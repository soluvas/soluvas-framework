/**
 */
package org.soluvas.commons.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Progress Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.ProgressMonitorImpl#isCanceled <em>Canceled</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.ProgressMonitorImpl#getTaskName <em>Task Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public abstract class ProgressMonitorImpl extends MinimalEObjectImpl.Container implements ProgressMonitor {
	
	private static final Logger log = LoggerFactory
			.getLogger(ProgressMonitorImpl.class);
	
	/**
	 * <p>Converts an unknown (possibly null) IProgressMonitor into a SubMonitor allocated
	 * with the given number of ticks. It is not necessary to call done() on the result,
	 * but the caller is responsible for calling done() on the argument. Calls beginTask
	 * on the argument.</p>
	 * 
	 * <p>This method should generally be called at the beginning of a method that accepts
	 * an IProgressMonitor in order to convert the IProgressMonitor into a SubMonitor.</p> 
	 * 
	 * @param monitor monitor to convert to a SubMonitor instance or null. Treats null
	 * as a new instance of <code>NullProgressMonitor</code>.
	 * @param work number of ticks that will be available in the resulting monitor
	 * @return a SubMonitor instance that adapts the argument
	 */
	public static ProgressMonitor convert(ProgressMonitor monitor, int work) {
		return new ProgressMonitorWrapperImpl(monitor);
	}
	
	/**
	 * The default value of the '{@link #isCanceled() <em>Canceled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanceled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CANCELED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanceled() <em>Canceled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanceled()
	 * @generated
	 * @ordered
	 */
	protected boolean canceled = CANCELED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected static final String TASK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskName() <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskName()
	 * @generated
	 * @ordered
	 */
	protected String taskName = TASK_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressMonitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.PROGRESS_MONITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCanceled() {
		return canceled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCanceled(boolean newCanceled) {
		boolean oldCanceled = canceled;
		canceled = newCanceled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PROGRESS_MONITOR__CANCELED, oldCanceled, canceled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTaskName() {
		return taskName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaskName(String newTaskName) {
		String oldTaskName = taskName;
		taskName = newTaskName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PROGRESS_MONITOR__TASK_NAME, oldTaskName, taskName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void beginTask(String name, long totalWork);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public final void done() {
		done(ProgressStatus.OK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void internalWorked(double work);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void subTask(String name) {
		log.warn("Unsupported subTask {}", name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public final void worked(long work) {
		worked(work, ProgressStatus.OK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void done(ProgressStatus status);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public abstract void worked(long work, ProgressStatus status);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.PROGRESS_MONITOR__CANCELED:
				return isCanceled();
			case CommonsPackage.PROGRESS_MONITOR__TASK_NAME:
				return getTaskName();
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
			case CommonsPackage.PROGRESS_MONITOR__CANCELED:
				setCanceled((Boolean)newValue);
				return;
			case CommonsPackage.PROGRESS_MONITOR__TASK_NAME:
				setTaskName((String)newValue);
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
			case CommonsPackage.PROGRESS_MONITOR__CANCELED:
				setCanceled(CANCELED_EDEFAULT);
				return;
			case CommonsPackage.PROGRESS_MONITOR__TASK_NAME:
				setTaskName(TASK_NAME_EDEFAULT);
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
			case CommonsPackage.PROGRESS_MONITOR__CANCELED:
				return canceled != CANCELED_EDEFAULT;
			case CommonsPackage.PROGRESS_MONITOR__TASK_NAME:
				return TASK_NAME_EDEFAULT == null ? taskName != null : !TASK_NAME_EDEFAULT.equals(taskName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CommonsPackage.PROGRESS_MONITOR___BEGIN_TASK__STRING_LONG:
				beginTask((String)arguments.get(0), (Long)arguments.get(1));
				return null;
			case CommonsPackage.PROGRESS_MONITOR___DONE:
				done();
				return null;
			case CommonsPackage.PROGRESS_MONITOR___INTERNAL_WORKED__DOUBLE:
				internalWorked((Double)arguments.get(0));
				return null;
			case CommonsPackage.PROGRESS_MONITOR___SUB_TASK__STRING:
				subTask((String)arguments.get(0));
				return null;
			case CommonsPackage.PROGRESS_MONITOR___WORKED__LONG:
				worked((Long)arguments.get(0));
				return null;
			case CommonsPackage.PROGRESS_MONITOR___DONE__PROGRESSSTATUS:
				done((ProgressStatus)arguments.get(0));
				return null;
			case CommonsPackage.PROGRESS_MONITOR___WORKED__LONG_PROGRESSSTATUS:
				worked((Long)arguments.get(0), (ProgressStatus)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (canceled: ");
		result.append(canceled);
		result.append(", taskName: ");
		result.append(taskName);
		result.append(')');
		return result.toString();
	}

} //ProgressMonitorImpl
