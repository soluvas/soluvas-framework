/**
 */
package org.soluvas.email.builtin.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.email.builtin.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuiltinFactoryImpl extends EFactoryImpl implements BuiltinFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BuiltinFactory init() {
		try {
			BuiltinFactory theBuiltinFactory = (BuiltinFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/email.builtin/1.0"); 
			if (theBuiltinFactory != null) {
				return theBuiltinFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BuiltinFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFactoryImpl() {
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
			case BuiltinPackage.CONTACT: return (EObject)createContact();
			case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER: return (EObject)createFeedbackToAdminManager();
			case BuiltinPackage.SOLUVAS: return (EObject)createSoluvas();
			case BuiltinPackage.TESTER: return (EObject)createTester();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact createContact() {
		ContactImpl contact = new ContactImpl();
		return contact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedbackToAdminManager createFeedbackToAdminManager() {
		FeedbackToAdminManagerImpl feedbackToAdminManager = new FeedbackToAdminManagerImpl();
		return feedbackToAdminManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Soluvas createSoluvas() {
		SoluvasImpl soluvas = new SoluvasImpl();
		return soluvas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tester createTester() {
		TesterImpl tester = new TesterImpl();
		return tester;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinPackage getBuiltinPackage() {
		return (BuiltinPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BuiltinPackage getPackage() {
		return BuiltinPackage.eINSTANCE;
	}

} //BuiltinFactoryImpl
