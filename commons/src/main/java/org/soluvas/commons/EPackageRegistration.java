package org.soluvas.commons;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Generic EMF Unloader.
 * 
 * Usage for single package:
 * 
 * <pre>
 * {@code
 * <bean class="org.soluvas.commons.EPackageRegistration" destroy-method="destroy">
 * 	<argument value="org.soluvas.security.SecurityPackage" />
 * </bean>
 * }
 * </pre>
 * 
 * Usage for multiple packages:
 * 
 * <pre>{@code
 * <bean class="org.soluvas.commons.EPackageRegistration" init-method="init" destroy-method="destroy">
 * 	<argument ref="blueprintBundleContext" />
 * 	<argument>
 * 		<list value-type="java.lang.Class">
 * 			<value>org.soluvas.web.site.SitePackage</value>
 * 			<value>org.soluvas.web.site.pagemeta.PagemetaPackage</value>
 * 			<value>org.soluvas.web.site.webaddress.WebaddressPackage</value>
 * 		</list>
 * 	</argument>
 * </bean>
 * }</pre>
 * 
 * @author ceefour
 */
public class EPackageRegistration {

	public static final class ClassToName implements Function<Class<?>, String> {
		@Override
		@Nullable
		public String apply(@Nullable Class<?> input) {
			return input.getName();
		}
	}

	private static final Logger log = LoggerFactory.getLogger(EPackageRegistration.class);
	private final Iterable<Class<EPackage>> packages;
	@Nonnull
	private final BundleContext bundleContext;
	private final List<ServiceRegistration<?>> pkgRegs = new ArrayList<ServiceRegistration<?>>();
	private final List<ServiceRegistration<?>> factoryRegs = new ArrayList<ServiceRegistration<?>>();
	
	public EPackageRegistration(@Nonnull BundleContext bundleContext, @Nonnull Class<EPackage> pkg) {
		super();
		this.bundleContext = bundleContext;
		this.packages = ImmutableList.of(pkg);
	}

	@SuppressWarnings("unchecked")
	public EPackageRegistration(@Nonnull BundleContext bundleContext, @Nonnull Iterable<?> packageClasses) {
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
				
				List<String> pkgInterfaces = Lists.transform( ImmutableList.copyOf(ePackage.getClass().getInterfaces()), new ClassToName());
				ServiceRegistration<?> reg = bundleContext.registerService(pkgInterfaces.toArray(new String[] {}),
						ePackage, new Hashtable<String, Object>());
				log.trace("Registered EPackage service {}", reg);
				pkgRegs.add(reg);
				
				EFactory eFactory = ePackage.getEFactoryInstance();
				Preconditions.checkNotNull(eFactory, "Cannot get EFactory for EPackage %s [%s]", ePackage.getName(), ePackage.getNsURI());
				List<String> factoryInterfaces = Lists.transform( ImmutableList.copyOf(eFactory.getClass().getInterfaces()), new ClassToName());
				ServiceRegistration<?> factoryReg = bundleContext.registerService(factoryInterfaces.toArray(new String[] {}),
						eFactory, new Hashtable<String, Object>());
				log.trace("Registered EFactory service {}", factoryReg);
				factoryRegs.add(factoryReg);
			} catch (Exception e) {
				log.error("Cannot register EPackage " + pkg.getName(), e);
			}
		}
	}

	/**
	 * Call this to unload the {@link EPackage}s and {@link EFactory}s.
	 */
	public void destroy() {
		for (ServiceRegistration<?> reg : factoryRegs) {
			log.trace("Unregistering EFactory service {}", reg);
			reg.unregister();
		}
		factoryRegs.clear();

		for (ServiceRegistration<?> reg : pkgRegs) {
			log.trace("Unregistering EPackage service {}", reg);
			reg.unregister();
		}
		pkgRegs.clear();
		
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
