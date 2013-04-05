/**
 */
package email.impl;

import email.EmailPackage;
import email.Layout;
import email.Page;
import email.PageType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link email.impl.PageTypeImpl#getSenderTypeName <em>Sender Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageTypeImpl extends TemplateTypeImpl<Page> implements PageType {
	/**
	 * The default value of the '{@link #getSenderTypeName() <em>Sender Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String SENDER_TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSenderTypeName() <em>Sender Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderTypeName()
	 * @generated
	 * @ordered
	 */
	protected String senderTypeName = SENDER_TYPE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.PAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSenderTypeName() {
		return senderTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSenderTypeName(String newSenderTypeName) {
		String oldSenderTypeName = senderTypeName;
		senderTypeName = newSenderTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME, oldSenderTypeName, senderTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page create(Layout layout) {
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
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				return getSenderTypeName();
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
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				setSenderTypeName((String)newValue);
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
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				setSenderTypeName(SENDER_TYPE_NAME_EDEFAULT);
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
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				return SENDER_TYPE_NAME_EDEFAULT == null ? senderTypeName != null : !SENDER_TYPE_NAME_EDEFAULT.equals(senderTypeName);
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
		result.append(" (senderTypeName: ");
		result.append(senderTypeName);
		result.append(')');
		return result.toString();
	}

} //PageTypeImpl
