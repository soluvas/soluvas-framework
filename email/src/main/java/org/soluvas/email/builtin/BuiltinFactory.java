/**
 */
package org.soluvas.email.builtin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.email.builtin.BuiltinPackage
 * @generated
 */
public interface BuiltinFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuiltinFactory eINSTANCE = org.soluvas.email.builtin.impl.BuiltinFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Contact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contact</em>'.
	 * @generated
	 */
	Contact createContact();

	/**
	 * Returns a new object of class '<em>Feedback To Admin Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feedback To Admin Manager</em>'.
	 * @generated
	 */
	FeedbackToAdminManager createFeedbackToAdminManager();

	/**
	 * Returns a new object of class '<em>Soluvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Soluvas</em>'.
	 * @generated
	 */
	Soluvas createSoluvas();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BuiltinPackage getBuiltinPackage();

} //BuiltinFactory
