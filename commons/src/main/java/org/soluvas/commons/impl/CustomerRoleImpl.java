/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.CustomerRoleStatus;
import org.soluvas.commons.Describable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.mongo.DateTimeConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Id;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isQuickShopEnabled <em>Quick Shop Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isSalesOrderReportEnabled <em>Sales Order Report Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isHistorySalesOrderEnabled <em>History Sales Order Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isAgentSalesReportEnabled <em>Agent Sales Report Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isTransactionHistoryEnabled <em>Transaction History Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isBookingEnabled <em>Booking Enabled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleImpl#isPaymentGatewayEnabled <em>Payment Gateway Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@Converters({DateTimeConverter.class})
public class CustomerRoleImpl extends MinimalEObjectImpl.Container implements CustomerRole {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@Id protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime MODIFICATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime modificationTime = MODIFICATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 2L;

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final CustomerRoleStatus STATUS_EDEFAULT = CustomerRoleStatus.ACTIVE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected CustomerRoleStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isQuickShopEnabled() <em>Quick Shop Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQuickShopEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean QUICK_SHOP_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isQuickShopEnabled() <em>Quick Shop Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQuickShopEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean quickShopEnabled = QUICK_SHOP_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSalesOrderReportEnabled() <em>Sales Order Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSalesOrderReportEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SALES_ORDER_REPORT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSalesOrderReportEnabled() <em>Sales Order Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSalesOrderReportEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean salesOrderReportEnabled = SALES_ORDER_REPORT_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isHistorySalesOrderEnabled() <em>History Sales Order Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorySalesOrderEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HISTORY_SALES_ORDER_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHistorySalesOrderEnabled() <em>History Sales Order Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorySalesOrderEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean historySalesOrderEnabled = HISTORY_SALES_ORDER_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isAgentSalesReportEnabled() <em>Agent Sales Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAgentSalesReportEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AGENT_SALES_REPORT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAgentSalesReportEnabled() <em>Agent Sales Report Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAgentSalesReportEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean agentSalesReportEnabled = AGENT_SALES_REPORT_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransactionHistoryEnabled() <em>Transaction History Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransactionHistoryEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSACTION_HISTORY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransactionHistoryEnabled() <em>Transaction History Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransactionHistoryEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean transactionHistoryEnabled = TRANSACTION_HISTORY_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isBookingEnabled() <em>Booking Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBookingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOKING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBookingEnabled() <em>Booking Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBookingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean bookingEnabled = BOOKING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPaymentGatewayEnabled() <em>Payment Gateway Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaymentGatewayEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PAYMENT_GATEWAY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPaymentGatewayEnabled() <em>Payment Gateway Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaymentGatewayEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean paymentGatewayEnabled = PAYMENT_GATEWAY_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.CUSTOMER_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(DateTime newCreationTime) {
		DateTime oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModificationTime(DateTime newModificationTime) {
		DateTime oldModificationTime = modificationTime;
		modificationTime = newModificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__DESCRIPTION, oldDescription, description));
	}

	public static long serialVersionUID = SCHEMA_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CustomerRoleStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(CustomerRoleStatus newStatus) {
		CustomerRoleStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isQuickShopEnabled() {
		return quickShopEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuickShopEnabled(boolean newQuickShopEnabled) {
		boolean oldQuickShopEnabled = quickShopEnabled;
		quickShopEnabled = newQuickShopEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED, oldQuickShopEnabled, quickShopEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSalesOrderReportEnabled() {
		return salesOrderReportEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesOrderReportEnabled(boolean newSalesOrderReportEnabled) {
		boolean oldSalesOrderReportEnabled = salesOrderReportEnabled;
		salesOrderReportEnabled = newSalesOrderReportEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED, oldSalesOrderReportEnabled, salesOrderReportEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHistorySalesOrderEnabled() {
		return historySalesOrderEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistorySalesOrderEnabled(boolean newHistorySalesOrderEnabled) {
		boolean oldHistorySalesOrderEnabled = historySalesOrderEnabled;
		historySalesOrderEnabled = newHistorySalesOrderEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED, oldHistorySalesOrderEnabled, historySalesOrderEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAgentSalesReportEnabled() {
		return agentSalesReportEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentSalesReportEnabled(boolean newAgentSalesReportEnabled) {
		boolean oldAgentSalesReportEnabled = agentSalesReportEnabled;
		agentSalesReportEnabled = newAgentSalesReportEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED, oldAgentSalesReportEnabled, agentSalesReportEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransactionHistoryEnabled() {
		return transactionHistoryEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionHistoryEnabled(boolean newTransactionHistoryEnabled) {
		boolean oldTransactionHistoryEnabled = transactionHistoryEnabled;
		transactionHistoryEnabled = newTransactionHistoryEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__TRANSACTION_HISTORY_ENABLED, oldTransactionHistoryEnabled, transactionHistoryEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBookingEnabled() {
		return bookingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBookingEnabled(boolean newBookingEnabled) {
		boolean oldBookingEnabled = bookingEnabled;
		bookingEnabled = newBookingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__BOOKING_ENABLED, oldBookingEnabled, bookingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPaymentGatewayEnabled() {
		return paymentGatewayEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaymentGatewayEnabled(boolean newPaymentGatewayEnabled) {
		boolean oldPaymentGatewayEnabled = paymentGatewayEnabled;
		paymentGatewayEnabled = newPaymentGatewayEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.CUSTOMER_ROLE__PAYMENT_GATEWAY_ENABLED, oldPaymentGatewayEnabled, paymentGatewayEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.CUSTOMER_ROLE__ID:
				return getId();
			case CommonsPackage.CUSTOMER_ROLE__NAME:
				return getName();
			case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME:
				return getCreationTime();
			case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME:
				return getModificationTime();
			case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION:
				return getDescription();
			case CommonsPackage.CUSTOMER_ROLE__SCHEMA_VERSION:
				return getSchemaVersion();
			case CommonsPackage.CUSTOMER_ROLE__STATUS:
				return getStatus();
			case CommonsPackage.CUSTOMER_ROLE__READ_ONLY:
				return isReadOnly();
			case CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED:
				return isQuickShopEnabled();
			case CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED:
				return isSalesOrderReportEnabled();
			case CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED:
				return isHistorySalesOrderEnabled();
			case CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED:
				return isAgentSalesReportEnabled();
			case CommonsPackage.CUSTOMER_ROLE__TRANSACTION_HISTORY_ENABLED:
				return isTransactionHistoryEnabled();
			case CommonsPackage.CUSTOMER_ROLE__BOOKING_ENABLED:
				return isBookingEnabled();
			case CommonsPackage.CUSTOMER_ROLE__PAYMENT_GATEWAY_ENABLED:
				return isPaymentGatewayEnabled();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonsPackage.CUSTOMER_ROLE__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__STATUS:
				setStatus((CustomerRoleStatus)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__READ_ONLY:
				setReadOnly((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED:
				setQuickShopEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED:
				setSalesOrderReportEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED:
				setHistorySalesOrderEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED:
				setAgentSalesReportEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__TRANSACTION_HISTORY_ENABLED:
				setTransactionHistoryEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__BOOKING_ENABLED:
				setBookingEnabled((Boolean)newValue);
				return;
			case CommonsPackage.CUSTOMER_ROLE__PAYMENT_GATEWAY_ENABLED:
				setPaymentGatewayEnabled((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommonsPackage.CUSTOMER_ROLE__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED:
				setQuickShopEnabled(QUICK_SHOP_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED:
				setSalesOrderReportEnabled(SALES_ORDER_REPORT_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED:
				setHistorySalesOrderEnabled(HISTORY_SALES_ORDER_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED:
				setAgentSalesReportEnabled(AGENT_SALES_REPORT_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__TRANSACTION_HISTORY_ENABLED:
				setTransactionHistoryEnabled(TRANSACTION_HISTORY_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__BOOKING_ENABLED:
				setBookingEnabled(BOOKING_ENABLED_EDEFAULT);
				return;
			case CommonsPackage.CUSTOMER_ROLE__PAYMENT_GATEWAY_ENABLED:
				setPaymentGatewayEnabled(PAYMENT_GATEWAY_ENABLED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonsPackage.CUSTOMER_ROLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.CUSTOMER_ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonsPackage.CUSTOMER_ROLE__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__STATUS:
				return status != STATUS_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED:
				return quickShopEnabled != QUICK_SHOP_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED:
				return salesOrderReportEnabled != SALES_ORDER_REPORT_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED:
				return historySalesOrderEnabled != HISTORY_SALES_ORDER_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED:
				return agentSalesReportEnabled != AGENT_SALES_REPORT_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__TRANSACTION_HISTORY_ENABLED:
				return transactionHistoryEnabled != TRANSACTION_HISTORY_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__BOOKING_ENABLED:
				return bookingEnabled != BOOKING_ENABLED_EDEFAULT;
			case CommonsPackage.CUSTOMER_ROLE__PAYMENT_GATEWAY_ENABLED:
				return paymentGatewayEnabled != PAYMENT_GATEWAY_ENABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CUSTOMER_ROLE__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return CommonsPackage.CUSTOMER_ROLE__NAME;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return CommonsPackage.CUSTOMER_ROLE__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return CommonsPackage.CUSTOMER_ROLE__DESCRIPTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", description: ");
		result.append(description);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", status: ");
		result.append(status);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", quickShopEnabled: ");
		result.append(quickShopEnabled);
		result.append(", salesOrderReportEnabled: ");
		result.append(salesOrderReportEnabled);
		result.append(", historySalesOrderEnabled: ");
		result.append(historySalesOrderEnabled);
		result.append(", agentSalesReportEnabled: ");
		result.append(agentSalesReportEnabled);
		result.append(", transactionHistoryEnabled: ");
		result.append(transactionHistoryEnabled);
		result.append(", bookingEnabled: ");
		result.append(bookingEnabled);
		result.append(", paymentGatewayEnabled: ");
		result.append(paymentGatewayEnabled);
		result.append(')');
		return result.toString();
	}

} //CustomerRoleImpl
