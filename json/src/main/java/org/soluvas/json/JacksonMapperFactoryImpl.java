package org.soluvas.json;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
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
public class JacksonMapperFactoryImpl implements JacksonMapperFactory {
	
	private transient Logger log = LoggerFactory
			.getLogger(JacksonMapperFactoryImpl.class);
	private List<Supplier<Module>> moduleSuppliers = ImmutableList.of();
	private ObjectMapper objectMapper;
	private Set<String> lastModuleNames;
	
	public JacksonMapperFactoryImpl() {
		super();
	}
	
	public JacksonMapperFactoryImpl(List<Supplier<Module>> modules) {
		super();
		this.moduleSuppliers = modules;
	}
	
	protected Set<String> getModuleNames(Iterable<Supplier<Module>> moduleSuppliers) {
		Set<String> moduleNames = ImmutableSet.copyOf( Iterables.transform(moduleSuppliers, new Function<Supplier<Module>, String>() {
			@Override
			public String apply(Supplier<Module> input) {
				return input.get().getModuleName();
			}
		}));
		return moduleNames;
	}
	
	protected void recreateMapper() {
		List<Module> modules = Lists.transform(moduleSuppliers, new Function<Supplier<Module>, Module>() {
			@Override
			public Module apply(Supplier<Module> input) {
				return input.get();
			}
		});
		lastModuleNames = getModuleNames(moduleSuppliers);
		log.info("Creating Jackson ObjectMapper with {} modules: {}", modules.size(), lastModuleNames);
		objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		for (Module module : modules) {
			objectMapper.registerModule(module);
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.json.JacksonMapperFactory#get()
	 */
	@Override
	public ObjectMapper get() {
		Set<String> currentModuleNames = getModuleNames(moduleSuppliers);
		if (lastModuleNames == null || !currentModuleNames.equals(lastModuleNames)) {
			recreateMapper();
		}
		return objectMapper;
	}

}
