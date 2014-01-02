/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.impl.GeolocationImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geolocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Why Double?
 * 
 * Hibernate Search has this as best practice:
 * "add the @Latitude and @Longitude annotations on your properties representing the coordinates; these must be of type Double"
 * http://docs.jboss.org/hibernate/search/4.2/reference/en-US/html/spatial.html
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Geolocation#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link org.soluvas.commons.Geolocation#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link org.soluvas.commons.Geolocation#getElevation <em>Elevation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getGeolocation()
 * @model
 * @generated
 */
@JsonDeserialize(as=GeolocationImpl.class)
public interface Geolocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(Double)
	 * @see org.soluvas.commons.CommonsPackage#getGeolocation_Latitude()
	 * @model
	 * @generated
	 */
	Double getLatitude();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Geolocation#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(Double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(Double)
	 * @see org.soluvas.commons.CommonsPackage#getGeolocation_Longitude()
	 * @model
	 * @generated
	 */
	Double getLongitude();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Geolocation#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(Double value);

	/**
	 * Returns the value of the '<em><b>Elevation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation</em>' attribute.
	 * @see #setElevation(Double)
	 * @see org.soluvas.commons.CommonsPackage#getGeolocation_Elevation()
	 * @model
	 * @generated
	 */
	Double getElevation();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Geolocation#getElevation <em>Elevation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation</em>' attribute.
	 * @see #getElevation()
	 * @generated
	 */
	void setElevation(Double value);

} // Geolocation
