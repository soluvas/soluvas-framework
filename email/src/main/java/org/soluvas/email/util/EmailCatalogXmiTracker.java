package org.soluvas.email.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.LayoutType;
import org.soluvas.email.PageType;
import org.soluvas.email.SenderType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * @author ceefour
 *
 */
public class EmailCatalogXmiTracker implements BundleTrackerCustomizer<List<EObject>> {
	
	private static Logger log = LoggerFactory
			.getLogger(EmailCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = EmailCatalog.class.getSimpleName();
	private static final String suppliedClassName = EmailCatalog.class.getName();
	private static final EmailPackage xmiEPackage = EmailPackage.eINSTANCE;
	private final EmailCatalog repo;
	private final EventBus eventBus;
	/**
	 * Used for plain Java.
	 */
	private final Map<String, List<EObject>> eObjects = new HashMap<>();
	
	/**
	 * @param repo Access to this repo from this class is guaranteed to be synchronized,
	 * 		but other consumers may not do that. So it's recommended that this class
	 * 		is the exclusive consumer of this repo.
	 */
	public EmailCatalogXmiTracker(@Nonnull final EmailCatalog repo,
			@Nonnull final EventBus eventBus) {
		super();
		this.repo = repo;
		this.eventBus = eventBus;
	}
	
//	public void add(Class<?> class1, String packageToScan) {
//		final List<EObject> objs = addingBundle(class1.getClassLoader(), packageToScan);
//		eObjects.put(packageToScan, objs);
//	}

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
		final List<String> locationPatterns = ImmutableList.of("classpath*:org/**/*.EmailCatalog.xmi",
				"classpath*:com/**/*.EmailCatalog.xmi", "classpath*:id/**/*.EmailCatalog.xmi",
				"file:" + dataFolder + "/common/*.EmailCatalog.xmi");
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
						throw new EmailException("Cannot get URL for " + input, e);
					}
				}
			}));
			for (URL xmiUrl : xmiUrls) {
				final List<EObject> objs = extractObjects(ImmutableList.of(xmiUrl), null, classLoader);
				eObjects.put(xmiUrl.toString(), objs);
			}
		} catch (IOException e) {
			throw new EmailException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	@Override
	public List<EObject> addingBundle(final Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		// ------------------ Scan EmailCatalogs ------------
		final String xmiFilePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , xmiFilePattern);
		final Enumeration<URL> entries = bundle.findEntries(path, xmiFilePattern, false);
		if (entries == null)
			return ImmutableList.of();
		final List<URL> xmiFiles = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		return extractObjects(xmiFiles, bundle, null);//, bundle.getSymbolicName());
	}

	private List<EObject> extractObjects(final List<URL> xmiUrls,
			@Nullable final Bundle bundle, final ClassLoader classLoader) {
		if (xmiUrls.isEmpty())
			return ImmutableList.of();

		// ------------------ Ecore package files ------------
		final List<EmailCatalog> catalogs = new ArrayList<>();
		for (final URL xmiUrl : xmiUrls) {
			final URL ecoreUrl;
			try {
				ecoreUrl = new URL(xmiUrl.toExternalForm()
						.replace("." + suppliedClassSimpleName + ".xmi", "-email.ecore"));
			} catch (MalformedURLException e) {
				throw new EmailException("Cannot get ecore URL from XMI URL " + xmiUrl, e);
			}
			
			// Load EmailCatalog XMI files so we can get the generatedPackageName
			log.debug("Getting EmailCatalog XMI {} from {} in {}", suppliedClassName, xmiUrl, xmiUrls );
			final StaticXmiLoader<EmailCatalog> loader;
			if (bundle != null) {
				loader = new StaticXmiLoader<EmailCatalog>(xmiEPackage, xmiUrl, bundle);
			} else {
				loader = new StaticXmiLoader<EmailCatalog>(xmiEPackage, xmiUrl, ResourceType.CLASSPATH);
			}
			final EmailCatalog emailCatalog = loader.get();
			catalogs.add(emailCatalog);
		}
		
		log.info("Scanning {} Ecore packages from {}", catalogs.size(), xmiUrls);
		// Must do ImmutableList.copyOf(), so the epackageMapBuilder gets used
		final List<Map<String, EClass>> ecoreFileObjs = ImmutableList.copyOf(Collections2.transform(
				catalogs, new Function<EmailCatalog, Map<String, EClass>>() {
			@SuppressWarnings("unchecked")
			@Override @Nullable
			public Map<String, EClass> apply(@Nullable EmailCatalog catalog) {
				// Determine generated package name. "email" is a special package suffix
				final String genPackage = Preconditions.checkNotNull(catalog.getGeneratedPackageName(),
						"generatedPackageName for %s cannot be null", catalog.getNsPrefix());
				
				// do NOT load EPackage from .ecore file, because the EClassifier index number would be different
				// than the actual genmodel-generated .java
				// so we use Class.forName instead to get the generated EPackage class, then get the eINSTANCE
				// from there
				
				final String ePackageFullName = genPackage + (genPackage.endsWith(".builtin") ? ".BuiltinPackage" : ".EmailPackage");
				log.debug("Getting {} from {} in {}", suppliedClassName, ePackageFullName, xmiUrls);
				EPackage ecorePackage;
				try {
					final Class<EPackage> ePackageIntf = (Class<EPackage>) classLoader.loadClass(ePackageFullName);
					final Field ePackageInstanceField = ePackageIntf.getDeclaredField("eINSTANCE");
					ecorePackage = (EPackage) ePackageInstanceField.get(ePackageIntf);
				} catch (ClassNotFoundException | NoSuchFieldException
						| SecurityException | IllegalArgumentException
						| IllegalAccessException e) {
					throw new EmailException(String.format("Cannot load EPackage class %s for %s in %s",
							ePackageFullName, catalog.getNsPrefix(), xmiUrls), e);
				}
				
//				final URL ecoreUrl = catalog.getEcoreUrl();
//				log.debug("Getting {} from {} in {}", suppliedClassName, ecoreUrl, xmiUrls);
//				StaticXmiLoader<EPackage> loader;
//				if (bundle != null) {
//					loader = new StaticXmiLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl,
//							bundle);
//				} else {
//					loader = new StaticXmiLoader<EPackage>(EcorePackage.eINSTANCE, ecoreUrl,
//							ResourceType.CLASSPATH);
//				}
//				final EPackage ecorePackage = loader.get();
				
				log.debug("Loaded {} EPackage {} ({}={}) from {} in {}", suppliedClassName, 
						ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
						ePackageFullName, xmiUrls);
				catalog.setEPackage(ecorePackage);
				
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
					final Field eFactoryInstanceField = eFactoryClass.getField("eINSTANCE");
					final EFactory eFactory = (EFactory) eFactoryInstanceField.get(eFactoryClass);
					log.debug("Loaded EFactory {} for EPackage {} ({}={}) from {} in {}",
							eFactory, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							ePackageFullName, xmiUrls);
					catalog.setEFactory(eFactory);
				} catch (Exception e) {
					throw new EmailException(String.format("Cannot load EFactory class %s for EPackage %s (%s=%s) from %s in %s",
							eFactoryClassName, ecorePackage.getName(), ecorePackage.getNsPrefix(), ecorePackage.getNsURI(),
							ePackageFullName, xmiUrls), e);
				}
				
				final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
				final EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
				for (final EClassifier eClassifier : eClassifiers) {
					if (!(eClassifier instanceof EClass))
						continue;
					EClass eClass = (EClass) eClassifier;
					log.debug("Mapping EClass {}.{} as {}:{} from {} in {}",
							ecorePackage.getName(), eClass.getName(),
							ecorePackage.getNsPrefix(), eClass.getName(),
							ePackageFullName, xmiUrls);
					eClassMapBuilder.put(ecorePackage.getNsPrefix() + ":" + eClass.getName(), eClass);
				}
				
				final Map<String, EClass> eClassMap = eClassMapBuilder.build();
				log.debug("Loaded {} EClasses from EmailSchema ecore package {} in {}",
						eClassMap.size(), ePackageFullName, xmiUrls );
				return eClassMap;
			}
		}));
