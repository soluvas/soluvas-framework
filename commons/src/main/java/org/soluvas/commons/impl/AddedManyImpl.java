/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.soluvas.commons.AddedMany;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Added Many</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AddedManyImpl<T extends EObject> extends ObjectsNotificationImpl<T> implements AddedMany<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddedManyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.ADDED_MANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<T> getObjects() {
		if (objects == null) {
			objects = new EDataTypeUniqueEList<T>(EObject.class, this, CommonsPackage.ADDED_MANY__OBJECTS);
		}
		return objects;
	}

} //AddedManyImpl
