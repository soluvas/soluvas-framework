package org.soluvas.data;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class MixinEMapDeserializer extends StdDeserializer<EMap<String, Mixin>> {

	protected MixinEMapDeserializer() {
		super(EMap.class);
	}
	
	@Override
	public EMap<String, Mixin> deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
//		JsonToken token = jp.getCurrentToken();
//		Preconditions.checkState(token == JsonToken.START_OBJECT, "Invalid token: %s", token);
//		jp.nextToken();
		Map<String, Mixin> map = jp.readValueAs(new TypeReference<Map<String, Mixin>>() {});
//		final JsonDeserializer<Map> mapDeser = (JsonDeserializer) ctxt.findRootValueDeserializer(ctxt.getTypeFactory().constructType(Map.class));
//		final Map<Object, Object> map = mapDeser.deserialize(jp, ctxt);
		// convert List to EList
//		final Map<Object, Object> transformed = ImmutableMap.copyOf(Maps.transformValues(map, new Function<Object, Object>() {
//			@SuppressWarnings("unchecked")
//			@Override
//			public Object apply(Object input) {
//				if (input == null)
//					return null;
//				if (input instanceof List)
//					return new BasicEList<Object>((List) input);
//				return input;
//			}
//		}));
		return new BasicEMap<>(map);
		
	}

}
