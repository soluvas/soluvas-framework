/**
 */
package org.soluvas.image;

import java.io.File;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overlay Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Watermark information if the transform supports watermark operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.OverlayLike#getOverlayFile <em>Overlay File</em>}</li>
 *   <li>{@link org.soluvas.image.OverlayLike#getOverlayGravity <em>Overlay Gravity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getOverlayLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OverlayLike extends EObject {
	/**
	 * Returns the value of the '<em><b>Overlay File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Watermark file to be used. If null, no watermark will be overlaid.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Overlay File</em>' attribute.
	 * @see #setOverlayFile(File)
	 * @see org.soluvas.image.ImagePackage#getOverlayLike_OverlayFile()
	 * @model dataType="org.soluvas.commons.File"
	 * @generated
	 */
	File getOverlayFile();

	/**
	 * Sets the value of the '{@link org.soluvas.image.OverlayLike#getOverlayFile <em>Overlay File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overlay File</em>' attribute.
	 * @see #getOverlayFile()
	 * @generated
	 */
	void setOverlayFile(File value);

	/**
	 * Returns the value of the '<em><b>Overlay Gravity</b></em>' attribute.
	 * The default value is <code>"center"</code>.
	 * The literals are from the enumeration {@link org.soluvas.image.TransformGravity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overlay Gravity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overlay Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #setOverlayGravity(TransformGravity)
	 * @see org.soluvas.image.ImagePackage#getOverlayLike_OverlayGravity()
	 * @model default="center"
	 * @generated
	 */
	TransformGravity getOverlayGravity();

	/**
	 * Sets the value of the '{@link org.soluvas.image.OverlayLike#getOverlayGravity <em>Overlay Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overlay Gravity</em>' attribute.
	 * @see org.soluvas.image.TransformGravity
	 * @see #getOverlayGravity()
	 * @generated
	 */
	void setOverlayGravity(TransformGravity value);

} // OverlayLike
