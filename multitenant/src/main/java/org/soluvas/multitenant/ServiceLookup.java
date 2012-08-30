package org.soluvas.multitenant;

import javax.annotation.Nonnull;

import org.apache.felix.service.command.CommandSession;

import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;

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

	public abstract <T, R> R withService(Class<? extends T> clazz, CommandSession commandSession, Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, @Nonnull String clientId, @Nonnull String tenantEnv,
			@Nonnull String tenantId, @Nonnull String namespace, Function<T, R> callback);

	public abstract <T, R> R withService(Class<? extends T> clazz, String filter, Function<T, R> callback);

	@Deprecated
	public abstract <T> void withService(Class<? extends T> clazz, CommandSession commandSession,
			FutureCallback<T> callback);

}