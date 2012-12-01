/**
 */
package org.soluvas.commons;

import org.joda.time.DateTime;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timestamped</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Can be used by any EObject that wants to preserve creationTime/modificationTime.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Timestamped#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.soluvas.commons.Timestamped#getModificationTime <em>Modification Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getTimestamped()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Timestamped extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * First creation time (raw).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #setCreationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getTimestamped_CreationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getCreationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Timestamped#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(DateTime value);

	/**
	 * Returns the value of the '<em><b>Modification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Last modification time (raw).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Modification Time</em>' attribute.
	 * @see #setModificationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getTimestamped_ModificationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getModificationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Timestamped#getModificationTime <em>Modification Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modification Time</em>' attribute.
	 * @see #getModificationTime()
	 * @generated
	 */
	void setModificationTime(DateTime value);

} // Timestamped
