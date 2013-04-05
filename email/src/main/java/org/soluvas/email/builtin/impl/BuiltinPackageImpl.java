/**
 */
package org.soluvas.email.builtin.impl;

import email.EmailPackage;
import email.impl.EmailPackageImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.email.builtin.BuiltinFactory;
import org.soluvas.email.builtin.BuiltinPackage;
import org.soluvas.email.builtin.FeedbackToAdmin;
import org.soluvas.email.builtin.Test;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuiltinPackageImpl extends EPackageImpl implements BuiltinPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass feedbackToAdminEClass = null;

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
	 * @see org.soluvas.email.builtin.BuiltinPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BuiltinPackageImpl() {
		super(eNS_URI, BuiltinFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BuiltinPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BuiltinPackage init() {
		if (isInited) return (BuiltinPackage)EPackage.Registry.INSTANCE.getEPackage(BuiltinPackage.eNS_URI);

		// Obtain or create and register package
		BuiltinPackageImpl theBuiltinPackage = (BuiltinPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuiltinPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuiltinPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EmailPackageImpl theEmailPackage = (EmailPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EmailPackage.eNS_URI) instanceof EmailPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EmailPackage.eNS_URI) : EmailPackage.eINSTANCE);

		// Create package meta-data objects
		theBuiltinPackage.createPackageContents();
		theEmailPackage.createPackageContents();

		// Initialize created meta-data
		theBuiltinPackage.initializePackageContents();
		theEmailPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBuiltinPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BuiltinPackage.eNS_URI, theBuiltinPackage);
		return theBuiltinPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTest() {
		return testEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeedbackToAdmin() {
		return feedbackToAdminEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFactory getBuiltinFactory() {
		return (BuiltinFactory)getEFactoryInstance();
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
		testEClass = createEClass(TEST);

		feedbackToAdminEClass = createEClass(FEEDBACK_TO_ADMIN);
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
		EmailPackage theEmailPackage = (EmailPackage)EPackage.Registry.INSTANCE.getEPackage(EmailPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		feedbackToAdminEClass.getESuperTypes().add(theEmailPackage.getPage());

		// Initialize classes and features; add operations and parameters
		initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(feedbackToAdminEClass, FeedbackToAdmin.class, "FeedbackToAdmin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (feedbackToAdminEClass, 
		   source, 
		   new String[] {
			 "documentation", "Feedback message for site/app administrator."
		   });
	}

} //BuiltinPackageImpl
