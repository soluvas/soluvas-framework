package org.soluvas.commons.mongo;

import java.math.BigDecimal;

import javax.annotation.Nullable;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.DBObject;

/**
 * Converts {@link BigDecimal} to/from {@link DBObject}.
 * 
 * <p>The MongoDB representation is the {@link BigDecimal#doubleValue()}.
 * 
 * @author atang
 */
public class BigDecimalConverter extends TypeConverter implements SimpleValueConverter {

//	private static final BigDecimal MULTIPLICAND = new BigDecimal(10000);

	public BigDecimalConverter() {
		super(BigDecimal.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("null")
	@Override
	public BigDecimal decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		// long x 10000 is no longer used, we now use double.
		// 12345 => 1.2345
		// 12300 => 1.23
		// (because preferred decimal precision is 0, but max decimal precision is 4)
		if (fromDBObject == null)
			return null;
//		else if (fromDBObject instanceof Long)
//			return new BigDecimal((Long)fromDBObject).divide(MULTIPLICAND);
//		else if (fromDBObject instanceof Integer)
//			return new BigDecimal((Integer)fromDBObject).divide(MULTIPLICAND);
		else if (fromDBObject instanceof Long)
			return new BigDecimal((Long)fromDBObject);
		else if (fromDBObject instanceof Integer)
			return new BigDecimal((Integer)fromDBObject);
		else if (fromDBObject instanceof Double)
			return new BigDecimal((Double)fromDBObject);
		else if (fromDBObject instanceof Float)
			return new BigDecimal((Float)fromDBObject);
		else
			return new BigDecimal((String)fromDBObject);
	}

	@Override
	public @Nullable Double encode(Object value, MappedField optionalExtraInfo) {
//		return value != null ? ((BigDecimal) value).multiply(MULTIPLICAND).longValue() : null;
		return value != null ? ((BigDecimal) value).doubleValue() : null;
	}

}
