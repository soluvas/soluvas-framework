/**
 */
package org.soluvas.email;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.WebAddress;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.Template#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.soluvas.email.Template#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link org.soluvas.email.Template#getAppManifest <em>App Manifest</em>}</li>
 *   <li>{@link org.soluvas.email.Template#getWebAddress <em>Web Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getTemplate()
 * @model abstract="true"
 * @generated
 */
public interface Template extends TemplateLike {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(PageType)
	 * @see org.soluvas.email.EmailPackage#getTemplate_Template()
	 * @model
	 * @generated
	 */
	PageType getTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Template#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(PageType value);

	/**
	 * Returns the value of the '<em><b>Recipients</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.email.Recipient}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipients</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipients</em>' reference list.
	 * @see org.soluvas.email.EmailPackage#getTemplate_Recipients()
	 * @model
	 * @generated
	 */
	EList<Recipient> getRecipients();

	/**
	 * Returns the value of the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Address</em>' reference.
	 * @see #setWebAddress(WebAddress)
	 * @see org.soluvas.email.EmailPackage#getTemplate_WebAddress()
	 * @model
	 * @generated
	 */
	WebAddress getWebAddress();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Template#getWebAddress <em>Web Address</em>}' reference.
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
	 * @see org.soluvas.email.EmailPackage#getTemplate_AppManifest()
	 * @model
	 * @generated
	 */
	AppManifest getAppManifest();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Template#getAppManifest <em>App Manifest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>App Manifest</em>' reference.
	 * @see #getAppManifest()
	 * @generated
	 */
	void setAppManifest(AppManifest value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Render the subject.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String renderSubject(Recipient recipient);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Render body using text/plain format.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String renderText(Recipient recipient);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Render body using text/html format.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String renderHtml(Recipient recipient);

} // Template
