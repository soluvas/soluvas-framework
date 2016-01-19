/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base EMF Interface of system configuration for a tenant.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.SysConfig#getTenantId <em>Tenant Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SysConfig extends Timestamped, EObject {
	/**
	 * Returns the value of the '<em><b>Tenant Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tenant ID (without tenantEnv) which this sysconfig applies to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tenant Id</em>' attribute.
	 * @see #setTenantId(String)
	 * @see org.soluvas.commons.CommonsPackage#getSysConfig_TenantId()
	 * @model
	 * @generated
	 */
	String getTenantId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.SysConfig#getTenantId <em>Tenant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tenant Id</em>' attribute.
	 * @see #getTenantId()
	 * @generated
	 */
	void setTenantId(String value);

} // SysConfig
