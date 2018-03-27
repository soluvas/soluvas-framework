/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.soluvas.commons.util.AppUtils;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import java.math.BigDecimal;
import java.util.Locale;

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
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomainPrd <em>Domain Prd</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomainDev <em>Domain Dev</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomainStg <em>Domain Stg</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmail <em>General Email</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmailPrd <em>General Email Prd</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmailDev <em>General Email Dev</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmailStg <em>General Email Stg</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationName <em>Organization Name</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationAddress <em>Organization Address</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationPhoneNumbers <em>Organization Phone Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultTimeZoneId <em>Default Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultTimeZone <em>Default Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCurrencyCode <em>Default Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCurrency <em>Default Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultLanguageTag <em>Default Language Tag</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCountryCode <em>Default Country Code</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultCategoryUName <em>Default Category UName</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getEmailLogoUriTemplate <em>Email Logo Uri Template</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterSalutation <em>Letter Salutation</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterClosing <em>Letter Closing</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getFootnote <em>Footnote</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getWwwUsed <em>Www Used</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getHeadNote <em>Head Note</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getHeadTitle <em>Head Title</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultStyle <em>Default Style</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultVariation <em>Default Variation</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getKursDollarPaypal <em>Kurs Dollar Paypal</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getKursDollarDpex <em>Kurs Dollar Dpex</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getReminderSchedule <em>Reminder Schedule</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getReminderPeriodStr <em>Reminder Period Str</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getReminderPeriod <em>Reminder Period</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getReminderScheduleStr <em>Reminder Schedule Str</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getSupportEmail <em>Support Email</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getAppManifest()
 * @see Tenant
 * @model
 */
public interface AppManifest extends Positionable, ResourceAware, BundleAware, Expandable {
	
	public static final String ENV_DEV = "dev";
	public static final String ENV_STG_PREFIX = "st";
	public static final String ENV_PRD = "prd";
	
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary domain name of the application for current environment, e.g. "berbatik.com". Used by Email system. URI templatable using "appDomain", "fqdn", "tenantId", "tenantEnv".
	 * 
	 * <p>TODO: make this read-only for future usage.
	 * 
	 * <p>For development, use e.g. "berbatik.annafi.dev".
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
	 * @model
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
	 * Returns the value of the '<em><b>Domain Prd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary domain name of the application for "prd" environment, e.g. "berbatik.com". Used by Email system. URI templatable using "appDomain", "fqdn", "tenantId", "tenantEnv".
	 * 
	 * <p>To get the real domain name, use {@link #getRealDomain(String)} instead.
	 * 
	 * <p>For development, use e.g. "berbatik.annafi.dev".
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
	 * @return the value of the '<em>Domain Prd</em>' attribute.
	 * @see #setDomainPrd(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DomainPrd()
	 * @model
	 * @generated
	 */
	String getDomainPrd();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDomainPrd <em>Domain Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Prd</em>' attribute.
	 * @see #getDomainPrd()
	 * @generated
	 */
	void setDomainPrd(String value);

	/**
	 * Returns the value of the '<em><b>Domain Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary domain name of the application for "dev" environment.
	 * URI templatable using "appDomain", "fqdn", "tenantId", "tenantEnv".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Dev</em>' attribute.
	 * @see #setDomainDev(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DomainDev()
	 * @model
	 * @generated
	 */
	String getDomainDev();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDomainDev <em>Domain Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Dev</em>' attribute.
	 * @see #getDomainDev()
	 * @generated
	 */
	void setDomainDev(String value);

	/**
	 * Returns the value of the '<em><b>Domain Stg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary domain name of the application for "dev" environment.
	 * URI templatable using "appDomain", "fqdn", "tenantId", "tenantEnv".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Stg</em>' attribute.
	 * @see #setDomainStg(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DomainStg()
	 * @model
	 * @generated
	 */
	String getDomainStg();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDomainStg <em>Domain Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Stg</em>' attribute.
	 * @see #getDomainStg()
	 * @generated
	 */
	void setDomainStg(String value);

	/**
	 * Returns the value of the '<em><b>General Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Email address (current environment) used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application.
	 * The default templated generalEmail is "{+userName}@{+fqdn}" so that in a development environment, a default postfix and dovecot installation will allow the developer to receive incoming emails and replies.
	 * 
	 * <p>Templated using URI templates.
	 * 
	 * <p>TODO: this should be read-only
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General Email</em>' attribute.
	 * @see #setGeneralEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_GeneralEmail()
	 * @model
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
	 * Returns the value of the '<em><b>General Email Prd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * General email for "prd" environment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General Email Prd</em>' attribute.
	 * @see #setGeneralEmailPrd(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_GeneralEmailPrd()
	 * @model
	 * @generated
	 */
	String getGeneralEmailPrd();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getGeneralEmailPrd <em>General Email Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Email Prd</em>' attribute.
	 * @see #getGeneralEmailPrd()
	 * @generated
	 */
	void setGeneralEmailPrd(String value);

	/**
	 * Returns the value of the '<em><b>General Email Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * General email for "dev" environment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General Email Dev</em>' attribute.
	 * @see #setGeneralEmailDev(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_GeneralEmailDev()
	 * @model
	 * @generated
	 */
	String getGeneralEmailDev();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getGeneralEmailDev <em>General Email Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Email Dev</em>' attribute.
	 * @see #getGeneralEmailDev()
	 * @generated
	 */
	void setGeneralEmailDev(String value);

	/**
	 * Returns the value of the '<em><b>General Email Stg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * General email for "stg" environment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General Email Stg</em>' attribute.
	 * @see #setGeneralEmailStg(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_GeneralEmailStg()
	 * @model
	 * @generated
	 */
	String getGeneralEmailStg();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getGeneralEmailStg <em>General Email Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Email Stg</em>' attribute.
	 * @see #getGeneralEmailStg()
	 * @generated
	 */
	void setGeneralEmailStg(String value);

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
	 * Returns the value of the '<em><b>Organization Phone Numbers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more telephone numbers (can be home, work, or mobile, it's not specified).
	 * They should conform to <a href="http://tools.ietf.org/html/rfc3966">tel: URI specification (RFC3966)</a> and <a href="http://tools.ietf.org/html/rfc5341">RFC5341</a>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Organization Phone Numbers</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_OrganizationPhoneNumbers()
	 * @model
	 * @generated
	 */
	EList<String> getOrganizationPhoneNumbers();

