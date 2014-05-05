/**
 */
package org.soluvas.security.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.soluvas.security.Action;
import org.soluvas.security.Domain;
import org.soluvas.security.DomainPermission;
import org.soluvas.security.DomainRole;
import org.soluvas.security.Permission;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityException;
import org.soluvas.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getInstanceRoles <em>Instance Roles</em>}</li>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.soluvas.security.impl.SecurityCatalogImpl#getDomainPermissions <em>Domain Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecurityCatalogImpl extends EObjectImpl implements SecurityCatalog {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getInstanceRoles() <em>Instance Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainRole> instanceRoles;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domains;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getPermissions() <em>Permissions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissions()
	 * @generated
	 * @ordered
	 */
	protected EList<Permission> permissions;

	/**
	 * The cached value of the '{@link #getDomainPermissions() <em>Domain Permissions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainPermissions()
	 * @generated
	 * @ordered
	 */
	protected DomainPermission domainPermissions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.SECURITY_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this, SecurityPackage.SECURITY_CATALOG__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainRole> getInstanceRoles() {
		if (instanceRoles == null) {
			instanceRoles = new EObjectContainmentEList<DomainRole>(DomainRole.class, this, SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES);
		}
		return instanceRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Domain> getDomains() {
		if (domains == null) {
			domains = new EObjectContainmentEList<Domain>(Domain.class, this, SecurityPackage.SECURITY_CATALOG__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, SecurityPackage.SECURITY_CATALOG__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Permission> getPermissions() {
		if (permissions == null) {
			permissions = new EObjectContainmentEList<Permission>(Permission.class, this, SecurityPackage.SECURITY_CATALOG__PERMISSIONS);
		}
		return permissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainPermission getDomainPermissions() {
		if (domainPermissions != null && domainPermissions.eIsProxy()) {
			InternalEObject oldDomainPermissions = (InternalEObject)domainPermissions;
			domainPermissions = (DomainPermission)eResolveProxy(oldDomainPermissions);
			if (domainPermissions != oldDomainPermissions) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS, oldDomainPermissions, domainPermissions));
			}
		}
		return domainPermissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPermission basicGetDomainPermissions() {
		return domainPermissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainPermissions(DomainPermission newDomainPermissions) {
		DomainPermission oldDomainPermissions = domainPermissions;
		domainPermissions = newDomainPermissions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS, oldDomainPermissions, domainPermissions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void validate() {
		final Map<String, Role> previousRoles = new HashMap<>();
		final Set<String> roleNames = new HashSet<>();
		for (final Role role : getRoles()) {
			if (previousRoles.containsKey(role.getId())) {
				throw new SecurityException(String.format("Duplicate role ID: '%s' from '%s', already loaded from '%s'", 
						role.getId(), role.getResourceUri(), previousRoles.get(role.getId()).getResourceUri()));
			}
			if (roleNames.contains(role.getName())) {
				throw new SecurityException(String.format("Duplicate role name: '%s' from '%s'", 
						role.getName(), role.getResourceUri()));
			}
			previousRoles.put(role.getId(), role);
			roleNames.add(role.getName());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SecurityPackage.SECURITY_CATALOG__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES:
				return ((InternalEList<?>)getInstanceRoles()).basicRemove(otherEnd, msgs);
			case SecurityPackage.SECURITY_CATALOG__DOMAINS:
				return ((InternalEList<?>)getDomains()).basicRemove(otherEnd, msgs);
			case SecurityPackage.SECURITY_CATALOG__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case SecurityPackage.SECURITY_CATALOG__PERMISSIONS:
				return ((InternalEList<?>)getPermissions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityPackage.SECURITY_CATALOG__ROLES:
				return getRoles();
			case SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES:
				return getInstanceRoles();
			case SecurityPackage.SECURITY_CATALOG__DOMAINS:
				return getDomains();
			case SecurityPackage.SECURITY_CATALOG__ACTIONS:
				return getActions();
			case SecurityPackage.SECURITY_CATALOG__PERMISSIONS:
				return getPermissions();
			case SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS:
				if (resolve) return getDomainPermissions();
				return basicGetDomainPermissions();
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
			case SecurityPackage.SECURITY_CATALOG__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES:
				getInstanceRoles().clear();
				getInstanceRoles().addAll((Collection<? extends DomainRole>)newValue);
				return;
			case SecurityPackage.SECURITY_CATALOG__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends Domain>)newValue);
				return;
			case SecurityPackage.SECURITY_CATALOG__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case SecurityPackage.SECURITY_CATALOG__PERMISSIONS:
				getPermissions().clear();
				getPermissions().addAll((Collection<? extends Permission>)newValue);
				return;
			case SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS:
				setDomainPermissions((DomainPermission)newValue);
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
			case SecurityPackage.SECURITY_CATALOG__ROLES:
				getRoles().clear();
				return;
			case SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES:
				getInstanceRoles().clear();
				return;
			case SecurityPackage.SECURITY_CATALOG__DOMAINS:
				getDomains().clear();
				return;
			case SecurityPackage.SECURITY_CATALOG__ACTIONS:
				getActions().clear();
				return;
			case SecurityPackage.SECURITY_CATALOG__PERMISSIONS:
				getPermissions().clear();
				return;
			case SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS:
				setDomainPermissions((DomainPermission)null);
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
			case SecurityPackage.SECURITY_CATALOG__ROLES:
				return roles != null && !roles.isEmpty();
			case SecurityPackage.SECURITY_CATALOG__INSTANCE_ROLES:
				return instanceRoles != null && !instanceRoles.isEmpty();
			case SecurityPackage.SECURITY_CATALOG__DOMAINS:
				return domains != null && !domains.isEmpty();
			case SecurityPackage.SECURITY_CATALOG__ACTIONS:
				return actions != null && !actions.isEmpty();
			case SecurityPackage.SECURITY_CATALOG__PERMISSIONS:
				return permissions != null && !permissions.isEmpty();
			case SecurityPackage.SECURITY_CATALOG__DOMAIN_PERMISSIONS:
				return domainPermissions != null;
		}
		return super.eIsSet(featureID);
	}

} //SecurityCatalogImpl
