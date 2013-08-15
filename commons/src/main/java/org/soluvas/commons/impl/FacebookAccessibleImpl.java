/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.FacebookAccessible;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facebook Accessible</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.FacebookAccessibleImpl#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacebookAccessibleImpl extends MinimalEObjectImpl.Container implements FacebookAccessible {
	/**
	 * The default value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String facebookAccessToken = FACEBOOK_ACCESS_TOKEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacebookAccessibleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.FACEBOOK_ACCESSIBLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacebookAccessToken(String newFacebookAccessToken) {
		String oldFacebookAccessToken = facebookAccessToken;
		facebookAccessToken = newFacebookAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN, oldFacebookAccessToken, facebookAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN:
				return getFacebookAccessToken();
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
			case CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken((String)newValue);
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
			case CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken(FACEBOOK_ACCESS_TOKEN_EDEFAULT);
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
			case CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN:
				return FACEBOOK_ACCESS_TOKEN_EDEFAULT == null ? facebookAccessToken != null : !FACEBOOK_ACCESS_TOKEN_EDEFAULT.equals(facebookAccessToken);
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
		result.append(" (facebookAccessToken: ");
		result.append(facebookAccessToken);
		result.append(')');
		return result.toString();
	}

} //FacebookAccessibleImpl
