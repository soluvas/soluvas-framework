/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Canonical Sluggable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: Consider merging this with {@link Sluggable}?
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.CanonicalSluggable#getCanonicalSlug <em>Canonical Slug</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getCanonicalSluggable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface CanonicalSluggable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Canonical Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Canonical slug is lowercase, and removes every character not in a-z, 0-9, and underscore.
	 * 
	 * <p>It is useful for e.g. making both http://www.satukancinta.com/arum.puspita and http://www.satukancinta.com/arumpuspita or even http://www.satukancinta.com/member/arum.pus.pi.ta usable.
	 * 
	 * <p>From the technical point-of-view (easy matching/lookup), the canonical slug/identifier for arum.puspita is arumpuspita, the canonicalSlug should be indexed in database for fast matching. From the user or SEO point-of-view however, the "canonical" one is arum.puspita, but it is not what is meant here.
	 * 
	 * <p>Use {@link SlugUtils#canonicalize()} to generate canonical slug from user-provided slug.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Canonical Slug</em>' attribute.
	 * @see #setCanonicalSlug(String)
	 * @see org.soluvas.commons.CommonsPackage#getCanonicalSluggable_CanonicalSlug()
	 * @model
	 * @generated
	 */
	String getCanonicalSlug();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CanonicalSluggable#getCanonicalSlug <em>Canonical Slug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Canonical Slug</em>' attribute.
	 * @see #getCanonicalSlug()
	 * @generated
	 */
	void setCanonicalSlug(String value);

} // CanonicalSluggable
