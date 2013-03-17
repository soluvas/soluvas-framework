package org.soluvas.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;

public interface JacksonMapperFactory extends Supplier<ObjectMapper> {

	public abstract ObjectMapper get();

}