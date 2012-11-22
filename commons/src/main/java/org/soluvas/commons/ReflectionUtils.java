package org.soluvas.commons;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * Useful for object mapping.
 * 
 * @author ceefour
 */
public class ReflectionUtils {

	/**
	 * Return all {@link Field}s (including private) of a {@link Class},
	 * including superclasses. Useful for object mapping.
	 * @param clazz
	 * @return
	 */
	public static List<Field> getAllFields(@Nonnull Class<?> clazz) {
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
	
}
