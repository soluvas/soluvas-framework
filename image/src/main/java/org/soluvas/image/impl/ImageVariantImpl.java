/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageVariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageVariantImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageVariantImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageVariantImpl#getStyleCode <em>Style Code</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageVariantImpl#getStyleVariant <em>Style Variant</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ImageVariantImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageVariantImpl extends EObjectImpl implements ImageVariant {
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected String imageId = IMAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getStyleCode() <em>Style Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleCode()
	 * @generated
	 * @ordered
	 */
	protected static final String STYLE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStyleCode() <em>Style Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleCode()
	 * @generated
	 * @ordered
	 */
	protected String styleCode = STYLE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStyleVariant() <em>Style Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleVariant()
	 * @generated
	 * @ordered
	 */
	protected static final String STYLE_VARIANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStyleVariant() <em>Style Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleVariant()
	 * @generated
	 * @ordered
	 */
	protected String styleVariant = STYLE_VARIANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageVariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_VARIANT__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageId(String newImageId) {
		String oldImageId = imageId;
		imageId = newImageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_VARIANT__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStyleCode() {
		return styleCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyleCode(String newStyleCode) {
		String oldStyleCode = styleCode;
		styleCode = newStyleCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_VARIANT__STYLE_CODE, oldStyleCode, styleCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStyleVariant() {
		return styleVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyleVariant(String newStyleVariant) {
		String oldStyleVariant = styleVariant;
		styleVariant = newStyleVariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_VARIANT__STYLE_VARIANT, oldStyleVariant, styleVariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_VARIANT__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.IMAGE_VARIANT__NAMESPACE:
				return getNamespace();
			case ImagePackage.IMAGE_VARIANT__IMAGE_ID:
				return getImageId();
			case ImagePackage.IMAGE_VARIANT__STYLE_CODE:
				return getStyleCode();
			case ImagePackage.IMAGE_VARIANT__STYLE_VARIANT:
				return getStyleVariant();
			case ImagePackage.IMAGE_VARIANT__EXTENSION:
				return getExtension();
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
			case ImagePackage.IMAGE_VARIANT__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case ImagePackage.IMAGE_VARIANT__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case ImagePackage.IMAGE_VARIANT__STYLE_CODE:
				setStyleCode((String)newValue);
				return;
			case ImagePackage.IMAGE_VARIANT__STYLE_VARIANT:
				setStyleVariant((String)newValue);
				return;
			case ImagePackage.IMAGE_VARIANT__EXTENSION:
				setExtension((String)newValue);
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
			case ImagePackage.IMAGE_VARIANT__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case ImagePackage.IMAGE_VARIANT__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case ImagePackage.IMAGE_VARIANT__STYLE_CODE:
				setStyleCode(STYLE_CODE_EDEFAULT);
				return;
			case ImagePackage.IMAGE_VARIANT__STYLE_VARIANT:
				setStyleVariant(STYLE_VARIANT_EDEFAULT);
				return;
			case ImagePackage.IMAGE_VARIANT__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
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
			case ImagePackage.IMAGE_VARIANT__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case ImagePackage.IMAGE_VARIANT__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case ImagePackage.IMAGE_VARIANT__STYLE_CODE:
				return STYLE_CODE_EDEFAULT == null ? styleCode != null : !STYLE_CODE_EDEFAULT.equals(styleCode);
			case ImagePackage.IMAGE_VARIANT__STYLE_VARIANT:
				return STYLE_VARIANT_EDEFAULT == null ? styleVariant != null : !STYLE_VARIANT_EDEFAULT.equals(styleVariant);
			case ImagePackage.IMAGE_VARIANT__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
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
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(", imageId: ");
		result.append(imageId);
		result.append(", styleCode: ");
		result.append(styleCode);
		result.append(", styleVariant: ");
		result.append(styleVariant);
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //ImageVariantImpl
