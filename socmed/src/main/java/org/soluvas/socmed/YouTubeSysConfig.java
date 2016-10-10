/**
 */
package org.soluvas.socmed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>You Tube Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * YouTube SysConfig for tenant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.socmed.YouTubeSysConfig#getYouTubeTenantScreenName <em>You Tube Tenant Screen Name</em>}</li>
 * </ul>
 *
 * @see org.soluvas.socmed.SocmedPackage#getYouTubeSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface YouTubeSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>You Tube Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * YouTube user screen name for the tenant, e.g. <a href="http://www.youtube.com/user/BippoID">bippoID</a>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>You Tube Tenant Screen Name</em>' attribute.
	 * @see #setYouTubeTenantScreenName(String)
	 * @see org.soluvas.socmed.SocmedPackage#getYouTubeSysConfig_YouTubeTenantScreenName()
	 * @model
	 * @generated
	 */
	String getYouTubeTenantScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.YouTubeSysConfig#getYouTubeTenantScreenName <em>You Tube Tenant Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>You Tube Tenant Screen Name</em>' attribute.
	 * @see #getYouTubeTenantScreenName()
	 * @generated
	 */
	void setYouTubeTenantScreenName(String value);

} // YouTubeSysConfig
