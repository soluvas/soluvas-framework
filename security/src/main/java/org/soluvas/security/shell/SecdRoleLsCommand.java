package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	protected Void doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-20s|%-40s|%-40s|@",
				"№", "ID", "Name", "Source", "Description" ));
		final List<Role> sortedRoles = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getRoles());
		int i = 0;
		for (final Role it : sortedRoles) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-20s@|bold,black ||@%-40s@|bold,black ||@%-40s",
					++i, it.getId(), it.getName(), StringUtils.right(it.getResourceUri(), 40), it.getDescription() ));
		}
		System.out.println(ansi().render("@|bold %d|@ Roles", securityCatalog.getRoles().size()));
		return null;
	}

}
