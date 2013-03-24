package org.soluvas.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Tracks files named <tt>(bundle)/*.{suppliedClassSimpleName}.xmi</tt> and adds/removes
 * them from {@link DelegatingSupplier}.
 * 
 * This is a shortcut that's in effect equivalent to using an {@link XmiTracker} 
 * combined with {@link SupplierTracker}.
 * 
 * Usage:
 * 
 * <pre>{@code
 * 	<bean id="bannerPackage" class="org.soluvas.web.banner.impl.BannerPackageImpl"
 * 		factory-method="getInstance" />
 * 	<bean id="bannerCatalogSupplier" class="org.soluvas.commons.OverridingSupplier"
 * 		destroy-method="destroy">
 * 		<argument ref="bannerPackage"/>
 * 		<argument value="BannerCatalog"/>
 * 		<argument><list /></argument>
 * 	</bean>
 * 	<service ref="bannerCatalogSupplier" auto-export="interfaces">
 * 		<service-properties>
 * 			<entry key="clientId" value="${clientId}" />
 * 			<entry key="tenantId" value="${tenantId}" />
 * 			<entry key="tenantEnv" value="${tenantEnv}" />
 * 			<entry key="suppliedClass" value="org.soluvas.web.banner.BannerCatalog" />
 * 			<entry key="layer" value="application" />
 * 		</service-properties>
 * 	</service>
 * 	<bean id="bannerCatalogXmiTracker" class="org.soluvas.commons.SupplierXmiTracker">
 * 		<argument value="org.soluvas.web.banner.BannerPackage" />
 * 		<argument value="org.soluvas.web.banner.BannerCatalog" />
 * 		<argument ref="bannerCatalogSupplier" />
 * 	</bean>
 * 	<bean class="org.osgi.util.tracker.BundleTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument value="32" />
 * 		<argument ref="bannerCatalogXmiTracker" />
 * 	</bean>
 * }</pre>
 * 
 * @author ceefour
 */
public class SupplierXmiClasspathScanner<T extends EObject> {
	private final Logger log;
	private final EPackage ePackage;
	private final String suppliedClassName;
	private final String suppliedClassSimpleName;
	private final DelegatingSupplier<T> delegate;
	private final String packageToScan;
	private final ClassLoader classLoader;
	private List<Supplier<T>> suppliers;
	
	/**
	 * Do not use this constructor in Blueprint XML due to classloading problems, use {@link #XmiTracker(Class, Class, String, String)}.
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SupplierXmiClasspathScanner(final @Nonnull EPackage ePackage, final @Nonnull Class<T> suppliedClass,
			@Nonnull final DelegatingSupplier<T> delegate, @Nonnull final Class<?> packageToScan) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.delegate = delegate;
		this.classLoader = packageToScan.getClassLoader();
		this.packageToScan = packageToScan.getPackage().getName();
		log = LoggerFactory.getLogger(SupplierXmiClasspathScanner.class.getName() + "." + suppliedClassSimpleName + "." + this.packageToScan);
	}
	
	@PostConstruct
	public void init() {
		suppliers = addingBundle(classLoader, packageToScan);
	}
	
	@PreDestroy
	public void destroy() {
		if (suppliers != null) {
			try {
				removedBundle(classLoader, packageToScan, suppliers);
			} finally {
				suppliers = null;
			}
		}
	}

	@Nullable
	public List<Supplier<T>> addingBundle(@Nonnull ClassLoader classLoader, @Nonnull String pkg) {
		final ImmutableList.Builder<Supplier<T>> suppliersBuilder = ImmutableList.builder();
		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		final Resource[] resources;
		try {
			log.debug("Scanning *.{}.xmi in classpath {}", suppliedClassSimpleName, pkg);
			resources = resolver.getResources(packageToScan.replace('.', '/') + "/*." + suppliedClassSimpleName + ".xmi");
			log.info("Scanned *.{}.xmi in classpath {} returned {} resources: {}",
					suppliedClassSimpleName, pkg, resources.length, resources);
			if (resources == null || resources.length == 0) {
				return null;
			}
		} catch (FileNotFoundException fnf) {
			log.warn("Requested to scan " + pkg + " for " + suppliedClassSimpleName +
					" but package not found in " + classLoader, fnf);
			return null;
		} catch (IOException e2) {
			log.error("Cannot scan " + pkg + " for " + suppliedClassSimpleName, e2);
			return null;
		}
		try {
			for (final Resource resource : resources) {
				log.debug("Registering Supplier for {} from {}", suppliedClassName, resource);
				final XmiObjectLoader<T> loader = new XmiObjectLoader<T>(ePackage, resource.getURL(),
						ResourceType.BUNDLE);
				delegate.addSupplier(loader);
				suppliersBuilder.add(loader);
			}
			final List<Supplier<T>> suppliers = suppliersBuilder.build();
			log.info("Registered {} {} suppliers from {}",
					suppliers.size(), suppliedClassSimpleName, pkg);
			return suppliers;
		} catch (final Exception e) {
			final List<Supplier<T>> suppliers = suppliersBuilder.build();
			// Undo registrations
			if (!suppliers.isEmpty()) {
				log.info("Unregistering {} {} suppliers due to {}",
						suppliers.size(), suppliedClassSimpleName, e);
				for (final Supplier<T> supplier : suppliers) {
					try {
						delegate.removeSupplier(supplier);
					} catch (Exception e1) {
						log.warn("Cannot unregister " + supplier, e);
					}
				}
			}
			log.error("Cannot scan " + pkg + " for " + suppliedClassSimpleName, e);
			return null;
		}
	}

	public void removedBundle(@Nonnull ClassLoader classLoader, @Nonnull String pkg,
			@Nullable List<Supplier<T>> suppliers) {
		if (suppliers == null)
			return;
		log.debug("Unregistering {} {} suppliers from {}",
				suppliers.size(), suppliedClassSimpleName, pkg);
		for (final Supplier<T> supplier : suppliers) {
			try {
				delegate.removeSupplier(supplier);
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {}", supplier, pkg);
			}
		}
		log.info("Unregistered {} {} suppliers from {}",
				suppliers.size(), suppliedClassSimpleName, pkg);
	}

}
