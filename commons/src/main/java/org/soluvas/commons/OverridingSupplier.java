package org.soluvas.commons;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Override contents of {@link EObject} {@link Supplier}s.
 * The top-level EObject (usually some form of Catalog) which has larger {@literal positioner} will "sink",
 * thus overriding the EObject before.
 * 
 * Usage:
 * 
 * <pre>{@literal
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
 * 	<bean id="bannerCatalogXmiTracker" class="org.soluvas.commons.XmiTracker">
 * 		<argument value="org.soluvas.web.banner.BannerPackage" />
 * 		<argument value="org.soluvas.web.banner.BannerCatalog" />
 * 		<argument value="${tenantId}" />
 * 		<argument value="${tenantEnv}" />
 * 	</bean>
 * 	<bean class="org.osgi.util.tracker.BundleTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument value="32" />
 * 		<argument ref="bannerCatalogXmiTracker" />
 * 	</bean>
 * }</pre>
 * 
 * @todo Support for propagating EMF Notify changes.
 * @author ceefour
 */
public class OverridingSupplier<T extends EObject> implements Supplier<T>, DelegatingSupplier<T> {

	private static final Logger log = LoggerFactory
			.getLogger(OverridingSupplier.class);
	private final EClass eClass;
	/**
	 * Maps a supplier with the {@link EObject}s it contains.
	 * Note that keys are <strong>copied</strong> objects, not original objects from suppliers.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final SortedMap<T, Supplier<T>> sources = Maps.synchronizedNavigableMap(Maps.newTreeMap(new PositionerComparator()));

	public OverridingSupplier(EFactory eFactory, EClass eClass,
			List<Supplier<T>> suppliers) {
		super();
		this.eClass = eClass;
		log.info("Initializing overriding supplier for {} with {} suppliers",
				eClass.getName(), suppliers.size());
		for (final Supplier<T> supplier : suppliers) {
			addSupplier(supplier);
		}
	}
	
	public OverridingSupplier(EPackage ePackage, String eClassName, List<Supplier<T>> suppliers) {
		this(ePackage.getEFactoryInstance(), (EClass) ePackage.getEClassifier(eClassName), suppliers);
	}
	
	@Override @PreDestroy
	public void destroy() {
		removeSuppliers(ImmutableList.copyOf(sources.values()));
	}
	
	@Override
	public void addSupplier(Supplier<T> supplier) {
		log.debug("Adding supplier {} for {}", supplier, eClass.getName());
		sources.put(supplier.get(), supplier);
		log.info("Added supplier {} for {}, now {} suppliers", supplier, eClass.getName(), sources.size());
	}

	@Override
	public void removeSupplier(Supplier<T> supplier) {
		log.debug("Removing supplier {} for {}", supplier, eClass.getName());
		doRemoveSuppliers(ImmutableList.of(supplier));
		log.info("Removed supplier {} for {}, now {} suppliers", supplier, eClass.getName(), sources.size());
	}

	protected void removeSuppliers(Collection<Supplier<T>> removedSuppliers) {
		log.debug("Removing suppliers {} for {}", removedSuppliers, eClass.getName());
		doRemoveSuppliers(removedSuppliers);
		log.info("Removed suppliers {} for {}, now {} suppliers", removedSuppliers, eClass.getName(), sources.size());
	}

	protected void doRemoveSuppliers(Collection<Supplier<T>> removedSuppliers) {
		int removedCount = 0;
		Iterator<Entry<T, Supplier<T>>> iterator = sources.entrySet().iterator();
		while (iterator.hasNext()) {
			final Entry<T, Supplier<T>> entry = iterator.next();
			if (removedSuppliers.contains( entry.getValue() )) {
				iterator.remove();
				removedCount++;
			}
			if (removedCount >= removedSuppliers.size())
				break;
		}
	}

	/**
	 * Return a copy of the bottommest source's Catalog (an {@link EObject}) according to the {@literal positioner}.
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
	public T get() {
		Preconditions.checkState(!sources.isEmpty(), "No suppliers provided for %s", eClass.getName());
		final T bottommost = sources.lastKey();
		return bottommost;
	}

}
