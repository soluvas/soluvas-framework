/**
 */
package org.soluvas.email;

import java.util.List;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.email.EmailPackage#getEmailManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface EmailManager extends SerializableEObject {
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

} // EmailManager
