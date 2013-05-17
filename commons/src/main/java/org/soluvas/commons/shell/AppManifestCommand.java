 package org.soluvas.commons.shell; 

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.AppManifest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show current {@link AppManifest}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="app", name="manifest", description="Show current AppManifest.")
public class AppManifestCommand extends ExtCommandSupport {
	
	private final AppManifest appManifest;

	@Inject
	public AppManifestCommand(AppManifest appManifest) {
		super();
		this.appManifest = appManifest;
	}

	@Override
	protected Object doExecute() throws Exception {
		return appManifest;
	}

}