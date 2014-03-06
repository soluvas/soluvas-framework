package org.soluvas.commons.tenant;

/**
 * Reacts to {@link TenantRepository} events.
 * @author ceefour
 */
public interface TenantRepositoryListener {
	
	void onTenantsStarting(TenantsStarting starting) throws Exception;
	void onTenantsStopping(TenantsStopping stopping) throws Exception;

}
