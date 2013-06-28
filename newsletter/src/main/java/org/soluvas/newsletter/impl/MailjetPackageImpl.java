/**
 */
package org.soluvas.newsletter.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.newsletter.MailjetFactory;
import org.soluvas.newsletter.MailjetManager;
import org.soluvas.newsletter.MailjetPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MailjetPackageImpl extends EPackageImpl implements MailjetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailjetManagerEClass = null;
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
	 * @see org.soluvas.newsletter.MailjetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MailjetPackageImpl() {
		super(eNS_URI, MailjetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MailjetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MailjetPackage init() {
		if (isInited) return (MailjetPackage)EPackage.Registry.INSTANCE.getEPackage(MailjetPackage.eNS_URI);

		// Obtain or create and register package
		MailjetPackageImpl theMailjetPackage = (MailjetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MailjetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MailjetPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMailjetPackage.createPackageContents();

		// Initialize created meta-data
		theMailjetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMailjetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MailjetPackage.eNS_URI, theMailjetPackage);
		return theMailjetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMailjetManager() {
		return mailjetManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMailjetManager_ApiKey() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMailjetManager_SecretKey() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailjetManager_ListId() {
		return (EAttribute)mailjetManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MailjetFactory getMailjetFactory() {
		return (MailjetFactory)getEFactoryInstance();
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
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__API_KEY);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__SECRET_KEY);
		createEAttribute(mailjetManagerEClass, MAILJET_MANAGER__LIST_ID);
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
		initEAttribute(getMailjetManager_ApiKey(), ecorePackage.getEString(), "apiKey", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetManager_SecretKey(), ecorePackage.getEString(), "secretKey", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailjetManager_ListId(), ecorePackage.getELongObject(), "listId", null, 1, 1, MailjetManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MailjetPackageImpl
