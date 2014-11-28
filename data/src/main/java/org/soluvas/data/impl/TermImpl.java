/**
 */
package org.soluvas.data.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Colorable;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.Translatable;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.impl.TranslationEntryImpl;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Term;
import org.soluvas.data.TermValue;
import org.soluvas.data.Vocab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getTranslationState <em>Translation State</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getOriginalLanguage <em>Original Language</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getTranslations <em>Translations</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getVocab <em>Vocab</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getKindNsPrefix <em>Kind Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getKindName <em>Kind Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#isBordered <em>Bordered</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getImageUri <em>Image Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermImpl#getSameAsUris <em>Same As Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermImpl extends EObjectImpl implements Term {
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<Term> terms;

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
	@JsonIgnore
	protected Bundle bundle = BUNDLE_EDEFAULT;

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
	@JsonIgnore
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
	@JsonIgnore
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
	@JsonIgnore
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getVocab() <em>Vocab</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVocab()
	 * @generated
	 * @ordered
	 */
	protected Vocab vocab;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getKindNsPrefix() <em>Kind Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKindNsPrefix() <em>Kind Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String kindNsPrefix = KIND_NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKindName() <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKindName()
	 * @generated
	 * @ordered
	 */
	protected String kindName = KIND_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isBordered() <em>Bordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBordered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBordered() <em>Bordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBordered()
	 * @generated
	 * @ordered
	 */
	protected boolean bordered = BORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageUri() <em>Image Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageUri()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageUri() <em>Image Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageUri()
	 * @generated
	 * @ordered
	 */
	protected String imageUri = IMAGE_URI_EDEFAULT;

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
	 * The cached value of the '{@link #getSameAsUris() <em>Same As Uris</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSameAsUris()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sameAsUris;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Term> getTerms() {
		if (terms == null) {
			terms = new EObjectResolvingEList<Term>(Term.class, this, DataPackage.TERM__TERMS);
		}
		return terms;
	}
	
	protected void setTerms(EList<Term> terms) {
		getTerms().clear();
		getTerms().addAll(terms);
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__BUNDLE, oldBundle, bundle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__RESOURCE_TYPE, oldResourceType, resourceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__NS_PREFIX, oldNsPrefix, nsPrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__POSITIONER, oldPositioner, positioner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__COLOR, oldColor, color));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__TRANSLATION_STATE, oldTranslationState, translationState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__ORIGINAL_LANGUAGE, oldOriginalLanguage, originalLanguage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Translation> getTranslations() {
		if (translations == null) {
			translations = new EcoreEMap<String,Translation>(CommonsPackage.Literals.TRANSLATION_ENTRY, TranslationEntryImpl.class, this, DataPackage.TERM__TRANSLATIONS);
		}
		return translations;
	}
	
	protected void setTranslations(Map<String, Translation> translations) {
		getTranslations().clear();
		getTranslations().putAll(translations);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vocab getVocab() {
		if (vocab != null && vocab.eIsProxy()) {
			InternalEObject oldVocab = (InternalEObject)vocab;
			vocab = (Vocab)eResolveProxy(oldVocab);
			if (vocab != oldVocab) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.TERM__VOCAB, oldVocab, vocab));
			}
		}
		return vocab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocab basicGetVocab() {
		return vocab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVocab(Vocab newVocab) {
		Vocab oldVocab = vocab;
		vocab = newVocab;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__VOCAB, oldVocab, vocab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__DISPLAY_NAME, oldDisplayName, displayName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKindNsPrefix() {
		return kindNsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKindNsPrefix(String newKindNsPrefix) {
		String oldKindNsPrefix = kindNsPrefix;
		kindNsPrefix = newKindNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__KIND_NS_PREFIX, oldKindNsPrefix, kindNsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKindName() {
		return kindName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKindName(String newKindName) {
		String oldKindName = kindName;
		kindName = newKindName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__KIND_NAME, oldKindName, kindName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBordered() {
		return bordered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBordered(boolean newBordered) {
		boolean oldBordered = bordered;
		bordered = newBordered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__BORDERED, oldBordered, bordered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageUri(String newImageUri) {
		String oldImageUri = imageUri;
		imageUri = newImageUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__IMAGE_URI, oldImageUri, imageUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM__PRIMARY_URI, oldPrimaryUri, primaryUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getSameAsUris() {
		if (sameAsUris == null) {
			sameAsUris = new EDataTypeUniqueEList<String>(String.class, this, DataPackage.TERM__SAME_AS_URIS);
		}
		return sameAsUris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	@JsonIgnore
	public String getQName() {
		return Strings.nullToEmpty(getNsPrefix()) + "_" + Strings.nullToEmpty(getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public TermValue toValue() {
		final TermValue value = new TermValueImpl(getQName(), getDisplayName(), getPrimaryUri());
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @Nullable
	public String getImageUri(String imagesUri) {
		if (!Strings.isNullOrEmpty(getImageId())) {
			final String uri;
			if ("base".equals(getNsPrefix())) {
//				final String bundleName =  ? "org.soluvas.data" : "tenant_common";
				uri = imagesUri + "org.soluvas.data/" + getKindNsPrefix() + "_" + getKindName() +"/" + getImageId() + ".png";
			} else {
				// on 5.3.x this was imagesUri/tenant_common/kindNsPrefix_kindName/imageId.png
				uri = imagesUri + "term/" + getNsPrefix() + "/" + getKindNsPrefix() + "_" + getKindName() + "/" + getImageId() + ".png";
			}
			return uri;
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.TERM__TRANSLATIONS:
				return ((InternalEList<?>)getTranslations()).basicRemove(otherEnd, msgs);
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
			case DataPackage.TERM__TERMS:
				return getTerms();
			case DataPackage.TERM__BUNDLE:
				return getBundle();
			case DataPackage.TERM__NAME:
				return getName();
			case DataPackage.TERM__RESOURCE_TYPE:
				return getResourceType();
			case DataPackage.TERM__RESOURCE_URI:
				return getResourceUri();
			case DataPackage.TERM__RESOURCE_NAME:
				return getResourceName();
			case DataPackage.TERM__NS_PREFIX:
				return getNsPrefix();
			case DataPackage.TERM__POSITIONER:
				return getPositioner();
			case DataPackage.TERM__COLOR:
				return getColor();
			case DataPackage.TERM__TRANSLATION_STATE:
				return getTranslationState();
			case DataPackage.TERM__ORIGINAL_LANGUAGE:
				return getOriginalLanguage();
			case DataPackage.TERM__LANGUAGE:
				return getLanguage();
			case DataPackage.TERM__TRANSLATIONS:
				if (coreType) return getTranslations();
				else return getTranslations().map();
			case DataPackage.TERM__VOCAB:
				if (resolve) return getVocab();
				return basicGetVocab();
			case DataPackage.TERM__DISPLAY_NAME:
				return getDisplayName();
			case DataPackage.TERM__IMAGE_ID:
				return getImageId();
			case DataPackage.TERM__KIND_NS_PREFIX:
				return getKindNsPrefix();
			case DataPackage.TERM__KIND_NAME:
				return getKindName();
			case DataPackage.TERM__BORDERED:
				return isBordered();
			case DataPackage.TERM__IMAGE_URI:
				return getImageUri();
			case DataPackage.TERM__PRIMARY_URI:
				return getPrimaryUri();
			case DataPackage.TERM__SAME_AS_URIS:
				return getSameAsUris();
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
			case DataPackage.TERM__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends Term>)newValue);
				return;
			case DataPackage.TERM__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case DataPackage.TERM__NAME:
				setName((String)newValue);
				return;
			case DataPackage.TERM__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case DataPackage.TERM__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case DataPackage.TERM__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case DataPackage.TERM__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case DataPackage.TERM__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case DataPackage.TERM__COLOR:
				setColor((String)newValue);
				return;
			case DataPackage.TERM__TRANSLATION_STATE:
				setTranslationState((TranslationState)newValue);
				return;
			case DataPackage.TERM__ORIGINAL_LANGUAGE:
				setOriginalLanguage((String)newValue);
				return;
			case DataPackage.TERM__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case DataPackage.TERM__TRANSLATIONS:
				((EStructuralFeature.Setting)getTranslations()).set(newValue);
				return;
			case DataPackage.TERM__VOCAB:
				setVocab((Vocab)newValue);
				return;
			case DataPackage.TERM__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case DataPackage.TERM__IMAGE_ID:
				setImageId((String)newValue);
				return;
			case DataPackage.TERM__KIND_NS_PREFIX:
				setKindNsPrefix((String)newValue);
				return;
			case DataPackage.TERM__KIND_NAME:
				setKindName((String)newValue);
				return;
			case DataPackage.TERM__BORDERED:
				setBordered((Boolean)newValue);
				return;
			case DataPackage.TERM__IMAGE_URI:
				setImageUri((String)newValue);
				return;
			case DataPackage.TERM__PRIMARY_URI:
				setPrimaryUri((String)newValue);
				return;
			case DataPackage.TERM__SAME_AS_URIS:
				getSameAsUris().clear();
				getSameAsUris().addAll((Collection<? extends String>)newValue);
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
			case DataPackage.TERM__TERMS:
				getTerms().clear();
				return;
			case DataPackage.TERM__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case DataPackage.TERM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.TERM__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case DataPackage.TERM__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case DataPackage.TERM__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case DataPackage.TERM__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case DataPackage.TERM__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case DataPackage.TERM__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case DataPackage.TERM__TRANSLATION_STATE:
				setTranslationState(TRANSLATION_STATE_EDEFAULT);
				return;
			case DataPackage.TERM__ORIGINAL_LANGUAGE:
				setOriginalLanguage(ORIGINAL_LANGUAGE_EDEFAULT);
				return;
			case DataPackage.TERM__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case DataPackage.TERM__TRANSLATIONS:
				getTranslations().clear();
				return;
			case DataPackage.TERM__VOCAB:
				setVocab((Vocab)null);
				return;
			case DataPackage.TERM__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case DataPackage.TERM__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case DataPackage.TERM__KIND_NS_PREFIX:
				setKindNsPrefix(KIND_NS_PREFIX_EDEFAULT);
				return;
			case DataPackage.TERM__KIND_NAME:
				setKindName(KIND_NAME_EDEFAULT);
				return;
			case DataPackage.TERM__BORDERED:
				setBordered(BORDERED_EDEFAULT);
				return;
			case DataPackage.TERM__IMAGE_URI:
				setImageUri(IMAGE_URI_EDEFAULT);
				return;
			case DataPackage.TERM__PRIMARY_URI:
				setPrimaryUri(PRIMARY_URI_EDEFAULT);
				return;
			case DataPackage.TERM__SAME_AS_URIS:
				getSameAsUris().clear();
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
			case DataPackage.TERM__TERMS:
				return terms != null && !terms.isEmpty();
			case DataPackage.TERM__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case DataPackage.TERM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.TERM__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case DataPackage.TERM__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case DataPackage.TERM__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case DataPackage.TERM__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case DataPackage.TERM__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case DataPackage.TERM__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case DataPackage.TERM__TRANSLATION_STATE:
				return translationState != TRANSLATION_STATE_EDEFAULT;
			case DataPackage.TERM__ORIGINAL_LANGUAGE:
				return ORIGINAL_LANGUAGE_EDEFAULT == null ? originalLanguage != null : !ORIGINAL_LANGUAGE_EDEFAULT.equals(originalLanguage);
			case DataPackage.TERM__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case DataPackage.TERM__TRANSLATIONS:
				return translations != null && !translations.isEmpty();
			case DataPackage.TERM__VOCAB:
				return vocab != null;
			case DataPackage.TERM__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case DataPackage.TERM__IMAGE_ID:
				return IMAGE_ID_EDEFAULT == null ? imageId != null : !IMAGE_ID_EDEFAULT.equals(imageId);
			case DataPackage.TERM__KIND_NS_PREFIX:
				return KIND_NS_PREFIX_EDEFAULT == null ? kindNsPrefix != null : !KIND_NS_PREFIX_EDEFAULT.equals(kindNsPrefix);
			case DataPackage.TERM__KIND_NAME:
				return KIND_NAME_EDEFAULT == null ? kindName != null : !KIND_NAME_EDEFAULT.equals(kindName);
			case DataPackage.TERM__BORDERED:
				return bordered != BORDERED_EDEFAULT;
			case DataPackage.TERM__IMAGE_URI:
				return IMAGE_URI_EDEFAULT == null ? imageUri != null : !IMAGE_URI_EDEFAULT.equals(imageUri);
			case DataPackage.TERM__PRIMARY_URI:
				return PRIMARY_URI_EDEFAULT == null ? primaryUri != null : !PRIMARY_URI_EDEFAULT.equals(primaryUri);
			case DataPackage.TERM__SAME_AS_URIS:
				return sameAsUris != null && !sameAsUris.isEmpty();
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
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
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
				case DataPackage.TERM__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case DataPackage.TERM__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case DataPackage.TERM__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__POSITIONER: return CommonsPackage.POSITIONABLE__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Colorable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__COLOR: return CommonsPackage.COLORABLE__COLOR;
				default: return -1;
			}
		}
		if (baseClass == Translatable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM__TRANSLATION_STATE: return CommonsPackage.TRANSLATABLE__TRANSLATION_STATE;
				case DataPackage.TERM__ORIGINAL_LANGUAGE: return CommonsPackage.TRANSLATABLE__ORIGINAL_LANGUAGE;
				case DataPackage.TERM__LANGUAGE: return CommonsPackage.TRANSLATABLE__LANGUAGE;
				case DataPackage.TERM__TRANSLATIONS: return CommonsPackage.TRANSLATABLE__TRANSLATIONS;
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
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return DataPackage.TERM__BUNDLE;
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
				case CommonsPackage.NAME_CONTAINER__NAME: return DataPackage.TERM__NAME;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return DataPackage.TERM__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return DataPackage.TERM__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return DataPackage.TERM__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return DataPackage.TERM__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Positionable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.POSITIONABLE__POSITIONER: return DataPackage.TERM__POSITIONER;
				default: return -1;
			}
		}
		if (baseClass == Colorable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.COLORABLE__COLOR: return DataPackage.TERM__COLOR;
				default: return -1;
			}
		}
		if (baseClass == Translatable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TRANSLATABLE__TRANSLATION_STATE: return DataPackage.TERM__TRANSLATION_STATE;
				case CommonsPackage.TRANSLATABLE__ORIGINAL_LANGUAGE: return DataPackage.TERM__ORIGINAL_LANGUAGE;
				case CommonsPackage.TRANSLATABLE__LANGUAGE: return DataPackage.TERM__LANGUAGE;
				case CommonsPackage.TRANSLATABLE__TRANSLATIONS: return DataPackage.TERM__TRANSLATIONS;
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
		result.append(" (bundle: ");
		result.append(bundle);
		result.append(", name: ");
		result.append(name);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", positioner: ");
		result.append(positioner);
		result.append(", color: ");
		result.append(color);
		result.append(", translationState: ");
		result.append(translationState);
		result.append(", originalLanguage: ");
		result.append(originalLanguage);
		result.append(", language: ");
		result.append(language);
		result.append(", displayName: ");
		result.append(displayName);
		result.append(", imageId: ");
		result.append(imageId);
		result.append(", kindNsPrefix: ");
		result.append(kindNsPrefix);
		result.append(", kindName: ");
		result.append(kindName);
		result.append(", bordered: ");
		result.append(bordered);
		result.append(", imageUri: ");
		result.append(imageUri);
		result.append(", primaryUri: ");
		result.append(primaryUri);
		result.append(", sameAsUris: ");
		result.append(sameAsUris);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kindName == null) ? 0 : kindName.hashCode());
		result = prime * result
				+ ((kindNsPrefix == null) ? 0 : kindNsPrefix.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nsPrefix == null) ? 0 : nsPrefix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TermImpl other = (TermImpl) obj;
		if (kindName == null) {
			if (other.kindName != null)
				return false;
		} else if (!kindName.equals(other.kindName))
			return false;
		if (kindNsPrefix == null) {
			if (other.kindNsPrefix != null)
				return false;
		} else if (!kindNsPrefix.equals(other.kindNsPrefix))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nsPrefix == null) {
			if (other.nsPrefix != null)
				return false;
		} else if (!nsPrefix.equals(other.nsPrefix))
			return false;
		return true;
	}
	
	

} //TermImpl
