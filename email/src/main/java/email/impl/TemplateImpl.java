/**
 */
package email.impl;

import email.DefaultScope;
import email.EmailPackage;
import email.Recipient;
import email.Template;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link email.impl.TemplateImpl#getSubjectTemplate <em>Subject Template</em>}</li>
 *   <li>{@link email.impl.TemplateImpl#getPlainTemplate <em>Plain Template</em>}</li>
 *   <li>{@link email.impl.TemplateImpl#getHtmlTemplate <em>Html Template</em>}</li>
 *   <li>{@link email.impl.TemplateImpl#getWebAddress <em>Web Address</em>}</li>
 *   <li>{@link email.impl.TemplateImpl#getAppManifest <em>App Manifest</em>}</li>
 *   <li>{@link email.impl.TemplateImpl#getRecipients <em>Recipients</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateImpl extends EObjectImpl implements Template {
	/**
	 * The default value of the '{@link #getSubjectTemplate() <em>Subject Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubjectTemplate() <em>Subject Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectTemplate()
	 * @generated
	 * @ordered
	 */
	protected String subjectTemplate = SUBJECT_TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlainTemplate() <em>Plain Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlainTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String PLAIN_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlainTemplate() <em>Plain Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlainTemplate()
	 * @generated
	 * @ordered
	 */
	protected String plainTemplate = PLAIN_TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHtmlTemplate() <em>Html Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String HTML_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHtmlTemplate() <em>Html Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHtmlTemplate()
	 * @generated
	 * @ordered
	 */
	protected String htmlTemplate = HTML_TEMPLATE_EDEFAULT;

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
	 * The cached value of the '{@link #getRecipients() <em>Recipients</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecipients()
	 * @generated
	 * @ordered
	 */
	protected EList<Recipient> recipients;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubjectTemplate() {
		return subjectTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubjectTemplate(String newSubjectTemplate) {
		String oldSubjectTemplate = subjectTemplate;
		subjectTemplate = newSubjectTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__SUBJECT_TEMPLATE, oldSubjectTemplate, subjectTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlainTemplate() {
		return plainTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlainTemplate(String newPlainTemplate) {
		String oldPlainTemplate = plainTemplate;
		plainTemplate = newPlainTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__PLAIN_TEMPLATE, oldPlainTemplate, plainTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHtmlTemplate(String newHtmlTemplate) {
		String oldHtmlTemplate = htmlTemplate;
		htmlTemplate = newHtmlTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__HTML_TEMPLATE, oldHtmlTemplate, htmlTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebAddress getWebAddress() {
		if (webAddress != null && ((EObject)webAddress).eIsProxy()) {
			InternalEObject oldWebAddress = (InternalEObject)webAddress;
			webAddress = (WebAddress)eResolveProxy(oldWebAddress);
			if (webAddress != oldWebAddress) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.TEMPLATE__WEB_ADDRESS, oldWebAddress, webAddress));
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
	public void setWebAddress(WebAddress newWebAddress) {
		WebAddress oldWebAddress = webAddress;
		webAddress = newWebAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__WEB_ADDRESS, oldWebAddress, webAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppManifest getAppManifest() {
		if (appManifest != null && ((EObject)appManifest).eIsProxy()) {
			InternalEObject oldAppManifest = (InternalEObject)appManifest;
			appManifest = (AppManifest)eResolveProxy(oldAppManifest);
			if (appManifest != oldAppManifest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.TEMPLATE__APP_MANIFEST, oldAppManifest, appManifest));
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
	public void setAppManifest(AppManifest newAppManifest) {
		AppManifest oldAppManifest = appManifest;
		appManifest = newAppManifest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__APP_MANIFEST, oldAppManifest, appManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Recipient> getRecipients() {
		if (recipients == null) {
			recipients = new EObjectResolvingEList<Recipient>(Recipient.class, this, EmailPackage.TEMPLATE__RECIPIENTS);
		}
		return recipients;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String renderSubject(Recipient recipient) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String renderText(Recipient recipient) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String renderHtml(Recipient recipient) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				return getSubjectTemplate();
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				return getPlainTemplate();
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				return getHtmlTemplate();
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				if (resolve) return getWebAddress();
				return basicGetWebAddress();
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				if (resolve) return getAppManifest();
				return basicGetAppManifest();
			case EmailPackage.TEMPLATE__RECIPIENTS:
				return getRecipients();
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
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				setWebAddress((WebAddress)newValue);
				return;
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				setAppManifest((AppManifest)newValue);
				return;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				getRecipients().clear();
				getRecipients().addAll((Collection<? extends Recipient>)newValue);
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
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate(SUBJECT_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate(PLAIN_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate(HTML_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				setWebAddress((WebAddress)null);
				return;
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				setAppManifest((AppManifest)null);
				return;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				getRecipients().clear();
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
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				return SUBJECT_TEMPLATE_EDEFAULT == null ? subjectTemplate != null : !SUBJECT_TEMPLATE_EDEFAULT.equals(subjectTemplate);
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				return PLAIN_TEMPLATE_EDEFAULT == null ? plainTemplate != null : !PLAIN_TEMPLATE_EDEFAULT.equals(plainTemplate);
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				return HTML_TEMPLATE_EDEFAULT == null ? htmlTemplate != null : !HTML_TEMPLATE_EDEFAULT.equals(htmlTemplate);
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				return webAddress != null;
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				return appManifest != null;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				return recipients != null && !recipients.isEmpty();
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
				case EmailPackage.TEMPLATE__WEB_ADDRESS: return EmailPackage.DEFAULT_SCOPE__WEB_ADDRESS;
				case EmailPackage.TEMPLATE__APP_MANIFEST: return EmailPackage.DEFAULT_SCOPE__APP_MANIFEST;
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
				case EmailPackage.DEFAULT_SCOPE__WEB_ADDRESS: return EmailPackage.TEMPLATE__WEB_ADDRESS;
				case EmailPackage.DEFAULT_SCOPE__APP_MANIFEST: return EmailPackage.TEMPLATE__APP_MANIFEST;
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
		result.append(" (subjectTemplate: ");
		result.append(subjectTemplate);
		result.append(", plainTemplate: ");
		result.append(plainTemplate);
		result.append(", htmlTemplate: ");
		result.append(htmlTemplate);
		result.append(')');
		return result.toString();
	}

} //TemplateImpl
