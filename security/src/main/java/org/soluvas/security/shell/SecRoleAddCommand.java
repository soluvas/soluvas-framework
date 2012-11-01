 package org.soluvas.security.shell; 

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
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
 * Add a {@link Role} to the Security Repository.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "roleadd", description = "Add a Role to the Security Repository")
public class SecRoleAddCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecRoleAddCommand.class);

	private final ServiceLookup svcLookup;

	@Option(name="-d", aliases="--description", description="Role description.")
	private String description;
	@Argument(index=0, name="role", required=true, description="Role name.")
	private String role;
	@Argument(index=1, name="personId ...", required=true, description="Role members as Person ID(s).", multiValued=true)
	private String[] personIds;

	public SecRoleAddCommand(ServiceLookup svcLookup) {
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
			System.out.format("Add role %s with members: %s and description '%s'...",
					role,
					Joiner.on(", ").join(personIds),
					description);
			securityRepo.addRole(role, description, ImmutableSet.copyOf(personIds));
			System.out.format(" OK\n");
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}