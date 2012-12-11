/**
 */
package org.soluvas.social.schema;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.soluvas.social.schema.SchemaFactory
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
	String eNS_URI = "http://www.soluvas.org/schema/social.schema/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "social-schema";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchemaPackage eINSTANCE = org.soluvas.social.schema.impl.SchemaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.social.schema.impl.TargetTypeImpl <em>Target Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.schema.impl.TargetTypeImpl
	 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetType()
	 * @generated
	 */
	int TARGET_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__BUNDLE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__RESOURCE_TYPE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__RESOURCE_URI = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__RESOURCE_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__JAVA_CLASS_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__JAVA_CLASS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__JAVA_CLASS_STATUS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__ECLASS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__ECLASS_STATUS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__EPACKAGE_NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__ECLASS_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__EPACKAGE_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__EFACTORY = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl <em>Social Schema Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.schema.impl.SocialSchemaCatalogImpl
	 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getSocialSchemaCatalog()
	 * @generated
	 */
	int SOCIAL_SCHEMA_CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__BUNDLE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__TARGET_TYPES = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG__NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Social Schema Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_SCHEMA_CATALOG_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.social.schema.impl.TargetTypeAddedImpl <em>Target Type Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.schema.impl.TargetTypeAddedImpl
	 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetTypeAdded()
	 * @generated
	 */
	int TARGET_TYPE_ADDED = 2;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_ADDED__TARGET_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Target Type Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_ADDED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.social.schema.impl.TargetTypeRemovedImpl <em>Target Type Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.schema.impl.TargetTypeRemovedImpl
	 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetTypeRemoved()
	 * @generated
	 */
	int TARGET_TYPE_REMOVED = 3;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_REMOVED__TARGET_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Target Type Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_REMOVED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Target</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.Target
	 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 4;


	/**
	 * Returns the meta object for class '{@link org.soluvas.social.schema.TargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Type</em>'.
	 * @see org.soluvas.social.schema.TargetType
	 * @generated
	 */
	EClass getTargetType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.schema.SocialSchemaCatalog <em>Social Schema Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Social Schema Catalog</em>'.
	 * @see org.soluvas.social.schema.SocialSchemaCatalog
	 * @generated
	 */
	EClass getSocialSchemaCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.social.schema.SocialSchemaCatalog#getTargetTypes <em>Target Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Types</em>'.
	 * @see org.soluvas.social.schema.SocialSchemaCatalog#getTargetTypes()
	 * @see #getSocialSchemaCatalog()
	 * @generated
	 */
	EReference getSocialSchemaCatalog_TargetTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix <em>Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns Prefix</em>'.
	 * @see org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix()
	 * @see #getSocialSchemaCatalog()
	 * @generated
	 */
	EAttribute getSocialSchemaCatalog_NsPrefix();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.schema.TargetTypeAdded <em>Target Type Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Type Added</em>'.
	 * @see org.soluvas.social.schema.TargetTypeAdded
	 * @generated
	 */
	EClass getTargetTypeAdded();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.social.schema.TargetTypeAdded#getTargetTypes <em>Target Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Types</em>'.
	 * @see org.soluvas.social.schema.TargetTypeAdded#getTargetTypes()
	 * @see #getTargetTypeAdded()
	 * @generated
	 */
	EReference getTargetTypeAdded_TargetTypes();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.schema.TargetTypeRemoved <em>Target Type Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Type Removed</em>'.
	 * @see org.soluvas.social.schema.TargetTypeRemoved
	 * @generated
	 */
	EClass getTargetTypeRemoved();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.social.schema.TargetTypeRemoved#getTargetTypes <em>Target Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Types</em>'.
	 * @see org.soluvas.social.schema.TargetTypeRemoved#getTargetTypes()
	 * @see #getTargetTypeRemoved()
	 * @generated
	 */
	EReference getTargetTypeRemoved_TargetTypes();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.social.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Target</em>'.
	 * @see org.soluvas.social.Target
	 * @model instanceClass="org.soluvas.social.Target"
	 * @generated
	 */
	EDataType getTarget();

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
		 * The meta object literal for the '{@link org.soluvas.social.schema.impl.TargetTypeImpl <em>Target Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.schema.impl.TargetTypeImpl
		 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetType()
		 * @generated
		 */
		EClass TARGET_TYPE = eINSTANCE.getTargetType();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl <em>Social Schema Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.schema.impl.SocialSchemaCatalogImpl
		 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getSocialSchemaCatalog()
		 * @generated
		 */
		EClass SOCIAL_SCHEMA_CATALOG = eINSTANCE.getSocialSchemaCatalog();

		/**
		 * The meta object literal for the '<em><b>Target Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCIAL_SCHEMA_CATALOG__TARGET_TYPES = eINSTANCE.getSocialSchemaCatalog_TargetTypes();

		/**
		 * The meta object literal for the '<em><b>Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCIAL_SCHEMA_CATALOG__NS_PREFIX = eINSTANCE.getSocialSchemaCatalog_NsPrefix();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.schema.impl.TargetTypeAddedImpl <em>Target Type Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.schema.impl.TargetTypeAddedImpl
		 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetTypeAdded()
		 * @generated
		 */
		EClass TARGET_TYPE_ADDED = eINSTANCE.getTargetTypeAdded();

		/**
		 * The meta object literal for the '<em><b>Target Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_TYPE_ADDED__TARGET_TYPES = eINSTANCE.getTargetTypeAdded_TargetTypes();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.schema.impl.TargetTypeRemovedImpl <em>Target Type Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.schema.impl.TargetTypeRemovedImpl
		 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTargetTypeRemoved()
		 * @generated
		 */
		EClass TARGET_TYPE_REMOVED = eINSTANCE.getTargetTypeRemoved();

		/**
		 * The meta object literal for the '<em><b>Target Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_TYPE_REMOVED__TARGET_TYPES = eINSTANCE.getTargetTypeRemoved_TargetTypes();

		/**
		 * The meta object literal for the '<em>Target</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.Target
		 * @see org.soluvas.social.schema.impl.SchemaPackageImpl#getTarget()
		 * @generated
		 */
		EDataType TARGET = eINSTANCE.getTarget();

	}

} //SchemaPackage
