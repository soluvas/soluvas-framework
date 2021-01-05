package org.soluvas.commons.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsException;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Expandable;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;

import com.damnhandy.uri.template.MalformedUriTemplateException;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.VariableExpansionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getExpansionState <em>Expansion State</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDomainPrd <em>Domain Prd</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDomainDev <em>Domain Dev</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDomainStg <em>Domain Stg</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getGeneralEmail <em>General Email</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getGeneralEmailPrd <em>General Email Prd</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getGeneralEmailDev <em>General Email Dev</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getGeneralEmailStg <em>General Email Stg</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getOrganizationName <em>Organization Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getOrganizationAddress <em>Organization Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getOrganizationPhoneNumbers <em>Organization Phone Numbers</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultTimeZoneId <em>Default Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultTimeZone <em>Default Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCurrencyCode <em>Default Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCurrency <em>Default Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultLanguageTag <em>Default Language Tag</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCountryCode <em>Default Country Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCategoryUName <em>Default Category UName</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getEmailLogoUriTemplate <em>Email Logo Uri Template</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getLetterSalutation <em>Letter Salutation</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getLetterClosing <em>Letter Closing</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getFootnote <em>Footnote</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getWwwUsed <em>Www Used</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getHeadNote <em>Head Note</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getHeadTitle <em>Head Title</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultStyle <em>Default Style</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultVariation <em>Default Variation</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getKursDollarPaypal <em>Kurs Dollar Paypal</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getKursDollarDpex <em>Kurs Dollar Dpex</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getReminderSchedule <em>Reminder Schedule</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getReminderPeriodStr <em>Reminder Period Str</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getReminderPeriod <em>Reminder Period</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getReminderScheduleStr <em>Reminder Schedule Str</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getSupportEmail <em>Support Email</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getShipmentLogoUriTemplate <em>Shipment Logo Uri Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AppManifestImpl extends MinimalEObjectImpl.Container implements AppManifest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(AppManifestImpl.class);
	
	/**
	 * Ordering matters! i.e. {@code co.id} will be stripped <i>before</i> {@code id}.
	 */
	public static final ImmutableSet<String> TLDS = ImmutableSet.of(
			"com", "net", "org", "biz", "info", "asia", "co", "co.id", "or.id", "web.id", "ac.id", "id", "web");

	/**
	 * The default value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected static final Integer POSITIONER_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected Integer positioner = POSITIONER_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.BUNDLE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpansionState() <em>Expansion State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpansionState()
	 * @generated
	 * @ordered
	 */
	protected static final ExpansionState EXPANSION_STATE_EDEFAULT = ExpansionState.UNEXPANDED;

	/**
	 * The cached value of the '{@link #getExpansionState() <em>Expansion State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpansionState()
	 * @generated
	 * @ordered
	 */
	protected ExpansionState expansionState = EXPANSION_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected String summary = SUMMARY_EDEFAULT;

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
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected String domain = DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDomainPrd() <em>Domain Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainPrd()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_PRD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDomainPrd() <em>Domain Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainPrd()
	 * @generated
	 * @ordered
	 */
	protected String domainPrd = DOMAIN_PRD_EDEFAULT;
	/**
	 * The default value of the '{@link #getDomainDev() <em>Domain Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainDev()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_DEV_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDomainDev() <em>Domain Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainDev()
	 * @generated
	 * @ordered
	 */
	protected String domainDev = DOMAIN_DEV_EDEFAULT;
	/**
	 * The default value of the '{@link #getDomainStg() <em>Domain Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainStg()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_STG_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDomainStg() <em>Domain Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainStg()
	 * @generated
	 * @ordered
	 */
	protected String domainStg = DOMAIN_STG_EDEFAULT;
	/**
	 * The default value of the '{@link #getGeneralEmail() <em>General Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERAL_EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneralEmail() <em>General Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmail()
	 * @generated
	 * @ordered
	 */
	protected String generalEmail = GENERAL_EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeneralEmailPrd() <em>General Email Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailPrd()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERAL_EMAIL_PRD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGeneralEmailPrd() <em>General Email Prd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailPrd()
	 * @generated
	 * @ordered
	 */
	protected String generalEmailPrd = GENERAL_EMAIL_PRD_EDEFAULT;
	/**
	 * The default value of the '{@link #getGeneralEmailDev() <em>General Email Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailDev()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERAL_EMAIL_DEV_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGeneralEmailDev() <em>General Email Dev</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailDev()
	 * @generated
	 * @ordered
	 */
	protected String generalEmailDev = GENERAL_EMAIL_DEV_EDEFAULT;
	/**
	 * The default value of the '{@link #getGeneralEmailStg() <em>General Email Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailStg()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERAL_EMAIL_STG_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGeneralEmailStg() <em>General Email Stg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralEmailStg()
	 * @generated
	 * @ordered
	 */
	protected String generalEmailStg = GENERAL_EMAIL_STG_EDEFAULT;
	/**
	 * The default value of the '{@link #getOrganizationName() <em>Organization Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationName()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrganizationName() <em>Organization Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationName()
	 * @generated
	 * @ordered
	 */
	protected String organizationName = ORGANIZATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrganizationAddress() <em>Organization Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATION_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrganizationAddress() <em>Organization Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationAddress()
	 * @generated
	 * @ordered
	 */
	protected String organizationAddress = ORGANIZATION_ADDRESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrganizationPhoneNumbers() <em>Organization Phone Numbers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganizationPhoneNumbers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> organizationPhoneNumbers;
	/**
	 * The default value of the '{@link #getDefaultTimeZoneId() <em>Default Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTimeZoneId()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_TIME_ZONE_ID_EDEFAULT = "UTC";

	/**
	 * The cached value of the '{@link #getDefaultTimeZoneId() <em>Default Time Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTimeZoneId()
	 * @generated
	 * @ordered
	 */
	protected String defaultTimeZoneId = DEFAULT_TIME_ZONE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultTimeZone() <em>Default Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTimeZone()
	 * @generated
	 * @ordered
	 */
	protected static final DateTimeZone DEFAULT_TIME_ZONE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDefaultCurrencyCode() <em>Default Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCurrencyCode()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CURRENCY_CODE_EDEFAULT = "IDR";

	/**
	 * The cached value of the '{@link #getDefaultCurrencyCode() <em>Default Currency Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCurrencyCode()
	 * @generated
	 * @ordered
	 */
	protected String defaultCurrencyCode = DEFAULT_CURRENCY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultCurrency() <em>Default Currency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final CurrencyUnit DEFAULT_CURRENCY_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDefaultLanguageTag() <em>Default Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultLanguageTag()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_LANGUAGE_TAG_EDEFAULT = "en-US";

	/**
	 * The cached value of the '{@link #getDefaultLanguageTag() <em>Default Language Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultLanguageTag()
	 * @generated
	 * @ordered
	 */
	protected String defaultLanguageTag = DEFAULT_LANGUAGE_TAG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultCountryCode() <em>Default Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCountryCode()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_COUNTRY_CODE_EDEFAULT = "US";

	/**
	 * The cached value of the '{@link #getDefaultCountryCode() <em>Default Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCountryCode()
	 * @generated
	 * @ordered
	 */
	protected String defaultCountryCode = DEFAULT_COUNTRY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultCategoryUName() <em>Default Category UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCategoryUName()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CATEGORY_UNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefaultCategoryUName() <em>Default Category UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCategoryUName()
	 * @generated
	 * @ordered
	 */
	protected String defaultCategoryUName = DEFAULT_CATEGORY_UNAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getEmailLogoUriTemplate() <em>Email Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailLogoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_LOGO_URI_TEMPLATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEmailLogoUriTemplate() <em>Email Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailLogoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected String emailLogoUriTemplate = EMAIL_LOGO_URI_TEMPLATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getLetterSalutation() <em>Letter Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLetterSalutation()
	 * @generated
	 * @ordered
	 */
	protected static final String LETTER_SALUTATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLetterSalutation() <em>Letter Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLetterSalutation()
	 * @generated
	 * @ordered
	 */
	protected String letterSalutation = LETTER_SALUTATION_EDEFAULT;
	/**
	 * The default value of the '{@link #getLetterClosing() <em>Letter Closing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLetterClosing()
	 * @generated
	 * @ordered
	 */
	protected static final String LETTER_CLOSING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLetterClosing() <em>Letter Closing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLetterClosing()
	 * @generated
	 * @ordered
	 */
	protected String letterClosing = LETTER_CLOSING_EDEFAULT;

	/**
	 * The default value of the '{@link #getFootnote() <em>Footnote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootnote()
	 * @generated
	 * @ordered
	 */
	protected static final String FOOTNOTE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFootnote() <em>Footnote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootnote()
	 * @generated
	 * @ordered
	 */
	protected String footnote = FOOTNOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWwwUsed() <em>Www Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWwwUsed()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean WWW_USED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWwwUsed() <em>Www Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWwwUsed()
	 * @generated
	 * @ordered
	 */
	protected Boolean wwwUsed = WWW_USED_EDEFAULT;
	/**
	 * The default value of the '{@link #getHeadNote() <em>Head Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNote()
	 * @generated
	 * @ordered
	 */
	protected static final String HEAD_NOTE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHeadNote() <em>Head Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNote()
	 * @generated
	 * @ordered
	 */
	protected String headNote = HEAD_NOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeadTitle() <em>Head Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String HEAD_TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHeadTitle() <em>Head Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadTitle()
	 * @generated
	 * @ordered
	 */
	protected String headTitle = HEAD_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultStyle() <em>Default Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_STYLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefaultStyle() <em>Default Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultStyle()
	 * @generated
	 * @ordered
	 */
	protected String defaultStyle = DEFAULT_STYLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getDefaultVariation() <em>Default Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultVariation()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VARIATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefaultVariation() <em>Default Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultVariation()
	 * @generated
	 * @ordered
	 */
	protected String defaultVariation = DEFAULT_VARIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getKursDollarPaypal() <em>Kurs Dollar Paypal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKursDollarPaypal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal KURS_DOLLAR_PAYPAL_EDEFAULT = new BigDecimal("0");
	/**
	 * The cached value of the '{@link #getKursDollarPaypal() <em>Kurs Dollar Paypal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKursDollarPaypal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal kursDollarPaypal = KURS_DOLLAR_PAYPAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getKursDollarDpex() <em>Kurs Dollar Dpex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKursDollarDpex()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal KURS_DOLLAR_DPEX_EDEFAULT = new BigDecimal("0");
	/**
	 * The cached value of the '{@link #getKursDollarDpex() <em>Kurs Dollar Dpex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKursDollarDpex()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal kursDollarDpex = KURS_DOLLAR_DPEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReminderSchedule() <em>Reminder Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderSchedule()
	 * @generated
	 * @ordered
	 */
	protected static final LocalTime REMINDER_SCHEDULE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getReminderPeriodStr() <em>Reminder Period Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderPeriodStr()
	 * @generated
	 * @ordered
	 */
	protected static final String REMINDER_PERIOD_STR_EDEFAULT = "P7D";
	/**
	 * The cached value of the '{@link #getReminderPeriodStr() <em>Reminder Period Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderPeriodStr()
	 * @generated
	 * @ordered
	 */
	protected String reminderPeriodStr = REMINDER_PERIOD_STR_EDEFAULT;
	/**
	 * The default value of the '{@link #getReminderPeriod() <em>Reminder Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final Period REMINDER_PERIOD_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getReminderScheduleStr() <em>Reminder Schedule Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderScheduleStr()
	 * @generated
	 * @ordered
	 */
	protected static final String REMINDER_SCHEDULE_STR_EDEFAULT = "18:00:00";
	/**
	 * The cached value of the '{@link #getReminderScheduleStr() <em>Reminder Schedule Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReminderScheduleStr()
	 * @generated
	 * @ordered
	 */
	protected String reminderScheduleStr = REMINDER_SCHEDULE_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSupportEmail() <em>Support Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPORT_EMAIL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSupportEmail() <em>Support Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportEmail()
	 * @generated
	 * @ordered
	 */
	protected String supportEmail = SUPPORT_EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getShipmentLogoUriTemplate() <em>Shipment Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShipmentLogoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String SHIPMENT_LOGO_URI_TEMPLATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getShipmentLogoUriTemplate() <em>Shipment Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShipmentLogoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected String shipmentLogoUriTemplate = SHIPMENT_LOGO_URI_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.APP_MANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__POSITIONER, oldPositioner, positioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpansionState getExpansionState() {
		return expansionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSummary() {
		return summary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSummary(String newSummary) {
		String oldSummary = summary;
		summary = newSummary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__SUMMARY, oldSummary, summary));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomain(String newDomain) {
		String oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainPrd() {
		return domainPrd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainPrd(String newDomainPrd) {
		String oldDomainPrd = domainPrd;
		domainPrd = newDomainPrd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DOMAIN_PRD, oldDomainPrd, domainPrd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainDev() {
		return domainDev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainDev(String newDomainDev) {
		String oldDomainDev = domainDev;
		domainDev = newDomainDev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DOMAIN_DEV, oldDomainDev, domainDev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainStg() {
		return domainStg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainStg(String newDomainStg) {
		String oldDomainStg = domainStg;
		domainStg = newDomainStg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DOMAIN_STG, oldDomainStg, domainStg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGeneralEmail() {
		return generalEmail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneralEmail(String newGeneralEmail) {
		String oldGeneralEmail = generalEmail;
		generalEmail = newGeneralEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__GENERAL_EMAIL, oldGeneralEmail, generalEmail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGeneralEmailPrd() {
		return generalEmailPrd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneralEmailPrd(String newGeneralEmailPrd) {
		String oldGeneralEmailPrd = generalEmailPrd;
		generalEmailPrd = newGeneralEmailPrd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD, oldGeneralEmailPrd, generalEmailPrd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGeneralEmailDev() {
		return generalEmailDev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneralEmailDev(String newGeneralEmailDev) {
		String oldGeneralEmailDev = generalEmailDev;
		generalEmailDev = newGeneralEmailDev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV, oldGeneralEmailDev, generalEmailDev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGeneralEmailStg() {
		return generalEmailStg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneralEmailStg(String newGeneralEmailStg) {
		String oldGeneralEmailStg = generalEmailStg;
		generalEmailStg = newGeneralEmailStg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG, oldGeneralEmailStg, generalEmailStg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrganizationName(String newOrganizationName) {
		String oldOrganizationName = organizationName;
		organizationName = newOrganizationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME, oldOrganizationName, organizationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOrganizationAddress() {
		return organizationAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrganizationAddress(String newOrganizationAddress) {
		String oldOrganizationAddress = organizationAddress;
		organizationAddress = newOrganizationAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS, oldOrganizationAddress, organizationAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOrganizationPhoneNumbers() {
		if (organizationPhoneNumbers == null) {
			organizationPhoneNumbers = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS);
		}
		return organizationPhoneNumbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLetterSalutation() {
		return letterSalutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLetterSalutation(String newLetterSalutation) {
		String oldLetterSalutation = letterSalutation;
		letterSalutation = newLetterSalutation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__LETTER_SALUTATION, oldLetterSalutation, letterSalutation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLetterClosing() {
		return letterClosing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLetterClosing(String newLetterClosing) {
		String oldLetterClosing = letterClosing;
		letterClosing = newLetterClosing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__LETTER_CLOSING, oldLetterClosing, letterClosing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFootnote() {
		return footnote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFootnote(String newFootnote) {
		String oldFootnote = footnote;
		footnote = newFootnote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__FOOTNOTE, oldFootnote, footnote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getWwwUsed() {
		return wwwUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWwwUsed(Boolean newWwwUsed) {
		Boolean oldWwwUsed = wwwUsed;
		wwwUsed = newWwwUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__WWW_USED, oldWwwUsed, wwwUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeadNote() {
		return headNote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeadNote(String newHeadNote) {
		String oldHeadNote = headNote;
		headNote = newHeadNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__HEAD_NOTE, oldHeadNote, headNote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeadTitle() {
		return headTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeadTitle(String newHeadTitle) {
		String oldHeadTitle = headTitle;
		headTitle = newHeadTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__HEAD_TITLE, oldHeadTitle, headTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultStyle() {
		return defaultStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultStyle(String newDefaultStyle) {
		String oldDefaultStyle = defaultStyle;
		defaultStyle = newDefaultStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_STYLE, oldDefaultStyle, defaultStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultVariation() {
		return defaultVariation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultVariation(String newDefaultVariation) {
		String oldDefaultVariation = defaultVariation;
		defaultVariation = newDefaultVariation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_VARIATION, oldDefaultVariation, defaultVariation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getKursDollarPaypal() {
		return kursDollarPaypal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKursDollarPaypal(BigDecimal newKursDollarPaypal) {
		BigDecimal oldKursDollarPaypal = kursDollarPaypal;
		kursDollarPaypal = newKursDollarPaypal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__KURS_DOLLAR_PAYPAL, oldKursDollarPaypal, kursDollarPaypal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigDecimal getKursDollarDpex() {
		return kursDollarDpex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKursDollarDpex(BigDecimal newKursDollarDpex) {
		BigDecimal oldKursDollarDpex = kursDollarDpex;
		kursDollarDpex = newKursDollarDpex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__KURS_DOLLAR_DPEX, oldKursDollarDpex, kursDollarDpex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public LocalTime getReminderSchedule() {
		return getReminderScheduleStr() != null ? new LocalTime(getReminderScheduleStr()) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReminderPeriodStr() {
		return reminderPeriodStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReminderPeriodStr(String newReminderPeriodStr) {
		String oldReminderPeriodStr = reminderPeriodStr;
		reminderPeriodStr = newReminderPeriodStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__REMINDER_PERIOD_STR, oldReminderPeriodStr, reminderPeriodStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Period getReminderPeriod() {
		return getReminderPeriodStr() != null ? Period.parse(getReminderPeriodStr()) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReminderScheduleStr() {
		return reminderScheduleStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReminderScheduleStr(String newReminderScheduleStr) {
		String oldReminderScheduleStr = reminderScheduleStr;
		reminderScheduleStr = newReminderScheduleStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE_STR, oldReminderScheduleStr, reminderScheduleStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSupportEmail() {
		return supportEmail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportEmail(String newSupportEmail) {
		String oldSupportEmail = supportEmail;
		supportEmail = newSupportEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__SUPPORT_EMAIL, oldSupportEmail, supportEmail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShipmentLogoUriTemplate() {
		return shipmentLogoUriTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShipmentLogoUriTemplate(String newShipmentLogoUriTemplate) {
		String oldShipmentLogoUriTemplate = shipmentLogoUriTemplate;
		shipmentLogoUriTemplate = newShipmentLogoUriTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__SHIPMENT_LOGO_URI_TEMPLATE, oldShipmentLogoUriTemplate, shipmentLogoUriTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultTimeZoneId() {
		return defaultTimeZoneId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultTimeZoneId(String newDefaultTimeZoneId) {
		String oldDefaultTimeZoneId = defaultTimeZoneId;
		defaultTimeZoneId = newDefaultTimeZoneId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID, oldDefaultTimeZoneId, defaultTimeZoneId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @Nullable
	public DateTimeZone getDefaultTimeZone() {
		return getDefaultTimeZoneId() != null ? DateTimeZone.forID(getDefaultTimeZoneId()) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultCurrencyCode(String newDefaultCurrencyCode) {
		String oldDefaultCurrencyCode = defaultCurrencyCode;
		defaultCurrencyCode = newDefaultCurrencyCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE, oldDefaultCurrencyCode, defaultCurrencyCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override @Nullable
	public CurrencyUnit getDefaultCurrency() {
		return getDefaultCurrencyCode() != null ? Monetary.getCurrency(getDefaultCurrencyCode()) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEmailLogoUriTemplate() {
		return emailLogoUriTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmailLogoUriTemplate(String newEmailLogoUriTemplate) {
		String oldEmailLogoUriTemplate = emailLogoUriTemplate;
		emailLogoUriTemplate = newEmailLogoUriTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE, oldEmailLogoUriTemplate, emailLogoUriTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultLanguageTag() {
		return defaultLanguageTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultLanguageTag(String newDefaultLanguageTag) {
		String oldDefaultLanguageTag = defaultLanguageTag;
		defaultLanguageTag = newDefaultLanguageTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG, oldDefaultLanguageTag, defaultLanguageTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultCountryCode() {
		return defaultCountryCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultCountryCode(String newDefaultCountryCode) {
		String oldDefaultCountryCode = defaultCountryCode;
		defaultCountryCode = newDefaultCountryCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE, oldDefaultCountryCode, defaultCountryCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultCategoryUName() {
		return defaultCategoryUName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultCategoryUName(String newDefaultCategoryUName) {
		String oldDefaultCategoryUName = defaultCategoryUName;
		defaultCategoryUName = newDefaultCategoryUName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME, oldDefaultCategoryUName, defaultCategoryUName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Locale getDefaultLocale() {
		return Locale.forLanguageTag(getDefaultLanguageTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getWebHost() {
		Preconditions.checkNotNull(getDomain(),
				"Internal error: AppManifestImpl.getDomain() should never be null, because AppManifest.domain is always set by expand(). appManifest=%s",
				this);
		Preconditions.checkNotNull(getWwwUsed(),
				"Internal error: AppManifestImpl.getWwwUsed() should never be null, because AppManifest.wwwUsed is always set by expand(). appManifest=%s",
				this);
		return getWwwUsed() ?  "www." + getDomain() : getDomain();
	}

	/**
	 * Sets proper {@link #setDomain(String)} based on {@code tenantEnv}.
	 * @param tenantEnv
	 */
	private void setDomainByTenantEnv(String tenantEnv) {
		if (ENV_PRD.equals(tenantEnv)) {
			if (getDomainPrd() != null) {
				log.trace("Set domain from prd: {}", getDomainPrd());
				setDomain(getDomainPrd());
			}
		} else if (tenantEnv.startsWith(ENV_STG_PREFIX)) {
			if (getDomainStg() != null) {
				log.trace("Set domain from stg: {}", getDomainStg());
				setDomain(getDomainStg());
			}
		} else if (ENV_DEV.equals(tenantEnv)) {
			if (getDomainDev() != null) {
				log.trace("Set domain from dev: {}", getDomainDev());
				setDomain(getDomainDev());
			}
		} else {
			throw new CommonsException("Unrecognized tenantEnv '" + tenantEnv + "'!! on setDomainByTenantEnv");
		}
	}

	/**
	 * Sets proper {@link #setGeneralEmail(String)} based on {@code tenantEnv}.
	 * @param tenantEnv
	 */
	private void setGeneralEmailByTenantEnv(String tenantEnv) {
		if (ENV_PRD.equals(tenantEnv)) {
			if (getGeneralEmailPrd() != null) {
				log.trace("Set generalEmail from prd: {}", getGeneralEmailPrd());
				setGeneralEmail(getGeneralEmailPrd());
			}
		} else if (tenantEnv.startsWith(ENV_STG_PREFIX)) {
			if (getGeneralEmailStg() != null) {
				log.trace("Set generalEmail from stg: {}", getGeneralEmailStg());
				setGeneralEmail(getGeneralEmailStg());
			}
		} else if (ENV_DEV.equals(tenantEnv)) {
			if (getGeneralEmailDev() != null) {
				log.trace("Set generalEmail from dev: {}", getGeneralEmailDev());
				setGeneralEmail(getGeneralEmailDev());
			}
		} else {
			throw new CommonsException("Unrecognized tenantEnv '" + tenantEnv + "' on setGeneralEmailByTenantEnv");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void expand(final Map<String, Object> upScope) {
		if (getExpansionState() == ExpansionState.UNEXPANDED) {
			Preconditions.checkArgument(upScope.containsKey("tenantEnv"),
					"tenantEnv is required in scope, used to determine domain");
			log.debug("Expanding AppManifest '{}' using {}", getTitle(), upScope);
			try {
				final Map<String, Object> scope = new HashMap<>(upScope);
				// hub.properties#appDomain may be null (for single-tenant configs),
				// and if exists, it may contain URI template esp. {+fqdn}
				if (scope.get("appDomain") != null && ((String) scope.get("appDomain")).contains("{")) {
					scope.put("appDomain", UriTemplate.expand((String) scope.get("appDomain"), scope) );
				}
				if (getDomainPrd() != null && getDomainPrd().contains("{")) {
					log.trace("expanding domainPrd '{}' using: {}", getDomainPrd(), scope);
					setDomainPrd( UriTemplate.expand(getDomainPrd(), scope) );
					log.trace("domainPrd expanded to: {}", getDomainPrd());
				}
				if (getDomainDev() != null && getDomainDev().contains("{")) {
					log.trace("expanding domainDev '{}' using: {}", getDomainDev(), scope);
					setDomainDev( UriTemplate.expand(getDomainDev(), scope) );
					log.trace("domainDev expanded to: {}", getDomainDev());
				}
				if (getDomainStg() != null && getDomainStg().contains("{")) {
					log.trace("expanding domainStg '{}' using: {}", getDomainStg(), scope);
					setDomainStg( UriTemplate.expand(getDomainStg(), scope) );
					log.trace("domainStg expanded to: {}", getDomainStg());
				}
				setDomainByTenantEnv((String) scope.get("tenantEnv"));
				Preconditions.checkNotNull(getDomain(),
						"AppManifest.domain must not be null. tenantEnv=%s. domainPrd=%s. domainDev=%s. domainStg=%s",
						scope.get("tenantEnv"), getDomainPrd(), getDomainDev(), getDomainStg());
				if (getDomain().contains("{")) {
					log.trace("expanding domain '{}' using: {}", getDomain(), scope);
					setDomain( UriTemplate.expand(getDomain(), scope) );
					log.trace("domain expanded to: {}", getDomain());
				}
				// 'domain' variable can then be used by other attributes, if needed
				scope.put("domain", getDomain());
				if (getGeneralEmailPrd() != null && getGeneralEmailPrd().contains("{")) {
					log.trace("expanding generalEmailPrd '{}' using: {}", getGeneralEmailPrd(), scope);
					setGeneralEmailPrd( UriTemplate.expand(getGeneralEmailPrd(), scope) );
					log.trace("generalEmailPrd expanded to: {}", getGeneralEmailPrd());
				}
				if (getGeneralEmailDev() != null && getGeneralEmailDev().contains("{")) {
					log.trace("expanding generalEmailDev '{}' using: {}", getGeneralEmailDev(), scope);
					setGeneralEmailDev( UriTemplate.expand(getGeneralEmailDev(), scope) );
					log.trace("generalEmailDev expanded to: {}", getGeneralEmailDev());
				}
				if (getGeneralEmailStg() != null && getGeneralEmailStg().contains("{")) {
					log.trace("expanding generalEmailStg '{}' using: {}", getGeneralEmailStg(), scope);
					setGeneralEmailStg( UriTemplate.expand(getGeneralEmailStg(), scope) );
					log.trace("generalEmailStg expanded to: {}", getGeneralEmailStg());
				}
				setGeneralEmailByTenantEnv((String) scope.get("tenantEnv"));
				Preconditions.checkNotNull(getGeneralEmail(),
						"AppManifest.generalEmail must not be null. tenantEnv=%s. generalEmailPrd=%s. generalEmailDev=%s. generalEmailStg=%s",
						scope.get("tenantEnv"), getGeneralEmailPrd(), getGeneralEmailDev(), getGeneralEmailStg());
				if (getGeneralEmail().contains("{")) {
					log.trace("expanding generalEmail '{}' using: {}", getGeneralEmail(), scope);
					setGeneralEmail( UriTemplate.expand(getGeneralEmail(), scope) );
					log.trace("generalEmail expanded to: {}", getGeneralEmail());
				}
				
				// wwwUsed
				if (getWwwUsed() == null) {
					// for appDomain: tuneeca.com
					// current logic doesn't use appDomain but simply TLD
					// because stg.tuneeca.com is a valid appDomain but we won't prepend "www."
					// if it's used as tenant domain
					// tuneeca.com -> wwwUsed: true
					// demo.com -> wwwUsed: true
					// tuneeca.tuneeca.com -> wwwUsed: false
					// demo.tuneeca.com -> wwwUsed: false
					// need TLDs data for below:
					// somethingelse.com -> wwwUsed: true
					// stg.somethingelse.com -> wwwUsed: false
					// defaults to true, unless domain-without-TLD has a dot
					String withoutTld = getDomain();
					for (final String tld : TLDS) {
						if (getDomain().endsWith("." + tld)) {
							withoutTld = getDomain().substring(0, getDomain().length() - tld.length() - 1);
							break;
						}
					}
					setWwwUsed(!withoutTld.contains("."));
					log.trace("Setting wwwUsed={} from withoutTld '{}' for domain '{}'", getWwwUsed(), withoutTld, getDomain());
				} else {
					log.trace("wwwUsed for domain '{}' was already set to {}", getDomain(), getWwwUsed());
				}
				
				expansionState = ExpansionState.EXPANDED;
				log.debug("Expanded AppManifest '{}' to domain={} generalEmail={} wwwUsed={} using {}", 
						getTitle(), getDomain(), getGeneralEmail(), getWwwUsed(), upScope);
			} catch (MalformedUriTemplateException | VariableExpansionException e) {
				throw new CommonsException(e, "Cannot expand AppManifest '%s'", getTitle());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				return getPositioner();
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				return getResourceType();
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				return getResourceUri();
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				return getResourceName();
			case CommonsPackage.APP_MANIFEST__BUNDLE:
				return getBundle();
			case CommonsPackage.APP_MANIFEST__EXPANSION_STATE:
				return getExpansionState();
			case CommonsPackage.APP_MANIFEST__TITLE:
				return getTitle();
			case CommonsPackage.APP_MANIFEST__SUMMARY:
				return getSummary();
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				return getDescription();
			case CommonsPackage.APP_MANIFEST__DOMAIN:
				return getDomain();
			case CommonsPackage.APP_MANIFEST__DOMAIN_PRD:
				return getDomainPrd();
			case CommonsPackage.APP_MANIFEST__DOMAIN_DEV:
				return getDomainDev();
			case CommonsPackage.APP_MANIFEST__DOMAIN_STG:
				return getDomainStg();
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				return getGeneralEmail();
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD:
				return getGeneralEmailPrd();
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV:
				return getGeneralEmailDev();
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG:
				return getGeneralEmailStg();
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				return getOrganizationName();
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				return getOrganizationAddress();
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS:
				return getOrganizationPhoneNumbers();
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				return getDefaultTimeZoneId();
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE:
				return getDefaultTimeZone();
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				return getDefaultCurrencyCode();
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY:
				return getDefaultCurrency();
			case CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG:
				return getDefaultLanguageTag();
			case CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE:
				return getDefaultCountryCode();
			case CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME:
				return getDefaultCategoryUName();
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				return getEmailLogoUriTemplate();
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				return getLetterSalutation();
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				return getLetterClosing();
			case CommonsPackage.APP_MANIFEST__FOOTNOTE:
				return getFootnote();
			case CommonsPackage.APP_MANIFEST__WWW_USED:
				return getWwwUsed();
			case CommonsPackage.APP_MANIFEST__HEAD_NOTE:
				return getHeadNote();
			case CommonsPackage.APP_MANIFEST__HEAD_TITLE:
				return getHeadTitle();
			case CommonsPackage.APP_MANIFEST__DEFAULT_STYLE:
				return getDefaultStyle();
			case CommonsPackage.APP_MANIFEST__DEFAULT_VARIATION:
				return getDefaultVariation();
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_PAYPAL:
				return getKursDollarPaypal();
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_DPEX:
				return getKursDollarDpex();
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE:
				return getReminderSchedule();
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD_STR:
				return getReminderPeriodStr();
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD:
				return getReminderPeriod();
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE_STR:
				return getReminderScheduleStr();
			case CommonsPackage.APP_MANIFEST__SUPPORT_EMAIL:
				return getSupportEmail();
			case CommonsPackage.APP_MANIFEST__SHIPMENT_LOGO_URI_TEMPLATE:
				return getShipmentLogoUriTemplate();
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__TITLE:
				setTitle((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__SUMMARY:
				setSummary((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN:
				setDomain((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_PRD:
				setDomainPrd((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_DEV:
				setDomainDev((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_STG:
				setDomainStg((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				setGeneralEmail((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD:
				setGeneralEmailPrd((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV:
				setGeneralEmailDev((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG:
				setGeneralEmailStg((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				setOrganizationName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				setOrganizationAddress((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS:
				getOrganizationPhoneNumbers().clear();
				getOrganizationPhoneNumbers().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				setDefaultTimeZoneId((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				setDefaultCurrencyCode((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG:
				setDefaultLanguageTag((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE:
				setDefaultCountryCode((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME:
				setDefaultCategoryUName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				setEmailLogoUriTemplate((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				setLetterSalutation((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				setLetterClosing((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__FOOTNOTE:
				setFootnote((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__WWW_USED:
				setWwwUsed((Boolean)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__HEAD_NOTE:
				setHeadNote((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__HEAD_TITLE:
				setHeadTitle((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_STYLE:
				setDefaultStyle((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_VARIATION:
				setDefaultVariation((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_PAYPAL:
				setKursDollarPaypal((BigDecimal)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_DPEX:
				setKursDollarDpex((BigDecimal)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD_STR:
				setReminderPeriodStr((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE_STR:
				setReminderScheduleStr((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__SUPPORT_EMAIL:
				setSupportEmail((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__SHIPMENT_LOGO_URI_TEMPLATE:
				setShipmentLogoUriTemplate((String)newValue);
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__SUMMARY:
				setSummary(SUMMARY_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_PRD:
				setDomainPrd(DOMAIN_PRD_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_DEV:
				setDomainDev(DOMAIN_DEV_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DOMAIN_STG:
				setDomainStg(DOMAIN_STG_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				setGeneralEmail(GENERAL_EMAIL_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD:
				setGeneralEmailPrd(GENERAL_EMAIL_PRD_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV:
				setGeneralEmailDev(GENERAL_EMAIL_DEV_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG:
				setGeneralEmailStg(GENERAL_EMAIL_STG_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				setOrganizationName(ORGANIZATION_NAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				setOrganizationAddress(ORGANIZATION_ADDRESS_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS:
				getOrganizationPhoneNumbers().clear();
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				setDefaultTimeZoneId(DEFAULT_TIME_ZONE_ID_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				setDefaultCurrencyCode(DEFAULT_CURRENCY_CODE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG:
				setDefaultLanguageTag(DEFAULT_LANGUAGE_TAG_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE:
				setDefaultCountryCode(DEFAULT_COUNTRY_CODE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME:
				setDefaultCategoryUName(DEFAULT_CATEGORY_UNAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				setEmailLogoUriTemplate(EMAIL_LOGO_URI_TEMPLATE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				setLetterSalutation(LETTER_SALUTATION_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				setLetterClosing(LETTER_CLOSING_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__FOOTNOTE:
				setFootnote(FOOTNOTE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__WWW_USED:
				setWwwUsed(WWW_USED_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__HEAD_NOTE:
				setHeadNote(HEAD_NOTE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__HEAD_TITLE:
				setHeadTitle(HEAD_TITLE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_STYLE:
				setDefaultStyle(DEFAULT_STYLE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_VARIATION:
				setDefaultVariation(DEFAULT_VARIATION_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_PAYPAL:
				setKursDollarPaypal(KURS_DOLLAR_PAYPAL_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_DPEX:
				setKursDollarDpex(KURS_DOLLAR_DPEX_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD_STR:
				setReminderPeriodStr(REMINDER_PERIOD_STR_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE_STR:
				setReminderScheduleStr(REMINDER_SCHEDULE_STR_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__SUPPORT_EMAIL:
				setSupportEmail(SUPPORT_EMAIL_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__SHIPMENT_LOGO_URI_TEMPLATE:
				setShipmentLogoUriTemplate(SHIPMENT_LOGO_URI_TEMPLATE_EDEFAULT);
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case CommonsPackage.APP_MANIFEST__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case CommonsPackage.APP_MANIFEST__EXPANSION_STATE:
				return expansionState != EXPANSION_STATE_EDEFAULT;
			case CommonsPackage.APP_MANIFEST__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case CommonsPackage.APP_MANIFEST__SUMMARY:
				return SUMMARY_EDEFAULT == null ? summary != null : !SUMMARY_EDEFAULT.equals(summary);
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonsPackage.APP_MANIFEST__DOMAIN:
				return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
			case CommonsPackage.APP_MANIFEST__DOMAIN_PRD:
				return DOMAIN_PRD_EDEFAULT == null ? domainPrd != null : !DOMAIN_PRD_EDEFAULT.equals(domainPrd);
			case CommonsPackage.APP_MANIFEST__DOMAIN_DEV:
				return DOMAIN_DEV_EDEFAULT == null ? domainDev != null : !DOMAIN_DEV_EDEFAULT.equals(domainDev);
			case CommonsPackage.APP_MANIFEST__DOMAIN_STG:
				return DOMAIN_STG_EDEFAULT == null ? domainStg != null : !DOMAIN_STG_EDEFAULT.equals(domainStg);
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				return GENERAL_EMAIL_EDEFAULT == null ? generalEmail != null : !GENERAL_EMAIL_EDEFAULT.equals(generalEmail);
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD:
				return GENERAL_EMAIL_PRD_EDEFAULT == null ? generalEmailPrd != null : !GENERAL_EMAIL_PRD_EDEFAULT.equals(generalEmailPrd);
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV:
				return GENERAL_EMAIL_DEV_EDEFAULT == null ? generalEmailDev != null : !GENERAL_EMAIL_DEV_EDEFAULT.equals(generalEmailDev);
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG:
				return GENERAL_EMAIL_STG_EDEFAULT == null ? generalEmailStg != null : !GENERAL_EMAIL_STG_EDEFAULT.equals(generalEmailStg);
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				return ORGANIZATION_NAME_EDEFAULT == null ? organizationName != null : !ORGANIZATION_NAME_EDEFAULT.equals(organizationName);
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				return ORGANIZATION_ADDRESS_EDEFAULT == null ? organizationAddress != null : !ORGANIZATION_ADDRESS_EDEFAULT.equals(organizationAddress);
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS:
				return organizationPhoneNumbers != null && !organizationPhoneNumbers.isEmpty();
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				return DEFAULT_TIME_ZONE_ID_EDEFAULT == null ? defaultTimeZoneId != null : !DEFAULT_TIME_ZONE_ID_EDEFAULT.equals(defaultTimeZoneId);
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE:
				return DEFAULT_TIME_ZONE_EDEFAULT == null ? getDefaultTimeZone() != null : !DEFAULT_TIME_ZONE_EDEFAULT.equals(getDefaultTimeZone());
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				return DEFAULT_CURRENCY_CODE_EDEFAULT == null ? defaultCurrencyCode != null : !DEFAULT_CURRENCY_CODE_EDEFAULT.equals(defaultCurrencyCode);
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY:
				return DEFAULT_CURRENCY_EDEFAULT == null ? getDefaultCurrency() != null : !DEFAULT_CURRENCY_EDEFAULT.equals(getDefaultCurrency());
			case CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG:
				return DEFAULT_LANGUAGE_TAG_EDEFAULT == null ? defaultLanguageTag != null : !DEFAULT_LANGUAGE_TAG_EDEFAULT.equals(defaultLanguageTag);
			case CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE:
				return DEFAULT_COUNTRY_CODE_EDEFAULT == null ? defaultCountryCode != null : !DEFAULT_COUNTRY_CODE_EDEFAULT.equals(defaultCountryCode);
			case CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME:
				return DEFAULT_CATEGORY_UNAME_EDEFAULT == null ? defaultCategoryUName != null : !DEFAULT_CATEGORY_UNAME_EDEFAULT.equals(defaultCategoryUName);
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				return EMAIL_LOGO_URI_TEMPLATE_EDEFAULT == null ? emailLogoUriTemplate != null : !EMAIL_LOGO_URI_TEMPLATE_EDEFAULT.equals(emailLogoUriTemplate);
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				return LETTER_SALUTATION_EDEFAULT == null ? letterSalutation != null : !LETTER_SALUTATION_EDEFAULT.equals(letterSalutation);
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				return LETTER_CLOSING_EDEFAULT == null ? letterClosing != null : !LETTER_CLOSING_EDEFAULT.equals(letterClosing);
			case CommonsPackage.APP_MANIFEST__FOOTNOTE:
				return FOOTNOTE_EDEFAULT == null ? footnote != null : !FOOTNOTE_EDEFAULT.equals(footnote);
			case CommonsPackage.APP_MANIFEST__WWW_USED:
				return WWW_USED_EDEFAULT == null ? wwwUsed != null : !WWW_USED_EDEFAULT.equals(wwwUsed);
			case CommonsPackage.APP_MANIFEST__HEAD_NOTE:
				return HEAD_NOTE_EDEFAULT == null ? headNote != null : !HEAD_NOTE_EDEFAULT.equals(headNote);
			case CommonsPackage.APP_MANIFEST__HEAD_TITLE:
				return HEAD_TITLE_EDEFAULT == null ? headTitle != null : !HEAD_TITLE_EDEFAULT.equals(headTitle);
			case CommonsPackage.APP_MANIFEST__DEFAULT_STYLE:
				return DEFAULT_STYLE_EDEFAULT == null ? defaultStyle != null : !DEFAULT_STYLE_EDEFAULT.equals(defaultStyle);
			case CommonsPackage.APP_MANIFEST__DEFAULT_VARIATION:
				return DEFAULT_VARIATION_EDEFAULT == null ? defaultVariation != null : !DEFAULT_VARIATION_EDEFAULT.equals(defaultVariation);
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_PAYPAL:
				return KURS_DOLLAR_PAYPAL_EDEFAULT == null ? kursDollarPaypal != null : !KURS_DOLLAR_PAYPAL_EDEFAULT.equals(kursDollarPaypal);
			case CommonsPackage.APP_MANIFEST__KURS_DOLLAR_DPEX:
				return KURS_DOLLAR_DPEX_EDEFAULT == null ? kursDollarDpex != null : !KURS_DOLLAR_DPEX_EDEFAULT.equals(kursDollarDpex);
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE:
				return REMINDER_SCHEDULE_EDEFAULT == null ? getReminderSchedule() != null : !REMINDER_SCHEDULE_EDEFAULT.equals(getReminderSchedule());
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD_STR:
				return REMINDER_PERIOD_STR_EDEFAULT == null ? reminderPeriodStr != null : !REMINDER_PERIOD_STR_EDEFAULT.equals(reminderPeriodStr);
			case CommonsPackage.APP_MANIFEST__REMINDER_PERIOD:
				return REMINDER_PERIOD_EDEFAULT == null ? getReminderPeriod() != null : !REMINDER_PERIOD_EDEFAULT.equals(getReminderPeriod());
			case CommonsPackage.APP_MANIFEST__REMINDER_SCHEDULE_STR:
				return REMINDER_SCHEDULE_STR_EDEFAULT == null ? reminderScheduleStr != null : !REMINDER_SCHEDULE_STR_EDEFAULT.equals(reminderScheduleStr);
			case CommonsPackage.APP_MANIFEST__SUPPORT_EMAIL:
				return SUPPORT_EMAIL_EDEFAULT == null ? supportEmail != null : !SUPPORT_EMAIL_EDEFAULT.equals(supportEmail);
			case CommonsPackage.APP_MANIFEST__SHIPMENT_LOGO_URI_TEMPLATE:
				return SHIPMENT_LOGO_URI_TEMPLATE_EDEFAULT == null ? shipmentLogoUriTemplate != null : !SHIPMENT_LOGO_URI_TEMPLATE_EDEFAULT.equals(shipmentLogoUriTemplate);
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
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case CommonsPackage.APP_MANIFEST__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case CommonsPackage.APP_MANIFEST__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.APP_MANIFEST__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == Expandable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.APP_MANIFEST__EXPANSION_STATE: return CommonsPackage.EXPANDABLE__EXPANSION_STATE;
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
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return CommonsPackage.APP_MANIFEST__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return CommonsPackage.APP_MANIFEST__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return CommonsPackage.APP_MANIFEST__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return CommonsPackage.APP_MANIFEST__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == Expandable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.EXPANDABLE__EXPANSION_STATE: return CommonsPackage.APP_MANIFEST__EXPANSION_STATE;
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
		result.append(" (positioner: ");
		result.append(positioner);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", expansionState: ");
		result.append(expansionState);
		result.append(", title: ");
		result.append(title);
		result.append(", summary: ");
		result.append(summary);
		result.append(", description: ");
		result.append(description);
		result.append(", domain: ");
		result.append(domain);
		result.append(", domainPrd: ");
		result.append(domainPrd);
		result.append(", domainDev: ");
		result.append(domainDev);
		result.append(", domainStg: ");
		result.append(domainStg);
		result.append(", generalEmail: ");
		result.append(generalEmail);
		result.append(", generalEmailPrd: ");
		result.append(generalEmailPrd);
		result.append(", generalEmailDev: ");
		result.append(generalEmailDev);
		result.append(", generalEmailStg: ");
		result.append(generalEmailStg);
		result.append(", organizationName: ");
		result.append(organizationName);
		result.append(", organizationAddress: ");
		result.append(organizationAddress);
		result.append(", organizationPhoneNumbers: ");
		result.append(organizationPhoneNumbers);
		result.append(", defaultTimeZoneId: ");
		result.append(defaultTimeZoneId);
		result.append(", defaultCurrencyCode: ");
		result.append(defaultCurrencyCode);
		result.append(", defaultLanguageTag: ");
		result.append(defaultLanguageTag);
		result.append(", defaultCountryCode: ");
		result.append(defaultCountryCode);
		result.append(", defaultCategoryUName: ");
		result.append(defaultCategoryUName);
		result.append(", emailLogoUriTemplate: ");
		result.append(emailLogoUriTemplate);
		result.append(", letterSalutation: ");
		result.append(letterSalutation);
		result.append(", letterClosing: ");
		result.append(letterClosing);
		result.append(", footnote: ");
		result.append(footnote);
		result.append(", wwwUsed: ");
		result.append(wwwUsed);
		result.append(", headNote: ");
		result.append(headNote);
		result.append(", headTitle: ");
		result.append(headTitle);
		result.append(", defaultStyle: ");
		result.append(defaultStyle);
		result.append(", defaultVariation: ");
		result.append(defaultVariation);
		result.append(", kursDollarPaypal: ");
		result.append(kursDollarPaypal);
		result.append(", kursDollarDpex: ");
		result.append(kursDollarDpex);
		result.append(", reminderPeriodStr: ");
		result.append(reminderPeriodStr);
		result.append(", reminderScheduleStr: ");
		result.append(reminderScheduleStr);
		result.append(", supportEmail: ");
		result.append(supportEmail);
		result.append(", shipmentLogoUriTemplate: ");
		result.append(shipmentLogoUriTemplate);
		result.append(')');
		return result.toString();
	}

} //AppManifestImpl
