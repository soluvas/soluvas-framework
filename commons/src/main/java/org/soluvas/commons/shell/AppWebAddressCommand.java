 package org.soluvas.commons.shell; 

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.commons.WebAddress;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show current {@link WebAddress}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="app", name="webaddress", description="Show current WebAddress.")
public class AppWebAddressCommand extends OsgiCommandSupport {
	
	private final WebAddress webAddress;

	@Inject
	public AppWebAddressCommand(WebAddress webAddress) {
		super();
		this.webAddress = webAddress;
	}

	@Override
	protected Object doExecute() throws Exception {
		return webAddress;
	}

}