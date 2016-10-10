/**
 */
package org.soluvas.socmed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instagram Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Instagram SysConfig for tenant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.socmed.InstagramSysConfig#getInstagramScreenName <em>Instagram Screen Name</em>}</li>
 *   <li>{@link org.soluvas.socmed.InstagramSysConfig#getInstagramClientSecret <em>Instagram Client Secret</em>}</li>
 * </ul>
 *
 * @see org.soluvas.socmed.SocmedPackage#getInstagramSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InstagramSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Instagram Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Instagram screen name for tenant, usable in Instagram URI e.g. <a href="http://instagram.com/mamadanbayi">http://instagram.com/mamadanbayi</a>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instagram Screen Name</em>' attribute.
	 * @see #setInstagramScreenName(String)
	 * @see org.soluvas.socmed.SocmedPackage#getInstagramSysConfig_InstagramScreenName()
	 * @model
	 * @generated
	 */
	String getInstagramScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.InstagramSysConfig#getInstagramScreenName <em>Instagram Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instagram Screen Name</em>' attribute.
	 * @see #getInstagramScreenName()
	 * @generated
	 */
	void setInstagramScreenName(String value);

	/**
	 * Returns the value of the '<em><b>Instagram Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instagram Client Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instagram Client Secret</em>' attribute.
	 * @see #setInstagramClientSecret(String)
	 * @see org.soluvas.socmed.SocmedPackage#getInstagramSysConfig_InstagramClientSecret()
	 * @model
	 * @generated
	 */
	String getInstagramClientSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.InstagramSysConfig#getInstagramClientSecret <em>Instagram Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instagram Client Secret</em>' attribute.
	 * @see #getInstagramClientSecret()
	 * @generated
	 */
	void setInstagramClientSecret(String value);

} // InstagramSysConfig
