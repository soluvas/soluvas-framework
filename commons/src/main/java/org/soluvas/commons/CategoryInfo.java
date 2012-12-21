/**
 */
package org.soluvas.commons;

import org.soluvas.commons.impl.CategoryInfoImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Info</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.commons.CommonsPackage#getCategoryInfo()
 * @model
 * @generated
 */
@JsonDeserialize(as=CategoryInfoImpl.class)
public interface CategoryInfo extends CategoryLike, Parentable<CategoryInfo> {
} // CategoryInfo
