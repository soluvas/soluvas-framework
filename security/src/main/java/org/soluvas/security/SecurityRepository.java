package org.soluvas.security;

import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.soluvas.ldap.Person;

public interface SecurityRepository {

	/**
	 * Give a Person ID, return their roles in the LDAP repository.
	 * @param personId
	 * @return
	 */
	Set<String> getPersonRoles(@Nonnull final String personId);

	/**
	 * Return the list of <strong>physical</strong> members (person IDs) of a particular <strong>physical</strong> role.
	 * 
	 * Physical means actually registered in LDAP, not virtual members/roles due to automatic assigning.
	 * 
	 * @param role
	 * @return
	 */
	Set<String> getRoleMembers(@Nonnull final String role);
	
	/**
	 * Replace all roles of a {@link Person} with specified {@link Role} names.
	 * @param personId
	 * @param roles
	 */
	void replacePersonRoles(@Nonnull final String personId, @Nonnull final Set<String> roles);

	/**
	 * Replace all members of a {@link Role} with specified {@link Person} IDs.
	 * @param role
	 * @param personId
	 */
	void replaceRoleMembers(@Nonnull final String role, @Nonnull final Set<String> personIds);
	
	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract String getDomainBase();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract String getGroupsRdn();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract LdapConnectionConfig getBindConfig();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract ObjectPool<LdapConnection> getLdapPool();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract String getUsersRdn();

}