package org.soluvas.email.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
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
import org.soluvas.email.SenderType;

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
		if (xmiFiles.isEmpty())
			return ImmutableList.of();

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
				XmiObjectLoader<EPackage> loader;
//				try {
					loader = new XmiObjectLoader<EPackage>(EcorePackage.eINSTANCE, url,
							bundle);
//				} catch (Exception e1) {
//					log.warn("Cannot load " + url, e1);
//					return ImmutableMap.of();
//				}
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
		final List<EmailCatalog> catalogs = ImmutableList.copyOf(Lists.transform(xmiFiles, new Function<URL, EmailCatalog>() {
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
				
				for (final LayoutType layoutType : emailCatalog.getLayoutTypes()) {
					log.debug("Realizing LayoutType {} from {}", layoutType.getName(), url);
					layoutType.setNsPrefix(emailCatalog.getNsPrefix());
					layoutType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
					layoutType.setEPackageName(emailCatalog.getNsPrefix());
					layoutType.setEFactory(eFactory);
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, layoutType.getName());
					layoutType.setEClassName(eClassName);
					layoutType.setJavaClassName(genPackage + "." + eClassName);
					
					final String plainFileName = genPackage.replace('.', '/') + "/" + eClassName + ".txt.mustache";
					try {
						final String plain = IOUtils.toString(bundle.getEntry(plainFileName).openStream());
						layoutType.setPlainTemplate(plain);
					} catch (IOException e) {
						throw new EmailException("Cannot read " + plainFileName + " in " + bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]", e);
					}
					final String htmlFileName = genPackage.replace('.', '/') + "/" + eClassName + ".html.mustache";
					try {
						final String html = IOUtils.toString(bundle.getEntry(htmlFileName).openStream());
						layoutType.setHtmlTemplate(html);
					} catch (IOException e) {
						throw new EmailException("Cannot read " + htmlFileName + " in " + bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]", e);
					}
				}
				
				for (final PageType pageType : emailCatalog.getPageTypes()) {
					log.debug("Realizing PageType {} from {}", pageType.getName(), url);
					pageType.setNsPrefix(emailCatalog.getNsPrefix());
					pageType.setEPackageNsPrefix(emailCatalog.getNsPrefix() + "-email");
					pageType.setEPackageName(emailCatalog.getNsPrefix());
					pageType.setEFactory(eFactory);
					final String eClassName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, pageType.getName());
					pageType.setEClassName(eClassName);
					pageType.setJavaClassName(genPackage + "." + eClassName);
					
					final String plainFileName = genPackage.replace('.', '/') + "/" + eClassName + ".txt.mustache";
					try {
						final String plain = IOUtils.toString(bundle.getEntry(plainFileName).openStream());
						pageType.setPlainTemplate(plain);
					} catch (Exception e) {
						throw new EmailException("Cannot read " + plainFileName + " in " + bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]", e);
					}
					final String htmlFileName = genPackage.replace('.', '/') + "/" + eClassName + ".html.mustache";
					try {
						final String html = IOUtils.toString(bundle.getEntry(htmlFileName).openStream());
						pageType.setHtmlTemplate(html);
					} catch (Exception e) {
						throw new EmailException("Cannot read " + htmlFileName + " in " + bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]", e);
					}
				}
				
				for (final SenderType senderType : emailCatalog.getSenderTypes()) {
					log.debug("Realizing SenderType {} from {}", senderType.getName(), url);
					senderType.setNsPrefix(emailCatalog.getNsPrefix());
				}
				
				log.debug("Loaded {} LayoutTypes, {} PageTypes, and {} SenderTypes from EmailSchema {} in {} [{}]",
						emailCatalog.getLayoutTypes().size(), emailCatalog.getPageTypes().size(),
						emailCatalog.getSenderTypes().size(),
						url, bundle.getSymbolicName(), bundle.getBundleId() );
				return emailCatalog;
			}
		}));
		
		// -------------- Concatenate everything ------------
		final List<LayoutType> layoutTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<LayoutType>>() {
			@Override @Nullable
			public List<LayoutType> apply(@Nullable final EmailCatalog input) {
				return input.getLayoutTypes();
			}
		})));
		log.info("Loaded {} LayoutTypes from {} [{}]",
				layoutTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());
		
		final List<PageType> pageTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<PageType>>() {
			@Override @Nullable
			public List<PageType> apply(@Nullable final EmailCatalog input) {
				return input.getPageTypes();
			}
		})));
		log.info("Loaded {} PageTypes from {} [{}]",
				pageTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());

		final List<SenderType> senderTypes = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<EmailCatalog, List<SenderType>>() {
			@Override @Nullable
			public List<SenderType> apply(@Nullable final EmailCatalog input) {
				return input.getSenderTypes();
			}
		})));
		log.info("Loaded {} SenderTypes from {} [{}]",
				senderTypes.size(), bundle.getSymbolicName(), bundle.getBundleId());

		// Add these objects to repo
		synchronized (repo) {
			repo.getLayoutTypes().addAll(layoutTypes);
			repo.getPageTypes().addAll(pageTypes);
			repo.getSenderTypes().addAll(senderTypes);
		}

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
		
		final List<EObject> objects = ImmutableList.copyOf(Iterables.<EObject>concat(layoutTypes, pageTypes));
		return objects;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<EObject> objects) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			@Nonnull final List<EObject> objects) {
		if (objects.isEmpty())
			return;
		
		log.debug("Removing {} EObjects provided by {} [{}]",
				objects.size(), bundle.getSymbolicName(), bundle.getBundleId());
		long removedCount = 0;
		for (final EObject eobject : objects) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			if (eobject instanceof LayoutType) {
				final LayoutType layoutType = (LayoutType) eobject;
				log.debug("Removing LayoutType {} from {} [{}]", layoutType.getName(),
						bundle.getSymbolicName(), bundle.getBundleId());
				synchronized (repo) {
					if (repo.getLayoutTypes().remove(layoutType))
						removedCount++;
				}
			} else if (eobject instanceof PageType) {
				final PageType pageType = (PageType) eobject;
				log.debug("Removing PageType {} from {} [{}]", pageType.getName(),
						bundle.getSymbolicName(), bundle.getBundleId());
				synchronized (repo) {
					if (repo.getPageTypes().remove(pageType))
						removedCount++;
				}
			} else if (eobject instanceof SenderType) {
				final SenderType senderType = (SenderType) eobject;
				log.debug("Removing SenderType {} from {} [{}]", senderType.getName(),
						bundle.getSymbolicName(), bundle.getBundleId());
				synchronized (repo) {
					if (repo.getSenderTypes().remove(senderType))
						removedCount++;
				}
			} else {
				throw new EmailException("Unknown EObject " + eobject.getClass().getName() + " from " + 
						bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
			}
		}
		log.info("Removed {} TargetTypes from {} [{}]",
				removedCount, bundle.getSymbolicName(), bundle.getBundleId());
		
		// Notify StorySchemaCatalogXmiTracker
//			final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
//			removed.getTargetTypes().addAll(catalogs);
//			eventBus.post(removed);
	}

}
