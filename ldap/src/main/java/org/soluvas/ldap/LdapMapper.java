package org.soluvas.ldap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.shared.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.name.Rdn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Maps LDAP {@link Entry} with <tt>objectClass=person</tt> to POJO and back.
 * 
 * Requires Apache Commons BeanUtils.
 *  
 * @author ceefour
 */
public class LdapMapper {

	private transient Logger log = LoggerFactory.getLogger(LdapMapper.class);
	
	/**
	 * Get the DN of a hypothetical POJO LDAP entry.
	 * @param id
	 * @param clazz
	 * @param baseDn
	 * @return
	 */
	public Dn toDn(String id, Class<?> clazz, String baseDn) {
		Field rdnField = null;
		String rdnAttribute = null;
		Class<?> currentClass = clazz;
		while (currentClass != null) {
			for (Field f : currentClass.getDeclaredFields()) {
				LdapAttribute ldapAttribute = f.getAnnotation(LdapAttribute.class);
				if (ldapAttribute == null)
					continue;
				LdapRdn ldapRdn = f.getAnnotation(LdapRdn.class);
				String fieldName = f.getName();
				if (ldapRdn != null) {
					rdnField = f;
					rdnAttribute = ldapAttribute.value();
					log.debug("RDN property for {} is {}#{}: {} -> LDAP attribute {}", new Object[] {
						clazz.getName(), currentClass.getName(), rdnField.getName(), rdnField.getType().getName(), rdnAttribute });	
					break;
				}
			}
			currentClass = currentClass.getSuperclass();
			if (rdnField != null)
				break;
			if (currentClass == Object.class)
				break;
		}
		
		if (rdnField == null) {
			throw new LdapMappingException("Cannot find RDN property for " + clazz.getName());
		}
		try {
			Dn dn = new Dn(new Rdn(rdnAttribute, id), new Dn(baseDn));
			log.debug("DN for {} with ID {} is {}", new Object[] {
					clazz.getName(), id, dn });	
			return dn;
		} catch (LdapInvalidDnException e) {
			throw new LdapMappingException("Invalid DN for " + clazz.getName() + " with ID " + id, e);
		}
	}
	
	/**
	 * Get the <tt>objectClass</tt>-es defined by an LDAP POJO {@link LdapEntry}-annotated entity.
	 * 
	 * The ordering of objectClass-es is special. The first objectClass will be used by
	 * {@link LdapRepository#findAll()}.
	 * 
	 * @param clazz
	 * @return
	 */
	public String[] getObjectClasses(Class<?> clazz) {
		LdapEntry entryAnn = (LdapEntry)clazz.getAnnotation(LdapEntry.class);
		if (entryAnn == null) {
			throw new LdapMappingException(clazz.getName() + " must be annotated with @LdapEntry");
		}
		String[] objectClasses = entryAnn.objectClasses();
		log.debug("{} maps to objectClasses: {}", clazz.getName(), objectClasses);
		return objectClasses;
	}
	
