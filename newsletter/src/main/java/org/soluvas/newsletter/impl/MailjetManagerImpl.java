/**
 */
package org.soluvas.newsletter.impl;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.newsletter.MailjetManager;
import org.soluvas.newsletter.NewsletterPackage;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetManagerImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetManagerImpl#getApiKey <em>Api Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetManagerImpl#getSecretKey <em>Secret Key</em>}</li>
 *   <li>{@link org.soluvas.newsletter.impl.MailjetManagerImpl#getListId <em>List Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MailjetManagerImpl extends EObjectImpl implements MailjetManager {
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

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
	 * The default value of the '{@link #getListId() <em>List Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListId()
	 * @generated
	 * @ordered
	 */
	protected static final Long LIST_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getListId() <em>List Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListId()
	 * @generated
	 * @ordered
	 */
	protected Long listId = LIST_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public MailjetManagerImpl() {
		throw new UnsupportedOperationException("Please use the constructor with arguments");
	}
	
	@Inject
	@Deprecated
	public MailjetManagerImpl(boolean enabled,
			String apiKey, String secretKey, Long listId) {
		super();
		this.enabled = enabled;
		this.apiKey = apiKey;
		this.secretKey = secretKey;
		this.listId = listId;
		if (enabled) { 
			Preconditions.checkArgument(!Strings.isNullOrEmpty(apiKey), "If Mailjet is enabled, apiKey must be provided");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(secretKey), "If Mailjet is enabled, secretKey must be provided");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NewsletterPackage.Literals.MAILJET_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
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
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Long getListId() {
		return listId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NewsletterPackage.MAILJET_MANAGER__ENABLED:
				return isEnabled();
			case NewsletterPackage.MAILJET_MANAGER__API_KEY:
				return getApiKey();
			case NewsletterPackage.MAILJET_MANAGER__SECRET_KEY:
				return getSecretKey();
			case NewsletterPackage.MAILJET_MANAGER__LIST_ID:
				return getListId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NewsletterPackage.MAILJET_MANAGER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case NewsletterPackage.MAILJET_MANAGER__API_KEY:
				return API_KEY_EDEFAULT == null ? apiKey != null : !API_KEY_EDEFAULT.equals(apiKey);
			case NewsletterPackage.MAILJET_MANAGER__SECRET_KEY:
				return SECRET_KEY_EDEFAULT == null ? secretKey != null : !SECRET_KEY_EDEFAULT.equals(secretKey);
			case NewsletterPackage.MAILJET_MANAGER__LIST_ID:
				return LIST_ID_EDEFAULT == null ? listId != null : !LIST_ID_EDEFAULT.equals(listId);
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", apiKey: ");
		result.append(apiKey);
		result.append(", secretKey: ");
		result.append(secretKey);
		result.append(", listId: ");
		result.append(listId);
		result.append(')');
		return result.toString();
	}

} //MailjetManagerImpl
