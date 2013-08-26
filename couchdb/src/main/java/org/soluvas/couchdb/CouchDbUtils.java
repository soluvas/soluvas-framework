package org.soluvas.couchdb;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PreDestroy;

import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @author ceefour
 *
 */
public class CouchDbUtils {
	
	private static final Logger log = LoggerFactory.getLogger(CouchDbUtils.class);
	/**
	 * Singleton {@link HttpClient} instances so we can effectively limit connections per webapp
	 * (regardless of number of {@link CouchDbRepositoryBase} repositories).
	 * <p>Note: To mitigate "memory leak", we use reference counting. 
	 */
	private static final Map<String, HttpClient> httpClients = new HashMap<>();
	/**
	 * Key is URI + '#' + dbName (concatenated). 
	 */
	private static final Map<String, StdCouchDbConnector> connectors = new HashMap<>();
	private static final Multiset<String> httpClientUris = HashMultiset.create();

	/**
	 * Please call {@link #ungetDb(String, String)} during @{@link PreDestroy} so reference counting
	 * works properly. (although practically, this is negligible, but it's good practice and we have nicer "shutdown" logging)
	 * @param uri
	 * @param dbName
	 * @return
	 * @throws MalformedURLException 
	 */
	public static synchronized StdCouchDbConnector getDb(String uri, String dbName) throws MalformedURLException {
		final URI parsedUri = URI.create(uri);
		final String username = parsedUri.getUserInfo() != null ? parsedUri.getUserInfo().split(":")[0] : null;
		httpClientUris.add(uri); // reference counting for uri only, not including dbName
		
		final String connKey = uri + "#" + dbName;
		if (connectors.containsKey(connKey)) {
			final StdCouchDbConnector dbConn = connectors.get(connKey);
			log.debug("Reusing existing StdCouchDbConnector {} for {}:{}{} database {} as {}",
					dbConn, parsedUri.getHost(), parsedUri.getPort(), parsedUri.getPath(), dbName, username);
			return dbConn;
		} else {
			// Reuse HttpClient if possible
			final HttpClient client;
			if (httpClients.containsKey(uri)) {
				client = httpClients.get(uri);
				log.debug("Reusing existing HttpClient {} for {}:{}{} database {} as {}",
						client, parsedUri.getHost(), parsedUri.getPort(), parsedUri.getPath(), dbName, username);
			} else {
				client = new StdHttpClient.Builder().url(uri).build();
				log.info("Instantiating new HttpClient {} for {}:{}{} database {} as {}", 
						client, parsedUri.getHost(), parsedUri.getPort(), parsedUri.getPath(), dbName, username);
				httpClients.put(uri, client);
			}
			final StdCouchDbInstance dbInstance = new StdCouchDbInstance(client, SoluvasObjectMapperFactory.INSTANCE);
			final StdCouchDbConnector dbConn = new StdCouchDbConnector(dbName, dbInstance, SoluvasObjectMapperFactory.INSTANCE);
			log.info("Instantiating new StdCouchDbConnector {} for {}:{}{} database {} as {}", 
					dbConn, parsedUri.getHost(), parsedUri.getPort(), parsedUri.getPath(), dbName, username);
			dbConn.createDatabaseIfNotExists();
			connectors.put(connKey, dbConn);
			return dbConn;
		}
	}
	
	/**
	 * Practically, this is negligible, but it's good practice and we have nicer "shutdown" logging.
	 * @param uri
	 * @param dbName
	 */
	public static synchronized void ungetDb(String uri, String dbName) {
		if (httpClientUris.remove(uri)) {
			if (!httpClientUris.contains(uri)) {
				// Remove all connectors for this URI
				int allConnectorCount = connectors.size();
				int removedConnectorCount = 0;
				final Iterator<Entry<String, StdCouchDbConnector>> iterator = connectors.entrySet().iterator();
				while (iterator.hasNext()) {
					final Entry<String, StdCouchDbConnector> entry = iterator.next();
					if (entry.getKey().startsWith(uri + "#")) {
						iterator.remove();
						removedConnectorCount++;
					}
				}
				// Shutdown HttpClient
				final HttpClient client = httpClients.remove(uri);
				log.info("Shutting down HttpClient {} ({} of {} CouchDB Connectors removed)", 
						client, removedConnectorCount, allConnectorCount);
				client.shutdown();
			}
		}
	}

}
