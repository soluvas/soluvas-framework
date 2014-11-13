/**
 */
package org.soluvas.category.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.CategoryContainer;
import org.soluvas.category.CategoryPackage;
import org.soluvas.category.CategoryStatus;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.Informer;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.Sluggable;
import org.soluvas.data.EntityLookup;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getSlugPath <em>Slug Path</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getCategoryCount <em>Category Count</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getMetaDescription <em>Meta Description</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getMetaKeywords <em>Meta Keywords</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getMetaTitle <em>Meta Title</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getAvailableSortBy <em>Available Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getDefaultSortBy <em>Default Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#isAnchor <em>Anchor</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#isIncludeInMenu <em>Include In Menu</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getCatalogName <em>Catalog Name</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getDefaultMixin <em>Default Mixin</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getUName <em>UName</em>}</li>
 *   <li>{@link org.soluvas.category.impl.CategoryImpl#getParentUName <em>Parent UName</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryImpl extends EObjectImpl implements Category {
	private static final Logger log = LoggerFactory
			.getLogger(CategoryImpl.class);
	
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected static final Integer POSITIONER_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected Integer positioner = POSITIONER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected static final String SLUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected String slug = SLUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlugPath() <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlugPath()
	 * @generated
	 * @ordered
	 */
	protected static final String SLUG_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlugPath() <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlugPath()
	 * @generated
	 * @ordered
	 */
	protected String slugPath = SLUG_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected String imageId = IMAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected Integer level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCategoryCount() <em>Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryCount()
	 * @generated
	 * @ordered
	 */
	protected static final Long CATEGORY_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategoryCount() <em>Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryCount()
	 * @generated
	 * @ordered
	 */
	protected Long categoryCount = CATEGORY_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Category parent;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.BUNDLE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final CategoryStatus STATUS_EDEFAULT = CategoryStatus.ACTIVE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected CategoryStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetaDescription() <em>Meta Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String META_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaDescription() <em>Meta Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaDescription()
	 * @generated
	 * @ordered
	 */
	protected String metaDescription = META_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetaKeywords() <em>Meta Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaKeywords()
	 * @generated
	 * @ordered
	 */
	protected static final String META_KEYWORDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaKeywords() <em>Meta Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaKeywords()
	 * @generated
	 * @ordered
	 */
	protected String metaKeywords = META_KEYWORDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetaTitle() <em>Meta Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String META_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaTitle() <em>Meta Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaTitle()
	 * @generated
	 * @ordered
	 */
	protected String metaTitle = META_TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAvailableSortBy() <em>Available Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableSortBy()
	 * @generated
	 * @ordered
	 */
	protected List<String> availableSortBy;

	/**
	 * The default value of the '{@link #getDefaultSortBy() <em>Default Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSortBy()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_SORT_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultSortBy() <em>Default Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSortBy()
	 * @generated
	 * @ordered
	 */
	protected String defaultSortBy = DEFAULT_SORT_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAnchor() <em>Anchor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnchor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANCHOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnchor() <em>Anchor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnchor()
	 * @generated
	 * @ordered
	 */
	protected boolean anchor = ANCHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncludeInMenu() <em>Include In Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeInMenu()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_IN_MENU_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeInMenu() <em>Include In Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeInMenu()
	 * @generated
	 * @ordered
	 */
	protected boolean includeInMenu = INCLUDE_IN_MENU_EDEFAULT;

	/**
	 * The default value of the '{@link #getCatalogName() <em>Catalog Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogName()
	 * @generated
	 * @ordered
	 */
	protected static final String CATALOG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatalogName() <em>Catalog Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogName()
	 * @generated
	 * @ordered
	 */
	protected String catalogName = CATALOG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultMixin() <em>Default Mixin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMixin()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_MIXIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultMixin() <em>Default Mixin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMixin()
	 * @generated
	 * @ordered
	 */
	protected String defaultMixin = DEFAULT_MIXIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getUName() <em>UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUName()
	 * @generated
	 * @ordered
	 */
	protected static final String UNAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getParentUName() <em>Parent UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentUName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_UNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentUName() <em>Parent UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentUName()
	 * @generated
	 * @ordered
	 */
	protected String parentUName = PARENT_UNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CategoryPackage.Literals.CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Category getParent() {
		if (parent != null && ((EObject)parent).eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Category)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CategoryPackage.CATEGORY__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setParent(Category newParent) {
		Category oldParent = parent;
		parent = newParent;
		// note that due to contract with EmfModel#detach(), parentUName is never reset here,
		// but it is reset in #resolve()
		if (parent != null) {
			setParentUName(parent.getUName());
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__POSITIONER, oldPositioner, positioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSlug() {
		return slug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlug(String newSlug) {
		String oldSlug = slug;
		slug = newSlug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__SLUG, oldSlug, slug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSlugPath() {
		return slugPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlugPath(String newSlugPath) {
		String oldSlugPath = slugPath;
		slugPath = newSlugPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__SLUG_PATH, oldSlugPath, slugPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImageId() {
		return imageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageId(String newImageId) {
		String oldImageId = imageId;
		imageId = newImageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevel(Integer newLevel) {
		Integer oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getCategoryCount() {
		return categoryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategoryCount(Long newCategoryCount) {
		Long oldCategoryCount = categoryCount;
		categoryCount = newCategoryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__CATEGORY_COUNT, oldCategoryCount, categoryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<>(Category.class, this, CategoryPackage.CATEGORY__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CategoryStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(CategoryStatus newStatus) {
		CategoryStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetaDescription() {
		return metaDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaDescription(String newMetaDescription) {
		String oldMetaDescription = metaDescription;
		metaDescription = newMetaDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__META_DESCRIPTION, oldMetaDescription, metaDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetaKeywords() {
		return metaKeywords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaKeywords(String newMetaKeywords) {
		String oldMetaKeywords = metaKeywords;
		metaKeywords = newMetaKeywords;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__META_KEYWORDS, oldMetaKeywords, metaKeywords));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetaTitle() {
		return metaTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaTitle(String newMetaTitle) {
		String oldMetaTitle = metaTitle;
		metaTitle = newMetaTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__META_TITLE, oldMetaTitle, metaTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<String> getAvailableSortBy() {
		return availableSortBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAvailableSortBy(List<String> newAvailableSortBy) {
		List<String> oldAvailableSortBy = availableSortBy;
		availableSortBy = newAvailableSortBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__AVAILABLE_SORT_BY, oldAvailableSortBy, availableSortBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultSortBy() {
		return defaultSortBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultSortBy(String newDefaultSortBy) {
		String oldDefaultSortBy = defaultSortBy;
		defaultSortBy = newDefaultSortBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__DEFAULT_SORT_BY, oldDefaultSortBy, defaultSortBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAnchor() {
		return anchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnchor(boolean newAnchor) {
		boolean oldAnchor = anchor;
		anchor = newAnchor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__ANCHOR, oldAnchor, anchor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIncludeInMenu() {
		return includeInMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncludeInMenu(boolean newIncludeInMenu) {
		boolean oldIncludeInMenu = includeInMenu;
		includeInMenu = newIncludeInMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__INCLUDE_IN_MENU, oldIncludeInMenu, includeInMenu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCatalogName() {
		return catalogName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCatalogName(String newCatalogName) {
		String oldCatalogName = catalogName;
		catalogName = newCatalogName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__CATALOG_NAME, oldCatalogName, catalogName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultMixin() {
		return defaultMixin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultMixin(String newDefaultMixin) {
		String oldDefaultMixin = defaultMixin;
		defaultMixin = newDefaultMixin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__DEFAULT_MIXIN, oldDefaultMixin, defaultMixin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getUName() {
		return Strings.nullToEmpty(getNsPrefix()) + "_" + Strings.nullToEmpty(getId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentUName() {
		return parentUName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentUName(String newParentUName) {
		String oldParentUName = parentUName;
		parentUName = newParentUName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CategoryPackage.CATEGORY__PARENT_UNAME, oldParentUName, parentUName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void resolve(EntityLookup<Category, String> categoryLookup) {
		final EObject catalog = EcoreUtil.getRootContainer(this);
		if (catalog instanceof CategoryCatalog) {
			setCatalogName(((CategoryCatalog) catalog).getName());
		} else {
			// TODO: hendy, please fix this -- happens to gerairazha
			log.warn("Unable to resolve(): Expected root container to be {}, got {} for {}. Stacktrace: {}",
					CategoryCatalog.class.getName(), catalog.getClass().getName(), this.getClass().getName(), new Exception().getStackTrace());
		}
		
		if (getParent() == null && getParentUName() != null && categoryLookup != null) {
			// set parent if parentUName is specified
			setParent(categoryLookup.findOne(getParentUName()));
		} else if (getParent() != null) {
			// otherwise, sync to parentUName
			setParentUName(getParent() != null ? getParent().getUName() : null);
		}
		
		if (getId() == null) {
			setId( (getParent() != null ? getParent().getId() + "_" : "") + SlugUtils.generateId(getName()) );
		}
		if (getSlug() == null) {
			setSlug(SlugUtils.generateSegment(getName()));
		}
		setSlugPath(Joiner.on('/').join(getSlugSegments(this)));
		setCategoryCount((long) getCategories().size());
		setLevel(getLevel(this));
		for (final Category child : getCategories()) {
			child.setParent(this);
		}
	}

	protected List<String> getNameSegments(Category category) {
		return category.getParent() != null
				? ImmutableList.copyOf(Iterables.concat(getNameSegments(category.getParent()), ImmutableList.of(category.getName())))
				: ImmutableList.<String>of(category.getName());
	}

	protected List<String> getSlugSegments(Category category) {
		return category.getParent() != null
				? ImmutableList.copyOf(Iterables.concat(getSlugSegments(category.getParent()), ImmutableList.of(category.getSlug())))
				: ImmutableList.<String>of(category.getSlug());
	}

	protected int getLevel(Category category) {
		return category.getParent() != null
				? getLevel(category.getParent()) + 1
				: 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public CategoryInfo toInfo() {
		return new ToCategoryInfo().apply(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CategoryPackage.CATEGORY__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CategoryPackage.CATEGORY__ID:
				return getId();
			case CategoryPackage.CATEGORY__NS_PREFIX:
				return getNsPrefix();
			case CategoryPackage.CATEGORY__NAME:
				return getName();
			case CategoryPackage.CATEGORY__POSITIONER:
				return getPositioner();
			case CategoryPackage.CATEGORY__SLUG:
				return getSlug();
			case CategoryPackage.CATEGORY__SLUG_PATH:
				return getSlugPath();
			case CategoryPackage.CATEGORY__COLOR:
				return getColor();
			case CategoryPackage.CATEGORY__IMAGE_ID:
				return getImageId();
			case CategoryPackage.CATEGORY__LEVEL:
				return getLevel();
			case CategoryPackage.CATEGORY__CATEGORY_COUNT:
				return getCategoryCount();
			case CategoryPackage.CATEGORY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case CategoryPackage.CATEGORY__RESOURCE_TYPE:
				return getResourceType();
			case CategoryPackage.CATEGORY__RESOURCE_URI:
				return getResourceUri();
			case CategoryPackage.CATEGORY__RESOURCE_NAME:
				return getResourceName();
			case CategoryPackage.CATEGORY__BUNDLE:
				return getBundle();
			case CategoryPackage.CATEGORY__CATEGORIES:
				return getCategories();
			case CategoryPackage.CATEGORY__DESCRIPTION:
				return getDescription();
			case CategoryPackage.CATEGORY__STATUS:
				return getStatus();
			case CategoryPackage.CATEGORY__META_DESCRIPTION:
				return getMetaDescription();
			case CategoryPackage.CATEGORY__META_KEYWORDS:
				return getMetaKeywords();
			case CategoryPackage.CATEGORY__META_TITLE:
				return getMetaTitle();
			case CategoryPackage.CATEGORY__AVAILABLE_SORT_BY:
				return getAvailableSortBy();
			case CategoryPackage.CATEGORY__DEFAULT_SORT_BY:
				return getDefaultSortBy();
			case CategoryPackage.CATEGORY__ANCHOR:
				return isAnchor();
			case CategoryPackage.CATEGORY__INCLUDE_IN_MENU:
				return isIncludeInMenu();
			case CategoryPackage.CATEGORY__CATALOG_NAME:
				return getCatalogName();
			case CategoryPackage.CATEGORY__DEFAULT_MIXIN:
				return getDefaultMixin();
			case CategoryPackage.CATEGORY__UNAME:
				return getUName();
			case CategoryPackage.CATEGORY__PARENT_UNAME:
				return getParentUName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CategoryPackage.CATEGORY__ID:
				setId((String)newValue);
				return;
			case CategoryPackage.CATEGORY__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case CategoryPackage.CATEGORY__NAME:
				setName((String)newValue);
				return;
			case CategoryPackage.CATEGORY__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case CategoryPackage.CATEGORY__SLUG:
				setSlug((String)newValue);
				return;
			case CategoryPackage.CATEGORY__SLUG_PATH:
				setSlugPath((String)newValue);
				return;
			case CategoryPackage.CATEGORY__COLOR:
				setColor((String)newValue);
				return;
			case CategoryPackage.CATEGORY__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case CategoryPackage.CATEGORY__LEVEL:
				setLevel((Integer)newValue);
				return;
			case CategoryPackage.CATEGORY__CATEGORY_COUNT:
				setCategoryCount((Long)newValue);
				return;
			case CategoryPackage.CATEGORY__PARENT:
				setParent((Category)newValue);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case CategoryPackage.CATEGORY__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case CategoryPackage.CATEGORY__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case CategoryPackage.CATEGORY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CategoryPackage.CATEGORY__STATUS:
				setStatus((CategoryStatus)newValue);
				return;
			case CategoryPackage.CATEGORY__META_DESCRIPTION:
				setMetaDescription((String)newValue);
				return;
			case CategoryPackage.CATEGORY__META_KEYWORDS:
				setMetaKeywords((String)newValue);
				return;
			case CategoryPackage.CATEGORY__META_TITLE:
				setMetaTitle((String)newValue);
				return;
			case CategoryPackage.CATEGORY__AVAILABLE_SORT_BY:
				setAvailableSortBy((List<String>)newValue);
				return;
			case CategoryPackage.CATEGORY__DEFAULT_SORT_BY:
				setDefaultSortBy((String)newValue);
				return;
			case CategoryPackage.CATEGORY__ANCHOR:
				setAnchor((Boolean)newValue);
				return;
			case CategoryPackage.CATEGORY__INCLUDE_IN_MENU:
				setIncludeInMenu((Boolean)newValue);
				return;
			case CategoryPackage.CATEGORY__CATALOG_NAME:
				setCatalogName((String)newValue);
				return;
			case CategoryPackage.CATEGORY__DEFAULT_MIXIN:
				setDefaultMixin((String)newValue);
				return;
			case CategoryPackage.CATEGORY__PARENT_UNAME:
				setParentUName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CategoryPackage.CATEGORY__ID:
				setId(ID_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__SLUG_PATH:
				setSlugPath(SLUG_PATH_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__CATEGORY_COUNT:
				setCategoryCount(CATEGORY_COUNT_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__PARENT:
				setParent((Category)null);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__CATEGORIES:
				getCategories().clear();
				return;
			case CategoryPackage.CATEGORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__META_DESCRIPTION:
				setMetaDescription(META_DESCRIPTION_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__META_KEYWORDS:
				setMetaKeywords(META_KEYWORDS_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__META_TITLE:
				setMetaTitle(META_TITLE_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__AVAILABLE_SORT_BY:
				setAvailableSortBy((List<String>)null);
				return;
			case CategoryPackage.CATEGORY__DEFAULT_SORT_BY:
				setDefaultSortBy(DEFAULT_SORT_BY_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__ANCHOR:
				setAnchor(ANCHOR_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__INCLUDE_IN_MENU:
				setIncludeInMenu(INCLUDE_IN_MENU_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__CATALOG_NAME:
				setCatalogName(CATALOG_NAME_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__DEFAULT_MIXIN:
				setDefaultMixin(DEFAULT_MIXIN_EDEFAULT);
				return;
			case CategoryPackage.CATEGORY__PARENT_UNAME:
				setParentUName(PARENT_UNAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CategoryPackage.CATEGORY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CategoryPackage.CATEGORY__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case CategoryPackage.CATEGORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CategoryPackage.CATEGORY__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case CategoryPackage.CATEGORY__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case CategoryPackage.CATEGORY__SLUG_PATH:
				return SLUG_PATH_EDEFAULT == null ? slugPath != null : !SLUG_PATH_EDEFAULT.equals(slugPath);
			case CategoryPackage.CATEGORY__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case CategoryPackage.CATEGORY__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case CategoryPackage.CATEGORY__LEVEL:
				return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
			case CategoryPackage.CATEGORY__CATEGORY_COUNT:
				return CATEGORY_COUNT_EDEFAULT == null ? categoryCount != null : !CATEGORY_COUNT_EDEFAULT.equals(categoryCount);
			case CategoryPackage.CATEGORY__PARENT:
				return parent != null;
			case CategoryPackage.CATEGORY__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case CategoryPackage.CATEGORY__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case CategoryPackage.CATEGORY__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case CategoryPackage.CATEGORY__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case CategoryPackage.CATEGORY__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case CategoryPackage.CATEGORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CategoryPackage.CATEGORY__STATUS:
				return status != STATUS_EDEFAULT;
			case CategoryPackage.CATEGORY__META_DESCRIPTION:
				return META_DESCRIPTION_EDEFAULT == null ? metaDescription != null : !META_DESCRIPTION_EDEFAULT.equals(metaDescription);
			case CategoryPackage.CATEGORY__META_KEYWORDS:
				return META_KEYWORDS_EDEFAULT == null ? metaKeywords != null : !META_KEYWORDS_EDEFAULT.equals(metaKeywords);
			case CategoryPackage.CATEGORY__META_TITLE:
				return META_TITLE_EDEFAULT == null ? metaTitle != null : !META_TITLE_EDEFAULT.equals(metaTitle);
			case CategoryPackage.CATEGORY__AVAILABLE_SORT_BY:
				return availableSortBy != null;
			case CategoryPackage.CATEGORY__DEFAULT_SORT_BY:
				return DEFAULT_SORT_BY_EDEFAULT == null ? defaultSortBy != null : !DEFAULT_SORT_BY_EDEFAULT.equals(defaultSortBy);
			case CategoryPackage.CATEGORY__ANCHOR:
				return anchor != ANCHOR_EDEFAULT;
			case CategoryPackage.CATEGORY__INCLUDE_IN_MENU:
				return includeInMenu != INCLUDE_IN_MENU_EDEFAULT;
			case CategoryPackage.CATEGORY__CATALOG_NAME:
				return CATALOG_NAME_EDEFAULT == null ? catalogName != null : !CATALOG_NAME_EDEFAULT.equals(catalogName);
			case CategoryPackage.CATEGORY__DEFAULT_MIXIN:
				return DEFAULT_MIXIN_EDEFAULT == null ? defaultMixin != null : !DEFAULT_MIXIN_EDEFAULT.equals(defaultMixin);
			case CategoryPackage.CATEGORY__UNAME:
				return UNAME_EDEFAULT == null ? getUName() != null : !UNAME_EDEFAULT.equals(getUName());
			case CategoryPackage.CATEGORY__PARENT_UNAME:
				return PARENT_UNAME_EDEFAULT == null ? parentUName != null : !PARENT_UNAME_EDEFAULT.equals(parentUName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__POSITIONER: return CommonsPackage.POSITIONABLE__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Parentable.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__PARENT: return CommonsPackage.PARENTABLE__PARENT;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case CategoryPackage.CATEGORY__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case CategoryPackage.CATEGORY__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == CategoryContainer.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__CATEGORIES: return CategoryPackage.CATEGORY_CONTAINER__CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case CategoryPackage.CATEGORY__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Informer.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return CategoryPackage.CATEGORY__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return CategoryPackage.CATEGORY__NAME;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.POSITIONABLE__POSITIONER: return CategoryPackage.CATEGORY__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return CategoryPackage.CATEGORY__SLUG;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Parentable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.PARENTABLE__PARENT: return CategoryPackage.CATEGORY__PARENT;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return CategoryPackage.CATEGORY__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return CategoryPackage.CATEGORY__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return CategoryPackage.CATEGORY__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return CategoryPackage.CATEGORY__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == CategoryContainer.class) {
			switch (baseFeatureID) {
				case CategoryPackage.CATEGORY_CONTAINER__CATEGORIES: return CategoryPackage.CATEGORY__CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return CategoryPackage.CATEGORY__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Informer.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", name: ");
		result.append(name);
		result.append(", positioner: ");
		result.append(positioner);
		result.append(", slug: ");
		result.append(slug);
		result.append(", slugPath: ");
		result.append(slugPath);
		result.append(", color: ");
		result.append(color);
		result.append(", imageId: ");
		result.append(imageId);
		result.append(", level: ");
		result.append(level);
		result.append(", categoryCount: ");
		result.append(categoryCount);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", description: ");
		result.append(description);
		result.append(", status: ");
		result.append(status);
		result.append(", metaDescription: ");
		result.append(metaDescription);
		result.append(", metaKeywords: ");
		result.append(metaKeywords);
		result.append(", metaTitle: ");
		result.append(metaTitle);
		result.append(", availableSortBy: ");
		result.append(availableSortBy);
		result.append(", defaultSortBy: ");
		result.append(defaultSortBy);
		result.append(", anchor: ");
		result.append(anchor);
		result.append(", includeInMenu: ");
		result.append(includeInMenu);
		result.append(", catalogName: ");
		result.append(catalogName);
		result.append(", defaultMixin: ");
		result.append(defaultMixin);
		result.append(", parentUName: ");
		result.append(parentUName);
		result.append(')');
		return result.toString();
	}

} //CategoryImpl
