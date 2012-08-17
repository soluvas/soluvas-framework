package org.soluvas.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 */
public class LowerEnumModule extends SimpleModule {
	
	public LowerEnumModule() {
		super("soluvas-json-enum", new Version(1, 0, 0, "", "org.soluvas", "soluvas-json"));
		addSerializer(Enum.class, new LowerEnumSerializer());
	}
	
	@Override
	public void setupModule(SetupContext context) {
		super.setupModule(context);
		Base deser = new Deserializers.Base() {
			@SuppressWarnings("unchecked")
			@Override
			public JsonDeserializer<?> findEnumDeserializer(Class<?> type,
					DeserializationConfig config, BeanDescription beanDesc)
					throws JsonMappingException {
				return new LowerEnumDeserializer((Class<Enum<?>>) type);
			}
		};
		context.addDeserializers(deser);
	};

}
