package org.soluvas.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.impl.PersonInfoImpl;

import javax.money.CurrencyUnit;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Inspired by and attempts to be compatible to {@link Person}.
 *
 * <ul>
 *  <li>usable as JPA and {@link javax.persistence.MappedSuperclass} so can be extended directly with app-specific information
 * (but not recommended, I think the best way is to have a {@link javax.persistence.SecondaryTable} extra table)</li>
 *  <li>supports both app-scoped and tenant-scoped users in one table</li>
 *  <li>supports role based access control in Spring Security and Shiro</li>
 *  <li>Liquibase YAML usable to be imported into app's {@code db.changelog-master.yaml}</li>
 *  <li>compatible with <a href="http://docs.spring.io/spring-security/site/docs/4.0.4.RELEASE/reference/htmlsingle/#appendix-schema">Spring Security's JDBC Authentication and Authorization + ACL</a> ({@link org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl} + {@code JdbcMutableAclService}) with minimal configuration</li>
 *  <li>compatible with {@link org.apache.shiro.realm.jdbc.JdbcRealm} with some configuration</li>
 *  <li>usable to be integrated with graph database such as Neo4j and distributed graph database such as Titan+Cassandra
 * and Spark GraphX processing</li>
 *  <li>usable to be used in Spring HATEOAS / JSON-LD / Hydra as {@code schema:Person}</li>
 *  <li>usable as Lumen users and can be interlinked with Lumen semantic Person entities</li>
 * </ul>
 */
