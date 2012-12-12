/**
 */
package org.soluvas.email;

import org.apache.commons.mail.Email;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.Page#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getPage()
 * @model
 * @generated
 */
public interface Page extends Template {
	/**
	 * Returns the value of the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' reference.
	 * @see #setLayout(Layout)
	 * @see org.soluvas.email.EmailPackage#getPage_Layout()
	 * @model
	 * @generated
	 */
	Layout getLayout();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Page#getLayout <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(Layout value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compose an Email to a recipient, using the provided layout.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.email.Email"
	 * @generated
	 */
	Email compose(Recipient recipient);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compose emails based on attributes, using the provided layout.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.email.Email"
	 * @generated
	 */
	EList<Email> composeAll();

} // Page
