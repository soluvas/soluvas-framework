/**
 */
package org.soluvas.email.builtin;

import org.soluvas.commons.SerializableEObject;
import email.Page;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feedback To Admin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Feedback message for site/app administrator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.builtin.FeedbackToAdmin#getContact <em>Contact</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.builtin.BuiltinPackage#getFeedbackToAdmin()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface FeedbackToAdmin extends SerializableEObject {

	/**
	 * Returns the value of the '<em><b>Contact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contact</em>' reference.
	 * @see #setContact(Contact)
	 * @see org.soluvas.email.builtin.BuiltinPackage#getFeedbackToAdmin_Contact()
	 * @model required="true"
	 * @generated
	 */
	Contact getContact();

	/**
	 * Sets the value of the '{@link org.soluvas.email.builtin.FeedbackToAdmin#getContact <em>Contact</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contact</em>' reference.
	 * @see #getContact()
	 * @generated
	 */
	void setContact(Contact value);
} // FeedbackToAdmin
