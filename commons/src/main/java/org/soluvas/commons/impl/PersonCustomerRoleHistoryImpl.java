package org.soluvas.commons.impl;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Email;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Organization;
import org.soluvas.commons.PersonCustomerRoleHistory;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PhoneNumber;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.PublicationStatus;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.LocalDateConverter;
import org.soluvas.commons.mongo.UnitConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPhotoId <em>Photo Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getCanonicalSlug <em>Canonical Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTwitterAccessToken <em>Twitter Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTwitterId <em>Twitter Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTwitterScreenName <em>Twitter Screen Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getFacebookUsername <em>Facebook Username</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getGuid <em>Guid</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPhoneNumbers <em>Phone Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getMobileNumbers <em>Mobile Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getAccountStatus <em>Account Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getBirthYear <em>Birth Year</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getBirthMonth <em>Birth Month</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getBirthDay <em>Birth Day</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getCurrencyCode <em>Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getCurrency <em>Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getGooglePlusId <em>Google Plus Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getGoogleUsername <em>Google Username</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getVirtualMail <em>Virtual Mail</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getNickname <em>Nickname</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getCustomerRole <em>Customer Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getMemberRole <em>Member Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getManagerRole <em>Manager Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTimeZoneId <em>Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getTimeZone <em>Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getReferrerId <em>Referrer Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getReferrerType <em>Referrer Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSignupSource <em>Signup Source</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSignupSourceType <em>Signup Source Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getIpAddress <em>Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getLastIpAddress <em>Last Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getLastLoginTime <em>Last Login Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getValidationTime <em>Validation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getActivationTime <em>Activation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getVerificationTime <em>Verification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getNewsletterSubscriptionEnabled <em>Newsletter Subscription Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getNewsletterSubscriptionTime <em>Newsletter Subscription Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSocialSharingEnabled <em>Social Sharing Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPublicationStatus <em>Publication Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getArchivalStatus <em>Archival Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getReligion <em>Religion</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPasswordResetCode <em>Password Reset Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getPasswordResetExpiryTime <em>Password Reset Expiry Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getClientAccessToken <em>Client Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getSecurityRoleIds <em>Security Role Ids</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getDebitBalance <em>Debit Balance</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getDebitCurrency <em>Debit Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getVerifyCode <em>Verify Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonCustomerRoleHistoryImpl#getOrganizations <em>Organizations</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity(noClassnameStored=true)
@Converters({BigDecimalConverter.class, DateTimeConverter.class, 
	CurrencyUnitConverter.class, UnitConverter.class, LocalDateConverter.class})
public class PersonCustomerRoleHistoryImpl extends MinimalEObjectImpl.Container implements PersonCustomerRoleHistory {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected static final String PHOTO_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhotoId() <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhotoId()
	 * @generated
	 * @ordered
	 */
	protected String photoId = PHOTO_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@Id @JsonProperty("uid")
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime MODIFICATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime modificationTime = MODIFICATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected static final String SLUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSlug() <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlug()
	 * @generated
	 * @ordered
	 */
	protected String slug = SLUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getCanonicalSlug() <em>Canonical Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanonicalSlug()
	 * @generated
	 * @ordered
	 */
	protected static final String CANONICAL_SLUG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCanonicalSlug() <em>Canonical Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCanonicalSlug()
	 * @generated
	 * @ordered
	 */
	protected String canonicalSlug = CANONICAL_SLUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterAccessToken() <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterAccessToken() <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String twitterAccessToken = TWITTER_ACCESS_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterAccessTokenSecret() <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterAccessTokenSecret() <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 * @ordered
	 */
	protected String twitterAccessTokenSecret = TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterId() <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterId()
	 * @generated
	 * @ordered
	 */
	protected static final Long TWITTER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterId() <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterId()
	 * @generated
	 * @ordered
	 */
	protected Long twitterId = TWITTER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterScreenName() <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterScreenName()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_SCREEN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterScreenName() <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterScreenName()
	 * @generated
	 * @ordered
	 */
	protected String twitterScreenName = TWITTER_SCREEN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected static final Long FACEBOOK_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected Long facebookId = FACEBOOK_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookUsername() <em>Facebook Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookUsername() <em>Facebook Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUsername()
	 * @generated
	 * @ordered
	 */
	protected String facebookUsername = FACEBOOK_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String facebookAccessToken = FACEBOOK_ACCESS_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("_id")
	protected String guid = GUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected static final String REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("_rev") @JsonInclude(Include.NON_NULL)
	protected String revision = REVISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 2L;

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;

