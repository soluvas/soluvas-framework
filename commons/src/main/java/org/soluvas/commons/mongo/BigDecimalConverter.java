package org.soluvas.commons.mongo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

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
	/**
	 * max 8 fraction digits (Bitcoin is 8 decimal digits), and arbitrary integer digits, no scientific notation. 
	 */
	static final DecimalFormat MONEY_FORMAT = new DecimalFormat("#0.########", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

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
		// (because preferred decimal precision is 0, but max decimal precision is 8)
		// note: double (and BigDecimal supports it too) sometimes gives exponential format/scientific notation e.g. 1.2345e+4 
		if (fromDBObject == null)
			return null;
//		else if (fromDBObject instanceof Long)
//			return new BigDecimal((Long)fromDBObject).divide(MULTIPLICAND);
//		else if (fromDBObject instanceof Integer)
//			return new BigDecimal((Integer)fromDBObject).divide(MULTIPLICAND);
		else if (fromDBObject instanceof Long)
			return BigDecimal.valueOf((Long)fromDBObject);
		else if (fromDBObject instanceof Integer)
			return BigDecimal.valueOf((Integer)fromDBObject);
		else if (fromDBObject instanceof Double)
			return new BigDecimal(MONEY_FORMAT.format(fromDBObject));// DON'T: will cause exponent: .stripTrailingZeros(); 
		else if (fromDBObject instanceof Float)
			return new BigDecimal(MONEY_FORMAT.format(fromDBObject));// DON'T: will cause exponent: .stripTrailingZeros();
		else {
			final String stringObj = (String)fromDBObject;
			if (StringUtils.containsIgnoreCase(stringObj, "e")) {
				// remove exponent
				return new BigDecimal(new BigDecimal(stringObj).toPlainString());
			} else {
				return new BigDecimal(stringObj);// DON'T: will cause exponent: .stripTrailingZeros();
			}
		}
	}

	@Override
	public @Nullable Double encode(Object value, MappedField optionalExtraInfo) {
//		return value != null ? ((BigDecimal) value).multiply(MULTIPLICAND).longValue() : null;
		return value != null ? ((BigDecimal) value).doubleValue() : null;
	}

}
