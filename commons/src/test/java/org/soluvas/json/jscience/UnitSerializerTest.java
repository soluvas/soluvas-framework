package org.soluvas.json.jscience;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.measure.quantity.Length;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ceefour
 *
 */
public class UnitSerializerTest {

	private static final Logger log = LoggerFactory
			.getLogger(UnitSerializerTest.class);
	private ObjectMapper objectMapper;
	
	public static class HasUnit {
		public Unit<?> unit;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
//		objectMapper.enableDefaultTypingAsProperty(DefaultTyping.OBJECT_AND_NON_CONCRETE, "@class");
		objectMapper.registerModule(new JscienceModule());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canSerializeUnit() throws JsonParseException, JsonMappingException, IOException {
		final Unit<Length> cm = SI.CENTIMETRE;
		final String expected = "\"cm\"";
		final String actual = objectMapper.writeValueAsString(cm);
		log.info("JSON: {}", actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void canSerializeTypedUnit() throws JsonParseException, JsonMappingException, IOException {
		final Unit<Length> cm = SI.CENTIMETRE;
		final String expected = "{\"unit\":\"cm\"}";
		final HasUnit hasUnit = new HasUnit();
		hasUnit.unit = cm;
		
		final String actual = objectMapper.writeValueAsString(hasUnit);
		log.info("JSON: {}", actual);
		assertEquals(expected, actual);
	}


}