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
 *   <li>{@link org.soluvas.commons.Positionable#getPositioner <em>Positioner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getPositionable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Positionable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Positioner</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Positioner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positioner</em>' attribute.
	 * @see #setPositioner(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getPositionable_Positioner()
	 * @model default="0"
	 * @generated
	 */
	Integer getPositioner();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Positionable#getPositioner <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positioner</em>' attribute.
	 * @see #getPositioner()
	 * @generated
	 */
	void setPositioner(Integer value);

} // Weightable
