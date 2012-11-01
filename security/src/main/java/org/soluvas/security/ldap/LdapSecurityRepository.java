package org.soluvas.security.ldap;

import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.DefaultModification;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Modification;
import org.apache.directory.shared.ldap.model.entry.ModificationOperation;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.name.Rdn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.LdapUtils;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;

/**
 * LDAP-powered {@link SecurityRepository}, with <tt>ou=users</tt> as people and <tt>ou=groups</tt> as roles.
 * @author ceefour
 */
public class LdapSecurityRepository implements SecurityRepository {
	
	private transient Logger log = LoggerFactory
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
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonRoles(final String personId) {
		Set<String> ldapRoles = LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Set<String>>() {
			@Override @Nullable
			public Set<String> apply(@Nullable LdapConnection ldap) {
				try {
					final Dn userDn = new Dn(new Rdn("uid", personId),
							new Dn(usersRdn, domainBase));
					final Dn groupsDn = new Dn(groupsRdn, domainBase);
					final String memberFilter = "(uniqueMember="
							+ userDn.getName() + ")";
					log.debug("Searching for {} in {}", memberFilter,
							groupsDn.getName());
					Set<String> roles = LdapUtils.transformSet(ldap
							.search(groupsDn, memberFilter,
									SearchScope.ONELEVEL),
							new Function<Entry, String>() {
								@Override
								@Nullable
								public String apply(
										@Nullable Entry input) {
									return input.getDn().getRdn()
											.getValue().getString();
								}
							});
					log.debug("User {} has {} roles: {}", personId,
							roles.size(), roles);
					return roles;
				} catch (Exception e) {
					log.error("Cannot get authorization info for "
							+ personId, e);
					throw new RuntimeException(
							"Cannot get authorization info for "
									+ personId, e);
				}
			}
		});
		return ldapRoles;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.login.SecurityRepository#getRoleMembers(java.lang.String)
	 */
	@Override
	public Set<String> getRoleMembers(final String role) {
		Set<String> members = LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Set<String>>() {
			@Override @Nullable
			public Set<String> apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", role),
							new Dn(groupsRdn, domainBase));
					final Dn usersDn = new Dn(usersRdn, domainBase);
					Entry groupEntry = ldap.lookup(groupDn);
					if (groupEntry == null) {
						log.warn("Cannot get members of role {}, entry {} does not exist",
								role, groupDn.getName());
						return ImmutableSet.of();
					}
					Attribute uniqueMemberAttr = groupEntry.get("uniqueMember");
					if (uniqueMemberAttr != null) {
						Builder<String> members = ImmutableSet.<String>builder();
						for (Value<?> uniqueMember : uniqueMemberAttr) {
							String memberStr = uniqueMember.getString();
							Dn memberDn = new Dn(memberStr);
							if (!memberDn.isDescendantOf(usersDn)) {
								log.warn("Skipping invalid uniqueMember {} from {}, expected a descendant of {}",
										memberStr, groupDn.getName(), usersDn.getName());
								continue;
							}
							if (!"uid".equals(memberDn.getRdn().getType())) {
								log.warn("Skipping invalid uniqueMember {} from {}, expected 'uid' RDN, but got {}",
										memberStr, groupDn.getName(), memberDn.getRdn().getType());
								continue;
							}
							members.add(memberDn.getRdn().getValue().getString());
						}
						return members.build();
					} else {
						return ImmutableSet.of();
					}
				} catch (Exception e) {
					log.error("Cannot get members for role " + role, e);
					throw new RuntimeException(
							"Cannot get members for " + role, e);
				}
			}
		});
		log.debug("Role {} has {} members: {}", role, members.size(), members);
		return members;
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
	@Override
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
	@Override
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
	public void replaceRoleMembers(@Nonnull final String role, @Nonnull final Set<String> personIds) {
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
	
}