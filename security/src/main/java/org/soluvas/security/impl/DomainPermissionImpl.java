/**
 */
package org.soluvas.security.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.soluvas.security.DomainPermission;
import org.soluvas.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.security.impl.DomainPermissionImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.soluvas.security.impl.DomainPermissionImpl#getDomainRoles <em>Domain Roles</em>}</li>
 *   <li>{@link org.soluvas.security.impl.DomainPermissionImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainPermissionImpl extends EObjectImpl implements DomainPermission {
	/**
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected String domain = DOMAIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomainRoles() <em>Domain Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> domainRoles;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.DOMAIN_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(String newDomain) {
		String oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.DOMAIN_PERMISSION__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDomainRoles() {
		if (domainRoles == null) {
			domainRoles = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.DOMAIN_PERMISSION__DOMAIN_ROLES);
		}
		return domainRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getActions() {
		if (actions == null) {
			actions = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.DOMAIN_PERMISSION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN:
				return getDomain();
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN_ROLES:
				return getDomainRoles();
			case SecurityPackage.DOMAIN_PERMISSION__ACTIONS:
				return getActions();
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
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN:
				setDomain((String)newValue);
				return;
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN_ROLES:
				getDomainRoles().clear();
				getDomainRoles().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.DOMAIN_PERMISSION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends String>)newValue);
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
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
				return;
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN_ROLES:
				getDomainRoles().clear();
				return;
			case SecurityPackage.DOMAIN_PERMISSION__ACTIONS:
				getActions().clear();
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
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN:
				return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
			case SecurityPackage.DOMAIN_PERMISSION__DOMAIN_ROLES:
				return domainRoles != null && !domainRoles.isEmpty();
			case SecurityPackage.DOMAIN_PERMISSION__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (domain: ");
		result.append(domain);
		result.append(", domainRoles: ");
		result.append(domainRoles);
		result.append(", actions: ");
		result.append(actions);
		result.append(')');
		return result.toString();
	}

} //DomainPermissionImpl
