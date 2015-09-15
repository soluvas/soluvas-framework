/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.ObjectNotification#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getObjectNotification()
 * @model abstract="true"
 * @generated
 */
public interface ObjectNotification<T extends EObject> extends ModelNotification<T> {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(EObject)
	 * @see org.soluvas.commons.CommonsPackage#getObjectNotification_Object()
	 * @model required="true"
	 * @generated
	 */
	T getObject();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ObjectNotification#getObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(T value);

} // ObjectNotification
