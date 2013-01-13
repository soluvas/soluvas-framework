/**
 */
package org.soluvas.image;

import java.io.File;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getImageConnector()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface ImageConnector extends SerializableEObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model fileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	UploadedImage upload(String namespace, String imageId, String styleCode, String extension, File file, String contentType);
} // ImageConnector
