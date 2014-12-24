package org.soluvas.couchdb;

import java.net.MalformedURLException;

import javax.inject.Inject;

import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.soluvas.commons.config.CommonsWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Multitenant CouchDB configuration.
 * @author ceefour
 */
@Configuration
public class CouchDbConfig {

	@Inject
	private Environment env;
	/**
	 * @see CommonsWebConfig#httpClientConnMgr()
	 */
	@Inject
	private ClientConnectionManager connMgr;
	
	@Bean // IMPORTANT: do NOT shutdown the connectionManager! BIG NO: (destroyMethod="shutdown")
	public HttpClient couchDbHttpClient() throws MalformedURLException {
		final String couchDbUri = env.getRequiredProperty("couchDbUri");
		final HttpClient client = new StdHttpClient.Builder()
	//		.connectionTimeout(60 * 1000) // workaround for Cloudant: https://quikdo.atlassian.net/browse/HUB-36
	//		.socketTimeout(60 * 1000) // workaround for Cloudant: https://quikdo.atlassian.net/browse/HUB-36
			.connectionManager(connMgr)
			.url(couchDbUri).build();
		return client;
	}

	/**
	 * @return
	 * @throws MalformedURLException
	 */
	@Bean
	public CouchDbInstance couchDbInstance() throws MalformedURLException {
		return new StdCouchDbInstance(couchDbHttpClient(), SoluvasObjectMapperFactory.INSTANCE);
	}

}
