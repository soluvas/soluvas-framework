/**
 */
package org.soluvas.security;

import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Roles contain global permissions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.security.Role#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.security.Role#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.security.Role#getAssignMode <em>Assign Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.security.SecurityPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends ResourceAware {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of role, e.g. "admin", "sysadmin", "manager", "sales", in lower_underscore format.
	 * 
	 * This corresponds directly to entries in ou=groups in LDAP.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.soluvas.security.SecurityPackage#getRole_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.soluvas.security.Role#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.soluvas.security.SecurityPackage#getRole_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.security.Role#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Assign Mode</b></em>' attribute.
	 * The default value is <code>"manual"</code>.
	 * The literals are from the enumeration {@link org.soluvas.security.AssignMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign Mode</em>' attribute.
	 * @see org.soluvas.security.AssignMode
	 * @see #setAssignMode(AssignMode)
	 * @see org.soluvas.security.SecurityPackage#getRole_AssignMode()
	 * @model default="manual"
	 * @generated
	 */
	AssignMode getAssignMode();

	/**
	 * Sets the value of the '{@link org.soluvas.security.Role#getAssignMode <em>Assign Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assign Mode</em>' attribute.
	 * @see org.soluvas.security.AssignMode
	 * @see #getAssignMode()
	 * @generated
	 */
	void setAssignMode(AssignMode value);

} // Role
