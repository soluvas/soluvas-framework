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
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__API_KEY = 1;

	/**
	 * The feature id for the '<em><b>Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__SECRET_KEY = 2;

	/**
	 * The feature id for the '<em><b>List Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER__LIST_ID = 3;

	/**
	 * The number of structural features of the '<em>Mailjet Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_MANAGER_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.soluvas.newsletter.MailjetSysConfig <em>Mailjet Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.newsletter.MailjetSysConfig
	 * @see org.soluvas.newsletter.impl.NewsletterPackageImpl#getMailjetSysConfig()
	 * @generated
	 */
	int MAILJET_SYS_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Mailjet Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_SYS_CONFIG__MAILJET_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Mailjet Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_SYS_CONFIG__MAILJET_API_KEY = 1;

	/**
	 * The feature id for the '<em><b>Mailjet Secret Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_SYS_CONFIG__MAILJET_SECRET_KEY = 2;

	/**
	 * The feature id for the '<em><b>Mailjet List Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_SYS_CONFIG__MAILJET_LIST_ID = 3;

	/**
	 * The number of structural features of the '<em>Mailjet Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAILJET_SYS_CONFIG_FEATURE_COUNT = 4;


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
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetManager#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.soluvas.newsletter.MailjetManager#isEnabled()
	 * @see #getMailjetManager()
	 * @generated
	 */
	EAttribute getMailjetManager_Enabled();

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
	 * Returns the meta object for class '{@link org.soluvas.newsletter.MailjetSysConfig <em>Mailjet Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mailjet Sys Config</em>'.
	 * @see org.soluvas.newsletter.MailjetSysConfig
	 * @generated
	 */
	EClass getMailjetSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetEnabled <em>Mailjet Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailjet Enabled</em>'.
	 * @see org.soluvas.newsletter.MailjetSysConfig#getMailjetEnabled()
	 * @see #getMailjetSysConfig()
	 * @generated
	 */
	EAttribute getMailjetSysConfig_MailjetEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetApiKey <em>Mailjet Api Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailjet Api Key</em>'.
	 * @see org.soluvas.newsletter.MailjetSysConfig#getMailjetApiKey()
	 * @see #getMailjetSysConfig()
	 * @generated
	 */
	EAttribute getMailjetSysConfig_MailjetApiKey();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetSecretKey <em>Mailjet Secret Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailjet Secret Key</em>'.
	 * @see org.soluvas.newsletter.MailjetSysConfig#getMailjetSecretKey()
	 * @see #getMailjetSysConfig()
	 * @generated
	 */
	EAttribute getMailjetSysConfig_MailjetSecretKey();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.newsletter.MailjetSysConfig#getMailjetListId <em>Mailjet List Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailjet List Id</em>'.
	 * @see org.soluvas.newsletter.MailjetSysConfig#getMailjetListId()
	 * @see #getMailjetSysConfig()
	 * @generated
	 */
	EAttribute getMailjetSysConfig_MailjetListId();

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
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_MANAGER__ENABLED = eINSTANCE.getMailjetManager_Enabled();

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

		/**
		 * The meta object literal for the '{@link org.soluvas.newsletter.MailjetSysConfig <em>Mailjet Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.newsletter.MailjetSysConfig
		 * @see org.soluvas.newsletter.impl.NewsletterPackageImpl#getMailjetSysConfig()
		 * @generated
		 */
		EClass MAILJET_SYS_CONFIG = eINSTANCE.getMailjetSysConfig();

		/**
		 * The meta object literal for the '<em><b>Mailjet Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_SYS_CONFIG__MAILJET_ENABLED = eINSTANCE.getMailjetSysConfig_MailjetEnabled();

		/**
		 * The meta object literal for the '<em><b>Mailjet Api Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_SYS_CONFIG__MAILJET_API_KEY = eINSTANCE.getMailjetSysConfig_MailjetApiKey();

		/**
		 * The meta object literal for the '<em><b>Mailjet Secret Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_SYS_CONFIG__MAILJET_SECRET_KEY = eINSTANCE.getMailjetSysConfig_MailjetSecretKey();

		/**
		 * The meta object literal for the '<em><b>Mailjet List Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAILJET_SYS_CONFIG__MAILJET_LIST_ID = eINSTANCE.getMailjetSysConfig_MailjetListId();

	}

} //NewsletterPackage
