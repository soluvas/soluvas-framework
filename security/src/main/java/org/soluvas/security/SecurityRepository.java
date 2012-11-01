package org.soluvas.security;

import java.util.Set;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;

public interface SecurityRepository {

	/**
	 * Give a Person ID, return their roles in the LDAP repository.
	 * @param personId
	 * @return
	 */
	public abstract Set<String> getPersonRoles(String personId);

	/**
	 * Return the list of <strong>physical</strong> members (person IDs) of a particular <strong>physical</strong> role.
	 * 
	 * Physical means actually registered in LDAP, not virtual members/roles due to automatic assigning.
	 * 
	 * @param role
	 * @return
	 */
	public abstract Set<String> getRoleMembers(String role);

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