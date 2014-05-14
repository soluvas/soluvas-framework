/**
 */
package org.soluvas.newsletter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mailjet Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetEnabled <em>Mailjet Enabled</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetApiKey <em>Mailjet Api Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetSecretKey <em>Mailjet Secret Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetListId <em>Mailjet List Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MailjetSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Mailjet Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailjet Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailjet Enabled</em>' attribute.
	 * @see #setMailjetEnabled(Boolean)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetSysConfig_MailjetEnabled()
	 * @model required="true"
	 * @generated
	 */
	Boolean getMailjetEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetEnabled <em>Mailjet Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailjet Enabled</em>' attribute.
	 * @see #getMailjetEnabled()
	 * @generated
	 */
	void setMailjetEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Mailjet Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet API Key.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mailjet Api Key</em>' attribute.
	 * @see #setMailjetApiKey(String)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetSysConfig_MailjetApiKey()
	 * @model required="true"
	 * @generated
	 */
	String getMailjetApiKey();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetApiKey <em>Mailjet Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailjet Api Key</em>' attribute.
	 * @see #getMailjetApiKey()
	 * @generated
	 */
	void setMailjetApiKey(String value);

	/**
	 * Returns the value of the '<em><b>Mailjet Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet Secret Key.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mailjet Secret Key</em>' attribute.
	 * @see #setMailjetSecretKey(String)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetSysConfig_MailjetSecretKey()
	 * @model required="true"
	 * @generated
	 */
	String getMailjetSecretKey();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetSecretKey <em>Mailjet Secret Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailjet Secret Key</em>' attribute.
	 * @see #getMailjetSecretKey()
	 * @generated
	 */
	void setMailjetSecretKey(String value);

	/**
	 * Returns the value of the '<em><b>Mailjet List Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet List ID. To get it, use this command:
	 * 
	 * <pre>
	 * curl  --user $API_KEY:$SECRET_KEY api.mailjet.com/0.1/listsAll | xmllint --format -
	 * </pre>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mailjet List Id</em>' attribute.
	 * @see #setMailjetListId(Long)
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetSysConfig_MailjetListId()
	 * @model required="true"
	 * @generated
	 */
	Long getMailjetListId();

	/**
	 * Sets the value of the '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetListId <em>Mailjet List Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailjet List Id</em>' attribute.
	 * @see #getMailjetListId()
	 * @generated
	 */
	void setMailjetListId(Long value);

} // MailjetSysConfig
