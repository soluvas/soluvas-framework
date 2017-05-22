/**
 */
package org.soluvas.data.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.soluvas.commons.TranslationState;
import org.soluvas.commons.impl.TranslationImpl;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.CurrencyValue;
import org.soluvas.data.DataException;
import org.soluvas.data.MeasureValue;
import org.soluvas.data.RangeValue;
import org.soluvas.data.StringValue;
import org.soluvas.data.TermValue;
import org.soluvas.data.impl.CurrencyValueImpl;
import org.soluvas.data.impl.MeasureValueImpl;
import org.soluvas.data.impl.RangeValueImpl;
import org.soluvas.data.impl.StringValueImpl;
import org.soluvas.data.impl.TermValueImpl;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getTranslationState <em>Translation State</em>}</li>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getOriginalLanguage <em>Original Language</em>}</li>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getTranslations <em>Translations</em>}</li>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getSemantic <em>Semantic</em>}</li>
 *   <li>{@link org.soluvas.data.impl.ValueImpl#getDisplayValue <em>Display Value</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
@SuppressWarnings("serial")
public abstract class Value<T> implements Serializable {
	
	public static String VALUE_ATTR = "value";
	
	public static String DISPLAY_VALUE_ATTR = "displayValue";
	
	public static String DISPLAY_NAME_ATTR = "displayName";
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
	 * The default value of the '{@link #getSemantic() <em>Semantic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantic()
	 * @generated NOT
	 * @ordered
	 */
	protected static final AttributeSemantic SEMANTIC_EDEFAULT = AttributeSemantic.EQUAL;
	
	/**
	 * The cached value of the '{@link #getSemantic() <em>Semantic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantic()
	 * @generated NOT
	 * @ordered
	 */
	protected AttributeSemantic semantic = SEMANTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayValue() <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String DISPLAY_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayValue() <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayValue()
	 * @generated NOT
	 * @ordered
	 */
	protected String displayValue = DISPLAY_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Value() {
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
		translationState = newTranslationState == null ? TRANSLATION_STATE_EDEFAULT : newTranslationState;
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
	public AttributeSemantic getSemantic() {
		return semantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSemantic(AttributeSemantic newSemantic) {
		this.semantic = newSemantic == null ? SEMANTIC_EDEFAULT : newSemantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDisplayValue(String newDisplayValue) {
		this.displayValue = newDisplayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getString() {
		return getValue() != null ? getValue().toString() : null;
	}
	
	public T getValue() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	
	public void copyFrom(org.soluvas.data.Value<?> upValue) {
		setDisplayValue(upValue.getDisplayValue());
		setLanguage(upValue.getLanguage());
		setOriginalLanguage(upValue.getOriginalLanguage());
		setSemantic(upValue.getSemantic());
		setTranslationState(upValue.getTranslationState());
		getTranslations().putAll(Maps.transformValues(upValue.getTranslations().map(), new Function<org.soluvas.commons.Translation, Map<String, String>>() {
			@Override
			public Map<String, String> apply(org.soluvas.commons.Translation input) {
				final Map<String, String> upTranslation = new HashMap<>();
				upTranslation.putAll(input.getMessages().map());
				return upTranslation;
			}
		}));
	}
	
	public org.soluvas.data.Value<?> castToEmf() {
		final org.soluvas.data.Value<?> emfValue;
		if (this instanceof org.soluvas.data.entity.CurrencyValue) {
			final org.soluvas.data.CurrencyValue upCurrencyValue = new CurrencyValueImpl();
			fillDefaultValue(upCurrencyValue);
			
			upCurrencyValue.setCurrencyUnit(((org.soluvas.data.entity.CurrencyValue) this).getCurrencyUnit());
			
			emfValue = upCurrencyValue;
		} else if (this instanceof org.soluvas.data.entity.MeasureValue) {
			final org.soluvas.data.MeasureValue upMeasureValue = new MeasureValueImpl();
			fillDefaultValue(upMeasureValue);
			
			upMeasureValue.setValue(((org.soluvas.data.entity.MeasureValue) this).getValue());
			upMeasureValue.setValueUnit(((org.soluvas.data.entity.MeasureValue) this).getValueUnit());

			emfValue = upMeasureValue;
		} else if (this instanceof org.soluvas.data.entity.RangeValue) {
			final org.soluvas.data.RangeValue upRangeValue = new RangeValueImpl();
			fillDefaultValue(upRangeValue);
			
			upRangeValue.setStartValue(((org.soluvas.data.entity.RangeValue<T>) this).getStartValue());
			upRangeValue.setEndValue(((org.soluvas.data.entity.RangeValue<T>) this).getEndValue());
			
			emfValue = upRangeValue;
		} else if (this instanceof org.soluvas.data.entity.StringValue) {
			final org.soluvas.data.StringValue upStringValue = new StringValueImpl();
			fillDefaultValue(upStringValue);
			
			upStringValue.setValue(((org.soluvas.data.entity.StringValue)this).getValue());
			
			emfValue = upStringValue;
		} else if (this instanceof org.soluvas.data.entity.TermValue) {
			final org.soluvas.data.TermValue upTermValue = new TermValueImpl();
			fillDefaultValue(upTermValue);
			
			upTermValue.setContent(((org.soluvas.data.entity.TermValue) this).getContent());
			upTermValue.setId(((org.soluvas.data.entity.TermValue) this).getId());
			upTermValue.setPrimaryUri(((org.soluvas.data.entity.TermValue) this).getPrimaryUri());
			upTermValue.setSlug(((org.soluvas.data.entity.TermValue) this).getSlug());
			upTermValue.setSlugPath(((org.soluvas.data.entity.TermValue) this).getSlugPath());
			upTermValue.setValue(((org.soluvas.data.entity.TermValue) this).getValue());
			
			emfValue = upTermValue;
		} else {
			throw new DataException(String.format("Unsupported for value '%s'", this.getClass().getName()));
		}
		
		return emfValue;
	}
	
	private void fillDefaultValue(org.soluvas.data.Value<?> emfValue) {
		emfValue.setDisplayValue( getDisplayValue() );
		emfValue.setLanguage( getLanguage() );
		emfValue.setOriginalLanguage( getOriginalLanguage() );
		emfValue.setSemantic( getSemantic() );
		emfValue.getTranslations().putAll( Maps.transformValues(getTranslations(), new Function<Map<String, String>, org.soluvas.commons.Translation>() {
			@Override
			public org.soluvas.commons.Translation apply(Map<String, String> input) {
				return new TranslationImpl(getLanguage(), input);
			}
		}) );
		emfValue.setTranslationState( getTranslationState() );
	}
	
} //ValueImpl
