/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.impl.CategoryInfoImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.CategoryInfo#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getCategoryInfo()
 * @model
 * @generated
 */
@JsonDeserialize(as=CategoryInfoImpl.class)
public interface CategoryInfo extends CategoryLike, Parentable<CategoryInfo> {

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.CategoryInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to help query performance. And also to display breadcrumbs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parents</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getCategoryInfo_Parents()
	 * @model containment="true"
	 * @generated
	 */
	EList<CategoryInfo> getParents();
} // CategoryInfo
