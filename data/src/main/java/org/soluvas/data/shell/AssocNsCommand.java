package org.soluvas.data.shell;

import java.util.Set;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.data.repository.AssocRepository;

/**
 * List available {@link AssocRepository} namespaces.
 * @author ceefour
 */
@Command(scope="assoc", name="ns", description="List available AssocRepository namespaces.")
public class AssocNsCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocNsCommand.class);

	private final ServiceLookup svcLookup;

	public AssocNsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Set<String> doExecute() throws Exception {
		return svcLookup.getNamespaces(AssocRepository.class, svcLookup.getTenant(session), null);
	}

}
