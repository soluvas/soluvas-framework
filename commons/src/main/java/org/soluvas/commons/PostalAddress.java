/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.joda.time.DateTime;
import org.soluvas.commons.impl.PostalAddressImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postal Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * See http://www.upu.int/en/activities/addressing/standards.html - UPU S42.
 * 
 * ID is RFC1274: unique identifer.
 * LDAP: uniqueIdentifier
 * 
 * 'name' attribute is Person name who will receive.
 * RFC2256: common name(s) for which the entity is known by.
 * cn, commonName.
 * 
 * Can be used as:
 * 
 * 1. Billing Address in SalesQuote/SalesOrder
 * 2. Shipping Address in SalesQuote/SalesOrder
 * 3. Origin Address in SalesQuote/SalesOrder
 * 4. Person (Customer) Address
 * 5. Shop Address
 * 6. Mall Address
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.PostalAddress#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getStreet <em>Street</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getCity <em>City</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getProvince <em>Province</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getCountry <em>Country</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getCountryCode <em>Country Code</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPrimaryMobile <em>Primary Mobile</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getMobiles <em>Mobiles</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPrimaryPhone <em>Primary Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPhones <em>Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPrimaryHomePhone <em>Primary Home Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getHomePhones <em>Home Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPrimaryWorkPhone <em>Primary Work Phone</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getWorkPhones <em>Work Phones</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getPrimaryEmail <em>Primary Email</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#isPrimaryBilling <em>Primary Billing</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#isPrimaryShipping <em>Primary Shipping</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getValidationTime <em>Validation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getDistrict <em>District</em>}</li>
 *   <li>{@link org.soluvas.commons.PostalAddress#getJneAreaCode <em>Jne Area Code</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getPostalAddress()
 * @model
 * @generated
 */
@JsonDeserialize(as=PostalAddressImpl.class)
public interface PostalAddress extends NameContainer, Identifiable, SchemaVersionable, EObject {
	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_SchemaVersion()
	 * @model default="3" changeable="false"
	 * @generated
	 */
	@Override
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Organization or company name who will send or receive.
	 * Can be empty.
	 * RFC2256: organization this object belongs to
	 * LDAP: o, organizationName
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Organization</em>' attribute.
	 * @see #setOrganization(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Organization()
	 * @model
	 * @generated
	 */
	String getOrganization();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getOrganization <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' attribute.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(String value);

	/**
	 * Returns the value of the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Street</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Street</em>' attribute.
	 * @see #setStreet(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Street()
	 * @model
	 * @generated
	 */
	String getStreet();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getStreet <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street</em>' attribute.
	 * @see #getStreet()
	 * @generated
	 */
	void setStreet(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>City</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_City()
	 * @model
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #setPostalCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PostalCode()
	 * @model
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Returns the value of the '<em><b>Province</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Province</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Province</em>' attribute.
	 * @see #setProvince(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Province()
	 * @model
	 * @generated
	 */
	String getProvince();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getProvince <em>Province</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Province</em>' attribute.
	 * @see #getProvince()
	 * @generated
	 */
	void setProvince(String value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * RFC1274: friendly country name.
	 * 
	 * LDAP: co, friendlyCountryName
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Country</em>' attribute.
	 * @see #setCountry(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Country()
	 * @model
	 * @generated
	 */
	String getCountry();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' attribute.
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(String value);

	/**
	 * Returns the value of the '<em><b>Country Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Country code using <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>.
	 * 
	 * LDAP: c, countryName
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Country Code</em>' attribute.
	 * @see #setCountryCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_CountryCode()
	 * @model
	 * @generated
	 */
	String getCountryCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getCountryCode <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country Code</em>' attribute.
	 * @see #getCountryCode()
	 * @generated
	 */
	void setCountryCode(String value);

	/**
	 * Returns the value of the '<em><b>Primary Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Mobile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Mobile</em>' attribute.
	 * @see #setPrimaryMobile(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryMobile()
	 * @model
	 * @generated
	 */
	String getPrimaryMobile();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPrimaryMobile <em>Primary Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Mobile</em>' attribute.
	 * @see #getPrimaryMobile()
	 * @generated
	 */
	void setPrimaryMobile(String value);

	/**
	 * Returns the value of the '<em><b>Mobiles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * RFC1274: mobile telephone number
	 * LDAP: mobile, mobileTelephoneNumber
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mobiles</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Mobiles()
	 * @model
	 * @generated
	 */
	EList<String> getMobiles();

	/**
	 * Returns the value of the '<em><b>Primary Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * RFC2256: Telephone Number
	 * LDAP: telephoneNumber
	 * 
	 * For offices, usually work phone. For people, usually home phone.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Phone</em>' attribute.
	 * @see #setPrimaryPhone(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryPhone()
	 * @model
	 * @generated
	 */
	String getPrimaryPhone();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPrimaryPhone <em>Primary Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Phone</em>' attribute.
	 * @see #getPrimaryPhone()
	 * @generated
	 */
	void setPrimaryPhone(String value);

	/**
	 * Returns the value of the '<em><b>Phones</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phones</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phones</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Phones()
	 * @model
	 * @generated
	 */
	EList<String> getPhones();

	/**
	 * Returns the value of the '<em><b>Primary Home Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Home Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Home Phone</em>' attribute.
	 * @see #setPrimaryHomePhone(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryHomePhone()
	 * @model
	 * @generated
	 */
	String getPrimaryHomePhone();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPrimaryHomePhone <em>Primary Home Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Home Phone</em>' attribute.
	 * @see #getPrimaryHomePhone()
	 * @generated
	 */
	void setPrimaryHomePhone(String value);

	/**
	 * Returns the value of the '<em><b>Home Phones</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * RFC1274: home telephone number.
	 * LDAP: homePhone, homeTelephoneNumber.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Home Phones</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_HomePhones()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getHomePhones();

	/**
	 * Returns the value of the '<em><b>Primary Work Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Work Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Work Phone</em>' attribute.
	 * @see #setPrimaryWorkPhone(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryWorkPhone()
	 * @model
	 * @generated
	 */
	String getPrimaryWorkPhone();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPrimaryWorkPhone <em>Primary Work Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Work Phone</em>' attribute.
	 * @see #getPrimaryWorkPhone()
	 * @generated
	 */
	void setPrimaryWorkPhone(String value);

	/**
	 * Returns the value of the '<em><b>Work Phones</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * RFC2256: Telephone Number.
	 * LDAP: (not yet mapped)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Work Phones</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_WorkPhones()
	 * @model
	 * @generated
	 */
	EList<String> getWorkPhones();

	/**
	 * Returns the value of the '<em><b>Primary Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Email</em>' attribute.
	 * @see #setPrimaryEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryEmail()
	 * @model
	 * @generated
	 */
	String getPrimaryEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getPrimaryEmail <em>Primary Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Email</em>' attribute.
	 * @see #getPrimaryEmail()
	 * @generated
	 */
	void setPrimaryEmail(String value);

	/**
	 * Returns the value of the '<em><b>Emails</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * LDAP: mail.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Emails</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Emails()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getEmails();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * What this address represents, usually "Home", "Work", etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates this Address as the primary Address of the containing list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_Primary()
	 * @model default="false"
	 * @generated
	 */
	boolean isPrimary();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#isPrimary <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' attribute.
	 * @see #isPrimary()
	 * @generated
	 */
	void setPrimary(boolean value);

	/**
	 * Returns the value of the '<em><b>Primary Billing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Billing</em>' attribute.
	 * @see #setPrimaryBilling(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryBilling()
	 * @model default="false"
	 * @generated
	 */
	boolean isPrimaryBilling();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#isPrimaryBilling <em>Primary Billing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Billing</em>' attribute.
	 * @see #isPrimaryBilling()
	 * @generated
	 */
	void setPrimaryBilling(boolean value);

	/**
	 * Returns the value of the '<em><b>Primary Shipping</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Shipping</em>' attribute.
	 * @see #setPrimaryShipping(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_PrimaryShipping()
	 * @model default="false"
	 * @generated
	 */
	boolean isPrimaryShipping();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#isPrimaryShipping <em>Primary Shipping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Shipping</em>' attribute.
	 * @see #isPrimaryShipping()
	 * @generated
	 */
	void setPrimaryShipping(boolean value);

	/**
	 * Returns the value of the '<em><b>Validation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When this postal address was validated by the user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Time</em>' attribute.
	 * @see #setValidationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_ValidationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getValidationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getValidationTime <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Time</em>' attribute.
	 * @see #getValidationTime()
	 * @generated
	 */
	void setValidationTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>District</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>District</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>District</em>' attribute.
	 * @see #setDistrict(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_District()
	 * @model
	 * @generated
	 */
	String getDistrict();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getDistrict <em>District</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>District</em>' attribute.
	 * @see #getDistrict()
	 * @generated
	 */
	void setDistrict(String value);

	/**
	 * Returns the value of the '<em><b>Jne Area Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jne Area Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jne Area Code</em>' attribute.
	 * @see #setJneAreaCode(String)
	 * @see org.soluvas.commons.CommonsPackage#getPostalAddress_JneAreaCode()
	 * @model
	 * @generated
	 */
	String getJneAreaCode();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PostalAddress#getJneAreaCode <em>Jne Area Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jne Area Code</em>' attribute.
	 * @see #getJneAreaCode()
	 * @generated
	 */
	void setJneAreaCode(String value);

} // PostalAddress
