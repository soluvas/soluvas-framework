package org.soluvas.json.money;

import java.io.IOException;

import org.joda.money.BigMoney;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableMap;

/**
 * Serializes Joda {@link BigMoney}.
 * @author ceefour
 */
public class BigMoneySerializer extends JsonSerializer<BigMoney> {

	@Override
	public void serialize(BigMoney value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeObject(ImmutableMap.of("currency", value.getCurrencyUnit().getCode(),
				"amount", value.getAmount().toPlainString() ));
	}

}
