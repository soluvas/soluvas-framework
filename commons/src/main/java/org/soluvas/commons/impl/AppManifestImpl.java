/**
 */
package org.soluvas.commons.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTimeZone;
import org.osgi.framework.Bundle;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
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
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getGeneralEmail <em>General Email</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getOrganizationName <em>Organization Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getOrganizationAddress <em>Organization Address</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getLetterSalutation <em>Letter Salutation</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getLetterClosing <em>Letter Closing</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultTimeZoneId <em>Default Time Zone Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultTimeZone <em>Default Time Zone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCurrencyCode <em>Default Currency Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDefaultCurrency <em>Default Currency</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getEmailLogoUriTemplate <em>Email Logo Uri Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppManifestImpl extends MinimalEObjectImpl.Container implements AppManifest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * The default value of the '{@link #getLetterSalutation() <em>Letter Salutation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLetterSalutation()
	 * @generated
	 * @ordered
	 */
	protected static final String LETTER_SALUTATION_EDEFAULT = "Hai";

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
	protected static final String DEFAULT_CURRENCY_CODE_EDEFAULT = null;

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
	 * The default value of the '{@link #getEmailLogoUriTemplate() <em>Email Logo Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmailLogoUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_LOGO_URI_TEMPLATE_EDEFAULT = "{+imagesUri}tenant_common/logo_email.png";

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
		return getDefaultCurrencyCode() != null ? CurrencyUnit.of(getDefaultCurrencyCode()) : null;
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
	 */
	@Override
	public void expand(Map<String, Object> scope) {
		if (getExpansionState() == ExpansionState.UNEXPANDED) {
			try {
				// domain is expanded twice, because the hub.properties#appDomain may contain URI template {+fqdn} too
				if (getDomain().contains("{")) {
					setDomain( UriTemplate.expand(getDomain(), scope) );
				}
				if (getDomain().contains("{")) {
					setDomain( UriTemplate.expand(getDomain(), scope) );
				}
				expansionState = ExpansionState.EXPANDED;
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
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				return getGeneralEmail();
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				return getOrganizationName();
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				return getOrganizationAddress();
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				return getLetterSalutation();
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				return getLetterClosing();
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				return getDefaultTimeZoneId();
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE:
				return getDefaultTimeZone();
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				return getDefaultCurrencyCode();
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY:
				return getDefaultCurrency();
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				return getEmailLogoUriTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				setGeneralEmail((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				setOrganizationName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				setOrganizationAddress((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				setLetterSalutation((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				setLetterClosing((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				setDefaultTimeZoneId((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				setDefaultCurrencyCode((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				setEmailLogoUriTemplate((String)newValue);
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
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				setGeneralEmail(GENERAL_EMAIL_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				setOrganizationName(ORGANIZATION_NAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				setOrganizationAddress(ORGANIZATION_ADDRESS_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				setLetterSalutation(LETTER_SALUTATION_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				setLetterClosing(LETTER_CLOSING_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				setDefaultTimeZoneId(DEFAULT_TIME_ZONE_ID_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				setDefaultCurrencyCode(DEFAULT_CURRENCY_CODE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				setEmailLogoUriTemplate(EMAIL_LOGO_URI_TEMPLATE_EDEFAULT);
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
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
				return GENERAL_EMAIL_EDEFAULT == null ? generalEmail != null : !GENERAL_EMAIL_EDEFAULT.equals(generalEmail);
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
				return ORGANIZATION_NAME_EDEFAULT == null ? organizationName != null : !ORGANIZATION_NAME_EDEFAULT.equals(organizationName);
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
				return ORGANIZATION_ADDRESS_EDEFAULT == null ? organizationAddress != null : !ORGANIZATION_ADDRESS_EDEFAULT.equals(organizationAddress);
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
				return LETTER_SALUTATION_EDEFAULT == null ? letterSalutation != null : !LETTER_SALUTATION_EDEFAULT.equals(letterSalutation);
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
				return LETTER_CLOSING_EDEFAULT == null ? letterClosing != null : !LETTER_CLOSING_EDEFAULT.equals(letterClosing);
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
				return DEFAULT_TIME_ZONE_ID_EDEFAULT == null ? defaultTimeZoneId != null : !DEFAULT_TIME_ZONE_ID_EDEFAULT.equals(defaultTimeZoneId);
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE:
				return DEFAULT_TIME_ZONE_EDEFAULT == null ? getDefaultTimeZone() != null : !DEFAULT_TIME_ZONE_EDEFAULT.equals(getDefaultTimeZone());
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
				return DEFAULT_CURRENCY_CODE_EDEFAULT == null ? defaultCurrencyCode != null : !DEFAULT_CURRENCY_CODE_EDEFAULT.equals(defaultCurrencyCode);
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY:
				return DEFAULT_CURRENCY_EDEFAULT == null ? getDefaultCurrency() != null : !DEFAULT_CURRENCY_EDEFAULT.equals(getDefaultCurrency());
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
				return EMAIL_LOGO_URI_TEMPLATE_EDEFAULT == null ? emailLogoUriTemplate != null : !EMAIL_LOGO_URI_TEMPLATE_EDEFAULT.equals(emailLogoUriTemplate);
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ResourceAware.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == Expandable.class) {
			switch (baseOperationID) {
				case CommonsPackage.EXPANDABLE___EXPAND__MAP: return CommonsPackage.APP_MANIFEST___EXPAND__MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CommonsPackage.APP_MANIFEST___EXPAND__MAP:
				try {
					expand((Map<String, Object>)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", generalEmail: ");
		result.append(generalEmail);
		result.append(", organizationName: ");
		result.append(organizationName);
		result.append(", organizationAddress: ");
		result.append(organizationAddress);
		result.append(", letterSalutation: ");
		result.append(letterSalutation);
		result.append(", letterClosing: ");
		result.append(letterClosing);
		result.append(", defaultTimeZoneId: ");
		result.append(defaultTimeZoneId);
		result.append(", defaultCurrencyCode: ");
		result.append(defaultCurrencyCode);
		result.append(", emailLogoUriTemplate: ");
		result.append(emailLogoUriTemplate);
		result.append(')');
		return result.toString();
	}

} //AppManifestImpl
