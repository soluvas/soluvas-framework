 package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.multitenant.ServiceLookup;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;


/**
 * Shell command to list available {@link Role}s.
 * 
 * @author ceefour
 */
@Command(scope = "secd", name = "rolels", description = "List available Roles")
public class SecdRoleLsCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecdRoleLsCommand.class);

	private final ServiceLookup svcLookup;

	public SecdRoleLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-15s | %-40s | %s\n", "#", "Name",
				"Source", "Description");
		SecurityCatalog securityCatalog = svcLookup.getSupplied(
				SecurityCatalog.class, session);
		List<Role> sortedRoles = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getRoles());
		int i = 0;
		for (Role it : sortedRoles) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-15s | %-40s | %s\n", ++i, it.getName(),
					it.getResourceUri(), it.getDescription() );
		}
		System.out.format("%d Roles\n", securityCatalog.getRoles().size());
		return null;
	}

}