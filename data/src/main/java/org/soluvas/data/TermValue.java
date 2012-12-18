/**
 */
package org.soluvas.data;

import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Sluggable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Use a taxonomy term. 'value' is the ID of the term.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.TermValue#getTerm <em>Term</em>}</li>
 *   <li>{@link org.soluvas.data.TermValue#getSlugPath <em>Slug Path</em>}</li>
 *   <li>{@link org.soluvas.data.TermValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTermValue()
 * @model superTypes="org.soluvas.data.Value<org.eclipse.emf.ecore.EString> org.soluvas.commons.Identifiable org.soluvas.commons.Sluggable"
 * @generated
 */
public interface TermValue extends Value<String>, Identifiable, Sluggable {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' reference.
	 * @see #setTerm(Term)
	 * @see org.soluvas.data.DataPackage#getTermValue_Term()
	 * @model
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link org.soluvas.data.TermValue#getTerm <em>Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

	/**
	 * Returns the value of the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * '/'-separated slug path.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slug Path</em>' attribute.
	 * @see #setSlugPath(String)
	 * @see org.soluvas.data.DataPackage#getTermValue_SlugPath()
	 * @model
	 * @generated
	 */
	String getSlugPath();

	/**
	 * Sets the value of the '{@link org.soluvas.data.TermValue#getSlugPath <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slug Path</em>' attribute.
	 * @see #getSlugPath()
	 * @generated
	 */
	void setSlugPath(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.soluvas.data.DataPackage#getTermValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.TermValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // TermValue
