/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.PhoneNumber;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Phone Number</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PhoneNumberImpl#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PhoneNumberImpl#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PhoneNumberImpl#getValidationTime <em>Validation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhoneNumberImpl extends EObjectImpl implements PhoneNumber {
	/**
	 * The default value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhoneNumber() <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumber()
	 * @generated
	 * @ordered
	 */
	protected String phoneNumber = PHONE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected boolean primary = PRIMARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationTime() <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime VALIDATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidationTime() <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime validationTime = VALIDATION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhoneNumberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PHONE_NUMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhoneNumber(String newPhoneNumber) {
		String oldPhoneNumber = phoneNumber;
		phoneNumber = newPhoneNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PHONE_NUMBER__PHONE_NUMBER, oldPhoneNumber, phoneNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(boolean newPrimary) {
		boolean oldPrimary = primary;
		primary = newPrimary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PHONE_NUMBER__PRIMARY, oldPrimary, primary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTime getValidationTime() {
		return validationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationTime(DateTime newValidationTime) {
		DateTime oldValidationTime = validationTime;
		validationTime = newValidationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PHONE_NUMBER__VALIDATION_TIME, oldValidationTime, validationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PHONE_NUMBER__PHONE_NUMBER:
				return getPhoneNumber();
			case CommonsPackage.PHONE_NUMBER__PRIMARY:
				return isPrimary();
			case CommonsPackage.PHONE_NUMBER__VALIDATION_TIME:
				return getValidationTime();
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
			case CommonsPackage.PHONE_NUMBER__PHONE_NUMBER:
				setPhoneNumber((String)newValue);
				return;
			case CommonsPackage.PHONE_NUMBER__PRIMARY:
				setPrimary((Boolean)newValue);
				return;
			case CommonsPackage.PHONE_NUMBER__VALIDATION_TIME:
				setValidationTime((DateTime)newValue);
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
			case CommonsPackage.PHONE_NUMBER__PHONE_NUMBER:
				setPhoneNumber(PHONE_NUMBER_EDEFAULT);
				return;
			case CommonsPackage.PHONE_NUMBER__PRIMARY:
				setPrimary(PRIMARY_EDEFAULT);
				return;
			case CommonsPackage.PHONE_NUMBER__VALIDATION_TIME:
				setValidationTime(VALIDATION_TIME_EDEFAULT);
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
			case CommonsPackage.PHONE_NUMBER__PHONE_NUMBER:
				return PHONE_NUMBER_EDEFAULT == null ? phoneNumber != null : !PHONE_NUMBER_EDEFAULT.equals(phoneNumber);
			case CommonsPackage.PHONE_NUMBER__PRIMARY:
				return primary != PRIMARY_EDEFAULT;
			case CommonsPackage.PHONE_NUMBER__VALIDATION_TIME:
				return VALIDATION_TIME_EDEFAULT == null ? validationTime != null : !VALIDATION_TIME_EDEFAULT.equals(validationTime);
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
		result.append(" (phoneNumber: ");
		result.append(phoneNumber);
		result.append(", primary: ");
		result.append(primary);
		result.append(", validationTime: ");
		result.append(validationTime);
		result.append(')');
		return result.toString();
	}

} //PhoneNumberImpl
