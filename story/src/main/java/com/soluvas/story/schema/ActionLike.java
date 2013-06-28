/**
 */
package com.soluvas.story.schema;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getTenses <em>Tenses</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getPastTense <em>Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getPluralPastTense <em>Plural Past Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getPresentTense <em>Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getPluralPresentTense <em>Plural Present Tense</em>}</li>
 *   <li>{@link com.soluvas.story.schema.ActionLike#getImperativeTense <em>Imperative Tense</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.schema.SchemaPackage#getActionLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ActionLike extends EObject {
	/**
	 * Returns the value of the '<em><b>Tenses</b></em>' attribute.
	 * The literals are from the enumeration {@link com.soluvas.story.schema.Tenses}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Allows you to select the tenses that will be used in News Feed stories. For example, you may wish to always display stories in present tense, in which case you would select the ''only the present tense'' option.
	 * 
	 * <p>Reference: http://developers.facebook.com/docs/technical-guides/opengraph/defining-an-action-type/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tenses</em>' attribute.
	 * @see com.soluvas.story.schema.Tenses
	 * @see #setTenses(Tenses)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_Tenses()
	 * @model required="true"
	 * @generated
	 */
	Tenses getTenses();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getTenses <em>Tenses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tenses</em>' attribute.
	 * @see com.soluvas.story.schema.Tenses
	 * @see #getTenses()
	 * @generated
	 */
	void setTenses(Tenses value);

	/**
	 * Returns the value of the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Past Tense field is pre-filled with an initial past tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.
	 * 
	 * e.g. cooked
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Past Tense</em>' attribute.
	 * @see #setPastTense(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_PastTense()
	 * @model
	 * @generated
	 */
	String getPastTense();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getPastTense <em>Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Past Tense</em>' attribute.
	 * @see #getPastTense()
	 * @generated
	 */
	void setPastTense(String value);

	/**
	 * Returns the value of the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Plural Past Tense field is pre-filled with an initial past tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the 'Sentence Previews` box.
	 * 
	 * e.g. cooked
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plural Past Tense</em>' attribute.
	 * @see #setPluralPastTense(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_PluralPastTense()
	 * @model
	 * @generated
	 */
	String getPluralPastTense();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getPluralPastTense <em>Plural Past Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plural Past Tense</em>' attribute.
	 * @see #getPluralPastTense()
	 * @generated
	 */
	void setPluralPastTense(String value);

	/**
	 * Returns the value of the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Present Tense field is pre-filled with an initial present tense action corresponding to your initial action type. You can edit this field. You can also edit the preposition that defines how the News Feed story is displayed. You can preview the various sentences that may be generated using the Sentence Previews box.
	 * 
	 * e.g. cook
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Present Tense</em>' attribute.
	 * @see #setPresentTense(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_PresentTense()
	 * @model required="true"
	 * @generated
	 */
	String getPresentTense();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getPresentTense <em>Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Present Tense</em>' attribute.
	 * @see #getPresentTense()
	 * @generated
	 */
	void setPresentTense(String value);

	/**
	 * Returns the value of the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Plural Present Tense field is pre-filled with an initial present tense action corresponding to your initial action when more than one friend is involved. Similar to the Past Tense field, you can make changes and preview them using the Sentence Previews box.
	 * 
	 * e.g. are cooking
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plural Present Tense</em>' attribute.
	 * @see #setPluralPresentTense(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_PluralPresentTense()
	 * @model required="true"
	 * @generated
	 */
	String getPluralPresentTense();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getPluralPresentTense <em>Plural Present Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plural Present Tense</em>' attribute.
	 * @see #getPluralPresentTense()
	 * @generated
	 */
	void setPluralPresentTense(String value);

	/**
	 * Returns the value of the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Imperative Tense field is pre-filled with an initial present tense action corresponding to your initial action type. This field controls the display for action links. You can edit this field. You can preview the various sentences that may be generated using the Sentence Previews box.
	 * 
	 * e.g. cook
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imperative Tense</em>' attribute.
	 * @see #setImperativeTense(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getActionLike_ImperativeTense()
	 * @model required="true"
	 * @generated
	 */
	String getImperativeTense();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.ActionLike#getImperativeTense <em>Imperative Tense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imperative Tense</em>' attribute.
	 * @see #getImperativeTense()
	 * @generated
	 */
	void setImperativeTense(String value);

} // ActionLike
