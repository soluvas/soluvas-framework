package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Action;
import org.soluvas.security.SecurityCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;

/**
 * Shell command to list available {@link Action}s.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "secd", name = "actionls", description = "List available Actions")
public class SecdActionLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecdActionLsCommand.class);

	@Override
	protected Void doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%-1s|%-20s|%-40s|%-40s|@",
				"№", "Name", "G", "Domains", "Source", "Description" ));
		final List<Action> sortedActions = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getActions());
		int i = 0;
		for (final Action it : sortedActions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-20s|@@|bold,black ||@%-1s@|bold,black ||@%-20s@|bold,black ||@%-40s@|bold,black ||@%-40s",
					++i,
					it.getName(), it.getGlobal() ? "G" : "-",
					Joiner.on(", ").join(it.getDomains()),
					StringUtils.right(it.getResourceUri(), 40),
					it.getDescription() ));
		}
		System.out.println(ansi().render("@|bold %d|@ Actions", securityCatalog.getActions().size()));
		return null;
	}

}