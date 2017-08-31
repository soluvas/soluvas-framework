package org.soluvas.schedule;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.jdbcjobstore.PostgreSQLDelegate;
import org.quartz.plugins.history.LoggingJobHistoryPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * Soluvas Schedule {@link Configuration}.
 * @deprecated It's better to use one {@link Scheduler} for all tenants. Imagine what happens if you have 1000+ tenants, all running Quartz threads?
 * @author ceefour
 */
@Deprecated
@Configuration @Lazy(false)
@Import(ScheduleTenantConfig.class)
@ComponentScan("org.soluvas.schedule.shell")
public class ScheduleMultiConfig {
	
	private static final Logger log = LoggerFactory
			.getLogger(ScheduleMultiConfig.class);

	@Inject
	private ApplicationContext appCtx;
	@Resource(name="tenantMap")
	private Map<String, AppManifest> appManifestMap;
	@Inject
	private DataSource dataSource;
	@Inject
	private PlatformTransactionManager txMgr;

	private final Map<String, SchedulerFactoryBean> schedulerFactoryBeanMap = new LinkedHashMap<>();
//	private final Map<String, Scheduler> schedulerMap = new HashMap<>();
	
	@PostConstruct
	public void init() throws Exception {
//		final ImmutableMap.Builder<String, Scheduler> schedulerMapBuilder = ImmutableMap.builder();
		for (final Entry<String, AppManifest> entry : appManifestMap.entrySet()) {
			final String tenantId = entry.getKey();
			final AppManifest appManifest = entry.getValue();
			log.info("Creating scheduler for tenant '{}'", tenantId);
			
//			final JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
//			final JobDetail createChecklistJd = JobBuilder.newJob(CreateChecklistJob.class)
//					.withIdentity("createChecklist_test", NAMESPACE).storeDurably().build();
//			final Trigger createChecklistTrigger = TriggerBuilder.newTrigger().withIdentity("createChecklist_test", NAMESPACE)
//					.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(300).withMisfireHandlingInstructionNextWithRemainingCount())
//					.startAt(DateBuilder.futureDate(300, IntervalUnit.YEAR))
//					.forJob(createChecklistJd)
//					.build();
			
			final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
			// do NOT share a JobFactory object among Scheduler instances!
			schedulerFactoryBean.setJobFactory(new SpringBeanJobFactory());
			schedulerFactoryBean.setSchedulerName(tenantId);
			schedulerFactoryBean.setSchedulerContextAsMap(ImmutableMap.of(
					"tenantId", tenantId,
					"appManifest", appManifest));
//			schedulerFactoryBean.setGlobalJobListeners(new JobListener[] {
//					new EventBusJobListener("eventBusJobListener", eventBus)
//			});
//			schedulerFactoryBean.setJobDetails(new JobDetail[] {
//					createChecklistJd
//			});
//			schedulerFactoryBean.setTriggers(new Trigger[] {
//					createChecklistTrigger
//			});
			schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
			
			schedulerFactoryBean.setDataSource(dataSource);
			schedulerFactoryBean.setTransactionManager(txMgr);
			final Properties props = new Properties();
			props.put("org.quartz.jobStore.driverDelegateClass", PostgreSQLDelegate.class.getName());
//			props.put(StdSchedulerFactory.PROP_SCHED_SKIP_UPDATE_CHECK, "true"); https://github.com/psi-probe/psi-probe/issues/1053
			props.put(StdSchedulerFactory.PROP_JOB_STORE_PREFIX + "." + StdSchedulerFactory.PROP_TABLE_PREFIX, tenantId + ".qrtz_");
			schedulerFactoryBean.setQuartzProperties(props);
			
			// Other than tenantId & AppManifest, Jobs should get dependencies via getBean(), similar to what shell commands do,
			// so when the object isn't ready, Spring should lazily initialize them
			// deprecated: startup delay should be configurable, as it is application-dependent,
			// it should be an estimate of the maximum time needed to register all schedulerContext objects (for all tenants)
			//schedulerFactoryBean.setStartupDelay(5);
			
			schedulerFactoryBean.setApplicationContext(appCtx);
			schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
			schedulerFactoryBean.afterPropertiesSet();
//			final Scheduler scheduler = schedulerFactoryBean.getObject();

			// Creates and adds {@link org.quartz.plugins.history.LoggingJobHistoryPlugin} using {@link org.quartz.ListenerManager}.
			final LoggingJobHistoryPlugin loggingJobListener = new LoggingJobHistoryPlugin2();
			loggingJobListener.initialize(entry.getKey(), schedulerFactoryBean.getScheduler(), null);

			schedulerFactoryBeanMap.put(tenantId, schedulerFactoryBean);
			
			log.info("Creating '{}' SchedulerFactoryBean using: {}", tenantId, props);
//			schedulerMap.put(tenantId, scheduler);
		}
//		schedulerMap = schedulerMapBuilder.build();
		
		// start the FactoryBean(s) last, to make sure that Scheduler is already inside the schedulerMap
		for (final Entry<String, SchedulerFactoryBean> entry : schedulerFactoryBeanMap.entrySet()) {
			log.info("Starting '{}' SchedulerFactoryBean", entry.getKey());
			try {
				entry.getValue().start();
			} catch (Exception e) {
				throw new ScheduleException(e,
						"Cannot start '%s' SchedulerFactoryBean, have you created Quartz SQL tables? %s", 
						entry.getKey(), e);
			}
		}
	}
	
	@PreDestroy
	public void destroy() {
//		for (final Iterator<Entry<String, Scheduler>> iter = schedulerMap.entrySet().iterator(); iter.hasNext(); ) {
//			final Entry<String, Scheduler> entry = iter.next();
//			log.info("Shutting down '{}' scheduler (waiting for jobs to complete)", entry.getKey());
//			try {
//				entry.getValue().shutdown(true);
//				iter.remove();
//			} catch (Exception e) {
//				log.error("Error shutting down '" + entry.getKey() + "' scheduler", e);
//			}
//		}
		for (final Iterator<Entry<String, SchedulerFactoryBean>> iter = schedulerFactoryBeanMap.entrySet().iterator(); iter.hasNext(); ) {
			final Entry<String, SchedulerFactoryBean> entry = iter.next();
			log.info("Shutting down '{}' SchedulerFactoryBean", entry.getKey());
			try {
				entry.getValue().stop();
				entry.getValue().destroy();
				iter.remove();
			} catch (Exception e) {
				log.error("Error shutting down '" + entry.getKey() + "' scheduler", e);
			}
		}
	}
	
	@Bean
	public Map<String, Scheduler> schedulerMap() {
		return Collections.unmodifiableMap(Maps.transformValues(schedulerFactoryBeanMap, 
				new Function<SchedulerFactoryBean, Scheduler>() {
			@Override @Nullable
			public Scheduler apply(@Nullable SchedulerFactoryBean input) {
				return input.getObject();
			}
		}));
	}

//	@Bean
//	public SchedulerManager schedulerMgr() {
//		return new SchedulerManager();
//	}

}
