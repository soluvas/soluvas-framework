/**
 */
package org.soluvas.newsletter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.newsletter.NewsletterFactory
 * @model kind="package"
 * @generated
 */
public interface NewsletterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "newsletter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/newsletter/1.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "newsletter";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NewsletterPackage eINSTANCE = org.soluvas.newsletter.impl.NewsletterPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.newsletter.impl.MailjetManagerImpl <em>Mailjet Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.newsletter.impl.MailjetManagerImpl
	 * @see org.soluvas.newsletter.impl.NewsletterPackageImpl#getMailjetManager()
	 * @generated
	 */
	int MAILJET_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__API_KEY = 0;

	/**
	 * The feature id for the '<em><b>Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__SECRET_KEY = 1;

	/**
	 * The feature id for the '<em><b>List Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__LIST_ID = 2;

	/**
	 * The number of structural features of the '<em>Mailjet Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.soluvas.newsletter.MailjetManager <em>Mailjet Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mailjet Manager</em>'.
	 * @see org.soluvas.newsletter.MailjetManager
	 * @generated
	 */
	EClass getMailjetManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetManager#getApiKey <em>Api Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Key</em>'.
	 * @see org.soluvas.newsletter.MailjetManager#getApiKey()
	 * @see #getMailjetManager()
	 * @generated
	 */
	EAttribute getMailjetManager_ApiKey();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetManager#getSecretKey <em>Secret Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secret Key</em>'.
	 * @see org.soluvas.newsletter.MailjetManager#getSecretKey()
	 * @see #getMailjetManager()
	 * @generated
	 */
	EAttribute getMailjetManager_SecretKey();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetManager#getListId <em>List Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List Id</em>'.
	 * @see org.soluvas.newsletter.MailjetManager#getListId()
	 * @see #getMailjetManager()
	 * @generated
	 */
	EAttribute getMailjetManager_ListId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NewsletterFactory getNewsletterFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.newsletter.impl.MailjetManagerImpl <em>Mailjet Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.newsletter.impl.MailjetManagerImpl
		 * @see org.soluvas.newsletter.impl.NewsletterPackageImpl#getMailjetManager()
		 * @generated
		 */
		EClass MAILJET_MANAGER = eINSTANCE.getMailjetManager();

		/**
		 * The meta object literal for the '<em><b>Api Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_MANAGER__API_KEY = eINSTANCE.getMailjetManager_ApiKey();

		/**
		 * The meta object literal for the '<em><b>Secret Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_MANAGER__SECRET_KEY = eINSTANCE.getMailjetManager_SecretKey();

		/**
		 * The meta object literal for the '<em><b>List Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_MANAGER__LIST_ID = eINSTANCE.getMailjetManager_ListId();

	}

} //NewsletterPackage
