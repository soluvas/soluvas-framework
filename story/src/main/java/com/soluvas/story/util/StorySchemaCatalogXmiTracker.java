package com.soluvas.story.util;

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
import org.eclipse.emf.ecore.EObject;
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
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.TargetTypeAdded;
import org.soluvas.social.schema.TargetTypeRemoved;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.eventbus.Subscribe;
import com.soluvas.story.StoryException;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.ActionTypeStatus;
import com.soluvas.story.schema.AggregationType;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.schema.StoryType;
import com.soluvas.story.schema.TargetTypeRef;

/**
 * @author ceefour
 *
 */
public class StorySchemaCatalogXmiTracker implements BundleTrackerCustomizer<List<EObject>> {
	
	private static Logger log = LoggerFactory
			.getLogger(StorySchemaCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = StorySchemaCatalog.class.getSimpleName();
	private static final String suppliedClassName = StorySchemaCatalog.class.getName();
	private static final SchemaPackage xmiEPackage = SchemaPackage.eINSTANCE;
	private final SocialSchemaCatalog socialRepo;
	private final StorySchemaCatalog storyRepo;
	/**
	 * Used for plain Java.
	 */
	private final Map<String, List<EObject>> managedObjs = new HashMap<>();
	
//	private final List<ActionType> actionTypes = Lists.newCopyOnWriteArrayList();
	
	/**
	 * @param repo Access to this repo from this class is guaranteed to be synchronized,
	 * 		but other consumers may not do that. So it's recommended that this class
	 * 		is the exclusive consumer of this repo.
	 */
	public StorySchemaCatalogXmiTracker(@Nonnull final SocialSchemaCatalog socialRepo,
			@Nonnull final StorySchemaCatalog repo) {
		super();
		this.socialRepo = socialRepo;
		this.storyRepo = repo;
	}

	@PreDestroy
	public void destroy() {
		for (final Entry<String, List<EObject>> entry : managedObjs.entrySet()) {
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
		final List<String> locationPatterns = ImmutableList.of("classpath*:org/**/*.StorySchemaCatalog.xmi",
				"classpath*:com/**/*.StorySchemaCatalog.xmi", "classpath*:id/**/*.StorySchemaCatalog.xmi",
				"file:" + dataFolder + "/common/*.StorySchemaCatalog.xmi");
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
						throw new StoryException("Cannot get URL for " + input, e);
					}
				}
			}));
			for (URL xmiUrl : xmiUrls) {
				final List<EObject> objs = extractObjects(ImmutableList.of(xmiUrl), null, classLoader);
				managedObjs.put(xmiUrl.toString(), objs);
			}
		} catch (IOException e) {
			throw new StoryException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	@Override
	public List<EObject> addingBundle(final Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		// ------------------ Scan StorySchemaCatalogs ------------
		final String xmiFilePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , xmiFilePattern);
		final Enumeration<URL> entries = bundle.findEntries(path, xmiFilePattern, false);
		if (entries == null)
			return ImmutableList.of();
		final List<URL> xmiFiles = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		return extractObjects(xmiFiles, bundle, null);
	}

	private List<EObject> extractObjects(final List<URL> xmiUrls,
			final Bundle bundle, final ClassLoader classLoader) {
		if (xmiUrls.isEmpty())
			return ImmutableList.of();

		// ------------------ Story Ecore package files ------------
		final List<StorySchemaCatalog> catalogs = new ArrayList<>();
		for (final URL xmiUrl : xmiUrls) {
			log.debug("Getting StorySchemaCatalog XMI {} from {} in {}", suppliedClassName, xmiUrl);
			final StaticXmiLoader<StorySchemaCatalog> loader;
			if (bundle != null) {
				loader = new StaticXmiLoader<StorySchemaCatalog>(xmiEPackage, xmiUrl, bundle);
			} else {
				loader = new StaticXmiLoader<StorySchemaCatalog>(xmiEPackage, xmiUrl, ResourceType.CLASSPATH);
			}
			final StorySchemaCatalog storySchemaCatalog = loader.get();
			catalogs.add(storySchemaCatalog);
			
			storySchemaCatalog.setXmiUrl(xmiUrl);
			final URL ecoreUrl;
			try {
				ecoreUrl = new URL(xmiUrl.toExternalForm().replace("." + suppliedClassSimpleName + ".xmi", "-story.ecore"));
			} catch (MalformedURLException e) {
				throw new StoryException("Cannot get ecore URL from XMI URL " + xmiUrl, e);
			}
			storySchemaCatalog.setEcoreUrl(ecoreUrl);
		}

		log.info("Scanning {} Ecore packages from {}", catalogs.size(), xmiUrls);
		// Must do ImmutableList.copyOf(), so the epackageMapBuilder gets used
		final List<Map<String, EClass>> ecoreFileObjs = ImmutableList.copyOf(Collections2.transform(
				catalogs, new Function<StorySchemaCatalog, Map<String, EClass>>() {
			@Override @Nullable
			public Map<String, EClass> apply(@Nullable StorySchemaCatalog catalog) {
				final URL ecoreUrl = catalog.getEcoreUrl();
				log.debug("Getting {} from {}", suppliedClassName, catalog.getEcoreUrl());
				final StaticXmiLoader<EPackage> loader;
				if (bundle != null) {
					loader = new StaticXmiLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl,
							bundle);
				} else {
					loader = new StaticXmiLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl,
							ResourceType.CLASSPATH);
				}
				final EPackage ecorePackage = loader.get();
				log.debug("Loaded {} EPackage {} ({}={}) from {}", suppliedClassName, 
						ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
						ecoreUrl);
				catalog.setEPackage(ecorePackage);
				
				// Determine generated package name. "story" is a special package suffix
				final String genPackage = catalog.getGeneratedPackageName();
				
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
					throw new StoryException(String.format("Cannot load EFactory class %s for EPackage %s (%s=%s) from %s",
							eFactoryClassName, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							ecoreUrl), e);
				}
				
				final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
				final EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
				for (final EClassifier eClassifier : eClassifiers) {
					if (!(eClassifier instanceof EClass))
						continue;
					EClass eClass = (EClass) eClassifier;
					log.debug("Mapping EClass {}.{} as {}:{} from {}",
							ecorePackage.getName(), eClass.getName(),
							ecorePackage.getNsPrefix(), eClass.getName(), ecoreUrl);
					eClassMapBuilder.put(ecorePackage.getNsPrefix() + ":" + eClass.getName(), eClass);
				}
				
				final Map<String, EClass> eClassMap = eClassMapBuilder.build();
				log.debug("Loaded {} EClasses from StorySchema ecore package {}",
						eClassMap.size(), ecoreUrl );
				return eClassMap;
			}
		}));
		final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
		for (final Map<String, EClass> ecoreFileObj : ecoreFileObjs) {
			eClassMapBuilder.putAll(ecoreFileObj);
		}
		final Map<String, EClass> eClassMap = eClassMapBuilder.build();
		log.info("Loaded {} EClasses from {} StorySchema ecore packages in {}: {}",
				eClassMap.size(), ecoreFileObjs.size(), xmiUrls, eClassMap.keySet() );

		// ------------------ StorySchemaCatalog XMI files ------------
		final List<EObject> loadedEobjects = new ArrayList<>();
		for (StorySchemaCatalog catalog : catalogs) {
			final List<EObject> innerEobjects = new ArrayList<>();
			
			final String storySchemaCatalogNsPrefix = catalog.getEPackage().getNsPrefix().replace("-story", "");
			
			for (final ActionType actionType : ImmutableList.copyOf(catalog.getActionTypes())) {
				log.debug("Adding ActionType {} from {}", actionType.getName(), catalog.getXmiUrl());
				final ActionType added = EcoreUtil.copy(actionType);
				added.setNsPrefix(storySchemaCatalogNsPrefix);
				added.setEFactory(catalog.getEFactory());
				added.setEPackageNsPrefix(catalog.getEPackage().getNsPrefix());
				final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, added.getName());
				added.setEClassName(eClassName);
				added.setJavaClassName(catalog.getGeneratedPackageName() + "." + eClassName);
//					for (final TargetType subjectType : actionType.getSubjectTypes()) {
//						final StorySchemaCatalog subjectCatalog = (StorySchemaCatalog) EcoreUtil.getRootContainer(subjectType);
//						subjectType.setEPackageNsPrefix(subjectCatalog.getNsPrefix());
//					}
				synchronized (storyRepo) {
					storyRepo.getActionTypes().add(added);
				}
				innerEobjects.add(added);
			}
			
			for (final AggregationType aggType : ImmutableList.copyOf(catalog.getAggregationTypes())) {
				log.debug("Adding AggregationType {} from {}", aggType.getName(), catalog.getXmiUrl());
				final AggregationType added;
				synchronized (storyRepo) {
					added = EcoreUtil.copy(aggType);
					added.setEPackageNsPrefix(catalog.getEPackage().getNsPrefix());
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, added.getName());
					added.setEClassName(eClassName);
					added.setJavaClassName(catalog.getGeneratedPackageName() + "." + eClassName);
					storyRepo.getAggregationTypes().add(added);
				}
				innerEobjects.add(added);
			}
			
			for (final StoryType storyType : ImmutableList.copyOf(catalog.getStoryTypes())) {
				log.debug("Adding StoryType {} from {}", storyType.getName(), catalog.getXmiUrl());
				final StoryType added;
				synchronized (storyRepo) {
					added = EcoreUtil.copy(storyType);
					added.setEPackageNsPrefix(catalog.getEPackage().getNsPrefix());
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, added.getName());
					added.setEClassName(eClassName);
					added.setJavaClassName(catalog.getGeneratedPackageName() + "." + eClassName);
					storyRepo.getStoryTypes().add(added);
				}
				innerEobjects.add(added);
			}
			log.debug("Loaded {} EObjects from StorySchema {}",
					innerEobjects.size(), catalog.getXmiUrl());
			
			loadedEobjects.addAll(innerEobjects);
		}
		log.info("Loaded {} EObjects from {}", loadedEobjects.size(), xmiUrls);
		
		// -------- Resolve EClass-es -----------
		final Collection<EClassLinked> eClassLinkeds = Collections2.filter(Lists.transform(
				loadedEobjects, new Function<EObject, EClassLinked>() {
			@Override @Nullable
			public EClassLinked apply(@Nullable EObject input) {
				return input instanceof EClassLinked ? (EClassLinked) input : null;				
			}
		}), new NotNullPredicate<EClassLinked>());
		log.info("Resolving {} EClassLinkeds from {}", eClassLinkeds.size(), xmiUrls);
		for (final EClassLinked eClassLinked : eClassLinkeds) {
			eClassLinked.resolveEClass(eClassMap);
		}

		// -------- Resolve Java Class-es -----------
		final Collection<JavaClassLinked<?>> javaClassLinkeds = Collections2.filter(Lists.transform(loadedEobjects, new Function<EObject, JavaClassLinked<?>>() {
			@Override @Nullable
			public JavaClassLinked<?> apply(@Nullable EObject input) {
				return input instanceof JavaClassLinked ? (JavaClassLinked<?>) input : null;				
			}
		}), new NotNullPredicate<JavaClassLinked<?>>());
		log.info("Resolving {} JavaClassLinkeds from {}", javaClassLinkeds.size(), xmiUrls);
		for (final JavaClassLinked<?> javaClassLinked : javaClassLinkeds) {
			javaClassLinked.resolveJavaClass(bundle);
		}
		
		// -------- Resolve EClass-es in ActionType.subjectTypes -----------
		resolveSubjectTypesInActionTypes();
