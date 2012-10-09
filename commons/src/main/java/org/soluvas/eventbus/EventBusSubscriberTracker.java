package org.soluvas.eventbus;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;
import com.google.common.eventbus.EventBus;

/**
 * Tracks {@link EventBus} subscribers.
 * @author rudi
 */
public class EventBusSubscriberTracker implements ServiceTrackerCustomizer {

	private transient Logger log = LoggerFactory
			.getLogger(EventBusSubscriberTracker.class);
	private EventBus eventBus;
	
	public EventBusSubscriberTracker() {
		super();
	}
	
	public EventBusSubscriberTracker(EventBus eventBus) {
		super();
		this.eventBus = eventBus;
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#addingService(org.osgi.framework.ServiceReference)
	 */
	@Override
	public Object addingService(ServiceReference reference) {
		Supplier<?> supplier = (Supplier<?>)reference.getBundle().getBundleContext().getService(reference);
		try {
			Object subscriber = supplier.get();
			log.info("Registering {} to {}", subscriber, eventBus);
			eventBus.register(subscriber);
			return subscriber;
		} finally {
			reference.getBundle().getBundleContext().ungetService(reference);
		}
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#modifiedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void modifiedService(ServiceReference reference, Object service) {
	}

	/* (non-Javadoc)
	 * @see org.osgi.util.tracker.ServiceTrackerCustomizer#removedService(org.osgi.framework.ServiceReference, java.lang.Object)
	 */
	@Override
	public void removedService(ServiceReference reference, Object service) {
		log.info("Unregistering {} from {}", service, eventBus);
		eventBus.unregister(service);
	}

}
