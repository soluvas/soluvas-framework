/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translation Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.commons.CommonsPackage#getTranslationManager()
 * @model
 * @generated
 */
public interface TranslationManager extends EObject {
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
