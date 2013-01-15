/**
 */
package org.soluvas.image;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.ImageTransformer#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getImageTransformer()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface ImageTransformer extends SerializableEObject {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Source image connector.
	 * 
	 * Thumbnailator will use this to get the origin URI and download the  image, before transforming it locally.
	 * 
	 * Blitline will use it to get the origin URI, but processing will be done by Blitline itself.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see org.soluvas.image.ImagePackage#getImageTransformer_Source()
	 * @model changeable="false"
	 * @generated
	 */
	ImageConnector getSource();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transform the image and saves it to the configured destination. The mechanism to assign destination is transformer-specific.
	 * Thumbnailator saves it to a file and then uploads it using an ImageConnector. Blitline saves directly to an S3 bucket.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void transform(ImageVariant sourceVariant, ImageTransform imageTransform, ImageVariant destVariant);
} // ImageTransformer
