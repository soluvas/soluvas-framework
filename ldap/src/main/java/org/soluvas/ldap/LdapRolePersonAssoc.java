package org.soluvas.ldap;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
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
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.data.repository.AssocRepositoryBase;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

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
	public boolean put(final String role, final String personId) {
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", role),
							new Dn(groupsRdn, domainBase));
					final Dn usersDn = new Dn(usersRdn, domainBase);
					Entry groupEntry = ldap.lookup(groupDn);
					if (groupEntry == null) {
						// TODO: should just create the group
						log.warn("Cannot find group entry {}", groupDn.getName());
						return false;
					}
					Attribute membersAttr = groupEntry.get("uniqueMember");
					final String personMember = new Rdn("uid", personId).getName() + "," + usersDn.getName();
					if (!membersAttr.contains(personMember)) {
						log.debug("Adding member {} to role entry {}",
								personMember, groupEntry.getDn().getName());
						membersAttr.add(personMember);
						if (membersAttr.contains(domainBase)) {
							log.debug("Removing dummy member {} in role entry {}",
									domainBase, groupEntry.getDn().getName());
							membersAttr.remove(domainBase);
						}
						log.info("Replacing uniqueMember in {} with {}",
								groupDn.getName(), membersAttr.get()); 
						ldap.modify(groupDn, new DefaultModification(ModificationOperation.REPLACE_ATTRIBUTE, membersAttr));
						return true;
					} else {
						log.debug("Skipping existing member {} in role entry {}",
								personMember, groupEntry.getDn().getName());
						return false;
					}
				} catch (Exception e) {
					throw new RuntimeException("Cannot add member " + personId + " to role " + role, e);
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean delete(final String role, final String personId) {
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", role),
							new Dn(groupsRdn, domainBase));
					final Dn usersDn = new Dn(usersRdn, domainBase);
					Entry groupEntry = ldap.lookup(groupDn);
					if (groupEntry == null) {
						log.warn("Cannot find group entry {}", groupDn.getName());
						return false;
					}
					Attribute membersAttr = groupEntry.get("uniqueMember");
					final String personMember = new Rdn("uid", personId).getName() + "," + usersDn.getName();
					if (membersAttr.remove(personMember)) {
						if (membersAttr.size() == 0) {
							membersAttr.add(domainBase);
						}
						log.info("Replacing uniqueMember in {} with {}",
								groupDn.getName(), membersAttr.get()); 
						ldap.modify(groupDn, new DefaultModification(ModificationOperation.REPLACE_ATTRIBUTE, membersAttr));
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					log.error("Cannot remove member " + personId + " from role " + role, e);
					throw new RuntimeException("Cannot remove member " + personId + " from role " + role, e);
				}
			}
		});
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
	 * @see org.soluvas.data.repository.AssocRepository#removeAllRights(java.lang.Object)
	 */
	@Override
	public long deleteAllRights(String role) {
		return replaceRights(role, ImmutableList.<String>of());
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#getLeft(java.lang.Object)
	 */
	@Override
	public List<R> getLeft(final String role) {
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
							if (memberStr.equals(domainBase))
								return null;
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
	public List<L> getRight(final String personId) {
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
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Multiset<String>>() {
			@Override @Nullable
			public Multiset<String> apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupsDn = new Dn(groupsRdn, domainBase);
					final Dn usersDn = new Dn(usersRdn, domainBase);
					List<Multiset.Entry<String>> lefts = LdapUtils.transform(ldap.search(groupsDn, "(objectClass=groupOfUniqueNames)", SearchScope.ONELEVEL, "uniqueMember"), new Function<Entry, Multiset.Entry<String>>() {
						@Override
						@Nullable
						public Multiset.Entry<String> apply(@Nullable final Entry entry) {
							Attribute uniqueMemberAttr = entry.get("uniqueMember");
							Iterable<Value<?>> validValues = Iterables.filter(uniqueMemberAttr, new Predicate<Value<?>>() {
								@Override
								public boolean apply(@Nullable Value<?> member) {
									try {
										final String memberStr = member.getString();
										if (memberStr.equals(domainBase))
											return false;
										final Dn memberDn = new Dn(memberStr);
										if (!memberDn.isDescendantOf(usersDn)) {
											log.warn("Skipping invalid uniqueMember {} from {}, expected a descendant of {}",
													memberStr, entry.getDn().getName(), usersDn.getName());
											return false;
										}
										if (!"uid".equals(memberDn.getRdn().getType())) {
											log.warn("Skipping invalid uniqueMember {} from {}, expected 'uid' RDN, but got {}",
													memberStr, entry.getDn().getName(), memberDn.getRdn().getType());
											return false;
										}
										return true;
									} catch (LdapInvalidDnException e) {
										throw Throwables.propagate(e);
									}
								}
							});
							final int validValueCount = Iterables.size(validValues);
							return Multisets.immutableEntry(entry.getDn().getRdn().getValue().getString(), validValueCount);
						}
					});
					ImmutableMultiset.Builder<String> builder = ImmutableMultiset.builder();
					for (Multiset.Entry<String> left : lefts) {
						builder.addCopies(left.getElement(), left.getCount());
					}
					return builder.build();
				} catch (Exception e) {
					log.error("Cannot get roles", e);
					throw new RuntimeException("Cannot get roles", e);
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.AssocRepository#findAll()
	 */
	@Override @Nonnull
	public Multimap<String, String> findAll() {
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Multimap<String, String>>() {
			@Override @Nullable
			public Multimap<String, String> apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupsDn = new Dn(groupsRdn, domainBase);
					final Dn usersDn = new Dn(usersRdn, domainBase);
					List<Map.Entry<String, Iterable<String>>> nestedEntries = LdapUtils.transform(
							ldap.search(groupsDn, "(objectClass=groupOfUniqueNames)", SearchScope.ONELEVEL, "uniqueMember"),
							new Function<Entry, Map.Entry<String, Iterable<String>>>() {
						@Override
						@Nullable
						public Map.Entry<String, Iterable<String>> apply(@Nullable final Entry entry) {
							final Attribute uniqueMemberAttr = entry.get("uniqueMember");
							final Iterable<String> members = Iterables.transform(uniqueMemberAttr, new Function<Value<?>, String>() {
								@Override
								public String apply(@Nullable Value<?> member) {
									try {
										final String memberStr = member.getString();
										if (memberStr.equals(domainBase))
											return null;
										final Dn memberDn = new Dn(memberStr);
										if (!memberDn.isDescendantOf(usersDn)) {
											log.warn("Skipping invalid uniqueMember {} from {}, expected a descendant of {}",
													memberStr, entry.getDn().getName(), usersDn.getName());
											return null;
										}
										if (!"uid".equals(memberDn.getRdn().getType())) {
											log.warn("Skipping invalid uniqueMember {} from {}, expected 'uid' RDN, but got {}",
													memberStr, entry.getDn().getName(), memberDn.getRdn().getType());
											return null;
										}
										return memberDn.getRdn().getValue().getString();
									} catch (LdapInvalidDnException e) {
										throw Throwables.propagate(e);
									}
								}
							});
							Iterable<String> filteredMembers = Iterables.filter(members, new NotNullPredicate<String>());
							final String roleName = entry.getDn().getRdn().getValue().getString();
							return Maps.immutableEntry(roleName, filteredMembers);
						}
					});
					ImmutableMultimap.Builder<String, String> builder = ImmutableMultimap.builder();
					for (Map.Entry<String, Iterable<String>> entry : nestedEntries) {
						builder.putAll(entry.getKey(), entry.getValue());
					}
					return builder.build();
				} catch (Exception e) {
					throw new RuntimeException("Cannot find all person-role associations", e);
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LdapRolePersonAssoc ["
				+ (domainBase != null ? "domainBase=" + domainBase + ", " : "")
				+ (groupsRdn != null ? "groupsRdn=" + groupsRdn + ", " : "")
				+ (usersRdn != null ? "usersRdn=" + usersRdn : "") + "]";
	}
	
}
