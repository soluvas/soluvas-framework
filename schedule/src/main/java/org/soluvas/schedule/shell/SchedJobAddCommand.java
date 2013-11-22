package org.soluvas.schedule.shell;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Service;

import com.google.common.base.CaseFormat;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;

/**
 * Add a new {@link JobDetail} for current {@link TenantRef}'s {@link Scheduler}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="jobadd", description="Add a new JobDetail for current tenant's Scheduler.")
public class SchedJobAddCommand extends ExtCommandSupport {

	@Inject
	private ApplicationContext appCtx;
	
	@Argument(index=0, name="jobClass", required=true, description="Job Class name.")
	private Class<? extends Job> jobClass;
	@Nullable
	@Argument(index=1, name="jobData ...", required=false, multiValued=true, description="Job Data (key=value).")
	private String[] jobDatas;
	
	@Nullable
	@Option(name="-n", description="Job name. If not filled will use jobClass's simple name (lower camel).")
	private String name;
	@Option(name="-g", description="Job group.")
	private transient String group = "DEFAULT";
	@Option(name="-d", description="Specify the job's durability, i.e. whether it should remain stored in the job store even if no triggers point to it anymore.")
	private transient boolean durability = true;
	@Option(name="-r", description="Set the recovery flag for this job, i.e. whether or not the job should get re-executed if a 'recovery' or 'fail-over' situation is encountered.")
	private transient boolean requestsRecovery = false;
	
	@Override
	protected JobDetail doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		final JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(jobClass);
		jobDetailFactory.setName(Optional.fromNullable(name).or(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, jobClass.getSimpleName())));
		jobDetailFactory.setGroup(group);
		if (jobDatas != null) {
			final JobDataMap jobDataMap = new JobDataMap();
			for (final String jobData : jobDatas) {
				final List<String> keyValue = Splitter.on('=').splitToList(jobData);
				jobDataMap.put(keyValue.get(0), keyValue.get(1));
			}
			jobDetailFactory.setJobDataMap(jobDataMap);
		}
		jobDetailFactory.setDurability(durability);
		jobDetailFactory.setRequestsRecovery(requestsRecovery);
		jobDetailFactory.setApplicationContext(appCtx);
		jobDetailFactory.afterPropertiesSet();
		final JobDetail jobDetail = jobDetailFactory.getObject();
		scheduler.addJob(jobDetail, false);
		return jobDetail;
	}

}