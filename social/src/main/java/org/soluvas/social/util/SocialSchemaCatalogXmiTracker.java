package org.soluvas.social.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.service.blueprint.container.ServiceUnavailableException;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.social.SocialException;
import org.soluvas.social.schema.SchemaFactory;
import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.TargetTypeAdded;
import org.soluvas.social.schema.TargetTypeRemoved;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * @author ceefour
 *
 */
public class SocialSchemaCatalogXmiTracker implements BundleTrackerCustomizer<List<TargetType>> {
	
	private static Logger log = LoggerFactory
			.getLogger(SocialSchemaCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = SocialSchemaCatalog.class.getSimpleName();
	private static final String suppliedClassName = SocialSchemaCatalog.class.getName();
	private static final SchemaPackage xmiEPackage = SchemaPackage.eINSTANCE;
	private final SocialSchemaCatalog repo;
	private final EventBus eventBus;
	/**
	 * Used for plain Java.
	 */
	private final Map<String, List<TargetType>> managedTargets = new HashMap<>();
	
	/**
	 * @param repo Access to this repo from this class is guaranteed to be synchronized,
	 * 		but other consumers may not do that. So it's recommended that this class
	 * 		is the exclusive consumer of this repo.
	 */
	public SocialSchemaCatalogXmiTracker(@Nonnull final SocialSchemaCatalog repo,
			@Nonnull final EventBus eventBus) {
		super();
		this.repo = repo;
		this.eventBus = eventBus;
	}

	@PreDestroy
	public void destroy() {
		for (final Entry<String, List<TargetType>> entry : managedTargets.entrySet()) {
			removedBundle(entry.getValue(), entry.getKey());
		}
	}

	/**
	 * Scan using classpath.
	 * @todo Scanning multiple classpaths for resources is slow, so static or hybrid
	 * 		approach is preferable.
	 * @param dataFolder TODO
	 */
	public void scan(ClassLoader classLoader, String dataFolder) {
		final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		// Due to JDK limitation, scanning of root won't work in webapp classpath,
		// at least the root folder must be specified before wildcard
		final List<String> locationPatterns = ImmutableList.of("classpath*:org/**/*.SocialSchemaCatalog.xmi",
				"classpath*:com/**/*.SocialSchemaCatalog.xmi", "classpath*:id/**/*.SocialSchemaCatalog.xmi",
				"file:" + dataFolder + "/common/*.SocialSchemaCatalog.xmi");
		log.trace("Scanning {} for {}", classLoader, locationPatterns);
		try {
			final List<Resource> allResources = new ArrayList<>();
			for (String locationPattern : locationPatterns) {
				final Resource[] resources = resolver.getResources(locationPattern);
				allResources.addAll(ImmutableList.copyOf(resources));
			}
			log.info("Scanned {} returned {} resources: {}",
					locationPatterns, allResources.size(), allResources);
			final List<URL> xmiUrls = ImmutableList.copyOf(Lists.transform(
					allResources, new Function<Resource, URL>() {
				@Override @Nullable
				public URL apply(@Nullable Resource input) {
					try {
						return input.getURL();
					} catch (IOException e) {
						throw new SocialException("Cannot get URL for " + input, e);
					}
				}
			}));
			for (URL xmiUrl : xmiUrls) {
				final List<TargetType> targets = extractObjects(ImmutableList.of(xmiUrl), null, classLoader);
				managedTargets.put(xmiUrl.toString(), targets);
			}
		} catch (IOException e) {
			throw new SocialException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	@Override
	public List<TargetType> addingBundle(final Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		// ------------------ Scan SocialSchemaCatalogs ------------
		final String xmiFilePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , xmiFilePattern);
		final Enumeration<URL> entries = bundle.findEntries(path, xmiFilePattern, false);
		if (entries == null)
			return ImmutableList.of();
		final List<URL> xmiUrls = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		return extractObjects(xmiUrls, bundle, null);
	}

	/**
	 * @param xmiUrls
	 * @param bundle
	 * @return
	 */
	public List<TargetType> extractObjects(final List<URL> xmiUrls,
			final Bundle bundle, final ClassLoader classLoader) {
		if (xmiUrls.isEmpty())
			return ImmutableList.of();

		// ------------------ Story Ecore package files ------------
		final List<SocialSchemaCatalog> catalogs = new ArrayList<>();
		for (final URL xmiUrl : xmiUrls) {
			final URL ecoreUrl;
			try {
				ecoreUrl = new URL(xmiUrl.toExternalForm().replace("." + suppliedClassSimpleName + ".xmi", "-social.ecore"));
			} catch (MalformedURLException e) {
				throw new SocialException("Cannot get ecore URL from XMI URL " + xmiUrl, e);
			}
			
			log.debug("Getting SocialSchemaCatalog XMI {} from {}", suppliedClassName, xmiUrl);
			final XmiObjectLoader<SocialSchemaCatalog> loader;
			if (bundle != null) {
				loader = new XmiObjectLoader<SocialSchemaCatalog>(xmiEPackage, xmiUrl, bundle);
			} else {
				loader = new XmiObjectLoader<SocialSchemaCatalog>(xmiEPackage, xmiUrl, ResourceType.CLASSPATH);
			}
			final SocialSchemaCatalog socialSchemaCatalog = loader.get();
			catalogs.add(socialSchemaCatalog);
			
			socialSchemaCatalog.setXmiUrl(xmiUrl);
			socialSchemaCatalog.setEcoreUrl(ecoreUrl);
		}

		log.info("Scanning {} Ecore packages from {}", catalogs.size(), xmiUrls);
		final List<Map<String, EClass>> ecoreFileObjs = ImmutableList.copyOf(Collections2.transform(
				catalogs, new Function<SocialSchemaCatalog, Map<String, EClass>>() {
			@Override @Nullable
			public Map<String, EClass> apply(@Nullable SocialSchemaCatalog catalog) {
				final URL ecoreUrl = catalog.getEcoreUrl();
				log.debug("Getting {} from {}", suppliedClassName, ecoreUrl);
				final XmiObjectLoader<EPackage> loader;
				if (bundle != null) {
					loader = new XmiObjectLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl, bundle);
				} else {
					loader = new XmiObjectLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl, ResourceType.CLASSPATH);
				}
				final EPackage ecorePackage = loader.get();
				log.debug("Loaded {} EPackage {} ({}={}) from {}", suppliedClassName, 
						ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
						ecoreUrl);
				catalog.setEPackage(ecorePackage);
				
				// Determine generated package name. "social" is a special package suffix
				final String genPackage = Preconditions.checkNotNull(catalog.getGeneratedPackageName(),
						"generatedPackageName for %s cannot be null", ecoreUrl);
				
				// Instantiate EFactory
				final String eFactoryClassName = genPackage + "." +
						CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, ecorePackage.getName()) + "Factory";
				try {
					final Class<EFactory> eFactoryClass;
					if (bundle != null) {
						eFactoryClass = (Class<EFactory>) bundle.loadClass(eFactoryClassName);
					} else {
						eFactoryClass = (Class<EFactory>) classLoader.loadClass(eFactoryClassName);
					}
					final Field eInstanceField = eFactoryClass.getField("eINSTANCE");
					final EFactory eFactory = (EFactory) eInstanceField.get(eFactoryClass);
					log.debug("Loaded EFactory {} for EPackage {} ({}={}) from {}",
							eFactory, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							ecoreUrl);
					catalog.setEFactory(eFactory);
				} catch (Exception e) {
					throw new SocialException(e, "Cannot load EFactory class %s for EPackage %s (%s=%s) from %s",
							eFactoryClassName, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							ecoreUrl);
				}
				
				final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
				final EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
				for (final EClassifier eClassifier : eClassifiers) {
					if (!(eClassifier instanceof EClass))
						continue;
					EClass eClass = (EClass) eClassifier;
					log.debug("Mapping EClass {}.{} as {}:{} from {}",
							ecorePackage.getName(), eClass.getName(),
							ecorePackage.getNsPrefix(), eClass.getName(),
							ecoreUrl);
					eClassMapBuilder.put(ecorePackage.getNsPrefix() + ":" + eClass.getName(), eClass);
				}
				
				final Map<String, EClass> eClassMap = eClassMapBuilder.build();
				log.debug("Loaded {} EClasses from SocialSchema ecore package {}",
						eClassMap.size(), ecoreUrl );
				return eClassMap;
			}
		}));
		final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
		for (final Map<String, EClass> ecoreFileObj : ecoreFileObjs) {
			eClassMapBuilder.putAll(ecoreFileObj);
		}
		final Map<String, EClass> eClassMap = eClassMapBuilder.build();
		log.info("Loaded {} EClasses from {} SocialSchema ecore packages in {}: {}",
				eClassMap.size(), ecoreFileObjs.size(), xmiUrls, eClassMap.keySet() );