	/**
	 * Returns the value of the '<em><b>Letter Salutation</b></em>' attribute.
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
	 * @model
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
	 * Returns the value of the '<em><b>Footnote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The footnote is shown on all frontend pages, usually positioned below the main content, but above the footer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Footnote</em>' attribute.
	 * @see #setFootnote(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_Footnote()
	 * @model
	 * @generated
	 */
	String getFootnote();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getFootnote <em>Footnote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footnote</em>' attribute.
	 * @see #getFootnote()
	 * @generated
	 */
	void setFootnote(String value);

	/**
	 * Returns the value of the '<em><b>Www Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If {@code true}, {#link getWebHost()} will return "www." + domain. If {@code false}, just domain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Www Used</em>' attribute.
	 * @see #setWwwUsed(Boolean)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_WwwUsed()
	 * @model
	 * @generated
	 */
	@Nullable
	Boolean getWwwUsed();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getWwwUsed <em>Www Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Www Used</em>' attribute.
	 * @see #getWwwUsed()
	 * @generated
	 */
	void setWwwUsed(Boolean value);

	/**
	 * Returns the value of the '<em><b>Head Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The headnote is shown on all frontend pages, usually positioned above the main content, but above the banner.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Head Note</em>' attribute.
	 * @see #setHeadNote(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_HeadNote()
	 * @model
	 * @generated
	 */
	String getHeadNote();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getHeadNote <em>Head Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Note</em>' attribute.
	 * @see #getHeadNote()
	 * @generated
	 */
	void setHeadNote(String value);

	/**
	 * Returns the value of the '<em><b>Head Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The headtitle is shown on all frontend pages, usually positioned above the main content, but above the banner.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Head Title</em>' attribute.
	 * @see #setHeadTitle(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_HeadTitle()
	 * @model
	 * @generated
	 */
	String getHeadTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getHeadTitle <em>Head Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Title</em>' attribute.
	 * @see #getHeadTitle()
	 * @generated
	 */
	void setHeadTitle(String value);

	/**
	 * Returns the value of the '<em><b>Default Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default style name for Wicket, e.g. "fluid" (Cinta Lama's original theme, created by Ahmad Syarif Farsiado).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Style</em>' attribute.
	 * @see #setDefaultStyle(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultStyle()
	 * @model
	 * @generated
	 */
	String getDefaultStyle();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultStyle <em>Default Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Style</em>' attribute.
	 * @see #getDefaultStyle()
	 * @generated
	 */
	void setDefaultStyle(String value);

	/**
	 * Returns the value of the '<em><b>Default Variation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default style variation for Wicket, e.g. "default", "shop", "business" (for Queen theme).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Variation</em>' attribute.
	 * @see #setDefaultVariation(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultVariation()
	 * @model
	 * @generated
	 */
	String getDefaultVariation();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultVariation <em>Default Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Variation</em>' attribute.
	 * @see #getDefaultVariation()
	 * @generated
	 */
	void setDefaultVariation(String value);

