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
	 * Given a <strong>physical</strong> {@link Role} ID, return <strong>physical</strong> member {@link Person}s in the {@link RolePersonRepository}.
	 * 
	 * <p><em>Physical</em> means actually registered in {@link RolePersonRepository}, not virtual members/roles due to automatic assignment.
	 * 
	 * @param tenantId Tenant ID.
	 * @param roleId Role ID.
	 * @return
	 */
	Set<String> getTenantRoleMembers(String tenantId, String roleId);

	/**
	 * Replace all tenant {@link Role}s of a {@link Person} with specified {@link Role} IDs.
	 * @param tenantId Tenant ID.
	 * @param personId Person ID.
	 * @param roles Tenant Role IDs.
	 */
	void replacePersonTenantRoles(final String tenantId, final String personId, final Set<String> roleIds);

	/**
	 * Replace all members of a tenant {@link Role} with specified {@link Person} IDs.
	 * @param tenantId Tenant ID.
	 * @param role Role ID.
	 * @param personId Person ID.
	 */
	void replaceTenantRoleMembers(final String tenantId, final String roleId, final Set<String> personIds);

}