	public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected String lastName = LAST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPhoneNumbers() <em>Phone Numbers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhoneNumbers()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<PhoneNumber> phoneNumbers;

	/**
	 * The cached value of the '{@link #getEmails() <em>Emails</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmails()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<Email> emails;

	/**
	 * The cached value of the '{@link #getMobileNumbers() <em>Mobile Numbers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobileNumbers()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<PhoneNumber> mobileNumbers;

	/**
	 * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddresses()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<PostalAddress> addresses;

	/**
	 * The default value of the '{@link #getAccountStatus() <em>Account Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountStatus()
	 * @generated
	 * @ordered
	 */
	protected static final AccountStatus ACCOUNT_STATUS_EDEFAULT = AccountStatus.DRAFT;

	/**
	 * The cached value of the '{@link #getAccountStatus() <em>Account Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccountStatus()
	 * @generated
	 * @ordered
	 */
	protected AccountStatus accountStatus = ACCOUNT_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthYear() <em>Birth Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthYear()
	 * @generated
	 * @ordered
	 */
	protected static final Integer BIRTH_YEAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthYear() <em>Birth Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthYear()
	 * @generated
	 * @ordered
	 */
	protected Integer birthYear = BIRTH_YEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthMonth() <em>Birth Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthMonth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer BIRTH_MONTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthMonth() <em>Birth Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthMonth()
	 * @generated
	 * @ordered
	 */
	protected Integer birthMonth = BIRTH_MONTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthDay() <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDay()
	 * @generated
	 * @ordered
	 */
	protected static final Integer BIRTH_DAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthDay() <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDay()
	 * @generated
	 * @ordered
	 */
	protected Integer birthDay = BIRTH_DAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected static final LocalDate BIRTH_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthDate() <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBirthDate()
	 * @generated
	 * @ordered
	 */
	protected LocalDate birthDate = BIRTH_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected static final Gender GENDER_EDEFAULT = Gender.UNKNOWN;

	/**
	 * The cached value of the '{@link #getGender() <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGender()
	 * @generated
	 * @ordered
	 */
	protected Gender gender = GENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrencyCode() <em>Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENCY_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrencyCode() <em>Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrencyCode()
	 * @generated
	 * @ordered
	 */
	protected String currencyCode = CURRENCY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrency() <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final CurrencyUnit CURRENCY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getGooglePlusId() <em>Google Plus Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGooglePlusId()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_PLUS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGooglePlusId() <em>Google Plus Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGooglePlusId()
	 * @generated
	 * @ordered
	 */
	protected String googlePlusId = GOOGLE_PLUS_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGoogleUsername() <em>Google Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String GOOGLE_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoogleUsername() <em>Google Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoogleUsername()
	 * @generated
	 * @ordered
	 */
	protected String googleUsername = GOOGLE_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVirtualMail() <em>Virtual Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualMail()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_MAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtualMail() <em>Virtual Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualMail()
	 * @generated
	 * @ordered
	 */
	protected String virtualMail = VIRTUAL_MAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNickname() <em>Nickname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNickname()
	 * @generated
	 * @ordered
	 */
	protected static final String NICKNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNickname() <em>Nickname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNickname()
	 * @generated
	 * @ordered
	 */
	protected String nickname = NICKNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomerRole() <em>Customer Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerRole()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_ROLE_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getCustomerRole() <em>Customer Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerRole()
	 * @generated
	 * @ordered
	 */
	protected String customerRole = CUSTOMER_ROLE_EDEFAULT;
	
