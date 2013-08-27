 package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
	
//	private final AppManifest appManifest;
//
//	@Inject
//	public AppManifestCommand(AppManifest appManifest) {
//		super();
//		this.appManifest = appManifest;
//	}

	@Override
	protected Object doExecute() throws Exception {
		// Unfortunately a proxied dependency yields unhelpful output when inspected by GoGo,
		// so we get the bean on-demand
		final AppManifest appManifest = EcoreUtil.copy(getBean(AppManifest.class));
		return appManifest;
	}

}