//		final Map<URL, EPackage> ePackageMap = ePackageMapBuilder.build();
//		final Map<URL, EFactory> eFactoryMap = eFactoryMapBuilder.build();
		final ImmutableMap.Builder<String, EClass> eClassMapBuilder = ImmutableMap.builder();
		for (final Map<String, EClass> ecoreFileObj : ecoreFileObjs) {
			eClassMapBuilder.putAll(ecoreFileObj);
		}
		final Map<String, EClass> eClassMap = eClassMapBuilder.build();
		log.info("Loaded {} EClasses from {} EmailSchema ecore packages in {}: {}",
				eClassMap.size(), ecoreFileObjs.size(), xmiUrls, eClassMap.keySet() );

		// ------------------ EmailCatalog XMI files ------------
		for (EmailCatalog emailCatalog : catalogs) {
			final String genPackage = emailCatalog.getGeneratedPackageName();
//			final EPackage ePackage = ePackageMap.get(ecoreUrl);
//			Preconditions.checkNotNull(ePackage, "Cannot find companion EPackage for XMI %s, Ecore %s. %s map entries: %s",
//					url, ecoreUrl, ePackageMap.size(), ePackageMap);
//			final String genPackage = genPackageMap.get(ecoreUrl);
//			Preconditions.checkNotNull(genPackage, "Cannot determine generated package for XMI %s, Ecore %s. %s map entries: %s",
//					url, ecoreUrl, genPackageMap.size(), genPackageMap);
			final EFactory eFactory = emailCatalog.getEFactory();
			
			for (final LayoutType layoutType : emailCatalog.getLayoutTypes()) {
				log.debug("Realizing LayoutType {} from {}", layoutType.getName(), emailCatalog.getNsPrefix());
				layoutType.setNsPrefix(emailCatalog.getNsPrefix());
				layoutType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
				layoutType.setEPackageName(emailCatalog.getNsPrefix());
				layoutType.setEFactory(eFactory);
				final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, layoutType.getName());
				layoutType.setEClassName(eClassName);
				layoutType.setJavaClassName(genPackage + "." + eClassName);
				
				final String plainFileName = genPackage.replace('.', '/') + "/" + eClassName + ".txt.mustache";
				try {
					final URL resource = bundle != null ? bundle.getEntry(plainFileName) : classLoader.getResource(plainFileName);
					final String plain = IOUtils.toString(resource);
					layoutType.setPlainTemplate(plain);
				} catch (IOException e) {
					throw new EmailException("Cannot read " + plainFileName + " in " + xmiUrls, e);
				}
				final String htmlFileName = genPackage.replace('.', '/') + "/" + eClassName + ".html.mustache";
				try {
					final URL resource = bundle != null ? bundle.getEntry(htmlFileName) : classLoader.getResource(htmlFileName);
					final String html = IOUtils.toString(resource);
					layoutType.setHtmlTemplate(html);
				} catch (IOException e) {
					throw new EmailException("Cannot read " + htmlFileName + " in " + xmiUrls, e);
				}
			}
			
			for (final PageType pageType : emailCatalog.getPageTypes()) {
				log.debug("Realizing PageType {} from {}", pageType.getName(), emailCatalog.getNsPrefix());
				pageType.setNsPrefix(emailCatalog.getNsPrefix());
				pageType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
				pageType.setEPackageName(emailCatalog.getNsPrefix());
				pageType.setEFactory(eFactory);
				final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, pageType.getName());
				pageType.setEClassName(eClassName);
				pageType.setJavaClassName(genPackage + "." + eClassName);
				
				final String plainFileName = genPackage.replace('.', '/') + "/" + eClassName + ".txt.mustache";
				try {
					final URL resource = bundle != null ? bundle.getEntry(plainFileName) : classLoader.getResource(plainFileName);
					final String plain = IOUtils.toString(resource);
					pageType.setPlainTemplate(plain);
				} catch (Exception e) {
					log.info("No plain email template found for " + pageType.getName() + ". Cannot read " +
						plainFileName + " in " + xmiUrls);
				}
				final String htmlFileName = genPackage.replace('.', '/') + "/" + eClassName + ".html.mustache";
				try {
					final URL resource = bundle != null ? bundle.getEntry(htmlFileName) : classLoader.getResource(htmlFileName);
					final String html = IOUtils.toString(resource);
					pageType.setHtmlTemplate(html);
				} catch (Exception e) {
					throw new EmailException("Cannot read " + htmlFileName + " in " + xmiUrls, e);
				}
			}
			
			for (final SenderType senderType : emailCatalog.getSenderTypes()) {
				log.debug("Realizing SenderType {} from {}", senderType.getName(), emailCatalog.getNsPrefix());
				senderType.setNsPrefix(emailCatalog.getNsPrefix());
			}
			
			log.debug("Loaded {} LayoutTypes, {} PageTypes, and {} SenderTypes from EmailSchema {} in {}",
					emailCatalog.getLayoutTypes().size(), emailCatalog.getPageTypes().size(),
					emailCatalog.getSenderTypes().size(),
					emailCatalog.getNsPrefix(), xmiUrls );
		}
		
		// -------------- Concatenate everything ------------
		final List<LayoutType> layoutTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<LayoutType>>() {
			@Override @Nullable
			public List<LayoutType> apply(@Nullable final EmailCatalog input) {
				return input.getLayoutTypes();
			}
		})));
		log.info("Loaded {} LayoutTypes from {}",
				layoutTypes.size(), xmiUrls);
		
		final List<PageType> pageTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<PageType>>() {
			@Override @Nullable
			public List<PageType> apply(@Nullable final EmailCatalog input) {
				return input.getPageTypes();
			}
		})));
		log.info("Loaded {} PageTypes from {}",
				pageTypes.size(), xmiUrls);

		final List<SenderType> senderTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<SenderType>>() {
			@Override @Nullable
			public List<SenderType> apply(@Nullable final EmailCatalog input) {
				return input.getSenderTypes();
			}
		})));
		log.info("Loaded {} SenderTypes from {}",
				senderTypes.size(), xmiUrls);

		// Add these objects to repo
		synchronized (repo) {
			repo.getLayoutTypes().addAll(layoutTypes);
			repo.getPageTypes().addAll(pageTypes);
			repo.getSenderTypes().addAll(senderTypes);
		}

		// -------- Resolve EClass-es & JavaClass-es -----------
		log.info("Resolving EClass & JavaClass in {} LayoutTypes from {}",
				layoutTypes.size(), xmiUrls);
		for (final LayoutType layoutType : layoutTypes) {
			layoutType.resolveEClass(eClassMap);
			layoutType.resolveJavaClass(bundle);
		}
		log.info("Resolving EClass & JavaClass in {} PageTypes from {}",
				layoutTypes.size(), xmiUrls);
		for (final PageType pageType : pageTypes) {
			pageType.resolveEClass(eClassMap);
			pageType.resolveJavaClass(bundle);
		}
		
		// Notify StorySchemaCatalogXmiTracker
