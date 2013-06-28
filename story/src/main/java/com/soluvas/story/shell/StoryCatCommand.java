package com.soluvas.story.shell; 
 
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Preconditions;
import com.soluvas.story.Story;
import com.soluvas.story.StoryRepository;

/**
 * Show an entity of {@link Story}.
 *
 * @author ceefour
 */
@Command(scope="story", name="cat", description="Get Story by (partial) ID.")
public class StoryCatCommand extends TenantCommandSupport {

	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";

	@Argument(index=0, name="id", required=true, description="Story ID or partial ID.")
	private String id;

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Story doExecute() throws Exception {
		final String realNamespace = "story-" + namespace;
		final ServiceReference<StoryRepository> repoRef = Preconditions.checkNotNull(
				TenantUtils.getService(bundleContext, tenant, StoryRepository.class, realNamespace, null),
				"Cannot find %s %s service reference", realNamespace, StoryRepository.class.getName());
		final StoryRepository storyRepo = getService(StoryRepository.class, repoRef);
		final String realId = id.replaceAll("[….]", "");
		return Preconditions.checkNotNull(storyRepo.findOneByPartialId(realId),
				"Cannot find %s story by (partial) ID %s",
				namespace, realId);
	}

}
