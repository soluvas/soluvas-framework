 package org.soluvas.security.shell; 

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.multitenant.ServiceLookup;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * Shell command to set members of a {@link Role}.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "rolememberset", description = "Set members of a security role.")
public class SecRoleMemberSetCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecRoleMemberSetCommand.class);

	private final ServiceLookup svcLookup;
	
	@Argument(index=0, name="role", required=true, description="Role name.")
	private String role;
	@Argument(index=1, name="personId ...", required=true, description="Person ID(s)", multiValued=true)
	private String[] personIds;

	public SecRoleMemberSetCommand(ServiceLookup svcLookup) {
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
			System.out.format("Setting members of role %s to %s...",
					role, Joiner.on(", ").join(personIds));
			securityRepo.replaceRoleMembers(role, ImmutableSet.copyOf(personIds));
			System.out.format(" OK\n");
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}