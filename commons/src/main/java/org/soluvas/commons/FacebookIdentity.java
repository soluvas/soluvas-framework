/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facebook Identity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains Facebook identity, which can be Facebook ID, username, or both.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.FacebookIdentity#getFacebookId <em>Facebook Id</em>}</li>
 *   <li>{@link org.soluvas.commons.FacebookIdentity#getFacebookUsername <em>Facebook Username</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getFacebookIdentity()
 * @model
 * @generated
 */
public interface FacebookIdentity extends EObject {
	/**
	 * Returns the value of the '<em><b>Facebook Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Id</em>' attribute.
	 * @see #setFacebookId(Long)
	 * @see org.soluvas.commons.CommonsPackage#getFacebookIdentity_FacebookId()
	 * @model
	 * @generated
	 */
	Long getFacebookId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.FacebookIdentity#getFacebookId <em>Facebook Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Id</em>' attribute.
	 * @see #getFacebookId()
	 * @generated
	 */
	void setFacebookId(Long value);

	/**
	 * Returns the value of the '<em><b>Facebook Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Username</em>' attribute.
	 * @see #setFacebookUsername(String)
	 * @see org.soluvas.commons.CommonsPackage#getFacebookIdentity_FacebookUsername()
	 * @model
	 * @generated
	 */
	String getFacebookUsername();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.FacebookIdentity#getFacebookUsername <em>Facebook Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Username</em>' attribute.
	 * @see #getFacebookUsername()
	 * @generated
	 */
	void setFacebookUsername(String value);

} // FacebookIdentity
