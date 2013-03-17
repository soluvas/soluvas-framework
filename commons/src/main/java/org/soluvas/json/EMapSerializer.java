package org.soluvas.json;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Serializer for {@link EMap}.
 * 
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class EMapSerializer extends StdSerializer<EMap> {

//	private static final Logger log = LoggerFactory
//			.getLogger(EMapSerializer.class);

	public EMapSerializer() {
		super(EMap.class, false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serialize(EMap value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		jgen.writeStartObject();
		for (final Entry<String, Object> entry : (Set<Entry>) value.map().entrySet()) {
			jgen.writeFieldName(entry.getKey());
			// Workaround for https://github.com/FasterXML/jackson-databind/issues/23
			final Object entryVal = entry.getValue();
//			log.info("writing {} object", entryVal.getClass());
			if (entryVal instanceof EList) {
				jgen.writeStartArray();
				for (Object obj : (EList) entryVal)
					jgen.writeObject(obj);
				jgen.writeEndArray();
			} else {
				jgen.writeObject(entry.getValue());
			}
		}
		jgen.writeEndObject();
//		jgen.writeObject(value.map());
	}

}	
