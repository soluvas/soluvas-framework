package org.soluvas.schedule.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;

/**
 * Trigger the identified {@link JobDetail} (execute it now).
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="exec", description="Trigger the identified JobDetail (execute it now).")
public class SchedExecCommand extends ExtCommandSupport {

	@Argument(index=0, name="job", required=true, description="Job name.")
	private String jobName;
	@Argument(index=1, name="group", required=false, description="Job group.")
	private transient String jobGroup = "DEFAULT";
	@Nullable
	@Argument(index=2, name="jobData ...", required=false, multiValued=true, description="Job Data (key=value).")
	private String[] jobDatas;
	
	@Override @Nullable
	protected Object doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		System.err.println(ansi().render("Using scheduler @|bold %s|@", scheduler.getSchedulerName()));
		final JobDataMap jobDataMap = new JobDataMap();
		if (jobDatas != null) {
			for (final String jobData : jobDatas) {
				final List<String> keyValue = Splitter.on('=').splitToList(jobData);
				jobDataMap.put(keyValue.get(0), keyValue.get(1));
			}
		}
		scheduler.triggerJob(new JobKey(jobName, jobGroup), jobDataMap);
		return null;
	}

}