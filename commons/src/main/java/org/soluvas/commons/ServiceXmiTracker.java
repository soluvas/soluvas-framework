package org.soluvas.commons;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.ClassUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.XmiTrackerUtils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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
 * 	<bean id="bannerCatalogXmiTracker" class="org.soluvas.commons.ServiceXmiTracker">
 * 		<argument value="org.soluvas.web.banner.BannerPackage" />
 * 		<argument value="org.soluvas.web.banner.BannerCatalog" />
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
	
	private final List<ServiceRegistration<T>> allSvcRegs = Lists.newCopyOnWriteArrayList();
	
	/**
	 * Do not use this constructor in Blueprint XML due to classloading problems, use {@link #XmiTracker(Class, Class, String, String)}.
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 */
	public ServiceXmiTracker(final EPackage ePackage, final Class<T> suppliedClass) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
	}

	public ServiceXmiTracker(final Class<EPackage> ePackageClass, final Class<T> suppliedClass) {
		super();
		this.ePackage = EmfUtils.getEPackage(ePackageClass);
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
	}
	
	public void destroy() {
		for (final ServiceRegistration<T> reg : allSvcRegs) {
			try {
				reg.unregister();
			} catch (Exception e) {
				log.warn("Cannot unregister", e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override @Nullable
	public List<ServiceRegistration<T>> addingBundle(Bundle bundle,
			BundleEvent event) {
		final ImmutableList.Builder<ServiceRegistration<T>> svcRegsBuilder = ImmutableList.builder();
		try {
			final List<URL> entries = XmiTrackerUtils.scan(bundle, suppliedClassSimpleName);
			if (entries.isEmpty()) {
				return null;
			}
			for (final URL url : entries) {
				log.debug("Registering Supplier for {} from {}", suppliedClassName, url);
				final StaticXmiLoader<T> loader = new StaticXmiLoader<T>(ePackage, url,
						bundle);
				final T root = loader.get();
				final Dictionary<String, Object> props = new Hashtable<String, Object>();
				if (root instanceof Positionable) {
					props.put(Constants.SERVICE_RANKING, Optional.fromNullable(((Positionable) root).getPositioner()).or(0));
				}
				props.put("resourceUri", url);
				final List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(root.getClass());
				final List<String> allInterfaceNames = Lists.transform(allInterfaces, new Function<Class<?>, String>() {
					@Override @Nullable
					public String apply(@Nullable Class<?> input) {
						return input.getName();
					}
				});
//				final ServiceRegistration<T> svcReg = (ServiceRegistration<T>) bundle.getBundleContext().registerService(suppliedClassName, root, props);
				final ServiceRegistration<T> svcReg = (ServiceRegistration<T>) bundle.getBundleContext().registerService(
						allInterfaceNames.toArray(new String[] {}), root, props);
				svcRegsBuilder.add(svcReg);
			}
			final List<ServiceRegistration<T>> svcRegs = svcRegsBuilder.build();
			log.info("Registered {} {} svcRegs from {} [{}]",
					svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
			allSvcRegs.addAll(svcRegs);
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
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			@Nullable List<ServiceRegistration<T>> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
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
			} finally {
				allSvcRegs.remove(svcReg);
			}
		}
		log.info("Unregistered {} {} svcRegs from {} [{}]",
				svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
	}
	
}
