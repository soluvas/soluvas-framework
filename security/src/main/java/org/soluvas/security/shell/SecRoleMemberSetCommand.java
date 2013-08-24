 package org.soluvas.security.shell; 

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * Shell command to set members of a {@link Role}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolememberset", description = "Set members of a security role.")
public class SecRoleMemberSetCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleMemberSetCommand.class);

	@Argument(index=0, name="role", required=true, description="Role name.")
	private String role;
	@Argument(index=1, name="personId ...", required=false, description="Person ID(s)", multiValued=true)
	private String[] personIds;

	@Override
	protected Object doExecute() throws Exception {
		final SecurityRepository securityRepo = getBean(SecurityRepository.class);
		System.out.format("Setting members of role %s to %s...",
				role, Joiner.on(", ").join(personIds));
		securityRepo.replaceRoleMembers(role, ImmutableSet.copyOf(personIds));
		System.out.format(" OK\n");
		return null;
	}

}