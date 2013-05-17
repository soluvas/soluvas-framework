package org.soluvas.security.mongo;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;

import com.google.common.collect.ImmutableSet;

/**
 * MongoDB {@link SecurityRepository} implementation.
 * @todo Implement
 * @author ceefour
 */
public class MongoSecurityRepository implements SecurityRepository {

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getRoleRepository()
	 */
	@Override
	public CrudRepository<Role, String> getRoleRepository() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonRoles(String personId) {
		return ImmutableSet.of();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getRoleMembers(java.lang.String)
	 */
	@Override
	public Set<String> getRoleMembers(String role) {
		return ImmutableSet.of();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#replacePersonRoles(java.lang.String, java.util.Set)
	 */
	@Override
	public void replacePersonRoles(String personId,
			Set<String> roles) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#replaceRoleMembers(java.lang.String, java.util.Set)
	 */
	@Override
	public void replaceRoleMembers(String role,
			Set<String> personIds) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#addRole(java.lang.String, java.lang.String, java.util.Set)
	 */
	@Override
	@Deprecated
	public void addRole(String name, @Nullable String description,
			@Nullable Set<String> personIds) {
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#ensureRoles(java.util.Collection)
	 */
	@Override
	public void ensureRoles(Collection<Role> roles) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getDomainBase()
	 */
	@Override
	@Deprecated
	public String getDomainBase() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getBindConfig()
	 */
	@Override
	@Deprecated
	public LdapConnectionConfig getBindConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getUsersRdn()
	 */
	@Override
	@Deprecated
	public String getUsersRdn() {
		// TODO Auto-generated method stub
		return null;
	}

}
