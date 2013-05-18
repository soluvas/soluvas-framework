/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Twitter Identity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains Twitter identity, which can be Twitter ID, screen name, or both.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.TwitterIdentity#getTwitterId <em>Twitter Id</em>}</li>
 *   <li>{@link org.soluvas.commons.TwitterIdentity#getTwitterScreenName <em>Twitter Screen Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getTwitterIdentity()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface TwitterIdentity extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Twitter Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Id</em>' attribute.
	 * @see #setTwitterId(Long)
	 * @see org.soluvas.commons.CommonsPackage#getTwitterIdentity_TwitterId()
	 * @model
	 * @generated
	 */
	Long getTwitterId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.TwitterIdentity#getTwitterId <em>Twitter Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Id</em>' attribute.
	 * @see #getTwitterId()
	 * @generated
	 */
	void setTwitterId(Long value);

	/**
	 * Returns the value of the '<em><b>Twitter Screen Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Screen Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Screen Name</em>' attribute.
	 * @see #setTwitterScreenName(String)
	 * @see org.soluvas.commons.CommonsPackage#getTwitterIdentity_TwitterScreenName()
	 * @model
	 * @generated
	 */
	String getTwitterScreenName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.TwitterIdentity#getTwitterScreenName <em>Twitter Screen Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Screen Name</em>' attribute.
	 * @see #getTwitterScreenName()
	 * @generated
	 */
	void setTwitterScreenName(String value);

} // TwitterIdentity
