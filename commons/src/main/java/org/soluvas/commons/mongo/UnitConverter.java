package org.soluvas.commons.mongo;

import javax.annotation.Nullable;
import javax.measure.unit.Unit;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.DBObject;

/**
 * Converts {@link Unit} to/from {@link DBObject}.
 * @author atang
 */
public class UnitConverter extends TypeConverter implements SimpleValueConverter {

	public UnitConverter() {
		super(Unit.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("null")
	@Override
	public Unit<?> decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		else
			return Unit.valueOf((String) fromDBObject);
	}

	@Override
	public @Nullable String encode(Object value, MappedField optionalExtraInfo) {
		return value != null ? value.toString() : null;
	}

}
