/**
 */
package org.soluvas.commons.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.SysConfig;
import org.soluvas.commons.Timestamped;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Sys Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getExpansionState <em>Expansion State</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getTenantId <em>Tenant Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.GeneralSysConfigImpl#getSslSupported <em>Ssl Supported</em>}</li>
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
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected static final DateTime MODIFICATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationTime() <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationTime()
	 * @generated
	 * @ordered
	 */
	protected DateTime modificationTime = MODIFICATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTenantId() <em>Tenant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantId()
	 * @generated
	 * @ordered
	 */
	protected static final String TENANT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTenantId() <em>Tenant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenantId()
	 * @generated
	 * @ordered
	 */
	protected String tenantId = TENANT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSslSupported() <em>Ssl Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslSupported()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SSL_SUPPORTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSslSupported() <em>Ssl Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSslSupported()
	 * @generated
	 * @ordered
	 */
	protected Boolean sslSupported = SSL_SUPPORTED_EDEFAULT;

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
	 * @generated
	 */
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(DateTime newCreationTime) {
		DateTime oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModificationTime(DateTime newModificationTime) {
		DateTime oldModificationTime = modificationTime;
		modificationTime = newModificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTenantId(String newTenantId) {
		String oldTenantId = tenantId;
		tenantId = newTenantId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID, oldTenantId, tenantId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getSslSupported() {
		return sslSupported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSslSupported(Boolean newSslSupported) {
		Boolean oldSslSupported = sslSupported;
		sslSupported = newSslSupported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.GENERAL_SYS_CONFIG__SSL_SUPPORTED, oldSslSupported, sslSupported));
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
			case CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME:
				return getCreationTime();
			case CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME:
				return getModificationTime();
			case CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID:
				return getTenantId();
			case CommonsPackage.GENERAL_SYS_CONFIG__SSL_SUPPORTED:
				return getSslSupported();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID:
				setTenantId((String)newValue);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__SSL_SUPPORTED:
				setSslSupported((Boolean)newValue);
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
			case CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID:
				setTenantId(TENANT_ID_EDEFAULT);
				return;
			case CommonsPackage.GENERAL_SYS_CONFIG__SSL_SUPPORTED:
				setSslSupported(SSL_SUPPORTED_EDEFAULT);
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
			case CommonsPackage.GENERAL_SYS_CONFIG__EXPANSION_STATE:
				return expansionState != EXPANSION_STATE_EDEFAULT;
			case CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID:
				return TENANT_ID_EDEFAULT == null ? tenantId != null : !TENANT_ID_EDEFAULT.equals(tenantId);
			case CommonsPackage.GENERAL_SYS_CONFIG__SSL_SUPPORTED:
				return SSL_SUPPORTED_EDEFAULT == null ? sslSupported != null : !SSL_SUPPORTED_EDEFAULT.equals(sslSupported);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SysConfig.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID: return CommonsPackage.SYS_CONFIG__TENANT_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return CommonsPackage.GENERAL_SYS_CONFIG__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return CommonsPackage.GENERAL_SYS_CONFIG__MODIFICATION_TIME;
				default: return -1;
			}
		}
		if (baseClass == SysConfig.class) {
			switch (baseFeatureID) {
				case CommonsPackage.SYS_CONFIG__TENANT_ID: return CommonsPackage.GENERAL_SYS_CONFIG__TENANT_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", tenantId: ");
		result.append(tenantId);
		result.append(", sslSupported: ");
		result.append(sslSupported);
		result.append(')');
		return result.toString();
	}
	
} //GeneralSysConfigImpl
