/**
 */
package org.soluvas.data;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.Term#getVocab <em>Vocab</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends TermContainer, BundleAware, NameContainer, ResourceAware {
	/**
	 * Returns the value of the '<em><b>Vocab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vocab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vocab</em>' reference.
	 * @see #setVocab(Vocab)
	 * @see org.soluvas.data.DataPackage#getTerm_Vocab()
	 * @model
	 * @generated
	 */
	Vocab getVocab();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getVocab <em>Vocab</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vocab</em>' reference.
	 * @see #getVocab()
	 * @generated
	 */
	void setVocab(Vocab value);

} // Term
