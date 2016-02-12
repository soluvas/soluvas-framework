/**
 */
package org.soluvas.newsletter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.newsletter.MailjetCredential;
import org.soluvas.newsletter.NewsletterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mailjet Credential</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetCredentialImpl#getApiKey <em>Api Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetCredentialImpl#getSecretKey <em>Secret Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetCredentialImpl#getDefaultContactID <em>Default Contact ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MailjetCredentialImpl extends EObjectImpl implements MailjetCredential {
	/**
	 * The default value of the '{@link #getApiKey() <em>Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiKey()
	 * @generated
	 * @ordered
	 */
	protected static final String API_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApiKey() <em>Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApiKey()
	 * @generated
	 * @ordered
	 */
	protected String apiKey = API_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecretKey() <em>Secret Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecretKey()
	 * @generated
	 * @ordered
	 */
	protected static final String SECRET_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecretKey() <em>Secret Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecretKey()
	 * @generated
	 * @ordered
	 */
	protected String secretKey = SECRET_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultContactID() <em>Default Contact ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultContactID()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CONTACT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultContactID() <em>Default Contact ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultContactID()
	 * @generated
	 * @ordered
	 */
	protected String defaultContactID = DEFAULT_CONTACT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailjetCredentialImpl() {
		super();
	}
	
	public MailjetCredentialImpl(String apiKey, String secretKey, String defaultContactID) {
		super();
		this.apiKey = apiKey;
		this.secretKey = secretKey;
		this.defaultContactID = defaultContactID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewsletterPackage.Literals.MAILJET_CREDENTIAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiKey(String newApiKey) {
		String oldApiKey = apiKey;
		apiKey = newApiKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewsletterPackage.MAILJET_CREDENTIAL__API_KEY, oldApiKey, apiKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecretKey(String newSecretKey) {
		String oldSecretKey = secretKey;
		secretKey = newSecretKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewsletterPackage.MAILJET_CREDENTIAL__SECRET_KEY, oldSecretKey, secretKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefaultContactID() {
		return defaultContactID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefaultContactID(String newDefaultContactID) {
		String oldDefaultContactID = defaultContactID;
		defaultContactID = newDefaultContactID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NewsletterPackage.MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID, oldDefaultContactID, defaultContactID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewsletterPackage.MAILJET_CREDENTIAL__API_KEY:
				return getApiKey();
			case NewsletterPackage.MAILJET_CREDENTIAL__SECRET_KEY:
				return getSecretKey();
			case NewsletterPackage.MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID:
				return getDefaultContactID();
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
			case NewsletterPackage.MAILJET_CREDENTIAL__API_KEY:
				setApiKey((String)newValue);
				return;
			case NewsletterPackage.MAILJET_CREDENTIAL__SECRET_KEY:
				setSecretKey((String)newValue);
				return;
			case NewsletterPackage.MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID:
				setDefaultContactID((String)newValue);
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
			case NewsletterPackage.MAILJET_CREDENTIAL__API_KEY:
				setApiKey(API_KEY_EDEFAULT);
				return;
			case NewsletterPackage.MAILJET_CREDENTIAL__SECRET_KEY:
				setSecretKey(SECRET_KEY_EDEFAULT);
				return;
			case NewsletterPackage.MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID:
				setDefaultContactID(DEFAULT_CONTACT_ID_EDEFAULT);
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
			case NewsletterPackage.MAILJET_CREDENTIAL__API_KEY:
				return API_KEY_EDEFAULT == null ? apiKey != null : !API_KEY_EDEFAULT.equals(apiKey);
			case NewsletterPackage.MAILJET_CREDENTIAL__SECRET_KEY:
				return SECRET_KEY_EDEFAULT == null ? secretKey != null : !SECRET_KEY_EDEFAULT.equals(secretKey);
			case NewsletterPackage.MAILJET_CREDENTIAL__DEFAULT_CONTACT_ID:
				return DEFAULT_CONTACT_ID_EDEFAULT == null ? defaultContactID != null : !DEFAULT_CONTACT_ID_EDEFAULT.equals(defaultContactID);
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
		result.append(" (apiKey: ");
		result.append(apiKey);
		result.append(", secretKey: ");
		result.append(secretKey);
		result.append(", defaultContactID: ");
		result.append(defaultContactID);
		result.append(')');
		return result.toString();
	}

} //MailjetCredentialImpl
