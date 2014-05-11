/**
 */
package org.soluvas.socmed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Twitter Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerKey <em>Twitter Consumer Key</em>}</li>
 *   <li>{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerSecret <em>Twitter Consumer Secret</em>}</li>
 *   <li>{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantScreenName <em>Twitter Tenant Screen Name</em>}</li>
 *   <li>{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessToken <em>Twitter Tenant Access Token</em>}</li>
 *   <li>{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessTokenSecret <em>Twitter Tenant Access Token Secret</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TwitterSysConfig extends EObject {

	/**
	 * Returns the value of the '<em><b>Twitter Consumer Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Twitter consumer key for this tenant.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Consumer Key</em>' attribute.
	 * @see #setTwitterConsumerKey(String)
	 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig_TwitterConsumerKey()
	 * @model
	 * @generated
	 */
	String getTwitterConsumerKey();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerKey <em>Twitter Consumer Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Consumer Key</em>' attribute.
	 * @see #getTwitterConsumerKey()
	 * @generated
	 */
	void setTwitterConsumerKey(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Consumer Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Twitter consumer key for this tenant.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Consumer Secret</em>' attribute.
	 * @see #setTwitterConsumerSecret(String)
	 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig_TwitterConsumerSecret()
	 * @model
	 * @generated
	 */
	String getTwitterConsumerSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterConsumerSecret <em>Twitter Consumer Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Consumer Secret</em>' attribute.
	 * @see #getTwitterConsumerSecret()
	 * @generated
	 */
	void setTwitterConsumerSecret(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Twitter account screen name for this tenant.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Tenant Screen Name</em>' attribute.
	 * @see #setTwitterTenantScreenName(String)
	 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig_TwitterTenantScreenName()
	 * @model
	 * @generated
	 */
	String getTwitterTenantScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantScreenName <em>Twitter Tenant Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Tenant Screen Name</em>' attribute.
	 * @see #getTwitterTenantScreenName()
	 * @generated
	 */
	void setTwitterTenantScreenName(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Tenant Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Access token that has access to this tenant's Twitter account, referred by {@link #getTwitterTenantScreenName()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Tenant Access Token</em>' attribute.
	 * @see #setTwitterTenantAccessToken(String)
	 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig_TwitterTenantAccessToken()
	 * @model
	 * @generated
	 */
	String getTwitterTenantAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessToken <em>Twitter Tenant Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Tenant Access Token</em>' attribute.
	 * @see #getTwitterTenantAccessToken()
	 * @generated
	 */
	void setTwitterTenantAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Tenant Access Token Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Access token secret that has access to this tenant's Twitter account, referred by {@link #getTwitterTenantScreenName()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Tenant Access Token Secret</em>' attribute.
	 * @see #setTwitterTenantAccessTokenSecret(String)
	 * @see org.soluvas.socmed.SocmedPackage#getTwitterSysConfig_TwitterTenantAccessTokenSecret()
	 * @model
	 * @generated
	 */
	String getTwitterTenantAccessTokenSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.TwitterSysConfig#getTwitterTenantAccessTokenSecret <em>Twitter Tenant Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Tenant Access Token Secret</em>' attribute.
	 * @see #getTwitterTenantAccessTokenSecret()
	 * @generated
	 */
	void setTwitterTenantAccessTokenSecret(String value);
} // TwitterSysConfig
