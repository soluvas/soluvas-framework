/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Role Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.CustomerRoleCatalog#getCustomerRoles <em>Customer Roles</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getCustomerRoleCatalog()
 * @model
 * @generated
 */
public interface CustomerRoleCatalog extends EObject {
	/**
	 * Returns the value of the '<em><b>Customer Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.CustomerRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Roles</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getCustomerRoleCatalog_CustomerRoles()
	 * @model containment="true"
	 * @generated
	 */
	EList<CustomerRole> getCustomerRoles();

} // CustomerRoleCatalog
