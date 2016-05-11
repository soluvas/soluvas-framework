/**
 */
package org.soluvas.image.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.commons.Describable;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.Revisionable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.image.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage
 * @generated
 */
public class ImageSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImagePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageSwitch() {
		if (modelPackage == null) {
			modelPackage = ImagePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImagePackage.IMAGE_CONNECTOR: {
				ImageConnector imageConnector = (ImageConnector)theEObject;
				T result = caseImageConnector(imageConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.DAV_CONNECTOR: {
				DavConnector davConnector = (DavConnector)theEObject;
				T result = caseDavConnector(davConnector);
				if (result == null) result = caseImageConnector(davConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.S3_CONNECTOR: {
				S3Connector s3Connector = (S3Connector)theEObject;
				T result = caseS3Connector(s3Connector);
				if (result == null) result = caseImageConnector(s3Connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_TRANSFORMER: {
				ImageTransformer imageTransformer = (ImageTransformer)theEObject;
				T result = caseImageTransformer(imageTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.BLITLINE_TRANSFORMER: {
				BlitlineTransformer blitlineTransformer = (BlitlineTransformer)theEObject;
				T result = caseBlitlineTransformer(blitlineTransformer);
				if (result == null) result = caseImageTransformer(blitlineTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.THUMBNAILATOR_TRANSFORMER: {
				ThumbnailatorTransformer thumbnailatorTransformer = (ThumbnailatorTransformer)theEObject;
				T result = caseThumbnailatorTransformer(thumbnailatorTransformer);
				if (result == null) result = caseImageTransformer(thumbnailatorTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.UPLOADED_IMAGE: {
				UploadedImage uploadedImage = (UploadedImage)theEObject;
				T result = caseUploadedImage(uploadedImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_MANAGER: {
				ImageManager imageManager = (ImageManager)theEObject;
				T result = caseImageManager(imageManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_TRANSFORM: {
				ImageTransform imageTransform = (ImageTransform)theEObject;
				T result = caseImageTransform(imageTransform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.RESIZE_TO_FIT: {
				ResizeToFit resizeToFit = (ResizeToFit)theEObject;
				T result = caseResizeToFit(resizeToFit);
				if (result == null) result = caseImageTransform(resizeToFit);
				if (result == null) result = caseDimensionLike(resizeToFit);
				if (result == null) result = caseWatermarkLike(resizeToFit);
				if (result == null) result = caseOverlayLike(resizeToFit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.RESIZE_TO_FILL: {
				ResizeToFill resizeToFill = (ResizeToFill)theEObject;
				T result = caseResizeToFill(resizeToFill);
				if (result == null) result = caseImageTransform(resizeToFill);
				if (result == null) result = caseDimensionLike(resizeToFill);
				if (result == null) result = caseWatermarkLike(resizeToFill);
				if (result == null) result = caseOverlayLike(resizeToFill);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.DIMENSION_LIKE: {
				DimensionLike dimensionLike = (DimensionLike)theEObject;
				T result = caseDimensionLike(dimensionLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_VARIANT: {
				ImageVariant imageVariant = (ImageVariant)theEObject;
				T result = caseImageVariant(imageVariant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE: {
				Image image = (Image)theEObject;
				T result = caseImage(image);
				if (result == null) result = caseIdentifiable(image);
				if (result == null) result = caseNameContainer(image);
				if (result == null) result = caseSchemaVersionable(image);
				if (result == null) result = caseTimestamped(image);
				if (result == null) result = caseDimensionLike(image);
				if (result == null) result = caseNameable(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.STYLED_IMAGE: {
				StyledImage styledImage = (StyledImage)theEObject;
				T result = caseStyledImage(styledImage);
				if (result == null) result = caseSchemaVersionable(styledImage);
				if (result == null) result = caseDimensionLike(styledImage);
				if (result == null) result = caseNameContainer(styledImage);
				if (result == null) result = caseTimestamped(styledImage);
				if (result == null) result = caseNameable(styledImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_CATALOG: {
				ImageCatalog imageCatalog = (ImageCatalog)theEObject;
				T result = caseImageCatalog(imageCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_MAGICK_TRANSFORMER: {
				ImageMagickTransformer imageMagickTransformer = (ImageMagickTransformer)theEObject;
				T result = caseImageMagickTransformer(imageMagickTransformer);
				if (result == null) result = caseImageTransformer(imageMagickTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.FOLDER_CONNECTOR: {
				FolderConnector folderConnector = (FolderConnector)theEObject;
				T result = caseFolderConnector(folderConnector);
				if (result == null) result = caseImageConnector(folderConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.DISPLAY_IMAGE: {
				DisplayImage displayImage = (DisplayImage)theEObject;
				T result = caseDisplayImage(displayImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.STYLED_IMAGE_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, StyledImage> styledImageEntry = (Map.Entry<String, StyledImage>)theEObject;
				T result = caseStyledImageEntry(styledImageEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.WATERMARK_LIKE: {
				WatermarkLike watermarkLike = (WatermarkLike)theEObject;
				T result = caseWatermarkLike(watermarkLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.MEDIA: {
				Media media = (Media)theEObject;
				T result = caseMedia(media);
				if (result == null) result = caseIdentifiable(media);
				if (result == null) result = caseRevisionable(media);
				if (result == null) result = caseTimestamped(media);
				if (result == null) result = caseNameContainer(media);
				if (result == null) result = caseDescribable(media);
				if (result == null) result = caseNameable(media);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.MEDIA_ATTACHMENT: {
				MediaAttachment mediaAttachment = (MediaAttachment)theEObject;
				T result = caseMediaAttachment(mediaAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.MEDIA_ATTACHMENT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, MediaAttachment> mediaAttachmentEntry = (Map.Entry<String, MediaAttachment>)theEObject;
				T result = caseMediaAttachmentEntry(mediaAttachmentEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.OVERLAY_LIKE: {
				OverlayLike overlayLike = (OverlayLike)theEObject;
				T result = caseOverlayLike(overlayLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageConnector(ImageConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>S3 Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>S3 Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseS3Connector(S3Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blitline Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blitline Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlitlineTransformer(BlitlineTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dav Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dav Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDavConnector(DavConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageTransformer(ImageTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thumbnailator Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thumbnailator Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThumbnailatorTransformer(ThumbnailatorTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uploaded Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uploaded Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUploadedImage(UploadedImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageManager(ImageManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageTransform(ImageTransform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resize To Fit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resize To Fit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResizeToFit(ResizeToFit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resize To Fill</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resize To Fill</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResizeToFill(ResizeToFill object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimensionLike(DimensionLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageVariant(ImageVariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Styled Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Styled Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyledImage(StyledImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageCatalog(ImageCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Magick Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Magick Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageMagickTransformer(ImageMagickTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderConnector(FolderConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayImage(DisplayImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Styled Image Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Styled Image Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyledImageEntry(Map.Entry<String, StyledImage> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Watermark Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Watermark Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWatermarkLike(WatermarkLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Media</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMedia(Media object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Media Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediaAttachment(MediaAttachment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Media Attachment Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Attachment Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediaAttachmentEntry(Map.Entry<String, MediaAttachment> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overlay Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overlay Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverlayLike(OverlayLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameContainer(NameContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Versionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Versionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchemaVersionable(SchemaVersionable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timestamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timestamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimestamped(Timestamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revisionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revisionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionable(Revisionable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Describable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Describable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescribable(Describable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ImageSwitch
