/**
 */
package org.soluvas.email;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.DefaultScope#getWebAddress <em>Web Address</em>}</li>
 *   <li>{@link org.soluvas.email.DefaultScope#getAppManifest <em>App Manifest</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getDefaultScope()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DefaultScope extends EObject {
	/**
	 * Returns the value of the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Address</em>' reference.
	 * @see #setWebAddress(WebAddress)
	 * @see org.soluvas.email.EmailPackage#getDefaultScope_WebAddress()
	 * @model
	 * @generated
	 */
	WebAddress getWebAddress();

	/**
	 * Sets the value of the '{@link org.soluvas.email.DefaultScope#getWebAddress <em>Web Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Address</em>' reference.
	 * @see #getWebAddress()
	 * @generated
	 */
	void setWebAddress(WebAddress value);

	/**
	 * Returns the value of the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>App Manifest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>App Manifest</em>' reference.
	 * @see #setAppManifest(AppManifest)
	 * @see org.soluvas.email.EmailPackage#getDefaultScope_AppManifest()
	 * @model
	 * @generated
	 */
	AppManifest getAppManifest();

	/**
	 * Sets the value of the '{@link org.soluvas.email.DefaultScope#getAppManifest <em>App Manifest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App Manifest</em>' reference.
	 * @see #getAppManifest()
	 * @generated
	 */
	void setAppManifest(AppManifest value);

} // DefaultScope
