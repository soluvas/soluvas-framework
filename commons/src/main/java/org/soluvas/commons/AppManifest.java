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
 *   <li>{@link org.soluvas.commons.AppManifest#getDomain <em>Domain</em>}</li>
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
	 * @model required="true"
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
	 * @model required="true"
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
	 * @model required="true"
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

} // AppManifest
