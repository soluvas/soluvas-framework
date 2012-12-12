/**
 */
package org.soluvas.email.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.LayoutType;
import org.soluvas.email.PageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailCatalogImpl#getLayouts <em>Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmailCatalogImpl extends EObjectImpl implements EmailCatalog {
	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<PageType> pages;

	/**
	 * The cached value of the '{@link #getLayouts() <em>Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<LayoutType> layouts;

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
	public EList<PageType> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<PageType>(PageType.class, this, EmailPackage.EMAIL_CATALOG__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayoutType> getLayouts() {
		if (layouts == null) {
			layouts = new EObjectContainmentEList<LayoutType>(LayoutType.class, this, EmailPackage.EMAIL_CATALOG__LAYOUTS);
		}
		return layouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmailPackage.EMAIL_CATALOG__PAGES:
				return ((InternalEList<?>)getPages()).basicRemove(otherEnd, msgs);
			case EmailPackage.EMAIL_CATALOG__LAYOUTS:
				return ((InternalEList<?>)getLayouts()).basicRemove(otherEnd, msgs);
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
			case EmailPackage.EMAIL_CATALOG__PAGES:
				return getPages();
			case EmailPackage.EMAIL_CATALOG__LAYOUTS:
				return getLayouts();
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
			case EmailPackage.EMAIL_CATALOG__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends PageType>)newValue);
				return;
			case EmailPackage.EMAIL_CATALOG__LAYOUTS:
				getLayouts().clear();
				getLayouts().addAll((Collection<? extends LayoutType>)newValue);
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
			case EmailPackage.EMAIL_CATALOG__PAGES:
				getPages().clear();
				return;
			case EmailPackage.EMAIL_CATALOG__LAYOUTS:
				getLayouts().clear();
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
			case EmailPackage.EMAIL_CATALOG__PAGES:
				return pages != null && !pages.isEmpty();
			case EmailPackage.EMAIL_CATALOG__LAYOUTS:
				return layouts != null && !layouts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EmailCatalogImpl
