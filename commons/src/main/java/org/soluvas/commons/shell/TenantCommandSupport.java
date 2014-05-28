package org.soluvas.commons.shell;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.commons.locale.LocaleContext;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Shell command base class which supports Inject, {@link Namespace}, {@link Supplied}, {@link Filter}.  
 * @author ceefour
 * @deprecated Doesn't work well in Spring. Use {@link ExtCommandSupport} instead.
 */
@Deprecated
public abstract class TenantCommandSupport extends OsgiCommandSupport {

	/**
	 * Tenant for the currently executing {@link CommandSession}.
	 * May be {@literal null} if no session is executing.
	 */
	protected TenantRef tenant;
	/**
	 * @todo Proper locale support.
	 */
	protected LocaleContext localeContext = new LocaleContext();
	protected ShellProgressMonitor monitor;
	
	@Override
	public Object execute(final CommandSession session) throws Exception {
		tenant = TenantUtils.getTenant(session);
		monitor = new ShellProgressMonitorImpl();
		final Map<Field, ServiceReference<?>> serviceRefs = inject(session);
		try {
			return super.execute(session);
		} finally {
			uninject(serviceRefs);
			tenant = null;
		}
	}
	
	/**
	 * Perform injection.
	 * @param session 
	 * @return Injected {@link Field}s and associated {@link ServiceReference}s.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<Field, ServiceReference<?>> inject(final CommandSession session) {
		final TenantRef tenant = TenantUtils.getTenant(session);
		final String tenantId = tenant.getTenantId();
		final String tenantEnv = tenant.getTenantEnv();
		
		// List of get-ed services (to unget).
		final Map<Field, ServiceReference<?>> serviceRefs = new HashMap<>();

		Class<?> clazz = getClass();
		final ImmutableList.Builder<Field> fieldsBuilder = ImmutableList.builder();
		while (clazz != null) {
			fieldsBuilder.addAll(ImmutableList.copyOf(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		final List<Field> fields = fieldsBuilder.build();
		
		for (Field field : fields) {
			// Skip irrelevant fields
			final Inject injectAnn = field.getAnnotation(Inject.class);
			if (injectAnn == null)
				continue;
			
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final String componentId = getClass().getName();
			final Supplied supplied = field.getAnnotation(Supplied.class);
			if (supplied == null) {
				final Class serviceClass = field.getType();
				
				log.trace("Field {}#{} looking up {} for tenantId={} tenantEnv={} namespace={} filter: {}",
						componentId, field.getName(), serviceClass.getName(), tenantId, tenantEnv, namespace, additionalFilter );
				// HACK: disable tenantId/tenantEnv filtering due to tenantId services prematurely removed
//				final String filter = "(&" + String.format("(|(tenantId=%s)(tenantId=\\*))(|(tenantEnv=%s)(tenantEnv=\\*))",
//						tenantId, tenantEnv)
//					+ namespaceFilter + additionalFilter + ")";
				String filter = "(&" + namespaceFilter + additionalFilter + ")";
				if ("(&)".equals(filter)) {
					filter = null;
				}
				
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
					FieldUtils.writeField(field, this, bean, true);
					serviceRefs.put(field, serviceRef);
				} catch (Exception e) {
					bundleContext.ungetService(serviceRef);
					serviceRefs.remove(field);
					throw new CommonsException("Cannot set field " + componentId + "#" + field.getName() + " using " +
							serviceClass.getName() + " service with " + filter, e);
				}
			} else {
				final Class<?> suppliedClass = field.getType();
				log.trace("Field {}#{} needs Supplier<{}> for tenantId={} tenantEnv={} namespace={} filter: {}",
						componentId, field.getName(), suppliedClass.getName(), tenantId, tenantEnv, namespace, additionalFilter );
				final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
//				final String filter = "(&" + String.format("(|(tenantId=%s)(tenantId=\\*))(|(tenantEnv=%s)(tenantEnv=\\*))",
//						tenantId, tenantEnv)
//					+ namespaceFilter + suppliedClassFilter + additionalFilter + ")";
				String filter = "(&" + namespaceFilter + additionalFilter + ")";
				final Collection<ServiceReference<Supplier>> foundServiceRefs;
				try {
					foundServiceRefs = bundleContext.getServiceReferences(Supplier.class, filter);
				} catch (InvalidSyntaxException e) {
					throw new CommonsException("Cannot inject " + componentId + "#" + field.getName() + ", invalid " +
							suppliedClass.getName() + " Supplier service with filter " + filter, e);
				}
				if (foundServiceRefs == null || foundServiceRefs.isEmpty()) {
					throw new CommonsException("Cannot find " + suppliedClass.getName() + " supplier for " + componentId + "#" + field.getName() + ", " +
							"Supplier with " + filter + " not found");
				}
				final ServiceReference<Supplier> serviceRef = foundServiceRefs.iterator().next();
				final Supplier supplier = bundleContext.getService(serviceRef);
				try {
					final Object suppliedObj = supplier.get();
					log.trace("Injecting {}#{} as {}", componentId, field.getName(), suppliedObj);
					FieldUtils.writeField(field, this, suppliedObj, true);
				} catch (Exception e) {
					log.error("Cannot inject " + componentId + "#" + field.getName() + " from " + supplier, e);
					throw new CommonsException("Cannot inject " + componentId + "#" + field.getName() + " from " + supplier, e);
				} finally {
					bundleContext.ungetService(serviceRef);
				}
			}
		}

		return serviceRefs;
	}

	/**
	 * Uninjects injected fields.
	 * @param component
	 */
	protected void uninject(final Map<Field, ServiceReference<?>> serviceRefs) {
		final Iterator<Entry<Field, ServiceReference<?>>> serviceRefIterator = serviceRefs.entrySet().iterator();
		while (serviceRefIterator.hasNext()) {
			final Entry<Field, ServiceReference<?>> entry = serviceRefIterator.next();
			final Field field = entry.getKey();
			log.trace("Unsetting {}#{}", getClass().getName(), field.getName() );
			try {
				FieldUtils.writeField(field, this, null, true);
			} catch (Exception e) {
				log.warn("Cannot unset " + getClass().getName() + "#" + field.getName(), e);
			}
			bundleContext.ungetService(entry.getValue());
			serviceRefIterator.remove();
		}
	}
	
}
