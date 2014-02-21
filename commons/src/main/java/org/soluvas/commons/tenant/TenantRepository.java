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

}
