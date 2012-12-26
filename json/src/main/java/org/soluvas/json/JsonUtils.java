package org.soluvas.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.jscience.JscienceModule;
import org.soluvas.json.money.JodaMoneyModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class JsonUtils {
	private static transient Logger log = LoggerFactory.getLogger(JsonUtils.class);

	private static ObjectWriter writer;
	public static final ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.registerModule(new JodaModule());
//		mapper.registerModule(new GuavaModule());
		mapper.registerModule(new LowerEnumModule());
		mapper.registerModule(new JodaMoneyModule());
		mapper.registerModule(new EmfModule());
		mapper.registerModule(new JscienceModule());
		writer = mapper.writer();
	}
	
	public static String asJson(Object obj) {
		try {
			return writer.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("Cannot serialize " + obj.getClass().getName() + " as JSON", e);
			return null;
		}
	}

}
