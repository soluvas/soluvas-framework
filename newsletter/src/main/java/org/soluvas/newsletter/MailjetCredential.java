/**
 */
package org.soluvas.newsletter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mailjet Credential</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.newsletter.MailjetCredential#getApiKey <em>Api Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetCredential#getSecretKey <em>Secret Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetCredential#getDefaultContactID <em>Default Contact ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetCredential()
 * @model
 * @generated
 */
public interface MailjetCredential extends EObject {
	/**
	 * Returns the value of the '<em><b>Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Key</em>' attribute.
	 * @see #setApiKey(String)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetCredential_ApiKey()
	 * @model
	 * @generated
	 */
	String getApiKey();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetCredential#getApiKey <em>Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Key</em>' attribute.
	 * @see #getApiKey()
	 * @generated
	 */
	void setApiKey(String value);

	/**
	 * Returns the value of the '<em><b>Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secret Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secret Key</em>' attribute.
	 * @see #setSecretKey(String)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetCredential_SecretKey()
	 * @model
	 * @generated
	 */
	String getSecretKey();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetCredential#getSecretKey <em>Secret Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secret Key</em>' attribute.
	 * @see #getSecretKey()
	 * @generated
	 */
	void setSecretKey(String value);

	/**
	 * Returns the value of the '<em><b>Default Contact ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Contact ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Contact ID</em>' attribute.
	 * @see #setDefaultContactID(String)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetCredential_DefaultContactID()
	 * @model
	 * @generated
	 */
	String getDefaultContactID();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetCredential#getDefaultContactID <em>Default Contact ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Contact ID</em>' attribute.
	 * @see #getDefaultContactID()
	 * @generated
	 */
	void setDefaultContactID(String value);

} // MailjetCredential
