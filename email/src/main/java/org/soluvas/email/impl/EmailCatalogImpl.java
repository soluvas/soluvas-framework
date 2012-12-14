/**
 */
package org.soluvas.email.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.LayoutType;
import org.soluvas.email.PageType;
import org.soluvas.email.SenderType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getPageTypes <em>Page Types</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getLayoutTypes <em>Layout Types</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getSenderTypes <em>Sender Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmailCatalogImpl extends EObjectImpl implements EmailCatalog {
	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPageTypes() <em>Page Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<PageType> pageTypes;

	/**
	 * The cached value of the '{@link #getLayoutTypes() <em>Layout Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<LayoutType> layoutTypes;

	/**
	 * The cached value of the '{@link #getSenderTypes() <em>Sender Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SenderType> senderTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.EMAIL_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.EMAIL_CATALOG__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageType> getPageTypes() {
		if (pageTypes == null) {
			pageTypes = new EObjectContainmentEList<PageType>(PageType.class, this, EmailPackage.EMAIL_CATALOG__PAGE_TYPES);
		}
		return pageTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayoutType> getLayoutTypes() {
		if (layoutTypes == null) {
			layoutTypes = new EObjectContainmentEList<LayoutType>(LayoutType.class, this, EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES);
		}
		return layoutTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SenderType> getSenderTypes() {
		if (senderTypes == null) {
			senderTypes = new EObjectContainmentEList<SenderType>(SenderType.class, this, EmailPackage.EMAIL_CATALOG__SENDER_TYPES);
		}
		return senderTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmailPackage.EMAIL_CATALOG__PAGE_TYPES:
				return ((InternalEList<?>)getPageTypes()).basicRemove(otherEnd, msgs);
			case EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES:
				return ((InternalEList<?>)getLayoutTypes()).basicRemove(otherEnd, msgs);
			case EmailPackage.EMAIL_CATALOG__SENDER_TYPES:
				return ((InternalEList<?>)getSenderTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.EMAIL_CATALOG__NS_PREFIX:
				return getNsPrefix();
			case EmailPackage.EMAIL_CATALOG__PAGE_TYPES:
				return getPageTypes();
			case EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES:
				return getLayoutTypes();
			case EmailPackage.EMAIL_CATALOG__SENDER_TYPES:
				return getSenderTypes();
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
			case EmailPackage.EMAIL_CATALOG__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case EmailPackage.EMAIL_CATALOG__PAGE_TYPES:
				getPageTypes().clear();
				getPageTypes().addAll((Collection<? extends PageType>)newValue);
				return;
			case EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES:
				getLayoutTypes().clear();
				getLayoutTypes().addAll((Collection<? extends LayoutType>)newValue);
				return;
			case EmailPackage.EMAIL_CATALOG__SENDER_TYPES:
				getSenderTypes().clear();
				getSenderTypes().addAll((Collection<? extends SenderType>)newValue);
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
			case EmailPackage.EMAIL_CATALOG__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case EmailPackage.EMAIL_CATALOG__PAGE_TYPES:
				getPageTypes().clear();
				return;
			case EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES:
				getLayoutTypes().clear();
				return;
			case EmailPackage.EMAIL_CATALOG__SENDER_TYPES:
				getSenderTypes().clear();
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
			case EmailPackage.EMAIL_CATALOG__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case EmailPackage.EMAIL_CATALOG__PAGE_TYPES:
				return pageTypes != null && !pageTypes.isEmpty();
			case EmailPackage.EMAIL_CATALOG__LAYOUT_TYPES:
				return layoutTypes != null && !layoutTypes.isEmpty();
			case EmailPackage.EMAIL_CATALOG__SENDER_TYPES:
				return senderTypes != null && !senderTypes.isEmpty();
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
		result.append(" (nsPrefix: ");
		result.append(nsPrefix);
		result.append(')');
		return result.toString();
	}

} //EmailCatalogImpl
