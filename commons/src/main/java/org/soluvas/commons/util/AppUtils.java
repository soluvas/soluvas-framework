package org.soluvas.commons.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.WebAddress;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
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
		try {
			Preconditions.checkNotNull(appManifest.getEmailLogoUriTemplate(),
					"AppManifest.emailLogoUriTemplate is required");
			Preconditions.checkNotNull(webAddress.getImagesUri(),
					"WebAddress.imagesUri is required");
			final UriTemplate template = UriTemplate.fromTemplate(appManifest.getEmailLogoUriTemplate());
			return template.expand(ImmutableMap.<String, Object>of("imagesUri", webAddress.getImagesUri())).toString();
		} catch (MalformedUriTemplateException | VariableExpansionException e) {
			throw new CommonsException(e, "Cannot expand imagesUri '%s' from AppManifest '%s' using template '%s'",
					webAddress.getImagesUri(), appManifest.getTitle(), appManifest.getEmailLogoUriTemplate());
		}
	}
	
	/**
	 * Create a {@link ThreadPoolExecutor} with {@link Runtime#availableProcessors()} named threads.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * @Bean(destroyMethod="shutdown") @Cpu
	 * public ListeningExecutorService cpuExecutor() {
	 * 	return AppUtils.newCpuExecutor();
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	public static ListeningExecutorService newCpuExecutor() {
		final int cpuExecutorThreads = Runtime.getRuntime().availableProcessors();
		log.info("Creating {} CPU executors", cpuExecutorThreads);
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("CPU-%02d").build();
		final ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(cpuExecutorThreads, threadFactory));
		// dummy jobs to ensure the threads are actually created (MDC workaround?)
		for (int i = 0; i < cpuExecutorThreads; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
				}
			});
		}
		return executor;
	}

	/**
	 * Create a {@link ThreadPoolExecutor} with {@value #NETWORK_EXECUTOR_THREADS} named threads.
	 * 
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * @Bean(destroyMethod="shutdown") @Network
	 * public ListeningExecutorService networkExecutor() {
	 * 	return AppUtils.newNetworkExecutor();
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	public static ListeningExecutorService newNetworkExecutor() {
		log.info("Creating {} Network executors", NETWORK_EXECUTOR_THREADS);
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Net-%02d").build();
		final ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(NETWORK_EXECUTOR_THREADS, threadFactory));
		// dummy jobs to ensure the threads are actually created (MDC workaround?)
		for (int i = 0; i < NETWORK_EXECUTOR_THREADS; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
				}
			});
		}
		return executor;
	}

}
