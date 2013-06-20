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

} // WatermarkLike
