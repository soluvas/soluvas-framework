/**
 */
package org.soluvas.commons.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.CustomerRoleCatalog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Role Catalog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.CustomerRoleCatalogImpl#getCustomerRoles <em>Customer Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerRoleCatalogImpl extends MinimalEObjectImpl.Container implements CustomerRoleCatalog {
	/**
	 * The cached value of the '{@link #getCustomerRoles() <em>Customer Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomerRole> customerRoles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerRoleCatalogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.CUSTOMER_ROLE_CATALOG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CustomerRole> getCustomerRoles() {
		if (customerRoles == null) {
			customerRoles = new EObjectContainmentEList<CustomerRole>(CustomerRole.class, this, CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES);
		}
		return customerRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES:
				return ((InternalEList<?>)getCustomerRoles()).basicRemove(otherEnd, msgs);
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
			case CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES:
				return getCustomerRoles();
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
			case CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES:
				getCustomerRoles().clear();
				getCustomerRoles().addAll((Collection<? extends CustomerRole>)newValue);
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
			case CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES:
				getCustomerRoles().clear();
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
			case CommonsPackage.CUSTOMER_ROLE_CATALOG__CUSTOMER_ROLES:
				return customerRoles != null && !customerRoles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CustomerRoleCatalogImpl
