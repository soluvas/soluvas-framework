/**
 */
package org.soluvas.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soluvas.commons.SerializableEObject;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.Person;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Session Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows universal access to security Subject and derivatives (i.e. Person) from Wicket, JAX-RS, or other means.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.security.AppSessionManager#getSecurityManager <em>Security Manager</em>}</li>
 *   <li>{@link org.soluvas.security.AppSessionManager#getPersonLookup <em>Person Lookup</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.security.SecurityPackage#getAppSessionManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface AppSessionManager extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Security Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Manager</em>' attribute.
	 * @see org.soluvas.security.SecurityPackage#getAppSessionManager_SecurityManager()
	 * @model dataType="org.soluvas.security.SecurityManager" transient="true" changeable="false"
	 * @generated
	 */
	org.apache.shiro.mgt.SecurityManager getSecurityManager();

	/**
	 * Returns the value of the '<em><b>Person Lookup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person Lookup</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person Lookup</em>' attribute.
	 * @see org.soluvas.security.SecurityPackage#getAppSessionManager_PersonLookup()
	 * @model dataType="org.soluvas.security.EntityLookup<? extends org.soluvas.security.Person, org.eclipse.emf.ecore.EString>" transient="true" changeable="false"
	 * @generated
	 */
	EntityLookup<? extends Person, String> getPersonLookup();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Ensure personId is set. If not, throw Exception.
	 * The IP Address and User Agent is required for security purposes.
	 * Convenience method for {@link #requirePerson(RequestIdentity)}.
	 * <!-- end-model-doc -->
	 * @model httpRequestDataType="org.soluvas.security.HttpServletRequest" httpResponseDataType="org.soluvas.security.HttpServletResponse" TBounds="org.soluvas.security.Person"
	 * @generated
	 */
	<T extends Person> T requirePerson(HttpServletRequest httpRequest, HttpServletResponse httpResponse);

} // AppSessionManager
