/**
 */
package com.soluvas.story.builtin;

import org.eclipse.emf.ecore.EObject;
import org.joda.time.DateTime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Trackable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.builtin.TimeTrackable#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link com.soluvas.story.builtin.TimeTrackable#getEndTime <em>End Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.builtin.BuiltinPackage#getTimeTrackable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TimeTrackable extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When the action begins
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(DateTime)
	 * @see com.soluvas.story.builtin.BuiltinPackage#getTimeTrackable_StartTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getStartTime();

	/**
	 * Sets the value of the '{@link com.soluvas.story.builtin.TimeTrackable#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When the action finishes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(DateTime)
	 * @see com.soluvas.story.builtin.BuiltinPackage#getTimeTrackable_EndTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getEndTime();

	/**
	 * Sets the value of the '{@link com.soluvas.story.builtin.TimeTrackable#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(DateTime value);

} // TimeTrackable
