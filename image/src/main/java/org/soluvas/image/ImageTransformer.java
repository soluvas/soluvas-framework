/**
 */
package org.soluvas.image;

import java.util.List;
import java.util.Map;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getImageTransformer()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface ImageTransformer extends SerializableEObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transform the image and saves it to the configured destination. The mechanism to assign destination is transformer-specific.
	 * Thumbnailator saves it to a file and then uploads it using an ImageConnector. Blitline saves directly to an S3 bucket.
	 * 
	 * source shouldn't a field, it should be parameter to transform, so we can reuse the same blitline transformer multiple times.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.List<org.soluvas.image.UploadedImage>" many="false"
	 * @generated
	 */
	List<UploadedImage> transform(ImageConnector source, String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms);
} // ImageTransformer
