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
@Command(scope="tenant", name="use", description="Change client and environment for current command session.")
public class TenantUseCommand extends OsgiCommandSupport {
	
	private static final Logger log = LoggerFactory.getLogger(TenantUseCommand.class);
	
	@Argument(index=0, name="clientId", required=true, description="Client ID, e.g. berbatik, bippo, tuneeca")
	private String clientId;
	@Argument(index=1, name="tenantEnv", required=true, description="Tenant environment, e.g. dev, stg, prd.")
	private String tenantEnv;
	@Argument(index=2, name="tenantId", required=false, description="Tenant ID, if different than client ID.")
	private String tenantId;
	
	public TenantUseCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		session.put("clientId", clientId);
		session.put("tenantEnv", tenantEnv);
		session.put("tenantId", Optional.fromNullable(tenantId).or(clientId));
		return String.format("Client: %s | Tenant: %s | Env: %s", session.get("clientId"), session.get("tenantId"),
				session.get("tenantEnv"));
	}

}
