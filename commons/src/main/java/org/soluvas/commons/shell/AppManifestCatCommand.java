 package org.soluvas.commons.shell; 

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Supplied;

/**
 * Show current {@link AppManifest}.
 *
 * @author ceefour
 */
@Command(scope="app", name="manifestcat", description="Show current AppManifest.")
public class AppManifestCatCommand extends TenantCommandSupport {

	@Inject @Supplied @Filter("(layer=application)")
	private AppManifest appManifest;
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		return appManifest;
	}

}