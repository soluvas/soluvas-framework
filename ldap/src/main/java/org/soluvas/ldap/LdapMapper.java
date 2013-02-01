package org.soluvas.ldap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.directory.api.ldap.model.entry.Attribute;
import org.apache.directory.api.ldap.model.entry.DefaultEntry;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.exception.LdapInvalidAttributeValueException;
import org.apache.directory.api.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.api.ldap.model.message.ModifyRequest;
import org.apache.directory.api.ldap.model.message.ModifyRequestImpl;
import org.apache.directory.api.ldap.model.name.Rdn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ReflectionUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * Maps LDAP {@link Entry} with <tt>objectClass=person</tt> to POJO and back.
 * 
 * Requires Apache Commons BeanUtils.
 *  
 * @author ceefour
 */
public class LdapMapper {

	private static Logger log = LoggerFactory.getLogger(LdapMapper.class);
	/**
	 * Cache {@link LdapMapping}s so it's very fast.
	 * Note: Caching {@link Class}es may be problematic in OSGi if the {@link LdapRepository} is not restarted when
	 * classes are reloaded.
	 */
	private final LoadingCache<Class<?>, LdapMapping> mappings = CacheBuilder.newBuilder().build(new CacheLoader<Class<?>, LdapMapping>() {
		@Override
		public LdapMapping load(@Nonnull Class<?> clazz) throws Exception {
			final List<Field> fields = ReflectionUtils.getAllFields(clazz);
			
			final LdapEntry entryAnn = clazz.getAnnotation(LdapEntry.class);
			if (entryAnn == null) {
				throw new LdapMappingException(clazz.getName() + " must be annotated with @LdapEntry");
			}
			final String[] objectClasses = entryAnn.objectClasses();
			log.debug("{} maps to {} objectClasses: {}", clazz.getName(), objectClasses.length, objectClasses);
			
			log.debug("Mapping {} from {} fields: {}", clazz.getName(), fields.size(), fields);
			final ImmutableList.Builder<LdapAttributeMapping> attrMappingBuilder = ImmutableList.builder();
			LdapAttributeMapping rdnMapping = null; 
			for (final Field field : fields) {
				final LdapAttribute ldapAttribute = field.getAnnotation(LdapAttribute.class);
				if (ldapAttribute == null)
					continue;
				final String attrName = ldapAttribute.value()[0];
				final LdapRdn ldapRdn = field.getAnnotation(LdapRdn.class);
				final String fieldName = field.getName();
				try {
					if (ldapRdn != null) {
						if (rdnMapping != null) {
							throw new RuntimeException(clazz.getName() + " has multiple @LdapRdn");
						}
						rdnMapping = new LdapAttributeMapping(field, attrName, false);
						attrMappingBuilder.add(rdnMapping);
					} else {
						if (Set.class.isAssignableFrom(field.getType())) {
							final LdapAttributeMapping attrMapping = new LdapAttributeMapping(field, attrName, true);
							attrMappingBuilder.add(attrMapping);
						} else {
							final LdapAttributeMapping attrMapping = new LdapAttributeMapping(field, attrName, false);
							attrMappingBuilder.add(attrMapping);
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("Error mapping " + clazz.getName() + " property " + fieldName + " to attribute " + attrName, e);
				}
			}
			Preconditions.checkNotNull(rdnMapping, "%s has %s fields, one must have @LdapRdn annotation", clazz.getName(), fields.size());
			final LdapMapping mapping = new LdapMapping( ImmutableSet.copyOf(objectClasses), rdnMapping, attrMappingBuilder.build() );
			return mapping;
		}
	});
	
	public LdapMapper() {
		super();
	}

	public LdapMapping getMapping(@Nonnull final Class<?> clazz) {
		try {
			return mappings.get(clazz);
		} catch (ExecutionException e) {
			throw new RuntimeException("Cannot get LDAP mapping for " + clazz.getName(), e);
		}
	}
	
	/**
	 * Map a POJO object to an LDAP {@link Entry}.
	 * @param obj
	 * @param baseDn
	 * @return
	 */
	public Entry toEntry(Object obj, String baseDn) {
		final Class<?> clazz = obj.getClass();
		log.trace("Mapping {} {} as Entry in {}", new Object[] { clazz.getName(), obj, baseDn });
		
		// Create the Entry (TODO: should be after mapping is prepared)
		final DefaultEntry entry = new DefaultEntry();
		
		// Prepare the mapping from the provided object side
		
		// Prepare the mapping from the Class side
		LdapEntry entryAnn = clazz.getAnnotation(LdapEntry.class);
		if (entryAnn == null) {
			throw new LdapMappingException(clazz.getName() + " must be annotated with @LdapEntry");
		}
		final String[] objectClasses = entryAnn.objectClasses();
		log.trace("{} maps to objectClasses: {}", clazz.getName(), objectClasses);
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
	 * Return LDAP attribute IDs for the specified class.
	 * @param clazz
	 * @return
	 */
	public Set<String> getAttributeIds(Class<?> clazz) {
		final List<Field> fields = ReflectionUtils.getAllFields(clazz);
		log.trace("Mapping {} fields: {}", clazz.getName(), fields);
		final Builder<String> attributeIds = ImmutableSet.builder();
		for (final Field field : fields) {
			final LdapAttribute ldapAttribute = field.getAnnotation(LdapAttribute.class);
			if (ldapAttribute == null)
				continue;
			attributeIds.addAll(ImmutableList.copyOf(ldapAttribute.value()));
		}
		return attributeIds.build();
	}

	/**
	 * Map the fields of a specific {@link Class} to the specified, mutable, LDAP {@link Entry}, excluding objectClass-es.
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
	 * @todo Instead of mutable LDAP {@link Entry}, return {@link Set} of {@link Attribute}s instead.
	 */
	protected void mapFromProperties(@Nonnull final Object obj, String baseDn, @Nonnull final Class<?> clazz,
			@Nonnull final Entry entry) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			LdapInvalidDnException {
		final String dn = getDn(obj, baseDn);
		final LdapMapping mapping = getMapping(clazz);
		log.trace("Mapping {} to LDAP entry {} from {} mapped fields: {}", clazz.getName(), dn,
				mapping.getAttributes().size(), mapping.getAttributes());
		
		// Set DN
		entry.setDn(dn);
		
		// Attributes
		for (final LdapAttributeMapping attr : mapping.getAttributes()) {
			try {
				if (attr.isMulti()) {
					// Set value as multi attribute
					final Set<?> objValues = (Set<?>) PropertyUtils.getProperty(obj, attr.getField().getName());
					if (objValues != null) {
						if (!objValues.isEmpty()) {
							final Set<String> attrValues = ImmutableSet.copyOf( Iterables.transform(objValues, new Function<Object, String>() {
								@Override
								public String apply(Object input) {
									return convertFromPropertyValue(attr.getField().getType(), input);
								}
							}) );
							log.trace("Map {}#{} as multi {}: {}",
									clazz.getName(), attr.getField().getName(), attr.getName(), attrValues );
							entry.put(attr.getName(), attrValues.toArray(new String[] { }));
						} else {
							log.trace("Not mapping {}#{} as multi {} because it is empty",
									clazz.getName(), attr.getField().getName(), attr.getName() );
						}
					} else {
						log.trace("Not mapping null {}#{} as multi {}",
								clazz.getName(), attr.getField(), attr.getName() );
					}
				} else {
					// Set value as single attribute
					final Object objValue = PropertyUtils.getProperty(obj, attr.getField().getName());
					if (objValue != null) {
						final String attrValue = convertFromPropertyValue(attr.getField().getType(), objValue);
						log.trace("Map {}#{} as {}: {}",
								clazz.getName(), attr.getField().getName(), attr.getName(), attrValue );
						entry.put(attr.getName(), attrValue);
					} else {
						log.trace("Not mapping null {}#{} as {}", new Object[] {
								clazz.getName(), attr.getField().getName(), attr.getName() });
					}
				}
			} catch (Exception e) {
				throw new RuntimeException("Error mapping property " + attr.getField() + " to attribute " + attr.getName(), e);
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
			final T bean = clazz.newInstance();

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
	 * Get the DN of a hypothetical POJO LDAP entry.
	 * @param id
	 * @param clazz
	 * @param baseDn
	 * @return
	 */
	public String getDn(@Nonnull final String rdnValue, @Nonnull final Class<?> clazz, @Nonnull final String baseDn) {
		final LdapMapping mapping = getMapping(clazz);
		// Set DN
		try {
			if (Strings.isNullOrEmpty(rdnValue))
				throw new LdapMappingException("RDN property " + mapping.getRdn().getField() + " cannot be empty");
			final String dn = new Rdn(mapping.getRdn().getName(), rdnValue) + "," + baseDn;
			log.trace("{} has RDN {}={}, full Entry DN: {}",
					clazz.getName(), mapping.getRdn().getName(), rdnValue, dn );
			return dn;
		} catch (LdapInvalidDnException e) {
			throw new LdapMappingException("Cannot get DN for " + clazz.getName() + " with RDN " + mapping.getRdn().getName(), e);
		}
	}
	
	/**
	 * Determine DN for the specified mapped object.
	 * @param obj
	 * @param baseDn
	 * @return
	 */
	@Nonnull
	public String getDn(@Nonnull final Object obj, @Nonnull final String baseDn) {
		final Class<? extends Object> clazz = obj.getClass();
		return getDn(getRdnValue(obj), clazz, baseDn);
	}
	
	@Nullable
	public String getRdnValue(@Nonnull final Object obj) {
		final Class<? extends Object> clazz = obj.getClass();
		final LdapMapping mapping = getMapping(clazz);
		// Set DN
		try {
			final String rdnValue = BeanUtils.getProperty(obj, mapping.getRdn().getField().getName());
			return rdnValue;
		} catch (Exception e) {
			throw new LdapMappingException("Cannot get RDN for " + clazz.getName() + " with RDN name " + mapping.getRdn().getName(), e);
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
	@SuppressWarnings("unchecked")
	protected <T, R> R convertToPropertyValue(Class<R> fieldType, final Object value) {
		if (fieldType.isEnum()) {
			final R[] enumConstants = fieldType.getEnumConstants();
			R found = Iterables.find( ImmutableList.copyOf(enumConstants), new Predicate<R>() {
				@Override
				public boolean apply(R input) {
					return ((Enum<?>)input).name().equalsIgnoreCase((String) value);
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
	 * 
	 * @param existingEntry Required to get existing objectClass-es. They will only be added, not replaced nor removed.
	 * @param existing
	 * @param up
	 * @return
	 */
	public <T> ModifyRequest createModifyRequest(@Nonnull final Entry existingEntry, @Nonnull final T existing, @Nonnull final T up) {
		final ModifyRequestImpl request = new ModifyRequestImpl();
		request.setName(existingEntry.getDn());
		// Object classes
		final Set<String> existingObjectClasses = ImmutableSet.copyOf(Iterables.transform(existingEntry.get("objectClass"), new Function<Value<?>, String>() {
			@Override
			@Nullable
			public String apply(@Nullable Value<?> input) {
				return input.getString();
			}
		}));
		final LdapMapping mapping = getMapping(up.getClass());
		final Set<String> upObjectClasses = mapping.getObjectClasses();
		final Set<String> newObjectClasses = Sets.difference(upObjectClasses, existingObjectClasses);
		if (!newObjectClasses.isEmpty()) {
			request.add("objectClass", newObjectClasses.toArray(new String[] {}));
			log.debug("Adding {} new objectClass-es to {}: {}", newObjectClasses.size(), existingEntry.getDn().getName(), newObjectClasses);
		}
		// Attributes
		try {
			for (final LdapAttributeMapping attr : mapping.getAttributes()) {
				final Object oldValue = PropertyUtils.getProperty(existing, attr.getField().getName());
				final Object newValue = PropertyUtils.getProperty(up, attr.getField().getName());
				if (Objects.equal(oldValue, newValue))
					continue;
				// We can't change the RDN, sorry!
				if (attr == mapping.getRdn()) {
					throw new LdapMappingException("Old entry RDN is " + mapping.getRdn().getName() + "=" + oldValue + ", new RDN is " + mapping.getRdn().getName() + "=" + newValue +
							" but changing RDN is not supported");
				}
				if (attr.isMulti()) {
					final Set<?> newValues = (Set<?>) newValue;
					final Set<?> oldValues = (Set<?>) oldValue;
					// Welcome guys
					final SetView<?> addedValues = Sets.difference(newValues, oldValues);
					final String[] addedValueArr = Iterables.toArray(Iterables.transform(addedValues, new Function<Object, String>() {
						@Override
						@Nullable
						public String apply(@Nullable Object input) {
							return convertFromPropertyValue(attr.getField().getType(), input);
						}
					}), String.class);
					request.add(attr.getName(), addedValueArr);
					// Bye guys
					final SetView<?> removedValues = Sets.difference(oldValues, newValues);
					final String[] removedValueArr = Iterables.toArray(Iterables.transform(removedValues, new Function<Object, String>() {
						@Override
						@Nullable
						public String apply(@Nullable Object input) {
							return convertFromPropertyValue(attr.getField().getType(), input);
						}
					}), String.class);
					request.remove(attr.getName(), removedValueArr);
				} else {
					if (newValue == null || "".equals(newValue)) {
						// Bye!
						request.remove(attr.getName(), convertFromPropertyValue(attr.getField().getType(), oldValue));
					} else if (oldValue == null | "".equals(oldValue)) {
						// No old attribute, let's do an add (actually this is similar to replace)
						request.add(attr.getName(), convertFromPropertyValue(attr.getField().getType(), newValue));
					} else {
						// Let's do a replace
						request.replace(attr.getName(), convertFromPropertyValue(attr.getField().getType(), newValue));
					}
				}
			}
		} catch (Exception e) {
			throw new LdapMappingException("Cannot map " + existingEntry.getDn().getName() + " from " + up, e);
		}
		return request;
	}

}
