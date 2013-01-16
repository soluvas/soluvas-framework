/**
 */
package org.soluvas.image;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImageFactory
 * @model kind="package"
 * @generated
 */
public interface ImagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "image";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/image/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "image";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImagePackage eINSTANCE = org.soluvas.image.impl.ImagePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ImageConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ImageConfigImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConfig()
	 * @generated
	 */
	int IMAGE_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Public Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONFIG__PUBLIC_URI = 0;

	/**
	 * The number of structural features of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONFIG_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ImageConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ImageConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConnector()
	 * @generated
	 */
	int IMAGE_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Hi Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONNECTOR__HI_URI_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Lo Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONNECTOR__LO_URI_TEMPLATE = 1;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONNECTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.S3ConnectorImpl <em>S3 Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.S3ConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getS3Connector()
	 * @generated
	 */
	int S3_CONNECTOR = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.image.ImageTransformer <em>Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageTransformer
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransformer()
	 * @generated
	 */
	int IMAGE_TRANSFORMER = 4;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.BlitlineTransformerImpl <em>Blitline Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.BlitlineTransformerImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getBlitlineTransformer()
	 * @generated
	 */
	int BLITLINE_TRANSFORMER = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.DavConnectorImpl <em>Dav Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.DavConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getDavConnector()
	 * @generated
	 */
	int DAV_CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>Hi Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAV_CONNECTOR__HI_URI_TEMPLATE = IMAGE_CONNECTOR__HI_URI_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Lo Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAV_CONNECTOR__LO_URI_TEMPLATE = IMAGE_CONNECTOR__LO_URI_TEMPLATE;

	/**
	 * The number of structural features of the '<em>Dav Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAV_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hi Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S3_CONNECTOR__HI_URI_TEMPLATE = IMAGE_CONNECTOR__HI_URI_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Lo Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S3_CONNECTOR__LO_URI_TEMPLATE = IMAGE_CONNECTOR__LO_URI_TEMPLATE;

	/**
	 * The number of structural features of the '<em>S3 Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S3_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSFORMER__SOURCE = 0;

	/**
	 * The number of structural features of the '<em>Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSFORMER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER__SOURCE = IMAGE_TRANSFORMER__SOURCE;

	/**
	 * The feature id for the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER__APPLICATION_ID = IMAGE_TRANSFORMER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bucket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER__BUCKET = IMAGE_TRANSFORMER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER__PREFIX = IMAGE_TRANSFORMER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Key Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER__KEY_TEMPLATE = IMAGE_TRANSFORMER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Blitline Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER_FEATURE_COUNT = IMAGE_TRANSFORMER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl <em>Thumbnailator Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ThumbnailatorTransformerImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getThumbnailatorTransformer()
	 * @generated
	 */
	int THUMBNAILATOR_TRANSFORMER = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAILATOR_TRANSFORMER__SOURCE = IMAGE_TRANSFORMER__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAILATOR_TRANSFORMER__DESTINATION = IMAGE_TRANSFORMER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Thumbnailator Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMBNAILATOR_TRANSFORMER_FEATURE_COUNT = IMAGE_TRANSFORMER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.UploadedImageImpl <em>Uploaded Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.UploadedImageImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getUploadedImage()
	 * @generated
	 */
	int UPLOADED_IMAGE = 7;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__URI = 0;

	/**
	 * The feature id for the '<em><b>Origin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__ORIGIN_URI = 1;

	/**
	 * The feature id for the '<em><b>Style Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__STYLE_CODE = 2;

	/**
	 * The feature id for the '<em><b>Style Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__STYLE_VARIANT = 3;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__EXTENSION = 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__SIZE = 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__WIDTH = 6;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE__HEIGHT = 7;

	/**
	 * The number of structural features of the '<em>Uploaded Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE_FEATURE_COUNT = 8;


	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ImageManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ImageManagerImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageManager()
	 * @generated
	 */
	int IMAGE_MANAGER = 8;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_MANAGER_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.soluvas.image.ImageTransform <em>Transform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageTransform
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransform()
	 * @generated
	 */
	int IMAGE_TRANSFORM = 9;


	/**
	 * The number of structural features of the '<em>Transform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSFORM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ResizeToFitImpl <em>Resize To Fit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ResizeToFitImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getResizeToFit()
	 * @generated
	 */
	int RESIZE_TO_FIT = 10;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FIT__WIDTH = IMAGE_TRANSFORM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FIT__HEIGHT = IMAGE_TRANSFORM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resize To Fit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FIT_FEATURE_COUNT = IMAGE_TRANSFORM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ResizeToFillImpl <em>Resize To Fill</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ResizeToFillImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getResizeToFill()
	 * @generated
	 */
	int RESIZE_TO_FILL = 11;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FILL__WIDTH = IMAGE_TRANSFORM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FILL__HEIGHT = IMAGE_TRANSFORM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gravity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FILL__GRAVITY = IMAGE_TRANSFORM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Only Shrink Larger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FILL__ONLY_SHRINK_LARGER = IMAGE_TRANSFORM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Resize To Fill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_TO_FILL_FEATURE_COUNT = IMAGE_TRANSFORM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.image.DimensionLike <em>Dimension Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.DimensionLike
	 * @see org.soluvas.image.impl.ImagePackageImpl#getDimensionLike()
	 * @generated
	 */
	int DIMENSION_LIKE = 12;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_LIKE__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_LIKE__HEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Dimension Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_LIKE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.ImageVariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ImageVariantImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageVariant()
	 * @generated
	 */
	int IMAGE_VARIANT = 13;

	/**
	 * The feature id for the '<em><b>Style Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VARIANT__STYLE_CODE = 0;

	/**
	 * The feature id for the '<em><b>Style Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VARIANT__STYLE_VARIANT = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VARIANT__EXTENSION = 2;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VARIANT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.image.ImageTransformType <em>Transform Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageTransformType
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransformType()
	 * @generated
	 */
	int IMAGE_TRANSFORM_TYPE = 14;


	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see org.soluvas.image.ImageConfig
	 * @generated
	 */
	EClass getImageConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageConfig#getPublicUri <em>Public Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Uri</em>'.
	 * @see org.soluvas.image.ImageConfig#getPublicUri()
	 * @see #getImageConfig()
	 * @generated
	 */
	EAttribute getImageConfig_PublicUri();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.soluvas.image.ImageConnector
	 * @generated
	 */
	EClass getImageConnector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageConnector#getHiUriTemplate <em>Hi Uri Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hi Uri Template</em>'.
	 * @see org.soluvas.image.ImageConnector#getHiUriTemplate()
	 * @see #getImageConnector()
	 * @generated
	 */
	EAttribute getImageConnector_HiUriTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageConnector#getLoUriTemplate <em>Lo Uri Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lo Uri Template</em>'.
	 * @see org.soluvas.image.ImageConnector#getLoUriTemplate()
	 * @see #getImageConnector()
	 * @generated
	 */
	EAttribute getImageConnector_LoUriTemplate();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.S3Connector <em>S3 Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>S3 Connector</em>'.
	 * @see org.soluvas.image.S3Connector
	 * @generated
	 */
	EClass getS3Connector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.BlitlineTransformer <em>Blitline Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blitline Transformer</em>'.
	 * @see org.soluvas.image.BlitlineTransformer
	 * @generated
	 */
	EClass getBlitlineTransformer();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.BlitlineTransformer#getApplicationId <em>Application Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Id</em>'.
	 * @see org.soluvas.image.BlitlineTransformer#getApplicationId()
	 * @see #getBlitlineTransformer()
	 * @generated
	 */
	EAttribute getBlitlineTransformer_ApplicationId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.BlitlineTransformer#getBucket <em>Bucket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bucket</em>'.
	 * @see org.soluvas.image.BlitlineTransformer#getBucket()
	 * @see #getBlitlineTransformer()
	 * @generated
	 */
	EAttribute getBlitlineTransformer_Bucket();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.BlitlineTransformer#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.soluvas.image.BlitlineTransformer#getPrefix()
	 * @see #getBlitlineTransformer()
	 * @generated
	 */
	EAttribute getBlitlineTransformer_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.BlitlineTransformer#getKeyTemplate <em>Key Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Template</em>'.
	 * @see org.soluvas.image.BlitlineTransformer#getKeyTemplate()
	 * @see #getBlitlineTransformer()
	 * @generated
	 */
	EAttribute getBlitlineTransformer_KeyTemplate();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.DavConnector <em>Dav Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dav Connector</em>'.
	 * @see org.soluvas.image.DavConnector
	 * @generated
	 */
	EClass getDavConnector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageTransformer <em>Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformer</em>'.
	 * @see org.soluvas.image.ImageTransformer
	 * @generated
	 */
	EClass getImageTransformer();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.image.ImageTransformer#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.soluvas.image.ImageTransformer#getSource()
	 * @see #getImageTransformer()
	 * @generated
	 */
	EReference getImageTransformer_Source();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ThumbnailatorTransformer <em>Thumbnailator Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thumbnailator Transformer</em>'.
	 * @see org.soluvas.image.ThumbnailatorTransformer
	 * @generated
	 */
	EClass getThumbnailatorTransformer();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.image.ThumbnailatorTransformer#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.soluvas.image.ThumbnailatorTransformer#getDestination()
	 * @see #getThumbnailatorTransformer()
	 * @generated
	 */
	EReference getThumbnailatorTransformer_Destination();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.UploadedImage <em>Uploaded Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uploaded Image</em>'.
	 * @see org.soluvas.image.UploadedImage
	 * @generated
	 */
	EClass getUploadedImage();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.soluvas.image.UploadedImage#getUri()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getOriginUri <em>Origin Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin Uri</em>'.
	 * @see org.soluvas.image.UploadedImage#getOriginUri()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_OriginUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getStyleCode <em>Style Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Code</em>'.
	 * @see org.soluvas.image.UploadedImage#getStyleCode()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_StyleCode();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getStyleVariant <em>Style Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Variant</em>'.
	 * @see org.soluvas.image.UploadedImage#getStyleVariant()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_StyleVariant();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.soluvas.image.UploadedImage#getExtension()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.soluvas.image.UploadedImage#getSize()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.image.UploadedImage#getWidth()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.UploadedImage#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.image.UploadedImage#getHeight()
	 * @see #getUploadedImage()
	 * @generated
	 */
	EAttribute getUploadedImage_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.soluvas.image.ImageManager
	 * @generated
	 */
	EClass getImageManager();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageTransform <em>Transform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transform</em>'.
	 * @see org.soluvas.image.ImageTransform
	 * @generated
	 */
	EClass getImageTransform();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ResizeToFit <em>Resize To Fit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resize To Fit</em>'.
	 * @see org.soluvas.image.ResizeToFit
	 * @generated
	 */
	EClass getResizeToFit();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ResizeToFill <em>Resize To Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resize To Fill</em>'.
	 * @see org.soluvas.image.ResizeToFill
	 * @generated
	 */
	EClass getResizeToFill();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ResizeToFill#getGravity <em>Gravity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gravity</em>'.
	 * @see org.soluvas.image.ResizeToFill#getGravity()
	 * @see #getResizeToFill()
	 * @generated
	 */
	EAttribute getResizeToFill_Gravity();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ResizeToFill#getOnlyShrinkLarger <em>Only Shrink Larger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Only Shrink Larger</em>'.
	 * @see org.soluvas.image.ResizeToFill#getOnlyShrinkLarger()
	 * @see #getResizeToFill()
	 * @generated
	 */
	EAttribute getResizeToFill_OnlyShrinkLarger();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.DimensionLike <em>Dimension Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Like</em>'.
	 * @see org.soluvas.image.DimensionLike
	 * @generated
	 */
	EClass getDimensionLike();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.DimensionLike#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.image.DimensionLike#getWidth()
	 * @see #getDimensionLike()
	 * @generated
	 */
	EAttribute getDimensionLike_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.DimensionLike#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.image.DimensionLike#getHeight()
	 * @see #getDimensionLike()
	 * @generated
	 */
	EAttribute getDimensionLike_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.ImageVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see org.soluvas.image.ImageVariant
	 * @generated
	 */
	EClass getImageVariant();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageVariant#getStyleCode <em>Style Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Code</em>'.
	 * @see org.soluvas.image.ImageVariant#getStyleCode()
	 * @see #getImageVariant()
	 * @generated
	 */
	EAttribute getImageVariant_StyleCode();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageVariant#getStyleVariant <em>Style Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Variant</em>'.
	 * @see org.soluvas.image.ImageVariant#getStyleVariant()
	 * @see #getImageVariant()
	 * @generated
	 */
	EAttribute getImageVariant_StyleVariant();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.ImageVariant#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.soluvas.image.ImageVariant#getExtension()
	 * @see #getImageVariant()
	 * @generated
	 */
	EAttribute getImageVariant_Extension();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.image.ImageTransformType <em>Transform Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transform Type</em>'.
	 * @see org.soluvas.image.ImageTransformType
	 * @generated
	 */
	EEnum getImageTransformType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImageFactory getImageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ImageConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ImageConfigImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConfig()
		 * @generated
		 */
		EClass IMAGE_CONFIG = eINSTANCE.getImageConfig();

		/**
		 * The meta object literal for the '<em><b>Public Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_CONFIG__PUBLIC_URI = eINSTANCE.getImageConfig_PublicUri();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ImageConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ImageConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConnector()
		 * @generated
		 */
		EClass IMAGE_CONNECTOR = eINSTANCE.getImageConnector();

		/**
		 * The meta object literal for the '<em><b>Hi Uri Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_CONNECTOR__HI_URI_TEMPLATE = eINSTANCE.getImageConnector_HiUriTemplate();

		/**
		 * The meta object literal for the '<em><b>Lo Uri Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_CONNECTOR__LO_URI_TEMPLATE = eINSTANCE.getImageConnector_LoUriTemplate();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.S3ConnectorImpl <em>S3 Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.S3ConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getS3Connector()
		 * @generated
		 */
		EClass S3_CONNECTOR = eINSTANCE.getS3Connector();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.BlitlineTransformerImpl <em>Blitline Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.BlitlineTransformerImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getBlitlineTransformer()
		 * @generated
		 */
		EClass BLITLINE_TRANSFORMER = eINSTANCE.getBlitlineTransformer();

		/**
		 * The meta object literal for the '<em><b>Application Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITLINE_TRANSFORMER__APPLICATION_ID = eINSTANCE.getBlitlineTransformer_ApplicationId();

		/**
		 * The meta object literal for the '<em><b>Bucket</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITLINE_TRANSFORMER__BUCKET = eINSTANCE.getBlitlineTransformer_Bucket();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITLINE_TRANSFORMER__PREFIX = eINSTANCE.getBlitlineTransformer_Prefix();

		/**
		 * The meta object literal for the '<em><b>Key Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITLINE_TRANSFORMER__KEY_TEMPLATE = eINSTANCE.getBlitlineTransformer_KeyTemplate();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.DavConnectorImpl <em>Dav Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.DavConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getDavConnector()
		 * @generated
		 */
		EClass DAV_CONNECTOR = eINSTANCE.getDavConnector();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.ImageTransformer <em>Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.ImageTransformer
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransformer()
		 * @generated
		 */
		EClass IMAGE_TRANSFORMER = eINSTANCE.getImageTransformer();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_TRANSFORMER__SOURCE = eINSTANCE.getImageTransformer_Source();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl <em>Thumbnailator Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ThumbnailatorTransformerImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getThumbnailatorTransformer()
		 * @generated
		 */
		EClass THUMBNAILATOR_TRANSFORMER = eINSTANCE.getThumbnailatorTransformer();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMBNAILATOR_TRANSFORMER__DESTINATION = eINSTANCE.getThumbnailatorTransformer_Destination();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.UploadedImageImpl <em>Uploaded Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.UploadedImageImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getUploadedImage()
		 * @generated
		 */
		EClass UPLOADED_IMAGE = eINSTANCE.getUploadedImage();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__URI = eINSTANCE.getUploadedImage_Uri();

		/**
		 * The meta object literal for the '<em><b>Origin Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__ORIGIN_URI = eINSTANCE.getUploadedImage_OriginUri();

		/**
		 * The meta object literal for the '<em><b>Style Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__STYLE_CODE = eINSTANCE.getUploadedImage_StyleCode();

		/**
		 * The meta object literal for the '<em><b>Style Variant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__STYLE_VARIANT = eINSTANCE.getUploadedImage_StyleVariant();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__EXTENSION = eINSTANCE.getUploadedImage_Extension();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__SIZE = eINSTANCE.getUploadedImage_Size();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__WIDTH = eINSTANCE.getUploadedImage_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPLOADED_IMAGE__HEIGHT = eINSTANCE.getUploadedImage_Height();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ImageManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ImageManagerImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageManager()
		 * @generated
		 */
		EClass IMAGE_MANAGER = eINSTANCE.getImageManager();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.ImageTransform <em>Transform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.ImageTransform
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransform()
		 * @generated
		 */
		EClass IMAGE_TRANSFORM = eINSTANCE.getImageTransform();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ResizeToFitImpl <em>Resize To Fit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ResizeToFitImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getResizeToFit()
		 * @generated
		 */
		EClass RESIZE_TO_FIT = eINSTANCE.getResizeToFit();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ResizeToFillImpl <em>Resize To Fill</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ResizeToFillImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getResizeToFill()
		 * @generated
		 */
		EClass RESIZE_TO_FILL = eINSTANCE.getResizeToFill();

		/**
		 * The meta object literal for the '<em><b>Gravity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESIZE_TO_FILL__GRAVITY = eINSTANCE.getResizeToFill_Gravity();

		/**
		 * The meta object literal for the '<em><b>Only Shrink Larger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESIZE_TO_FILL__ONLY_SHRINK_LARGER = eINSTANCE.getResizeToFill_OnlyShrinkLarger();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.DimensionLike <em>Dimension Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.DimensionLike
		 * @see org.soluvas.image.impl.ImagePackageImpl#getDimensionLike()
		 * @generated
		 */
		EClass DIMENSION_LIKE = eINSTANCE.getDimensionLike();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION_LIKE__WIDTH = eINSTANCE.getDimensionLike_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION_LIKE__HEIGHT = eINSTANCE.getDimensionLike_Height();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.ImageVariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ImageVariantImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageVariant()
		 * @generated
		 */
		EClass IMAGE_VARIANT = eINSTANCE.getImageVariant();

		/**
		 * The meta object literal for the '<em><b>Style Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_VARIANT__STYLE_CODE = eINSTANCE.getImageVariant_StyleCode();

		/**
		 * The meta object literal for the '<em><b>Style Variant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_VARIANT__STYLE_VARIANT = eINSTANCE.getImageVariant_StyleVariant();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_VARIANT__EXTENSION = eINSTANCE.getImageVariant_Extension();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.ImageTransformType <em>Transform Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.ImageTransformType
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransformType()
		 * @generated
		 */
		EEnum IMAGE_TRANSFORM_TYPE = eINSTANCE.getImageTransformType();

	}

} //ImagePackage
