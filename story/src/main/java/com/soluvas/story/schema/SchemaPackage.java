/**
 */
package com.soluvas.story.schema;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.soluvas.commons.CommonsPackage;

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
 * @see com.soluvas.story.schema.SchemaFactory
 * @model kind="package"
 * @generated
 */
public interface SchemaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "schema";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.com/schema/story.schema/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "story-schema";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchemaPackage eINSTANCE = com.soluvas.story.schema.impl.SchemaPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.impl.StoryTypeImpl <em>Story Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.impl.StoryTypeImpl
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStoryType()
	 * @generated
	 */
	int STORY_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__JAVA_CLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__JAVA_CLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__JAVA_CLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__ECLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__ECLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__EPACKAGE_NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__ECLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE__EPACKAGE_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Story Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_TYPE_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.impl.StorySchemaCatalogImpl <em>Story Schema Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.impl.StorySchemaCatalogImpl
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStorySchemaCatalog()
	 * @generated
	 */
	int STORY_SCHEMA_CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__BUNDLE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Story Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__STORY_TYPES = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__ACTION_TYPES = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Aggregation Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__AGGREGATION_TYPES = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Generated Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Xmi Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__XMI_URL = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Ecore Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__ECORE_URL = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__EPACKAGE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG__EFACTORY = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Story Schema Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_SCHEMA_CATALOG_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.impl.ActionTypeImpl <em>Action Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.impl.ActionTypeImpl
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__BUNDLE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__RESOURCE_TYPE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__RESOURCE_URI = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__RESOURCE_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__JAVA_CLASS_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__JAVA_CLASS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__JAVA_CLASS_STATUS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ECLASS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ECLASS_STATUS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__EPACKAGE_NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ECLASS_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__EPACKAGE_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__EFACTORY = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__TENSES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__PAST_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__PLURAL_PAST_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__PRESENT_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__PLURAL_PRESENT_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__IMPERATIVE_TENSE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Resolved Subject Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__RESOLVED_SUBJECT_TYPES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__STATUS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Subject Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__SUBJECT_TYPES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 22;

	/**
	 * The number of structural features of the '<em>Action Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 23;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.impl.AggregationTypeImpl <em>Aggregation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.impl.AggregationTypeImpl
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAggregationType()
	 * @generated
	 */
	int AGGREGATION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__BUNDLE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__JAVA_CLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__JAVA_CLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__JAVA_CLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__ECLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__ECLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__EPACKAGE_NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__ECLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE__EPACKAGE_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Aggregation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_TYPE_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.ActionLike <em>Action Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.ActionLike
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionLike()
	 * @generated
	 */
	int ACTION_LIKE = 4;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__TENSES = 0;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__PAST_TENSE = 1;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__PLURAL_PAST_TENSE = 2;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__PRESENT_TENSE = 3;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__PLURAL_PRESENT_TENSE = 4;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE__IMPERATIVE_TENSE = 5;

	/**
	 * The number of structural features of the '<em>Action Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LIKE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.impl.TargetTypeRefImpl <em>Target Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.impl.TargetTypeRefImpl
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getTargetTypeRef()
	 * @generated
	 */
	int TARGET_TYPE_REF = 5;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_REF__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_REF__NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_REF_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.Tenses <em>Tenses</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.Tenses
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getTenses()
	 * @generated
	 */
	int TENSES = 6;

	/**
	 * The meta object id for the '{@link com.soluvas.story.schema.ActionTypeStatus <em>Action Type Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.schema.ActionTypeStatus
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionTypeStatus()
	 * @generated
	 */
	int ACTION_TYPE_STATUS = 7;

	/**
	 * The meta object id for the '<em>Story</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.Story
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStory()
	 * @generated
	 */
	int STORY = 8;

	/**
	 * The meta object id for the '<em>Action</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.Action
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 9;


	/**
	 * The meta object id for the '<em>Aggregation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.Aggregation
	 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAggregation()
	 * @generated
	 */
	int AGGREGATION = 10;


	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.StoryType <em>Story Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Story Type</em>'.
	 * @see com.soluvas.story.schema.StoryType
	 * @generated
	 */
	EClass getStoryType();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.StorySchemaCatalog <em>Story Schema Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Story Schema Catalog</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog
	 * @generated
	 */
	EClass getStorySchemaCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link com.soluvas.story.schema.StorySchemaCatalog#getStoryTypes <em>Story Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Story Types</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getStoryTypes()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EReference getStorySchemaCatalog_StoryTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.soluvas.story.schema.StorySchemaCatalog#getActionTypes <em>Action Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action Types</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getActionTypes()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EReference getStorySchemaCatalog_ActionTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.soluvas.story.schema.StorySchemaCatalog#getAggregationTypes <em>Aggregation Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aggregation Types</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getAggregationTypes()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EReference getStorySchemaCatalog_AggregationTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.StorySchemaCatalog#getGeneratedPackageName <em>Generated Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated Package Name</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getGeneratedPackageName()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EAttribute getStorySchemaCatalog_GeneratedPackageName();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.StorySchemaCatalog#getXmiUrl <em>Xmi Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmi Url</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getXmiUrl()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EAttribute getStorySchemaCatalog_XmiUrl();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.StorySchemaCatalog#getEcoreUrl <em>Ecore Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecore Url</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getEcoreUrl()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EAttribute getStorySchemaCatalog_EcoreUrl();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.schema.StorySchemaCatalog#getEPackage <em>EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EPackage</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getEPackage()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EReference getStorySchemaCatalog_EPackage();

	/**
	 * Returns the meta object for the reference '{@link com.soluvas.story.schema.StorySchemaCatalog#getEFactory <em>EFactory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EFactory</em>'.
	 * @see com.soluvas.story.schema.StorySchemaCatalog#getEFactory()
	 * @see #getStorySchemaCatalog()
	 * @generated
	 */
	EReference getStorySchemaCatalog_EFactory();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Type</em>'.
	 * @see com.soluvas.story.schema.ActionType
	 * @generated
	 */
	EClass getActionType();

	/**
	 * Returns the meta object for the reference list '{@link com.soluvas.story.schema.ActionType#getResolvedSubjectTypes <em>Resolved Subject Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resolved Subject Types</em>'.
	 * @see com.soluvas.story.schema.ActionType#getResolvedSubjectTypes()
	 * @see #getActionType()
	 * @generated
	 */
	EReference getActionType_ResolvedSubjectTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.soluvas.story.schema.ActionType#getSubjectTypes <em>Subject Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subject Types</em>'.
	 * @see com.soluvas.story.schema.ActionType#getSubjectTypes()
	 * @see #getActionType()
	 * @generated
	 */
	EReference getActionType_SubjectTypes();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionType#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.soluvas.story.schema.ActionType#getStatus()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Status();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.AggregationType <em>Aggregation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Type</em>'.
	 * @see com.soluvas.story.schema.AggregationType
	 * @generated
	 */
	EClass getAggregationType();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.ActionLike <em>Action Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Like</em>'.
	 * @see com.soluvas.story.schema.ActionLike
	 * @generated
	 */
	EClass getActionLike();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getTenses <em>Tenses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tenses</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getTenses()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_Tenses();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getPastTense <em>Past Tense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Past Tense</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getPastTense()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_PastTense();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getPluralPastTense <em>Plural Past Tense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plural Past Tense</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getPluralPastTense()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_PluralPastTense();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getPresentTense <em>Present Tense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Present Tense</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getPresentTense()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_PresentTense();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getPluralPresentTense <em>Plural Present Tense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plural Present Tense</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getPluralPresentTense()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_PluralPresentTense();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.schema.ActionLike#getImperativeTense <em>Imperative Tense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imperative Tense</em>'.
	 * @see com.soluvas.story.schema.ActionLike#getImperativeTense()
	 * @see #getActionLike()
	 * @generated
	 */
	EAttribute getActionLike_ImperativeTense();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.schema.TargetTypeRef <em>Target Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Type Ref</em>'.
	 * @see com.soluvas.story.schema.TargetTypeRef
	 * @generated
	 */
	EClass getTargetTypeRef();

	/**
	 * Returns the meta object for enum '{@link com.soluvas.story.schema.Tenses <em>Tenses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tenses</em>'.
	 * @see com.soluvas.story.schema.Tenses
	 * @generated
	 */
	EEnum getTenses();

	/**
	 * Returns the meta object for enum '{@link com.soluvas.story.schema.ActionTypeStatus <em>Action Type Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Type Status</em>'.
	 * @see com.soluvas.story.schema.ActionTypeStatus
	 * @generated
	 */
	EEnum getActionTypeStatus();

	/**
	 * Returns the meta object for data type '{@link com.soluvas.story.Story <em>Story</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Story</em>'.
	 * @see com.soluvas.story.Story
	 * @model instanceClass="com.soluvas.story.Story"
	 * @generated
	 */
	EDataType getStory();

	/**
	 * Returns the meta object for data type '{@link com.soluvas.story.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Action</em>'.
	 * @see com.soluvas.story.Action
	 * @model instanceClass="com.soluvas.story.Action"
	 * @generated
	 */
	EDataType getAction();

	/**
	 * Returns the meta object for data type '{@link com.soluvas.story.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Aggregation</em>'.
	 * @see com.soluvas.story.Aggregation
	 * @model instanceClass="com.soluvas.story.Aggregation"
	 * @generated
	 */
	EDataType getAggregation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchemaFactory getSchemaFactory();

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
		 * The meta object literal for the '{@link com.soluvas.story.schema.impl.StoryTypeImpl <em>Story Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.impl.StoryTypeImpl
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStoryType()
		 * @generated
		 */
		EClass STORY_TYPE = eINSTANCE.getStoryType();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.impl.StorySchemaCatalogImpl <em>Story Schema Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.impl.StorySchemaCatalogImpl
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStorySchemaCatalog()
		 * @generated
		 */
		EClass STORY_SCHEMA_CATALOG = eINSTANCE.getStorySchemaCatalog();

		/**
		 * The meta object literal for the '<em><b>Story Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_SCHEMA_CATALOG__STORY_TYPES = eINSTANCE.getStorySchemaCatalog_StoryTypes();

		/**
		 * The meta object literal for the '<em><b>Action Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_SCHEMA_CATALOG__ACTION_TYPES = eINSTANCE.getStorySchemaCatalog_ActionTypes();

		/**
		 * The meta object literal for the '<em><b>Aggregation Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_SCHEMA_CATALOG__AGGREGATION_TYPES = eINSTANCE.getStorySchemaCatalog_AggregationTypes();

		/**
		 * The meta object literal for the '<em><b>Generated Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME = eINSTANCE.getStorySchemaCatalog_GeneratedPackageName();

		/**
		 * The meta object literal for the '<em><b>Xmi Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY_SCHEMA_CATALOG__XMI_URL = eINSTANCE.getStorySchemaCatalog_XmiUrl();

		/**
		 * The meta object literal for the '<em><b>Ecore Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY_SCHEMA_CATALOG__ECORE_URL = eINSTANCE.getStorySchemaCatalog_EcoreUrl();

		/**
		 * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_SCHEMA_CATALOG__EPACKAGE = eINSTANCE.getStorySchemaCatalog_EPackage();

		/**
		 * The meta object literal for the '<em><b>EFactory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_SCHEMA_CATALOG__EFACTORY = eINSTANCE.getStorySchemaCatalog_EFactory();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.impl.ActionTypeImpl <em>Action Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.impl.ActionTypeImpl
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionType()
		 * @generated
		 */
		EClass ACTION_TYPE = eINSTANCE.getActionType();

		/**
		 * The meta object literal for the '<em><b>Resolved Subject Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TYPE__RESOLVED_SUBJECT_TYPES = eINSTANCE.getActionType_ResolvedSubjectTypes();

		/**
		 * The meta object literal for the '<em><b>Subject Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TYPE__SUBJECT_TYPES = eINSTANCE.getActionType_SubjectTypes();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__STATUS = eINSTANCE.getActionType_Status();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.impl.AggregationTypeImpl <em>Aggregation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.impl.AggregationTypeImpl
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAggregationType()
		 * @generated
		 */
		EClass AGGREGATION_TYPE = eINSTANCE.getAggregationType();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.ActionLike <em>Action Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.ActionLike
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionLike()
		 * @generated
		 */
		EClass ACTION_LIKE = eINSTANCE.getActionLike();

		/**
		 * The meta object literal for the '<em><b>Tenses</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__TENSES = eINSTANCE.getActionLike_Tenses();

		/**
		 * The meta object literal for the '<em><b>Past Tense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__PAST_TENSE = eINSTANCE.getActionLike_PastTense();

		/**
		 * The meta object literal for the '<em><b>Plural Past Tense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__PLURAL_PAST_TENSE = eINSTANCE.getActionLike_PluralPastTense();

		/**
		 * The meta object literal for the '<em><b>Present Tense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__PRESENT_TENSE = eINSTANCE.getActionLike_PresentTense();

		/**
		 * The meta object literal for the '<em><b>Plural Present Tense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__PLURAL_PRESENT_TENSE = eINSTANCE.getActionLike_PluralPresentTense();

		/**
		 * The meta object literal for the '<em><b>Imperative Tense</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LIKE__IMPERATIVE_TENSE = eINSTANCE.getActionLike_ImperativeTense();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.impl.TargetTypeRefImpl <em>Target Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.impl.TargetTypeRefImpl
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getTargetTypeRef()
		 * @generated
		 */
		EClass TARGET_TYPE_REF = eINSTANCE.getTargetTypeRef();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.Tenses <em>Tenses</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.Tenses
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getTenses()
		 * @generated
		 */
		EEnum TENSES = eINSTANCE.getTenses();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.schema.ActionTypeStatus <em>Action Type Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.schema.ActionTypeStatus
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getActionTypeStatus()
		 * @generated
		 */
		EEnum ACTION_TYPE_STATUS = eINSTANCE.getActionTypeStatus();

		/**
		 * The meta object literal for the '<em>Story</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.Story
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getStory()
		 * @generated
		 */
		EDataType STORY = eINSTANCE.getStory();

		/**
		 * The meta object literal for the '<em>Action</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.Action
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAction()
		 * @generated
		 */
		EDataType ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em>Aggregation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.Aggregation
		 * @see com.soluvas.story.schema.impl.SchemaPackageImpl#getAggregation()
		 * @generated
		 */
		EDataType AGGREGATION = eINSTANCE.getAggregation();

	}

} //SchemaPackage
