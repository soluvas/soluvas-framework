/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sluggable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Sluggable#getSlug <em>Slug</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getSluggable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Sluggable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Slug (aka Directory uniqueIdentifier) used in SEO-friendly URIs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slug</em>' attribute.
	 * @see #setSlug(String)
	 * @see org.soluvas.commons.CommonsPackage#getSluggable_Slug()
	 * @model required="true"
	 * @generated
	 */
	String getSlug();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Sluggable#getSlug <em>Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slug</em>' attribute.
	 * @see #getSlug()
	 * @generated
	 */
	void setSlug(String value);

} // Sluggable
