package org.soluvas.security.shell; 

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

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

	private final SecurityRepository securityRepo;
	
	@Argument(name="personId", required=true, description="Person ID.")
	private String personId;
	
	@Inject
	public SecPersonRoleLsCommand(SecurityRepository securityRepo) {
		super();
		this.securityRepo = securityRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		final Set<String> personRoles = securityRepo.getPersonRoles(personId);
		System.out.format("%3s | %-40s\n", "#", "Role");
		final List<String> sortedRoles = Ordering.natural().immutableSortedCopy(personRoles);
		int i = 0;
		for (final String it : sortedRoles) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-40s\n", ++i, it );
		}
		System.out.format("%d roles\n", sortedRoles.size());
		return null;
	}

}