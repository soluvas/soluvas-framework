/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objects Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.ObjectsNotification#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getObjectsNotification()
 * @model abstract="true"
 * @generated
 */
public interface ObjectsNotification<T extends EObject> extends ModelNotification<T> {
	/**
	 * Returns the value of the '<em><b>Objects</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getObjectsNotification_Objects()
	 * @model required="true"
	 * @generated
	 */
	EList<T> getObjects();

} // ObjectsNotification
