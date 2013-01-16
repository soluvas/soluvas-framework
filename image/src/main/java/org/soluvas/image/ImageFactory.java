/**
 */
package org.soluvas.image;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage
 * @generated
 */
public interface ImageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImageFactory eINSTANCE = org.soluvas.image.impl.ImageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>S3 Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>S3 Connector</em>'.
	 * @generated
	 */
	S3Connector createS3Connector();

	/**
	 * Returns a new object of class '<em>Blitline Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blitline Transformer</em>'.
	 * @generated
	 */
	BlitlineTransformer createBlitlineTransformer();

	/**
	 * Returns a new object of class '<em>Dav Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dav Connector</em>'.
	 * @generated
	 */
	DavConnector createDavConnector();

	/**
	 * Returns a new object of class '<em>Thumbnailator Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thumbnailator Transformer</em>'.
	 * @generated
	 */
	ThumbnailatorTransformer createThumbnailatorTransformer();

	/**
	 * Returns a new object of class '<em>Uploaded Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uploaded Image</em>'.
	 * @generated
	 */
	UploadedImage createUploadedImage();

	/**
	 * Returns a new object of class '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	ImageManager createImageManager();

	/**
	 * Returns a new object of class '<em>Resize To Fit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resize To Fit</em>'.
	 * @generated
	 */
	ResizeToFit createResizeToFit();

	/**
	 * Returns a new object of class '<em>Resize To Fill</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resize To Fill</em>'.
	 * @generated
	 */
	ResizeToFill createResizeToFill();

	/**
	 * Returns a new object of class '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variant</em>'.
	 * @generated
	 */
	ImageVariant createImageVariant();

	/**
	 * Returns a new object of class '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image</em>'.
	 * @generated
	 */
	Image createImage();

	/**
	 * Returns a new object of class '<em>Styled Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Styled Image</em>'.
	 * @generated
	 */
	StyledImage createStyledImage();

	/**
	 * Returns a new object of class '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catalog</em>'.
	 * @generated
	 */
	ImageCatalog createImageCatalog();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImagePackage getImagePackage();

} //ImageFactory