		// ------------------ SocialSchemaCatalog XMI files ------------
		final List<List<TargetType>> xmiFileObjs = Lists.transform(catalogs, 
				new Function<SocialSchemaCatalog, List<TargetType>>() {
			@Override @Nullable
			public List<TargetType> apply(@Nullable SocialSchemaCatalog catalog) {
				final Builder<TargetType> targetTypesBuilder = ImmutableList.builder();
				
				final String catalogNsPrefix = catalog.getEPackage().getNsPrefix().replaceAll("-social", "");
				
				for (final TargetType targetType : ImmutableList.copyOf(catalog.getTargetTypes())) {
					log.debug("Adding TargetType {} from {}", targetType.getName(), catalog.getXmiUrl());
					final TargetType added = EcoreUtil.copy(targetType);
					added.setNsPrefix(catalogNsPrefix);
					added.setEFactory(catalog.getEFactory());
					added.setEPackageNsPrefix(catalog.getEPackage().getNsPrefix());
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, added.getName());
					added.setEClassName(eClassName);
					added.setJavaClassName(catalog.getGeneratedPackageName() + "." + eClassName);
					synchronized (repo) {
						repo.getTargetTypes().add(added);
					}
					targetTypesBuilder.add(added);
				}
				
				final List<TargetType> targetTypes = targetTypesBuilder.build();
				log.debug("Loaded {} TargetTypes from SocialSchema {}",
						targetTypes.size(), catalog.getXmiUrl() );
				return targetTypes;
			}
		});
		
		// -------------- Concatenate everything ------------
		final List<TargetType> targetTypes = ImmutableList.copyOf(Iterables.concat(xmiFileObjs));
		log.info("Loaded {} TargetTypes from {}", targetTypes.size(), xmiUrls);
		
		// -------- Resolve EClass-es -----------
		final Collection<EClassLinked> eClassLinkeds = Collections2.filter(Lists.transform(targetTypes, new Function<TargetType, EClassLinked>() {
			@Override @Nullable
			public EClassLinked apply(@Nullable TargetType input) {
				return input instanceof EClassLinked ? (EClassLinked) input : null;				
			}
		}), new NotNullPredicate<EClassLinked>());
		log.info("Resolving {} EClassLinkeds from {}", eClassLinkeds.size(), xmiUrls);
		for (final EClassLinked eClassLinked : eClassLinkeds) {
			eClassLinked.resolveEClass(eClassMap);
		}

		// -------- Resolve Java Class-es -----------
		final Collection<JavaClassLinked<?>> javaClassLinkeds = Collections2.filter(Lists.transform(targetTypes, new Function<TargetType, JavaClassLinked<?>>() {
			@Override @Nullable
			public JavaClassLinked<?> apply(@Nullable TargetType input) {
				return input instanceof JavaClassLinked ? (JavaClassLinked<?>) input : null;				
			}
		}), new NotNullPredicate<JavaClassLinked<?>>());
		log.info("Resolving {} JavaClassLinkeds from {}", javaClassLinkeds.size(), xmiUrls);
		for (final JavaClassLinked<?> javaClassLinked : javaClassLinkeds) {
			javaClassLinked.resolveJavaClass(bundle);
		}

		// Notify StorySchemaCatalogXmiTracker
		final TargetTypeAdded added = SchemaFactory.eINSTANCE.createTargetTypeAdded();
		added.getTargetTypes().addAll(targetTypes);
		eventBus.post(added);
		
		return targetTypes;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<TargetType> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			List<TargetType> targetTypes) {
		removedBundle(targetTypes, bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
	}
	
	private void removedBundle(@Nonnull final List<TargetType> targetTypes,
			String resourceContainer) {
		if (targetTypes.isEmpty())
			return;

		log.debug("Removing {} TargetTypes provided by {}",
				targetTypes.size(), resourceContainer);
		long removedCount = 0;
		for (final TargetType eobject : targetTypes) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			if (eobject instanceof TargetType) {
				final TargetType targetType = eobject;
				log.debug("Removing TargetType {} from {}", targetType.getName(),
						resourceContainer);
				synchronized (repo) {
					if (repo.getTargetTypes().remove(targetType))
						removedCount++;
				}
			} else {
				throw new SocialException("Unknown TargetType " + eobject.getClass().getName() + " from " + 
						resourceContainer);
			}
		}
		log.info("Removed {} TargetTypes from {}",
				removedCount, resourceContainer);
		
		// Notify StorySchemaCatalogXmiTracker
		final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
		removed.getTargetTypes().addAll(targetTypes);
		try {
			eventBus.post(removed);
		} catch (ServiceUnavailableException e) {
			// can happen if bundles are stopped, i.e. during mass update/refresh
			log.warn("Cannot post TargetTypeRemoved event: " + removed, e);
		}
	}

}
