package org.soluvas.commons.shell;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.basic.SimpleCommand;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

/**
 * For how to publish GoGo commands in OSGi, see {@link SimpleCommand}.
 * @author ceefour
 */
@Command(scope="tenant", name="info", description="Show multitenancy info for current command session.")
public class TenantInfoCommand extends OsgiCommandSupport {
	
	private static final Logger log = LoggerFactory.getLogger(TenantInfoCommand.class);
	
	public TenantInfoCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		String clientId = (String) session.get("clientId");
		String tenantEnv = (String) session.get("tenantEnv");
		String tenantId = (String) session.get("tenantId");
		return String.format("Client ID:  %s\nTenant Env: %s\nTenant ID:  %s\n",
				Optional.fromNullable(clientId).or("(default)"),
				Optional.fromNullable(tenantEnv).or("(default)"),
				Optional.fromNullable(tenantId).or("(default)") );
	}

}
