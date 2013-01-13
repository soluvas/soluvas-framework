/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uploaded Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getOriginUri <em>Origin Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UploadedImageImpl extends EObjectImpl implements UploadedImage {
	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginUri() <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginUri() <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUri()
	 * @generated
	 * @ordered
	 */
	protected String originUri = ORIGIN_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadedImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.UPLOADED_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginUri() {
		return originUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginUri(String newOriginUri) {
		String oldOriginUri = originUri;
		originUri = newOriginUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__ORIGIN_URI, oldOriginUri, originUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.UPLOADED_IMAGE__URI:
				return getUri();
			case ImagePackage.UPLOADED_IMAGE__ORIGIN_URI:
				return getOriginUri();
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
			case ImagePackage.UPLOADED_IMAGE__URI:
				setUri((String)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__ORIGIN_URI:
				setOriginUri((String)newValue);
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
			case ImagePackage.UPLOADED_IMAGE__URI:
				setUri(URI_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__ORIGIN_URI:
				setOriginUri(ORIGIN_URI_EDEFAULT);
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
			case ImagePackage.UPLOADED_IMAGE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ImagePackage.UPLOADED_IMAGE__ORIGIN_URI:
				return ORIGIN_URI_EDEFAULT == null ? originUri != null : !ORIGIN_URI_EDEFAULT.equals(originUri);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", originUri: ");
		result.append(originUri);
		result.append(')');
		return result.toString();
	}

} //UploadedImageImpl
