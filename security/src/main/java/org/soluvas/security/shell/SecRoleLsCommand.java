package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.security.Role;
import org.soluvas.security.RoleRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * List {@link Role}s in the {@link RoleRepository}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolels", description = "List Roles in the RoleRepository.")
public class SecRoleLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleLsCommand.class);

	@Override
	protected Object doExecute() throws Exception {
		final RoleRepository roleRepo = getBean(RoleRepository.class);
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%-25s|%-30s|@", "№", "ID", "Name", "Description"));
		final Page<Role> repoRoles = roleRepo.findAll(new CappedRequest(100L));
		int i = 0;
		for (final Role it : repoRoles) {
			System.out.println(ansi().render("@|bold,black %3d||@%-20s@|bold,black ||@%-25s@|bold,black ||@%s|%s", 
					++i, it.getId(), it.getName(), it.getDescription(), it.getResourceUri() ));
		}
		System.out.format("%d out of %d Roles\n", repoRoles.getNumberOfElements(), repoRoles.getTotalElements());
		return null;
	}

}
