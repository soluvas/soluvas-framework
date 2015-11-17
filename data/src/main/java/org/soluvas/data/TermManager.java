/**
 */
package org.soluvas.data;

import java.util.List;

import com.google.common.collect.Multimap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.TermManager#getDataCatalog <em>Data Catalog</em>}</li>
 * </ul>
 * </p>
 *
 *Use MongoTermRepository
 *
 * @see org.soluvas.data.DataPackage#getTermManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
@Deprecated
public interface TermManager {
	/**
	 * Returns the value of the '<em><b>Data Catalog</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Catalog</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Catalog</em>' reference.
	 * @see org.soluvas.data.DataPackage#getTermManager_DataCatalog()
	 * @model changeable="false"
	 * @generated
	 */
	DataCatalog getDataCatalog();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.soluvas.commons.List<org.soluvas.data.Term>" many="false"
	 * @generated
	 */
	List<Term> findTerms(String kindNsPrefix, String kindName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List all terms partitioned by attribute type ({nsPrefix}_{name}).
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.soluvas.commons.Multimap<org.eclipse.emf.ecore.EString, org.soluvas.data.Term>"
	 * @generated
	 */
	Multimap<String, Term> getTermsByAttributeTypes();
	
	/**
	 * @param qName
	 * @return
	 * @todo FIXME: Do <b>not</b> use this for dynamic kinds like {@code base_Color} and {@code base_Size},
	 * 		because not yet updated to use {@link TermRepository}. For now please use {@code color/size} {@link TermRepository} instead.
	 */
	Term findTerm(String qName);

} // TermManager
