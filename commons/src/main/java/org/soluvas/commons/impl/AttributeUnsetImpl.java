/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.AttributeUnset;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Unset</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeUnsetImpl<T extends EObject, V> extends AttributeNotificationImpl<T, V> implements AttributeUnset<T, V> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeUnsetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.ATTRIBUTE_UNSET;
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

} //AttributeUnsetImpl
