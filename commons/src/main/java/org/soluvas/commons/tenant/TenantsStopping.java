package org.soluvas.commons.tenant;

import org.soluvas.commons.AppManifest;
import org.soluvas.push.TrackableEvent;

import com.google.common.collect.ImmutableMap;

/**
 * Used by {@link TenantRepository}, handled by {@link TenantRepositoryListener}.
 * @author ceefour
 * @see TenantRepositoryListener
 * @see TenantRepository
 */
public class TenantsStopping extends TrackableEvent {

	private static final long serialVersionUID = 1L;
	
	private final ImmutableMap<String, AppManifest> tenants;

	/**
	 * @param trackingId
	 */
	public TenantsStopping(ImmutableMap<String, AppManifest> tenants, String trackingId) {
		super(trackingId);
		this.tenants = tenants;
	}
	
	public ImmutableMap<String, AppManifest> getTenants() {
		return tenants;
	}

}
