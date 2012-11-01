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
import org.soluvas.commons.ResourceType;
import org.soluvas.security.Permission;
import org.soluvas.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getDomainPermission <em>Domain Permission</em>}</li>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getActionPermission <em>Action Permission</em>}</li>
 *   <li>{@link org.soluvas.security.impl.PermissionImpl#getInstancePermission <em>Instance Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionImpl extends EObjectImpl implements Permission {
	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceType RESOURCE_TYPE_EDEFAULT = ResourceType.BUNDLE;

	/**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType = RESOURCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> roles;

	/**
	 * The cached value of the '{@link #getDomainPermission() <em>Domain Permission</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainPermission()
	 * @generated
	 * @ordered
	 */
	protected EList<String> domainPermission;

	/**
	 * The cached value of the '{@link #getActionPermission() <em>Action Permission</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionPermission()
	 * @generated
	 * @ordered
	 */
	protected EList<String> actionPermission;

	/**
	 * The cached value of the '{@link #getInstancePermission() <em>Instance Permission</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstancePermission()
	 * @generated
	 * @ordered
	 */
	protected EList<String> instancePermission;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.PERMISSION__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.PERMISSION__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.PERMISSION__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getDomainPermission() {
		if (domainPermission == null) {
			domainPermission = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.PERMISSION__DOMAIN_PERMISSION);
		}
		return domainPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getActionPermission() {
		if (actionPermission == null) {
			actionPermission = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.PERMISSION__ACTION_PERMISSION);
		}
		return actionPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getInstancePermission() {
		if (instancePermission == null) {
			instancePermission = new EDataTypeUniqueEList<String>(String.class, this, SecurityPackage.PERMISSION__INSTANCE_PERMISSION);
		}
		return instancePermission;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> Uses
	 * {@link ToStringPermission} to do its work.
	 */
	@Override
	public String toStringPermission() {
		return new ToStringPermission().apply(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityPackage.PERMISSION__RESOURCE_URI:
				return getResourceUri();
			case SecurityPackage.PERMISSION__RESOURCE_TYPE:
				return getResourceType();
			case SecurityPackage.PERMISSION__ROLES:
				return getRoles();
			case SecurityPackage.PERMISSION__DOMAIN_PERMISSION:
				return getDomainPermission();
			case SecurityPackage.PERMISSION__ACTION_PERMISSION:
				return getActionPermission();
			case SecurityPackage.PERMISSION__INSTANCE_PERMISSION:
				return getInstancePermission();
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
			case SecurityPackage.PERMISSION__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case SecurityPackage.PERMISSION__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case SecurityPackage.PERMISSION__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.PERMISSION__DOMAIN_PERMISSION:
				getDomainPermission().clear();
				getDomainPermission().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.PERMISSION__ACTION_PERMISSION:
				getActionPermission().clear();
				getActionPermission().addAll((Collection<? extends String>)newValue);
				return;
			case SecurityPackage.PERMISSION__INSTANCE_PERMISSION:
				getInstancePermission().clear();
				getInstancePermission().addAll((Collection<? extends String>)newValue);
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
			case SecurityPackage.PERMISSION__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case SecurityPackage.PERMISSION__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case SecurityPackage.PERMISSION__ROLES:
				getRoles().clear();
				return;
			case SecurityPackage.PERMISSION__DOMAIN_PERMISSION:
				getDomainPermission().clear();
				return;
			case SecurityPackage.PERMISSION__ACTION_PERMISSION:
				getActionPermission().clear();
				return;
			case SecurityPackage.PERMISSION__INSTANCE_PERMISSION:
				getInstancePermission().clear();
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
			case SecurityPackage.PERMISSION__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case SecurityPackage.PERMISSION__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case SecurityPackage.PERMISSION__ROLES:
				return roles != null && !roles.isEmpty();
			case SecurityPackage.PERMISSION__DOMAIN_PERMISSION:
				return domainPermission != null && !domainPermission.isEmpty();
			case SecurityPackage.PERMISSION__ACTION_PERMISSION:
				return actionPermission != null && !actionPermission.isEmpty();
			case SecurityPackage.PERMISSION__INSTANCE_PERMISSION:
				return instancePermission != null && !instancePermission.isEmpty();
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
		result.append(" (resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", roles: ");
		result.append(roles);
		result.append(", domainPermission: ");
		result.append(domainPermission);
		result.append(", actionPermission: ");
		result.append(actionPermission);
		result.append(", instancePermission: ");
		result.append(instancePermission);
		result.append(')');
		return result.toString();
	}

} //PermissionImpl
