/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.ecore.EClass;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EmailPackage.LAYOUT_TYPE___CREATE:
				return create();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LayoutTypeImpl
