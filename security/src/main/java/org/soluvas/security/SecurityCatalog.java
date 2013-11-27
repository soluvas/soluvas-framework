/**
 */
package org.soluvas.security;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains objects used to define security: roles, instance roles, domains, actions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getInstanceRoles <em>Instance Roles</em>}</li>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getActions <em>Actions</em>}</li>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.soluvas.security.SecurityCatalog#getDomainPermissions <em>Domain Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog()
 * @model
 * @generated
 */
public interface SecurityCatalog extends EObject {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.security.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Instance Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.security.DomainRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Roles</em>' containment reference list.
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_InstanceRoles()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainRole> getInstanceRoles();

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.security.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' containment reference list.
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_Domains()
	 * @model containment="true"
	 * @generated
	 */
	EList<Domain> getDomains();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.security.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.security.Permission}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' containment reference list.
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_Permissions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Permission> getPermissions();

	/**
	 * Returns the value of the '<em><b>Domain Permissions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Permissions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Permissions</em>' reference.
	 * @see #setDomainPermissions(DomainPermission)
	 * @see org.soluvas.security.SecurityPackage#getSecurityCatalog_DomainPermissions()
	 * @model
	 * @generated
	 */
	DomainPermission getDomainPermissions();

	/**
	 * Sets the value of the '{@link org.soluvas.security.SecurityCatalog#getDomainPermissions <em>Domain Permissions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Permissions</em>' reference.
	 * @see #getDomainPermissions()
	 * @generated
	 */
	void setDomainPermissions(DomainPermission value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ensures that {@link Role} definitions have unique IDs and names.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void validate();

} // SecurityCatalog
