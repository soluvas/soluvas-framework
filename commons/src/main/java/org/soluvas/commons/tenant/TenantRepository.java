package org.soluvas.commons.tenant;

import org.soluvas.commons.AppManifest;

import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

/**
 * Dynamic tenant repository. Tenants can be added or removed at anytime,
 * and notifications will be sent via app {@link EventBus}.
 * <p>Note: Unfortunately we can't use {@link org.soluvas.data.repository.PagingAndSortingRepository} from
 * {@code soluvas.commons} :(
 * @author ceefour
 * @see DirectoryTenantRepository
 */
public interface TenantRepository {
	
	/**
	 * Returns a map of tenant information (key=tenantId).
	 * @return
	 */
	ImmutableMap<String, AppManifest> findAll();
	
	/**
	 * Creates a blank {@link AppManifest} object, which may be pre-customized to the app.
	 * @return
	 */
	AppManifest newBlank();
	
	/**
	 * Sets up a new tenant and activates it.
	 * @param tenantId
	 * @param appManifest
	 * @param trackingId TODO
	 * @return
	 * @throws IllegalStateException if {@code tenantWhitelist} is used
	 */
	AppManifest add(String tenantId, AppManifest appManifest, String trackingId);

	/**
	 * Shuts down a tenant, modifies it then restarts it.
	 * @param tenantId
	 * @param appManifest
	 * @return
	 */
	AppManifest modify(String tenantId, AppManifest appManifest);

	/**
	 * Deletes a tenant permanently.
	 * @param tenantId
	 * @param appManifest
	 * @return
	 * @throws IllegalStateException if {@code tenantWhitelist} is used
	 */
	boolean delete(String tenantId);

}
