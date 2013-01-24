/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.image.DimensionLike;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ResizeToFit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resize To Fit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.soluvas.image.impl.ResizeToFitImpl#getOnlyShrinkLarger <em>Only Shrink Larger</em>}</li>
 * </ul>
 * </p>
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
	public ResizeToFitImpl() {
		super();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.RESIZE_TO_FIT__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOnlyShrinkLarger() {
		return onlyShrinkLarger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				return getWidth();
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				return getHeight();
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
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
			case ImagePackage.RESIZE_TO_FIT__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case ImagePackage.RESIZE_TO_FIT__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case ImagePackage.RESIZE_TO_FIT__ONLY_SHRINK_LARGER:
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
				case ImagePackage.RESIZE_TO_FIT__WIDTH: return ImagePackage.DIMENSION_LIKE__WIDTH;
				case ImagePackage.RESIZE_TO_FIT__HEIGHT: return ImagePackage.DIMENSION_LIKE__HEIGHT;
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
		result.append(", onlyShrinkLarger: ");
		result.append(onlyShrinkLarger);
		result.append(')');
		return result.toString();
	}

} //ResizeToFitImpl
