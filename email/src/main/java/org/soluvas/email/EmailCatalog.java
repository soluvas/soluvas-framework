/**
 */
package org.soluvas.email;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.soluvas.commons.NsPrefixable;

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
 *   <li>{@link org.soluvas.email.EmailCatalog#getSenderTypes <em>Sender Types</em>}</li>
 *   <li>{@link org.soluvas.email.EmailCatalog#getGeneratedPackageName <em>Generated Package Name</em>}</li>
 *   <li>{@link org.soluvas.email.EmailCatalog#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.soluvas.email.EmailCatalog#getEFactory <em>EFactory</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Sender Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.email.SenderType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender Types</em>' containment reference list.
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_SenderTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SenderType> getSenderTypes();

	/**
	 * Returns the value of the '<em><b>Generated Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generated package name, in order to lookup the Java class. e.g. "id.co.bippo.comment.email".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generated Package Name</em>' attribute.
	 * @see #setGeneratedPackageName(String)
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_GeneratedPackageName()
	 * @model required="true"
	 * @generated
	 */
	String getGeneratedPackageName();

	/**
	 * Sets the value of the '{@link org.soluvas.email.EmailCatalog#getGeneratedPackageName <em>Generated Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated Package Name</em>' attribute.
	 * @see #getGeneratedPackageName()
	 * @generated
	 */
	void setGeneratedPackageName(String value);

	/**
	 * Returns the value of the '<em><b>EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used by EmailCatalogXmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EPackage</em>' reference.
	 * @see #setEPackage(EPackage)
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_EPackage()
	 * @model transient="true"
	 * @generated
	 */
	EPackage getEPackage();

	/**
	 * Sets the value of the '{@link org.soluvas.email.EmailCatalog#getEPackage <em>EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPackage</em>' reference.
	 * @see #getEPackage()
	 * @generated
	 */
	void setEPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used by EmailCatalogXmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EFactory</em>' reference.
	 * @see #setEFactory(EFactory)
	 * @see org.soluvas.email.EmailPackage#getEmailCatalog_EFactory()
	 * @model transient="true"
	 * @generated
	 */
	EFactory getEFactory();

	/**
	 * Sets the value of the '{@link org.soluvas.email.EmailCatalog#getEFactory <em>EFactory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EFactory</em>' reference.
	 * @see #getEFactory()
	 * @generated
	 */
	void setEFactory(EFactory value);

} // EmailCatalog
