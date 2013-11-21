package org.soluvas.schedule.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Set;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * List {@link JobDetail}s for current {@link TenantRef}'s {@link Scheduler}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="jobls", description="List JobDetails for current tenant's Scheduler.")
public class SchedJobLsCommand extends ExtCommandSupport {

	@Override @Nullable
	protected Integer doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		final Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyJobGroup());
		System.out.println(ansi().render("@|negative_on %3s|%-25s|%-20s|%-25s|@",
				"№", "Name", "Group", "Class"));
		int i = 0;
		for (final JobKey it : jobKeys) {
			final JobDetail jobDetail = scheduler.getJobDetail(it);
			final String jobClassAnsi = NameUtils.shortenClassAnsi(jobDetail.getJobClass(), 25);
			System.out.println(ansi().render("@|bold,black %3d||@%-25s@|bold,black ||@%-20s@|bold,black ||@" + jobClassAnsi,
				++i, it.getName(), it.getGroup()));
		}
		System.out.println(ansi().render("@|bold,yellow %d|@ Jobs", 
				jobKeys.size()));
		return jobKeys.size();
	}

}