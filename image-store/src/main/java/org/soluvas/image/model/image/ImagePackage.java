/**
 */
package org.soluvas.image.model.image;

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
 * @see org.soluvas.image.model.image.ImageFactory
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
	ImagePackage eINSTANCE = org.soluvas.image.model.image.impl.ImagePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.image.model.image.impl.ImageConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.image.model.image.impl.ImageConfigImpl
	 * @see org.soluvas.image.model.image.impl.ImagePackageImpl#getImageConfig()
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
	 * Returns the meta object for class '{@link org.soluvas.image.model.image.ImageConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see org.soluvas.image.model.image.ImageConfig
	 * @generated
	 */
	EClass getImageConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.image.model.image.ImageConfig#getPublicUri <em>Public Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Uri</em>'.
	 * @see org.soluvas.image.model.image.ImageConfig#getPublicUri()
	 * @see #getImageConfig()
	 * @generated
	 */
	EAttribute getImageConfig_PublicUri();

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
		 * The meta object literal for the '{@link org.soluvas.image.model.image.impl.ImageConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.image.model.image.impl.ImageConfigImpl
		 * @see org.soluvas.image.model.image.impl.ImagePackageImpl#getImageConfig()
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

	}

} //ImagePackage
