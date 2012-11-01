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
import com.google.common.collect.ImmutableList;


/**
 * Deletes a {@link Role} in the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "rolerm", description = "Deletes a Role in the Security Repository.")
public class SecRoleRmCommand extends OsgiCommandSupport {

	private transient Logger log = LoggerFactory.getLogger(SecRoleRmCommand.class);

	private final ServiceLookup svcLookup;

	@Argument(index=0, name="role", required=true, multiValued=true,
			description="Role name(s) to delete.")
	private String roles[];

	public SecRoleRmCommand(ServiceLookup svcLookup) {
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
			System.out.format("Delete role(s): %s...", Joiner.on(", ").join(roles));
			securityRepo.getRoleRepository().deleteIds(ImmutableList.copyOf(roles));
			System.out.format(" OK\n");
			return null;
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}