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
 * <ul>
 *   <li>{@link org.soluvas.socmed.InstagramSysConfig#getInstagramScreenName <em>Instagram Screen Name</em>}</li>
 * </ul>
 * </p>
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

} // InstagramSysConfig
