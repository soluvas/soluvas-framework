/**
 */
package org.soluvas.data;

import java.io.Serializable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Range attribute's primary value can be either the start or end value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.RangeValue#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link org.soluvas.data.RangeValue#getEndValue <em>End Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getRangeValue()
 * @model TBounds="org.soluvas.commons.Serializable"
 * @generated
 */
public interface RangeValue<T extends Serializable> extends Value<T> {
	/**
	 * Returns the value of the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Value</em>' attribute.
	 * @see #setStartValue(Serializable)
	 * @see org.soluvas.data.DataPackage#getRangeValue_StartValue()
	 * @model
	 * @generated
	 */
	T getStartValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.RangeValue#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(T value);

	/**
	 * Returns the value of the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Value</em>' attribute.
	 * @see #setEndValue(Serializable)
	 * @see org.soluvas.data.DataPackage#getRangeValue_EndValue()
	 * @model
	 * @generated
	 */
	T getEndValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.RangeValue#getEndValue <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Value</em>' attribute.
	 * @see #getEndValue()
	 * @generated
	 */
	void setEndValue(T value);

} // RangeValue
