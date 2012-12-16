/**
 */
package org.soluvas.category;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.category.CategoryContainer#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.category.CategoryPackage#getCategoryContainer()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface CategoryContainer extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.category.Category}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of categories or children.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.soluvas.category.CategoryPackage#getCategoryContainer_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

} // CategoryContainer
