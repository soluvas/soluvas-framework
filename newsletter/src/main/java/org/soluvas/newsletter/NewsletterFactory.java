/**
 */
package org.soluvas.newsletter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.newsletter.NewsletterPackage
 * @generated
 */
public interface NewsletterFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NewsletterFactory eINSTANCE = org.soluvas.newsletter.impl.NewsletterFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mailjet Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mailjet Manager</em>'.
	 * @generated
	 */
	MailjetManager createMailjetManager();

	/**
	 * Returns a new object of class '<em>Mailjet Credential</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mailjet Credential</em>'.
	 * @generated
	 */
	MailjetCredential createMailjetCredential();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NewsletterPackage getNewsletterPackage();

} //NewsletterFactory
