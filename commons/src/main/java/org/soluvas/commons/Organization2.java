/**
 */
package org.soluvas.commons;

import com.google.common.base.MoreObjects;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import java.io.Serializable;

/**
 * Supersedes {@link Organization} and {@link org.soluvas.commons.impl.OrganizationImpl}.
 * Can be used with <a href="https://schema.org/Organization">schema:Organization</a>.
 */
public class Organization2 implements Serializable {
	protected String id;
	protected String name;
	protected static final long SCHEMA_VERSION_EDEFAULT = 1L;
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;
	protected String blackBerryPin;
	protected String website;
	protected String facebookPageUri;
	protected String facebookAccessToken;
	protected String facebookId;
	protected String facebookUserName;
	protected String twitterScreenName;
	protected String twitterAccessToken;
	protected String twitterAccessTokenSecret;
	protected String twitterId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(long schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public String getBlackBerryPin() {
		return blackBerryPin;
	}

	public void setBlackBerryPin(String blackBerryPin) {
		this.blackBerryPin = blackBerryPin;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebookPageUri() {
		return facebookPageUri;
	}

	public void setFacebookPageUri(String facebookPageUri) {
		this.facebookPageUri = facebookPageUri;
	}

	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	public void setFacebookAccessToken(String facebookAccessToken) {
		this.facebookAccessToken = facebookAccessToken;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getFacebookUserName() {
		return facebookUserName;
	}

	public void setFacebookUserName(String facebookUserName) {
		this.facebookUserName = facebookUserName;
	}

	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public void setTwitterAccessToken(String twitterAccessToken) {
		this.twitterAccessToken = twitterAccessToken;
	}

	public String getTwitterAccessTokenSecret() {
		return twitterAccessTokenSecret;
	}

	public void setTwitterAccessTokenSecret(String twitterAccessTokenSecret) {
		this.twitterAccessTokenSecret = twitterAccessTokenSecret;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("id", id)
				.add("name", name)
				.add("schemaVersion", schemaVersion)
				.add("blackBerryPin", blackBerryPin)
				.add("website", website)
				.add("facebookPageUri", facebookPageUri)
				.add("facebookAccessToken", facebookAccessToken)
				.add("facebookId", facebookId)
				.add("facebookUserName", facebookUserName)
				.add("twitterScreenName", twitterScreenName)
				.add("twitterAccessToken", twitterAccessToken)
				.add("twitterAccessTokenSecret", twitterAccessTokenSecret)
				.add("twitterId", twitterId)
				.toString();
	}
}