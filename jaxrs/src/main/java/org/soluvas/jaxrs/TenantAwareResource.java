package org.soluvas.jaxrs;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ReflectionUtils;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.commons.tenant.TenantInjection;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantServiceProxy;

import com.google.common.base.Supplier;

/**
 * JAX-RS Resource base class for {@link TenantRef}-aware
 * resources.
 * 
 * <p>Inspired by org.soluvas.web.site.ProxyTenantInjector.
 * 
 * <p>Usage:
 * 
 * <pre>{@literal
 * <bean id="personRsSys" class="id.co.bippo.person.rs.hand.PersonResourceSys"
 * 	destroy-method="destroy">
 * 	<argument ref="blueprintBundleContext" />
 * 	<argument value="${clientId}" />
 * 	<argument value="${tenantId}" />
 * 	<argument value="${tenantEnv}" />
 * </bean>
 * 
 * <bean id="rsList" class="java.util.ArrayList">
 * 	<argument>
 * 		<list>
 * 			<ref component-id="personRs" />
 * 		</list>
 * 	</argument>
 * </bean>
 * <service ref="rsList" auto-export="interfaces">
 * 	<service-properties>
 * 		<entry key="clientId" value="${clientId}" />
 * 		<entry key="tenantId" value="${tenantId}" />
 * 		<entry key="tenantEnv" value="${tenantEnv}" />
 * 		<entry key="type" value="jaxrs" />
 * 		<entry key="address" value="api" />
 * 	</service-properties>
 * </service>
 * }</pre>
 * 
 * @todo Inject dependencies using real objects, and use the {@link #destroy()} lifecycle to uninject.
 * @see TenantServiceProxy
 * @author rully
 */
public class TenantAwareResource {
	
	private static final Logger log = LoggerFactory
			.getLogger(TenantAwareResource.class);
	
	protected final TenantRef tenant;

	private final TenantInjection tenantInjection;
	
	/**
	 * @param bundleContext {@link BundleContext} of the tenant-scoped resource, usually {@code <argument ref="blueprintBundleContext" />}
	 *    in tenant-scoped resource Blueprint XML.
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 */
	public TenantAwareResource(final BundleContext bundleContext, final String clientId, final String tenantId, final String tenantEnv) {
		super();
		tenant = new TenantRef(clientId, tenantId, tenantEnv);
		injectSupplied(bundleContext, tenantId, tenantEnv);
		tenantInjection = new TenantInjection(bundleContext, tenantId, tenantEnv);
		injectDependencies(bundleContext, tenantId, tenantEnv);
		//injectProxies(bundleContext, tenantId, tenantEnv);
	}

	/**
	 * Perform injection of @{@link Supplied} objects.
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void injectSupplied(final BundleContext bundleContext,
			final String tenantId, final String tenantEnv) {
		final List <Field> suppliedFields = ReflectionUtils.getSuppliedFields(getClass());
		
		for (final Field field : suppliedFields) {
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final Class<?> suppliedClass = field.getType();
			
			log.trace("Field {}#{} needs Supplier<{}> for tenantId={} tenantEnv={} namespace={} filter: {}",
					this, field.getName(), suppliedClass.getName(), tenantId, tenantEnv, namespace, additionalFilter );
			final Supplied supplied = field.getAnnotation(Supplied.class);
			final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
			final String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + suppliedClassFilter + additionalFilter + ")";
			
			final Collection<ServiceReference<Supplier<?>>> serviceRefs;
			try {
				serviceRefs = (Collection) bundleContext.getServiceReferences(Supplier.class, filter);
			} catch (InvalidSyntaxException e) {
				throw new RuntimeException("Cannot inject " + this + "#" + field.getName() + ", invalid " +
						suppliedClass.getName() + " Supplier service with filter " + filter, e);
			}
			if (serviceRefs == null || serviceRefs.isEmpty()) {
				throw new RuntimeException("Cannot find " + suppliedClass.getName() + " supplier for " + this + "#" + field.getName() + ", " +
						"Supplier with " + filter + " not found");
			}
			final ServiceReference<Supplier<?>> serviceRef = serviceRefs.iterator().next();
			final Supplier<?> supplier = bundleContext.getService(serviceRef);
			try {
				final Object suppliedObj = supplier.get();
				log.trace("Injecting {}#{} as {}", this, field.getName(), suppliedObj);
				FieldUtils.writeField(field, this, suppliedObj, true);
			} catch (Exception e) {
				log.error("Cannot inject " + this + "#" + field.getName() + " from " + supplier, e);
				throw new RuntimeException("Cannot inject " + this + "#" + field.getName() + " from " + supplier, e);
			} finally {
				bundleContext.ungetService(serviceRef);
			}
		}
	}
	
	/**
	 * Perform injection of non-@{@link Supplied} @{@link Inject} fields
	 * using {@link TenantServiceProxy} (JDK Proxy for now, not CGLIB).
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 * @deprecated
	 */
	@Deprecated
	protected void injectProxies(final BundleContext bundleContext,
			final String tenantId, final String tenantEnv) {
		final List<Field> nonSuppliedFields = ReflectionUtils.getNonSuppliedFields(getClass());
		for (final Field field : nonSuppliedFields) {
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final Class<?> serviceClass = field.getType();
			
			log.trace("Field {}#{} will lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}",
					this, field.getName(), serviceClass.getName(), tenantId, tenantEnv, namespace, additionalFilter );
			final String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + additionalFilter + ")";
			
			final InvocationHandler invocationHandler = new TenantServiceProxy(bundleContext, this + "#" + field.getName(), serviceClass, filter);
			final Object proxy = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { serviceClass }, invocationHandler);
			log.trace("Injecting {}#{} as {}", this, field.getName(), invocationHandler);
			try {
				FieldUtils.writeField(field, this, proxy, true);
			} catch (Exception e) {
				log.error("Cannot inject " + this + "#" + field.getName() + " as " + invocationHandler, e);
				throw new RuntimeException("Cannot inject " + this + "#" + field.getName() + " as " + invocationHandler, e);
			}
		}
	}

	/**
	 * Perform injection of non-@{@link Supplied} @{@link Inject} fields
	 * using TenantInjection.
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	protected void injectDependencies(final BundleContext bundleContext,
			final String tenantId, final String tenantEnv) {
		tenantInjection.inject(this, toString(), "init");
	}

	protected void uninjectDependencies() {
		tenantInjection.uninject(this, toString(), "destroy");
	}
	
	/**
	 * Uninject dependencies.
	 */
	@PreDestroy
	public void destroy() {
		uninjectDependencies();
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [" + tenant.getTenantId() + "_" + tenant.getTenantEnv() + "]";
	}

}
