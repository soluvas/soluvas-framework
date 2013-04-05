/**
 */
package email;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see email.EmailPackage
 * @generated
 */
public interface EmailFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailFactory eINSTANCE = email.impl.EmailFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catalog</em>'.
	 * @generated
	 */
	EmailCatalog createEmailCatalog();

	/**
	 * Returns a new object of class '<em>Page Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Type</em>'.
	 * @generated
	 */
	PageType createPageType();

	/**
	 * Returns a new object of class '<em>Layout Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout Type</em>'.
	 * @generated
	 */
	LayoutType createLayoutType();

	/**
	 * Returns a new object of class '<em>Recipient</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient</em>'.
	 * @generated
	 */
	Recipient createRecipient();

	/**
	 * Returns a new object of class '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	EmailManager createEmailManager();

	/**
	 * Returns a new object of class '<em>Sender</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sender</em>'.
	 * @generated
	 */
	Sender createSender();

	/**
	 * Returns a new object of class '<em>Sender Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sender Type</em>'.
	 * @generated
	 */
	SenderType createSenderType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmailPackage getEmailPackage();

} //EmailFactory
