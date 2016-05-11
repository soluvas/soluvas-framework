/**
 */
package org.soluvas.image.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.image.BlitlineTransformer;
import org.soluvas.image.DavConnector;
import org.soluvas.image.DimensionLike;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.DuplicateIdHandling;
import org.soluvas.image.FileExport;
import org.soluvas.image.FolderConnector;
import org.soluvas.image.Image;
import org.soluvas.image.ImageCatalog;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImageMagickTransformer;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageStyle;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformType;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageType;
import org.soluvas.image.ImageTypes;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.Media;
import org.soluvas.image.MediaAttachment;
import org.soluvas.image.MediaStatus;
import org.soluvas.image.OverlayLike;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.ResizeToFit;
import org.soluvas.image.S3Connector;
import org.soluvas.image.StyledImage;
import org.soluvas.image.ThumbnailatorTransformer;
import org.soluvas.image.TransformGravity;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.WatermarkLike;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.ldap.SocialPerson;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImagePackageImpl extends EPackageImpl implements ImagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageConnectorEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass s3ConnectorEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blitlineTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass davConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thumbnailatorTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uploadedImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageTransformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resizeToFitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resizeToFillEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageVariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styledImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageMagickTransformerEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderConnectorEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayImageEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styledImageEntryEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass watermarkLikeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaAttachmentEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediaAttachmentEntryEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass overlayLikeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum imageTransformTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fileExportEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum duplicateIdHandlingEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transformGravityEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum imageTypesEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum imageStylesEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mediaStatusEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageRepositoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageTypeEDataType = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageStyleEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.soluvas.image.ImagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImagePackageImpl() {
		super(eNS_URI, ImageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ImagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImagePackage init() {
		if (isInited) return (ImagePackage)EPackage.Registry.INSTANCE.getEPackage(ImagePackage.eNS_URI);

		// Obtain or create and register package
		ImagePackageImpl theImagePackage = (ImagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImagePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImagePackage.createPackageContents();

		// Initialize created meta-data
		theImagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImagePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImagePackage.eNS_URI, theImagePackage);
		return theImagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageConnector() {
		return imageConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageConnector_HiUriTemplate() {
		return (EAttribute)imageConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageConnector_UriTemplate() {
		return (EAttribute)imageConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageConnector_Executor() {
		return (EAttribute)imageConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getS3Connector() {
		return s3ConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_CanonicalUserId() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_Bucket() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_TenantId() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_TenantEnv() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_OriginAlias() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getS3Connector_CdnAlias() {
		return (EAttribute)s3ConnectorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlitlineTransformer() {
		return blitlineTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_ApplicationId() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_Bucket() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_TenantId() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_TenantEnv() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_CdnAlias() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_KeyTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_UriTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBlitlineTransformer_OriginUriTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDavConnector() {
		return davConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageTransformer() {
		return imageTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageTransformer_Executor() {
		return (EAttribute)imageTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThumbnailatorTransformer() {
		return thumbnailatorTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getThumbnailatorTransformer_Destination() {
		return (EReference)thumbnailatorTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUploadedImage() {
		return uploadedImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_Uri() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_OriginUri() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_StyleCode() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_StyleVariant() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_Extension() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_Size() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_Width() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUploadedImage_Height() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageManager() {
		return imageManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageTransform() {
		return imageTransformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResizeToFit() {
		return resizeToFitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResizeToFit_OnlyShrinkLarger() {
		return (EAttribute)resizeToFitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResizeToFill() {
		return resizeToFillEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResizeToFill_Gravity() {
		return (EAttribute)resizeToFillEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResizeToFill_OnlyShrinkLarger() {
		return (EAttribute)resizeToFillEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDimensionLike() {
		return dimensionLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDimensionLike_Width() {
		return (EAttribute)dimensionLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDimensionLike_Height() {
		return (EAttribute)dimensionLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageVariant() {
		return imageVariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageVariant_StyleCode() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageVariant_StyleVariant() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageVariant_Extension() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImage() {
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImage_Styles() {
		return (EReference)imageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_SchemaVersion() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Uri() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_FileName() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_ContentType() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Size() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Created() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_OriginUri() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Extension() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImage_LinkedFile() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImage_OriginalFile() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStyledImage() {
		return styledImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_SchemaVersion() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_Code() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_Uri() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_Size() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_Variant() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_Extension() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_OriginUri() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStyledImage_ContentType() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyledImage_LinkedFile() {
		return (EAttribute)styledImageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageCatalog() {
		return imageCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImageCatalog_Images() {
		return (EReference)imageCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageMagickTransformer() {
		return imageMagickTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImageMagickTransformer_Destination() {
		return (EReference)imageMagickTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolderConnector() {
		return folderConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFolderConnector_Folder() {
		return (EAttribute)folderConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplayImage() {
		return displayImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayImage_Src() {
		return (EAttribute)displayImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayImage_Width() {
		return (EAttribute)displayImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayImage_Height() {
		return (EAttribute)displayImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayImage_Alt() {
		return (EAttribute)displayImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisplayImage_Title() {
		return (EAttribute)displayImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStyledImageEntry() {
		return styledImageEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStyledImageEntry_Key() {
		return (EAttribute)styledImageEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStyledImageEntry_Value() {
		return (EReference)styledImageEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWatermarkLike() {
		return watermarkLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWatermarkLike_WatermarkFile() {
		return (EAttribute)watermarkLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWatermarkLike_WatermarkOpacity() {
		return (EAttribute)watermarkLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWatermarkLike_WatermarkGravity() {
		return (EAttribute)watermarkLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMedia() {
		return mediaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedia_Type() {
		return (EAttribute)mediaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMedia_Status() {
		return (EAttribute)mediaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMedia_Attachments() {
		return (EReference)mediaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaAttachment() {
		return mediaAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachment_ContentType() {
		return (EAttribute)mediaAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachment_RevPos() {
		return (EAttribute)mediaAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachment_Digest() {
		return (EAttribute)mediaAttachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachment_Length() {
		return (EAttribute)mediaAttachmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachment_Stub() {
		return (EAttribute)mediaAttachmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediaAttachmentEntry() {
		return mediaAttachmentEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediaAttachmentEntry_Key() {
		return (EAttribute)mediaAttachmentEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediaAttachmentEntry_Value() {
		return (EReference)mediaAttachmentEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOverlayLike() {
		return overlayLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverlayLike_OverlayFile() {
		return (EAttribute)overlayLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverlayLike_OverlayGravity() {
		return (EAttribute)overlayLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getImageTransformType() {
		return imageTransformTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFileExport() {
		return fileExportEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDuplicateIdHandling() {
		return duplicateIdHandlingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransformGravity() {
		return transformGravityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImageTypes() {
		return imageTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImageStyles() {
		return imageStylesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMediaStatus() {
		return mediaStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageRepository() {
		return imageRepositoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageType() {
		return imageTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageStyle() {
		return imageStyleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageFactory getImageFactory() {
		return (ImageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		imageConnectorEClass = createEClass(IMAGE_CONNECTOR);
		createEAttribute(imageConnectorEClass, IMAGE_CONNECTOR__HI_URI_TEMPLATE);
		createEAttribute(imageConnectorEClass, IMAGE_CONNECTOR__URI_TEMPLATE);
		createEAttribute(imageConnectorEClass, IMAGE_CONNECTOR__EXECUTOR);

		davConnectorEClass = createEClass(DAV_CONNECTOR);

		s3ConnectorEClass = createEClass(S3_CONNECTOR);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__CANONICAL_USER_ID);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__BUCKET);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__TENANT_ID);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__TENANT_ENV);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__ORIGIN_ALIAS);
		createEAttribute(s3ConnectorEClass, S3_CONNECTOR__CDN_ALIAS);

		imageTransformerEClass = createEClass(IMAGE_TRANSFORMER);
		createEAttribute(imageTransformerEClass, IMAGE_TRANSFORMER__EXECUTOR);

		blitlineTransformerEClass = createEClass(BLITLINE_TRANSFORMER);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__APPLICATION_ID);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__BUCKET);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__TENANT_ID);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__TENANT_ENV);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__CDN_ALIAS);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__KEY_TEMPLATE);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__URI_TEMPLATE);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__ORIGIN_URI_TEMPLATE);

		thumbnailatorTransformerEClass = createEClass(THUMBNAILATOR_TRANSFORMER);
		createEReference(thumbnailatorTransformerEClass, THUMBNAILATOR_TRANSFORMER__DESTINATION);

		uploadedImageEClass = createEClass(UPLOADED_IMAGE);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__URI);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__ORIGIN_URI);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__STYLE_CODE);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__STYLE_VARIANT);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__EXTENSION);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__SIZE);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__WIDTH);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__HEIGHT);

		imageManagerEClass = createEClass(IMAGE_MANAGER);

		imageTransformEClass = createEClass(IMAGE_TRANSFORM);

		resizeToFitEClass = createEClass(RESIZE_TO_FIT);
		createEAttribute(resizeToFitEClass, RESIZE_TO_FIT__ONLY_SHRINK_LARGER);

		resizeToFillEClass = createEClass(RESIZE_TO_FILL);
		createEAttribute(resizeToFillEClass, RESIZE_TO_FILL__GRAVITY);
		createEAttribute(resizeToFillEClass, RESIZE_TO_FILL__ONLY_SHRINK_LARGER);

		dimensionLikeEClass = createEClass(DIMENSION_LIKE);
		createEAttribute(dimensionLikeEClass, DIMENSION_LIKE__WIDTH);
		createEAttribute(dimensionLikeEClass, DIMENSION_LIKE__HEIGHT);

		imageVariantEClass = createEClass(IMAGE_VARIANT);
		createEAttribute(imageVariantEClass, IMAGE_VARIANT__STYLE_CODE);
		createEAttribute(imageVariantEClass, IMAGE_VARIANT__STYLE_VARIANT);
		createEAttribute(imageVariantEClass, IMAGE_VARIANT__EXTENSION);

		imageEClass = createEClass(IMAGE);
		createEReference(imageEClass, IMAGE__STYLES);
		createEAttribute(imageEClass, IMAGE__SCHEMA_VERSION);
		createEAttribute(imageEClass, IMAGE__URI);
		createEAttribute(imageEClass, IMAGE__FILE_NAME);
		createEAttribute(imageEClass, IMAGE__CONTENT_TYPE);
		createEAttribute(imageEClass, IMAGE__SIZE);
		createEAttribute(imageEClass, IMAGE__CREATED);
		createEAttribute(imageEClass, IMAGE__ORIGIN_URI);
		createEAttribute(imageEClass, IMAGE__EXTENSION);
		createEAttribute(imageEClass, IMAGE__LINKED_FILE);
		createEAttribute(imageEClass, IMAGE__ORIGINAL_FILE);

		styledImageEClass = createEClass(STYLED_IMAGE);
		createEAttribute(styledImageEClass, STYLED_IMAGE__SCHEMA_VERSION);
		createEAttribute(styledImageEClass, STYLED_IMAGE__CODE);
		createEAttribute(styledImageEClass, STYLED_IMAGE__URI);
		createEAttribute(styledImageEClass, STYLED_IMAGE__SIZE);
		createEAttribute(styledImageEClass, STYLED_IMAGE__VARIANT);
		createEAttribute(styledImageEClass, STYLED_IMAGE__EXTENSION);
		createEAttribute(styledImageEClass, STYLED_IMAGE__ORIGIN_URI);
		createEAttribute(styledImageEClass, STYLED_IMAGE__CONTENT_TYPE);
		createEAttribute(styledImageEClass, STYLED_IMAGE__LINKED_FILE);

		imageCatalogEClass = createEClass(IMAGE_CATALOG);
		createEReference(imageCatalogEClass, IMAGE_CATALOG__IMAGES);

		imageMagickTransformerEClass = createEClass(IMAGE_MAGICK_TRANSFORMER);
		createEReference(imageMagickTransformerEClass, IMAGE_MAGICK_TRANSFORMER__DESTINATION);

		folderConnectorEClass = createEClass(FOLDER_CONNECTOR);
		createEAttribute(folderConnectorEClass, FOLDER_CONNECTOR__FOLDER);

		displayImageEClass = createEClass(DISPLAY_IMAGE);
		createEAttribute(displayImageEClass, DISPLAY_IMAGE__SRC);
		createEAttribute(displayImageEClass, DISPLAY_IMAGE__WIDTH);
		createEAttribute(displayImageEClass, DISPLAY_IMAGE__HEIGHT);
		createEAttribute(displayImageEClass, DISPLAY_IMAGE__ALT);
		createEAttribute(displayImageEClass, DISPLAY_IMAGE__TITLE);

		styledImageEntryEClass = createEClass(STYLED_IMAGE_ENTRY);
		createEAttribute(styledImageEntryEClass, STYLED_IMAGE_ENTRY__KEY);
		createEReference(styledImageEntryEClass, STYLED_IMAGE_ENTRY__VALUE);

		watermarkLikeEClass = createEClass(WATERMARK_LIKE);
		createEAttribute(watermarkLikeEClass, WATERMARK_LIKE__WATERMARK_FILE);
		createEAttribute(watermarkLikeEClass, WATERMARK_LIKE__WATERMARK_OPACITY);
		createEAttribute(watermarkLikeEClass, WATERMARK_LIKE__WATERMARK_GRAVITY);

		mediaEClass = createEClass(MEDIA);
		createEAttribute(mediaEClass, MEDIA__TYPE);
		createEAttribute(mediaEClass, MEDIA__STATUS);
		createEReference(mediaEClass, MEDIA__ATTACHMENTS);

		mediaAttachmentEClass = createEClass(MEDIA_ATTACHMENT);
		createEAttribute(mediaAttachmentEClass, MEDIA_ATTACHMENT__CONTENT_TYPE);
		createEAttribute(mediaAttachmentEClass, MEDIA_ATTACHMENT__REV_POS);
		createEAttribute(mediaAttachmentEClass, MEDIA_ATTACHMENT__DIGEST);
		createEAttribute(mediaAttachmentEClass, MEDIA_ATTACHMENT__LENGTH);
		createEAttribute(mediaAttachmentEClass, MEDIA_ATTACHMENT__STUB);

		mediaAttachmentEntryEClass = createEClass(MEDIA_ATTACHMENT_ENTRY);
		createEAttribute(mediaAttachmentEntryEClass, MEDIA_ATTACHMENT_ENTRY__KEY);
		createEReference(mediaAttachmentEntryEClass, MEDIA_ATTACHMENT_ENTRY__VALUE);

		overlayLikeEClass = createEClass(OVERLAY_LIKE);
		createEAttribute(overlayLikeEClass, OVERLAY_LIKE__OVERLAY_FILE);
		createEAttribute(overlayLikeEClass, OVERLAY_LIKE__OVERLAY_GRAVITY);

		// Create enums
		imageTransformTypeEEnum = createEEnum(IMAGE_TRANSFORM_TYPE);
		fileExportEEnum = createEEnum(FILE_EXPORT);
		duplicateIdHandlingEEnum = createEEnum(DUPLICATE_ID_HANDLING);
		transformGravityEEnum = createEEnum(TRANSFORM_GRAVITY);
		imageTypesEEnum = createEEnum(IMAGE_TYPES);
		imageStylesEEnum = createEEnum(IMAGE_STYLES);
		mediaStatusEEnum = createEEnum(MEDIA_STATUS);

		// Create data types
		imageRepositoryEDataType = createEDataType(IMAGE_REPOSITORY);
		imageTypeEDataType = createEDataType(IMAGE_TYPE);
		imageStyleEDataType = createEDataType(IMAGE_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		davConnectorEClass.getESuperTypes().add(this.getImageConnector());
		s3ConnectorEClass.getESuperTypes().add(this.getImageConnector());
		blitlineTransformerEClass.getESuperTypes().add(this.getImageTransformer());
		thumbnailatorTransformerEClass.getESuperTypes().add(this.getImageTransformer());
		resizeToFitEClass.getESuperTypes().add(this.getImageTransform());
		resizeToFitEClass.getESuperTypes().add(this.getDimensionLike());
		resizeToFitEClass.getESuperTypes().add(this.getWatermarkLike());
		resizeToFitEClass.getESuperTypes().add(this.getOverlayLike());
		resizeToFillEClass.getESuperTypes().add(this.getImageTransform());
		resizeToFillEClass.getESuperTypes().add(this.getDimensionLike());
		resizeToFillEClass.getESuperTypes().add(this.getWatermarkLike());
		resizeToFillEClass.getESuperTypes().add(this.getOverlayLike());
		imageEClass.getESuperTypes().add(theCommonsPackage.getIdentifiable());
		imageEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		imageEClass.getESuperTypes().add(theCommonsPackage.getSchemaVersionable());
		imageEClass.getESuperTypes().add(theCommonsPackage.getTimestamped());
		imageEClass.getESuperTypes().add(this.getDimensionLike());
		styledImageEClass.getESuperTypes().add(theCommonsPackage.getSchemaVersionable());
		styledImageEClass.getESuperTypes().add(this.getDimensionLike());
		styledImageEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		styledImageEClass.getESuperTypes().add(theCommonsPackage.getTimestamped());
		imageMagickTransformerEClass.getESuperTypes().add(this.getImageTransformer());
		folderConnectorEClass.getESuperTypes().add(this.getImageConnector());
		mediaEClass.getESuperTypes().add(theCommonsPackage.getIdentifiable());
		mediaEClass.getESuperTypes().add(theCommonsPackage.getRevisionable());
		mediaEClass.getESuperTypes().add(theCommonsPackage.getTimestamped());
		mediaEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		mediaEClass.getESuperTypes().add(theCommonsPackage.getDescribable());

		// Initialize classes and features; add operations and parameters
		initEClass(imageConnectorEClass, ImageConnector.class, "ImageConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageConnector_HiUriTemplate(), ecorePackage.getEString(), "hiUriTemplate", null, 0, 1, ImageConnector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageConnector_UriTemplate(), ecorePackage.getEString(), "uriTemplate", null, 0, 1, ImageConnector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageConnector_Executor(), theCommonsPackage.getListeningExecutorService(), "executor", null, 1, 1, ImageConnector.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(imageConnectorEClass, null, "upload", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "contentType", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theCommonsPackage.getListenableFuture());
		EGenericType g2 = createEGenericType(this.getUploadedImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(imageConnectorEClass, ecorePackage.getEBoolean(), "download", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, ecorePackage.getEString(), "getUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, ecorePackage.getEString(), "getOriginUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(imageConnectorEClass, null, "destroy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(davConnectorEClass, DavConnector.class, "DavConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(s3ConnectorEClass, S3Connector.class, "S3Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getS3Connector_CanonicalUserId(), ecorePackage.getEString(), "canonicalUserId", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getS3Connector_Bucket(), ecorePackage.getEString(), "bucket", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getS3Connector_TenantId(), ecorePackage.getEString(), "tenantId", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getS3Connector_TenantEnv(), ecorePackage.getEString(), "tenantEnv", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getS3Connector_OriginAlias(), ecorePackage.getEString(), "originAlias", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getS3Connector_CdnAlias(), ecorePackage.getEString(), "cdnAlias", null, 0, 1, S3Connector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageTransformerEClass, ImageTransformer.class, "ImageTransformer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageTransformer_Executor(), theCommonsPackage.getListeningExecutorService(), "executor", null, 1, 1, ImageTransformer.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(imageTransformerEClass, null, "transform", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageConnector(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "sourceFile", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageVariant(), "sourceVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(this.getImageTransform());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getImageVariant());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "transforms", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getListenableFuture());
		g2 = createEGenericType(theCommonsPackage.getList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getUploadedImage());
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		initEClass(blitlineTransformerEClass, BlitlineTransformer.class, "BlitlineTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlitlineTransformer_ApplicationId(), ecorePackage.getEString(), "applicationId", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_Bucket(), ecorePackage.getEString(), "bucket", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_TenantId(), ecorePackage.getEString(), "tenantId", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_TenantEnv(), ecorePackage.getEString(), "tenantEnv", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_CdnAlias(), ecorePackage.getEString(), "cdnAlias", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_KeyTemplate(), ecorePackage.getEString(), "keyTemplate", "{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_UriTemplate(), ecorePackage.getEString(), "uriTemplate", "http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_OriginUriTemplate(), ecorePackage.getEString(), "originUriTemplate", "http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thumbnailatorTransformerEClass, ThumbnailatorTransformer.class, "ThumbnailatorTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThumbnailatorTransformer_Destination(), this.getImageConnector(), null, "destination", null, 0, 1, ThumbnailatorTransformer.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uploadedImageEClass, UploadedImage.class, "UploadedImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUploadedImage_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_OriginUri(), ecorePackage.getEString(), "originUri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_StyleCode(), ecorePackage.getEString(), "styleCode", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_StyleVariant(), ecorePackage.getEString(), "styleVariant", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Size(), ecorePackage.getELongObject(), "size", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageManagerEClass, ImageManager.class, "ImageManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(imageManagerEClass, ecorePackage.getEString(), "getNoImageUri", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getEString(), "getDefaultPhotoId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getGender(), "gender", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getEString(), "getPersonIconUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getGender(), "gender", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getEString(), "getPersonPhotoUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getGender(), "gender", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getEString(), "getObjectPhotoUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getELong(), "export", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageRepository(), "imageRepo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "metadata", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFileExport(), "files", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "destFolder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, ecorePackage.getELong(), "importImages", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "srcFolder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "metadata", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFileExport(), "files", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageRepository(), "imageRepo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDuplicateIdHandling(), "duplicateIdHandling", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, this.getDisplayImage(), "getSafeImage", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, null, "getSafeImages", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getCollection());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(theCommonsPackage.getImageable());
		g2.setEUpperBound(g3);
		addEParameter(op, g1, "imageables", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDisplayImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(imageManagerEClass, null, "getSafeImagesById", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getCollection());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "imageIds", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDisplayImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(imageManagerEClass, this.getDisplayImage(), "getSafePersonPhoto", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "photoId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getGender(), "gender", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, this.getDisplayImage(), "getSafePersonPhoto", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getPersonLike(), "person", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageManagerEClass, null, "getSafePersonPhotos", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getCollection());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(theCommonsPackage.getPersonLike());
		g2.setEUpperBound(g3);
		addEParameter(op, g1, "people", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDisplayImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(imageManagerEClass, null, "getSafeSocialPersonPhotos", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "namespace", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getCollection());
		g2 = createEGenericType(theCommonsPackage.getPerson());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "people", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageStyle(), "style", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDisplayImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(imageManagerEClass, this.getImageRepository(), "getRepository", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageType(), "imageType", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(imageTransformEClass, ImageTransform.class, "ImageTransform", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resizeToFitEClass, ResizeToFit.class, "ResizeToFit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResizeToFit_OnlyShrinkLarger(), ecorePackage.getEBooleanObject(), "onlyShrinkLarger", null, 0, 1, ResizeToFit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resizeToFillEClass, ResizeToFill.class, "ResizeToFill", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResizeToFill_Gravity(), this.getTransformGravity(), "gravity", null, 0, 1, ResizeToFill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResizeToFill_OnlyShrinkLarger(), ecorePackage.getEBooleanObject(), "onlyShrinkLarger", null, 0, 1, ResizeToFill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionLikeEClass, DimensionLike.class, "DimensionLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimensionLike_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, DimensionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimensionLike_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, DimensionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageVariantEClass, ImageVariant.class, "ImageVariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageVariant_StyleCode(), ecorePackage.getEString(), "styleCode", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageVariant_StyleVariant(), ecorePackage.getEString(), "styleVariant", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageVariant_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImage_Styles(), this.getStyledImageEntry(), null, "styles", null, 0, -1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "2", 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Size(), ecorePackage.getELongObject(), "size", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Created(), theCommonsPackage.getDateTime(), "created", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_OriginUri(), ecorePackage.getEString(), "originUri", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_LinkedFile(), ecorePackage.getEString(), "linkedFile", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_OriginalFile(), theCommonsPackage.getFile(), "originalFile", null, 0, 1, Image.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styledImageEClass, StyledImage.class, "StyledImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyledImage_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "2", 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_Code(), ecorePackage.getEString(), "code", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_Size(), ecorePackage.getELongObject(), "size", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_Variant(), ecorePackage.getEString(), "variant", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_OriginUri(), ecorePackage.getEString(), "originUri", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStyledImage_LinkedFile(), ecorePackage.getEString(), "linkedFile", null, 0, 1, StyledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageCatalogEClass, ImageCatalog.class, "ImageCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageCatalog_Images(), this.getImage(), null, "images", null, 0, -1, ImageCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageMagickTransformerEClass, ImageMagickTransformer.class, "ImageMagickTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageMagickTransformer_Destination(), this.getImageConnector(), null, "destination", null, 0, 1, ImageMagickTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(folderConnectorEClass, FolderConnector.class, "FolderConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFolderConnector_Folder(), ecorePackage.getEString(), "folder", null, 1, 1, FolderConnector.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayImageEClass, DisplayImage.class, "DisplayImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisplayImage_Src(), ecorePackage.getEString(), "src", null, 1, 1, DisplayImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayImage_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, DisplayImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayImage_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, DisplayImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayImage_Alt(), ecorePackage.getEString(), "alt", null, 0, 1, DisplayImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDisplayImage_Title(), ecorePackage.getEString(), "title", null, 0, 1, DisplayImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styledImageEntryEClass, Map.Entry.class, "StyledImageEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStyledImageEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStyledImageEntry_Value(), this.getStyledImage(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(watermarkLikeEClass, WatermarkLike.class, "WatermarkLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWatermarkLike_WatermarkFile(), theCommonsPackage.getFile(), "watermarkFile", null, 0, 1, WatermarkLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWatermarkLike_WatermarkOpacity(), ecorePackage.getEInt(), "watermarkOpacity", "15", 0, 1, WatermarkLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWatermarkLike_WatermarkGravity(), this.getTransformGravity(), "watermarkGravity", "center", 0, 1, WatermarkLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaEClass, Media.class, "Media", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMedia_Type(), ecorePackage.getEString(), "type", "Media", 1, 1, Media.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMedia_Status(), this.getMediaStatus(), "status", null, 1, 1, Media.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMedia_Attachments(), this.getMediaAttachmentEntry(), null, "attachments", null, 0, -1, Media.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaAttachmentEClass, MediaAttachment.class, "MediaAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaAttachment_ContentType(), ecorePackage.getEString(), "contentType", null, 1, 1, MediaAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaAttachment_RevPos(), ecorePackage.getELong(), "revPos", null, 0, 1, MediaAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaAttachment_Digest(), ecorePackage.getEString(), "digest", null, 0, 1, MediaAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaAttachment_Length(), ecorePackage.getELong(), "length", null, 0, 1, MediaAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediaAttachment_Stub(), ecorePackage.getEBoolean(), "stub", null, 0, 1, MediaAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediaAttachmentEntryEClass, Map.Entry.class, "MediaAttachmentEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediaAttachmentEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediaAttachmentEntry_Value(), this.getMediaAttachment(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(overlayLikeEClass, OverlayLike.class, "OverlayLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOverlayLike_OverlayFile(), theCommonsPackage.getFile(), "overlayFile", null, 0, 1, OverlayLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOverlayLike_OverlayGravity(), this.getTransformGravity(), "overlayGravity", "center", 0, 1, OverlayLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(imageTransformTypeEEnum, ImageTransformType.class, "ImageTransformType");
		addEEnumLiteral(imageTransformTypeEEnum, ImageTransformType.RESIZE_TO_FIT);
		addEEnumLiteral(imageTransformTypeEEnum, ImageTransformType.RESIZE_TO_FILL);

		initEEnum(fileExportEEnum, FileExport.class, "FileExport");
		addEEnumLiteral(fileExportEEnum, FileExport.ORIGINAL);
		addEEnumLiteral(fileExportEEnum, FileExport.STYLE);
		addEEnumLiteral(fileExportEEnum, FileExport.ALL);

		initEEnum(duplicateIdHandlingEEnum, DuplicateIdHandling.class, "DuplicateIdHandling");
		addEEnumLiteral(duplicateIdHandlingEEnum, DuplicateIdHandling.SKIP);
		addEEnumLiteral(duplicateIdHandlingEEnum, DuplicateIdHandling.OVERWRITE);
		addEEnumLiteral(duplicateIdHandlingEEnum, DuplicateIdHandling.ADD);
		addEEnumLiteral(duplicateIdHandlingEEnum, DuplicateIdHandling.ERROR);

		initEEnum(transformGravityEEnum, TransformGravity.class, "TransformGravity");
		addEEnumLiteral(transformGravityEEnum, TransformGravity.CENTER);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.TOP_CENTER);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.BOTTOM_CENTER);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.CENTER_LEFT);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.CENTER_RIGHT);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.TOP_LEFT);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.TOP_RIGHT);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.BOTTOM_LEFT);
		addEEnumLiteral(transformGravityEEnum, TransformGravity.BOTTOM_RIGHT);

		initEEnum(imageTypesEEnum, ImageTypes.class, "ImageTypes");
		addEEnumLiteral(imageTypesEEnum, ImageTypes.PERSON);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.SHOP);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.PRODUCT);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.PLACE);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.TASK);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.ARTICLE);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.BANNER_SHOP);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.GALLERY);
		addEEnumLiteral(imageTypesEEnum, ImageTypes.CATEGORY);

		initEEnum(imageStylesEEnum, ImageStyles.class, "ImageStyles");
		addEEnumLiteral(imageStylesEEnum, ImageStyles.ORIGINAL);
		addEEnumLiteral(imageStylesEEnum, ImageStyles.THUMBNAIL);
		addEEnumLiteral(imageStylesEEnum, ImageStyles.SMALL);
		addEEnumLiteral(imageStylesEEnum, ImageStyles.NORMAL);
		addEEnumLiteral(imageStylesEEnum, ImageStyles.LARGE);

		initEEnum(mediaStatusEEnum, MediaStatus.class, "MediaStatus");
		addEEnumLiteral(mediaStatusEEnum, MediaStatus.DRAFT);
		addEEnumLiteral(mediaStatusEEnum, MediaStatus.BOOKED);
		addEEnumLiteral(mediaStatusEEnum, MediaStatus.VOID);

		// Initialize data types
		initEDataType(imageRepositoryEDataType, ImageRepository.class, "ImageRepository", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageTypeEDataType, ImageType.class, "ImageType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageStyleEDataType, ImageStyle.class, "ImageStyle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (imageConnectorEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Note: Use File, because if uploading using InputStream, can throw org.apache.http.client.NonRepeatableRequestException: Cannot retry request with a non-repeatable request entity; because InputStream can only be read once."
		   });	
		addAnnotation
		  (imageConnectorEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Download the object from the object storage. Usually via HTTP, but the actual mechanism is encapsulated."
		   });	
		addAnnotation
		  (imageConnectorEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Get the public (optionally CDN) URI of the image.\n\nThis simply expands the hiUriTemplate or loUriTemplate, depending on styleCode."
		   });	
		addAnnotation
		  (imageConnectorEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Get the public origin URI (never uses CDN) of the image.\n\nThe default implementation uses getUri(), but some implementations, like S3Connector, will return the S3 alias for the origin URI (not CloudFront CDN)."
		   });	
		addAnnotation
		  (imageConnectorEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Required to help {@link org.soluvas.commons.tenant.TenantBeans} detect whether this class is destroyable."
		   });	
		addAnnotation
		  (getImageConnector_HiUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'hi\' (original) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nreturn \"http://cdn.alias/\" + \"prefix/\" + \"{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}\";"
		   });	
		addAnnotation
		  (getImageConnector_UriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for images (both hi=original and lo=derived), optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, extension.\n\nreturn \"http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}\";\n"
		   });	
		addAnnotation
		  (davConnectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Store images using any WebDAV Protocol compatible server, such as Apache, nginx, Sling, Alfresco, Magnolia."
		   });	
		addAnnotation
		  (s3ConnectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Store images using Amazon S3 or S3 API-compatible servers such as Ceph, Parkplace, Boardwalk. fakes3 is not working due to it creating folders, not actually storing files."
		   });	
		addAnnotation
		  (imageTransformerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Transform the image and saves it to the configured destination. The mechanism to assign destination is transformer-specific.\nThumbnailator saves it to a file and then uploads it using an ImageConnector. Blitline saves directly to an S3 bucket.\n\nsource shouldn\'t a field, it should be parameter to transform, so we can reuse the same blitline transformer multiple times.\n\nsourceFile can be null. If filled, that means it\'s just being uploaded and available locally. If null, that means the file can only be accessed using ImageConnector."
		   });	
		addAnnotation
		  (blitlineTransformerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Processes using Blitline. The source image must be publicly hosted, for example using S3.\nBlitline will use source to get the origin URI, but processing will be done by Blitline itself.\n\nThe destination image is directly written into an S3 bucket.\n\nYou must have an S3 account and have permissions to change the policy on your bucket\nFor these instructions, you must use the Amazon AWS Console\nSee: http://www.blitline.com/docs/s3_permissions\n\nMake sure to set the Canonical ID, see http://blog.blitline.com/post/32296310740/canonical-id-s3-permissions\n\nWARNING: BlitlineTransformer currently does not support ResizeToFit especially with dynamic width/height (because need to either calculate dimensions or read the resulting image sizes via callback). Use ImageMagickTransformer instead if you need it."
		   });	
		addAnnotation
		  (getBlitlineTransformer_CdnAlias(), 
		   source, 
		   new String[] {
			 "documentation", "CDN alias (if available), e.g. pic.stg.berbatik.com."
		   });	
		addAnnotation
		  (getBlitlineTransformer_KeyTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "key template in URI template format.\n\nVariables are: tenantId, tenantEnv,\nnamespace, styleCode, imageId, styleVariant, extension.\n\nDefault is: \"{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}\";"
		   });	
		addAnnotation
		  (getBlitlineTransformer_UriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'lo\' (derived) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nDefault is: http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}"
		   });	
		addAnnotation
		  (getBlitlineTransformer_OriginUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'lo\' (derived) images, without CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nDefault is: http://{+alias}/{tenantId}_{tenantEnv}/{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}"
		   });	
		addAnnotation
		  (thumbnailatorTransformerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Thumbnailator will use this to get the origin URI and download the  image, before transforming it locally."
		   });	
		addAnnotation
		  (getThumbnailatorTransformer_Destination(), 
		   source, 
		   new String[] {
			 "documentation", "Where to upload transformed images."
		   });	
		addAnnotation
		  (getUploadedImage_Uri(), 
		   source, 
		   new String[] {
			 "documentation", "Public URI, usually CDN. This may be cached, so it\'s not a good fit for input to ImageTransformer."
		   });	
		addAnnotation
		  (getUploadedImage_OriginUri(), 
		   source, 
		   new String[] {
			 "documentation", "URI for direct access to object storage."
		   });	
		addAnnotation
		  (getUploadedImage_Size(), 
		   source, 
		   new String[] {
			 "documentation", "File size in bytes. A transformer like Blitline is unable to provide this information immediately, an enhanced Blitlines transformer can update the size independently and asynchronously"
		   });	
		addAnnotation
		  (getUploadedImage_Width(), 
		   source, 
		   new String[] {
			 "documentation", "Width in pixels, useful for IMG tag.\n\nNote: Connectors won\'t return this, but Transformers would."
		   });	
		addAnnotation
		  (getUploadedImage_Height(), 
		   source, 
		   new String[] {
			 "documentation", "Height in pixels, useful for IMG tag.\n\nNote: Connectors won\'t return this, but Transformers would."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Object / non-person missing image URI."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Returns the provided URI if specified. Otherwise, return the default photo ID based on given gender.\nIf gender is not known, will return unknown gender photo URI."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Return the non-object URI if not null, otherwise return the default non-object image URI."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Downloads all images and exports them to a folder."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "documentation", "Import from metadata file and images.\n\nCan\'t have \"import\" as name because it\'s a reserved keyword."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "documentation", "Gets the DisplayImage for an imageId & styleName in a specified repository."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "documentation", "Gets DisplayImages for [Identifiable & Imageable] & styleName in a specified repository.\nIf image is not available, use the default object noimage.\nReturns Map<entityId, DisplayImage>.\nNote the parameter must implement both Identifiable and Imageable."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "documentation", "Gets DisplayImages for image IDs & styleName in a specified repository.\nIf image is not available, use the default object noimage.\nReturns Map<imageId, DisplayImage>."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "documentation", "Gets the DisplayImage for an imageId & styleName in a specified repository. If image is not available, use the gender to select the representation."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(11), 
		   source, 
		   new String[] {
			 "documentation", "Gets the DisplayImage for an imageId & styleName in a specified repository. If image is not available, use the gender to select the representation."
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(12), 
		   source, 
		   new String[] {
			 "documentation", "Gets DisplayImages for SocialPersons & styleName in a specified repository.\nIf image is not available, use the gender to select the representation.\nReturns Map<personId, DisplayImage>"
		   });	
		addAnnotation
		  (imageManagerEClass.getEOperations().get(13), 
		   source, 
		   new String[] {
			 "documentation", "Gets DisplayImages for SocialPersons & styleName in a specified repository.\nIf image is not available, use the gender to select the representation.\nReturns Map<personId, DisplayImage>"
		   });	
		addAnnotation
		  (imageTransformTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create thumbnail with same aspect ratio."
		   });	
		addAnnotation
		  (imageTransformTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Fill thumbnail dimension."
		   });	
		addAnnotation
		  (resizeToFitEClass, 
		   source, 
		   new String[] {
			 "documentation", "At least width or height must be present.\n\nIf both width and height are present, the image will be constrained to specified dimensions.\nIf only width or height are present, the image will be resized proportionally to conform to the specified width/height."
		   });	
		addAnnotation
		  (getResizeToFit_OnlyShrinkLarger(), 
		   source, 
		   new String[] {
			 "documentation", "If true, only shrink larger images, but do not enlarge small images.\nIf false, both shrinking and enlarging are performed."
		   });	
		addAnnotation
		  (resizeToFillEClass, 
		   source, 
		   new String[] {
			 "documentation", "Resize the image to fit within the specified dimensions while retaining the aspect ratio of the original image. If necessary, crop the image in the larger dimension\n\nCommon English Translation: This is probably the crop you want if you want to cut a center piece out of a photo and use it as a thumbnail. This wont do any scaling, only cut out the center (by default) to your defined size.\n\n\"name\": \"resize_to_fill\",\n\"params\" : { \"width\" : 40, \"height\" : 40 }"
		   });	
		addAnnotation
		  (getResizeToFill_Gravity(), 
		   source, 
		   new String[] {
			 "documentation", "Location of crop (defaults to \'CenterGravity\')"
		   });	
		addAnnotation
		  (getResizeToFill_OnlyShrinkLarger(), 
		   source, 
		   new String[] {
			 "documentation", "Don\u2019t upsize image (defaults to false)"
		   });	
		addAnnotation
		  (getDimensionLike_Width(), 
		   source, 
		   new String[] {
			 "documentation", "Width of desired image"
		   });	
		addAnnotation
		  (getDimensionLike_Height(), 
		   source, 
		   new String[] {
			 "documentation", "Height of desired image"
		   });	
		addAnnotation
		  (imageEClass, 
		   source, 
		   new String[] {
			 "documentation", "The v1 structure is as follows:\n\n\t\t\tdbo.put(\"_id\", imageId);\n\t\t\tdbo.put(\"name\", name); // in v1: Only used for creating/uploading new image. Otherwise it\'s always null.\n\t\t\tdbo.put(\"uri\", originalUri);\n\t\t\tdbo.put(\"fileName\", originalName);\n\t\t\tdbo.put(\"contentType\", contentType);\n\t\t\tdbo.put(\"size\", (int)length);\n\t\t\tfinal Date creationTime = new Date();\n\t\t\tdbo.put(\"created\", creationTime);\n\t\t\tdbo.put(\"styles\", stylesObj);\n- originalFile : transient\n\nv2 adds:\n\n\t\t\tdbo.put(\"name\", name); // in v2: serialized\n\t\t\tdbo.put(\"originUri\", originalOriginUri);\n\t\t\tdbo.put(\"extension\", extension);\n\t\t\tdbo.put(\"creationTime\", creationTime);\n- modificationTime\n- width\n- height\n- linkedFile"
		   });	
		addAnnotation
		  (getImage_Created(), 
		   source, 
		   new String[] {
			 "documentation", "DEPRECATED."
		   });	
		addAnnotation
		  (getImage_LinkedFile(), 
		   source, 
		   new String[] {
			 "documentation", "Image file name, relative to XMI file path inside the export folder or archive file. Only used for XMI data."
		   });	
		addAnnotation
		  (getImage_OriginalFile(), 
		   source, 
		   new String[] {
			 "documentation", "Only used for creating/uploading new image. Otherwise it\'s always null."
		   });	
		addAnnotation
		  (styledImageEClass, 
		   source, 
		   new String[] {
			 "documentation", "StyledImage v1 is as follows:\n\n\t\t\t\tbson.put(\"code\", transformed.getStyleCode());\n\t\t\t\tbson.put(\"uri\", transformed.getUri());\n\t\t\t\tbson.put(\"size\", transformed.getSize());\n\t\t\t\tbson.put(\"width\", transformed.getWidth());\n\t\t\t\tbson.put(\"height\", transformed.getHeight());\n\nv2 adds:\n\n\t\t\t\tbson.put(\"className\", StyledImage.class.getName()); // META\n\t\t\t\tbson.put(\"name\", style.getName());\n\t\t\t\tbson.put(\"variant\", transformed.getStyleVariant());\n\t\t\t\tbson.put(\"extension\", transformed.getExtension());\n\t\t\t\tbson.put(\"originUri\", transformed.getOriginUri());\n\t\t\t\tbson.put(\"contentType\", \"image/jpeg\"); // TODO: don\'t hardcode content type\n- creationTime\n- modificationTime\n"
		   });	
		addAnnotation
		  (getStyledImage_LinkedFile(), 
		   source, 
		   new String[] {
			 "documentation", "Image file name, relative to XMI file path inside the export folder or archive file. Only used for XMI data."
		   });	
		addAnnotation
		  (duplicateIdHandlingEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "If ID already exists, skip (default, safest)"
		   });	
		addAnnotation
		  (duplicateIdHandlingEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "If ID already exists, overwrite (common use)"
		   });	
		addAnnotation
		  (duplicateIdHandlingEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "If ID already exists, upload new image (not very useful)"
		   });	
		addAnnotation
		  (duplicateIdHandlingEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "If ID already exists, throw error (strict)"
		   });	
		addAnnotation
		  (folderConnectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Directly save to filesytem folder, useful for testing."
		   });	
		addAnnotation
		  (getFolderConnector_Folder(), 
		   source, 
		   new String[] {
			 "documentation", "Location to save."
		   });	
		addAnnotation
		  (displayImageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Makes it easier to display an image with additional information like width, height, alt, and title."
		   });	
		addAnnotation
		  (getDisplayImage_Width(), 
		   source, 
		   new String[] {
			 "documentation", "TODO: not yet usable."
		   });	
		addAnnotation
		  (getDisplayImage_Height(), 
		   source, 
		   new String[] {
			 "documentation", "TODO: not yet usable."
		   });	
		addAnnotation
		  (getDisplayImage_Alt(), 
		   source, 
		   new String[] {
			 "documentation", "TODO: not yet usable."
		   });	
		addAnnotation
		  (getDisplayImage_Title(), 
		   source, 
		   new String[] {
			 "documentation", "TODO: not yet usable."
		   });	
		addAnnotation
		  (imageStylesEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Holds commonly used image styles."
		   });	
		addAnnotation
		  (watermarkLikeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Watermark information if the transform supports watermark operation."
		   });	
		addAnnotation
		  (getWatermarkLike_WatermarkFile(), 
		   source, 
		   new String[] {
			 "documentation", "Watermark file to be used. If null, no watermark will be overlaid."
		   });	
		addAnnotation
		  (mediaEClass, 
		   source, 
		   new String[] {
			 "documentation", "Media document containing embedded file as a single (and only) attachment, compatible with CouchDB repository."
		   });	
		addAnnotation
		  (getMediaAttachment_ContentType(), 
		   source, 
		   new String[] {
			 "documentation", "Content type."
		   });	
		addAnnotation
		  (getMediaAttachment_Digest(), 
		   source, 
		   new String[] {
			 "documentation", "Digest, usually MD5 then base64 encoded, e.g. \"md5-kowj0TKpx2GdcR1zV9O11w==\""
		   });	
		addAnnotation
		  (getMediaAttachment_Stub(), 
		   source, 
		   new String[] {
			 "documentation", "Usually true, meaning the attachment content is not included in this object."
		   });	
		addAnnotation
		  (overlayLikeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Watermark information if the transform supports watermark operation."
		   });	
		addAnnotation
		  (getOverlayLike_OverlayFile(), 
		   source, 
		   new String[] {
			 "documentation", "Watermark file to be used. If null, no watermark will be overlaid."
		   });
	}

} //ImagePackageImpl
