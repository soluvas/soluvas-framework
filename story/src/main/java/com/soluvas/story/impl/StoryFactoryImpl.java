/**
 */
package com.soluvas.story.impl;

import com.soluvas.story.*;
import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.joda.time.DateTime;
import org.soluvas.commons.Identifiable;
import org.soluvas.social.Target;

import com.google.common.collect.ImmutableList;
import com.soluvas.story.Action;
import com.soluvas.story.Story;
import com.soluvas.story.StoryFactory;
import com.soluvas.story.StoryManager;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.StoryStatus;
import com.soluvas.story.schema.ActionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryFactoryImpl extends EFactoryImpl implements StoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoryFactory init() {
		try {
			StoryFactory theStoryFactory = (StoryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.com/schema/story/1.0"); 
			if (theStoryFactory != null) {
				return theStoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StoryPackage.STORY: return createStory();
			case StoryPackage.STORY_MANAGER: return createStoryManager();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StoryPackage.STORY_STATUS:
				return createStoryStatusFromString(eDataType, initialValue);
			case StoryPackage.ACTION_TYPE:
				return createActionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StoryPackage.STORY_STATUS:
				return convertStoryStatusToString(eDataType, instanceValue);
			case StoryPackage.ACTION_TYPE:
				return convertActionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Story createStory() {
		StoryImpl story = new StoryImpl();
		return story;
	}

	@Override
	public <R extends Target> Story createActiveStory(Identifiable owner, Target subject, Action action, Collection<R> receivers) {
		final Story story = createStory();
		story.setStatus(StoryStatus.ACTIVE);
		story.setId(UUID.randomUUID().toString());
		story.setOwner(owner);
		story.setSubject(subject);
		story.setAction(action);
		story.getReceivers().addAll(receivers);
		story.setCreationTime(new DateTime()); // TODO: TimeZone
		story.setModificationTime(new DateTime()); // TODO: TimeZone
		return story;
	}

	@Override
	public Story createActiveStory(Identifiable owner, Target subject, Action action, Target receiver) {
		return createActiveStory(owner, subject, action, ImmutableList.of(receiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StoryManager createStoryManager() {
		StoryManagerImpl storyManager = new StoryManagerImpl();
		return storyManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryStatus createStoryStatusFromString(EDataType eDataType, String initialValue) {
		StoryStatus result = StoryStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStoryStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType createActionTypeFromString(EDataType eDataType, String initialValue) {
		return (ActionType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StoryPackage getStoryPackage() {
		return (StoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StoryPackage getPackage() {
		return StoryPackage.eINSTANCE;
	}

	@Override
	public <R extends Target, A extends Target> Story createActiveStory(Identifiable owner, Target subject,
			Action action, Collection<R> receivers, Collection<A> attachments) {
		final Story story = createActiveStory(owner, subject, action, receivers);
		story.getAttachments().addAll(attachments);
		return story;
	}

	@Override
	public Story createActiveStory(Identifiable owner, Target subject,
			Action action, Target receiver, Target attachment) {
		return createActiveStory(owner, subject, action, receiver, ImmutableList.of(attachment));
	}

	@Override
	public <A extends Target> Story createActiveStory(Identifiable owner, Target subject,
			Action action, Target receiver, Collection<A> attachments) {
		return createActiveStory(owner, subject, action, ImmutableList.of(receiver), attachments);
	}

} //StoryFactoryImpl
