package org.soluvas.json.money;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializes Joda {@link Money}.
 * @author ceefour
 */
public class MoneyDeserializer extends JsonDeserializer<Money> {

	@Override
	public Money deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, Object> obj = jp.readValueAs(new TypeReference<Map<String, Object>>() {});
		return Money.of(CurrencyUnit.of((String)obj.get("currencyCode")),
				obj.get("amount") instanceof Double ? new BigDecimal((Double)obj.get("amount")) : new BigDecimal(obj.get("amount").toString()),
						RoundingMode.HALF_EVEN);
	}

}
