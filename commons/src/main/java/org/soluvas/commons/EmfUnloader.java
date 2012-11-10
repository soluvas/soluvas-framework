package org.soluvas.commons;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic EMF Unloader.
 * 
 * Usage:
 * 
 * <pre>
 * {@code
 * <bean class="org.soluvas.commons.EmfUnloader" destroy-method="destroy">
 * 	<argument value="org.soluvas.security.SecurityPackage" />
 * </bean>
 * }
 * </pre>
 * 
 * @author ceefour
 */
public class EmfUnloader {

	private transient Logger log = LoggerFactory.getLogger(EmfUnloader.class);
	private final Class<? extends EPackage>[] packages;
	private final BundleContext bundleContext;
	private final List<ServiceRegistration<?>> svcRegs = new ArrayList<ServiceRegistration<?>>();
	
	@SuppressWarnings("unchecked")
	@Deprecated
	public EmfUnloader(Class<? extends EPackage> pkg) {
		this(null, pkg);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Deprecated
	public EmfUnloader(Class... packages) {
		super();
		this.bundleContext = null;
		this.packages = packages;
	}
	
	@SuppressWarnings("unchecked")
	public EmfUnloader(BundleContext bundleContext, Class<? extends EPackage> pkg) {
		super();
		this.bundleContext = bundleContext;
		this.packages = new Class[] { pkg };
	}

	/**
	 * Call this to register the {@link EPackage}s.
	 */
	public void init() {
		for (Class<? extends EPackage> pkg : packages) {
			try {
				log.debug("Registering EPackage {}", pkg.getName());
				EPackage ePackage = EmfUtils.getEPackage(pkg);
				EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
				
				if (bundleContext != null) {
					ServiceRegistration<?> reg = bundleContext.registerService(pkg.getName(), ePackage, new Hashtable<String, Object>());
					log.trace("Registered EPackage service {}", reg);
					svcRegs.add(reg);
				}
			} catch (Exception e) {
				log.error("Cannot register EPackage " + pkg.getName(), e);
			}
		}
	}

	/**
	 * Call this to unload the {@link EPackage}s.
	 */
	public void destroy() {
		for (ServiceRegistration<?> reg : svcRegs) {
			log.trace("Unregistering EPackage service {}", reg);
			reg.unregister();
		}
		
		for (Class<? extends EPackage> pkg : packages) {
			try {
				String packageNsUri = (String) pkg.getDeclaredField("eNS_URI")
						.get(pkg);
				log.debug("Unloading EMF Package {} by {}", packageNsUri,
						pkg.getName());
				EPackage.Registry.INSTANCE.remove(packageNsUri);
			} catch (Exception e) {
				log.error("Cannot unload EMF Package " + pkg.getName(), e);
			}
		}
	}

}
