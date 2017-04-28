/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.impl.ThingInfoImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thing Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A condensed version of a (probably app-specific) Thing.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.ThingInfo#getImageId <em>Image Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getThingInfo()
 * @model
 * @generated
 */
@JsonDeserialize(as=ThingInfoImpl.class)
public interface ThingInfo extends NameContainer, Identifiable, Sluggable, Imageable, EObject {
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
	 * @see org.soluvas.commons.CommonsPackage#getThingInfo_ImageId()
	 * @model
	 * @generated
	 */
	@Override
	String getImageId();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.ThingInfo#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(String value);

} // ThingInfo
