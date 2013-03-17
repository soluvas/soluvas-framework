package org.soluvas.json.jscience;

import java.io.IOException;

import javax.measure.unit.Unit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializes Joda {@link Unit}.
 * @author ceefour
 */
public class UnitDeserializer extends JsonDeserializer<Unit<?>> {

	@Override
	public Unit<?> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String text = jp.getText();
		return Unit.valueOf(text);
	}

}
