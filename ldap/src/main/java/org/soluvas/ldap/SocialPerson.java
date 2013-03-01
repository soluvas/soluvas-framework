package org.soluvas.ldap;

import java.util.Set;

import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.PublicationStatus;

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
	@LdapAttribute("birthDate")
	private DateTime birthDate;
	@LdapAttribute("lang")
	private String language;
	@LdapAttribute("currency")
	private CurrencyUnit currency;
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
	@LdapAttribute("managerRole")
	private String managerRole;
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
	private DateTime creationTime;
	@LdapAttribute("modificationTime")
	private DateTime modificationTime;
	@LdapAttribute("lastLoginTime")
	private DateTime lastLoginTime;
	@LdapAttribute("validationTime")
	private DateTime validationTime;
	@LdapAttribute("activationTime")
	private DateTime activationTime;
	@LdapAttribute("verificationTime")
	private DateTime verificationTime;
	@LdapAttribute("accountStatus")
	private AccountStatus accountStatus;
	@LdapAttribute("newsletterSubscriptionTime")
	private DateTime newsletterSubscriptionTime;
	@LdapAttribute("newsletterSubscriptionEnabled")
	private Boolean newsletterSubscriptionEnabled;
	@LdapAttribute("socialSharingEnabled")
	private Boolean socialSharingEnabled;
	@LdapAttribute("validMail")
	private Set<String> validMails;
	@LdapAttribute("publicationStatus")
	private PublicationStatus publicationStatus;
	@LdapAttribute("archivalStatus")
	private ArchivalStatus archivalStatus;
	@LdapAttribute("folder")
	private String folder;
	@LdapAttribute("religion")
	private String religion;
	
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
	 * @return the birthDate
	 */
	public DateTime getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Preferred language as language identifier,
	 * as defined by IETF RFC 4646 (http://www.ietf.org/rfc/rfc4646.txt) or successor,
	 * or ISO 639-1 Language Codes. 
	 * @return the languageCode
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Preferred language as language identifier,
	 * as defined by IETF RFC 4646 (http://www.ietf.org/rfc/rfc4646.txt) or successor, 
	 * or ISO 639-1 Language Codes. 
	 * @param language the languageCode to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.
	 * @return the currency
	 */
	public CurrencyUnit getCurrency() {
		return currency;
	}

	/**
	 * Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.
	 * @param currency the currency to set
	 */
	public void setCurrency(CurrencyUnit currency) {
		this.currency = currency;
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
	 * Name of Manager Role or Group for example : regular, moderator , administrator, sysadmin.
	 * 
	 * (administrativeRole attribute OID 2.5.18.5 is already used by LDAP standard)
	 *   
	 * @return the administrativeRole
	 */
	public String getManagerRole() {
		return managerRole;
	}

	/**
	 * Name of Manager Role or Group for example : regular, moderator , administrator, sysadmin
	 * 
	 * (administrativeRole attribute OID 2.5.18.5 is already used by LDAP standard)
	 *   
	 * @param managerRole the administrativeRole to set
	 */
	public void setManagerRole(String managerRole) {
		this.managerRole = managerRole;
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
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * kapan entry pertama kali dibuat
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * kapan terakhir di-update
	 * @return the modificationTime
	 */
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * kapan terakhir di-update
	 * @param modificationTime the modificationTime to set
	 */
	public void setModificationTime(DateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	/**
	 * kapan terakhir kali login
	 * @return the lastLoginTime
	 */
	public DateTime getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * kapan terakhir kali login
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(DateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * kapan dia validate email
	 * @return the validationTime
	 */
	public DateTime getValidationTime() {
		return validationTime;
	}

	/**
	 * kapan dia validate email
	 * @param validationTime the validationTime to set
	 */
	public void setValidationTime(DateTime validationTime) {
		this.validationTime = validationTime;
	}

	/**
	 * kapan akun dia aktif (bila dimoderasi)
	 * @return the activationTime
	 */
	public DateTime getActivationTime() {
		return activationTime;
	}

	/**
	 * kapan akun dia aktif (bila dimoderasi)
	 * @param activationTime the activationTime to set
	 */
	public void setActivationTime(DateTime activationTime) {
		this.activationTime = activationTime;
	}

	/**
	 * kapan dia menjadi verified member
	 * @return the verificationTime
	 */
	public DateTime getVerificationTime() {
		return verificationTime;
	}

	/**
	 * kapan dia menjadi verified member
	 * @param verificationTime the verificationTime to set
	 */
	public void setVerificationTime(DateTime verificationTime) {
		this.verificationTime = verificationTime;
	}

	/**
	 * accountStatus itu delete (move to Trash)/undelete, untuk normal repository :
	 * 
	 * <ol>
	 * 	<li>draft: Member belum aktif.</li>
	 * 	<li>validated: Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).</li>
	 * 	<li>active: Akun aktif dan dapat digunakan.</li>
	 * 	<li>verified: Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator).</li>
	 * 	<li>inactive: Member dinonaktifkan / suspended.</li>
	 * 	<li>void: Member dihapus.@return the accountStatus</li>
	 * </ol>
	 */
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	/**
	 * accountStatus itu delete (move to Trash)/undelete, untuk normal repository :
	 * 
	 * <ol>
	 * 	<li>draft: Member belum aktif.</li>
	 * 	<li>validated: Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).</li>
	 * 	<li>active: Akun aktif dan dapat digunakan.</li>
	 * 	<li>verified: Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator).</li>
	 * 	<li>inactive: Member dinonaktifkan / suspended.</li>
	 * 	<li>void: Member dihapus.@return the accountStatus</li>
	 * </ol>
	 * 
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * Kapan dia terdaftar di newsletter
	 * @return the newsletterSubscriptionTime
	 */
	public DateTime getNewsletterSubscriptionTime() {
		return newsletterSubscriptionTime;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @param newsletterSubscriptionTime the newsletterSubscriptionTime to set
	 */
	public void setNewsletterSubscriptionTime(DateTime newsletterSubscriptionTime) {
		this.newsletterSubscriptionTime = newsletterSubscriptionTime;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @return the newsletterSubscriptionEnabled
	 */
	public Boolean getNewsletterSubscriptionEnabled() {
		return newsletterSubscriptionEnabled;
	}

	/**
	 * Apakah dia ingin menerima newsletter.
	 * @param newsletterSubscriptionEnabled the newsletterSubscriptionEnabled to set
	 */
	public void setNewsletterSubscriptionEnabled(Boolean newsletterSubscriptionEnabled) {
		this.newsletterSubscriptionEnabled = newsletterSubscriptionEnabled;
	}

	/**
	 * Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)
	 * @return the socialSharingEnabled
	 */
	public Boolean getSocialSharingEnabled() {
		return socialSharingEnabled;
	}

	/**
	 *  Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)
	 * @param socialSharingEnabled the socialSharingEnabled to set
	 */
	public void setSocialSharingEnabled(Boolean socialSharingEnabled) {
		this.socialSharingEnabled = socialSharingEnabled;
	}

	/**
	 * daftar email yang sudah divalidasi, bisa multi (apakah email sudah confirmed atau belum). Bila akun confirmed, maka validMail.size() >= 1. Bila semua mail confirmed, maka validMail.equals(mail).
	 * @return the validMail
	 */
	public Set<String> getValidMails() {
		return validMails;
	}

	/**
	 * daftar email yang sudah divalidasi, bisa multi (apakah email sudah confirmed atau belum). Bila akun confirmed, maka validMail.size() >= 1. Bila semua mail confirmed, maka validMail.equals(mail).
	 * @param validMail the validMail to set
	 */
	public void setValidMails(Set<String> validMails) {
		this.validMails = validMails;
	}

	/**
	 *  atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).
	 *      draft
	 *      published
	 *      unpublished
	 *  
	 * @return the publicationStatus
	 */
	public PublicationStatus getPublicationStatus() {
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
	public void setPublicationStatus(PublicationStatus publicationStatus) {
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
	public ArchivalStatus getArchivalStatus() {
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
	public void setArchivalStatus(ArchivalStatus archivalStatus) {
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

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
}
