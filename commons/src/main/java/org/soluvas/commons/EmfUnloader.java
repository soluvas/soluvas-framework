package org.soluvas.commons;

import org.eclipse.emf.ecore.EPackage;
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

	@SuppressWarnings("unchecked")
	public EmfUnloader(Class<? extends EPackage> pkg) {
		super();
		this.packages = new Class[] { pkg };
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EmfUnloader(Class... packages) {
		super();
		this.packages = packages;
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
			} catch (Exception e) {
				log.error("Cannot register EPackage " + pkg.getName(), e);
			}
		}
	}

	/**
	 * Call this to unload the {@link EPackage}s.
	 */
	public void destroy() {
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
