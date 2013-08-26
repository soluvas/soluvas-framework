package org.soluvas.commons.shell;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show {@link TenantRef} info for current command session.
 * @author ceefour
 * @see AppManifestCommand
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="info", description="Show tenant info for current command session. See also app:manifest")
public class TenantInfoCommand extends ExtCommandSupport {
	
	@Override
	protected Object doExecute() throws Exception {
		final TenantRef tenant = getTenant();
		return String.format("Client: %s | Tenant: %s | Env: %s", 
				tenant.getClientId(), tenant.getTenantId(), tenant.getTenantEnv());
	}

}
