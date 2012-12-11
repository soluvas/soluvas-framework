/**
 */
package org.soluvas.social.schema.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osgi.framework.Bundle;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceType;

import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Social Schema Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getTargetTypes <em>Target Types</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SocialSchemaCatalogImpl extends EObjectImpl implements SocialSchemaCatalog {
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
	 * The cached value of the '{@link #getTargetTypes() <em>Target Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetType> targetTypes;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocialSchemaCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchemaPackage.Literals.SOCIAL_SCHEMA_CATALOG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE, oldResourceType, resourceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetType> getTargetTypes() {
		if (targetTypes == null) {
			targetTypes = new EObjectContainmentEList<TargetType>(TargetType.class, this, SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES);
		}
		return targetTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES:
				return ((InternalEList<?>)getTargetTypes()).basicRemove(otherEnd, msgs);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE:
				return getResourceType();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI:
				return getResourceUri();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME:
				return getResourceName();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE:
				return getBundle();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES:
				return getTargetTypes();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__NS_PREFIX:
				return getNsPrefix();
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES:
				getTargetTypes().clear();
				getTargetTypes().addAll((Collection<? extends TargetType>)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__NS_PREFIX:
				setNsPrefix((String)newValue);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES:
				getTargetTypes().clear();
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__TARGET_TYPES:
				return targetTypes != null && !targetTypes.isEmpty();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
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
		if (baseClass == BundleAware.class) {
			switch (derivedFeatureID) {
				case SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
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
		if (baseClass == BundleAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return SchemaPackage.SOCIAL_SCHEMA_CATALOG__BUNDLE;
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
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(')');
		return result.toString();
	}

} //SocialSchemaCatalogImpl
