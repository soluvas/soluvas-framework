package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;
import java.util.Set;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.AccessControlManager;
import org.soluvas.security.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Ordering;

/**
 * Shell command to list members of a {@link Role}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolememberls", description = "List members of a security roleId.")
public class SecRoleMemberLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleMemberLsCommand.class);

	@Argument(name="roleId", required=true, description="Role name.")
	private String roleId;

	@Override
	protected Void doExecute() throws Exception {
		final AccessControlManager acMgr = getBean(AccessControlManager.class);
		final Set<String> roleMembers = acMgr.getTenantRoleMembers(getTenant().getTenantId(), roleId);
		System.out.println(ansi().render("@|negative_on %3s|%-40s|@",
				"№", "Person"));
		final List<String> sortedRoleMembers = Ordering.natural().immutableSortedCopy(roleMembers);
		int i = 0;
		for (String it : sortedRoleMembers) {
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-40s|@", ++i, it ));
		}
		System.out.println(ansi().render("@|bold %d|@ members", sortedRoleMembers.size()));
		return null;
	}

}