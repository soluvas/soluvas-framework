/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressMonitorWrapper;
import org.soluvas.commons.ProgressStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Progress Monitor Wrapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.ProgressMonitorWrapperImpl#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgressMonitorWrapperImpl extends ProgressMonitorImpl implements ProgressMonitorWrapper {
	/**
	 * The cached value of the '{@link #getDelegate() <em>Delegate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegate()
	 * @generated
	 * @ordered
	 */
	protected ProgressMonitor delegate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressMonitorWrapperImpl() {
		super();
	}

	public ProgressMonitorWrapperImpl(ProgressMonitor monitor) {
		super();
		this.delegate = monitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PROGRESS_MONITOR_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProgressMonitor getDelegate() {
		if (delegate != null && ((EObject)delegate).eIsProxy()) {
			InternalEObject oldDelegate = (InternalEObject)delegate;
			delegate = (ProgressMonitor)eResolveProxy(oldDelegate);
			if (delegate != oldDelegate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonsPackage.PROGRESS_MONITOR_WRAPPER__DELEGATE, oldDelegate, delegate));
			}
		}
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressMonitor basicGetDelegate() {
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PROGRESS_MONITOR_WRAPPER__DELEGATE:
				if (resolve) return getDelegate();
				return basicGetDelegate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonsPackage.PROGRESS_MONITOR_WRAPPER__DELEGATE:
				return delegate != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void beginTask(String name, long totalWork) {
		if (delegate != null)
			delegate.beginTask(name, totalWork);
	}

	@Override
	public void internalWorked(double work) {
		if (delegate != null)
			delegate.internalWorked(work);
	}

	@Override
	public void done(ProgressStatus status) {
		if (delegate != null)
			delegate.done(status);
	}

	@Override
	public void worked(long work, ProgressStatus status) {
		if (delegate != null)
			delegate.worked(work, status);
	}

} //ProgressMonitorWrapperImpl
