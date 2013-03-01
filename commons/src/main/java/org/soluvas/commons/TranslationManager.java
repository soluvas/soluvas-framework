/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.commons.CommonsPackage#getTranslationManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface TranslationManager extends SerializableEObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Processes available translations and sets language to the targetLanguage.
	 * Will throw Exception if it's not already in the targetLanguage and translationState is translated.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void translate(Translatable entity, String targetLanguage);

} // TranslationManager
