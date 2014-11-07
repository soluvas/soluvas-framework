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
 *   <li>{@link org.soluvas.commons.CustomerRole#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isQuickShopEnabled <em>Quick Shop Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isSalesOrderReportEnabled <em>Sales Order Report Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isHistorySalesOrderEnabled <em>History Sales Order Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isAgentSalesReportEnabled <em>Agent Sales Report Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isTransactionHistoryEnabled <em>Transaction History Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.CustomerRole#isBookingEnabled <em>Booking Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getCustomerRole()
 * @model
 * @generated
 */
public interface CustomerRole extends Identifiable, SchemaVersionable, NameContainer, Timestamped, Describable {
	
	/**
	 * Registered user / retail.
	 */
	static final String COMMON_ID = "common";
	/**
	 * Premium Member.
	 */
	static final String MEMBER_ID = "member"; 
	/**
	 * Reseller agent.
	 */
	static final String AGENT_ID = "agent";
	/**
	 * Retailers not keeping goods in stock, but instead transfer customer orders and shipment details to us.
	 */
	static final String DROPS_ID = "drops";
	
	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_SchemaVersion()
	 * @model default="2" required="true" changeable="false"
	 * @generated
	 */
	@Override
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
	 * @model required="true"
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
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Read-only customer roles are defined by the application and not editable by the tenant administrator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_ReadOnly()
	 * @model required="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

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

	/**
	 * Returns the value of the '<em><b>Agent Sales Report Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For accessing "..agent_sales_report/mall/"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Agent Sales Report Enabled</em>' attribute.
	 * @see #setAgentSalesReportEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_AgentSalesReportEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isAgentSalesReportEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isAgentSalesReportEnabled <em>Agent Sales Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agent Sales Report Enabled</em>' attribute.
	 * @see #isAgentSalesReportEnabled()
	 * @generated
	 */
	void setAgentSalesReportEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Transaction History Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction History Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction History Enabled</em>' attribute.
	 * @see #setTransactionHistoryEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_TransactionHistoryEnabled()
	 * @model
	 * @generated
	 */
	boolean isTransactionHistoryEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isTransactionHistoryEnabled <em>Transaction History Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction History Enabled</em>' attribute.
	 * @see #isTransactionHistoryEnabled()
	 * @generated
	 */
	void setTransactionHistoryEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Booking Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Booking Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Booking Enabled</em>' attribute.
	 * @see #setBookingEnabled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRole_BookingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isBookingEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CustomerRole#isBookingEnabled <em>Booking Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Booking Enabled</em>' attribute.
	 * @see #isBookingEnabled()
	 * @generated
	 */
	void setBookingEnabled(boolean value);

} // CustomerRole
