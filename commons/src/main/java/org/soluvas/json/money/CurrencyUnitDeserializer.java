package org.soluvas.json.money;

import java.io.IOException;

import org.joda.money.CurrencyUnit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializes Joda {@link CurrencyUnit}.
 * @author ceefour
 */
public class CurrencyUnitDeserializer extends JsonDeserializer<CurrencyUnit> {

	@Override
	public CurrencyUnit deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String text = jp.getText();
		return CurrencyUnit.of(text);
	}

}
