/**
 */
package org.soluvas.email;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.EmailCatalog#getPageTypes <em>Page Types</em>}</li>
 *   <li>{@link org.soluvas.email.EmailCatalog#getLayoutTypes <em>Layout Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getEmailCatalog()
 * @model
 * @generated
 */
public interface EmailCatalog extends NsPrefixable {
	/**
	 * Returns the value of the '<em><b>Page Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.email.PageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Types</em>' containment reference list.
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_PageTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageType> getPageTypes();

	/**
	 * Returns the value of the '<em><b>Layout Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.email.LayoutType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Types</em>' containment reference list.
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_LayoutTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<LayoutType> getLayoutTypes();

} // EmailCatalog
