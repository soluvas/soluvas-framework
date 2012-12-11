package org.soluvas.commons.tenant;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.ReflectionUtils;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;

import com.google.common.base.Throwables;

/**
 * Base implementation to injects {@link Inject} {@link TenantRef} services using lifecycle methods
 * inject and uninject.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TenantInjection implements Serializable {
	
	private static Logger log = LoggerFactory
			.getLogger(TenantInjection.class);
	private final BundleContext bundleContext;
	private final String tenantId;
	private final String tenantEnv;
	/**
	 * List of get-ed services (to unget).
	 */
	private final Map<Field, ServiceReference<?>> serviceRefs = new HashMap<Field, ServiceReference<?>>();
	
	/**
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	public TenantInjection(@Nonnull final BundleContext bundleContext,
			@Nonnull final String tenantId, @Nonnull final String tenantEnv) {
		super();
		this.bundleContext = bundleContext;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}
	
	/**
	 * Perform injection.
	 * @param component
	 * @param phase 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void inject(@Nonnull final Object component, @Nonnull final String componentId, @Nonnull final String phase) {
		final List<Field> nonSuppliedFields = ReflectionUtils.getNonSuppliedFields(component.getClass());
		for (final Field field : nonSuppliedFields) {
			try {
				Object currentValue = FieldUtils.readField(field, component, true);
				if (currentValue != null)
					continue;
			} catch (IllegalAccessException e) {
				Throwables.propagate(e);
				return;
			}
			
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final Class serviceClass = field.getType();
			
			log.trace("Field {}#{} looking up {} for tenantId={} tenantEnv={} namespace={} filter: {}",
					componentId, field.getName(), serviceClass.getName(), tenantId, tenantEnv, namespace, additionalFilter );
			final String filter = String.format("(&(|(tenantId=%s)(tenantId=\\*))(|(tenantEnv=%s)(tenantEnv=\\*))%s%s)",
					tenantId, tenantEnv, namespaceFilter, additionalFilter);
			
			final ServiceReference<?> serviceRef;
			try {
				final Collection<ServiceReference<?>> foundRefs = bundleContext.getServiceReferences(serviceClass, filter);
				if (foundRefs == null || foundRefs.isEmpty()) {
					throw new CommonsException("Cannot inject " + componentId + "#" + field.getName() + ", " +
							serviceClass.getName() + " service with " + filter + " not found");
				}
				serviceRef = foundRefs.iterator().next();
			} catch (InvalidSyntaxException e) {
				throw new CommonsException("Cannot inject " + componentId + "#" + field.getName() + ", invalid " +
						serviceClass.getName() + " service with " + filter);
			}
			final Object bean = bundleContext.getService(serviceRef);
			try {
				log.trace("Injecting {}#{} as {}", componentId, field.getName(), bean);
				FieldUtils.writeField(field, component, bean, true);
				serviceRefs.put(field, serviceRef);
			} catch (Exception e) {
				bundleContext.ungetService(serviceRef);
				serviceRefs.remove(field);
				throw new CommonsException("Cannot set field " + componentId + "#" + field.getName() + " using " +
						serviceClass.getName() + " service with " + filter, e);
			}
		}
		if (!serviceRefs.isEmpty()) {
			log.debug("Injected {} services to {} in {}", serviceRefs.size(), componentId, phase);
		}
	}
	
	/**
	 * Uninjects injected fields.
	 * @param component
	 * @param phase 
	 */
	public void uninject(@Nonnull final Object component, @Nonnull final String componentId, @Nonnull final String phase) {
		if (!serviceRefs.isEmpty()) {
			log.debug("Uninjecting {} services from {} due to {}", serviceRefs.size(), componentId, phase);
			final Iterator<Entry<Field, ServiceReference<?>>> serviceRefIterator = serviceRefs.entrySet().iterator();
			while (serviceRefIterator.hasNext()) {
				final Entry<Field, ServiceReference<?>> entry = serviceRefIterator.next();
				final Field field = entry.getKey();
				log.trace("Unsetting {}#{}", componentId, field.getName() );
				try {
					FieldUtils.writeField(field, component, null, true);
				} catch (Exception e) {
					log.warn("Cannot unset " + componentId + "#" + field.getName(), e);
				}
				bundleContext.ungetService(entry.getValue());
				serviceRefIterator.remove();
			}
		}
	}

}
