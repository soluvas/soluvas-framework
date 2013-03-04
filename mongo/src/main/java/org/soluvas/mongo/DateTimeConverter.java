package org.soluvas.mongo;

import java.util.Date;

import org.joda.time.DateTime;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.DBObject;

/**
 * Converts {@link DateTime} to/from {@link DBObject}.
 * 
 * <p>the target representation uses {@link Date}.
 * 
 * @author ceefour
 */
public class DateTimeConverter extends TypeConverter implements SimpleValueConverter {

	public DateTimeConverter() {
		super(DateTime.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		else
			return new DateTime(fromDBObject);
	}

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		return value != null ? ((DateTime)value).toDate() : null;
	}

}
