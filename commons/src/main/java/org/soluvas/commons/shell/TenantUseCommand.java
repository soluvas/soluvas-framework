package org.soluvas.commons.shell;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

/**
 * Change clientId/tenantId for current command session.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="use", description="Change clientId/tenantId for current command session.")
public class TenantUseCommand extends ExtCommandSupport {
	
	@Argument(index=0, name="clientId", required=true, description="Client ID, e.g. berbatik, bippo, tuneeca")
	private String clientId;
	@Argument(index=1, name="tenantId", required=false, description="Tenant ID, if different than client ID.")
	private String tenantId;
	
	public TenantUseCommand() {
		super(false);
	}
	
	@Override
	protected Object doExecute() throws Exception {
		setClientId(clientId);
		setTenantId(Optional.fromNullable(tenantId).or(clientId));
		final TenantRef tenant = getTenant();
		return String.format("Client: %s | Tenant: %s | Env: %s", 
				tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv());
	}

}
