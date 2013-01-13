/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.image.ImageConfig;
import org.soluvas.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageConfigImpl#getPublicUri <em>Public Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageConfigImpl extends EObjectImpl implements ImageConfig {
	/**
	 * The default value of the '{@link #getPublicUri() <em>Public Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicUri()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicUri() <em>Public Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicUri()
	 * @generated
	 * @ordered
	 */
	protected String publicUri = PUBLIC_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicUri() {
		return publicUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicUri(String newPublicUri) {
		String oldPublicUri = publicUri;
		publicUri = newPublicUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_CONFIG__PUBLIC_URI, oldPublicUri, publicUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.IMAGE_CONFIG__PUBLIC_URI:
				return getPublicUri();
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
			case ImagePackage.IMAGE_CONFIG__PUBLIC_URI:
				setPublicUri((String)newValue);
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
			case ImagePackage.IMAGE_CONFIG__PUBLIC_URI:
				setPublicUri(PUBLIC_URI_EDEFAULT);
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
			case ImagePackage.IMAGE_CONFIG__PUBLIC_URI:
				return PUBLIC_URI_EDEFAULT == null ? publicUri != null : !PUBLIC_URI_EDEFAULT.equals(publicUri);
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
		result.append(" (publicUri: ");
		result.append(publicUri);
		result.append(')');
		return result.toString();
	}

} //ImageConfigImpl
