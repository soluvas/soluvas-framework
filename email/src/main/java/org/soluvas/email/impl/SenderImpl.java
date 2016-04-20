/**
 */
package org.soluvas.email.impl;

import java.io.StringReader;
import java.io.StringWriter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.email.DefaultScope;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderType;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.common.base.Strings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sender</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getReplyTo <em>Reply To</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getWebAddress <em>Web Address</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getAppManifest <em>App Manifest</em>}</li>
 *   <li>{@link org.soluvas.email.impl.SenderImpl#getSenderType <em>Sender Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SenderImpl extends MinimalEObjectImpl.Container implements Sender {
	/**
	 * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected String from = FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplyTo() <em>Reply To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplyTo()
	 * @generated
	 * @ordered
	 */
	protected static final String REPLY_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReplyTo() <em>Reply To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplyTo()
	 * @generated
	 * @ordered
	 */
	protected String replyTo = REPLY_TO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWebAddress() <em>Web Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebAddress()
	 * @generated
	 * @ordered
	 */
	protected WebAddress webAddress;

	/**
	 * The cached value of the '{@link #getAppManifest() <em>App Manifest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppManifest()
	 * @generated
	 * @ordered
	 */
	protected AppManifest appManifest;

	/**
	 * The cached value of the '{@link #getSenderType() <em>Sender Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderType()
	 * @generated
	 * @ordered
	 */
	protected SenderType senderType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.SENDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrom(String newFrom) {
		String oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReplyTo(String newReplyTo) {
		String oldReplyTo = replyTo;
		replyTo = newReplyTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__REPLY_TO, oldReplyTo, replyTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WebAddress getWebAddress() {
		if (webAddress != null && webAddress.eIsProxy()) {
			InternalEObject oldWebAddress = (InternalEObject)webAddress;
			webAddress = (WebAddress)eResolveProxy(oldWebAddress);
			if (webAddress != oldWebAddress) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.SENDER__WEB_ADDRESS, oldWebAddress, webAddress));
			}
		}
		return webAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebAddress basicGetWebAddress() {
		return webAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWebAddress(WebAddress newWebAddress) {
		WebAddress oldWebAddress = webAddress;
		webAddress = newWebAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__WEB_ADDRESS, oldWebAddress, webAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppManifest getAppManifest() {
		if (appManifest != null && appManifest.eIsProxy()) {
			InternalEObject oldAppManifest = (InternalEObject)appManifest;
			appManifest = (AppManifest)eResolveProxy(oldAppManifest);
			if (appManifest != oldAppManifest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.SENDER__APP_MANIFEST, oldAppManifest, appManifest));
			}
		}
		return appManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppManifest basicGetAppManifest() {
		return appManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAppManifest(AppManifest newAppManifest) {
		AppManifest oldAppManifest = appManifest;
		appManifest = newAppManifest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__APP_MANIFEST, oldAppManifest, appManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenderType getSenderType() {
		if (senderType != null && senderType.eIsProxy()) {
			InternalEObject oldSenderType = (InternalEObject)senderType;
			senderType = (SenderType)eResolveProxy(oldSenderType);
			if (senderType != oldSenderType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.SENDER__SENDER_TYPE, oldSenderType, senderType));
			}
		}
		return senderType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SenderType basicGetSenderType() {
		return senderType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setSenderType(SenderType newSenderType) {
		SenderType oldSenderType = senderType;
		senderType = newSenderType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.SENDER__SENDER_TYPE, oldSenderType, senderType));
		
		setFrom(newSenderType.getFrom());
		setEmail(newSenderType.getEmail());
		setReplyTo(newSenderType.getReplyTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void expand() {
		setFrom(doExpand(getFrom()));
		setEmail(doExpand(getEmail()));
		if (!Strings.isNullOrEmpty(getReplyTo())) {
			setReplyTo(doExpand(getReplyTo()));
		}
	}
	
	protected String doExpand(String template) {
		final MustacheFactory mf = new DefaultMustacheFactory();
		final Mustache mustache = mf.compile(new StringReader(template), "sender");
		final StringWriter stringWriter = new StringWriter();
		mustache.execute(stringWriter, this);
		return stringWriter.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.SENDER__FROM:
				return getFrom();
			case EmailPackage.SENDER__EMAIL:
				return getEmail();
			case EmailPackage.SENDER__REPLY_TO:
				return getReplyTo();
			case EmailPackage.SENDER__WEB_ADDRESS:
				if (resolve) return getWebAddress();
				return basicGetWebAddress();
			case EmailPackage.SENDER__APP_MANIFEST:
				if (resolve) return getAppManifest();
				return basicGetAppManifest();
			case EmailPackage.SENDER__SENDER_TYPE:
				if (resolve) return getSenderType();
				return basicGetSenderType();
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
			case EmailPackage.SENDER__FROM:
				setFrom((String)newValue);
				return;
			case EmailPackage.SENDER__EMAIL:
				setEmail((String)newValue);
				return;
			case EmailPackage.SENDER__REPLY_TO:
				setReplyTo((String)newValue);
				return;
			case EmailPackage.SENDER__WEB_ADDRESS:
				setWebAddress((WebAddress)newValue);
				return;
			case EmailPackage.SENDER__APP_MANIFEST:
				setAppManifest((AppManifest)newValue);
				return;
			case EmailPackage.SENDER__SENDER_TYPE:
				setSenderType((SenderType)newValue);
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
			case EmailPackage.SENDER__FROM:
				setFrom(FROM_EDEFAULT);
				return;
			case EmailPackage.SENDER__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case EmailPackage.SENDER__REPLY_TO:
				setReplyTo(REPLY_TO_EDEFAULT);
				return;
			case EmailPackage.SENDER__WEB_ADDRESS:
				setWebAddress((WebAddress)null);
				return;
			case EmailPackage.SENDER__APP_MANIFEST:
				setAppManifest((AppManifest)null);
				return;
			case EmailPackage.SENDER__SENDER_TYPE:
				setSenderType((SenderType)null);
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
			case EmailPackage.SENDER__FROM:
				return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
			case EmailPackage.SENDER__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case EmailPackage.SENDER__REPLY_TO:
				return REPLY_TO_EDEFAULT == null ? replyTo != null : !REPLY_TO_EDEFAULT.equals(replyTo);
			case EmailPackage.SENDER__WEB_ADDRESS:
				return webAddress != null;
			case EmailPackage.SENDER__APP_MANIFEST:
				return appManifest != null;
			case EmailPackage.SENDER__SENDER_TYPE:
				return senderType != null;
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
		if (baseClass == DefaultScope.class) {
			switch (derivedFeatureID) {
				case EmailPackage.SENDER__WEB_ADDRESS: return EmailPackage.DEFAULT_SCOPE__WEB_ADDRESS;
				case EmailPackage.SENDER__APP_MANIFEST: return EmailPackage.DEFAULT_SCOPE__APP_MANIFEST;
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
		if (baseClass == DefaultScope.class) {
			switch (baseFeatureID) {
				case EmailPackage.DEFAULT_SCOPE__WEB_ADDRESS: return EmailPackage.SENDER__WEB_ADDRESS;
				case EmailPackage.DEFAULT_SCOPE__APP_MANIFEST: return EmailPackage.SENDER__APP_MANIFEST;
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
		result.append(" (from: ");
		result.append(from);
		result.append(", email: ");
		result.append(email);
		result.append(", replyTo: ");
		result.append(replyTo);
		result.append(')');
		return result.toString();
	}

} //SenderImpl
