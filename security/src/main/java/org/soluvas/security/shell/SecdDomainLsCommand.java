 package org.soluvas.security.shell; 

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EObjectNameOrdering;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.security.Domain;
import org.soluvas.security.SecurityCatalog;


/**
 * Shell command to list available {@link Domain}s.
 * 
 * @author ceefour
 */
@Command(scope = "secd", name = "domainls", description = "List available Domains")
public class SecdDomainLsCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecdDomainLsCommand.class);

	private final ServiceLookup svcLookup;

	public SecdDomainLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-15s | %-40s | %s\n", "#", "Name",
				"Source", "Description");
		SecurityCatalog securityCatalog = svcLookup.getSupplied(
				SecurityCatalog.class, session);
		List<Domain> sortedDomains = new EObjectNameOrdering()
				.immutableSortedCopy(securityCatalog.getDomains());
		int i = 0;
		for (Domain it : sortedDomains) {
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