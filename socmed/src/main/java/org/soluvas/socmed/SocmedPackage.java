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
	 * The feature id for the '<em><b>Facebook Profile Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_ID = 3;

	/**
	 * The feature id for the '<em><b>Facebook Profile Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_USERNAME = 4;

	/**
	 * The feature id for the '<em><b>Facebook Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_NAME = 5;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Page Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_ID = 6;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Page Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_USERNAME = 7;

	/**
	 * The feature id for the '<em><b>Facebook Tenant Publish Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PUBLISH_ENABLED = 8;

	/**
	 * The feature id for the '<em><b>Facebook Explicitly Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_EXPLICITLY_SHARED = 9;

	/**
	 * The feature id for the '<em><b>Facebook Pixel Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_PIXEL_ID = 10;

	/**
	 * The feature id for the '<em><b>Facebook Pixel Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG__FACEBOOK_PIXEL_ENABLED = 11;

	/**
	 * The number of structural features of the '<em>Facebook Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACEBOOK_SYS_CONFIG_FEATURE_COUNT = 12;

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
	 * The meta object id for the '{@link org.soluvas.socmed.YouTubeSysConfig <em>You Tube Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.socmed.YouTubeSysConfig
	 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getYouTubeSysConfig()
	 * @generated
	 */
	int YOU_TUBE_SYS_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>You Tube Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOU_TUBE_SYS_CONFIG__YOU_TUBE_TENANT_SCREEN_NAME = 0;

	/**
	 * The number of structural features of the '<em>You Tube Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOU_TUBE_SYS_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>You Tube Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YOU_TUBE_SYS_CONFIG_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.soluvas.socmed.PinterestSysConfig <em>Pinterest Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.socmed.PinterestSysConfig
	 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getPinterestSysConfig()
	 * @generated
	 */
	int PINTEREST_SYS_CONFIG = 3;

	/**
	 * The feature id for the '<em><b>Pinterest Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PINTEREST_SYS_CONFIG__PINTEREST_TENANT_SCREEN_NAME = 0;

	/**
	 * The number of structural features of the '<em>Pinterest Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PINTEREST_SYS_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Pinterest Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PINTEREST_SYS_CONFIG_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.soluvas.socmed.InstagramSysConfig <em>Instagram Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.socmed.InstagramSysConfig
	 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getInstagramSysConfig()
	 * @generated
	 */
	int INSTAGRAM_SYS_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Instagram Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTAGRAM_SYS_CONFIG__INSTAGRAM_SCREEN_NAME = 0;

	/**
	 * The feature id for the '<em><b>Instagram Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTAGRAM_SYS_CONFIG__INSTAGRAM_CLIENT_SECRET = 1;

	/**
	 * The number of structural features of the '<em>Instagram Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTAGRAM_SYS_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Instagram Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTAGRAM_SYS_CONFIG_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookProfileId <em>Facebook Profile Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Profile Id</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookProfileId()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookProfileId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookProfileUsername <em>Facebook Profile Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Profile Username</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookProfileUsername()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookProfileUsername();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookProfileName <em>Facebook Profile Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Profile Name</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookProfileName()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookProfileName();

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
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageUsername <em>Facebook Tenant Page Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Tenant Page Username</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageUsername()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookTenantPageUsername();

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
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookPixelId <em>Facebook Pixel Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Pixel Id</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookPixelId()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookPixelId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookPixelEnabled <em>Facebook Pixel Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Pixel Enabled</em>'.
	 * @see org.soluvas.socmed.FacebookSysConfig#getFacebookPixelEnabled()
	 * @see #getFacebookSysConfig()
	 * @generated
	 */
	EAttribute getFacebookSysConfig_FacebookPixelEnabled();

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
	 * Returns the meta object for class '{@link org.soluvas.socmed.YouTubeSysConfig <em>You Tube Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>You Tube Sys Config</em>'.
	 * @see org.soluvas.socmed.YouTubeSysConfig
	 * @generated
	 */
	EClass getYouTubeSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.YouTubeSysConfig#getYouTubeTenantScreenName <em>You Tube Tenant Screen Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>You Tube Tenant Screen Name</em>'.
	 * @see org.soluvas.socmed.YouTubeSysConfig#getYouTubeTenantScreenName()
	 * @see #getYouTubeSysConfig()
	 * @generated
	 */
	EAttribute getYouTubeSysConfig_YouTubeTenantScreenName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.socmed.PinterestSysConfig <em>Pinterest Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pinterest Sys Config</em>'.
	 * @see org.soluvas.socmed.PinterestSysConfig
	 * @generated
	 */
	EClass getPinterestSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.PinterestSysConfig#getPinterestTenantScreenName <em>Pinterest Tenant Screen Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pinterest Tenant Screen Name</em>'.
	 * @see org.soluvas.socmed.PinterestSysConfig#getPinterestTenantScreenName()
	 * @see #getPinterestSysConfig()
	 * @generated
	 */
	EAttribute getPinterestSysConfig_PinterestTenantScreenName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.socmed.InstagramSysConfig <em>Instagram Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instagram Sys Config</em>'.
	 * @see org.soluvas.socmed.InstagramSysConfig
	 * @generated
	 */
	EClass getInstagramSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.InstagramSysConfig#getInstagramScreenName <em>Instagram Screen Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instagram Screen Name</em>'.
	 * @see org.soluvas.socmed.InstagramSysConfig#getInstagramScreenName()
	 * @see #getInstagramSysConfig()
	 * @generated
	 */
	EAttribute getInstagramSysConfig_InstagramScreenName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.socmed.InstagramSysConfig#getInstagramClientSecret <em>Instagram Client Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instagram Client Secret</em>'.
	 * @see org.soluvas.socmed.InstagramSysConfig#getInstagramClientSecret()
	 * @see #getInstagramSysConfig()
	 * @generated
	 */
	EAttribute getInstagramSysConfig_InstagramClientSecret();

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
		 * The meta object literal for the '<em><b>Facebook Profile Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_ID = eINSTANCE.getFacebookSysConfig_FacebookProfileId();

		/**
		 * The meta object literal for the '<em><b>Facebook Profile Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_USERNAME = eINSTANCE.getFacebookSysConfig_FacebookProfileUsername();

		/**
		 * The meta object literal for the '<em><b>Facebook Profile Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_PROFILE_NAME = eINSTANCE.getFacebookSysConfig_FacebookProfileName();

		/**
		 * The meta object literal for the '<em><b>Facebook Tenant Page Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_ID = eINSTANCE.getFacebookSysConfig_FacebookTenantPageId();

		/**
		 * The meta object literal for the '<em><b>Facebook Tenant Page Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_TENANT_PAGE_USERNAME = eINSTANCE.getFacebookSysConfig_FacebookTenantPageUsername();

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
		 * The meta object literal for the '<em><b>Facebook Pixel Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_PIXEL_ID = eINSTANCE.getFacebookSysConfig_FacebookPixelId();

		/**
		 * The meta object literal for the '<em><b>Facebook Pixel Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACEBOOK_SYS_CONFIG__FACEBOOK_PIXEL_ENABLED = eINSTANCE.getFacebookSysConfig_FacebookPixelEnabled();

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

		/**
		 * The meta object literal for the '{@link org.soluvas.socmed.YouTubeSysConfig <em>You Tube Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.socmed.YouTubeSysConfig
		 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getYouTubeSysConfig()
		 * @generated
		 */
		EClass YOU_TUBE_SYS_CONFIG = eINSTANCE.getYouTubeSysConfig();

		/**
		 * The meta object literal for the '<em><b>You Tube Tenant Screen Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YOU_TUBE_SYS_CONFIG__YOU_TUBE_TENANT_SCREEN_NAME = eINSTANCE.getYouTubeSysConfig_YouTubeTenantScreenName();

		/**
		 * The meta object literal for the '{@link org.soluvas.socmed.PinterestSysConfig <em>Pinterest Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.socmed.PinterestSysConfig
		 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getPinterestSysConfig()
		 * @generated
		 */
		EClass PINTEREST_SYS_CONFIG = eINSTANCE.getPinterestSysConfig();

		/**
		 * The meta object literal for the '<em><b>Pinterest Tenant Screen Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PINTEREST_SYS_CONFIG__PINTEREST_TENANT_SCREEN_NAME = eINSTANCE.getPinterestSysConfig_PinterestTenantScreenName();

		/**
		 * The meta object literal for the '{@link org.soluvas.socmed.InstagramSysConfig <em>Instagram Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.socmed.InstagramSysConfig
		 * @see org.soluvas.socmed.impl.SocmedPackageImpl#getInstagramSysConfig()
		 * @generated
		 */
		EClass INSTAGRAM_SYS_CONFIG = eINSTANCE.getInstagramSysConfig();

		/**
		 * The meta object literal for the '<em><b>Instagram Screen Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTAGRAM_SYS_CONFIG__INSTAGRAM_SCREEN_NAME = eINSTANCE.getInstagramSysConfig_InstagramScreenName();

		/**
		 * The meta object literal for the '<em><b>Instagram Client Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTAGRAM_SYS_CONFIG__INSTAGRAM_CLIENT_SECRET = eINSTANCE.getInstagramSysConfig_InstagramClientSecret();

	}

} //SocmedPackage
