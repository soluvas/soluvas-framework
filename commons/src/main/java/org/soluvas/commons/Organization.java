/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.Organization#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getBlackBerryPin <em>Black Berry Pin</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getWebsite <em>Website</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getFacebookPageUri <em>Facebook Page Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getFacebookUserName <em>Facebook User Name</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getTwitterScreenName <em>Twitter Screen Name</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getTwitterAccessToken <em>Twitter Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}</li>
 *   <li>{@link org.soluvas.commons.Organization#getTwitterId <em>Twitter Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getOrganization()
 * @model
 * @generated
 */
public interface Organization extends Identifiable, SchemaVersionable, NameContainer {
	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_SchemaVersion()
	 * @model default="1" changeable="false"
	 * @generated
	 */
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Black Berry Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Black Berry Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Black Berry Pin</em>' attribute.
	 * @see #setBlackBerryPin(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_BlackBerryPin()
	 * @model
	 * @generated
	 */
	String getBlackBerryPin();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getBlackBerryPin <em>Black Berry Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Black Berry Pin</em>' attribute.
	 * @see #getBlackBerryPin()
	 * @generated
	 */
	void setBlackBerryPin(String value);

	/**
	 * Returns the value of the '<em><b>Website</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Website</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Website</em>' attribute.
	 * @see #setWebsite(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_Website()
	 * @model
	 * @generated
	 */
	String getWebsite();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getWebsite <em>Website</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Website</em>' attribute.
	 * @see #getWebsite()
	 * @generated
	 */
	void setWebsite(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Page Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Page Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Page Uri</em>' attribute.
	 * @see #setFacebookPageUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_FacebookPageUri()
	 * @model
	 * @generated
	 */
	String getFacebookPageUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getFacebookPageUri <em>Facebook Page Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Page Uri</em>' attribute.
	 * @see #getFacebookPageUri()
	 * @generated
	 */
	void setFacebookPageUri(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Access Token</em>' attribute.
	 * @see #setFacebookAccessToken(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_FacebookAccessToken()
	 * @model
	 * @generated
	 */
	String getFacebookAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getFacebookAccessToken <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Access Token</em>' attribute.
	 * @see #getFacebookAccessToken()
	 * @generated
	 */
	void setFacebookAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Id</em>' attribute.
	 * @see #setFacebookId(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_FacebookId()
	 * @model
	 * @generated
	 */
	String getFacebookId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getFacebookId <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Id</em>' attribute.
	 * @see #getFacebookId()
	 * @generated
	 */
	void setFacebookId(String value);

	/**
	 * Returns the value of the '<em><b>Facebook User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook User Name</em>' attribute.
	 * @see #setFacebookUserName(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_FacebookUserName()
	 * @model
	 * @generated
	 */
	String getFacebookUserName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getFacebookUserName <em>Facebook User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook User Name</em>' attribute.
	 * @see #getFacebookUserName()
	 * @generated
	 */
	void setFacebookUserName(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Screen Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Screen Name</em>' attribute.
	 * @see #setTwitterScreenName(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_TwitterScreenName()
	 * @model
	 * @generated
	 */
	String getTwitterScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getTwitterScreenName <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Screen Name</em>' attribute.
	 * @see #getTwitterScreenName()
	 * @generated
	 */
	void setTwitterScreenName(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Access Token</em>' attribute.
	 * @see #setTwitterAccessToken(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_TwitterAccessToken()
	 * @model
	 * @generated
	 */
	String getTwitterAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getTwitterAccessToken <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Access Token</em>' attribute.
	 * @see #getTwitterAccessToken()
	 * @generated
	 */
	void setTwitterAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Access Token Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Access Token Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Access Token Secret</em>' attribute.
	 * @see #setTwitterAccessTokenSecret(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_TwitterAccessTokenSecret()
	 * @model
	 * @generated
	 */
	String getTwitterAccessTokenSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Access Token Secret</em>' attribute.
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 */
	void setTwitterAccessTokenSecret(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Id</em>' attribute.
	 * @see #setTwitterId(String)
	 * @see org.soluvas.commons.CommonsPackage#getOrganization_TwitterId()
	 * @model
	 * @generated
	 */
	String getTwitterId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Organization#getTwitterId <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Id</em>' attribute.
	 * @see #getTwitterId()
	 * @generated
	 */
	void setTwitterId(String value);

} // Organization
