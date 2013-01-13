/**
 */
package org.soluvas.image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blitline Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Processes using Blitline. The source image must be publicly hosted, for example using S3.
 * 
 * The destination image is directly written into an S3 bucket. Make sure to set the Canonical ID, see http://blog.blitline.com/post/32296310740/canonical-id-s3-permissions
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer()
 * @model
 * @generated
 */
public interface BlitlineTransformer extends ImageTransformer {
} // BlitlineTransformer
