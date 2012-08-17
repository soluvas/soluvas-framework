package org.soluvas.json.money;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.math.BigDecimal;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.json.money.JodaMoneyModule;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 *
 */
public class JodaMoneySerializersTest {

	private ObjectMapper objectMapper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JodaMoneyModule());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canSerializeMoney() throws JsonParseException, JsonMappingException, IOException {
		Money money = Money.of(CurrencyUnit.of("IDR"), new BigDecimal("501251"));
		String expected = "{\"currencyCode\":\"IDR\",\"amount\":\"501251\"}";
		String actual = objectMapper.writeValueAsString(money);
		assertEquals(expected, actual);
	}

	@Test
	public void canSerializeBigMoney() throws JsonParseException, JsonMappingException, IOException {
		BigMoney money = BigMoney.of(CurrencyUnit.of("IDR"), new BigDecimal("501251.95"));
		String expected = "{\"currencyCode\":\"IDR\",\"amount\":\"501251.95\"}";
		String actual = objectMapper.writeValueAsString(money);
		assertEquals(expected, actual);
	}

}
