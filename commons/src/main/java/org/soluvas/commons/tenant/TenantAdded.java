package org.soluvas.commons.tenant;

import org.soluvas.commons.AppManifest;

/**
 * @author rudi
 *
 */
public class TenantAdded {
	
	private final String tenantId;
	private final AppManifest upAppManifest;
	private final ProvisionData provisionData;
	private final String trackingId;
	
	public TenantAdded(String tenantId, AppManifest upAppManifest, ProvisionData provisionData, String trackingId) {
		super();
		this.tenantId = tenantId;
		this.upAppManifest = upAppManifest;
		this.provisionData = provisionData;
		this.trackingId = trackingId;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @return the upAppManifest
	 */
	public AppManifest getUpAppManifest() {
		return upAppManifest;
	}

	/**
	 * @return the provisionData
	 */
	public ProvisionData getProvisionData() {
		return provisionData;
	}

	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}
	
}
