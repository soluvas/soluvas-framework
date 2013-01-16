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
 *   <li>{@link org.soluvas.image.UploadedImage#getStyleCode <em>Style Code</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getStyleVariant <em>Style Variant</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getWidth <em>Width</em>}</li>
 *   <li>{@link org.soluvas.image.UploadedImage#getHeight <em>Height</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Style Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Code</em>' attribute.
	 * @see #setStyleCode(String)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_StyleCode()
	 * @model
	 * @generated
	 */
	String getStyleCode();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getStyleCode <em>Style Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Code</em>' attribute.
	 * @see #getStyleCode()
	 * @generated
	 */
	void setStyleCode(String value);

	/**
	 * Returns the value of the '<em><b>Style Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Variant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Variant</em>' attribute.
	 * @see #setStyleVariant(String)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_StyleVariant()
	 * @model
	 * @generated
	 */
	String getStyleVariant();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getStyleVariant <em>Style Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Variant</em>' attribute.
	 * @see #getStyleVariant()
	 * @generated
	 */
	void setStyleVariant(String value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * File size in bytes. A transformer like Blitlines is unable to provide this information immediately, an enhanced Blitlines transformer can update the size independently and asynchronously.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Long)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_Size()
	 * @model
	 * @generated
	 */
	Long getSize();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Long value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Width in pixels, useful for IMG tag.
	 * 
	 * Note: Connectors won't return this, but Transformers would.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_Width()
	 * @model
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Height in pixels, useful for IMG tag.
	 * 
	 * Note: Connectors won't return this, but Transformers would.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.soluvas.image.ImagePackage#getUploadedImage_Height()
	 * @model
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.soluvas.image.UploadedImage#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

} // UploadedImage
