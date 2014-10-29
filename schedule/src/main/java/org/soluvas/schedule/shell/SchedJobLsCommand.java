package org.soluvas.schedule.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
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

import com.google.common.collect.ImmutableMap;

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
		System.out.println(ansi().render("@|negative_on %3s|%-50s|%-20s|%-25s|%-1s|%-1s|%-1s|%-1s|@",
				"№", "Name", "Group", "Class", "C", "P", "D", "R"));
		int i = 0;
		for (final JobKey it : jobKeys) {
			final JobDetail jobDetail = scheduler.getJobDetail(it);
			final String jobClassAnsi = NameUtils.shortenClassAnsi(jobDetail.getJobClass(), 25);
			System.out.println(ansi().render("@|bold,black %3d||@%-50s@|bold,black ||@%-20s@|bold,black ||@" + jobClassAnsi + "@|bold,black ||@%-1s@|bold,black ||@%-1s@|bold,black ||@%-1s@|bold,black ||@%-1s",
				++i, StringUtils.abbreviateMiddle(it.getName(), "…", 50), it.getGroup(),
				jobDetail.isConcurrentExectionDisallowed() ? "-" : "C", jobDetail.isPersistJobDataAfterExecution() ? "P" : "-",
				jobDetail.isDurable() ? "D" : "-", jobDetail.requestsRecovery() ? "R" : "-"));
			System.out.println(ansi().render("@|bold,black    ||@%-50s", ImmutableMap.copyOf(jobDetail.getJobDataMap())));
		}
		System.out.println(ansi().render("@|bold,yellow %d|@ Jobs in scheduler @|bold %s|@", 
				jobKeys.size(), scheduler.getSchedulerName()));
		return jobKeys.size();
	}

}