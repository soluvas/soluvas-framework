/**
 */
package com.soluvas.story.schema;

import org.eclipse.emf.ecore.EFactory;
import org.soluvas.social.schema.TargetType;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.soluvas.story.schema.SchemaPackage
 * @generated
 */
public interface SchemaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchemaFactory eINSTANCE = com.soluvas.story.schema.impl.SchemaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Story Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Story Type</em>'.
	 * @generated
	 */
	StoryType createStoryType();

	/**
	 * Returns a new object of class '<em>Story Schema Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Story Schema Catalog</em>'.
	 * @generated
	 */
	StorySchemaCatalog createStorySchemaCatalog();

	/**
	 * Returns a new object of class '<em>Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Type</em>'.
	 * @generated
	 */
	ActionType createActionType();

	/**
	 * Returns a new object of class '<em>Aggregation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregation Type</em>'.
	 * @generated
	 */
	AggregationType createAggregationType();

	/**
	 * Returns a new object of class '<em>Target Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Type Ref</em>'.
	 * @generated
	 */
	TargetTypeRef createTargetTypeRef();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchemaPackage getSchemaPackage();

} //SchemaFactory
