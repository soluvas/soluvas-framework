/**
 */
package org.soluvas.commons;

import org.joda.time.DateTimeZone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Attributes are optional because can use OverlayingSupplier.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getGeneralEmail <em>General Email</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationName <em>Organization Name</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getOrganizationAddress <em>Organization Address</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterSalutation <em>Letter Salutation</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getLetterClosing <em>Letter Closing</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDefaultTimeZone <em>Default Time Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getAppManifest()
 * @model
 * @generated
 */
public interface AppManifest extends Positionable, ResourceAware, BundleAware {
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
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>General Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Email address used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application.
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
	 * The default value is <code>"Hai"</code>.
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
	 * @model default="Hai"
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
	 * Returns the value of the '<em><b>Default Time Zone</b></em>' attribute.
	 * The default value is <code>"UTC"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default time zone for the application. For example this is used by perpetual inventory to store dates with a fixed reference timezone.
	 * It's a String, not a DateTimeZone object, to make it easier to edit the *.AppManifest.xmi file using generic EMF editor.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Time Zone</em>' attribute.
	 * @see #setDefaultTimeZone(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_DefaultTimeZone()
	 * @model default="UTC"
	 * @generated
	 */
	String getDefaultTimeZone();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getDefaultTimeZone <em>Default Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Time Zone</em>' attribute.
	 * @see #getDefaultTimeZone()
	 * @generated
	 */
	void setDefaultTimeZone(String value);

} // AppManifest
