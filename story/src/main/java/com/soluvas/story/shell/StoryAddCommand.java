package com.soluvas.story.shell; 

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.PersonRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.social.Target;
import org.soluvas.social.TargetFinder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.soluvas.story.Action;
import com.soluvas.story.Messageable;
import com.soluvas.story.PersonStory;
import com.soluvas.story.Story;
import com.soluvas.story.StoryFactory;
import com.soluvas.story.StoryRepository;
import com.soluvas.story.StoryStatus;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.schema.TargetTypeRef;

/**
 * Add {@link Story} entity.
 * 
 * <p>Examples owned by person:
 * 
 * <pre>
 * story:add hendy hendy follow nana
 * story:add hendy hendy like product:batiktanpanama_top_batik
 * story:add hendy hendy like shop:zibalabel
 * story:add hendy shop:zibalabel shop:follow hendy
 * story:add hendy shop:zibalabel shop:show product:batiktanpanama_top_batik
 * </pre>
 *
 * <p>Examples owned by product:
 * 
 * <pre>
 * story:add -n product batiktanpanama_top_batik hendy follow nana
 * story:add -n product batiktanpanama_top_batik hendy like product:batiktanpanama_top_batik
 * story:add -n product batiktanpanama_top_batik hendy like shop:zibalabel
 * story:add -n product -m 'Wah lucu' batiktanpanama_top_batik hendy comment product:batiktanpanama_top_batik
 * story:add -n product batiktanpanama_top_batik shop:zibalabel shop:follow hendy
 * story:add -n product batiktanpanama_top_batik shop:zibalabel shop:show product:batiktanpanama_top_batik
 * </pre>
 *
 * <pre>
 * story:add -n product tascantik hendy follow nana
 * story:add -n product tascantik hendy like product:tascantik
 * story:add -n product tascantik hendy like shop:zibalabel
 * story:add -n product -m 'Wah lucu' tascantik hendy comment product:tascantik
 * story:add -n product tascantik shop:zibalabel shop:follow hendy
 * story:add -n product tascantik shop:zibalabel shop:show product:tascantik
 * </pre>
 *
 * @author ceefour
 */
@Service @Lazy
@Command(scope="story", name="add", description="Add Story entity.")
public class StoryAddCommand extends ExtCommandSupport {

	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. person, shop, product.")
	private transient String namespace = "person";
	
//	@Option(name="-s", aliases="--subject",
//			description="Subject namespace, e.g. person, shop, product.")
//	private transient String subjectNamespace = "person";
//	@Option(name="-r", aliases="--receiver",
//			description="Receiver namespace, e.g. person, shop, product.")
//	private transient String receiverNamespace = "person";
//	@Option(name="-i", aliases="--indirect",
//			description="Indirect namespace, e.g. person, shop, product.")
//	private transient String indirectNamespace = "person";
	@Option(name="-m", aliases="--message",
			description="Message for Messageable actions.")
	private transient String message = "Hello, World!";
	
	@Argument(index=0, name="owner", required=true, description="Owner ID (if String) or a PersonInfo object.")
	private Object ownerArg;
	@Argument(index=1, name="subjectId", required=true, description="Subject ID or QName, will be searched using TargetFinder service in the specified namespace.")
	private String subjectId;
	@Argument(index=2, name="action", required=true, description="Action name (see storys:actionls).")
	private String actionName;
	@Argument(index=3, name="receiverId", required=true, description="Receiver ID, will be searched using TargetFinder service in the specified namespace.")
	private String receiverId;
	@Argument(index=4, name="attachmentId", description="Attachment ID, will be searched using TargetFinder service in the specified namespace.")
	private String attachmentId;
	private final StorySchemaCatalog storySchemaCatalog;
	// TODO: dynamic TargetFinder lookup
	private final TargetFinder<Target> subjectFinder;
	private final TargetFinder<Target> receiverFinder;
	private final TargetFinder<Target> attachmentFinder;
	private final StoryRepository storyRepo;
	
