/**
 */
package org.soluvas.image;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.ImageTransformer#getExecutor <em>Executor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getImageTransformer()
 * @model abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface ImageTransformer extends SerializableEObject {

	/**
	 * Returns the value of the '<em><b>Executor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executor</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImageTransformer_Executor()
	 * @model dataType="org.soluvas.commons.ListeningExecutorService" required="true" transient="true" changeable="false"
	 * @generated
	 */
	ListeningExecutorService getExecutor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transform the image and saves it to the configured destination. The mechanism to assign destination is transformer-specific.
	 * Thumbnailator saves it to a file and then uploads it using an ImageConnector. Blitline saves directly to an S3 bucket.
	 * 
	 * source shouldn't a field, it should be parameter to transform, so we can reuse the same blitline transformer multiple times.
	 * 
	 * sourceFile can be null. If filled, that means it's just being uploaded and available locally. If null, that means the file can only be accessed using ImageConnector.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.ListenableFuture<org.soluvas.commons.List<org.soluvas.image.UploadedImage>>" sourceFileDataType="org.soluvas.commons.File"
	 * @generated
	 */
	ListenableFuture<List<UploadedImage>> transform(ImageConnector source, File sourceFile, String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms);
} // ImageTransformer
