/**
 */
package org.soluvas.data.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.impl.TranslationEntryImpl;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Value;

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
 * @generated
 */
@SuppressWarnings("serial")
public abstract class ValueImpl<T> extends EObjectImpl implements Value<T> {
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
	 * The default value of the '{@link #getSemantic() <em>Semantic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantic()
	 * @generated
	 * @ordered
	 */
	protected static final AttributeSemantic SEMANTIC_EDEFAULT = AttributeSemantic.EQUAL;

	/**
	 * The cached value of the '{@link #getSemantic() <em>Semantic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantic()
	 * @generated
	 * @ordered
	 */
	protected AttributeSemantic semantic = SEMANTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayValue() <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayValue() <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayValue()
	 * @generated
	 * @ordered
	 */
	protected String displayValue = DISPLAY_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueImpl() {
		super();
	}

//	public ValueImpl(T value) {
//		super();
//		setValue(value);
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.VALUE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VALUE__TRANSLATION_STATE, oldTranslationState, translationState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VALUE__ORIGINAL_LANGUAGE, oldOriginalLanguage, originalLanguage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VALUE__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Translation> getTranslations() {
		if (translations == null) {
			translations = new EcoreEMap<String,Translation>(CommonsPackage.Literals.TRANSLATION_ENTRY, TranslationEntryImpl.class, this, DataPackage.VALUE__TRANSLATIONS);
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
	public T getValue() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.VALUE__TRANSLATIONS:
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
	public AttributeSemantic getSemantic() {
		return semantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSemantic(AttributeSemantic newSemantic) {
		AttributeSemantic oldSemantic = semantic;
		semantic = newSemantic == null ? SEMANTIC_EDEFAULT : newSemantic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VALUE__SEMANTIC, oldSemantic, semantic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplayValue(String newDisplayValue) {
		String oldDisplayValue = displayValue;
		displayValue = newDisplayValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VALUE__DISPLAY_VALUE, oldDisplayValue, displayValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getString() {
		return getValue() != null ? getValue().toString() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.VALUE__TRANSLATION_STATE:
				return getTranslationState();
			case DataPackage.VALUE__ORIGINAL_LANGUAGE:
				return getOriginalLanguage();
			case DataPackage.VALUE__LANGUAGE:
				return getLanguage();
			case DataPackage.VALUE__TRANSLATIONS:
				if (coreType) return getTranslations();
				else return getTranslations().map();
			case DataPackage.VALUE__SEMANTIC:
				return getSemantic();
			case DataPackage.VALUE__DISPLAY_VALUE:
				return getDisplayValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.VALUE__TRANSLATION_STATE:
				setTranslationState((TranslationState)newValue);
				return;
			case DataPackage.VALUE__ORIGINAL_LANGUAGE:
				setOriginalLanguage((String)newValue);
				return;
			case DataPackage.VALUE__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case DataPackage.VALUE__TRANSLATIONS:
				((EStructuralFeature.Setting)getTranslations()).set(newValue);
				return;
			case DataPackage.VALUE__SEMANTIC:
				setSemantic((AttributeSemantic)newValue);
				return;
			case DataPackage.VALUE__DISPLAY_VALUE:
				setDisplayValue((String)newValue);
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
			case DataPackage.VALUE__TRANSLATION_STATE:
				setTranslationState(TRANSLATION_STATE_EDEFAULT);
				return;
			case DataPackage.VALUE__ORIGINAL_LANGUAGE:
				setOriginalLanguage(ORIGINAL_LANGUAGE_EDEFAULT);
				return;
			case DataPackage.VALUE__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case DataPackage.VALUE__TRANSLATIONS:
				getTranslations().clear();
				return;
			case DataPackage.VALUE__SEMANTIC:
				setSemantic(SEMANTIC_EDEFAULT);
				return;
			case DataPackage.VALUE__DISPLAY_VALUE:
				setDisplayValue(DISPLAY_VALUE_EDEFAULT);
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
			case DataPackage.VALUE__TRANSLATION_STATE:
				return translationState != TRANSLATION_STATE_EDEFAULT;
			case DataPackage.VALUE__ORIGINAL_LANGUAGE:
				return ORIGINAL_LANGUAGE_EDEFAULT == null ? originalLanguage != null : !ORIGINAL_LANGUAGE_EDEFAULT.equals(originalLanguage);
			case DataPackage.VALUE__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case DataPackage.VALUE__TRANSLATIONS:
				return translations != null && !translations.isEmpty();
			case DataPackage.VALUE__SEMANTIC:
				return semantic != SEMANTIC_EDEFAULT;
			case DataPackage.VALUE__DISPLAY_VALUE:
				return DISPLAY_VALUE_EDEFAULT == null ? displayValue != null : !DISPLAY_VALUE_EDEFAULT.equals(displayValue);
		}
		return super.eIsSet(featureID);
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
		if (!(obj instanceof ValueImpl)) {
			return false;
		}
		ValueImpl other = (ValueImpl) obj;
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
