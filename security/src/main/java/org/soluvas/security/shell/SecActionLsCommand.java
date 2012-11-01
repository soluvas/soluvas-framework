 package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.multitenant.ServiceLookup;
import org.soluvas.security.Action;
import org.soluvas.security.SecurityCatalog;

import com.google.common.base.Joiner;

/**
 * Shell command to list available {@link Action}s.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "actionls", description = "List available Actions")
public class SecActionLsCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecActionLsCommand.class);

	private final ServiceLookup svcLookup;

	public SecActionLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-20s | %1s | %-20s | %-40s | %s\n", "#",
				"Name", "G", "Domains", "Source", "Description");
		SecurityCatalog securityCatalog = svcLookup.getSupplied(
				SecurityCatalog.class, session);
		List<Action> sortedActions = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getActions());
		int i = 0;
		for (Action it : sortedActions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-20s | %1s | %-20s | %-40s | %s\n", ++i,
					it.getName(), it.getGlobal() ? "G" : "-",
					Joiner.on(", ").join(it.getDomains()),
					it.eResource() != null ? it .eResource().getURI() : null,
					it.getDescription());
		}
		System.out.format("%d Actions\n", securityCatalog.getActions().size());
		return null;
	}

}