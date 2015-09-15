/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Organization;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.SchemaVersionable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Organization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getBlackBerryPin <em>Black Berry Pin</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getWebsite <em>Website</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getFacebookPageUri <em>Facebook Page Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getFacebookUserName <em>Facebook User Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getTwitterScreenName <em>Twitter Screen Name</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getTwitterAccessToken <em>Twitter Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.OrganizationImpl#getTwitterId <em>Twitter Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrganizationImpl extends MinimalEObjectImpl.Container implements Organization {
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
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final long SCHEMA_VERSION_EDEFAULT = 1L;

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
	 * The default value of the '{@link #getBlackBerryPin() <em>Black Berry Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlackBerryPin()
	 * @generated
	 * @ordered
	 */
	protected static final String BLACK_BERRY_PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBlackBerryPin() <em>Black Berry Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlackBerryPin()
	 * @generated
	 * @ordered
	 */
	protected String blackBerryPin = BLACK_BERRY_PIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getWebsite() <em>Website</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebsite()
	 * @generated
	 * @ordered
	 */
	protected static final String WEBSITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWebsite() <em>Website</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebsite()
	 * @generated
	 * @ordered
	 */
	protected String website = WEBSITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookPageUri() <em>Facebook Page Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookPageUri()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_PAGE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookPageUri() <em>Facebook Page Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookPageUri()
	 * @generated
	 * @ordered
	 */
	protected String facebookPageUri = FACEBOOK_PAGE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookAccessToken() <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String facebookAccessToken = FACEBOOK_ACCESS_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookId() <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookId()
	 * @generated
	 * @ordered
	 */
	protected String facebookId = FACEBOOK_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookUserName() <em>Facebook User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookUserName() <em>Facebook User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUserName()
	 * @generated
	 * @ordered
	 */
	protected String facebookUserName = FACEBOOK_USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterScreenName() <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterScreenName()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_SCREEN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterScreenName() <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterScreenName()
	 * @generated
	 * @ordered
	 */
	protected String twitterScreenName = TWITTER_SCREEN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterAccessToken() <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessToken()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_ACCESS_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterAccessToken() <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessToken()
	 * @generated
	 * @ordered
	 */
	protected String twitterAccessToken = TWITTER_ACCESS_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterAccessTokenSecret() <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterAccessTokenSecret() <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 * @ordered
	 */
	protected String twitterAccessTokenSecret = TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterId() <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterId()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterId() <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterId()
	 * @generated
	 * @ordered
	 */
	protected String twitterId = TWITTER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.ORGANIZATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__NAME, oldName, name));
	}

	public static final long serialVersionUID = SCHEMA_VERSION_EDEFAULT;

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
	public String getBlackBerryPin() {
		return blackBerryPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlackBerryPin(String newBlackBerryPin) {
		String oldBlackBerryPin = blackBerryPin;
		blackBerryPin = newBlackBerryPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__BLACK_BERRY_PIN, oldBlackBerryPin, blackBerryPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWebsite() {
		return website;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebsite(String newWebsite) {
		String oldWebsite = website;
		website = newWebsite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__WEBSITE, oldWebsite, website));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookPageUri() {
		return facebookPageUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookPageUri(String newFacebookPageUri) {
		String oldFacebookPageUri = facebookPageUri;
		facebookPageUri = newFacebookPageUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__FACEBOOK_PAGE_URI, oldFacebookPageUri, facebookPageUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookAccessToken(String newFacebookAccessToken) {
		String oldFacebookAccessToken = facebookAccessToken;
		facebookAccessToken = newFacebookAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__FACEBOOK_ACCESS_TOKEN, oldFacebookAccessToken, facebookAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookId() {
		return facebookId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookId(String newFacebookId) {
		String oldFacebookId = facebookId;
		facebookId = newFacebookId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__FACEBOOK_ID, oldFacebookId, facebookId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFacebookUserName() {
		return facebookUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFacebookUserName(String newFacebookUserName) {
		String oldFacebookUserName = facebookUserName;
		facebookUserName = newFacebookUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__FACEBOOK_USER_NAME, oldFacebookUserName, facebookUserName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterScreenName(String newTwitterScreenName) {
		String oldTwitterScreenName = twitterScreenName;
		twitterScreenName = newTwitterScreenName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__TWITTER_SCREEN_NAME, oldTwitterScreenName, twitterScreenName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterAccessToken(String newTwitterAccessToken) {
		String oldTwitterAccessToken = twitterAccessToken;
		twitterAccessToken = newTwitterAccessToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN, oldTwitterAccessToken, twitterAccessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterAccessTokenSecret() {
		return twitterAccessTokenSecret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterAccessTokenSecret(String newTwitterAccessTokenSecret) {
		String oldTwitterAccessTokenSecret = twitterAccessTokenSecret;
		twitterAccessTokenSecret = newTwitterAccessTokenSecret;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET, oldTwitterAccessTokenSecret, twitterAccessTokenSecret));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTwitterId() {
		return twitterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTwitterId(String newTwitterId) {
		String oldTwitterId = twitterId;
		twitterId = newTwitterId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ORGANIZATION__TWITTER_ID, oldTwitterId, twitterId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.ORGANIZATION__ID:
				return getId();
			case CommonsPackage.ORGANIZATION__NAME:
				return getName();
			case CommonsPackage.ORGANIZATION__SCHEMA_VERSION:
				return getSchemaVersion();
			case CommonsPackage.ORGANIZATION__BLACK_BERRY_PIN:
				return getBlackBerryPin();
			case CommonsPackage.ORGANIZATION__WEBSITE:
				return getWebsite();
			case CommonsPackage.ORGANIZATION__FACEBOOK_PAGE_URI:
				return getFacebookPageUri();
			case CommonsPackage.ORGANIZATION__FACEBOOK_ACCESS_TOKEN:
				return getFacebookAccessToken();
			case CommonsPackage.ORGANIZATION__FACEBOOK_ID:
				return getFacebookId();
			case CommonsPackage.ORGANIZATION__FACEBOOK_USER_NAME:
				return getFacebookUserName();
			case CommonsPackage.ORGANIZATION__TWITTER_SCREEN_NAME:
				return getTwitterScreenName();
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN:
				return getTwitterAccessToken();
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET:
				return getTwitterAccessTokenSecret();
			case CommonsPackage.ORGANIZATION__TWITTER_ID:
				return getTwitterId();
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
			case CommonsPackage.ORGANIZATION__ID:
				setId((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__NAME:
				setName((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__BLACK_BERRY_PIN:
				setBlackBerryPin((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__WEBSITE:
				setWebsite((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_PAGE_URI:
				setFacebookPageUri((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_ID:
				setFacebookId((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_USER_NAME:
				setFacebookUserName((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_SCREEN_NAME:
				setTwitterScreenName((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN:
				setTwitterAccessToken((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET:
				setTwitterAccessTokenSecret((String)newValue);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ID:
				setTwitterId((String)newValue);
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
			case CommonsPackage.ORGANIZATION__ID:
				setId(ID_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__BLACK_BERRY_PIN:
				setBlackBerryPin(BLACK_BERRY_PIN_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__WEBSITE:
				setWebsite(WEBSITE_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_PAGE_URI:
				setFacebookPageUri(FACEBOOK_PAGE_URI_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_ACCESS_TOKEN:
				setFacebookAccessToken(FACEBOOK_ACCESS_TOKEN_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_ID:
				setFacebookId(FACEBOOK_ID_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__FACEBOOK_USER_NAME:
				setFacebookUserName(FACEBOOK_USER_NAME_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_SCREEN_NAME:
				setTwitterScreenName(TWITTER_SCREEN_NAME_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN:
				setTwitterAccessToken(TWITTER_ACCESS_TOKEN_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET:
				setTwitterAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT);
				return;
			case CommonsPackage.ORGANIZATION__TWITTER_ID:
				setTwitterId(TWITTER_ID_EDEFAULT);
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
			case CommonsPackage.ORGANIZATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CommonsPackage.ORGANIZATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommonsPackage.ORGANIZATION__SCHEMA_VERSION:
				return schemaVersion != SCHEMA_VERSION_EDEFAULT;
			case CommonsPackage.ORGANIZATION__BLACK_BERRY_PIN:
				return BLACK_BERRY_PIN_EDEFAULT == null ? blackBerryPin != null : !BLACK_BERRY_PIN_EDEFAULT.equals(blackBerryPin);
			case CommonsPackage.ORGANIZATION__WEBSITE:
				return WEBSITE_EDEFAULT == null ? website != null : !WEBSITE_EDEFAULT.equals(website);
			case CommonsPackage.ORGANIZATION__FACEBOOK_PAGE_URI:
				return FACEBOOK_PAGE_URI_EDEFAULT == null ? facebookPageUri != null : !FACEBOOK_PAGE_URI_EDEFAULT.equals(facebookPageUri);
			case CommonsPackage.ORGANIZATION__FACEBOOK_ACCESS_TOKEN:
				return FACEBOOK_ACCESS_TOKEN_EDEFAULT == null ? facebookAccessToken != null : !FACEBOOK_ACCESS_TOKEN_EDEFAULT.equals(facebookAccessToken);
			case CommonsPackage.ORGANIZATION__FACEBOOK_ID:
				return FACEBOOK_ID_EDEFAULT == null ? facebookId != null : !FACEBOOK_ID_EDEFAULT.equals(facebookId);
			case CommonsPackage.ORGANIZATION__FACEBOOK_USER_NAME:
				return FACEBOOK_USER_NAME_EDEFAULT == null ? facebookUserName != null : !FACEBOOK_USER_NAME_EDEFAULT.equals(facebookUserName);
			case CommonsPackage.ORGANIZATION__TWITTER_SCREEN_NAME:
				return TWITTER_SCREEN_NAME_EDEFAULT == null ? twitterScreenName != null : !TWITTER_SCREEN_NAME_EDEFAULT.equals(twitterScreenName);
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN:
				return TWITTER_ACCESS_TOKEN_EDEFAULT == null ? twitterAccessToken != null : !TWITTER_ACCESS_TOKEN_EDEFAULT.equals(twitterAccessToken);
			case CommonsPackage.ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET:
				return TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT == null ? twitterAccessTokenSecret != null : !TWITTER_ACCESS_TOKEN_SECRET_EDEFAULT.equals(twitterAccessTokenSecret);
			case CommonsPackage.ORGANIZATION__TWITTER_ID:
				return TWITTER_ID_EDEFAULT == null ? twitterId != null : !TWITTER_ID_EDEFAULT.equals(twitterId);
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
		if (baseClass == SchemaVersionable.class) {
			switch (derivedFeatureID) {
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
				case CommonsPackage.ORGANIZATION__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
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
		if (baseClass == SchemaVersionable.class) {
			switch (baseFeatureID) {
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
				case CommonsPackage.NAME_CONTAINER__NAME: return CommonsPackage.ORGANIZATION__NAME;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", schemaVersion: ");
		result.append(schemaVersion);
		result.append(", blackBerryPin: ");
		result.append(blackBerryPin);
		result.append(", website: ");
		result.append(website);
		result.append(", facebookPageUri: ");
		result.append(facebookPageUri);
		result.append(", facebookAccessToken: ");
		result.append(facebookAccessToken);
		result.append(", facebookId: ");
		result.append(facebookId);
		result.append(", facebookUserName: ");
		result.append(facebookUserName);
		result.append(", twitterScreenName: ");
		result.append(twitterScreenName);
		result.append(", twitterAccessToken: ");
		result.append(twitterAccessToken);
		result.append(", twitterAccessTokenSecret: ");
		result.append(twitterAccessTokenSecret);
		result.append(", twitterId: ");
		result.append(twitterId);
		result.append(')');
		return result.toString();
	}

} //OrganizationImpl
