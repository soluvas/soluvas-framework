/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.ecore.EClass;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;

import com.google.common.base.Preconditions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LayoutTypeImpl extends TemplateTypeImpl<Layout> implements LayoutType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.LAYOUT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Layout create() {
		Preconditions.checkNotNull(getEFactory(),
				"Cannot create Layout %s because eFactory is null", getName());
		final Layout target = (Layout) getEFactory().create(getEClass());
		target.setLayoutType(this);
		return target;
	}

} //LayoutTypeImpl
