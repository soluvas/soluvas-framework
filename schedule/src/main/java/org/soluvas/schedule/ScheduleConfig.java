package org.soluvas.schedule;

import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.quartz.ListenerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.jdbcjobstore.PostgreSQLDelegate;
import org.quartz.plugins.history.LoggingJobHistoryPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

import com.google.common.base.Preconditions;

/**
 * One global {@link Scheduler} in {@code PUBLIC} schema for all tenants, including the app itself.
 * @author rudi
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
@Import({ScheduleLiquibaseConfig.class})
public class ScheduleConfig {

	private static final Logger log = LoggerFactory.getLogger(ScheduleConfig.class);
	
	@Inject
	private ApplicationContext appCtx;
	/**
	 * @see org.soluvas.jpa.PostgresConfig
	 */
	@Inject
	private DataSource dataSource;
	/**
	 * @see org.soluvas.jpa.PostgresConfig
	 */
	@Autowired(required = false)
	private DataSourceTransactionManager dsTxMgr;
	/**
	 * @see org.soluvas.jpa.PostgresConfig
	 */
	@Inject
	private PlatformTransactionManager fallbackTxMgr;
	@Autowired(required = false)
	private ScheduleLiquibaseConfig scheduleLiquibaseConfig;
	@Inject
	private Environment env;

	@PostConstruct
	public void init() {
		if (env.getProperty("quartz.migrate", Boolean.class, false)) {
			Preconditions.checkNotNull(scheduleLiquibaseConfig, "With quartz.migrate=true, ScheduleLiquibaseConfig must be @Import-ed");
			scheduleLiquibaseConfig.migrate();
		}
	}

	@Bean
	public SchedulerFactoryBean scheduler() {
		final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		// do NOT share a JobFactory object among Scheduler instances!
		schedulerFactoryBean.setJobFactory(new SpringBeanJobFactory());
		final String schedulerName = "scheduler";
		schedulerFactoryBean.setSchedulerName(schedulerName);
//		schedulerFactoryBean.setSchedulerContextAsMap(ImmutableMap.of(
//				"tenantId", tenantId,
//				"appManifest", appManifest));
//		schedulerFactoryBean.setGlobalJobListeners(new JobListener[] {
//				new EventBusJobListener("eventBusJobListener", eventBus)
//		});
//		schedulerFactoryBean.setJobDetails(new JobDetail[] {
//				createChecklistJd
//		});
//		schedulerFactoryBean.setTriggers(new Trigger[] {
//				createChecklistTrigger
//		});
		schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
		
		schedulerFactoryBean.setDataSource(dataSource);
		schedulerFactoryBean.setTransactionManager(Optional.<PlatformTransactionManager>ofNullable(dsTxMgr).orElse(fallbackTxMgr));
		final Properties props = new Properties();
		//GA EFFECT T.T untuk: https://idbippo.atlassian.net/browse/BC-3222
		//coba pk 4 thread --> ga effek juga
		//http://stackoverflow.com/questions/8473863/how-to-avoid-two-jobs-running-at-the-same-time-in-quartz
//		props.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//		props.put("org.quartz.threadPool.threadCount", String.valueOf(4));
		
		props.put("org.quartz.jobStore.driverDelegateClass", PostgreSQLDelegate.class.getName());
//		props.put(StdSchedulerFactory.PROP_SCHED_SKIP_UPDATE_CHECK, "true"); https://github.com/psi-probe/psi-probe/issues/1053
		props.put(StdSchedulerFactory.PROP_JOB_STORE_PREFIX + "." + StdSchedulerFactory.PROP_TABLE_PREFIX, "public.qrtz_");
		
		//Example Properties For A Clustered Scheduler
		//#============================================================================
		//# Configure Main Scheduler Properties  
		//#============================================================================

//				props.put("org.quartz.scheduler.instanceName", "SoluvasClusteredScheduler");
		/*$*/ props.put("org.quartz.scheduler.instanceId", "AUTO");

		//#============================================================================
		//# Configure ThreadPool  
		//#============================================================================

		/*$*/ props.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		/*$*/ props.put("org.quartz.threadPool.threadCount", String.valueOf(4));
		/*$*/ props.put("org.quartz.threadPool.threadPriority", String.valueOf(5));

		//#============================================================================
		//# Configure JobStore  
		//#============================================================================

		/*$*/ props.put("org.quartz.jobStore.misfireThreshold", String.valueOf(60000));

		/*$*/ props.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//				props.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.oracle.OracleDelegate"); --> postgres
		/*$*/ props.put("org.quartz.jobStore.useProperties", false);
//				props.put("org.quartz.jobStore.dataSource", "myDS"); --> di atas defini ds nya
//				props.put("org.quartz.jobStore.tablePrefix", "QRTZ_" --> public.qrtz_);

		/*$*/ props.put("org.quartz.jobStore.isClustered", true);
		/*$*/ props.put("org.quartz.jobStore.clusterCheckinInterval", String.valueOf(20000));

//				//#============================================================================
//				//# Configure Datasources  --> GA PERLU, karna udh di set di atas
//				//#============================================================================
//
//				org.quartz.dataSource.myDS.driver = oracle.jdbc.driver.OracleDriver
//				org.quartz.dataSource.myDS.URL = jdbc:oracle:thin:@polarbear:1521:dev
//				org.quartz.dataSource.myDS.user = quartz
//				org.quartz.dataSource.myDS.password = quartz
//				org.quartz.dataSource.myDS.maxConnections = 5
//				org.quartz.dataSource.myDS.validationQuery=select 0 from dual
		//End For A Clustered Scheduler
		
		schedulerFactoryBean.setQuartzProperties(props);
		
		// Other than tenantId & AppManifest, Jobs should get dependencies via getBean(), similar to what shell commands do,
		// so when the object isn't ready, Spring should lazily initialize them
		// deprecated: startup delay should be configurable, as it is application-dependent,
		// it should be an estimate of the maximum time needed to register all schedulerContext objects (for all tenants)
		//schedulerFactoryBean.setStartupDelay(5);
		
		schedulerFactoryBean.setApplicationContext(appCtx);
		schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
//		final Scheduler scheduler = schedulerFactoryBean.getObject();
		
		log.info("Creating Scheduler '{}' using: {}", schedulerName, props);
		return schedulerFactoryBean;
	}
	
	/**
	 * Creates and adds {@link LoggingJobHistoryPlugin} using {@link ListenerManager}.
	 * @return
	 * @throws SchedulerException
	 */
	@Bean
	public LoggingJobHistoryPlugin loggingJobHistoryPlugin() throws SchedulerException {
		final Scheduler scheduler = scheduler().getObject();
		final LoggingJobHistoryPlugin loggingJobListener = new LoggingJobHistoryPlugin2();
		loggingJobListener.initialize("logging", scheduler, null);
		return loggingJobListener;
	}
	
}
