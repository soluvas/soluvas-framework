/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.LayoutImpl#getPageSubject <em>Page Subject</em>}</li>
 *   <li>{@link org.soluvas.email.impl.LayoutImpl#getPagePlain <em>Page Plain</em>}</li>
 *   <li>{@link org.soluvas.email.impl.LayoutImpl#getPageHtml <em>Page Html</em>}</li>
 *   <li>{@link org.soluvas.email.impl.LayoutImpl#getLayoutType <em>Layout Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LayoutImpl extends TemplateImpl implements Layout {
	/**
	 * The default value of the '{@link #getPageSubject() <em>Page Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_SUBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageSubject() <em>Page Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSubject()
	 * @generated
	 * @ordered
	 */
	protected String pageSubject = PAGE_SUBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPagePlain() <em>Page Plain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPagePlain()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_PLAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPagePlain() <em>Page Plain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPagePlain()
	 * @generated
	 * @ordered
	 */
	protected String pagePlain = PAGE_PLAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageHtml() <em>Page Html</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageHtml()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_HTML_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageHtml() <em>Page Html</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageHtml()
	 * @generated
	 * @ordered
	 */
	protected String pageHtml = PAGE_HTML_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutType()
	 * @generated
	 * @ordered
	 */
	protected LayoutType layoutType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPageSubject() {
		return pageSubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPageSubject(String newPageSubject) {
		String oldPageSubject = pageSubject;
		pageSubject = newPageSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.LAYOUT__PAGE_SUBJECT, oldPageSubject, pageSubject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPagePlain() {
		return pagePlain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPagePlain(String newPagePlain) {
		String oldPagePlain = pagePlain;
		pagePlain = newPagePlain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.LAYOUT__PAGE_PLAIN, oldPagePlain, pagePlain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPageHtml() {
		return pageHtml;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPageHtml(String newPageHtml) {
		String oldPageHtml = pageHtml;
		pageHtml = newPageHtml;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.LAYOUT__PAGE_HTML, oldPageHtml, pageHtml));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LayoutType getLayoutType() {
		if (layoutType != null && layoutType.eIsProxy()) {
			InternalEObject oldLayoutType = (InternalEObject)layoutType;
			layoutType = (LayoutType)eResolveProxy(oldLayoutType);
			if (layoutType != oldLayoutType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
			}
		}
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutType basicGetLayoutType() {
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setLayoutType(LayoutType newLayoutType) {
		LayoutType oldLayoutType = layoutType;
		layoutType = newLayoutType;
		
		setSubjectTemplate(newLayoutType.getSubjectTemplate());
		setPlainTemplate(newLayoutType.getPlainTemplate());
		setHtmlTemplate(newLayoutType.getHtmlTemplate());
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.LAYOUT__LAYOUT_TYPE, oldLayoutType, layoutType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.LAYOUT__PAGE_SUBJECT:
				return getPageSubject();
			case EmailPackage.LAYOUT__PAGE_PLAIN:
				return getPagePlain();
			case EmailPackage.LAYOUT__PAGE_HTML:
				return getPageHtml();
			case EmailPackage.LAYOUT__LAYOUT_TYPE:
				if (resolve) return getLayoutType();
				return basicGetLayoutType();
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
			case EmailPackage.LAYOUT__PAGE_SUBJECT:
				setPageSubject((String)newValue);
				return;
			case EmailPackage.LAYOUT__PAGE_PLAIN:
				setPagePlain((String)newValue);
				return;
			case EmailPackage.LAYOUT__PAGE_HTML:
				setPageHtml((String)newValue);
				return;
			case EmailPackage.LAYOUT__LAYOUT_TYPE:
				setLayoutType((LayoutType)newValue);
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
			case EmailPackage.LAYOUT__PAGE_SUBJECT:
				setPageSubject(PAGE_SUBJECT_EDEFAULT);
				return;
			case EmailPackage.LAYOUT__PAGE_PLAIN:
				setPagePlain(PAGE_PLAIN_EDEFAULT);
				return;
			case EmailPackage.LAYOUT__PAGE_HTML:
				setPageHtml(PAGE_HTML_EDEFAULT);
				return;
			case EmailPackage.LAYOUT__LAYOUT_TYPE:
				setLayoutType((LayoutType)null);
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
			case EmailPackage.LAYOUT__PAGE_SUBJECT:
				return PAGE_SUBJECT_EDEFAULT == null ? pageSubject != null : !PAGE_SUBJECT_EDEFAULT.equals(pageSubject);
			case EmailPackage.LAYOUT__PAGE_PLAIN:
				return PAGE_PLAIN_EDEFAULT == null ? pagePlain != null : !PAGE_PLAIN_EDEFAULT.equals(pagePlain);
			case EmailPackage.LAYOUT__PAGE_HTML:
				return PAGE_HTML_EDEFAULT == null ? pageHtml != null : !PAGE_HTML_EDEFAULT.equals(pageHtml);
			case EmailPackage.LAYOUT__LAYOUT_TYPE:
				return layoutType != null;
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
		result.append(" (pageSubject: ");
		result.append(pageSubject);
		result.append(", pagePlain: ");
		result.append(pagePlain);
		result.append(", pageHtml: ");
		result.append(pageHtml);
		result.append(')');
		return result.toString();
	}

} //LayoutImpl
