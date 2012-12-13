package org.soluvas.email.util;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.validation.SchemaFactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.LayoutType;
import org.soluvas.email.PageType;

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
public class EmailCatalogXmiTracker implements BundleTrackerCustomizer<Map<String, EmailCatalog>> {
	
	private static Logger log = LoggerFactory
			.getLogger(EmailCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = EmailCatalog.class.getSimpleName();
	private static final String suppliedClassName = EmailCatalog.class.getName();
	private static final EmailPackage xmiEPackage = EmailPackage.eINSTANCE;
	private final EmailCatalog repo;
	private final EventBus eventBus;
	
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

	@Override
	public Map<String, EmailCatalog> addingBundle(final Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		// ------------------ Scan EmailCatalogs ------------
		final String xmiFilePattern = "*." + suppliedClassSimpleName + ".xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , xmiFilePattern);
		final Enumeration<URL> entries = bundle.findEntries(path, xmiFilePattern, false);
		if (entries == null)
			return ImmutableMap.of();
		final List<URL> xmiFiles = ImmutableList.copyOf(Iterators.forEnumeration(entries));
		if (xmiFiles.isEmpty())
			return ImmutableMap.of();

		// ------------------ Ecore package files ------------
		final ImmutableMap.Builder<URL, URL> xmiToEcoreMapBuilder = ImmutableMap.builder();
		for (final URL xmiUrl : xmiFiles) {
			final URL ecoreUrl;
			try {
				ecoreUrl = new URL(xmiUrl.toExternalForm()
						.replace("." + suppliedClassSimpleName + ".xmi", "-email.ecore"));
			} catch (MalformedURLException e) {
				throw new EmailException("Cannot get ecore URL from XMI URL " + xmiUrl, e);
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
				
				// Determine generated package name. "email" is a special package suffix
				final String genPackage = bundle.getSymbolicName() +
						("email".equals(ecorePackage.getName()) && bundle.getSymbolicName().endsWith(".email") ? "" : "." + ecorePackage.getName());
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
					throw new EmailException(String.format("Cannot load EFactory class %s for EPackage %s (%s=%s) from %s in %s [%s]",
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
				log.debug("Loaded {} EClasses from EmailSchema ecore package {} in {} [{}]",
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
		log.info("Loaded {} EPackages, {} EFactory-es, and {} EClasses from {} EmailSchema ecore packages in {} [{}]: {}",
				ePackageMap.size(), eFactoryMap.size(), eClassMap.size(), ecoreFileObjs.size(), bundle.getSymbolicName(), bundle.getBundleId(),
				eClassMap.keySet() );

		// ------------------ EmailCatalog XMI files ------------
		final List<EmailCatalog> xmiFileObjs = ImmutableList.copyOf(Lists.transform(xmiFiles, new Function<URL, EmailCatalog>() {
			@Override @Nullable
			public EmailCatalog apply(@Nullable URL url) {
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

				log.debug("Getting EmailCatalog XMI {} from {} in {} [{}], EPackage {} ({}={})", suppliedClassName, url,
						bundle.getSymbolicName(), bundle.getBundleId(), ePackage.getName(), ePackage.getNsPrefix(), ePackage.getNsURI() );
				final XmiObjectLoader<EmailCatalog> loader = new XmiObjectLoader<EmailCatalog>(xmiEPackage, url,
						bundle);
				final EmailCatalog emailCatalog = loader.get();
				
				for (final LayoutType layoutType : emailCatalog.getLayouts()) {
					log.debug("Realizing LayoutType {} from {}", layoutType.getName(), url);
					layoutType.setNsPrefix(emailCatalog.getNsPrefix());
					layoutType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
					layoutType.setEPackageName(emailCatalog.getNsPrefix());
					layoutType.setEFactory(eFactory);
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, pageType.getName());
					layoutType.setEClassName(eClassName);
					layoutType.setJavaClassName(genPackage + "." + eClassName);
				}
				
				for (final PageType pageType : emailCatalog.getPages()) {
					log.debug("Realizing PageType {} from {}", pageType.getName(), url);
					pageType.setNsPrefix(emailCatalog.getNsPrefix());
					pageType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
					pageType.setEPackageName(emailCatalog.getNsPrefix());
					pageType.setEFactory(eFactory);
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, pageType.getName());
					pageType.setEClassName(eClassName);
					pageType.setJavaClassName(genPackage + "." + eClassName);
				}
				
				log.debug("Loaded {} LayoutTypes and {} PageTypes from EmailSchema {} in {} [{}]",
						emailCatalog.getLayouts().size(), emailCatalog.getPages().size(),
						url, bundle.getSymbolicName(), bundle.getBundleId() );
				return emailCatalog;
			}
		}));
		
		// -------------- Concatenate everything ------------
		final List<LayoutType> layoutTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(xmiFileObjs, new Function<EmailCatalog, List<LayoutType>>() {
			@Override @Nullable
			public List<LayoutType> apply(@Nullable final EmailCatalog input) {
				return input.getLayouts();
			}
		})));
		log.info("Loaded {} LayoutTypes from {} [{}]",
				layoutTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		final List<PageType> pageTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(xmiFileObjs, new Function<EmailCatalog, List<PageType>>() {
			@Override @Nullable
			public List<PageType> apply(@Nullable final EmailCatalog input) {
				return input.getPages();
			}
		})));
		log.info("Loaded {} PageTypes from {} [{}]",
				pageTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		
		// -------- Resolve EClass-es & JavaClass-es -----------
		log.info("Resolving EClass & JavaClass in {} LayoutTypes from {} [{}]",
				layoutTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		for (final LayoutType layoutType : layoutTypes) {
			layoutType.resolveEClass(eClassMap);
			layoutType.resolveJavaClass(bundle);
		}
		log.info("Resolving EClass & JavaClass in {} PageTypes from {} [{}]",
				layoutTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		for (final PageType pageType : pageTypes) {
			pageType.resolveEClass(eClassMap);
			pageType.resolveJavaClass(bundle);
		}

		// Notify StorySchemaCatalogXmiTracker
//		final TargetTypeAdded added = SchemaFactory.eINSTANCE.createTargetTypeAdded();
//		added.getTargetTypes().addAll(targetTypes);
//		eventBus.post(added);
		
		return emailCatalog;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<TargetType> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			Map<String, EmailCatalog> catalogs) {
		if (catalogs.isEmpty())
			return;

		log.debug("Removing {} TargetTypes provided by {} [{}]",
				catalogs.size(), bundle.getSymbolicName(), bundle.getBundleId());
		long removedCount = 0;
		for (final TargetType eobject : catalogs) {
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
				throw new EmailException("Unknown TargetType " + eobject.getClass().getName() + " from " + 
						bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
			}
		}
		log.info("Removed {} TargetTypes from {} [{}]",
				removedCount, bundle.getSymbolicName(), bundle.getBundleId());
		
		// Notify StorySchemaCatalogXmiTracker
		final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
		removed.getTargetTypes().addAll(catalogs);
		eventBus.post(removed);
	}

}
