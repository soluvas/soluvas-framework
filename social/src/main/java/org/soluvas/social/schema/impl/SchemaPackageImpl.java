/**
 */
package org.soluvas.social.schema.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.commons.CommonsPackage;

import org.soluvas.social.Target;

import org.soluvas.social.schema.SchemaFactory;
import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.TargetTypeAdded;
import org.soluvas.social.schema.TargetTypeRemoved;

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
	private EClass targetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass socialSchemaCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetTypeAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetTypeRemovedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType targetEDataType = null;

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
	 * @see org.soluvas.social.schema.SchemaPackage#eNS_URI
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
		CommonsPackage.eINSTANCE.eClass();

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
	public EClass getTargetType() {
		return targetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSocialSchemaCatalog() {
		return socialSchemaCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocialSchemaCatalog_TargetTypes() {
		return (EReference)socialSchemaCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSocialSchemaCatalog_NsPrefix() {
		return (EAttribute)socialSchemaCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSocialSchemaCatalog_GeneratedPackageName() {
		return (EAttribute)socialSchemaCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSocialSchemaCatalog_XmiUrl() {
		return (EAttribute)socialSchemaCatalogEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSocialSchemaCatalog_EcoreUrl() {
		return (EAttribute)socialSchemaCatalogEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocialSchemaCatalog_EPackage() {
		return (EReference)socialSchemaCatalogEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSocialSchemaCatalog_EFactory() {
		return (EReference)socialSchemaCatalogEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetTypeAdded() {
		return targetTypeAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetTypeAdded_TargetTypes() {
		return (EReference)targetTypeAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetTypeRemoved() {
		return targetTypeRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetTypeRemoved_TargetTypes() {
		return (EReference)targetTypeRemovedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTarget() {
		return targetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		targetTypeEClass = createEClass(TARGET_TYPE);

		socialSchemaCatalogEClass = createEClass(SOCIAL_SCHEMA_CATALOG);
		createEReference(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__TARGET_TYPES);
		createEAttribute(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__NS_PREFIX);
		createEAttribute(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME);
		createEAttribute(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__XMI_URL);
		createEAttribute(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__ECORE_URL);
		createEReference(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__EPACKAGE);
		createEReference(socialSchemaCatalogEClass, SOCIAL_SCHEMA_CATALOG__EFACTORY);

		targetTypeAddedEClass = createEClass(TARGET_TYPE_ADDED);
		createEReference(targetTypeAddedEClass, TARGET_TYPE_ADDED__TARGET_TYPES);

		targetTypeRemovedEClass = createEClass(TARGET_TYPE_REMOVED);
		createEReference(targetTypeRemovedEClass, TARGET_TYPE_REMOVED__TARGET_TYPES);

		// Create data types
		targetEDataType = createEDataType(TARGET);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theCommonsPackage.getNameContainer());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getResourceAware());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		EGenericType g2 = createEGenericType(this.getTarget());
		g1.getETypeArguments().add(g2);
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEFactoryLinked());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNsPrefixable());
		targetTypeEClass.getEGenericSuperTypes().add(g1);
		socialSchemaCatalogEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		socialSchemaCatalogEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());

		// Initialize classes and features; add operations and parameters
		initEClass(targetTypeEClass, TargetType.class, "TargetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(targetTypeEClass, this.getTarget(), "create", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(socialSchemaCatalogEClass, SocialSchemaCatalog.class, "SocialSchemaCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSocialSchemaCatalog_TargetTypes(), this.getTargetType(), null, "targetTypes", null, 0, -1, SocialSchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSocialSchemaCatalog_NsPrefix(), theEcorePackage.getEString(), "nsPrefix", null, 1, 1, SocialSchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSocialSchemaCatalog_GeneratedPackageName(), theEcorePackage.getEString(), "generatedPackageName", null, 1, 1, SocialSchemaCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSocialSchemaCatalog_XmiUrl(), theCommonsPackage.getURL(), "xmiUrl", null, 0, 1, SocialSchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSocialSchemaCatalog_EcoreUrl(), theCommonsPackage.getURL(), "ecoreUrl", null, 0, 1, SocialSchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSocialSchemaCatalog_EPackage(), theEcorePackage.getEPackage(), null, "ePackage", null, 0, 1, SocialSchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSocialSchemaCatalog_EFactory(), theEcorePackage.getEFactory(), null, "eFactory", null, 0, 1, SocialSchemaCatalog.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetTypeAddedEClass, TargetTypeAdded.class, "TargetTypeAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetTypeAdded_TargetTypes(), this.getTargetType(), null, "targetTypes", null, 0, -1, TargetTypeAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetTypeRemovedEClass, TargetTypeRemoved.class, "TargetTypeRemoved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetTypeRemoved_TargetTypes(), this.getTargetType(), null, "targetTypes", null, 0, -1, TargetTypeRemoved.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(targetEDataType, Target.class, "Target", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (targetTypeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create Target with proper nsPrefix and targetType attributes."
		   });		
		addAnnotation
		  (socialSchemaCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "The loader will load two files for each catalog:\n\n1. <catalogName>.StorySchemaCatalog.xmi, declaring the action/target/aggregation/story types, but not the structure.\n2. <catalogName>.ecore. This defines the structure of the types.\n\nThe loader will resolve eClass names mentioned in the StorySchemaCatalog inside the related ecore file."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_NsPrefix(), 
		   source, 
		   new String[] {
			 "documentation", "Used to resolve a TargetType subject types inside ActionType."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_GeneratedPackageName(), 
		   source, 
		   new String[] {
			 "documentation", "Used to lookup the Java class. e.g. \"id.co.bippo.person.story\"."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_XmiUrl(), 
		   source, 
		   new String[] {
			 "documentation", "Only used at runtime by XmiTracker."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_EcoreUrl(), 
		   source, 
		   new String[] {
			 "documentation", "Only used at runtime by XmiTracker."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_EPackage(), 
		   source, 
		   new String[] {
			 "documentation", "Only used by XmiTracker."
		   });		
		addAnnotation
		  (getSocialSchemaCatalog_EFactory(), 
		   source, 
		   new String[] {
			 "documentation", "Only used by XmiTracker."
		   });
	}

} //SchemaPackageImpl
