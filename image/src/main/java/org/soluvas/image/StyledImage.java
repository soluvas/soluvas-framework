/**
 */
package org.soluvas.image;

import org.soluvas.commons.NameContainer;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Styled Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * StyledImage v1 is as follows:
 * 
 * 				bson.put("code", transformed.getStyleCode());
 * 				bson.put("uri", transformed.getUri());
 * 				bson.put("size", transformed.getSize());
 * 				bson.put("width", transformed.getWidth());
 * 				bson.put("height", transformed.getHeight());
 * 
 * v2 adds:
 * 
 * 				bson.put("className", StyledImage.class.getName()); // META
 * 				bson.put("name", style.getName());
 * 				bson.put("variant", transformed.getStyleVariant());
 * 				bson.put("extension", transformed.getExtension());
 * 				bson.put("originUri", transformed.getOriginUri());
 * 				bson.put("contentType", "image/jpeg"); // TODO: don't hardcode content type
 * - creationTime
 * - modificationTime
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.StyledImage#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getCode <em>Code</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getUri <em>Uri</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getSize <em>Size</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getVariant <em>Variant</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getOriginUri <em>Origin Uri</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.soluvas.image.StyledImage#getLinkedFile <em>Linked File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getStyledImage()
 * @model
 * @generated
 */
public interface StyledImage extends SchemaVersionable, DimensionLike, NameContainer, Timestamped {
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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_SchemaVersion()
	 * @model default="2" changeable="false"
	 * @generated
	 */
	long getSchemaVersion();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see org.soluvas.image.ImagePackage#getStyledImage_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_Size()
	 * @model
	 * @generated
	 */
	Long getSize();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Long value);

	/**
	 * Returns the value of the '<em><b>Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variant</em>' attribute.
	 * @see #setVariant(String)
	 * @see org.soluvas.image.ImagePackage#getStyledImage_Variant()
	 * @model
	 * @generated
	 */
	String getVariant();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getVariant <em>Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variant</em>' attribute.
	 * @see #getVariant()
	 * @generated
	 */
	void setVariant(String value);

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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_OriginUri()
	 * @model
	 * @generated
	 */
	String getOriginUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getOriginUri <em>Origin Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Uri</em>' attribute.
	 * @see #getOriginUri()
	 * @generated
	 */
	void setOriginUri(String value);

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
	 * @see org.soluvas.image.ImagePackage#getStyledImage_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Linked File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Image file name, relative to XMI file path inside the export folder or archive file. Only used for XMI data.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Linked File</em>' attribute.
	 * @see #setLinkedFile(String)
	 * @see org.soluvas.image.ImagePackage#getStyledImage_LinkedFile()
	 * @model
	 * @generated
	 */
	String getLinkedFile();

	/**
	 * Sets the value of the '{@link org.soluvas.image.StyledImage#getLinkedFile <em>Linked File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked File</em>' attribute.
	 * @see #getLinkedFile()
	 * @generated
	 */
	void setLinkedFile(String value);

} // StyledImage