@MappedSuperclass
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person2 implements Serializable {

    /**
     * For Spring Security {@link org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl#setUsersByUsernameQuery()}.
     */
    public static final String USERS_BY_USERNAME_QUERY =
            "SELECT id, password, status IN ('active', 'verified') AS enabled " +
                    "FROM public.person " +
                    "WHERE id = ?";
    // other tables + ACL tables are same. we only customize the users/person table
//    public static final String AUTHORITIES_BY_USERNAME_QUERY =
//            "select username,authority " +
//                    "from authorities " +
//                    "where username = ?";
//    public static final String GROUP_AUTHORITIES_BY_USERNAME_QUERY =
//            "select g.id, g.group_name, ga.authority " +
//                    "from groups g, group_members gm, group_authorities ga " +
//                    "where gm.username = ? " +
//                    "and g.id = ga.group_id " +
//                    "and g.id = gm.group_id";

    /**
     * Query used to retrieve account data for the user.
     */
    public static final String SHIRO_AUTHENTICATION_QUERY = "select password from public.person where id = ?";
    /**
     * Query used to retrieve the roles that apply to a user.
     */
    public static final String SHIRO_USER_ROLES_QUERY = "select securityrole_id from public.person_securityrole where person_id = ?";
    /**
     * Query used to retrieve permissions that apply to a particular role.
     */
    public static final String SHIRO_PERMISSIONS_QUERY = "select permission from public.securityrole_permission where securityrole_id = ?";

    @Id
    @JsonProperty("uid")
    protected String id;
    @Basic(optional = false)
    @Column(nullable = false)
    protected String tenantId;
    protected String name;
    protected String photoId;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime creationTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
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
    //protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;
    public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_EDEFAULT;
    protected String firstName;
    protected String lastName;
    protected String password;
    // NOTE: In Hibernate 4.x you had to specify @CollectionTable+@JoinColumn otherwise it's using incorrect foreign key column
    // Hibernate 5.x got this correctly
    @ElementCollection
    protected List<PhoneNumber2> phoneNumbers = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER) // EAGER required by toInfo()
    protected List<Email2> emails = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER) // EAGER required by toInfo()
    protected List<PhoneNumber2> mobileNumbers = new ArrayList<>();
    @ElementCollection
    protected List<PostalAddress2> addresses = new ArrayList<>();
    protected static final AccountStatus ACCOUNT_STATUS_EDEFAULT = AccountStatus.DRAFT;
    @Enumerated(EnumType.STRING)
    protected AccountStatus status = ACCOUNT_STATUS_EDEFAULT;
    protected Short birthYear;
    protected Short birthMonth;
    protected Short birthDay;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    protected LocalDate birthDate;
    protected static final Gender GENDER_EDEFAULT = Gender.UNKNOWN;
    @Enumerated(EnumType.STRING)
    protected Gender gender = GENDER_EDEFAULT;
    @Type(type = "org.soluvas.jpa.PersistentLocale")
    protected Locale language;
    @Type(type = "org.soluvas.jpa.PersistentCurrencyUnit")
    protected CurrencyUnit currency;
    protected String googlePlusId;
    protected String googleUsername;
    protected String virtualMail;
    protected String nickname;
    protected String customerRole;
    protected String memberRole;
    protected String managerRole;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeZoneAsString")
    protected DateTimeZone timeZone;
    protected String referrerId;
    protected String referrerType;
    protected String signupSource;
    @Enumerated(EnumType.STRING)
    protected SignupSourceType signupSourceType;
    @Type(type = "org.soluvas.jpa.PersistentInetAddress")
    protected InetAddress signupIpAddress;
    @Type(type = "org.soluvas.jpa.PersistentInetAddress")
    protected InetAddress lastIpAddress;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime lastLoginTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime validationTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime activationTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime verificationTime;
    protected Boolean newsletterSubscriptionEnabled;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime newsletterSubscriptionTime;
    protected Boolean socialSharingEnabled;
    @Enumerated(EnumType.STRING)
    protected PublicationStatus publicationStatus;
    @Enumerated(EnumType.STRING)
    protected ArchivalStatus archivalStatus;
    protected String folder;
    protected String religion;
    protected String passwordResetCode;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime passwordResetExpiryTime;
    protected String clientAccessToken;
    @ElementCollection(fetch = FetchType.EAGER) // EAGER required by security
    @Column(name = "securityrole_id")
    protected List<String> securityRoleIds = new ArrayList<>();
    protected BigDecimal debitBalance;
    @Type(type = "org.soluvas.jpa.PersistentCurrencyUnit")
    protected CurrencyUnit debitCurrency;
    protected String verifyCode;
    @ElementCollection
    protected List<Organization2> organizations = new ArrayList<>();

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

    public List<PhoneNumber2> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getPhoneNumber() {
        final Optional<PhoneNumber2> primaryPhone = Iterables.tryFind(getPhoneNumbers(), PhoneNumber2::getPrimary);
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

    public List<PhoneNumber2> getMobileNumbers() {
        return mobileNumbers;
    }

    @JsonProperty
    public String getMobileNumber() {
        final Optional<PhoneNumber2> primaryMobile = Iterables.tryFind(getMobileNumbers(), PhoneNumber2::getPrimary);
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

    public List<PostalAddress2> getAddresses() {
        return addresses;
    }

    @JsonIgnore
    public PostalAddress2 getPrimaryAddress() {
        if (getAddresses() != null && !getAddresses().isEmpty()) {
            final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress2::isPrimary);
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
            final Optional<PostalAddress2> primaryShippingAddress = Iterables.tryFind(getAddresses(), PostalAddress2::isPrimaryShipping);
            if (primaryShippingAddress.isPresent()) {
                return primaryShippingAddress.get();
            }

            final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress2::isPrimary);
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
            final Optional<PostalAddress2> primaryBillingAddress = Iterables.tryFind(getAddresses(), PostalAddress2::isPrimaryBilling);
            if (primaryBillingAddress.isPresent()) {
                return primaryBillingAddress.get();
            }

            final Optional<PostalAddress2> primaryAddress = Iterables.tryFind(getAddresses(), PostalAddress2::isPrimary);
            if (primaryAddress.isPresent()) {
                return primaryAddress.get();
            } else {
                return getAddresses().get(0);
            }
        } else {
            return null;
        }
    }

    public List<Email2> getEmails() {
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
    public Email2 putEmail(String email) {
        if (email == null) {
            return null;
        }
        final String normalized = NameUtils.normalizeEmail(email);
        final Optional<Email2> found = Iterables.tryFind(getEmails(), input -> normalized.equals(input.getEmail()));
        if (found.isPresent()) {
            return found.get();
        } else {
            final Email2 newEmail = new Email2(normalized, getEmails().isEmpty());
            getEmails().add(newEmail);
            return newEmail;
        }
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

    /**
     * BCrypt-encoded password.
     * For Spring Security, use {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder}.
     * For Shiro, use {@link org.soluvas.security.shiro.BCryptPasswordService}.
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
    }

    public Short getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Short birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Short getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Short birthDay) {
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

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public CurrencyUnit getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyUnit currency) {
        this.currency = currency;
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

    public DateTimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(DateTimeZone timeZone) {
        this.timeZone = timeZone;
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

    public InetAddress getSignupIpAddress() {
        return signupIpAddress;
    }

    public void setSignupIpAddress(InetAddress signupIpAddress) {
        this.signupIpAddress = signupIpAddress;
    }

    public InetAddress getLastIpAddress() {
        return lastIpAddress;
    }

    public void setLastIpAddress(InetAddress lastIpAddress) {
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

    /**
     * To make it compatible with Spring's JdbcDaoImpl and Shiro's JdbcRealm,
     * securityRoleIds is mapped using {@link ElementCollection} instead of {@code varchar[]}.
     * @return
     */
    @CollectionTable(name = "person_securityrole")
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

    public List<Organization2> getOrganizations() {
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
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("password", password)
                .add("phoneNumbers", phoneNumbers)
                .add("emails", emails)
                .add("mobileNumbers", mobileNumbers)
                .add("addresses", addresses)
                .add("accountStatus", status)
                .add("birthYear", birthYear)
                .add("birthMonth", birthMonth)
                .add("birthDay", birthDay)
                .add("birthDate", birthDate)
                .add("gender", gender)
                .add("language", language)
                .add("currencyCode", currency)
                .add("googlePlusId", googlePlusId)
                .add("googleUsername", googleUsername)
                .add("virtualMail", virtualMail)
                .add("nickname", nickname)
                .add("customerRole", customerRole)
                .add("memberRole", memberRole)
                .add("managerRole", managerRole)
                .add("timeZone", timeZone)
                .add("referrerId", referrerId)
                .add("referrerType", referrerType)
                .add("signupSource", signupSource)
                .add("signupSourceType", signupSourceType)
                .add("ipAddress", signupIpAddress)
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

    public PersonInfo toInfo() {
        return ((Function<Person2, PersonInfo>)((Person2 input) -> {
            if (input == null)
                return null;
            final PersonInfo personInfo = new PersonInfoImpl();
            personInfo.setId(input.getId());
            personInfo.setSlug(input.getSlug());
            personInfo.setName(input.getName());
            personInfo.setPhotoId(input.getPhotoId());
            personInfo.setGender(input.getGender());
            personInfo.setEmail(input.getEmail());
            personInfo.setMobileNumber(input.getMobileNumber());
            return personInfo;
        })).apply(this);
    }

    @PrePersist
    public void prePersist() {
        if (null == getCreationTime()) {
            setCreationTime(new DateTime());
        }
        if (null == getModificationTime()) {
            setModificationTime(getCreationTime());
        }
    }
}
