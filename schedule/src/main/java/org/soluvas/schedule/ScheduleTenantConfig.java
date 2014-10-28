package org.soluvas.schedule;

import java.util.Map;

import javax.inject.Inject;

import org.quartz.Scheduler;
import org.soluvas.commons.config.MultiTenantWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Soluvas Schedule tenant-specific {@link Configuration}.
 * @author ceefour
 */
@Configuration @Lazy
public class ScheduleTenantConfig {
	
	@Inject
	private MultiTenantWebConfig tenantConfig;
	@Inject
	public ScheduleMultiConfig scheduleConfig;
	
	/**
	 * Scope must be prototype, otherwise it will be destroyed by Spring.
	 * @return
	 */
	@Bean @Scope("prototype")
	public Scheduler scheduler() {
		final String tenantId = tenantConfig.tenantRef().getTenantId();
		final Map<String, Scheduler> schedulerMap = scheduleConfig.schedulerMap();
		return Preconditions.checkNotNull(schedulerMap.get(tenantId),
				"No Scheduler for tenant '%s'. %s available Schedulers: %s",
				tenantId, schedulerMap.size(), Iterables.limit(schedulerMap.keySet(), 10));
	}

}
