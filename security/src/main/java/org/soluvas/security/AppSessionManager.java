/**
 */
package org.soluvas.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.entity.Person2;
import org.soluvas.data.EntityLookup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>App Session Manager</b></em>'.
 * @deprecated Do we still need this? Or Shiro's {@link Session} is enough for all purposes (i.e. REST API sessions)?
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows universal access to security Subject and derivatives (i.e. Person) from Wicket, JAX-RS, or other means.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.security.AppSessionManager#getSecurityManager <em>Security Manager</em>}</li>
 *   <li>{@link org.soluvas.security.AppSessionManager#getPersonLookup <em>Person Lookup</em>}</li>
 * </ul>
 *
 * @see org.soluvas.security.SecurityPackage#getAppSessionManager()
 * @model
 * @generated
 */
@Deprecated
public interface AppSessionManager extends EObject {
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
	 * @model dataType="org.soluvas.security.EntityLookup<? extends org.soluvas.commons.Person, org.eclipse.emf.ecore.EString>" transient="true" changeable="false"
	 * @generated
	 */
	EntityLookup<? extends Person2, String> getPersonLookup();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Ensure personId is set. If not, throw Exception.
	 * The IP Address and User Agent is required for security purposes.
	 * Convenience method for {@link #requirePerson(RequestIdentity)}.
	 * <!-- end-model-doc -->
	 * @model httpRequestDataType="org.soluvas.security.HttpServletRequest" httpResponseDataType="org.soluvas.security.HttpServletResponse"
	 * @generated
	 */
	<T extends Person2> T requirePerson(HttpServletRequest httpRequest, HttpServletResponse httpResponse);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model subjectDataType="org.soluvas.security.Subject"
	 * @generated
	 */
	<T extends Person2> T requirePerson(Subject subject);

} // AppSessionManager
