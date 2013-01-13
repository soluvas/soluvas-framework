/**
 */
package org.soluvas.image;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uploaded Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.UploadedImage#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getOriginUri <em>Origin Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getUploadedImage()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface UploadedImage extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Public URI, usually CDN. This may be cached, so it's not a good fit for input to ImageTransformer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Origin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URI for direct access to object storage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Origin Uri</em>' attribute.
	 * @see #setOriginUri(String)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_OriginUri()
	 * @model
	 * @generated
	 */
	String getOriginUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getOriginUri <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Uri</em>' attribute.
	 * @see #getOriginUri()
	 * @generated
	 */
	void setOriginUri(String value);

} // UploadedImage
