package org.soluvas.commons;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.XmiTrackerUtils;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
 * Tracks files named <tt>(bundle).{suppliedClassSimpleName}.xmi</tt> and registers
 * them as {suppliedClassSimpleName} {@link Supplier}.
 * 
 * Usage:
 * 
 * <pre>{@code
 * 	<bean id="securityCatalogXmiTracker" class="org.soluvas.commons.XmiTracker">
 * 		<argument value="org.soluvas.security.SecurityPackage" />
 * 		<argument value="org.soluvas.security.SecurityCatalog" />
 * 		<argument value="${tenantId}" />
 * 		<argument value="${tenantEnv}" />
 * 	</bean>
 * 	<bean class="org.osgi.util.tracker.BundleTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument value="32" />
 * 		<argument ref="securityCatalogXmiTracker" />
 * 	</bean>
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class XmiTracker implements BundleTrackerCustomizer<List<ServiceRegistration<Supplier>>> {

	private static final Logger log = LoggerFactory
			.getLogger(XmiTracker.class);
	private final String tenantId;
	private final String tenantEnv;
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
	public XmiTracker(final @Nonnull EPackage ePackage, final @Nonnull Class<?> suppliedClass,
			@Nonnull String tenantId, @Nonnull String tenantEnv) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

	public XmiTracker(final @Nonnull Class<EPackage> ePackageClass, final @Nonnull Class<?> suppliedClass,
			@Nonnull String tenantId, @Nonnull String tenantEnv) {
		super();
		this.ePackage = EmfUtils.getEPackage(ePackageClass);
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

//	public XmiTracker(final @Nonnull EPackage ePackage, final @Nonnull String suppliedClassName,
//			@Nonnull String tenantId, @Nonnull String tenantEnv) {
//		super();
//		this.ePackage = ePackage;
//		this.suppliedClassName = suppliedClassName;
//		Matcher matcher = Pattern.compile(".*([^.]+)").matcher(suppliedClassName);
//		if (!matcher.matches())
//			throw new IllegalArgumentException("Invalid supplied class name: " + suppliedClassName);
//		this.suppliedClassSimpleName = matcher.group(1);
//		this.tenantId = tenantId;
//		this.tenantEnv = tenantEnv;
//	}

	@Override
	@Nullable
	public List<ServiceRegistration<Supplier>> addingBundle(@Nonnull Bundle bundle,
			@Nonnull BundleEvent event) {
		final Builder<ServiceRegistration<Supplier>> svcRegs = ImmutableList.builder();
		try {
			final List<URL> entries = XmiTrackerUtils.scan(bundle, suppliedClassSimpleName);
			if (entries.isEmpty()) {
				return null;
			}
			for (final URL url : entries) {
				log.debug("Registering Supplier for {} from {}", suppliedClassName, url);
				final XmiObjectLoader<EObject> loader = new XmiObjectLoader<EObject>(ePackage, url,
						bundle);
				final Dictionary<String, String> props = new Hashtable<String, String>();
				props.put("suppliedClass", suppliedClassName);
				props.put("layer", "module");
				props.put("tenantId", tenantId);
				props.put("tenantEnv", tenantEnv);
				final ServiceRegistration<Supplier> svcReg = bundle.getBundleContext()
						.registerService(Supplier.class, loader, props);
				svcRegs.add(svcReg);
			}
			final List<ServiceRegistration<Supplier>> svcRegList = svcRegs.build();
			log.info("Registered {} {} suppliers from {} [{}]",
					svcRegList.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
			return svcRegList;
		} catch (Exception e) {
			final List<ServiceRegistration<Supplier>> svcRegList = svcRegs.build();
			// Undo registrations
			if (!svcRegList.isEmpty()) {
				log.info("Unregistering {} {} suppliers due to {}",
						svcRegList.size(), suppliedClassSimpleName, e);
				for (final ServiceRegistration<Supplier> svcReg : svcRegList) {
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
			@Nullable List<ServiceRegistration<Supplier>> object) {
	}

	@Override
	public void removedBundle(@Nonnull Bundle bundle, @Nonnull BundleEvent event,
			@Nullable List<ServiceRegistration<Supplier>> svcRegs) {
		if (svcRegs == null)
			return;
		log.debug("Unregistering {} {} suppliers from {} [{}]",
				svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
		for (final ServiceRegistration<Supplier> svcReg : svcRegs) {
			try {
				svcReg.unregister();
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {} [{}]", svcReg,
						bundle.getSymbolicName(), bundle.getBundleId());
			}
		}
		log.info("Unregistered {} {} suppliers from {} [{}]",
				svcRegs.size(), suppliedClassSimpleName, bundle.getSymbolicName(), bundle.getBundleId());
	}

}
