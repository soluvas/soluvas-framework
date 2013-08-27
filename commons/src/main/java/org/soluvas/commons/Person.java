/**
 */
package org.soluvas.commons;

import javax.annotation.Nullable;

import org.eclipse.emf.common.util.EList;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import com.google.common.base.Function;
import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Database-agnostic future replacement for org.soluvas.ldap.SocialPerson & BippoPerson.
 * 
 * A basic LDAP <tt>objectClass=person</tt> with proper mappings that can be subclassed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Person#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getPassword <em>Password</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getPhoneNumbers <em>Phone Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getMobileNumbers <em>Mobile Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getAccountStatus <em>Account Status</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getBirthYear <em>Birth Year</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getBirthMonth <em>Birth Month</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getBirthDay <em>Birth Day</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getCurrencyCode <em>Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getCurrency <em>Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getGooglePlusId <em>Google Plus Id</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getGoogleUsername <em>Google Username</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getVirtualMail <em>Virtual Mail</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getNickname <em>Nickname</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getCustomerRole <em>Customer Role</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getMemberRole <em>Member Role</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getManagerRole <em>Manager Role</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getTimeZoneId <em>Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getTimeZone <em>Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getReferrerId <em>Referrer Id</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getReferrerType <em>Referrer Type</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getSignupSource <em>Signup Source</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getSignupSourceType <em>Signup Source Type</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getIpAddress <em>Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getLastIpAddress <em>Last Ip Address</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getLastLoginTime <em>Last Login Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getValidationTime <em>Validation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getActivationTime <em>Activation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getVerificationTime <em>Verification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getNewsletterSubscriptionEnabled <em>Newsletter Subscription Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getNewsletterSubscriptionTime <em>Newsletter Subscription Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getSocialSharingEnabled <em>Social Sharing Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getPublicationStatus <em>Publication Status</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getArchivalStatus <em>Archival Status</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getReligion <em>Religion</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getPasswordResetCode <em>Password Reset Code</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getPasswordResetExpiryTime <em>Password Reset Expiry Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getClientAccessToken <em>Client Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getSecurityRoleIds <em>Security Role Ids</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getDebitBalance <em>Debit Balance</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getDebitCurrency <em>Debit Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.Person#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends NameContainer, PhotoIdContainer, Identifiable, PersonLike, Informer<PersonInfo>, Timestamped, SchemaVersionable, Describable, Sluggable, CanonicalSluggable, TwitterAccessible, TwitterIdentity, FacebookIdentity, FacebookAccessible, Revisionable {
	
	public static class ToPersonInfo implements Function<Person, PersonInfo> {
		@Override @Nullable
		public PersonInfo apply(@Nullable Person input) {
			if (input == null)
				return null;
			final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
			personInfo.setId(input.getId());
			personInfo.setSlug(input.getSlug());
			personInfo.setName(input.getName());
			personInfo.setPhotoId(input.getPhotoId());
			personInfo.setGender(input.getGender());
			personInfo.setEmail(input.getEmail());
			return personInfo;
		}
	}
	
	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_SchemaVersion()
	 * @model default="2" changeable="false"
	 * @generated
	 */
	@Override
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The password, may be encoded e.g. <code>{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==<code>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Phone Numbers</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.PhoneNumber}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Numbers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Numbers</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_PhoneNumbers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PhoneNumber> getPhoneNumbers();

	/**
	 * Returns the value of the '<em><b>Emails</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.Email}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emails</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emails</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Emails()
	 * @model containment="true"
	 * @generated
	 */
	EList<Email> getEmails();

	/**
	 * Returns the value of the '<em><b>Mobile Numbers</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.PhoneNumber}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mobile Numbers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mobile Numbers</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_MobileNumbers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PhoneNumber> getMobileNumbers();
	
	String getMobileNumber();

	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.PostalAddress}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addresses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addresses</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Addresses()
	 * @model containment="true"
	 * @generated
	 */
	EList<PostalAddress> getAddresses();

	/**
	 * Returns the value of the '<em><b>Account Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.AccountStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Status of Account, can be used for shop, person, or mall.
	 * 
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
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Account Status</em>' attribute.
	 * @see org.soluvas.commons.AccountStatus
	 * @see #setAccountStatus(AccountStatus)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_AccountStatus()
	 * @model
	 * @generated
	 */
	AccountStatus getAccountStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getAccountStatus <em>Account Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Status</em>' attribute.
	 * @see org.soluvas.commons.AccountStatus
	 * @see #getAccountStatus()
	 * @generated
	 */
	void setAccountStatus(AccountStatus value);

	/**
	 * Returns the value of the '<em><b>Birth Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Year</em>' attribute.
	 * @see #setBirthYear(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_BirthYear()
	 * @model
	 * @generated
	 */
	Integer getBirthYear();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getBirthYear <em>Birth Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Year</em>' attribute.
	 * @see #getBirthYear()
	 * @generated
	 */
	void setBirthYear(Integer value);

	/**
	 * Returns the value of the '<em><b>Birth Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Month</em>' attribute.
	 * @see #setBirthMonth(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_BirthMonth()
	 * @model
	 * @generated
	 */
	Integer getBirthMonth();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getBirthMonth <em>Birth Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Month</em>' attribute.
	 * @see #getBirthMonth()
	 * @generated
	 */
	void setBirthMonth(Integer value);

	/**
	 * Returns the value of the '<em><b>Birth Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Day</em>' attribute.
	 * @see #setBirthDay(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_BirthDay()
	 * @model
	 * @generated
	 */
	Integer getBirthDay();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getBirthDay <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Day</em>' attribute.
	 * @see #getBirthDay()
	 * @generated
	 */
	void setBirthDay(Integer value);

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only available if birthYear, birthMonth, and birthDay is a valid date.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @see #setBirthDate(LocalDate)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_BirthDate()
	 * @model dataType="org.soluvas.commons.LocalDate"
	 * @generated
	 */
	LocalDate getBirthDate();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @see #getBirthDate()
	 * @generated
	 */
	void setBirthDate(LocalDate value);

	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #setGender(Gender)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Gender()
	 * @model
	 * @generated
	 */
	@Override
	Gender getGender();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Preferred language as language identifier,
	 * as defined by IETF RFC 4646 (http://www.ietf.org/rfc/rfc4646.txt) or successor,
	 * or ISO 639-1 Language Codes. 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Currency Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Currency Code</em>' attribute.
	 * @see #setCurrencyCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_CurrencyCode()
	 * @model
	 * @generated
	 */
	String getCurrencyCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getCurrencyCode <em>Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency Code</em>' attribute.
	 * @see #getCurrencyCode()
	 * @generated
	 */
	void setCurrencyCode(String value);

	/**
	 * Returns the value of the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Currency</em>' attribute.
	 * @see #setCurrency(CurrencyUnit)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Currency()
	 * @model dataType="org.soluvas.commons.CurrencyUnit" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	CurrencyUnit getCurrency();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getCurrency <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency</em>' attribute.
	 * @see #getCurrency()
	 * @generated
	 */
	void setCurrency(CurrencyUnit value);

	/**
	 * Returns the value of the '<em><b>Google Plus Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Google Plus Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Google Plus Id</em>' attribute.
	 * @see #setGooglePlusId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_GooglePlusId()
	 * @model
	 * @generated
	 */
	String getGooglePlusId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getGooglePlusId <em>Google Plus Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Plus Id</em>' attribute.
	 * @see #getGooglePlusId()
	 * @generated
	 */
	void setGooglePlusId(String value);

	/**
	 * Returns the value of the '<em><b>Google Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Google Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Google Username</em>' attribute.
	 * @see #setGoogleUsername(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_GoogleUsername()
	 * @model
	 * @generated
	 */
	String getGoogleUsername();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getGoogleUsername <em>Google Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Username</em>' attribute.
	 * @see #getGoogleUsername()
	 * @generated
	 */
	void setGoogleUsername(String value);

	/**
	 * Returns the value of the '<em><b>Virtual Mail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Mail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Mail</em>' attribute.
	 * @see #setVirtualMail(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_VirtualMail()
	 * @model
	 * @generated
	 */
	String getVirtualMail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getVirtualMail <em>Virtual Mail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Mail</em>' attribute.
	 * @see #getVirtualMail()
	 * @generated
	 */
	void setVirtualMail(String value);

	/**
	 * Returns the value of the '<em><b>Nickname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nickname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nickname</em>' attribute.
	 * @see #setNickname(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Nickname()
	 * @model
	 * @generated
	 */
	String getNickname();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getNickname <em>Nickname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nickname</em>' attribute.
	 * @see #getNickname()
	 * @generated
	 */
	void setNickname(String value);

	/**
	 * Returns the value of the '<em><b>Customer Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Customer Role or Group, for example in Tuneeca there are 5: ag-sp, agen, biasa, drops, membr
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Customer Role</em>' attribute.
	 * @see #setCustomerRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_CustomerRole()
	 * @model
	 * @generated
	 */
	String getCustomerRole();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getCustomerRole <em>Customer Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Role</em>' attribute.
	 * @see #getCustomerRole()
	 * @generated
	 */
	void setCustomerRole(String value);

	/**
	 * Returns the value of the '<em><b>Member Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Member Role or Group for example : newbie, aktivis , donatur
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Role</em>' attribute.
	 * @see #setMemberRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_MemberRole()
	 * @model
	 * @generated
	 */
	String getMemberRole();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getMemberRole <em>Member Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Role</em>' attribute.
	 * @see #getMemberRole()
	 * @generated
	 */
	void setMemberRole(String value);

	/**
	 * Returns the value of the '<em><b>Manager Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Manager Role or Group for example : regular, moderator , administrator, sysadmin. (administrativeRole attribute OID 2.5.18.5 is already used by LDAP standard)
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manager Role</em>' attribute.
	 * @see #setManagerRole(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ManagerRole()
	 * @model
	 * @generated
	 */
	String getManagerRole();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getManagerRole <em>Manager Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Role</em>' attribute.
	 * @see #getManagerRole()
	 * @generated
	 */
	void setManagerRole(String value);

	/**
	 * Returns the value of the '<em><b>Time Zone Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute is named 'timezone' and is a plain string, e.g. 'Asia/Jakarta' or 'UTC'. If not set, will default to whatever the application configuration is set to (or its heuristics). References: * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html * http://tracker.moodle.org/browse/MDL-17330
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Zone Id</em>' attribute.
	 * @see #setTimeZoneId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_TimeZoneId()
	 * @model
	 * @generated
	 */
	String getTimeZoneId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getTimeZoneId <em>Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Zone Id</em>' attribute.
	 * @see #getTimeZoneId()
	 * @generated
	 */
	void setTimeZoneId(String value);

	/**
	 * Returns the value of the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute is named 'timezone' and is a plain string, e.g. 'Asia/Jakarta' or 'UTC'. If not set, will default to whatever the application configuration is set to (or its heuristics). References: * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html * http://tracker.moodle.org/browse/MDL-17330
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Time Zone</em>' attribute.
	 * @see #setTimeZone(DateTimeZone)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_TimeZone()
	 * @model dataType="org.soluvas.commons.DateTimeZone" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	DateTimeZone getTimeZone();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getTimeZone <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Zone</em>' attribute.
	 * @see #getTimeZone()
	 * @generated
	 */
	void setTimeZone(DateTimeZone value);

	/**
	 * Returns the value of the '<em><b>Referrer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Person ID who refers this person
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referrer Id</em>' attribute.
	 * @see #setReferrerId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ReferrerId()
	 * @model
	 * @generated
	 */
	String getReferrerId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getReferrerId <em>Referrer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referrer Id</em>' attribute.
	 * @see #getReferrerId()
	 * @generated
	 */
	void setReferrerId(String value);

	/**
	 * Returns the value of the '<em><b>Referrer Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of referrer for example : person_id , email, facebook_id
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referrer Type</em>' attribute.
	 * @see #setReferrerType(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ReferrerType()
	 * @model
	 * @generated
	 */
	String getReferrerType();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getReferrerType <em>Referrer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referrer Type</em>' attribute.
	 * @see #getReferrerType()
	 * @generated
	 */
	void setReferrerType(String value);

	/**
	 * Returns the value of the '<em><b>Signup Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Signup source name, e.g. "Rudi Wijaya" for {@link SignupSourceType#FACEBOOK_FRIEND}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signup Source</em>' attribute.
	 * @see #setSignupSource(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_SignupSource()
	 * @model
	 * @generated
	 */
	String getSignupSource();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getSignupSource <em>Signup Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signup Source</em>' attribute.
	 * @see #getSignupSource()
	 * @generated
	 */
	void setSignupSource(String value);

	/**
	 * Returns the value of the '<em><b>Signup Source Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.SignupSourceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Signup source type, e.g. {@link SignupSourceType#FACEBOOK_FRIEND}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signup Source Type</em>' attribute.
	 * @see org.soluvas.commons.SignupSourceType
	 * @see #setSignupSourceType(SignupSourceType)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_SignupSourceType()
	 * @model
	 * @generated
	 */
	SignupSourceType getSignupSourceType();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getSignupSourceType <em>Signup Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signup Source Type</em>' attribute.
	 * @see org.soluvas.commons.SignupSourceType
	 * @see #getSignupSourceType()
	 * @generated
	 */
	void setSignupSourceType(SignupSourceType value);

	/**
	 * Returns the value of the '<em><b>Ip Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * IP address pertama kali login
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ip Address</em>' attribute.
	 * @see #setIpAddress(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_IpAddress()
	 * @model
	 * @generated
	 */
	String getIpAddress();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getIpAddress <em>Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip Address</em>' attribute.
	 * @see #getIpAddress()
	 * @generated
	 */
	void setIpAddress(String value);

	/**
	 * Returns the value of the '<em><b>Last Ip Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * IP address terakhir kali login
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Ip Address</em>' attribute.
	 * @see #setLastIpAddress(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_LastIpAddress()
	 * @model
	 * @generated
	 */
	String getLastIpAddress();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getLastIpAddress <em>Last Ip Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Ip Address</em>' attribute.
	 * @see #getLastIpAddress()
	 * @generated
	 */
	void setLastIpAddress(String value);

	/**
	 * Returns the value of the '<em><b>Last Login Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kapan terakhir kali login
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Login Time</em>' attribute.
	 * @see #setLastLoginTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_LastLoginTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getLastLoginTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getLastLoginTime <em>Last Login Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Login Time</em>' attribute.
	 * @see #getLastLoginTime()
	 * @generated
	 */
	void setLastLoginTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Validation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kapan dia validate email
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Time</em>' attribute.
	 * @see #setValidationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ValidationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getValidationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getValidationTime <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Time</em>' attribute.
	 * @see #getValidationTime()
	 * @generated
	 */
	void setValidationTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Activation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kapan akun dia aktif (bila dimoderasi)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Activation Time</em>' attribute.
	 * @see #setActivationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ActivationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getActivationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getActivationTime <em>Activation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Time</em>' attribute.
	 * @see #getActivationTime()
	 * @generated
	 */
	void setActivationTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Verification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * kapan dia menjadi verified member
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Verification Time</em>' attribute.
	 * @see #setVerificationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_VerificationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getVerificationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getVerificationTime <em>Verification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verification Time</em>' attribute.
	 * @see #getVerificationTime()
	 * @generated
	 */
	void setVerificationTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Newsletter Subscription Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Apakah dia ingin menerima newsletter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Newsletter Subscription Enabled</em>' attribute.
	 * @see #setNewsletterSubscriptionEnabled(Boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_NewsletterSubscriptionEnabled()
	 * @model
	 * @generated
	 */
	Boolean getNewsletterSubscriptionEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getNewsletterSubscriptionEnabled <em>Newsletter Subscription Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Newsletter Subscription Enabled</em>' attribute.
	 * @see #getNewsletterSubscriptionEnabled()
	 * @generated
	 */
	void setNewsletterSubscriptionEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Newsletter Subscription Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Kapan dia terdaftar di newsletter
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Newsletter Subscription Time</em>' attribute.
	 * @see #setNewsletterSubscriptionTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_NewsletterSubscriptionTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getNewsletterSubscriptionTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getNewsletterSubscriptionTime <em>Newsletter Subscription Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Newsletter Subscription Time</em>' attribute.
	 * @see #getNewsletterSubscriptionTime()
	 * @generated
	 */
	void setNewsletterSubscriptionTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Social Sharing Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Social Sharing Enabled</em>' attribute.
	 * @see #setSocialSharingEnabled(Boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_SocialSharingEnabled()
	 * @model
	 * @generated
	 */
	Boolean getSocialSharingEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getSocialSharingEnabled <em>Social Sharing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Social Sharing Enabled</em>' attribute.
	 * @see #getSocialSharingEnabled()
	 * @generated
	 */
	void setSocialSharingEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Publication Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.PublicationStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).
	 * 
	 * <ol>
	 * 	<li>draft</li>
	 * 	<li>published</li>
	 * 	<li>unpublished</li>
	 * </ol>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Publication Status</em>' attribute.
	 * @see org.soluvas.commons.PublicationStatus
	 * @see #setPublicationStatus(PublicationStatus)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_PublicationStatus()
	 * @model
	 * @generated
	 */
	PublicationStatus getPublicationStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getPublicationStatus <em>Publication Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publication Status</em>' attribute.
	 * @see org.soluvas.commons.PublicationStatus
	 * @see #getPublicationStatus()
	 * @generated
	 */
	void setPublicationStatus(PublicationStatus value);

	/**
	 * Returns the value of the '<em><b>Archival Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.ArchivalStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya. fresh archived
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Archival Status</em>' attribute.
	 * @see org.soluvas.commons.ArchivalStatus
	 * @see #setArchivalStatus(ArchivalStatus)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ArchivalStatus()
	 * @model
	 * @generated
	 */
	ArchivalStatus getArchivalStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getArchivalStatus <em>Archival Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Archival Status</em>' attribute.
	 * @see org.soluvas.commons.ArchivalStatus
	 * @see #getArchivalStatus()
	 * @generated
	 */
	void setArchivalStatus(ArchivalStatus value);

	/**
	 * Returns the value of the '<em><b>Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * atribut untuk labeling. Masukkan nsPrefix_{folderName}. (folder name di sini underscore lowercase)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Folder</em>' attribute.
	 * @see #setFolder(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Folder()
	 * @model
	 * @generated
	 */
	String getFolder();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getFolder <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder</em>' attribute.
	 * @see #getFolder()
	 * @generated
	 */
	void setFolder(String value);

	/**
	 * Returns the value of the '<em><b>Religion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Religion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Religion</em>' attribute.
	 * @see #setReligion(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Religion()
	 * @model
	 * @generated
	 */
	String getReligion();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getReligion <em>Religion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Religion</em>' attribute.
	 * @see #getReligion()
	 * @generated
	 */
	void setReligion(String value);

	/**
	 * Returns the value of the '<em><b>Password Reset Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Code that can be used to perform password reset for a limited time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password Reset Code</em>' attribute.
	 * @see #setPasswordResetCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_PasswordResetCode()
	 * @model
	 * @generated
	 */
	String getPasswordResetCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getPasswordResetCode <em>Password Reset Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Reset Code</em>' attribute.
	 * @see #getPasswordResetCode()
	 * @generated
	 */
	void setPasswordResetCode(String value);

	/**
	 * Returns the value of the '<em><b>Password Reset Expiry Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time when the passwordResetCode becomes no longer usable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password Reset Expiry Time</em>' attribute.
	 * @see #setPasswordResetExpiryTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_PasswordResetExpiryTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getPasswordResetExpiryTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getPasswordResetExpiryTime <em>Password Reset Expiry Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Reset Expiry Time</em>' attribute.
	 * @see #getPasswordResetExpiryTime()
	 * @generated
	 */
	void setPasswordResetExpiryTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Client Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * OAuth 2.0 access token usable by official client applications (Android, iOS, etc.).
	 * This is for simple usage, with no expiration (though regenerating the client access token is possible if the access token is compromised). For more complex usage like third party applications, use another mechanism.
	 * 
	 * The 'client_id' and 'callback_url' (or 'callback_domains') should be specified elsewhere (probably on AppManifest?)
	 * 
	 * See: https://developer.foursquare.com/overview/auth.html
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Access Token</em>' attribute.
	 * @see #setClientAccessToken(String)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_ClientAccessToken()
	 * @model
	 * @generated
	 */
	String getClientAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getClientAccessToken <em>Client Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Access Token</em>' attribute.
	 * @see #getClientAccessToken()
	 * @generated
	 */
	void setClientAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Security Role Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Role Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Role Ids</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_SecurityRoleIds()
	 * @model
	 * @generated
	 */
	EList<String> getSecurityRoleIds();

	/**
	 * Returns the value of the '<em><b>Debit Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debit Balance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debit Balance</em>' attribute.
	 * @see #setDebitBalance(BigDecimal)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_DebitBalance()
	 * @model
	 * @generated
	 */
	BigDecimal getDebitBalance();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getDebitBalance <em>Debit Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debit Balance</em>' attribute.
	 * @see #getDebitBalance()
	 * @generated
	 */
	void setDebitBalance(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Debit Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debit Currency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debit Currency</em>' attribute.
	 * @see #setDebitCurrency(CurrencyUnit)
	 * @see org.soluvas.commons.CommonsPackage#getPerson_DebitCurrency()
	 * @model dataType="org.soluvas.commons.CurrencyUnit"
	 * @generated
	 */
	CurrencyUnit getDebitCurrency();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Person#getDebitCurrency <em>Debit Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debit Currency</em>' attribute.
	 * @see #getDebitCurrency()
	 * @generated
	 */
	void setDebitCurrency(CurrencyUnit value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Person"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getPerson_Type()
	 * @model default="Person" changeable="false"
	 * @generated
	 */
	String getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the email is already in its list.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEmail(String email);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puts the (normalized) email, and sets it as primary if the only one. Has no effect if already exists. Returns the added Email contained object.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	Email putEmail(String email);

} // Person
