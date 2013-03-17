package org.soluvas.json.money;

import java.io.IOException;

import org.joda.money.CurrencyUnit;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializes JScience {@link CurrencyUnit}.
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class CurrencyUnitSerializer extends JsonSerializer<CurrencyUnit> {

	@Override
	public void serialize(CurrencyUnit value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeString(value.toString());
	}

}
