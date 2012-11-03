package org.soluvas.commons.tenant;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.felix.service.command.CommandSession;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.FutureCallback;

/**
 * Provides helper to lookup multitenant-aware services in the OSGi runtime.
 * 
 * Also {@link ServiceTrackerCustomizer} to put clientId, tenantId, and tenantEnv default settings.
 *  
 * @author ceefour
 * @version 1.1
 */
public class MultitenantServiceLookup implements ServiceLookup {
	
	private transient Logger log = LoggerFactory.getLogger(MultitenantServiceLookup.class);
	private final BundleContext bundleContext;
	private final String defaultTenantEnv = "dev";
	private final String defaultClientId = "berbatik";
	
	public MultitenantServiceLookup(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
	}

	@Deprecated
	@Override
	public <T> void withService(Class<? extends T> clazz, CommandSession commandSession, final FutureCallback<T> callback) {
		withService(clazz, commandSession, new Function<T, Void>() {
			@Override
			public Void apply(T input) {
				callback.onSuccess(input);
				return null;
			};
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, R> R withService(Class<? extends T> clazz, String filter, Function<T, R> callback) {
		try {
			ServiceReference<T>[] refs = (ServiceReference<T>[]) bundleContext
					.getServiceReferences(clazz.getName(), filter);
			if (refs == null || refs.length <= 0)
				throw new RuntimeException(String.format("Cannot find service %s for filter %s",
						clazz, filter));
			ServiceReference<T> ref = refs[0];
			T svc = bundleContext.getService(ref);
			try {
				R result = callback.apply(svc);
				return result;
			} finally {
				bundleContext.ungetService(ref);
			}
		} catch (Exception e) {
			log.error(String.format("Cannot find service %s for filter %s",
						clazz.getName(), filter), e);
			Throwables.propagate(e);
			return null;
		}
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv, 
			@Nonnull String tenantId, @Nonnull String namespace, Function<T, R> callback) {
		final String filter = String.format("(&(clientId=%s)(tenantId=%s)(tenantEnv=%s)(namespace=%s))",
				clientId, tenantId, tenantEnv, namespace);
		return withService(clazz, filter, callback);
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv, 
			@Nonnull String tenantId, @Nonnull Function<T, R> callback) {
		final String filter = String.format("(&(clientId=%s)(tenantId=%s)(tenantEnv=%s))",
				clientId, tenantId, tenantEnv);
		return withService(clazz, filter, callback);
	}

	@Override
	public <T, R> R withService(@Nonnull Class<? extends T> clazz,
			@Nonnull CommandSession commandSession, @Nullable String namespace,
			@Nullable String filter, Function<T, R> callback) {
		TenantRef tenant = getTenant(commandSession);
		final String realFilter = String.format(
				"(&(clientId=%s)(tenantId=%s)(tenantEnv=%s)%s%s)", tenant
						.getClientId(), tenant.getTenantId(), tenant
						.getTenantEnv(),
				!Strings.isNullOrEmpty(namespace) ? "(namespace=" + namespace
						+ ")" : "", Optional.fromNullable(filter).or(""));
		return withService(clazz, realFilter, callback);
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz,
			CommandSession commandSession, Function<T, R> callback) {
		return withService(clazz, commandSession, null, null, callback);
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz,
			CommandSession commandSession, String namespace,
			Function<T, R> callback) {
		return withService(clazz, commandSession, namespace, null, callback);
	}

	/**
	 * Get {@link TenantRef} for provided {@link CommandSession}.
	 * 
	 * @return
	 */
	@Override
	public TenantRef getTenant(@Nonnull CommandSession session) {
		String clientId = Optional.fromNullable(
				(String) session.get("clientId")).or(defaultClientId);
		String tenantEnv = Optional.fromNullable(
				(String) session.get("tenantEnv")).or(defaultTenantEnv);
		String tenantId = Optional.fromNullable(
				(String) session.get("tenantId")).or(defaultClientId);
		return new TenantRef(clientId, tenantId, tenantEnv);
	}

	/**
	 * Get OSGi {@link ServiceReference} scoped to the provided
	 * {@link CommandSession}.
	 * 
	 * @param iface
	 * @param namespace
	 * @param filter
	 * @return
	 */
	@Override
	public <T> ServiceReference<T> getService(@Nonnull Class<T> iface,
			@Nonnull CommandSession session, @Nullable String namespace,
			@Nullable String filter) {
		BundleContext bundleContext = FrameworkUtil.getBundle(
				MultitenantServiceLookup.class).getBundleContext();

		TenantRef tenant = getTenant(session);

		final String className = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		log.trace(
				"Lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}",
				new Object[] { className, tenant.getTenantId(),
						tenant.getTenantEnv(), namespace,
						additionalFilter });
		final String namespaceFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace="
				+ namespace + ")"
				: "";
		String realFilter = "(&(tenantId=" + tenant.getTenantId()
				+ ")(tenantEnv=" + tenant.getTenantEnv() + ")"
				+ namespaceFilter + additionalFilter + ")";

		ServiceReference<T> serviceRef = null;
		try {
			Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty())
				throw new RuntimeException("Cannot find " + className
						+ " service with filter " + realFilter);
			serviceRef = foundRefs.iterator().next();
			return serviceRef;
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException("Cannot find " + className
					+ " service with filter " + realFilter, e);
		}
	}

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service.
	 * 
	 * @param clazz
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getSupplied(@Nonnull Class<T> clazz, CommandSession session) {
		ServiceReference<Supplier> supplierRef = getService(Supplier.class,
				session, null, "(suppliedClass=" + clazz.getName() + ")(layer=application)");
		BundleContext bundleContext = FrameworkUtil.getBundle(
				MultitenantServiceLookup.class).getBundleContext();
		Supplier<T> supplier = bundleContext.getService(supplierRef);
		try {
			return supplier.get();
		} finally {
			bundleContext.ungetService(supplierRef);
		}
	}

}
