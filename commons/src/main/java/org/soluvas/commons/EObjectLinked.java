/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Linked</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.commons.CommonsPackage#getEObjectLinked()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EObjectLinked<T extends EObject> extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	T getObject();

} // EObjectLinked
