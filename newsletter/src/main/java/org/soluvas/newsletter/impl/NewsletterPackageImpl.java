/**
 */
package org.soluvas.newsletter.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.newsletter.MailjetCredential;
import org.soluvas.newsletter.MailjetManager;
import org.soluvas.newsletter.MailjetSysConfig;
import org.soluvas.newsletter.NewsletterFactory;
import org.soluvas.newsletter.NewsletterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NewsletterPackageImpl extends EPackageImpl implements NewsletterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailjetManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailjetSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailjetCredentialEClass = null;

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
	 * @see org.soluvas.newsletter.NewsletterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NewsletterPackageImpl() {
		super(eNS_URI, NewsletterFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NewsletterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NewsletterPackage init() {
		if (isInited) return (NewsletterPackage)EPackage.Registry.INSTANCE.getEPackage(NewsletterPackage.eNS_URI);

		// Obtain or create and register package
		NewsletterPackageImpl theNewsletterPackage = (NewsletterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NewsletterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NewsletterPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theNewsletterPackage.createPackageContents();

		// Initialize created meta-data
		theNewsletterPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNewsletterPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NewsletterPackage.eNS_URI, theNewsletterPackage);
		return theNewsletterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailjetManager() {
		return mailjetManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetManager_Enabled() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetManager_ApiKey() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetManager_SecretKey() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetManager_ListId() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailjetSysConfig() {
		return mailjetSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetSysConfig_MailjetEnabled() {
		return (EAttribute)mailjetSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetSysConfig_MailjetApiKey() {
		return (EAttribute)mailjetSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetSysConfig_MailjetSecretKey() {
		return (EAttribute)mailjetSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetSysConfig_MailjetListId() {
		return (EAttribute)mailjetSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailjetCredential() {
		return mailjetCredentialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetCredential_ApiKey() {
		return (EAttribute)mailjetCredentialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetCredential_SecretKey() {
		return (EAttribute)mailjetCredentialEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetCredential_DefaultContactID() {
		return (EAttribute)mailjetCredentialEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewsletterFactory getNewsletterFactory() {
		return (NewsletterFactory)getEFactoryInstance();
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
		mailjetManagerEClass = createEClass(MAILJET_MANAGER);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__ENABLED);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__API_KEY);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__SECRET_KEY);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__LIST_ID);

		mailjetSysConfigEClass = createEClass(MAILJET_SYS_CONFIG);
		createEAttribute(mailjetSysConfigEClass, MAILJET_SYS_CONFIG__MAILJET_ENABLED);
		createEAttribute(mailjetSysConfigEClass, MAILJET_SYS_CONFIG__MAILJET_API_KEY);
		createEAttribute(mailjetSysConfigEClass, MAILJET_SYS_CONFIG__MAILJET_SECRET_KEY);
		createEAttribute(mailjetSysConfigEClass, MAILJET_SYS_CONFIG__MAILJET_LIST_ID);

		mailjetCredentialEClass = createEClass(MAILJET_CREDENTIAL);
		createEAttribute(mailjetCredentialEClass, MAILJET_CREDENTIAL__API_KEY);
		createEAttribute(mailjetCredentialEClass, MAILJET_CREDENTIAL__SECRET_KEY);
		createEAttribute(mailjetCredentialEClass, MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(mailjetManagerEClass, MailjetManager.class, "MailjetManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMailjetManager_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetManager_ApiKey(), ecorePackage.getEString(), "apiKey", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetManager_SecretKey(), ecorePackage.getEString(), "secretKey", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetManager_ListId(), ecorePackage.getELongObject(), "listId", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mailjetSysConfigEClass, MailjetSysConfig.class, "MailjetSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMailjetSysConfig_MailjetEnabled(), ecorePackage.getEBooleanObject(), "mailjetEnabled", null, 1, 1, MailjetSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetSysConfig_MailjetApiKey(), ecorePackage.getEString(), "mailjetApiKey", null, 1, 1, MailjetSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetSysConfig_MailjetSecretKey(), ecorePackage.getEString(), "mailjetSecretKey", null, 1, 1, MailjetSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetSysConfig_MailjetListId(), ecorePackage.getELongObject(), "mailjetListId", null, 1, 1, MailjetSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mailjetCredentialEClass, MailjetCredential.class, "MailjetCredential", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMailjetCredential_ApiKey(), ecorePackage.getEString(), "apiKey", null, 0, 1, MailjetCredential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetCredential_SecretKey(), ecorePackage.getEString(), "secretKey", null, 0, 1, MailjetCredential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetCredential_DefaultContactID(), ecorePackage.getEString(), "defaultContactID", null, 0, 1, MailjetCredential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getMailjetManager_ApiKey(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet API Key."
		   });	
		addAnnotation
		  (getMailjetManager_SecretKey(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet Secret Key."
		   });	
		addAnnotation
		  (getMailjetManager_ListId(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet List ID."
		   });	
		addAnnotation
		  (getMailjetSysConfig_MailjetApiKey(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet API Key."
		   });	
		addAnnotation
		  (getMailjetSysConfig_MailjetSecretKey(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet Secret Key."
		   });	
		addAnnotation
		  (getMailjetSysConfig_MailjetListId(), 
		   source, 
		   new String[] {
			 "documentation", "Mailjet List ID. To get it, use this command:\n\n<pre>\ncurl  --user $API_KEY:$SECRET_KEY api.mailjet.com/0.1/listsAll | xmllint --format -\n</pre>\n"
		   });
	}

} //NewsletterPackageImpl
