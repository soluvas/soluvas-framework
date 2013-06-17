/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ID is prefixed with parent IDs then concatenated by '_', it won't change when categories are reordered are moved/restructured. IDs cannot be duplicate (even draft/inactive/void categories). Slugs can be duplicates only within same parent. Names can be duplicates.
 * 
 * <p>Slug is used as name in JCR repositories. If not specified, should be generated based on Name.
 * 
 * <p>Name is used as displayName in JCR repositories.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.CategoryLike#getSlugPath <em>Slug Path</em>}</li>
 *   <li>{@link org.soluvas.commons.CategoryLike#getColor <em>Color</em>}</li>
 *   <li>{@link org.soluvas.commons.CategoryLike#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.commons.CategoryLike#getLevel <em>Level</em>}</li>
 *   <li>{@link org.soluvas.commons.CategoryLike#getCategoryCount <em>Category Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getCategoryLike()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CategoryLike extends Identifiable, NsPrefixable, NameContainer, Positionable, Sluggable, Imageable {
	/**
	 * Returns the value of the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Automatically updated based on slug and parent slugs, separated by '/'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slug Path</em>' attribute.
	 * @see #setSlugPath(String)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryLike_SlugPath()
	 * @model
	 * @generated
	 */
	String getSlugPath();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryLike#getSlugPath <em>Slug Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slug Path</em>' attribute.
	 * @see #getSlugPath()
	 * @generated
	 */
	void setSlugPath(String value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * HTML color code name or hexadecimal code (i.e. "#3356ff") of category color (usually used as background).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryLike_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryLike#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Id</em>' attribute.
	 * @see #setImageId(String)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryLike_ImageId()
	 * @model
	 * @generated
	 */
	String getImageId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryLike#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The "implicit root category" has level 0. So a Category without a parent has level 1. Automatically updated on save.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(Integer)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryLike_Level()
	 * @model
	 * @generated
	 */
	Integer getLevel();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryLike#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(Integer value);

	/**
	 * Returns the value of the '<em><b>Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Number of children categories. Automatically updated when categories are restructured.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Category Count</em>' attribute.
	 * @see #setCategoryCount(Long)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryLike_CategoryCount()
	 * @model
	 * @generated
	 */
	Long getCategoryCount();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryLike#getCategoryCount <em>Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category Count</em>' attribute.
	 * @see #getCategoryCount()
	 * @generated
	 */
	void setCategoryCount(Long value);

} // CategoryLike
