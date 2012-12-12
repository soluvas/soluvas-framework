/**
 */
package org.soluvas.email;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.EmailCatalog#getPages <em>Pages</em>}</li>
 *   <li>{@link org.soluvas.email.EmailCatalog#getLayouts <em>Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getEmailCatalog()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface EmailCatalog extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.email.PageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_Pages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageType> getPages();

	/**
	 * Returns the value of the '<em><b>Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.email.LayoutType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layouts</em>' containment reference list.
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_Layouts()
	 * @model containment="true"
	 * @generated
	 */
	EList<LayoutType> getLayouts();

} // EmailCatalog
