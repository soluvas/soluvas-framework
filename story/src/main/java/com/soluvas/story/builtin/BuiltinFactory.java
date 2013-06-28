/**
 */
package com.soluvas.story.builtin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.soluvas.story.builtin.BuiltinPackage
 * @generated
 */
public interface BuiltinFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuiltinFactory eINSTANCE = com.soluvas.story.builtin.impl.BuiltinFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Follow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Follow</em>'.
	 * @generated
	 */
	Follow createFollow();

	/**
	 * Returns a new object of class '<em>Like</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Like</em>'.
	 * @generated
	 */
	Like createLike();

	/**
	 * Returns a new object of class '<em>Listen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Listen</em>'.
	 * @generated
	 */
	Listen createListen();

	/**
	 * Returns a new object of class '<em>Read</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read</em>'.
	 * @generated
	 */
	Read createRead();

	/**
	 * Returns a new object of class '<em>Watch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Watch</em>'.
	 * @generated
	 */
	Watch createWatch();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Share</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Share</em>'.
	 * @generated
	 */
	Share createShare();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BuiltinPackage getBuiltinPackage();

} //BuiltinFactory
