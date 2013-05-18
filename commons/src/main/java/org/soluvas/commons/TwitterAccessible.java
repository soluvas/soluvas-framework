/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Twitter Accessible</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Supports Twitter Access Token and Access Token Secret, and therefore able to tweet, mention, or retweet.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.TwitterAccessible#getTwitterAccessToken <em>Twitter Access Token</em>}</li>
 *   <li>{@link org.soluvas.commons.TwitterAccessible#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getTwitterAccessible()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface TwitterAccessible extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Twitter Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Access Token</em>' attribute.
	 * @see #setTwitterAccessToken(String)
	 * @see org.soluvas.commons.CommonsPackage#getTwitterAccessible_TwitterAccessToken()
	 * @model
	 * @generated
	 */
	String getTwitterAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.TwitterAccessible#getTwitterAccessToken <em>Twitter Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Access Token</em>' attribute.
	 * @see #getTwitterAccessToken()
	 * @generated
	 */
	void setTwitterAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Access Token Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Access Token Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Access Token Secret</em>' attribute.
	 * @see #setTwitterAccessTokenSecret(String)
	 * @see org.soluvas.commons.CommonsPackage#getTwitterAccessible_TwitterAccessTokenSecret()
	 * @model
	 * @generated
	 */
	String getTwitterAccessTokenSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.TwitterAccessible#getTwitterAccessTokenSecret <em>Twitter Access Token Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Access Token Secret</em>' attribute.
	 * @see #getTwitterAccessTokenSecret()
	 * @generated
	 */
	void setTwitterAccessTokenSecret(String value);

} // TwitterAccessible
