/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains collections of data objects: kinds, terms.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.DataCatalog#getVocabs <em>Vocabs</em>}</li>
 *   <li>{@link org.soluvas.data.DataCatalog#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.soluvas.data.DataCatalog#getKinds <em>Kinds</em>}</li>
 * </ul>
 *
 * @see org.soluvas.data.DataPackage#getDataCatalog()
 * @model extendedMetaData="name='DataCatalog'"
 * @generated
 */
public interface DataCatalog extends BundleAware, ResourceAware, NameContainer {
	/**
	 * Returns the value of the '<em><b>Vocabs</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.Vocab}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vocabs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vocabs</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getDataCatalog_Vocabs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vocab> getVocabs();

	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.Term}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getDataCatalog_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Term> getTerms();

	/**
	 * Returns the value of the '<em><b>Kinds</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.Kind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kinds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kinds</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getDataCatalog_Kinds()
	 * @model containment="true"
	 * @generated
	 */
	EList<Kind> getKinds();

} // DataCatalog
