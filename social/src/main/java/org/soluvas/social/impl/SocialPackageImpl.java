/**
 */
package org.soluvas.social.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.commons.CommonsPackage;

import org.soluvas.social.PersonLike;
import org.soluvas.social.SocialFactory;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.Target;

import org.soluvas.social.builtin.ExternalProfile;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.schema.SchemaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SocialPackageImpl extends EPackageImpl implements SocialPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personLikeEClass = null;

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
	 * @see org.soluvas.social.SocialPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SocialPackageImpl() {
		super(eNS_URI, SocialFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SocialPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SocialPackage init() {
		if (isInited) return (SocialPackage)EPackage.Registry.INSTANCE.getEPackage(SocialPackage.eNS_URI);

		// Obtain or create and register package
		SocialPackageImpl theSocialPackage = (SocialPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SocialPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SocialPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SchemaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSocialPackage.createPackageContents();

		// Initialize created meta-data
		theSocialPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSocialPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SocialPackage.eNS_URI, theSocialPackage);
		return theSocialPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_TargetType() {
		return (EReference)targetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Title() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Images() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_Uri() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_TypeName() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonLike() {
		return personLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonLike_FirstName() {
		return (EAttribute)personLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonLike_LastName() {
		return (EAttribute)personLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonLike_Username() {
		return (EAttribute)personLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersonLike_Gender() {
		return (EAttribute)personLikeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocialFactory getSocialFactory() {
		return (SocialFactory)getEFactoryInstance();
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
		targetEClass = createEClass(TARGET);
		createEReference(targetEClass, TARGET__TARGET_TYPE);
		createEAttribute(targetEClass, TARGET__TITLE);
		createEAttribute(targetEClass, TARGET__IMAGES);
		createEAttribute(targetEClass, TARGET__URI);
		createEAttribute(targetEClass, TARGET__TYPE_NAME);

		personLikeEClass = createEClass(PERSON_LIKE);
		createEAttribute(personLikeEClass, PERSON_LIKE__FIRST_NAME);
		createEAttribute(personLikeEClass, PERSON_LIKE__LAST_NAME);
		createEAttribute(personLikeEClass, PERSON_LIKE__USERNAME);
		createEAttribute(personLikeEClass, PERSON_LIKE__GENDER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		targetEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		targetEClass.getESuperTypes().add(theCommonsPackage.getDescribable());

		// Initialize classes and features; add operations and parameters
		initEClass(targetEClass, Target.class, "Target", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTarget_TargetType(), theSchemaPackage.getTargetType(), null, "targetType", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTarget_Title(), theEcorePackage.getEString(), "title", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theCommonsPackage.getList());
		EGenericType g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getTarget_Images(), g1, "images", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTarget_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTarget_TypeName(), theEcorePackage.getEString(), "typeName", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personLikeEClass, PersonLike.class, "PersonLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersonLike_FirstName(), theEcorePackage.getEString(), "firstName", null, 0, 1, PersonLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonLike_LastName(), theEcorePackage.getEString(), "lastName", null, 0, 1, PersonLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonLike_Username(), theEcorePackage.getEString(), "username", null, 0, 1, PersonLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonLike_Gender(), theCommonsPackage.getGender(), "gender", null, 0, 1, PersonLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (targetEClass, 
		   source, 
		   new String[] {
			 "documentation", "Objects\n\nObjects represent \"entities\" that users can act on in your app. Most Open Graph objects are web pages hosted on a public website, with Open Graph-specific meta tags embedded within the page. Facebook routinely scrapes these web pages, extracting the data contained in the meta tags in order to generate stories that it displays on peoples\' News Feeds and Timelines.\n\nPreviously, users were able to connect to objects in your app via the like action. Now, you can model user interactions with custom actions and objects for richer connections with your users.\nTypes\nBuilt-in Objects\n\nFacebook has defined a set of objects that can be used without any further customization on your part.\n\n    Article\n    Blog\n    Book\n    Profile (External)\n    Movie\n    TV Episode\n    TV Show\n    Video\n    Website\n\nCustom Objects\n\nYou have the ability to create your own objects and define all properties of those objects.\nPrivacy Model\n\nObjects are public entities that reside on the internet and must be available to Facebook\'s \"scraper\". All information defined in an object should be considered as public. You should anticipate that all information is easily accessible to anyone on the internet and therefore, no sensitive information or information that is exclusive for a user or set of users is stored.\n\n______________________\n\nDirect and Indirect Objects\n\nA direct object is the receiver of action within a sentence, as in \"He hit the ball.\" Be careful to distinguish between a direct object and an object complement:\n\n    They named their daughter Natasha.\n\nIn that sentence, \"daughter\" is the direct object and \"Natasha\" is the object complement, which renames or describes the direct object.\n\nThe indirect object identifies to or for whom or what the action of the verb is performed. The direct object and indirect object are different people or places or things. The direct objects in the sentences below are in boldface; the indirect objects are in italics.\n\n    The instructor gave his students A\'s.\n    Grandfather left Rosalita and Raoul all his money.\n    Jo-Bob sold me her boat.\n\nIncidentally, the word me (and similar object-form pronouns such as him, us, them) is not always an indirect object; it will also serve, sometimes, as a direct object.\n\n    Bless me/her/us!\n    Call me/him/them if you have questions.\n\nIn English, nouns and their accompanying modifiers (articles and adjectives) do not change form when they are used as objects or indirect objects, as they do in many other languages. \"The radio is on the desk\" and \"I borrowed the radio\" contain exactly the same word form used for quite different functions. This is not true of pronouns, however, which use different forms for different functions. (He [subject] loves his grandmother. His grandmother loves him [object].) (See, also, pronoun cases.)\n\nReference: http://grammar.ccc.commnet.edu/grammar/objects.htm"
		   });		
		addAnnotation
		  (getTarget_Title(), 
		   source, 
		   new String[] {
			 "documentation", "Object Name."
		   });		
		addAnnotation
		  (getTarget_Images(), 
		   source, 
		   new String[] {
			 "documentation", "Array of images"
		   });		
		addAnnotation
		  (getTarget_Uri(), 
		   source, 
		   new String[] {
			 "documentation", "Open Graph URL of the Profile"
		   });		
		addAnnotation
		  (getPersonLike_FirstName(), 
		   source, 
		   new String[] {
			 "documentation", "First Name of Profile"
		   });		
		addAnnotation
		  (getPersonLike_LastName(), 
		   source, 
		   new String[] {
			 "documentation", "Last Name of Profile"
		   });		
		addAnnotation
		  (getPersonLike_Username(), 
		   source, 
		   new String[] {
			 "documentation", "Username of Profile, if applicable"
		   });
	}

} //SocialPackageImpl
