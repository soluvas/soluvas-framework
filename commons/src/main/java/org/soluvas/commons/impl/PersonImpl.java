package org.soluvas.commons.impl;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.CanonicalSluggable;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Email;
import org.soluvas.commons.FacebookAccessible;
import org.soluvas.commons.FacebookIdentity;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.Informer;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PersonLike;
import org.soluvas.commons.PhoneNumber;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.PublicationStatus;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.Sluggable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.TwitterAccessible;
import org.soluvas.commons.TwitterIdentity;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.UnitConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPhotoId <em>Photo Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSlug <em>Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getCanonicalSlug <em>Canonical Slug</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTwitterAccessToken <em>Twitter Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTwitterId <em>Twitter Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTwitterScreenName <em>Twitter Screen Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getFacebookUsername <em>Facebook Username</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPhoneNumbers <em>Phone Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getMobileNumbers <em>Mobile Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getAccountStatus <em>Account Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getBirthYear <em>Birth Year</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getBirthMonth <em>Birth Month</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getBirthDay <em>Birth Day</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getCurrencyCode <em>Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getCurrency <em>Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getGooglePlusId <em>Google Plus Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getGoogleUsername <em>Google Username</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getVirtualMail <em>Virtual Mail</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getNickname <em>Nickname</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getCustomerRole <em>Customer Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getMemberRole <em>Member Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getManagerRole <em>Manager Role</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTimeZoneId <em>Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getTimeZone <em>Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getReferrerId <em>Referrer Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getReferrerType <em>Referrer Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSignupSource <em>Signup Source</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSignupSourceType <em>Signup Source Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getIpAddress <em>Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getLastIpAddress <em>Last Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getLastLoginTime <em>Last Login Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getValidationTime <em>Validation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getActivationTime <em>Activation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getVerificationTime <em>Verification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getNewsletterSubscriptionEnabled <em>Newsletter Subscription Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getNewsletterSubscriptionTime <em>Newsletter Subscription Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSocialSharingEnabled <em>Social Sharing Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPublicationStatus <em>Publication Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getArchivalStatus <em>Archival Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getReligion <em>Religion</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPasswordResetCode <em>Password Reset Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getPasswordResetExpiryTime <em>Password Reset Expiry Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getClientAccessToken <em>Client Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PersonImpl#getSecurityRoleIds <em>Security Role Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@Entity(noClassnameStored=true)
@Converters({BigDecimalConverter.class, DateTimeConverter.class,
	CurrencyUnitConverter.class, UnitConverter.class})
public class PersonImpl extends EObjectImpl implements Person {
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
	@Id
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
	protected EList<PhoneNumber> phoneNumbers;

	/**
	 * The cached value of the '{@link #getEmails() <em>Emails</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmails()
	 * @generated
	 * @ordered
	 */
	protected EList<Email> emails;

	/**
	 * The cached value of the '{@link #getMobileNumbers() <em>Mobile Numbers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobileNumbers()
	 * @generated
	 * @ordered
	 */
	protected EList<PhoneNumber> mobileNumbers;

