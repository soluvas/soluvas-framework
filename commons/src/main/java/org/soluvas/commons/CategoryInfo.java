/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.BasicEList;
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
 *   <li>{@link org.soluvas.commons.CategoryInfo#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.CategoryInfo#getGoogleFormalId <em>Google Formal Id</em>}</li>
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
	 * Single right guillemet surrounded by space.
	 */
	public static final String RSAQUO = " › ";

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
	@JsonDeserialize(as=BasicEList.class)
	EList<CategoryInfo> getParents();

	/**
	 * Returns the value of the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Linked Data URI for <tt>@id</tt> in JSON-LD.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Uri</em>' attribute.
	 * @see #setPrimaryUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryInfo_PrimaryUri()
	 * @model
	 * @generated
	 */
	String getPrimaryUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryInfo#getPrimaryUri <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Uri</em>' attribute.
	 * @see #getPrimaryUri()
	 * @generated
	 */
	void setPrimaryUri(String value);

	/**
	 * Returns the value of the '<em><b>Google Formal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Google Formal Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Google Formal Id</em>' attribute.
	 * @see #setGoogleFormalId(Long)
	 * @see org.soluvas.commons.CommonsPackage#getCategoryInfo_GoogleFormalId()
	 * @model
	 * @generated
	 */
	Long getGoogleFormalId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.CategoryInfo#getGoogleFormalId <em>Google Formal Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Formal Id</em>' attribute.
	 * @see #getGoogleFormalId()
	 * @generated
	 */
	void setGoogleFormalId(Long value);

	String getFullName();

	String getFullName(String separator);
	
	String getUName();

} // CategoryInfo
