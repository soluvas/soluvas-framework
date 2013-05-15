package org.soluvas.commons;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.inject.Supplied;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

/**
 * Useful for object mapping.
 * 
 * @author ceefour
 */
public class ReflectionUtils {

	private static final Logger log = LoggerFactory
			.getLogger(ReflectionUtils.class);
	
	/**
	 * Return all {@link Field}s (including private) of a {@link Class},
	 * including superclasses. Useful for object mapping and dependency injection.
	 * @param clazz
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> clazz) {
		Preconditions.checkNotNull(clazz, "clazz must not be null");
		
		final ImmutableList.Builder<Field> fieldsBuilder = ImmutableList.builder();
		
		final Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> iface : interfaces) {
			fieldsBuilder.addAll( getAllFields(iface) );
		}
		
		final Class<?> superclass = clazz.getSuperclass();
		if (superclass != null) {
			fieldsBuilder.addAll( getAllFields(superclass) );
		}
		
		final Field[] ownFields = clazz.getDeclaredFields();
		fieldsBuilder.addAll(ImmutableList.copyOf(ownFields));
		
		return fieldsBuilder.build();
	}

	/**
	 * Return all @{@link Inject} {@link Field}s (including private) of a {@link Class},
	 * including superclasses. Useful for dependency injection.
	 * @param clazz
	 * @return
	 */
	public static List<Field> getInjectFields(Class<?> clazz) {
		final List<Field> allFields = getAllFields(clazz);
		final Collection<Field> fields = Collections2.filter(allFields,
				new Predicate<Field>() {
					@Override
					public boolean apply(@Nullable Field field) {
						final Inject injectAnn = field.getAnnotation(Inject.class);
						return injectAnn != null;
					}
				});
		final List<Field> fieldList = ImmutableList.copyOf(fields);
		log.trace("{} has {} @Inject fields: {}", clazz,
				fieldList.size(), fieldList);
		return fieldList;
	}
	
	/**
	 * Return all non-@{@link Supplied} @{@link Inject} {@link Field}s (including private) of a {@link Class},
	 * including superclasses. Useful for dependency injection.
	 * @param clazz
	 * @return
	 */
	public static List<Field> getNonSuppliedFields(Class<?> clazz) {
		final List<Field> injectFields = getInjectFields(clazz);
		final Collection<Field> fields = Collections2.filter(injectFields,
				new Predicate<Field>() {
					@Override
					public boolean apply(@Nullable Field field) {
						final Supplied suppliedAnn = field.getAnnotation(Supplied.class);
						return suppliedAnn == null;
					}
				});
		final List<Field> fieldList = ImmutableList.copyOf(fields);
		log.trace("{} has {} non-@Supplied fields: {}", clazz,
				fieldList.size(), fieldList);
		return fieldList;
	}

	/**
	 * Return all @{@link Supplied} {@link Inject} {@link Field}s (including private) of a {@link Class},
	 * including superclasses. Useful for dependency injection.
	 * @param clazz
	 * @return
	 */
	public static List<Field> getSuppliedFields(Class<?> clazz) {
		final List<Field> injectFields = getInjectFields(clazz);
		final Collection<Field> fields = Collections2.filter(injectFields,
				new Predicate<Field>() {
					@Override
					public boolean apply(@Nullable Field field) {
						final Supplied suppliedAnn = field.getAnnotation(Supplied.class);
						return suppliedAnn != null;
					}
				});
		final List<Field> fieldList = ImmutableList.copyOf(fields);
		log.trace("{} has {} @Supplied fields: {}", clazz,
				fieldList.size(), fieldList);
		return fieldList;
	}
	
}