	/**
	 * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddresses()
	 * @generated
	 * @ordered
	 */
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
	protected EList<String> securityRoleIds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonImpl() {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastName(String newLastName) {
		String oldLastName = lastName;
		lastName = newLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__LAST_NAME, oldLastName, lastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PhoneNumber> getPhoneNumbers() {
		if (phoneNumbers == null) {
			phoneNumbers = new EObjectContainmentEList<PhoneNumber>(PhoneNumber.class, this, CommonsPackage.PERSON__PHONE_NUMBERS);
		}
		return phoneNumbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Email> getEmails() {
		if (emails == null) {
			emails = new EObjectContainmentEList<Email>(Email.class, this, CommonsPackage.PERSON__EMAILS);
		}
		return emails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PhoneNumber> getMobileNumbers() {
		if (mobileNumbers == null) {
			mobileNumbers = new EObjectContainmentEList<PhoneNumber>(PhoneNumber.class, this, CommonsPackage.PERSON__MOBILE_NUMBERS);
		}
		return mobileNumbers;
	}
	
	@Override
	public String getMobileNumber() {
		final Optional<PhoneNumber> primaryMobile = Iterables.tryFind(getMobileNumbers(), new Predicate<PhoneNumber>() {
			@Override
			public boolean apply(@Nullable PhoneNumber input) {
				return input.isPrimary();
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PostalAddress> getAddresses() {
		if (addresses == null) {
			addresses = new EObjectContainmentEList<PostalAddress>(PostalAddress.class, this, CommonsPackage.PERSON__ADDRESSES);
		}
		return addresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccountStatus(AccountStatus newAccountStatus) {
		AccountStatus oldAccountStatus = accountStatus;
		accountStatus = newAccountStatus == null ? ACCOUNT_STATUS_EDEFAULT : newAccountStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__ACCOUNT_STATUS, oldAccountStatus, accountStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getBirthYear() {
		return birthYear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBirthYear(Integer newBirthYear) {
		Integer oldBirthYear = birthYear;
		birthYear = newBirthYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__BIRTH_YEAR, oldBirthYear, birthYear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getBirthMonth() {
		return birthMonth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBirthMonth(Integer newBirthMonth) {
		Integer oldBirthMonth = birthMonth;
		birthMonth = newBirthMonth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__BIRTH_MONTH, oldBirthMonth, birthMonth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getBirthDay() {
		return birthDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBirthDay(Integer newBirthDay) {
		Integer oldBirthDay = birthDay;
		birthDay = newBirthDay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__BIRTH_DAY, oldBirthDay, birthDay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBirthDate(LocalDate newBirthDate) {
		LocalDate oldBirthDate = birthDate;
		birthDate = newBirthDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__BIRTH_DATE, oldBirthDate, birthDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gender getGender() {
		return gender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGender(Gender newGender) {
		Gender oldGender = gender;
		gender = newGender == null ? GENDER_EDEFAULT : newGender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__GENDER, oldGender, gender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrencyCode(String newCurrencyCode) {
		String oldCurrencyCode = currencyCode;
		currencyCode = newCurrencyCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__CURRENCY_CODE, oldCurrencyCode, currencyCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public CurrencyUnit getCurrency() {
		return currencyCode != null ? CurrencyUnit.of(currencyCode) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setCurrency(CurrencyUnit newCurrency) {
		setCurrencyCode(newCurrency != null ? newCurrency.getCode() : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getFacebookId() {
		return facebookId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookId(Long newFacebookId) {
		Long oldFacebookId = facebookId;
		facebookId = newFacebookId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__FACEBOOK_ID, oldFacebookId, facebookId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookUsername() {
		return facebookUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookUsername(String newFacebookUsername) {
		String oldFacebookUsername = facebookUsername;
		facebookUsername = newFacebookUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__FACEBOOK_USERNAME, oldFacebookUsername, facebookUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookAccessToken(String newFacebookAccessToken) {
		String oldFacebookAccessToken = facebookAccessToken;
		facebookAccessToken = newFacebookAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN, oldFacebookAccessToken, facebookAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getTwitterId() {
		return twitterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterId(Long newTwitterId) {
		Long oldTwitterId = twitterId;
		twitterId = newTwitterId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__TWITTER_ID, oldTwitterId, twitterId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterScreenName(String newTwitterScreenName) {
		String oldTwitterScreenName = twitterScreenName;
		twitterScreenName = newTwitterScreenName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__TWITTER_SCREEN_NAME, oldTwitterScreenName, twitterScreenName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterAccessToken(String newTwitterAccessToken) {
		String oldTwitterAccessToken = twitterAccessToken;
		twitterAccessToken = newTwitterAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN, oldTwitterAccessToken, twitterAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterAccessTokenSecret() {
		return twitterAccessTokenSecret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterAccessTokenSecret(String newTwitterAccessTokenSecret) {
		String oldTwitterAccessTokenSecret = twitterAccessTokenSecret;
		twitterAccessTokenSecret = newTwitterAccessTokenSecret;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET, oldTwitterAccessTokenSecret, twitterAccessTokenSecret));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGooglePlusId() {
		return googlePlusId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGooglePlusId(String newGooglePlusId) {
		String oldGooglePlusId = googlePlusId;
		googlePlusId = newGooglePlusId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__GOOGLE_PLUS_ID, oldGooglePlusId, googlePlusId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGoogleUsername() {
		return googleUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGoogleUsername(String newGoogleUsername) {
		String oldGoogleUsername = googleUsername;
		googleUsername = newGoogleUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__GOOGLE_USERNAME, oldGoogleUsername, googleUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVirtualMail() {
		return virtualMail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVirtualMail(String newVirtualMail) {
		String oldVirtualMail = virtualMail;
		virtualMail = newVirtualMail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__VIRTUAL_MAIL, oldVirtualMail, virtualMail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNickname() {
		return nickname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNickname(String newNickname) {
		String oldNickname = nickname;
		nickname = newNickname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__NICKNAME, oldNickname, nickname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCustomerRole() {
		return customerRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCustomerRole(String newCustomerRole) {
		String oldCustomerRole = customerRole;
		customerRole = newCustomerRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__CUSTOMER_ROLE, oldCustomerRole, customerRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMemberRole() {
		return memberRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMemberRole(String newMemberRole) {
		String oldMemberRole = memberRole;
		memberRole = newMemberRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__MEMBER_ROLE, oldMemberRole, memberRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getManagerRole() {
		return managerRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setManagerRole(String newManagerRole) {
		String oldManagerRole = managerRole;
		managerRole = newManagerRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__MANAGER_ROLE, oldManagerRole, managerRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeZoneId(String newTimeZoneId) {
		String oldTimeZoneId = timeZoneId;
		timeZoneId = newTimeZoneId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__TIME_ZONE_ID, oldTimeZoneId, timeZoneId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public DateTimeZone getTimeZone() {
		return timeZoneId != null ? DateTimeZone.forID(timeZoneId) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setTimeZone(DateTimeZone newTimeZone) {
		setTimeZoneId(newTimeZone != null ? newTimeZone.getID() : null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferrerId() {
		return referrerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferrerId(String newReferrerId) {
		String oldReferrerId = referrerId;
		referrerId = newReferrerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__REFERRER_ID, oldReferrerId, referrerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReferrerType() {
		return referrerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferrerType(String newReferrerType) {
		String oldReferrerType = referrerType;
		referrerType = newReferrerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__REFERRER_TYPE, oldReferrerType, referrerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSignupSource() {
		return signupSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSignupSource(String newSignupSource) {
		String oldSignupSource = signupSource;
		signupSource = newSignupSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__SIGNUP_SOURCE, oldSignupSource, signupSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SignupSourceType getSignupSourceType() {
		return signupSourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSignupSourceType(SignupSourceType newSignupSourceType) {
		SignupSourceType oldSignupSourceType = signupSourceType;
		signupSourceType = newSignupSourceType == null ? SIGNUP_SOURCE_TYPE_EDEFAULT : newSignupSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE, oldSignupSourceType, signupSourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIpAddress(String newIpAddress) {
		String oldIpAddress = ipAddress;
		ipAddress = newIpAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__IP_ADDRESS, oldIpAddress, ipAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastIpAddress() {
		return lastIpAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastIpAddress(String newLastIpAddress) {
		String oldLastIpAddress = lastIpAddress;
		lastIpAddress = newLastIpAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__LAST_IP_ADDRESS, oldLastIpAddress, lastIpAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastLoginTime(DateTime newLastLoginTime) {
		DateTime oldLastLoginTime = lastLoginTime;
		lastLoginTime = newLastLoginTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__LAST_LOGIN_TIME, oldLastLoginTime, lastLoginTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getValidationTime() {
		return validationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationTime(DateTime newValidationTime) {
		DateTime oldValidationTime = validationTime;
		validationTime = newValidationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__VALIDATION_TIME, oldValidationTime, validationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getActivationTime() {
		return activationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActivationTime(DateTime newActivationTime) {
		DateTime oldActivationTime = activationTime;
		activationTime = newActivationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__ACTIVATION_TIME, oldActivationTime, activationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getVerificationTime() {
		return verificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerificationTime(DateTime newVerificationTime) {
		DateTime oldVerificationTime = verificationTime;
		verificationTime = newVerificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__VERIFICATION_TIME, oldVerificationTime, verificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getNewsletterSubscriptionEnabled() {
		return newsletterSubscriptionEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNewsletterSubscriptionEnabled(Boolean newNewsletterSubscriptionEnabled) {
		Boolean oldNewsletterSubscriptionEnabled = newsletterSubscriptionEnabled;
		newsletterSubscriptionEnabled = newNewsletterSubscriptionEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED, oldNewsletterSubscriptionEnabled, newsletterSubscriptionEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getNewsletterSubscriptionTime() {
		return newsletterSubscriptionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNewsletterSubscriptionTime(DateTime newNewsletterSubscriptionTime) {
		DateTime oldNewsletterSubscriptionTime = newsletterSubscriptionTime;
		newsletterSubscriptionTime = newNewsletterSubscriptionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME, oldNewsletterSubscriptionTime, newsletterSubscriptionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getSocialSharingEnabled() {
		return socialSharingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSocialSharingEnabled(Boolean newSocialSharingEnabled) {
		Boolean oldSocialSharingEnabled = socialSharingEnabled;
		socialSharingEnabled = newSocialSharingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED, oldSocialSharingEnabled, socialSharingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PublicationStatus getPublicationStatus() {
		return publicationStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublicationStatus(PublicationStatus newPublicationStatus) {
		PublicationStatus oldPublicationStatus = publicationStatus;
		publicationStatus = newPublicationStatus == null ? PUBLICATION_STATUS_EDEFAULT : newPublicationStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__PUBLICATION_STATUS, oldPublicationStatus, publicationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArchivalStatus getArchivalStatus() {
		return archivalStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArchivalStatus(ArchivalStatus newArchivalStatus) {
		ArchivalStatus oldArchivalStatus = archivalStatus;
		archivalStatus = newArchivalStatus == null ? ARCHIVAL_STATUS_EDEFAULT : newArchivalStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__ARCHIVAL_STATUS, oldArchivalStatus, archivalStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFolder() {
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFolder(String newFolder) {
		String oldFolder = folder;
		folder = newFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__FOLDER, oldFolder, folder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReligion() {
		return religion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReligion(String newReligion) {
		String oldReligion = religion;
		religion = newReligion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__RELIGION, oldReligion, religion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPasswordResetCode() {
		return passwordResetCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPasswordResetCode(String newPasswordResetCode) {
		String oldPasswordResetCode = passwordResetCode;
		passwordResetCode = newPasswordResetCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__PASSWORD_RESET_CODE, oldPasswordResetCode, passwordResetCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getPasswordResetExpiryTime() {
		return passwordResetExpiryTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPasswordResetExpiryTime(DateTime newPasswordResetExpiryTime) {
		DateTime oldPasswordResetExpiryTime = passwordResetExpiryTime;
		passwordResetExpiryTime = newPasswordResetExpiryTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME, oldPasswordResetExpiryTime, passwordResetExpiryTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientAccessToken() {
		return clientAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientAccessToken(String newClientAccessToken) {
		String oldClientAccessToken = clientAccessToken;
		clientAccessToken = newClientAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN, oldClientAccessToken, clientAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getSecurityRoleIds() {
		if (securityRoleIds == null) {
			securityRoleIds = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.PERSON__SECURITY_ROLE_IDS);
		}
		return securityRoleIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean hasEmail(String email) {
		if (email == null) {
			return false;
		}
		final String toFind = NameUtils.normalizeEmail(email);
		return Iterables.any(getEmails(), new Predicate<Email>() {
			@Override
			public boolean apply(@Nullable Email input) {
				return toFind.equals(input.getEmail());
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Email putEmail(String email) {
		if (email == null) {
			return null;
		}
		final String normalized = NameUtils.normalizeEmail(email);
		final Optional<Email> found = Iterables.tryFind(getEmails(), new Predicate<Email>() {
			@Override
			public boolean apply(@Nullable Email input) {
				return normalized.equals(input.getEmail());
			}
		});
		if (found.isPresent()) {
			return found.get();
		} else {
			final Email newEmail = new EmailImpl(normalized, getEmails().isEmpty());
			getEmails().add(newEmail);
			return newEmail;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public PersonInfo toInfo() {
		return new ToPersonInfo().apply(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSlug() {
		return slug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlug(String newSlug) {
		String oldSlug = slug;
		slug = newSlug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__SLUG, oldSlug, slug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCanonicalSlug() {
		return canonicalSlug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanonicalSlug(String newCanonicalSlug) {
		String oldCanonicalSlug = canonicalSlug;
		canonicalSlug = newCanonicalSlug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PERSON__CANONICAL_SLUG, oldCanonicalSlug, canonicalSlug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getEmail() {
		final Optional<Email> primaryEmail = Iterables.tryFind(getEmails(), new Predicate<Email>() {
			@Override
			public boolean apply(@Nullable Email input) {
				return input.isPrimary();
			}
		});
		if (primaryEmail.isPresent()) {
			return primaryEmail.get().getEmail();
		} else if (!getEmails().isEmpty()) {
			return getEmails().get(0).getEmail();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getImageId() {
		return photoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonsPackage.PERSON__PHONE_NUMBERS:
				return ((InternalEList<?>)getPhoneNumbers()).basicRemove(otherEnd, msgs);
			case CommonsPackage.PERSON__EMAILS:
				return ((InternalEList<?>)getEmails()).basicRemove(otherEnd, msgs);
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
				return ((InternalEList<?>)getMobileNumbers()).basicRemove(otherEnd, msgs);
			case CommonsPackage.PERSON__ADDRESSES:
				return ((InternalEList<?>)getAddresses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PERSON__NAME:
				return getName();
			case CommonsPackage.PERSON__PHOTO_ID:
				return getPhotoId();
			case CommonsPackage.PERSON__ID:
				return getId();
			case CommonsPackage.PERSON__CREATION_TIME:
				return getCreationTime();
			case CommonsPackage.PERSON__MODIFICATION_TIME:
				return getModificationTime();
			case CommonsPackage.PERSON__DESCRIPTION:
				return getDescription();
			case CommonsPackage.PERSON__SLUG:
				return getSlug();
			case CommonsPackage.PERSON__CANONICAL_SLUG:
				return getCanonicalSlug();
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN:
				return getTwitterAccessToken();
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET:
				return getTwitterAccessTokenSecret();
			case CommonsPackage.PERSON__TWITTER_ID:
				return getTwitterId();
			case CommonsPackage.PERSON__TWITTER_SCREEN_NAME:
				return getTwitterScreenName();
			case CommonsPackage.PERSON__FACEBOOK_ID:
				return getFacebookId();
			case CommonsPackage.PERSON__FACEBOOK_USERNAME:
				return getFacebookUsername();
			case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN:
				return getFacebookAccessToken();
			case CommonsPackage.PERSON__SCHEMA_VERSION:
				return getSchemaVersion();
			case CommonsPackage.PERSON__FIRST_NAME:
				return getFirstName();
			case CommonsPackage.PERSON__LAST_NAME:
				return getLastName();
			case CommonsPackage.PERSON__PASSWORD:
				return getPassword();
			case CommonsPackage.PERSON__PHONE_NUMBERS:
				return getPhoneNumbers();
			case CommonsPackage.PERSON__EMAILS:
				return getEmails();
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
				return getMobileNumbers();
			case CommonsPackage.PERSON__ADDRESSES:
				return getAddresses();
			case CommonsPackage.PERSON__ACCOUNT_STATUS:
				return getAccountStatus();
			case CommonsPackage.PERSON__BIRTH_YEAR:
				return getBirthYear();
			case CommonsPackage.PERSON__BIRTH_MONTH:
				return getBirthMonth();
			case CommonsPackage.PERSON__BIRTH_DAY:
				return getBirthDay();
			case CommonsPackage.PERSON__BIRTH_DATE:
				return getBirthDate();
			case CommonsPackage.PERSON__GENDER:
				return getGender();
			case CommonsPackage.PERSON__LANGUAGE:
				return getLanguage();
			case CommonsPackage.PERSON__CURRENCY_CODE:
				return getCurrencyCode();
			case CommonsPackage.PERSON__CURRENCY:
				return getCurrency();
			case CommonsPackage.PERSON__GOOGLE_PLUS_ID:
				return getGooglePlusId();
			case CommonsPackage.PERSON__GOOGLE_USERNAME:
				return getGoogleUsername();
			case CommonsPackage.PERSON__VIRTUAL_MAIL:
				return getVirtualMail();
			case CommonsPackage.PERSON__NICKNAME:
				return getNickname();
			case CommonsPackage.PERSON__CUSTOMER_ROLE:
				return getCustomerRole();
			case CommonsPackage.PERSON__MEMBER_ROLE:
				return getMemberRole();
			case CommonsPackage.PERSON__MANAGER_ROLE:
				return getManagerRole();
			case CommonsPackage.PERSON__TIME_ZONE_ID:
				return getTimeZoneId();
			case CommonsPackage.PERSON__TIME_ZONE:
				return getTimeZone();
			case CommonsPackage.PERSON__REFERRER_ID:
				return getReferrerId();
			case CommonsPackage.PERSON__REFERRER_TYPE:
				return getReferrerType();
			case CommonsPackage.PERSON__SIGNUP_SOURCE:
				return getSignupSource();
			case CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE:
				return getSignupSourceType();
			case CommonsPackage.PERSON__IP_ADDRESS:
				return getIpAddress();
			case CommonsPackage.PERSON__LAST_IP_ADDRESS:
				return getLastIpAddress();
			case CommonsPackage.PERSON__LAST_LOGIN_TIME:
				return getLastLoginTime();
			case CommonsPackage.PERSON__VALIDATION_TIME:
				return getValidationTime();
			case CommonsPackage.PERSON__ACTIVATION_TIME:
				return getActivationTime();
			case CommonsPackage.PERSON__VERIFICATION_TIME:
				return getVerificationTime();
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED:
				return getNewsletterSubscriptionEnabled();
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME:
				return getNewsletterSubscriptionTime();
			case CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED:
				return getSocialSharingEnabled();
			case CommonsPackage.PERSON__PUBLICATION_STATUS:
				return getPublicationStatus();
			case CommonsPackage.PERSON__ARCHIVAL_STATUS:
				return getArchivalStatus();
			case CommonsPackage.PERSON__FOLDER:
				return getFolder();
			case CommonsPackage.PERSON__RELIGION:
				return getReligion();
			case CommonsPackage.PERSON__PASSWORD_RESET_CODE:
				return getPasswordResetCode();
			case CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME:
				return getPasswordResetExpiryTime();
			case CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN:
				return getClientAccessToken();
			case CommonsPackage.PERSON__SECURITY_ROLE_IDS:
				return getSecurityRoleIds();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonsPackage.PERSON__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.PERSON__PHOTO_ID:
				setPhotoId((String)newValue);
				return;
			case CommonsPackage.PERSON__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.PERSON__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonsPackage.PERSON__SLUG:
				setSlug((String)newValue);
				return;
			case CommonsPackage.PERSON__CANONICAL_SLUG:
				setCanonicalSlug((String)newValue);
				return;
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN:
				setTwitterAccessToken((String)newValue);
				return;
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET:
				setTwitterAccessTokenSecret((String)newValue);
				return;
			case CommonsPackage.PERSON__TWITTER_ID:
				setTwitterId((Long)newValue);
				return;
			case CommonsPackage.PERSON__TWITTER_SCREEN_NAME:
				setTwitterScreenName((String)newValue);
				return;
			case CommonsPackage.PERSON__FACEBOOK_ID:
				setFacebookId((Long)newValue);
				return;
			case CommonsPackage.PERSON__FACEBOOK_USERNAME:
				setFacebookUsername((String)newValue);
				return;
			case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken((String)newValue);
				return;
			case CommonsPackage.PERSON__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case CommonsPackage.PERSON__LAST_NAME:
				setLastName((String)newValue);
				return;
			case CommonsPackage.PERSON__PASSWORD:
				setPassword((String)newValue);
				return;
			case CommonsPackage.PERSON__PHONE_NUMBERS:
				getPhoneNumbers().clear();
				getPhoneNumbers().addAll((Collection<? extends PhoneNumber>)newValue);
				return;
			case CommonsPackage.PERSON__EMAILS:
				getEmails().clear();
				getEmails().addAll((Collection<? extends Email>)newValue);
				return;
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
				getMobileNumbers().clear();
				getMobileNumbers().addAll((Collection<? extends PhoneNumber>)newValue);
				return;
			case CommonsPackage.PERSON__ADDRESSES:
				getAddresses().clear();
				getAddresses().addAll((Collection<? extends PostalAddress>)newValue);
				return;
			case CommonsPackage.PERSON__ACCOUNT_STATUS:
				setAccountStatus((AccountStatus)newValue);
				return;
			case CommonsPackage.PERSON__BIRTH_YEAR:
				setBirthYear((Integer)newValue);
				return;
			case CommonsPackage.PERSON__BIRTH_MONTH:
				setBirthMonth((Integer)newValue);
				return;
			case CommonsPackage.PERSON__BIRTH_DAY:
				setBirthDay((Integer)newValue);
				return;
			case CommonsPackage.PERSON__BIRTH_DATE:
				setBirthDate((LocalDate)newValue);
				return;
			case CommonsPackage.PERSON__GENDER:
				setGender((Gender)newValue);
				return;
			case CommonsPackage.PERSON__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case CommonsPackage.PERSON__CURRENCY_CODE:
				setCurrencyCode((String)newValue);
				return;
			case CommonsPackage.PERSON__CURRENCY:
				setCurrency((CurrencyUnit)newValue);
				return;
			case CommonsPackage.PERSON__GOOGLE_PLUS_ID:
				setGooglePlusId((String)newValue);
				return;
			case CommonsPackage.PERSON__GOOGLE_USERNAME:
				setGoogleUsername((String)newValue);
				return;
			case CommonsPackage.PERSON__VIRTUAL_MAIL:
				setVirtualMail((String)newValue);
				return;
			case CommonsPackage.PERSON__NICKNAME:
				setNickname((String)newValue);
				return;
			case CommonsPackage.PERSON__CUSTOMER_ROLE:
				setCustomerRole((String)newValue);
				return;
			case CommonsPackage.PERSON__MEMBER_ROLE:
				setMemberRole((String)newValue);
				return;
			case CommonsPackage.PERSON__MANAGER_ROLE:
				setManagerRole((String)newValue);
				return;
			case CommonsPackage.PERSON__TIME_ZONE_ID:
				setTimeZoneId((String)newValue);
				return;
			case CommonsPackage.PERSON__TIME_ZONE:
				setTimeZone((DateTimeZone)newValue);
				return;
			case CommonsPackage.PERSON__REFERRER_ID:
				setReferrerId((String)newValue);
				return;
			case CommonsPackage.PERSON__REFERRER_TYPE:
				setReferrerType((String)newValue);
				return;
			case CommonsPackage.PERSON__SIGNUP_SOURCE:
				setSignupSource((String)newValue);
				return;
			case CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE:
				setSignupSourceType((SignupSourceType)newValue);
				return;
			case CommonsPackage.PERSON__IP_ADDRESS:
				setIpAddress((String)newValue);
				return;
			case CommonsPackage.PERSON__LAST_IP_ADDRESS:
				setLastIpAddress((String)newValue);
				return;
			case CommonsPackage.PERSON__LAST_LOGIN_TIME:
				setLastLoginTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__VALIDATION_TIME:
				setValidationTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__ACTIVATION_TIME:
				setActivationTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__VERIFICATION_TIME:
				setVerificationTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED:
				setNewsletterSubscriptionEnabled((Boolean)newValue);
				return;
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME:
				setNewsletterSubscriptionTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED:
				setSocialSharingEnabled((Boolean)newValue);
				return;
			case CommonsPackage.PERSON__PUBLICATION_STATUS:
				setPublicationStatus((PublicationStatus)newValue);
				return;
			case CommonsPackage.PERSON__ARCHIVAL_STATUS:
				setArchivalStatus((ArchivalStatus)newValue);
				return;
			case CommonsPackage.PERSON__FOLDER:
				setFolder((String)newValue);
				return;
			case CommonsPackage.PERSON__RELIGION:
				setReligion((String)newValue);
				return;
			case CommonsPackage.PERSON__PASSWORD_RESET_CODE:
				setPasswordResetCode((String)newValue);
				return;
			case CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME:
				setPasswordResetExpiryTime((DateTime)newValue);
				return;
			case CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN:
				setClientAccessToken((String)newValue);
				return;
			case CommonsPackage.PERSON__SECURITY_ROLE_IDS:
				getSecurityRoleIds().clear();
				getSecurityRoleIds().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommonsPackage.PERSON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PHOTO_ID:
				setPhotoId(PHOTO_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonsPackage.PERSON__SLUG:
				setSlug(SLUG_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CANONICAL_SLUG:
				setCanonicalSlug(CANONICAL_SLUG_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN:
				setTwitterAccessToken(TWITTER_ACCESS_TOKEN_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET:
				setTwitterAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TWITTER_ID:
				setTwitterId(TWITTER_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TWITTER_SCREEN_NAME:
				setTwitterScreenName(TWITTER_SCREEN_NAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__FACEBOOK_ID:
				setFacebookId(FACEBOOK_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__FACEBOOK_USERNAME:
				setFacebookUsername(FACEBOOK_USERNAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken(FACEBOOK_ACCESS_TOKEN_EDEFAULT);
				return;
			case CommonsPackage.PERSON__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PHONE_NUMBERS:
				getPhoneNumbers().clear();
				return;
			case CommonsPackage.PERSON__EMAILS:
				getEmails().clear();
				return;
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
				getMobileNumbers().clear();
				return;
			case CommonsPackage.PERSON__ADDRESSES:
				getAddresses().clear();
				return;
			case CommonsPackage.PERSON__ACCOUNT_STATUS:
				setAccountStatus(ACCOUNT_STATUS_EDEFAULT);
				return;
			case CommonsPackage.PERSON__BIRTH_YEAR:
				setBirthYear(BIRTH_YEAR_EDEFAULT);
				return;
			case CommonsPackage.PERSON__BIRTH_MONTH:
				setBirthMonth(BIRTH_MONTH_EDEFAULT);
				return;
			case CommonsPackage.PERSON__BIRTH_DAY:
				setBirthDay(BIRTH_DAY_EDEFAULT);
				return;
			case CommonsPackage.PERSON__BIRTH_DATE:
				setBirthDate(BIRTH_DATE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__GENDER:
				setGender(GENDER_EDEFAULT);
				return;
			case CommonsPackage.PERSON__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CURRENCY_CODE:
				setCurrencyCode(CURRENCY_CODE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CURRENCY:
				setCurrency(CURRENCY_EDEFAULT);
				return;
			case CommonsPackage.PERSON__GOOGLE_PLUS_ID:
				setGooglePlusId(GOOGLE_PLUS_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__GOOGLE_USERNAME:
				setGoogleUsername(GOOGLE_USERNAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__VIRTUAL_MAIL:
				setVirtualMail(VIRTUAL_MAIL_EDEFAULT);
				return;
			case CommonsPackage.PERSON__NICKNAME:
				setNickname(NICKNAME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CUSTOMER_ROLE:
				setCustomerRole(CUSTOMER_ROLE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__MEMBER_ROLE:
				setMemberRole(MEMBER_ROLE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__MANAGER_ROLE:
				setManagerRole(MANAGER_ROLE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TIME_ZONE_ID:
				setTimeZoneId(TIME_ZONE_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__TIME_ZONE:
				setTimeZone(TIME_ZONE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__REFERRER_ID:
				setReferrerId(REFERRER_ID_EDEFAULT);
				return;
			case CommonsPackage.PERSON__REFERRER_TYPE:
				setReferrerType(REFERRER_TYPE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__SIGNUP_SOURCE:
				setSignupSource(SIGNUP_SOURCE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE:
				setSignupSourceType(SIGNUP_SOURCE_TYPE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__IP_ADDRESS:
				setIpAddress(IP_ADDRESS_EDEFAULT);
				return;
			case CommonsPackage.PERSON__LAST_IP_ADDRESS:
				setLastIpAddress(LAST_IP_ADDRESS_EDEFAULT);
				return;
			case CommonsPackage.PERSON__LAST_LOGIN_TIME:
				setLastLoginTime(LAST_LOGIN_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__VALIDATION_TIME:
				setValidationTime(VALIDATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__ACTIVATION_TIME:
				setActivationTime(ACTIVATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__VERIFICATION_TIME:
				setVerificationTime(VERIFICATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED:
				setNewsletterSubscriptionEnabled(NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME:
				setNewsletterSubscriptionTime(NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED:
				setSocialSharingEnabled(SOCIAL_SHARING_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PUBLICATION_STATUS:
				setPublicationStatus(PUBLICATION_STATUS_EDEFAULT);
				return;
			case CommonsPackage.PERSON__ARCHIVAL_STATUS:
				setArchivalStatus(ARCHIVAL_STATUS_EDEFAULT);
				return;
			case CommonsPackage.PERSON__FOLDER:
				setFolder(FOLDER_EDEFAULT);
				return;
			case CommonsPackage.PERSON__RELIGION:
				setReligion(RELIGION_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PASSWORD_RESET_CODE:
				setPasswordResetCode(PASSWORD_RESET_CODE_EDEFAULT);
				return;
			case CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME:
				setPasswordResetExpiryTime(PASSWORD_RESET_EXPIRY_TIME_EDEFAULT);
				return;
			case CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN:
				setClientAccessToken(CLIENT_ACCESS_TOKEN_EDEFAULT);
				return;
			case CommonsPackage.PERSON__SECURITY_ROLE_IDS:
				getSecurityRoleIds().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonsPackage.PERSON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.PERSON__PHOTO_ID:
				return PHOTO_ID_EDEFAULT == null ? photoId != null : !PHOTO_ID_EDEFAULT.equals(photoId);
			case CommonsPackage.PERSON__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.PERSON__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case CommonsPackage.PERSON__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case CommonsPackage.PERSON__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonsPackage.PERSON__SLUG:
				return SLUG_EDEFAULT == null ? slug != null : !SLUG_EDEFAULT.equals(slug);
			case CommonsPackage.PERSON__CANONICAL_SLUG:
				return CANONICAL_SLUG_EDEFAULT == null ? canonicalSlug != null : !CANONICAL_SLUG_EDEFAULT.equals(canonicalSlug);
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN:
				return TWITTER_ACCESS_TOKEN_EDEFAULT == null ? twitterAccessToken != null : !TWITTER_ACCESS_TOKEN_EDEFAULT.equals(twitterAccessToken);
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET:
				return TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT == null ? twitterAccessTokenSecret != null : !TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT.equals(twitterAccessTokenSecret);
			case CommonsPackage.PERSON__TWITTER_ID:
				return TWITTER_ID_EDEFAULT == null ? twitterId != null : !TWITTER_ID_EDEFAULT.equals(twitterId);
			case CommonsPackage.PERSON__TWITTER_SCREEN_NAME:
				return TWITTER_SCREEN_NAME_EDEFAULT == null ? twitterScreenName != null : !TWITTER_SCREEN_NAME_EDEFAULT.equals(twitterScreenName);
			case CommonsPackage.PERSON__FACEBOOK_ID:
				return FACEBOOK_ID_EDEFAULT == null ? facebookId != null : !FACEBOOK_ID_EDEFAULT.equals(facebookId);
			case CommonsPackage.PERSON__FACEBOOK_USERNAME:
				return FACEBOOK_USERNAME_EDEFAULT == null ? facebookUsername != null : !FACEBOOK_USERNAME_EDEFAULT.equals(facebookUsername);
			case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN:
				return FACEBOOK_ACCESS_TOKEN_EDEFAULT == null ? facebookAccessToken != null : !FACEBOOK_ACCESS_TOKEN_EDEFAULT.equals(facebookAccessToken);
			case CommonsPackage.PERSON__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case CommonsPackage.PERSON__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case CommonsPackage.PERSON__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case CommonsPackage.PERSON__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case CommonsPackage.PERSON__PHONE_NUMBERS:
				return phoneNumbers != null && !phoneNumbers.isEmpty();
			case CommonsPackage.PERSON__EMAILS:
				return emails != null && !emails.isEmpty();
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
				return mobileNumbers != null && !mobileNumbers.isEmpty();
			case CommonsPackage.PERSON__ADDRESSES:
				return addresses != null && !addresses.isEmpty();
			case CommonsPackage.PERSON__ACCOUNT_STATUS:
				return accountStatus != ACCOUNT_STATUS_EDEFAULT;
			case CommonsPackage.PERSON__BIRTH_YEAR:
				return BIRTH_YEAR_EDEFAULT == null ? birthYear != null : !BIRTH_YEAR_EDEFAULT.equals(birthYear);
			case CommonsPackage.PERSON__BIRTH_MONTH:
				return BIRTH_MONTH_EDEFAULT == null ? birthMonth != null : !BIRTH_MONTH_EDEFAULT.equals(birthMonth);
			case CommonsPackage.PERSON__BIRTH_DAY:
				return BIRTH_DAY_EDEFAULT == null ? birthDay != null : !BIRTH_DAY_EDEFAULT.equals(birthDay);
			case CommonsPackage.PERSON__BIRTH_DATE:
				return BIRTH_DATE_EDEFAULT == null ? birthDate != null : !BIRTH_DATE_EDEFAULT.equals(birthDate);
			case CommonsPackage.PERSON__GENDER:
				return gender != GENDER_EDEFAULT;
			case CommonsPackage.PERSON__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case CommonsPackage.PERSON__CURRENCY_CODE:
				return CURRENCY_CODE_EDEFAULT == null ? currencyCode != null : !CURRENCY_CODE_EDEFAULT.equals(currencyCode);
			case CommonsPackage.PERSON__CURRENCY:
				return CURRENCY_EDEFAULT == null ? getCurrency() != null : !CURRENCY_EDEFAULT.equals(getCurrency());
			case CommonsPackage.PERSON__GOOGLE_PLUS_ID:
				return GOOGLE_PLUS_ID_EDEFAULT == null ? googlePlusId != null : !GOOGLE_PLUS_ID_EDEFAULT.equals(googlePlusId);
			case CommonsPackage.PERSON__GOOGLE_USERNAME:
				return GOOGLE_USERNAME_EDEFAULT == null ? googleUsername != null : !GOOGLE_USERNAME_EDEFAULT.equals(googleUsername);
			case CommonsPackage.PERSON__VIRTUAL_MAIL:
				return VIRTUAL_MAIL_EDEFAULT == null ? virtualMail != null : !VIRTUAL_MAIL_EDEFAULT.equals(virtualMail);
			case CommonsPackage.PERSON__NICKNAME:
				return NICKNAME_EDEFAULT == null ? nickname != null : !NICKNAME_EDEFAULT.equals(nickname);
			case CommonsPackage.PERSON__CUSTOMER_ROLE:
				return CUSTOMER_ROLE_EDEFAULT == null ? customerRole != null : !CUSTOMER_ROLE_EDEFAULT.equals(customerRole);
			case CommonsPackage.PERSON__MEMBER_ROLE:
				return MEMBER_ROLE_EDEFAULT == null ? memberRole != null : !MEMBER_ROLE_EDEFAULT.equals(memberRole);
			case CommonsPackage.PERSON__MANAGER_ROLE:
				return MANAGER_ROLE_EDEFAULT == null ? managerRole != null : !MANAGER_ROLE_EDEFAULT.equals(managerRole);
			case CommonsPackage.PERSON__TIME_ZONE_ID:
				return TIME_ZONE_ID_EDEFAULT == null ? timeZoneId != null : !TIME_ZONE_ID_EDEFAULT.equals(timeZoneId);
			case CommonsPackage.PERSON__TIME_ZONE:
				return TIME_ZONE_EDEFAULT == null ? getTimeZone() != null : !TIME_ZONE_EDEFAULT.equals(getTimeZone());
			case CommonsPackage.PERSON__REFERRER_ID:
				return REFERRER_ID_EDEFAULT == null ? referrerId != null : !REFERRER_ID_EDEFAULT.equals(referrerId);
			case CommonsPackage.PERSON__REFERRER_TYPE:
				return REFERRER_TYPE_EDEFAULT == null ? referrerType != null : !REFERRER_TYPE_EDEFAULT.equals(referrerType);
			case CommonsPackage.PERSON__SIGNUP_SOURCE:
				return SIGNUP_SOURCE_EDEFAULT == null ? signupSource != null : !SIGNUP_SOURCE_EDEFAULT.equals(signupSource);
			case CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE:
				return signupSourceType != SIGNUP_SOURCE_TYPE_EDEFAULT;
			case CommonsPackage.PERSON__IP_ADDRESS:
				return IP_ADDRESS_EDEFAULT == null ? ipAddress != null : !IP_ADDRESS_EDEFAULT.equals(ipAddress);
			case CommonsPackage.PERSON__LAST_IP_ADDRESS:
				return LAST_IP_ADDRESS_EDEFAULT == null ? lastIpAddress != null : !LAST_IP_ADDRESS_EDEFAULT.equals(lastIpAddress);
			case CommonsPackage.PERSON__LAST_LOGIN_TIME:
				return LAST_LOGIN_TIME_EDEFAULT == null ? lastLoginTime != null : !LAST_LOGIN_TIME_EDEFAULT.equals(lastLoginTime);
			case CommonsPackage.PERSON__VALIDATION_TIME:
				return VALIDATION_TIME_EDEFAULT == null ? validationTime != null : !VALIDATION_TIME_EDEFAULT.equals(validationTime);
			case CommonsPackage.PERSON__ACTIVATION_TIME:
				return ACTIVATION_TIME_EDEFAULT == null ? activationTime != null : !ACTIVATION_TIME_EDEFAULT.equals(activationTime);
			case CommonsPackage.PERSON__VERIFICATION_TIME:
				return VERIFICATION_TIME_EDEFAULT == null ? verificationTime != null : !VERIFICATION_TIME_EDEFAULT.equals(verificationTime);
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED:
				return NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT == null ? newsletterSubscriptionEnabled != null : !NEWSLETTER_SUBSCRIPTION_ENABLED_EDEFAULT.equals(newsletterSubscriptionEnabled);
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME:
				return NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT == null ? newsletterSubscriptionTime != null : !NEWSLETTER_SUBSCRIPTION_TIME_EDEFAULT.equals(newsletterSubscriptionTime);
			case CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED:
				return SOCIAL_SHARING_ENABLED_EDEFAULT == null ? socialSharingEnabled != null : !SOCIAL_SHARING_ENABLED_EDEFAULT.equals(socialSharingEnabled);
			case CommonsPackage.PERSON__PUBLICATION_STATUS:
				return publicationStatus != PUBLICATION_STATUS_EDEFAULT;
			case CommonsPackage.PERSON__ARCHIVAL_STATUS:
				return archivalStatus != ARCHIVAL_STATUS_EDEFAULT;
			case CommonsPackage.PERSON__FOLDER:
				return FOLDER_EDEFAULT == null ? folder != null : !FOLDER_EDEFAULT.equals(folder);
			case CommonsPackage.PERSON__RELIGION:
				return RELIGION_EDEFAULT == null ? religion != null : !RELIGION_EDEFAULT.equals(religion);
			case CommonsPackage.PERSON__PASSWORD_RESET_CODE:
				return PASSWORD_RESET_CODE_EDEFAULT == null ? passwordResetCode != null : !PASSWORD_RESET_CODE_EDEFAULT.equals(passwordResetCode);
			case CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME:
				return PASSWORD_RESET_EXPIRY_TIME_EDEFAULT == null ? passwordResetExpiryTime != null : !PASSWORD_RESET_EXPIRY_TIME_EDEFAULT.equals(passwordResetExpiryTime);
			case CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN:
				return CLIENT_ACCESS_TOKEN_EDEFAULT == null ? clientAccessToken != null : !CLIENT_ACCESS_TOKEN_EDEFAULT.equals(clientAccessToken);
			case CommonsPackage.PERSON__SECURITY_ROLE_IDS:
				return securityRoleIds != null && !securityRoleIds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Imageable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__PHOTO_ID: return CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__ID: return CommonsPackage.IDENTIFIABLE__ID;
				default: return -1;
			}
		}
		if (baseClass == PersonLike.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Informer.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case CommonsPackage.PERSON__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__SLUG: return CommonsPackage.SLUGGABLE__SLUG;
				default: return -1;
			}
		}
		if (baseClass == CanonicalSluggable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__CANONICAL_SLUG: return CommonsPackage.CANONICAL_SLUGGABLE__CANONICAL_SLUG;
				default: return -1;
			}
		}
		if (baseClass == TwitterAccessible.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN: return CommonsPackage.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN;
				case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET: return CommonsPackage.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN_SECRET;
				default: return -1;
			}
		}
		if (baseClass == TwitterIdentity.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__TWITTER_ID: return CommonsPackage.TWITTER_IDENTITY__TWITTER_ID;
				case CommonsPackage.PERSON__TWITTER_SCREEN_NAME: return CommonsPackage.TWITTER_IDENTITY__TWITTER_SCREEN_NAME;
				default: return -1;
			}
		}
		if (baseClass == FacebookIdentity.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__FACEBOOK_ID: return CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID;
				case CommonsPackage.PERSON__FACEBOOK_USERNAME: return CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME;
				default: return -1;
			}
		}
		if (baseClass == FacebookAccessible.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN: return CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Imageable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PhotoIdContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.PHOTO_ID_CONTAINER__PHOTO_ID: return CommonsPackage.PERSON__PHOTO_ID;
				default: return -1;
			}
		}
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.IDENTIFIABLE__ID: return CommonsPackage.PERSON__ID;
				default: return -1;
			}
		}
		if (baseClass == PersonLike.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Informer.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return CommonsPackage.PERSON__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return CommonsPackage.PERSON__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return CommonsPackage.PERSON__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == Sluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SLUGGABLE__SLUG: return CommonsPackage.PERSON__SLUG;
				default: return -1;
			}
		}
		if (baseClass == CanonicalSluggable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.CANONICAL_SLUGGABLE__CANONICAL_SLUG: return CommonsPackage.PERSON__CANONICAL_SLUG;
				default: return -1;
			}
		}
		if (baseClass == TwitterAccessible.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN: return CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN;
				case CommonsPackage.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN_SECRET: return CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET;
				default: return -1;
			}
		}
		if (baseClass == TwitterIdentity.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TWITTER_IDENTITY__TWITTER_ID: return CommonsPackage.PERSON__TWITTER_ID;
				case CommonsPackage.TWITTER_IDENTITY__TWITTER_SCREEN_NAME: return CommonsPackage.PERSON__TWITTER_SCREEN_NAME;
				default: return -1;
			}
		}
		if (baseClass == FacebookIdentity.class) {
			switch (baseFeatureID) {
				case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_ID: return CommonsPackage.PERSON__FACEBOOK_ID;
				case CommonsPackage.FACEBOOK_IDENTITY__FACEBOOK_USERNAME: return CommonsPackage.PERSON__FACEBOOK_USERNAME;
				default: return -1;
			}
		}
		if (baseClass == FacebookAccessible.class) {
			switch (baseFeatureID) {
				case CommonsPackage.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN: return CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

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
		result.append(')');
		return result.toString();
	}

} //PersonImpl
