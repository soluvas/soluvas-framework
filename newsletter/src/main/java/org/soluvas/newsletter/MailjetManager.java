/**
 */
package org.soluvas.newsletter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.newsletter.MailjetManager#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetManager#getApiKey <em>Api Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetManager#getSecretKey <em>Secret Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.MailjetManager#getListId <em>List Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetManager()
 * @model
 * @generated
 */
public interface MailjetManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetManager_Enabled()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Returns the value of the '<em><b>Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet API Key.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Api Key</em>' attribute.
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetManager_ApiKey()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	String getApiKey();

	/**
	 * Returns the value of the '<em><b>Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secret Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet Secret Key.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secret Key</em>' attribute.
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetManager_SecretKey()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	String getSecretKey();

	/**
	 * Returns the value of the '<em><b>List Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Mailjet List ID.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>List Id</em>' attribute.
	 * @see org.soluvas.newsletter.NewsletterPackage#getMailjetManager_ListId()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	Long getListId();

} // MailjetManager
