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
 * Shell command to list members of a {@link Role}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolememberls", description = "List members of a security role.")
public class SecRoleMemberLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleMemberLsCommand.class);

	@Argument(name="role", required=true, description="Role name.")
	private String role;

	private final SecurityRepository securityRepo;

	@Inject
	public SecRoleMemberLsCommand(SecurityRepository securityRepo) {
		super();
		this.securityRepo = securityRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		Set<String> roleMembers = securityRepo.getRoleMembers(role);
		System.out.format("%3s | %-40s\n", "#", "Name");
		List<String> sortedRoleMembers = Ordering.natural().immutableSortedCopy(roleMembers);
		int i = 0;
		for (String it : sortedRoleMembers) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-40s\n", ++i, it );
		}
		System.out.format("%d members\n", sortedRoleMembers.size());
		return null;
	}

}