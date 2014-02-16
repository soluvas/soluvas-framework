package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.Domain;
import org.soluvas.security.SecurityCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to list available {@link Domain}s.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "secd", name = "domainls", description = "List available Domains")
public class SecdDomainLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecdDomainLsCommand.class);

	@Override
	protected Void doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-40s|%-40s|@",
				"№", "Name", "Source", "Description" ));
		final List<Domain> sortedDomains = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getDomains());
		int i = 0;
		for (final Domain it : sortedDomains) {
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-40s@|bold,black ||@%-40s",
					++i, it.getName(), StringUtils.right(it.getResourceUri(), 40), it.getDescription() ));
		}
		System.out.println(ansi().render("@|bold %d|@ Domains\n", securityCatalog.getDomains().size()));
		return null;
	}

}