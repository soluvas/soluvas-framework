package org.soluvas.social.util;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.social.SocialException;
import org.soluvas.social.schema.SchemaFactory;
import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.TargetTypeAdded;
import org.soluvas.social.schema.TargetTypeRemoved;

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
		final List<URL> xmiFiles = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		if (xmiFiles.isEmpty())
			return ImmutableList.of();

		// ------------------ Story Ecore package files ------------
		final ImmutableMap.Builder<URL, URL> xmiToEcoreMapBuilder = ImmutableMap.builder();
		for (final URL xmiUrl : xmiFiles) {
			final URL ecoreUrl;
			try {
				ecoreUrl = new URL(xmiUrl.toExternalForm().replace("." + suppliedClassSimpleName + ".xmi", "-social.ecore"));
			} catch (MalformedURLException e) {
				throw new SocialException("Cannot get ecore URL from XMI URL " + xmiUrl, e);
			}
			xmiToEcoreMapBuilder.put(xmiUrl, ecoreUrl);
		}
		final Map<URL, URL> xmiToEcoreMap = xmiToEcoreMapBuilder.build();

		log.info("Scanning {} Ecore packages: {} from {} [{}]", xmiToEcoreMap.size(), xmiToEcoreMap.values(),
				bundle.getSymbolicName(), bundle.getBundleId());
		final ImmutableMap.Builder<URL, EPackage> ePackageMapBuilder = ImmutableMap.builder();
		final ImmutableMap.Builder<URL, String> genPackageMapBuilder = ImmutableMap.builder();
		final ImmutableMap.Builder<URL, EFactory> eFactoryMapBuilder = ImmutableMap.builder();
		// Must do ImmutableList.copyOf(), so the epackageMapBuilder gets used
		final List<Map<String, EClass>> ecoreFileObjs = ImmutableList.copyOf(Collections2.transform(xmiToEcoreMap.values(), new Function<URL, Map<String, EClass>>() {
			@SuppressWarnings("unchecked")
			@Override @Nullable
			public Map<String, EClass> apply(@Nullable URL url) {
				log.debug("Getting {} from {} in {} [{}]", suppliedClassName, url, bundle.getSymbolicName(), bundle.getBundleId());
				final XmiObjectLoader<EPackage> loader = new XmiObjectLoader<EPackage>(EcorePackage.eINSTANCE, url,
						bundle);
				final EPackage ecorePackage = loader.get();
				log.debug("Loaded {} EPackage {} ({}={}) from {} in {} [{}]", suppliedClassName, 
						ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
						url, bundle.getSymbolicName(), bundle.getBundleId());
				ePackageMapBuilder.put(url, ecorePackage);
				
				// Determine generated package name. "social" is a special package suffix
				final String genPackage = bundle.getSymbolicName() +
						("social".equals(ecorePackage.getName()) && bundle.getSymbolicName().endsWith(".social") ? "" : "." + ecorePackage.getName());
				genPackageMapBuilder.put(url, genPackage);
				
				// Instantiate EFactory
				final String eFactoryClassName = genPackage + "." +
						CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, ecorePackage.getName()) + "Factory";
				try {
					final Class<EFactory> eFactoryClass = (Class<EFactory>) bundle.loadClass(eFactoryClassName);
					final Field eInstanceField = eFactoryClass.getField("eINSTANCE");
					final EFactory eFactory = (EFactory) eInstanceField.get(eFactoryClass);
					log.debug("Loaded EFactory {} for EPackage {} ({}={}) from {} in {} [{}]",
							eFactory, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							url, bundle.getSymbolicName(), bundle.getBundleId());
					eFactoryMapBuilder.put(url, eFactory);
				} catch (Exception e) {
					throw new SocialException(String.format("Cannot load EFactory class %s for EPackage %s (%s=%s) from %s in %s [%s]",
							eFactoryClassName, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							url, bundle.getSymbolicName(), bundle.getBundleId()), e);
				}
				
				final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
				final EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
				for (final EClassifier eClassifier : eClassifiers) {
					if (!(eClassifier instanceof EClass))
						continue;
					EClass eClass = (EClass) eClassifier;
					log.debug("Mapping EClass {}.{} as {}:{} from {} in {} [{}]",
							ecorePackage.getName(), eClass.getName(),
							ecorePackage.getNsPrefix(), eClass.getName(),
							url, bundle.getSymbolicName(), bundle.getBundleId());
					eClassMapBuilder.put(ecorePackage.getNsPrefix() + ":" + eClass.getName(), eClass);
				}
				
				final Map<String, EClass> eClassMap = eClassMapBuilder.build();
				log.debug("Loaded {} EClasses from SocialSchema ecore package {} in {} [{}]",
						eClassMap.size(), url, bundle.getSymbolicName(), bundle.getBundleId() );
				return eClassMap;
			}
		}));
		final Map<URL, EPackage> ePackageMap = ePackageMapBuilder.build();
		final Map<URL, String> genPackageMap = genPackageMapBuilder.build();
		final Map<URL, EFactory> eFactoryMap = eFactoryMapBuilder.build();
		final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
		for (final Map<String, EClass> ecoreFileObj : ecoreFileObjs) {
			eClassMapBuilder.putAll(ecoreFileObj);
		}
		final Map<String, EClass> eClassMap = eClassMapBuilder.build();
		log.info("Loaded {} EPackages, {} EFactory-es, and {} EClasses from {} SocialSchema ecore packages in {} [{}]: {}",
				ePackageMap.size(), eFactoryMap.size(), eClassMap.size(), ecoreFileObjs.size(), bundle.getSymbolicName(), bundle.getBundleId(),
				eClassMap.keySet() );

		// ------------------ SocialSchemaCatalog XMI files ------------
		final List<List<TargetType>> xmiFileObjs = Lists.transform(xmiFiles, new Function<URL, List<TargetType>>() {
			@Override @Nullable
			public List<TargetType> apply(@Nullable URL url) {
				final URL ecoreUrl = xmiToEcoreMap.get(url);
				Preconditions.checkNotNull(xmiEPackage, "Cannot find companion Ecore for XMI %s. %s map entries: %s",
						ecoreUrl, xmiToEcoreMap.size(), xmiToEcoreMap);
				final EPackage ePackage = ePackageMap.get(ecoreUrl);
				Preconditions.checkNotNull(ePackage, "Cannot find companion EPackage for XMI %s, Ecore %s. %s map entries: %s",
						url, ecoreUrl, ePackageMap.size(), ePackageMap);
				final String genPackage = genPackageMap.get(ecoreUrl);
				Preconditions.checkNotNull(genPackage, "Cannot determine generated package for XMI %s, Ecore %s. %s map entries: %s",
						url, ecoreUrl, genPackageMap.size(), genPackageMap);
				final EFactory eFactory = eFactoryMap.get(ecoreUrl);
				Preconditions.checkNotNull(eFactory, "Cannot find companion EFactory for XMI %s, Ecore %s. %s map entries: %s",
						url, ecoreUrl, eFactoryMap.size(), eFactoryMap);

				final Builder<TargetType> targetTypesBuilder = ImmutableList.builder();
				log.debug("Getting SocialSchemaCatalog XMI {} from {} in {} [{}], EPackage {} ({}={})", suppliedClassName, url,
						bundle.getSymbolicName(), bundle.getBundleId(), ePackage.getName(), ePackage.getNsPrefix(), ePackage.getNsURI() );
				final XmiObjectLoader<SocialSchemaCatalog> loader = new XmiObjectLoader<SocialSchemaCatalog>(xmiEPackage, url,
						bundle);
				final SocialSchemaCatalog storySchemaCatalog = loader.get();
				
				for (final TargetType targetType : ImmutableList.copyOf(storySchemaCatalog.getTargetTypes())) {
					log.debug("Adding TargetType {} from {}", targetType.getName(), url);
					final TargetType added = EcoreUtil.copy(targetType);
					added.setEFactory(eFactory);
					added.setEPackageNsPrefix(ePackage.getNsPrefix());
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, added.getName());
					added.setEClassName(eClassName);
					added.setJavaClassName(genPackage + "." + eClassName);
					synchronized (repo) {
						repo.getTargetTypes().add(added);
					}
					targetTypesBuilder.add(added);
				}
				
				final List<TargetType> targetTypes = targetTypesBuilder.build();
				log.debug("Loaded {} TargetTypes from SocialSchema {} in {} [{}]",
						targetTypes.size(), url, bundle.getSymbolicName(), bundle.getBundleId() );
				return targetTypes;
			}
		});
		
		// -------------- Concatenate everything ------------
		final List<TargetType> targetTypes = ImmutableList.copyOf(Iterables.concat(xmiFileObjs));
		log.info("Loaded {} TargetTypes from {} [{}]",
				targetTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		
		// -------- Resolve EClass-es -----------
		final Collection<EClassLinked> eClassLinkeds = Collections2.filter(Lists.transform(targetTypes, new Function<TargetType, EClassLinked>() {
			@Override @Nullable
			public EClassLinked apply(@Nullable TargetType input) {
				return input instanceof EClassLinked ? (EClassLinked) input : null;				
			}
		}), new NotNullPredicate<EClassLinked>());
		log.info("Resolving {} EClassLinkeds from {} [{}]",
				eClassLinkeds.size(), bundle.getSymbolicName(), bundle.getBundleId());
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
		log.info("Resolving {} JavaClassLinkeds from {} [{}]",
				javaClassLinkeds.size(), bundle.getSymbolicName(), bundle.getBundleId());
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
		if (targetTypes.isEmpty())
			return;

		log.debug("Removing {} TargetTypes provided by {} [{}]",
				targetTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		long removedCount = 0;
		for (final TargetType eobject : targetTypes) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			if (eobject instanceof TargetType) {
				final TargetType targetType = eobject;
				log.debug("Removing TargetType {} from {} [{}]", targetType.getName(),
						bundle.getSymbolicName(), bundle.getBundleId());
				synchronized (repo) {
					if (repo.getTargetTypes().remove(targetType))
						removedCount++;
				}
			} else {
				throw new SocialException("Unknown TargetType " + eobject.getClass().getName() + " from " + 
						bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
			}
		}
		log.info("Removed {} TargetTypes from {} [{}]",
				removedCount, bundle.getSymbolicName(), bundle.getBundleId());
		
		// Notify StorySchemaCatalogXmiTracker
		final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
		removed.getTargetTypes().addAll(targetTypes);
		eventBus.post(removed);
	}

}
