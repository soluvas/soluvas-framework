/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resize To Fit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * At least width or height must be present.
 * 
 * If both width and height are present, the image will be constrained to specified dimensions.
 * If only width or height are present, the image will be resized proportionally to conform to the specified width/height.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.ResizeToFit#getOnlyShrinkLarger <em>Only Shrink Larger</em>}</li>
 *   <li>{@link org.soluvas.image.ResizeToFit#isExtentEnabled <em>Extent Enabled</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getResizeToFit()
 * @model
 * @generated
 */
public interface ResizeToFit extends ImageTransform, DimensionLike, WatermarkLike, OverlayLike {

	/**
	 * Returns the value of the '<em><b>Only Shrink Larger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Only Shrink Larger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, only shrink larger images, but do not enlarge small images.
	 * If false, both shrinking and enlarging are performed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Only Shrink Larger</em>' attribute.
	 * @see #setOnlyShrinkLarger(Boolean)
	 * @see org.soluvas.image.ImagePackage#getResizeToFit_OnlyShrinkLarger()
	 * @model
	 * @generated
	 */
	Boolean getOnlyShrinkLarger();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ResizeToFit#getOnlyShrinkLarger <em>Only Shrink Larger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Only Shrink Larger</em>' attribute.
	 * @see #getOnlyShrinkLarger()
	 * @generated
	 */
	void setOnlyShrinkLarger(Boolean value);

	/**
	 * Returns the value of the '<em><b>Extent Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent Enabled</em>' attribute.
	 * @see #setExtentEnabled(boolean)
	 * @see org.soluvas.image.ImagePackage#getResizeToFit_ExtentEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExtentEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ResizeToFit#isExtentEnabled <em>Extent Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent Enabled</em>' attribute.
	 * @see #isExtentEnabled()
	 * @generated
	 */
	void setExtentEnabled(boolean value);

} // ResizeToFit