//		final TargetTypeAdded added = SchemaFactory.eINSTANCE.createTargetTypeAdded();
//		added.getTargetTypes().addAll(targetTypes);
//		eventBus.post(added);
		
		final List<EObject> objects = ImmutableList.copyOf(Iterables.<EObject>concat(layoutTypes, pageTypes));
		return objects;
	}

	/**
	 * Note: A global "scan using classpath" is not possible unless the packageToScan to get the package name
	 * is embedded inside the XMI file.
	 * @param classLoader
	 * @param pkg
	 * @return
	 */
//	@Nullable
//	protected List<EObject> addingBundle(@Nonnull ClassLoader classLoader, @Nonnull String pkg) {
//		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
//		final Resource[] resources;
//		try {
//			log.debug("Scanning *.{}.xmi in classpath {}", suppliedClassSimpleName, pkg);
//			resources = resolver.getResources(pkg.replace('.', '/') + "/*." + suppliedClassSimpleName + ".xmi");
//			log.info("Scanned *.{}.xmi in classpath {} returned {} resources: {}",
//					suppliedClassSimpleName, pkg, resources.length, resources);
//			if (resources == null || resources.length == 0) {
//				return null;
//			}
//		} catch (FileNotFoundException fnf) {
//			log.warn("Requested to scan " + pkg + " for " + suppliedClassSimpleName +
//					" but package not found in " + classLoader, fnf);
//			return null;
//		} catch (IOException e2) {
//			log.error("Cannot scan " + pkg + " for " + suppliedClassSimpleName, e2);
//			return null;
//		}
//		final List<URL> xmiUrls = Lists.transform(ImmutableList.copyOf(resources), new Function<Resource, URL>() {
//			@Override @Nullable
//			public URL apply(@Nullable Resource input) {
//				try {
//					return input.getURL();
//				} catch (IOException e) {
//					throw new RuntimeException("Cannot get URL for " + input, e);
//				}
//			}
//		});
//		return extractObjects(xmiUrls, null, classLoader, pkg);
//	}
	
	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<EObject> objects) {
	}

	private void removedBundle(@Nonnull final List<EObject> objects,
			String resourceContainer) {
		if (objects.isEmpty())
			return;
		
		log.debug("Removing {} EObjects provided by {}",
				objects.size(), resourceContainer);
		long removedCount = 0;
		for (final EObject eobject : objects) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			if (eobject instanceof LayoutType) {
				final LayoutType layoutType = (LayoutType) eobject;
				log.debug("Removing LayoutType {} from {}", layoutType.getName(),
						resourceContainer);
				synchronized (repo) {
					if (repo.getLayoutTypes().remove(layoutType))
						removedCount++;
				}
			} else if (eobject instanceof PageType) {
				final PageType pageType = (PageType) eobject;
				log.debug("Removing PageType {} from {}", pageType.getName(),
						resourceContainer);
				synchronized (repo) {
					if (repo.getPageTypes().remove(pageType))
						removedCount++;
				}
			} else if (eobject instanceof SenderType) {
				final SenderType senderType = (SenderType) eobject;
				log.debug("Removing SenderType {} from {}", senderType.getName(),
						resourceContainer);
				synchronized (repo) {
					if (repo.getSenderTypes().remove(senderType))
						removedCount++;
				}
			} else {
				throw new EmailException("Unknown EObject " + eobject.getClass().getName() + " from " + 
						resourceContainer);
			}
		}
		log.info("Removed {} email Types from {}",
				removedCount, resourceContainer);
		
		// Notify StorySchemaCatalogXmiTracker
//			final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
//			removed.getTargetTypes().addAll(catalogs);
//			eventBus.post(removed);
	}
	
	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			@Nonnull final List<EObject> objects) {
		removedBundle(objects, bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
	}
	
	@PreDestroy
	public void destroy() {
		for (final Entry<String, List<EObject>> entry : eObjects.entrySet()) {
			removedBundle(entry.getValue(), entry.getKey());
		}
	}
	
}
