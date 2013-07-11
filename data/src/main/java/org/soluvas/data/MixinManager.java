/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mixin Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.MixinManager#getMixinCatalog <em>Mixin Catalog</em>}</li>
 *   <li>{@link org.soluvas.data.MixinManager#getMixins <em>Mixins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getMixinManager()
 * @model
 * @generated
 */
public interface MixinManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixin Catalog</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixin Catalog</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixin Catalog</em>' reference.
	 * @see org.soluvas.data.DataPackage#getMixinManager_MixinCatalog()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	MixinCatalog getMixinCatalog();

	/**
	 * Returns the value of the '<em><b>Mixins</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixins</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixins</em>' attribute.
	 * @see org.soluvas.data.DataPackage#getMixinManager_Mixins()
	 * @model required="true" many="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Mixin> getMixins();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Mixin findMixin(String uName);

} // MixinManager
