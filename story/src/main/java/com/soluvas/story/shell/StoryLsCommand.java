package com.soluvas.story.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Preconditions;
import com.soluvas.story.Story;
import com.soluvas.story.StoryRepository;

/**
 * Shell command to list entities of {@link Story}.
 *
 * @author ceefour
 */
@Command(scope="story", name="ls", description="List Story entities.")
public class StoryLsCommand extends TenantCommandSupport {

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
		System.out.println(ansi().render("@|negative_on %3s|%-9s|%-15s|%-20s|%-12s|%-20s|%-20s|%14s|@",
				"№", "ID", "Owner", "Subject", "Action", "Receiver", "Attachment", "⌚Created"));
		final Collection<Story> storyList = storyRepo.findAll();
		int i = 0;
		for (final Story story : storyList) {
			final String shortIdAnsi = NameUtils.shortenUuidAnsi(story.getId(), 9);
			final String indirectTitle = story.getAttachment() != null ? story.getAttachment().getTitle() : null;
			final String storyQName = (!"builtin".equals(story.getAction().getNsPrefix()) ? story.getAction().getNsPrefix() + ":" : "") +
					story.getAction().getName();
			System.out.println(ansi().render("@|bold,black %3d||@" + shortIdAnsi + "@|bold,black ||@%-15s@|bold,black ||@%-20s@|bold,black ||@%-12s@|bold,black ||@%-20s@|bold,black ||@%-20s@|bold,black ||@%14s",
				++i, story.getOwner().getId(), story.getSubject().getTitle(), storyQName, story.getReceiver().getTitle(), indirectTitle,
				localeContext.formatShortDateTime(story.getCreationTime()) ));
		}
		System.out.println(ansi().render("@|bold %d|@ stories in @|bold %s|@", i, namespace));
		return null;
	}

}