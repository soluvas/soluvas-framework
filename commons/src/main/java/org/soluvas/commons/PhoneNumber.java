/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.joda.time.DateTime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Phone Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.PhoneNumber#getPhoneNumber <em>Phone Number</em>}</li>
 *   <li>{@link org.soluvas.commons.PhoneNumber#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.PhoneNumber#getValidationTime <em>Validation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getPhoneNumber()
 * @model
 * @generated
 */
public interface PhoneNumber extends EObject {
	/**
	 * Returns the value of the '<em><b>Phone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Number</em>' attribute.
	 * @see #setPhoneNumber(String)
	 * @see org.soluvas.commons.CommonsPackage#getPhoneNumber_PhoneNumber()
	 * @model required="true"
	 * @generated
	 */
	String getPhoneNumber();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PhoneNumber#getPhoneNumber <em>Phone Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone Number</em>' attribute.
	 * @see #getPhoneNumber()
	 * @generated
	 */
	void setPhoneNumber(String value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates this PhoneNumber as the primary PhoneNumber of the containing list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getPhoneNumber_Primary()
	 * @model default="false"
	 * @generated
	 */
	boolean isPrimary();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PhoneNumber#isPrimary <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' attribute.
	 * @see #isPrimary()
	 * @generated
	 */
	void setPrimary(boolean value);

	/**
	 * Returns the value of the '<em><b>Validation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When this phone number was validated by the user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Time</em>' attribute.
	 * @see #setValidationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getPhoneNumber_ValidationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getValidationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PhoneNumber#getValidationTime <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Time</em>' attribute.
	 * @see #getValidationTime()
	 * @generated
	 */
	void setValidationTime(DateTime value);

} // PhoneNumber
