/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.osgi.framework.Bundle;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.WebAddress;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getPositioner <em>Positioner</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getBaseUri <em>Base Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getBasePath <em>Base Path</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getApiPath <em>Api Path</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getImagesUri <em>Images Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getSkinUri <em>Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getJsUri <em>Js Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getSecureBaseUri <em>Secure Base Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getSecureImagesUri <em>Secure Images Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getSecureSkinUri <em>Secure Skin Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.WebAddressImpl#getSecureJsUri <em>Secure Js Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebAddressImpl extends EObjectImpl implements WebAddress {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * The default value of the '{@link #getBaseUri() <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUri()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseUri() <em>Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseUri()
	 * @generated
	 * @ordered
	 */
	protected String baseUri = BASE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getBasePath() <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePath()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasePath() <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasePath()
	 * @generated
	 * @ordered
	 */
	protected String basePath = BASE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getApiPath() <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiPath()
	 * @generated
	 * @ordered
	 */
	protected static final String API_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApiPath() <em>Api Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiPath()
	 * @generated
	 * @ordered
	 */
	protected String apiPath = API_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getImagesUri() <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagesUri()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGES_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImagesUri() <em>Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagesUri()
	 * @generated
	 * @ordered
	 */
	protected String imagesUri = IMAGES_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkinUri() <em>Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SKIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSkinUri() <em>Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkinUri()
	 * @generated
	 * @ordered
	 */
	protected String skinUri = SKIN_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getJsUri() <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsUri()
	 * @generated
	 * @ordered
	 */
	protected static final String JS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJsUri() <em>Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsUri()
	 * @generated
	 * @ordered
	 */
	protected String jsUri = JS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureBaseUri() <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureBaseUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_BASE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureBaseUri() <em>Secure Base Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureBaseUri()
	 * @generated
	 * @ordered
	 */
	protected String secureBaseUri = SECURE_BASE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureImagesUri() <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureImagesUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_IMAGES_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureImagesUri() <em>Secure Images Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureImagesUri()
	 * @generated
	 * @ordered
	 */
	protected String secureImagesUri = SECURE_IMAGES_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureSkinUri() <em>Secure Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureSkinUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_SKIN_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureSkinUri() <em>Secure Skin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureSkinUri()
	 * @generated
	 * @ordered
	 */
	protected String secureSkinUri = SECURE_SKIN_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecureJsUri() <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureJsUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SECURE_JS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecureJsUri() <em>Secure Js Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecureJsUri()
	 * @generated
	 * @ordered
	 */
	protected String secureJsUri = SECURE_JS_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.WEB_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getPositioner() {
		return positioner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPositioner(Integer newPositioner) {
		Integer oldPositioner = positioner;
		positioner = newPositioner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__POSITIONER, oldPositioner, positioner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__BUNDLE, oldBundle, bundle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE, oldResourceType, resourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@JsonIgnore
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBaseUri() {
		return baseUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseUri(String newBaseUri) {
		String oldBaseUri = baseUri;
		baseUri = newBaseUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__BASE_URI, oldBaseUri, baseUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBasePath() {
		return basePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBasePath(String newBasePath) {
		String oldBasePath = basePath;
		basePath = newBasePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__BASE_PATH, oldBasePath, basePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiPath(String newApiPath) {
		String oldApiPath = apiPath;
		apiPath = newApiPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__API_PATH, oldApiPath, apiPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImagesUri() {
		return imagesUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImagesUri(String newImagesUri) {
		String oldImagesUri = imagesUri;
		imagesUri = newImagesUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__IMAGES_URI, oldImagesUri, imagesUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSkinUri() {
		return skinUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSkinUri(String newSkinUri) {
		String oldSkinUri = skinUri;
		skinUri = newSkinUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__SKIN_URI, oldSkinUri, skinUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJsUri() {
		return jsUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJsUri(String newJsUri) {
		String oldJsUri = jsUri;
		jsUri = newJsUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__JS_URI, oldJsUri, jsUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecureBaseUri() {
		return secureBaseUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecureBaseUri(String newSecureBaseUri) {
		String oldSecureBaseUri = secureBaseUri;
		secureBaseUri = newSecureBaseUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI, oldSecureBaseUri, secureBaseUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecureImagesUri() {
		return secureImagesUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecureImagesUri(String newSecureImagesUri) {
		String oldSecureImagesUri = secureImagesUri;
		secureImagesUri = newSecureImagesUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI, oldSecureImagesUri, secureImagesUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecureSkinUri() {
		return secureSkinUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecureSkinUri(String newSecureSkinUri) {
		String oldSecureSkinUri = secureSkinUri;
		secureSkinUri = newSecureSkinUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI, oldSecureSkinUri, secureSkinUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecureJsUri() {
		return secureJsUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecureJsUri(String newSecureJsUri) {
		String oldSecureJsUri = secureJsUri;
		secureJsUri = newSecureJsUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.WEB_ADDRESS__SECURE_JS_URI, oldSecureJsUri, secureJsUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.WEB_ADDRESS__POSITIONER:
				return getPositioner();
			case CommonsPackage.WEB_ADDRESS__BUNDLE:
				return getBundle();
			case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE:
				return getResourceType();
			case CommonsPackage.WEB_ADDRESS__RESOURCE_URI:
				return getResourceUri();
			case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME:
				return getResourceName();
			case CommonsPackage.WEB_ADDRESS__BASE_URI:
				return getBaseUri();
			case CommonsPackage.WEB_ADDRESS__BASE_PATH:
				return getBasePath();
			case CommonsPackage.WEB_ADDRESS__API_PATH:
				return getApiPath();
			case CommonsPackage.WEB_ADDRESS__IMAGES_URI:
				return getImagesUri();
			case CommonsPackage.WEB_ADDRESS__SKIN_URI:
				return getSkinUri();
			case CommonsPackage.WEB_ADDRESS__JS_URI:
				return getJsUri();
			case CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI:
				return getSecureBaseUri();
			case CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				return getSecureImagesUri();
			case CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				return getSecureSkinUri();
			case CommonsPackage.WEB_ADDRESS__SECURE_JS_URI:
				return getSecureJsUri();
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
			case CommonsPackage.WEB_ADDRESS__POSITIONER:
				setPositioner((Integer)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__BASE_URI:
				setBaseUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__BASE_PATH:
				setBasePath((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__API_PATH:
				setApiPath((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__IMAGES_URI:
				setImagesUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__SKIN_URI:
				setSkinUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__JS_URI:
				setJsUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI:
				setSecureBaseUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				setSecureImagesUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				setSecureSkinUri((String)newValue);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_JS_URI:
				setSecureJsUri((String)newValue);
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
			case CommonsPackage.WEB_ADDRESS__POSITIONER:
				setPositioner(POSITIONER_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__BASE_URI:
				setBaseUri(BASE_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__BASE_PATH:
				setBasePath(BASE_PATH_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__API_PATH:
				setApiPath(API_PATH_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__IMAGES_URI:
				setImagesUri(IMAGES_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__SKIN_URI:
				setSkinUri(SKIN_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__JS_URI:
				setJsUri(JS_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI:
				setSecureBaseUri(SECURE_BASE_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				setSecureImagesUri(SECURE_IMAGES_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				setSecureSkinUri(SECURE_SKIN_URI_EDEFAULT);
				return;
			case CommonsPackage.WEB_ADDRESS__SECURE_JS_URI:
				setSecureJsUri(SECURE_JS_URI_EDEFAULT);
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
			case CommonsPackage.WEB_ADDRESS__POSITIONER:
				return POSITIONER_EDEFAULT == null ? positioner != null : !POSITIONER_EDEFAULT.equals(positioner);
			case CommonsPackage.WEB_ADDRESS__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case CommonsPackage.WEB_ADDRESS__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case CommonsPackage.WEB_ADDRESS__BASE_URI:
				return BASE_URI_EDEFAULT == null ? baseUri != null : !BASE_URI_EDEFAULT.equals(baseUri);
			case CommonsPackage.WEB_ADDRESS__BASE_PATH:
				return BASE_PATH_EDEFAULT == null ? basePath != null : !BASE_PATH_EDEFAULT.equals(basePath);
			case CommonsPackage.WEB_ADDRESS__API_PATH:
				return API_PATH_EDEFAULT == null ? apiPath != null : !API_PATH_EDEFAULT.equals(apiPath);
			case CommonsPackage.WEB_ADDRESS__IMAGES_URI:
				return IMAGES_URI_EDEFAULT == null ? imagesUri != null : !IMAGES_URI_EDEFAULT.equals(imagesUri);
			case CommonsPackage.WEB_ADDRESS__SKIN_URI:
				return SKIN_URI_EDEFAULT == null ? skinUri != null : !SKIN_URI_EDEFAULT.equals(skinUri);
			case CommonsPackage.WEB_ADDRESS__JS_URI:
				return JS_URI_EDEFAULT == null ? jsUri != null : !JS_URI_EDEFAULT.equals(jsUri);
			case CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI:
				return SECURE_BASE_URI_EDEFAULT == null ? secureBaseUri != null : !SECURE_BASE_URI_EDEFAULT.equals(secureBaseUri);
			case CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
				return SECURE_IMAGES_URI_EDEFAULT == null ? secureImagesUri != null : !SECURE_IMAGES_URI_EDEFAULT.equals(secureImagesUri);
			case CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI:
				return SECURE_SKIN_URI_EDEFAULT == null ? secureSkinUri != null : !SECURE_SKIN_URI_EDEFAULT.equals(secureSkinUri);
			case CommonsPackage.WEB_ADDRESS__SECURE_JS_URI:
				return SECURE_JS_URI_EDEFAULT == null ? secureJsUri != null : !SECURE_JS_URI_EDEFAULT.equals(secureJsUri);
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
				case CommonsPackage.WEB_ADDRESS__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (derivedFeatureID) {
				case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE: return CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;
				case CommonsPackage.WEB_ADDRESS__RESOURCE_URI: return CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;
				case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME: return CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;
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
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return CommonsPackage.WEB_ADDRESS__BUNDLE;
				default: return -1;
			}
		}
		if (baseClass == ResourceAware.class) {
			switch (baseFeatureID) {
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE: return CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_URI: return CommonsPackage.WEB_ADDRESS__RESOURCE_URI;
				case CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME: return CommonsPackage.WEB_ADDRESS__RESOURCE_NAME;
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
		result.append(", bundle: ");
		result.append(bundle);
		result.append(", resourceType: ");
		result.append(resourceType);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", resourceName: ");
		result.append(resourceName);
		result.append(", baseUri: ");
		result.append(baseUri);
		result.append(", basePath: ");
		result.append(basePath);
		result.append(", apiPath: ");
		result.append(apiPath);
		result.append(", imagesUri: ");
		result.append(imagesUri);
		result.append(", skinUri: ");
		result.append(skinUri);
		result.append(", jsUri: ");
		result.append(jsUri);
		result.append(", secureBaseUri: ");
		result.append(secureBaseUri);
		result.append(", secureImagesUri: ");
		result.append(secureImagesUri);
		result.append(", secureSkinUri: ");
		result.append(secureSkinUri);
		result.append(", secureJsUri: ");
		result.append(secureJsUri);
		result.append(')');
		return result.toString();
	}

} //WebAddressImpl
