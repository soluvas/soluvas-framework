/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.image.BlitlineTransformer;
import org.soluvas.image.ImageConfig;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageFactory;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformType;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.ResizeToFill;
import org.soluvas.image.ResizeToFit;
import org.soluvas.image.S3Connector;
import org.soluvas.image.ThumbnailatorTransformer;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.DavConnector;
import org.soluvas.image.DimensionLike;

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
	private EClass imageConfigEClass = null;

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
	private EEnum imageTransformTypeEEnum = null;

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
	public EClass getImageConfig() {
		return imageConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageConfig_PublicUri() {
		return (EAttribute)imageConfigEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getImageConnector_LoUriTemplate() {
		return (EAttribute)imageConnectorEClass.getEStructuralFeatures().get(1);
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
	@Override
	public EClass getBlitlineTransformer() {
		return blitlineTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_ApplicationId() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_Bucket() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_Prefix() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_CdnAlias() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_KeyTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_UriTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlitlineTransformer_OriginUriTemplate() {
		return (EAttribute)blitlineTransformerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public EReference getImageTransformer_Source() {
		return (EReference)imageTransformerEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getUploadedImage_StyleCode() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadedImage_StyleVariant() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadedImage_Extension() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadedImage_Size() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadedImage_Width() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUploadedImage_Height() {
		return (EAttribute)uploadedImageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageManager() {
		return imageManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageTransform() {
		return imageTransformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResizeToFit() {
		return resizeToFitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResizeToFill() {
		return resizeToFillEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResizeToFill_Gravity() {
		return (EAttribute)resizeToFillEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResizeToFill_OnlyShrinkLarger() {
		return (EAttribute)resizeToFillEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimensionLike() {
		return dimensionLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimensionLike_Width() {
		return (EAttribute)dimensionLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimensionLike_Height() {
		return (EAttribute)dimensionLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageVariant() {
		return imageVariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageVariant_StyleCode() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageVariant_StyleVariant() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageVariant_Extension() {
		return (EAttribute)imageVariantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImageTransformType() {
		return imageTransformTypeEEnum;
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
		imageConfigEClass = createEClass(IMAGE_CONFIG);
		createEAttribute(imageConfigEClass, IMAGE_CONFIG__PUBLIC_URI);

		imageConnectorEClass = createEClass(IMAGE_CONNECTOR);
		createEAttribute(imageConnectorEClass, IMAGE_CONNECTOR__HI_URI_TEMPLATE);
		createEAttribute(imageConnectorEClass, IMAGE_CONNECTOR__LO_URI_TEMPLATE);

		davConnectorEClass = createEClass(DAV_CONNECTOR);

		s3ConnectorEClass = createEClass(S3_CONNECTOR);

		imageTransformerEClass = createEClass(IMAGE_TRANSFORMER);
		createEReference(imageTransformerEClass, IMAGE_TRANSFORMER__SOURCE);

		blitlineTransformerEClass = createEClass(BLITLINE_TRANSFORMER);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__APPLICATION_ID);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__BUCKET);
		createEAttribute(blitlineTransformerEClass, BLITLINE_TRANSFORMER__PREFIX);
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

		// Create enums
		imageTransformTypeEEnum = createEEnum(IMAGE_TRANSFORM_TYPE);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
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
		resizeToFillEClass.getESuperTypes().add(this.getImageTransform());
		resizeToFillEClass.getESuperTypes().add(this.getDimensionLike());

		// Initialize classes and features; add operations and parameters
		initEClass(imageConfigEClass, ImageConfig.class, "ImageConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageConfig_PublicUri(), ecorePackage.getEString(), "publicUri", null, 0, 1, ImageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageConnectorEClass, ImageConnector.class, "ImageConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageConnector_HiUriTemplate(), theEcorePackage.getEString(), "hiUriTemplate", null, 0, 1, ImageConnector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageConnector_LoUriTemplate(), theEcorePackage.getEString(), "loUriTemplate", null, 0, 1, ImageConnector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(imageConnectorEClass, this.getUploadedImage(), "upload", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "contentType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, theEcorePackage.getEBoolean(), "download", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, theEcorePackage.getEString(), "getUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(imageConnectorEClass, theEcorePackage.getEString(), "getOriginUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(davConnectorEClass, DavConnector.class, "DavConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(davConnectorEClass, null, "destroy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(s3ConnectorEClass, S3Connector.class, "S3Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(s3ConnectorEClass, null, "destroy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(imageTransformerEClass, ImageTransformer.class, "ImageTransformer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageTransformer_Source(), this.getImageConnector(), null, "source", null, 0, 1, ImageTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(imageTransformerEClass, null, "transform", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageVariant(), "sourceVariant", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType(this.getImageTransform());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getImageVariant());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "transforms", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getList());
		g2 = createEGenericType(this.getUploadedImage());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(blitlineTransformerEClass, BlitlineTransformer.class, "BlitlineTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlitlineTransformer_ApplicationId(), theEcorePackage.getEString(), "applicationId", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_Bucket(), theEcorePackage.getEString(), "bucket", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_Prefix(), theEcorePackage.getEString(), "prefix", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_CdnAlias(), theEcorePackage.getEString(), "cdnAlias", null, 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_KeyTemplate(), theEcorePackage.getEString(), "keyTemplate", "{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_UriTemplate(), theEcorePackage.getEString(), "uriTemplate", "{+alias}{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlitlineTransformer_OriginUriTemplate(), theEcorePackage.getEString(), "originUriTemplate", "{+alias}{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}", 0, 1, BlitlineTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thumbnailatorTransformerEClass, ThumbnailatorTransformer.class, "ThumbnailatorTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThumbnailatorTransformer_Destination(), this.getImageConnector(), null, "destination", null, 0, 1, ThumbnailatorTransformer.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uploadedImageEClass, UploadedImage.class, "UploadedImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUploadedImage_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_OriginUri(), theEcorePackage.getEString(), "originUri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_StyleCode(), theEcorePackage.getEString(), "styleCode", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_StyleVariant(), theEcorePackage.getEString(), "styleVariant", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Extension(), theEcorePackage.getEString(), "extension", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Size(), theEcorePackage.getELongObject(), "size", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Width(), theEcorePackage.getEIntegerObject(), "width", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_Height(), theEcorePackage.getEIntegerObject(), "height", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageManagerEClass, ImageManager.class, "ImageManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(imageManagerEClass, theEcorePackage.getEString(), "getDefaultPhotoId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getGender(), "gender", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(imageTransformEClass, ImageTransform.class, "ImageTransform", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resizeToFitEClass, ResizeToFit.class, "ResizeToFit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resizeToFillEClass, ResizeToFill.class, "ResizeToFill", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResizeToFill_Gravity(), theEcorePackage.getEString(), "gravity", null, 0, 1, ResizeToFill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResizeToFill_OnlyShrinkLarger(), theEcorePackage.getEBooleanObject(), "onlyShrinkLarger", null, 0, 1, ResizeToFill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionLikeEClass, DimensionLike.class, "DimensionLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimensionLike_Width(), theEcorePackage.getEIntegerObject(), "width", null, 0, 1, DimensionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimensionLike_Height(), theEcorePackage.getEIntegerObject(), "height", null, 0, 1, DimensionLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageVariantEClass, ImageVariant.class, "ImageVariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageVariant_StyleCode(), theEcorePackage.getEString(), "styleCode", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageVariant_StyleVariant(), theEcorePackage.getEString(), "styleVariant", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageVariant_Extension(), theEcorePackage.getEString(), "extension", null, 0, 1, ImageVariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(imageTransformTypeEEnum, ImageTransformType.class, "ImageTransformType");
		addEEnumLiteral(imageTransformTypeEEnum, ImageTransformType.RESIZE_TO_FIT);
		addEEnumLiteral(imageTransformTypeEEnum, ImageTransformType.RESIZE_TO_FILL);

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
		  (imageConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "Image module configuration.\n\nThe URI pattern is hardcoded as folows:\n\nFor normal styles:\n\n* {publicUri}/{namespace}/{styleCode}/{id}_{styleCode}.{extension}\n\nFor variant styles: (styleCode is usually \'x\', but can be anything else except \'o\')\n\n* {publicUri}/{namespace}/{styleCode}/{id}_{styleCode}_{variantCode}.{extension}\n\nIn the future, URI pattern (\"template\") should be configurable, based on http://tools.ietf.org/html/rfc6570\nand can be expanded both by server and client scripts.\n\nThe domain name can also be different for each namespace, or even for each styleCode or variantCode.\n"
		   });		
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
		  (getImageConnector_HiUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'hi\' (original) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nreturn \"http://cdn.alias/\" + \"prefix/\" + \"{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}\";"
		   });		
		addAnnotation
		  (getImageConnector_LoUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'lo\' (derived) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nreturn \"http://origin.alias/\" + \"prefix/\" + \"{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}\";"
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
			 "documentation", "Transform the image and saves it to the configured destination. The mechanism to assign destination is transformer-specific.\nThumbnailator saves it to a file and then uploads it using an ImageConnector. Blitline saves directly to an S3 bucket."
		   });		
		addAnnotation
		  (getImageTransformer_Source(), 
		   source, 
		   new String[] {
			 "documentation", "Source image connector.\n\nThumbnailator will use this to get the origin URI and download the  image, before transforming it locally.\n\nBlitline will use it to get the origin URI, but processing will be done by Blitline itself."
		   });		
		addAnnotation
		  (blitlineTransformerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Processes using Blitline. The source image must be publicly hosted, for example using S3.\n\nThe destination image is directly written into an S3 bucket. Make sure to set the Canonical ID, see http://blog.blitline.com/post/32296310740/canonical-id-s3-permissions"
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
			 "documentation", "key template in URI template format.\n\nVariables are: namespace, styleCode, imageId, styleVariant, extension.\n\nDefault is: \"{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}\";"
		   });		
		addAnnotation
		  (getBlitlineTransformer_UriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'lo\' (derived) images, optionally with CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nDefault is: {+alias}{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}"
		   });		
		addAnnotation
		  (getBlitlineTransformer_OriginUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI template for \'lo\' (derived) images, without CDN. This template will be used on 3 areas: server-side, email templating, and client-side JavaScript.\n\nVariables are: namespace, styleCode, imageId, styleVariant, ext.\n\nDefault is: {+alias}{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{ext}"
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
			 "documentation", "File size in bytes. A transformer like Blitlines is unable to provide this information immediately, an enhanced Blitlines transformer can update the size independently and asynchronously."
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
	}

} //ImagePackageImpl
