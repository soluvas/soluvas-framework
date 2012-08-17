package org.soluvas.json.money;

import java.io.IOException;

import org.joda.money.Money;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableMap;

/**
 * Serializes Joda {@link Money}.
 * @author ceefour
 */
public class MoneySerializer extends JsonSerializer<Money> {

	@Override
	public void serialize(Money value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeObject(ImmutableMap.of("currencyCode", value.getCurrencyUnit().getCode(),
				"amount", value.getAmount().toPlainString() ));
	}

}
