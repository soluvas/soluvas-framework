/**
 */
package org.soluvas.image;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
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
 *   <li>{@link org.soluvas.image.ImageConnector#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.soluvas.image.ImageConnector#getExecutor <em>Executor</em>}</li>
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
	 * Returns the value of the '<em><b>Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URI template for images (both hi=original and lo=derived), optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.
	 * 
	 * Variables are: namespace, styleCode, imageId, styleVariant, extension.
	 * 
	 * return "http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uri Template</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImageConnector_UriTemplate()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getUriTemplate();

	/**
	 * Returns the value of the '<em><b>Executor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executor</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImageConnector_Executor()
	 * @model dataType="org.soluvas.commons.ListeningExecutorService" required="true" transient="true" changeable="false"
	 * @generated
	 */
	ListeningExecutorService getExecutor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Note: Use File, because if uploading using InputStream, can throw org.apache.http.client.NonRepeatableRequestException: Cannot retry request with a non-repeatable request entity; because InputStream can only be read once.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.ListenableFuture<org.soluvas.image.UploadedImage>" fileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	ListenableFuture<UploadedImage> upload(String namespace, String imageId, String styleCode, String styleVariant, String extension, File file, String contentType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Download the object from the object storage. Usually via HTTP, but the actual mechanism is encapsulated.
	 * <!-- end-model-doc -->
	 * @model fileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	boolean download(String namespace, String imageId, String styleCode, String styleVariant, String extension, File file);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void delete(String namespace, String imageId, String styleCode, String styleVariant, String extension);

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
