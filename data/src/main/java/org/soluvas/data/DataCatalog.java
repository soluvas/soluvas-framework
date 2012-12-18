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
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.DataCatalog#getVocabs <em>Vocabs</em>}</li>
 *   <li>{@link org.soluvas.data.DataCatalog#getMixins <em>Mixins</em>}</li>
 *   <li>{@link org.soluvas.data.DataCatalog#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.soluvas.data.DataCatalog#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
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
	 * Returns the value of the '<em><b>Mixins</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.Mixin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixins</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getDataCatalog_Mixins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mixin> getMixins();

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
	 * Returns the value of the '<em><b>Attribute Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Types</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getDataCatalog_AttributeTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeType> getAttributeTypes();

} // DataCatalog
