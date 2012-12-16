/**
 */
package org.soluvas.category;

import java.util.List;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CategoryLike;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.category.Category#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaDescription <em>Meta Description</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaKeywords <em>Meta Keywords</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaTitle <em>Meta Title</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getAvailableSortBy <em>Available Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getDefaultSortBy <em>Default Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.Category#isAnchor <em>Anchor</em>}</li>
 *   <li>{@link org.soluvas.category.Category#isIncludeInMenu <em>Include In Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.category.CategoryPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends Parentable<Category>, CategoryLike, ResourceAware, BundleAware, CategoryContainer, Describable {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.category.CategoryStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.category.CategoryStatus
	 * @see #setStatus(CategoryStatus)
	 * @see org.soluvas.category.CategoryPackage#getCategory_Status()
	 * @model
	 * @generated
	 */
	CategoryStatus getStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.category.CategoryStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(CategoryStatus value);

	/**
	 * Returns the value of the '<em><b>Meta Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Description</em>' attribute.
	 * @see #setMetaDescription(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaDescription()
	 * @model
	 * @generated
	 */
	String getMetaDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaDescription <em>Meta Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Description</em>' attribute.
	 * @see #getMetaDescription()
	 * @generated
	 */
	void setMetaDescription(String value);

	/**
	 * Returns the value of the '<em><b>Meta Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Keywords</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Keywords</em>' attribute.
	 * @see #setMetaKeywords(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaKeywords()
	 * @model
	 * @generated
	 */
	String getMetaKeywords();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaKeywords <em>Meta Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Keywords</em>' attribute.
	 * @see #getMetaKeywords()
	 * @generated
	 */
	void setMetaKeywords(String value);

	/**
	 * Returns the value of the '<em><b>Meta Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Title</em>' attribute.
	 * @see #setMetaTitle(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaTitle()
	 * @model
	 * @generated
	 */
	String getMetaTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaTitle <em>Meta Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Title</em>' attribute.
	 * @see #getMetaTitle()
	 * @generated
	 */
	void setMetaTitle(String value);

	/**
	 * Returns the value of the '<em><b>Available Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Sort By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Sort By</em>' attribute.
	 * @see #setAvailableSortBy(List)
	 * @see org.soluvas.category.CategoryPackage#getCategory_AvailableSortBy()
	 * @model dataType="org.soluvas.commons.List<org.eclipse.emf.ecore.EString>" many="false"
	 * @generated
	 */
	List<String> getAvailableSortBy();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getAvailableSortBy <em>Available Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Sort By</em>' attribute.
	 * @see #getAvailableSortBy()
	 * @generated
	 */
	void setAvailableSortBy(List<String> value);

	/**
	 * Returns the value of the '<em><b>Default Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Sort By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Sort By</em>' attribute.
	 * @see #setDefaultSortBy(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_DefaultSortBy()
	 * @model
	 * @generated
	 */
	String getDefaultSortBy();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getDefaultSortBy <em>Default Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Sort By</em>' attribute.
	 * @see #getDefaultSortBy()
	 * @generated
	 */
	void setDefaultSortBy(String value);

	/**
	 * Returns the value of the '<em><b>Anchor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchor</em>' attribute.
	 * @see #setAnchor(boolean)
	 * @see org.soluvas.category.CategoryPackage#getCategory_Anchor()
	 * @model
	 * @generated
	 */
	boolean isAnchor();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#isAnchor <em>Anchor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anchor</em>' attribute.
	 * @see #isAnchor()
	 * @generated
	 */
	void setAnchor(boolean value);

	/**
	 * Returns the value of the '<em><b>Include In Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include In Menu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include In Menu</em>' attribute.
	 * @see #setIncludeInMenu(boolean)
	 * @see org.soluvas.category.CategoryPackage#getCategory_IncludeInMenu()
	 * @model
	 * @generated
	 */
	boolean isIncludeInMenu();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#isIncludeInMenu <em>Include In Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include In Menu</em>' attribute.
	 * @see #isIncludeInMenu()
	 * @generated
	 */
	void setIncludeInMenu(boolean value);

} // Category
