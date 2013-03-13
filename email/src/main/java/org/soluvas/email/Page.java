/**
 */
package org.soluvas.email;

import java.util.List;
import javax.mail.Session;
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
 *   <li>{@link org.soluvas.email.Page#getPageType <em>Page Type</em>}</li>
 *   <li>{@link org.soluvas.email.Page#getSender <em>Sender</em>}</li>
 *   <li>{@link org.soluvas.email.Page#getMailSession <em>Mail Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getPage()
 * @model abstract="true"
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
	 * Returns the value of the '<em><b>Page Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Type</em>' reference.
	 * @see #setPageType(PageType)
	 * @see org.soluvas.email.EmailPackage#getPage_PageType()
	 * @model required="true"
	 * @generated
	 */
	PageType getPageType();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Page#getPageType <em>Page Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Type</em>' reference.
	 * @see #getPageType()
	 * @generated
	 */
	void setPageType(PageType value);

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(Sender)
	 * @see org.soluvas.email.EmailPackage#getPage_Sender()
	 * @model required="true"
	 * @generated
	 */
	Sender getSender();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Page#getSender <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(Sender value);

	/**
	 * Returns the value of the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mail Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mail Session</em>' attribute.
	 * @see #setMailSession(Session)
	 * @see org.soluvas.email.EmailPackage#getPage_MailSession()
	 * @model dataType="org.soluvas.email.MailSession" required="true" transient="true"
	 * @generated
	 */
	Session getMailSession();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Page#getMailSession <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail Session</em>' attribute.
	 * @see #getMailSession()
	 * @generated
	 */
	void setMailSession(Session value);

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
	 * @model dataType="org.soluvas.commons.List<org.soluvas.email.Email>" required="true" many="false"
	 * @generated
	 */
	List<Email> composeAll();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void attach(byte[] content, String fileName);

} // Page
