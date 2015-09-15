/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Photo Id Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains image ID as photoId attribute and has default implementation for {#getImageId()}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.PhotoIdContainer#getPhotoId <em>Photo Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getPhotoIdContainer()
 * @model abstract="true"
 * @generated
 */
public interface PhotoIdContainer extends Imageable {
	/**
	 * Returns the value of the '<em><b>Photo Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Avatar Photo ID directly usable by Image Store. Used by {#getImageId()}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Photo Id</em>' attribute.
	 * @see #setPhotoId(String)
	 * @see org.soluvas.commons.CommonsPackage#getPhotoIdContainer_PhotoId()
	 * @model
	 * @generated
	 */
	String getPhotoId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.PhotoIdContainer#getPhotoId <em>Photo Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo Id</em>' attribute.
	 * @see #getPhotoId()
	 * @generated
	 */
	void setPhotoId(String value);

} // PhotoIdContainer
