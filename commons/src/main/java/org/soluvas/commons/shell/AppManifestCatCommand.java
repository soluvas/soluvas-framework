 package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.ServiceLookup;

/**
 * Show current {@link AppManifest}.
 *
 * @author ceefour
 */
@Command(scope="app", name="manifestcat", description="Show current AppManifest.")
public class AppManifestCatCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AppManifestCatCommand.class);

	private final ServiceLookup svcLookup;

	public AppManifestCatCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		AppManifest appManifest = svcLookup.getSupplied(AppManifest.class, session);
		return appManifest;
	}

}