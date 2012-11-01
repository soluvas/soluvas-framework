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
 * Shell command to list members of a {@link Role}.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "rolemembers", description = "List members of a security role.")
public class SecRoleMembersCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecRoleMembersCommand.class);

	private final ServiceLookup svcLookup;
	
	@Argument(name="role", required=true, description="Role name.")
	private String role;

	public SecRoleMembersCommand(ServiceLookup svcLookup) {
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
			Set<String> roleMembers = securityRepo.getRoleMembers(role);
			System.out.format("%3s | %-40s\n", "#", "Name");
			List<String> sortedRoleMembers = Ordering.natural().immutableSortedCopy(roleMembers);
			int i = 0;
			for (String it : sortedRoleMembers) {
				// TODO: use locale settings to format date, currency, amount,
				// "and", many
				// TODO: format products
				System.out.format("%3d | %-40s\n", ++i, it );
			}
			System.out.format("%d members\n", sortedRoleMembers.size());
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}