	/**
	 * Map a POJO object to an LDAP {@link Entry}.
	 * @param obj
	 * @param baseDn
	 * @return
	 */
	public Entry toEntry(Object obj, String baseDn) {
		Class<?> clazz = obj.getClass();
		log.debug("Mapping {} {} as Entry in {}", new Object[] { clazz.getName(), obj, baseDn });
		
		// Create the Entry (TODO: should be after mapping is prepared)
		DefaultEntry entry = new DefaultEntry();
		
		// Prepare the mapping from the provided object side
		
		
		// Prepare the mapping from the Class side
		LdapEntry entryAnn = (LdapEntry)clazz.getAnnotation(LdapEntry.class);
		if (entryAnn == null) {
			throw new LdapMappingException(clazz.getName() + " must be annotated with @LdapEntry");
		}
		String[] objectClasses = entryAnn.objectClasses();
		log.debug("{} maps to objectClasses: {}", clazz.getName(), objectClasses);
		try {
			entry.add("objectClass", objectClasses);
			
			Class<?> currentClass = clazz;
			while (currentClass != null) {
				mapFromProperties(obj, baseDn, currentClass, entry);
				currentClass = currentClass.getSuperclass();
				if (currentClass == Object.class)
					break;
			}
			
			return entry;
		} catch (LdapException e) {
			log.error("Error mapping " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping " + clazz.getName(), e);
		} catch (IllegalAccessException e) {
			log.error("Error mapping " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping " + clazz.getName(), e);
		} catch (InvocationTargetException e) {
			log.error("Error mapping " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping " + clazz.getName(), e);
		} catch (NoSuchMethodException e) {
			log.error("Error mapping " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping " + clazz.getName(), e);
		}
	}

	/**
	 * Map the fields of a specific {@link Class} to an LDAP {@link Entry}.
	 * 
	 * Fields in superclasses are not checked.
	 * 
	 * @param obj
	 * @param baseDn
	 * @param clazz
	 * @param entry
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws LdapInvalidDnException
	 */
	protected void mapFromProperties(Object obj, String baseDn, Class<?> clazz,
			Entry entry) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			LdapInvalidDnException {
		final Field[] fields = clazz.getDeclaredFields();
		log.debug("Mapping {} fields: {}", clazz.getName(), fields);
		for (Field f : fields) {
			LdapAttribute ldapAttribute = f.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			String attrName = ldapAttribute.value();
			LdapRdn ldapRdn = f.getAnnotation(LdapRdn.class);
			String fieldName = f.getName();
			if (ldapRdn != null) {
				// Set value as the RDN
				String value = BeanUtils.getSimpleProperty(obj, fieldName);
				if (value == null)
					throw new LdapMappingException("RDN property " + clazz.getName() + "#" + fieldName + " cannot be null");
				final Dn dn = new Dn(new Rdn(attrName, value), new Dn(baseDn));
				log.debug("Map {} with {}={} as Entry DN: {}", new Object[] {
					clazz.getName(), fieldName, value, dn });
				entry.put(attrName, value);
				entry.setDn(dn);
			} else {
				if (Set.class.isAssignableFrom(f.getType())) {
					// Set value as multi attribute
					Set<String> values = (Set<String>) PropertyUtils.getProperty(obj, fieldName);
					if (values != null) {
						log.trace("Map {}#{} as multi {}: {}", new Object[] {
								clazz.getName(), fieldName, attrName, values });
						entry.put(attrName, values.toArray(new String[] { }));
					} else {
						log.trace("Not mapping null {}#{} as multi {}", new Object[] {
								clazz.getName(), fieldName, attrName });
					}
				} else {
					// Set value as normal attribute
					String value = BeanUtils.getSimpleProperty(obj, fieldName);
					if (value != null) {
						log.trace("Map {}#{} as {}: {}", new Object[] {
								clazz.getName(), fieldName, attrName, value });
						entry.put(attrName, value);
					} else {
						log.trace("Not mapping null {}#{} as {}", new Object[] {
								clazz.getName(), fieldName, attrName });
					}
				}
			}
		}
	}
	
	/**
	 * Map an LDAP {@link Entry} to a POJO object.
	 * @param entry
	 * @param clazz
	 * @return
	 */
	public <T> T fromEntry(Entry entry, Class<T> clazz) {
		if (entry.getDn() == null)
			throw new LdapMappingException("LDAP Entry DN cannot be null");
		try {
			T bean = clazz.newInstance();

			Class<?> currentClass = clazz;
			while (currentClass != null) {
				mapToProperties(entry, currentClass, bean);
				currentClass = currentClass.getSuperclass();
				if (currentClass == Object.class)
					break;
			}
			
			return bean;
		} catch (InstantiationException e) {
			log.error("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
		} catch (IllegalAccessException e) {
			log.error("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
		} catch (InvocationTargetException e) {
			log.error("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
		} catch (LdapInvalidAttributeValueException e) {
			log.error("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
		} catch (NoSuchMethodException e) {
			log.error("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
			throw new LdapMappingException("Error mapping Entry " + entry.getDn() + " to " + clazz.getName(), e);
		}
	}

	/**
	 * Map {@link Entry} attributes to bean properties annotated with {@link LdapAttribute}. 
	 * @param entry
	 * @param clazz
	 * @param bean
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws LdapInvalidAttributeValueException
	 */
	protected <T> void mapToProperties(Entry entry, Class<?> clazz, T bean)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, LdapInvalidAttributeValueException {
		final Field[] fields = clazz.getDeclaredFields();
		final List<String> fieldNames = Lists.transform(ImmutableList.copyOf(fields), new Function<Field, String>() {
			@Override
			public String apply(Field input) {
				return input.getName() + ": " + input.getType().getSimpleName();
			}
		});
		log.debug("Mapping Entry attributes to fields in {}: {}", clazz.getName(), fieldNames);
		for (Field f : fields) {
			LdapAttribute ldapAttribute = f.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			String attrName = ldapAttribute.value();
			LdapRdn ldapRdn = f.getAnnotation(LdapRdn.class);
			String fieldName = f.getName();
			if (ldapRdn != null) {
				try {
					// Set value from the RDN
					String rdnValue = entry.getDn().getRdn().getValue().getString();
					log.debug("Map DN {} to {} RDN property {}={}", new Object[] {
							entry.getDn(), clazz.getName(), fieldName, rdnValue });
					BeanUtils.setProperty(bean, fieldName, rdnValue);
				} catch (Exception e) {
					throw new LdapMappingException("Cannot map DN " + entry.getDn() + " as " + clazz.getName() + "#" + fieldName, e);
				}
			} else {
				if (!entry.containsAttribute(attrName))
					continue;
				final Attribute attr = entry.get(attrName);
				if (Set.class.isAssignableFrom(f.getType())) {
					// Set value as multi attribute
					try {
						HashSet<Object> values = new HashSet<Object>();
						for (Value<?> v : attr) {
							values.add(v.getValue());
						}
						log.trace("Map {} to {}#{} as set: {}", new Object[] {
								attrName, clazz.getName(), fieldName, values });
						BeanUtils.setProperty(bean, fieldName, values);
					} catch (Exception e) {
						throw new LdapMappingException("Cannot map multi " + attrName + ": " + attr + " as " +
								clazz.getName() + "#" + fieldName + " (" + f.getType().getName() + ") from " + entry.getDn(), e);
					}
				} else {
					// Set property value from single attribute value
					try {
						Object value = attr.get().getValue();
						log.trace("Map {} to {}#{} as {}: {}", new Object[] {
								attrName, clazz.getName(), fieldName, f.getType().getName(), value });
						BeanUtils.setProperty(bean, fieldName, value);
					} catch (Exception e) {
						throw new LdapMappingException("Cannot map " + attrName + ": " + attr.get() + " as " +
								clazz.getName() + "#" + fieldName + " (" + f.getType().getName() + ") from " + entry.getDn(), e);
					}
				}
			}
		}
	}
	
}
