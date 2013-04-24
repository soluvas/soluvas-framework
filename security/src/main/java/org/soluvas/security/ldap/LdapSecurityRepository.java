package org.soluvas.security.ldap;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.api.ldap.model.entry.DefaultModification;
import org.apache.directory.api.ldap.model.entry.Modification;
import org.apache.directory.api.ldap.model.entry.ModificationOperation;
import org.apache.directory.api.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.api.ldap.model.name.Rdn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.AssocRepository;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.ldap.LdapRolePersonAssoc;
import org.soluvas.ldap.LdapUtils;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * LDAP-powered {@link SecurityRepository}, with <tt>ou=users</tt> as people and <tt>ou=groups</tt> as roles.
 * @author ceefour
 */
public class LdapSecurityRepository implements SecurityRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(LdapSecurityRepository.class);
	/**
	 * {@link LdapConnection} pool which full access used to read entries.
	 */
	final ObjectPool<LdapConnection> ldapPool;
	/**
	 * (Context) Entry which acts as the root of the application.
	 */
	final String domainBase;
	/**
	 * Entry which contains the <tt>person</tt> entries, relative to
	 * <tt>domainBase</tt>.
	 */
	final String usersRdn = "ou=users";
	/**
	 * Entry which contains the <tt>groupOfUniqueNames</tt> entries, relative to
	 * <tt>domainBase</tt>. These will be mapped to Shiro roles.
	 */
	final String groupsRdn = "ou=groups";
	private final LdapConnectionConfig bindConfig;
	private final LdapRoleRepository roleRepository;
	private final AssocRepository<String, String> rolePersonAssoc;
	
	/**
	 * 
	 * @param ldapPool
	 * @param domainBase
	 * @param bindConfig
	 *            LDAP configuration used to perform bind-based authentication.
	 */
	public LdapSecurityRepository(final ObjectPool<LdapConnection> ldapPool,
			String domainBase, LdapConnectionConfig bindConfig) {
		super();
		this.ldapPool = ldapPool;
		this.domainBase = domainBase;
		this.bindConfig = bindConfig;
		this.roleRepository = new LdapRoleRepository(ldapPool, domainBase);
		this.rolePersonAssoc = new LdapRolePersonAssoc(ldapPool, domainBase);
	}

	/**
	 * 
	 * @param ldapPool
	 * @param domainBase
	 * @param bindConfig
	 *            LDAP configuration used to perform bind-based authentication.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LdapSecurityRepository(final ObjectPool<LdapConnection> ldapPool,
			String domainBase, LdapConnectionConfig bindConfig, AssocRepository rolePersonAssoc) {
		super();
		this.ldapPool = ldapPool;
		this.domainBase = domainBase;
		this.bindConfig = bindConfig;
		this.roleRepository = new LdapRoleRepository(ldapPool, domainBase);
		this.rolePersonAssoc = rolePersonAssoc;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonRoles(final String personId) {
		return ImmutableSet.copyOf(rolePersonAssoc.getRight(personId));
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getRoleMembers(java.lang.String)
	 */
	@Override
	public Set<String> getRoleMembers(final String role) {
		return ImmutableSet.copyOf(rolePersonAssoc.getLeft(role));
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getDomainBase()
	 */
	@Override
	public String getDomainBase() {
		return domainBase;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getGroupsRdn()
	 */
	public String getGroupsRdn() {
		return groupsRdn;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getBindConfig()
	 */
	@Override
	public LdapConnectionConfig getBindConfig() {
		return bindConfig;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getLdapPool()
	 */
	public ObjectPool<LdapConnection> getLdapPool() {
		return ldapPool;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getUsersRdn()
	 */
	@Override
	public String getUsersRdn() {
		return usersRdn;
	}

	@Override
	public void replacePersonRoles(String personId, Set<String> roles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceRoleMembers(final String role, final Set<String> personIds) {
		LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Void>() {
			@Override @Nullable
			public Void apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", role),
							new Dn(groupsRdn, domainBase));
					final Dn usersDn = new Dn(usersRdn, domainBase);
					final String[] uniqueMembers;
					if (personIds.isEmpty()) {
						// dummy member, stupid LDAP spec :(
						uniqueMembers = new String[] { domainBase };						
					} else {
						uniqueMembers = Iterables.toArray( Iterables.transform(personIds, new Function<String, String>() {
							@Override
							@Nullable
							public String apply(@Nullable String input) {
								try {
									return new Rdn("uid", input).getName() + "," + usersDn.getName();
								} catch (LdapInvalidDnException e) {
									throw new RuntimeException("Invalid person ID: " + input, e);
								}
							}
						}), String.class);
					}
					final Modification modification = new DefaultModification(ModificationOperation.REPLACE_ATTRIBUTE, "uniqueMember", uniqueMembers);
					log.info("Replacing uniqueMember in {} with {}",
							groupDn.getName(), uniqueMembers); 
					ldap.modify(groupDn, modification);
					return null;
				} catch (Exception e) {
					log.error("Cannot replace members for role " + role, e);
					throw new RuntimeException(
							"Cannot replace members for " + role, e);
				}
			}
		});
	}

	@Override
	public void addRole(final String name, @Nullable final String description, @Nullable final Set<String> personIds) {
		roleRepository.addRole(name, description);
		replaceRoleMembers(name, personIds);
	}

	@Override
	@Nonnull
	public CrudRepository<Role, String> getRoleRepository() {
		return roleRepository;
	}

	@Override
	public void ensureRoles(Collection<Role> roles) {
		log.trace("Ensuring {} roles exist", roles.size());
		long skipped = 0;
		long added = 0;
		for (Role role : roles) {
			if (!roleRepository.exists(role.getName())) {
				log.info("Adding role {}", role.getName());
				roleRepository.save(role);
				added++;
			} else {
				log.trace("Skipping role {}", role.getName());
				skipped++;
			}
		}
		log.info("Ensured {} roles exist, added {}, skipped {}", roles.size(),
				added, skipped);
	}
	
}