package org.soluvas.json;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ceefour
 *
 */
public class EMapDeserializerTest {

	private static final Logger log = LoggerFactory
			.getLogger(EMapDeserializerTest.class);
	private ObjectMapper objectMapper;
	
	public static class Person {
		private String name;
	}

	public static class EMapWithObject {
		@JsonTypeInfo(use=Id.CLASS, property="@class")
		@JsonProperty
		private EMap<Object, Object> eMap;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final int maxLen = 10;
			return "EMapWithObject ["
					+ (eMap != null ? "eMap="
							+ eMap.subList(0, Math.min(eMap.size(), maxLen))
							: "") + "]";
		}
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new EmfModule());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canDeserializeSimpleEMap() throws JsonParseException, JsonMappingException, IOException {
//		BasicEMap<String, String> eMap = new BasicEMap<String, String>(ImmutableMap.of("hallo", "Yuhu"));
		EMap<Object, Object> eMap = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"amount\": 501250.95}",
				EMap.class);
		log.info("EMap {}", eMap);
		assertNotNull(eMap);
		assertThat(eMap, hasSize(2));
	}

	@Test
	public void canDeserializeEMapAndObject() throws JsonParseException, JsonMappingException, IOException {
//		BasicEMap<String, String> eMap = new BasicEMap<String, String>(ImmutableMap.of("hallo", "Yuhu"));
		EMapWithObject eMapWithObject = objectMapper.readValue("{\"eMap\": {\"currencyCode\": \"IDR\", \"person\": {\"@class\": \"org.soluvas.json.EMapDeserializerTest.Person\", \"name\": \"Rudi\"}} }",
				EMapWithObject.class);
		log.info("EMap {}", eMapWithObject);
		assertNotNull(eMapWithObject);
		assertThat(eMapWithObject.eMap, hasSize(2));
	}

	@Test
	public void canDeserializeEMapAndList() throws JsonParseException, JsonMappingException, IOException {
//		BasicEMap<String, String> eMap = new BasicEMap<String, String>(ImmutableMap.of("hallo", "Yuhu"));
		EMap<Object, Object> eMap = objectMapper.readValue("{\"currencyCode\": \"IDR\", \"attributes\": [{\"@class\": \"org.soluvas.json.EMapDeserializerTest.Person\", \"name\": \"Rudi\"}]}",
				EMap.class);
		log.info("EMap {}", eMap);
		assertNotNull(eMap);
		assertThat(eMap, hasSize(2));
		assertThat(eMap.get("attributes"), instanceOf(EList.class));
	}

}
