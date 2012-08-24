package org.soluvas.ldap;

import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

/**
 * {@link Person} with extended attributes from Soluvas, Bippo, Facebook, and Twitter.
 * @author ceefour
 */
@SuppressWarnings("serial")
@LdapEntry(objectClasses={"organizationalPerson", "uidObject", "extensibleObject", "socialPerson", "facebookObject", "twitterObject"})
public class SocialPerson extends Person {
	
	public static enum Gender { MALE, FEMALE };

	@LdapAttribute("primaryMail") private String primaryEmail;
	@LdapAttribute("photoId") private String photoId;
	@LdapAttribute("gender") private Gender gender;
	@LdapAttribute("fbId") private Long facebookId;
	@LdapAttribute("fbUser") private String facebookUsername;
	@LdapAttribute("fbAccessToken") private String facebookAccessToken;
	@LdapAttribute("twitterId") private Long twitterId;
	@LdapAttribute("twitterScreenName") private String twitterScreenName;
	@LdapAttribute("virtualMail") private String virtualMail;
	
	public SocialPerson() {
		super();
	}

	public SocialPerson(String id, String slug, String firstName,
			String lastName) {
		super(id, slug, firstName, lastName);
	}

	public SocialPerson(String id, String slug, String firstName,
			String lastName, Gender gender) {
		super(id, slug, firstName, lastName);
		this.gender = gender;
	}

	/**
	 * @return the primaryEmail
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * @param primaryEmail the primaryEmail to set
	 */
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
		Builder<String> emailsBuilder = ImmutableSet.<String>builder();
		if (getEmails() != null)
			emailsBuilder.addAll(getEmails());
		if (primaryEmail != null)
			emailsBuilder.add(primaryEmail);
		final Set<String> newEmails = emailsBuilder.build();
		if (!newEmails.equals(getEmails())) {
			setEmails( newEmails );
		}
	}
	
	@Override
	public void setEmails(Set<String> emails) {
		super.setEmails(emails);
		if (emails != null && !emails.isEmpty() && Strings.isNullOrEmpty(primaryEmail)) {
			final String newPrimaryEmail = emails.iterator().next();
			if (!Strings.isNullOrEmpty(newPrimaryEmail))
				setPrimaryEmail(newPrimaryEmail);
		}
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
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	/**
	 * @return the virtualMail
	 */
	public String getVirtualMail() {
		return virtualMail;
	}

	/**
	 * @param virtualMail the virtualMail to set
	 */
	public void setVirtualMail(String virtualMail) {
		this.virtualMail = virtualMail;
	}
	
}
