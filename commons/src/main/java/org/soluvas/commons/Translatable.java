/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translatable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Entity Translation
 * Multi-locale & multi-language support for entities/nodes/database objects
 * Allow entities (like Product) to have different description / price / custom attribute values (fabric, origin, technique, etc.) for each locale/language.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Translatable#getTranslationState <em>Translation State</em>}</li>
 *   <li>{@link org.soluvas.commons.Translatable#getOriginalLanguage <em>Original Language</em>}</li>
 *   <li>{@link org.soluvas.commons.Translatable#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.Translatable#getTranslations <em>Translations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getTranslatable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Translatable extends EObject {
	/**
	 * Returns the value of the '<em><b>Translation State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.TranslationState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translation State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translation State</em>' attribute.
	 * @see org.soluvas.commons.TranslationState
	 * @see #setTranslationState(TranslationState)
	 * @see org.soluvas.commons.CommonsPackage#getTranslatable_TranslationState()
	 * @model
	 * @generated
	 */
	TranslationState getTranslationState();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Translatable#getTranslationState <em>Translation State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translation State</em>' attribute.
	 * @see org.soluvas.commons.TranslationState
	 * @see #getTranslationState()
	 * @generated
	 */
	void setTranslationState(TranslationState value);

	/**
	 * Returns the value of the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The language of original values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original Language</em>' attribute.
	 * @see #setOriginalLanguage(String)
	 * @see org.soluvas.commons.CommonsPackage#getTranslatable_OriginalLanguage()
	 * @model
	 * @generated
	 */
	String getOriginalLanguage();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Translatable#getOriginalLanguage <em>Original Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Language</em>' attribute.
	 * @see #getOriginalLanguage()
	 * @generated
	 */
	void setOriginalLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Current language code (if translationState == translated) or same as originalLanguage.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.soluvas.commons.CommonsPackage#getTranslatable_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Translatable#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Translations</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.soluvas.commons.Translation},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EMap[ language: String, Translation ]
	 * Where Translation object contains language: String and the localized messages keyed by attribute QName.
	 * Example translations is as follows:
	 * 1. en
	 * 1. base_description : Very good style.
	 * 2. base_fabric : Super funky.
	 * 2. id
	 * 1. base_description : Sangat bagus untuk Anda.
	 * 2. base_fabric : Katun keren.
	 * 3. base_origin : Jakarta area.
	 * Country codes in language codes:
	 * en and en_US are identical and interchangeable.
	 * id and id_ID are identical and interchangeable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Translations</em>' map.
	 * @see org.soluvas.commons.CommonsPackage#getTranslatable_Translations()
	 * @model mapType="org.soluvas.commons.TranslationEntry<org.eclipse.emf.ecore.EString, org.soluvas.commons.Translation>"
	 * @generated
	 */
	EMap<String, Translation> getTranslations();

} // Translatable
