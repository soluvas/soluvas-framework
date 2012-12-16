package org.soluvas.ldap;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.ModifyRequest;
import org.apache.directory.shared.ldap.model.message.ModifyResponse;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * You need to call init() after creation.
 * This repository is thread-safe.
 * @author ceefour
 */
public class PooledLdapRepository<T> implements LdapRepository<T> {

	private static Logger log = LoggerFactory.getLogger(PooledLdapRepository.class);
	@Inject
	private final ObjectPool<LdapConnection> pool;
	private final LdapMapper mapper;
	private final String baseDn;
	private final Class<? extends T> entityClass;

	public PooledLdapRepository(@Nonnull final Class<? extends T> entityClass, @Nonnull final ObjectPool<LdapConnection> pool, @Nonnull final String baseDn) {
		super();
		this.entityClass = entityClass;
		this.pool = pool;
		this.baseDn = baseDn;
		this.mapper = new LdapMapper();
	}
	
	protected <V> V withConnection(@Nonnull final Function<LdapConnection, V> function) {
		return LdapUtils.withConnection(pool, function);
	}
	
	@Override
	public void init() {
		// No longer needed
	}
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public T add(T obj) {
		final Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Add LDAP Entry {}: {}", entry.getDn(), entry);
		try {
			Entry newEntry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						conn.add(entry);
						log.debug("Lookup added LDAP Entry {}", entry.getDn());
						return conn.lookup(entry.getDn());
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
			return mapper.fromEntry(newEntry, entityClass);
		} catch (Exception e) {
			log.error("Error adding LDAP Entry " + entry.getDn(), e);
			throw new RuntimeException("Error adding LDAP Entry " + entry.getDn(), e);
		}
	}
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * <tt>uid</tt> attribute cannot be replaced.
	 * @param obj
	 * @return
	 * @throws LdapException
	 */
	@Override @Nonnull
	public T modify(@Nonnull final T obj) {
		Preconditions.checkNotNull(obj, "LDAP object to modify cannot be null");
		final String dn = mapper.getDn(obj, baseDn);
		final String rdnValue = mapper.getRdnValue(obj);
		log.info("Modify LDAP Entity {} with ID {}: {}", getEntityClass().getName(), rdnValue, dn); 
		final T modifiedObj = withConnection(new Function<LdapConnection, T>() {
			@Override @Nullable
			public T apply(@Nullable LdapConnection conn) {
				try {
					final Entry existingEntry = conn.lookup(dn);
					if (existingEntry == null) {
						throw new RuntimeException("Cannot find LDAP Entry to modify: " + dn);
					}
					final T existing = mapper.fromEntry(existingEntry, entityClass);
					final ModifyRequest modifyRequest = mapper.createModifyRequest(existingEntry, existing, obj);
					if (modifyRequest.getModifications().isEmpty()) {
						log.info("Not modifying unmodified LDAP Entry {}", dn);
						return existing;
					} else {
						log.info("Modifying LDAP Entry {} with {}", dn, modifyRequest);
						final ModifyResponse modifyResponse = conn.modify(modifyRequest);
						log.info("Modified LDAP Entry {} returned {}", dn, modifyResponse);
						final Entry modifiedEntry = conn.lookup(dn);
						final T newObj = mapper.fromEntry(modifiedEntry, entityClass);
						return newObj;
					}
				} catch (LdapException e) {
					throw new RuntimeException("Error updating LDAP Entry " + dn, e);
				}
			}
		});
		return modifiedObj;
	}

