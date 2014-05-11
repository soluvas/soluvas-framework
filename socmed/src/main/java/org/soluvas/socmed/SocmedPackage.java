/**
 */
package org.soluvas.socmed;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.socmed.SocmedFactory
 * @model kind="package"
 * @generated
 */
public interface SocmedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "socmed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/socmed/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "socmed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SocmedPackage eINSTANCE = org.soluvas.socmed.impl.SocmedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.socmed.FacebookSysConfig <em>Facebook Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.socmed.FacebookSysConfig
	 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getFacebookSysConfig()
	 * @generated
	 */
	int FACEBOOK_SYS_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Facebook App Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_APP_ID = 0;

	/**
	 * The feature id for the '<em><b>Facebook App Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_APP_SECRET = 1;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_ACCESS_TOKEN = 2;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Page Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_ID = 3;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Publish Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PUBLISH_ENABLED = 4;

	/**
	 * The feature id for the '<em><b>Facebook Explicitly Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_EXPLICITLY_SHARED = 5;

	/**
	 * The number of structural features of the '<em>Facebook Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Facebook Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.socmed.TwitterSysConfig <em>Twitter Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.socmed.TwitterSysConfig
	 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getTwitterSysConfig()
	 * @generated
	 */
	int TWITTER_SYS_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Twitter Consumer Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG__TWITTER_CONSUMER_KEY = 0;

	/**
	 * The feature id for the '<em><b>Twitter Consumer Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG__TWITTER_CONSUMER_SECRET = 1;

	/**
	 * The feature id for the '<em><b>Twitter Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG__TWITTER_TENANT_SCREEN_NAME = 2;

	/**
	 * The feature id for the '<em><b>Twitter Tenant Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN = 3;

	/**
	 * The feature id for the '<em><b>Twitter Tenant Access Token Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN_SECRET = 4;

	/**
	 * The number of structural features of the '<em>Twitter Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Twitter Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWITTER_SYS_CONFIG_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.soluvas.socmed.FacebookSysConfig <em>Facebook Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facebook Sys Config</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig
	 * @generated
	 */
	EClass getFacebookSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppId <em>Facebook App Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook App Id</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookAppId()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookAppId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppSecret <em>Facebook App Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook App Secret</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookAppSecret()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookAppSecret();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantAccessToken <em>Facebook Tenant Access Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Tenant Access Token</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookTenantAccessToken()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookTenantAccessToken();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageId <em>Facebook Tenant Page Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Tenant Page Id</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageId()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookTenantPageId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPublishEnabled <em>Facebook Tenant Publish Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Tenant Publish Enabled</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPublishEnabled()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookTenantPublishEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookExplicitlyShared <em>Facebook Explicitly Shared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Explicitly Shared</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookExplicitlyShared()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookExplicitlyShared();

	/**
	 * Returns the meta object for class '{@link org.soluvas.socmed.TwitterSysConfig <em>Twitter Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Twitter Sys Config</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig
	 * @generated
	 */
	EClass getTwitterSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerKey <em>Twitter Consumer Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Consumer Key</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerKey()
	 * @see #getTwitterSysConfig()
	 * @generated
	 */
	EAttribute getTwitterSysConfig_TwitterConsumerKey();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerSecret <em>Twitter Consumer Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Consumer Secret</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerSecret()
	 * @see #getTwitterSysConfig()
	 * @generated
	 */
	EAttribute getTwitterSysConfig_TwitterConsumerSecret();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantScreenName <em>Twitter Tenant Screen Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Tenant Screen Name</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig#getTwitterTenantScreenName()
	 * @see #getTwitterSysConfig()
	 * @generated
	 */
	EAttribute getTwitterSysConfig_TwitterTenantScreenName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessToken <em>Twitter Tenant Access Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Tenant Access Token</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessToken()
	 * @see #getTwitterSysConfig()
	 * @generated
	 */
	EAttribute getTwitterSysConfig_TwitterTenantAccessToken();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessTokenSecret <em>Twitter Tenant Access Token Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Tenant Access Token Secret</em>'.
	 * @see org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessTokenSecret()
	 * @see #getTwitterSysConfig()
	 * @generated
	 */
	EAttribute getTwitterSysConfig_TwitterTenantAccessTokenSecret();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SocmedFactory getSocmedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.socmed.FacebookSysConfig <em>Facebook Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.socmed.FacebookSysConfig
		 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getFacebookSysConfig()
		 * @generated
		 */
		EClass FACEBOOK_SYS_CONFIG = eINSTANCE.getFacebookSysConfig();

		/**
		 * The meta object literal for the '<em><b>Facebook App Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_APP_ID = eINSTANCE.getFacebookSysConfig_FacebookAppId();

		/**
		 * The meta object literal for the '<em><b>Facebook App Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_APP_SECRET = eINSTANCE.getFacebookSysConfig_FacebookAppSecret();

		/**
		 * The meta object literal for the '<em><b>Facebook Tenant Access Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_ACCESS_TOKEN = eINSTANCE.getFacebookSysConfig_FacebookTenantAccessToken();

		/**
		 * The meta object literal for the '<em><b>Facebook Tenant Page Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_ID = eINSTANCE.getFacebookSysConfig_FacebookTenantPageId();

		/**
		 * The meta object literal for the '<em><b>Facebook Tenant Publish Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PUBLISH_ENABLED = eINSTANCE.getFacebookSysConfig_FacebookTenantPublishEnabled();

		/**
		 * The meta object literal for the '<em><b>Facebook Explicitly Shared</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_EXPLICITLY_SHARED = eINSTANCE.getFacebookSysConfig_FacebookExplicitlyShared();

		/**
		 * The meta object literal for the '{@link org.soluvas.socmed.TwitterSysConfig <em>Twitter Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.socmed.TwitterSysConfig
		 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getTwitterSysConfig()
		 * @generated
		 */
		EClass TWITTER_SYS_CONFIG = eINSTANCE.getTwitterSysConfig();

		/**
		 * The meta object literal for the '<em><b>Twitter Consumer Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWITTER_SYS_CONFIG__TWITTER_CONSUMER_KEY = eINSTANCE.getTwitterSysConfig_TwitterConsumerKey();

		/**
		 * The meta object literal for the '<em><b>Twitter Consumer Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWITTER_SYS_CONFIG__TWITTER_CONSUMER_SECRET = eINSTANCE.getTwitterSysConfig_TwitterConsumerSecret();

		/**
		 * The meta object literal for the '<em><b>Twitter Tenant Screen Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWITTER_SYS_CONFIG__TWITTER_TENANT_SCREEN_NAME = eINSTANCE.getTwitterSysConfig_TwitterTenantScreenName();

		/**
		 * The meta object literal for the '<em><b>Twitter Tenant Access Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN = eINSTANCE.getTwitterSysConfig_TwitterTenantAccessToken();

		/**
		 * The meta object literal for the '<em><b>Twitter Tenant Access Token Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWITTER_SYS_CONFIG__TWITTER_TENANT_ACCESS_TOKEN_SECRET = eINSTANCE.getTwitterSysConfig_TwitterTenantAccessTokenSecret();

	}

} //SocmedPackage
