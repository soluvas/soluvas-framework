/**
 */
package org.soluvas.commons;

import java.util.Locale;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTimeZone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AppManifest is actually a misnomer, it should've been called TenantManifest instead, which is the primary (non-sysconfig) information about a tenant.
 * 
 * <p>Attributes are optional because can use OverlayingSupplier.
 * 
 * <p>Expandable attributes are: domain, generalEmail.
 * 
 * <p>Expansion variables are: fqdn (host-dependent), appDomain (from properties), userName (from System property user.name), domain (can only be used by other attributes than domain itself).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmail <em>General Email</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationName <em>Organization Name</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationAddress <em>Organization Address</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterSalutation <em>Letter Salutation</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterClosing <em>Letter Closing</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultTimeZoneId <em>Default Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultTimeZone <em>Default Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCurrencyCode <em>Default Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCurrency <em>Default Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getEmailLogoUriTemplate <em>Email Logo Uri Template</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultLanguageTag <em>Default Language Tag</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCountryCode <em>Default Country Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getAppManifest()
 * @model
 * @generated
 */
public interface AppManifest extends Positionable, ResourceAware, BundleAware, Expandable {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Short description to be used in page title, usually 3-10 words.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Summary</em>' attribute.
	 * @see #setSummary(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_Summary()
	 * @model
	 * @generated
	 */
	String getSummary();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getSummary <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary</em>' attribute.
	 * @see #getSummary()
	 * @generated
	 */
	void setSummary(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Longer description to be used in meta description, recommended to be less than 160 characters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute.
	 * The default value is <code>"{+tenantId}.{+appDomain}"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary domain name of the application, e.g. "berbatik.com". Used by Email system.
	 * 
	 * <p>For development, use e.g. "berbatik.annafi.dev".
	 * 
	 * <p>TODO: title & domain should probably be moved somewhere else, since it's tenant & environment specific.
	 * 
	 * <p>Production: title=Berbatik, domain=berbatik.com
	 * 
	 * <p>Staging: title=Berbatik stg, domain=stg.berbatik.com
	 * 
	 * <p>Development: title=Berbatik Annafi, domain=berbatik.annafi.dev
	 * 
	 * <p>Description usually stays the same, but can be different too.
	 * 
	 * <p>Templated using URI templates. e.g. to use {@code appDomain} variable, i.e. "acme.{+appDomain}",
	 * that will be expanded when you call {@link #expand()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain</em>' attribute.
	 * @see #setDomain(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_Domain()
	 * @model default="{+tenantId}.{+appDomain}"
	 * @generated
	 */
	String getDomain();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' attribute.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(String value);

	/**
	 * Returns the value of the '<em><b>General Email</b></em>' attribute.
	 * The default value is <code>"{+userName}@{+fqdn}"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Email address used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application.
	 * The default templated generalEmail is "{+userName}@{+fqdn}" so that in a development environment, a default postfix and dovecot installation will allow the developer to receive incoming emails and replies.
	 * 
	 * <p>Templated using URI templates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General Email</em>' attribute.
	 * @see #setGeneralEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_GeneralEmail()
	 * @model default="{+userName}@{+fqdn}"
	 * @generated
	 */
	String getGeneralEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getGeneralEmail <em>General Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Email</em>' attribute.
	 * @see #getGeneralEmail()
	 * @generated
	 */
	void setGeneralEmail(String value);

	/**
	 * Returns the value of the '<em><b>Organization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used in email notifications, e.g. "PT Berniaga Digital".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Organization Name</em>' attribute.
	 * @see #setOrganizationName(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_OrganizationName()
	 * @model
	 * @generated
	 */
	String getOrganizationName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getOrganizationName <em>Organization Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization Name</em>' attribute.
	 * @see #getOrganizationName()
	 * @generated
	 */
	void setOrganizationName(String value);

	/**
	 * Returns the value of the '<em><b>Organization Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used in email notifications, e.g. "Talavera Office Park, Jl. TB Simatupang KAV 20-22 Jakarta".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Organization Address</em>' attribute.
	 * @see #setOrganizationAddress(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_OrganizationAddress()
	 * @model
	 * @generated
	 */
	String getOrganizationAddress();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getOrganizationAddress <em>Organization Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization Address</em>' attribute.
	 * @see #getOrganizationAddress()
	 * @generated
	 */
	void setOrganizationAddress(String value);

	/**
	 * Returns the value of the '<em><b>Letter Salutation</b></em>' attribute.
	 * The default value is <code>"Hi"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SALUTATION (C) of the letter starts on the left margin two lines below the inside address for a business letter or five lines below the heading of a personal letter, if typed. All words in the salutation are capitalized, and the last word is followed by a comma in a personal letter or a colon in a business letter.
	 * Sample salutations are:
	 * 
	 * 
	 * Personal:
	 * Greetings Friend, Dear Bob, Hi Bob,
	 * 
	 * Business:
	 * Dear Mr. Jones: Dear Sir:
	 * Ladies and Gentlemen: Dear Mr./Mrs./Ms. Jones:
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Letter Salutation</em>' attribute.
	 * @see #setLetterSalutation(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_LetterSalutation()
	 * @model default="Hi"
	 * @generated
	 */
	String getLetterSalutation();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getLetterSalutation <em>Letter Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Letter Salutation</em>' attribute.
	 * @see #getLetterSalutation()
	 * @generated
	 */
	void setLetterSalutation(String value);

	/**
	 * Returns the value of the '<em><b>Letter Closing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first word of the CLOSING (E), which is placed several lines below the body, lines up with the first word in the heading and is the only word capitalized. A comma follows the closing.
	 * 
	 * Possible closings include:
	 * 
	 * Personal:
	 * Your friend, Missing you, Sincerely,
	 * Confused, Affectionately,Cordially,
	 * 
	 * Business:
	 * Sincerely yours, Yours truly,Respectfully yours,
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Letter Closing</em>' attribute.
	 * @see #setLetterClosing(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_LetterClosing()
	 * @model
	 * @generated
	 */
	String getLetterClosing();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getLetterClosing <em>Letter Closing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Letter Closing</em>' attribute.
	 * @see #getLetterClosing()
	 * @generated
	 */
	void setLetterClosing(String value);

	/**
	 * Returns the value of the '<em><b>Default Time Zone Id</b></em>' attribute.
	 * The default value is <code>"UTC"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default time zone for the application. For example this is used by perpetual inventory to store dates with a fixed reference timezone.
	 * It's a String, not a DateTimeZone object, to make it easier to edit the *.AppManifest.xmi file using generic EMF editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Time Zone Id</em>' attribute.
	 * @see #setDefaultTimeZoneId(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultTimeZoneId()
	 * @model default="UTC"
	 * @generated
	 */
	String getDefaultTimeZoneId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultTimeZoneId <em>Default Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Time Zone Id</em>' attribute.
	 * @see #getDefaultTimeZoneId()
	 * @generated
	 */
	void setDefaultTimeZoneId(String value);

	/**
	 * Returns the value of the '<em><b>Default Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reads directly from {@link #getDefaultTimeZoneId()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Time Zone</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultTimeZone()
	 * @model dataType="org.soluvas.commons.DateTimeZone" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	DateTimeZone getDefaultTimeZone();

	/**
	 * Returns the value of the '<em><b>Default Currency Code</b></em>' attribute.
	 * The default value is <code>"USD"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Currency Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is a String and not a CurrencyUnit object to aid visual editing using EMF Reflective Editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Currency Code</em>' attribute.
	 * @see #setDefaultCurrencyCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultCurrencyCode()
	 * @model default="USD"
	 * @generated
	 */
	String getDefaultCurrencyCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultCurrencyCode <em>Default Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Currency Code</em>' attribute.
	 * @see #getDefaultCurrencyCode()
	 * @generated
	 */
	void setDefaultCurrencyCode(String value);

	/**
	 * Returns the value of the '<em><b>Default Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Currency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reads directly from {@link #getDefaultCurrencyCode()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Currency</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultCurrency()
	 * @model dataType="org.soluvas.commons.CurrencyUnit" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	CurrencyUnit getDefaultCurrency();

	/**
	 * Returns the value of the '<em><b>Email Logo Uri Template</b></em>' attribute.
	 * The default value is <code>"{+imagesUri}tenant_common/logo_email.png"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URI to tenant logo usable when sending email notifications, by default the tenant logo URI template is: {+imagesUri}tenant_common/logo_email.png
	 * 
	 * <p>Width of 127 pixels is recommended with landscape ratio.
	 * 
	 * <p>Supported parameter is "imagesUri", which is from {link WebAddress#getImagesUri()}.
	 * 
	 * <p>You can have app-wide logo without any tenant_common folder by using URI template such as: {+imagesUri}/com.aksimata.app/aksimata_email_192x92.png
	 * 
	 * <p>To get the actual URI, call {@link AppUtils#getEmailLogoUri(AppManifest, WebAddress)}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Email Logo Uri Template</em>' attribute.
	 * @see #setEmailLogoUriTemplate(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_EmailLogoUriTemplate()
	 * @model default="{+imagesUri}tenant_common/logo_email.png"
	 * @generated
	 */
	String getEmailLogoUriTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getEmailLogoUriTemplate <em>Email Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Logo Uri Template</em>' attribute.
	 * @see #getEmailLogoUriTemplate()
	 * @generated
	 */
	void setEmailLogoUriTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Default Language Tag</b></em>' attribute.
	 * The default value is <code>"en-US"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * IETF BCP 47 language tag string, e.g. {@code id-ID}. This is different than {@code defaultCountryCode}, because {@code defaultLanguageTag} is used to determine the {@link java.util.Locale}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Language Tag</em>' attribute.
	 * @see #setDefaultLanguageTag(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultLanguageTag()
	 * @model default="en-US"
	 * @generated
	 */
	String getDefaultLanguageTag();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultLanguageTag <em>Default Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Language Tag</em>' attribute.
	 * @see #getDefaultLanguageTag()
	 * @generated
	 */
	void setDefaultLanguageTag(String value);

	/**
	 * Returns the value of the '<em><b>Default Country Code</b></em>' attribute.
	 * The default value is <code>"US"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default country code in ISO 3166-1 alpha-2. It is used for e.g. fill the country field in new PostalAddress form.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Country Code</em>' attribute.
	 * @see #setDefaultCountryCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultCountryCode()
	 * @model default="US"
	 * @generated
	 */
	String getDefaultCountryCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultCountryCode <em>Default Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Country Code</em>' attribute.
	 * @see #getDefaultCountryCode()
	 * @generated
	 */
	void setDefaultCountryCode(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the {@link java.util.Locale} referred by {@link @getDefaultLanguageTag()}.
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.soluvas.commons.Locale" required="true"
	 * @generated
	 */
	Locale getDefaultLocale();

} // AppManifest
