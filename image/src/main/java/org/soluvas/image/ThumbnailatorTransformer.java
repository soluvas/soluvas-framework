/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thumbnailator Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Thumbnailator will use this to get the origin URI and download the  image, before transforming it locally.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.ThumbnailatorTransformer#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getThumbnailatorTransformer()
 * @model
 * @generated
 */
public interface ThumbnailatorTransformer extends ImageTransformer {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Where to upload transformed images.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see org.soluvas.image.ImagePackage#getThumbnailatorTransformer_Destination()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	ImageConnector getDestination();

} // ThumbnailatorTransformer
