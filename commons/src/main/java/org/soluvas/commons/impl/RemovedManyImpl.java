/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.RemovedMany;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Removed Many</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RemovedManyImpl<T extends EObject> extends ObjectsNotificationImpl<T> implements RemovedMany<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemovedManyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.REMOVED_MANY;
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
			objects = new EDataTypeUniqueEList<T>(EObject.class, this, CommonsPackage.REMOVED_MANY__OBJECTS);
		}
		return objects;
	}

} //RemovedManyImpl
