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

} // CustomerRole
