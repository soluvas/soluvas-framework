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
			case BuiltinPackage.TEST: return (EObject)createTest();
			case BuiltinPackage.FEEDBACK_TO_ADMIN: return (EObject)createFeedbackToAdmin();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Test createTest() {
		TestImpl test = new TestImpl();
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedbackToAdmin createFeedbackToAdmin() {
		FeedbackToAdminImpl feedbackToAdmin = new FeedbackToAdminImpl();
		return feedbackToAdmin;
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
