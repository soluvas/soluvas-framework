/**
 */
package org.soluvas.commons.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CategoryInfo2;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.Sluggable;
import org.soluvas.commons.Translatable;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationState;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Optional;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
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
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getTranslationState <em>Translation State</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getOriginalLanguage <em>Original Language</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getTranslations <em>Translations</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CategoryInfoImpl#getGoogleFormalId <em>Google Formal Id</em>}</li>
 * </ul>
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
	 * The default value of the '{@link #getTranslationState() <em>Translation State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationState()
	 * @generated
	 * @ordered
	 */
	protected static final TranslationState TRANSLATION_STATE_EDEFAULT = TranslationState.ORIGINAL;

	/**
	 * The cached value of the '{@link #getTranslationState() <em>Translation State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationState()
	 * @generated
	 * @ordered
	 */
	protected TranslationState translationState = TRANSLATION_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginalLanguage() <em>Original Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalLanguage() <em>Original Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalLanguage()
	 * @generated
	 * @ordered
	 */
	protected String originalLanguage = ORIGINAL_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTranslations() <em>Translations</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslations()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Translation> translations;

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
	 * The default value of the '{@link #getPrimaryUri() <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryUri()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryUri() <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryUri()
	 * @generated
	 * @ordered
	 */
	protected String primaryUri = PRIMARY_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleFormalId() <em>Google Formal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleFormalId()
	 * @generated
	 * @ordered
	 */
	protected static final Long GOOGLE_FORMAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleFormalId() <em>Google Formal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleFormalId()
	 * @generated
	 * @ordered
	 */
	protected Long googleFormalId = GOOGLE_FORMAL_ID_EDEFAULT;

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
	public TranslationState getTranslationState() {
		return translationState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationState(TranslationState newTranslationState) {
		TranslationState oldTranslationState = translationState;
		translationState = newTranslationState == null ? TRANSLATION_STATE_EDEFAULT : newTranslationState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE, oldTranslationState, translationState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalLanguage(String newOriginalLanguage) {
		String oldOriginalLanguage = originalLanguage;
		originalLanguage = newOriginalLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE, oldOriginalLanguage, originalLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Translation> getTranslations() {
		if (translations == null) {
			translations = new EcoreEMap<String,Translation>(CommonsPackage.Literals.TRANSLATION_ENTRY, TranslationEntryImpl.class, this, CommonsPackage.CATEGORY_INFO__TRANSLATIONS);
		}
		return translations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CategoryInfo> getParents() {
		if (parents == null) {
			parents = new EObjectContainmentEList<CategoryInfo>(CategoryInfo.class, this, CommonsPackage.CATEGORY_INFO__PARENTS);
		}
		return parents;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryUri() {
		return primaryUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryUri(String newPrimaryUri) {
		String oldPrimaryUri = primaryUri;
		primaryUri = newPrimaryUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__PRIMARY_URI, oldPrimaryUri, primaryUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getGoogleFormalId() {
		return googleFormalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGoogleFormalId(Long newGoogleFormalId) {
		Long oldGoogleFormalId = googleFormalId;
		googleFormalId = newGoogleFormalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CATEGORY_INFO__GOOGLE_FORMAL_ID, oldGoogleFormalId, googleFormalId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@JsonIgnore
	public String getEffectiveName(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getName();
		} else {
			final EMap<String, Translation> translations = getTranslations();
			if (translations.isEmpty()) {
				return getName();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getName();
				} else {
					final Translation translation = translations.get(curLanguageTag);
					if (!translation.getMessages().containsKey(CategoryInfo.NAME_ATTR)) {
						return getName();
					} else {
						final String translatedValue = translation.getMessages().get(CategoryInfo.NAME_ATTR);
						return translatedValue;
					}
				}
			}
		}
	}
	
	@JsonIgnore
	public void setEffectiveName() {
		throw new UnsupportedOperationException();
	}

	protected void setParents(List<CategoryInfo> parents) {
		getParents().clear();
		getParents().addAll(parents);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonsPackage.CATEGORY_INFO__TRANSLATIONS:
				return ((InternalEList<?>)getTranslations()).basicRemove(otherEnd, msgs);
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
			case CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE:
				return getTranslationState();
			case CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE:
				return getOriginalLanguage();
			case CommonsPackage.CATEGORY_INFO__LANGUAGE:
				return getLanguage();
			case CommonsPackage.CATEGORY_INFO__TRANSLATIONS:
				if (coreType) return getTranslations();
				else return getTranslations().map();
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				return getParents();
			case CommonsPackage.CATEGORY_INFO__PRIMARY_URI:
				return getPrimaryUri();
			case CommonsPackage.CATEGORY_INFO__GOOGLE_FORMAL_ID:
				return getGoogleFormalId();
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
			case CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE:
				setTranslationState((TranslationState)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE:
				setOriginalLanguage((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__TRANSLATIONS:
				((EStructuralFeature.Setting)getTranslations()).set(newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends CategoryInfo>)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__PRIMARY_URI:
				setPrimaryUri((String)newValue);
				return;
			case CommonsPackage.CATEGORY_INFO__GOOGLE_FORMAL_ID:
				setGoogleFormalId((Long)newValue);
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
			case CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE:
				setTranslationState(TRANSLATION_STATE_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE:
				setOriginalLanguage(ORIGINAL_LANGUAGE_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__TRANSLATIONS:
				getTranslations().clear();
				return;
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				getParents().clear();
				return;
			case CommonsPackage.CATEGORY_INFO__PRIMARY_URI:
				setPrimaryUri(PRIMARY_URI_EDEFAULT);
				return;
			case CommonsPackage.CATEGORY_INFO__GOOGLE_FORMAL_ID:
				setGoogleFormalId(GOOGLE_FORMAL_ID_EDEFAULT);
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
			case CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE:
				return translationState != TRANSLATION_STATE_EDEFAULT;
			case CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE:
				return ORIGINAL_LANGUAGE_EDEFAULT == null ? originalLanguage != null : !ORIGINAL_LANGUAGE_EDEFAULT.equals(originalLanguage);
			case CommonsPackage.CATEGORY_INFO__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case CommonsPackage.CATEGORY_INFO__TRANSLATIONS:
				return translations != null && !translations.isEmpty();
			case CommonsPackage.CATEGORY_INFO__PARENTS:
				return parents != null && !parents.isEmpty();
			case CommonsPackage.CATEGORY_INFO__PRIMARY_URI:
				return PRIMARY_URI_EDEFAULT == null ? primaryUri != null : !PRIMARY_URI_EDEFAULT.equals(primaryUri);
			case CommonsPackage.CATEGORY_INFO__GOOGLE_FORMAL_ID:
				return GOOGLE_FORMAL_ID_EDEFAULT == null ? googleFormalId != null : !GOOGLE_FORMAL_ID_EDEFAULT.equals(googleFormalId);
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
		if (baseClass == Translatable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE: return CommonsPackage.TRANSLATABLE__TRANSLATION_STATE;
				case CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE: return CommonsPackage.TRANSLATABLE__ORIGINAL_LANGUAGE;
				case CommonsPackage.CATEGORY_INFO__LANGUAGE: return CommonsPackage.TRANSLATABLE__LANGUAGE;
				case CommonsPackage.CATEGORY_INFO__TRANSLATIONS: return CommonsPackage.TRANSLATABLE__TRANSLATIONS;
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
		if (baseClass == Translatable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TRANSLATABLE__TRANSLATION_STATE: return CommonsPackage.CATEGORY_INFO__TRANSLATION_STATE;
				case CommonsPackage.TRANSLATABLE__ORIGINAL_LANGUAGE: return CommonsPackage.CATEGORY_INFO__ORIGINAL_LANGUAGE;
				case CommonsPackage.TRANSLATABLE__LANGUAGE: return CommonsPackage.CATEGORY_INFO__LANGUAGE;
				case CommonsPackage.TRANSLATABLE__TRANSLATIONS: return CommonsPackage.CATEGORY_INFO__TRANSLATIONS;
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
		result.append(", translationState: ");
		result.append(translationState);
		result.append(", originalLanguage: ");
		result.append(originalLanguage);
		result.append(", language: ");
		result.append(language);
		result.append(", primaryUri: ");
		result.append(primaryUri);
		result.append(", googleFormalId: ");
		result.append(googleFormalId);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Full name of this category including its parents, separated by slash.
	 * <a href="http://schema.org/category">schema:Category</a>: A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
	 * @return
	 */
	@JsonIgnore @Override
	public String getFullName() {
		return getFullName("/");
	}
	
	/**
	 * Full name of this category including its parents, separated by separator.
	 * <a href="http://schema.org/category">schema:Category</a>: A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
	 * @param separator For nice presentation, use {@link CategoryInfo#RSAQUO}.
	 * @return
	 */
	@JsonIgnore @Override
	public String getFullName(String separator) {
		String fullName = "";
		for (final CategoryInfo parent : getParents()) {
			fullName += parent.getName() + separator;
		}
		return fullName + getName();
	}
	
	@JsonIgnore @Override
	public String getUName() {
		return getNsPrefix() + "_" + getId();
	}

	@Override
	public CategoryInfo2 toInfo2() {
		
		CategoryInfo2 categoryInfo2 = new CategoryInfo2();
		categoryInfo2.setColor(getColor());
		categoryInfo2.setGoogleFormalId(getGoogleFormalId());
		categoryInfo2.setId(getId());
		categoryInfo2.setImageId(getImageId());
		categoryInfo2.setLevel(getLevel());
		categoryInfo2.setName(getName());
		categoryInfo2.setNsPrefix(getNsPrefix());
		if (getParent() != null){
			categoryInfo2.setParentId(getParent().getId());
		}
		categoryInfo2.setPositioner(getPositioner());
		categoryInfo2.setPrimaryUri(getPrimaryUri());
		categoryInfo2.setSlug(getSlug());
		categoryInfo2.setSlugPath(getSlugPath());
		
		
		return categoryInfo2;
	}
	
} //CategoryInfoImpl
