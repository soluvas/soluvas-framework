package org.soluvas.commons;

import java.net.URL;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.XmiTrackerUtils;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Tracks files named <tt>(bundle).{suppliedClassSimpleName}.xmi</tt> and adds/removes
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
public class SupplierXmiTracker<T extends EObject> implements BundleTrackerCustomizer<List<Supplier<T>>> {

	private static final Logger log = LoggerFactory
			.getLogger(SupplierXmiTracker.class);
	private final EPackage ePackage;
	private final String suppliedClassName;
	private final String suppliedClassSimpleName;
	private final DelegatingSupplier<T> delegate;
	
	/**
	 * Do not use this constructor in Blueprint XML due to classloading problems, use {@link #XmiTracker(Class, Class, String, String)}.
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SupplierXmiTracker(final @Nonnull EPackage ePackage, final @Nonnull Class<T> suppliedClass,
			@Nonnull final DelegatingSupplier<T> delegate) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.delegate = delegate;
	}

	public SupplierXmiTracker(final @Nonnull Class<EPackage> ePackageClass, final @Nonnull Class<T> suppliedClass,
			@Nonnull final DelegatingSupplier<T> delegate) {
		super();
		this.ePackage = EmfUtils.getEPackage(ePackageClass);
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.delegate = delegate;
	}
	
	@Override @Nullable
	public List<Supplier<T>> addingBundle(@Nonnull Bundle bundle,
			@Nonnull BundleEvent event) {
		final ImmutableList.Builder<Supplier<T>> suppliersBuilder = ImmutableList.builder();
		try {
			final List<URL> entries = XmiTrackerUtils.scan(bundle, suppliedClassSimpleName);
			if (entries.isEmpty()) {
				return null;
			}
			for (final URL url : entries) {
				log.debug("Registering Supplier for {} from {}", suppliedClassName, url);
				final XmiObjectLoader<T> loader = new XmiObjectLoader<T>(ePackage, url,
						bundle);
				delegate.addSupplier(loader);
				suppliersBuilder.add(loader);
			}
			final List<Supplier<T>> suppliers = suppliersBuilder.build();
			log.info("Registered {} {} suppliers from {} [{}]",
					suppliers.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
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
			log.error("Cannot scan " + bundle + " for " + suppliedClassSimpleName, e);
			return null;
		}
	}

	@Override
	public void modifiedBundle(@Nonnull Bundle bundle, @Nonnull BundleEvent event,
			@Nullable List<Supplier<T>> object) {
	}

	@Override
	public void removedBundle(@Nonnull Bundle bundle, @Nonnull BundleEvent event,
			@Nullable List<Supplier<T>> suppliers) {
		if (suppliers == null)
			return;
		log.debug("Unregistering {} {} suppliers from {} [{}]",
				suppliers.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
		for (final Supplier<T> supplier : suppliers) {
			try {
				delegate.removeSupplier(supplier);
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {} [{}]", supplier,
						bundle.getSymbolicName(), bundle.getBundleId());
			}
		}
		log.info("Unregistered {} {} suppliers from {} [{}]",
				suppliers.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
	}

}
