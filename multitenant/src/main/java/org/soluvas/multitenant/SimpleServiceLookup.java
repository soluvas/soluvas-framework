package org.soluvas.multitenant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nonnull;

import org.apache.felix.service.command.CommandSession;

/**
 * @author ceefour
 * @deprecated
 */
@Deprecated
public abstract class SimpleServiceLookup<T> implements ServiceLookup {
	
	private final Map<LookupKey, T> services;
	
	public SimpleServiceLookup() {
		super();
		services = new ConcurrentHashMap<LookupKey, T>();
	}
	
	public SimpleServiceLookup(Map<LookupKey, T> services) {
		super();
		this.services = services;
	}

	@Override
	public TenantRef getTenant(@Nonnull CommandSession session) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.multitenant.LookupService#lookup(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.common.base.Function)
	 */
//	@Override
//	public <R> R lookup(String clientId, String tenantEnv, String tenantId, String namespace,
//			Function<T, R> callback) {
//		LookupKey lookupKey = new LookupKey(clientId, tenantEnv, tenantId, namespace);
//		T service = services.get(lookupKey);
//		return callback.apply(service);
//	}

}
