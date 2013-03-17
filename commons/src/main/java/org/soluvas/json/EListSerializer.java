package org.soluvas.json;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serializer for {@link EList} that supports {@link JsonTypeInfo}.
 * 
 * @deprecated Do not use this, doesn't work as expected. EMap is an EList which causes infinite loop. EMapSerializer now supports typed EList as entry values.
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
@Deprecated
public class EListSerializer extends StdSerializer<EList> {

	private static final Logger log = LoggerFactory
			.getLogger(EListSerializer.class);
	
	public EListSerializer() {
		super(EList.class, false);
	}
	
	@Override
	public void serialize(EList value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		log.info("Serializing EList with {} elements", value.size());
		jgen.writeStartArray();
		for (Object entry : value) {
			log.info("Serializing EList element: {}", entry.getClass());
			jgen.writeObject(entry);
		}
		jgen.writeEndArray();
//		jgen.writeObject(value.map());
	}

}	
