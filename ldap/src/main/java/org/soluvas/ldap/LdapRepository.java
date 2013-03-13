package org.soluvas.ldap;

import java.util.List;

import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.name.Dn;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.repository.BasicRepository;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.Repository;

/**
 * Manages LDAP entry POJO objects annotated with {@link LdapEntry}.
 * @author ceefour
 * @todo Extend {@link CrudRepository}.
 */
public interface LdapRepository<T> extends EntityLookup<T, String>, Repository<T, String>,
	BasicRepository, CrudRepository<T, String> {

	void init();
	
	/**
	 * Add an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @throws LdapException
	 */
//	public abstract T add(T obj);
	
	/**
	 * Modify an LDAP {@link Entry} from typed POJO object.
	 * @param obj
	 * @return
	 * @throws LdapException
	 */
	T modify(T obj);

	/**
	 * Modifies a given entity. Some repositories may allow modifying the {@code id} attribute.
	 * 
	 * @param entities
	 * @return the modified entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
//	public abstract T modify(@Nonnull String id, @Nonnull T entity);

	/**
	 * Delete an LDAP entry.
	 * @param obj
	 * @throws LdapException
	 */
//	@Override
//	void delete(T obj);
	
	/**
	 * Delete an LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 */
//	@Override
//	void delete(String id);
	
	/**
	 * Find LDAP entry based on ID, a {@link LdapRdn} annotated property.
	 * @param obj
	 * @throws LdapException
	 * @return T entity or <tt>null</tt> if none found.
	 */
	@Override
	<U extends T> U findOne(String id);

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
	@Override
	List<T> findAll();

	/**
	 * Find all LDAP entries partially matching a specified searchText.
	 * @param obj
	 * @throws LdapException
	 */
	List<T> search(String searchText);

	/**
	 * Find all LDAP entries matching a custom LDAP filter.
	 * @param obj
	 * @throws LdapException
	 */
	List<T> findAllByFilter(String filter);

	/**
	 * @return the baseDn
	 */
	String getBaseDn();

	/**
	 * @return the entityClass
	 */
	Class<? extends T> getEntityClass();

	/**
	 * @return the mapper
	 */
	LdapMapper<T> getMapper();

	/**
	 * Get the entry {@link Dn} for the specified entry ID.
	 * @param id entry ID.
	 * @return Entry DN.
	 */
	String toDn(String id);

	@Override
	boolean exists(String id);

	boolean existsByAttribute(String attribute, String value);

}
