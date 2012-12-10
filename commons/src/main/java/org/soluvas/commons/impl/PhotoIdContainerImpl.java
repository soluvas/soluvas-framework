/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.PhotoIdContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Photo Id Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PhotoIdContainerImpl#getPhotoId <em>Photo Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PhotoIdContainerImpl extends EObjectImpl implements PhotoIdContainer {
	/**
	 * The default value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected static final String PHOTO_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected String photoId = PHOTO_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhotoIdContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PHOTO_ID_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPhotoId() {
		return photoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhotoId(String newPhotoId) {
		String oldPhotoId = photoId;
		photoId = newPhotoId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID, oldPhotoId, photoId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getImageId() {
		return photoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID:
				return getPhotoId();
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
			case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID:
				setPhotoId((String)newValue);
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
			case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID:
				setPhotoId(PHOTO_ID_EDEFAULT);
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
			case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID:
				return PHOTO_ID_EDEFAULT == null ? photoId != null : !PHOTO_ID_EDEFAULT.equals(photoId);
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
		result.append(" (photoId: ");
		result.append(photoId);
		result.append(')');
		return result.toString();
	}

} //PhotoIdContainerImpl
