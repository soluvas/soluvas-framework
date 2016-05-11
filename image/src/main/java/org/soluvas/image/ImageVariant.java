/**
 */
package org.soluvas.image;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.ImageVariant#getStyleCode <em>Style Code</em>}</li>
 *   <li>{@link org.soluvas.image.ImageVariant#getStyleVariant <em>Style Variant</em>}</li>
 *   <li>{@link org.soluvas.image.ImageVariant#getExtension <em>Extension</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getImageVariant()
 * @model
 * @generated
 */
public interface ImageVariant extends EObject {
	/**
	 * Returns the value of the '<em><b>Style Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Code</em>' attribute.
	 * @see #setStyleCode(String)
	 * @see org.soluvas.image.ImagePackage#getImageVariant_StyleCode()
	 * @model
	 * @generated
	 */
	String getStyleCode();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ImageVariant#getStyleCode <em>Style Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Code</em>' attribute.
	 * @see #getStyleCode()
	 * @generated
	 */
	void setStyleCode(String value);

	/**
	 * Returns the value of the '<em><b>Style Variant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Variant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Variant</em>' attribute.
	 * @see #setStyleVariant(String)
	 * @see org.soluvas.image.ImagePackage#getImageVariant_StyleVariant()
	 * @model
	 * @generated
	 */
	String getStyleVariant();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ImageVariant#getStyleVariant <em>Style Variant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Variant</em>' attribute.
	 * @see #getStyleVariant()
	 * @generated
	 */
	void setStyleVariant(String value);

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
	 * @see org.soluvas.image.ImagePackage#getImageVariant_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ImageVariant#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

} // ImageVariant
