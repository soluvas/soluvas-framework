package org.soluvas.ldap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

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
import org.apache.directory.shared.ldap.model.schema.AttributeType;
import org.apache.directory.shared.ldap.model.schema.SchemaManager;
import org.apache.directory.shared.ldap.schemamanager.impl.DefaultSchemaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
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
	@Nonnull private transient SchemaManager schemaManager;
	
	public LdapMapper() throws Exception {
		this(new DefaultSchemaManager());
	}

	/**
	 * @param schemaManager
	 */
	public LdapMapper(@Nonnull SchemaManager schemaManager) {
		super();
		Preconditions.checkNotNull(schemaManager, "schemaManager cannot be null");
		this.schemaManager = schemaManager;
	}

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
					rdnAttribute = ldapAttribute.value()[0];
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
		LdapEntry entryAnn = clazz.getAnnotation(LdapEntry.class);
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
		log.trace("Mapping {} {} as Entry in {}", new Object[] { clazz.getName(), obj, baseDn });
		Preconditions.checkNotNull(schemaManager, "schemaManager cannot be null");
		
		// Create the Entry (TODO: should be after mapping is prepared)
		DefaultEntry entry = new DefaultEntry(schemaManager);
		
		// Prepare the mapping from the provided object side
		
		
		// Prepare the mapping from the Class side
		LdapEntry entryAnn = clazz.getAnnotation(LdapEntry.class);
		if (entryAnn == null) {
			throw new LdapMappingException(clazz.getName() + " must be annotated with @LdapEntry");
		}
		String[] objectClasses = entryAnn.objectClasses();
		log.trace("{} maps to objectClasses: {}", clazz.getName(), objectClasses);
		try {
			AttributeType objectClassAttrType = schemaManager.getAttributeType("objectClass");
			Preconditions.checkNotNull(objectClassAttrType, "Cannot find AttributeType for 'objectClass' (2.5.4.0) using %s", schemaManager);
			entry.add(objectClassAttrType, objectClasses);
			
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
	 * Return all {@link Field}s (including private) of a {@link Class},
	 * including superclasses.
	 * @param clazz
	 * @return
	 */
	public Set<Field> getAllFields(@Nonnull Class<?> clazz) {
		Preconditions.checkNotNull(clazz, "clazz must not be null");
		
		Builder<Field> fieldsBuilder = ImmutableSet.builder();
		final Field[] ownFields = clazz.getDeclaredFields();
		fieldsBuilder.addAll(ImmutableList.copyOf(ownFields));

		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> iface : interfaces) {
			fieldsBuilder.addAll( getAllFields(iface) );
		}
		
		Class<?> superclass = clazz.getSuperclass();
		if (superclass != null) {
			fieldsBuilder.addAll( getAllFields(superclass) );
		}
		
		return fieldsBuilder.build();
	}
	
	/**
	 * Return LDAP attribute IDs for the specified class.
	 * @param clazz
	 * @return
	 */
	public Set<String> getAttributeIds(Class<?> clazz) {
		final Set<Field> fields = getAllFields(clazz);
		log.trace("Mapping {} fields: {}", clazz.getName(), fields);
		Builder<String> attributeIds = ImmutableSet.builder();
		for (final Field field : fields) {
			LdapAttribute ldapAttribute = field.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			attributeIds.addAll(ImmutableList.copyOf(ldapAttribute.value()));
		}
		return attributeIds.build();
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
		log.trace("Mapping {} fields: {}", clazz.getName(), fields);
		for (final Field field : fields) {
			LdapAttribute ldapAttribute = field.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			String attrName = ldapAttribute.value()[0];
			final AttributeType attrType = schemaManager.getAttributeType(attrName);
			Preconditions.checkNotNull(attrType, "Cannot find attribute %s in schema %s", attrName, schemaManager);
			LdapRdn ldapRdn = field.getAnnotation(LdapRdn.class);
			String fieldName = field.getName();
			try {
				if (ldapRdn != null) {
					// Set value as the RDN
					String value = BeanUtils.getSimpleProperty(obj, fieldName);
					if (value == null)
						throw new LdapMappingException("RDN property " + clazz.getName() + "#" + fieldName + " cannot be null");
					final Dn dn = new Dn(new Rdn(attrName, value), new Dn(baseDn));
					log.trace("Map {} with {}={} as Entry DN: {}",
						clazz.getName(), fieldName, value, dn );
					entry.put(attrType, value);
					entry.setDn(dn);
				} else {
					if (Set.class.isAssignableFrom(field.getType())) {
						// Set value as multi attribute
						Set<Object> objValues = (Set<Object>) PropertyUtils.getProperty(obj, fieldName);
						if (objValues != null) {
							Set<String> attrValues = ImmutableSet.copyOf( Iterables.transform(objValues, new Function<Object, String>() {
								@Override
								public String apply(Object input) {
									return convertFromPropertyValue(field.getType(), input);
								}
							}) );
							log.trace("Map {}#{} as multi {} ({}): {}",
									clazz.getName(), fieldName, attrName, attrType.getOid(), attrValues );
							entry.put(attrType, attrValues.toArray(new String[] { }));
						} else {
							log.trace("Not mapping null {}#{} as multi {}",
									clazz.getName(), fieldName, attrName );
						}
					} else {
						// Set value as single attribute
						Object objValue = PropertyUtils.getProperty(obj, fieldName);
						if (objValue != null) {
							String attrValue = convertFromPropertyValue(field.getType(), objValue);
							log.trace("Map {}#{} as {} ({}): {}",
									clazz.getName(), fieldName, attrName, attrType.getOid(), attrValue );
							entry.put(attrType, attrValue);
						} else {
							log.trace("Not mapping null {}#{} as {}", new Object[] {
									clazz.getName(), fieldName, attrName });
						}
					}
				}
			} catch (Exception e) {
				throw new RuntimeException("Error mapping property " + fieldName + " to attribute " + attrName, e);
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
		for (Field field : fields) {
			LdapAttribute ldapAttribute = field.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			String[] attrNames = ldapAttribute.value();
			LdapRdn ldapRdn = field.getAnnotation(LdapRdn.class);
			String fieldName = field.getName();
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
				for (String attrName : attrNames) {
					if (entry.containsAttribute(attrName)) {
						final Attribute attr = entry.get(attrName);
						if (Set.class.isAssignableFrom(field.getType())) {
							// Set value as multi attribute
							try {
								HashSet<Object> values = new HashSet<Object>();
								for (Value<?> v : attr) {
									Object converted = convertToPropertyValue(field.getType(), v.getValue());
									values.add(converted);
								}
								log.trace("Map {} to {}#{} as set: {}", new Object[] {
										attrName, clazz.getName(), fieldName, values });
								BeanUtils.setProperty(bean, fieldName, values);
							} catch (Exception e) {
								throw new LdapMappingException("Cannot map multi " + attrName + ": " + attr + " as " +
										clazz.getName() + "#" + fieldName + " (" + field.getType().getName() + ") from " + entry.getDn(), e);
							}
						} else {
							// Set property value from single attribute value
							try {
								Object value = attr.get().getValue();
								Object converted = convertToPropertyValue(field.getType(), value);
								log.trace("Map {} to {}#{} as {}: {}", new Object[] {
										attrName, clazz.getName(), fieldName, field.getType().getName(), converted });
								BeanUtils.setProperty(bean, fieldName, converted);
							} catch (Exception e) {
								throw new LdapMappingException("Cannot map " + attrName + ": " + attr.get() + " as " +
										clazz.getName() + "#" + fieldName + " (" + field.getType().getName() + ") from " + entry.getDn(), e);
							}
						}
						// attribute name alias found, so break
						break;
					}
				}
			}
		}
	}

	/**
	 * Convert from an LDAP value (usually string) to a Bean property value. 
	 * @param bean
	 * @param fieldName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected <T, R> R convertToPropertyValue(Class<R> fieldType, final Object value) {
		if (fieldType.isEnum()) {
			final R[] enumConstants = fieldType.getEnumConstants();
			R found = Iterables.find( ImmutableList.copyOf(enumConstants), new Predicate<R>() {
				@Override
				public boolean apply(R input) {
					return ((Enum)input).name().equalsIgnoreCase((String) value);
				};
			}, null);
			if (found == null)
				throw new IllegalArgumentException("Cannot convert '" + value +"' to " + fieldType.getName() +
						". Valid values are: " + enumConstants);
			return found;
		} else if (value instanceof byte[]) {
			// Byte array, usually userPassword
			return (R) new String((byte[])value, Charsets.UTF_8);
		} else {
			return (R) value;
		}
	}

	/**
	 * Convert from Bean property value (can be {@link Enum}) to an LDAP attribute value (usually String, but can be Long).
	 * @param bean
	 * @param fieldName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected String convertFromPropertyValue(Class<?> fieldType, final Object value) {
		if (value == null) {
			return null;
		} else if (fieldType.isEnum()) {
			return ((Enum<?>) value).name().toLowerCase();
		} else {
			return value.toString();
		}
	}

	/**
	 * @return the schemaManager
	 */
	public SchemaManager getSchemaManager() {
		return schemaManager;
	}

	/**
	 * @param schemaManager the schemaManager to set
	 */
	public void setSchemaManager(SchemaManager schemaManager) {
		this.schemaManager = schemaManager;
	}

}
