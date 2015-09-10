/**
 */
package org.soluvas.data;

import java.math.BigDecimal;

import org.joda.money.CurrencyUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Currency Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mixin with monetary value and currency code.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.CurrencyValue#getCurrencyUnit <em>Currency Unit</em>}</li>
 * </ul>
 *
 * @see org.soluvas.data.DataPackage#getCurrencyValue()
 * @model superTypes="org.soluvas.data.Value<org.eclipse.emf.ecore.EBigDecimal>"
 * @generated
 */
public interface CurrencyValue extends Value<BigDecimal> {
	/**
	 * Returns the value of the '<em><b>Currency Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currency Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Currency Unit</em>' attribute.
	 * @see #setCurrencyUnit(CurrencyUnit)
	 * @see org.soluvas.data.DataPackage#getCurrencyValue_CurrencyUnit()
	 * @model dataType="org.soluvas.commons.CurrencyUnit"
	 * @generated
	 */
	CurrencyUnit getCurrencyUnit();

	/**
	 * Sets the value of the '{@link org.soluvas.data.CurrencyValue#getCurrencyUnit <em>Currency Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency Unit</em>' attribute.
	 * @see #getCurrencyUnit()
	 * @generated
	 */
	void setCurrencyUnit(CurrencyUnit value);
	
} // CurrencyValue
