/**
 */
package email;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sender</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Sender information. Mustache variables are supported.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link email.Sender#getSenderType <em>Sender Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see email.EmailPackage#getSender()
 * @model
 * @generated
 */
public interface Sender extends SenderLike, DefaultScope {
	/**
	 * Returns the value of the '<em><b>Sender Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender Type</em>' reference.
	 * @see #setSenderType(SenderType)
	 * @see email.EmailPackage#getSender_SenderType()
	 * @model required="true"
	 * @generated
	 */
	SenderType getSenderType();

	/**
	 * Sets the value of the '{@link email.Sender#getSenderType <em>Sender Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender Type</em>' reference.
	 * @see #getSenderType()
	 * @generated
	 */
	void setSenderType(SenderType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expand the Mustache templates.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void expand();

} // Sender
