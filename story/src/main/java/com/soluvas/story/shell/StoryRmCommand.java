package com.soluvas.story.shell; 

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.fusesource.jansi.Ansi;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.IdFunction;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.soluvas.story.Story;
import com.soluvas.story.StoryRepository;

/**
 * Delete {@link Story}s.
 *
 * @author ceefour
 */
@Command(scope="story", name="rm", description="Delete story(s).")
public class StoryRmCommand extends TenantCommandSupport {

	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";
	@Option(name="-a", aliases="--all",
			description="Delete all stories. WARNING: Dangerous!")
	private boolean deleteAll;
	
	@Argument(name="id ...", multiValued=true,
			description="Story ID(s). Partial ID is accepted, ellipsis (…) is stripped.")
	private String ids[];
	
	@Override
	protected Object doExecute() throws Exception {
		final String realNamespace = "story-" + namespace;
		final ServiceReference<StoryRepository> repoRef = Preconditions.checkNotNull(
				TenantUtils.getService(bundleContext, tenant, StoryRepository.class, realNamespace, null),
				"Cannot find %s %s service reference", realNamespace, StoryRepository.class.getName());
		final StoryRepository storyRepo = getService(StoryRepository.class, repoRef);

		if (deleteAll) {
			Preconditions.checkArgument(ids == null,
					"To delete all, id argument must be empty");
			final Collection<Story> stories = storyRepo.findAll();
			final Collection<String> ids = Collections2.transform(stories, new IdFunction());
			return doDelete(storyRepo, ids);
		} else {
			Preconditions.checkNotNull(ids, "At least one id argument is required");
			return doDelete(storyRepo, ImmutableList.copyOf(ids));
		}
	}

	/**
	 * @param storyRepo
	 * @return
	 */
	private Object doDelete(final StoryRepository storyRepo, final Collection<String> ids) {
		final List<Boolean> deleteds = ImmutableList.copyOf( Collections2.transform(ids, new Function<String, Boolean>() {
			@Override @Nullable
			public Boolean apply(@Nullable String id) {
				final String realId = id.replaceAll("[….]", "");
				final Story story = Preconditions.checkNotNull(storyRepo.findOneByPartialId(realId),
						"Cannot find %s story by partial ID %s", namespace, realId);
				System.out.print(Ansi.ansi().render("Deleting @|bold %s|@ story @|bold %s|@ for @|bold %s|@...",
						namespace, story.getId(), story.getOwner() != null ? story.getOwner().getId() : null));
				boolean deleted = storyRepo.delete(story);
				System.out.println(Ansi.ansi().render(deleted ? " @|bold,yellow DELETED|@" : " @|bold,red ERROR|@"));
				return deleted;
			}
		}) );
		return deleteds;
	}

}