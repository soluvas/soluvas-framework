/**
 */
package org.soluvas.social.schema.impl;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceType;
import org.soluvas.social.SocialException;
import org.soluvas.social.Target;
import org.soluvas.social.schema.SchemaPackage;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getGeneratedPackageName <em>Generated Package Name</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getXmiUrl <em>Xmi Url</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getEcoreUrl <em>Ecore Url</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.soluvas.social.schema.impl.SocialSchemaCatalogImpl#getEFactory <em>EFactory</em>}</li>
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
	 * The default value of the '{@link #getGeneratedPackageName() <em>Generated Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATED_PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratedPackageName() <em>Generated Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedPackageName()
	 * @generated
	 * @ordered
	 */
	protected String generatedPackageName = GENERATED_PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getXmiUrl() <em>Xmi Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiUrl()
	 * @generated
	 * @ordered
	 */
	protected static final URL XMI_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiUrl() <em>Xmi Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiUrl()
	 * @generated
	 * @ordered
	 */
	protected URL xmiUrl = XMI_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEcoreUrl() <em>Ecore Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreUrl()
	 * @generated
	 * @ordered
	 */
	protected static final URL ECORE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEcoreUrl() <em>Ecore Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreUrl()
	 * @generated
	 * @ordered
	 */
	protected URL ecoreUrl = ECORE_URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEPackage() <em>EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage ePackage;

	/**
	 * The cached value of the '{@link #getEFactory() <em>EFactory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactory()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactory;

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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_TYPE, oldResourceType, resourceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public String getGeneratedPackageName() {
		return generatedPackageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeneratedPackageName(String newGeneratedPackageName) {
		String oldGeneratedPackageName = generatedPackageName;
		generatedPackageName = newGeneratedPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME, oldGeneratedPackageName, generatedPackageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URL getXmiUrl() {
		return xmiUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXmiUrl(URL newXmiUrl) {
		URL oldXmiUrl = xmiUrl;
		xmiUrl = newXmiUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__XMI_URL, oldXmiUrl, xmiUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URL getEcoreUrl() {
		return ecoreUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEcoreUrl(URL newEcoreUrl) {
		URL oldEcoreUrl = ecoreUrl;
		ecoreUrl = newEcoreUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__ECORE_URL, oldEcoreUrl, ecoreUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPackage getEPackage() {
		if (ePackage != null && ePackage.eIsProxy()) {
			InternalEObject oldEPackage = (InternalEObject)ePackage;
			ePackage = (EPackage)eResolveProxy(oldEPackage);
			if (ePackage != oldEPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE, oldEPackage, ePackage));
			}
		}
		return ePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetEPackage() {
		return ePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackage(EPackage newEPackage) {
		EPackage oldEPackage = ePackage;
		ePackage = newEPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE, oldEPackage, ePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFactory getEFactory() {
		if (eFactory != null && eFactory.eIsProxy()) {
			InternalEObject oldEFactory = (InternalEObject)eFactory;
			eFactory = (EFactory)eResolveProxy(oldEFactory);
			if (eFactory != oldEFactory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY, oldEFactory, eFactory));
			}
		}
		return eFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory basicGetEFactory() {
		return eFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEFactory(EFactory newEFactory) {
		EFactory oldEFactory = eFactory;
		eFactory = newEFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY, oldEFactory, eFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public <T extends Target> T createTarget(final Class<T> targetClass) {
		try {
			final TargetType targetType = Iterables.find(getTargetTypes(),
					new Predicate<TargetType>() {
				@Override
				public boolean apply(@Nullable final TargetType input) {
					return targetClass.equals( input.getJavaClass() );
				}
			});
			return (T) targetType.create();
		} catch (final NoSuchElementException e) {
			final Function<TargetType, String> targetTypeQName = new Function<TargetType, String>() {
				@Override @Nullable
				public String apply(@Nullable TargetType input) {
					return input.getJavaClass().getName();
				}
			};
			final List<String> supportedTargetTypeQNames = Lists.transform(getTargetTypes(), targetTypeQName);
			throw new SocialException(String.format("Cannot find target type %s, %s supported types are: %s",
					targetClass.getName(), supportedTargetTypeQNames.size(), supportedTargetTypeQNames), e);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME:
				return getGeneratedPackageName();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__XMI_URL:
				return getXmiUrl();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__ECORE_URL:
				return getEcoreUrl();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE:
				if (resolve) return getEPackage();
				return basicGetEPackage();
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY:
				if (resolve) return getEFactory();
				return basicGetEFactory();
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME:
				setGeneratedPackageName((String)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__XMI_URL:
				setXmiUrl((URL)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__ECORE_URL:
				setEcoreUrl((URL)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE:
				setEPackage((EPackage)newValue);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY:
				setEFactory((EFactory)newValue);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME:
				setGeneratedPackageName(GENERATED_PACKAGE_NAME_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__XMI_URL:
				setXmiUrl(XMI_URL_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__ECORE_URL:
				setEcoreUrl(ECORE_URL_EDEFAULT);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE:
				setEPackage((EPackage)null);
				return;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY:
				setEFactory((EFactory)null);
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
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__GENERATED_PACKAGE_NAME:
				return GENERATED_PACKAGE_NAME_EDEFAULT == null ? generatedPackageName != null : !GENERATED_PACKAGE_NAME_EDEFAULT.equals(generatedPackageName);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__XMI_URL:
				return XMI_URL_EDEFAULT == null ? xmiUrl != null : !XMI_URL_EDEFAULT.equals(xmiUrl);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__ECORE_URL:
				return ECORE_URL_EDEFAULT == null ? ecoreUrl != null : !ECORE_URL_EDEFAULT.equals(ecoreUrl);
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EPACKAGE:
				return ePackage != null;
			case SchemaPackage.SOCIAL_SCHEMA_CATALOG__EFACTORY:
				return eFactory != null;
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
		result.append(", generatedPackageName: ");
		result.append(generatedPackageName);
		result.append(", xmiUrl: ");
		result.append(xmiUrl);
		result.append(", ecoreUrl: ");
		result.append(ecoreUrl);
		result.append(')');
		return result.toString();
	}

} //SocialSchemaCatalogImpl
