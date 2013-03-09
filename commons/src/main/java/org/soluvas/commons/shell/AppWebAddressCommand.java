 package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

/**
 * Show current {@link WebAddress}.
 *
 * @author ceefour
 */
@Command(scope="app", name="webaddress", description="Show current WebAddress.")
public class AppWebAddressCommand extends OsgiCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final WebAddress webAddress = getService(WebAddress.class,
				bundleContext.getServiceReference(WebAddress.class));
		return webAddress;
	}

}