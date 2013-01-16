/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.image.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImageFactoryImpl extends EFactoryImpl implements ImageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImageFactory init() {
		try {
			ImageFactory theImageFactory = (ImageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/image/1.0"); 
			if (theImageFactory != null) {
				return theImageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ImagePackage.DAV_CONNECTOR: return (EObject)createDavConnector();
			case ImagePackage.S3_CONNECTOR: return (EObject)createS3Connector();
			case ImagePackage.BLITLINE_TRANSFORMER: return (EObject)createBlitlineTransformer();
			case ImagePackage.THUMBNAILATOR_TRANSFORMER: return (EObject)createThumbnailatorTransformer();
			case ImagePackage.UPLOADED_IMAGE: return (EObject)createUploadedImage();
			case ImagePackage.IMAGE_MANAGER: return (EObject)createImageManager();
			case ImagePackage.RESIZE_TO_FIT: return (EObject)createResizeToFit();
			case ImagePackage.RESIZE_TO_FILL: return (EObject)createResizeToFill();
			case ImagePackage.IMAGE_VARIANT: return (EObject)createImageVariant();
			case ImagePackage.IMAGE: return (EObject)createImage();
			case ImagePackage.STYLED_IMAGE: return (EObject)createStyledImage();
			case ImagePackage.IMAGE_CATALOG: return (EObject)createImageCatalog();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ImagePackage.IMAGE_TRANSFORM_TYPE:
				return createImageTransformTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ImagePackage.IMAGE_TRANSFORM_TYPE:
				return convertImageTransformTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public S3Connector createS3Connector() {
		S3ConnectorImpl s3Connector = new S3ConnectorImpl();
		return s3Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlitlineTransformer createBlitlineTransformer() {
		BlitlineTransformerImpl blitlineTransformer = new BlitlineTransformerImpl();
		return blitlineTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DavConnector createDavConnector() {
		DavConnectorImpl davConnector = new DavConnectorImpl();
		return davConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThumbnailatorTransformer createThumbnailatorTransformer() {
		ThumbnailatorTransformerImpl thumbnailatorTransformer = new ThumbnailatorTransformerImpl();
		return thumbnailatorTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadedImage createUploadedImage() {
		UploadedImageImpl uploadedImage = new UploadedImageImpl();
		return uploadedImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageManager createImageManager() {
		ImageManagerImpl imageManager = new ImageManagerImpl();
		return imageManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResizeToFit createResizeToFit() {
		ResizeToFitImpl resizeToFit = new ResizeToFitImpl();
		return resizeToFit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResizeToFill createResizeToFill() {
		ResizeToFillImpl resizeToFill = new ResizeToFillImpl();
		return resizeToFill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageVariant createImageVariant() {
		ImageVariantImpl imageVariant = new ImageVariantImpl();
		return imageVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyledImage createStyledImage() {
		StyledImageImpl styledImage = new StyledImageImpl();
		return styledImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageCatalog createImageCatalog() {
		ImageCatalogImpl imageCatalog = new ImageCatalogImpl();
		return imageCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageTransformType createImageTransformTypeFromString(EDataType eDataType, String initialValue) {
		ImageTransformType result = ImageTransformType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImageTransformTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImagePackage getImagePackage() {
		return (ImagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImagePackage getPackage() {
		return ImagePackage.eINSTANCE;
	}

} //ImageFactoryImpl
