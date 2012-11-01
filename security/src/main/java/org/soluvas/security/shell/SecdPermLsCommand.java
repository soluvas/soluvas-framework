 package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.multitenant.ServiceLookup;
import org.soluvas.security.Permission;
import org.soluvas.security.SecurityCatalog;

import com.google.common.base.Joiner;

/**
 * Shell command to list available {@link Permission}s.
 * 
 * @author ceefour
 */
@Command(scope = "secd", name = "permls", description = "List available Permissions")
public class SecdPermLsCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecdPermLsCommand.class);

	private final ServiceLookup svcLookup;

	public SecdPermLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-15s | %-15s | %-15s | %-20s | %s\n", "#",
				"Domain", "Action", "Instance", "Role", "Source");
		SecurityCatalog securityCatalog = svcLookup.getSupplied(
				SecurityCatalog.class, session);
		List<Permission> permissions = securityCatalog.getPermissions();
		int i = 0;
		for (Permission it : permissions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			final Joiner spaceJoiner = Joiner.on(' ');
			System.out.format("%3d | %-15s | %-15s | %-15s | %-20s | %s\n",
					++i, spaceJoiner.join(it.getDomainPermission()),
					spaceJoiner.join(it.getActionPermission()), spaceJoiner
							.join(it.getInstancePermission()), spaceJoiner
							.join(it.getRoles()),
					it.getResourceUri());
		}
		System.out.format("%d Permissions\n", securityCatalog.getPermissions()
				.size());
		return null;
	}

}