/**
 */
package org.soluvas.socmed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pinterest Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.socmed.PinterestSysConfig#getPinterestTenantScreenName <em>Pinterest Tenant Screen Name</em>}</li>
 * </ul>
 *
 * @see org.soluvas.socmed.SocmedPackage#getPinterestSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PinterestSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Pinterest Tenant Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Pinterest Business screen name for the tenant/mall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pinterest Tenant Screen Name</em>' attribute.
	 * @see #setPinterestTenantScreenName(String)
	 * @see org.soluvas.socmed.SocmedPackage#getPinterestSysConfig_PinterestTenantScreenName()
	 * @model
	 * @generated
	 */
	String getPinterestTenantScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.PinterestSysConfig#getPinterestTenantScreenName <em>Pinterest Tenant Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pinterest Tenant Screen Name</em>' attribute.
	 * @see #getPinterestTenantScreenName()
	 * @generated
	 */
	void setPinterestTenantScreenName(String value);

} // PinterestSysConfig
