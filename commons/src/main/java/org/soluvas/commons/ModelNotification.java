/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Inspired by {@link org.eclipse.emf.common.notify.Notification}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.ModelNotification#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getModelNotification()
 * @model abstract="true"
 * @generated
 */
public interface ModelNotification<T extends EObject> extends EObjectLinked<T> {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(EObject)
	 * @see org.soluvas.commons.CommonsPackage#getModelNotification_Container()
	 * @model
	 * @generated
	 */
	EObject getContainer();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ModelNotification#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EObject value);

} // ModelNotification
