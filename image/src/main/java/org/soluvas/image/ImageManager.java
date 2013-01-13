/**
 */
package org.soluvas.image;

import org.soluvas.commons.Gender;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getImageManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface ImageManager extends SerializableEObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getDefaultPhotoId(Gender gender);

} // ImageManager
