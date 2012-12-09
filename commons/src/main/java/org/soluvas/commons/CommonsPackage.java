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
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__TITLE = POSITIONABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST__DESCRIPTION = POSITIONABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>App Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MANIFEST_FEATURE_COUNT = POSITIONABLE_FEATURE_COUNT + 5;

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
	 * The number of structural features of the '<em>Person Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_INFO_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

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
	 * The meta object id for the '{@link org.soluvas.commons.impl.NameContainerImpl <em>Name Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.impl.NameContainerImpl
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
	 * The number of structural features of the '<em>Describable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBABLE_FEATURE_COUNT = 0;

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
	 * The meta object id for the '{@link org.soluvas.commons.ResourceType <em>Resource Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.ResourceType
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 17;


	/**
	 * The meta object id for the '{@link org.soluvas.commons.Gender <em>Gender</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.Gender
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getGender()
	 * @generated
	 */
	int GENDER = 18;


	/**
	 * The meta object id for the '{@link org.soluvas.commons.EClassStatus <em>EClass Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.EClassStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getEClassStatus()
	 * @generated
	 */
	int ECLASS_STATUS = 19;

	/**
	 * The meta object id for the '{@link org.soluvas.commons.JavaClassStatus <em>Java Class Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getJavaClassStatus()
	 * @generated
	 */
	int JAVA_CLASS_STATUS = 20;

	/**
	 * The meta object id for the '<em>Date Time</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.time.DateTime
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getDateTime()
	 * @generated
	 */
	int DATE_TIME = 21;

	/**
	 * The meta object id for the '<em>Currency Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.joda.money.CurrencyUnit
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCurrencyUnit()
	 * @generated
	 */
	int CURRENCY_UNIT = 22;

	/**
	 * The meta object id for the '<em>Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.unit.Unit
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 23;


	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getList()
	 * @generated
	 */
	int LIST = 24;

	/**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMap()
	 * @generated
	 */
	int MAP = 25;

	/**
	 * The meta object id for the '<em>Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSet()
	 * @generated
	 */
	int SET = 26;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 27;

	/**
	 * The meta object id for the '<em>Multimap</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.google.common.collect.Multimap
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultimap()
	 * @generated
	 */
	int MULTIMAP = 28;

	/**
	 * The meta object id for the '<em>Navigable Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.NavigableMap
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getNavigableMap()
	 * @generated
	 */
	int NAVIGABLE_MAP = 29;

	/**
	 * The meta object id for the '<em>Queue</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Queue
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getQueue()
	 * @generated
	 */
	int QUEUE = 30;

	/**
	 * The meta object id for the '<em>Multiset</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.google.common.collect.Multiset
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getMultiset()
	 * @generated
	 */
	int MULTISET = 31;


	/**
	 * The meta object id for the '<em>Serializable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.Serializable
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getSerializable()
	 * @generated
	 */
	int SERIALIZABLE = 32;


	/**
	 * The meta object id for the '<em>Bundle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.Bundle
	 * @see org.soluvas.commons.impl.CommonsPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 33;


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
	 * @model instanceClass="javax.measure.unit.Unit"
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
		 * The meta object literal for the '{@link org.soluvas.commons.impl.NameContainerImpl <em>Name Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.commons.impl.NameContainerImpl
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

	}

} //CommonsPackage
