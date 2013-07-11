/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.NameContainer;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mixin Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains a collection of mixins.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.MixinCatalog#getMixins <em>Mixins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getMixinCatalog()
 * @model
 * @generated
 */
public interface MixinCatalog extends NameContainer {
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
	 * @see org.soluvas.data.DataPackage#getMixinCatalog_Mixins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mixin> getMixins();

} // MixinCatalog
