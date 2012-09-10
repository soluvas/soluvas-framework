package org.soluvas.mongo;

import java.math.BigDecimal;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;

/**
 * Converts {@link BigDecimal}.
 * @author atang
 */
public class BigDecimalConverter extends TypeConverter implements SimpleValueConverter {

	public BigDecimalConverter() {
		super(BigDecimal.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject instanceof Double)
			return new BigDecimal((Double)fromDBObject);
		else
			return new BigDecimal((String)fromDBObject);
	}

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		return value.toString();
	}

}
