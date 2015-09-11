/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colorable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An object that can display itself as color.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.Colorable#getColor <em>Color</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getColorable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Colorable extends EObject {
	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color code name or hexadecimal code (i.e. "#3356ff") of category color (usually used as background).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see org.soluvas.commons.CommonsPackage#getColorable_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Colorable#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

} // Colorable
