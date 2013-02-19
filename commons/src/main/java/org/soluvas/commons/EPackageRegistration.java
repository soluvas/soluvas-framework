package org.soluvas.commons;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.ClassUtils;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
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
	public EPackageRegistration(@Nonnull final BundleContext bundleContext, @Nonnull Iterable<?> packageClasses) {
		super();
		this.bundleContext = bundleContext;
		this.packages = ImmutableList.copyOf(Iterables.transform(packageClasses, new Function<Object, Class<EPackage>>() {
			@Override
			@Nullable
			public Class<EPackage> apply(@Nullable Object input) {
				if (input instanceof Class) {
					return (Class<EPackage>) input;
				} else if (input instanceof String) {
					try {
						return (Class<EPackage>) bundleContext.getBundle().loadClass((String) input);
					} catch (ClassNotFoundException e) {
						throw new IllegalArgumentException("Cannot load EPackage class " + input, e);
					}
				} else
					throw new IllegalArgumentException("Unrecognized EPackage class: " + input);
			}
		}));
	}

	/**
	 * Call this to register the {@link EPackage}s.
	 */
	public void init() {
		for (final Class<? extends EPackage> pkg : packages) {
			try {
				log.trace("Registering EPackage {}", pkg.getName());
				final EPackage ePackage = EmfUtils.getEPackage(pkg);
				EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
				log.debug("Registered EPackage {}, global registry now has {} entries",
						pkg.getName(), EPackage.Registry.INSTANCE.size());
				
				final List<Class<?>> ePackageInterfaces = ClassUtils.getAllInterfaces(ePackage.getClass());
				final List<String> ePackageInterfaceNames = Lists.transform( ePackageInterfaces, new ClassToName());
				final Dictionary<String, Object> svcProps = new Hashtable<String, Object>();
				svcProps.put("name", ePackage.getName());
				svcProps.put("nsURI", ePackage.getNsURI());
				svcProps.put("nsPrefix", ePackage.getNsPrefix());
				final ServiceRegistration<?> reg = bundleContext.registerService(ePackageInterfaceNames.toArray(new String[] {}),
						ePackage, svcProps);
				log.trace("Registered EPackage service {} using {}", reg, ePackageInterfaceNames);
				pkgRegs.add(reg);
				
				final EFactory eFactory = Preconditions.checkNotNull(ePackage.getEFactoryInstance(),
					"Cannot get EFactory for EPackage %s [%s]",
					ePackage.getName(), ePackage.getNsURI());
				final List<Class<?>> eFactoryInterfaces = ClassUtils.getAllInterfaces(eFactory.getClass());
				final List<String> eFactoryInterfaceNames = Lists.transform( eFactoryInterfaces, new ClassToName());
				final ServiceRegistration<?> factoryReg = bundleContext.registerService(eFactoryInterfaceNames.toArray(new String[] {}),
						eFactory, svcProps);
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
				EPackage.Registry.INSTANCE.remove(packageNsUri);
				log.debug("Unregistered EMF Package {} by {}, global registry now has {} entries",
						packageNsUri, pkg.getName(), EPackage.Registry.INSTANCE.size());
			} catch (Exception e) {
				log.error("Cannot unload EMF Package " + pkg.getName(), e);
			}
		}
	}

}
