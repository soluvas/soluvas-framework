package org.soluvas.security.ldap;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.name.Rdn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.ldap.LdapUtils;
import org.soluvas.ldap.PooledLdapRepository;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityFactory;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;

/**
 * @author ceefour
 * @todo Should be implemented on top of, or directly uses, {@link PooledLdapRepository}.
 */
public class LdapRoleRepository implements CrudRepository<Role, String> {

	private transient Logger log = LoggerFactory
			.getLogger(LdapRoleRepository.class);
	/**
	 * {@link LdapConnection} pool which full access used to read entries.
	 */
	final ObjectPool<LdapConnection> ldapPool;
	/**
	 * (Context) Entry which acts as the root of the application.
	 */
	final String domainBase;
	/**
	 * Entry which contains the <tt>groupOfUniqueNames</tt> entries, relative to
	 * <tt>domainBase</tt>. These will be mapped to Shiro roles.
	 */
	final String groupsRdn = "ou=groups";
	
	/**
	 * 
	 * @param ldapPool
	 * @param domainBase
	 * @param bindConfig
	 *            LDAP configuration used to perform bind-based authentication.
	 */
	public LdapRoleRepository(final ObjectPool<LdapConnection> ldapPool,
			String domainBase) {
		super();
		this.ldapPool = ldapPool;
		this.domainBase = domainBase;
	}

	protected void addRole(@Nonnull final String name, @Nullable final String description) {
		LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Void>() {
			@Override @Nullable
			public Void apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", name),
							new Dn(groupsRdn, domainBase));
					DefaultEntry groupEntry = new DefaultEntry(ldap.getSchemaManager(), groupDn);
					groupEntry.add("objectClass", "groupOfUniqueNames");
					if (!Strings.isNullOrEmpty(description))
						groupEntry.add("description", description);
					// dummy member, stupid LDAP spec :(
					final String[] uniqueMembers = new String[] { domainBase };						
					groupEntry.add("uniqueMember", uniqueMembers);
					log.info("Adding group entry {} with description='{}' members={}",
							groupDn.getName(), description, uniqueMembers);
					ldap.add(groupEntry);
					return null;
				} catch (Exception e) {
					log.error("Cannot add role " + name, e);
					throw new RuntimeException("Cannot add role " + name, e);
				}
			}
		});
	}

	@Override
	public <S extends Role> S save(S entity) {
		if (exists(entity.getName())) {
			throw new UnsupportedOperationException("Cannot modify existing role " + entity.getName());
		} else {
			addRole(entity.getName(), entity.getDescription());
			return entity;
		}
	}

	@Override
	public <S extends Role> Collection<S> save(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Role findOne(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exists(final String id) {
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", id),
							new Dn(groupsRdn, domainBase));
					return ldap.exists(groupDn);
				} catch (Exception e) {
					log.error("Cannot get role " + id, e);
					throw new RuntimeException("Cannot get role " + id, e);
				}
			}
		});
		
	}

	@Override
	public Collection<Role> findAll() {
		return LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, List<Role>>() {
			@Override @Nullable
			public List<Role> apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupsDn = new Dn(groupsRdn, domainBase);
					log.trace("Searching onelevel of {}", groupsDn.getName());
					EntryCursor cursor = ldap.search(groupsDn, "(objectClass=groupOfUniqueNames)", SearchScope.ONELEVEL);
					List<Role> roles = LdapUtils.transform(cursor, new Function<Entry, Role>() {
						@Override
						@Nullable
						public Role apply(@Nullable Entry input) {
							Role role = SecurityFactory.eINSTANCE.createRole();
							try {
								role.setName(input.get("cn").getString());
								if (input.containsAttribute("description")) {
									role.setDescription(input.get("description").getString());
								}
							} catch (LdapInvalidAttributeValueException e) {
								Throwables.propagate(e);
							}
							return role;
						}
					});
					log.debug("Searching onelevel of {} returned {} entries", groupsDn.getName(), roles.size());
					return roles;
				} catch (Exception e) {
					log.error("Cannot findAll roles", e);
					throw new SecurityException("Cannot findAll roles", e);
				}
			}
		});
	}

	@Override
	public Collection<Role> findAll(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(final String id) {
		LdapUtils.withConnection(ldapPool,
				new Function<LdapConnection, Void>() {
			@Override @Nullable
			public Void apply(@Nullable LdapConnection ldap) {
				try {
					final Dn groupDn = new Dn(new Rdn("cn", id),
							new Dn(groupsRdn, domainBase));
					log.debug("Deleting group entry {}", groupDn.getName());
					ldap.delete(groupDn);
					log.info("Group entry {} deleted", groupDn.getName());
					return null;
				} catch (Exception e) {
					log.error("Cannot delete role " + id, e);
					throw new SecurityException("Cannot delete role " + id, e);
				}
			}
		});
	}

	@Override
	public void delete(Role entity) {
		delete(entity.getName());
	}

	@Override
	public void delete(Iterable<? extends Role> entities) {
		Iterable<String> ids = Iterables.transform(entities, new Function<Role, String>() {
			@Override
			@Nullable
			public String apply(@Nullable Role input) {
				return input.getName();
			}
		});
		deleteIds(ids);
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteIds(Iterable<String> ids) {
		for (String id : ids) {
			delete(id);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepository#existsAll(java.lang.Iterable)
	 */
	@Override
	public boolean existsAll(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepository#existsAny(java.lang.Iterable)
	 */
	@Override
	public boolean existsAny(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepository#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.CrudRepository#count(java.lang.Iterable)
	 */
	@Override
	public long count(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

}
