/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Email;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Email</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.EmailImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.EmailImpl#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.EmailImpl#getValidationTime <em>Validation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmailImpl extends EObjectImpl implements Email {
	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

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
	public EmailImpl() {
		super();
	}
	
	public EmailImpl(String email, boolean primary) {
		super();
		this.email = email;
		this.primary = primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.EMAIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.EMAIL__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimary(boolean newPrimary) {
		boolean oldPrimary = primary;
		primary = newPrimary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.EMAIL__PRIMARY, oldPrimary, primary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getValidationTime() {
		return validationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationTime(DateTime newValidationTime) {
		DateTime oldValidationTime = validationTime;
		validationTime = newValidationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.EMAIL__VALIDATION_TIME, oldValidationTime, validationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.EMAIL__EMAIL:
				return getEmail();
			case CommonsPackage.EMAIL__PRIMARY:
				return isPrimary();
			case CommonsPackage.EMAIL__VALIDATION_TIME:
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
			case CommonsPackage.EMAIL__EMAIL:
				setEmail((String)newValue);
				return;
			case CommonsPackage.EMAIL__PRIMARY:
				setPrimary((Boolean)newValue);
				return;
			case CommonsPackage.EMAIL__VALIDATION_TIME:
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
			case CommonsPackage.EMAIL__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case CommonsPackage.EMAIL__PRIMARY:
				setPrimary(PRIMARY_EDEFAULT);
				return;
			case CommonsPackage.EMAIL__VALIDATION_TIME:
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
			case CommonsPackage.EMAIL__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case CommonsPackage.EMAIL__PRIMARY:
				return primary != PRIMARY_EDEFAULT;
			case CommonsPackage.EMAIL__VALIDATION_TIME:
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
		result.append(" (email: ");
		result.append(email);
		result.append(", primary: ");
		result.append(primary);
		result.append(", validationTime: ");
		result.append(validationTime);
		result.append(')');
		return result.toString();
	}

} //EmailImpl
