package org.soluvas.commons.shell;

import org.apache.felix.gogo.commands.Argument;
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
@Command(scope="tenant", name="env", description="Set active tenant environment for current client for current command session.")
public class TenantEnvCommand extends OsgiCommandSupport {
	
	private static final Logger log = LoggerFactory.getLogger(TenantEnvCommand.class);
	
	@Argument(index=0, name="tenantEnv", required=false, description="Tenant environment, e.g. dev, stg, prd.")
	private String tenantEnv;
	
	public TenantEnvCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		if (tenantEnv != null)
			session.put("tenantEnv", tenantEnv);
		return Optional.fromNullable(session.get("tenantEnv")).or("(default)");
	}

}
