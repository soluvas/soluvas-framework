/**
 */
package com.soluvas.story.schema.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.social.Target;
import org.soluvas.social.schema.TargetType;

import com.soluvas.story.Action;
import com.soluvas.story.Aggregation;
import com.soluvas.story.Story;
import com.soluvas.story.StoryPackage;
import com.soluvas.story.impl.StoryPackageImpl;
import com.soluvas.story.schema.ActionLike;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.ActionTypeStatus;
import com.soluvas.story.schema.AggregationType;
import com.soluvas.story.schema.SchemaFactory;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.schema.StoryType;
import com.soluvas.story.schema.TargetTypeRef;
import com.soluvas.story.schema.Tenses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemaPackageImpl extends EPackageImpl implements SchemaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storySchemaCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tensesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType storyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType actionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType aggregationEDataType = null;

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
	 * @see com.soluvas.story.schema.SchemaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchemaPackageImpl() {
		super(eNS_URI, SchemaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SchemaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchemaPackage init() {
		if (isInited) return (SchemaPackage)EPackage.Registry.INSTANCE.getEPackage(SchemaPackage.eNS_URI);

		// Obtain or create and register package
		SchemaPackageImpl theSchemaPackage = (SchemaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchemaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchemaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		org.soluvas.social.schema.SchemaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSchemaPackage.createPackageContents();

		// Initialize created meta-data
		theSchemaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchemaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchemaPackage.eNS_URI, theSchemaPackage);
		return theSchemaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStoryType() {
		return storyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStorySchemaCatalog() {
		return storySchemaCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStorySchemaCatalog_StoryTypes() {
		return (EReference)storySchemaCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStorySchemaCatalog_ActionTypes() {
		return (EReference)storySchemaCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStorySchemaCatalog_AggregationTypes() {
		return (EReference)storySchemaCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStorySchemaCatalog_GeneratedPackageName() {
		return (EAttribute)storySchemaCatalogEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStorySchemaCatalog_XmiUrl() {
		return (EAttribute)storySchemaCatalogEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStorySchemaCatalog_EcoreUrl() {
		return (EAttribute)storySchemaCatalogEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStorySchemaCatalog_EPackage() {
		return (EReference)storySchemaCatalogEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStorySchemaCatalog_EFactory() {
		return (EReference)storySchemaCatalogEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionType() {
		return actionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionType_ResolvedSubjectTypes() {
		return (EReference)actionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionType_SubjectTypes() {
		return (EReference)actionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionType_Status() {
		return (EAttribute)actionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAggregationType() {
		return aggregationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionLike() {
		return actionLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_Tenses() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_PastTense() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_PluralPastTense() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_PresentTense() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_PluralPresentTense() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionLike_ImperativeTense() {
		return (EAttribute)actionLikeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetTypeRef() {
		return targetTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTenses() {
		return tensesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionTypeStatus() {
		return actionTypeStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getStory() {
		return storyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getAction() {
		return actionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getAggregation() {
		return aggregationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SchemaFactory getSchemaFactory() {
		return (SchemaFactory)getEFactoryInstance();
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
		storyTypeEClass = createEClass(STORY_TYPE);

		storySchemaCatalogEClass = createEClass(STORY_SCHEMA_CATALOG);
		createEReference(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__STORY_TYPES);
		createEReference(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__ACTION_TYPES);
		createEReference(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__AGGREGATION_TYPES);
		createEAttribute(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME);
		createEAttribute(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__XMI_URL);
		createEAttribute(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__ECORE_URL);
		createEReference(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__EPACKAGE);
		createEReference(storySchemaCatalogEClass, STORY_SCHEMA_CATALOG__EFACTORY);

		actionTypeEClass = createEClass(ACTION_TYPE);
		createEReference(actionTypeEClass, ACTION_TYPE__RESOLVED_SUBJECT_TYPES);
		createEAttribute(actionTypeEClass, ACTION_TYPE__STATUS);
		createEReference(actionTypeEClass, ACTION_TYPE__SUBJECT_TYPES);

		aggregationTypeEClass = createEClass(AGGREGATION_TYPE);

		actionLikeEClass = createEClass(ACTION_LIKE);
		createEAttribute(actionLikeEClass, ACTION_LIKE__TENSES);
		createEAttribute(actionLikeEClass, ACTION_LIKE__PAST_TENSE);
		createEAttribute(actionLikeEClass, ACTION_LIKE__PLURAL_PAST_TENSE);
		createEAttribute(actionLikeEClass, ACTION_LIKE__PRESENT_TENSE);
		createEAttribute(actionLikeEClass, ACTION_LIKE__PLURAL_PRESENT_TENSE);
		createEAttribute(actionLikeEClass, ACTION_LIKE__IMPERATIVE_TENSE);

		targetTypeRefEClass = createEClass(TARGET_TYPE_REF);

		// Create enums
		tensesEEnum = createEEnum(TENSES);
		actionTypeStatusEEnum = createEEnum(ACTION_TYPE_STATUS);

		// Create data types
		storyEDataType = createEDataType(STORY);
		actionEDataType = createEDataType(ACTION);
		aggregationEDataType = createEDataType(AGGREGATION);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.soluvas.social.schema.SchemaPackage theSchemaPackage_1 = (org.soluvas.social.schema.SchemaPackage)EPackage.Registry.INSTANCE.getEPackage(org.soluvas.social.schema.SchemaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theCommonsPackage.getResourceAware());
		storyTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNameContainer());
		storyTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		EGenericType g2 = createEGenericType(this.getStory());
		g1.getETypeArguments().add(g2);
		storyTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		storyTypeEClass.getEGenericSuperTypes().add(g1);
		storySchemaCatalogEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		storySchemaCatalogEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		storySchemaCatalogEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		g1 = createEGenericType(theCommonsPackage.getNameContainer());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getResourceAware());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		g2 = createEGenericType(this.getAction());
		g1.getETypeArguments().add(g2);
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEFactoryLinked());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getActionLike());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNsPrefixable());
		actionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getResourceAware());
		aggregationTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNameContainer());
		aggregationTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		aggregationTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		g2 = createEGenericType(this.getAggregation());
		g1.getETypeArguments().add(g2);
		aggregationTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		aggregationTypeEClass.getEGenericSuperTypes().add(g1);
		targetTypeRefEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		targetTypeRefEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(storyTypeEClass, StoryType.class, "StoryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storySchemaCatalogEClass, StorySchemaCatalog.class, "StorySchemaCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorySchemaCatalog_StoryTypes(), this.getStoryType(), null, "storyTypes", null, 0, -1, StorySchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStorySchemaCatalog_ActionTypes(), this.getActionType(), null, "actionTypes", null, 0, -1, StorySchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStorySchemaCatalog_AggregationTypes(), this.getAggregationType(), null, "aggregationTypes", null, 0, -1, StorySchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStorySchemaCatalog_GeneratedPackageName(), theEcorePackage.getEString(), "generatedPackageName", null, 1, 1, StorySchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStorySchemaCatalog_XmiUrl(), theCommonsPackage.getURL(), "xmiUrl", null, 0, 1, StorySchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStorySchemaCatalog_EcoreUrl(), theCommonsPackage.getURL(), "ecoreUrl", null, 0, 1, StorySchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStorySchemaCatalog_EPackage(), theEcorePackage.getEPackage(), null, "ePackage", null, 0, 1, StorySchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStorySchemaCatalog_EFactory(), theEcorePackage.getEFactory(), null, "eFactory", null, 0, 1, StorySchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(storySchemaCatalogEClass, null, "createAction", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAction());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaClass());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "targetClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(actionTypeEClass, ActionType.class, "ActionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionType_ResolvedSubjectTypes(), theSchemaPackage_1.getTargetType(), null, "resolvedSubjectTypes", null, 0, -1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionType_Status(), this.getActionTypeStatus(), "status", null, 0, 1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionType_SubjectTypes(), this.getTargetTypeRef(), null, "subjectTypes", null, 0, -1, ActionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(actionTypeEClass, this.getAction(), "create", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(aggregationTypeEClass, AggregationType.class, "AggregationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(aggregationTypeEClass, this.getAggregation(), "create", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(actionLikeEClass, ActionLike.class, "ActionLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionLike_Tenses(), this.getTenses(), "tenses", null, 1, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionLike_PastTense(), theEcorePackage.getEString(), "pastTense", null, 0, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionLike_PluralPastTense(), theEcorePackage.getEString(), "pluralPastTense", null, 0, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionLike_PresentTense(), theEcorePackage.getEString(), "presentTense", null, 1, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionLike_PluralPresentTense(), theEcorePackage.getEString(), "pluralPresentTense", null, 1, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionLike_ImperativeTense(), theEcorePackage.getEString(), "imperativeTense", null, 1, 1, ActionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetTypeRefEClass, TargetTypeRef.class, "TargetTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(tensesEEnum, Tenses.class, "Tenses");
		addEEnumLiteral(tensesEEnum, Tenses.BOTH);
		addEEnumLiteral(tensesEEnum, Tenses.PRESENT);

		initEEnum(actionTypeStatusEEnum, ActionTypeStatus.class, "ActionTypeStatus");
		addEEnumLiteral(actionTypeStatusEEnum, ActionTypeStatus.UNRESOLVED);
		addEEnumLiteral(actionTypeStatusEEnum, ActionTypeStatus.RESOLVED);

		// Initialize data types
		initEDataType(storyEDataType, Story.class, "Story", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(actionEDataType, Action.class, "Action", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(aggregationEDataType, Aggregation.class, "Aggregation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (storyTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "name = name of the Story entity Class (including package, if any), relative to the bundle symbolic name."
		   });		
		addAnnotation
		  (storySchemaCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "The loader will load two files for each catalog:\n\n1. <catalogName>.StorySchemaCatalog.xmi, declaring the action/target/aggregation/story types, but not the structure.\n2. <catalogName>.ecore. This defines the structure of the types.\n\nThe loader will resolve eClass names mentioned in the StorySchemaCatalog inside the related ecore file.\n\nnsPrefix = Used to resolve a TargetType subject types inside ActionType."
		   });		
		addAnnotation
		  (storySchemaCatalogEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Helper method to create an {@link Action}."
		   });		
		addAnnotation
		  (getStorySchemaCatalog_GeneratedPackageName(), 
		   source, 
		   new String[] {
			 "documentation", "Used to lookup the Java class. e.g. \"id.co.bippo.person.story\"."
		   });		
		addAnnotation
		  (getStorySchemaCatalog_XmiUrl(), 
		   source, 
		   new String[] {
			 "documentation", "Only used at runtime by XmiTracker."
		   });		
		addAnnotation
		  (getStorySchemaCatalog_EcoreUrl(), 
		   source, 
		   new String[] {
			 "documentation", "Only used at runtime by XmiTracker."
		   });		
		addAnnotation
		  (getStorySchemaCatalog_EPackage(), 
		   source, 
		   new String[] {
			 "documentation", "Only used by XmiTracker."
		   });		
		addAnnotation
		  (getStorySchemaCatalog_EFactory(), 
		   source, 
		   new String[] {
			 "documentation", "Only used by XmiTracker."
		   });		
		addAnnotation
		  (actionTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Before your application can publish actions, you must first define and register Action Types through the Open Graph Tool within the App Dashboard.\n\n    Define Action Types for your app\n    Utilize Built-In Action Types in your app\n    Configure Custom Action Types with default properties\n    Define Custom Properties for Custom Action Types\n    Utilize Custom Action Types with Built-In Object Types in your app\n\nDefine Action Types\n\nTo define an Action Type, click on the \"Create New Action Type\" button in the Dashboard view and enter an action which describes a high-level social action users can do in your app.\n\n\nStart typing the action into the action dialog to get started:\n\nConfigure Custom Action Types\n\nOnce you have defined the name of a custom action type, you are ready to configure its properties:\nDefine Action Type\n\n\n    Basic:\n        Name field is pre-filled with the action you defined in the initial step. For example: read, bake, run.\n        Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list.\n    Properties: These are the instance specific properties you can set when you publish an action.\n        Any object types that are connected to this action type will be listed first. These are required when publishing an action.\n        start_time an optional field specifies a start time for a published action. This is used to control the tense of of the action displayed in the News Feed story. string containing ISO-8601 date-time\n        end_time an optional field specifies an end time for a published action. This is used to control the tense of of the action displayed in the News Feed story. string containing ISO-8601 date-time\n        expires_in an optional field specifies when a published action will expire. This is used to control the tense of of the action displayed in the News Feed story.\n        place an optional field specifies a place for a published action. This is used to set additional location information displayed the News Feed story. Location is an important part of a story that helps convey rich information about the action or event taking place. Open Graph stories that include the place field will be considered for additional News Feed and Timeline distribution. See the Location Tagging documentation for more information.\n        tags an optional field specifies one or more Facebook users to tag in a published action. This is used to set additional tagging information displayed in the News Feed story. The information entered should be a comma-separated list of one or more Facebook user ids. Read more information about how to use this field.\n        image an optional field specifies the image for a published action. This is used to control the image that is displayed in News Feed and Timeline stories. If no image is specified the image corresponding to the object is displayed. Images that are 200x200px or higher tend to get more distribution through News Feed and Timeline as the stories generated leverage deeper story formats.\n        ref an optional field specifies a reference for a published action. This parameter will be associated with your published action and can then be used to track analytics in App Insights.\n        message an optional field specifies the message that will be attached to the action when it is displayed in the News Feed story. Read more information about how to use this field.\n        Add Custom Property as needed. This allows you to add additional action type properties, allowing you to specify the property type and property rules.\n\nConfigure Story Text\n\n\n    Tenses Supported: Allows you to select the tenses that will be used in News Feed stories. For example, you may wish to always display stories in present tense, in which case you would select the \'\'only the present tense\'\' option.\n    Configure Tenses: Configure how the stories will appear in the News Feed. By default, all actions are displayed in the past tense form, unless specified for a period of time in the present tense.\n        Past Tense field is pre-filled with an initial past tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.\n        Plural Past Tense field is pre-filled with an initial past tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the \'Sentence Previews` box.\n        Present Tense field is pre-filled with an initial present tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.\n        Plural Present Tense field is pre-filled with an initial present tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the Sentence Previews box.\n        Imperative Tense field is pre-filled with an initial present tense action corresponding to your initial action type. This field controls the display for action links. You can edit this field. You can preview the various sentences that may be generated using the Sentence Previews box.\n    Sentence Previews: The preview box displays the various stories that can be generated for the different tenses. This enables you to see how your stories will appear in News Feed, notifications, Timeline headers, etc. Use this to help you define your tenses. You may have to save the action type at least once for the sentence previews to display.\n        Singular Present displays the various stories for an individual actor and a present tense action.\n        Plural Present displays the various stories for an multiple actors and a present tense action.\n        Singular Past displays the various stories for an individual actor and a past tense action.\n        Singular Past displays the various stories for an multiple actors and a past tense action.\n        Imperative displays the various stories for an action link.\n\nConfigure Story Attachment\n\n\n    Attachment Layout: Configure the way the action attachment renders in the News Feed, Ticker (when a user clicks on the one line story), and in Timeline.\n        Item select this option for caption next to an image\n        Numberselect this option for displaying a number with caption underneath\n        Map select this option for map view of your action\n    Caption: Create a caption for your story with a combination of text, action and object property values and a simple text template syntax for formatting these property values. See Using Text Templates for details.\n    Note: Do not repeat text of the form [user] [action] [object] in the captions, as this will be automatically generated and added to each published Open Graph story.\n    Advanced:\n        Graph API URL field allows you to set the endpoint URL you will use to call your action. You can only change the action part of this URL. The action is pre-filled with the one you set initially.\n        Unique Action field allows you to select whether you will support unique actions or not. By default you will support multiple actions. Only select this option if there can only be one instance of the action -> object pair. For example, a valid use case of this is if a user can only vote once for an entry.\n        Requires App Access Token to Publish field specifies if the app secret is required to publish activity. For example, some games want enforce that actions like score or achieve can only be written from the app\'s servers and can\'t be written by trapping a normal access token and writing to the graph. To do this, do Graph writes using /{user-id}/{action}?access_token={token} where token is an app access token and the user id is a #. By default an app access_token is not required.\n        Geographic Restrictions field allows you to list countries where you either want to show or hide published actions.\n        Linked Action field allows you to tie an existing action type to this action type as part of configuring action links.\n        Action Link Preview box allows you to view how an action link will be displayed in News Feed or Timeline. This preview is only visible when a Linked Action has been specified.\n        Action Link URL field specifies the end point that Facebook will call when a user clicks on an action link. This must be a secure link.\n\nPreview\n\n\nThis preview box allows you to see how your action instance story will appear in the News Feed and Timeline.\n\nDefine Custom Properties\n\nCustom properties are additional attributes used to describe a custom action instance. Actions, by default, are only visible to a user\'s friends. Apps can specify a broader (everyone) or narrower (user only) visibility setting for actions generated by the app. Additionally, a user can also edit the action visibility settings on her Timeline. More details on app permissions and settings here.\n\nCustom properties of a custom action are used to store personal and instance-specific data. Examples of custom action instance properties include: Duration for a run action, Score for a game-play action, or Rating for a review action.\n\nA custom property can also be defined to refer to other objects. For example, when a user reviewed a dish, \"review\" is the action and \"dish\" is the object. A \"restaurant\" object can be a custom property associated with the \"review\" action.\n\nIf an image was specified when publishing an action, News Feed will prioritize the action image over the object image.\nNext Steps\n\n    Define Objects\n    Define Timeline Aggregations\n    Publish Actions\n    Configure Action Links\n\nReference: https://developers.facebook.com/docs/technical-guides/opengraph/defining-an-action-type/#define"
		   });		
		addAnnotation
		  (actionTypeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create Action with proper nsPrefix and actionType attributes."
		   });		
		addAnnotation
		  (getActionType_ResolvedSubjectTypes(), 
		   source, 
		   new String[] {
			 "documentation", "Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list."
		   });		
		addAnnotation
		  (getActionType_SubjectTypes(), 
		   source, 
		   new String[] {
			 "documentation", "Connected Object Types indicates the object types that this action can act upon. If you have previously defined custom object types for this app, you can add these here. You may also add Built-In Object Types to this list."
		   });		
		addAnnotation
		  (aggregationTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Timeline Aggregations are aggregated stories that are defined by an application to showcase actions and objects on a user\'s Timeline in a structured and interesting way.\n\nWhen a user installs an application that publishes back to Open Graph, an Aggregation defined by the application will appear on the user\'s Timeline based on two key factors:\n\n    Data availability - Sufficient actions and objects were published to generate an Aggregation in a given time period.\n    Feedback - Calculated based on how engaged users are with the Aggregation on their Timelines, covering both positive actions (liking, commenting, pinning) and negative ones (removing/hiding the aggregation, removing the application that generated the aggregation).\n\nWhen an application defines multiple aggregations, these may appear on Timeline as Reports. Reports are collections of aggregations and are shown for each time period in which a user has published activity back to the Open Graph. This provides a consistent viewing experience and makes it easier for a user to digest data from an application. When configuring multiple aggregations for an application through the Facebook App Dashboard, ensure that these aggregations are ordered by priority - with the most important aggregation first. When a report is generated for your app, the primary aggregation is in the top position, and the other aggregations (if sufficient data is available to generate these aggregations) are displayed in their respective order in the report.\n\nHere is an example of a Report for a recipe app with 2 aggregated stories with \'Recipes I\'ve Made\' as the primary story.\n\nOverview\n\nWithin the App Dashboard under Open Graph > Dashboard tab, click on \"Create New Aggregation\" to get started.\n\nAn Aggregation can be configured by the following fields:\n\n    Data to Display - Specify whether an Aggregation should surface a user\'s actions or objects.\n    Layout Style - The style of the Aggregation display.\n    Sort By - Chooses how the \'\'Data to Display\'\' will be ordered in the Aggregation. The current choices are \'\'Most Recent\'\', \'\'Favorite\'\', and a \'\'Custom\'\' selection.\n    Aggregation Title - Sets the user-facing title of an Aggregation. Preview any changes through the Timeline Preview box.\n    Caption Lines - Sets the caption shown in an Aggregation. A combination of text and syntax from the in-built Text Template language can be used to create the caption.\n    Advanced - Provides additional optional aggregation parameters: Group By (not available for Aggregations showing actions) and Filters.\n\nData to Display\n\nAn Aggregation can display any action type or object type that your application has configured.\n\nObject Type\nTo configure an Aggregation to show \"Most [Action Type] [Object Types]\", such as: \"Most Ran Routes\", or \"Restaurants Visited Most\", choose the object type (e.g. Route) as the \'\'Data to Display\'\'. Then, select a connected action type (e.g. Run) as the \'\'Action Type\'\'.\n\nSuch an aggregation in effect does a group by on the Route object and accesses its in-built {count} property, which is the number of times a user has taken the connected action on the object, in this case, the number of times the user has ran on the route.\n\nAction Type\nTo configure an Aggregation to show \"Most Recent [Action Type]\", such as: \"Most Recent Runs\" or \"Most Recent Books Read\", choose the action type (e.g. Read) as the \'\'Data to Display\'\'. This aggregation will be able to access individual instances of the chosen action, such as all \"Read\" actions of the current user published by the app back to Open Graph. The {count} for action-based aggregations will always be 1.\n\nExamples\nConsider a Cookbook app that has the Actions: \"Cook\", \"Plan to Make\" and the Objects: \"Recipe\", \"Meal\"\n\n    Configure an aggregation grouped by the \"Recipe\" object, this gives access to the number of times a connected action occurred for the object. For example, to create a Most Cooked Recipes aggregation, select the \"Recipe\" object as the \'\'Data to Display\'\' and \"Cook\" as the connected \'\'Action Type\'\'.\n    Configure an aggregation with an action as the \'\'Data to Display\'\'. For example, setting the \"Plan to Make\" action as the \'\'Data to Display\'\' helps create the Latest Planning to Make aggregation that shows the most recent recipes that the user has taken the \"Plan to Make\" action on. The configured aggregation could also focus on particular properties of an action. For example, if the \"Cook\" action had a custom property called \"Duration\" that tracks how long it takes to cook each time, and if a Longest Cooking aggregation was created, then the \"Cook\" action is the \'\'Data to Display\'\', with a custom \'\'Sort By\'\' on the action property called \"Duration\". The aggregation will have access to action instance-specific information and properties, which would not be available had the \"Recipe\" object been the \'\'Data to Display\'\'.\n\nLayout Style\n\nLayout styles define how your aggregation looks on the user\u2019s Timeline.\n\nThe following layout templates, including suggested use-cases, are available for you to choose from:\n\n    List: Help highlight a user\'s recent activity or favorite objects. Lists also have an associated histogram, shaded grey, that will automatically appear for each row displayed in the list.\n    Gallery: Help when Object images are meaningful. Example, the cover art for my favorite albums or the course photos from my runs.\n    Table: Help highlight a mixture of interesting statistical and qualitative attributes of a user\'s actions or objects.\n    Item: Help highlight a single, interesting action or object with a compelling visual representation. Image size will be 90x90px in Timeline, and 379x284px on App Tabs (if a larger image is provided). To get larger images, you should specify multiply images with your objects and include the height and width attributes. Images with larger sizes will be chosen for the larger format.\n    Number: Help highlight a single, meaningful number from a macro view. For example, a user\'s total miles ran in a time period or the number of restaurant reviews a user has posted.\n    Map: Help highlight geolocation attributes of a user\'s actions and objects. For example, use the Map layout to plot the geo-coordinates of a user\'s \"longest run\" or \"path travelled\" from a lifestyle app.\n\nMap Layout Style\n\nTo take advantage of the Map layout, your objects need to have at least one GeoPoint property. GeoPoint is a complex type that can be described with latitude, longitude, and altitude; altitude being optional here.\n\nThere are two styles of maps to choose from, and each have their own set of parameters:\n\nSingle Action: this style renders one action or object only (using the highest or lowest rank depending on the configured sort order), but can highlight multiple pins on the map and trace a route between several points. One example would be to display a travel action with multiple stops, or a run action that follows multiple paths.\n\nThe parameters the Single Action map takes are:\n\n    Numbers: Specify number values that will be highlighted in the header of this aggregation.\n    Highlighted Points: Specify object or action properties of type GeoPoint that will be rendered as pins on the map. You can specify multiple properties.\n    Route: Specify an array property of type GeoPoint. These points will be rendered on the map as a route.\n\nMultiple Actions: this style renders multiple objects or actions, except that each item is rendered as a point of the map instead of a caption text with a picture within a gallery layout.\n\nThis map style accepts one parameter only:\n\n    Contributing points: Specify an object or action property of type GeoPoint. Only one property is accepted here.\n\nSort By\n\nConfigures the ordering and display for the Aggregation. You have the ability to choose from the following:\n\n    Most Recent: Displays actions ordered by the action\'s start_time property\n    Favorite: Displays objects ordered by the number of times a user has taken a specific action against an object. For example, a \"favorite songs\" Aggregation shows song objects that I\'m connected to via listen actions ordered by the number of listen actions per song.\n    Custom: Sort by properties on an action or object, such as the end time of an action, the number of counts or the highest or lowest numerical value of a property. Examples: Distance or Pace of a run action, the Rating of a movie object.\n\nAggregation Title\n\nUsers will see the title for every aggregation on their Timeline. Avoid using a title that could confuse the another viewer of a user\'s Timeline about the ownership of the actions and objects in the aggregation such as \"My Most Visited Places\" or \"Routes I Ran\". Instead, use identity-agnostic titles such as \"Most Visited Places\" or titles which explicitly articulate ownership such as \"Routes Diana Ran\".\n\nThe title should also honestly reflect the content being displayed. For example, if an application defines a \"Favorite Runs\" aggregation, the application should provide runs that were explicitly made \"favorites\" by the user, versus the most popular runs, which should be titled as \"Most Popular Runs\".\n\nCaption Lines\n\nAggregations support a simple text template syntax for formatting Open Graph action / object properties into strings that a user sees. This template syntax supports formatters for different data types such as dates, times, currencies, etc., pluralization of display text and operators for simple mathematical computations. Text templates are specified between the \u201c{...}\u201d characters.\n\nExample:\nA Run action connects to a Course object via a \u201ccourse\u201d custom property. To show the run\u2019s distance and pace, use:\nRan {course.distance} miles in {time | duration}\nwhich would be formatted into: \u201cRan 7.48 miles in 42:37\u201d.\n\nSee Using Text Templates to take full advantage of its capabilities.\n\nAdvanced\n\nFilters - Option allows the aggregation to only display if this is true. For example, you can filter by the type of movie (type is a custom property on movie object).\n\nGroup by - Option is only available if your Aggregation is displaying Objects. This option allows the aggregation to group by a property of the object. For example, you can group by Movie object\'s type, to show how many times you\'ve watched a certain type of movie.\n\nEffects when Updating the Definition of Existing Aggregations\n\nWhen making changes to the definition of of an existing aggregation definition, you should be aware that some types of changes may wipe out (destructive) aggregation and stories for previously published actions.\n\nDestructive changes (ie: previously published actions will not appear):\n\n    Changing the \"group by\" property\n    Changing the \"action type\" property (if grouping by an object)\n    Changing the \"sort-by\" property\n    Adding a new, previously unused selector to a caption to use / display a property from an action or object\n    Adding a function (sum, max, avg) on an existing selector. Note: we are planning to fix this behavior soon.\n    Adding a filter that uses a function (sum, max, avg).\n\nNon-destructive changes (ie: previously published actions continue to appear):\n\n    Changing the title\n    Changing the layout\n    Changing a caption without adding a new selector or function. i.e. it\'s okay to rearrange text and selectors, just not to add ones that read new properties from an action / object\n    Using a formatter on an existing selector i.e. formatting a date or a number\n    Starting or stopping use of {count}in a filter, selector, etc [fixed week of 12/12]\n    Using an existing selector as a filter\n\nReference: https://developers.facebook.com/docs/technical-guides/opengraph/defining-an-aggregation/"
		   });		
		addAnnotation
		  (aggregationTypeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create Target with proper nsPrefix and aggregationType attributes."
		   });		
		addAnnotation
		  (tensesEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Allows you to select the tenses that will be used in News Feed stories. For example, you may wish to always display stories in present tense, in which case you would select the \'\'only the present tense\'\' option.\n\n<p>Reference: http://developers.facebook.com/docs/technical-guides/opengraph/defining-an-action-type/"
		   });		
		addAnnotation
		  (getActionLike_Tenses(), 
		   source, 
		   new String[] {
			 "documentation", "Allows you to select the tenses that will be used in News Feed stories. For example, you may wish to always display stories in present tense, in which case you would select the \'\'only the present tense\'\' option.\n\n<p>Reference: http://developers.facebook.com/docs/technical-guides/opengraph/defining-an-action-type/"
		   });		
		addAnnotation
		  (getActionLike_PastTense(), 
		   source, 
		   new String[] {
			 "documentation", "Past Tense field is pre-filled with an initial past tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.\n\ne.g. cooked"
		   });		
		addAnnotation
		  (getActionLike_PluralPastTense(), 
		   source, 
		   new String[] {
			 "documentation", "Plural Past Tense field is pre-filled with an initial past tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the \'Sentence Previews` box.\n\ne.g. cooked"
		   });		
		addAnnotation
		  (getActionLike_PresentTense(), 
		   source, 
		   new String[] {
			 "documentation", "Present Tense field is pre-filled with an initial present tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.\n\ne.g. cook"
		   });		
		addAnnotation
		  (getActionLike_PluralPresentTense(), 
		   source, 
		   new String[] {
			 "documentation", "Plural Present Tense field is pre-filled with an initial present tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the Sentence Previews box.\n\ne.g. are cooking"
		   });		
		addAnnotation
		  (getActionLike_ImperativeTense(), 
		   source, 
		   new String[] {
			 "documentation", "Imperative Tense field is pre-filled with an initial present tense action corresponding to your initial action type. This field controls the display for action links. You can edit this field. You can preview the various sentences that may be generated using the Sentence Previews box.\n\ne.g. cook"
		   });
	}

} //SchemaPackageImpl
