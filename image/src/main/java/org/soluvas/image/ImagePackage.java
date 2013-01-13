/**
 */
package org.soluvas.image;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
	 * The meta object id for the '{@link org.soluvas.image.ImageConnector <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.ImageConnector
	 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConnector()
	 * @generated
	 */
	int IMAGE_CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_CONNECTOR_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>S3 Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int S3_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.BlitlineConnectorImpl <em>Blitline Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.BlitlineConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getBlitlineConnector()
	 * @generated
	 */
	int BLITLINE_CONNECTOR = 3;

	/**
	 * The number of structural features of the '<em>Blitline Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITLINE_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.CloudinaryConnectorImpl <em>Cloudinary Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.CloudinaryConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getCloudinaryConnector()
	 * @generated
	 */
	int CLOUDINARY_CONNECTOR = 4;

	/**
	 * The number of structural features of the '<em>Cloudinary Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUDINARY_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.image.impl.WebDavConnectorImpl <em>Web Dav Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.impl.WebDavConnectorImpl
	 * @see org.soluvas.image.impl.ImagePackageImpl#getWebDavConnector()
	 * @generated
	 */
	int WEB_DAV_CONNECTOR = 5;

	/**
	 * The number of structural features of the '<em>Web Dav Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_DAV_CONNECTOR_FEATURE_COUNT = IMAGE_CONNECTOR_FEATURE_COUNT + 0;


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
	 * Returns the meta object for class '{@link org.soluvas.image.S3Connector <em>S3 Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>S3 Connector</em>'.
	 * @see org.soluvas.image.S3Connector
	 * @generated
	 */
	EClass getS3Connector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.BlitlineConnector <em>Blitline Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blitline Connector</em>'.
	 * @see org.soluvas.image.BlitlineConnector
	 * @generated
	 */
	EClass getBlitlineConnector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.CloudinaryConnector <em>Cloudinary Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cloudinary Connector</em>'.
	 * @see org.soluvas.image.CloudinaryConnector
	 * @generated
	 */
	EClass getCloudinaryConnector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.image.WebDavConnector <em>Web Dav Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Dav Connector</em>'.
	 * @see org.soluvas.image.WebDavConnector
	 * @generated
	 */
	EClass getWebDavConnector();

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
		 * The meta object literal for the '{@link org.soluvas.image.ImageConnector <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.ImageConnector
		 * @see org.soluvas.image.impl.ImagePackageImpl#getImageConnector()
		 * @generated
		 */
		EClass IMAGE_CONNECTOR = eINSTANCE.getImageConnector();

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
		 * The meta object literal for the '{@link org.soluvas.image.impl.BlitlineConnectorImpl <em>Blitline Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.BlitlineConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getBlitlineConnector()
		 * @generated
		 */
		EClass BLITLINE_CONNECTOR = eINSTANCE.getBlitlineConnector();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.CloudinaryConnectorImpl <em>Cloudinary Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.CloudinaryConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getCloudinaryConnector()
		 * @generated
		 */
		EClass CLOUDINARY_CONNECTOR = eINSTANCE.getCloudinaryConnector();

		/**
		 * The meta object literal for the '{@link org.soluvas.image.impl.WebDavConnectorImpl <em>Web Dav Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.impl.WebDavConnectorImpl
		 * @see org.soluvas.image.impl.ImagePackageImpl#getWebDavConnector()
		 * @generated
		 */
		EClass WEB_DAV_CONNECTOR = eINSTANCE.getWebDavConnector();

	}

} //ImagePackage
