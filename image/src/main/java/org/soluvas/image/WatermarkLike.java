/**
 */
package org.soluvas.image;

import java.io.File;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Watermark Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Watermark information if the transform supports watermark operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.WatermarkLike#getWatermarkFile <em>Watermark File</em>}</li>
 *   <li>{@link org.soluvas.image.WatermarkLike#getWatermarkOpacity <em>Watermark Opacity</em>}</li>
 *   <li>{@link org.soluvas.image.WatermarkLike#getWatermarkGravity <em>Watermark Gravity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getWatermarkLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WatermarkLike extends EObject {
	/**
	 * Returns the value of the '<em><b>Watermark File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Watermark file to be used. If null, no watermark will be overlaid.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Watermark File</em>' attribute.
	 * @see #setWatermarkFile(File)
	 * @see org.soluvas.image.ImagePackage#getWatermarkLike_WatermarkFile()
	 * @model dataType="org.soluvas.commons.File"
	 * @generated
	 */
	File getWatermarkFile();

	/**
	 * Sets the value of the '{@link org.soluvas.image.WatermarkLike#getWatermarkFile <em>Watermark File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Watermark File</em>' attribute.
	 * @see #getWatermarkFile()
	 * @generated
	 */
	void setWatermarkFile(File value);

	/**
	 * Returns the value of the '<em><b>Watermark Opacity</b></em>' attribute.
	 * The default value is <code>"15"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Watermark Opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Watermark Opacity</em>' attribute.
	 * @see #setWatermarkOpacity(int)
	 * @see org.soluvas.image.ImagePackage#getWatermarkLike_WatermarkOpacity()
	 * @model default="15"
	 * @generated
	 */
	int getWatermarkOpacity();

	/**
	 * Sets the value of the '{@link org.soluvas.image.WatermarkLike#getWatermarkOpacity <em>Watermark Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Watermark Opacity</em>' attribute.
	 * @see #getWatermarkOpacity()
	 * @generated
	 */
	void setWatermarkOpacity(int value);

	/**
	 * Returns the value of the '<em><b>Watermark Gravity</b></em>' attribute.
	 * The default value is <code>"center"</code>.
	 * The literals are from the enumeration {@link org.soluvas.image.TransformGravity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Watermark Gravity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Watermark Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #setWatermarkGravity(TransformGravity)
	 * @see org.soluvas.image.ImagePackage#getWatermarkLike_WatermarkGravity()
	 * @model default="center"
	 * @generated
	 */
	TransformGravity getWatermarkGravity();

	/**
	 * Sets the value of the '{@link org.soluvas.image.WatermarkLike#getWatermarkGravity <em>Watermark Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Watermark Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #getWatermarkGravity()
	 * @generated
	 */
	void setWatermarkGravity(TransformGravity value);

} // WatermarkLike
