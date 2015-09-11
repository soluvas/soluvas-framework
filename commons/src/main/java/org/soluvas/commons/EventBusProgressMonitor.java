/**
 */
package org.soluvas.commons;

import com.google.common.eventbus.EventBus;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Bus Progress Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Use Guava EventBus to report progress.
 * Can be used to implement web-based progress bar.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.EventBusProgressMonitor#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link org.soluvas.commons.EventBusProgressMonitor#getTrackingId <em>Tracking Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getEventBusProgressMonitor()
 * @model
 * @generated
 */
public interface EventBusProgressMonitor extends ProgressMonitor {
	/**
	 * Returns the value of the '<em><b>Event Bus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Bus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Bus</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getEventBusProgressMonitor_EventBus()
	 * @model dataType="org.soluvas.commons.EventBus" transient="true" changeable="false"
	 * @generated
	 */
	EventBus getEventBus();

	/**
	 * Returns the value of the '<em><b>Tracking Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tracking Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tracking Id</em>' attribute.
	 * @see org.soluvas.commons.CommonsPackage#getEventBusProgressMonitor_TrackingId()
	 * @model changeable="false"
	 * @generated
	 */
	String getTrackingId();

} // EventBusProgressMonitor
