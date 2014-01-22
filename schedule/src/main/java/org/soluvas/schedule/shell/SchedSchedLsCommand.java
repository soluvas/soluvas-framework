package org.soluvas.schedule.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.Resource;

import org.apache.felix.gogo.commands.Command;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * List {@link Scheduler}s for all tenants.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="schedls", description="List schedulers for all tenants.")
public class SchedSchedLsCommand extends ExtCommandSupport {

	@Resource(name="schedulerMap")
	private Map<String, Scheduler> schedulerMap;
	
	@Override @Nullable
	protected Integer doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%-15s|%-3s|%-3s|%-3s|%-25s|@",
				"№", "Name/Tenant", "Instance ID", "Cur", "Job", "Trg", "Store" ));
		int i = 0;
		for (Entry<String, Scheduler> entry : schedulerMap.entrySet()) {
//			final String tenantId = entry.getKey();
			final Scheduler scheduler = entry.getValue();
			final Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyJobGroup());
			final List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
			final Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(GroupMatcher.anyTriggerGroup());
			
			final String startedAnsi = scheduler.isStarted() ? "@|bold,green ▶|@‎" : "@|bold,red ◼|@";
			System.out.println(ansi().render("@|bold,black %3d||@" + startedAnsi + "%-19s@|bold,black ||@%-15s@|bold,black ||@%3d@|bold,black ||@%3d@|bold,black ||@%3d@|bold,black ||@%-25s",
				++i, scheduler.getSchedulerName(), scheduler.getSchedulerInstanceId(), 
						executingJobs.size(), jobKeys.size(), triggerKeys.size(),
						scheduler.getMetaData().getJobStoreClass().getSimpleName()));
		}
		System.out.println(ansi().render("@|bold,yellow %d|@ Schedulers", schedulerMap.size()));
		return schedulerMap.size();
	}

}