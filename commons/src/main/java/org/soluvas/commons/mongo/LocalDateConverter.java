package org.soluvas.commons.mongo;

import java.util.Date;

import javax.annotation.Nullable;

import org.joda.time.LocalDate;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.DBObject;

/**
 * Converts {@link LocalDate} to/from {@link DBObject}.
 * 
 * <p>the target representation uses {@link Date}.
 * 
 * @author ceefour
 */
public class LocalDateConverter extends TypeConverter implements SimpleValueConverter {

	public LocalDateConverter() {
		super(LocalDate.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("null")
	@Override
	public LocalDate decode(@Nullable Class targetClass, @Nullable Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		else
			return new LocalDate(fromDBObject);
	}

	@Override
	public @Nullable String encode(Object value, MappedField optionalExtraInfo) {
		return value != null ? ((LocalDate)value).toString() : null;
	}

}
