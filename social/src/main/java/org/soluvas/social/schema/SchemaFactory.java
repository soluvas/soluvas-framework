/**
 */
package org.soluvas.social.schema;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.social.schema.SchemaPackage
 * @generated
 */
public interface SchemaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchemaFactory eINSTANCE = org.soluvas.social.schema.impl.SchemaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Type</em>'.
	 * @generated
	 */
	TargetType createTargetType();

	/**
	 * Returns a new object of class '<em>Social Schema Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Social Schema Catalog</em>'.
	 * @generated
	 */
	SocialSchemaCatalog createSocialSchemaCatalog();

	/**
	 * Returns a new object of class '<em>Target Type Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Type Added</em>'.
	 * @generated
	 */
	TargetTypeAdded createTargetTypeAdded();

	/**
	 * Returns a new object of class '<em>Target Type Removed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Type Removed</em>'.
	 * @generated
	 */
	TargetTypeRemoved createTargetTypeRemoved();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchemaPackage getSchemaPackage();

} //SchemaFactory
