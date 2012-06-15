package org.soluvas.ldap;

import java.util.List;

import javax.inject.Inject;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * @author ceefour
 */
public class LdapRepositoryImpl<T> implements LdapRepository<T> {

	private transient Logger log = LoggerFactory.getLogger(LdapRepositoryImpl.class);
	@Inject private LdapConnection connection;
	private LdapMapper mapper;
	private String baseDn;
	private Class<T> entityClass;

	public LdapRepositoryImpl() {
	}
	
	public LdapRepositoryImpl(Class<T> entityClass, LdapConnection connection, String baseDn) {
		super();
		this.entityClass = entityClass;
		this.connection = connection;
		this.baseDn = baseDn;
	}
	
	public void init() {
		mapper = new LdapMapper(connection.getSchemaManager());
	}
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	public T add(T obj) {
		Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Add LDAP Entry {}: {}", entry.getDn(), entry); 
		try {
			connection.add(entry);
			log.debug("Lookup added LDAP Entry {}", entry.getDn());
			Entry newEntry = connection.lookup(entry.getDn());
			T newObj = mapper.fromEntry(newEntry, entityClass);
			return newObj;
		} catch (LdapException e) {
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
	public T modify(T obj, boolean removeExtraAttributes) {
		Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Modify LDAP Entry {}", entry.getDn(), entry); 
		try {
			LdapUtils.update(connection, entry, removeExtraAttributes, "uid"); 
			log.debug("Lookup modified LDAP Entry {}", entry.getDn());
			Entry newEntry = connection.lookup(entry.getDn());
			T newObj = mapper.fromEntry(newEntry, entityClass);
			return newObj;
		} catch (LdapException e) {
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
		Entry entry = mapper.toEntry(obj, baseDn);
		log.info("Delete LDAP Entry {}", entry.getDn()); 
		try {
			connection.delete(entry.getDn());
		} catch (LdapException e) {
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
		Dn dn = mapper.toDn(id, entityClass, baseDn);
		log.info("Delete LDAP Entry {}", dn); 
		try {
			connection.delete(dn);
		} catch (LdapException e) {
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
		Dn dn = mapper.toDn(id, entityClass, baseDn);
		log.info("Lookup LDAP Entry {}", dn); 
		Entry entry;
		try {
			entry = connection.lookup(dn);
			if (entry != null) {
				T obj = mapper.fromEntry(entry, entityClass);
				return obj;
			} else {
				log.trace("Lookup LDAP Entry " + dn + " returns nothing");
				return null;
			}
		} catch (LdapException e) {
			log.error("Error during lookup of LDAP Entry " + dn, e);
			throw new RuntimeException("Error during lookup of LDAP Entry " + dn, e);
		}
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
		String filter = "(&(objectClass=" + objectClasses[0] + ")(" + attribute + "=" + value + "))";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			EntryCursor cursor = connection.search(baseDn, filter, SearchScope.ONELEVEL);
			Entry entry = Iterables.getOnlyElement(cursor, null);
			if (entry != null) {
				log.info("LDAP search {} filter {} returned {}", new Object[] { baseDn, filter, entry.getDn() });
				T entity = mapper.fromEntry(entry, entityClass);
				return entity;
			} else {
				log.info("LDAP search {} filter {} returned nothing", new Object[] { baseDn, filter });
				return null;
			}
		} catch (LdapException e) {
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
		String filter = "(objectClass=" + objectClasses[0] + ")";
		log.info("Searching LDAP {} filter: {}", baseDn, filter); 
		try {
			EntryCursor cursor = connection.search(baseDn, filter, SearchScope.ONELEVEL);
			List<Entry> entries = Lists.newArrayList(cursor);
			log.info("LDAP search {} filter {} returned {} entries", new Object[] { baseDn, filter, entries.size() });
			List<T> entities = Lists.transform(entries, new Function<Entry, T>() {
				@Override
				public T apply(Entry input) {
					return mapper.fromEntry(input, entityClass);
				}
			});
			return entities;
		} catch (LdapException e) {
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
	 * @return the connection
	 */
	public LdapConnection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(LdapConnection connection) {
		this.connection = connection;
	}

	/**
	 * @return the mapper
	 */
	public LdapMapper getMapper() {
		return mapper;
	}
	
}
