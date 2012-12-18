/**
 */
package org.soluvas.data;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Use a taxonomy term.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.TermAttribute#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTermAttribute()
 * @model superTypes="org.soluvas.data.Value<org.eclipse.emf.ecore.EString>"
 * @generated
 */
public interface TermAttribute extends Value<String> {
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
	 * @see org.soluvas.data.DataPackage#getTermAttribute_Term()
	 * @model
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link org.soluvas.data.TermAttribute#getTerm <em>Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // TermAttribute
