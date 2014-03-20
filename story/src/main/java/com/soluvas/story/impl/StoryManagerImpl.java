package com.soluvas.story.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.PersonInfo;
import org.soluvas.push.CollectionAdd;
import org.soluvas.social.Target;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;
import com.soluvas.story.Action;
import com.soluvas.story.Story;
import com.soluvas.story.StoryFactory;
import com.soluvas.story.StoryManager;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.StoryRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * Note: Do not @Service this! It's configured manually in AppConfig.StoryConfig.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
// Note: Do not @Service this! It's configured manually in AppConfig.StoryConfig.
public class StoryManagerImpl extends EObjectImpl implements StoryManager {
	
	private static final Logger log = LoggerFactory.getLogger(StoryManagerImpl.class);
	private final EventBus eventBus;
	private final Map<String, StoryRepository> repositories;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected StoryManagerImpl() {
		throw new UnsupportedOperationException("Please provide constructor arguments");
	}

	/**
	 * @param personStoryRepo
	 * @param eventBus
	 */
	public StoryManagerImpl(final Map<String, StoryRepository> repositories,
			final EventBus eventBus) {
		super();
		this.repositories = ImmutableMap.copyOf(repositories);
		this.eventBus = eventBus;
		log.info("StoryManager initialized with {} repositories: {}",
				repositories.size(), repositories.keySet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.STORY_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Story publish(PersonInfo owner, Target subject, Action action, Target receiver, String trackingId) {
		return publish("person", owner, subject, action, receiver, trackingId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Story publish(String namespace, Identifiable owner, Target subject, Action action, Target receiver, String trackingId) {
		final StoryRepository storyRepo = Preconditions.checkNotNull(repositories.get(namespace),
				"Story Repository for %s not provided", namespace);
		final Story story = StoryFactory.eINSTANCE.createActiveStory(
				owner, subject, action, receiver);
		storyRepo.add(story);
		final String channelName = namespace + "." + owner.getId() + ".story";
		final CollectionAdd<Story> storyPush = new CollectionAdd<Story>(trackingId, channelName,
				channelName, story);
		log.debug("Push story '{} {} {}' [{}] to {} using tracker {} at {}",
				subject.getTitle(), action.getName(), receiver.getTitle(), story.getId(), channelName,
				trackingId, eventBus);
		eventBus.post(storyPush);
		
		return story;
	}

} //StoryManagerImpl
