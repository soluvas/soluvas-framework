package org.soluvas.commons;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;
import com.google.common.eventbus.EventBus;

/**
 * Tracks {@link EventBus} subscribers.
 * 
 * EventBus service:
 * 
 * <pre>{@code
 * <bean id="eventBus" class="com.google.common.eventbus.EventBus">
 * 		<argument value="berbatik_dev"/>
 * 	</bean>
 * 	<service ref="eventBus" auto-export="all-classes">
 * 		<service-properties>
 * 			<entry key="clientId" value="berbatik"/>
 * 			<entry key="tenantEnv" value="dev"/>
 * 			<entry key="tenantId" value="berbatik"/>
 * 			<entry key="namespace" value=""/>
 * 		</service-properties>
 * 	</service>
 * 	<bean class="org.osgi.util.tracker.ServiceTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext"/>
 * 		<argument>
 * 			<bean class="org.osgi.framework.FrameworkUtil" factory-method="createFilter">
 * 				<argument value="(&amp;(objectClass=com.google.common.base.Supplier)(tenantId=berbatik)(tenantEnv=dev)(type=eventbus))"/>
 * 			</bean>
 * 		</argument> 
 * 		<argument>
 * 			<bean class="org.soluvas.eventbus.EventBusSubscriberTracker">
 * 				<argument ref="eventBus" />
 * 			</bean>
 * 		</argument>
 * 	</bean>
 * }</pre>
 * 
 * Registering subscriber:
 * 
 * <pre>{@code
 * <service auto-export="interfaces">
 * 		<service-properties>
 * 			<entry key="type" value="eventbus"/>
 * 			<entry key="clientId" value="berbatik"/>
 * 			<entry key="tenantId" value="berbatik"/>
 * 			<entry key="tenantEnv" value="dev"/>
 * 		</service-properties>
 * 		<bean class="com.google.common.base.Suppliers" factory-method="ofInstance">
 * 			<argument>
 * 				<bean class="tmp.test.subscriber.TestSubscriber" />
 * 			</argument>
 * 		</bean>
 * 	</service>
 * }</pre>
 * 
 * Consuming EventBus:
 * 
 * <pre>{@code
 * <reference id="eventBus" interface="com.google.common.eventbus.EventBus"
 * 		filter="(&amp;(tenantId=berbatik)(tenantEnv=dev))"/>
 * }</pre>
 * 
 * See also {@literal README.textile} for more info.
 * 
 * @author rudi
 */
public class EventBusSubscriberTracker implements ServiceTrackerCustomizer {

	private static final Logger log = LoggerFactory
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
		final Supplier<?> supplier = (Supplier<?>)reference.getBundle().getBundleContext().getService(reference);
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
