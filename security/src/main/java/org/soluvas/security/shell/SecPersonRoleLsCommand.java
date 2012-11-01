package org.soluvas.security.shell; 

import java.util.List;
import java.util.Set;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.multitenant.ServiceLookup;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;

import com.google.common.collect.Ordering;

/**
 * Shell command to list {@link Role} of a person.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "personrolels", description = "List roles of a person.")
public class SecPersonRoleLsCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecPersonRoleLsCommand.class);

	private final ServiceLookup svcLookup;
	
	@Argument(name="personId", required=true, description="Person ID.")
	private String personId;

	public SecPersonRoleLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		ServiceReference<SecurityRepository> securityRepoRef = svcLookup.getService(SecurityRepository.class, session, null, null);
		SecurityRepository securityRepo = bundleContext.getService(securityRepoRef);
		try {
			Set<String> personRoles = securityRepo.getPersonRoles(personId);
			System.out.format("%3s | %-40s\n", "#", "Role");
			List<String> sortedRoles = Ordering.natural().immutableSortedCopy(personRoles);
			int i = 0;
			for (String it : sortedRoles) {
				// TODO: use locale settings to format date, currency, amount,
				// "and", many
				// TODO: format products
				System.out.format("%3d | %-40s\n", ++i, it );
			}
			System.out.format("%d roles\n", sortedRoles.size());
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}