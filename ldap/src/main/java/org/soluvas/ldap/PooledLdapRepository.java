package org.soluvas.ldap;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * You need to call init() after creation.
 * @author ceefour
 */
public class PooledLdapRepository<T> implements LdapRepository<T> {

	private transient Logger log = LoggerFactory.getLogger(PooledLdapRepository.class);
	@Inject private transient LdapConnectionPool pool;
	private LdapMapper mapper;
	private String baseDn;
	private Class<T> entityClass;

	public PooledLdapRepository() {
		super();
	}
	
	public PooledLdapRepository(Class<T> entityClass, LdapConnectionPool pool, String baseDn) {
		super();
		this.entityClass = entityClass;
		this.pool = pool;
		this.baseDn = baseDn;
	}
	
	protected <V> V withConnection(Function<LdapConnection, V> function) throws Exception {
		LdapConnection conn = pool.getConnection();
		try {
			return function.apply(conn);
		} finally {
			pool.releaseConnection(conn);
		}
	}
	
	public void init() {
		try {
			mapper = withConnection(new Function<LdapConnection, LdapMapper>() {
				@Override @Nullable
				public LdapMapper apply(@Nullable LdapConnection conn) {
					return new LdapMapper(conn.getSchemaManager());
				}
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
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
	 * @param obj
	 * @param removeExtraAttributes
	 * @return
	 * @throws LdapException
	 */
	public T modify(T obj, final boolean removeExtraAttributes) {
		final Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Modify LDAP Entry {}", entry.getDn(), entry); 
		try {
			Entry modifiedEntry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						LdapUtils.update(conn, entry, removeExtraAttributes, "uid"); 
						log.debug("Lookup modified LDAP Entry {}", entry.getDn());
						return conn.lookup(entry.getDn());
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
			T newObj = mapper.fromEntry(modifiedEntry, entityClass);
			return newObj;
		} catch (Exception e) {
			log.error("Error modifying LDAP Entry " + entry.getDn(), e);
			throw new RuntimeException("Error modifying LDAP Entry " + entry.getDn(), e);
		}
	}

	/**
	 * Delete an LDAP entry.
	 * @param obj
	 * @throws LdapException
	 */
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
	public void delete(String id) {
		final Dn dn = toDn(id);
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
	public T findOne(String id) {
		final Dn dn = toDn(id);
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
				return obj;
			} else {
				log.trace("Lookup LDAP Entry " + dn + " returns nothing");
				return null;
			}
		} catch (Exception e) {
			log.error("Error during lookup of LDAP Entry " + dn, e);
			throw new RuntimeException("Error during lookup of LDAP Entry " + dn, e);
		}
	}

	public Dn toDn(String id) {
		return mapper.toDn(id, entityClass, baseDn);
	}
	
	/**
	 * Find LDAP entry based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	public T findOneByAttribute(String attribute, String value) {
		String[] objectClasses = mapper.getObjectClasses(entityClass);
		// Only search based on first objectClass, this is the typical use case
		final String filter = "(&(objectClass=" + objectClasses[0] + ")(" + attribute + "=" + value + "))";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			Entry entry = withConnection(new Function<LdapConnection, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable LdapConnection conn) {
					try {
						EntryCursor cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL);
						return Iterables.getOnlyElement(cursor, null);
					} catch (LdapException e) {
						throw new RuntimeException(e);
					}
				}
			});
			if (entry != null) {
				log.info("LDAP search {} filter {} returned {}", new Object[] { baseDn, filter, entry.getDn() });
				T entity = mapper.fromEntry(entry, entityClass);
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
	public List<T> findAll() {
		String[] objectClasses = mapper.getObjectClasses(entityClass);
//		String filter = "(&";
//		for (String objectClass : objectClasses) {
//			filter += "(objectClass=" + objectClass + ")";
//		}
//		filter += ")";
		// Only search based on first objectClass, this is the typical use case
		final String filter = "(objectClass=" + objectClasses[0] + ")";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			List<Entry> entries = withConnection(new Function<LdapConnection, List<Entry>>() {
				@Override @Nullable
				public List<Entry> apply(@Nullable LdapConnection conn) {
					try {
						EntryCursor cursor = conn.search(baseDn, filter, SearchScope.ONELEVEL);
						return ImmutableList.copyOf(cursor.iterator());
					} catch (LdapException e) {
						throw new RuntimeException(e);
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

	/**
	 * @return the baseDn
	 */
	public String getBaseDn() {
		return baseDn;
	}

	/**
	 * @param baseDn the baseDn to set
	 */
	public void setBaseDn(String baseDn) {
		this.baseDn = baseDn;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * @return the mapper
	 */
	public LdapMapper getMapper() {
		return mapper;
	}
	
}
