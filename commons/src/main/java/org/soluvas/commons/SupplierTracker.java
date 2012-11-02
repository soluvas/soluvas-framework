package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;

/**
 * Tracks {@link Supplier} services and manages the suppliers
 * in a {@link DelegatingSupplier}.
 * @author ceefour
 */
public class SupplierTracker<T extends EObject> implements
		ServiceTrackerCustomizer<Supplier<T>, Supplier<T>> {

	private transient Logger log = LoggerFactory
			.getLogger(SupplierTracker.class);
	private final BundleContext bundleContext;
	private final DelegatingSupplier<T> delegate;

	public SupplierTracker(BundleContext bundleContext,
			DelegatingSupplier<T> delegate) {
		super();
		this.bundleContext = bundleContext;
		this.delegate = delegate;
	}

	@Override
	public Supplier<T> addingService(
			ServiceReference<Supplier<T>> reference) {
		log.debug("Adding service {} from bundle {} [{}] with {}",
				reference.getProperty("objectClass"), reference.getBundle().getSymbolicName(),
				reference.getBundle().getBundleId(), reference.getPropertyKeys());
		Supplier<T> supplier = bundleContext.getService(reference);
		delegate.addSupplier(supplier);
		return supplier;
	}

	@Override
	public void modifiedService(
			ServiceReference<Supplier<T>> reference,
			Supplier<T> service) {
	}

	@Override
	public void removedService(
			ServiceReference<Supplier<T>> reference,
			Supplier<T> service) {
		log.debug("Removing service {} from bundle {} [{}] with {}",
				reference.getProperty("objectClass"), reference.getBundle().getSymbolicName(),
				reference.getBundle().getBundleId(), reference.getPropertyKeys());
		delegate.removeSupplier(service);
		bundleContext.ungetService(reference);
	}

}
