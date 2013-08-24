package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Permission;
import org.soluvas.security.SecurityCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;

/**
 * Shell command to list available {@link Permission}s.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "secd", name = "permls", description = "List available Permissions")
public class SecdPermLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecdPermLsCommand.class);

	@Override
	protected Object doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.format("%3s | %-15s | %-15s | %-15s | %-20s | %s\n", "#",
				"Domain", "Action", "Instance", "Role", "Source");
		final List<Permission> permissions = securityCatalog.getPermissions();
		int i = 0;
		for (Permission it : permissions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			final Joiner spaceJoiner = Joiner.on(' ');
			System.out.format("%3d | %-15s | %-15s | %-15s | %-20s | %s\n",
					++i, spaceJoiner.join(it.getDomainPermission()),
					spaceJoiner.join(it.getActionPermission()), spaceJoiner
							.join(it.getInstancePermission()), spaceJoiner
							.join(it.getRoles()),
					it.getResourceUri());
		}
		System.out.format("%d Permissions\n", securityCatalog.getPermissions()
				.size());
		return null;
	}

}