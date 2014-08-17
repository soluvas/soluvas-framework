/**
 */
package org.soluvas.email;

import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.apache.commons.mail.Email;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.email.impl.EmailTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.EmailManager#getSmtpUser <em>Smtp User</em>}</li>
 *   <li>{@link org.soluvas.email.EmailManager#getSmtpPassword <em>Smtp Password</em>}</li>
 *   <li>{@link org.soluvas.email.EmailManager#getSmtpHost <em>Smtp Host</em>}</li>
 *   <li>{@link org.soluvas.email.EmailManager#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.soluvas.email.EmailManager#getSmtpSecurity <em>Smtp Security</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getEmailManager()
 * @model
 * @generated
 */
public interface EmailManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Smtp User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp User</em>' attribute.
	 * @see org.soluvas.email.EmailPackage#getEmailManager_SmtpUser()
	 * @model changeable="false"
	 *        extendedMetaData="name='smtpSecurity'"
	 * @generated
	 */
	String getSmtpUser();

	/**
	 * Returns the value of the '<em><b>Smtp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Password</em>' attribute.
	 * @see org.soluvas.email.EmailPackage#getEmailManager_SmtpPassword()
	 * @model changeable="false"
	 *        extendedMetaData="name='smtpSecurity'"
	 * @generated
	 */
	String getSmtpPassword();

	/**
	 * Returns the value of the '<em><b>Smtp Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Host</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Host</em>' attribute.
	 * @see org.soluvas.email.EmailPackage#getEmailManager_SmtpHost()
	 * @model changeable="false"
	 *        extendedMetaData="name='smtpSecurity'"
	 * @generated
	 */
	String getSmtpHost();

	/**
	 * Returns the value of the '<em><b>Smtp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Port</em>' attribute.
	 * @see org.soluvas.email.EmailPackage#getEmailManager_SmtpPort()
	 * @model changeable="false"
	 *        extendedMetaData="name='smtpSecurity'"
	 * @generated
	 */
	Integer getSmtpPort();

	/**
	 * Returns the value of the '<em><b>Smtp Security</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.email.EmailSecurity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Security</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Security</em>' attribute.
	 * @see org.soluvas.email.EmailSecurity
	 * @see org.soluvas.email.EmailPackage#getEmailManager_SmtpSecurity()
	 * @model changeable="false"
	 * @generated
	 */
	EmailSecurity getSmtpSecurity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create an email Page using the tenant-wide default layout.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	<T extends Page> T createPage(Class<T> pageClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Sender createSender(String qname);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compose the page to all recipients, then sends all of them. Returns the list of Email IDs returned by mailer.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.List<org.eclipse.emf.ecore.EString>" many="false"
	 * @generated
	 */
	List<String> sendAll(Page page);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compose the page to all recipients, then sends all of them with custom MailSession. Returns the list of Email IDs returned by mailer.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.commons.List<org.eclipse.emf.ecore.EString>" many="false" mailSessionDataType="org.soluvas.email.MailSession"
	 * @generated
	 */
	List<String> sendAll(Page page, Session mailSession);

	<T> EmailTemplate<T> loadTemplate(Class<T> modelClass);

	<T> Email compose(EmailTemplate<T> template, T model, Recipient recipient);

	<T> Map<Recipient, Email> compose(EmailTemplate<T> template, T model,
			List<Recipient> recipients);

	<T> SendResult send(EmailTemplate<T> template, T model, Recipient recipient);

	<T> Map<Recipient, SendResult> send(EmailTemplate<T> template, T model,
			List<Recipient> recipients);

} // EmailManager
