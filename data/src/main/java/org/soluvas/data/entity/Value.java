/**
 */
package org.soluvas.data.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.soluvas.commons.TranslationState;
import org.soluvas.data.AttributeSemantic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@SuppressWarnings("serial")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS)
public abstract class Value<T> implements Serializable {
	
	public static String VALUE_ATTR = "value";
	
	public static String DISPLAY_VALUE_ATTR = "displayValue";
	
	public static String DISPLAY_NAME_ATTR = "displayName";
	protected static final TranslationState TRANSLATION_STATE_EDEFAULT = TranslationState.ORIGINAL;

	protected TranslationState translationState = TRANSLATION_STATE_EDEFAULT;

	protected static final String ORIGINAL_LANGUAGE_EDEFAULT = null;

	protected String originalLanguage = ORIGINAL_LANGUAGE_EDEFAULT;

	protected static final String LANGUAGE_EDEFAULT = null;

	protected String language = LANGUAGE_EDEFAULT;

	protected Map<String, Map<String, String>> translations;

	protected static final AttributeSemantic SEMANTIC_EDEFAULT = AttributeSemantic.EQUAL;
	
	protected AttributeSemantic semantic = SEMANTIC_EDEFAULT;

	protected static final String DISPLAY_VALUE_EDEFAULT = null;

	protected String displayValue = DISPLAY_VALUE_EDEFAULT;

	public TranslationState getTranslationState() {
		return translationState;
	}

	public void setTranslationState(TranslationState newTranslationState) {
		translationState = newTranslationState == null ? TRANSLATION_STATE_EDEFAULT : newTranslationState;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String newOriginalLanguage) {
		this.originalLanguage = newOriginalLanguage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String newLanguage) {
		this.language = newLanguage;
	}

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

	public AttributeSemantic getSemantic() {
		return semantic;
	}

	public void setSemantic(AttributeSemantic newSemantic) {
		this.semantic = newSemantic == null ? SEMANTIC_EDEFAULT : newSemantic;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String newDisplayValue) {
		this.displayValue = newDisplayValue;
	}

	@JsonIgnore
	public String getString() {
		return getValue() != null ? getValue().toString() : null;
	}
	
	public T getValue() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (translationState: ");
		result.append(translationState);
		result.append(", originalLanguage: ");
		result.append(originalLanguage);
		result.append(", language: ");
		result.append(language);
		result.append(", semantic: ");
		result.append(semantic);
		result.append(", displayValue: ");
		result.append(displayValue);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getString() == null) ? 0 : getString().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Value)) {
			return false;
		}
		Value other = (Value) obj;
		if (getString() == null) {
			if (other.getString() != null) {
				return false;
			}
		} else if (!getString().equals(other.getString())) {
			return false;
		}
		return true;
	}
	
	
} //ValueImpl
