/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage
 * @generated
 */
public interface CommonsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonsFactory eINSTANCE = org.soluvas.commons.impl.CommonsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>App Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>App Manifest</em>'.
	 * @generated
	 */
	AppManifest createAppManifest();

	/**
	 * Returns a new object of class '<em>Person Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person Info</em>'.
	 * @generated
	 */
	PersonInfo createPersonInfo();
	
	/**
	 * Returns a new object of class '<em>Photo Id Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Photo Id Container</em>'.
	 * @generated
	 */
	PhotoIdContainer createPhotoIdContainer();

	/**
	 * Returns a new object of class '<em>Name Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Container</em>'.
	 * @generated
	 */
	NameContainer createNameContainer();

	/**
	 * Returns a new object of class '<em>Java Class Linked</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Class Linked</em>'.
	 * @generated
	 */
	<T> JavaClassLinked<T> createJavaClassLinked();

	/**
	 * Returns a new object of class '<em>EClass Linked</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Linked</em>'.
	 * @generated
	 */
	EClassLinked createEClassLinked();

	PersonInfo createPersonInfo(String id, String slug, String name, String photoId, Gender gender);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonsPackage getCommonsPackage();

} //CommonsFactory
