/**
 */
package org.soluvas.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;
import javax.measure.unit.Unit;

import org.soluvas.commons.TranslationState;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyKind;
import org.soluvas.data.TermKind;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Optional;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getTranslationState <em>Translation State</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getOriginalLanguage <em>Original Language</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getTranslations <em>Translations</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getEnumerationId <em>Enumeration Id</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link id.co.bippo.product.impl.OptionTypeImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
public class OptionType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String NAME_ATTR = "name";
	
	@JsonIgnore
	public String getEffectiveName(String curLanguageTag) {
//		log.debug("session language Tag: '{}'", curLanguageTag);
		/**
		 * Run me if error here:
		 * db.product.update({}, {$set: {language: 'id-ID'}}, true, true);
		 */
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getName();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations.isEmpty()) {
				return getName();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getName();
				} else {
					@Nullable final Map<String, String> translation = translations.get(curLanguageTag);
					if (translation != null) {
						if (!translation.containsKey(OptionType.NAME_ATTR)) {
							return getName();
						} else {
							final String translatedValue = translation.get(OptionType.NAME_ATTR);
							return translatedValue;
						}
					} else {
						return getName();
					}
				}
			}
		}
	}
	
	/**
	 * The default value of the '{@link #getTranslationState() <em>Translation State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationState()
	 * @generated NOT
	 * @ordered
	 */
	protected static final TranslationState TRANSLATION_STATE_EDEFAULT = TranslationState.ORIGINAL;

	/**
	 * The cached value of the '{@link #getTranslationState() <em>Translation State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationState()
	 * @generated NOT
	 * @ordered
	 */
	protected TranslationState translationState = TRANSLATION_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOriginalLanguage() <em>Original Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalLanguage()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String ORIGINAL_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalLanguage() <em>Original Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalLanguage()
	 * @generated NOT
	 * @ordered
	 */
	protected String originalLanguage = ORIGINAL_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated NOT
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTranslations() <em>Translations</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslations()
	 * @generated NOT
	 * @ordered
	 */
	protected Map<String, Map<String, String>> translations;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated NOT
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated NOT
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated NOT
	 * @ordered
	 */
	protected List<Option> options;

	/**
	 * The default value of the '{@link #getEnumerationId() <em>Enumeration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String ENUMERATION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumerationId() <em>Enumeration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationId()
	 * @generated NOT
	 * @ordered
	 */
	protected String enumerationId = ENUMERATION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated NOT
	 * @ordered
	 */
	protected static final PropertyKind KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated NOT
	 * @ordered
	 */
	protected PropertyKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated NOT
	 * @ordered
	 */
	protected Unit<?> unit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OptionType() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TranslationState getTranslationState() {
		return translationState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTranslationState(TranslationState newTranslationState) {
		this.translationState = newTranslationState == null ? TRANSLATION_STATE_EDEFAULT : newTranslationState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOriginalLanguage(String newOriginalLanguage) {
		this.originalLanguage = newOriginalLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLanguage(String newLanguage) {
		this.language = newLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, Map<String, String>> getTranslations() {
		if (translations == null) {
			translations = new HashMap<>();
		}
		return translations;
	}
	
	protected void setTranslations(Map<String, Map<String, String>> translations) {
		getTranslations().clear();
		getTranslations().putAll(translations);
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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Option> getOptions() {
		if (options == null) {
			options = new ArrayList<>();
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEnumerationId() {
		return enumerationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEnumerationId(String newEnumerationId) {
		this.enumerationId = newEnumerationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setKind(PropertyKind newKind) {
		this.kind = newKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Unit<?> getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUnit(Unit<?> newUnit) {
		this.unit = newUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (translationState: ");
		result.append(translationState);
		result.append(", originalLanguage: ");
		result.append(originalLanguage);
		result.append(", language: ");
		result.append(language);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", enumerationId: ");
		result.append(enumerationId);
		result.append(", kind: ");
		result.append(kind);
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}
	
	public void copyFromPropertyDefinition(PropertyDefinition propertyDefition, TranslationState translationState) {
		setEnumerationId(propertyDefition.getDefaultEnum());
		setKind(propertyDefition.getDefaultKind());
		setUnit(propertyDefition.getDefaultUnit());
		setDescription(propertyDefition.getDescription());
		setId(propertyDefition.getId());
		if (propertyDefition.getLanguage() != null) {
			setLanguage(propertyDefition.getLanguage());
		}
		setName(propertyDefition.getName());
		setOriginalLanguage(propertyDefition.getLanguage());
		setTranslationState(translationState);

		if (propertyDefition.getTranslations() != null && !propertyDefition.getTranslations().isEmpty()) {
			for (final Entry<String, Map<String, String>> entryTranslation : propertyDefition.getTranslations()
					.entrySet()) {
				final Map<String, String> translation = new HashMap<>();
//				translation.setLanguage(entryTranslation.getKey());
				for (final Entry<String, String> entryMsg : entryTranslation.getValue().entrySet()) {
					translation.put(entryMsg.getKey(), entryMsg.getValue());
				}
				getTranslations().put(entryTranslation.getKey(), translation);
			}
		}
	}

	public void copyFromTermKind(String id, TermKind termKind, TranslationState translationState) {
		setEnumerationId(termKind.getId());
		setKind(PropertyKind.ENUMERATION);
		setUnit(null);
		setDescription(termKind.getDescription());
		setId(id);
		if (termKind.getLanguage() != null) {
			setLanguage(termKind.getLanguage().toLanguageTag());
		}
		setName(termKind.getName());
		setOriginalLanguage(getLanguage());
		setTranslationState(translationState);

		if (termKind.getTranslations() != null && !termKind.getTranslations().isEmpty()) {
			for (final Entry<String, Map<String, String>> entryTranslation : termKind.getTranslations().entrySet()) {
				final Map<String, String> translation = new HashMap<>();
//				translation.setLanguage(entryTranslation.getKey());
				for (final Entry<String, String> entryMsg : entryTranslation.getValue().entrySet()) {
					translation.put(entryMsg.getKey(), entryMsg.getValue());
				}
				getTranslations().put(entryTranslation.getKey(), translation);
			}
		}
	}
	
} //OptionType
