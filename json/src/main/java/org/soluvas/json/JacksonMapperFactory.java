package org.soluvas.json;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Creates a Jackson 2.0 {@link ObjectMapper} with following settings:
 * 
 * - disable write dates as timestamps
 * - enable indent output
 * - register modules
 * 
 * @author ceefour
 */
public class JacksonMapperFactory implements Supplier<ObjectMapper> {
	
	private transient Logger log = LoggerFactory
			.getLogger(JacksonMapperFactory.class);
	private List<Supplier<Module>> moduleSuppliers = ImmutableList.of();
	private ObjectMapper objectMapper;
	
	public JacksonMapperFactory() {
		super();
	}
	
	public JacksonMapperFactory(List<Supplier<Module>> modules) {
		super();
		this.moduleSuppliers = modules;
	}
	
	protected void create() {
		List<Module> modules = Lists.transform(moduleSuppliers, new Function<Supplier<Module>, Module>() {
			@Override
			public Module apply(Supplier<Module> input) {
				return input.get();
			}
		});
		log.info("Creating Jackson ObjectMapper with {} modules", modules.size());
		objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		for (Module module : modules) {
			objectMapper.registerModule(module);
		}
	}

	@Override
	public ObjectMapper get() {
//		if (objectMapper == null) {
//			create();
//		}
		create();
		return objectMapper;
	}

}
