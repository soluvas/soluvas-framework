package org.soluvas.commons;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

/**
 * Generic EMF Unloader.
 * 
 * Usage for single package:
 * 
 * <pre>
 * {@code
 * <bean class="org.soluvas.commons.EmfUnloader" destroy-method="destroy">
 * 	<argument value="org.soluvas.security.SecurityPackage" />
 * </bean>
 * }
 * </pre>
 * 
 * Usage for multiple packages:
 * 
 * <pre>{@code
 * <bean class="org.soluvas.commons.EmfUnloader" init-method="init" destroy-method="destroy">
 * 	<argument ref="blueprintBundleContext" />
 * 	<argument>
 * 		<list value-type="java.lang.Class">
 * 			<value>org.soluvas.web.site.SitePackage</value>
 * 			<value>org.soluvas.web.site.pagemeta.PageMetaPackage</value>
 * 			<value>org.soluvas.web.site.webaddress.WebaddressPackage</value>
 * 		</list>
 * 	</argument>
 * </bean>
 * }</pre>
 * 
 * @author ceefour
 */
public class EmfUnloader {

	private transient Logger log = LoggerFactory.getLogger(EmfUnloader.class);
	private final Iterable<Class<EPackage>> packages;
	private final BundleContext bundleContext;
	private final List<ServiceRegistration<?>> svcRegs = new ArrayList<ServiceRegistration<?>>();
	
	@Deprecated
	public EmfUnloader(Class<? extends EPackage> pkg) {
		this(null, pkg);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Deprecated
	public EmfUnloader(Class... packages) {
		super();
		this.bundleContext = null;
		this.packages = ImmutableList.copyOf((Class<EPackage>[]) packages);
	}
	
	public EmfUnloader(BundleContext bundleContext, Class<EPackage> pkg) {
		super();
		this.bundleContext = bundleContext;
		this.packages = ImmutableList.of(pkg);
	}

	@SuppressWarnings("unchecked")
	public EmfUnloader(BundleContext bundleContext, Iterable<?> packageClasses) {
		super();
		this.bundleContext = bundleContext;
		this.packages = (Iterable<Class<EPackage>>) packageClasses;
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
