/**
 */
package com.soluvas.story;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.soluvas.story.StoryFactory
 * @model kind="package"
 * @generated
 */
public interface StoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "story";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.com/schema/story/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "story";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoryPackage eINSTANCE = com.soluvas.story.impl.StoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.soluvas.story.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.impl.ActionImpl
	 * @see com.soluvas.story.impl.StoryPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 0;

	/**
	 * The meta object id for the '{@link com.soluvas.story.impl.AggregationImpl <em>Aggregation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.impl.AggregationImpl
	 * @see com.soluvas.story.impl.StoryPackageImpl#getAggregation()
	 * @generated
	 */
	int AGGREGATION = 1;

	/**
	 * The meta object id for the '{@link com.soluvas.story.impl.StoryImpl <em>Story</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.impl.StoryImpl
	 * @see com.soluvas.story.impl.StoryPackageImpl#getStory()
	 * @generated
	 */
	int STORY = 2;

	/**
	 * The meta object id for the '{@link com.soluvas.story.impl.StoryManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.impl.StoryManagerImpl
	 * @see com.soluvas.story.impl.StoryPackageImpl#getStoryManager()
	 * @generated
	 */
	int STORY_MANAGER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TENSES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PAST_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PLURAL_PAST_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PRESENT_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PLURAL_PRESENT_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__IMPERATIVE_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_TYPE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aggregation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__AGGREGATION_TYPE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aggregation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ID = CommonsPackage.IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__CREATION_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__MODIFICATION_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__SCHEMA_VERSION = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__STATUS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ACTION = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__OWNER = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Subjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__SUBJECTS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Receivers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__RECEIVERS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ATTACHMENTS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__SUBJECT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__RECEIVER = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ATTACHMENT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Story</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_FEATURE_COUNT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_MANAGER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.soluvas.story.Messageable <em>Messageable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.Messageable
	 * @see com.soluvas.story.impl.StoryPackageImpl#getMessageable()
	 * @generated
	 */
	int MESSAGEABLE = 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGEABLE__MESSAGE = 0;

	/**
	 * The number of structural features of the '<em>Messageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGEABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.soluvas.story.StoryStatus <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.StoryStatus
	 * @see com.soluvas.story.impl.StoryPackageImpl#getStoryStatus()
	 * @generated
	 */
	int STORY_STATUS = 5;


	/**
	 * The meta object id for the '<em>Action Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.ActionType
	 * @see com.soluvas.story.impl.StoryPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 6;

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see com.soluvas.story.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Action#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action Type</em>'.
	 * @see com.soluvas.story.Action#getActionType()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ActionType();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation</em>'.
	 * @see com.soluvas.story.Aggregation
	 * @generated
	 */
	EClass getAggregation();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Aggregation#getAggregationType <em>Aggregation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Aggregation Type</em>'.
	 * @see com.soluvas.story.Aggregation#getAggregationType()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_AggregationType();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.Story <em>Story</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Story</em>'.
	 * @see com.soluvas.story.Story
	 * @generated
	 */
	EClass getStory();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.Story#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.soluvas.story.Story#getStatus()
	 * @see #getStory()
	 * @generated
	 */
	EAttribute getStory_Status();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Story#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see com.soluvas.story.Story#getAction()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Action();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Story#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see com.soluvas.story.Story#getOwner()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.Story#getSchemaVersion <em>Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Version</em>'.
	 * @see com.soluvas.story.Story#getSchemaVersion()
	 * @see #getStory()
	 * @generated
	 */
	EAttribute getStory_SchemaVersion();

	/**
	 * Returns the meta object for the reference list '{@link com.soluvas.story.Story#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subjects</em>'.
	 * @see com.soluvas.story.Story#getSubjects()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Subjects();

	/**
	 * Returns the meta object for the reference list '{@link com.soluvas.story.Story#getReceivers <em>Receivers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receivers</em>'.
	 * @see com.soluvas.story.Story#getReceivers()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Receivers();

	/**
	 * Returns the meta object for the reference list '{@link com.soluvas.story.Story#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attachments</em>'.
	 * @see com.soluvas.story.Story#getAttachments()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Attachments();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Story#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subject</em>'.
	 * @see com.soluvas.story.Story#getSubject()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Subject();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Story#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see com.soluvas.story.Story#getReceiver()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Receiver();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.Story#getAttachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attachment</em>'.
	 * @see com.soluvas.story.Story#getAttachment()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Attachment();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.StoryManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see com.soluvas.story.StoryManager
	 * @generated
	 */
	EClass getStoryManager();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.Messageable <em>Messageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Messageable</em>'.
	 * @see com.soluvas.story.Messageable
	 * @generated
	 */
	EClass getMessageable();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.Messageable#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.soluvas.story.Messageable#getMessage()
	 * @see #getMessageable()
	 * @generated
	 */
	EAttribute getMessageable_Message();

	/**
	 * Returns the meta object for enum '{@link com.soluvas.story.StoryStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see com.soluvas.story.StoryStatus
	 * @generated
	 */
	EEnum getStoryStatus();

	/**
	 * Returns the meta object for data type '{@link com.soluvas.story.schema.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Action Type</em>'.
	 * @see com.soluvas.story.schema.ActionType
	 * @model instanceClass="com.soluvas.story.schema.ActionType"
	 * @generated
	 */
	EDataType getActionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoryFactory getStoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.soluvas.story.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.impl.ActionImpl
		 * @see com.soluvas.story.impl.StoryPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Action Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ACTION_TYPE = eINSTANCE.getAction_ActionType();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.impl.AggregationImpl <em>Aggregation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.impl.AggregationImpl
		 * @see com.soluvas.story.impl.StoryPackageImpl#getAggregation()
		 * @generated
		 */
		EClass AGGREGATION = eINSTANCE.getAggregation();

		/**
		 * The meta object literal for the '<em><b>Aggregation Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__AGGREGATION_TYPE = eINSTANCE.getAggregation_AggregationType();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.impl.StoryImpl <em>Story</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.impl.StoryImpl
		 * @see com.soluvas.story.impl.StoryPackageImpl#getStory()
		 * @generated
		 */
		EClass STORY = eINSTANCE.getStory();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY__STATUS = eINSTANCE.getStory_Status();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__ACTION = eINSTANCE.getStory_Action();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__OWNER = eINSTANCE.getStory_Owner();

		/**
		 * The meta object literal for the '<em><b>Schema Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY__SCHEMA_VERSION = eINSTANCE.getStory_SchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Subjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__SUBJECTS = eINSTANCE.getStory_Subjects();

		/**
		 * The meta object literal for the '<em><b>Receivers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__RECEIVERS = eINSTANCE.getStory_Receivers();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__ATTACHMENTS = eINSTANCE.getStory_Attachments();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__SUBJECT = eINSTANCE.getStory_Subject();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__RECEIVER = eINSTANCE.getStory_Receiver();

		/**
		 * The meta object literal for the '<em><b>Attachment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__ATTACHMENT = eINSTANCE.getStory_Attachment();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.impl.StoryManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.impl.StoryManagerImpl
		 * @see com.soluvas.story.impl.StoryPackageImpl#getStoryManager()
		 * @generated
		 */
		EClass STORY_MANAGER = eINSTANCE.getStoryManager();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.Messageable <em>Messageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.Messageable
		 * @see com.soluvas.story.impl.StoryPackageImpl#getMessageable()
		 * @generated
		 */
		EClass MESSAGEABLE = eINSTANCE.getMessageable();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGEABLE__MESSAGE = eINSTANCE.getMessageable_Message();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.StoryStatus <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.StoryStatus
		 * @see com.soluvas.story.impl.StoryPackageImpl#getStoryStatus()
		 * @generated
		 */
		EEnum STORY_STATUS = eINSTANCE.getStoryStatus();

		/**
		 * The meta object literal for the '<em>Action Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.ActionType
		 * @see com.soluvas.story.impl.StoryPackageImpl#getActionType()
		 * @generated
		 */
		EDataType ACTION_TYPE = eINSTANCE.getActionType();

	}

} //StoryPackage
