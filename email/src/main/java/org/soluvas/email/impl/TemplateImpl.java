/**
 */
package org.soluvas.email.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.WebAddress;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.PageType;
import org.soluvas.email.Recipient;
import org.soluvas.email.Template;
import org.soluvas.email.TemplateLike;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getEClassStatus <em>EClass Status</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getEPackageNsPrefix <em>EPackage Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getEPackageName <em>EPackage Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getSubjectTemplate <em>Subject Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getPlainTemplate <em>Plain Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getHtmlTemplate <em>Html Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getRecipients <em>Recipients</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getAppManifest <em>App Manifest</em>}</li>
 *   <li>{@link org.soluvas.email.impl.TemplateImpl#getWebAddress <em>Web Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateImpl extends EObjectImpl implements Template {
	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * The default value of the '{@link #getEClassStatus() <em>EClass Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassStatus()
	 * @generated
	 * @ordered
	 */
	protected static final EClassStatus ECLASS_STATUS_EDEFAULT = EClassStatus.UNRESOLVED;

	/**
	 * The cached value of the '{@link #getEClassStatus() <em>EClass Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassStatus()
	 * @generated
	 * @ordered
	 */
	protected EClassStatus eClassStatus = ECLASS_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEPackageNsPrefix() <em>EPackage Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String EPACKAGE_NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPackageNsPrefix() <em>EPackage Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String ePackageNsPrefix = EPACKAGE_NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String ECLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassName()
	 * @generated
	 * @ordered
	 */
	protected String eClassName = ECLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEPackageName() <em>EPackage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String EPACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPackageName() <em>EPackage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackageName()
	 * @generated
	 * @ordered
	 */
	protected String ePackageName = EPACKAGE_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected PageType template;

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
	 * The cached value of the '{@link #getAppManifest() <em>App Manifest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppManifest()
	 * @generated
	 * @ordered
	 */
	protected AppManifest appManifest;

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
	@Override
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.TEMPLATE__ECLASS, oldEClass, eClass));
			}
		}
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClass(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassStatus getEClassStatus() {
		return eClassStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClassStatus(EClassStatus newEClassStatus) {
		EClassStatus oldEClassStatus = eClassStatus;
		eClassStatus = newEClassStatus == null ? ECLASS_STATUS_EDEFAULT : newEClassStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__ECLASS_STATUS, oldEClassStatus, eClassStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEPackageNsPrefix() {
		return ePackageNsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackageNsPrefix(String newEPackageNsPrefix) {
		String oldEPackageNsPrefix = ePackageNsPrefix;
		ePackageNsPrefix = newEPackageNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__EPACKAGE_NS_PREFIX, oldEPackageNsPrefix, ePackageNsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEClassName() {
		return eClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEClassName(String newEClassName) {
		String oldEClassName = eClassName;
		eClassName = newEClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__ECLASS_NAME, oldEClassName, eClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEPackageName() {
		return ePackageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEPackageName(String newEPackageName) {
		String oldEPackageName = ePackageName;
		ePackageName = newEPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__EPACKAGE_NAME, oldEPackageName, ePackageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSubjectTemplate() {
		return subjectTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getPlainTemplate() {
		return plainTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public PageType getTemplate() {
		if (template != null && ((EObject)template).eIsProxy()) {
			InternalEObject oldTemplate = (InternalEObject)template;
			template = (PageType)eResolveProxy(oldTemplate);
			if (template != oldTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.TEMPLATE__TEMPLATE, oldTemplate, template));
			}
		}
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageType basicGetTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemplate(PageType newTemplate) {
		PageType oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.TEMPLATE__TEMPLATE, oldTemplate, template));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	public void resolveEClass(Map<String, EClass> eClassMap) {
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
			case EmailPackage.TEMPLATE__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case EmailPackage.TEMPLATE__ECLASS_STATUS:
				return getEClassStatus();
			case EmailPackage.TEMPLATE__EPACKAGE_NS_PREFIX:
				return getEPackageNsPrefix();
			case EmailPackage.TEMPLATE__ECLASS_NAME:
				return getEClassName();
			case EmailPackage.TEMPLATE__EPACKAGE_NAME:
				return getEPackageName();
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				return getSubjectTemplate();
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				return getPlainTemplate();
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				return getHtmlTemplate();
			case EmailPackage.TEMPLATE__TEMPLATE:
				if (resolve) return getTemplate();
				return basicGetTemplate();
			case EmailPackage.TEMPLATE__RECIPIENTS:
				return getRecipients();
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				if (resolve) return getAppManifest();
				return basicGetAppManifest();
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				if (resolve) return getWebAddress();
				return basicGetWebAddress();
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
			case EmailPackage.TEMPLATE__ECLASS:
				setEClass((EClass)newValue);
				return;
			case EmailPackage.TEMPLATE__ECLASS_STATUS:
				setEClassStatus((EClassStatus)newValue);
				return;
			case EmailPackage.TEMPLATE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix((String)newValue);
				return;
			case EmailPackage.TEMPLATE__ECLASS_NAME:
				setEClassName((String)newValue);
				return;
			case EmailPackage.TEMPLATE__EPACKAGE_NAME:
				setEPackageName((String)newValue);
				return;
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate((String)newValue);
				return;
			case EmailPackage.TEMPLATE__TEMPLATE:
				setTemplate((PageType)newValue);
				return;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				getRecipients().clear();
				getRecipients().addAll((Collection<? extends Recipient>)newValue);
				return;
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				setAppManifest((AppManifest)newValue);
				return;
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				setWebAddress((WebAddress)newValue);
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
			case EmailPackage.TEMPLATE__ECLASS:
				setEClass((EClass)null);
				return;
			case EmailPackage.TEMPLATE__ECLASS_STATUS:
				setEClassStatus(ECLASS_STATUS_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__EPACKAGE_NS_PREFIX:
				setEPackageNsPrefix(EPACKAGE_NS_PREFIX_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__ECLASS_NAME:
				setEClassName(ECLASS_NAME_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__EPACKAGE_NAME:
				setEPackageName(EPACKAGE_NAME_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate(SUBJECT_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate(PLAIN_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate(HTML_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.TEMPLATE__TEMPLATE:
				setTemplate((PageType)null);
				return;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				getRecipients().clear();
				return;
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				setAppManifest((AppManifest)null);
				return;
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				setWebAddress((WebAddress)null);
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
			case EmailPackage.TEMPLATE__ECLASS:
				return eClass != null;
			case EmailPackage.TEMPLATE__ECLASS_STATUS:
				return eClassStatus != ECLASS_STATUS_EDEFAULT;
			case EmailPackage.TEMPLATE__EPACKAGE_NS_PREFIX:
				return EPACKAGE_NS_PREFIX_EDEFAULT == null ? ePackageNsPrefix != null : !EPACKAGE_NS_PREFIX_EDEFAULT.equals(ePackageNsPrefix);
			case EmailPackage.TEMPLATE__ECLASS_NAME:
				return ECLASS_NAME_EDEFAULT == null ? eClassName != null : !ECLASS_NAME_EDEFAULT.equals(eClassName);
			case EmailPackage.TEMPLATE__EPACKAGE_NAME:
				return EPACKAGE_NAME_EDEFAULT == null ? ePackageName != null : !EPACKAGE_NAME_EDEFAULT.equals(ePackageName);
			case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE:
				return SUBJECT_TEMPLATE_EDEFAULT == null ? subjectTemplate != null : !SUBJECT_TEMPLATE_EDEFAULT.equals(subjectTemplate);
			case EmailPackage.TEMPLATE__PLAIN_TEMPLATE:
				return PLAIN_TEMPLATE_EDEFAULT == null ? plainTemplate != null : !PLAIN_TEMPLATE_EDEFAULT.equals(plainTemplate);
			case EmailPackage.TEMPLATE__HTML_TEMPLATE:
				return HTML_TEMPLATE_EDEFAULT == null ? htmlTemplate != null : !HTML_TEMPLATE_EDEFAULT.equals(htmlTemplate);
			case EmailPackage.TEMPLATE__TEMPLATE:
				return template != null;
			case EmailPackage.TEMPLATE__RECIPIENTS:
				return recipients != null && !recipients.isEmpty();
			case EmailPackage.TEMPLATE__APP_MANIFEST:
				return appManifest != null;
			case EmailPackage.TEMPLATE__WEB_ADDRESS:
				return webAddress != null;
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
		if (baseClass == TemplateLike.class) {
			switch (derivedFeatureID) {
				case EmailPackage.TEMPLATE__SUBJECT_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__SUBJECT_TEMPLATE;
				case EmailPackage.TEMPLATE__PLAIN_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__PLAIN_TEMPLATE;
				case EmailPackage.TEMPLATE__HTML_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__HTML_TEMPLATE;
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
		if (baseClass == TemplateLike.class) {
			switch (baseFeatureID) {
				case EmailPackage.TEMPLATE_LIKE__SUBJECT_TEMPLATE: return EmailPackage.TEMPLATE__SUBJECT_TEMPLATE;
				case EmailPackage.TEMPLATE_LIKE__PLAIN_TEMPLATE: return EmailPackage.TEMPLATE__PLAIN_TEMPLATE;
				case EmailPackage.TEMPLATE_LIKE__HTML_TEMPLATE: return EmailPackage.TEMPLATE__HTML_TEMPLATE;
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
		result.append(" (eClassStatus: ");
		result.append(eClassStatus);
		result.append(", ePackageNsPrefix: ");
		result.append(ePackageNsPrefix);
		result.append(", eClassName: ");
		result.append(eClassName);
		result.append(", ePackageName: ");
		result.append(ePackageName);
		result.append(", subjectTemplate: ");
		result.append(subjectTemplate);
		result.append(", plainTemplate: ");
		result.append(plainTemplate);
		result.append(", htmlTemplate: ");
		result.append(htmlTemplate);
		result.append(')');
		return result.toString();
	}

} //TemplateImpl
