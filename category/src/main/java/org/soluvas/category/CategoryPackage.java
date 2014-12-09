/**
 */
package org.soluvas.category;

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
 * @see org.soluvas.category.CategoryFactory
 * @model kind="package"
 * @generated
 */
public interface CategoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "category";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/category/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "category";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CategoryPackage eINSTANCE = org.soluvas.category.impl.CategoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.category.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.category.impl.CategoryImpl
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = CommonsPackage.CATEGORY_LIKE__ID;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NS_PREFIX = CommonsPackage.CATEGORY_LIKE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = CommonsPackage.CATEGORY_LIKE__NAME;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__POSITIONER = CommonsPackage.CATEGORY_LIKE__POSITIONER;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SLUG = CommonsPackage.CATEGORY_LIKE__SLUG;

	/**
	 * The feature id for the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SLUG_PATH = CommonsPackage.CATEGORY_LIKE__SLUG_PATH;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__COLOR = CommonsPackage.CATEGORY_LIKE__COLOR;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__IMAGE_ID = CommonsPackage.CATEGORY_LIKE__IMAGE_ID;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__LEVEL = CommonsPackage.CATEGORY_LIKE__LEVEL;

	/**
	 * The feature id for the '<em><b>Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATEGORY_COUNT = CommonsPackage.CATEGORY_LIKE__CATEGORY_COUNT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PARENT = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__RESOURCE_TYPE = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__RESOURCE_URI = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__RESOURCE_NAME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BUNDLE = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATEGORIES = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CREATION_TIME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Modification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__MODIFICATION_TIME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__STATUS = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Meta Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__META_DESCRIPTION = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Meta Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__META_KEYWORDS = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Meta Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__META_TITLE = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Available Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__AVAILABLE_SORT_BY = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Default Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DEFAULT_SORT_BY = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Anchor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ANCHOR = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Include In Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__INCLUDE_IN_MENU = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Catalog Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATALOG_NAME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Default Mixin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DEFAULT_MIXIN = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>UName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__UNAME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Parent UName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PARENT_UNAME = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PRIMARY_URI = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Same As Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SAME_AS_URIS = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__TAGS = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 23;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = CommonsPackage.CATEGORY_LIKE_FEATURE_COUNT + 24;

	/**
	 * The meta object id for the '{@link org.soluvas.category.CategoryContainer <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.category.CategoryContainer
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryContainer()
	 * @generated
	 */
	int CATEGORY_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CONTAINER__CATEGORIES = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.category.impl.CategoryCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.category.impl.CategoryCatalogImpl
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryCatalog()
	 * @generated
	 */
	int CATEGORY_CATALOG = 2;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__CATEGORIES = CATEGORY_CONTAINER__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__NAME = CATEGORY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__RESOURCE_TYPE = CATEGORY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__RESOURCE_URI = CATEGORY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__RESOURCE_NAME = CATEGORY_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG__BUNDLE = CATEGORY_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_CATALOG_FEATURE_COUNT = CATEGORY_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.category.impl.CategoryManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.category.impl.CategoryManagerImpl
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryManager()
	 * @generated
	 */
	int CATEGORY_MANAGER = 3;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_MANAGER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.category.CategoryStatus <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.category.CategoryStatus
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryStatus()
	 * @generated
	 */
	int CATEGORY_STATUS = 4;


	/**
	 * The meta object id for the '<em>Entity Lookup</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.EntityLookup
	 * @see org.soluvas.category.impl.CategoryPackageImpl#getEntityLookup()
	 * @generated
	 */
	int ENTITY_LOOKUP = 5;


	/**
	 * Returns the meta object for class '{@link org.soluvas.category.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.soluvas.category.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.soluvas.category.Category#getStatus()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getMetaDescription <em>Meta Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Description</em>'.
	 * @see org.soluvas.category.Category#getMetaDescription()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_MetaDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getMetaKeywords <em>Meta Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Keywords</em>'.
	 * @see org.soluvas.category.Category#getMetaKeywords()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_MetaKeywords();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getMetaTitle <em>Meta Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Title</em>'.
	 * @see org.soluvas.category.Category#getMetaTitle()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_MetaTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getAvailableSortBy <em>Available Sort By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Sort By</em>'.
	 * @see org.soluvas.category.Category#getAvailableSortBy()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_AvailableSortBy();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getDefaultSortBy <em>Default Sort By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Sort By</em>'.
	 * @see org.soluvas.category.Category#getDefaultSortBy()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_DefaultSortBy();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#isAnchor <em>Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anchor</em>'.
	 * @see org.soluvas.category.Category#isAnchor()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Anchor();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#isIncludeInMenu <em>Include In Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include In Menu</em>'.
	 * @see org.soluvas.category.Category#isIncludeInMenu()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_IncludeInMenu();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getCatalogName <em>Catalog Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Catalog Name</em>'.
	 * @see org.soluvas.category.Category#getCatalogName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_CatalogName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getDefaultMixin <em>Default Mixin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Mixin</em>'.
	 * @see org.soluvas.category.Category#getDefaultMixin()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_DefaultMixin();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getUName <em>UName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UName</em>'.
	 * @see org.soluvas.category.Category#getUName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_UName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getParentUName <em>Parent UName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent UName</em>'.
	 * @see org.soluvas.category.Category#getParentUName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_ParentUName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.category.Category#getPrimaryUri <em>Primary Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Uri</em>'.
	 * @see org.soluvas.category.Category#getPrimaryUri()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_PrimaryUri();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.category.Category#getSameAsUris <em>Same As Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Same As Uris</em>'.
	 * @see org.soluvas.category.Category#getSameAsUris()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_SameAsUris();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.category.Category#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.soluvas.category.Category#getTags()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Tags();

	/**
	 * Returns the meta object for class '{@link org.soluvas.category.CategoryContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.soluvas.category.CategoryContainer
	 * @generated
	 */
	EClass getCategoryContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.category.CategoryContainer#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.soluvas.category.CategoryContainer#getCategories()
	 * @see #getCategoryContainer()
	 * @generated
	 */
	EReference getCategoryContainer_Categories();

	/**
	 * Returns the meta object for class '{@link org.soluvas.category.CategoryCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.category.CategoryCatalog
	 * @generated
	 */
	EClass getCategoryCatalog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.category.CategoryManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.soluvas.category.CategoryManager
	 * @generated
	 */
	EClass getCategoryManager();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.category.CategoryStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see org.soluvas.category.CategoryStatus
	 * @generated
	 */
	EEnum getCategoryStatus();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.EntityLookup <em>Entity Lookup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Entity Lookup</em>'.
	 * @see org.soluvas.data.EntityLookup
	 * @model instanceClass="org.soluvas.data.EntityLookup" serializeable="false" typeParameters="T ID"
	 * @generated
	 */
	EDataType getEntityLookup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CategoryFactory getCategoryFactory();

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
		 * The meta object literal for the '{@link org.soluvas.category.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.category.impl.CategoryImpl
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__STATUS = eINSTANCE.getCategory_Status();

		/**
		 * The meta object literal for the '<em><b>Meta Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__META_DESCRIPTION = eINSTANCE.getCategory_MetaDescription();

		/**
		 * The meta object literal for the '<em><b>Meta Keywords</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__META_KEYWORDS = eINSTANCE.getCategory_MetaKeywords();

		/**
		 * The meta object literal for the '<em><b>Meta Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__META_TITLE = eINSTANCE.getCategory_MetaTitle();

		/**
		 * The meta object literal for the '<em><b>Available Sort By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__AVAILABLE_SORT_BY = eINSTANCE.getCategory_AvailableSortBy();

		/**
		 * The meta object literal for the '<em><b>Default Sort By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__DEFAULT_SORT_BY = eINSTANCE.getCategory_DefaultSortBy();

		/**
		 * The meta object literal for the '<em><b>Anchor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__ANCHOR = eINSTANCE.getCategory_Anchor();

		/**
		 * The meta object literal for the '<em><b>Include In Menu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__INCLUDE_IN_MENU = eINSTANCE.getCategory_IncludeInMenu();

		/**
		 * The meta object literal for the '<em><b>Catalog Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__CATALOG_NAME = eINSTANCE.getCategory_CatalogName();

		/**
		 * The meta object literal for the '<em><b>Default Mixin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__DEFAULT_MIXIN = eINSTANCE.getCategory_DefaultMixin();

		/**
		 * The meta object literal for the '<em><b>UName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__UNAME = eINSTANCE.getCategory_UName();

		/**
		 * The meta object literal for the '<em><b>Parent UName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__PARENT_UNAME = eINSTANCE.getCategory_ParentUName();

		/**
		 * The meta object literal for the '<em><b>Primary Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__PRIMARY_URI = eINSTANCE.getCategory_PrimaryUri();

		/**
		 * The meta object literal for the '<em><b>Same As Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__SAME_AS_URIS = eINSTANCE.getCategory_SameAsUris();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__TAGS = eINSTANCE.getCategory_Tags();

		/**
		 * The meta object literal for the '{@link org.soluvas.category.CategoryContainer <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.category.CategoryContainer
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryContainer()
		 * @generated
		 */
		EClass CATEGORY_CONTAINER = eINSTANCE.getCategoryContainer();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY_CONTAINER__CATEGORIES = eINSTANCE.getCategoryContainer_Categories();

		/**
		 * The meta object literal for the '{@link org.soluvas.category.impl.CategoryCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.category.impl.CategoryCatalogImpl
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryCatalog()
		 * @generated
		 */
		EClass CATEGORY_CATALOG = eINSTANCE.getCategoryCatalog();

		/**
		 * The meta object literal for the '{@link org.soluvas.category.impl.CategoryManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.category.impl.CategoryManagerImpl
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryManager()
		 * @generated
		 */
		EClass CATEGORY_MANAGER = eINSTANCE.getCategoryManager();

		/**
		 * The meta object literal for the '{@link org.soluvas.category.CategoryStatus <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.category.CategoryStatus
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getCategoryStatus()
		 * @generated
		 */
		EEnum CATEGORY_STATUS = eINSTANCE.getCategoryStatus();

		/**
		 * The meta object literal for the '<em>Entity Lookup</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.EntityLookup
		 * @see org.soluvas.category.impl.CategoryPackageImpl#getEntityLookup()
		 * @generated
		 */
		EDataType ENTITY_LOOKUP = eINSTANCE.getEntityLookup();

	}

} //CategoryPackage
