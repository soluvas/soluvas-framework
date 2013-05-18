/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facebook Accessible</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains Facebook access token (which can expire anytime).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.FacebookAccessible#getFacebookAccessToken <em>Facebook Access Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getFacebookAccessible()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface FacebookAccessible extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Facebook Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Access Token</em>' attribute.
	 * @see #setFacebookAccessToken(String)
	 * @see org.soluvas.commons.CommonsPackage#getFacebookAccessible_FacebookAccessToken()
	 * @model
	 * @generated
	 */
	String getFacebookAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.FacebookAccessible#getFacebookAccessToken <em>Facebook Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Access Token</em>' attribute.
	 * @see #getFacebookAccessToken()
	 * @generated
	 */
	void setFacebookAccessToken(String value);

} // FacebookAccessible
