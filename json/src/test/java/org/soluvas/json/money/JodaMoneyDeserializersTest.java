/**
 * 
 */
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
public class JodaMoneyDeserializersTest {

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
	public void canDeserializeStringMoney() throws JsonParseException, JsonMappingException, IOException {
		Money expected = Money.of(CurrencyUnit.of("IDR"), new BigDecimal("501251"));
		Money money = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"amount\": \"501250.95\"}", Money.class);
		assertNotNull(money);
		assertEquals(expected.getCurrencyUnit(), money.getCurrencyUnit());
		assertThat(money.getAmount(), comparesEqualTo(expected.getAmount()));
	}

	@Test
	public void canDeserializeDoubleMoney() throws JsonParseException, JsonMappingException, IOException {
		Money expected = Money.of(CurrencyUnit.of("IDR"), new BigDecimal("501251"));
		Money money = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"amount\": 501250.95}", Money.class);
		assertNotNull(money);
		assertEquals(expected.getCurrencyUnit(), money.getCurrencyUnit());
		assertThat(money.getAmount(), comparesEqualTo(expected.getAmount()));
	}

	@Test
	public void canDeserializeMoneyReversed() throws JsonParseException, JsonMappingException, IOException {
		Money expected = Money.of(CurrencyUnit.of("IDR"), new BigDecimal("501251"));
		Money money = objectMapper.readValue("{\"amount\": \"501250.95\", \"currencyCode\": \"IDR\"}", Money.class);
		assertNotNull(money);
		assertEquals(expected.getCurrencyUnit(), money.getCurrencyUnit());
		assertThat(money.getAmount(), comparesEqualTo(expected.getAmount()));
	}

	@Test
	public void canDeserializeNullMoney() throws JsonParseException, JsonMappingException, IOException {
		Money money = objectMapper.readValue("null", Money.class);
		assertNull(money);
	}
	
	@Test
	public void canDeserializeStringBigMoney() throws JsonParseException, JsonMappingException, IOException {
		BigMoney expected = BigMoney.of(CurrencyUnit.of("IDR"), new BigDecimal("501250.95"));
		BigMoney money = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"amount\": \"501250.95\"}", BigMoney.class);
		assertNotNull(money);
		assertEquals(expected.getCurrencyUnit(), money.getCurrencyUnit());
		assertThat(money.getAmount(), comparesEqualTo(expected.getAmount()));
	}
	
	@Test
	public void canDeserializeDoubleBigMoney() throws JsonParseException, JsonMappingException, IOException {
		BigMoney expected = BigMoney.of(CurrencyUnit.of("IDR"), new BigDecimal("501250.95"));
		BigMoney money = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"amount\": 501250.95}", BigMoney.class);
		assertNotNull(money);
		assertEquals(expected.getCurrencyUnit(), money.getCurrencyUnit());
		assertThat(money.getAmount(), comparesEqualTo(expected.getAmount()));
	}
	
	@Test
	public void canDeserializeNullBigMoney() throws JsonParseException, JsonMappingException, IOException {
		BigMoney money = objectMapper.readValue("null", BigMoney.class);
		assertNull(money);
	}
	
}
