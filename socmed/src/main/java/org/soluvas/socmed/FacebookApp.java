package org.soluvas.socmed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Facebook Consumer App information, this does not contain any access token.
 * @see FacebookAuthorization
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes(@JsonSubTypes.Type(name="FacebookApp", value=FacebookApp.class))
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookApp implements Serializable {

	private String apiKey;
	private String apiSecret;
	private Set<String> loginPermissions = new LinkedHashSet<>();

	public FacebookApp() {
	}

	public FacebookApp(String apiKey, String apiSecret, Set<String> loginPermissions) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.loginPermissions.addAll(loginPermissions);
	}

	/**
	 * Facebook App ID.
	 */
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String value) {
		this.apiKey = value;
	}

	/**
	 * Facebook App Secret.
	 * @return
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String value) {
		this.apiSecret = value;
	}

	public Set<String> getLoginPermissions() {
		return loginPermissions;
	}
}