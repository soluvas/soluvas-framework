 package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.WebAddress;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show current {@link WebAddress}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="app", name="webaddress", description="Show tenant WebAddress.")
public class AppWebAddressCommand extends ExtCommandSupport {
	
	@Override
	protected WebAddress doExecute() throws Exception {
		final WebAddress webAddress = getBean(WebAddress.class);
		return webAddress;
	}

}