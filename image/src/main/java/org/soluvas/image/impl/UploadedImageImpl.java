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
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getStyleCode <em>Style Code</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getStyleVariant <em>Style Variant</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.UploadedImageImpl#getHeight <em>Height</em>}</li>
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
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Long SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Long size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Integer HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected Integer height = HEIGHT_EDEFAULT;

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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__STYLE_CODE, oldStyleCode, styleCode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__STYLE_VARIANT, oldStyleVariant, styleVariant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(Long newSize) {
		Long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(Integer newWidth) {
		Integer oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(Integer newHeight) {
		Integer oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.UPLOADED_IMAGE__HEIGHT, oldHeight, height));
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
			case ImagePackage.UPLOADED_IMAGE__STYLE_CODE:
				return getStyleCode();
			case ImagePackage.UPLOADED_IMAGE__STYLE_VARIANT:
				return getStyleVariant();
			case ImagePackage.UPLOADED_IMAGE__EXTENSION:
				return getExtension();
			case ImagePackage.UPLOADED_IMAGE__SIZE:
				return getSize();
			case ImagePackage.UPLOADED_IMAGE__WIDTH:
				return getWidth();
			case ImagePackage.UPLOADED_IMAGE__HEIGHT:
				return getHeight();
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
			case ImagePackage.UPLOADED_IMAGE__STYLE_CODE:
				setStyleCode((String)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__STYLE_VARIANT:
				setStyleVariant((String)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__EXTENSION:
				setExtension((String)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__SIZE:
				setSize((Long)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.UPLOADED_IMAGE__HEIGHT:
				setHeight((Integer)newValue);
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
			case ImagePackage.UPLOADED_IMAGE__STYLE_CODE:
				setStyleCode(STYLE_CODE_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__STYLE_VARIANT:
				setStyleVariant(STYLE_VARIANT_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.UPLOADED_IMAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case ImagePackage.UPLOADED_IMAGE__STYLE_CODE:
				return STYLE_CODE_EDEFAULT == null ? styleCode != null : !STYLE_CODE_EDEFAULT.equals(styleCode);
			case ImagePackage.UPLOADED_IMAGE__STYLE_VARIANT:
				return STYLE_VARIANT_EDEFAULT == null ? styleVariant != null : !STYLE_VARIANT_EDEFAULT.equals(styleVariant);
			case ImagePackage.UPLOADED_IMAGE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case ImagePackage.UPLOADED_IMAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case ImagePackage.UPLOADED_IMAGE__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.UPLOADED_IMAGE__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
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
		result.append(", styleCode: ");
		result.append(styleCode);
		result.append(", styleVariant: ");
		result.append(styleVariant);
		result.append(", extension: ");
		result.append(extension);
		result.append(", size: ");
		result.append(size);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //UploadedImageImpl
