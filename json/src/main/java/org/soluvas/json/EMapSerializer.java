package org.soluvas.json;

import java.io.IOException;

import org.eclipse.emf.common.util.EMap;

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
 */
@SuppressWarnings("rawtypes")
public class EMapSerializer extends StdScalarSerializer<EMap> {

	public EMapSerializer() {
		super(EMap.class, false);
	}

	@Override
	public void serialize(EMap value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		jgen.writeObject(value.map());
	}

}	
