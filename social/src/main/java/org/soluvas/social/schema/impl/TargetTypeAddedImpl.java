/**
 */
package org.soluvas.social.schema.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.TargetTypeAdded;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Type Added</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.social.schema.impl.TargetTypeAddedImpl#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetTypeAddedImpl extends EObjectImpl implements TargetTypeAdded {
	/**
	 * The cached value of the '{@link #getTargetTypes() <em>Target Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetType> targetTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetTypeAddedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchemaPackage.Literals.TARGET_TYPE_ADDED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetType> getTargetTypes() {
		if (targetTypes == null) {
			targetTypes = new EObjectResolvingEList<TargetType>(TargetType.class, this, SchemaPackage.TARGET_TYPE_ADDED__TARGET_TYPES);
		}
		return targetTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchemaPackage.TARGET_TYPE_ADDED__TARGET_TYPES:
				return getTargetTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchemaPackage.TARGET_TYPE_ADDED__TARGET_TYPES:
				getTargetTypes().clear();
				getTargetTypes().addAll((Collection<? extends TargetType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchemaPackage.TARGET_TYPE_ADDED__TARGET_TYPES:
				getTargetTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchemaPackage.TARGET_TYPE_ADDED__TARGET_TYPES:
				return targetTypes != null && !targetTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TargetTypeAddedImpl
