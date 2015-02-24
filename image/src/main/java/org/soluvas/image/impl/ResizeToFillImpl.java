/**
 */
package org.soluvas.image.impl;

import java.io.File;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.image.DimensionLike;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.WatermarkLike;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resize To Fill</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getWatermarkFile <em>Watermark File</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getWatermarkOpacity <em>Watermark Opacity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getWatermarkGravity <em>Watermark Gravity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getGravity <em>Gravity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFillImpl#getOnlyShrinkLarger <em>Only Shrink Larger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResizeToFillImpl extends EObjectImpl implements ResizeToFill {
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
	 * The default value of the '{@link #getWatermarkFile() <em>Watermark File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkFile()
	 * @generated
	 * @ordered
	 */
	protected static final File WATERMARK_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWatermarkFile() <em>Watermark File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkFile()
	 * @generated
	 * @ordered
	 */
	protected File watermarkFile = WATERMARK_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWatermarkOpacity() <em>Watermark Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkOpacity()
	 * @generated
	 * @ordered
	 */
	protected static final int WATERMARK_OPACITY_EDEFAULT = 15;

	/**
	 * The cached value of the '{@link #getWatermarkOpacity() <em>Watermark Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkOpacity()
	 * @generated
	 * @ordered
	 */
	protected int watermarkOpacity = WATERMARK_OPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWatermarkGravity() <em>Watermark Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkGravity()
	 * @generated
	 * @ordered
	 */
	protected static final TransformGravity WATERMARK_GRAVITY_EDEFAULT = TransformGravity.CENTER;

	/**
	 * The cached value of the '{@link #getWatermarkGravity() <em>Watermark Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatermarkGravity()
	 * @generated
	 * @ordered
	 */
	protected TransformGravity watermarkGravity = WATERMARK_GRAVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGravity() <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGravity()
	 * @generated
	 * @ordered
	 */
	protected static final TransformGravity GRAVITY_EDEFAULT = TransformGravity.CENTER;

	/**
	 * The cached value of the '{@link #getGravity() <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGravity()
	 * @generated
	 * @ordered
	 */
	protected TransformGravity gravity = GRAVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnlyShrinkLarger() <em>Only Shrink Larger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnlyShrinkLarger()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean ONLY_SHRINK_LARGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnlyShrinkLarger() <em>Only Shrink Larger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnlyShrinkLarger()
	 * @generated
	 * @ordered
	 */
	protected Boolean onlyShrinkLarger = ONLY_SHRINK_LARGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResizeToFillImpl() {
		super();
	}
	
	public ResizeToFillImpl(Integer width, Integer height,
			TransformGravity gravity) {
		super();
		this.width = width;
		this.height = height;
		this.gravity = gravity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.RESIZE_TO_FILL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(Integer newWidth) {
		Integer oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(Integer newHeight) {
		Integer oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getWatermarkFile() {
		return watermarkFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWatermarkFile(File newWatermarkFile) {
		File oldWatermarkFile = watermarkFile;
		watermarkFile = newWatermarkFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE, oldWatermarkFile, watermarkFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWatermarkOpacity() {
		return watermarkOpacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWatermarkOpacity(int newWatermarkOpacity) {
		int oldWatermarkOpacity = watermarkOpacity;
		watermarkOpacity = newWatermarkOpacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY, oldWatermarkOpacity, watermarkOpacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformGravity getWatermarkGravity() {
		return watermarkGravity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWatermarkGravity(TransformGravity newWatermarkGravity) {
		TransformGravity oldWatermarkGravity = watermarkGravity;
		watermarkGravity = newWatermarkGravity == null ? WATERMARK_GRAVITY_EDEFAULT : newWatermarkGravity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY, oldWatermarkGravity, watermarkGravity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformGravity getGravity() {
		return gravity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGravity(TransformGravity newGravity) {
		TransformGravity oldGravity = gravity;
		gravity = newGravity == null ? GRAVITY_EDEFAULT : newGravity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__GRAVITY, oldGravity, gravity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getOnlyShrinkLarger() {
		return onlyShrinkLarger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOnlyShrinkLarger(Boolean newOnlyShrinkLarger) {
		Boolean oldOnlyShrinkLarger = onlyShrinkLarger;
		onlyShrinkLarger = newOnlyShrinkLarger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FILL__ONLY_SHRINK_LARGER, oldOnlyShrinkLarger, onlyShrinkLarger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.RESIZE_TO_FILL__WIDTH:
				return getWidth();
			case ImagePackage.RESIZE_TO_FILL__HEIGHT:
				return getHeight();
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE:
				return getWatermarkFile();
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY:
				return getWatermarkOpacity();
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY:
				return getWatermarkGravity();
			case ImagePackage.RESIZE_TO_FILL__GRAVITY:
				return getGravity();
			case ImagePackage.RESIZE_TO_FILL__ONLY_SHRINK_LARGER:
				return getOnlyShrinkLarger();
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
			case ImagePackage.RESIZE_TO_FILL__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE:
				setWatermarkFile((File)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY:
				setWatermarkOpacity((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY:
				setWatermarkGravity((TransformGravity)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__GRAVITY:
				setGravity((TransformGravity)newValue);
				return;
			case ImagePackage.RESIZE_TO_FILL__ONLY_SHRINK_LARGER:
				setOnlyShrinkLarger((Boolean)newValue);
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
			case ImagePackage.RESIZE_TO_FILL__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE:
				setWatermarkFile(WATERMARK_FILE_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY:
				setWatermarkOpacity(WATERMARK_OPACITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY:
				setWatermarkGravity(WATERMARK_GRAVITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__GRAVITY:
				setGravity(GRAVITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FILL__ONLY_SHRINK_LARGER:
				setOnlyShrinkLarger(ONLY_SHRINK_LARGER_EDEFAULT);
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
			case ImagePackage.RESIZE_TO_FILL__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.RESIZE_TO_FILL__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE:
				return WATERMARK_FILE_EDEFAULT == null ? watermarkFile != null : !WATERMARK_FILE_EDEFAULT.equals(watermarkFile);
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY:
				return watermarkOpacity != WATERMARK_OPACITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY:
				return watermarkGravity != WATERMARK_GRAVITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FILL__GRAVITY:
				return gravity != GRAVITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FILL__ONLY_SHRINK_LARGER:
				return ONLY_SHRINK_LARGER_EDEFAULT == null ? onlyShrinkLarger != null : !ONLY_SHRINK_LARGER_EDEFAULT.equals(onlyShrinkLarger);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DimensionLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.RESIZE_TO_FILL__WIDTH: return ImagePackage.DIMENSION_LIKE__WIDTH;
				case ImagePackage.RESIZE_TO_FILL__HEIGHT: return ImagePackage.DIMENSION_LIKE__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == WatermarkLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE: return ImagePackage.WATERMARK_LIKE__WATERMARK_FILE;
				case ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY: return ImagePackage.WATERMARK_LIKE__WATERMARK_OPACITY;
				case ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY: return ImagePackage.WATERMARK_LIKE__WATERMARK_GRAVITY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DimensionLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.DIMENSION_LIKE__WIDTH: return ImagePackage.RESIZE_TO_FILL__WIDTH;
				case ImagePackage.DIMENSION_LIKE__HEIGHT: return ImagePackage.RESIZE_TO_FILL__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == WatermarkLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.WATERMARK_LIKE__WATERMARK_FILE: return ImagePackage.RESIZE_TO_FILL__WATERMARK_FILE;
				case ImagePackage.WATERMARK_LIKE__WATERMARK_OPACITY: return ImagePackage.RESIZE_TO_FILL__WATERMARK_OPACITY;
				case ImagePackage.WATERMARK_LIKE__WATERMARK_GRAVITY: return ImagePackage.RESIZE_TO_FILL__WATERMARK_GRAVITY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", watermarkFile: ");
		result.append(watermarkFile);
		result.append(", watermarkOpacity: ");
		result.append(watermarkOpacity);
		result.append(", watermarkGravity: ");
		result.append(watermarkGravity);
		result.append(", gravity: ");
		result.append(gravity);
		result.append(", onlyShrinkLarger: ");
		result.append(onlyShrinkLarger);
		result.append(')');
		return result.toString();
	}

} //ResizeToFillImpl
