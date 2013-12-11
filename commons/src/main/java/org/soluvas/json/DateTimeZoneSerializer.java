package org.soluvas.json;

import java.io.IOException;

import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializes Joda {@link DateTimeZone}.
 * Until https://jira.codehaus.org/browse/JACKSON-909 is fixed, here's my take.
 * @author ceefour
 */
public class DateTimeZoneSerializer extends JsonSerializer<DateTimeZone> {

	@Override
	public void serialize(DateTimeZone value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (value != null) {
			jgen.writeString(value.getID());
		} else {
			jgen.writeNull();
		}
	}

}