//		final Map<String, TargetType> targetTypeMap = Maps.uniqueIndex(repo.getTargetTypes(), new Function<TargetType, String>() {
//			@Override @Nullable
//			public String apply(@Nullable TargetType input) {
//				return input.getEPackageNsPrefix() + ":" + input.getName();
//			}
//		});
//		final Collection<ActionType> actionTypes = Collections2.filter(Lists.transform(eobjects, new Function<EObject, ActionType>() {
//			@Override @Nullable
//			public ActionType apply(@Nullable EObject input) {
//				return input instanceof ActionType ? (ActionType) input : null;				
//			}
//		}), new NotNullPredicate<ActionType>());
//		log.info("Replacing {} ActionType.subjectTypes from {} [{}]",
//				eClassLinkeds.size(), bundle.getSymbolicName(), bundle.getBundleId());
//		for (final ActionType actionType : actionTypes) {
//			final String actionTypeQName = actionType.getEPackageNsPrefix() + ":" + actionType.getName();
//			final List<TargetType> resolvedSubjectTypes = ImmutableList.copyOf(Lists.transform(
//					actionType.getSubjectTypes(), new Function<TargetType, TargetType>() {
//				@Override @Nullable
//				public TargetType apply(@Nullable TargetType input) {
//					final String qName = input.getEPackageNsPrefix()  + ":" + input.getName();
//					return Preconditions.checkNotNull(targetTypeMap.get(qName),
//							"Cannot resolve TargetType %s referred by ActionType %s, map has %s entries: %s",
//							qName, actionTypeQName, targetTypeMap.size(), targetTypeMap);
//				}
//			}));
//			actionType.getSubjectTypes().clear();
//			actionType.getSubjectTypes().addAll(resolvedSubjectTypes);
//		}

		return loadedEobjects;
	}
	
	/**
	 * Try to resolve {@link TargetType} in {@link ActionType}s. If not successful,
	 * status will stay as {@link ActionTypeStatus#UNRESOLVED}.
	 */
	protected synchronized void resolveSubjectTypesInActionTypes() {
		final Collection<ActionType> unresolvedActionTypes = ImmutableList.copyOf(
				Collections2.filter(storyRepo.getActionTypes(), new Predicate<ActionType>() {
					@Override
					public boolean apply(@Nullable ActionType input) {
						return input.getStatus() == ActionTypeStatus.UNRESOLVED;
					}
				}));
		final Map<String, TargetType> targetTypeMap = ImmutableMap.copyOf(
				Maps.uniqueIndex(socialRepo.getTargetTypes(),
				new TargetType.ToQName()));
		log.info("Replacing {} unresolved ActionType.subjectTypes from {} TargetTypes: {}",
				unresolvedActionTypes.size(), socialRepo.getTargetTypes().size(), targetTypeMap.keySet());
		for (final ActionType actionType : unresolvedActionTypes) {
			final String actionTypeQName = actionType.getNsPrefix() + ":" + actionType.getName();
			final List<TargetType> resolvedSubjectTypes = Lists.transform(
					actionType.getSubjectTypes(), new Function<TargetTypeRef, TargetType>() {
				@Override @Nullable
				public TargetType apply(@Nullable TargetTypeRef input) {
					final String qName = Optional.fromNullable(input.getNsPrefix()).or("builtin") + ":" + input.getName();
					final TargetType targetType = targetTypeMap.get(qName);
					if (targetType == null) {
						log.warn("Cannot resolve TargetType {} referred by ActionType {}, map has {} entries: {}",
							qName, actionTypeQName, targetTypeMap.size(), targetTypeMap.keySet());
					}
					return targetType;
//					return Preconditions.checkNotNull(targetTypeMap.get(qName),
//							"Cannot resolve TargetType %s referred by ActionType %s, map has %s entries: %s",
//							qName, actionTypeQName, targetTypeMap.size(), targetTypeMap);
				}
			});
			if (Iterables.all(resolvedSubjectTypes, new NotNullPredicate<TargetType>())) {
				actionType.getResolvedSubjectTypes().clear();
				actionType.getResolvedSubjectTypes().addAll(resolvedSubjectTypes);
				actionType.setStatus(ActionTypeStatus.RESOLVED);
				log.info("Resolved {} TargetTypes referred by ActionType {}",
						actionType.getSubjectTypes().size(), actionTypeQName);
			} else {
				log.info("Waiting to resolve {} TargetTypes ({}) referred by ActionType {}, map has {} entries: {}",
							actionType.getSubjectTypes().size(), actionType.getSubjectTypes(),
							actionTypeQName, targetTypeMap.size(), targetTypeMap.keySet());
			}
		}
	}

	protected synchronized void unresolveSubjectTypesInActionTypes() {
		final Collection<ActionType> resolvedActionTypes = Collections2.filter(
				storyRepo.getActionTypes(), new Predicate<ActionType>() {
					@Override
					public boolean apply(@Nullable ActionType input) {
						return input.getStatus() == ActionTypeStatus.RESOLVED;
					}
				});
		final Map<String, TargetType> targetTypeMap = Maps.uniqueIndex(socialRepo.getTargetTypes(),
				new TargetType.ToQName());
		log.info("Re-checking {} resolved ActionType.subjectTypes from {} TargetTypes: {}",
				resolvedActionTypes.size(), socialRepo.getTargetTypes().size(), targetTypeMap.keySet());
		for (final ActionType actionType : resolvedActionTypes) {
			final String actionTypeQName = actionType.getEPackageNsPrefix() + ":" + actionType.getName();
			final List<TargetType> resolvedSubjectTypes = Lists.transform(
					actionType.getSubjectTypes(), new Function<TargetTypeRef, TargetType>() {
				@Override @Nullable
				public TargetType apply(@Nullable TargetTypeRef input) {
					final String qName = Optional.fromNullable(input.getNsPrefix()).or("builtin") + ":" + input.getName();
					return targetTypeMap.get(qName);
//					return Preconditions.checkNotNull(targetTypeMap.get(qName),
//							"Cannot resolve TargetType %s referred by ActionType %s, map has %s entries: %s",
//							qName, actionTypeQName, targetTypeMap.size(), targetTypeMap);
				}
			});
			if (Iterables.all(resolvedSubjectTypes, new NotNullPredicate<TargetType>())) {
				// OK
//				actionType.getSubjectTypes().clear();
//				actionType.getSubjectTypes().addAll(resolvedSubjectTypes);
//				actionType.setStatus(ActionTypeStatus.RESOLVED);
//				log.info("Resolved %d TargetTypes referred by ActionType %s",
//						actionType.getSubjectTypes().size(), actionTypeQName);
			} else {
				log.info("Unresolving ActionType %s because not all %d TargetTypes can be found, map has %s entries: %s",
							actionType.getSubjectTypes().size(), actionTypeQName, targetTypeMap.size(), targetTypeMap.keySet());
				// TODO: this should refer by name
				actionType.setStatus(ActionTypeStatus.UNRESOLVED);
				actionType.getResolvedSubjectTypes().clear();
			}
		}
	}

	@Subscribe
	protected void targetTypeAdded(TargetTypeAdded ev) {
		resolveSubjectTypesInActionTypes();
	}

	@Subscribe
	protected void targetTypeRemoved(TargetTypeRemoved ev) {
		unresolveSubjectTypesInActionTypes();
		
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<EObject> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			List<EObject> eobjects) {
		removedBundle(eobjects, bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
	}
	
	private void removedBundle(@Nonnull final List<EObject> eobjects,
			String resourceContainer) {
		if (eobjects.isEmpty())
			return;

		log.debug("Removing {} EObjects provided by {}",
				eobjects.size(), resourceContainer);
		long removedCount = 0;
		for (final EObject eobject : eobjects) {
			// Unresolve (not strictly necessary)
//			if (eobject instanceof JavaClassLinked) {
//				((JavaClassLinked<?>) eobject).setJavaClassStatus(JavaClassStatus.UNRESOLVED);
//				((JavaClassLinked<?>) eobject).setJavaClass(null);
//			}
//			if (eobject instanceof EClassLinked) {
//				((EClassLinked) eobject).setEClassStatus(EClassStatus.UNRESOLVED);
//				((EClassLinked) eobject).setEClass(null);
//			}
			// Unregister from repo
			if (eobject instanceof StoryType) {
				final StoryType storyType = (StoryType) eobject;
				log.debug("Removing StoryType {} from {}", storyType.getName(),
						resourceContainer);
				synchronized (storyRepo) {
					if (storyRepo.getStoryTypes().remove(storyType))
						removedCount++;
				}
			} else if (eobject instanceof ActionType) {
				final ActionType actionType = (ActionType) eobject;
				log.debug("Removing ActionType {} from {}", actionType.getName(),
						resourceContainer);
				synchronized (storyRepo) {
					if (storyRepo.getActionTypes().remove(actionType))
						removedCount++;
				}
			} else if (eobject instanceof AggregationType) {
				final AggregationType aggType = (AggregationType) eobject;
				log.debug("Removing AggregationType {} from {}", aggType.getName(),
						resourceContainer);
				synchronized (storyRepo) {
					if (storyRepo.getAggregationTypes().remove(aggType))
						removedCount++;
				}
			} else {
				throw new StoryException("Unknown EObject " + eobject.getClass().getName() + " from " + 
						resourceContainer);
			}
		}
		log.info("Removed {} EObjects from {}",
				removedCount, resourceContainer);
	}

}
