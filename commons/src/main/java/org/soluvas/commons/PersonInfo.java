/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PersonInfo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Person partial value object that is stored in Graph database (usually Neo4j) or embedded in a MongoDB document.
 * 
 * The ID is Directory entry uid attribute.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.PersonInfo#getGender <em>Gender</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.commons.PersonInfo#getMobileNumber <em>Mobile Number</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getPersonInfo()
 * @model
 * @generated
 */
public interface PersonInfo extends Identifiable, PhotoIdContainer, Sluggable, NameContainer, PersonLike {
	/**
	 * Returns the value of the '<em><b>Gender</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.Gender}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #setGender(Gender)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Gender()
	 * @model
	 * @generated
	 */
	Gender getGender();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getGender <em>Gender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gender</em>' attribute.
	 * @see org.soluvas.commons.Gender
	 * @see #getGender()
	 * @generated
	 */
	void setGender(Gender value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_Email()
	 * @model
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Mobile Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mobile Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mobile Number</em>' attribute.
	 * @see #setMobileNumber(String)
	 * @see org.soluvas.commons.CommonsPackage#getPersonInfo_MobileNumber()
	 * @model
	 * @generated
	 */
	String getMobileNumber();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PersonInfo#getMobileNumber <em>Mobile Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mobile Number</em>' attribute.
	 * @see #getMobileNumber()
	 * @generated
	 */
	void setMobileNumber(String value);

} // PersonInfo