	/**
	 * Delete an LDAP entry.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public void delete(T obj) {
		final Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Delete LDAP Entry {}", entry.getDn()); 
		try {
			withConnection(new Function<LdapConnection, Void>() {
				@Override @Nullable
				public Void apply(@Nullable LdapConnection conn) {
					try {
						conn.delete(entry.getDn());
						return null;
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
		} catch (Exception e) {
			log.error("Error deleting LDAP Entry " + entry.getDn(), e);
			throw new RuntimeException("Error deleting LDAP Entry " + entry.getDn(), e);
		}
	}
	
	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public void delete(String id) {
		final String dn = toDn(id);
		log.info("Delete LDAP Entry {}", dn); 
		try {
			withConnection(new Function<LdapConnection, Void>() {
				@Override @Nullable
				public Void apply(@Nullable LdapConnection conn) {
					try {
						conn.delete(dn);
						return null;
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
		} catch (Exception e) {
			log.error("Error deleting LDAP Entry " + dn, e);
			throw new RuntimeException("Error deleting LDAP Entry " + dn, e);
		}
	}
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <U extends T> U findOne(String id) {
		final String dn = toDn(id);
		log.info("Lookup LDAP Entry {}", dn); 
		try {
			Entry entry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						return conn.lookup(dn);
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
			if (entry != null) {
				T obj = mapper.fromEntry(entry, entityClass);
				return (U) obj;
			} else {
				log.trace("Lookup LDAP Entry " + dn + " returns nothing");
				return null;
			}
		} catch (Exception e) {
			log.error("Error during lookup of LDAP Entry " + dn, e);
			throw new RuntimeException("Error during lookup of LDAP Entry " + dn, e);
		}
	}

	@Override
	public String toDn(String id) {
		return mapper.getDn(id, entityClass, baseDn);
	}
	
	/**
	 * Find LDAP entry based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@Override
	public T findOneByAttribute(String attribute, String value) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
		final String filter = "(&(objectClass=" + primaryObjectClass + ")(" + attribute + "=" + value + "))";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final Entry entry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						List<Entry> entries = LdapUtils.asList(conn.search(baseDn, filter, SearchScope.ONELEVEL));
						return Iterables.getOnlyElement(entries, null);
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			if (entry != null) {
				log.info("LDAP search {} filter {} returned {}", new Object[] { baseDn, filter, entry.getDn() });
				final T entity = mapper.fromEntry(entry, entityClass);
				return entity;
			} else {
				log.info("LDAP search {} filter {} returned nothing", new Object[] { baseDn, filter });
				return null;
			}
		} catch (Exception e) {
			log.error("Error searching LDAP in " + baseDn + " filter " + filter, e);
			throw new RuntimeException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}
	
	/**
	 * Find all LDAP entries of the same <tt>objectClass</tt>-es as the {@link LdapEntity}#objectClasses() annotation.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public List<T> findAll() {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
		final String filter = "(objectClass=" + primaryObjectClass + ")";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						return LdapUtils.asList( conn.search(baseDn, filter, SearchScope.ONELEVEL) );
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			log.info("LDAP search {} filter {} returned {} entries", new Object[] { baseDn, filter, entries.size() });
			final List<T> entities = Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			});
			return entities;
		} catch (Exception e) {
			log.error("Error searching LDAP in " + baseDn + " filter " + filter, e);
			throw new RuntimeException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}

	/**
	 * @return the baseDn
	 */
	@Override
	public String getBaseDn() {
		return baseDn;
	}

	/**
	 * @return the entityClass
	 */
	@Override
	public Class<? extends T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @return the mapper
	 */
	@Override
	public LdapMapper getMapper() {
		return mapper;
	}

	public ObjectPool<LdapConnection> getPool() {
		return pool;
	}

	@Override
	public boolean exists(String id) {
		final String dn = toDn(id);
		return withConnection(new Function<LdapConnection, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable LdapConnection conn) {
				try {
					return conn.exists(dn);
				} catch (LdapException e) {
					Throwables.propagate(e);
					return false;
				}
			}
		});
	}

	@Override
	public List<T> search(String searchText) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
		// TODO: escape searchText
		final String filter = String.format("(&(objectClass=%s)(|(cn=*%s*)(gn=*%s*)(sn=*%s*)(uid=*%s*)(mail=*%s*)))",
				primaryObjectClass, searchText, searchText, searchText, searchText, searchText);
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						return LdapUtils.asList( conn.search(baseDn, filter, SearchScope.ONELEVEL) );
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			log.info("LDAP search {} filter {} returned {} entries", new Object[] { baseDn, filter, entries.size() });
			List<T> entities = Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			});
			return entities;
		} catch (Exception e) {
			log.error("Error searching LDAP in " + baseDn + " filter " + filter, e);
			throw new RuntimeException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}
	
}
