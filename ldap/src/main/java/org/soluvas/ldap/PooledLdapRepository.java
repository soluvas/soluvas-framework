package org.soluvas.ldap;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.filter.FilterEncoder;
import org.apache.directory.api.ldap.model.message.ModifyRequest;
import org.apache.directory.api.ldap.model.message.ModifyResponse;
import org.apache.directory.api.ldap.model.message.ResultCodeEnum;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepositoryBase;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * You need to call init() after creation.
 * This repository is thread-safe.
 * @author ceefour
 */
public class PooledLdapRepository<T> extends CrudRepositoryBase<T, String>
	implements LdapRepository<T> {

	private final class EntryToEntity implements Function<Entry, T> {
		@Override
		public T apply(Entry input) {
			return mapper.fromEntry(input, entityClass);
		}
	}

	private static Logger log = LoggerFactory.getLogger(PooledLdapRepository.class);
	
	@Inject
	private final ObjectPool<LdapConnection> pool;
	private final LdapMapper<T> mapper;
	private final String baseDn;
	private final Class<? extends T> entityClass;

	public PooledLdapRepository(@Nonnull final Class<? extends T> entityClass, @Nonnull final ObjectPool<LdapConnection> pool, @Nonnull final String baseDn) {
		super();
		this.entityClass = entityClass;
		this.pool = pool;
		this.baseDn = baseDn;
		this.mapper = new LdapMapper<T>();
	}
	
	protected <V> V withConnection(@Nonnull final Function<LdapConnection, V> function) {
		return LdapUtils.withConnection(pool, function);
	}
	
	@Override @Deprecated
	public void init() {
		// No longer needed
	}
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public <S extends T> S add(S entity) {
		Preconditions.checkNotNull(entity, "Cannot add null object to %s, expected %s",
				baseDn, getEntityClass().getName());
		final Entry entry = mapper.toEntry(entity, baseDn);
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
			return (S) mapper.fromEntry(newEntry, entityClass);
		} catch (Exception e) {
			log.error("Error adding LDAP Entry " + entry.getDn(), e);
			throw new RuntimeException("Error adding LDAP Entry " + entry.getDn(), e);
		}
	}
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * <tt>uid</tt> attribute cannot be replaced.
	 * @param entity
	 * @return
	 * @throws LdapException
	 */
	@Override @Nonnull
	public T modify(@Nonnull final T entity) {
		final String rdnValue = mapper.getRdnValue(entity);
		return modify(rdnValue, entity);
	}
	
	@Override
	public <S extends T> S modify(String id, final S entity) {
		Preconditions.checkNotNull(entity, "LDAP object to modify cannot be null");
//		final String dn = mapper.getDn(entity, baseDn);
		final String oldDn = mapper.getDn(id, entityClass, baseDn);
		log.info("Modify LDAP Entity {} with ID {} at {}", getEntityClass().getName(), id, oldDn); 
		final T modifiedObj = withConnection(new Function<LdapConnection, T>() {
			@Override @Nullable
			public T apply(@Nullable LdapConnection conn) {
				try {
					final String newDn = mapper.getDn(entity, baseDn);
					if (!oldDn.equals(newDn)) {
						final String newRdn = new Dn(newDn).getRdn().toString();
						log.info("Renaming LDAP Entity {} to {}", oldDn, newRdn);
						conn.rename(oldDn, newRdn);
					}
					
					final Entry existingEntry = conn.lookup(newDn);
					if (existingEntry == null) {
						throw new RuntimeException("Cannot find LDAP Entry to modify: " + newDn);
					}
					final T existing = mapper.fromEntry(existingEntry, entityClass);
					final ModifyRequest modifyRequest = mapper.createModifyRequest(existingEntry, existing, entity);
					if (modifyRequest.getModifications().isEmpty()) {
						log.info("Not modifying unmodified LDAP Entry {}", newDn);
						return existing;
					} else {
						log.info("Modifying LDAP Entry {} with {}", newDn, modifyRequest);
						final ModifyResponse modifyResponse = conn.modify(modifyRequest);
						if (modifyResponse.getLdapResult().getResultCode() == ResultCodeEnum.SUCCESS) {
							log.info("Modified LDAP Entry {} returned: {}", newDn, modifyResponse);
							final Entry modifiedEntry = conn.lookup(newDn);
							final T newObj = mapper.fromEntry(modifiedEntry, entityClass);
							return newObj;
						} else {
							log.error("Modified LDAP Entry {} returned: {}", newDn, modifyResponse);
							throw new RuntimeException("Error updating LDAP Entry " + newDn + ", result: " + modifyResponse);
						}
					}
				} catch (LdapException e) {
					throw new RuntimeException("Error updating LDAP Entry " + oldDn, e);
				}
			}
		});
		return (S) modifiedObj;
	}

	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property, including all
	 * its subentries. Uses {@link LdapUtils#deleteRecursively(org.apache.directory.ldap.client.api.LdapConnection, String)}.
	 * @param obj
	 * @throws LdapException
	 */
	@Override
	public boolean delete(String id) {
		final String dn = toDn(id);
		log.info("Deleting LDAP Entry {} recursively", dn); 
		try {
			return withConnection(new Function<LdapConnection, Boolean>() {
				@Override @Nullable
				public Boolean apply(@Nullable LdapConnection conn) {
					return LdapUtils.deleteRecursively(conn, dn) >= 1;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("Error deleting LDAP Entry " + dn, e);
		}
	}
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@SuppressWarnings("unchecked") @Override
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
//		final String filter = "(&(objectClass=" + primaryObjectClass + ")(" + attribute + "=" + value + "))";
		final String filter = "(&(objectClass=*)(" + attribute + "=" + value + "))";
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
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
		final String filter = "(objectClass=*)";
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
			final List<T> entities = ImmutableList.copyOf(Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			}));
			return entities;
		} catch (Exception e) {
			log.error("Error searching LDAP in " + baseDn + " filter " + filter, e);
			throw new RuntimeException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}

	/**
	 * @return the shopDn
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
	public LdapMapper<T> getMapper() {
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
		final String encodedSearchText = FilterEncoder.encodeFilterValue(searchText);
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
		// escape searchText using https://issues.apache.org/jira/browse/DIRSHARED-143
//		final String filter = String.format("(&(objectClass=%s)(|(cn=*%s*)(gn=*%s*)(sn=*%s*)(uid=*%s*)(mail=*%s*)))",
//				primaryObjectClass, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText);
		final String filter = String.format("(&(objectClass=*)(|(cn=*%s*)(gn=*%s*)(sn=*%s*)(uid=*%s*)(mail=*%s*)))",
				encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText, encodedSearchText);
		log.debug("Searching LDAP {} filter: {}", baseDn, filter); 
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
			log.info("LDAP search {} filter {} returned {} entries", baseDn, filter, entries.size());
			final List<T> entities = Lists.transform(entries, new EntryToEntity());
			return entities;
		} catch (Exception e) {
			throw new LdapRepositoryException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}

	@Override
	public boolean existsByAttribute(String attribute, String value) {
		final T found = findOneByAttribute(attribute, value);
		return found != null;
	}

	@Override
	public List<T> findAllByFilter(String filter) {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
//		final String realFilter = String.format("(&(objectClass=%s)%s)",
//				primaryObjectClass, filter);
		final String realFilter = String.format("(&(objectClass=*)%s)",
				filter);
		log.debug("Searching LDAP {} filter: {}", baseDn, realFilter); 
		try {
			final List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						return LdapUtils.asList( conn.search(baseDn, realFilter, SearchScope.ONELEVEL) );
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					}
				}
			});
			log.info("LDAP search {} filter {} returned {} entries", baseDn, filter, entries.size());
			final List<T> entities = Lists.transform(entries, new EntryToEntity());
			return entities;
		} catch (Exception e) {
			throw new LdapRepositoryException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}

	@Override
	public long count() {
		final String primaryObjectClass = mapper.getMapping(entityClass).getPrimaryObjectClass();
		// Only search based on first objectClass, this is the typical use case
//		final String filter = "(objectClass=" + primaryObjectClass + ")";
		final String filter = "(objectClass=*)";
		log.info("Counting LDAP {} filter: {}", baseDn, filter); 
		try {
			final Long entries = withConnection(new Function<LdapConnection, Long>() {
				@Override @Nullable
				public Long apply(@Nullable LdapConnection conn) {
					EntryCursor cursor = null;
					try {
						cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL);
						return (long) Iterables.size(cursor);
					} catch (LdapException e) {
						Throwables.propagate(e);
						return null;
					} finally {
						if (cursor != null) {
							cursor.close();
						}
					}
				}
			});
			log.info("LDAP count {} filter {} returned {} entries", baseDn, filter, entries);
			return entries;
		} catch (Exception e) {
			log.error("Error searching LDAP in " + baseDn + " filter " + filter, e);
			throw new RuntimeException("Error searching LDAP in " + baseDn + " filter " + filter, e);
		}
	}

	@Override @Nullable
	protected String getId(T entity) {
		return mapper.getRdnValue(entity);
	}
	
}
