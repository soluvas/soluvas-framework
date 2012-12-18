/**
 */
package org.soluvas.data.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joda.money.CurrencyUnit;

import org.soluvas.data.CurrencyValue;
import org.soluvas.data.DataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Currency Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.CurrencyValueImpl#getCurrencyUnit <em>Currency Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurrencyValueImpl extends ValueImpl<BigDecimal> implements CurrencyValue {
	/**
	 * The default value of the '{@link #getCurrencyUnit() <em>Currency Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyUnit()
	 * @generated
	 * @ordered
	 */
	protected static final CurrencyUnit CURRENCY_UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrencyUnit() <em>Currency Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyUnit()
	 * @generated
	 * @ordered
	 */
	protected CurrencyUnit currencyUnit = CURRENCY_UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrencyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.CURRENCY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrencyUnit getCurrencyUnit() {
		return currencyUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrencyUnit(CurrencyUnit newCurrencyUnit) {
		CurrencyUnit oldCurrencyUnit = currencyUnit;
		currencyUnit = newCurrencyUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CURRENCY_VALUE__CURRENCY_UNIT, oldCurrencyUnit, currencyUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.CURRENCY_VALUE__CURRENCY_UNIT:
				return getCurrencyUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.CURRENCY_VALUE__CURRENCY_UNIT:
				setCurrencyUnit((CurrencyUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.CURRENCY_VALUE__CURRENCY_UNIT:
				setCurrencyUnit(CURRENCY_UNIT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.CURRENCY_VALUE__CURRENCY_UNIT:
				return CURRENCY_UNIT_EDEFAULT == null ? currencyUnit != null : !CURRENCY_UNIT_EDEFAULT.equals(currencyUnit);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (currencyUnit: ");
		result.append(currencyUnit);
		result.append(')');
		return result.toString();
	}

} //CurrencyValueImpl
