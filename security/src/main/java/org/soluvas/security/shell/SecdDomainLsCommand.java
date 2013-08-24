package org.soluvas.security.shell; 

import java.util.List;

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
	protected Object doExecute() throws Exception {
		final SecurityCatalog securityCatalog = getBean(SecurityCatalog.class);
		System.out.format("%3s | %-15s | %-40s | %s\n", "#", "Name",
				"Source", "Description");
		final List<Domain> sortedDomains = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getDomains());
		int i = 0;
		for (final Domain it : sortedDomains) {
			// TODO: use locale settings to format date, currency, amount,
			// "and", many
			// TODO: format products
			System.out.format("%3d | %-15s | %-40s | %s\n", ++i, it.getName(),
					it.getResourceUri(), it.getDescription() );
		}
		System.out.format("%d Domains\n", securityCatalog.getDomains().size());
		return null;
	}

}