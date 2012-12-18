/**
 */
package org.soluvas.data.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osgi.framework.Bundle;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;

import org.soluvas.data.AttributeType;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Mixin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinImpl#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixinImpl extends EObjectImpl implements Mixin {
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
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected static final Bundle BUNDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundle() <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundle()
	 * @generated
	 * @ordered
	 */
	protected Bundle bundle = BUNDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

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
	 * The cached value of the '{@link #getAttributeTypes() <em>Attribute Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeType> attributeTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MixinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.MIXIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType(ResourceType newResourceType) {
		ResourceType oldResourceType = resourceType;
		resourceType = newResourceType == null ? RESOURCE_TYPE_EDEFAULT : newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundle(Bundle newBundle) {
		Bundle oldBundle = bundle;
		bundle = newBundle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MIXIN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttributeTypes() {
		if (attributeTypes == null) {
			attributeTypes = new EObjectResolvingEList<AttributeType>(AttributeType.class, this, DataPackage.MIXIN__ATTRIBUTE_TYPES);
		}
		return attributeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.MIXIN__NAME:
				return getName();
			case DataPackage.MIXIN__RESOURCE_TYPE:
				return getResourceType();
			case DataPackage.MIXIN__RESOURCE_URI:
				return getResourceUri();
			case DataPackage.MIXIN__RESOURCE_NAME:
				return getResourceName();
			case DataPackage.MIXIN__BUNDLE:
				return getBundle();
			case DataPackage.MIXIN__NS_PREFIX:
				return getNsPrefix();
			case DataPackage.MIXIN__DESCRIPTION:
				return getDescription();
			case DataPackage.MIXIN__ATTRIBUTE_TYPES:
				return getAttributeTypes();
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
			case DataPackage.MIXIN__NAME:
				setName((String)newValue);
				return;
			case DataPackage.MIXIN__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case DataPackage.MIXIN__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case DataPackage.MIXIN__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case DataPackage.MIXIN__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case DataPackage.MIXIN__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case DataPackage.MIXIN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DataPackage.MIXIN__ATTRIBUTE_TYPES:
				getAttributeTypes().clear();
				getAttributeTypes().addAll((Collection<? extends AttributeType>)newValue);
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
			case DataPackage.MIXIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.MIXIN__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case DataPackage.MIXIN__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case DataPackage.MIXIN__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case DataPackage.MIXIN__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case DataPackage.MIXIN__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case DataPackage.MIXIN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DataPackage.MIXIN__ATTRIBUTE_TYPES:
				getAttributeTypes().clear();
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
			case DataPackage.MIXIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.MIXIN__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case DataPackage.MIXIN__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case DataPackage.MIXIN__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case DataPackage.MIXIN__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case DataPackage.MIXIN__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case DataPackage.MIXIN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DataPackage.MIXIN__ATTRIBUTE_TYPES:
				return attributeTypes != null && !attributeTypes.isEmpty();
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
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case DataPackage.MIXIN__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case DataPackage.MIXIN__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case DataPackage.MIXIN__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case DataPackage.MIXIN__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (derivedFeatureID) {
				case DataPackage.MIXIN__NS_PREFIX: return CommonsPackage.NS_PREFIXABLE__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (derivedFeatureID) {
				case DataPackage.MIXIN__DESCRIPTION: return CommonsPackage.DESCRIBABLE__DESCRIPTION;
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
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return DataPackage.MIXIN__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return DataPackage.MIXIN__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return DataPackage.MIXIN__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return DataPackage.MIXIN__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == NsPrefixable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NS_PREFIXABLE__NS_PREFIX: return DataPackage.MIXIN__NS_PREFIX;
				default: return -1;
			}
		}
		if (baseClass == Describable.class) {
			switch (baseFeatureID) {
				case CommonsPackage.DESCRIBABLE__DESCRIPTION: return DataPackage.MIXIN__DESCRIPTION;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //MixinImpl
