package org.soluvas.commons.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.Email2;
import org.soluvas.commons.Gender;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.Organization;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.commons.PhoneNumber2;
import org.soluvas.commons.PostalAddress2;
import org.soluvas.commons.PublicationStatus;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.LocalDateConverter;
import org.soluvas.commons.mongo.UnitConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@Entity(noClassnameStored=true)
@Converters({BigDecimalConverter.class, DateTimeConverter.class,
	CurrencyUnitConverter.class, UnitConverter.class, LocalDateConverter.class})
public class Person2 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static final String NAME_EDEFAULT = null;
	protected String name = NAME_EDEFAULT;
	protected static final String PHOTO_ID_EDEFAULT = null;
	protected String photoId = PHOTO_ID_EDEFAULT;
	protected static final String ID_EDEFAULT = null;
	@Id @JsonProperty("uid")
	protected String id = ID_EDEFAULT;
	protected static final DateTime CREATION_TIME_EDEFAULT = null;
	protected DateTime creationTime = CREATION_TIME_EDEFAULT;
	protected static final DateTime MODIFICATION_TIME_EDEFAULT = null;
	protected DateTime modificationTime = MODIFICATION_TIME_EDEFAULT;
	protected static final String DESCRIPTION_EDEFAULT = null;
	protected String description = DESCRIPTION_EDEFAULT;
	protected static final String SLUG_EDEFAULT = null;
	protected String slug = SLUG_EDEFAULT;
	protected static final String CANONICAL_SLUG_EDEFAULT = null;
	protected String canonicalSlug = CANONICAL_SLUG_EDEFAULT;
	protected static final String TWITTER_ACCESS_TOKEN_EDEFAULT = null;
	protected String twitterAccessToken = TWITTER_ACCESS_TOKEN_EDEFAULT;
	protected static final String TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT = null;
	protected String twitterAccessTokenSecret = TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT;
	protected static final Long TWITTER_ID_EDEFAULT = null;
	protected Long twitterId = TWITTER_ID_EDEFAULT;
	protected static final String TWITTER_SCREEN_NAME_EDEFAULT = null;
	protected String twitterScreenName = TWITTER_SCREEN_NAME_EDEFAULT;
	protected static final Long FACEBOOK_ID_EDEFAULT = null;
	protected Long facebookId = FACEBOOK_ID_EDEFAULT;
	protected static final String FACEBOOK_USERNAME_EDEFAULT = null;
	protected String facebookUsername = FACEBOOK_USERNAME_EDEFAULT;
	protected static final String FACEBOOK_ACCESS_TOKEN_EDEFAULT = null;
	protected String facebookAccessToken = FACEBOOK_ACCESS_TOKEN_EDEFAULT;
	protected static final String GUID_EDEFAULT = null;
	@JsonProperty("_id")
	protected String guid = GUID_EDEFAULT;
	protected static final String REVISION_EDEFAULT = null;
	@JsonProperty("_rev") @JsonInclude(Include.NON_NULL)
	protected String revision = REVISION_EDEFAULT;
	protected static final long SCHEMA_VERSION_EDEFAULT = 2L;
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;
	public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_EDEFAULT;
	protected static final String FIRST_NAME_EDEFAULT = null;
	protected String firstName = FIRST_NAME_EDEFAULT;
	protected static final String LAST_NAME_EDEFAULT = null;
	protected String lastName = LAST_NAME_EDEFAULT;
	protected static final String PASSWORD_EDEFAULT = null;
	protected String password = PASSWORD_EDEFAULT;
	protected List<PhoneNumber2> phoneNumbers;
	protected List<Email2> emails;
	protected List<PhoneNumber2> mobileNumbers;

	protected List<PostalAddress2> addresses;
	protected static final AccountStatus ACCOUNT_STATUS_EDEFAULT = AccountStatus.DRAFT;
	protected AccountStatus accountStatus = ACCOUNT_STATUS_EDEFAULT;
	protected static final Integer BIRTH_YEAR_EDEFAULT = null;
	protected Integer birthYear = BIRTH_YEAR_EDEFAULT;
	protected static final Integer BIRTH_MONTH_EDEFAULT = null;
	protected Integer birthMonth = BIRTH_MONTH_EDEFAULT;
	protected static final Integer BIRTH_DAY_EDEFAULT = null;

	protected Integer birthDay = BIRTH_DAY_EDEFAULT;
	protected static final LocalDate BIRTH_DATE_EDEFAULT = null;

	protected LocalDate birthDate = BIRTH_DATE_EDEFAULT;

	protected static final Gender GENDER_EDEFAULT = Gender.UNKNOWN;
	protected Gender gender = GENDER_EDEFAULT;

	protected static final String LANGUAGE_EDEFAULT = null;

	protected String language = LANGUAGE_EDEFAULT;

	protected static final String CURRENCY_CODE_EDEFAULT = null;
	protected String currencyCode = CURRENCY_CODE_EDEFAULT;
	protected static final CurrencyUnit CURRENCY_EDEFAULT = null;
	protected static final String GOOGLE_PLUS_ID_EDEFAULT = null;
	protected String googlePlusId = GOOGLE_PLUS_ID_EDEFAULT;
	protected static final String GOOGLE_USERNAME_EDEFAULT = null;
	protected String googleUsername = GOOGLE_USERNAME_EDEFAULT;
	protected static final String VIRTUAL_MAIL_EDEFAULT = null;
	protected String virtualMail = VIRTUAL_MAIL_EDEFAULT;
	protected static final String NICKNAME_EDEFAULT = null;
	protected String nickname = NICKNAME_EDEFAULT;
	protected static final String CUSTOMER_ROLE_EDEFAULT = null;
	protected String customerRole = CUSTOMER_ROLE_EDEFAULT;
	protected static final String MEMBER_ROLE_EDEFAULT = null;
	protected String memberRole = MEMBER_ROLE_EDEFAULT;
	protected static final String MANAGER_ROLE_EDEFAULT = null;
	protected String managerRole = MANAGER_ROLE_EDEFAULT;
	protected static final String TIME_ZONE_ID_EDEFAULT = null;
	protected String timeZoneId = TIME_ZONE_ID_EDEFAULT;
	protected static final DateTimeZone TIME_ZONE_EDEFAULT = null;
	protected static final String REFERRER_ID_EDEFAULT = null;
	protected String referrerId = REFERRER_ID_EDEFAULT;
	protected static final String REFERRER_TYPE_EDEFAULT = null;
	protected String referrerType = REFERRER_TYPE_EDEFAULT;
	protected static final String SIGNUP_SOURCE_EDEFAULT = null;
	protected String signupSource = SIGNUP_SOURCE_EDEFAULT;
	protected static final SignupSourceType SIGNUP_SOURCE_TYPE_EDEFAULT = SignupSourceType.OTHER;
	protected SignupSourceType signupSourceType = SIGNUP_SOURCE_TYPE_EDEFAULT;
	protected static final String IP_ADDRESS_EDEFAULT = null;
	protected String ipAddress = IP_ADDRESS_EDEFAULT;
	protected static final String LAST_IP_ADDRESS_EDEFAULT = null;
	protected String lastIpAddress = LAST_IP_ADDRESS_EDEFAULT;
	protected static final DateTime LAST_LOGIN_TIME_EDEFAULT = null;
	protected DateTime lastLoginTime = LAST_LOGIN_TIME_EDEFAULT;
	protected static final DateTime VALIDATION_TIME_EDEFAULT = null;
	protected DateTime validationTime = VALIDATION_TIME_EDEFAULT;
	protected static final DateTime ACTIVATION_TIME_EDEFAULT = null;

	protected DateTime activationTime = ACTIVATION_TIME_EDEFAULT;

	protected static final DateTime VERIFICATION_TIME_EDEFAULT = null;

	protected DateTime verificationTime = VERIFICATION_TIME_EDEFAULT;

	protected static final Boolean NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT = null;

	protected Boolean newsletterSubscriptionEnabled = NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT;

	protected static final DateTime NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT = null;

	protected DateTime newsletterSubscriptionTime = NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT;

	protected static final Boolean SOCIAL_SHARING_ENABLED_EDEFAULT = null;

	protected Boolean socialSharingEnabled = SOCIAL_SHARING_ENABLED_EDEFAULT;

	protected static final PublicationStatus PUBLICATION_STATUS_EDEFAULT = PublicationStatus.DRAFT;

	protected PublicationStatus publicationStatus = PUBLICATION_STATUS_EDEFAULT;
	protected static final ArchivalStatus ARCHIVAL_STATUS_EDEFAULT = ArchivalStatus.FRESH;

	protected ArchivalStatus archivalStatus = ARCHIVAL_STATUS_EDEFAULT;
	protected static final String FOLDER_EDEFAULT = null;
	protected String folder = FOLDER_EDEFAULT;

	protected static final String RELIGION_EDEFAULT = null;

	protected String religion = RELIGION_EDEFAULT;
	protected static final String PASSWORD_RESET_CODE_EDEFAULT = null;

	protected String passwordResetCode = PASSWORD_RESET_CODE_EDEFAULT;
	protected static final DateTime PASSWORD_RESET_EXPIRY_TIME_EDEFAULT = null;
	protected DateTime passwordResetExpiryTime = PASSWORD_RESET_EXPIRY_TIME_EDEFAULT;

	protected static final String CLIENT_ACCESS_TOKEN_EDEFAULT = null;

	protected String clientAccessToken = CLIENT_ACCESS_TOKEN_EDEFAULT;
	protected List<String> securityRoleIds;

	protected static final BigDecimal DEBIT_BALANCE_EDEFAULT = null;

	protected BigDecimal debitBalance = DEBIT_BALANCE_EDEFAULT;
	protected static final CurrencyUnit DEBIT_CURRENCY_EDEFAULT = null;
	protected CurrencyUnit debitCurrency = DEBIT_CURRENCY_EDEFAULT;
	protected static final String TYPE_EDEFAULT = "Person";
	protected String type = TYPE_EDEFAULT;
	protected static final String VERIFY_CODE_EDEFAULT = null;
	protected String verifyCode = VERIFY_CODE_EDEFAULT;
	protected List<Organization> organizations;
	protected static final Long ZENDESK_USER_ID_EDEFAULT = null;
	protected Long zendeskUserId = ZENDESK_USER_ID_EDEFAULT;
	protected static final DateTime CUSTOMER_ROLE_EDIT_TIME_EDEFAULT = null;
	protected DateTime customerRoleEditTime = CUSTOMER_ROLE_EDIT_TIME_EDEFAULT;
	protected static final DateTime LAST_TIME_SYNCHRONIZE_WITH_ZENDESK_EDEFAULT = null;
	protected DateTime lastTimeSynchronizeWithZendesk = LAST_TIME_SYNCHRONIZE_WITH_ZENDESK_EDEFAULT;
	protected static final boolean ZENDESK_INTEGRATION_EDEFAULT = false;
	protected boolean zendeskIntegration = ZENDESK_INTEGRATION_EDEFAULT;

	public Person2() {
		super();
	}

	public static class ToPersonInfo implements Function<Person2, PersonInfo2> {
		@Override @Nullable
		public PersonInfo2 apply(@Nullable Person2 input) {
			if (input == null)
				return null;
			final PersonInfo2 personInfo = new PersonInfo2();
			personInfo.setId(input.getId());
			personInfo.setSlug(input.getSlug());
			personInfo.setName(input.getName());
			personInfo.setPhotoId(input.getPhotoId());
			personInfo.setGender(input.getGender());
			personInfo.setEmail(input.getEmail());
			personInfo.setMobileNumber(input.getMobileNumber());
			return personInfo;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String newPhotoId) {
		photoId = newPhotoId;
	}

	public String getId() {
		return id;
	}
	public void setId(String newId) {
		id = newId;
	}

	public DateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(DateTime newCreationTime) {
		creationTime = newCreationTime;
	}

	public DateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(DateTime newModificationTime) {
		modificationTime = newModificationTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public long getSchemaVersion() {
		return schemaVersion;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public List<PhoneNumber2> getPhoneNumbers() {
		if (phoneNumbers == null) {
			phoneNumbers = new ArrayList<>();
		}
		return phoneNumbers;
	}
	
	public String getPhoneNumber() {
		final Optional<PhoneNumber2> primaryPhone = Iterables.tryFind(getPhoneNumbers(), new Predicate<PhoneNumber2>() {
			@Override
			public boolean apply(@Nullable PhoneNumber2 input) {
				return input.getPrimary();
			}
		});
		if (primaryPhone.isPresent()) {
			return primaryPhone.get().getPhoneNumber();
		} else if (!getPhoneNumbers().isEmpty()) {
			return getPhoneNumbers().get(0).getPhoneNumber();
		} else {
			return null;
		}
	}

	@JsonIgnore
	private void setPhoneNumber(String phoneNumber) {
		throw new UnsupportedOperationException();
	}

	public List<Email2> getEmails() {
		if (emails == null) {
			emails = new ArrayList<>();
		}
		return emails;
	}

	public List<PhoneNumber2> getMobileNumbers() {
		if (mobileNumbers == null) {
			mobileNumbers = new ArrayList<>();
		}
		return mobileNumbers;
	}
	
	@JsonProperty
	public String getMobileNumber() {
		final Optional<PhoneNumber2> primaryMobile = Iterables.tryFind(getMobileNumbers(), new Predicate<PhoneNumber2>() {
			@Override
			public boolean apply(@Nullable PhoneNumber2 input) {
				return input.getPrimary();
			}
		});
		if (primaryMobile.isPresent()) {
			return primaryMobile.get().getPhoneNumber();
		} else if (!getMobileNumbers().isEmpty()) {
			return getMobileNumbers().get(0).getPhoneNumber();
		} else {
			return null;
		}
	}

	@JsonIgnore
	private void setMobileNumber(String mobileNumber) {
		throw new UnsupportedOperationException();
	}
	
	public List<PostalAddress2> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<>();
		}
		return addresses;
	}
	
	@JsonIgnore
	public PostalAddress2 getPrimaryAddress() {
		if (getAddresses() != null && !getAddresses().isEmpty()) {
			final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), new Predicate<PostalAddress2>() {
				@Override
				public boolean apply(@Nullable PostalAddress2 input) {
					return input.isPrimary();
				}
			});
			if (primaryAddress.isPresent()) {
				return primaryAddress.get();
			} else {
				return getAddresses().get(0);
			}
		} else {
			return null;
		}
	}
	
	@JsonIgnore
	public PostalAddress2 getPrimaryShippingAddress() {
		if (getAddresses() != null && !getAddresses().isEmpty()) {
			final Optional<PostalAddress2> primaryShippingAddress = Iterables.tryFind(getAddresses(), new Predicate<PostalAddress2>() {
				@Override
				public boolean apply(@Nullable PostalAddress2 input) {
					return input.isPrimaryShipping();
				}
			});
			if (primaryShippingAddress.isPresent()) {
				return primaryShippingAddress.get();
			}
			
			final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), new Predicate<PostalAddress2>() {
				@Override
				public boolean apply(@Nullable PostalAddress2 input) {
					return input.isPrimary();
				}
			});
			if (primaryAddress.isPresent()) {
				return primaryAddress.get();
			} else {
				return getAddresses().get(0);
			}
		} else {
			return null;
		}
	}
	
	@JsonIgnore
	public PostalAddress2 getPrimaryBillingAddress() {
		if (getAddresses() != null && !getAddresses().isEmpty()) {
			final Optional<PostalAddress2> primaryBillingAddress = Iterables.tryFind(getAddresses(), new Predicate<PostalAddress2>() {
				@Override
				public boolean apply(@Nullable PostalAddress2 input) {
					return input.isPrimaryBilling();
				}
			});
			if (primaryBillingAddress.isPresent()) {
				return primaryBillingAddress.get();
			}
			
			final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), new Predicate<PostalAddress2>() {
				@Override
				public boolean apply(@Nullable PostalAddress2 input) {
					return input.isPrimary();
				}
			});
			if (primaryAddress.isPresent()) {
				return primaryAddress.get();
			} else {
				return getAddresses().get(0);
			}
		} else {
			return null;
		}
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus newAccountStatus) {
		accountStatus = newAccountStatus == null ? ACCOUNT_STATUS_EDEFAULT : newAccountStatus;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer newBirthYear) {
		birthYear = newBirthYear;
	}

	public Integer getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Integer newBirthMonth) {
		birthMonth = newBirthMonth;
	}

	public Integer getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Integer newBirthDay) {
		birthDay = newBirthDay;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate newBirthDate) {
		birthDate = newBirthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender newGender) {
		gender = newGender == null ? GENDER_EDEFAULT : newGender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String newLanguage) {
		language = newLanguage;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String newCurrencyCode) {
		currencyCode = newCurrencyCode;
	}

	public CurrencyUnit getCurrency() {
		return currencyCode != null ? Monetary.getCurrency(currencyCode) : null;
	}

	public void setCurrency(CurrencyUnit newCurrency) {
		setCurrencyCode(newCurrency != null ? newCurrency.getCurrencyCode() : null);
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long newFacebookId) {
		facebookId = newFacebookId;
	}

	public String getFacebookUsername() {
		return facebookUsername;
	}

	public void setFacebookUsername(String newFacebookUsername) {
		facebookUsername = newFacebookUsername;
	}

	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	public void setFacebookAccessToken(String newFacebookAccessToken) {
		facebookAccessToken = newFacebookAccessToken;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String newGuid) {
		guid = newGuid;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String newRevision) {
		revision = newRevision;
	}

	public Long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(Long newTwitterId) {
		twitterId = newTwitterId;
	}

	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	public void setTwitterScreenName(String newTwitterScreenName) {
		twitterScreenName = newTwitterScreenName;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public void setTwitterAccessToken(String newTwitterAccessToken) {
		twitterAccessToken = newTwitterAccessToken;
	}

	public String getTwitterAccessTokenSecret() {
		return twitterAccessTokenSecret;
	}

	public void setTwitterAccessTokenSecret(String newTwitterAccessTokenSecret) {
		twitterAccessTokenSecret = newTwitterAccessTokenSecret;
	}

	public String getGooglePlusId() {
		return googlePlusId;
	}

	public void setGooglePlusId(String newGooglePlusId) {
		googlePlusId = newGooglePlusId;
	}

	public String getGoogleUsername() {
		return googleUsername;
	}

	public void setGoogleUsername(String newGoogleUsername) {
		googleUsername = newGoogleUsername;
	}

	public String getVirtualMail() {
		return virtualMail;
	}

	public void setVirtualMail(String newVirtualMail) {
		virtualMail = newVirtualMail;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String newNickname) {
		nickname = newNickname;
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String newCustomerRole) {
		customerRole = newCustomerRole;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String newMemberRole) {
		memberRole = newMemberRole;
	}

	public String getManagerRole() {
		return managerRole;
	}

	public void setManagerRole(String newManagerRole) {
		managerRole = newManagerRole;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String newTimeZoneId) {
		timeZoneId = newTimeZoneId;
	}

	public DateTimeZone getTimeZone() {
		return timeZoneId != null ? DateTimeZone.forID(timeZoneId) : null;
	}

	public void setTimeZone(DateTimeZone newTimeZone) {
		setTimeZoneId(newTimeZone != null ? newTimeZone.getID() : null);
	}

	public String getReferrerId() {
		return referrerId;
	}

	public void setReferrerId(String newReferrerId) {
		referrerId = newReferrerId;
	}

	public String getReferrerType() {
		return referrerType;
	}

	public void setReferrerType(String newReferrerType) {
		referrerType = newReferrerType;
	}

	public String getSignupSource() {
		return signupSource;
	}

	public void setSignupSource(String newSignupSource) {
		signupSource = newSignupSource;
	}

	public SignupSourceType getSignupSourceType() {
		return signupSourceType;
	}

	public void setSignupSourceType(SignupSourceType newSignupSourceType) {
		signupSourceType = newSignupSourceType == null ? SIGNUP_SOURCE_TYPE_EDEFAULT : newSignupSourceType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String newIpAddress) {
		ipAddress = newIpAddress;
	}

	public String getLastIpAddress() {
		return lastIpAddress;
	}

	public void setLastIpAddress(String newLastIpAddress) {
		lastIpAddress = newLastIpAddress;
	}

	public DateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(DateTime newLastLoginTime) {
		lastLoginTime = newLastLoginTime;
	}

	public DateTime getValidationTime() {
		return validationTime;
	}

	public void setValidationTime(DateTime newValidationTime) {
		validationTime = newValidationTime;
	}

	public DateTime getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(DateTime newActivationTime) {
		activationTime = newActivationTime;
	}

	public DateTime getVerificationTime() {
		return verificationTime;
	}

	public void setVerificationTime(DateTime newVerificationTime) {
		verificationTime = newVerificationTime;
	}

	public Boolean getNewsletterSubscriptionEnabled() {
		return newsletterSubscriptionEnabled;
	}

	public void setNewsletterSubscriptionEnabled(Boolean newNewsletterSubscriptionEnabled) {
		newsletterSubscriptionEnabled = newNewsletterSubscriptionEnabled;
	}

	public DateTime getNewsletterSubscriptionTime() {
		return newsletterSubscriptionTime;
	}

	public void setNewsletterSubscriptionTime(DateTime newNewsletterSubscriptionTime) {
		newsletterSubscriptionTime = newNewsletterSubscriptionTime;
	}

	public Boolean getSocialSharingEnabled() {
		return socialSharingEnabled;
	}

	public void setSocialSharingEnabled(Boolean newSocialSharingEnabled) {
		socialSharingEnabled = newSocialSharingEnabled;
	}

	public PublicationStatus getPublicationStatus() {
		return publicationStatus;
	}

	public void setPublicationStatus(PublicationStatus newPublicationStatus) {
		publicationStatus = newPublicationStatus == null ? PUBLICATION_STATUS_EDEFAULT : newPublicationStatus;
	}

	public ArchivalStatus getArchivalStatus() {
		return archivalStatus;
	}

	public void setArchivalStatus(ArchivalStatus newArchivalStatus) {
		archivalStatus = newArchivalStatus == null ? ARCHIVAL_STATUS_EDEFAULT : newArchivalStatus;
	}

	public String getFolder() {
		return folder;
	}
	
	public void setFolder(String newFolder) {
		folder = newFolder;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String newReligion) {
		religion = newReligion;
	}

	public String getPasswordResetCode() {
		return passwordResetCode;
	}

	public void setPasswordResetCode(String newPasswordResetCode) {
		passwordResetCode = newPasswordResetCode;
	}

	public DateTime getPasswordResetExpiryTime() {
		return passwordResetExpiryTime;
	}

	public void setPasswordResetExpiryTime(DateTime newPasswordResetExpiryTime) {
		passwordResetExpiryTime = newPasswordResetExpiryTime;
	}

	public String getClientAccessToken() {
		return clientAccessToken;
	}

	public void setClientAccessToken(String newClientAccessToken) {
		clientAccessToken = newClientAccessToken;
	}

	public List<String> getSecurityRoleIds() {
		if (securityRoleIds == null) {
			securityRoleIds = new ArrayList<>();
		}
		return securityRoleIds;
	}

	public BigDecimal getDebitBalance() {
		return debitBalance;
	}

	public void setDebitBalance(BigDecimal newDebitBalance) {
		debitBalance = newDebitBalance;
	}

	public CurrencyUnit getDebitCurrency() {
		return debitCurrency;
	}

	public void setDebitCurrency(CurrencyUnit newDebitCurrency) {
		debitCurrency = newDebitCurrency;
	}

	public String getType() {
		return type;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String newVerifyCode) {
		verifyCode = newVerifyCode;
	}

	public List<Organization> getOrganizations() {
		if (organizations == null) {
			organizations = new ArrayList<>();
		}
		return organizations;
	}

	public Long getZendeskUserId() {
		return zendeskUserId;
	}

	public void setZendeskUserId(Long newZendeskUserId) {
		zendeskUserId = newZendeskUserId;
	}

	public DateTime getCustomerRoleEditTime() {
		return customerRoleEditTime;
	}

	public void setCustomerRoleEditTime(DateTime newCustomerRoleEditTime) {
		customerRoleEditTime = newCustomerRoleEditTime;
	}

	public DateTime getLastTimeSynchronizeWithZendesk() {
		return lastTimeSynchronizeWithZendesk;
	}

	public void setLastTimeSynchronizeWithZendesk(DateTime newLastTimeSynchronizeWithZendesk) {
		lastTimeSynchronizeWithZendesk = newLastTimeSynchronizeWithZendesk;
	}

	public boolean isZendeskIntegration() {
		return zendeskIntegration;
	}

	public void setZendeskIntegration(boolean newZendeskIntegration) {
		zendeskIntegration = newZendeskIntegration;
	}

	public boolean hasEmail(String email) {
		if (email == null) {
			return false;
		}
		final String toFind = NameUtils.normalizeEmail(email);
		return Iterables.any(getEmails(), new Predicate<Email2>() {
			@Override
			public boolean apply(@Nullable Email2 input) {
				return toFind.equals(input.getEmail());
			}
		});
	}

	public Email2 putEmail(String email) {
		if (email == null) {
			return null;
		}
		final String normalized = NameUtils.normalizeEmail(email);
		final Optional<Email2> found = Iterables.tryFind(getEmails(), new Predicate<Email2>() {
			@Override
			public boolean apply(@Nullable Email2 input) {
				return normalized.equals(input.getEmail());
			}
		});
		if (found.isPresent()) {
			return found.get();
		} else {
			final Email2 newEmail = new Email2(normalized, getEmails().isEmpty());
			getEmails().add(newEmail);
			return newEmail;
		}
	}

	public Person2 toPerson2() {
		final Person2 person2 = new Person2();
		person2.setId(getId());
		person2.setGender(getGender());
		person2.setName(getName());
		person2.setSlug(getSlug());
		person2.setCanonicalSlug(getCanonicalSlug());
		person2.setReligion(getReligion());
		person2.setBirthDate(getBirthDate());
		person2.setPhotoId(getImageId());
		return person2;
	}

	public PersonInfo2 toInfo() {
		return new ToPersonInfo().apply(this);
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String newSlug) {
		slug = newSlug;
	}

	public String getCanonicalSlug() {
		return canonicalSlug;
	}

	public void setCanonicalSlug(String newCanonicalSlug) {
		canonicalSlug = newCanonicalSlug;
	}

	@JsonProperty
	public String getEmail() {
		final Optional<Email2> primaryEmail = Iterables.tryFind(getEmails(), Email2::getPrimary);
		if (primaryEmail.isPresent()) {
			return primaryEmail.get().getEmail();
		} else if (!getEmails().isEmpty()) {
			return getEmails().get(0).getEmail();
		} else {
			return null;
		}
	}
	
	@JsonIgnore
	private void setEmail(String email) {
		// serialization only, no deserialization
		throw new UnsupportedOperationException();
	}

	@JsonProperty
	public String getImageId() {
		return photoId;
	}
	
	@JsonIgnore
	private void setImageId(String imageId) {
		// serialization only, no deserialization
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", photoId: ");
		result.append(photoId);
		result.append(", id: ");
		result.append(id);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", description: ");
		result.append(description);
		result.append(", slug: ");
		result.append(slug);
		result.append(", canonicalSlug: ");
		result.append(canonicalSlug);
		result.append(", twitterAccessToken: ");
		result.append(twitterAccessToken);
		result.append(", twitterAccessTokenSecret: ");
		result.append(twitterAccessTokenSecret);
		result.append(", twitterId: ");
		result.append(twitterId);
		result.append(", twitterScreenName: ");
		result.append(twitterScreenName);
		result.append(", facebookId: ");
		result.append(facebookId);
		result.append(", facebookUsername: ");
		result.append(facebookUsername);
		result.append(", facebookAccessToken: ");
		result.append(facebookAccessToken);
		result.append(", guid: ");
		result.append(guid);
		result.append(", revision: ");
		result.append(revision);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", firstName: ");
		result.append(firstName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", password: ");
		result.append(password);
		result.append(", accountStatus: ");
		result.append(accountStatus);
		result.append(", birthYear: ");
		result.append(birthYear);
		result.append(", birthMonth: ");
		result.append(birthMonth);
		result.append(", birthDay: ");
		result.append(birthDay);
		result.append(", birthDate: ");
		result.append(birthDate);
		result.append(", gender: ");
		result.append(gender);
		result.append(", language: ");
		result.append(language);
		result.append(", currencyCode: ");
		result.append(currencyCode);
		result.append(", googlePlusId: ");
		result.append(googlePlusId);
		result.append(", googleUsername: ");
		result.append(googleUsername);
		result.append(", virtualMail: ");
		result.append(virtualMail);
		result.append(", nickname: ");
		result.append(nickname);
		result.append(", customerRole: ");
		result.append(customerRole);
		result.append(", memberRole: ");
		result.append(memberRole);
		result.append(", managerRole: ");
		result.append(managerRole);
		result.append(", timeZoneId: ");
		result.append(timeZoneId);
		result.append(", referrerId: ");
		result.append(referrerId);
		result.append(", referrerType: ");
		result.append(referrerType);
		result.append(", signupSource: ");
		result.append(signupSource);
		result.append(", signupSourceType: ");
		result.append(signupSourceType);
		result.append(", ipAddress: ");
		result.append(ipAddress);
		result.append(", lastIpAddress: ");
		result.append(lastIpAddress);
		result.append(", lastLoginTime: ");
		result.append(lastLoginTime);
		result.append(", validationTime: ");
		result.append(validationTime);
		result.append(", activationTime: ");
		result.append(activationTime);
		result.append(", verificationTime: ");
		result.append(verificationTime);
		result.append(", newsletterSubscriptionEnabled: ");
		result.append(newsletterSubscriptionEnabled);
		result.append(", newsletterSubscriptionTime: ");
		result.append(newsletterSubscriptionTime);
		result.append(", socialSharingEnabled: ");
		result.append(socialSharingEnabled);
		result.append(", publicationStatus: ");
		result.append(publicationStatus);
		result.append(", archivalStatus: ");
		result.append(archivalStatus);
		result.append(", folder: ");
		result.append(folder);
		result.append(", religion: ");
		result.append(religion);
		result.append(", passwordResetCode: ");
		result.append(passwordResetCode);
		result.append(", passwordResetExpiryTime: ");
		result.append(passwordResetExpiryTime);
		result.append(", clientAccessToken: ");
		result.append(clientAccessToken);
		result.append(", securityRoleIds: ");
		result.append(securityRoleIds);
		result.append(", debitBalance: ");
		result.append(debitBalance);
		result.append(", debitCurrency: ");
		result.append(debitCurrency);
		result.append(", type: ");
		result.append(type);
		result.append(", verifyCode: ");
		result.append(verifyCode);
		result.append(", zendeskUserId: ");
		result.append(zendeskUserId);
		result.append(", customerRoleEditTime: ");
		result.append(customerRoleEditTime);
		result.append(", lastTimeSynchronizeWithZendesk: ");
		result.append(lastTimeSynchronizeWithZendesk);
		result.append(", zendeskIntegration: ");
		result.append(zendeskIntegration);
		result.append(')');
		return result.toString();
	}


} //Person
