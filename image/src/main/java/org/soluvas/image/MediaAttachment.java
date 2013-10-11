/**
 */
package org.soluvas.image;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.image.impl.MediaAttachmentImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Media Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.MediaAttachment#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.MediaAttachment#getRevPos <em>Rev Pos</em>}</li>
 *   <li>{@link org.soluvas.image.MediaAttachment#getDigest <em>Digest</em>}</li>
 *   <li>{@link org.soluvas.image.MediaAttachment#getLength <em>Length</em>}</li>
 *   <li>{@link org.soluvas.image.MediaAttachment#isStub <em>Stub</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getMediaAttachment()
 * @model
 * @generated
 */
@JsonDeserialize(as=MediaAttachmentImpl.class)
public interface MediaAttachment extends EObject {
	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Content type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.soluvas.image.ImagePackage#getMediaAttachment_ContentType()
	 * @model required="true"
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.soluvas.image.MediaAttachment#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Rev Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rev Pos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rev Pos</em>' attribute.
	 * @see #setRevPos(long)
	 * @see org.soluvas.image.ImagePackage#getMediaAttachment_RevPos()
	 * @model
	 * @generated
	 */
	long getRevPos();

	/**
	 * Sets the value of the '{@link org.soluvas.image.MediaAttachment#getRevPos <em>Rev Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rev Pos</em>' attribute.
	 * @see #getRevPos()
	 * @generated
	 */
	void setRevPos(long value);

	/**
	 * Returns the value of the '<em><b>Digest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Digest, usually MD5 then base64 encoded, e.g. "md5-kowj0TKpx2GdcR1zV9O11w=="
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Digest</em>' attribute.
	 * @see #setDigest(String)
	 * @see org.soluvas.image.ImagePackage#getMediaAttachment_Digest()
	 * @model
	 * @generated
	 */
	String getDigest();

	/**
	 * Sets the value of the '{@link org.soluvas.image.MediaAttachment#getDigest <em>Digest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Digest</em>' attribute.
	 * @see #getDigest()
	 * @generated
	 */
	void setDigest(String value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(long)
	 * @see org.soluvas.image.ImagePackage#getMediaAttachment_Length()
	 * @model
	 * @generated
	 */
	long getLength();

	/**
	 * Sets the value of the '{@link org.soluvas.image.MediaAttachment#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(long value);

	/**
	 * Returns the value of the '<em><b>Stub</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Usually true, meaning the attachment content is not included in this object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stub</em>' attribute.
	 * @see #setStub(boolean)
	 * @see org.soluvas.image.ImagePackage#getMediaAttachment_Stub()
	 * @model
	 * @generated
	 */
	boolean isStub();

	/**
	 * Sets the value of the '{@link org.soluvas.image.MediaAttachment#isStub <em>Stub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stub</em>' attribute.
	 * @see #isStub()
	 * @generated
	 */
	void setStub(boolean value);

} // MediaAttachment
