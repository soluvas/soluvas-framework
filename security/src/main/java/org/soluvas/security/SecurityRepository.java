package org.soluvas.security;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.soluvas.commons.Person;
import org.soluvas.data.repository.CrudRepository;

/**
 * This is different that security dictionary.
 * Role definition modifications in the dictionary are not automatically applied to the repository.
 * Repository is the database, dictionary defines what should/shouldn't exist based on the active bundles.
 * 
 * The Roles are defined on {@link Person}'s attributes (SecurityRoleIds)
 * @author ceefour
 * @deprecated This should be more like {@code SecurityManager}-ish. While the "repository" should be
 * 		provided by individual repositories, e.g. {@link RoleRepository}, etc.
 */
@Deprecated
public interface SecurityRepository {

	/**
	 * Returns a {@link Role} {@link CrudRepository} where roles can be added and removed.
	 * @return
	 */
	CrudRepository<Role, String> getRoleRepository();
	
	/**
	 * Give a Person ID, return their roles in the LDAP repository.
	 * @param personId
	 * @return
	 */
	Set<String> getPersonRoles(final String personId);

	/**
	 * Return the list of <strong>physical</strong> members (person IDs) of a particular <strong>physical</strong> role.
	 * 
	 * Physical means actually registered in LDAP, not virtual members/roles due to automatic assigning.
	 * 
	 * @param role
	 * @return
	 */
	Set<String> getRoleMembers(final String role);
	
	/**
	 * Replace all roles of a {@link Person} with specified {@link Role} names.
	 * @param personId
	 * @param roles
	 */
	void replacePersonRoles(final String personId, final Set<String> roles);

	/**
	 * Replace all members of a {@link Role} with specified {@link Person} IDs.
	 * @param role
	 * @param personId
	 */
	void replaceRoleMembers(final String role, final Set<String> personIds);
	
	/**
	 * Add a role to the <strong>repository</strong>. Note that this is different that security dictionary.
	 * Role definition modifications in the dictionary are not automatically applied to the repository.
	 * Repository is the database, dictionary defines what should/shouldn't exist based on the active bundles. 
	 * @param name
	 * @param description
	 * @param personIds TODO
	 */
	@Deprecated
	void addRole(final String name, @Nullable final String description, @Nullable final Set<String> personIds);

	/**
	 * Make sure all the requested {@link Role}s exist in the repository.
	 * @param roles
	 */
	void ensureRoles(final Collection<Role> roles);
	
	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract String getDomainBase();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract LdapConnectionConfig getBindConfig();

	/**
	 * @deprecated shouldn't be here
	 */
	@Deprecated
	public abstract String getUsersRdn();

}