	protected static final DateTime CUSTOMER_ROLE_EDIT_TIME_EDEFAULT = null;

	protected DateTime customerRoleEditTime = CUSTOMER_ROLE_EDIT_TIME_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getMemberRole() <em>Member Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBER_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberRole() <em>Member Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberRole()
	 * @generated
	 * @ordered
	 */
	protected String memberRole = MEMBER_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagerRole() <em>Manager Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGER_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagerRole() <em>Manager Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerRole()
	 * @generated
	 * @ordered
	 */
	protected String managerRole = MANAGER_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeZoneId() <em>Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZoneId()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_ZONE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeZoneId() <em>Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZoneId()
	 * @generated
	 * @ordered
	 */
	protected String timeZoneId = TIME_ZONE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeZone() <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZone()
	 * @generated
	 * @ordered
	 */
	protected static final DateTimeZone TIME_ZONE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getReferrerId() <em>Referrer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferrerId()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERRER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferrerId() <em>Referrer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferrerId()
	 * @generated
	 * @ordered
	 */
	protected String referrerId = REFERRER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferrerType() <em>Referrer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferrerType()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERRER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferrerType() <em>Referrer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferrerType()
	 * @generated
	 * @ordered
	 */
	protected String referrerType = REFERRER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignupSource() <em>Signup Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignupSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNUP_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignupSource() <em>Signup Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignupSource()
	 * @generated
	 * @ordered
	 */
	protected String signupSource = SIGNUP_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignupSourceType() <em>Signup Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignupSourceType()
	 * @generated
	 * @ordered
	 */
	protected static final SignupSourceType SIGNUP_SOURCE_TYPE_EDEFAULT = SignupSourceType.OTHER;

	/**
	 * The cached value of the '{@link #getSignupSourceType() <em>Signup Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignupSourceType()
	 * @generated
	 * @ordered
	 */
	protected SignupSourceType signupSourceType = SIGNUP_SOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpAddress() <em>Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpAddress() <em>Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpAddress()
	 * @generated
	 * @ordered
	 */
	protected String ipAddress = IP_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastIpAddress() <em>Last Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastIpAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_IP_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastIpAddress() <em>Last Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastIpAddress()
	 * @generated
	 * @ordered
	 */
	protected String lastIpAddress = LAST_IP_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastLoginTime() <em>Last Login Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastLoginTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime LAST_LOGIN_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastLoginTime() <em>Last Login Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastLoginTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime lastLoginTime = LAST_LOGIN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationTime() <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime VALIDATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidationTime() <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime validationTime = VALIDATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivationTime() <em>Activation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime ACTIVATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivationTime() <em>Activation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime activationTime = ACTIVATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerificationTime() <em>Verification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime VERIFICATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerificationTime() <em>Verification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime verificationTime = VERIFICATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewsletterSubscriptionEnabled() <em>Newsletter Subscription Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewsletterSubscriptionEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewsletterSubscriptionEnabled() <em>Newsletter Subscription Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewsletterSubscriptionEnabled()
	 * @generated
	 * @ordered
	 */
	protected Boolean newsletterSubscriptionEnabled = NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewsletterSubscriptionTime() <em>Newsletter Subscription Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewsletterSubscriptionTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewsletterSubscriptionTime() <em>Newsletter Subscription Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewsletterSubscriptionTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime newsletterSubscriptionTime = NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSocialSharingEnabled() <em>Social Sharing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocialSharingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SOCIAL_SHARING_ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSocialSharingEnabled() <em>Social Sharing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocialSharingEnabled()
	 * @generated
	 * @ordered
	 */
	protected Boolean socialSharingEnabled = SOCIAL_SHARING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublicationStatus() <em>Publication Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationStatus()
	 * @generated
	 * @ordered
	 */
	protected static final PublicationStatus PUBLICATION_STATUS_EDEFAULT = PublicationStatus.DRAFT;

