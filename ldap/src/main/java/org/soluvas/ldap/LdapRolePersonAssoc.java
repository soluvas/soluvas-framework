package org.soluvas.ldap;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
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
import org.soluvas.data.repository.AssocRepositoryBase;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * Associates role name with {@link Person} IDs.
 * @author ceefour
 */
public class LdapRolePersonAssoc extends AssocRepositoryBase<String, String> {

	private transient Logger log = LoggerFactory
			.getLogger(LdapRolePersonAssoc.class);
	/**
	 * {@link LdapConnection} pool which full access used to manipulate entries.
	 */
	private final ObjectPool<LdapConnection> ldapPool;
	/**
	 * (Context) Entry which acts as the root of the application.
	 */
	private final String domainBase;
	/**
	 * Entry which contains the <tt>groupOfUniqueNames</tt> entries, relative to
	 * <tt>domainBase</tt>. These will be mapped to Shiro roles.
	 */
	private final String groupsRdn = "ou=groups";
	/**
	 * Entry which contains the <tt>person</tt> entries, relative to
	 * <tt>domainBase</tt>.
	 */
	private final String usersRdn = "ou=users";
	
	public LdapRolePersonAssoc(ObjectPool<LdapConnection> ldapPool,
			String domainBase) {
		super();
		this.ldapPool = ldapPool;
		this.domainBase = domainBase;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean put(String left, String right) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(String left, String right) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#replaceRights(java.lang.Object, java.lang.Iterable)
	 */
	@Override
	public long replaceRights(final String role,
			final Iterable<? extends String> personIds) {
		LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Void>() {
			@Override @Nullable
			public Void apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", role),
							new Dn(groupsRdn, domainBase));
					final Dn usersDn = new Dn(usersRdn, domainBase);
					final String[] uniqueMembers;
					if (Iterables.isEmpty(personIds)) {
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
		return -1;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#replaceLefts(java.lang.Object, java.lang.Iterable)
	 */
	@Override
	public void replaceLefts(String right,
			Iterable<? extends String> lefts) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#removeAllRights(java.lang.Object)
	 */
	@Override
	public long removeAllRights(String role) {
		return replaceRights(role, ImmutableList.<String>of());
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#getLeft(java.lang.Object)
	 */
	@Override
	public Collection<String> getLeft(final String role) {
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
	 * @see org.soluvas.data.repository.AssocRepository#getRight(java.lang.Object)
	 */
	@Override
	public Collection<String> getRight(final String personId) {
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
					log.error("Cannot get roles for " + personId, e);
					throw new RuntimeException(
							"Cannot get roles for " + personId, e);
				}
			}
		});
		return ldapRoles;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#lefts()
	 */
	@Override
	public Multiset<String> lefts() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#rights()
	 */
	@Override
	public Multiset<String> rights() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#findAll()
	 */
	@Override
	public Multimap<String, String> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