	@Inject
	public StoryAddCommand(StorySchemaCatalog storySchemaCatalog,
			@PersonRelated TargetFinder<Target> subjectFinder,
			@PersonRelated TargetFinder<Target> receiverFinder,
			@PersonRelated TargetFinder<Target> attachmentFinder,
			@PersonStory StoryRepository personStoryRepo) {
		super();
		this.storySchemaCatalog = storySchemaCatalog;
		this.subjectFinder = subjectFinder;
		this.receiverFinder = receiverFinder;
		this.attachmentFinder = attachmentFinder;
		this.storyRepo = personStoryRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Object doExecute() throws Exception {
		final Identifiable owner = ownerArg instanceof String
				? CommonsFactory.eINSTANCE.createPersonInfo((String) ownerArg, (String) ownerArg, (String) ownerArg, null, null)
				: (Identifiable) ownerArg;
				
		// Find ActionType
//		final ServiceReference<StorySchemaCatalog> storySchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(StorySchemaCatalog.class),
//				"Cannot get %s service reference", StorySchemaCatalog.class.getName());
//		final StorySchemaCatalog storySchemaCatalog = Preconditions.checkNotNull(getService(StorySchemaCatalog.class, storySchemaCatalogRef),
//				"Cannot get %s service", StorySchemaCatalog.class.getName());
		final String realActionName = actionName.contains(":") ? actionName : "builtin:" + actionName;
		final Map<String, ActionType> actionTypeMap = Maps.uniqueIndex(storySchemaCatalog.getActionTypes(), new Function<ActionType, String>() {
			@Override @Nullable
			public String apply(@Nullable ActionType input) {
				return input.getNsPrefix() + ":" + input.getName();
			}
		});
		final ActionType actionType = Preconditions.checkNotNull(actionTypeMap.get(realActionName),
				"Cannot find action %s, %s supported actions are: %s",
				realActionName, actionTypeMap.size(), actionTypeMap.keySet());
		final String actionTypeQName = actionType.getEPackageNsPrefix() + ":" + actionType.getName();
		// Create Action
		final Action action = actionType.create();
		if (message != null && action instanceof Messageable) {
			((Messageable) action).setMessage(message);
		}
		
		final Pattern namespacePattern = Pattern.compile("(.+):(.+)");
		
		// Find Subject
		final Matcher subjectMatcher = namespacePattern.matcher(subjectId);
		final String subjectNamespace = subjectMatcher.matches() ? subjectMatcher.group(1) : "person";
		final String realSubjectId = subjectMatcher.matches() ? subjectMatcher.group(2) : subjectId;
//		final ServiceReference<TargetFinder<Target>> subjectFinderRef = (ServiceReference) Preconditions.checkNotNull(
//				TenantUtils.getService(bundleContext, tenant, TargetFinder.class, subjectNamespace, null),
//				"Cannot find %s %s service reference", subjectNamespace, TargetFinder.class.getName());
//		final TargetFinder<Target> subjectFinder = getService(TargetFinder.class, subjectFinderRef);
		final Target subject = subjectFinder.findOne(realSubjectId);
				
		// Find Receiver
		final Matcher receiverMatcher = namespacePattern.matcher(receiverId);
		final String receiverNamespace = receiverMatcher.matches() ? receiverMatcher.group(1) : "person";
		final String realReceiverId = receiverMatcher.matches() ? receiverMatcher.group(2) : receiverId;
//		final ServiceReference<TargetFinder<Target>> receiverFinderRef = (ServiceReference) Preconditions.checkNotNull(
//				TenantUtils.getService(bundleContext, tenant, TargetFinder.class, receiverNamespace, null),
//				"Cannot find %s %s service reference", receiverNamespace, TargetFinder.class.getName());
//		final TargetFinder<Target> receiverFinder = getService(TargetFinder.class, receiverFinderRef);
		final Target receiver = receiverFinder.findOne(realReceiverId);

		// Find Attachment
		final Target attachment;
		if (attachmentId != null) {
			final Matcher attachmentMatcher = namespacePattern.matcher(attachmentId);
			final String attachmentNamespace = attachmentMatcher.matches() ? attachmentMatcher.group(1) : "person";
			final String realIndirectId = attachmentMatcher.matches() ? attachmentMatcher.group(2) : attachmentId;
//			final ServiceReference<TargetFinder<Target>> attachmentFinderRef = (ServiceReference) Preconditions.checkNotNull(
//					TenantUtils.getService(bundleContext, tenant, TargetFinder.class, attachmentNamespace, null),
//					"Cannot find %s %s service reference", attachmentNamespace, TargetFinder.class.getName());
//			final TargetFinder<Target> attachmentFinder = getService(TargetFinder.class, attachmentFinderRef);
			attachment = attachmentFinder.findOne(realIndirectId);
		} else {
			attachment = null;
		}
		
		// Sanity check (action must support subject)
		final Set<String> supportedSubjectTypes = ImmutableSet.copyOf( Lists.transform(actionType.getSubjectTypes(), new Function<TargetTypeRef, String>() {
			@Override @Nullable
			public String apply(@Nullable TargetTypeRef targetType) {
				return Optional.fromNullable(targetType.getNsPrefix()).or("builtin") + ":" + targetType.getName();
			}
		}) );
		final String subjectType = subject.getTargetType().getNsPrefix() + ":" + subject.getTargetType().getName();
		Preconditions.checkArgument(supportedSubjectTypes.contains(subjectType),
				"Unsupported subject type %s for %s, %s supported types are: %s",
				subjectType, actionTypeQName, supportedSubjectTypes.size(), supportedSubjectTypes);

		final String realNamespace = "story-" + namespace;
//		final ServiceReference<StoryRepository> repoRef = Preconditions.checkNotNull(
//				TenantUtils.getService(bundleContext, tenant, StoryRepository.class, realNamespace, null),
//				"Cannot find %s %s service reference", realNamespace, StoryRepository.class.getName());
//		final StoryRepository storyRepo = getService(StoryRepository.class, repoRef);

		final Story story = StoryFactory.eINSTANCE.createStory();
		story.setId(UUID.randomUUID().toString());
		story.setStatus(StoryStatus.ACTIVE);
		story.setOwner(owner);
		story.setSubject(subject);
		story.setAction(action);
		story.setReceiver(receiver);
		story.setAttachment(attachment);
		story.setCreationTime(new DateTime(localeContext.getTimeZone()));
		final Story added = storyRepo.add(story);
		return added;
	}

}