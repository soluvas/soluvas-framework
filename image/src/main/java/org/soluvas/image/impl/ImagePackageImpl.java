/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.S3Connector;
import org.soluvas.image.ThumbnailatorTransformer;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.WebDavConnector;

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
	private EClass webDavConnectorEClass = null;

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
	@Override
	public EClass getWebDavConnector() {
		return webDavConnectorEClass;
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

		s3ConnectorEClass = createEClass(S3_CONNECTOR);

		blitlineTransformerEClass = createEClass(BLITLINE_TRANSFORMER);

		webDavConnectorEClass = createEClass(WEB_DAV_CONNECTOR);

		imageTransformerEClass = createEClass(IMAGE_TRANSFORMER);

		thumbnailatorTransformerEClass = createEClass(THUMBNAILATOR_TRANSFORMER);
		createEReference(thumbnailatorTransformerEClass, THUMBNAILATOR_TRANSFORMER__DESTINATION);

		uploadedImageEClass = createEClass(UPLOADED_IMAGE);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__URI);
		createEAttribute(uploadedImageEClass, UPLOADED_IMAGE__ORIGIN_URI);
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
		s3ConnectorEClass.getESuperTypes().add(this.getImageConnector());
		blitlineTransformerEClass.getESuperTypes().add(this.getImageTransformer());
		webDavConnectorEClass.getESuperTypes().add(this.getImageConnector());
		thumbnailatorTransformerEClass.getESuperTypes().add(this.getImageTransformer());

		// Initialize classes and features; add operations and parameters
		initEClass(imageConfigEClass, ImageConfig.class, "ImageConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageConfig_PublicUri(), ecorePackage.getEString(), "publicUri", null, 0, 1, ImageConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageConnectorEClass, ImageConnector.class, "ImageConnector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(imageConnectorEClass, this.getUploadedImage(), "upload", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "namespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imageId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "styleCode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "extension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getFile(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "contentType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(s3ConnectorEClass, S3Connector.class, "S3Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blitlineTransformerEClass, BlitlineTransformer.class, "BlitlineTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(webDavConnectorEClass, WebDavConnector.class, "WebDavConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageTransformerEClass, ImageTransformer.class, "ImageTransformer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(thumbnailatorTransformerEClass, ThumbnailatorTransformer.class, "ThumbnailatorTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThumbnailatorTransformer_Destination(), this.getImageConnector(), null, "destination", null, 0, 1, ThumbnailatorTransformer.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uploadedImageEClass, UploadedImage.class, "UploadedImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUploadedImage_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUploadedImage_OriginUri(), theEcorePackage.getEString(), "originUri", null, 0, 1, UploadedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (blitlineTransformerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Processes using Blitline. The source image must be publicly hosted, for example using S3.\n\nThe destination image is directly written into an S3 bucket."
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
	}

} //ImagePackageImpl
