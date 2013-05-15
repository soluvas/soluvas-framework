package org.soluvas.commons.tenant;

import java.util.Set;

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
 * Just use {@link TenantUtils} or similar (for JAX-RS, Shell, Wicket, etc.). ServiceLookup is used internally
 * by {@link TenantUtils}.
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
	public abstract <T, R> R withService(Class<T> clazz, CommandSession commandSession, String namespace,
			Function<? extends T, R> callback);

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
	public abstract <T, R> R withService(Class<T> clazz,
			CommandSession commandSession, String namespace, String filter,
			Function<? extends T, R> callback);

	public abstract <T, R> R withService(Class<T> clazz, CommandSession commandSession, Function<? extends T, R> callback);

	public abstract <T, R> R withService(Class<T> clazz, String clientId, String tenantEnv,
			String tenantId, Function<? extends T, R> callback);

	public abstract <T, R> R withService(Class<T> clazz, String clientId, String tenantEnv,
			String tenantId, String namespace, Function<? extends T, R> callback);

	public abstract <T, R, S extends T> R withService(Class<T> clazz, String filter, Function<S,R> callback);

	@Deprecated
	public <T, S extends T> void withService(Class<T> clazz, CommandSession commandSession, final FutureCallback<S> callback);

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service,
	 * with layer=application.
	 * 
	 * @param clazz
	 * @return
	 */
	public <T> T getSupplied(Class<T> clazz,
			CommandSession commandSession);

	public abstract <T> ServiceReference<T> getService(Class<T> iface,
			CommandSession session, @Nullable String namespace,
			@Nullable String filter);

	public abstract TenantRef getTenant(CommandSession session);

	public abstract <T> Set<String> getNamespaces(Class<T> iface, TenantRef tenant, @Nullable String filter);

}