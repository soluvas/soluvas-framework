package org.soluvas.socmed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Twitter Consumer App information, this does not contain any access token.
 * @see TwitterAuthorization
 */
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes(@com.fasterxml.jackson.annotation.JsonSubTypes.Type(name="TwitterApp", value=TwitterApp.class))
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterApp {

	private String apiKey;
	private String apiSecret;

	/**
	 * Returns the value of the '<em><b>Twitter Consumer Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Twitter consumer key for this tenant.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Consumer Key</em>' attribute.
	 * @see #setApiKey(String)
	 * @see SocmedPackage#getTwitterSysConfig_TwitterConsumerKey()
	 * @model
	 * @generated
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Sets the value of the '{@link TwitterApp#getApiKey <em>Twitter Consumer Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Consumer Key</em>' attribute.
	 * @see #getApiKey()
	 * @generated
	 */
	public void setApiKey(String value) {
		this.apiKey = value;
	}

	/**
	 * Returns the value of the '<em><b>Twitter Consumer Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Twitter consumer key for this tenant.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Consumer Secret</em>' attribute.
	 * @see #setApiSecret(String)
	 * @see SocmedPackage#getTwitterSysConfig_TwitterConsumerSecret()
	 * @model
	 * @generated
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	/**
	 * Sets the value of the '{@link TwitterApp#getApiSecret <em>Twitter Consumer Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Consumer Secret</em>' attribute.
	 * @see #getApiSecret()
	 * @generated
	 */
	public void setApiSecret(String value) {
		this.apiSecret = value;
	}

} // TwitterSysConfig
