package org.soluvas.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * Deserializer class for {@link EMap}.
 * <p>Usage: just register {@link EmfModule} to {@link ObjectMapper} because this deserializer is
 * automatically used for {@link EMap}.
 * 
 * <p>Explicit annotation is also possible but <b>not necessary</b>.
 * 
 * <pre>{@literal
 * 	@JsonDeserialize(using=EMapDeserializer.class)
 * 	protected EMap<String, Discount> discounts;
 * }</pre>
 * 
 * <p>Note: Do <b>not</b> use {@link JsonDeserialize#contentAs()}, just {@link JsonDeserialize#using()} is enough.
 * 
 * @author ceefour
 */
public class EMapDeserializer extends StdDeserializer<EMap<Object, Object>> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(EMapDeserializer.class);
//	private final MapDeserializer mapDeserializer;
	
	public EMapDeserializer() {
		super(EMap.class);
//		mapDeserializer = new MapDeserializer(null, null, null, null, null);
	}
	
	@Override
	public EMap<Object, Object> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final JsonDeserializer<Map<?, ?>> mapDeser = (JsonDeserializer) ctxt.findRootValueDeserializer(ctxt.getTypeFactory().constructType(Map.class));
		final Map<?, ?> map = mapDeser.deserialize(jp, ctxt);
		// convert List to EList
		final Map<Object, Object> transformed = ImmutableMap.copyOf(Maps.transformValues(map, new Function<Object, Object>() {
			@SuppressWarnings("unchecked")
			@Override
			public Object apply(Object input) {
				if (input == null)
					return null;
				if (input instanceof List)
					return new BasicEList<Object>((List) input);
				return input;
			}
		}));
		return new BasicEMap<Object, Object>(transformed);
	}

}
