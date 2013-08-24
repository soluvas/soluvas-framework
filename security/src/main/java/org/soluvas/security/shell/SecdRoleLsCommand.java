package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to list available {@link Role}s.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "secd", name = "rolels", description = "List available Roles")
public class SecdRoleLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecdRoleLsCommand.class);
	
	@Override
	protected Object doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.format("%3s | %-15s | %-40s | %s\n", "#", "Name",
				"Source", "Description");
		final List<Role> sortedRoles = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getRoles());
		int i = 0;
		for (final Role it : sortedRoles) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-15s | %-40s | %s\n", ++i, it.getName(),
					it.getResourceUri(), it.getDescription() );
		}
		System.out.format("%d Roles\n", securityCatalog.getRoles().size());
		return null;
	}

}