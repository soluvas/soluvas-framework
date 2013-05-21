package org.soluvas.commons.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author agus
 */
public class AppUtils {
	private static final Logger log = LoggerFactory.getLogger(AppUtils.class);
	public static final int NETWORK_EXECUTOR_THREADS = 32;
	
	/**
	 * Returns the absolute URI of {@literal logo_email.png},
	 * specified by {@link AppManifest#getEmailLogoUriTemplate()}.
	 * This is practically "{webAddress.imagesUri}tenant_common/logo_email.png".
	 * Where {@literal common} is mounted by {tenantId}_common.
	 * 
	 * <p>This is useful for email and for JasperReports reporting.
	 * 
	 * <p>Note: To use in email layout Mustache such as Soluvas.html.mustache:
	 * <pre>
	 * &lt;img src="{{emailLogoUri}}" /&gt;
	 * </pre>
	 * 
	 * @param appManifest
	 * @param webAddress
	 * @return
	 */
	public static String getEmailLogoUri(AppManifest appManifest, WebAddress webAddress) {
		final UriTemplate template = UriTemplate.fromTemplate(appManifest.getEmailLogoUriTemplate());
		return template.expand(ImmutableMap.<String, Object>of("imagesUri", webAddress.getImagesUri())).toString();
	}
	
	/**
	 * Create a {@link ThreadPoolExecutor} with {@link Runtime#availableProcessors()} named threads.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * @Bean(destroyMethod="shutdown") @Cpu
	 * public ExecutorService cpuExecutor() {
	 * 	return AppUtils.newCpuExecutor();
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	public static ExecutorService newCpuExecutor() {
		final int cpuExecutorThreads = Runtime.getRuntime().availableProcessors();
		log.info("Creating {} CPU executors", cpuExecutorThreads);
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("CPU-%02d").build();
		return Executors.newFixedThreadPool(cpuExecutorThreads, threadFactory);
	}

	/**
	 * Create a {@link ThreadPoolExecutor} with {@value #NETWORK_EXECUTOR_THREADS} named threads.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * @Bean(destroyMethod="shutdown") @Network
	 * public ExecutorService networkExecutor() {
	 * 	return AppUtils.newNetworkExecutor();
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	public static ExecutorService newNetworkExecutor() {
		log.info("Creating {} Network executors", NETWORK_EXECUTOR_THREADS);
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Net-%02d").build();
		return Executors.newFixedThreadPool(NETWORK_EXECUTOR_THREADS, threadFactory);
	}

}
