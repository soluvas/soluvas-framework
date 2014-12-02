package org.soluvas.schedule.shell;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Unschedule a {@link org.quartz.Trigger} for current {@link org.soluvas.commons.tenant.TenantRef}'s {@link org.quartz.Scheduler}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sched", name="trigrm", description="Unschedule a Trigger for current tenant's Scheduler.")
public class SchedTrigRmCommand extends ExtCommandSupport {

	@Option(name="-a", aliases = "--all", description="Unschedule all Triggers in the specified group.")
	private transient boolean all = false;
	@Option(name="-g", aliases = "--group", description="Trigger group.")
	private transient String group = "DEFAULT";

	@Argument(index=0, name="name ...", required=false, multiValued = true, description="Trigger name(s).")
	private String[] names;

	@Override @Nullable
	protected Void doExecute() throws Exception {
		final Scheduler scheduler = getBean(Scheduler.class);
		System.err.println(ansi().render("Using scheduler @|bold %s|@", scheduler.getSchedulerName()));
		final Set<TriggerKey> triggerKeys;
		if (all) {
			triggerKeys = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(group));
		} else {
			triggerKeys = FluentIterable.from(Arrays.asList(names)).transform(new Function<String, TriggerKey>() {
				@Nullable @Override
				public TriggerKey apply(@Nullable String input) {
					return new TriggerKey(input, group);
				}
			}).toSet();
		}

		for (final TriggerKey key : triggerKeys) {
			System.err.print(ansi().render("Unscheduling @|bold %-30s|@", key.getGroup() + "." + key.getName()));
			final boolean unscheduled = scheduler.unscheduleJob(key);
			System.err.println(ansi().render(" @|bold %s|@", unscheduled));
		}

		return null;
	}

}