/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Progress Monitor Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  * An abstract wrapper around a progress monitor which,
 *  * unless overridden, forwards <code>IProgressMonitor</code>
 *  * and <code>IProgressMonitorWithBlocking</code> methods to the wrapped progress monitor.
 *  * <p>
 *  * This class can be used without OSGi running.
 *  * </p><p>
 *  * Clients may subclass.
 *  * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.ProgressMonitorWrapper#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getProgressMonitorWrapper()
 * @model
 * @generated
 */
public interface ProgressMonitorWrapper extends ProgressMonitor {
	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate</em>' reference.
	 * @see org.soluvas.commons.CommonsPackage#getProgressMonitorWrapper_Delegate()
	 * @model changeable="false"
	 * @generated
	 */
	ProgressMonitor getDelegate();

} // ProgressMonitorWrapper
