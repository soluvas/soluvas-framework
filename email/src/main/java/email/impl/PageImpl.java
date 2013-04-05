/**
 */
package email.impl;

import email.EmailPackage;
import email.Layout;
import email.Page;
import email.PageType;
import email.Recipient;
import email.Sender;

import java.util.List;

import javax.mail.Session;

import org.apache.commons.mail.Email;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link email.impl.PageImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link email.impl.PageImpl#getPageType <em>Page Type</em>}</li>
 *   <li>{@link email.impl.PageImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link email.impl.PageImpl#getMailSession <em>Mail Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PageImpl extends TemplateImpl implements Page {
	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected Layout layout;

	/**
	 * The cached value of the '{@link #getPageType() <em>Page Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageType()
	 * @generated
	 * @ordered
	 */
	protected PageType pageType;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected Sender sender;

	/**
	 * The default value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected static final Session MAIL_SESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected Session mailSession = MAIL_SESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout getLayout() {
		if (layout != null && ((EObject)layout).eIsProxy()) {
			InternalEObject oldLayout = (InternalEObject)layout;
			layout = (Layout)eResolveProxy(oldLayout);
			if (layout != oldLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__LAYOUT, oldLayout, layout));
			}
		}
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout basicGetLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayout(Layout newLayout) {
		Layout oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageType getPageType() {
		if (pageType != null && ((EObject)pageType).eIsProxy()) {
			InternalEObject oldPageType = (InternalEObject)pageType;
			pageType = (PageType)eResolveProxy(oldPageType);
			if (pageType != oldPageType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__PAGE_TYPE, oldPageType, pageType));
			}
		}
		return pageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageType basicGetPageType() {
		return pageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageType(PageType newPageType) {
		PageType oldPageType = pageType;
		pageType = newPageType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__PAGE_TYPE, oldPageType, pageType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sender getSender() {
		if (sender != null && ((EObject)sender).eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (Sender)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sender basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(Sender newSender) {
		Sender oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session getMailSession() {
		return mailSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailSession(Session newMailSession) {
		Session oldMailSession = mailSession;
		mailSession = newMailSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__MAIL_SESSION, oldMailSession, mailSession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Email compose(Recipient recipient) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Email> composeAll() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void attach(byte[] content, String fileName) {
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
			case EmailPackage.PAGE__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
			case EmailPackage.PAGE__PAGE_TYPE:
				if (resolve) return getPageType();
				return basicGetPageType();
			case EmailPackage.PAGE__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case EmailPackage.PAGE__MAIL_SESSION:
				return getMailSession();
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
			case EmailPackage.PAGE__LAYOUT:
				setLayout((Layout)newValue);
				return;
			case EmailPackage.PAGE__PAGE_TYPE:
				setPageType((PageType)newValue);
				return;
			case EmailPackage.PAGE__SENDER:
				setSender((Sender)newValue);
				return;
			case EmailPackage.PAGE__MAIL_SESSION:
				setMailSession((Session)newValue);
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
			case EmailPackage.PAGE__LAYOUT:
				setLayout((Layout)null);
				return;
			case EmailPackage.PAGE__PAGE_TYPE:
				setPageType((PageType)null);
				return;
			case EmailPackage.PAGE__SENDER:
				setSender((Sender)null);
				return;
			case EmailPackage.PAGE__MAIL_SESSION:
				setMailSession(MAIL_SESSION_EDEFAULT);
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
			case EmailPackage.PAGE__LAYOUT:
				return layout != null;
			case EmailPackage.PAGE__PAGE_TYPE:
				return pageType != null;
			case EmailPackage.PAGE__SENDER:
				return sender != null;
			case EmailPackage.PAGE__MAIL_SESSION:
				return MAIL_SESSION_EDEFAULT == null ? mailSession != null : !MAIL_SESSION_EDEFAULT.equals(mailSession);
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
		result.append(" (mailSession: ");
		result.append(mailSession);
		result.append(')');
		return result.toString();
	}

} //PageImpl
