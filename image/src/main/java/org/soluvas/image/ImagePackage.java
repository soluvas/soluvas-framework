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
	int S3_CONNECTOR = 2;

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
	 * The meta object id for the '{@link org.soluvas.image.ImageTransformer <em>Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageTransformer
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransformer()
	 * @generated
	 */
	int IMAGE_TRANSFORMER = 5;

	/**
	 * The number of structural features of the '<em>Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSFORMER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.BlitlineTransformerImpl <em>Blitline Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.BlitlineTransformerImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getBlitlineTransformer()
	 * @generated
	 */
	int BLITLINE_TRANSFORMER = 3;

	/**
	 * The number of structural features of the '<em>Blitline Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_TRANSFORMER_FEATURE_COUNT = IMAGE_TRANSFORMER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.DavConnectorImpl <em>Dav Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.DavConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getDavConnector()
	 * @generated
	 */
	int DAV_CONNECTOR = 4;

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
	 * The meta object id for the '{@link org.soluvas.image.impl.ThumbnailatorTransformerImpl <em>Thumbnailator Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.ThumbnailatorTransformerImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getThumbnailatorTransformer()
	 * @generated
	 */
	int THUMBNAILATOR_TRANSFORMER = 6;

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
	 * The number of structural features of the '<em>Uploaded Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOADED_IMAGE_FEATURE_COUNT = 2;


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
	 * The meta object id for the '{@link org.soluvas.image.ImageTransform <em>Transform</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageTransform
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransform()
	 * @generated
	 */
	int IMAGE_TRANSFORM = 9;


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
	 * Returns the meta object for class '{@link org.soluvas.image.ImageManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.soluvas.image.ImageManager
	 * @generated
	 */
	EClass getImageManager();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.image.ImageTransform <em>Transform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transform</em>'.
	 * @see org.soluvas.image.ImageTransform
	 * @generated
	 */
	EEnum getImageTransform();

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
		 * The meta object literal for the '{@link org.soluvas.image.impl.ImageManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.ImageManagerImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageManager()
		 * @generated
		 */
		EClass IMAGE_MANAGER = eINSTANCE.getImageManager();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.ImageTransform <em>Transform</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.ImageTransform
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageTransform()
		 * @generated
		 */
		EEnum IMAGE_TRANSFORM = eINSTANCE.getImageTransform();

	}

} //ImagePackage
