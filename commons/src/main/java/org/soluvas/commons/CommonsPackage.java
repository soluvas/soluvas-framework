/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.soluvas.commons.CommonsFactory
 * @model kind="package"
 * @generated
 */
public interface CommonsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commons";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/commons/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "commons";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonsPackage eINSTANCE = org.soluvas.commons.impl.CommonsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.commons.ResourceAware <em>Resource Aware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.ResourceAware
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getResourceAware()
	 * @generated
	 */
	int RESOURCE_AWARE = 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_AWARE__RESOURCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_AWARE__RESOURCE_URI = 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_AWARE__RESOURCE_NAME = 2;

	/**
	 * The number of structural features of the '<em>Resource Aware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_AWARE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Positionable <em>Positionable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Positionable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPositionable()
	 * @generated
	 */
	int POSITIONABLE = 1;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONABLE__POSITIONER = 0;

	/**
	 * The number of structural features of the '<em>Positionable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITIONABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AppManifestImpl <em>App Manifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AppManifestImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAppManifest()
	 * @generated
	 */
	int APP_MANIFEST = 2;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__POSITIONER = POSITIONABLE__POSITIONER;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__RESOURCE_TYPE = POSITIONABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__RESOURCE_URI = POSITIONABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__RESOURCE_NAME = POSITIONABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__BUNDLE = POSITIONABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__TITLE = POSITIONABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__DESCRIPTION = POSITIONABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__DOMAIN = POSITIONABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>App Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST_FEATURE_COUNT = POSITIONABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Identifiable <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Identifiable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__ID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.PersonInfoImpl <em>Person Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.PersonInfoImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPersonInfo()
	 * @generated
	 */
	int PERSON_INFO = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Photo Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__PHOTO_ID = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__SLUG = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__NAME = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__GENDER = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO__EMAIL = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Person Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Timestamped <em>Timestamped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Timestamped
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getTimestamped()
	 * @generated
	 */
	int TIMESTAMPED = 4;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMPED__CREATION_TIME = 0;

	/**
	 * The feature id for the '<em><b>Modification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMPED__MODIFICATION_TIME = 1;

	/**
	 * The number of structural features of the '<em>Timestamped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMPED_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Sluggable <em>Sluggable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Sluggable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSluggable()
	 * @generated
	 */
	int SLUGGABLE = 6;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLUGGABLE__SLUG = 0;

	/**
	 * The number of structural features of the '<em>Sluggable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLUGGABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Nameable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 7;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Imageable <em>Imageable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Imageable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getImageable()
	 * @generated
	 */
	int IMAGEABLE = 8;

	/**
	 * The number of structural features of the '<em>Imageable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGEABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.PhotoIdContainerImpl <em>Photo Id Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.PhotoIdContainerImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPhotoIdContainer()
	 * @generated
	 */
	int PHOTO_ID_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Photo Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHOTO_ID_CONTAINER__PHOTO_ID = IMAGEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Photo Id Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHOTO_ID_CONTAINER_FEATURE_COUNT = IMAGEABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.NameContainer <em>Name Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.NameContainer
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNameContainer()
	 * @generated
	 */
	int NAME_CONTAINER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_CONTAINER__NAME = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Name Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_CONTAINER_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Informer <em>Informer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Informer
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getInformer()
	 * @generated
	 */
	int INFORMER = 11;

	/**
	 * The number of structural features of the '<em>Informer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Describable <em>Describable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Describable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDescribable()
	 * @generated
	 */
	int DESCRIBABLE = 12;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBABLE__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Describable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.BundleAware <em>Bundle Aware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.BundleAware
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBundleAware()
	 * @generated
	 */
	int BUNDLE_AWARE = 13;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_AWARE__BUNDLE = 0;

	/**
	 * The number of structural features of the '<em>Bundle Aware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_AWARE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.JavaClassLinked <em>Java Class Linked</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.JavaClassLinked
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getJavaClassLinked()
	 * @generated
	 */
	int JAVA_CLASS_LINKED = 14;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_LINKED__JAVA_CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_LINKED__JAVA_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_LINKED__JAVA_CLASS_STATUS = 2;

	/**
	 * The number of structural features of the '<em>Java Class Linked</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_CLASS_LINKED_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.EClassLinked <em>EClass Linked</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.EClassLinked
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEClassLinked()
	 * @generated
	 */
	int ECLASS_LINKED = 15;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED__ECLASS = 0;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED__ECLASS_STATUS = 1;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED__EPACKAGE_NS_PREFIX = 2;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED__ECLASS_NAME = 3;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED__EPACKAGE_NAME = 4;

	/**
	 * The number of structural features of the '<em>EClass Linked</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_LINKED_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.SchemaVersionable <em>Schema Versionable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.SchemaVersionable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSchemaVersionable()
	 * @generated
	 */
	int SCHEMA_VERSIONABLE = 16;

	/**
	 * The number of structural features of the '<em>Schema Versionable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_VERSIONABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.EFactoryLinked <em>EFactory Linked</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.EFactoryLinked
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEFactoryLinked()
	 * @generated
	 */
	int EFACTORY_LINKED = 17;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFACTORY_LINKED__EFACTORY = 0;

	/**
	 * The number of structural features of the '<em>EFactory Linked</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFACTORY_LINKED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.NsPrefixable <em>Ns Prefixable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.NsPrefixable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNsPrefixable()
	 * @generated
	 */
	int NS_PREFIXABLE = 18;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NS_PREFIXABLE__NS_PREFIX = 0;

	/**
	 * The number of structural features of the '<em>Ns Prefixable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NS_PREFIXABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.WebAddressImpl <em>Web Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.WebAddressImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getWebAddress()
	 * @generated
	 */
	int WEB_ADDRESS = 19;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__POSITIONER = POSITIONABLE__POSITIONER;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__BUNDLE = POSITIONABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__RESOURCE_TYPE = POSITIONABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__RESOURCE_URI = POSITIONABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__RESOURCE_NAME = POSITIONABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__BASE_URI = POSITIONABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__BASE_PATH = POSITIONABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Api Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__API_PATH = POSITIONABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__IMAGES_URI = POSITIONABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SKIN_URI = POSITIONABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__JS_URI = POSITIONABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Secure Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_BASE_URI = POSITIONABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Secure Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_IMAGES_URI = POSITIONABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Secure Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_SKIN_URI = POSITIONABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Secure Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS__SECURE_JS_URI = POSITIONABLE_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Web Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ADDRESS_FEATURE_COUNT = POSITIONABLE_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.EObjectLinked <em>EObject Linked</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.EObjectLinked
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEObjectLinked()
	 * @generated
	 */
	int EOBJECT_LINKED = 30;

	/**
	 * The number of structural features of the '<em>EObject Linked</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LINKED_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ModelNotificationImpl <em>Model Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ModelNotificationImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getModelNotification()
	 * @generated
	 */
	int MODEL_NOTIFICATION = 21;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_NOTIFICATION__CONTAINER = EOBJECT_LINKED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_NOTIFICATION_FEATURE_COUNT = EOBJECT_LINKED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ObjectNotificationImpl <em>Object Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ObjectNotificationImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getObjectNotification()
	 * @generated
	 */
	int OBJECT_NOTIFICATION = 25;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_NOTIFICATION__CONTAINER = MODEL_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_NOTIFICATION__OBJECT = MODEL_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_NOTIFICATION_FEATURE_COUNT = MODEL_NOTIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AddedImpl <em>Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AddedImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAdded()
	 * @generated
	 */
	int ADDED = 20;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED__CONTAINER = OBJECT_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED__OBJECT = OBJECT_NOTIFICATION__OBJECT;

	/**
	 * The number of structural features of the '<em>Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_FEATURE_COUNT = OBJECT_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AttributeNotificationImpl <em>Attribute Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AttributeNotificationImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeNotification()
	 * @generated
	 */
	int ATTRIBUTE_NOTIFICATION = 26;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION__CONTAINER = MODEL_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION__ATTRIBUTE = MODEL_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION__OBJECT = MODEL_NOTIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION__OLD_VALUE = MODEL_NOTIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION__NEW_VALUE = MODEL_NOTIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOTIFICATION_FEATURE_COUNT = MODEL_NOTIFICATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AttributeSetImpl <em>Attribute Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AttributeSetImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeSet()
	 * @generated
	 */
	int ATTRIBUTE_SET = 22;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__CONTAINER = ATTRIBUTE_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__ATTRIBUTE = ATTRIBUTE_NOTIFICATION__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__OBJECT = ATTRIBUTE_NOTIFICATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__OLD_VALUE = ATTRIBUTE_NOTIFICATION__OLD_VALUE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__NEW_VALUE = ATTRIBUTE_NOTIFICATION__NEW_VALUE;

	/**
	 * The number of structural features of the '<em>Attribute Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET_FEATURE_COUNT = ATTRIBUTE_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AttributeUnsetImpl <em>Attribute Unset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AttributeUnsetImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeUnset()
	 * @generated
	 */
	int ATTRIBUTE_UNSET = 23;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__CONTAINER = ATTRIBUTE_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__ATTRIBUTE = ATTRIBUTE_NOTIFICATION__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__OBJECT = ATTRIBUTE_NOTIFICATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__OLD_VALUE = ATTRIBUTE_NOTIFICATION__OLD_VALUE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__NEW_VALUE = ATTRIBUTE_NOTIFICATION__NEW_VALUE;

	/**
	 * The number of structural features of the '<em>Attribute Unset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET_FEATURE_COUNT = ATTRIBUTE_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.RemovedImpl <em>Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.RemovedImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getRemoved()
	 * @generated
	 */
	int REMOVED = 24;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED__CONTAINER = OBJECT_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED__OBJECT = OBJECT_NOTIFICATION__OBJECT;

	/**
	 * The number of structural features of the '<em>Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_FEATURE_COUNT = OBJECT_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ObjectsNotificationImpl <em>Objects Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ObjectsNotificationImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getObjectsNotification()
	 * @generated
	 */
	int OBJECTS_NOTIFICATION = 29;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS_NOTIFICATION__CONTAINER = MODEL_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS_NOTIFICATION__OBJECTS = MODEL_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Objects Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS_NOTIFICATION_FEATURE_COUNT = MODEL_NOTIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.AddedManyImpl <em>Added Many</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.AddedManyImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAddedMany()
	 * @generated
	 */
	int ADDED_MANY = 27;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_MANY__CONTAINER = OBJECTS_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_MANY__OBJECTS = OBJECTS_NOTIFICATION__OBJECTS;

	/**
	 * The number of structural features of the '<em>Added Many</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_MANY_FEATURE_COUNT = OBJECTS_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.RemovedManyImpl <em>Removed Many</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.RemovedManyImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getRemovedMany()
	 * @generated
	 */
	int REMOVED_MANY = 28;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_MANY__CONTAINER = OBJECTS_NOTIFICATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_MANY__OBJECTS = OBJECTS_NOTIFICATION__OBJECTS;

	/**
	 * The number of structural features of the '<em>Removed Many</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_MANY_FEATURE_COUNT = OBJECTS_NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.Parentable <em>Parentable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Parentable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getParentable()
	 * @generated
	 */
	int PARENTABLE = 31;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTABLE__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Parentable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.CategoryLike <em>Category Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.CategoryLike
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCategoryLike()
	 * @generated
	 */
	int CATEGORY_LIKE = 32;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__POSITIONER = POSITIONABLE__POSITIONER;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__SLUG = POSITIONABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__ID = POSITIONABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__NAME = POSITIONABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__SLUG_PATH = POSITIONABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__COLOR = POSITIONABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__IMAGE_ID = POSITIONABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__LEVEL = POSITIONABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE__CATEGORY_COUNT = POSITIONABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Category Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_LIKE_FEATURE_COUNT = POSITIONABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.CategoryInfoImpl <em>Category Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.CategoryInfoImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCategoryInfo()
	 * @generated
	 */
	int CATEGORY_INFO = 33;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__POSITIONER = CATEGORY_LIKE__POSITIONER;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__SLUG = CATEGORY_LIKE__SLUG;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__ID = CATEGORY_LIKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__NAME = CATEGORY_LIKE__NAME;

	/**
	 * The feature id for the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__SLUG_PATH = CATEGORY_LIKE__SLUG_PATH;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__COLOR = CATEGORY_LIKE__COLOR;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__IMAGE_ID = CATEGORY_LIKE__IMAGE_ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__LEVEL = CATEGORY_LIKE__LEVEL;

	/**
	 * The feature id for the '<em><b>Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__CATEGORY_COUNT = CATEGORY_LIKE__CATEGORY_COUNT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__PARENT = CATEGORY_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO__PARENTS = CATEGORY_LIKE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_INFO_FEATURE_COUNT = CATEGORY_LIKE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ProgressMonitorImpl <em>Progress Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ProgressMonitorImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressMonitor()
	 * @generated
	 */
	int PROGRESS_MONITOR = 34;

	/**
	 * The feature id for the '<em><b>Canceled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR__CANCELED = 0;

	/**
	 * The feature id for the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR__TASK_NAME = 1;

	/**
	 * The number of structural features of the '<em>Progress Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ShellProgressMonitorImpl <em>Shell Progress Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ShellProgressMonitorImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getShellProgressMonitor()
	 * @generated
	 */
	int SHELL_PROGRESS_MONITOR = 35;

	/**
	 * The feature id for the '<em><b>Canceled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_PROGRESS_MONITOR__CANCELED = PROGRESS_MONITOR__CANCELED;

	/**
	 * The feature id for the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_PROGRESS_MONITOR__TASK_NAME = PROGRESS_MONITOR__TASK_NAME;

	/**
	 * The number of structural features of the '<em>Shell Progress Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_PROGRESS_MONITOR_FEATURE_COUNT = PROGRESS_MONITOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.impl.ProgressMonitorWrapperImpl <em>Progress Monitor Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.ProgressMonitorWrapperImpl
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressMonitorWrapper()
	 * @generated
	 */
	int PROGRESS_MONITOR_WRAPPER = 36;

	/**
	 * The feature id for the '<em><b>Canceled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR_WRAPPER__CANCELED = PROGRESS_MONITOR__CANCELED;

	/**
	 * The feature id for the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR_WRAPPER__TASK_NAME = PROGRESS_MONITOR__TASK_NAME;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR_WRAPPER__DELEGATE = PROGRESS_MONITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Progress Monitor Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRESS_MONITOR_WRAPPER_FEATURE_COUNT = PROGRESS_MONITOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.ResourceType <em>Resource Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.ResourceType
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 37;


	/**
	 * The meta object id for the '{@link org.soluvas.commons.Gender <em>Gender</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Gender
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getGender()
	 * @generated
	 */
	int GENDER = 38;


	/**
	 * The meta object id for the '{@link org.soluvas.commons.EClassStatus <em>EClass Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.EClassStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEClassStatus()
	 * @generated
	 */
	int ECLASS_STATUS = 39;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.JavaClassStatus <em>Java Class Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getJavaClassStatus()
	 * @generated
	 */
	int JAVA_CLASS_STATUS = 40;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.ProgressStatus <em>Progress Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.ProgressStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressStatus()
	 * @generated
	 */
	int PROGRESS_STATUS = 41;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.AccountStatus <em>Account Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.AccountStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAccountStatus()
	 * @generated
	 */
	int ACCOUNT_STATUS = 42;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.PublicationStatus <em>Publication Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.PublicationStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPublicationStatus()
	 * @generated
	 */
	int PUBLICATION_STATUS = 43;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.ArchivalStatus <em>Archival Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.ArchivalStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getArchivalStatus()
	 * @generated
	 */
	int ARCHIVAL_STATUS = 44;

	/**
	 * The meta object id for the '<em>Date Time</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.time.DateTime
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDateTime()
	 * @generated
	 */
	int DATE_TIME = 45;

	/**
	 * The meta object id for the '<em>Currency Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.money.CurrencyUnit
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCurrencyUnit()
	 * @generated
	 */
	int CURRENCY_UNIT = 46;

	/**
	 * The meta object id for the '<em>Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.unit.Unit
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 48;


	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getList()
	 * @generated
	 */
	int LIST = 49;

	/**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 50;

	/**
	 * The meta object id for the '<em>Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSet()
	 * @generated
	 */
	int SET = 51;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 52;

	/**
	 * The meta object id for the '<em>Multimap</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.google.common.collect.Multimap
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultimap()
	 * @generated
	 */
	int MULTIMAP = 53;

	/**
	 * The meta object id for the '<em>Navigable Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.NavigableMap
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNavigableMap()
	 * @generated
	 */
	int NAVIGABLE_MAP = 54;

	/**
	 * The meta object id for the '<em>Queue</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Queue
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getQueue()
	 * @generated
	 */
	int QUEUE = 55;

	/**
	 * The meta object id for the '<em>Multiset</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.google.common.collect.Multiset
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultiset()
	 * @generated
	 */
	int MULTISET = 56;


	/**
	 * The meta object id for the '<em>Serializable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Serializable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSerializable()
	 * @generated
	 */
	int SERIALIZABLE = 57;


	/**
	 * The meta object id for the '<em>Bundle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.Bundle
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 58;


	/**
	 * The meta object id for the '<em>Big Money Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.money.BigMoneyProvider
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBigMoneyProvider()
	 * @generated
	 */
	int BIG_MONEY_PROVIDER = 59;

	/**
	 * The meta object id for the '<em>Quantity</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.quantity.Quantity
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getQuantity()
	 * @generated
	 */
	int QUANTITY = 47;

	/**
	 * The meta object id for the '<em>Measurable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.Measurable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMeasurable()
	 * @generated
	 */
	int MEASURABLE = 60;


	/**
	 * The meta object id for the '<em>Big Decimal</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBigDecimal()
	 * @generated
	 */
	int BIG_DECIMAL = 61;


	/**
	 * The meta object id for the '<em>Date Time Zone</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.time.DateTimeZone
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDateTimeZone()
	 * @generated
	 */
	int DATE_TIME_ZONE = 62;


	/**
	 * The meta object id for the '<em>Locale</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Locale
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getLocale()
	 * @generated
	 */
	int LOCALE = 63;


	/**
	 * The meta object id for the '<em>File</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 64;


	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ResourceAware <em>Resource Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Aware</em>'.
	 * @see org.soluvas.commons.ResourceAware
	 * @generated
	 */
	EClass getResourceAware();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ResourceAware#getResourceUri <em>Resource Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Uri</em>'.
	 * @see org.soluvas.commons.ResourceAware#getResourceUri()
	 * @see #getResourceAware()
	 * @generated
	 */
	EAttribute getResourceAware_ResourceUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ResourceAware#getResourceName <em>Resource Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Name</em>'.
	 * @see org.soluvas.commons.ResourceAware#getResourceName()
	 * @see #getResourceAware()
	 * @generated
	 */
	EAttribute getResourceAware_ResourceName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Positionable <em>Positionable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Positionable</em>'.
	 * @see org.soluvas.commons.Positionable
	 * @generated
	 */
	EClass getPositionable();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Positionable#getPositioner <em>Positioner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positioner</em>'.
	 * @see org.soluvas.commons.Positionable#getPositioner()
	 * @see #getPositionable()
	 * @generated
	 */
	EAttribute getPositionable_Positioner();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ResourceAware#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Type</em>'.
	 * @see org.soluvas.commons.ResourceAware#getResourceType()
	 * @see #getResourceAware()
	 * @generated
	 */
	EAttribute getResourceAware_ResourceType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.AppManifest <em>App Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Manifest</em>'.
	 * @see org.soluvas.commons.AppManifest
	 * @generated
	 */
	EClass getAppManifest();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.commons.AppManifest#getTitle()
	 * @see #getAppManifest()
	 * @generated
	 */
	EAttribute getAppManifest_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.commons.AppManifest#getDescription()
	 * @see #getAppManifest()
	 * @generated
	 */
	EAttribute getAppManifest_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see org.soluvas.commons.AppManifest#getDomain()
	 * @see #getAppManifest()
	 * @generated
	 */
	EAttribute getAppManifest_Domain();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.PersonInfo <em>Person Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person Info</em>'.
	 * @see org.soluvas.commons.PersonInfo
	 * @generated
	 */
	EClass getPersonInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.PersonInfo#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see org.soluvas.commons.PersonInfo#getGender()
	 * @see #getPersonInfo()
	 * @generated
	 */
	EAttribute getPersonInfo_Gender();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.PersonInfo#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.soluvas.commons.PersonInfo#getEmail()
	 * @see #getPersonInfo()
	 * @generated
	 */
	EAttribute getPersonInfo_Email();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Timestamped <em>Timestamped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timestamped</em>'.
	 * @see org.soluvas.commons.Timestamped
	 * @generated
	 */
	EClass getTimestamped();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Timestamped#getCreationTime <em>Creation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Time</em>'.
	 * @see org.soluvas.commons.Timestamped#getCreationTime()
	 * @see #getTimestamped()
	 * @generated
	 */
	EAttribute getTimestamped_CreationTime();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Timestamped#getModificationTime <em>Modification Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modification Time</em>'.
	 * @see org.soluvas.commons.Timestamped#getModificationTime()
	 * @see #getTimestamped()
	 * @generated
	 */
	EAttribute getTimestamped_ModificationTime();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see org.soluvas.commons.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Identifiable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.soluvas.commons.Identifiable#getId()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Id();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Sluggable <em>Sluggable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sluggable</em>'.
	 * @see org.soluvas.commons.Sluggable
	 * @generated
	 */
	EClass getSluggable();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Sluggable#getSlug <em>Slug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slug</em>'.
	 * @see org.soluvas.commons.Sluggable#getSlug()
	 * @see #getSluggable()
	 * @generated
	 */
	EAttribute getSluggable_Slug();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.soluvas.commons.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Imageable <em>Imageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imageable</em>'.
	 * @see org.soluvas.commons.Imageable
	 * @generated
	 */
	EClass getImageable();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.PhotoIdContainer <em>Photo Id Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Photo Id Container</em>'.
	 * @see org.soluvas.commons.PhotoIdContainer
	 * @generated
	 */
	EClass getPhotoIdContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.PhotoIdContainer#getPhotoId <em>Photo Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Photo Id</em>'.
	 * @see org.soluvas.commons.PhotoIdContainer#getPhotoId()
	 * @see #getPhotoIdContainer()
	 * @generated
	 */
	EAttribute getPhotoIdContainer_PhotoId();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.NameContainer <em>Name Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Container</em>'.
	 * @see org.soluvas.commons.NameContainer
	 * @generated
	 */
	EClass getNameContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.NameContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.commons.NameContainer#getName()
	 * @see #getNameContainer()
	 * @generated
	 */
	EAttribute getNameContainer_Name();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Informer <em>Informer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Informer</em>'.
	 * @see org.soluvas.commons.Informer
	 * @generated
	 */
	EClass getInformer();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Describable <em>Describable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Describable</em>'.
	 * @see org.soluvas.commons.Describable
	 * @generated
	 */
	EClass getDescribable();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.Describable#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.commons.Describable#getDescription()
	 * @see #getDescribable()
	 * @generated
	 */
	EAttribute getDescribable_Description();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.BundleAware <em>Bundle Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle Aware</em>'.
	 * @see org.soluvas.commons.BundleAware
	 * @generated
	 */
	EClass getBundleAware();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.BundleAware#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle</em>'.
	 * @see org.soluvas.commons.BundleAware#getBundle()
	 * @see #getBundleAware()
	 * @generated
	 */
	EAttribute getBundleAware_Bundle();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.JavaClassLinked <em>Java Class Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Class Linked</em>'.
	 * @see org.soluvas.commons.JavaClassLinked
	 * @generated
	 */
	EClass getJavaClassLinked();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.JavaClassLinked#getJavaClassName <em>Java Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Class Name</em>'.
	 * @see org.soluvas.commons.JavaClassLinked#getJavaClassName()
	 * @see #getJavaClassLinked()
	 * @generated
	 */
	EAttribute getJavaClassLinked_JavaClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.JavaClassLinked#getJavaClass <em>Java Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Class</em>'.
	 * @see org.soluvas.commons.JavaClassLinked#getJavaClass()
	 * @see #getJavaClassLinked()
	 * @generated
	 */
	EAttribute getJavaClassLinked_JavaClass();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.JavaClassLinked#getJavaClassStatus <em>Java Class Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Class Status</em>'.
	 * @see org.soluvas.commons.JavaClassLinked#getJavaClassStatus()
	 * @see #getJavaClassLinked()
	 * @generated
	 */
	EAttribute getJavaClassLinked_JavaClassStatus();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.EClassLinked <em>EClass Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Linked</em>'.
	 * @see org.soluvas.commons.EClassLinked
	 * @generated
	 */
	EClass getEClassLinked();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.EClassLinked#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.soluvas.commons.EClassLinked#getEClass()
	 * @see #getEClassLinked()
	 * @generated
	 */
	EReference getEClassLinked_EClass();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.EClassLinked#getEClassStatus <em>EClass Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EClass Status</em>'.
	 * @see org.soluvas.commons.EClassLinked#getEClassStatus()
	 * @see #getEClassLinked()
	 * @generated
	 */
	EAttribute getEClassLinked_EClassStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.EClassLinked#getEPackageNsPrefix <em>EPackage Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EPackage Ns Prefix</em>'.
	 * @see org.soluvas.commons.EClassLinked#getEPackageNsPrefix()
	 * @see #getEClassLinked()
	 * @generated
	 */
	EAttribute getEClassLinked_EPackageNsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.EClassLinked#getEClassName <em>EClass Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EClass Name</em>'.
	 * @see org.soluvas.commons.EClassLinked#getEClassName()
	 * @see #getEClassLinked()
	 * @generated
	 */
	EAttribute getEClassLinked_EClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.EClassLinked#getEPackageName <em>EPackage Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EPackage Name</em>'.
	 * @see org.soluvas.commons.EClassLinked#getEPackageName()
	 * @see #getEClassLinked()
	 * @generated
	 */
	EAttribute getEClassLinked_EPackageName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.SchemaVersionable <em>Schema Versionable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Versionable</em>'.
	 * @see org.soluvas.commons.SchemaVersionable
	 * @generated
	 */
	EClass getSchemaVersionable();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.EFactoryLinked <em>EFactory Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFactory Linked</em>'.
	 * @see org.soluvas.commons.EFactoryLinked
	 * @generated
	 */
	EClass getEFactoryLinked();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.EFactoryLinked#getEFactory <em>EFactory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EFactory</em>'.
	 * @see org.soluvas.commons.EFactoryLinked#getEFactory()
	 * @see #getEFactoryLinked()
	 * @generated
	 */
	EReference getEFactoryLinked_EFactory();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.NsPrefixable <em>Ns Prefixable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ns Prefixable</em>'.
	 * @see org.soluvas.commons.NsPrefixable
	 * @generated
	 */
	EClass getNsPrefixable();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.NsPrefixable#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.soluvas.commons.NsPrefixable#getNsPrefix()
	 * @see #getNsPrefixable()
	 * @generated
	 */
	EAttribute getNsPrefixable_NsPrefix();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.WebAddress <em>Web Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Address</em>'.
	 * @see org.soluvas.commons.WebAddress
	 * @generated
	 */
	EClass getWebAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getBaseUri <em>Base Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getBaseUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_BaseUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getBasePath <em>Base Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Path</em>'.
	 * @see org.soluvas.commons.WebAddress#getBasePath()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_BasePath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getApiPath <em>Api Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Path</em>'.
	 * @see org.soluvas.commons.WebAddress#getApiPath()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_ApiPath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getImagesUri <em>Images Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Images Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getImagesUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_ImagesUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getSkinUri <em>Skin Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skin Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getSkinUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SkinUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getJsUri <em>Js Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Js Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getJsUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_JsUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Base Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getSecureBaseUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureBaseUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Images Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getSecureImagesUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureImagesUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getSecureSkinUri <em>Secure Skin Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Skin Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getSecureSkinUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureSkinUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Js Uri</em>'.
	 * @see org.soluvas.commons.WebAddress#getSecureJsUri()
	 * @see #getWebAddress()
	 * @generated
	 */
	EAttribute getWebAddress_SecureJsUri();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Added <em>Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Added</em>'.
	 * @see org.soluvas.commons.Added
	 * @generated
	 */
	EClass getAdded();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ModelNotification <em>Model Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Notification</em>'.
	 * @see org.soluvas.commons.ModelNotification
	 * @generated
	 */
	EClass getModelNotification();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.ModelNotification#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.soluvas.commons.ModelNotification#getContainer()
	 * @see #getModelNotification()
	 * @generated
	 */
	EReference getModelNotification_Container();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.AttributeSet <em>Attribute Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Set</em>'.
	 * @see org.soluvas.commons.AttributeSet
	 * @generated
	 */
	EClass getAttributeSet();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.AttributeUnset <em>Attribute Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Unset</em>'.
	 * @see org.soluvas.commons.AttributeUnset
	 * @generated
	 */
	EClass getAttributeUnset();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Removed <em>Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Removed</em>'.
	 * @see org.soluvas.commons.Removed
	 * @generated
	 */
	EClass getRemoved();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ObjectNotification <em>Object Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Notification</em>'.
	 * @see org.soluvas.commons.ObjectNotification
	 * @generated
	 */
	EClass getObjectNotification();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ObjectNotification#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.soluvas.commons.ObjectNotification#getObject()
	 * @see #getObjectNotification()
	 * @generated
	 */
	EAttribute getObjectNotification_Object();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.AttributeNotification <em>Attribute Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Notification</em>'.
	 * @see org.soluvas.commons.AttributeNotification
	 * @generated
	 */
	EClass getAttributeNotification();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.AttributeNotification#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.soluvas.commons.AttributeNotification#getAttribute()
	 * @see #getAttributeNotification()
	 * @generated
	 */
	EReference getAttributeNotification_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AttributeNotification#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.soluvas.commons.AttributeNotification#getObject()
	 * @see #getAttributeNotification()
	 * @generated
	 */
	EAttribute getAttributeNotification_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AttributeNotification#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.soluvas.commons.AttributeNotification#getOldValue()
	 * @see #getAttributeNotification()
	 * @generated
	 */
	EAttribute getAttributeNotification_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.AttributeNotification#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.soluvas.commons.AttributeNotification#getNewValue()
	 * @see #getAttributeNotification()
	 * @generated
	 */
	EAttribute getAttributeNotification_NewValue();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.AddedMany <em>Added Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Added Many</em>'.
	 * @see org.soluvas.commons.AddedMany
	 * @generated
	 */
	EClass getAddedMany();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.RemovedMany <em>Removed Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Removed Many</em>'.
	 * @see org.soluvas.commons.RemovedMany
	 * @generated
	 */
	EClass getRemovedMany();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ObjectsNotification <em>Objects Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objects Notification</em>'.
	 * @see org.soluvas.commons.ObjectsNotification
	 * @generated
	 */
	EClass getObjectsNotification();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.commons.ObjectsNotification#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Objects</em>'.
	 * @see org.soluvas.commons.ObjectsNotification#getObjects()
	 * @see #getObjectsNotification()
	 * @generated
	 */
	EAttribute getObjectsNotification_Objects();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.EObjectLinked <em>EObject Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Linked</em>'.
	 * @see org.soluvas.commons.EObjectLinked
	 * @generated
	 */
	EClass getEObjectLinked();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.Parentable <em>Parentable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parentable</em>'.
	 * @see org.soluvas.commons.Parentable
	 * @generated
	 */
	EClass getParentable();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.Parentable#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.soluvas.commons.Parentable#getParent()
	 * @see #getParentable()
	 * @generated
	 */
	EReference getParentable_Parent();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.CategoryLike <em>Category Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Like</em>'.
	 * @see org.soluvas.commons.CategoryLike
	 * @generated
	 */
	EClass getCategoryLike();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.CategoryLike#getSlugPath <em>Slug Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slug Path</em>'.
	 * @see org.soluvas.commons.CategoryLike#getSlugPath()
	 * @see #getCategoryLike()
	 * @generated
	 */
	EAttribute getCategoryLike_SlugPath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.CategoryLike#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.soluvas.commons.CategoryLike#getColor()
	 * @see #getCategoryLike()
	 * @generated
	 */
	EAttribute getCategoryLike_Color();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.CategoryLike#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.soluvas.commons.CategoryLike#getImageId()
	 * @see #getCategoryLike()
	 * @generated
	 */
	EAttribute getCategoryLike_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.CategoryLike#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.soluvas.commons.CategoryLike#getLevel()
	 * @see #getCategoryLike()
	 * @generated
	 */
	EAttribute getCategoryLike_Level();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.CategoryLike#getCategoryCount <em>Category Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Count</em>'.
	 * @see org.soluvas.commons.CategoryLike#getCategoryCount()
	 * @see #getCategoryLike()
	 * @generated
	 */
	EAttribute getCategoryLike_CategoryCount();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.CategoryInfo <em>Category Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Info</em>'.
	 * @see org.soluvas.commons.CategoryInfo
	 * @generated
	 */
	EClass getCategoryInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.commons.CategoryInfo#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parents</em>'.
	 * @see org.soluvas.commons.CategoryInfo#getParents()
	 * @see #getCategoryInfo()
	 * @generated
	 */
	EReference getCategoryInfo_Parents();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ProgressMonitor <em>Progress Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Progress Monitor</em>'.
	 * @see org.soluvas.commons.ProgressMonitor
	 * @generated
	 */
	EClass getProgressMonitor();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ProgressMonitor#isCanceled <em>Canceled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Canceled</em>'.
	 * @see org.soluvas.commons.ProgressMonitor#isCanceled()
	 * @see #getProgressMonitor()
	 * @generated
	 */
	EAttribute getProgressMonitor_Canceled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.commons.ProgressMonitor#getTaskName <em>Task Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Name</em>'.
	 * @see org.soluvas.commons.ProgressMonitor#getTaskName()
	 * @see #getProgressMonitor()
	 * @generated
	 */
	EAttribute getProgressMonitor_TaskName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ShellProgressMonitor <em>Shell Progress Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shell Progress Monitor</em>'.
	 * @see org.soluvas.commons.ShellProgressMonitor
	 * @generated
	 */
	EClass getShellProgressMonitor();

	/**
	 * Returns the meta object for class '{@link org.soluvas.commons.ProgressMonitorWrapper <em>Progress Monitor Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Progress Monitor Wrapper</em>'.
	 * @see org.soluvas.commons.ProgressMonitorWrapper
	 * @generated
	 */
	EClass getProgressMonitorWrapper();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.commons.ProgressMonitorWrapper#getDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegate</em>'.
	 * @see org.soluvas.commons.ProgressMonitorWrapper#getDelegate()
	 * @see #getProgressMonitorWrapper()
	 * @generated
	 */
	EReference getProgressMonitorWrapper_Delegate();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Type</em>'.
	 * @see org.soluvas.commons.ResourceType
	 * @generated
	 */
	EEnum getResourceType();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.Gender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gender</em>'.
	 * @see org.soluvas.commons.Gender
	 * @generated
	 */
	EEnum getGender();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.EClassStatus <em>EClass Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EClass Status</em>'.
	 * @see org.soluvas.commons.EClassStatus
	 * @generated
	 */
	EEnum getEClassStatus();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.JavaClassStatus <em>Java Class Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Java Class Status</em>'.
	 * @see org.soluvas.commons.JavaClassStatus
	 * @generated
	 */
	EEnum getJavaClassStatus();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.ProgressStatus <em>Progress Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Progress Status</em>'.
	 * @see org.soluvas.commons.ProgressStatus
	 * @generated
	 */
	EEnum getProgressStatus();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.AccountStatus <em>Account Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Account Status</em>'.
	 * @see org.soluvas.commons.AccountStatus
	 * @generated
	 */
	EEnum getAccountStatus();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.PublicationStatus <em>Publication Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Publication Status</em>'.
	 * @see org.soluvas.commons.PublicationStatus
	 * @generated
	 */
	EEnum getPublicationStatus();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.commons.ArchivalStatus <em>Archival Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Archival Status</em>'.
	 * @see org.soluvas.commons.ArchivalStatus
	 * @generated
	 */
	EEnum getArchivalStatus();

	/**
	 * Returns the meta object for data type '{@link org.joda.time.DateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date Time</em>'.
	 * @see org.joda.time.DateTime
	 * @model instanceClass="org.joda.time.DateTime"
	 * @generated
	 */
	EDataType getDateTime();

	/**
	 * Returns the meta object for data type '{@link org.joda.money.CurrencyUnit <em>Currency Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Currency Unit</em>'.
	 * @see org.joda.money.CurrencyUnit
	 * @model instanceClass="org.joda.money.CurrencyUnit"
	 * @generated
	 */
	EDataType getCurrencyUnit();

	/**
	 * Returns the meta object for data type '{@link javax.measure.unit.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unit</em>'.
	 * @see javax.measure.unit.Unit
	 * @model instanceClass="javax.measure.unit.Unit" typeParameters="Q" QBounds="org.soluvas.commons.Quantity"
	 * @generated
	 */
	EDataType getUnit();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="T"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" typeParameters="K V"
	 * @generated
	 */
	EDataType getMap();

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set" typeParameters="T"
	 * @generated
	 */
	EDataType getSet();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	EDataType getCollection();

	/**
	 * Returns the meta object for data type '{@link com.google.common.collect.Multimap <em>Multimap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Multimap</em>'.
	 * @see com.google.common.collect.Multimap
	 * @model instanceClass="com.google.common.collect.Multimap" typeParameters="K V"
	 * @generated
	 */
	EDataType getMultimap();

	/**
	 * Returns the meta object for data type '{@link java.util.NavigableMap <em>Navigable Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Navigable Map</em>'.
	 * @see java.util.NavigableMap
	 * @model instanceClass="java.util.NavigableMap" typeParameters="K V"
	 * @generated
	 */
	EDataType getNavigableMap();

	/**
	 * Returns the meta object for data type '{@link java.util.Queue <em>Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Queue</em>'.
	 * @see java.util.Queue
	 * @model instanceClass="java.util.Queue" typeParameters="T"
	 * @generated
	 */
	EDataType getQueue();

	/**
	 * Returns the meta object for data type '{@link com.google.common.collect.Multiset <em>Multiset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Multiset</em>'.
	 * @see com.google.common.collect.Multiset
	 * @model instanceClass="com.google.common.collect.Multiset" typeParameters="T"
	 * @generated
	 */
	EDataType getMultiset();

	/**
	 * Returns the meta object for data type '{@link java.io.Serializable <em>Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Serializable</em>'.
	 * @see java.io.Serializable
	 * @model instanceClass="java.io.Serializable"
	 * @generated
	 */
	EDataType getSerializable();

	/**
	 * Returns the meta object for data type '{@link org.osgi.framework.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bundle</em>'.
	 * @see org.osgi.framework.Bundle
	 * @model instanceClass="org.osgi.framework.Bundle" serializeable="false"
	 * @generated
	 */
	EDataType getBundle();

	/**
	 * Returns the meta object for data type '{@link org.joda.money.BigMoneyProvider <em>Big Money Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Big Money Provider</em>'.
	 * @see org.joda.money.BigMoneyProvider
	 * @model instanceClass="org.joda.money.BigMoneyProvider"
	 * @generated
	 */
	EDataType getBigMoneyProvider();

	/**
	 * Returns the meta object for data type '{@link javax.measure.quantity.Quantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Quantity</em>'.
	 * @see javax.measure.quantity.Quantity
	 * @model instanceClass="javax.measure.quantity.Quantity"
	 * @generated
	 */
	EDataType getQuantity();

	/**
	 * Returns the meta object for data type '{@link javax.measure.Measurable <em>Measurable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Measurable</em>'.
	 * @see javax.measure.Measurable
	 * @model instanceClass="javax.measure.Measurable" typeParameters="Q" QBounds="org.soluvas.commons.Quantity"
	 * @generated
	 */
	EDataType getMeasurable();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Big Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Big Decimal</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 * @generated
	 */
	EDataType getBigDecimal();

	/**
	 * Returns the meta object for data type '{@link org.joda.time.DateTimeZone <em>Date Time Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date Time Zone</em>'.
	 * @see org.joda.time.DateTimeZone
	 * @model instanceClass="org.joda.time.DateTimeZone"
	 * @generated
	 */
	EDataType getDateTimeZone();

	/**
	 * Returns the meta object for data type '{@link java.util.Locale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Locale</em>'.
	 * @see java.util.Locale
	 * @model instanceClass="java.util.Locale"
	 * @generated
	 */
	EDataType getLocale();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 * @generated
	 */
	EDataType getFile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonsFactory getCommonsFactory();

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
		 * The meta object literal for the '{@link org.soluvas.commons.ResourceAware <em>Resource Aware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.ResourceAware
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getResourceAware()
		 * @generated
		 */
		EClass RESOURCE_AWARE = eINSTANCE.getResourceAware();

		/**
		 * The meta object literal for the '<em><b>Resource Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_AWARE__RESOURCE_URI = eINSTANCE.getResourceAware_ResourceUri();

		/**
		 * The meta object literal for the '<em><b>Resource Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_AWARE__RESOURCE_NAME = eINSTANCE.getResourceAware_ResourceName();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Positionable <em>Positionable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Positionable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPositionable()
		 * @generated
		 */
		EClass POSITIONABLE = eINSTANCE.getPositionable();

		/**
		 * The meta object literal for the '<em><b>Positioner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITIONABLE__POSITIONER = eINSTANCE.getPositionable_Positioner();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_AWARE__RESOURCE_TYPE = eINSTANCE.getResourceAware_ResourceType();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AppManifestImpl <em>App Manifest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AppManifestImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAppManifest()
		 * @generated
		 */
		EClass APP_MANIFEST = eINSTANCE.getAppManifest();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_MANIFEST__TITLE = eINSTANCE.getAppManifest_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_MANIFEST__DESCRIPTION = eINSTANCE.getAppManifest_Description();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_MANIFEST__DOMAIN = eINSTANCE.getAppManifest_Domain();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.PersonInfoImpl <em>Person Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.PersonInfoImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPersonInfo()
		 * @generated
		 */
		EClass PERSON_INFO = eINSTANCE.getPersonInfo();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_INFO__GENDER = eINSTANCE.getPersonInfo_Gender();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_INFO__EMAIL = eINSTANCE.getPersonInfo_Email();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Timestamped <em>Timestamped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Timestamped
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getTimestamped()
		 * @generated
		 */
		EClass TIMESTAMPED = eINSTANCE.getTimestamped();

		/**
		 * The meta object literal for the '<em><b>Creation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMESTAMPED__CREATION_TIME = eINSTANCE.getTimestamped_CreationTime();

		/**
		 * The meta object literal for the '<em><b>Modification Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMESTAMPED__MODIFICATION_TIME = eINSTANCE.getTimestamped_ModificationTime();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Identifiable <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Identifiable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_Id();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Sluggable <em>Sluggable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Sluggable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSluggable()
		 * @generated
		 */
		EClass SLUGGABLE = eINSTANCE.getSluggable();

		/**
		 * The meta object literal for the '<em><b>Slug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLUGGABLE__SLUG = eINSTANCE.getSluggable_Slug();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Nameable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Imageable <em>Imageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Imageable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getImageable()
		 * @generated
		 */
		EClass IMAGEABLE = eINSTANCE.getImageable();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.PhotoIdContainerImpl <em>Photo Id Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.PhotoIdContainerImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPhotoIdContainer()
		 * @generated
		 */
		EClass PHOTO_ID_CONTAINER = eINSTANCE.getPhotoIdContainer();

		/**
		 * The meta object literal for the '<em><b>Photo Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHOTO_ID_CONTAINER__PHOTO_ID = eINSTANCE.getPhotoIdContainer_PhotoId();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.NameContainer <em>Name Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.NameContainer
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNameContainer()
		 * @generated
		 */
		EClass NAME_CONTAINER = eINSTANCE.getNameContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_CONTAINER__NAME = eINSTANCE.getNameContainer_Name();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Informer <em>Informer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Informer
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getInformer()
		 * @generated
		 */
		EClass INFORMER = eINSTANCE.getInformer();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Describable <em>Describable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Describable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDescribable()
		 * @generated
		 */
		EClass DESCRIBABLE = eINSTANCE.getDescribable();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIBABLE__DESCRIPTION = eINSTANCE.getDescribable_Description();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.BundleAware <em>Bundle Aware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.BundleAware
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBundleAware()
		 * @generated
		 */
		EClass BUNDLE_AWARE = eINSTANCE.getBundleAware();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_AWARE__BUNDLE = eINSTANCE.getBundleAware_Bundle();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.JavaClassLinked <em>Java Class Linked</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.JavaClassLinked
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getJavaClassLinked()
		 * @generated
		 */
		EClass JAVA_CLASS_LINKED = eINSTANCE.getJavaClassLinked();

		/**
		 * The meta object literal for the '<em><b>Java Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS_LINKED__JAVA_CLASS_NAME = eINSTANCE.getJavaClassLinked_JavaClassName();

		/**
		 * The meta object literal for the '<em><b>Java Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS_LINKED__JAVA_CLASS = eINSTANCE.getJavaClassLinked_JavaClass();

		/**
		 * The meta object literal for the '<em><b>Java Class Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_CLASS_LINKED__JAVA_CLASS_STATUS = eINSTANCE.getJavaClassLinked_JavaClassStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.EClassLinked <em>EClass Linked</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.EClassLinked
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEClassLinked()
		 * @generated
		 */
		EClass ECLASS_LINKED = eINSTANCE.getEClassLinked();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLASS_LINKED__ECLASS = eINSTANCE.getEClassLinked_EClass();

		/**
		 * The meta object literal for the '<em><b>EClass Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS_LINKED__ECLASS_STATUS = eINSTANCE.getEClassLinked_EClassStatus();

		/**
		 * The meta object literal for the '<em><b>EPackage Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS_LINKED__EPACKAGE_NS_PREFIX = eINSTANCE.getEClassLinked_EPackageNsPrefix();

		/**
		 * The meta object literal for the '<em><b>EClass Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS_LINKED__ECLASS_NAME = eINSTANCE.getEClassLinked_EClassName();

		/**
		 * The meta object literal for the '<em><b>EPackage Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLASS_LINKED__EPACKAGE_NAME = eINSTANCE.getEClassLinked_EPackageName();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.SchemaVersionable <em>Schema Versionable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.SchemaVersionable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSchemaVersionable()
		 * @generated
		 */
		EClass SCHEMA_VERSIONABLE = eINSTANCE.getSchemaVersionable();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.EFactoryLinked <em>EFactory Linked</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.EFactoryLinked
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEFactoryLinked()
		 * @generated
		 */
		EClass EFACTORY_LINKED = eINSTANCE.getEFactoryLinked();

		/**
		 * The meta object literal for the '<em><b>EFactory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFACTORY_LINKED__EFACTORY = eINSTANCE.getEFactoryLinked_EFactory();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.NsPrefixable <em>Ns Prefixable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.NsPrefixable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNsPrefixable()
		 * @generated
		 */
		EClass NS_PREFIXABLE = eINSTANCE.getNsPrefixable();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NS_PREFIXABLE__NS_PREFIX = eINSTANCE.getNsPrefixable_NsPrefix();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.WebAddressImpl <em>Web Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.WebAddressImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getWebAddress()
		 * @generated
		 */
		EClass WEB_ADDRESS = eINSTANCE.getWebAddress();

		/**
		 * The meta object literal for the '<em><b>Base Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__BASE_URI = eINSTANCE.getWebAddress_BaseUri();

		/**
		 * The meta object literal for the '<em><b>Base Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__BASE_PATH = eINSTANCE.getWebAddress_BasePath();

		/**
		 * The meta object literal for the '<em><b>Api Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__API_PATH = eINSTANCE.getWebAddress_ApiPath();

		/**
		 * The meta object literal for the '<em><b>Images Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__IMAGES_URI = eINSTANCE.getWebAddress_ImagesUri();

		/**
		 * The meta object literal for the '<em><b>Skin Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SKIN_URI = eINSTANCE.getWebAddress_SkinUri();

		/**
		 * The meta object literal for the '<em><b>Js Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__JS_URI = eINSTANCE.getWebAddress_JsUri();

		/**
		 * The meta object literal for the '<em><b>Secure Base Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_BASE_URI = eINSTANCE.getWebAddress_SecureBaseUri();

		/**
		 * The meta object literal for the '<em><b>Secure Images Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_IMAGES_URI = eINSTANCE.getWebAddress_SecureImagesUri();

		/**
		 * The meta object literal for the '<em><b>Secure Skin Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_SKIN_URI = eINSTANCE.getWebAddress_SecureSkinUri();

		/**
		 * The meta object literal for the '<em><b>Secure Js Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_ADDRESS__SECURE_JS_URI = eINSTANCE.getWebAddress_SecureJsUri();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AddedImpl <em>Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AddedImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAdded()
		 * @generated
		 */
		EClass ADDED = eINSTANCE.getAdded();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ModelNotificationImpl <em>Model Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ModelNotificationImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getModelNotification()
		 * @generated
		 */
		EClass MODEL_NOTIFICATION = eINSTANCE.getModelNotification();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_NOTIFICATION__CONTAINER = eINSTANCE.getModelNotification_Container();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AttributeSetImpl <em>Attribute Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AttributeSetImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeSet()
		 * @generated
		 */
		EClass ATTRIBUTE_SET = eINSTANCE.getAttributeSet();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AttributeUnsetImpl <em>Attribute Unset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AttributeUnsetImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeUnset()
		 * @generated
		 */
		EClass ATTRIBUTE_UNSET = eINSTANCE.getAttributeUnset();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.RemovedImpl <em>Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.RemovedImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getRemoved()
		 * @generated
		 */
		EClass REMOVED = eINSTANCE.getRemoved();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ObjectNotificationImpl <em>Object Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ObjectNotificationImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getObjectNotification()
		 * @generated
		 */
		EClass OBJECT_NOTIFICATION = eINSTANCE.getObjectNotification();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_NOTIFICATION__OBJECT = eINSTANCE.getObjectNotification_Object();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AttributeNotificationImpl <em>Attribute Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AttributeNotificationImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAttributeNotification()
		 * @generated
		 */
		EClass ATTRIBUTE_NOTIFICATION = eINSTANCE.getAttributeNotification();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_NOTIFICATION__ATTRIBUTE = eINSTANCE.getAttributeNotification_Attribute();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_NOTIFICATION__OBJECT = eINSTANCE.getAttributeNotification_Object();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_NOTIFICATION__OLD_VALUE = eINSTANCE.getAttributeNotification_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_NOTIFICATION__NEW_VALUE = eINSTANCE.getAttributeNotification_NewValue();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.AddedManyImpl <em>Added Many</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.AddedManyImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAddedMany()
		 * @generated
		 */
		EClass ADDED_MANY = eINSTANCE.getAddedMany();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.RemovedManyImpl <em>Removed Many</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.RemovedManyImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getRemovedMany()
		 * @generated
		 */
		EClass REMOVED_MANY = eINSTANCE.getRemovedMany();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ObjectsNotificationImpl <em>Objects Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ObjectsNotificationImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getObjectsNotification()
		 * @generated
		 */
		EClass OBJECTS_NOTIFICATION = eINSTANCE.getObjectsNotification();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECTS_NOTIFICATION__OBJECTS = eINSTANCE.getObjectsNotification_Objects();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.EObjectLinked <em>EObject Linked</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.EObjectLinked
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEObjectLinked()
		 * @generated
		 */
		EClass EOBJECT_LINKED = eINSTANCE.getEObjectLinked();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Parentable <em>Parentable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Parentable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getParentable()
		 * @generated
		 */
		EClass PARENTABLE = eINSTANCE.getParentable();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENTABLE__PARENT = eINSTANCE.getParentable_Parent();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.CategoryLike <em>Category Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.CategoryLike
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCategoryLike()
		 * @generated
		 */
		EClass CATEGORY_LIKE = eINSTANCE.getCategoryLike();

		/**
		 * The meta object literal for the '<em><b>Slug Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_LIKE__SLUG_PATH = eINSTANCE.getCategoryLike_SlugPath();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_LIKE__COLOR = eINSTANCE.getCategoryLike_Color();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_LIKE__IMAGE_ID = eINSTANCE.getCategoryLike_ImageId();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_LIKE__LEVEL = eINSTANCE.getCategoryLike_Level();

		/**
		 * The meta object literal for the '<em><b>Category Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY_LIKE__CATEGORY_COUNT = eINSTANCE.getCategoryLike_CategoryCount();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.CategoryInfoImpl <em>Category Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.CategoryInfoImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCategoryInfo()
		 * @generated
		 */
		EClass CATEGORY_INFO = eINSTANCE.getCategoryInfo();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY_INFO__PARENTS = eINSTANCE.getCategoryInfo_Parents();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ProgressMonitorImpl <em>Progress Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ProgressMonitorImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressMonitor()
		 * @generated
		 */
		EClass PROGRESS_MONITOR = eINSTANCE.getProgressMonitor();

		/**
		 * The meta object literal for the '<em><b>Canceled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRESS_MONITOR__CANCELED = eINSTANCE.getProgressMonitor_Canceled();

		/**
		 * The meta object literal for the '<em><b>Task Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRESS_MONITOR__TASK_NAME = eINSTANCE.getProgressMonitor_TaskName();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ShellProgressMonitorImpl <em>Shell Progress Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ShellProgressMonitorImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getShellProgressMonitor()
		 * @generated
		 */
		EClass SHELL_PROGRESS_MONITOR = eINSTANCE.getShellProgressMonitor();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.impl.ProgressMonitorWrapperImpl <em>Progress Monitor Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.ProgressMonitorWrapperImpl
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressMonitorWrapper()
		 * @generated
		 */
		EClass PROGRESS_MONITOR_WRAPPER = eINSTANCE.getProgressMonitorWrapper();

		/**
		 * The meta object literal for the '<em><b>Delegate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRESS_MONITOR_WRAPPER__DELEGATE = eINSTANCE.getProgressMonitorWrapper_Delegate();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.ResourceType <em>Resource Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.ResourceType
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getResourceType()
		 * @generated
		 */
		EEnum RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.Gender <em>Gender</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.Gender
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getGender()
		 * @generated
		 */
		EEnum GENDER = eINSTANCE.getGender();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.EClassStatus <em>EClass Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.EClassStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEClassStatus()
		 * @generated
		 */
		EEnum ECLASS_STATUS = eINSTANCE.getEClassStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.JavaClassStatus <em>Java Class Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.JavaClassStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getJavaClassStatus()
		 * @generated
		 */
		EEnum JAVA_CLASS_STATUS = eINSTANCE.getJavaClassStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.ProgressStatus <em>Progress Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.ProgressStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getProgressStatus()
		 * @generated
		 */
		EEnum PROGRESS_STATUS = eINSTANCE.getProgressStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.AccountStatus <em>Account Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.AccountStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getAccountStatus()
		 * @generated
		 */
		EEnum ACCOUNT_STATUS = eINSTANCE.getAccountStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.PublicationStatus <em>Publication Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.PublicationStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getPublicationStatus()
		 * @generated
		 */
		EEnum PUBLICATION_STATUS = eINSTANCE.getPublicationStatus();

		/**
		 * The meta object literal for the '{@link org.soluvas.commons.ArchivalStatus <em>Archival Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.ArchivalStatus
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getArchivalStatus()
		 * @generated
		 */
		EEnum ARCHIVAL_STATUS = eINSTANCE.getArchivalStatus();

		/**
		 * The meta object literal for the '<em>Date Time</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joda.time.DateTime
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDateTime()
		 * @generated
		 */
		EDataType DATE_TIME = eINSTANCE.getDateTime();

		/**
		 * The meta object literal for the '<em>Currency Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joda.money.CurrencyUnit
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCurrencyUnit()
		 * @generated
		 */
		EDataType CURRENCY_UNIT = eINSTANCE.getCurrencyUnit();

		/**
		 * The meta object literal for the '<em>Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.unit.Unit
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getUnit()
		 * @generated
		 */
		EDataType UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMap()
		 * @generated
		 */
		EDataType MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em>Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSet()
		 * @generated
		 */
		EDataType SET = eINSTANCE.getSet();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCollection()
		 * @generated
		 */
		EDataType COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em>Multimap</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.google.common.collect.Multimap
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultimap()
		 * @generated
		 */
		EDataType MULTIMAP = eINSTANCE.getMultimap();

		/**
		 * The meta object literal for the '<em>Navigable Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.NavigableMap
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNavigableMap()
		 * @generated
		 */
		EDataType NAVIGABLE_MAP = eINSTANCE.getNavigableMap();

		/**
		 * The meta object literal for the '<em>Queue</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Queue
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getQueue()
		 * @generated
		 */
		EDataType QUEUE = eINSTANCE.getQueue();

		/**
		 * The meta object literal for the '<em>Multiset</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.google.common.collect.Multiset
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultiset()
		 * @generated
		 */
		EDataType MULTISET = eINSTANCE.getMultiset();

		/**
		 * The meta object literal for the '<em>Serializable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.Serializable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSerializable()
		 * @generated
		 */
		EDataType SERIALIZABLE = eINSTANCE.getSerializable();

		/**
		 * The meta object literal for the '<em>Bundle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osgi.framework.Bundle
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBundle()
		 * @generated
		 */
		EDataType BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em>Big Money Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joda.money.BigMoneyProvider
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBigMoneyProvider()
		 * @generated
		 */
		EDataType BIG_MONEY_PROVIDER = eINSTANCE.getBigMoneyProvider();

		/**
		 * The meta object literal for the '<em>Quantity</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.quantity.Quantity
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getQuantity()
		 * @generated
		 */
		EDataType QUANTITY = eINSTANCE.getQuantity();

		/**
		 * The meta object literal for the '<em>Measurable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.Measurable
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMeasurable()
		 * @generated
		 */
		EDataType MEASURABLE = eINSTANCE.getMeasurable();

		/**
		 * The meta object literal for the '<em>Big Decimal</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBigDecimal()
		 * @generated
		 */
		EDataType BIG_DECIMAL = eINSTANCE.getBigDecimal();

		/**
		 * The meta object literal for the '<em>Date Time Zone</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.joda.time.DateTimeZone
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDateTimeZone()
		 * @generated
		 */
		EDataType DATE_TIME_ZONE = eINSTANCE.getDateTimeZone();

		/**
		 * The meta object literal for the '<em>Locale</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Locale
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getLocale()
		 * @generated
		 */
		EDataType LOCALE = eINSTANCE.getLocale();

		/**
		 * The meta object literal for the '<em>File</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see org.soluvas.commons.impl.CommonsPackageImpl#getFile()
		 * @generated
		 */
		EDataType FILE = eINSTANCE.getFile();

	}

} //CommonsPackage
