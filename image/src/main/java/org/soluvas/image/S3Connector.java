/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>S3 Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Store images using Amazon S3 or S3 API-compatible servers such as Ceph, Parkplace, Boardwalk. fakes3 is not working due to it creating folders, not actually storing files.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getS3Connector()
 * @model
 * @generated
 */
public interface S3Connector extends ImageConnector {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void destroy();
} // S3Connector
