/**
 */
package org.soluvas.email.builtin.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.email.builtin.BuiltinPackage;
import org.soluvas.email.builtin.Contact;
import org.soluvas.email.builtin.FeedbackToAdmin;
import org.soluvas.email.builtin.FeedbackToAdminManager;
import org.soluvas.email.impl.PageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feedback To Admin Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.builtin.impl.FeedbackToAdminManagerImpl#getContact <em>Contact</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeedbackToAdminManagerImpl extends PageImpl implements FeedbackToAdminManager {
	/**
	 * The cached value of the '{@link #getContact() <em>Contact</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContact()
	 * @generated
	 * @ordered
	 */
	protected Contact contact;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedbackToAdminManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuiltinPackage.Literals.FEEDBACK_TO_ADMIN_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contact getContact() {
		if (contact != null && ((EObject)contact).eIsProxy()) {
			InternalEObject oldContact = (InternalEObject)contact;
			contact = (Contact)eResolveProxy(oldContact);
			if (contact != oldContact) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT, oldContact, contact));
			}
		}
		return contact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact basicGetContact() {
		return contact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContact(Contact newContact) {
		Contact oldContact = contact;
		contact = newContact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT, oldContact, contact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT:
				if (resolve) return getContact();
				return basicGetContact();
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
			case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT:
				setContact((Contact)newValue);
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
			case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT:
				setContact((Contact)null);
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
			case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT:
				return contact != null;
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
		if (baseClass == FeedbackToAdmin.class) {
			switch (derivedFeatureID) {
				case BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT: return BuiltinPackage.FEEDBACK_TO_ADMIN__CONTACT;
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
		if (baseClass == FeedbackToAdmin.class) {
			switch (baseFeatureID) {
				case BuiltinPackage.FEEDBACK_TO_ADMIN__CONTACT: return BuiltinPackage.FEEDBACK_TO_ADMIN_MANAGER__CONTACT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FeedbackToAdminManagerImpl
