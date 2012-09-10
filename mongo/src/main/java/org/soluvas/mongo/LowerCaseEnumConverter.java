package org.soluvas.mongo;

import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;

import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.google.common.base.Throwables;

/**
 * Converts {@link LowerCaseEnum}.
 * @author atang
 * @deprecated I can't make this work... probably something wrong with Morphia.
 * http://code.google.com/p/morphia/issues/detail?id=412
 */
@Deprecated
public class LowerCaseEnumConverter extends TypeConverter {

	@Override
	protected boolean isSupported(Class<?> c, MappedField optionalExtraInfo) {
		boolean supported = LowerCaseEnum.class.isAssignableFrom(c);
		LoggerFactory.getLogger(getClass()).debug("{} supported {}", c.getName(), supported);
		return supported;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" }) @Override
	public Object decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		try {
			String upperValue = fromDBObject.toString().toUpperCase();
			// Same as calling handcoded:
			// Booking.Status bookingStatus = Booking.Status.valueOf("CLOSED");
			// BookingDetail.Status detailStatus = BookingDetail.Status.valueOf("EXPIRED");
			Method valueOfMethod = targetClass.getDeclaredMethod("valueOf", String.class);
			Object result = valueOfMethod.invoke(null, upperValue);
			return result;
		} catch (Exception e) {
			Throwables.propagate(e);
			return null;
		}
	}

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		return ((Enum<?>)value).name().toLowerCase();
	}

}
