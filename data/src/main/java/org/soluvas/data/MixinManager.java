/**
 */
package org.soluvas.data;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mixin Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.MixinManager#getDataCatalog <em>Data Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getMixinManager()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface MixinManager {
	/**
	 * Returns the value of the '<em><b>Data Catalog</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Catalog</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Catalog</em>' reference.
	 * @see org.soluvas.data.DataPackage#getMixinManager_DataCatalog()
	 * @model changeable="false"
	 * @generated
	 */
	DataCatalog getDataCatalog();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Find mixin by QName, i.e. it must contain nsPrefix, e.g. "base_Apparel".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Mixin findMixin(String qName);

} // MixinManager
