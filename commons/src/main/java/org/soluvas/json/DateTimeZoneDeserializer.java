package org.soluvas.json;

import java.io.IOException;

import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializes Joda {@link DateTimeZone}.
 * Until https://jira.codehaus.org/browse/JACKSON-909 is fixed, here's my take.
 * @author ceefour
 */
public class DateTimeZoneDeserializer extends JsonDeserializer<DateTimeZone> {

	@Override
	public DateTimeZone deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String text = jp.getText();
		return text != null ? DateTimeZone.forID(text) : null;
	}

}
