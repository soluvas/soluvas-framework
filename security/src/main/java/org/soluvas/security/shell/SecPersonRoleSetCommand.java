 package org.soluvas.security.shell; 

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

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * Shell command to set members of a {@link Role}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "personroleset", description = "Set security roles of a person.")
public class SecPersonRoleSetCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecPersonRoleSetCommand.class);

	@Argument(index=0, name="personId", required=true, description="Person ID")
	private String personId;
	@Argument(index=1, name="role ...", required=false, multiValued=true,
			description="Role name(s). If none specified, will remove all roles from the person.")
	private String[] roles;

	private final SecurityRepository securityRepo;

	@Inject
	public SecPersonRoleSetCommand(SecurityRepository securityRepo) {
		super();
		this.securityRepo = securityRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		final Set<String> roleSet = roles != null ? ImmutableSet.copyOf(roles) : ImmutableSet.<String>of();
		System.out.format("Setting security roles of %s to %s...",
				personId, Joiner.on(", ").join(roleSet));
		securityRepo.replacePersonRoles(personId, roleSet);
		System.out.format(" OK\n");
		return null;
	}

}