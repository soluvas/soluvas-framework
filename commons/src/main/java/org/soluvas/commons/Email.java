/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.joda.time.DateTime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Email</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Email#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.commons.Email#isPrimary <em>Primary</em>}</li>
 *   <li>{@link org.soluvas.commons.Email#getValidationTime <em>Validation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getEmail()
 * @model
 * @generated
 */
public interface Email extends EObject {
	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Must be normalized: lowercased, trimmed, and must not be null.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getEmail_Email()
	 * @model required="true"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Email#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates this Email as the primary Email of the containing list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(boolean)
	 * @see org.soluvas.commons.CommonsPackage#getEmail_Primary()
	 * @model default="false"
	 * @generated
	 */
	boolean isPrimary();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Email#isPrimary <em>Primary</em>}' attribute.
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
	 * When this email was validated by the user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Time</em>' attribute.
	 * @see #setValidationTime(DateTime)
	 * @see org.soluvas.commons.CommonsPackage#getEmail_ValidationTime()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getValidationTime();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Email#getValidationTime <em>Validation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Time</em>' attribute.
	 * @see #getValidationTime()
	 * @generated
	 */
	void setValidationTime(DateTime value);

} // Email
