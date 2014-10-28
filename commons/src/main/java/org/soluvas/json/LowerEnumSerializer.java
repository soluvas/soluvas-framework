package org.soluvas.json;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;

/**
 * Lowercase serializer used for {@link java.lang.Enum} types.
 *<p>
 * Based on {@link StdScalarSerializer} since the JSON value is
 * scalar (String).
 * 
 * See http://jira.codehaus.org/browse/JACKSON-861
 * 
 * @author ceefour
 * @deprecated This breaks {@link JsonCreator} and {@link JsonValue} :(
 */
@Deprecated
@SuppressWarnings("rawtypes")
public class LowerEnumSerializer extends StdScalarSerializer<Enum> {
	
	/**
	 * Transitional configuration, set to false to "disable".
	 */
	public static boolean LOWER = true;

	public LowerEnumSerializer() {
		super(Enum.class, false);
	}

	@Override
	public void serialize(Enum value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		if (LOWER) {
			jgen.writeString(value.name().toLowerCase());
		} else {
			jgen.writeString(value.name());
		}
	}
}	
