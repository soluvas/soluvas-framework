/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.Added;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Added</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AddedImpl<T extends EObject> extends ObjectNotificationImpl<T> implements Added<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.ADDED;
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

} //AddedImpl
