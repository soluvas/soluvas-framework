/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Progress Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  * The <code>IProgressMonitor</code> interface is implemented
 *  * by objects that monitor the progress of an activity; the methods
 *  * in this interface are invoked by code that performs the activity.
 *  * <p>
 *  * All activity is broken down into a linear sequence of tasks against
 *  * which progress is reported. When a task begins, a <code>beginTask(String, int)
 *  * </code> notification is reported, followed by any number and mixture of 
 *  * progress reports (<code>worked()</code>) and subtask notifications 
 *  * (<code>subTask(String)</code>).  When the task is eventually completed, a 
 *  * <code>done()</code> notification is reported.  After the <code>done()</code>
 *  * notification, the progress monitor cannot be reused;  i.e., <code>
 *  * beginTask(String, int)</code> cannot be called again after the call to 
 *  * <code>done()</code>.
 *  * </p>
 *  * <p>
 *  * A request to cancel an operation can be signaled using the 
 *  * <code>setCanceled</code> method.  Operations taking a progress
 *  * monitor are expected to poll the monitor (using <code>isCanceled</code>)
 *  * periodically and abort at their earliest convenience.  Operation can however 
 *  * choose to ignore cancelation requests.
 *  * </p>
 *  * <p>
 *  * Since notification is synchronous with the activity itself, the listener should 
 *  * provide a fast and robust implementation. If the handling of notifications would 
 *  * involve blocking operations, or operations which might throw uncaught exceptions, 
 *  * the notifications should be queued, and the actual processing deferred (or perhaps
 *  * delegated to a separate thread).
 *  * </p><p>
 *  * This interface can be used without OSGi running.
 *  * </p><p>
 *  * Clients may implement this interface.
 *  * </p>
 * 
 * 
 * Inspired by: org.eclipse.core.runtime.IProgressMonitor
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.ProgressMonitor#isCanceled <em>Canceled</em>}</li>
 *   <li>{@link org.soluvas.commons.ProgressMonitor#getTaskName <em>Task Name</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getProgressMonitor()
 * @model abstract="true"
 * @generated
 */
public interface ProgressMonitor extends EObject {
	
	/**
	 * Returns the value of the '<em><b>Canceled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 	 * Returns whether cancelation of current operation has been requested.
	 * 	 * Long-running operations should poll to see if cancelation
	 * 	 * has been requested.
	 * 	 *
	 * 	 * @return <code>true</code> if cancellation has been requested,
	 * 	 *    and <code>false</code> otherwise
	 * 	 * @see #setCanceled(boolean)
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Canceled</em>' attribute.
	 * @see #setCanceled(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getProgressMonitor_Canceled()
	 * @model
	 * @generated
	 */
	boolean isCanceled();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ProgressMonitor#isCanceled <em>Canceled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Canceled</em>' attribute.
	 * @see #isCanceled()
	 * @generated
	 */
	void setCanceled(boolean value);

	/**
	 * Returns the value of the '<em><b>Task Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 	 * Sets the task name to the given value. This method is used to 
	 * 	 * restore the task label after a nested operation was executed. 
	 * 	 * Normally there is no need for clients to call this method.
	 * 	 *
	 * 	 * @param name the name (or description) of the main task
	 * 	 * @see #beginTask(java.lang.String, int)
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Task Name</em>' attribute.
	 * @see #setTaskName(String)
	 * @see org.soluvas.commons.CommonsPackage#getProgressMonitor_TaskName()
	 * @model
	 * @generated
	 */
	String getTaskName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ProgressMonitor#getTaskName <em>Task Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Name</em>' attribute.
	 * @see #getTaskName()
	 * @generated
	 */
	void setTaskName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 	 * Notifies that the main task is beginning.  This must only be called once
	 * 	 * on a given progress monitor instance.
	 * 	 * 
	 * 	 * @param name the name (or description) of the main task
	 * 	 * @param totalWork the total number of work units into which
	 * 	 *  the main task is been subdivided. If the value is <code>UNKNOWN</code> 
	 * 	 *  the implementation is free to indicate progress in a way which 
	 * 	 *  doesn't require the total number of work units in advance.
	 * 
	 * TODO: support formatting in the task name, probably using HTML5 or RDFa, which will be converted (in shell) into ANSI codes.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void beginTask(String name, long totalWork);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 	 * Notifies that the work is done; that is, either the main task is completed 
	 * 	 * or the user canceled it. This method may be called more than once 
	 * 	 * (implementations should be prepared to handle this case).
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void done();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 	 * Internal method to handle scaling correctly. This method
	 * 	 * must not be called by a client. Clients should 
	 * 	 * always use the method </code>worked(int)</code>.
	 * 	 * 
	 * 	 * @param work the amount of work done
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void internalWorked(double work);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void subTask(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void worked(long work);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void done(ProgressStatus status);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void worked(long work, ProgressStatus status);

} // ProgressMonitor
