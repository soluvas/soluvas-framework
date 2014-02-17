package org.soluvas.security;

import java.util.Set;

import org.soluvas.commons.Person;

/**
 * Manages ACL assignments (i.e. which users get which roles).
 * 
 * <p>This is different than security dictionary.
 * Role definition modifications in the dictionary are not automatically applied to the repository.
 * AccessControlManager manages ACL assignments (i.e. which users get which roles),
 * security dictionary defines roles/actions/domains/permissions what should/shouldn't exist based on the active bundles.
 * 
 * <p>The {@link Role}s are usually assigned inside {@link Person#getSecurityRoleIds()} (e.g. for MongoDB-backed Person).
 * 
 * <p>{@code AccessControlManager} is a multitenant-aware application-scoped bean.
 * 
 * @author ceefour
 * @todo Work in progress, migrating methods from {@link SecurityRepository}.
 */
public interface AccessControlManager {
	
	/**
	 * Given a {@link Person} ID, return their {@link Role}s in the {@link RolePersonRepository}.
	 * @param tenantId Tenant ID.
	 * @param personId Person ID.
	 * @return
	 */
	Set<String> getPersonTenantRoles(final String tenantId, final String personId);

	/**
	 * Given a {@link Role} ID, return member {@link Person}s in the {@link RolePersonRepository}.
	 * @param tenantId Tenant ID.
	 * @param roleId Role ID.
	 * @return
	 */
	Set<String> getTenantRoleMembers(String tenantId, String roleId);

}
