package org.soluvas.jpa.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.*;
import org.soluvas.commons.Describable;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.impl.EmailImpl;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Inspired by and attempts to be compatible to {@link Person},
 * usable as JPA and {@link javax.persistence.MappedSuperclass} so can be extended directly with app-specific information
 * (but not recommended, I think the best way is to have a {@link javax.persistence.OneToOne} extra table),
 * supports both app-scoped and tenant-scoped users in one table,
 * supports role based access control,
 * Liquibase YAML usable to be copied into app's {@code db.changelog-master.yaml},
 * and compatible with Spring Security's JDBC Authentication and Authorization with minimal configuration,
 * usable to be integrated with graph database such as Neo4j and distributed graph database such as Titan+Cassandra
 * and Spark GraphX processing,
 * usable to be used in Spring HATEOAS / JSON-LD / Hydra as {@code schema:Person},
 * usable as Lumen users and can be interlinked with Lumen semantic Person entities.
 *
 * @generated
 */
@MappedSuperclass
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person2 implements Serializable {
    @Id
    @JsonProperty("uid")
    protected String id;
    @Basic(optional = false)
    @Column(nullable = false)
    protected String tenantId;
    protected String name;
    protected String photoId;
    protected DateTime creationTime;
    protected DateTime modificationTime;
    protected String description;
    protected String slug;
    protected String canonicalSlug;
    protected String twitterAccessToken;
    protected String twitterAccessTokenSecret;
    protected Long twitterId;
    protected String twitterScreenName;
    protected Long facebookId;
    protected String facebookUsername;
    protected String facebookAccessToken;
//    @JsonProperty("_id")
//    protected String guid;
//    @JsonProperty("_rev")
//    @JsonInclude(Include.NON_NULL)
//    protected String revision;

    protected static final long SCHEMA_VERSION_EDEFAULT = 2L;
    protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;
    public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_EDEFAULT;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected List<PhoneNumber> phoneNumbers = new ArrayList<>();
    protected List<Email> emails = new ArrayList<>();
    protected List<PhoneNumber> mobileNumbers = new ArrayList<>();
    protected List<PostalAddress> addresses = new ArrayList<>();
    protected static final AccountStatus ACCOUNT_STATUS_EDEFAULT = AccountStatus.DRAFT;
    protected AccountStatus accountStatus = ACCOUNT_STATUS_EDEFAULT;
    protected Integer birthYear;
    protected Integer birthMonth;
    protected Integer birthDay;
    protected LocalDate birthDate;
    protected static final Gender GENDER_EDEFAULT = Gender.UNKNOWN;
    protected Gender gender = GENDER_EDEFAULT;
    protected String language;
    protected String currencyCode;
    protected String googlePlusId;
    protected String googleUsername;
    protected String virtualMail;
    protected String nickname;
    protected String customerRole;
    protected String memberRole;
    protected String managerRole;
    protected String timeZoneId;
    protected String referrerId;
    protected String referrerType;
    protected String signupSource;
    protected SignupSourceType signupSourceType;
    protected String ipAddress;
    protected String lastIpAddress;
    protected DateTime lastLoginTime;
    protected DateTime validationTime;
    protected DateTime activationTime;
    protected DateTime verificationTime;
    protected Boolean newsletterSubscriptionEnabled;
    protected DateTime newsletterSubscriptionTime;
    protected Boolean socialSharingEnabled;
    protected PublicationStatus publicationStatus;
    protected ArchivalStatus archivalStatus;
    protected String folder;
    protected String religion;
    protected String passwordResetCode;
    protected DateTime passwordResetExpiryTime;
    protected String clientAccessToken;
    protected List<String> securityRoleIds = new ArrayList<>();
    protected BigDecimal debitBalance;
    protected CurrencyUnit debitCurrency;
    protected String verifyCode;
    protected List<Organization> organizations = new ArrayList<>();

    public Person2() {
        super();
    }

    /**
     * This will be {@code lowercased_slug "@" tenantId}, so multiple people with same ID from different tenants
     * will not clash.
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Cannot be {@code null}. Supports app-scoped user by using {@code tenantId=""}.
     * @return
     */
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getPhoneNumber() {
        final Optional<PhoneNumber> primaryPhone = Iterables.tryFind(getPhoneNumbers(), PhoneNumber::isPrimary);
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
        // serialization only, no deserialization
        throw new UnsupportedOperationException();
    }

    public List<PhoneNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    @JsonProperty
    public String getMobileNumber() {
        final Optional<PhoneNumber> primaryMobile = Iterables.tryFind(getMobileNumbers(), PhoneNumber::isPrimary);
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
        // serialization only, no deserialization
        throw new UnsupportedOperationException();
    }

    public List<PostalAddress> getAddresses() {
        return addresses;
    }

    @JsonIgnore
    public PostalAddress getPrimaryAddress() {
        if (getAddresses() != null && !getAddresses().isEmpty()) {
            final Optional<PostalAddress> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress::isPrimary);
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
    public PostalAddress getPrimaryShippingAddress() {
        if (getAddresses() != null && !getAddresses().isEmpty()) {
            final Optional<PostalAddress> primaryShippingAddress = Iterables.tryFind(getAddresses(), PostalAddress::isPrimaryShipping);
            if (primaryShippingAddress.isPresent()) {
                return primaryShippingAddress.get();
            }

            final Optional<PostalAddress> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress::isPrimary);
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
    public PostalAddress getPrimaryBillingAddress() {
        if (getAddresses() != null && !getAddresses().isEmpty()) {
            final Optional<PostalAddress> primaryBillingAddress = Iterables.tryFind(getAddresses(), PostalAddress::isPrimaryBilling);
            if (primaryBillingAddress.isPresent()) {
                return primaryBillingAddress.get();
            }

            final Optional<PostalAddress> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress::isPrimary);
            if (primaryAddress.isPresent()) {
                return primaryAddress.get();
            } else {
                return getAddresses().get(0);
            }
        } else {
            return null;
        }
    }

    public List<Email> getEmails() {
        return emails;
    }

    public boolean hasEmail(String email) {
        if (email == null) {
            return false;
        }
        final String toFind = NameUtils.normalizeEmail(email);
        return Iterables.any(getEmails(), input -> toFind.equals(input.getEmail()));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public Email putEmail(String email) {
        if (email == null) {
            return null;
        }
        final String normalized = NameUtils.normalizeEmail(email);
        final Optional<Email> found = Iterables.tryFind(getEmails(), input -> normalized.equals(input.getEmail()));
        if (found.isPresent()) {
            return found.get();
        } else {
            final Email newEmail = new EmailImpl(normalized, getEmails().isEmpty());
            getEmails().add(newEmail);
            return newEmail;
        }
    }

    @JsonProperty
    public String getEmail() {
        final Optional<Email> primaryEmail = Iterables.tryFind(getEmails(), Email::isPrimary);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public DateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(DateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCanonicalSlug() {
        return canonicalSlug;
    }

    public void setCanonicalSlug(String canonicalSlug) {
        this.canonicalSlug = canonicalSlug;
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

    public Long getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(Long twitterId) {
        this.twitterId = twitterId;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public Long getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(Long facebookId) {
        this.facebookId = facebookId;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookAccessToken() {
        return facebookAccessToken;
    }

    public void setFacebookAccessToken(String facebookAccessToken) {
        this.facebookAccessToken = facebookAccessToken;
    }

    public long getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(long schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getGooglePlusId() {
        return googlePlusId;
    }

    public void setGooglePlusId(String googlePlusId) {
        this.googlePlusId = googlePlusId;
    }

    public String getGoogleUsername() {
        return googleUsername;
    }

    public void setGoogleUsername(String googleUsername) {
        this.googleUsername = googleUsername;
    }

    public String getVirtualMail() {
        return virtualMail;
    }

    public void setVirtualMail(String virtualMail) {
        this.virtualMail = virtualMail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(String managerRole) {
        this.managerRole = managerRole;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public String getReferrerType() {
        return referrerType;
    }

    public void setReferrerType(String referrerType) {
        this.referrerType = referrerType;
    }

    public String getSignupSource() {
        return signupSource;
    }

    public void setSignupSource(String signupSource) {
        this.signupSource = signupSource;
    }

    public SignupSourceType getSignupSourceType() {
        return signupSourceType;
    }

    public void setSignupSourceType(SignupSourceType signupSourceType) {
        this.signupSourceType = signupSourceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLastIpAddress() {
        return lastIpAddress;
    }

    public void setLastIpAddress(String lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }

    public DateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(DateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public DateTime getValidationTime() {
        return validationTime;
    }

    public void setValidationTime(DateTime validationTime) {
        this.validationTime = validationTime;
    }

    public DateTime getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(DateTime activationTime) {
        this.activationTime = activationTime;
    }

    public DateTime getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(DateTime verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Boolean getNewsletterSubscriptionEnabled() {
        return newsletterSubscriptionEnabled;
    }

    public void setNewsletterSubscriptionEnabled(Boolean newsletterSubscriptionEnabled) {
        this.newsletterSubscriptionEnabled = newsletterSubscriptionEnabled;
    }

    public DateTime getNewsletterSubscriptionTime() {
        return newsletterSubscriptionTime;
    }

    public void setNewsletterSubscriptionTime(DateTime newsletterSubscriptionTime) {
        this.newsletterSubscriptionTime = newsletterSubscriptionTime;
    }

    public Boolean getSocialSharingEnabled() {
        return socialSharingEnabled;
    }

    public void setSocialSharingEnabled(Boolean socialSharingEnabled) {
        this.socialSharingEnabled = socialSharingEnabled;
    }

    public PublicationStatus getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(PublicationStatus publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public ArchivalStatus getArchivalStatus() {
        return archivalStatus;
    }

    public void setArchivalStatus(ArchivalStatus archivalStatus) {
        this.archivalStatus = archivalStatus;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode) {
        this.passwordResetCode = passwordResetCode;
    }

    public DateTime getPasswordResetExpiryTime() {
        return passwordResetExpiryTime;
    }

    public void setPasswordResetExpiryTime(DateTime passwordResetExpiryTime) {
        this.passwordResetExpiryTime = passwordResetExpiryTime;
    }

    public String getClientAccessToken() {
        return clientAccessToken;
    }

    public void setClientAccessToken(String clientAccessToken) {
        this.clientAccessToken = clientAccessToken;
    }

    public List<String> getSecurityRoleIds() {
        return securityRoleIds;
    }

    public BigDecimal getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(BigDecimal debitBalance) {
        this.debitBalance = debitBalance;
    }

    public CurrencyUnit getDebitCurrency() {
        return debitCurrency;
    }

    public void setDebitCurrency(CurrencyUnit debitCurrency) {
        this.debitCurrency = debitCurrency;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("name", name)
                .add("photoId", photoId)
                .add("id", id)
                .add("creationTime", creationTime)
                .add("modificationTime", modificationTime)
                .add("description", description)
                .add("slug", slug)
                .add("canonicalSlug", canonicalSlug)
                .add("twitterAccessToken", twitterAccessToken)
                .add("twitterAccessTokenSecret", twitterAccessTokenSecret)
                .add("twitterId", twitterId)
                .add("twitterScreenName", twitterScreenName)
                .add("facebookId", facebookId)
                .add("facebookUsername", facebookUsername)
                .add("facebookAccessToken", facebookAccessToken)
                .add("schemaVersion", schemaVersion)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("password", password)
                .add("phoneNumbers", phoneNumbers)
                .add("emails", emails)
                .add("mobileNumbers", mobileNumbers)
                .add("addresses", addresses)
                .add("accountStatus", accountStatus)
                .add("birthYear", birthYear)
                .add("birthMonth", birthMonth)
                .add("birthDay", birthDay)
                .add("birthDate", birthDate)
                .add("gender", gender)
                .add("language", language)
                .add("currencyCode", currencyCode)
                .add("googlePlusId", googlePlusId)
                .add("googleUsername", googleUsername)
                .add("virtualMail", virtualMail)
                .add("nickname", nickname)
                .add("customerRole", customerRole)
                .add("memberRole", memberRole)
                .add("managerRole", managerRole)
                .add("timeZoneId", timeZoneId)
                .add("referrerId", referrerId)
                .add("referrerType", referrerType)
                .add("signupSource", signupSource)
                .add("signupSourceType", signupSourceType)
                .add("ipAddress", ipAddress)
                .add("lastIpAddress", lastIpAddress)
                .add("lastLoginTime", lastLoginTime)
                .add("validationTime", validationTime)
                .add("activationTime", activationTime)
                .add("verificationTime", verificationTime)
                .add("newsletterSubscriptionEnabled", newsletterSubscriptionEnabled)
                .add("newsletterSubscriptionTime", newsletterSubscriptionTime)
                .add("socialSharingEnabled", socialSharingEnabled)
                .add("publicationStatus", publicationStatus)
                .add("archivalStatus", archivalStatus)
                .add("folder", folder)
                .add("religion", religion)
                .add("passwordResetCode", passwordResetCode)
                .add("passwordResetExpiryTime", passwordResetExpiryTime)
                .add("clientAccessToken", clientAccessToken)
                .add("securityRoleIds", securityRoleIds)
                .add("debitBalance", debitBalance)
                .add("debitCurrency", debitCurrency)
                .add("verifyCode", verifyCode)
                .add("organizations", organizations)
                .toString();
    }
}
