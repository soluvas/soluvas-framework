package org.soluvas.folder.shell;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.shell.TenantCommandSupport;

@Command(scope="folder", name="dummy", description="Dummy.")
public class DummyCommand extends TenantCommandSupport {
	
	@Override
	protected Object doExecute() throws Exception {
		return null;
	}

}
