package org.soluvas.ldap;

/**
 * {@link Person} with extended attributes from Soluvas, Bippo, Facebook, and Twitter.
 * @author ceefour
 */
@SuppressWarnings("serial")
@LdapEntry(objectClasses={"organizationalPerson", "uidObject", "extensibleObject", "socialPerson", "facebookObject", "twitterObject"})
public class SocialPerson extends Person {

	@LdapAttribute("photoId") private String photoId;
	@LdapAttribute("fbId") private Long facebookId;
	@LdapAttribute("fbUser") private String facebookUsername;
	@LdapAttribute("fbAccessToken") private String facebookAccessToken;
	@LdapAttribute("twitterId") private Long twitterId;
	@LdapAttribute("twitterScreenName") private String twitterScreenName;
	
	public SocialPerson() {
		super();
	}

	public SocialPerson(String id, String slug, String firstName,
			String lastName, String email) {
		super(id, slug, firstName, lastName, email);
	}

	public SocialPerson(String id, String slug, String firstName,
			String lastName) {
		super(id, slug, firstName, lastName);
	}

	/**
	 * @return the photoId
	 */
	public String getPhotoId() {
		return photoId;
	}
	
	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	
	/**
	 * @return the facebookId
	 */
	public Long getFacebookId() {
		return facebookId;
	}
	
	/**
	 * @param facebookId the facebookId to set
	 */
	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}
	
	/**
	 * @return the facebookUsername
	 */
	public String getFacebookUsername() {
		return facebookUsername;
	}
	
	/**
	 * @param facebookUsername the facebookUsername to set
	 */
	public void setFacebookUsername(String facebookUsername) {
		this.facebookUsername = facebookUsername;
	}
	
	/**
	 * @return the facebookAccessToken
	 */
	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}
	
	/**
	 * @param facebookAccessToken the facebookAccessToken to set
	 */
	public void setFacebookAccessToken(String facebookAccessToken) {
		this.facebookAccessToken = facebookAccessToken;
	}
	
	/**
	 * @return the twitterId
	 */
	public Long getTwitterId() {
		return twitterId;
	}
	
	/**
	 * @param twitterId the twitterId to set
	 */
	public void setTwitterId(Long twitterId) {
		this.twitterId = twitterId;
	}
	
	/**
	 * @return the twitterScreenName
	 */
	public String getTwitterScreenName() {
		return twitterScreenName;
	}
	
	/**
	 * @param twitterScreenName the twitterScreenName to set
	 */
	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}
	
}
