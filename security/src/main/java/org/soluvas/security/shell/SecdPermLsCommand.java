package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	protected Void doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-15s|%-15s|%-20s|%-40s|@",
				"№", "Domain", "Action", "Instance", "Role", "Source" ));
		final List<Permission> permissions = securityCatalog.getPermissions();
		int i = 0;
		for (Permission it : permissions) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			final Joiner spaceJoiner = Joiner.on(' ');
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-15s@|bold,black ||@%-15s@|bold,black ||@%-20s@|bold,black ||@%-40s",
					++i, spaceJoiner.join(it.getDomainPermission()),
					spaceJoiner.join(it.getActionPermission()),
					spaceJoiner.join(it.getInstancePermission()),
					spaceJoiner.join(it.getRoles()),
					StringUtils.right(it.getResourceUri(), 40) ));
		}
		System.out.println(ansi().render("@|bold %d|@ Permissions",
				securityCatalog.getPermissions().size()));
		return null;
	}

}