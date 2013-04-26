 package org.soluvas.security.shell; 

import java.util.List;

import javax.inject.Inject;

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

	private final SecurityCatalog securityCatalog;
	
	@Inject
	public SecdActionLsCommand(final SecurityCatalog securityCatalog) {
		super();
		this.securityCatalog = securityCatalog;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-20s | %1s | %-20s | %-40s | %s\n", "#",
				"Name", "G", "Domains", "Source", "Description");
		final List<Action> sortedActions = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getActions());
		int i = 0;
		for (final Action it : sortedActions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-20s | %1s | %-20s | %-40s | %s\n", ++i,
					it.getName(), it.getGlobal() ? "G" : "-",
					Joiner.on(", ").join(it.getDomains()),
					it.getResourceUri(),
					it.getDescription());
		}
		System.out.format("%d Actions\n", securityCatalog.getActions().size());
		return null;
	}

}