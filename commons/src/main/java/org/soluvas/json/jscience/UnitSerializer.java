package org.soluvas.json.jscience;

import java.io.IOException;

import javax.measure.unit.Unit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializes JScience {@link Unit}.
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class UnitSerializer extends JsonSerializer<Unit> {

	@Override
	public void serialize(Unit value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeString(value.toString());
	}

}
