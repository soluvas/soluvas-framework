package org.soluvas.security;

import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.XmiObjectLoader;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
 * Tracks files named <tt>(bundle).SecurityCatalog.xmi</tt> and registers
 * them as {@link SecurityCatalog} {@link Supplier}.
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class SecurityCatalogXmiTracker implements BundleTrackerCustomizer<List<ServiceRegistration<Supplier>>> {

	private transient Logger log = LoggerFactory
			.getLogger(SecurityCatalogXmiTracker.class);
	private final String tenantId;
	private final String tenantEnv;
	
	public SecurityCatalogXmiTracker(String tenantId, String tenantEnv) {
		super();
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

	@Override
	public List<ServiceRegistration<Supplier>> addingBundle(Bundle bundle,
			BundleEvent event) {
		String path = bundle.getSymbolicName().replace('.', '/');
		String filePattern = "*.SecurityCatalog.xmi";
		log.trace("Scanning {} [{}] for {}/{}", bundle.getSymbolicName(), bundle.getBundleId(),
				path , filePattern);
		Enumeration<URL> entries = bundle.findEntries(path, filePattern, false);
		Builder<ServiceRegistration<Supplier>> svcRegs = ImmutableList.builder();
		while (entries.hasMoreElements()) {
			URL url = entries.nextElement();
			log.debug("Loading SecurityCatalog from {}", url);
			XmiObjectLoader<EObject> loader = new XmiObjectLoader<EObject>(SecurityPackage.class, url);
			Dictionary<String, String> props = new Hashtable<String, String>();
			props.put("suppliedClass", SecurityCatalog.class.getName());
			props.put("tenantId", tenantId);
			props.put("tenantEnv", tenantEnv);
			ServiceRegistration<Supplier> svcReg = bundle.getBundleContext().registerService(Supplier.class, loader, props);
			svcRegs.add(svcReg);
		}
		final List<ServiceRegistration<Supplier>> svcRegList = svcRegs.build();
		log.info("Registered {} SecurityCatalog suppliers from {} [{}]",
				svcRegList.size(), bundle.getSymbolicName(), bundle.getBundleId());
		return svcRegList;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<ServiceRegistration<Supplier>> object) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			List<ServiceRegistration<Supplier>> svcRegs) {
		log.debug("Unregistering {} SecurityCatalog suppliers from {} [{}]",
				svcRegs.size(), bundle.getSymbolicName(), bundle.getBundleId());
		for (ServiceRegistration<Supplier> svcReg : svcRegs) {
			try {
				svcReg.unregister();
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {} [{}]", svcReg,
						bundle.getSymbolicName(), bundle.getBundleId());
			}
		}
		log.info("Unregistered {} SecurityCatalog suppliers from {} [{}]",
				svcRegs.size(), bundle.getSymbolicName(), bundle.getBundleId());
	}

}
