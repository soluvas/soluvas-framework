/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Removed;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Removed</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RemovedImpl<T extends EObject> extends ObjectNotificationImpl<T> implements Removed<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemovedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.REMOVED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setObject(T newObject) {
		super.setObject(newObject);
	}

} //RemovedImpl
