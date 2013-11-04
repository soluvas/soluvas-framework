package org.soluvas.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Tracks files named <tt>(bundle)/*.{suppliedClassSimpleName}.xmi</tt> and adds/removes
 * them from {@link DelegatingSupplier} (non-dynamic, scan is only performed once,
 * however the XMI files themselves can change and reloaded).
 * 
 * <p>This is a shortcut that's in effect equivalent to using an {@link XmiTracker} 
 * combined with {@link SupplierTracker}.
 * 
 * <p>Uses {@link OnDemandXmiLoader} instead of {@link StaticXmiLoader} so that
 * {@link AggregatingSupplier#reload()} works as intended.
 * 
 * <p>Usage:
 * 
 * <pre>{@literal
 * @Bean
 * public AggregatingSupplier<DataCatalog> dataCatalogSupplier() {
 * 	final AggregatingSupplier<DataCatalog> aggregator = new AggregatingSupplier<>(DataFactory.eINSTANCE,
 * 			DataPackage.Literals.DATA_CATALOG, ImmutableList.<Supplier<DataCatalog>>of());
 * 	final SupplierXmiClasspathScanner<DataCatalog> scanner = new SupplierXmiClasspathScanner<>(DataPackage.eINSTANCE, DataCatalog.class,
 * 			aggregator, SingleTenantDataConfig.class.getClassLoader(), dataFolder);
 * 	return aggregator;
 * }
 * }</pre>
 * 
 * @author ceefour
 */
public class SupplierXmiClasspathScanner<T extends EObject> {
	private final Logger log;
	private final EPackage ePackage;
	private final String suppliedClassName;
	private final String suppliedClassSimpleName;
	private final DelegatingSupplier<T> delegate;
	private final String packageToScan;
	private final ClassLoader classLoader;
	private final List<Supplier<T>> suppliers;
	
	/**
	 * Scan a specific class.
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SupplierXmiClasspathScanner(final EPackage ePackage, final Class<T> suppliedClass,
			final DelegatingSupplier<T> delegate, final Class<?> packageToScan) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.delegate = delegate;
		this.classLoader = packageToScan.getClassLoader();
		this.packageToScan = packageToScan.getPackage().getName();
		log = LoggerFactory.getLogger(SupplierXmiClasspathScanner.class.getName() + "." + suppliedClassSimpleName + "." + this.packageToScan);
		this.suppliers = addingBundle(classLoader, this.packageToScan);
	}
	
	/**
	 * Scan, in this order:
	 * <ol>
	 * 	<li>the entire org, com, and id classpath</li>
	 * 	<li>the {@code common} folder.</li>
	 * </ol>
	 * @param ePackage
	 * @param suppliedClass
	 * @param tenantId
	 * @param tenantEnv
	 * @todo Note that this is slow, but used for now to support lazy beans instantiation. Static or hybrid is preferable.
	 */
	public SupplierXmiClasspathScanner(final EPackage ePackage, final Class<T> suppliedClass,
			final DelegatingSupplier<T> delegate, final ClassLoader classLoader,
			final String dataFolder) {
		super();
		this.ePackage = ePackage;
		this.suppliedClassName = suppliedClass.getName();
		this.suppliedClassSimpleName = suppliedClass.getSimpleName();
		this.delegate = delegate;
		this.classLoader = classLoader;
		this.packageToScan = "classpath";
		log = LoggerFactory.getLogger(SupplierXmiClasspathScanner.class.getName() + "." + suppliedClassSimpleName);
		this.suppliers = scan(classLoader, dataFolder);
	}
	
	@PreDestroy
	public void destroy() {
		removedBundle(classLoader, packageToScan, suppliers);
	}

