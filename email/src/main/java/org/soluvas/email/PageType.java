/**
 */
package org.soluvas.email;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.PageType#getSenderTypeName <em>Sender Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getPageType()
 * @model
 * @generated
 */
public interface PageType extends TemplateType<Page> {

	/**
	 * Returns the value of the '<em><b>Sender Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sender type name, including prefix. If not set, "builtin:general" is default.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sender Type Name</em>' attribute.
	 * @see #setSenderTypeName(String)
	 * @see org.soluvas.email.EmailPackage#getPageType_SenderTypeName()
	 * @model
	 * @generated
	 */
	String getSenderTypeName();

	/**
	 * Sets the value of the '{@link org.soluvas.email.PageType#getSenderTypeName <em>Sender Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender Type Name</em>' attribute.
	 * @see #getSenderTypeName()
	 * @generated
	 */
	void setSenderTypeName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create Page using the specified layout.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Page create(Layout layout);
} // PageType
