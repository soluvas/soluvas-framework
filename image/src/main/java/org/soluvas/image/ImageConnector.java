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
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.ImageConnector#getHiUriTemplate <em>Hi Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.ImageConnector#getLoUriTemplate <em>Lo Uri Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getImageConnector()
 * @model abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface ImageConnector extends SerializableEObject {

	/**
	 * Returns the value of the '<em><b>Hi Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URI template for 'hi' (original) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.
	 * 
	 * Variables are: namespace, styleCode, imageId, styleVariant, ext.
	 * 
	 * return "http://cdn.alias/" + "prefix/" + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hi Uri Template</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImageConnector_HiUriTemplate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getHiUriTemplate();

	/**
	 * Returns the value of the '<em><b>Lo Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URI template for 'lo' (derived) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.
	 * 
	 * Variables are: namespace, styleCode, imageId, styleVariant, ext.
	 * 
	 * return "http://origin.alias/" + "prefix/" + "{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}";
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lo Uri Template</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImageConnector_LoUriTemplate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getLoUriTemplate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model fileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	UploadedImage upload(String namespace, String imageId, String styleCode, String extension, File file, String contentType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void delete(String namespace, String imageId, String styleCode, String extension);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Download the object from the object storage. Usually via HTTP, but the actual mechanism is encapsulated.
	 * <!-- end-model-doc -->
	 * @model fileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	boolean download(String namespace, String imageId, String styleCode, String extension, File file);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the public (optionally CDN) URI of the image.
	 * 
	 * This simply expands the hiUriTemplate or loUriTemplate, depending on styleCode.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String getUri(String namespace, String imageId, String styleCode, String styleVariant, String extension);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the public origin URI (never uses CDN) of the image.
	 * 
	 * The default implementation uses getUri(), but some implementations, like S3Connector, will return the S3 alias for the origin URI (not CloudFront CDN).
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String getOriginUri(String namespace, String imageId, String styleCode, String styleVariant, String extension);
} // ImageConnector
