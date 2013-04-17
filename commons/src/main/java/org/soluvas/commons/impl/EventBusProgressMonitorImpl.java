/**
 */
package org.soluvas.commons.impl;

import org.eclipse.emf.ecore.EClass;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EventBusProgressMonitor;
import org.soluvas.commons.MonitorDone;
import org.soluvas.commons.MonitorProgressed;
import org.soluvas.commons.ProgressStatus;

import com.google.common.eventbus.EventBus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Bus Progress Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.commons.impl.EventBusProgressMonitorImpl#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link org.soluvas.commons.impl.EventBusProgressMonitorImpl#getTrackingId <em>Tracking Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBusProgressMonitorImpl extends ProgressMonitorImpl implements EventBusProgressMonitor {
	
	protected double totalWork = 100.0;
	protected double worked = 0.0;
	protected DateTime startTime;
	protected Long lastRenderTime;
	protected String name;
	
	/**
	 * The default value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventBus()
	 * @generated
	 * @ordered
	 */
	protected static final EventBus EVENT_BUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventBus()
	 * @generated
	 * @ordered
	 */
	protected EventBus eventBus = EVENT_BUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrackingId() <em>Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrackingId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACKING_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrackingId() <em>Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrackingId()
	 * @generated
	 * @ordered
	 */
	protected String trackingId = TRACKING_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBusProgressMonitorImpl() {
		super();
	}
	
	public EventBusProgressMonitorImpl(EventBus eventBus, String trackingId) {
		super();
		this.eventBus = eventBus;
		this.trackingId = trackingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.EVENT_BUS_PROGRESS_MONITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonsPackage.EVENT_BUS_PROGRESS_MONITOR__EVENT_BUS:
				return getEventBus();
			case CommonsPackage.EVENT_BUS_PROGRESS_MONITOR__TRACKING_ID:
				return getTrackingId();
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
			case CommonsPackage.EVENT_BUS_PROGRESS_MONITOR__EVENT_BUS:
				return EVENT_BUS_EDEFAULT == null ? eventBus != null : !EVENT_BUS_EDEFAULT.equals(eventBus);
			case CommonsPackage.EVENT_BUS_PROGRESS_MONITOR__TRACKING_ID:
				return TRACKING_ID_EDEFAULT == null ? trackingId != null : !TRACKING_ID_EDEFAULT.equals(trackingId);
		}
		return super.eIsSet(featureID);
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
		result.append(" (eventBus: ");
		result.append(eventBus);
		result.append(", trackingId: ");
		result.append(trackingId);
		result.append(')');
		return result.toString();
	}

	@Override
	public void beginTask(String name, long totalWork) {
		this.name = name;
		this.worked = 0.0d;
		this.totalWork = totalWork;
		this.startTime = new DateTime();
		renderProgressBar();
	}

	@Override
	public void internalWorked(double work) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done(ProgressStatus status) {
		eventBus.post(new MonitorDone(trackingId, status));
	}

	protected synchronized void renderProgressBar() {
		final int totalBlocks = 19;
		final int blocksWorked = Math.min((int)(worked / totalWork * totalBlocks), totalBlocks);
		final int blocksUnworked = Math.min(totalBlocks - blocksWorked, totalBlocks);
		final double percentage = Math.min(worked / totalWork * 100d, 100d);
		final Period elapsed = new Period(startTime, new DateTime());
		
		eventBus.post(new MonitorProgressed(trackingId, worked, totalWork, name));
		
		lastRenderTime = System.currentTimeMillis();
	}

	@Override
	public void worked(long work, ProgressStatus status) {
		worked = worked + work;
		// only render after 100ms has elapsed, so won't slow down operation
		if (lastRenderTime == null || System.currentTimeMillis() - lastRenderTime >= 100) {
			renderProgressBar();
		}
	}
	
	@Override
	public void subTask(String name) {
		this.name = name;
		// only render after 100ms has elapsed, so won't slow down operation
		if (lastRenderTime == null || System.currentTimeMillis() - lastRenderTime >= 100) {
			renderProgressBar();
		}
	}

} //EventBusProgressMonitorImpl