	/**
	 * The cached value of the '{@link #getPublicationStatus() <em>Publication Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationStatus()
	 * @generated
	 * @ordered
	 */
	protected PublicationStatus publicationStatus = PUBLICATION_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getArchivalStatus() <em>Archival Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchivalStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ArchivalStatus ARCHIVAL_STATUS_EDEFAULT = ArchivalStatus.FRESH;

	/**
	 * The cached value of the '{@link #getArchivalStatus() <em>Archival Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchivalStatus()
	 * @generated
	 * @ordered
	 */
	protected ArchivalStatus archivalStatus = ARCHIVAL_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated
	 * @ordered
	 */
	protected String folder = FOLDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getReligion() <em>Religion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReligion()
	 * @generated
	 * @ordered
	 */
	protected static final String RELIGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReligion() <em>Religion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReligion()
	 * @generated
	 * @ordered
	 */
	protected String religion = RELIGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordResetCode() <em>Password Reset Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordResetCode()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_RESET_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordResetCode() <em>Password Reset Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordResetCode()
	 * @generated
	 * @ordered
	 */
	protected String passwordResetCode = PASSWORD_RESET_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordResetExpiryTime() <em>Password Reset Expiry Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordResetExpiryTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime PASSWORD_RESET_EXPIRY_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordResetExpiryTime() <em>Password Reset Expiry Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordResetExpiryTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime passwordResetExpiryTime = PASSWORD_RESET_EXPIRY_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientAccessToken() <em>Client Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientAccessToken() <em>Client Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String clientAccessToken = CLIENT_ACCESS_TOKEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSecurityRoleIds() <em>Security Role Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityRoleIds()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> securityRoleIds;

	/**
	 * The default value of the '{@link #getDebitBalance() <em>Debit Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebitBalance()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal DEBIT_BALANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebitBalance() <em>Debit Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebitBalance()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal debitBalance = DEBIT_BALANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebitCurrency() <em>Debit Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebitCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final CurrencyUnit DEBIT_CURRENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebitCurrency() <em>Debit Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebitCurrency()
	 * @generated
	 * @ordered
	 */
	protected CurrencyUnit debitCurrency = DEBIT_CURRENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "PersonCustomerRoleHistory";

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerifyCode() <em>Verify Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifyCode()
	 * @generated
	 * @ordered
	 */
	protected static final String VERIFY_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerifyCode() <em>Verify Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifyCode()
	 * @generated
	 * @ordered
	 */
	protected String verifyCode = VERIFY_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrganizations() <em>Organizations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizations()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<Organization> organizations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonCustomerRoleHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPhotoId() {
		return photoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPhotoId(String newPhotoId) {
		String oldPhotoId = photoId;
		photoId = newPhotoId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__PHOTO_ID, oldPhotoId, photoId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(DateTime newCreationTime) {
		DateTime oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModificationTime(DateTime newModificationTime) {
		DateTime oldModificationTime = modificationTime;
		modificationTime = newModificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSchemaVersion() {
		return schemaVersion;
	}

	@Override
	public String getImageId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSlug() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gender getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonInfo toInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSlug(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCanonicalSlug() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCanonicalSlug(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTwitterAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTwitterAccessToken(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTwitterAccessTokenSecret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTwitterAccessTokenSecret(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getTwitterId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTwitterId(Long value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTwitterScreenName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTwitterScreenName(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getFacebookId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFacebookId(Long value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFacebookUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFacebookUsername(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFacebookAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFacebookAccessToken(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getGuid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGuid(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRevision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRevision(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomerRole(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DateTime getCustomerRoleEditTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomerRoleEditTime(DateTime value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMemberRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemberRole(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCustomerRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstName(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastName(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getManagerRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setManagerRole(String value) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	

} //PersonImpl
