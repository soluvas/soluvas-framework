package org.soluvas.commons.tenant;

/**
 * Reacts to {@link TenantRepository} events.
 * These methods are guaranteed never be called concurrently,
 * so it's not needed to use {@code synchronized} on them.
 * @author ceefour
 */
public interface TenantRepositoryListener {
	
	void onTenantsStarting(TenantsStarting starting) throws Exception;
	void onTenantsStopping(TenantsStopping stopping) throws Exception;

}
