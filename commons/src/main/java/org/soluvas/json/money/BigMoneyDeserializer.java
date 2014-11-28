package org.soluvas.json.money;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializes Joda {@link BigMoney}.
 * @author ceefour
 */
public class BigMoneyDeserializer extends JsonDeserializer<BigMoney> {

	@Override
	public BigMoney deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, Object> obj = jp.readValueAs(new TypeReference<Map<String, Object>>() {});
		// WARNING: MathContext.DECIMAL64 is not accurate! Please use string amount when serializing Money/BigMoney!
		return BigMoney.of(CurrencyUnit.of((String)obj.get("currency")),
				obj.get("amount") instanceof Double ? new BigDecimal((Double)obj.get("amount"), MathContext.DECIMAL64) : new BigDecimal(obj.get("amount").toString()));
	}

}
