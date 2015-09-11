/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFactory Linked</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Useful for schema classes, e.g. {@code com.soluvas.story.schema.ActionType}, {@code com.soluvas.story.schema.TargetType}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.EFactoryLinked#getEFactory <em>EFactory</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getEFactoryLinked()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EFactoryLinked extends EObject {
	/**
	 * Returns the value of the '<em><b>EFactory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Useful for schema classes, e.g. {@code com.soluvas.story.schema.ActionType}, {@code com.soluvas.story.schema.TargetType}. Only accessible when resolved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EFactory</em>' attribute.
	 * @see #setEFactory(EFactory)
	 * @see org.soluvas.commons.CommonsPackage#getEFactoryLinked_EFactory()
	 * @model dataType="org.soluvas.commons.EFactory" transient="true"
	 * @generated
	 */
	EFactory getEFactory();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.EFactoryLinked#getEFactory <em>EFactory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EFactory</em>' attribute.
	 * @see #getEFactory()
	 * @generated
	 */
	void setEFactory(EFactory value);

} // EFactoryLinked
