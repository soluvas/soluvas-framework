package org.soluvas.security;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.soluvas.commons.AggregatingSupplier;

import com.google.common.base.Supplier;

/**
 * @author ceefour
 *
 */
public class SecurityCatalogSupplierTracker implements
		ServiceTrackerCustomizer<Supplier<SecurityCatalog>, Supplier<SecurityCatalog>> {

	private final BundleContext bundleContext;
	private final AggregatingSupplier<SecurityCatalog> aggregator;

	public SecurityCatalogSupplierTracker(BundleContext bundleContext,
			AggregatingSupplier aggregator) {
		super();
		this.bundleContext = bundleContext;
		this.aggregator = aggregator;
	}

	@Override
	public Supplier<SecurityCatalog> addingService(
			ServiceReference<Supplier<SecurityCatalog>> reference) {
		Supplier<SecurityCatalog> supplier = bundleContext.getService(reference);
		aggregator.addSupplier(supplier);
		return supplier;
	}

	@Override
	public void modifiedService(
			ServiceReference<Supplier<SecurityCatalog>> reference,
			Supplier<SecurityCatalog> service) {
	}

	@Override
	public void removedService(
			ServiceReference<Supplier<SecurityCatalog>> reference,
			Supplier<SecurityCatalog> service) {
		aggregator.removeSupplier(service);
		bundleContext.ungetService(reference);
	}

}
