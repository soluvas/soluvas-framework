/**
 */
package org.soluvas.email;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.Layout#getPageSubject <em>Page Subject</em>}</li>
 *   <li>{@link org.soluvas.email.Layout#getPagePlain <em>Page Plain</em>}</li>
 *   <li>{@link org.soluvas.email.Layout#getPageHtml <em>Page Html</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getLayout()
 * @model abstract="true"
 * @generated
 */
public interface Layout extends Template {
	/**
	 * Returns the value of the '<em><b>Page Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rendered subject by Page, to be used as input for the layout.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Subject</em>' attribute.
	 * @see #setPageSubject(String)
	 * @see org.soluvas.email.EmailPackage#getLayout_PageSubject()
	 * @model required="true"
	 * @generated
	 */
	String getPageSubject();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Layout#getPageSubject <em>Page Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Subject</em>' attribute.
	 * @see #getPageSubject()
	 * @generated
	 */
	void setPageSubject(String value);

	/**
	 * Returns the value of the '<em><b>Page Plain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rendered text/plain content by Page, to be used as input for the layout.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Plain</em>' attribute.
	 * @see #setPagePlain(String)
	 * @see org.soluvas.email.EmailPackage#getLayout_PagePlain()
	 * @model required="true"
	 * @generated
	 */
	String getPagePlain();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Layout#getPagePlain <em>Page Plain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Plain</em>' attribute.
	 * @see #getPagePlain()
	 * @generated
	 */
	void setPagePlain(String value);

	/**
	 * Returns the value of the '<em><b>Page Html</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Rendered text/html content by Page, to be used as input for the layout.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Html</em>' attribute.
	 * @see #setPageHtml(String)
	 * @see org.soluvas.email.EmailPackage#getLayout_PageHtml()
	 * @model required="true"
	 * @generated
	 */
	String getPageHtml();

	/**
	 * Sets the value of the '{@link org.soluvas.email.Layout#getPageHtml <em>Page Html</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Html</em>' attribute.
	 * @see #getPageHtml()
	 * @generated
	 */
	void setPageHtml(String value);

} // Layout
