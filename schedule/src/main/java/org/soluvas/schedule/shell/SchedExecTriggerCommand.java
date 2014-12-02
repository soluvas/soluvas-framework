package org.soluvas.schedule.shell;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.quartz.*;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Simulate executing the identified {@link org.quartz.Trigger} (execute it now).
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="exectrigger",
		description="Simulate executing the identified Trigger, by executing the JobDetail now using the Trigger's Job Data.")
public class SchedExecTriggerCommand extends ExtCommandSupport {

	@Option(name="-g", aliases = "--group", description="Trigger group.")
	private transient String group = "DEFAULT";

	@Argument(index=0, name="name ...", required=true, multiValued = true, description="Trigger name(s).")
	private String[] names;

	@Override @Nullable
	protected Void doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		System.err.println(ansi().render("Using scheduler @|bold %s|@", scheduler.getSchedulerName()));
		final JobDataMap jobDataMap = new JobDataMap();
		for (final String name : names) {
			final Trigger trigger = scheduler.getTrigger(new TriggerKey(group, name));
			System.err.println(ansi().render("Triggering job @|bold %s|@ using @|bold %s|@",
					trigger.getJobKey(), ImmutableMap.copyOf(trigger.getJobDataMap())));
			scheduler.triggerJob(trigger.getJobKey(), trigger.getJobDataMap());
		}
		return null;
	}

}