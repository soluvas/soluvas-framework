package org.soluvas.couchdb;

import org.ektorp.CouchDbConnector;
import org.ektorp.impl.ObjectMapperFactory;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.impl.StdObjectMapperFactory;
import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;

/**
 * An Ektorp {@link ObjectMapperFactory} that registers Jackson modules from soluvas-json {@link JsonUtils}.
 * To be used with {@link StdCouchDbInstance} and {@link StdCouchDbConnector}.
 * @author ceefour
 */
public class SoluvasObjectMapperFactory extends StdObjectMapperFactory {

	/**
	 * Singleton instance. 
	 */
	public static final SoluvasObjectMapperFactory INSTANCE = new SoluvasObjectMapperFactory();
	
	@Override
	public synchronized ObjectMapper createObjectMapper() {
		final ObjectMapper objectMapper = super.createObjectMapper();
		objectMapper.registerModules(Lists.transform(JsonUtils.modules, new Function<Supplier<Module>, Module>() {
			@Override
			public Module apply(Supplier<Module> input) {
				return input.get();
			};
		}));
		return objectMapper;
	}
	
	@Override
	public ObjectMapper createObjectMapper(CouchDbConnector connector) {
		final ObjectMapper objectMapper = super.createObjectMapper(connector);
		objectMapper.registerModules(Lists.transform(JsonUtils.modules, new Function<Supplier<Module>, Module>() {
			@Override
			public Module apply(Supplier<Module> input) {
				return input.get();
			};
		}));
		return objectMapper;
	}

}