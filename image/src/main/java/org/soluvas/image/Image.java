/**
 */
package org.soluvas.image;

import java.io.File;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.EList;

import org.joda.time.DateTime;

import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The v1 structure is as follows:
 * 
 * 			dbo.put("_id", imageId);
 * 			dbo.put("name", name); // in v1: Only used for creating/uploading new image. Otherwise it's always null.
 * 			dbo.put("uri", originalUri);
 * 			dbo.put("fileName", originalName);
 * 			dbo.put("contentType", contentType);
 * 			dbo.put("size", (int)length);
 * 			final Date creationTime = new Date();
 * 			dbo.put("created", creationTime);
 * 			dbo.put("styles", stylesObj);
 * - originalFile : transient
 * 
 * v2 adds:
 * 
 * 			dbo.put("name", name); // in v2: serialized
 * 			dbo.put("originUri", originalOriginUri);
 * 			dbo.put("extension", extension);
 * 			dbo.put("creationTime", creationTime);
 * - modificationTime
 * - width
 * - height
 * - linkedFile
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.Image#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getCreated <em>Created</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getOriginUri <em>Origin Uri</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getLinkedFile <em>Linked File</em>}</li>
 *   <li>{@link org.soluvas.image.Image#getOriginalFile <em>Original File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Identifiable, NameContainer, SchemaVersionable, Timestamped, DimensionLike {
	/**
	 * Returns the value of the '<em><b>Styles</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.soluvas.image.StyledImage},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' map.
	 * @see org.soluvas.image.ImagePackage#getImage_Styles()
	 * @model mapType="org.soluvas.image.StyledImageEntry<org.eclipse.emf.ecore.EString, org.soluvas.image.StyledImage>"
	 * @generated
	 */
	EMap<String, StyledImage> getStyles();

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getImage_SchemaVersion()
	 * @model default="2" changeable="false"
	 * @generated
	 */
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.soluvas.image.ImagePackage#getImage_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.soluvas.image.ImagePackage#getImage_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.soluvas.image.ImagePackage#getImage_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Long)
	 * @see org.soluvas.image.ImagePackage#getImage_Size()
	 * @model
	 * @generated
	 */
	Long getSize();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Long value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DEPRECATED.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(DateTime)
	 * @see org.soluvas.image.ImagePackage#getImage_Created()
	 * @model dataType="org.soluvas.commons.DateTime"
	 * @generated
	 */
	DateTime getCreated();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(DateTime value);

	/**
	 * Returns the value of the '<em><b>Origin Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Uri</em>' attribute.
	 * @see #setOriginUri(String)
	 * @see org.soluvas.image.ImagePackage#getImage_OriginUri()
	 * @model
	 * @generated
	 */
	String getOriginUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getOriginUri <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Uri</em>' attribute.
	 * @see #getOriginUri()
	 * @generated
	 */
	void setOriginUri(String value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.soluvas.image.ImagePackage#getImage_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Linked File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Image file name, relative to XMI file path inside the export folder or archive file. Only used for XMI data.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Linked File</em>' attribute.
	 * @see #setLinkedFile(String)
	 * @see org.soluvas.image.ImagePackage#getImage_LinkedFile()
	 * @model
	 * @generated
	 */
	String getLinkedFile();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getLinkedFile <em>Linked File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked File</em>' attribute.
	 * @see #getLinkedFile()
	 * @generated
	 */
	void setLinkedFile(String value);

	/**
	 * Returns the value of the '<em><b>Original File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used for creating/uploading new image. Otherwise it's always null.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Original File</em>' attribute.
	 * @see #setOriginalFile(File)
	 * @see org.soluvas.image.ImagePackage#getImage_OriginalFile()
	 * @model dataType="org.soluvas.commons.File" transient="true"
	 * @generated
	 */
	File getOriginalFile();

	/**
	 * Sets the value of the '{@link org.soluvas.image.Image#getOriginalFile <em>Original File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original File</em>' attribute.
	 * @see #getOriginalFile()
	 * @generated
	 */
	void setOriginalFile(File value);

} // Image
