package org.soluvas.data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class ValueEMapDeserializer extends StdDeserializer<EMap<String, EList<Value<?>>>> {

	protected ValueEMapDeserializer() {
		super(EMap.class);
	}
	
	@Override
	public EMap<String, EList<Value<?>>> deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
//		JsonToken token = jp.getCurrentToken();
//		Preconditions.checkState(token == JsonToken.START_OBJECT, "Invalid token: %s", token);
//		jp.nextToken();
		// TODO: find a better, cleaner workaround :'(
		final ClassLoader oldCcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(ValueEMapDeserializer.class.getClassLoader());
		final Map<String, List<Value<?>>> map;
		try {
			map = jp.readValueAs(new TypeReference<Map<String, List<Value<?>>>>() {});
		} finally {
			Thread.currentThread().setContextClassLoader(oldCcl);
		}
//		final JsonDeserializer<Map> mapDeser = (JsonDeserializer) ctxt.findRootValueDeserializer(ctxt.getTypeFactory().constructType(Map.class));
//		final Map<Object, Object> map = mapDeser.deserialize(jp, ctxt);
//		 convert List to EList
		final Map<String, EList<Value<?>>> transformed = ImmutableMap.copyOf(Maps.transformValues(map, new Function<List<Value<?>>, EList<Value<?>>>() {
			@Override
			public EList<Value<?>> apply(List<Value<?>> input) {
				if (input == null)
					return null;
				return new BasicEList<Value<?>>(input);
			}
		}));
		return new BasicEMap<String, EList<Value<?>>>(transformed);
		
	}

}
