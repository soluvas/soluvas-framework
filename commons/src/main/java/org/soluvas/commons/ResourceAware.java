/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Aware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.ResourceAware#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link org.soluvas.commons.ResourceAware#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link org.soluvas.commons.ResourceAware#getResourceName <em>Resource Name</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getResourceAware()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ResourceAware extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Uri</em>' attribute.
	 * @see #setResourceUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getResourceAware_ResourceUri()
	 * @model transient="true"
	 * @generated
	 */
	@JsonIgnore
	String getResourceUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ResourceAware#getResourceUri <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Uri</em>' attribute.
	 * @see #getResourceUri()
	 * @generated
	 */
	void setResourceUri(String value);

	/**
	 * Returns the value of the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name relative to parent resource.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Name</em>' attribute.
	 * @see #setResourceName(String)
	 * @see org.soluvas.commons.CommonsPackage#getResourceAware_ResourceName()
	 * @model transient="true"
	 * @generated
	 */
	@JsonIgnore
	String getResourceName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ResourceAware#getResourceName <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Name</em>' attribute.
	 * @see #getResourceName()
	 * @generated
	 */
	void setResourceName(String value);

	/**
	 * Returns the value of the '<em><b>Resource Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Type</em>' attribute.
	 * @see org.soluvas.commons.ResourceType
	 * @see #setResourceType(ResourceType)
	 * @see org.soluvas.commons.CommonsPackage#getResourceAware_ResourceType()
	 * @model transient="true"
	 * @generated
	 */
	@JsonIgnore
	ResourceType getResourceType();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ResourceAware#getResourceType <em>Resource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Type</em>' attribute.
	 * @see org.soluvas.commons.ResourceType
	 * @see #getResourceType()
	 * @generated
	 */
	void setResourceType(ResourceType value);

} // ResourceAware
