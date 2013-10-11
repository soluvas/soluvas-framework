/**
 */
package org.soluvas.image.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.MediaAttachment;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Media Attachment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.MediaAttachmentImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.impl.MediaAttachmentImpl#getRevPos <em>Rev Pos</em>}</li>
 *   <li>{@link org.soluvas.image.impl.MediaAttachmentImpl#getDigest <em>Digest</em>}</li>
 *   <li>{@link org.soluvas.image.impl.MediaAttachmentImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.soluvas.image.impl.MediaAttachmentImpl#isStub <em>Stub</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MediaAttachmentImpl extends EObjectImpl implements MediaAttachment {
	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("content_type")
	protected String contentType = CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRevPos() <em>Rev Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevPos()
	 * @generated
	 * @ordered
	 */
	protected static final long REV_POS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRevPos() <em>Rev Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevPos()
	 * @generated
	 * @ordered
	 */
	@JsonProperty("revpos")
	protected long revPos = REV_POS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDigest() <em>Digest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDigest()
	 * @generated
	 * @ordered
	 */
	protected static final String DIGEST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDigest() <em>Digest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDigest()
	 * @generated
	 * @ordered
	 */
	protected String digest = DIGEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final long LENGTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected long length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isStub() <em>Stub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStub()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STUB_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStub() <em>Stub</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStub()
	 * @generated
	 * @ordered
	 */
	protected boolean stub = STUB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaAttachmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.MEDIA_ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContentType(String newContentType) {
		String oldContentType = contentType;
		contentType = newContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.MEDIA_ATTACHMENT__CONTENT_TYPE, oldContentType, contentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getRevPos() {
		return revPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRevPos(long newRevPos) {
		long oldRevPos = revPos;
		revPos = newRevPos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.MEDIA_ATTACHMENT__REV_POS, oldRevPos, revPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDigest() {
		return digest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDigest(String newDigest) {
		String oldDigest = digest;
		digest = newDigest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.MEDIA_ATTACHMENT__DIGEST, oldDigest, digest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLength(long newLength) {
		long oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.MEDIA_ATTACHMENT__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStub() {
		return stub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStub(boolean newStub) {
		boolean oldStub = stub;
		stub = newStub;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.MEDIA_ATTACHMENT__STUB, oldStub, stub));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImagePackage.MEDIA_ATTACHMENT__CONTENT_TYPE:
				return getContentType();
			case ImagePackage.MEDIA_ATTACHMENT__REV_POS:
				return getRevPos();
			case ImagePackage.MEDIA_ATTACHMENT__DIGEST:
				return getDigest();
			case ImagePackage.MEDIA_ATTACHMENT__LENGTH:
				return getLength();
			case ImagePackage.MEDIA_ATTACHMENT__STUB:
				return isStub();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImagePackage.MEDIA_ATTACHMENT__CONTENT_TYPE:
				setContentType((String)newValue);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__REV_POS:
				setRevPos((Long)newValue);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__DIGEST:
				setDigest((String)newValue);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__LENGTH:
				setLength((Long)newValue);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__STUB:
				setStub((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImagePackage.MEDIA_ATTACHMENT__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__REV_POS:
				setRevPos(REV_POS_EDEFAULT);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__DIGEST:
				setDigest(DIGEST_EDEFAULT);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ImagePackage.MEDIA_ATTACHMENT__STUB:
				setStub(STUB_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImagePackage.MEDIA_ATTACHMENT__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
			case ImagePackage.MEDIA_ATTACHMENT__REV_POS:
				return revPos != REV_POS_EDEFAULT;
			case ImagePackage.MEDIA_ATTACHMENT__DIGEST:
				return DIGEST_EDEFAULT == null ? digest != null : !DIGEST_EDEFAULT.equals(digest);
			case ImagePackage.MEDIA_ATTACHMENT__LENGTH:
				return length != LENGTH_EDEFAULT;
			case ImagePackage.MEDIA_ATTACHMENT__STUB:
				return stub != STUB_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (contentType: ");
		result.append(contentType);
		result.append(", revPos: ");
		result.append(revPos);
		result.append(", digest: ");
		result.append(digest);
		result.append(", length: ");
		result.append(length);
		result.append(", stub: ");
		result.append(stub);
		result.append(')');
		return result.toString();
	}

} //MediaAttachmentImpl
