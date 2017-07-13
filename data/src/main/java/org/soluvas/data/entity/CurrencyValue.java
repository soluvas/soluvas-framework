/**
 */
package org.soluvas.data.entity;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Currency Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.impl.CurrencyValueImpl#getCurrencyUnit <em>Currency Unit</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
public class CurrencyValue extends Value<BigDecimal> {
	/**
	 * The default value of the '{@link #getCurrencyUnit() <em>Currency Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyUnit()
	 * @generated NOT
	 * @ordered
	 */
	protected static final CurrencyUnit CURRENCY_UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrencyUnit() <em>Currency Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyUnit()
	 * @generated NOT
	 * @ordered
	 */
	protected CurrencyUnit currencyUnit = CURRENCY_UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CurrencyValue() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CurrencyUnit getCurrencyUnit() {
		return currencyUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrencyUnit(CurrencyUnit newCurrencyUnit) {
		this.currencyUnit = newCurrencyUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (currencyUnit: ");
		result.append(currencyUnit);
		result.append(')');
		return result.toString();
	}
	
//	@Override
//	public void copyFrom(org.soluvas.data.Value<?> upValue) {
//		super.copyFrom(upValue);
//		if (upValue instanceof org.soluvas.data.CurrencyValue) {
//			final org.soluvas.data.CurrencyValue upCurrencyValue = (org.soluvas.data.CurrencyValue) upValue;
//			setCurrencyUnit(upCurrencyValue.getCurrencyUnit());
//		}
//	}

} //CurrencyValueImpl
