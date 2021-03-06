/**
 */
package org.soluvas.data.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Sluggable;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationState;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Term;
import org.soluvas.data.Term2;
import org.soluvas.data.TermValue;

import jline.internal.Preconditions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getTerm <em>Term</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getSlugPath <em>Slug Path</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.TermValueImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TermValueImpl extends ValueImpl<String> implements TermValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * The cached value of the '{@link #getTerm() <em>Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerm()
	 * @generated
	 * @ordered
	 */
	protected Term term;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

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
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermValueImpl() {
		super();
	}

	/**
	 * @param id
	 * @param displayValue
	 * @deprecated Use {@link #TermValueImpl(String, String, String)}
	 */
	@Deprecated
	public TermValueImpl(String id, String displayValue) {
		super();
		setValue(id);
		setDisplayValue(displayValue);
	}

	public TermValueImpl(String id, String displayValue, String primaryUri) {
		super();
		setValue(id);
		setDisplayValue(displayValue);
		setPrimaryUri(primaryUri);
	}

	public TermValueImpl(Term term) {
		super();
		setTerm(term);
		setValue(term.getQName());
		setDisplayValue(term.getDisplayName());
		setPrimaryUri(term.getPrimaryUri());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TERM_VALUE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__SLUG, oldSlug, slug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term getTerm() {
		if (term != null && term.eIsProxy()) {
			InternalEObject oldTerm = (InternalEObject)term;
			term = (Term)eResolveProxy(oldTerm);
			if (term != oldTerm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.TERM_VALUE__TERM, oldTerm, term));
			}
		}
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term basicGetTerm() {
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTerm(Term newTerm) {
		Term oldTerm = term;
		term = newTerm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__TERM, oldTerm, term));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__SLUG_PATH, oldSlugPath, slugPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__VALUE, oldValue, value));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__PRIMARY_URI, oldPrimaryUri, primaryUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TERM_VALUE__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TERM_VALUE__ID:
				return getId();
			case DataPackage.TERM_VALUE__SLUG:
				return getSlug();
			case DataPackage.TERM_VALUE__TERM:
				if (resolve) return getTerm();
				return basicGetTerm();
			case DataPackage.TERM_VALUE__SLUG_PATH:
				return getSlugPath();
			case DataPackage.TERM_VALUE__VALUE:
				return getValue();
			case DataPackage.TERM_VALUE__PRIMARY_URI:
				return getPrimaryUri();
			case DataPackage.TERM_VALUE__CONTENT:
				return getContent();
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
			case DataPackage.TERM_VALUE__ID:
				setId((String)newValue);
				return;
			case DataPackage.TERM_VALUE__SLUG:
				setSlug((String)newValue);
				return;
			case DataPackage.TERM_VALUE__TERM:
				setTerm((Term)newValue);
				return;
			case DataPackage.TERM_VALUE__SLUG_PATH:
				setSlugPath((String)newValue);
				return;
			case DataPackage.TERM_VALUE__VALUE:
				setValue((String)newValue);
				return;
			case DataPackage.TERM_VALUE__PRIMARY_URI:
				setPrimaryUri((String)newValue);
				return;
			case DataPackage.TERM_VALUE__CONTENT:
				setContent((String)newValue);
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
			case DataPackage.TERM_VALUE__ID:
				setId(ID_EDEFAULT);
				return;
			case DataPackage.TERM_VALUE__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case DataPackage.TERM_VALUE__TERM:
				setTerm((Term)null);
				return;
			case DataPackage.TERM_VALUE__SLUG_PATH:
				setSlugPath(SLUG_PATH_EDEFAULT);
				return;
			case DataPackage.TERM_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DataPackage.TERM_VALUE__PRIMARY_URI:
				setPrimaryUri(PRIMARY_URI_EDEFAULT);
				return;
			case DataPackage.TERM_VALUE__CONTENT:
				setContent(CONTENT_EDEFAULT);
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
			case DataPackage.TERM_VALUE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DataPackage.TERM_VALUE__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case DataPackage.TERM_VALUE__TERM:
				return term != null;
			case DataPackage.TERM_VALUE__SLUG_PATH:
				return SLUG_PATH_EDEFAULT == null ? slugPath != null : !SLUG_PATH_EDEFAULT.equals(slugPath);
			case DataPackage.TERM_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DataPackage.TERM_VALUE__PRIMARY_URI:
				return PRIMARY_URI_EDEFAULT == null ? primaryUri != null : !PRIMARY_URI_EDEFAULT.equals(primaryUri);
			case DataPackage.TERM_VALUE__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
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
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM_VALUE__ID: return CommonsPackage.IDENTIFIABLE__ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case DataPackage.TERM_VALUE__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
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
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.IDENTIFIABLE__ID: return DataPackage.TERM_VALUE__ID;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return DataPackage.TERM_VALUE__SLUG;
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
		result.append(", slug: ");
		result.append(slug);
		result.append(", slugPath: ");
		result.append(slugPath);
		result.append(", value: ");
		result.append(value);
		result.append(", primaryUri: ");
		result.append(primaryUri);
		result.append(", content: ");
		result.append(content);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TermValueImpl))
			return false;
		TermValueImpl other = (TermValueImpl) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public void copyFromMongo(Term2 term2) {
		setDisplayValue(term2.getName());
		setId(term2.getId());
		setLanguage(term2.getLanguage());
		setOriginalLanguage(term2.getLanguage());
		setPrimaryUri(term2.getPrimaryUri());
		setSemantic(AttributeSemantic.EQUAL);
		setSlug(null);
		setSlugPath(null);
		setTranslationState(TranslationState.ORIGINAL);
		setValue(term2.getId());
		setContent(term2.getContent());
		for ( final Entry<String, Map<String, String>> entry : term2.getTranslations().entrySet()) {
			final String key = entry.getKey();
			final Translation translation = CommonsFactory.eINSTANCE.createTranslation();
			for (final Entry<String, String> transEntry : entry.getValue().entrySet()) {
				translation.setLanguage(key);
				translation.getMessages().put(transEntry.getKey(), transEntry.getValue());
			}
			getTranslations().put(key, translation);
		}
	}
	
	@Override
	public String getEffectiveContent(String curLanguageTag) {
		Preconditions.checkNotNull("For getting effective content, the curLanguageTag must not be null.");
		if (getTranslations() != null && !getTranslations().isEmpty()) {
			if (curLanguageTag.equals(getLanguage())) {
				return getContent();
			} else {
				final Map<String, String> msg = getTranslations().get(curLanguageTag).getMessages().map();
				if (msg != null && msg.containsKey(CONTENT_ATTR)) {
					return msg.get(CONTENT_ATTR);
				} else {
					return getContent();
				}
			}
		} else {
			return getContent();
		}
	}
	
} //TermValueImpl
