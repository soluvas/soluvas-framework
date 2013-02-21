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
@LdapEntry(objectClasses={"inetOrgPerson", "uidObject", "extensibleObject", "socialPerson", "facebookObject", "twitterObject"})
public class SocialPerson extends Person {
	
	public static enum Gender { MALE, FEMALE };

	@LdapAttribute("primaryMail")
	private String primaryEmail;
	@LdapAttribute("photoId")
	private String photoId;
	@LdapAttribute("gender")
	private Gender gender;
	@LdapAttribute({ "fbId", "facebookId" })
	private Long facebookId;
	@LdapAttribute({ "fbUser", "facebookUsername" })
	private String facebookUsername;
	@LdapAttribute("fbAccessToken")
	private String facebookAccessToken;
	@LdapAttribute("twitterId")
	private Long twitterId;
	@LdapAttribute("twitterScreenName")
	private String twitterScreenName;
	@LdapAttribute("twitterAccessToken")
	private String twitterAccessToken;
	@LdapAttribute("twitterAccessTokenSecret")
	private String twitterAccessTokenSecret;
	@LdapAttribute("googlePlusId")
	private String googlePlusId;
	@LdapAttribute("googleAccessToken")
	private String googleAccessToken;
	@LdapAttribute("googleUsername")
	private String googleUsername;
	@LdapAttribute("virtualMail")
	private String virtualMail;
	@LdapAttribute("nickname")
	private String nickname;
	@LdapAttribute("primaryShippingAddress")
	private String primaryShippingAddress;
	@LdapAttribute("primaryBillingAddress")
	private String primaryBillingAddress;
	@LdapAttribute("customerRole")
	private String customerRole;
	@LdapAttribute("memberRole")
	private String memberRole;
	@LdapAttribute("administrativeRole")
	private String administrativeRole;
	@LdapAttribute("timezone")
	private String timezone;
	@LdapAttribute("referrer")
	private String referrer;
	@LdapAttribute("referrerType")
	private String referrerType;
	@LdapAttribute("ipAddress")
	private String ipAddress;
	@LdapAttribute("lastIpAddress")
	private String lastIpAddress;
	@LdapAttribute("creationTime")
	private String creationTime;
	@LdapAttribute("modificationTime")
	private String modificationTime;
	@LdapAttribute("lastLoginTime")
	private String lastLoginTime;
	@LdapAttribute("validationTime")
	private String validationTime;
	@LdapAttribute("activationTime")
	private String activationTime;
	@LdapAttribute("verificationTime")
	private String verificationTime;
	@LdapAttribute("accountStatus")
	private String accountStatus;
	@LdapAttribute("newsletterSubscriptionTime")
	private String newsletterSubscriptionTime;
	@LdapAttribute("newsletterSubscriptionEnabled")
	private String newsletterSubscriptionEnabled;
	@LdapAttribute("socialSharingEnabled")
	private String socialSharingEnabled;
	@LdapAttribute("validMail")
	private String validMail;
	@LdapAttribute("publicationStatus")
	private String publicationStatus;
	@LdapAttribute("archivalStatus")
	private String archivalStatus;
	@LdapAttribute("folder")
	private String folder;
	
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
	
	public String getGooglePlusId() {
		return googlePlusId;
	}

	public void setGooglePlusId(String googlePlusId) {
		this.googlePlusId = googlePlusId;
	}

	public String getGoogleAccessToken() {
		return googleAccessToken;
	}

	public void setGoogleAccessToken(String googleAccessToken) {
		this.googleAccessToken = googleAccessToken;
	}

	public String getGoogleUsername() {
		return googleUsername;
	}

