package org.soluvas.image.impl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.image.MediaAttachment;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Deserializer class for {@link EMap}.
 * <p>Usage:
 * 
 * <pre>{@literal
 * 	@JsonDeserialize(using=MediaAttachmentEMapDeserializer.class)
 * 	protected EMap<String, Discount> discounts;
 * }</pre>
 * 
 * @author ceefour
 */
public class MediaAttachmentEMapDeserializer extends StdDeserializer<EMap<String, MediaAttachment>> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(MediaAttachmentEMapDeserializer.class);
//	private final MapDeserializer mapDeserializer;
	
	public MediaAttachmentEMapDeserializer() {
		super(EMap.class);
//		mapDeserializer = new MapDeserializer(null, null, null, null, null);
	}
	
	@Override
	public EMap<String, MediaAttachment> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final TypeReference<Map<String, MediaAttachment>> mediaAttachmentMapTypeRef = new TypeReference<Map<String, MediaAttachment>>() { };
		final JsonDeserializer<Map<String, MediaAttachment>> mapDeser = (JsonDeserializer) ctxt.findRootValueDeserializer(ctxt.getTypeFactory().constructType(mediaAttachmentMapTypeRef));
		final Map<String, MediaAttachment> map = mapDeser.deserialize(jp, ctxt);
		// convert List to EList
		return new BasicEMap<String, MediaAttachment>(map);
	}

}
