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
	
	public ImageVariantImpl(String styleCode, String styleVariant,
			String extension) {
		super();
		this.styleCode = styleCode;
		this.styleVariant = styleVariant;
		this.extension = extension;
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
	@Override
	public String getStyleCode() {
		return styleCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getStyleVariant() {
		return styleVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		result.append(" (styleCode: ");
		result.append(styleCode);
		result.append(", styleVariant: ");
		result.append(styleVariant);
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //ImageVariantImpl
