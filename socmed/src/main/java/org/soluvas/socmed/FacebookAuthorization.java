package org.soluvas.socmed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Authorization by a specific Facebook user granted to a specific {@link FacebookApp}.
 * This can be stored as embedded data structure in file or database for tenant, person, shop, etc.
 */
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, property="@type")
@JsonSubTypes(@JsonSubTypes.Type(name="FacebookAuthorization", value=FacebookAuthorization.class))
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookAuthorization implements Serializable {

	private Long entityId;
	private String name;
	private String screenName;
	private String category;
	private Set<FacebookPagePermission> pagePermissions = new HashSet<>();
	private DateTime creationTime;
	private String accessToken;
	private DateTime expiryTime;

	/**
	 * Facebook User or Page ID, if known. Can be app-specific or global ID.
	 * @return
	 */
	@Nullable
	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	/**
	 * Facebook User or Page's name, if known.
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Facebook User's or Page's screen name, if known.
	 * @return
	 */
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * Facebook Page's category.
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Facebook Pages have five levels of permissions to access settings, publish content as a page, or perform operations with the Pages API.
	 * @return
	 */
	public Set<FacebookPagePermission> getPagePermissions() {
		return pagePermissions;
	}

	public void setPagePermissions(Set<FacebookPagePermission> pagePermissions) {
		this.pagePermissions = pagePermissions;
	}

	/**
	 * When this authorization was granted.
	 * @return
	 */
	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * Returns the value of the '<em><b>Twitter Tenant Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Access token that has access to this tenant's Twitter account, referred by {@link #getTwitterTenantScreenName()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Twitter Tenant Access Token</em>' attribute.
	 * @see #setAccessToken(String)
	 * @see SocmedPackage#getTwitterSysConfig_TwitterTenantAccessToken()
	 * @model
	 * @generated
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Sets the value of the '{@link FacebookAuthorization#getAccessToken <em>Twitter Tenant Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Tenant Access Token</em>' attribute.
	 * @see #getAccessToken()
	 * @generated
	 */
	public void setAccessToken(String value) {
		this.accessToken = value;
	}

	public DateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(DateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
} // TwitterSysConfig
