/**
 */
package org.soluvas.data.impl;

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

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;

import org.soluvas.data.AttributeType;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Mixin;
import org.soluvas.data.Term;
import org.soluvas.data.Vocab;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getVocabs <em>Vocabs</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getMixins <em>Mixins</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.soluvas.data.impl.DataCatalogImpl#getAttributeTypes <em>Attribute Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataCatalogImpl extends EObjectImpl implements DataCatalog {
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
	 * The cached value of the '{@link #getVocabs() <em>Vocabs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVocabs()
	 * @generated
	 * @ordered
	 */
	protected EList<Vocab> vocabs;

	/**
	 * The cached value of the '{@link #getMixins() <em>Mixins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixins()
	 * @generated
	 * @ordered
	 */
	protected EList<Mixin> mixins;

	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<Term> terms;

	/**
	 * The cached value of the '{@link #getAttributeTypes() <em>Attribute Types</em>}' containment reference list.
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
	public DataCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.DATA_CATALOG;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_CATALOG__BUNDLE, oldBundle, bundle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_CATALOG__RESOURCE_TYPE, oldResourceType, resourceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_CATALOG__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_CATALOG__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_CATALOG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vocab> getVocabs() {
		if (vocabs == null) {
			vocabs = new EObjectContainmentEList<Vocab>(Vocab.class, this, DataPackage.DATA_CATALOG__VOCABS);
		}
		return vocabs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mixin> getMixins() {
		if (mixins == null) {
			mixins = new EObjectContainmentEList<Mixin>(Mixin.class, this, DataPackage.DATA_CATALOG__MIXINS);
		}
		return mixins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Term> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList<Term>(Term.class, this, DataPackage.DATA_CATALOG__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttributeTypes() {
		if (attributeTypes == null) {
			attributeTypes = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES);
		}
		return attributeTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.DATA_CATALOG__VOCABS:
				return ((InternalEList<?>)getVocabs()).basicRemove(otherEnd, msgs);
			case DataPackage.DATA_CATALOG__MIXINS:
				return ((InternalEList<?>)getMixins()).basicRemove(otherEnd, msgs);
			case DataPackage.DATA_CATALOG__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
			case DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES:
				return ((InternalEList<?>)getAttributeTypes()).basicRemove(otherEnd, msgs);
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
			case DataPackage.DATA_CATALOG__BUNDLE:
				return getBundle();
			case DataPackage.DATA_CATALOG__RESOURCE_TYPE:
				return getResourceType();
			case DataPackage.DATA_CATALOG__RESOURCE_URI:
				return getResourceUri();
			case DataPackage.DATA_CATALOG__RESOURCE_NAME:
				return getResourceName();
			case DataPackage.DATA_CATALOG__NAME:
				return getName();
			case DataPackage.DATA_CATALOG__VOCABS:
				return getVocabs();
			case DataPackage.DATA_CATALOG__MIXINS:
				return getMixins();
			case DataPackage.DATA_CATALOG__TERMS:
				return getTerms();
			case DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES:
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
			case DataPackage.DATA_CATALOG__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case DataPackage.DATA_CATALOG__NAME:
				setName((String)newValue);
				return;
			case DataPackage.DATA_CATALOG__VOCABS:
				getVocabs().clear();
				getVocabs().addAll((Collection<? extends Vocab>)newValue);
				return;
			case DataPackage.DATA_CATALOG__MIXINS:
				getMixins().clear();
				getMixins().addAll((Collection<? extends Mixin>)newValue);
				return;
			case DataPackage.DATA_CATALOG__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends Term>)newValue);
				return;
			case DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES:
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
			case DataPackage.DATA_CATALOG__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case DataPackage.DATA_CATALOG__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case DataPackage.DATA_CATALOG__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.DATA_CATALOG__VOCABS:
				getVocabs().clear();
				return;
			case DataPackage.DATA_CATALOG__MIXINS:
				getMixins().clear();
				return;
			case DataPackage.DATA_CATALOG__TERMS:
				getTerms().clear();
				return;
			case DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES:
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
			case DataPackage.DATA_CATALOG__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case DataPackage.DATA_CATALOG__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case DataPackage.DATA_CATALOG__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case DataPackage.DATA_CATALOG__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case DataPackage.DATA_CATALOG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.DATA_CATALOG__VOCABS:
				return vocabs != null && !vocabs.isEmpty();
			case DataPackage.DATA_CATALOG__MIXINS:
				return mixins != null && !mixins.isEmpty();
			case DataPackage.DATA_CATALOG__TERMS:
				return terms != null && !terms.isEmpty();
			case DataPackage.DATA_CATALOG__ATTRIBUTE_TYPES:
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
				case DataPackage.DATA_CATALOG__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case DataPackage.DATA_CATALOG__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case DataPackage.DATA_CATALOG__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (derivedFeatureID) {
				case DataPackage.DATA_CATALOG__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
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
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return DataPackage.DATA_CATALOG__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return DataPackage.DATA_CATALOG__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return DataPackage.DATA_CATALOG__RESOURCE_NAME;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NameContainer.class) {
			switch (baseFeatureID) {
				case CommonsPackage.NAME_CONTAINER__NAME: return DataPackage.DATA_CATALOG__NAME;
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
		result.append(" (bundle: ");
		result.append(bundle);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DataCatalogImpl
