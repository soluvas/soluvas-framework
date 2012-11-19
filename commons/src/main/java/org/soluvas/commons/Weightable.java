/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weightable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Weightable#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getWeightable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Weightable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getWeightable_Weight()
	 * @model default="0"
	 * @generated
	 */
	Integer getWeight();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Weightable#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(Integer value);

} // Weightable
