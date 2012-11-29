/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>App Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getBrandingBundleName <em>Branding Bundle Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.AppManifestImpl#getFaviconPath <em>Favicon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppManifestImpl extends EObjectImpl implements AppManifest {
	/**
	 * The default value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected static final Integer POSITIONER_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getPositioner() <em>Positioner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositioner()
	 * @generated
	 * @ordered
	 */
	protected Integer positioner = POSITIONER_EDEFAULT;

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
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

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
	 * The default value of the '{@link #getBrandingBundleName() <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandingBundleName()
	 * @generated
	 * @ordered
	 */
	protected static final String BRANDING_BUNDLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrandingBundleName() <em>Branding Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandingBundleName()
	 * @generated
	 * @ordered
	 */
	protected String brandingBundleName = BRANDING_BUNDLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaviconPath() <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FAVICON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaviconPath() <em>Favicon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaviconPath()
	 * @generated
	 * @ordered
	 */
	protected String faviconPath = FAVICON_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.APP_MANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__POSITIONER, oldPositioner, positioner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrandingBundleName() {
		return brandingBundleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrandingBundleName(String newBrandingBundleName) {
		String oldBrandingBundleName = brandingBundleName;
		brandingBundleName = newBrandingBundleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__BRANDING_BUNDLE_NAME, oldBrandingBundleName, brandingBundleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaviconPath() {
		return faviconPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaviconPath(String newFaviconPath) {
		String oldFaviconPath = faviconPath;
		faviconPath = newFaviconPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.APP_MANIFEST__FAVICON_PATH, oldFaviconPath, faviconPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				return getPositioner();
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				return getResourceType();
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				return getResourceUri();
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				return getResourceName();
			case CommonsPackage.APP_MANIFEST__TITLE:
				return getTitle();
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				return getDescription();
			case CommonsPackage.APP_MANIFEST__BRANDING_BUNDLE_NAME:
				return getBrandingBundleName();
			case CommonsPackage.APP_MANIFEST__FAVICON_PATH:
				return getFaviconPath();
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__TITLE:
				setTitle((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__BRANDING_BUNDLE_NAME:
				setBrandingBundleName((String)newValue);
				return;
			case CommonsPackage.APP_MANIFEST__FAVICON_PATH:
				setFaviconPath((String)newValue);
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__BRANDING_BUNDLE_NAME:
				setBrandingBundleName(BRANDING_BUNDLE_NAME_EDEFAULT);
				return;
			case CommonsPackage.APP_MANIFEST__FAVICON_PATH:
				setFaviconPath(FAVICON_PATH_EDEFAULT);
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
			case CommonsPackage.APP_MANIFEST__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case CommonsPackage.APP_MANIFEST__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CommonsPackage.APP_MANIFEST__BRANDING_BUNDLE_NAME:
				return BRANDING_BUNDLE_NAME_EDEFAULT == null ? brandingBundleName != null : !BRANDING_BUNDLE_NAME_EDEFAULT.equals(brandingBundleName);
			case CommonsPackage.APP_MANIFEST__FAVICON_PATH:
				return FAVICON_PATH_EDEFAULT == null ? faviconPath != null : !FAVICON_PATH_EDEFAULT.equals(faviconPath);
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
				case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case CommonsPackage.APP_MANIFEST__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case CommonsPackage.APP_MANIFEST__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
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
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return CommonsPackage.APP_MANIFEST__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return CommonsPackage.APP_MANIFEST__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return CommonsPackage.APP_MANIFEST__RESOURCE_NAME;
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
		result.append(" (positioner: ");
		result.append(positioner);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", title: ");
		result.append(title);
		result.append(", description: ");
		result.append(description);
		result.append(", brandingBundleName: ");
		result.append(brandingBundleName);
		result.append(", faviconPath: ");
		result.append(faviconPath);
		result.append(')');
		return result.toString();
	}

} //AppManifestImpl
