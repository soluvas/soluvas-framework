package org.soluvas.multitenant;

import javax.annotation.Nonnull;

import org.apache.felix.service.command.CommandSession;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
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
public class MultitenantServiceLookup implements ServiceTrackerCustomizer, ServiceLookup {
	
	private transient Logger log = LoggerFactory.getLogger(MultitenantServiceLookup.class);
	private BundleContext bundleContext;
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
			public Void apply(T input) {
				callback.onSuccess(input);
				return null;
			};
		});
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz, String filter, Function<T, R> callback) {
		try {
			ServiceReference[] refs = bundleContext.getServiceReferences(clazz.getName(), filter);
			if (refs == null || refs.length <= 0)
				throw new RuntimeException(String.format("Cannot find service %s for filter %s",
						clazz, filter));
			ServiceReference ref = refs[0];
			T svc = (T) bundleContext.getService(ref);
			try {
				R result = callback.apply(svc);
				return result;
			} finally {
				bundleContext.ungetService(ref);
			}
		} catch (Exception e) {
			log.error(String.format("Cannot find service %s for filter %s",
						clazz, filter), e);
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
	public <T, R> R withService(Class<? extends T> clazz, CommandSession commandSession, Function<T, R> callback) {
		String clientId = Optional.fromNullable( (String) commandSession.get("clientId") ).or(defaultClientId);
		String tenantEnv = Optional.fromNullable( (String) commandSession.get("tenantEnv") ).or(defaultTenantEnv);
		String tenantId = Optional.fromNullable( (String) commandSession.get("tenantId") ).or(defaultClientId);
		return withService(clazz, clientId, tenantEnv, tenantId, callback);
	}

	@Override
	public <T, R> R withService(Class<? extends T> clazz, CommandSession commandSession, String namespace, Function<T, R> callback) {
		String clientId = Optional.fromNullable( (String) commandSession.get("clientId") ).or(defaultClientId);
		String tenantEnv = Optional.fromNullable( (String) commandSession.get("tenantEnv") ).or(defaultTenantEnv);
		String tenantId = Optional.fromNullable( (String) commandSession.get("tenantId") ).or(defaultClientId);
		return withService(clazz, clientId, tenantEnv, tenantId, namespace, callback);
	}

	@Override
	public Object addingService(ServiceReference reference) {
		return null;
	}

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
	}

}
