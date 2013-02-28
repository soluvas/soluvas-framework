/**
 */
package org.soluvas.data;

import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

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
 * @see org.soluvas.data.DataPackage#getTermManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface TermManager extends SerializableEObject {
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
	List<Term> findTerms(String attributeTypeNsPrefix, String attributeTypeName);

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

} // TermManager
