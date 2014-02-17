package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Set;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.AccessControlManager;
import org.soluvas.security.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * Shell command to set {@link Role}s of a {@link Person}.
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

	@Override
	protected Set<String> doExecute() throws Exception {
		final AccessControlManager acMgr = getBean(AccessControlManager.class);
		final Set<String> roleSet = roles != null ? ImmutableSet.copyOf(roles) : ImmutableSet.<String>of();
		System.out.print(ansi().render("Setting security roles of @|bold %s|@ to @|bold %s|@...",
				personId, Joiner.on(", ").join(roleSet)));
		acMgr.replacePersonTenantRoles(getTenant().getTenantId(), personId, roleSet);
		System.out.println(ansi().render(" @|bold,bg_green  OK |@"));
		return roleSet;
	}

}