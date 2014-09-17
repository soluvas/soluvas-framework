/**
 */
package org.soluvas.commons.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.SchemaVersionable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Postal Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getCity <em>City</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getProvince <em>Province</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getCountryCode <em>Country Code</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPrimaryMobile <em>Primary Mobile</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getMobiles <em>Mobiles</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPrimaryPhone <em>Primary Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPhones <em>Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPrimaryHomePhone <em>Primary Home Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getHomePhones <em>Home Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPrimaryWorkPhone <em>Primary Work Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getWorkPhones <em>Work Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getPrimaryEmail <em>Primary Email</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#isPrimaryBilling <em>Primary Billing</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#isPrimaryShipping <em>Primary Shipping</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.PostalAddressImpl#getValidationTime <em>Validation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostalAddressImpl extends MinimalEObjectImpl.Container implements PostalAddress {
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
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 3L;

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected static final String ORGANIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected String organization = ORGANIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected String postalCode = POSTAL_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvince() <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvince()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVINCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvince() <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvince()
	 * @generated
	 * @ordered
	 */
	protected String province = PROVINCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected String country = COUNTRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountryCode() <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountryCode()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTRY_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCountryCode() <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountryCode()
	 * @generated
	 * @ordered
	 */
	protected String countryCode = COUNTRY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryMobile() <em>Primary Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryMobile()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_MOBILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryMobile() <em>Primary Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryMobile()
	 * @generated
	 * @ordered
	 */
	protected String primaryMobile = PRIMARY_MOBILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMobiles() <em>Mobiles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobiles()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> mobiles;

	/**
	 * The default value of the '{@link #getPrimaryPhone() <em>Primary Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryPhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_PHONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryPhone() <em>Primary Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryPhone()
	 * @generated
	 * @ordered
	 */
	protected String primaryPhone = PRIMARY_PHONE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPhones() <em>Phones</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhones()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> phones;

	/**
	 * The default value of the '{@link #getPrimaryHomePhone() <em>Primary Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryHomePhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_HOME_PHONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryHomePhone() <em>Primary Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryHomePhone()
	 * @generated
	 * @ordered
	 */
	protected String primaryHomePhone = PRIMARY_HOME_PHONE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHomePhones() <em>Home Phones</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomePhones()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> homePhones;

	/**
	 * The default value of the '{@link #getPrimaryWorkPhone() <em>Primary Work Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryWorkPhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_WORK_PHONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryWorkPhone() <em>Primary Work Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryWorkPhone()
	 * @generated
	 * @ordered
	 */
	protected String primaryWorkPhone = PRIMARY_WORK_PHONE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorkPhones() <em>Work Phones</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkPhones()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> workPhones;

	/**
	 * The default value of the '{@link #getPrimaryEmail() <em>Primary Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryEmail() <em>Primary Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryEmail()
	 * @generated
	 * @ordered
	 */
	protected String primaryEmail = PRIMARY_EMAIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEmails() <em>Emails</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmails()
	 * @generated
	 * @ordered
	 */
	@JsonDeserialize(as=BasicEList.class)
	protected EList<String> emails;

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
	 * The default value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected boolean primary = PRIMARY_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrimaryBilling() <em>Primary Billing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryBilling()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_BILLING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimaryBilling() <em>Primary Billing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryBilling()
	 * @generated
	 * @ordered
	 */
	protected boolean primaryBilling = PRIMARY_BILLING_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrimaryShipping() <em>Primary Shipping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryShipping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_SHIPPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimaryShipping() <em>Primary Shipping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryShipping()
	 * @generated
	 * @ordered
	 */
	protected boolean primaryShipping = PRIMARY_SHIPPING_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostalAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.POSTAL_ADDRESS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__ID, oldId, id));
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
	public String getOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrganization(String newOrganization) {
		String oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__ORGANIZATION, oldOrganization, organization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostalCode(String newPostalCode) {
		String oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE, oldPostalCode, postalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProvince() {
		return province;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvince(String newProvince) {
		String oldProvince = province;
		province = newProvince;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PROVINCE, oldProvince, province));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountry(String newCountry) {
		String oldCountry = country;
		country = newCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__COUNTRY, oldCountry, country));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountryCode(String newCountryCode) {
		String oldCountryCode = countryCode;
		countryCode = newCountryCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE, oldCountryCode, countryCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryMobile() {
		return primaryMobile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryMobile(String newPrimaryMobile) {
		String oldPrimaryMobile = primaryMobile;
		primaryMobile = newPrimaryMobile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE, oldPrimaryMobile, primaryMobile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getMobiles() {
		if (mobiles == null) {
			mobiles = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.POSTAL_ADDRESS__MOBILES);
		}
		return mobiles;
	}
	
	protected void setMobiles(List<String> mobiles) {
		getMobiles().clear();
		getMobiles().addAll(mobiles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryPhone(String newPrimaryPhone) {
		String oldPrimaryPhone = primaryPhone;
		primaryPhone = newPrimaryPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE, oldPrimaryPhone, primaryPhone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPhones() {
		if (phones == null) {
			phones = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.POSTAL_ADDRESS__PHONES);
		}
		return phones;
	}
	
	protected void setPhones(List<String> phones) {
		getPhones().clear();
		getPhones().addAll(phones);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryHomePhone() {
		return primaryHomePhone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryHomePhone(String newPrimaryHomePhone) {
		String oldPrimaryHomePhone = primaryHomePhone;
		primaryHomePhone = newPrimaryHomePhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE, oldPrimaryHomePhone, primaryHomePhone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getHomePhones() {
		if (homePhones == null) {
			homePhones = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.POSTAL_ADDRESS__HOME_PHONES);
		}
		return homePhones;
	}
	
	protected void setHomePhones(List<String> homePhones) {
		getHomePhones().clear();
		getHomePhones().addAll(homePhones);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryWorkPhone() {
		return primaryWorkPhone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryWorkPhone(String newPrimaryWorkPhone) {
		String oldPrimaryWorkPhone = primaryWorkPhone;
		primaryWorkPhone = newPrimaryWorkPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE, oldPrimaryWorkPhone, primaryWorkPhone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getWorkPhones() {
		if (workPhones == null) {
			workPhones = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.POSTAL_ADDRESS__WORK_PHONES);
		}
		return workPhones;
	}
	
	protected void setWorkPhones(List<String> workPhones) {
		getWorkPhones().clear();
		getWorkPhones().addAll(workPhones);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryEmail(String newPrimaryEmail) {
		String oldPrimaryEmail = primaryEmail;
		primaryEmail = newPrimaryEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL, oldPrimaryEmail, primaryEmail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getEmails() {
		if (emails == null) {
			emails = new EDataTypeUniqueEList<String>(String.class, this, CommonsPackage.POSTAL_ADDRESS__EMAILS);
		}
		return emails;
	}
	
	protected void setEmails(List<String> emails) {
		getEmails().clear();
		getEmails().addAll(emails);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimary(boolean newPrimary) {
		boolean oldPrimary = primary;
		primary = newPrimary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY, oldPrimary, primary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimaryBilling() {
		return primaryBilling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryBilling(boolean newPrimaryBilling) {
		boolean oldPrimaryBilling = primaryBilling;
		primaryBilling = newPrimaryBilling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING, oldPrimaryBilling, primaryBilling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimaryShipping() {
		return primaryShipping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryShipping(boolean newPrimaryShipping) {
		boolean oldPrimaryShipping = primaryShipping;
		primaryShipping = newPrimaryShipping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING, oldPrimaryShipping, primaryShipping));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME, oldValidationTime, validationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.POSTAL_ADDRESS__NAME:
				return getName();
			case CommonsPackage.POSTAL_ADDRESS__ID:
				return getId();
			case CommonsPackage.POSTAL_ADDRESS__SCHEMA_VERSION:
				return getSchemaVersion();
			case CommonsPackage.POSTAL_ADDRESS__ORGANIZATION:
				return getOrganization();
			case CommonsPackage.POSTAL_ADDRESS__STREET:
				return getStreet();
			case CommonsPackage.POSTAL_ADDRESS__CITY:
				return getCity();
			case CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE:
				return getPostalCode();
			case CommonsPackage.POSTAL_ADDRESS__PROVINCE:
				return getProvince();
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY:
				return getCountry();
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE:
				return getCountryCode();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE:
				return getPrimaryMobile();
			case CommonsPackage.POSTAL_ADDRESS__MOBILES:
				return getMobiles();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE:
				return getPrimaryPhone();
			case CommonsPackage.POSTAL_ADDRESS__PHONES:
				return getPhones();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE:
				return getPrimaryHomePhone();
			case CommonsPackage.POSTAL_ADDRESS__HOME_PHONES:
				return getHomePhones();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE:
				return getPrimaryWorkPhone();
			case CommonsPackage.POSTAL_ADDRESS__WORK_PHONES:
				return getWorkPhones();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL:
				return getPrimaryEmail();
			case CommonsPackage.POSTAL_ADDRESS__EMAILS:
				return getEmails();
			case CommonsPackage.POSTAL_ADDRESS__DESCRIPTION:
				return getDescription();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY:
				return isPrimary();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING:
				return isPrimaryBilling();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING:
				return isPrimaryShipping();
			case CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME:
				return getValidationTime();
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
			case CommonsPackage.POSTAL_ADDRESS__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__ORGANIZATION:
				setOrganization((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__STREET:
				setStreet((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__CITY:
				setCity((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PROVINCE:
				setProvince((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY:
				setCountry((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE:
				setCountryCode((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE:
				setPrimaryMobile((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__MOBILES:
				getMobiles().clear();
				getMobiles().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE:
				setPrimaryPhone((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PHONES:
				getPhones().clear();
				getPhones().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE:
				setPrimaryHomePhone((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__HOME_PHONES:
				getHomePhones().clear();
				getHomePhones().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE:
				setPrimaryWorkPhone((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__WORK_PHONES:
				getWorkPhones().clear();
				getWorkPhones().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL:
				setPrimaryEmail((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__EMAILS:
				getEmails().clear();
				getEmails().addAll((Collection<? extends String>)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY:
				setPrimary((Boolean)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING:
				setPrimaryBilling((Boolean)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING:
				setPrimaryShipping((Boolean)newValue);
				return;
			case CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME:
				setValidationTime((DateTime)newValue);
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
			case CommonsPackage.POSTAL_ADDRESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__ORGANIZATION:
				setOrganization(ORGANIZATION_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PROVINCE:
				setProvince(PROVINCE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY:
				setCountry(COUNTRY_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE:
				setCountryCode(COUNTRY_CODE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE:
				setPrimaryMobile(PRIMARY_MOBILE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__MOBILES:
				getMobiles().clear();
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE:
				setPrimaryPhone(PRIMARY_PHONE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PHONES:
				getPhones().clear();
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE:
				setPrimaryHomePhone(PRIMARY_HOME_PHONE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__HOME_PHONES:
				getHomePhones().clear();
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE:
				setPrimaryWorkPhone(PRIMARY_WORK_PHONE_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__WORK_PHONES:
				getWorkPhones().clear();
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL:
				setPrimaryEmail(PRIMARY_EMAIL_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__EMAILS:
				getEmails().clear();
				return;
			case CommonsPackage.POSTAL_ADDRESS__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY:
				setPrimary(PRIMARY_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING:
				setPrimaryBilling(PRIMARY_BILLING_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING:
				setPrimaryShipping(PRIMARY_SHIPPING_EDEFAULT);
				return;
			case CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME:
				setValidationTime(VALIDATION_TIME_EDEFAULT);
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
			case CommonsPackage.POSTAL_ADDRESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.POSTAL_ADDRESS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.POSTAL_ADDRESS__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case CommonsPackage.POSTAL_ADDRESS__ORGANIZATION:
				return ORGANIZATION_EDEFAULT == null ? organization != null : !ORGANIZATION_EDEFAULT.equals(organization);
			case CommonsPackage.POSTAL_ADDRESS__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case CommonsPackage.POSTAL_ADDRESS__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case CommonsPackage.POSTAL_ADDRESS__PROVINCE:
				return PROVINCE_EDEFAULT == null ? province != null : !PROVINCE_EDEFAULT.equals(province);
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY:
				return COUNTRY_EDEFAULT == null ? country != null : !COUNTRY_EDEFAULT.equals(country);
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE:
				return COUNTRY_CODE_EDEFAULT == null ? countryCode != null : !COUNTRY_CODE_EDEFAULT.equals(countryCode);
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE:
				return PRIMARY_MOBILE_EDEFAULT == null ? primaryMobile != null : !PRIMARY_MOBILE_EDEFAULT.equals(primaryMobile);
			case CommonsPackage.POSTAL_ADDRESS__MOBILES:
				return mobiles != null && !mobiles.isEmpty();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE:
				return PRIMARY_PHONE_EDEFAULT == null ? primaryPhone != null : !PRIMARY_PHONE_EDEFAULT.equals(primaryPhone);
			case CommonsPackage.POSTAL_ADDRESS__PHONES:
				return phones != null && !phones.isEmpty();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE:
				return PRIMARY_HOME_PHONE_EDEFAULT == null ? primaryHomePhone != null : !PRIMARY_HOME_PHONE_EDEFAULT.equals(primaryHomePhone);
			case CommonsPackage.POSTAL_ADDRESS__HOME_PHONES:
				return homePhones != null && !homePhones.isEmpty();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE:
				return PRIMARY_WORK_PHONE_EDEFAULT == null ? primaryWorkPhone != null : !PRIMARY_WORK_PHONE_EDEFAULT.equals(primaryWorkPhone);
			case CommonsPackage.POSTAL_ADDRESS__WORK_PHONES:
				return workPhones != null && !workPhones.isEmpty();
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL:
				return PRIMARY_EMAIL_EDEFAULT == null ? primaryEmail != null : !PRIMARY_EMAIL_EDEFAULT.equals(primaryEmail);
			case CommonsPackage.POSTAL_ADDRESS__EMAILS:
				return emails != null && !emails.isEmpty();
			case CommonsPackage.POSTAL_ADDRESS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY:
				return primary != PRIMARY_EDEFAULT;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING:
				return primaryBilling != PRIMARY_BILLING_EDEFAULT;
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING:
				return primaryShipping != PRIMARY_SHIPPING_EDEFAULT;
			case CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME:
				return VALIDATION_TIME_EDEFAULT == null ? validationTime != null : !VALIDATION_TIME_EDEFAULT.equals(validationTime);
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
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.POSTAL_ADDRESS__ID: return CommonsPackage.IDENTIFIABLE__ID;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.IDENTIFIABLE__ID: return CommonsPackage.POSTAL_ADDRESS__ID;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
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
		result.append(", id: ");
		result.append(id);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", organization: ");
		result.append(organization);
		result.append(", street: ");
		result.append(street);
		result.append(", city: ");
		result.append(city);
		result.append(", postalCode: ");
		result.append(postalCode);
		result.append(", province: ");
		result.append(province);
		result.append(", country: ");
		result.append(country);
		result.append(", countryCode: ");
		result.append(countryCode);
		result.append(", primaryMobile: ");
		result.append(primaryMobile);
		result.append(", mobiles: ");
		result.append(mobiles);
		result.append(", primaryPhone: ");
		result.append(primaryPhone);
		result.append(", phones: ");
		result.append(phones);
		result.append(", primaryHomePhone: ");
		result.append(primaryHomePhone);
		result.append(", homePhones: ");
		result.append(homePhones);
		result.append(", primaryWorkPhone: ");
		result.append(primaryWorkPhone);
		result.append(", workPhones: ");
		result.append(workPhones);
		result.append(", primaryEmail: ");
		result.append(primaryEmail);
		result.append(", emails: ");
		result.append(emails);
		result.append(", description: ");
		result.append(description);
		result.append(", primary: ");
		result.append(primary);
		result.append(", primaryBilling: ");
		result.append(primaryBilling);
		result.append(", primaryShipping: ");
		result.append(primaryShipping);
		result.append(", validationTime: ");
		result.append(validationTime);
		result.append(')');
		return result.toString();
	}

} //PostalAddressImpl
