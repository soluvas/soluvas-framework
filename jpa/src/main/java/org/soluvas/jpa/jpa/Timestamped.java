package org.soluvas.jpa.jpa;

import org.joda.time.DateTime;

/**
 * A representation of the model object '<em><b>Timestamped</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public interface Timestamped {
	/**
	 * Returns the value of '<em><b>creationTime</em></b>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>creationTime</b></em>' feature
	 * @generated
	 */
	public DateTime getCreationTime();

	/**
	 * Sets the '{@link Timestamped#getCreationTime() <em>creationTime</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newCreationTime
	 *            the new value of the '{@link Timestamped#getCreationTime()
	 *            <em>creationTime</em>}' feature.
	 * @generated
	 */
	public void setCreationTime(DateTime newCreationTime);

	/**
	 * Returns the value of '<em><b>modificationTime</em></b>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>modificationTime</b></em>' feature
	 * @generated
	 */
	public DateTime getModificationTime();

	/**
	 * Sets the '{@link Timestamped#getModificationTime()
	 * <em>modificationTime</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newModificationTime
	 *            the new value of the '{@link Timestamped#getModificationTime()
	 *            <em>modificationTime</em>}' feature.
	 * @generated
	 */
	public void setModificationTime(DateTime newModificationTime);

}
