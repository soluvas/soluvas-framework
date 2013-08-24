package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


/**
 * List {@link Role}s in the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolels", description = "List Roles in the SecurityRepository.")
public class SecRoleLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleLsCommand.class);

	@Override
	protected Object doExecute() throws Exception {
		final SecurityRepository securityRepo = getBean(SecurityRepository.class);
		System.out.format("%3s | %-15s | %s\n", "#", "Name", "Description");
		Iterable<Role> repoRoles = securityRepo.getRoleRepository().findAll();
		List<Role> sortedRoles = new EObjectNameOrdering().immutableSortedCopy(repoRoles);
		int i = 0;
		for (Role it : sortedRoles) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-15s | %s\n", ++i, it.getName(),
					it.getDescription() );
		}
		System.out.format("%d Roles\n", sortedRoles.size());
		return null;
	}

}