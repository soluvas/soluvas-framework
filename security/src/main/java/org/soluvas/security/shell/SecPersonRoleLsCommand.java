package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;
import java.util.Set;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Ordering;

/**
 * Shell command to list {@link Role} of a person.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "personrolels", description = "List roles of a person.")
public class SecPersonRoleLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecPersonRoleLsCommand.class);

	@Argument(name="personId", required=true, description="Person ID.")
	private String personId;
	
	@Override
	protected Void doExecute() throws Exception {
		final SecurityRepository securityRepo = getBean(SecurityRepository.class);
		final Set<String> personRoles = securityRepo.getPersonRoles(personId);
		System.out.println(ansi().render("@|negative_on %3s|%-%-40s|@",
				"№", "Role"));
		final List<String> sortedRoles = Ordering.natural().immutableSortedCopy(personRoles);
		int i = 0;
		for (final String it : sortedRoles) {
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-40s",
					++i, it ));
		}
		System.out.println(ansi().render("@|bold %d|@ roles", sortedRoles.size()));
		return null;
	}

}