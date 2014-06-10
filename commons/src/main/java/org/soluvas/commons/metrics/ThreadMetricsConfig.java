package org.soluvas.commons.metrics;

import java.lang.management.ManagementFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * See <a href="http://docs.oracle.com/javase/7/docs/jre/api/management/extension/com/sun/management/ThreadMXBean.html#getThreadAllocatedBytes(long)">com.sun.management.ThreadMXBean.getThreadAllocatedBytes(long)</a>.
 * 
 * <p>Enable dulu dengan <a href="http://docs.oracle.com/javase/7/docs/jre/api/management/extension/com/sun/management/ThreadMXBean.html#setThreadAllocatedMemoryEnabled(boolean)">com.sun.management.ThreadMXBean.setThreadAllocatedMemoryEnabled(boolean)</a>.
 * 
 * <p>Bisa diakses juga dari <a href="http://visualvm.java.net/">VisualVM</a>.
 * 
 * <p>Setting dengan {@code threadMetrics=true} di properties.
 * 
 * @author ceefour
 */
@Configuration
public class ThreadMetricsConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(ThreadMetricsConfig.class);
	
	@Inject
	private Environment env;

	private boolean enabled;
	
	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		enabled = env.getProperty("threadMetrics", Boolean.class, false);
		if (enabled) {
			try {
				log.info("Enabling Thread Metrics");
				final com.sun.management.ThreadMXBean threadMx = (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
				threadMx.setThreadAllocatedMemoryEnabled(true);
				threadMx.setThreadContentionMonitoringEnabled(true);
				threadMx.setThreadCpuTimeEnabled(true);
			} catch (Exception e) {
				throw new CommonsException("Oracle/OpenJDK is required to enabled Thread Metrics", e);
			}
		} else {
			log.info("Thread Metrics is disabled");
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}

}
