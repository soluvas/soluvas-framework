/**
 */
package org.soluvas.image;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.image.ImageCatalog#getImages <em>Images</em>}</li>
 * </ul>
 *
 * @see org.soluvas.image.ImagePackage#getImageCatalog()
 * @model
 * @generated
 */
public interface ImageCatalog extends EObject {

	/**
	 * Returns the value of the '<em><b>Images</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.image.Image}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Images</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Images</em>' containment reference list.
	 * @see org.soluvas.image.ImagePackage#getImageCatalog_Images()
	 * @model containment="true"
	 * @generated
	 */
	EList<Image> getImages();
} // ImageCatalog
