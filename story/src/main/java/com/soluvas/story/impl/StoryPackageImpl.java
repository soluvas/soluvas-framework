/**
 */
package com.soluvas.story.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.social.SocialPackage;

import com.soluvas.story.Action;
import com.soluvas.story.Aggregation;
import com.soluvas.story.Messageable;
import com.soluvas.story.Story;
import com.soluvas.story.StoryFactory;
import com.soluvas.story.StoryManager;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.StoryStatus;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.SchemaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryPackageImpl extends EPackageImpl implements StoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum storyStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType actionTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.soluvas.story.StoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StoryPackageImpl() {
		super(eNS_URI, StoryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StoryPackage init() {
		if (isInited) return (StoryPackage)EPackage.Registry.INSTANCE.getEPackage(StoryPackage.eNS_URI);

		// Obtain or create and register package
		StoryPackageImpl theStoryPackage = (StoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StoryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SocialPackage.eINSTANCE.eClass();
		SchemaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStoryPackage.createPackageContents();

		// Initialize created meta-data
		theStoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStoryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StoryPackage.eNS_URI, theStoryPackage);
		return theStoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAction_ActionType() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAggregation() {
		return aggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_AggregationType() {
		return (EReference)aggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStory() {
		return storyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStory_Status() {
		return (EAttribute)storyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Action() {
		return (EReference)storyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Owner() {
		return (EReference)storyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStory_SchemaVersion() {
		return (EAttribute)storyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Subjects() {
		return (EReference)storyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Receivers() {
		return (EReference)storyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Attachments() {
		return (EReference)storyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Subject() {
		return (EReference)storyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Receiver() {
		return (EReference)storyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStory_Attachment() {
		return (EReference)storyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStoryManager() {
		return storyManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessageable() {
		return messageableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMessageable_Message() {
		return (EAttribute)messageableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getStoryStatus() {
		return storyStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getActionType() {
		return actionTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StoryFactory getStoryFactory() {
		return (StoryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__ACTION_TYPE);

		aggregationEClass = createEClass(AGGREGATION);
		createEReference(aggregationEClass, AGGREGATION__AGGREGATION_TYPE);

		storyEClass = createEClass(STORY);
		createEAttribute(storyEClass, STORY__SCHEMA_VERSION);
		createEAttribute(storyEClass, STORY__STATUS);
		createEReference(storyEClass, STORY__ACTION);
		createEReference(storyEClass, STORY__OWNER);
		createEReference(storyEClass, STORY__SUBJECTS);
		createEReference(storyEClass, STORY__RECEIVERS);
		createEReference(storyEClass, STORY__ATTACHMENTS);
		createEReference(storyEClass, STORY__SUBJECT);
		createEReference(storyEClass, STORY__RECEIVER);
		createEReference(storyEClass, STORY__ATTACHMENT);

		storyManagerEClass = createEClass(STORY_MANAGER);

		messageableEClass = createEClass(MESSAGEABLE);
		createEAttribute(messageableEClass, MESSAGEABLE__MESSAGE);

		// Create enums
		storyStatusEEnum = createEEnum(STORY_STATUS);

		// Create data types
		actionTypeEDataType = createEDataType(ACTION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
		SchemaPackage theSchemaPackage = (SchemaPackage)EPackage.Registry.INSTANCE.getEPackage(SchemaPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		SocialPackage theSocialPackage = (SocialPackage)EPackage.Registry.INSTANCE.getEPackage(SocialPackage.eNS_URI);
		org.soluvas.social.schema.SchemaPackage theSchemaPackage_1 = (org.soluvas.social.schema.SchemaPackage)EPackage.Registry.INSTANCE.getEPackage(org.soluvas.social.schema.SchemaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actionEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		actionEClass.getESuperTypes().add(theSchemaPackage.getActionLike());
		actionEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		aggregationEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		aggregationEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		storyEClass.getESuperTypes().add(theCommonsPackage.getIdentifiable());
		storyEClass.getESuperTypes().add(theCommonsPackage.getTimestamped());
		storyEClass.getESuperTypes().add(theCommonsPackage.getSchemaVersionable());

		// Initialize classes and features; add operations and parameters
		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_ActionType(), theSchemaPackage.getActionType(), null, "actionType", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregationEClass, Aggregation.class, "Aggregation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregation_AggregationType(), theSchemaPackage.getAggregationType(), null, "aggregationType", null, 0, 1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storyEClass, Story.class, "Story", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStory_SchemaVersion(), theEcorePackage.getELong(), "schemaVersion", "3", 1, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStory_Status(), this.getStoryStatus(), "status", null, 0, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Action(), this.getAction(), null, "action", null, 1, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Owner(), theCommonsPackage.getIdentifiable(), null, "owner", null, 0, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Subjects(), theSocialPackage.getTarget(), null, "subjects", null, 1, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Receivers(), theSocialPackage.getTarget(), null, "receivers", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Attachments(), theSocialPackage.getTarget(), null, "attachments", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Subject(), theSocialPackage.getTarget(), null, "subject", null, 1, 1, Story.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Receiver(), theSocialPackage.getTarget(), null, "receiver", null, 0, 1, Story.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Attachment(), theSocialPackage.getTarget(), null, "attachment", null, 0, 1, Story.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(storyManagerEClass, StoryManager.class, "StoryManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(storyManagerEClass, theSchemaPackage.getStory(), "publish", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getPersonInfo(), "owner", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSchemaPackage_1.getTarget(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAction(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSchemaPackage_1.getTarget(), "receiver", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "trackingId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(storyManagerEClass, theSchemaPackage.getStory(), "publish", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getIdentifiable(), "owner", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSchemaPackage_1.getTarget(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAction(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSchemaPackage_1.getTarget(), "receiver", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "trackingId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(messageableEClass, Messageable.class, "Messageable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageable_Message(), theEcorePackage.getEString(), "message", null, 0, 1, Messageable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(storyStatusEEnum, StoryStatus.class, "StoryStatus");
		addEEnumLiteral(storyStatusEEnum, StoryStatus.DRAFT);
		addEEnumLiteral(storyStatusEEnum, StoryStatus.ACTIVE);
		addEEnumLiteral(storyStatusEEnum, StoryStatus.INACTIVE);

		// Initialize data types
		initEDataType(actionTypeEDataType, ActionType.class, "ActionType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (actionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Actions\n\nActions are the high-level \"interactions\" users can perform in your app.\nTypes\nBuilt-in\n\nFacebook has defined a set of actions that can be used without any further customization on your part.\n\n    Follow\n    Like\n    Listen\n    Read\n    Watch\n\nCustom Actions\n\nYou have the ability to create your own actions and define all properties of those actions. This gives you the ultimate flexibility when modeling Open Graph actions that seamlessly replicate what your user\'s are doing on your site.\nPrivacy Model\n\nUser Choice\n\nActions follow the privacy model of the user. User\'s can decide to share the actions they\'ve taken on your app with \"Everyone\", \"Friends\", or keep them private to themselves. When configuring your action, as the developer, you have the ability to set a default privacy level, however, the user can choose to override that default privacy level with any privacy level that\'s more restricted. The user can NOT choose a privacy level that\'s more open, which might be important if you are building an app where you need to ensure a minimum level of privacy.\nExamples\n\nYou may have seen Open Graph actions on your Timeline. Here are examples of the Open Graph actions (\"pin\") generated by Pinterest. The first example is how a Pinterest action is displayed in another person\'s News Feed:\n\nThe second example is how a Pinterest action is aggregated in a person\'s Timeline:\n\nReference: https://developers.facebook.com/docs/concepts/opengraph/actions/"
		   });		
		addAnnotation
		  (aggregationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Aggregations are summary stories on Timeline that are defined by your application to showcase the Open Graph activities of a user in a structured and interesting way. You can customize your application\'s Aggregations and preview their look and feel with sample data in the App Dashboard.\nAggregation Models\n\n    Gallery\n    Item\n    List\n    Map\n    Number\n    Table\n\nPrivacy Model\n\nAggregations are displayed on your Timeline, so those users who are allowed access to your Timeline will be able to see your aggregations. Each aggregation contains information based actions you\'ve taken from the associated app. Because a user can decide to hide certain stories or change the privacy for a single story, the information in an aggregation may be different from viewer to viewer.\nExamples\n\nYou may have seen Open Graph aggregations on your Timeline. Here is an example of an Open Graph aggregation for questions you may have followed using Quora:\n\nReference: https://developers.facebook.com/docs/concepts/opengraph/aggregations/"
		   });		
		addAnnotation
		  (storyStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Active story."
		   });		
		addAnnotation
		  (storyStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Deleted story, e.g. comment has been deleted."
		   });		
		addAnnotation
		  (getStory_Action(), 
		   source, 
		   new String[] {
			 "documentation", "A predicate is the completer of a sentence. The subject names the \"do-er\" or \"be-er\" of the sentence; the predicate does the rest of the work. A simple predicate consists of only a verb, verb string, or compound verb:\n\n    The glacier melted.\n    The glacier has been melting.\n    The glacier melted, broke apart, and slipped into the sea.\n\nA compound predicate consists of two (or more) such predicates connected:\n\n    The glacier began to slip down the mountainside and eventually crushed some of the village\'s outlying buildings.\n\nA complete predicate consists of the verb and all accompanying modifiers and other words that receive the action of a transitive verb or complete its meaning. The following description of predicates comes from The Longman Handbook for Writers and Readers (examples our own):\n\n    With an intransitive verb, objects and complements are included in the predicate. (The glacier is melting.) With a transitive verb, objects and object complements are said to be part of the predicate. (The slow moving glacier wiped out an entire forest. It gave the villagers a lot of problems.) With a linking verb, the subject is connected to a subject complement. (The mayor doesn\'t feel good.) \n\nA predicate adjective follows a linking verb and tells us something about the subject:\n\n    Ramonita is beautiful.\n    His behavior has been outrageous.\n    That garbage on the street smells bad.\n\nA predicate nominative follows a linking verb and tells us what the subject is:\n\n    Dr. Couchworthy is acting president of the university.\n    She used to be the tallest girl on the team.\n\nReference: http://grammar.ccc.commnet.edu/grammar/objects.htm"
		   });		
		addAnnotation
		  (getStory_Subject(), 
		   source, 
		   new String[] {
			 "documentation", "Get the primary subject."
		   });		
		addAnnotation
		  (getStory_Receiver(), 
		   source, 
		   new String[] {
			 "documentation", "Get the primary receiver."
		   });		
		addAnnotation
		  (getStory_Attachment(), 
		   source, 
		   new String[] {
			 "documentation", "Get the primary attachment."
		   });		
		addAnnotation
		  (storyManagerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Actions are the high-level \"interactions\" users can perform in your app. Before publishing an Action instance to Open Graph, define its Action Type and its connected Object Type through the App Dashboard.\n\n    Publishing Actions\n    Retrieving Actions\n    Updating an Action\n    Deleting an Action\n    Commenting on an Action\n    Liking an Action\n    Configure Action Timestamps\n\nPublishing Actions\n\nActions are defined through the App Dashboard. Once an application has defined the types of actions that it publishes, the application can invoke the Graph API to publish action instances to Open Graph -- this connects the current user with an appropriate object instance via the action.\n\nPOST /me/{namespace}:{action-type-name}\n\nwith the request body\n\n{object-type-name}={object-instance-url}\n\nThe following call sees the recipebox app establishing a Cook action instance connection between the current user and a Pumpkin Pie (an instance of the Recipe object type):\n\ncurl -X POST \\\n     -F \'access_token=USER_ACCESS_TOKEN\' \\\n     -F \'recipe=http://www.example.com/pumpkinpie.html\' \\\n     https://graph.facebook.com/me/recipebox:cook\n\nHere is another example using the Javascript SDK:\n\nFB.api(\'/me/recipebox:cook\', \'post\', \n  { recipe : \'http://www.example.com/pumpkinpie.html\' });\n\nNote - Apps can also use an App Access Token to publish actions for authenticated users.\n\nOnce an action is published, friends may see a News Feed and Ticker story:\n\nIn News Feed\n\nIn Ticker\n\nPreviewing Stories from Published Actions\n\nYou can preview News Feed stories created when publishing actions by going to https://www.facebook.com/USER_ID/activity/STORY_ID, where USER_ID is the user\'s Facebook ID or username, and STORY_ID is the action-instance-id as described below. For example:\n\nhttps://www.facebook.com/dhirenp/activity/10100657260775943\n\nThe user must have appropriate permissions in order to view the preview.\n\nRequired Parameters\nName \tValue \tType\nType Name of Connected Object \tThe object URL or object ID of an appropriate object instance.\n\nIf the object represented by the URL is not in the graph, it will be scraped. \tstring\nOptional Parameters Requiring Review\n\nYou must request these optional properties during the Open Graph submission flow.\nName \tValue \tType\nmessage \tAllows users to write a personalized message attached to this action. You can only use user message when the text is entered by the user (not pre-populated). You can mention users and pages inline with the message (see mention tagging).\tstring\nfb:explicitly_shared \tValue specifying that the published action is explicitly shared by the user.\tboolean\nplace \tID referencing a place where the action occurred. For example: \"Simon ate Pizza at Facebook HQ\"\tid\nuser_generated (image) \tAllows user generated, large photos to be displayed in stories - see docs\tboolean\ntags \tAllows an app user to tag other users in a story. For example: Carl visited Dolores Park. - with Mike and Austin.\ta string of comma separated ids\n\nOptional Parameters\nName \tValue \tType\nstart_time \tThe time this action started.\tISO-8601 date-time\nend_time \tThe time this action ended.\tISO-8601 date-time\nexpires_in \tThe number of seconds before this action is considered \u201cold\u201d. From the time the action until expires_in seconds have elapsed, the action is considered \u201cpresent tense\u201d, and afterwards, it is considered \u201cpast tense\u201d.\n\nexpires_in is a shortcut for specifying end_time when it\u2019s more convenient to provide a delta in seconds between when an action started and when it ends. For example, when a user starts watching a movie, when you post a watch action, expires_in should be the length of the movie in seconds.\tinteger\nnotify \tIf set to false we will suppress notifications resulting from the published action. Currently this is only applicable to likes published on actions and Open Graph likes.\tbool\nprivacy \tA JSON-encoded object that defines the privacy setting for the action. Its fields are described here. \tobject\nimage\tAbility to add an image to the story and override the image that is associated with the object properties. If you would like to include a user generated image, that will be saved in the user\'s albums, please see the docs on User Generated Photos\tURL\nref \tWhen users click through to your site from an Open Graph action displayed in Facebook, this value will be passed in the fb_ref query parameter which Facebook will add to external links to your objects. This is useful for A/B tests and tracking other data associated with the action.\n\nBy default, the ref parameter will accept 500 unique values for ref in a 7 day period. These values will be used to display graphs grouped by each unique value of ref in your application\'s insights.\n\nIf you need more values 500 per 7 days, for example if you are passing globally unique IDs via the ref parameter, you may use the \"__\" separator. Text to the left of the separator will be used as indexes in Insights and used to help you analyze A/B test results. Text to the right of the separator will be ignored for insights purposes, will not form part of the 500 by 7 quota, but will still be passed in the fb_ref parameter the user follows a link to from the Open Graph action.\tstring\nscrape \tIf set to true we will scrape your object and update its properties prior to creating the action. Scraping will slow down the request and has the potential to hit rate limits so only scrape when the object has been updated.\tbool\nResponse\n\n{\n  id: \u201c{action-instance-id}\u201d\n}\n\nIf extra properties are sent in a request but not defined on an Action type, an error is thrown.\n\nSetting custom action instance properties\n\nCustom action properties must be set when an action instance is published. They are assigned by passing URL parameters in the form:\n\n{custom-property-name}={value}\n\nThe following shows how to set a custom property, rating, on the recipebox:cook action:\n\nhttps://graph.facebook.com/me/recipebox:cook?\n  book=http://www.example.com/pumpkinpie.html&rating=10\n\nExplicit Sharing\n\nExplicitly shared actions let apps notify us when a user wants to share something prominently, like they would on Facebook. For example, when people choose to share a run they took with a fitness app, they expect the content to appear as if they had posted it directly to Facebook. You mark Open Graph actions as explicitly shared by adding the fb:explicitly_shared parameter when publishing actions:\n\ncurl -X POST https://graph.dev.facebook.com/me/nyccookbook:cook \\\n     -F \"access_token=<valid access_token>\"  \\\n     -F \"recipe=http://www.sugarmedia.com/nyccookbook/cookie.html\" \\\n     -F \"fb:explicitly_shared=true\"\n\nSee the guide on Explicit Sharing for the full details.\nRetrieving an Action\n\nApps can retrieve actions published for the authorized user. For example, a Recipe app can retrieve all the recipes I\'ve cooked or plan on cooking and customize the app experience based the data.\n\nThis API returns the action\u2019s metadata including timestamps along with custom properties and their values. Objects referenced from an action are returned a single level deep.\n\nGET /{action-instance-id}\n\nThe following retrieves a specific action instance\n\nhttps://graph.facebook.com/1538292028372\n      ?access_token=USER_ACCESS_TOKEN\n\nResponse\n\n{\n    \"id\": \"1538292028372\"\n    \"start_time\": 1303502229, \n    \"end_time\": 1303513029, \n    \"data\": {\n        \"type\": \"recipebox:recipe\", \n        \"url\": \"http://www.example.com/pumpkinpie.html\", \n        \"id\": \"1234567890\", \n        \"title\": \"Pumpkin Pie\"\n    }, \n}\n\nUpdating an Action\n\nApps can update properties of an action instance by:\n\nPOST /{action-instance-id}\n\nThe following updates the end_time of an action\n\nhttps://graph.facebook.com/1538292028372?expires_in=300\n      &access_token=YOUR_ACCESS_TOKEN\n\nHere is the same example using the JS SDK:\n\nFB.api(\'/1538292028372\', \'post\', { expires_in : \'300\' });\n\nResponse\n\ntrue\n\nDeleting an Action\n\nApps can also remove actions published for authorized users. You may use this feature if a user retroactively decides to un-publish the activity.\n\nDELETE /{action-instance-id}\n\nThe following deletes action instance 1538292028372\n\nhttps://graph.facebook.com/1538292028372?access_token=YOUR_ACCESS_TOKEN\n\nHere is the same example using the JS SDK:\n\nFB.api(\'/1538292028372\', \'delete\');\n\nResponse\n\ntrue \n\nLiking an Action\n\nCreate a Like connection between the current user and the specified action. This requires the publish_actions permission from the user.\n\nPOST /{action-instance-id}/likes\n\nThe following creates a like between the current user and action instance 1538292028372\n\nhttps://graph.facebook.com/1538292028372/likes\n      ?access_token=YOUR_ACCESS_TOKEN\n\nHere is the same example using the JS SDK:\n\nFB.api(\'/1538292028372/likes\', \'post\');\n\nTo get likes associated with an action instance\n\nGET /{action-instance-id}/likes\n\nLiking an action with an App Access Token\n\nCreate a like connection between the user and the action using an app access token. When using the app access token, pass in the user id of the user \"liking\" the action in the \"user\" parameter.\n\nhttps://graph.facebook.com/1538292028372/likes\n      ?access_token=YOUR_APP_ACCESS_TOKEN\n      &user=499804870\n\nSuppressing notifications\n\nWhen publishing a like from your app, there are scenarios where notifications might be duplicated between your app and Facebook. To suppress the notification from liking an action, pass in the notify parameter with a value of false.\n\nhttps://graph.facebook.com/1538292028372/likes\n      ?access_token=YOUR_ACCESS_TOKEN\n      &notify=false\n\nCommenting on an Action\n\nAdd a comment for the current user and the specified action.\n\nPOST /{action-instance-id}/comments\n\nThe following creates a comment on the action instance 1538292028372\n\nhttps://graph.facebook.com/1538292028372/comments\n      ?message=test+comment&access_token=YOUR_ACCESS_TOKEN\n\nHere is the same example using the JS SDK:\n\nFB.api(\'/1538292028372/comments\', \'post\', { message : \'test comment\' });\n\nGet comments for the current user and the specified action\n\nGET /{action-instance-id}/comments\n\nRetrieve the comments on an Action. Use the request parameters that are described for retrieving Comments on a Post. Described here.\n\nTimestamps\n\nAction\u2019s timestamps can be configured to describe actions that occur at different times and how actions appear on the user\'s profile and News Feed.\n\nSupported configurations for timestamps are:\n\n    Point in time when the API call is made (default. example: voted for a poll)\n    Start in the past / end in the past (example: soccer team I played on last summer)\n    Start in the past / end in the future (example: courses a student takes over a semester\n    Start now / end in the future (example: a relationship status)\n    Start now / end indefinite (example: like or want actions)\n\nIn all cases, an expires_in value provided in seconds can be used to specify the end_time relative to the start_time. It is not acceptable to provide expires_in and end_time for the same action instance. When an app provides expires_in, we calculate end_time as follows:\n\nend_time = start_time + expires_in\n\nTo alter the end_time of an action -- because a trip is running long or because a student drops a college course -- the end_time can be updated.\nTimestamps and collections\n\nTimestamps can be used to model collections by testing the liveness of an action. For example, the set of Courses a student is currently taking can be calculated by looking at the which \u201cenrolled\u201d actions that point to Course objects have a start_date in the past and an end_date in the future.\n\nSimilarly, the college courses I was taking in the March of 1998 can be determined by looking at the Enrolled actions with a start_date before March 1, 1998 and an end_date after March 31, 1998. This supports pinning my \u201cClass Schedule\u201d Aggregation to March 1998.\n\nUsing this method, it is possible to build Aggregations for perpetual actions including \u201clike\u201d and \u201cwant\u201d.\n\nReference: https://developers.facebook.com/docs/technical-guides/opengraph/publish-action/"
		   });		
		addAnnotation
		  (messageableEClass, 
		   source, 
		   new String[] {
			 "documentation", "For actions that contain message."
		   });
	}

} //StoryPackageImpl
