/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.FacebookIdentity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facebook Identity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.FacebookIdentityImpl#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.FacebookIdentityImpl#getFacebookUsername <em>Facebook Username</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacebookIdentityImpl extends MinimalEObjectImpl.Container implements FacebookIdentity {
	/**
	 * The default value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected static final Long FACEBOOK_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected Long facebookId = FACEBOOK_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookUsername() <em>Facebook Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookUsername() <em>Facebook Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUsername()
	 * @generated
	 * @ordered
	 */
	protected String facebookUsername = FACEBOOK_USERNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacebookIdentityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.FACEBOOK_IDENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getFacebookId() {
		return facebookId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacebookId(Long newFacebookId) {
		Long oldFacebookId = facebookId;
		facebookId = newFacebookId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID, oldFacebookId, facebookId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacebookUsername() {
		return facebookUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacebookUsername(String newFacebookUsername) {
		String oldFacebookUsername = facebookUsername;
		facebookUsername = newFacebookUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME, oldFacebookUsername, facebookUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID:
				return getFacebookId();
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME:
				return getFacebookUsername();
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
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID:
				setFacebookId((Long)newValue);
				return;
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME:
				setFacebookUsername((String)newValue);
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
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID:
				setFacebookId(FACEBOOK_ID_EDEFAULT);
				return;
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME:
				setFacebookUsername(FACEBOOK_USERNAME_EDEFAULT);
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
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID:
				return FACEBOOK_ID_EDEFAULT == null ? facebookId != null : !FACEBOOK_ID_EDEFAULT.equals(facebookId);
			case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME:
				return FACEBOOK_USERNAME_EDEFAULT == null ? facebookUsername != null : !FACEBOOK_USERNAME_EDEFAULT.equals(facebookUsername);
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
		result.append(" (facebookId: ");
		result.append(facebookId);
		result.append(", facebookUsername: ");
		result.append(facebookUsername);
		result.append(')');
		return result.toString();
	}

} //FacebookIdentityImpl
