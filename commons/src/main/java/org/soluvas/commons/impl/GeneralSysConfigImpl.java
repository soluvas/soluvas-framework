/**
 */
package org.soluvas.commons.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.GeneralSysConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getExpansionState <em>Expansion State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GeneralSysConfigImpl extends MinimalEObjectImpl.Container implements GeneralSysConfig {
	/**
	 * The default value of the '{@link #getExpansionState() <em>Expansion State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpansionState()
	 * @generated
	 * @ordered
	 */
	protected static final ExpansionState EXPANSION_STATE_EDEFAULT = ExpansionState.UNEXPANDED;

	/**
	 * The cached value of the '{@link #getExpansionState() <em>Expansion State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpansionState()
	 * @generated
	 * @ordered
	 */
	protected ExpansionState expansionState = EXPANSION_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralSysConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.GENERAL_SYS_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpansionState getExpansionState() {
		return expansionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void expand(Map<String, Object> scope) throws Exception {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.GENERAL_SYS_CONFIG__EXPANSION_STATE:
				return getExpansionState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonsPackage.GENERAL_SYS_CONFIG__EXPANSION_STATE:
				return expansionState != EXPANSION_STATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CommonsPackage.GENERAL_SYS_CONFIG___EXPAND__MAP:
				try {
					expand((Map<String, Object>)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expansionState: ");
		result.append(expansionState);
		result.append(')');
		return result.toString();
	}
	
} //GeneralSysConfigImpl
