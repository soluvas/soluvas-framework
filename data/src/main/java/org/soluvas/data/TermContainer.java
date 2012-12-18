/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.TermContainer#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTermContainer()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface TermContainer extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.data.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of terms in a Vocabulary or if the Term is nested (tree vocabulary).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Terms</em>' reference list.
	 * @see org.soluvas.data.DataPackage#getTermContainer_Terms()
	 * @model
	 * @generated
	 */
	EList<Term> getTerms();

} // TermContainer
