 package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;


/**
 * List {@link Role}s in the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "rolels", description = "List Roles in the SecurityRepository.")
public class SecRoleLsCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecRoleLsCommand.class);

	private final ServiceLookup svcLookup;

	public SecRoleLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-15s | %s\n", "#", "Name", "Description");
		ServiceReference<SecurityRepository> securityRepoRef = svcLookup.getService(SecurityRepository.class, session, null, null);
		SecurityRepository securityRepo = bundleContext.getService(securityRepoRef);
		try {
			Iterable<Role> repoRoles = securityRepo.getRoleRepository().findAll();
			List<Role> sortedRoles = new EObjectNameOrdering().immutableSortedCopy(repoRoles);
			int i = 0;
			for (Role it : sortedRoles) {
				// TODO: use locale settings to format date, currency, amount,
				// "and", many
				// TODO: format products
				System.out.format("%3d | %-15s | %s\n", ++i, it.getName(),
						it.getDescription() );
			}
			System.out.format("%d Roles\n", sortedRoles.size());
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}