/**
 */
package org.soluvas.security;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Permission for arbitrary instance of a single domain.
 * 
 * To express "manager of shop X can edit shop X" :
 * domain: shop
 * instanceRole: manager
 * action: edit,delete
 * 
 * More complex use cases are not possible, and need a different and much more complex DSL, such as...
 * 
 * To express "moderator of shop X can edit+delete comment * to shop X"
 * domain: shop
 * instanceRole: moderator
 * action: edit,delete
 * targetDomain: comment
 * targetInstance: *
 * 
 * To express "wink_moderator of zibalabel can edit+delete wink * of product * for zibalabel"
 * 
 * To express "creator of comment X can edit+delete comment X for *":
 * instanceRole: creator
 * domain: comment
 * action: edit,delete
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.security.DomainPermission#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.security.DomainPermission#getDomainRoles <em>Domain Roles</em>}</li>
 *   <li>{@link org.soluvas.security.DomainPermission#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.security.SecurityPackage#getDomainPermission()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface DomainPermission extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A simple (non-composite) domain this permission refers to.
	 * 
	 * A composite domain example is "comment-shop" or "wink-product-person".
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain</em>' attribute.
	 * @see #setDomain(String)
	 * @see org.soluvas.security.SecurityPackage#getDomainPermission_Domain()
	 * @model required="true"
	 * @generated
	 */
	String getDomain();

	/**
	 * Sets the value of the '{@link org.soluvas.security.DomainPermission#getDomain <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' attribute.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(String value);

	/**
	 * Returns the value of the '<em><b>Domain Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Roles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Roles</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getDomainPermission_DomainRoles()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getDomainRoles();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Action permissions given to subjects having the specified domain roles of a particular domain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getDomainPermission_Actions()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getActions();

} // DomainPermission