	/**
	 * Returns the value of the '<em><b>Kurs Dollar Paypal</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kurs Dollar Paypal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kurs Dollar Paypal</em>' attribute.
	 * @see #setKursDollarPaypal(BigDecimal)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_KursDollarPaypal()
	 * @model default="0"
	 * @generated
	 */
	BigDecimal getKursDollarPaypal();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getKursDollarPaypal <em>Kurs Dollar Paypal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kurs Dollar Paypal</em>' attribute.
	 * @see #getKursDollarPaypal()
	 * @generated
	 */
	void setKursDollarPaypal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Kurs Dollar Dpex</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Kurs used by DPEX courier only
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kurs Dollar Dpex</em>' attribute.
	 * @see #setKursDollarDpex(BigDecimal)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_KursDollarDpex()
	 * @model default="0"
	 * @generated
	 */
	BigDecimal getKursDollarDpex();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getKursDollarDpex <em>Kurs Dollar Dpex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kurs Dollar Dpex</em>' attribute.
	 * @see #getKursDollarDpex()
	 * @generated
	 */
	void setKursDollarDpex(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Reminder Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reminder Schedule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When the reminder will be sent in that day, using the timezone of server.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reminder Schedule</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_ReminderSchedule()
	 * @model dataType="org.soluvas.commons.LocalTime" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	LocalTime getReminderSchedule();

	/**
	 * Returns the value of the '<em><b>Reminder Period Str</b></em>' attribute.
	 * The default value is <code>"P7D"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Period for general reminder, for example if reminderPeriod is "7D", when a product has been shipped the customer will be reminded after 7 days.
	 * The ready Period object can be fetched using {@link #getReminderPeriod()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reminder Period Str</em>' attribute.
	 * @see #setReminderPeriodStr(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_ReminderPeriodStr()
	 * @model default="P7D"
	 * @generated
	 */
	String getReminderPeriodStr();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getReminderPeriodStr <em>Reminder Period Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reminder Period Str</em>' attribute.
	 * @see #getReminderPeriodStr()
	 * @generated
	 */
	void setReminderPeriodStr(String value);

	/**
	 * Returns the value of the '<em><b>Reminder Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Period for general reminder, for example if reminderPeriod is "7D", when a product has been shipped the customer will be reminded after 7 days.
	 * The Period can be set in XMI using {@link #setReminderPeriodStr()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reminder Period</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_ReminderPeriod()
	 * @model dataType="org.soluvas.commons.Period" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Period getReminderPeriod();

	/**
	 * Returns the value of the '<em><b>Reminder Schedule Str</b></em>' attribute.
	 * The default value is <code>"18:00:00"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When the reminder will be sent in that day, using the timezone of mall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reminder Schedule Str</em>' attribute.
	 * @see #setReminderScheduleStr(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_ReminderScheduleStr()
	 * @model default="18:00:00"
	 * @generated
	 */
	String getReminderScheduleStr();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getReminderScheduleStr <em>Reminder Schedule Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reminder Schedule Str</em>' attribute.
	 * @see #getReminderScheduleStr()
	 * @generated
	 */
	void setReminderScheduleStr(String value);

	/**
	 * Returns the value of the '<em><b>Support Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Email address (current environment) used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application.
	 * The default templated generalEmail is "{+userName}@{+fqdn}" so that in a development environment, a default postfix and dovecot installation will allow the developer to receive incoming emails and replies.
	 * 
	 * <p>Templated using URI templates.
	 * 
	 * <p>TODO: this should be read-only
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Support Email</em>' attribute.
	 * @see #setSupportEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_SupportEmail()
	 * @model
	 * @generated
	 */
	String getSupportEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getSupportEmail <em>Support Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support Email</em>' attribute.
	 * @see #getSupportEmail()
	 * @generated
	 */
	void setSupportEmail(String value);

	/**
	 * Returns the value of the '<em><b>Shipment Logo Uri Template</b></em>' attribute.
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
	 * @return the value of the '<em>Shipment Logo Uri Template</em>' attribute.
	 * @see #setShipmentLogoUriTemplate(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_ShipmentLogoUriTemplate()
	 * @model
	 * @generated
	 */
	String getShipmentLogoUriTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getShipmentLogoUriTemplate <em>Shipment Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shipment Logo Uri Template</em>' attribute.
	 * @see #getShipmentLogoUriTemplate()
	 * @generated
	 */
	void setShipmentLogoUriTemplate(String value);

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
	 * @model
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
	 * Returns the value of the '<em><b>Default Category UName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If specified, this will be the {@link org.soluvas.category.Category}'s UName to use when creating a new application entity (such as {@link id.co.bippo.product.VariedProduct}).
	 * If not specified, please choose the first <b>leaf</b> {@link org.soluvas.category.Category} instead (which must exist).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Category UName</em>' attribute.
	 * @see #setDefaultCategoryUName(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultCategoryUName()
	 * @model
	 * @generated
	 */
	String getDefaultCategoryUName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultCategoryUName <em>Default Category UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Category UName</em>' attribute.
	 * @see #getDefaultCategoryUName()
	 * @generated
	 */
	void setDefaultCategoryUName(String value);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If {@link #isWwwUsed()} is {@code true}, will return "www." + {@link #getDomain()}. Otherwise, just {@link #getDomain()}.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getWebHost();

} // AppManifest