	@Nullable
	public List<Supplier<T>> scan(ClassLoader classLoader, String dataFolder) {
		final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		// Due to JDK limitation, scanning of root won't work in webapp classpath,
		// at least the root folder must be specified before wildcard
		final List<String> locationPatterns = ImmutableList.of("classpath*:org/**/*." + suppliedClassSimpleName + ".xmi",
				"classpath*:com/**/*." + suppliedClassSimpleName + ".xmi",
				"classpath*:id/**/*." + suppliedClassSimpleName +".xmi",
				"file:" + dataFolder + "/common/*." + suppliedClassSimpleName +".xmi");
		log.trace("Scanning {} for {}", classLoader, locationPatterns);
		try {
			final List<Resource> allResources = new ArrayList<>();
			for (String locationPattern : locationPatterns) {
				final Resource[] resources = resolver.getResources(locationPattern);
				allResources.addAll(ImmutableList.copyOf(resources));
			}
			log.info("Scanned {} returned {} resources: {}",
					locationPatterns, allResources.size(), allResources);
			final List<URL> xmiUrls = ImmutableList.copyOf(Lists.transform(
					allResources, new Function<Resource, URL>() {
				@Override @Nullable
				public URL apply(@Nullable Resource input) {
					try {
						return input.getURL();
					} catch (IOException e) {
						throw new CommonsException("Cannot get URL for " + input, e);
					}
				}
			}));
			final Map<String, List<Supplier<T>>> managedSuppliers = new HashMap<>();
			for (URL xmiUrl : xmiUrls) {
				final List<Supplier<T>> objs = Preconditions.checkNotNull(extractSuppliers(ImmutableList.of(xmiUrl)),
						"extractSuppliers from '%s' returned null", xmiUrl);
				managedSuppliers.put(xmiUrl.toString(), objs);
			}
			final List<Supplier<T>> scannedSuppliers = ImmutableList.copyOf(Iterables.concat(managedSuppliers.values()));
			return scannedSuppliers;
		} catch (IOException e) {
			throw new CommonsException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	@Nullable
	public List<Supplier<T>> addingBundle(ClassLoader classLoader, String pkg) {
		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		final Resource[] resources;
		try {
			log.debug("Scanning *.{}.xmi in classpath {}", suppliedClassSimpleName, pkg);
			resources = resolver.getResources(pkg.replace('.', '/') + "/*." + suppliedClassSimpleName + ".xmi");
			log.info("Scanned *.{}.xmi in classpath {} returned {} resources: {}",
					suppliedClassSimpleName, pkg, resources.length, resources);
			if (resources == null || resources.length == 0) {
				return null;
			}
		} catch (FileNotFoundException fnf) {
			log.warn("Requested to scan " + pkg + " for " + suppliedClassSimpleName +
					" but package not found in " + classLoader, fnf);
			return null;
		} catch (IOException e2) {
			log.error("Cannot scan " + pkg + " for " + suppliedClassSimpleName, e2);
			return null;
		}
		final List<URL> xmiUrls = ImmutableList.copyOf(Lists.transform(
				ImmutableList.copyOf(resources), new Function<Resource, URL>() {
			@Override @Nullable
			public URL apply(@Nullable Resource input) {
				try {
					return input.getURL();
				} catch (IOException e) {
					throw new CommonsException("Cannot get URL for " + input, e);
				}
			}
		}));
		return extractSuppliers(xmiUrls);
	}

	private List<Supplier<T>> extractSuppliers(final List<URL> xmiUrls) {
		final ImmutableList.Builder<Supplier<T>> suppliersBuilder = ImmutableList.builder();
		try {
			for (final URL resource : xmiUrls) {
				log.debug("Registering Supplier for {} from {}", suppliedClassName, resource);
				final Supplier<T> loader = new OnDemandXmiLoader<T>(ePackage, resource,
						ResourceType.CLASSPATH);
				delegate.addSupplier(loader);
				suppliersBuilder.add(loader);
			}
			final List<Supplier<T>> suppliers = suppliersBuilder.build();
			log.info("Registered {} {} suppliers from {}",
					suppliers.size(), suppliedClassSimpleName, xmiUrls);
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
			log.error("Cannot read " + xmiUrls + " for " + suppliedClassSimpleName, e);
			return null;
		}
	}

	public void removedBundle(ClassLoader classLoader, String pkg,
			@Nullable List<Supplier<T>> suppliers) {
		if (suppliers == null)
			return;
		log.debug("Unregistering {} {} suppliers from {}",
				suppliers.size(), suppliedClassSimpleName, pkg);
		for (final Supplier<T> supplier : suppliers) {
			try {
				delegate.removeSupplier(supplier);
			} catch (Exception e) {
				log.warn("Cannot unregister {} from {}", supplier, pkg);
			}
		}
		log.info("Unregistered {} {} suppliers from {}",
				suppliers.size(), suppliedClassSimpleName, pkg);
	}

}
