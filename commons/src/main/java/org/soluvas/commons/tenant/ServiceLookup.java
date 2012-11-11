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
 * @author ceefour
 * @deprecated Just use {@link TenantUtils} or similar (for JAX-RS, Shell, Wicket, etc.)
 */
@Deprecated
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

	public abstract <T, R> R withService(Class<T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull Function<? extends T, R> callback);

	public abstract <T, R> R withService(Class<T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull String namespace, Function<? extends T, R> callback);

	public abstract <T, R, S extends T> R withService(Class<T> clazz, String filter, Function<S,R> callback);

	@Deprecated
	public <T, S extends T> void withService(@Nonnull Class<T> clazz, @Nonnull CommandSession commandSession, @Nonnull final FutureCallback<S> callback);

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service,
	 * with layer=application.
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

	public abstract <T> Set<String> getNamespaces(@Nonnull Class<T> iface, @Nonnull TenantRef tenant, @Nullable String filter);

}