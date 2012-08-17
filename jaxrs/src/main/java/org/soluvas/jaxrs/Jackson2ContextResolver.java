package org.soluvas.jaxrs;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;

/**
 * This {@link ContextResolver} needs to be manually configured (via DI).
 * @author ceefour
 */
//@Provider @Produces(MediaType.APPLICATION_JSON)
public class Jackson2ContextResolver implements ContextResolver<ObjectMapper> {

	private Supplier<ObjectMapper> objectMapperSupplier;

	public Jackson2ContextResolver(Supplier<ObjectMapper> objectMapperSupplier) {
		super();
		this.objectMapperSupplier = objectMapperSupplier;
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapperSupplier.get();
	}
}
