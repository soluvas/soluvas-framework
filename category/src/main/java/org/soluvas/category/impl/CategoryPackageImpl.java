/**
 */
package org.soluvas.category.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.CategoryContainer;
import org.soluvas.category.CategoryFactory;
import org.soluvas.category.CategoryManager;
import org.soluvas.category.CategoryPackage;
import org.soluvas.category.CategoryStatus;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.data.EntityLookup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CategoryPackageImpl extends EPackageImpl implements CategoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum categoryStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType entityLookupEDataType = null;

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
	 * @see org.soluvas.category.CategoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CategoryPackageImpl() {
		super(eNS_URI, CategoryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CategoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CategoryPackage init() {
		if (isInited) return (CategoryPackage)EPackage.Registry.INSTANCE.getEPackage(CategoryPackage.eNS_URI);

		// Obtain or create and register package
		CategoryPackageImpl theCategoryPackage = (CategoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CategoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CategoryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCategoryPackage.createPackageContents();

		// Initialize created meta-data
		theCategoryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCategoryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CategoryPackage.eNS_URI, theCategoryPackage);
		return theCategoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_Status() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_MetaDescription() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_MetaKeywords() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_MetaTitle() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_AvailableSortBy() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_DefaultSortBy() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_Anchor() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_IncludeInMenu() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_CatalogName() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_DefaultMixin() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_UName() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_ParentUName() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_PrimaryUri() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_SameAsUris() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Tags() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_GoogleFormalId() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryContainer() {
		return categoryContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategoryContainer_Categories() {
		return (EReference)categoryContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryCatalog() {
		return categoryCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryManager() {
		return categoryManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCategoryStatus() {
		return categoryStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEntityLookup() {
		return entityLookupEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CategoryFactory getCategoryFactory() {
		return (CategoryFactory)getEFactoryInstance();
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
		categoryEClass = createEClass(CATEGORY);
		createEAttribute(categoryEClass, CATEGORY__STATUS);
		createEAttribute(categoryEClass, CATEGORY__META_DESCRIPTION);
		createEAttribute(categoryEClass, CATEGORY__META_KEYWORDS);
		createEAttribute(categoryEClass, CATEGORY__META_TITLE);
		createEAttribute(categoryEClass, CATEGORY__AVAILABLE_SORT_BY);
		createEAttribute(categoryEClass, CATEGORY__DEFAULT_SORT_BY);
		createEAttribute(categoryEClass, CATEGORY__ANCHOR);
		createEAttribute(categoryEClass, CATEGORY__INCLUDE_IN_MENU);
		createEAttribute(categoryEClass, CATEGORY__CATALOG_NAME);
		createEAttribute(categoryEClass, CATEGORY__DEFAULT_MIXIN);
		createEAttribute(categoryEClass, CATEGORY__UNAME);
		createEAttribute(categoryEClass, CATEGORY__PARENT_UNAME);
		createEAttribute(categoryEClass, CATEGORY__PRIMARY_URI);
		createEAttribute(categoryEClass, CATEGORY__SAME_AS_URIS);
		createEAttribute(categoryEClass, CATEGORY__TAGS);
		createEAttribute(categoryEClass, CATEGORY__GOOGLE_FORMAL_ID);

		categoryContainerEClass = createEClass(CATEGORY_CONTAINER);
		createEReference(categoryContainerEClass, CATEGORY_CONTAINER__CATEGORIES);

		categoryCatalogEClass = createEClass(CATEGORY_CATALOG);

		categoryManagerEClass = createEClass(CATEGORY_MANAGER);

		// Create enums
		categoryStatusEEnum = createEEnum(CATEGORY_STATUS);

		// Create data types
		entityLookupEDataType = createEDataType(ENTITY_LOOKUP);
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
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(entityLookupEDataType, "T");
		addETypeParameter(entityLookupEDataType, "ID");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theCommonsPackage.getCategoryLike());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNsPrefixable());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getParentable());
		EGenericType g2 = createEGenericType(this.getCategory());
		g1.getETypeArguments().add(g2);
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getResourceAware());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCategoryContainer());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getDescribable());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getInformer());
		g2 = createEGenericType(theCommonsPackage.getCategoryInfo());
		g1.getETypeArguments().add(g2);
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getTimestamped());
		categoryEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getTranslatable());
		categoryEClass.getEGenericSuperTypes().add(g1);
		categoryCatalogEClass.getESuperTypes().add(this.getCategoryContainer());
		categoryCatalogEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		categoryCatalogEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		categoryCatalogEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());

		// Initialize classes and features; add operations and parameters
		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategory_Status(), this.getCategoryStatus(), "status", "active", 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_MetaDescription(), ecorePackage.getEString(), "metaDescription", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_MetaKeywords(), ecorePackage.getEString(), "metaKeywords", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_MetaTitle(), ecorePackage.getEString(), "metaTitle", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getList());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getCategory_AvailableSortBy(), g1, "availableSortBy", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_DefaultSortBy(), ecorePackage.getEString(), "defaultSortBy", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Anchor(), ecorePackage.getEBoolean(), "anchor", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_IncludeInMenu(), ecorePackage.getEBoolean(), "includeInMenu", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_CatalogName(), ecorePackage.getEString(), "catalogName", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_DefaultMixin(), ecorePackage.getEString(), "defaultMixin", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_UName(), ecorePackage.getEString(), "uName", null, 0, 1, Category.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_ParentUName(), ecorePackage.getEString(), "parentUName", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_PrimaryUri(), ecorePackage.getEString(), "primaryUri", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_SameAsUris(), ecorePackage.getEString(), "sameAsUris", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Tags(), ecorePackage.getEString(), "tags", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_GoogleFormalId(), ecorePackage.getELongObject(), "googleFormalId", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(categoryEClass, null, "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getEntityLookup());
		g2 = createEGenericType(this.getCategory());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "categoryLookup", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(categoryEClass, ecorePackage.getEString(), "getEffectiveName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "curLanguageTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(categoryEClass, ecorePackage.getEString(), "getEffectiveDescription", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "curLanguageTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(categoryEClass, theCommonsPackage.getCategoryInfo(), "toInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "curLanguageTag", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(categoryContainerEClass, CategoryContainer.class, "CategoryContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategoryContainer_Categories(), this.getCategory(), null, "categories", null, 0, -1, CategoryContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryCatalogEClass, CategoryCatalog.class, "CategoryCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(categoryManagerEClass, CategoryManager.class, "CategoryManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(categoryStatusEEnum, CategoryStatus.class, "CategoryStatus");
		addEEnumLiteral(categoryStatusEEnum, CategoryStatus.DRAFT);
		addEEnumLiteral(categoryStatusEEnum, CategoryStatus.ACTIVE);
		addEEnumLiteral(categoryStatusEEnum, CategoryStatus.INACTIVE);
		addEEnumLiteral(categoryStatusEEnum, CategoryStatus.VOID);

		// Initialize data types
		initEDataType(entityLookupEDataType, EntityLookup.class, "EntityLookup", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (categoryEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Provide default values for id, slug, slugPath, etc.\n\nIf categoryLookup is provided, it will lookup the parentUName and set the parent reference.\nThis is optional and unnecessary during loading from XMI, but is required during EmfModel deserialization."
		   });	
		addAnnotation
		  (getCategory_CatalogName(), 
		   source, 
		   new String[] {
			 "documentation", "Name of the category catalog."
		   });	
		addAnnotation
		  (getCategory_DefaultMixin(), 
		   source, 
		   new String[] {
			 "documentation", "Default {@link org.soluvas.data.Mixin} UName, including nsPrefix, e.g. \"base_Apparel\"."
		   });	
		addAnnotation
		  (getCategory_UName(), 
		   source, 
		   new String[] {
			 "documentation", "nsPrefix + \"_\" + id."
		   });	
		addAnnotation
		  (getCategory_ParentUName(), 
		   source, 
		   new String[] {
			 "documentation", "Parent Category UName (\"{nsPrefix}_{ID}\"), useful during serialization/deserialization to get a real reference to the parent (which may/may not be found)."
		   });	
		addAnnotation
		  (getCategory_PrimaryUri(), 
		   source, 
		   new String[] {
			 "documentation", "Primary Linked Data URI, this will be used as <code>@id</code> in JSON-LD."
		   });	
		addAnnotation
		  (getCategory_SameAsUris(), 
		   source, 
		   new String[] {
			 "documentation", "Additional <a href=\"http://schema.org/sameAs\">sameAs</a> Linked Data URIs."
		   });	
		addAnnotation
		  (getCategory_Tags(), 
		   source, 
		   new String[] {
			 "documentation", "Freeform hashtags, however do not put special characters like space, comma, and semicolon.\nDash, underscore, and dot are usually okay.\nCan be used for both inbound and outbound.\nInbound: putting a product uploaded from Instagram or Twitter to specified category based on Instagram/Twitter hashtags.\nOutbound: publishing a product or category to Instagram/Twitter/Facebook, while hashtagging based on category\'s tags."
		   });	
		addAnnotation
		  (getCategoryContainer_Categories(), 
		   source, 
		   new String[] {
			 "documentation", "List of categories or children."
		   });
	}

	@Override
	protected Resource createResource(String uri) {
		// assume accessed from bipporeg-model
		return super.createResource("../../../org.soluvas.category/src/main/resources/org/soluvas/category/category.ecore");
	}
	
} //CategoryPackageImpl
