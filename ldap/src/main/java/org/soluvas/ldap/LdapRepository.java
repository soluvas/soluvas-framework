package org.soluvas.ldap;

import java.util.List;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.exception.LdapException;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * @author ceefour
 */
public interface LdapRepository<T> {

	public void init();
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
	public T add(T obj);
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @param removeExtraAttributes
	 * @return
	 * @throws LdapException
	 */
	public T modify(T obj, boolean removeExtraAttributes);

	/**
	 * Delete an LDAP entry.
	 * @param obj
	 * @throws LdapException
	 */
	public void delete(T obj);
	
	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 */
	public void delete(String id);
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	public T findOne(String id);

	/**
	 * Find LDAP entry based on an attribute value. The attribute does not need to be
	 * {@link LdapAttribute} annotated.
	 * 
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	public T findOneByAttribute(String attribute, String value);
	
	/**
	 * Find all LDAP entries of the same <tt>objectClass</tt>-es as the {@link LdapEntity}#objectClasses() annotation.
	 * @param obj
	 * @throws LdapException
	 */
	public List<T> findAll();

	/**
	 * @return the baseDn
	 */
	public String getBaseDn();

	/**
	 * @param baseDn the baseDn to set
	 */
	public void setBaseDn(String baseDn);

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass();

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass);

	/**
	 * @return the connection
	 */
	public LdapConnection getConnection();

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(LdapConnection connection);

	/**
	 * @return the mapper
	 */
	public LdapMapper getMapper();
	
}
