/**
 */
package org.soluvas.email;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.email.TemplateLike#getSubjectTemplate <em>Subject Template</em>}</li>
 *   <li>{@link org.soluvas.email.TemplateLike#getPlainTemplate <em>Plain Template</em>}</li>
 *   <li>{@link org.soluvas.email.TemplateLike#getHtmlTemplate <em>Html Template</em>}</li>
 * </ul>
 *
 * @see org.soluvas.email.EmailPackage#getTemplateLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TemplateLike extends EObject {
	/**
	 * Returns the value of the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Some subjects include tracking ID, e.g.
	 * 
	 * <pre>[#MCV-529-28864]: Email forwarding not working</pre>
	 * 
	 * <p>Such subject would use this template:
	 * 
	 * <pre>[#{{{ticket.formalId}}}]: {{{ticket.subject}}}</pre>
	 * 
	 * <p>It's not recommended to put company name in the subject. Best practice is to put the company name as Sender's name, optionally suffixed with "Support" etc. Also, most services (Facebook, NameCheap) do not put the recipient name in the subject.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subject Template</em>' attribute.
	 * @see #setSubjectTemplate(String)
	 * @see org.soluvas.email.EmailPackage#getTemplateLike_SubjectTemplate()
	 * @model
	 * @generated
	 */
	String getSubjectTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.email.TemplateLike#getSubjectTemplate <em>Subject Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject Template</em>' attribute.
	 * @see #getSubjectTemplate()
	 * @generated
	 */
	void setSubjectTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Plain text template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plain Template</em>' attribute.
	 * @see #setPlainTemplate(String)
	 * @see org.soluvas.email.EmailPackage#getTemplateLike_PlainTemplate()
	 * @model
	 * @generated
	 */
	String getPlainTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.email.TemplateLike#getPlainTemplate <em>Plain Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plain Template</em>' attribute.
	 * @see #getPlainTemplate()
	 * @generated
	 */
	void setPlainTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this is null, the html template will be synthesized from plain template.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Html Template</em>' attribute.
	 * @see #setHtmlTemplate(String)
	 * @see org.soluvas.email.EmailPackage#getTemplateLike_HtmlTemplate()
	 * @model
	 * @generated
	 */
	String getHtmlTemplate();

	/**
	 * Sets the value of the '{@link org.soluvas.email.TemplateLike#getHtmlTemplate <em>Html Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Html Template</em>' attribute.
	 * @see #getHtmlTemplate()
	 * @generated
	 */
	void setHtmlTemplate(String value);

} // TemplateLike
