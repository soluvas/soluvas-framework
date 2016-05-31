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
import org.soluvas.image.OverlayLike;
import org.soluvas.image.ResizeToFit;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.WatermarkLike;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resize To Fit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getWatermarkFile <em>Watermark File</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getWatermarkOpacity <em>Watermark Opacity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getWatermarkGravity <em>Watermark Gravity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getOverlayFile <em>Overlay File</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getOverlayGravity <em>Overlay Gravity</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getOnlyShrinkLarger <em>Only Shrink Larger</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#isExtentEnabled <em>Extent Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResizeToFitImpl extends EObjectImpl implements ResizeToFit {
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
	 * The default value of the '{@link #getOverlayFile() <em>Overlay File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlayFile()
	 * @generated
	 * @ordered
	 */
	protected static final File OVERLAY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverlayFile() <em>Overlay File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlayFile()
	 * @generated
	 * @ordered
	 */
	protected File overlayFile = OVERLAY_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverlayGravity() <em>Overlay Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlayGravity()
	 * @generated
	 * @ordered
	 */
	protected static final TransformGravity OVERLAY_GRAVITY_EDEFAULT = TransformGravity.CENTER;

	/**
	 * The cached value of the '{@link #getOverlayGravity() <em>Overlay Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverlayGravity()
	 * @generated
	 * @ordered
	 */
	protected TransformGravity overlayGravity = OVERLAY_GRAVITY_EDEFAULT;

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
	 * The default value of the '{@link #isExtentEnabled() <em>Extent Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtentEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtentEnabled() <em>Extent Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtentEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean extentEnabled = EXTENT_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResizeToFitImpl() {
		super();
	}
	
	public ResizeToFitImpl(Integer width, Integer height) {
		super();
		this.width = width;
		this.height = height;
		this.onlyShrinkLarger = false; // also enlarge small images
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.RESIZE_TO_FIT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__HEIGHT, oldHeight, height));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE, oldWatermarkFile, watermarkFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY, oldWatermarkOpacity, watermarkOpacity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY, oldWatermarkGravity, watermarkGravity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getOverlayFile() {
		return overlayFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverlayFile(File newOverlayFile) {
		File oldOverlayFile = overlayFile;
		overlayFile = newOverlayFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE, oldOverlayFile, overlayFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformGravity getOverlayGravity() {
		return overlayGravity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverlayGravity(TransformGravity newOverlayGravity) {
		TransformGravity oldOverlayGravity = overlayGravity;
		overlayGravity = newOverlayGravity == null ? OVERLAY_GRAVITY_EDEFAULT : newOverlayGravity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY, oldOverlayGravity, overlayGravity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER, oldOnlyShrinkLarger, onlyShrinkLarger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtentEnabled() {
		return extentEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtentEnabled(boolean newExtentEnabled) {
		boolean oldExtentEnabled = extentEnabled;
		extentEnabled = newExtentEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__EXTENT_ENABLED, oldExtentEnabled, extentEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				return getWidth();
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				return getHeight();
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE:
				return getWatermarkFile();
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY:
				return getWatermarkOpacity();
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY:
				return getWatermarkGravity();
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE:
				return getOverlayFile();
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY:
				return getOverlayGravity();
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
				return getOnlyShrinkLarger();
			case ImagePackage.RESIZE_TO_FIT__EXTENT_ENABLED:
				return isExtentEnabled();
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE:
				setWatermarkFile((File)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY:
				setWatermarkOpacity((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY:
				setWatermarkGravity((TransformGravity)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE:
				setOverlayFile((File)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY:
				setOverlayGravity((TransformGravity)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
				setOnlyShrinkLarger((Boolean)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__EXTENT_ENABLED:
				setExtentEnabled((Boolean)newValue);
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE:
				setWatermarkFile(WATERMARK_FILE_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY:
				setWatermarkOpacity(WATERMARK_OPACITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY:
				setWatermarkGravity(WATERMARK_GRAVITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE:
				setOverlayFile(OVERLAY_FILE_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY:
				setOverlayGravity(OVERLAY_GRAVITY_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
				setOnlyShrinkLarger(ONLY_SHRINK_LARGER_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__EXTENT_ENABLED:
				setExtentEnabled(EXTENT_ENABLED_EDEFAULT);
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE:
				return WATERMARK_FILE_EDEFAULT == null ? watermarkFile != null : !WATERMARK_FILE_EDEFAULT.equals(watermarkFile);
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY:
				return watermarkOpacity != WATERMARK_OPACITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY:
				return watermarkGravity != WATERMARK_GRAVITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE:
				return OVERLAY_FILE_EDEFAULT == null ? overlayFile != null : !OVERLAY_FILE_EDEFAULT.equals(overlayFile);
			case ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY:
				return overlayGravity != OVERLAY_GRAVITY_EDEFAULT;
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
				return ONLY_SHRINK_LARGER_EDEFAULT == null ? onlyShrinkLarger != null : !ONLY_SHRINK_LARGER_EDEFAULT.equals(onlyShrinkLarger);
			case ImagePackage.RESIZE_TO_FIT__EXTENT_ENABLED:
				return extentEnabled != EXTENT_ENABLED_EDEFAULT;
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
				case ImagePackage.RESIZE_TO_FIT__WIDTH: return ImagePackage.DIMENSION_LIKE__WIDTH;
				case ImagePackage.RESIZE_TO_FIT__HEIGHT: return ImagePackage.DIMENSION_LIKE__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == WatermarkLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE: return ImagePackage.WATERMARK_LIKE__WATERMARK_FILE;
				case ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY: return ImagePackage.WATERMARK_LIKE__WATERMARK_OPACITY;
				case ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY: return ImagePackage.WATERMARK_LIKE__WATERMARK_GRAVITY;
				default: return -1;
			}
		}
		if (baseClass == OverlayLike.class) {
			switch (derivedFeatureID) {
				case ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE: return ImagePackage.OVERLAY_LIKE__OVERLAY_FILE;
				case ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY: return ImagePackage.OVERLAY_LIKE__OVERLAY_GRAVITY;
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
				case ImagePackage.DIMENSION_LIKE__WIDTH: return ImagePackage.RESIZE_TO_FIT__WIDTH;
				case ImagePackage.DIMENSION_LIKE__HEIGHT: return ImagePackage.RESIZE_TO_FIT__HEIGHT;
				default: return -1;
			}
		}
		if (baseClass == WatermarkLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.WATERMARK_LIKE__WATERMARK_FILE: return ImagePackage.RESIZE_TO_FIT__WATERMARK_FILE;
				case ImagePackage.WATERMARK_LIKE__WATERMARK_OPACITY: return ImagePackage.RESIZE_TO_FIT__WATERMARK_OPACITY;
				case ImagePackage.WATERMARK_LIKE__WATERMARK_GRAVITY: return ImagePackage.RESIZE_TO_FIT__WATERMARK_GRAVITY;
				default: return -1;
			}
		}
		if (baseClass == OverlayLike.class) {
			switch (baseFeatureID) {
				case ImagePackage.OVERLAY_LIKE__OVERLAY_FILE: return ImagePackage.RESIZE_TO_FIT__OVERLAY_FILE;
				case ImagePackage.OVERLAY_LIKE__OVERLAY_GRAVITY: return ImagePackage.RESIZE_TO_FIT__OVERLAY_GRAVITY;
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
		result.append(", overlayFile: ");
		result.append(overlayFile);
		result.append(", overlayGravity: ");
		result.append(overlayGravity);
		result.append(", onlyShrinkLarger: ");
		result.append(onlyShrinkLarger);
		result.append(", extentEnabled: ");
		result.append(extentEnabled);
		result.append(')');
		return result.toString();
	}

} //ResizeToFitImpl
