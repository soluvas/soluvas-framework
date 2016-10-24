package org.soluvas.security.impl;

import java.io.Serializable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.joda.time.DateTime;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.mongo.BigDecimalConverter;
import org.soluvas.commons.mongo.CurrencyUnitConverter;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.UnitConverter;
import org.soluvas.security.AssignMode;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityPackage;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getModificationTime <em>Modification Time</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getAssignMode <em>Assign Mode</em>}</li>
 *   <li>{@link org.soluvas.security.impl.RoleImpl#getSchemaVersion <em>Schema Version</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity(noClassnameStored=true)
@Converters({BigDecimalConverter.class, DateTimeConverter.class,
	CurrencyUnitConverter.class, UnitConverter.class})
public class RoleImpl extends EObjectImpl implements Role {

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
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	@Id
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssignMode() <em>Assign Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignMode()
	 * @generated
	 * @ordered
	 */
	protected static final AssignMode ASSIGN_MODE_EDEFAULT = AssignMode.MANUAL;

	/**
	 * The cached value of the '{@link #getAssignMode() <em>Assign Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignMode()
	 * @generated
	 * @ordered
	 */
	protected AssignMode assignMode = ASSIGN_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 1L;
	
	private static final long serialVersionUID = SCHEMA_VERSION_EDEFAULT;
	public static final long CURRENT_SCHEMA_VERSION = SCHEMA_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected long schemaVersion = SCHEMA_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.ROLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationTime(DateTime newCreationTime) {
		DateTime oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModificationTime(DateTime newModificationTime) {
		DateTime oldModificationTime = modificationTime;
		modificationTime = newModificationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__MODIFICATION_TIME, oldModificationTime, modificationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssignMode getAssignMode() {
		return assignMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssignMode(AssignMode newAssignMode) {
		AssignMode oldAssignMode = assignMode;
		assignMode = newAssignMode == null ? ASSIGN_MODE_EDEFAULT : newAssignMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SecurityPackage.ROLE__ASSIGN_MODE, oldAssignMode, assignMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SecurityPackage.ROLE__RESOURCE_TYPE:
				return getResourceType();
			case SecurityPackage.ROLE__RESOURCE_URI:
				return getResourceUri();
			case SecurityPackage.ROLE__RESOURCE_NAME:
				return getResourceName();
			case SecurityPackage.ROLE__DESCRIPTION:
				return getDescription();
			case SecurityPackage.ROLE__ID:
				return getId();
			case SecurityPackage.ROLE__CREATION_TIME:
				return getCreationTime();
			case SecurityPackage.ROLE__MODIFICATION_TIME:
				return getModificationTime();
			case SecurityPackage.ROLE__NAME:
				return getName();
			case SecurityPackage.ROLE__ASSIGN_MODE:
				return getAssignMode();
			case SecurityPackage.ROLE__SCHEMA_VERSION:
				return getSchemaVersion();
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
			case SecurityPackage.ROLE__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case SecurityPackage.ROLE__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case SecurityPackage.ROLE__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case SecurityPackage.ROLE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SecurityPackage.ROLE__ID:
				setId((String)newValue);
				return;
			case SecurityPackage.ROLE__CREATION_TIME:
				setCreationTime((DateTime)newValue);
				return;
			case SecurityPackage.ROLE__MODIFICATION_TIME:
				setModificationTime((DateTime)newValue);
				return;
			case SecurityPackage.ROLE__NAME:
				setName((String)newValue);
				return;
			case SecurityPackage.ROLE__ASSIGN_MODE:
				setAssignMode((AssignMode)newValue);
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
			case SecurityPackage.ROLE__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case SecurityPackage.ROLE__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case SecurityPackage.ROLE__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case SecurityPackage.ROLE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SecurityPackage.ROLE__ID:
				setId(ID_EDEFAULT);
				return;
			case SecurityPackage.ROLE__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case SecurityPackage.ROLE__MODIFICATION_TIME:
				setModificationTime(MODIFICATION_TIME_EDEFAULT);
				return;
			case SecurityPackage.ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SecurityPackage.ROLE__ASSIGN_MODE:
				setAssignMode(ASSIGN_MODE_EDEFAULT);
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
			case SecurityPackage.ROLE__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case SecurityPackage.ROLE__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case SecurityPackage.ROLE__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case SecurityPackage.ROLE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SecurityPackage.ROLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SecurityPackage.ROLE__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case SecurityPackage.ROLE__MODIFICATION_TIME:
				return MODIFICATION_TIME_EDEFAULT == null ? modificationTime != null : !MODIFICATION_TIME_EDEFAULT.equals(modificationTime);
			case SecurityPackage.ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SecurityPackage.ROLE__ASSIGN_MODE:
				return assignMode != ASSIGN_MODE_EDEFAULT;
			case SecurityPackage.ROLE__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
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
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.ROLE__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.ROLE__ID: return CommonsPackage.IDENTIFIABLE__ID;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.ROLE__CREATION_TIME: return CommonsPackage.TIMESTAMPED__CREATION_TIME;
				case SecurityPackage.ROLE__MODIFICATION_TIME: return CommonsPackage.TIMESTAMPED__MODIFICATION_TIME;
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
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return SecurityPackage.ROLE__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.IDENTIFIABLE__ID: return SecurityPackage.ROLE__ID;
				default: return -1;
			}
		}
		if (baseClass == Timestamped.class) {
			switch (baseFeatureID) {
				case CommonsPackage.TIMESTAMPED__CREATION_TIME: return SecurityPackage.ROLE__CREATION_TIME;
				case CommonsPackage.TIMESTAMPED__MODIFICATION_TIME: return SecurityPackage.ROLE__MODIFICATION_TIME;
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", modificationTime: ");
		result.append(modificationTime);
		result.append(", name: ");
		result.append(name);
		result.append(", assignMode: ");
		result.append(assignMode);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(')');
		return result.toString();
	}

} //RoleImpl
