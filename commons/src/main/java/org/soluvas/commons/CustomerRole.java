/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.CustomerRole#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isQuickShopEnabled <em>Quick Shop Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isSalesOrderReportEnabled <em>Sales Order Report Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isHistorySalesOrderEnabled <em>History Sales Order Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getCustomerRole()
 * @model
 * @generated
 */
public interface CustomerRole extends Identifiable, SchemaVersionable, NameContainer, Timestamped {
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
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_SchemaVersion()
	 * @model default="1" changeable="false"
	 * @generated
	 */
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.CustomerRoleStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.commons.CustomerRoleStatus
	 * @see #setStatus(CustomerRoleStatus)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_Status()
	 * @model
	 * @generated
	 */
	CustomerRoleStatus getStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.commons.CustomerRoleStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(CustomerRoleStatus value);

	/**
	 * Returns the value of the '<em><b>Quick Shop Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Can access to "..quick_shopping_agent/"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quick Shop Enabled</em>' attribute.
	 * @see #setQuickShopEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_QuickShopEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isQuickShopEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isQuickShopEnabled <em>Quick Shop Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quick Shop Enabled</em>' attribute.
	 * @see #isQuickShopEnabled()
	 * @generated
	 */
	void setQuickShopEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Sales Order Report Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Can access to "..user/salesorder_report/"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sales Order Report Enabled</em>' attribute.
	 * @see #setSalesOrderReportEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_SalesOrderReportEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isSalesOrderReportEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isSalesOrderReportEnabled <em>Sales Order Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sales Order Report Enabled</em>' attribute.
	 * @see #isSalesOrderReportEnabled()
	 * @generated
	 */
	void setSalesOrderReportEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>History Sales Order Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Can access to "..user/salesorder/"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>History Sales Order Enabled</em>' attribute.
	 * @see #setHistorySalesOrderEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_HistorySalesOrderEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isHistorySalesOrderEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isHistorySalesOrderEnabled <em>History Sales Order Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History Sales Order Enabled</em>' attribute.
	 * @see #isHistorySalesOrderEnabled()
	 * @generated
	 */
	void setHistorySalesOrderEnabled(boolean value);

} // CustomerRole
