/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Informer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Can transform itself an "Info" object.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.commons.CommonsPackage#getInformer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Informer<T extends Identifiable> extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Transforms to its "Info" model.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	T toInfo();

} // Informer