	public void setGoogleUsername(String googleUsername) {
		this.googleUsername = googleUsername;
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

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the primaryShippingAddress
	 */
	public String getPrimaryShippingAddress() {
		return primaryShippingAddress;
	}

	/**
	 * @param primaryShippingAddress the primaryShippingAddress to set
	 */
	public void setPrimaryShippingAddress(String primaryShippingAddress) {
		this.primaryShippingAddress = primaryShippingAddress;
	}

	/**
	 * @return the primaryBillingAddress
	 */
	public String getPrimaryBillingAddress() {
		return primaryBillingAddress;
	}

	/**
	 * @param primaryBillingAddress the primaryBillingAddress to set
	 */
	public void setPrimaryBillingAddress(String primaryBillingAddress) {
		this.primaryBillingAddress = primaryBillingAddress;
	}

	/**
	 * Name of Customer Role or Group for example : agen_biasa, agen_special , dropship
	 * @return the customerRole
	 */
	public String getCustomerRole() {
		return customerRole;
	}

	/**
	 * Name of Customer Role or Group for example : agen_biasa, agen_special , dropship
	 * @param customerRole the customerRole to set
	 */
	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	/**
	 * Name of Member Role or Group for example : newbie, aktivis , donatur
	 * @return the memberRole
	 */
	public String getMemberRole() {
		return memberRole;
	}

	/**
	 * Name of Member Role or Group for example : newbie, aktivis , donatur
	 * @param memberRole the memberRole to set
	 */
	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	/**
	 * Name of Administrative Role or Group for example : regular, moderator , administrator, sysadmin
	 * @return the administrativeRole
	 */
	public String getAdministrativeRole() {
		return administrativeRole;
	}

	/**
	 * Name of Administrative Role or Group for example : regular, moderator , administrator, sysadmin
	 * @param administrativeRole the administrativeRole to set
	 */
	public void setAdministrativeRole(String administrativeRole) {
		this.administrativeRole = administrativeRole;
	}

	/**
	 * The attribute is named 'timezone' and is a plain string, e.g. 'Asia/Jakarta' or 'UTC'. If not set, will default to whatever the application configuration is set to (or its heuristics).
	 * 
	 * References:
	 * * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE
	 * * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html
	 * * http://tracker.moodle.org/browse/MDL-17330
	 * 
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * The attribute is named 'timezone' and is a plain string, e.g. 'Asia/Jakarta' or 'UTC'. If not set, will default to whatever the application configuration is set to (or its heuristics).
	 * 
	 * References:
	 * * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE
	 * * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html
	 * * http://tracker.moodle.org/browse/MDL-17330
	 * 
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * Person who refers this person
	 * @return the referrer
	 */
	public String getReferrer() {
		return referrer;
	}

	/**
	 * Person who refers this person
	 * @param referrer the referrer to set
	 */
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	/**
	 * Type of referrer for example : person_id , email, facebook_id
	 * @return the referrerType
	 */
	public String getReferrerType() {
		return referrerType;
	}

	/**
	 * Type of referrer for example : person_id , email, facebook_id
	 * @param referrerType the referrerType to set
	 */
	public void setReferrerType(String referrerType) {
		this.referrerType = referrerType;
	}

	/**
	 * IP address pertama kali login
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * IP address pertama kali login
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * IP address terakhir kali login
	 * @return the lastIpAddress
	 */
	public String getLastIpAddress() {
		return lastIpAddress;
	}

	/**
	 * IP address terakhir kali login
	 * @param lastIpAddress the lastIpAddress to set
	 */
	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	/**
	 * kapan entry pertama kali dibuat
	 * @return the creationTime
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * kapan entry pertama kali dibuat
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * kapan terakhir di-update
	 * @return the modificationTime
	 */
	public String getModificationTime() {
		return modificationTime;
	}

	/**
	 * kapan terakhir di-update
	 * @param modificationTime the modificationTime to set
	 */
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}

	/**
	 * kapan terakhir kali login
	 * @return the lastLoginTime
	 */
	public String getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * kapan terakhir kali login
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * kapan dia validate email
	 * @return the validationTime
	 */
	public String getValidationTime() {
		return validationTime;
	}

	/**
	 * kapan dia validate email
	 * @param validationTime the validationTime to set
	 */
	public void setValidationTime(String validationTime) {
		this.validationTime = validationTime;
	}

	/**
	 * kapan akun dia aktif (bila dimoderasi)
	 * @return the activationTime
	 */
	public String getActivationTime() {
		return activationTime;
	}

	/**
	 * kapan akun dia aktif (bila dimoderasi)
	 * @param activationTime the activationTime to set
	 */
	public void setActivationTime(String activationTime) {
		this.activationTime = activationTime;
	}

