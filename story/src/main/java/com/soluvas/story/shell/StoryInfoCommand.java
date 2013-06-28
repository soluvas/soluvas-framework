 package com.soluvas.story.shell; 


import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Preconditions;
import com.soluvas.story.StoryRepository;

/**
 * Shell command to show information about the current {@link StoryRepository}.
 *
 * Bippo Commerce Story (should be polymorphic).
 *
 * @author ceefour
 */
@Command(scope="story", name="info", description="Show information about the current Story repository.")
public class StoryInfoCommand extends TenantCommandSupport {

	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final String realNamespace = "story-" + namespace;
		final ServiceReference<StoryRepository> repoRef = Preconditions.checkNotNull(
				TenantUtils.getService(bundleContext, tenant, StoryRepository.class, realNamespace, null),
				"Cannot find %s %s service reference", realNamespace, StoryRepository.class.getName());
		final StoryRepository storyRepo = getService(StoryRepository.class, repoRef);
		return storyRepo;
	}

}