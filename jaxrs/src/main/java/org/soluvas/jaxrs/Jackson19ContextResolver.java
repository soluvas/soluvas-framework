package org.soluvas.jaxrs;

import java.io.IOException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectMapper.DefaultTyping;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rudi
 * @deprecated Should be deprecated because nobody uses it anyway.
 * (we used it in JBoss AS 7.1.1 because it only supports Jackson 1.9)
 */
//@Provider @Produces(MediaType.APPLICATION_JSON)
@Deprecated
public class Jackson19ContextResolver implements ContextResolver<ObjectMapper> {

	private static final Logger log = LoggerFactory.getLogger(Jackson19ContextResolver.class);
	private final ObjectMapper objectMapper;

	public Jackson19ContextResolver() throws JsonGenerationException, JsonMappingException, IOException {
		log.info("Configuring Jackson ObjectMapper to indent output and write dates as ISO-8601");
		objectMapper = new ObjectMapper();
		objectMapper.enableDefaultTypingAsProperty(DefaultTyping.OBJECT_AND_NON_CONCRETE, "@class");
		objectMapper.enable(Feature.INDENT_OUTPUT);
		objectMapper.disable(Feature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.disable(Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}
}
