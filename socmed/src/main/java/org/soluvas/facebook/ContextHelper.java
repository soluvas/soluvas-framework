package org.soluvas.facebook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author ceefour
 * @deprecated Should be replaced by Spring {@link Configuration} beans instead.
 */
@Deprecated
public class ContextHelper {

	private static final Logger log = LoggerFactory.getLogger(ContextHelper.class);
	private ExecutorService executor;
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public ContextHelper() {
		super();
		log.info("Creating default executor FacebookUtils with 8 threads");
		executor = Executors.newFixedThreadPool(8, new ThreadFactoryBuilder().setNameFormat("FacebookUtils-%d").build() );
	}
	
	public void destroy() {
		try {
			executor.shutdown();
		} catch (Exception e) {
			log.error("Cannot shutdown Executor " + executor, e);
		} finally {
			executor = null;
		}
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * @return the executor
	 */
	public ExecutorService getExecutor() {
		return executor;
	}

	/**
	 * @return the httpClient
	 */
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

}
