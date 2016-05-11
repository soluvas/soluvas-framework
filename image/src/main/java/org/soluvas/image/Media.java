/**
 */
package org.soluvas.image;

import org.eclipse.emf.common.util.EMap;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Revisionable;
import org.soluvas.commons.Timestamped;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Media</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Media document containing embedded file as a single (and only) attachment, compatible with CouchDB repository.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.Media#getType <em>Type</em>}</li>
 *   <li>{@link org.soluvas.image.Media#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.image.Media#getAttachments <em>Attachments</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getMedia()
 * @model
 * @generated
 */
public interface Media extends Identifiable, Revisionable, Timestamped, NameContainer, Describable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Media"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getMedia_Type()
	 * @model default="Media" required="true" changeable="false"
	 * @generated
	 */
	String getType();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.image.MediaStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.image.MediaStatus
	 * @see #setStatus(MediaStatus)
	 * @see org.soluvas.image.ImagePackage#getMedia_Status()
	 * @model required="true"
	 * @generated
	 */
	MediaStatus getStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Media#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.image.MediaStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(MediaStatus value);

	/**
	 * Returns the value of the '<em><b>Attachments</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.soluvas.image.MediaAttachment},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachments</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachments</em>' map.
	 * @see org.soluvas.image.ImagePackage#getMedia_Attachments()
	 * @model mapType="org.soluvas.image.MediaAttachmentEntry<org.eclipse.emf.ecore.EString, org.soluvas.image.MediaAttachment>"
	 * @generated
	 */
	EMap<String, MediaAttachment> getAttachments();

} // Media
