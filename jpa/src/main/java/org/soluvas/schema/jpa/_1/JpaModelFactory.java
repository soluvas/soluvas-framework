package org.soluvas.schema.jpa._1;

import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.texo.model.AbstractModelFeatureMapEntry;
import org.eclipse.emf.texo.model.AbstractModelObject;
import org.eclipse.emf.texo.model.ModelFactory;
import org.eclipse.emf.texo.model.ModelFeatureMapEntry;
import org.eclipse.emf.texo.model.ModelObject;
import org.eclipse.emf.texo.model.ModelPackage;
import org.joda.time.DateTime;

/**
 * The <b>{@link ModelFactory}</b> for the types of this model: jpa. It contains
 * code to create instances {@link ModelObject} wrappers and instances for
 * EClasses and convert objects back and forth from their String (XML)
 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class JpaModelFactory implements ModelFactory {

	/**
	 * Creates an instance for an {@link EClass} <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param eClass
	 *            creates a Object instance for this EClass
	 * @return an object representing the eClass
	 * @generated
	 */
	public Object create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case JpaModelPackage.POSTALADDRESS_CLASSIFIER_ID:
			return createPostalAddress();
		case JpaModelPackage.GEOLOCATION_CLASSIFIER_ID:
			return createGeolocation();
		default:
			throw new IllegalArgumentException("The EClass '"
					+ eClass.getName()
					+ "' is not a valid EClass for this EPackage");
		}
	}

	/**
	 * Wraps an object in a {@link ModelObject}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param eClass
	 *            the EClass of the object
	 * @param adaptee
	 *            the object being wrapped/adapted
	 * @return the wrapper {@link ModelObject}
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelObject createModelObject(EClass eClass, Object adaptee) {
		ModelObject<Object> modelObject = null;
		switch (eClass.getClassifierID()) {
		case JpaModelPackage.POSTALADDRESS_CLASSIFIER_ID:
			modelObject = new PostalAddressModelObject();
			break;
		case JpaModelPackage.GEOLOCATION_CLASSIFIER_ID:
			modelObject = new GeolocationModelObject();
			break;
		default:
			throw new IllegalArgumentException("The EClass '" + eClass
					+ "' is not defined in this EPackage");
		}
		modelObject.setTarget(adaptee);
		return modelObject;
	}

	/**
	 * Creates a feature map entry instance for a certain EStructuralFeature.
	 * 
	 * @param eFeature
	 *            the feature map feature
	 * @return the pojo feature map entry
	 * @generated
	 */
	public Object createFeatureMapEntry(EStructuralFeature eFeature) {
		throw new IllegalArgumentException("The EStructuralFeature '"
				+ eFeature + "' is not a valid feature map in this EPackage");
	}

	/**
	 * Wraps a feature map entry pojo in a {@link AbstractModelFeatureMapEntry}.
	 * If the feature map entry is null then a new one is created and <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param eFeature
	 *            the feature map feature of the object
	 * @param adaptee
	 *            the pojo feature map entry being wrapped/adapted
	 * @return the wrapper {@link ModelFeatureMapEntry}
	 * @generated
	 */
	public ModelFeatureMapEntry<?> createModelFeatureMapEntry(
			EStructuralFeature eFeature, Object adaptee) {
		throw new IllegalArgumentException("The EStructuralFeature '"
				+ eFeature + "' is not a valid feature map in this EPackage");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the model object representing the EClass
	 *         PostalAddress
	 * @generated
	 */
	public PostalAddress createPostalAddress() {
		return new PostalAddress();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the model object representing the EClass
	 *         Geolocation
	 * @generated
	 */
	public Geolocation createGeolocation() {
		return new Geolocation();
	}

	/**
	 * Converts an instance of an {@link EDataType} to a String. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param eDataType
	 *            the {@link EDataType} defining the type
	 * @param value
	 *            the object to convert, if the value is null then null is
	 *            returned.
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String value) {
		switch (eDataType.getClassifierID()) {
		case JpaModelPackage.DATETIME_CLASSIFIER_ID:
			return createDateTimeFromString(value);
		default:
			throw new IllegalArgumentException("The EDatatype '" + eDataType
					+ "' is not defined in this EPackage");
		}
	}

	/**
	 * Converts an instance of an {@link EDataType} to a String. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param eDataType
	 *            the {@link EDataType} defining the type
	 * @param value
	 *            the object to convert, if value == null then null is returned
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object value) {
		switch (eDataType.getClassifierID()) {
		case JpaModelPackage.DATETIME_CLASSIFIER_ID:
			return convertDateTimeToString((DateTime) value);
		default:
			throw new IllegalArgumentException("The EDatatype '" + eDataType
					+ "' is not defined in this EPackage.");
		}
	}

	/**
	 * Converts the EDataType: DateTime to a String. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the object to convert
	 * @return the String representing the value, if value == null then null is
	 *         returned
	 * @generated
	 */
	public String convertDateTimeToString(DateTime value) {
		if (value == null) {
			return null;
		}
		EDataType eDataType = JpaModelPackage.INSTANCE.getDateTimeEDataType();
		throw new UnsupportedOperationException(
				"Operation not support for EDataType " + eDataType.getName()
						+ " converting from value " + value);
	}

	/**
	 * Creates an instance of the EDataType: DateTime from a String. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the string value to convert to an object
	 * @return the instance of the data type, if value == null then null is
	 *         returned
	 * @generated
	 */
	public DateTime createDateTimeFromString(String value) {
		if (value == null) {
			return null;
		}
		EDataType eDataType = JpaModelPackage.INSTANCE.getDateTimeEDataType();
		throw new UnsupportedOperationException(
				"Operation not support for EDataType " + eDataType.getName()
						+ " converting from value " + value);
	}

	/**
	 * The adapter/wrapper for the EClass '<em><b>PostalAddress</b></em>'.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param <E>
	 *            the domain model java class
	 * 
	 * @generated
	 */
	public static class PostalAddressModelObject<E extends PostalAddress>
			extends AbstractModelObject<E> {
		/**
		 * @generated
		 */
		public EClass eClass() {
			return JpaModelPackage.INSTANCE.getPostalAddressEClass();
		}

		/**
		 * @generated
		 */
		public ModelPackage getModelPackage() {
			return JpaModelPackage.INSTANCE;
		}

		/**
		 * @generated
		 */
		@Override
		public Object eGet(EStructuralFeature eStructuralFeature) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {
			case JpaModelPackage.POSTALADDRESS_ORGANIZATION_FEATURE_ID:
				return getTarget().getOrganization();
			case JpaModelPackage.POSTALADDRESS_STREET_FEATURE_ID:
				return getTarget().getStreet();
			case JpaModelPackage.POSTALADDRESS_CITY_FEATURE_ID:
				return getTarget().getCity();
			case JpaModelPackage.POSTALADDRESS_POSTALCODE_FEATURE_ID:
				return getTarget().getPostalCode();
			case JpaModelPackage.POSTALADDRESS_PROVINCE_FEATURE_ID:
				return getTarget().getProvince();
			case JpaModelPackage.POSTALADDRESS_COUNTRY_FEATURE_ID:
				return getTarget().getCountry();
			case JpaModelPackage.POSTALADDRESS_COUNTRYCODE_FEATURE_ID:
				return getTarget().getCountryCode();
			case JpaModelPackage.POSTALADDRESS_PRIMARYMOBILE_FEATURE_ID:
				return getTarget().getPrimaryMobile();
			case JpaModelPackage.POSTALADDRESS_MOBILES_FEATURE_ID:
				return getTarget().getMobiles();
			case JpaModelPackage.POSTALADDRESS_PRIMARYPHONE_FEATURE_ID:
				return getTarget().getPrimaryPhone();
			case JpaModelPackage.POSTALADDRESS_PHONES_FEATURE_ID:
				return getTarget().getPhones();
			case JpaModelPackage.POSTALADDRESS_PRIMARYHOMEPHONE_FEATURE_ID:
				return getTarget().getPrimaryHomePhone();
			case JpaModelPackage.POSTALADDRESS_HOMEPHONES_FEATURE_ID:
				return getTarget().getHomePhones();
			case JpaModelPackage.POSTALADDRESS_PRIMARYWORKPHONE_FEATURE_ID:
				return getTarget().getPrimaryWorkPhone();
			case JpaModelPackage.POSTALADDRESS_WORKPHONES_FEATURE_ID:
				return getTarget().getWorkPhones();
			case JpaModelPackage.POSTALADDRESS_PRIMARYEMAIL_FEATURE_ID:
				return getTarget().getPrimaryEmail();
			case JpaModelPackage.POSTALADDRESS_EMAILS_FEATURE_ID:
				return getTarget().getEmails();
			case JpaModelPackage.POSTALADDRESS_DESCRIPTION_FEATURE_ID:
				return getTarget().getDescription();
			case JpaModelPackage.POSTALADDRESS_PRIMARY_FEATURE_ID:
				return getTarget().isPrimary();
			case JpaModelPackage.POSTALADDRESS_PRIMARYBILLING_FEATURE_ID:
				return getTarget().isPrimaryBilling();
			case JpaModelPackage.POSTALADDRESS_PRIMARYSHIPPING_FEATURE_ID:
				return getTarget().isPrimaryShipping();
			case JpaModelPackage.POSTALADDRESS_VALIDATIONTIME_FEATURE_ID:
				return getTarget().getValidationTime();
			default:
				return super.eGet(eStructuralFeature);
			}
		}

		/**
		 * @generated
		 */
		@SuppressWarnings("unchecked")
		@Override
		public void eSet(EStructuralFeature eStructuralFeature, Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {
			case JpaModelPackage.POSTALADDRESS_ORGANIZATION_FEATURE_ID:
				getTarget().setOrganization((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_STREET_FEATURE_ID:
				getTarget().setStreet((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_CITY_FEATURE_ID:
				getTarget().setCity((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_POSTALCODE_FEATURE_ID:
				getTarget().setPostalCode((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PROVINCE_FEATURE_ID:
				getTarget().setProvince((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_COUNTRY_FEATURE_ID:
				getTarget().setCountry((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_COUNTRYCODE_FEATURE_ID:
				getTarget().setCountryCode((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYMOBILE_FEATURE_ID:
				getTarget().setPrimaryMobile((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_MOBILES_FEATURE_ID:
				getTarget().setMobiles((List<String>) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYPHONE_FEATURE_ID:
				getTarget().setPrimaryPhone((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PHONES_FEATURE_ID:
				getTarget().setPhones((List<String>) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYHOMEPHONE_FEATURE_ID:
				getTarget().setPrimaryHomePhone((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_HOMEPHONES_FEATURE_ID:
				getTarget().setHomePhones((Set<String>) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYWORKPHONE_FEATURE_ID:
				getTarget().setPrimaryWorkPhone((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_WORKPHONES_FEATURE_ID:
				getTarget().setWorkPhones((List<String>) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYEMAIL_FEATURE_ID:
				getTarget().setPrimaryEmail((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_EMAILS_FEATURE_ID:
				getTarget().setEmails((Set<String>) value);
				return;
			case JpaModelPackage.POSTALADDRESS_DESCRIPTION_FEATURE_ID:
				getTarget().setDescription((String) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARY_FEATURE_ID:
				getTarget().setPrimary((Boolean) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYBILLING_FEATURE_ID:
				getTarget().setPrimaryBilling((Boolean) value);
				return;
			case JpaModelPackage.POSTALADDRESS_PRIMARYSHIPPING_FEATURE_ID:
				getTarget().setPrimaryShipping((Boolean) value);
				return;
			case JpaModelPackage.POSTALADDRESS_VALIDATIONTIME_FEATURE_ID:
				getTarget().setValidationTime((DateTime) value);
				return;
			default:
				super.eSet(eStructuralFeature, value);
			}
		}

		/**
		 * @generated
		 */
		@Override
		public boolean eAddTo(EStructuralFeature eStructuralFeature,
				Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {

			case JpaModelPackage.POSTALADDRESS_MOBILES_FEATURE_ID:
				return getTarget().getMobiles().add((String) value);

			case JpaModelPackage.POSTALADDRESS_PHONES_FEATURE_ID:
				return getTarget().getPhones().add((String) value);

			case JpaModelPackage.POSTALADDRESS_HOMEPHONES_FEATURE_ID:
				return getTarget().getHomePhones().add((String) value);

			case JpaModelPackage.POSTALADDRESS_WORKPHONES_FEATURE_ID:
				return getTarget().getWorkPhones().add((String) value);

			case JpaModelPackage.POSTALADDRESS_EMAILS_FEATURE_ID:
				return getTarget().getEmails().add((String) value);

			default:
				return super.eAddTo(eStructuralFeature, value);
			}
		}

		/**
		 * @generated
		 */
		@Override
		public boolean eRemoveFrom(EStructuralFeature eStructuralFeature,
				Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {

			case JpaModelPackage.POSTALADDRESS_MOBILES_FEATURE_ID:
				return getTarget().getMobiles().remove(value);

			case JpaModelPackage.POSTALADDRESS_PHONES_FEATURE_ID:
				return getTarget().getPhones().remove(value);

			case JpaModelPackage.POSTALADDRESS_HOMEPHONES_FEATURE_ID:
				return getTarget().getHomePhones().remove(value);

			case JpaModelPackage.POSTALADDRESS_WORKPHONES_FEATURE_ID:
				return getTarget().getWorkPhones().remove(value);

			case JpaModelPackage.POSTALADDRESS_EMAILS_FEATURE_ID:
				return getTarget().getEmails().remove(value);

			default:
				return super.eRemoveFrom(eStructuralFeature, value);
			}
		}
	}

	/**
	 * The adapter/wrapper for the EClass '<em><b>Geolocation</b></em>'.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param <E>
	 *            the domain model java class
	 * 
	 * @generated
	 */
	public static class GeolocationModelObject<E extends Geolocation> extends
			AbstractModelObject<E> {
		/**
		 * @generated
		 */
		public EClass eClass() {
			return JpaModelPackage.INSTANCE.getGeolocationEClass();
		}

		/**
		 * @generated
		 */
		public ModelPackage getModelPackage() {
			return JpaModelPackage.INSTANCE;
		}

		/**
		 * @generated
		 */
		@Override
		public Object eGet(EStructuralFeature eStructuralFeature) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {
			case JpaModelPackage.GEOLOCATION_LATITUDE_FEATURE_ID:
				return getTarget().getLatitude();
			case JpaModelPackage.GEOLOCATION_LONGITUDE_FEATURE_ID:
				return getTarget().getLongitude();
			case JpaModelPackage.GEOLOCATION_ELEVATION_FEATURE_ID:
				return getTarget().getElevation();
			default:
				return super.eGet(eStructuralFeature);
			}
		}

		/**
		 * @generated
		 */
		@Override
		public void eSet(EStructuralFeature eStructuralFeature, Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {
			case JpaModelPackage.GEOLOCATION_LATITUDE_FEATURE_ID:
				getTarget().setLatitude((Double) value);
				return;
			case JpaModelPackage.GEOLOCATION_LONGITUDE_FEATURE_ID:
				getTarget().setLongitude((Double) value);
				return;
			case JpaModelPackage.GEOLOCATION_ELEVATION_FEATURE_ID:
				getTarget().setElevation((Double) value);
				return;
			default:
				super.eSet(eStructuralFeature, value);
			}
		}

		/**
		 * @generated
		 */
		@Override
		public boolean eAddTo(EStructuralFeature eStructuralFeature,
				Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {

			default:
				return super.eAddTo(eStructuralFeature, value);
			}
		}

		/**
		 * @generated
		 */
		@Override
		public boolean eRemoveFrom(EStructuralFeature eStructuralFeature,
				Object value) {
			final int featureID = eClass().getFeatureID(eStructuralFeature);
			switch (featureID) {

			default:
				return super.eRemoveFrom(eStructuralFeature, value);
			}
		}
	}
}