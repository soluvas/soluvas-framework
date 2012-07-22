package org.soluvas.ldap;

import java.util.List;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.name.Dn;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * @author ceefour
 */
public interface LdapRepository<T> {

	void init();
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	T add(T obj);
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @param removeExtraAttributes
	 * @return
	 * @throws LdapException
	 */
	T modify(T obj, boolean removeExtraAttributes);

	/**
	 * Delete an LDAP entry.
	 * @param obj
	 * @throws LdapException
	 */
	void delete(T obj);
	
	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 */
	void delete(String id);
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	T findOne(String id);

	/**
	 * Find LDAP entry based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	T findOneByAttribute(String attribute, String value);
	
	/**
	 * Find all LDAP entries of the same <tt>objectClass</tt>-es as the {@link LdapEntity}#objectClasses() annotation.
	 * @param obj
	 * @throws LdapException
	 */
	List<T> findAll();

	/**
	 * @return the baseDn
	 */
	String getBaseDn();

	/**
	 * @param baseDn the baseDn to set
	 */
	void setBaseDn(String baseDn);

	/**
	 * @return the entityClass
	 */
	Class<T> getEntityClass();

	/**
	 * @param entityClass the entityClass to set
	 */
	void setEntityClass(Class<T> entityClass);

	/**
	 * @return the mapper
	 */
	LdapMapper getMapper();

	/**
	 * Get the entry {@link Dn} for the specified entry ID.
	 * @param id entry ID.
	 * @return Entry DN.
	 */
	Dn toDn(String id);

}
