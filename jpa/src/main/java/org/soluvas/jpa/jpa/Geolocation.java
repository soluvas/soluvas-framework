package org.soluvas.jpa.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;

/**
 * A representation of the model object '<em><b>Geolocation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Embeddable()
public class Geolocation implements Serializable {

	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Basic()
	private Double latitude = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Basic()
	private Double longitude = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Basic()
	private Double elevation = null;

	/**
	 * Returns the value of '<em><b>latitude</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Latitude, in decimal degrees. Positive latitudes are north of the
	 * equator, negative latitudes are south of the equator. <!-- end-model-doc
	 * -->
	 * 
	 * @return the value of '<em><b>latitude</b></em>' feature
	 * @generated
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the '{@link Geolocation#getLatitude() <em>latitude</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Latitude, in decimal degrees. Positive latitudes are north of the
	 * equator, negative latitudes are south of the equator. <!-- end-model-doc
	 * -->
	 * 
	 * @param newLatitude
	 *            the new value of the '{@link Geolocation#getLatitude()
	 *            latitude}' feature.
	 * @generated
	 */
	public void setLatitude(Double newLatitude) {
		latitude = newLatitude;
	}

	/**
	 * Returns the value of '<em><b>longitude</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Longitude, in decimal degrees. Positive longitudes are east of Prime
	 * Meridian, negative longitudes are west of the Prime Meridian. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of '<em><b>longitude</b></em>' feature
	 * @generated
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the '{@link Geolocation#getLongitude() <em>longitude</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Longitude, in decimal degrees. Positive longitudes are east of Prime
	 * Meridian, negative longitudes are west of the Prime Meridian. <!--
	 * end-model-doc -->
	 * 
	 * @param newLongitude
	 *            the new value of the '{@link Geolocation#getLongitude()
	 *            longitude}' feature.
	 * @generated
	 */
	public void setLongitude(Double newLongitude) {
		longitude = newLongitude;
	}

	/**
	 * Returns the value of '<em><b>elevation</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Elevation, in SI meters. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>elevation</b></em>' feature
	 * @generated
	 */
	public Double getElevation() {
		return elevation;
	}

	/**
	 * Sets the '{@link Geolocation#getElevation() <em>elevation</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Elevation, in SI meters. <!-- end-model-doc -->
	 * 
	 * @param newElevation
	 *            the new value of the '{@link Geolocation#getElevation()
	 *            elevation}' feature.
	 * @generated
	 */
	public void setElevation(Double newElevation) {
		elevation = newElevation;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Geolocation " + " [latitude: " + getLatitude() + "]" + " [longitude: " + getLongitude() + "]"
				+ " [elevation: " + getElevation() + "]";
	}
}
