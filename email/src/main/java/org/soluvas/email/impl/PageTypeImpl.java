/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.ecore.EClass;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;

import com.google.common.base.Preconditions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PageTypeImpl extends TemplateTypeImpl<Page> implements PageType {
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
	 */
	@Override
	public Page create(Layout layout) {
		Preconditions.checkNotNull(getEFactory(),
				"Cannot create Page %s because eFactory is null", getName());
		final Page target = (Page) getEFactory().create(getEClass());
		target.setPageType(this);
		target.setLayout(layout);
		return target;
	}

} //PageTypeImpl
