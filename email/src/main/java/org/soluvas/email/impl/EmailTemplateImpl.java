/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.osgi.framework.Bundle;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.ResourceType;

import org.soluvas.email.EmailPackage;
import org.soluvas.email.EmailTemplate;
import org.soluvas.email.TemplateLike;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getBundle <em>Bundle</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getSubjectTemplate <em>Subject Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getPlainTemplate <em>Plain Template</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailTemplateImpl#getHtmlTemplate <em>Html Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EmailTemplateImpl extends EObjectImpl implements EmailTemplate {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.EMAIL_TEMPLATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__RESOURCE_TYPE, oldResourceType, resourceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__RESOURCE_URI, oldResourceUri, resourceUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__RESOURCE_NAME, oldResourceName, resourceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__BUNDLE, oldBundle, bundle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE, oldSubjectTemplate, subjectTemplate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE, oldPlainTemplate, plainTemplate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE, oldHtmlTemplate, htmlTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_TYPE:
				return getResourceType();
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_URI:
				return getResourceUri();
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_NAME:
				return getResourceName();
			case EmailPackage.EMAIL_TEMPLATE__BUNDLE:
				return getBundle();
			case EmailPackage.EMAIL_TEMPLATE__NAME:
				return getName();
			case EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE:
				return getSubjectTemplate();
			case EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE:
				return getPlainTemplate();
			case EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE:
				return getHtmlTemplate();
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
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_TYPE:
				setResourceType((ResourceType)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_NAME:
				setResourceName((String)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__BUNDLE:
				setBundle((Bundle)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__NAME:
				setName((String)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate((String)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate((String)newValue);
				return;
			case EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate((String)newValue);
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
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_TYPE:
				setResourceType(RESOURCE_TYPE_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_NAME:
				setResourceName(RESOURCE_NAME_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__BUNDLE:
				setBundle(BUNDLE_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE:
				setSubjectTemplate(SUBJECT_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE:
				setPlainTemplate(PLAIN_TEMPLATE_EDEFAULT);
				return;
			case EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE:
				setHtmlTemplate(HTML_TEMPLATE_EDEFAULT);
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
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_TYPE:
				return resourceType != RESOURCE_TYPE_EDEFAULT;
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case EmailPackage.EMAIL_TEMPLATE__RESOURCE_NAME:
				return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
			case EmailPackage.EMAIL_TEMPLATE__BUNDLE:
				return BUNDLE_EDEFAULT == null ? bundle != null : !BUNDLE_EDEFAULT.equals(bundle);
			case EmailPackage.EMAIL_TEMPLATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE:
				return SUBJECT_TEMPLATE_EDEFAULT == null ? subjectTemplate != null : !SUBJECT_TEMPLATE_EDEFAULT.equals(subjectTemplate);
			case EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE:
				return PLAIN_TEMPLATE_EDEFAULT == null ? plainTemplate != null : !PLAIN_TEMPLATE_EDEFAULT.equals(plainTemplate);
			case EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE:
				return HTML_TEMPLATE_EDEFAULT == null ? htmlTemplate != null : !HTML_TEMPLATE_EDEFAULT.equals(htmlTemplate);
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
				case EmailPackage.EMAIL_TEMPLATE__BUNDLE: return CommonsPackage.BUNDLE_AWARE__BUNDLE;
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
				case EmailPackage.EMAIL_TEMPLATE__NAME: return CommonsPackage.NAME_CONTAINER__NAME;
				default: return -1;
			}
		}
		if (baseClass == TemplateLike.class) {
			switch (derivedFeatureID) {
				case EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__SUBJECT_TEMPLATE;
				case EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__PLAIN_TEMPLATE;
				case EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE: return EmailPackage.TEMPLATE_LIKE__HTML_TEMPLATE;
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
				case CommonsPackage.BUNDLE_AWARE__BUNDLE: return EmailPackage.EMAIL_TEMPLATE__BUNDLE;
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
				case CommonsPackage.NAME_CONTAINER__NAME: return EmailPackage.EMAIL_TEMPLATE__NAME;
				default: return -1;
			}
		}
		if (baseClass == TemplateLike.class) {
			switch (baseFeatureID) {
				case EmailPackage.TEMPLATE_LIKE__SUBJECT_TEMPLATE: return EmailPackage.EMAIL_TEMPLATE__SUBJECT_TEMPLATE;
				case EmailPackage.TEMPLATE_LIKE__PLAIN_TEMPLATE: return EmailPackage.EMAIL_TEMPLATE__PLAIN_TEMPLATE;
				case EmailPackage.TEMPLATE_LIKE__HTML_TEMPLATE: return EmailPackage.EMAIL_TEMPLATE__HTML_TEMPLATE;
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
		result.append(", name: ");
		result.append(name);
		result.append(", subjectTemplate: ");
		result.append(subjectTemplate);
		result.append(", plainTemplate: ");
		result.append(plainTemplate);
		result.append(", htmlTemplate: ");
		result.append(htmlTemplate);
		result.append(')');
		return result.toString();
	}

} //EmailTemplateImpl
