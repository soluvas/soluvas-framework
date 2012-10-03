package org.soluvas.facebook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ContextHelper {

	private transient Logger log = LoggerFactory.getLogger(ContextHelper.class);
	private ExecutorService executor;
	private DecompressingHttpClient httpClient;
	
	public ContextHelper() {
		super();
		log.info("Creating default executor FacebookUtils with 8 threads");
		executor = Executors.newFixedThreadPool(8, new ThreadFactoryBuilder().setNameFormat("FacebookUtils-%d").build() );
		httpClient = new DecompressingHttpClient(new DefaultHttpClient());
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
	public DecompressingHttpClient getHttpClient() {
		return httpClient;
	}

}
