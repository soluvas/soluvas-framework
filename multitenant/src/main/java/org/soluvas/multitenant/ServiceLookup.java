package org.soluvas.multitenant;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.felix.service.command.CommandSession;
import org.osgi.framework.ServiceReference;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.FutureCallback;

/**
 * Looks up a service.
 * 
 * @author ceefour
 */
public interface ServiceLookup {

	/**
	 * Lookup the service. In OSGi environments or when looking up a service requires to access
	 * a resource, after the callback is called the resource will be closed properly.
	 * @param clientId
	 * @param tenantEnv
	 * @param tenantId
	 * @param namespace
	 * @param callback
	 * @return
	 */
	public abstract <T, R> R withService(Class<? extends T> clazz, CommandSession commandSession, String namespace,
			Function<T, R> callback);

	/**
	 * Lookup the service. In OSGi environments or when looking up a service
	 * requires to access a resource, after the callback is called the resource
	 * will be closed properly.
	 * 
	 * @param clientId
	 * @param tenantEnv
	 * @param tenantId
	 * @param namespace
	 * @param callback
	 * @return
	 */
	public abstract <T, R> R withService(Class<? extends T> clazz,
			CommandSession commandSession, String namespace, String filter,
			Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, CommandSession commandSession, Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull String namespace, Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, String filter, Function<T, R> callback);

	@Deprecated
	public abstract <T> void withService(Class<? extends T> clazz, CommandSession commandSession,
			FutureCallback<T> callback);

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service.
	 * 
	 * @param clazz
	 * @return
	 */
	public <T> T getSupplied(@Nonnull Class<T> clazz,
			CommandSession commandSession);

	public abstract <T> ServiceReference<T> getService(@Nonnull Class<T> iface,
			@Nonnull CommandSession session, @Nullable String namespace,
			@Nullable String filter);

	public abstract TenantRef getTenant(@Nonnull CommandSession session);

}