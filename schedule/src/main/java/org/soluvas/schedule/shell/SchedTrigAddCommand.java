package org.soluvas.schedule.shell;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;

/**
 * Add a new {@link Trigger} for current {@link TenantRef}'s {@link Scheduler}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="trigadd", description="Add a new Trigger for current tenant's Scheduler.")
public class SchedTrigAddCommand extends ExtCommandSupport {

	public static enum SimpleRepeat {
		NONE,
		SECONDLY,
		MINUTELY,
		HOURLY
	}
	
	@Inject
	private ApplicationContext appCtx;
	
	@Argument(index=0, name="job", required=true, description="Job name.")
	private String jobName;
	@Argument(index=1, name="jobGroup", required=false, description="Job group.")
	private transient String jobGroup = "DEFAULT";
	@Nullable
	@Argument(index=2, name="jobData ...", required=false, multiValued=true, description="Job Data (key=value).")
	private String[] jobDatas;
	
	@Nullable
	@Option(name="-n", description="Trigger name. If not filled will use Job name.")
	private String name;
	@Nullable
	@Option(name="-g", description="Trigger group. If not filled will use Job group.")
	private String group;
	@Nullable
	@Option(name="-p", description="Set the Trigger's priority. When more than one Trigger have the same fire time, the scheduler will fire the one with the highest priority first.")
	private Integer priority;
	@Nullable
	@Option(name="-s", description="Set the time (incl. time zone) the Trigger should start at - the trigger may or may not fire at this time - depending upon the schedule configured for the Trigger."
			+ " However the Trigger will NOT fire before this time, regardless of the Trigger's schedule. (otherwise, start now)")
	private String startAt;
	@Nullable
	@Option(name="-e", description="Set the time (incl. time zone) at which the Trigger will no longer fire - even if it's schedule has remaining repeats.")
	private String endAt;
	@Nullable
	@Option(name="-d", description="Set the given (human-meaningful) description of the Trigger.")
	private String description;
	@Option(name="-r", description="Simple Repeat: NONE|SECONDLY|MINUTELY|HOURLY.")
	private transient SimpleRepeat repeat = SimpleRepeat.NONE;
	@Nullable
	@Option(name="-c", description="Repeat count, otherwise forever.")
	private Integer repeatCount;
	@Option(name="-i", description="Repeat interval, e.g. 1 second/minute/hour.")
	private transient int interval = 1;

	@Override
	protected Trigger doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		final TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		triggerBuilder.forJob(jobName, jobGroup);
		triggerBuilder.withIdentity(Optional.fromNullable(name).or(jobName), Optional.fromNullable(group).or(jobGroup));
		if (priority != null) {
			triggerBuilder.withPriority(priority);
		}
		if (startAt != null) {
			triggerBuilder.startAt(new DateTime(startAt).toDate());
		} else {
			triggerBuilder.startNow();
		}
		if (endAt != null) {
			triggerBuilder.endAt(new DateTime(endAt).toDate());
		}
		if (jobDatas != null) {
			final JobDataMap jobDataMap = new JobDataMap();
			for (final String jobData : jobDatas) {
				final List<String> keyValue = Splitter.on('=').splitToList(jobData);
				jobDataMap.put(keyValue.get(0), keyValue.get(1));
			}
			triggerBuilder.usingJobData(jobDataMap);
		}
		if (description != null) {
			triggerBuilder.withDescription(description);
		}
		
		switch (repeat) {
		case NONE:
			triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule());
			break;
		case SECONDLY:
			if (repeatCount != null) {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(repeatCount, interval));
			} else {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(interval));
			}
			break;
		case MINUTELY:
			if (repeatCount != null) {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatMinutelyForTotalCount(repeatCount, interval));
			} else {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(interval));
			}
			break;
		case HOURLY:
			if (repeatCount != null) {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatHourlyForTotalCount(repeatCount, interval));
			} else {
				triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatHourlyForever(interval));
			}
			break;
		}
		
		final Trigger trigger = triggerBuilder.build();
		scheduler.scheduleJob(trigger);
		return trigger;
	}

}