/**
 */
package org.soluvas.data.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.soluvas.commons.TranslationState;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.Term2;

import jline.internal.Preconditions;

public class TermValue extends Value<String> {
	public static String CONTENT_ATTR = "content";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated NOT
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String SLUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated NOT
	 * @ordered
	 */
	protected String slug = SLUG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTerm() <em>Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerm()
	 * @generated NOT
	 * @ordered
	 */
//	protected Term term;

	/**
	 * The default value of the '{@link #getSlugPath() <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlugPath()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String SLUG_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlugPath() <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlugPath()
	 * @generated NOT
	 * @ordered
	 */
	protected String slugPath = SLUG_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated NOT
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryUri() <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryUri()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String PRIMARY_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryUri() <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryUri()
	 * @generated NOT
	 * @ordered
	 */
	protected String primaryUri = PRIMARY_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated NOT
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TermValue() {
		super();
	}

	
	public TermValue(String id, String displayValue) {
		super();
		setValue(id);
		setDisplayValue(displayValue);
	}

	public TermValue(String id, String displayValue, String primaryUri) {
		super();
		setValue(id);
		setDisplayValue(displayValue);
		setPrimaryUri(primaryUri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setId(String newId) {
		this.id = newId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSlug(String newSlug) {
		this.slug = newSlug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
//	public Term getTerm() {
//		return term;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
//	public Term basicGetTerm() {
//		return term;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
//	public void setTerm(Term newTerm) {
//		this.term = newTerm;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSlugPath() {
		return slugPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSlugPath(String newSlugPath) {
		this.slugPath = newSlugPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValue(String newValue) {
		this.value = newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPrimaryUri() {
		return primaryUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPrimaryUri(String newPrimaryUri) {
		this.primaryUri = newPrimaryUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setContent(String newContent) {
		this.content = newContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
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
		if (!(obj instanceof TermValue))
			return false;
		TermValue other = (TermValue) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
	public String getEffectiveContent(String curLanguageTag) {
		Preconditions.checkNotNull("For getting effective content, the curLanguageTag must not be null.");
		if (getTranslations() != null && !getTranslations().isEmpty()) {
			if (curLanguageTag.equals(getLanguage())) {
				return getContent();
			} else {
				final Map<String, String> msg = getTranslations().get(curLanguageTag);
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
	
//	@Override
//	public void copyFrom(org.soluvas.data.Value<?> upValue) {
//		super.copyFrom(upValue);
//		if (upValue instanceof org.soluvas.data.TermValue) {
//			final org.soluvas.data.TermValue upTermValue = (org.soluvas.data.TermValue) upValue;
//			setContent( upTermValue.getContent() );
//			setId( upTermValue.getId() );
//			setPrimaryUri( upTermValue.getPrimaryUri() );
//			setSlug( upTermValue.getSlug() );
//			setSlugPath( upTermValue.getSlugPath() );
////			setTerm( upTermValue.getTerm() );
//			setValue( upTermValue.getValue() );
//		}
//	}
	
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
			final Map<String, String> translation = new HashMap<>();
			for (final Entry<String, String> transEntry : entry.getValue().entrySet()) {
//				translation.setLanguage(key);
				translation.put(transEntry.getKey(), transEntry.getValue());
			}
			getTranslations().put(key, translation);
		}
	}
	
} //TermValue
