package org.soluvas.json;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.jscience.JscienceModule;
import org.zalando.jackson.datatype.money.MoneyModule;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

public class JsonUtils {
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

	private static ObjectWriter writer;

	public static final ObjectMapper mapper;

	@SuppressWarnings("unchecked")
	public static final List<Supplier<Module>> modules = (List) ImmutableList.copyOf(new Supplier[] {
		Suppliers.ofInstance(new JodaModule()),
		Suppliers.ofInstance(new GuavaModule()),
		Suppliers.ofInstance(new LowerEnumModule()),
		Suppliers.ofInstance(new MoneyModule()),
		Suppliers.ofInstance(new EmfModule()),
		Suppliers.ofInstance(new JscienceModule())
	});

	static {
		final JacksonMapperFactory jacksonMapperFactory = new JacksonMapperFactoryImpl(
				modules);
		mapper = jacksonMapperFactory.get();
//		mapper.enableDefaultTypingAsProperty(DefaultTyping.OBJECT_AND_NON_CONCRETE, "@class");
//		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		mapper.registerModule(new JodaModule());
//		mapper.registerModule(new GuavaModule());
//		mapper.registerModule(new LowerEnumModule());
//		mapper.registerModule(new JodaMoneyModule());
//		mapper.registerModule(new EmfModule());
//		mapper.registerModule(new JscienceModule());
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
