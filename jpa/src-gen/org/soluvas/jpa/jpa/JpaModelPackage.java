package org.soluvas.jpa.jpa;

import java.time.DayOfWeek;
import java.util.Locale;
import java.util.UUID;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.texo.model.ModelFactory;
import org.eclipse.emf.texo.model.ModelPackage;
import org.eclipse.emf.texo.model.ModelResolver;
import org.eclipse.emf.texo.utils.ModelUtils;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.soluvas.commons.Gender;
import org.soluvas.commons.GenericStatus;

/**
 * The <b>Package</b> for the model '<em><b>jpa</b></em>'. It contains
 * initialization code and access to the Factory to instantiate types of this
 * package.
 *
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class JpaModelPackage extends ModelPackage {

	/**
	 * Is set when the package has been initialized.
	 * 
	 * @generated
	 */
	private static boolean isInitialized = false;

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String NS_URI = "http://www.soluvas.org/jpa.jpa/";

	/**
	 * The {@link ModelFactory} for this package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final JpaModelFactory MODELFACTORY = new JpaModelFactory();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int DATETIME_CLASSIFIER_ID = 8;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int UUID_CLASSIFIER_ID = 14;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GENDER_CLASSIFIER_ID = 16;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int CURRENCYUNIT_CLASSIFIER_ID = 7;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MASS_CLASSIFIER_ID = 9;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int LENGTH_CLASSIFIER_ID = 10;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int LOCALDATE_CLASSIFIER_ID = 11;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int QUANTITY_CLASSIFIER_ID = 12;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int UNIT_CLASSIFIER_ID = 13;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GENERICSTATUS_CLASSIFIER_ID = 15;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int DATETIMEZONE_CLASSIFIER_ID = 17;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int LOCALE_CLASSIFIER_ID = 18;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int DAYOFWEEK_CLASSIFIER_ID = 19;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int LOCALTIME_CLASSIFIER_ID = 20;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_CLASSIFIER_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_ID_FEATURE_ID = 1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_NAME_FEATURE_ID = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_ORGANIZATION_FEATURE_ID = 3;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_STREET_FEATURE_ID = 4;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_CITY_FEATURE_ID = 5;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_POSTALCODE_FEATURE_ID = 6;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PROVINCE_FEATURE_ID = 7;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_COUNTRY_FEATURE_ID = 8;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_COUNTRYCODE_FEATURE_ID = 9;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYMOBILE_FEATURE_ID = 10;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_MOBILES_FEATURE_ID = 11;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYPHONE_FEATURE_ID = 12;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PHONES_FEATURE_ID = 13;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYHOMEPHONE_FEATURE_ID = 14;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_HOMEPHONES_FEATURE_ID = 15;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYWORKPHONE_FEATURE_ID = 16;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_WORKPHONES_FEATURE_ID = 17;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYEMAIL_FEATURE_ID = 18;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_EMAILS_FEATURE_ID = 19;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARY_FEATURE_ID = 20;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYBILLING_FEATURE_ID = 21;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_PRIMARYSHIPPING_FEATURE_ID = 22;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_VALIDATIONTIME_FEATURE_ID = 23;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSTALADDRESS_DESCRIPTION_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int DESCRIBABLE_CLASSIFIER_ID = 4;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int DESCRIBABLE_DESCRIPTION_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GEOLOCATION_CLASSIFIER_ID = 1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GEOLOCATION_LATITUDE_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GEOLOCATION_LONGITUDE_FEATURE_ID = 1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int GEOLOCATION_ELEVATION_FEATURE_ID = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_CLASSIFIER_ID = 5;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_ID_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_NAME_FEATURE_ID = 1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_GENDER_FEATURE_ID = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_SLUG_FEATURE_ID = 3;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_EMAIL_FEATURE_ID = 4;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_PHOTOID_FEATURE_ID = 5;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int PERSONINFO_DOMAIN_FEATURE_ID = 6;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSITIONABLE_CLASSIFIER_ID = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int POSITIONABLE_POSITIONER_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int NAMECONTAINER_CLASSIFIER_ID = 3;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int NAMECONTAINER_NAME_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int TIMESTAMPED_CLASSIFIER_ID = 6;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int TIMESTAMPED_CREATIONTIME_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int TIMESTAMPED_MODIFICATIONTIME_FEATURE_ID = 1;

	/**
	 * The static member with the instance of this {@link ModelPackage}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final JpaModelPackage INSTANCE = initialize();

	/**
	 * Initializes this {@link ModelPackage}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return an initialized instance of this class
	 *
	 * @generated
	 */
	public static JpaModelPackage initialize() {

		if (isInitialized) {
			return (JpaModelPackage) ModelResolver.getInstance()
					.getModelPackage(NS_URI);
		}

		final JpaModelPackage modelPackage = new JpaModelPackage();

		ModelResolver.getInstance().registerModelPackage(modelPackage);

		// read the model from the ecore file, the EPackage is registered in the
		// EPackage.Registry
		// see the ModelResolver getEPackageRegistry method
		ModelUtils.readEPackagesFromFile(modelPackage);

		isInitialized = true;

		// force the initialization of the EFactory proxy
		modelPackage.getEPackage();

		// register the relation between a Class and its EClassifier
		ModelResolver.getInstance().registerClassModelMapping(
				PostalAddress.class, modelPackage.getPostalAddressEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(
				Describable.class, modelPackage.getDescribableEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(
				Geolocation.class, modelPackage.getGeolocationEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(PersonInfo.class,
				modelPackage.getPersonInfoEClass(), modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(
				Positionable.class, modelPackage.getPositionableEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(
				NameContainer.class, modelPackage.getNameContainerEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(
				Timestamped.class, modelPackage.getTimestampedEClass(),
				modelPackage);

		// and return ourselves
		return modelPackage;
	}

	/**
	 * Returns the {@link ModelFactory} of this ModelPackage. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the {@link JpaModelFactory} instance.
	 * @generated
	 */
	@Override
	public JpaModelFactory getModelFactory() {
		return MODELFACTORY;
	}

	/**
	 * Returns the nsUri of the {@link EPackage} managed by this Package
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the nsUri of the EPackage
	 * @generated
	 */
	@Override
	public String getNsURI() {
		return NS_URI;
	}

	/**
	 * Returns the name of the ecore file containing the ecore model of the
	 * {@link EPackage} managed here. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @return the name of the ecore file
	 * @generated
	 */
	@Override
	public String getEcoreFileName() {
		return "jpa.ecore";
	}

	/**
	 * Returns the {@link EClass} '<em><b>PostalAddress</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>PostalAddress</b></em>'
	 * @generated
	 */
	public EClass getPostalAddressEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				POSTALADDRESS_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PostalAddress.id</b></em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.id</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Id() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(POSTALADDRESS_ID_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.name</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.name</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Name() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(POSTALADDRESS_NAME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.organization</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.organization</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Organization() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_ORGANIZATION_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.street</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.street</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Street() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_STREET_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.city</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.city</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_City() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(POSTALADDRESS_CITY_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.postalCode</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.postalCode</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PostalCode() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_POSTALCODE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.province</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.province</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Province() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PROVINCE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.country</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.country</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Country() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_COUNTRY_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.countryCode</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.countryCode</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_CountryCode() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_COUNTRYCODE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryMobile</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryMobile</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryMobile() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYMOBILE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.mobiles</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.mobiles</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Mobiles() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_MOBILES_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryPhone</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryPhone</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryPhone() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYPHONE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.phones</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.phones</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Phones() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PHONES_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryHomePhone</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryHomePhone</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryHomePhone() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYHOMEPHONE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.homePhones</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.homePhones</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_HomePhones() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_HOMEPHONES_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryWorkPhone</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryWorkPhone</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryWorkPhone() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYWORKPHONE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.workPhones</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.workPhones</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_WorkPhones() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_WORKPHONES_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryEmail</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryEmail</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryEmail() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYEMAIL_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.emails</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.emails</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Emails() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_EMAILS_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primary</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primary</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Primary() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARY_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryBilling</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryBilling</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryBilling() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYBILLING_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.primaryShipping</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.primaryShipping</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryShipping() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_PRIMARYSHIPPING_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.validationTime</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.validationTime</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_ValidationTime() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_VALIDATIONTIME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PostalAddress.description</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PostalAddress.description</b></em>'.
	 * @generated
	 */
	public EAttribute getPostalAddress_Description() {
		return (EAttribute) getPostalAddressEClass()
				.getEAllStructuralFeatures().get(
						POSTALADDRESS_DESCRIPTION_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>Describable</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>Describable</b></em>'
	 * @generated
	 */
	public EClass getDescribableEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				DESCRIBABLE_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Describable.description</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Describable.description</b></em>'.
	 * @generated
	 */
	public EAttribute getDescribable_Description() {
		return (EAttribute) getDescribableEClass().getEAllStructuralFeatures()
				.get(DESCRIBABLE_DESCRIPTION_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>Geolocation</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>Geolocation</b></em>'
	 * @generated
	 */
	public EClass getGeolocationEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				GEOLOCATION_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Geolocation.latitude</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Geolocation.latitude</b></em>'.
	 * @generated
	 */
	public EAttribute getGeolocation_Latitude() {
		return (EAttribute) getGeolocationEClass().getEAllStructuralFeatures()
				.get(GEOLOCATION_LATITUDE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Geolocation.longitude</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Geolocation.longitude</b></em>'.
	 * @generated
	 */
	public EAttribute getGeolocation_Longitude() {
		return (EAttribute) getGeolocationEClass().getEAllStructuralFeatures()
				.get(GEOLOCATION_LONGITUDE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Geolocation.elevation</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Geolocation.elevation</b></em>'.
	 * @generated
	 */
	public EAttribute getGeolocation_Elevation() {
		return (EAttribute) getGeolocationEClass().getEAllStructuralFeatures()
				.get(GEOLOCATION_ELEVATION_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>PersonInfo</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>PersonInfo</b></em>'
	 * @generated
	 */
	public EClass getPersonInfoEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				PERSONINFO_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.id</b></em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.id</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Id() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_ID_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.name</b></em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.name</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Name() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_NAME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.gender</b></em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.gender</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Gender() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_GENDER_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.slug</b></em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.slug</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Slug() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_SLUG_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.email</b></em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.email</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Email() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_EMAIL_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>PersonInfo.photoId</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.photoId</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_PhotoId() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_PHOTOID_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>PersonInfo.domain</b></em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>PersonInfo.domain</b></em>'.
	 * @generated
	 */
	public EAttribute getPersonInfo_Domain() {
		return (EAttribute) getPersonInfoEClass().getEAllStructuralFeatures()
				.get(PERSONINFO_DOMAIN_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>Positionable</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>Positionable</b></em>'
	 * @generated
	 */
	public EClass getPositionableEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				POSITIONABLE_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Positionable.positioner</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Positionable.positioner</b></em>'.
	 * @generated
	 */
	public EAttribute getPositionable_Positioner() {
		return (EAttribute) getPositionableEClass().getEAllStructuralFeatures()
				.get(POSITIONABLE_POSITIONER_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>NameContainer</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>NameContainer</b></em>'
	 * @generated
	 */
	public EClass getNameContainerEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				NAMECONTAINER_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>NameContainer.name</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>NameContainer.name</b></em>'.
	 * @generated
	 */
	public EAttribute getNameContainer_Name() {
		return (EAttribute) getNameContainerEClass()
				.getEAllStructuralFeatures().get(NAMECONTAINER_NAME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>Timestamped</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>Timestamped</b></em>'
	 * @generated
	 */
	public EClass getTimestampedEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				TIMESTAMPED_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Timestamped.creationTime</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Timestamped.creationTime</b></em>'.
	 * @generated
	 */
	public EAttribute getTimestamped_CreationTime() {
		return (EAttribute) getTimestampedEClass().getEAllStructuralFeatures()
				.get(TIMESTAMPED_CREATIONTIME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>Timestamped.modificationTime</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>Timestamped.modificationTime</b></em>'.
	 * @generated
	 */
	public EAttribute getTimestamped_ModificationTime() {
		return (EAttribute) getTimestampedEClass().getEAllStructuralFeatures()
				.get(TIMESTAMPED_MODIFICATIONTIME_FEATURE_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>DateTime</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>DateTime</b></em>'
	 * @generated
	 */
	public EDataType getDateTimeEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				DATETIME_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>UUID</b></em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>UUID</b></em>'
	 * @generated
	 */
	public EDataType getUUIDEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				UUID_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Gender</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Gender</b></em>'
	 * @generated
	 */
	public EDataType getGenderEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				GENDER_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>CurrencyUnit</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>CurrencyUnit</b></em>'
	 * @generated
	 */
	public EDataType getCurrencyUnitEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				CURRENCYUNIT_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Mass</b></em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Mass</b></em>'
	 * @generated
	 */
	public EDataType getMassEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				MASS_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Length</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Length</b></em>'
	 * @generated
	 */
	public EDataType getLengthEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				LENGTH_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>LocalDate</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>LocalDate</b></em>'
	 * @generated
	 */
	public EDataType getLocalDateEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				LOCALDATE_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Quantity</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Quantity</b></em>'
	 * @generated
	 */
	public EDataType getQuantityEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				QUANTITY_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Unit</b></em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Unit</b></em>'
	 * @generated
	 */
	public EDataType getUnitEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				UNIT_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>GenericStatus</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>GenericStatus</b></em>'
	 * @generated
	 */
	public EDataType getGenericStatusEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				GENERICSTATUS_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>DateTimeZone</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>DateTimeZone</b></em>'
	 * @generated
	 */
	public EDataType getDateTimeZoneEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				DATETIMEZONE_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>Locale</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>Locale</b></em>'
	 * @generated
	 */
	public EDataType getLocaleEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				LOCALE_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>DayOfWeek</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>DayOfWeek</b></em>'
	 * @generated
	 */
	public EDataType getDayOfWeekEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				DAYOFWEEK_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EDataType} '<em><b>LocalTime</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EDataType} representing '
	 *         <em><b>LocalTime</b></em>'
	 * @generated
	 */
	public EDataType getLocalTimeEDataType() {
		return (EDataType) getEPackage().getEClassifiers().get(
				LOCALTIME_CLASSIFIER_ID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param eClassifier
	 *            the {@link EClassifier}
	 * @return the class implementing a specific {@link EClass}.
	 * @generated
	 */
	@Override
	public Class<?> getEClassifierClass(EClassifier eClassifier) {
		switch (eClassifier.getClassifierID()) {
		case POSTALADDRESS_CLASSIFIER_ID:
			return PostalAddress.class;
		case DESCRIBABLE_CLASSIFIER_ID:
			return Describable.class;
		case GEOLOCATION_CLASSIFIER_ID:
			return Geolocation.class;
		case PERSONINFO_CLASSIFIER_ID:
			return PersonInfo.class;
		case POSITIONABLE_CLASSIFIER_ID:
			return Positionable.class;
		case NAMECONTAINER_CLASSIFIER_ID:
			return NameContainer.class;
		case TIMESTAMPED_CLASSIFIER_ID:
			return Timestamped.class;
		case DATETIME_CLASSIFIER_ID:
			return DateTime.class;
		case UUID_CLASSIFIER_ID:
			return UUID.class;
		case GENDER_CLASSIFIER_ID:
			return Gender.class;
		case CURRENCYUNIT_CLASSIFIER_ID:
			return CurrencyUnit.class;
		case MASS_CLASSIFIER_ID:
			return Mass.class;
		case LENGTH_CLASSIFIER_ID:
			return Length.class;
		case LOCALDATE_CLASSIFIER_ID:
			return LocalDate.class;
		case QUANTITY_CLASSIFIER_ID:
			return Quantity.class;
		case UNIT_CLASSIFIER_ID:
			return Unit.class;
		case GENERICSTATUS_CLASSIFIER_ID:
			return GenericStatus.class;
		case DATETIMEZONE_CLASSIFIER_ID:
			return DateTimeZone.class;
		case LOCALE_CLASSIFIER_ID:
			return Locale.class;
		case DAYOFWEEK_CLASSIFIER_ID:
			return DayOfWeek.class;
		case LOCALTIME_CLASSIFIER_ID:
			return LocalTime.class;
		default:
			throw new IllegalArgumentException("The EClassifier '"
					+ eClassifier + "' is not defined in this EPackage");
		}
	}
}
