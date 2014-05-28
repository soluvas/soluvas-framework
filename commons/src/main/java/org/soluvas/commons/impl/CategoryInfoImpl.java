/**
 */
package org.soluvas.commons.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.Sluggable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getSlugPath <em>Slug Path</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getCategoryCount <em>Category Count</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryInfoImpl extends MinimalEObjectImpl.Container implements CategoryInfo {
	
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
	protected CategoryInfo parent;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<CategoryInfo> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.CATEGORY_INFO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__POSITIONER, oldPositioner, positioner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__SLUG, oldSlug, slug));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__NS_PREFIX, oldNsPrefix, nsPrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__SLUG_PATH, oldSlugPath, slugPath));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__COLOR, oldColor, color));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__IMAGE_ID, oldImageId, imageId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__LEVEL, oldLevel, level));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__CATEGORY_COUNT, oldCategoryCount, categoryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CategoryInfo getParent() {
		if (parent != null && ((EObject)parent).eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (CategoryInfo)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonsPackage.CATEGORY_INFO__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryInfo basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(CategoryInfo newParent) {
		CategoryInfo oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CategoryInfo> getParents() {
		if (parents == null) {
			parents = new EObjectContainmentEList<>(CategoryInfo.class, this, CommonsPackage.CATEGORY_INFO__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				return ((InternalEList<?>)getParents()).basicRemove(otherEnd, msgs);
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
			case CommonsPackage.CATEGORY_INFO__ID:
				return getId();
			case CommonsPackage.CATEGORY_INFO__NS_PREFIX:
				return getNsPrefix();
			case CommonsPackage.CATEGORY_INFO__NAME:
				return getName();
			case CommonsPackage.CATEGORY_INFO__POSITIONER:
				return getPositioner();
			case CommonsPackage.CATEGORY_INFO__SLUG:
				return getSlug();
			case CommonsPackage.CATEGORY_INFO__SLUG_PATH:
				return getSlugPath();
			case CommonsPackage.CATEGORY_INFO__COLOR:
				return getColor();
			case CommonsPackage.CATEGORY_INFO__IMAGE_ID:
				return getImageId();
			case CommonsPackage.CATEGORY_INFO__LEVEL:
				return getLevel();
			case CommonsPackage.CATEGORY_INFO__CATEGORY_COUNT:
				return getCategoryCount();
			case CommonsPackage.CATEGORY_INFO__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				return getParents();
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
			case CommonsPackage.CATEGORY_INFO__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__SLUG:
				setSlug((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__SLUG_PATH:
				setSlugPath((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__COLOR:
				setColor((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__LEVEL:
				setLevel((Integer)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__CATEGORY_COUNT:
				setCategoryCount((Long)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__PARENT:
				setParent((CategoryInfo)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends CategoryInfo>)newValue);
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
			case CommonsPackage.CATEGORY_INFO__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__SLUG_PATH:
				setSlugPath(SLUG_PATH_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__CATEGORY_COUNT:
				setCategoryCount(CATEGORY_COUNT_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__PARENT:
				setParent((CategoryInfo)null);
				return;
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				getParents().clear();
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
			case CommonsPackage.CATEGORY_INFO__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.CATEGORY_INFO__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case CommonsPackage.CATEGORY_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.CATEGORY_INFO__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case CommonsPackage.CATEGORY_INFO__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case CommonsPackage.CATEGORY_INFO__SLUG_PATH:
				return SLUG_PATH_EDEFAULT == null ? slugPath != null : !SLUG_PATH_EDEFAULT.equals(slugPath);
			case CommonsPackage.CATEGORY_INFO__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case CommonsPackage.CATEGORY_INFO__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case CommonsPackage.CATEGORY_INFO__LEVEL:
				return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
			case CommonsPackage.CATEGORY_INFO__CATEGORY_COUNT:
				return CATEGORY_COUNT_EDEFAULT == null ? categoryCount != null : !CATEGORY_COUNT_EDEFAULT.equals(categoryCount);
			case CommonsPackage.CATEGORY_INFO__PARENT:
				return parent != null;
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				return parents != null && !parents.isEmpty();
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
				case CommonsPackage.CATEGORY_INFO__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
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
				case CommonsPackage.CATEGORY_INFO__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CATEGORY_INFO__POSITIONER: return CommonsPackage.POSITIONABLE__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CATEGORY_INFO__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
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
				case CommonsPackage.CATEGORY_INFO__PARENT: return CommonsPackage.PARENTABLE__PARENT;
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
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return CommonsPackage.CATEGORY_INFO__NS_PREFIX;
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
				case CommonsPackage.NAME_CONTAINER__NAME: return CommonsPackage.CATEGORY_INFO__NAME;
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.POSITIONABLE__POSITIONER: return CommonsPackage.CATEGORY_INFO__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return CommonsPackage.CATEGORY_INFO__SLUG;
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
				case CommonsPackage.PARENTABLE__PARENT: return CommonsPackage.CATEGORY_INFO__PARENT;
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
		result.append(')');
		return result.toString();
	}

} //CategoryInfoImpl
