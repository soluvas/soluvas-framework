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
import com.google.common.collect.ImmutableList;


/**
 * Deletes a {@link Role} in the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolerm", description = "Deletes a Role in the Security Repository.")
public class SecRoleRmCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleRmCommand.class);

	@Argument(index=0, name="role", required=true, multiValued=true,
			description="Role name(s) to delete.")
	private String roles[];

	@Override
	protected Object doExecute() throws Exception {
		final SecurityRepository securityRepo = getBean(SecurityRepository.class);
		System.out.format("Delete role(s): %s...", Joiner.on(", ").join(roles));
		securityRepo.getRoleRepository().deleteIds(ImmutableList.copyOf(roles));
		System.out.format(" OK\n");
		return null;
	}

}