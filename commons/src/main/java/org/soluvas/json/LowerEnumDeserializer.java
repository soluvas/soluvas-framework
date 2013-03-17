package org.soluvas.json;

import java.io.IOException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

/**
 * Deserializer class that can deserialize instances of
 * specified Enum class from Strings and Integers,
 * uppercasing before deserialization.
 * @author ceefour
 */
public class LowerEnumDeserializer extends StdScalarDeserializer<Enum<?>> {

	private static final Logger log = LoggerFactory
			.getLogger(LowerEnumDeserializer.class);
	
	protected LowerEnumDeserializer(Class<Enum<?>> clazz) {
		super(clazz);
	}

	@Override
	public Enum<?> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String jpText = jp.getText();
		if (jpText == null)
			return null;
		String text = jpText.toUpperCase();
		try {
			Method valueOfMethod = getValueClass().getDeclaredMethod("valueOf", String.class);
			return (Enum<?>) valueOfMethod.invoke(null, text);
		} catch (Exception e) {
			log.error("Cannot deserialize enum " + getValueClass().getName() + " from " + text, e);
			throw new RuntimeException("Cannot deserialize enum " + getValueClass().getName() + " from " + text, e);
		}
	}

}
