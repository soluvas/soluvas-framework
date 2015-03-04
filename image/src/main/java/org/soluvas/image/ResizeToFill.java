/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resize To Fill</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Resize the image to fit within the specified dimensions while retaining the aspect ratio of the original image. If necessary, crop the image in the larger dimension
 * 
 * Common English Translation: This is probably the crop you want if you want to cut a center piece out of a photo and use it as a thumbnail. This wont do any scaling, only cut out the center (by default) to your defined size.
 * 
 * "name": "resize_to_fill",
 * "params" : { "width" : 40, "height" : 40 }
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.ResizeToFill#getGravity <em>Gravity</em>}</li>
 *   <li>{@link org.soluvas.image.ResizeToFill#getOnlyShrinkLarger <em>Only Shrink Larger</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getResizeToFill()
 * @model
 * @generated
 */
public interface ResizeToFill extends ImageTransform, DimensionLike, WatermarkLike, OverlayLike {

	/**
	 * Returns the value of the '<em><b>Gravity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.image.TransformGravity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Location of crop (defaults to 'CenterGravity')
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #setGravity(TransformGravity)
	 * @see org.soluvas.image.ImagePackage#getResizeToFill_Gravity()
	 * @model
	 * @generated
	 */
	TransformGravity getGravity();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ResizeToFill#getGravity <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #getGravity()
	 * @generated
	 */
	void setGravity(TransformGravity value);

	/**
	 * Returns the value of the '<em><b>Only Shrink Larger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Don’t upsize image (defaults to false)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Only Shrink Larger</em>' attribute.
	 * @see #setOnlyShrinkLarger(Boolean)
	 * @see org.soluvas.image.ImagePackage#getResizeToFill_OnlyShrinkLarger()
	 * @model
	 * @generated
	 */
	Boolean getOnlyShrinkLarger();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ResizeToFill#getOnlyShrinkLarger <em>Only Shrink Larger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Only Shrink Larger</em>' attribute.
	 * @see #getOnlyShrinkLarger()
	 * @generated
	 */
	void setOnlyShrinkLarger(Boolean value);
} // ResizeToFill
