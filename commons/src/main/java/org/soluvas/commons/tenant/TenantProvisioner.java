package org.soluvas.commons.tenant;

import java.util.Set;

import org.soluvas.commons.AppManifest;

/**
 * A provisioner is different that {@link TenantRepository} in that it's not
 * always used during runtime. It may be an ad-hoc management command ran from shell.
 * @author ceefour
 */
public interface TenantProvisioner<T> {
	
	/**
	 * Creates a blank provisionData.
	 * @return
	 */
	T newProvisionData();
	
	AppManifest add(String tenantId, AppManifest appManifest, T provisionData, String trackingId);

	T lookupOne(String tenantId);
	
	Set<String> findAllStyles();
}
