package org.soluvas.multitenant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Function;

/**
 * @author ceefour
 * @deprecated
 */
public abstract class SimpleServiceLookup<T> implements ServiceLookup {
	
	private Map<LookupKey, T> services;
	
	public SimpleServiceLookup() {
		super();
		services = new ConcurrentHashMap<LookupKey, T>();
	}
	
	public SimpleServiceLookup(Map<LookupKey, T> services) {
		super();
		this.services = services;
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
