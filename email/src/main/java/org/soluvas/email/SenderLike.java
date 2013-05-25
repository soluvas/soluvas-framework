/**
 */
package org.soluvas.email;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sender Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.email.SenderLike#getFrom <em>From</em>}</li>
 *   <li>{@link org.soluvas.email.SenderLike#getEmail <em>Email</em>}</li>
 *   <li>{@link org.soluvas.email.SenderLike#getReplyTo <em>Reply To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.email.EmailPackage#getSenderLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SenderLike extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Best practice is to put the company name as Sender's name, optionally suffixed with "Support" etc.
	 * 
	 * <p>Most notifications should consist only of company name. Actual conversations with support (i.e. tickets) would be suffixed with "Support".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(String)
	 * @see org.soluvas.email.EmailPackage#getSenderLike_From()
	 * @model
	 * @generated
	 */
	String getFrom();

	/**
	 * Sets the value of the '{@link org.soluvas.email.SenderLike#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(String value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Email address of the sender. This can be:
	 * 
	 * <ol>
	 * <li>a fully static text, e.g. "support@berbatik.com", very seldom used</li>
	 * <li>a variable, e.g. "{{{generalEmail}}}", most common</li>
	 * <li>a partial variable, e.g. "support@{{{appManifest.domain}}}", sometimes used</li>
	 * <li>multiple variables for randomly generated drop boxes, e.g. "{{{dropbox.code}}}@{{{postEmailDomain}}}" or "{{{dropbox.code}}}@post.{{{appManifest.domain}}}", which expands to "yummy234food@post.berbatik.com"</li>
	 * <li>a tracking address, e.g. "notification+mwkuhkji@facebookmail.com". Template is: "notification+{{{tracker.code}}}@notification.{{{appManifest.domain}}}" or "notification+{{{tracker.code}}}@{{{notificationEmailDomain}}}"</li>
	 * 
	 * <p>WARNING: A suffix like "+something" is not recommended for non-tracking emails, some mail servers like NameCheap email forwarding does not support it, and many email forms do not accept "+".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.soluvas.email.EmailPackage#getSenderLike_Email()
	 * @model
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.soluvas.email.SenderLike#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Reply To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply To</em>' attribute.
	 * @see #setReplyTo(String)
	 * @see org.soluvas.email.EmailPackage#getSenderLike_ReplyTo()
	 * @model
	 * @generated
	 */
	String getReplyTo();

	/**
	 * Sets the value of the '{@link org.soluvas.email.SenderLike#getReplyTo <em>Reply To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reply To</em>' attribute.
	 * @see #getReplyTo()
	 * @generated
	 */
	void setReplyTo(String value);

} // SenderLike
