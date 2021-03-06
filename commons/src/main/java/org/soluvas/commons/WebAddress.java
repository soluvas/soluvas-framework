/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Web Address</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Tenant-wide website URI configuration. URI template variables: appId, tenantId, tenantEnv, appDomain, domain, fqdn, webHost.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.WebAddress#getBaseUri <em>Base Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getBasePath <em>Base Path</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getApiPath <em>Api Path</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getImagesUri <em>Images Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getSkinUri <em>Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getJsUri <em>Js Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getSecureSkinUri <em>Secure Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getWebAddress()
 * @model
 * @generated
 */
public interface WebAddress extends Positionable, BundleAware, ResourceAware, Expandable {
	/**
	 * Returns the value of the '<em><b>Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI of the website. Used by email notifications, external servers, etc.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Uri</em>' attribute.
	 * @see #setBaseUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_BaseUri()
	 * @model required="true"
	 * @generated
	 */
	String getBaseUri();
	
//	String getRealBaseUri(boolean secure);

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getBaseUri <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Uri</em>' attribute.
	 * @see #getBaseUri()
	 * @generated
	 */
	void setBaseUri(String value);

	/**
	 * Returns the value of the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute path to website, e.g. /
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Path</em>' attribute.
	 * @see #setBasePath(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_BasePath()
	 * @model required="true"
	 * @generated
	 */
	String getBasePath();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getBasePath <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Path</em>' attribute.
	 * @see #getBasePath()
	 * @generated
	 */
	void setBasePath(String value);

	/**
	 * Returns the value of the '<em><b>Api Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute path to API, e.g. /api/
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Api Path</em>' attribute.
	 * @see #setApiPath(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_ApiPath()
	 * @model required="true"
	 * @generated
	 */
	String getApiPath();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getApiPath <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Path</em>' attribute.
	 * @see #getApiPath()
	 * @generated
	 */
	void setApiPath(String value);

	/**
	 * Returns the value of the '<em><b>Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to image files, e.g. http://images.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Images Uri</em>' attribute.
	 * @see #setImagesUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_ImagesUri()
	 * @model required="true"
	 * @generated
	 */
	String getImagesUri();
	
//	String getRealImagesUri(boolean secure);

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getImagesUri <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Images Uri</em>' attribute.
	 * @see #getImagesUri()
	 * @generated
	 */
	void setImagesUri(String value);

	/**
	 * Returns the value of the '<em><b>Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to CSS files and dependencies (sprite images, fonts, etc.), e.g. http://skin.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Skin Uri</em>' attribute.
	 * @see #setSkinUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_SkinUri()
	 * @model required="true"
	 * @generated
	 */
	String getSkinUri();
	
//	String getRealSkinUri(boolean secure);

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getSkinUri <em>Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skin Uri</em>' attribute.
	 * @see #getSkinUri()
	 * @generated
	 */
	void setSkinUri(String value);
	
	/**
	 * Returns the value of the '<em><b>Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to JavaScript files, e.g. http://js.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Js Uri</em>' attribute.
	 * @see #setJsUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_JsUri()
	 * @model required="true"
	 * @generated
	 */
	String getJsUri();
	
//	String getRealJsUri(boolean secure);

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getJsUri <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Js Uri</em>' attribute.
	 * @see #getJsUri()
	 * @generated
	 */
	void setJsUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Base Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to website, e.g. https://www.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Base Uri</em>' attribute.
	 * @see #setSecureBaseUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_SecureBaseUri()
	 * @model
	 * @generated
	 */
	String getSecureBaseUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getSecureBaseUri <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Base Uri</em>' attribute.
	 * @see #getSecureBaseUri()
	 * @generated
	 */
	void setSecureBaseUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Images Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute URI to secure image files, e.g. https://images.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Images Uri</em>' attribute.
	 * @see #setSecureImagesUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_SecureImagesUri()
	 * @model
	 * @generated
	 */
	String getSecureImagesUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getSecureImagesUri <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Images Uri</em>' attribute.
	 * @see #getSecureImagesUri()
	 * @generated
	 */
	void setSecureImagesUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Skin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Absolute secure URI to CSS files and dependencies (sprite images, fonts, etc.), e.g. http://skin.berbatik.com/
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Secure Skin Uri</em>' attribute.
	 * @see #setSecureSkinUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_SecureSkinUri()
	 * @model
	 * @generated
	 */
	String getSecureSkinUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getSecureSkinUri <em>Secure Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Skin Uri</em>' attribute.
	 * @see #getSecureSkinUri()
	 * @generated
	 */
	void setSecureSkinUri(String value);

	/**
	 * Returns the value of the '<em><b>Secure Js Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secure Js Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secure Js Uri</em>' attribute.
	 * @see #setSecureJsUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getWebAddress_SecureJsUri()
	 * @model
	 * @generated
	 */
	String getSecureJsUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.WebAddress#getSecureJsUri <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secure Js Uri</em>' attribute.
	 * @see #getSecureJsUri()
	 * @generated
	 */
	void setSecureJsUri(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * API URI is useful if you want to access API resources (e.g. MediaResource) from external apps, email, etc. or where you have taken care of the cross-origin request issues.
	 * 
	 * Always returns baseUri + apiPath, removing double slash.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getApiUri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * API URI is useful if you want to access API resources (e.g. MediaResource) from external apps, email, etc. or where you have taken care of the cross-origin request issues.
	 * 
	 * Always returns secureBaseUri + apiPath, removing double slash.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getSecureApiUri();

} // WebAddress
