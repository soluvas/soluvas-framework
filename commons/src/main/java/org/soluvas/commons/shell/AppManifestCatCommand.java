 package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.commons.AppManifest;

/**
 * Show current {@link AppManifest}.
 *
 * @author ceefour
 */
@Command(scope="app", name="manifestcat", description="Show current AppManifest.")
public class AppManifestCatCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final AppManifest appManifest = getService(AppManifest.class, bundleContext.getServiceReference(AppManifest.class));
		return appManifest;
	}

}