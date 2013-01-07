/**
 * 
 */
package org.soluvas.data;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * @author haidar
 *
 */
public class DataJacksonTest {

	private static final Logger log = LoggerFactory
			.getLogger(DataJacksonTest.class);
	
	public static class ValueListContainer {
		public List<Value<?>> values;
	}
	
	public static class MapValueListContainer {
		public Map<String, List<Value<?>>> valueMap;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void serializedValueIncludesTypeInfo() {
		final TermValue value = DataFactory.eINSTANCE.createTermValue();
		value.setId("mantapgan");
		value.setValue("kerengan");
		value.setDisplayValue("Aseeeek");
		final String json = JsonUtils.asJson(value);
		log.info("JSON: {}", json);
		assertThat(json, containsString("\"@class\""));
	}

	/**
	 * Currently this test fails, and it can't succeed without breaking other purposes,
	 * if this is enabled;
	 * 
	 * objectMapper.enableDefaultTypingAsProperty(DefaultTyping.OBJECT_AND_NON_CONCRETE, "@class");
	 * 
	 * So the current workaround is, client needs to add the typing information by themselves.
	 */
	@Test
	public void serializedValueListIncludesTypeInfo() {
		final TermValue value = DataFactory.eINSTANCE.createTermValue();
		value.setId("mantapgan");
		value.setValue("kerengan");
		value.setDisplayValue("Aseeeek");
		final List<TermValue> valueList = ImmutableList.of(value);
		final String json = JsonUtils.asJson(valueList);
		log.info("JSON: {}", json);
		assertThat(json, containsString("\"@class\""));
	}

	@Test
	public void objectWithSerializedValueListIncludesTypeInfo() {
		final TermValue value = DataFactory.eINSTANCE.createTermValue();
		value.setId("mantapgan");
		value.setValue("kerengan");
		value.setDisplayValue("Aseeeek");
		final List<Value<?>> valueList = ImmutableList.<Value<?>>of(value);
		ValueListContainer cont = new ValueListContainer();
		cont.values = valueList;
		final String json = JsonUtils.asJson(cont);
		log.info("JSON: {}", json);
		assertThat(json, containsString("\"@class\""));
	}

	@Test
	public void MapWithSerializedValueListIncludesTypeInfo() {
		final TermValue value = DataFactory.eINSTANCE.createTermValue();
		value.setId("mantapgan");
		value.setValue("kerengan");
		value.setDisplayValue("Aseeeek");
		final List<Value<?>> valueList = ImmutableList.<Value<?>>of(value);
		MapValueListContainer cont = new MapValueListContainer();
		cont.valueMap = ImmutableMap.of("fabrics", valueList);
		final String json = JsonUtils.asJson(cont);
		log.info("JSON: {}", json);
		assertThat(json, containsString("\"@class\""));
	}

}
