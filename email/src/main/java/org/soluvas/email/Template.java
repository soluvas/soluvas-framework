/**
 */
package org.soluvas.email;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.Template#getRecipients <em>Recipients</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getTemplate()
 * @model abstract="true"
 * @generated
 */
public interface Template extends TemplateLike, DefaultScope {
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
