package org.soluvas.commons;

import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Tracks files named <tt>(bundle).{suppliedClassSimpleName}.xmi</tt> and
 * directly registers/unregisters the root content in the OSGi Service Registry,
 * using {@link Positionable#getPositioner()} as OSGi service ranking if available.
 * 
 * This is a shortcut that's in effect equivalent to using an {@link XmiTracker} 
 * combined with {@link SupplierTracker}, or using {@link SupplierXmiTracker},
 * but without the {@link Supplier} part. Which is convenient when dealing
 * with OSGi API.
 * 
 * Note: This is best used when you only have one XMI for that service (i.e. no "default").
 * If you have multiple services, then you can't conveniently use this with
 * Blueprint because once Blueprint gets a service, it won't release it
 * even if a higher ranking service comes in. So you must refresh the consuming bundle
 * manually. 
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
public class ServiceXmiTracker<T extends EObject> implements BundleTrackerCustomizer<List<ServiceRegistration<T>>> {

	private static final Logger log = LoggerFactory
			.getLogger(ServiceXmiTracker.class);
	private final EPackage ePackage;
	private final String suppliedClassName;
	private final String suppliedClassSimpleName;
	
	/**
	 * Do not use this constructor in Blueprint XML due to classloading problems, use {@link #XmiTracker(Class, Class, String, String)}.
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 */
	public ServiceXmiTracker(final @Nonnull EPackage ePackage, final @Nonnull Class<T> suppliedClass) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
	}

	public ServiceXmiTracker(final @Nonnull Class<EPackage> ePackageClass, final @Nonnull Class<T> suppliedClass) {
		super();
		this.ePackage = EmfUtils.getEPackage(ePackageClass);
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
	}
	
	@Override @Nullable
	public List<ServiceRegistration<T>> addingBundle(@Nonnull Bundle bundle,
			@Nonnull BundleEvent event) {
		final ImmutableList.Builder<ServiceRegistration<T>> svcRegsBuilder = ImmutableList.builder();
		try {
			final String path = bundle.getSymbolicName().replace('.', '/');
			final String filePattern = "*." + suppliedClassSimpleName + ".xmi";
			log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
					path , filePattern);
			final Enumeration<URL> entries = bundle.findEntries(path, filePattern, false);
			if (entries == null) {
				return null;
			}
			while (entries.hasMoreElements()) {
				final URL url = entries.nextElement();
				log.debug("Registering Supplier for {} from {}", suppliedClassName, url);
				final XmiObjectLoader<T> loader = new XmiObjectLoader<T>(ePackage, url,
						bundle);
				final T root = loader.get();
				final Dictionary<String, Object> props = new Hashtable<String, Object>();
				if (root instanceof Positionable) {
					props.put(Constants.SERVICE_RANKING, Optional.fromNullable(((Positionable) root).getPositioner()).or(0));
				}
				props.put("resourceUri", url);
				final ServiceRegistration<T> svcReg = (ServiceRegistration<T>) bundle.getBundleContext().registerService(suppliedClassName, root, props);
				svcRegsBuilder.add(svcReg);
			}
			final List<ServiceRegistration<T>> svcRegs = svcRegsBuilder.build();
			log.info("Registered {} {} svcRegs from {} [{}]",
					svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
			return svcRegs;
		} catch (final Exception e) {
			final List<ServiceRegistration<T>> svcRegs = svcRegsBuilder.build();
			// Undo registrations
			if (!svcRegs.isEmpty()) {
				log.info("Unregistering {} {} svcRegs due to {}",
						svcRegs.size(), suppliedClassSimpleName, e);
				for (final ServiceRegistration<T> svcReg : svcRegs) {
					try {
						svcReg.unregister();
					} catch (Exception e1) {
						log.warn("Cannot unregister " + svcReg, e);
					}
				}
			}
			log.error("Cannot scan " + bundle + " for " + suppliedClassSimpleName, e);
			return null;
		}
	}

	@Override
	public void modifiedBundle(@Nonnull Bundle bundle, @Nonnull BundleEvent event,
			@Nullable List<ServiceRegistration<T>> object) {
	}

	@Override
	public void removedBundle(@Nonnull Bundle bundle, @Nonnull BundleEvent event,
			@Nullable List<ServiceRegistration<T>> svcRegs) {
		if (svcRegs == null)
			return;
		log.debug("Unregistering {} {} svcRegs from {} [{}]",
				svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
		for (final ServiceRegistration<T> svcReg : svcRegs) {
			try {
				svcReg.unregister();
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {} [{}]", svcReg,
						bundle.getSymbolicName(), bundle.getBundleId());
			}
		}
		log.info("Unregistered {} {} svcRegs from {} [{}]",
				svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
	}

}
