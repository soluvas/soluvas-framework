package org.soluvas.jaxrs;

import java.io.IOException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider @Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private transient Logger log = LoggerFactory.getLogger(JacksonContextResolver.class);
	private ObjectMapper objectMapper;

	public JacksonContextResolver() throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Configuring Jackson ObjectMapper to indent output and write dates as ISO-8601");
		objectMapper = new ObjectMapper();
		objectMapper.configure(Feature.INDENT_OUTPUT, true);
		objectMapper.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}
}