	/**
	 * kapan dia menjadi verified member
	 * @return the verificationTime
	 */
	public String getVerificationTime() {
		return verificationTime;
	}

	/**
	 * kapan dia menjadi verified member
	 * @param verificationTime the verificationTime to set
	 */
	public void setVerificationTime(String verificationTime) {
		this.verificationTime = verificationTime;
	}

	/**
	 * accountStatus itu delete (move to Trash)/undelete, untuk normal repository :
	 * 
	 *     draft: Member belum aktif.
	 *     validated: Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).
	 *     active: Akun aktif dan dapat digunakan.
	 *     verified: Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator).
	 *     inactive: Member dinonaktifkan / suspended.
	 *     void: Member dihapus.@return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * accountStatus itu delete (move to Trash)/undelete, untuk normal repository :
	 * 
	 *     draft: Member belum aktif.
	 *     validated: Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).
	 *     active: Akun aktif dan dapat digunakan.
	 *     verified: Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator).
	 *     inactive: Member dinonaktifkan / suspended.
	 *     void: Member dihapus.@return the accountStatus
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * Kapan dia terdaftar di newsletter
	 * @return the newsletterSubscriptionTime
	 */
	public String getNewsletterSubscriptionTime() {
		return newsletterSubscriptionTime;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @param newsletterSubscriptionTime the newsletterSubscriptionTime to set
	 */
	public void setNewsletterSubscriptionTime(String newsletterSubscriptionTime) {
		this.newsletterSubscriptionTime = newsletterSubscriptionTime;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @return the newsletterSubscriptionEnabled
	 */
	public String getNewsletterSubscriptionEnabled() {
		return newsletterSubscriptionEnabled;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @param newsletterSubscriptionEnabled the newsletterSubscriptionEnabled to set
	 */
	public void setNewsletterSubscriptionEnabled(
			String newsletterSubscriptionEnabled) {
		this.newsletterSubscriptionEnabled = newsletterSubscriptionEnabled;
	}

	/**
	 *  Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)
	 * @return the socialSharingEnabled
	 */
	public String getSocialSharingEnabled() {
		return socialSharingEnabled;
	}

	/**
	 *  Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)
	 * @param socialSharingEnabled the socialSharingEnabled to set
	 */
	public void setSocialSharingEnabled(String socialSharingEnabled) {
		this.socialSharingEnabled = socialSharingEnabled;
	}

	/**
	 * daftar email yang sudah divalidasi, bisa multi (apakah email sudah confirmed atau belum). Bila akun confirmed, maka validMail.size() >= 1. Bila semua mail confirmed, maka validMail.equals(mail).
	 * @return the validMail
	 */
	public String getValidMail() {
		return validMail;
	}

	/**
	 * daftar email yang sudah divalidasi, bisa multi (apakah email sudah confirmed atau belum). Bila akun confirmed, maka validMail.size() >= 1. Bila semua mail confirmed, maka validMail.equals(mail).
	 * @param validMail the validMail to set
	 */
	public void setValidMail(String validMail) {
		this.validMail = validMail;
	}

	/**
	 *  atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).
	 *      draft
	 *      published
	 *      unpublished
	 *  
	 * @return the publicationStatus
	 */
	public String getPublicationStatus() {
		return publicationStatus;
	}

	/**
	 *  atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).
	 *      draft
	 *      published
	 *      unpublished
	 * 
	 * @param publicationStatus the publicationStatus to set
	 */
	public void setPublicationStatus(String publicationStatus) {
		this.publicationStatus = publicationStatus;
	}

	/**
	 *  atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya.
	 * 
	 *     fresh
	 *     archived
	 * 
	 * @return the archivalStatus
	 */
	public String getArchivalStatus() {
		return archivalStatus;
	}

	/**
	 *  atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya.
	 * 
	 *     fresh
	 *     archived
	 * 
	 * @param archivalStatus the archivalStatus to set
	 */
	public void setArchivalStatus(String archivalStatus) {
		this.archivalStatus = archivalStatus;
	}

	/**
	 * atribut untuk labeling. Masukkan nsPrefix_{folderName}. (folder name di sini underscore lowercase)
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * atribut untuk labeling. Masukkan nsPrefix_{folderName}. (folder name di sini underscore lowercase)
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
}
