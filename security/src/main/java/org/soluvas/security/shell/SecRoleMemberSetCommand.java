 package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.AccessControlManager;
import org.soluvas.security.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * Shell command to set {@link Person2} members of a tenant {@link Role}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolememberset", description = "Set members of a tenant role.")
public class SecRoleMemberSetCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleMemberSetCommand.class);

	@Argument(index=0, name="role", required=true, description="Role name.")
	private String role;
	@Argument(index=1, name="personId ...", required=false, description="Person ID(s)", multiValued=true)
	private String[] personIds;

	@Override
	protected Void doExecute() throws Exception {
		final AccessControlManager acMgr = getBean(AccessControlManager.class);
		System.out.print(ansi().render("Setting members of role @|bold %s|@ to @|bold %s|@...",
				role, Joiner.on(", ").join(personIds)));
		acMgr.replaceTenantRoleMembers(getTenant().getTenantId(), role, ImmutableSet.copyOf(personIds));
		System.out.println(ansi().render(" @|bold,bg_green  OK |@"));
		return null;
	}

}