/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.AppManifest#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getBrandingBundleName <em>Branding Bundle Name</em>}</li>
 *   <li>{@link org.soluvas.commons.AppManifest#getFaviconPath <em>Favicon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getAppManifest()
 * @model
 * @generated
 */
public interface AppManifest extends Positionable, ResourceAware {
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
	 * Returns the value of the '<em><b>Branding Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bundle that contains the branding resources (favicons, logos).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Branding Bundle Name</em>' attribute.
	 * @see #setBrandingBundleName(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_BrandingBundleName()
	 * @model
	 * @generated
	 */
	String getBrandingBundleName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getBrandingBundleName <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branding Bundle Name</em>' attribute.
	 * @see #getBrandingBundleName()
	 * @generated
	 */
	void setBrandingBundleName(String value);

	/**
	 * Returns the value of the '<em><b>Favicon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Relative path to 16x16 favicon.ico file in the branding bundle.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Favicon Path</em>' attribute.
	 * @see #setFaviconPath(String)
	 * @see org.soluvas.commons.CommonsPackage#getAppManifest_FaviconPath()
	 * @model
	 * @generated
	 */
	String getFaviconPath();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.AppManifest#getFaviconPath <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favicon Path</em>' attribute.
	 * @see #getFaviconPath()
	 * @generated
	 */
	void setFaviconPath(String value);

} // AppManifest
