package org.soluvas.commons.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;

import javax.measure.Measurable;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.joda.money.BigMoneyProvider;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.osgi.framework.Bundle;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Added;
import org.soluvas.commons.AddedMany;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.AttributeNotification;
import org.soluvas.commons.AttributeSet;
import org.soluvas.commons.AttributeUnset;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CanonicalSluggable;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CategoryLike;
import org.soluvas.commons.Colorable;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Describable;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.EObjectLinked;
import org.soluvas.commons.Email;
import org.soluvas.commons.EventBusProgressMonitor;
import org.soluvas.commons.Expandable;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.Informer;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.JavaClassStatus;
import org.soluvas.commons.ModelNotification;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ObjectNotification;
import org.soluvas.commons.ObjectsNotification;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonCatalog;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PersonLike;
import org.soluvas.commons.PhoneNumber;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.ProgressMonitorWrapper;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.PublicationStatus;
import org.soluvas.commons.Removed;
import org.soluvas.commons.RemovedMany;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.Sluggable;
import org.soluvas.commons.StyleConfiguration;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.Translatable;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationManager;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.WebAddress;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonsPackageImpl extends EPackageImpl implements CommonsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceAwareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appManifestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timestampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sluggableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass photoIdContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass describableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleAwareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaClassLinkedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassLinkedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schemaVersionableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFactoryLinkedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nsPrefixableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeUnsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addedManyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removedManyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectsNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectLinkedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass progressMonitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shellProgressMonitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventBusProgressMonitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass progressMonitorWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translatableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationMessageEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translationEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phoneNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emailEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postalAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass canonicalSluggableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eClassStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum javaClassStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum progressStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accountStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum publicationStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum archivalStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum translationStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expansionStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum signupSourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dateTimeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType currencyUnitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType setEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType collectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType multimapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType navigableMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType queueEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType multisetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serializableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bundleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bigMoneyProviderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType quantityEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType measurableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dateTimeZoneEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType localeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fileEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listenableFutureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listeningExecutorServiceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classLoaderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType urlEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eventBusEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType localDateEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.soluvas.commons.CommonsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonsPackageImpl() {
		super(eNS_URI, CommonsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CommonsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommonsPackage init() {
		if (isInited) return (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

		// Obtain or create and register package
		CommonsPackageImpl theCommonsPackage = (CommonsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCommonsPackage.createPackageContents();

		// Initialize created meta-data
		theCommonsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonsPackage.eNS_URI, theCommonsPackage);
		return theCommonsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceAware() {
		return resourceAwareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceAware_ResourceType() {
		return (EAttribute)resourceAwareEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceAware_ResourceUri() {
		return (EAttribute)resourceAwareEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceAware_ResourceName() {
		return (EAttribute)resourceAwareEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPositionable() {
		return positionableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPositionable_Positioner() {
		return (EAttribute)positionableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppManifest() {
		return appManifestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_Title() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_Description() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_Domain() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_GeneralEmail() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_OrganizationName() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_OrganizationAddress() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_LetterSalutation() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_LetterClosing() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultTimeZoneId() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultTimeZone() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultCurrencyCode() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultCurrency() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPersonInfo() {
		return personInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonInfo_Gender() {
		return (EAttribute)personInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPersonInfo_Email() {
		return (EAttribute)personInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTimestamped() {
		return timestampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimestamped_CreationTime() {
		return (EAttribute)timestampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTimestamped_ModificationTime() {
		return (EAttribute)timestampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIdentifiable_Id() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSluggable() {
		return sluggableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSluggable_Slug() {
		return (EAttribute)sluggableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageable() {
		return imageableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPhotoIdContainer() {
		return photoIdContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPhotoIdContainer_PhotoId() {
		return (EAttribute)photoIdContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNameContainer() {
		return nameContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNameContainer_Name() {
		return (EAttribute)nameContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInformer() {
		return informerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescribable() {
		return describableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDescribable_Description() {
		return (EAttribute)describableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBundleAware() {
		return bundleAwareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBundleAware_Bundle() {
		return (EAttribute)bundleAwareEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaClassLinked() {
		return javaClassLinkedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaClassLinked_JavaClassName() {
		return (EAttribute)javaClassLinkedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaClassLinked_JavaClass() {
		return (EAttribute)javaClassLinkedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaClassLinked_JavaClassStatus() {
		return (EAttribute)javaClassLinkedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEClassLinked() {
		return eClassLinkedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEClassLinked_EClass() {
		return (EReference)eClassLinkedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEClassLinked_EClassStatus() {
		return (EAttribute)eClassLinkedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEClassLinked_EPackageNsPrefix() {
		return (EAttribute)eClassLinkedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEClassLinked_EClassName() {
		return (EAttribute)eClassLinkedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEClassLinked_EPackageName() {
		return (EAttribute)eClassLinkedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSchemaVersionable() {
		return schemaVersionableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEFactoryLinked() {
		return eFactoryLinkedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEFactoryLinked_EFactory() {
		return (EReference)eFactoryLinkedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNsPrefixable() {
		return nsPrefixableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNsPrefixable_NsPrefix() {
		return (EAttribute)nsPrefixableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWebAddress() {
		return webAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_BaseUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_BasePath() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_ApiPath() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_ImagesUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_SkinUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_JsUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_SecureBaseUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_SecureImagesUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_SecureSkinUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWebAddress_SecureJsUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAdded() {
		return addedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelNotification() {
		return modelNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelNotification_Container() {
		return (EReference)modelNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeSet() {
		return attributeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeUnset() {
		return attributeUnsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRemoved() {
		return removedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectNotification() {
		return objectNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectNotification_Object() {
		return (EAttribute)objectNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeNotification() {
		return attributeNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeNotification_Attribute() {
		return (EReference)attributeNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeNotification_Object() {
		return (EAttribute)attributeNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeNotification_OldValue() {
		return (EAttribute)attributeNotificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeNotification_NewValue() {
		return (EAttribute)attributeNotificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddedMany() {
		return addedManyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRemovedMany() {
		return removedManyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectsNotification() {
		return objectsNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectsNotification_Objects() {
		return (EAttribute)objectsNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEObjectLinked() {
		return eObjectLinkedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParentable() {
		return parentableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParentable_Parent() {
		return (EReference)parentableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryLike() {
		return categoryLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryLike_SlugPath() {
		return (EAttribute)categoryLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryLike_Color() {
		return (EAttribute)categoryLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryLike_ImageId() {
		return (EAttribute)categoryLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryLike_Level() {
		return (EAttribute)categoryLikeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategoryLike_CategoryCount() {
		return (EAttribute)categoryLikeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategoryInfo() {
		return categoryInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategoryInfo_Parents() {
		return (EReference)categoryInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProgressMonitor() {
		return progressMonitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProgressMonitor_Canceled() {
		return (EAttribute)progressMonitorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProgressMonitor_TaskName() {
		return (EAttribute)progressMonitorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShellProgressMonitor() {
		return shellProgressMonitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEventBusProgressMonitor() {
		return eventBusProgressMonitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEventBusProgressMonitor_EventBus() {
		return (EAttribute)eventBusProgressMonitorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEventBusProgressMonitor_TrackingId() {
		return (EAttribute)eventBusProgressMonitorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProgressMonitorWrapper() {
		return progressMonitorWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProgressMonitorWrapper_Delegate() {
		return (EReference)progressMonitorWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColorable() {
		return colorableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorable_Color() {
		return (EAttribute)colorableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranslatable() {
		return translatableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslatable_TranslationState() {
		return (EAttribute)translatableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslatable_OriginalLanguage() {
		return (EAttribute)translatableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslatable_Language() {
		return (EAttribute)translatableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTranslatable_Translations() {
		return (EReference)translatableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranslation() {
		return translationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslation_Language() {
		return (EAttribute)translationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTranslation_Messages() {
		return (EReference)translationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranslationMessageEntry() {
		return translationMessageEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslationMessageEntry_Key() {
		return (EAttribute)translationMessageEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslationMessageEntry_Value() {
		return (EAttribute)translationMessageEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranslationManager() {
		return translationManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTranslationEntry() {
		return translationEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTranslationEntry_Value() {
		return (EReference)translationEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTranslationEntry_Key() {
		return (EAttribute)translationEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStyleConfiguration() {
		return styleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpandable() {
		return expandableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpandable_ExpansionState() {
		return (EAttribute)expandableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonLike() {
		return personLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SchemaVersion() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FirstName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Password() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_PhoneNumbers() {
		return (EReference)personEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Emails() {
		return (EReference)personEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_MobileNumbers() {
		return (EReference)personEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Addresses() {
		return (EReference)personEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_AccountStatus() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_BirthYear() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_BirthMonth() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_BirthDay() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_BirthDate() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Gender() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Language() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_CurrencyCode() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Currency() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FacebookId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FacebookUsername() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FacebookAccessToken() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TwitterId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TwitterScreenName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TwitterAccessToken() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TwitterAccessTokenSecret() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_GooglePlusId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_GoogleUsername() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_VirtualMail() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Nickname() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_CustomerRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_MemberRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ManagerRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TimeZoneId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TimeZone() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ReferrerId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ReferrerType() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SignupSource() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SignupSourceType() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_IpAddress() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastIpAddress() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastLoginTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ValidationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ActivationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_VerificationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NewsletterSubscriptionEnabled() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NewsletterSubscriptionTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SocialSharingEnabled() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PublicationStatus() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ArchivalStatus() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Folder() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Religion() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PasswordResetCode() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PasswordResetExpiryTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhoneNumber() {
		return phoneNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNumber_PhoneNumber() {
		return (EAttribute)phoneNumberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNumber_Primary() {
		return (EAttribute)phoneNumberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhoneNumber_ValidationTime() {
		return (EAttribute)phoneNumberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmail() {
		return emailEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmail_Email() {
		return (EAttribute)emailEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmail_Primary() {
		return (EAttribute)emailEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmail_ValidationTime() {
		return (EAttribute)emailEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostalAddress() {
		return postalAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_SchemaVersion() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Organization() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Street() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_City() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PostalCode() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Province() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Country() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_CountryCode() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryMobile() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Mobiles() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryPhone() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Phones() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryHomePhone() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_HomePhones() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryWorkPhone() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_WorkPhones() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryEmail() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Emails() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Description() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_Primary() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryBilling() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_PrimaryShipping() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostalAddress_ValidationTime() {
		return (EAttribute)postalAddressEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonCatalog() {
		return personCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonCatalog_People() {
		return (EReference)personCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCanonicalSluggable() {
		return canonicalSluggableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCanonicalSluggable_CanonicalSlug() {
		return (EAttribute)canonicalSluggableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getResourceType() {
		return resourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGender() {
		return genderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEClassStatus() {
		return eClassStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getJavaClassStatus() {
		return javaClassStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getProgressStatus() {
		return progressStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAccountStatus() {
		return accountStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPublicationStatus() {
		return publicationStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getArchivalStatus() {
		return archivalStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTranslationState() {
		return translationStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getExpansionState() {
		return expansionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSignupSourceType() {
		return signupSourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDateTime() {
		return dateTimeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCurrencyUnit() {
		return currencyUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUnit() {
		return unitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMap() {
		return mapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSet() {
		return setEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCollection() {
		return collectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMultimap() {
		return multimapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getNavigableMap() {
		return navigableMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getQueue() {
		return queueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMultiset() {
		return multisetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSerializable() {
		return serializableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getBundle() {
		return bundleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getBigMoneyProvider() {
		return bigMoneyProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getQuantity() {
		return quantityEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMeasurable() {
		return measurableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDateTimeZone() {
		return dateTimeZoneEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLocale() {
		return localeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getFile() {
		return fileEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getListenableFuture() {
		return listenableFutureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getListeningExecutorService() {
		return listeningExecutorServiceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getClassLoader() {
		return classLoaderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getURL() {
		return urlEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEventBus() {
		return eventBusEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLocalDate() {
		return localDateEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommonsFactory getCommonsFactory() {
		return (CommonsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		resourceAwareEClass = createEClass(RESOURCE_AWARE);
		createEAttribute(resourceAwareEClass, RESOURCE_AWARE__RESOURCE_TYPE);
		createEAttribute(resourceAwareEClass, RESOURCE_AWARE__RESOURCE_URI);
		createEAttribute(resourceAwareEClass, RESOURCE_AWARE__RESOURCE_NAME);

		positionableEClass = createEClass(POSITIONABLE);
		createEAttribute(positionableEClass, POSITIONABLE__POSITIONER);

		appManifestEClass = createEClass(APP_MANIFEST);
		createEAttribute(appManifestEClass, APP_MANIFEST__TITLE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DESCRIPTION);
		createEAttribute(appManifestEClass, APP_MANIFEST__DOMAIN);
		createEAttribute(appManifestEClass, APP_MANIFEST__GENERAL_EMAIL);
		createEAttribute(appManifestEClass, APP_MANIFEST__ORGANIZATION_NAME);
		createEAttribute(appManifestEClass, APP_MANIFEST__ORGANIZATION_ADDRESS);
		createEAttribute(appManifestEClass, APP_MANIFEST__LETTER_SALUTATION);
		createEAttribute(appManifestEClass, APP_MANIFEST__LETTER_CLOSING);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_TIME_ZONE_ID);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_TIME_ZONE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_CURRENCY_CODE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_CURRENCY);

		personInfoEClass = createEClass(PERSON_INFO);
		createEAttribute(personInfoEClass, PERSON_INFO__GENDER);
		createEAttribute(personInfoEClass, PERSON_INFO__EMAIL);

		timestampedEClass = createEClass(TIMESTAMPED);
		createEAttribute(timestampedEClass, TIMESTAMPED__CREATION_TIME);
		createEAttribute(timestampedEClass, TIMESTAMPED__MODIFICATION_TIME);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

		sluggableEClass = createEClass(SLUGGABLE);
		createEAttribute(sluggableEClass, SLUGGABLE__SLUG);

		nameableEClass = createEClass(NAMEABLE);

		imageableEClass = createEClass(IMAGEABLE);

		photoIdContainerEClass = createEClass(PHOTO_ID_CONTAINER);
		createEAttribute(photoIdContainerEClass, PHOTO_ID_CONTAINER__PHOTO_ID);

		nameContainerEClass = createEClass(NAME_CONTAINER);
		createEAttribute(nameContainerEClass, NAME_CONTAINER__NAME);

		informerEClass = createEClass(INFORMER);

		describableEClass = createEClass(DESCRIBABLE);
		createEAttribute(describableEClass, DESCRIBABLE__DESCRIPTION);

		bundleAwareEClass = createEClass(BUNDLE_AWARE);
		createEAttribute(bundleAwareEClass, BUNDLE_AWARE__BUNDLE);

		javaClassLinkedEClass = createEClass(JAVA_CLASS_LINKED);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS_NAME);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS_STATUS);

		eClassLinkedEClass = createEClass(ECLASS_LINKED);
		createEReference(eClassLinkedEClass, ECLASS_LINKED__ECLASS);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__ECLASS_STATUS);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__EPACKAGE_NS_PREFIX);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__ECLASS_NAME);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__EPACKAGE_NAME);

		schemaVersionableEClass = createEClass(SCHEMA_VERSIONABLE);

		eFactoryLinkedEClass = createEClass(EFACTORY_LINKED);
		createEReference(eFactoryLinkedEClass, EFACTORY_LINKED__EFACTORY);

		nsPrefixableEClass = createEClass(NS_PREFIXABLE);
		createEAttribute(nsPrefixableEClass, NS_PREFIXABLE__NS_PREFIX);

		webAddressEClass = createEClass(WEB_ADDRESS);
		createEAttribute(webAddressEClass, WEB_ADDRESS__BASE_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__BASE_PATH);
		createEAttribute(webAddressEClass, WEB_ADDRESS__API_PATH);
		createEAttribute(webAddressEClass, WEB_ADDRESS__IMAGES_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SKIN_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__JS_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_BASE_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_IMAGES_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_SKIN_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_JS_URI);

		addedEClass = createEClass(ADDED);

		modelNotificationEClass = createEClass(MODEL_NOTIFICATION);
		createEReference(modelNotificationEClass, MODEL_NOTIFICATION__CONTAINER);

		attributeSetEClass = createEClass(ATTRIBUTE_SET);

		attributeUnsetEClass = createEClass(ATTRIBUTE_UNSET);

		removedEClass = createEClass(REMOVED);

		objectNotificationEClass = createEClass(OBJECT_NOTIFICATION);
		createEAttribute(objectNotificationEClass, OBJECT_NOTIFICATION__OBJECT);

		attributeNotificationEClass = createEClass(ATTRIBUTE_NOTIFICATION);
		createEReference(attributeNotificationEClass, ATTRIBUTE_NOTIFICATION__ATTRIBUTE);
		createEAttribute(attributeNotificationEClass, ATTRIBUTE_NOTIFICATION__OBJECT);
		createEAttribute(attributeNotificationEClass, ATTRIBUTE_NOTIFICATION__OLD_VALUE);
		createEAttribute(attributeNotificationEClass, ATTRIBUTE_NOTIFICATION__NEW_VALUE);

		addedManyEClass = createEClass(ADDED_MANY);

		removedManyEClass = createEClass(REMOVED_MANY);

		objectsNotificationEClass = createEClass(OBJECTS_NOTIFICATION);
		createEAttribute(objectsNotificationEClass, OBJECTS_NOTIFICATION__OBJECTS);

		eObjectLinkedEClass = createEClass(EOBJECT_LINKED);

		parentableEClass = createEClass(PARENTABLE);
		createEReference(parentableEClass, PARENTABLE__PARENT);

		categoryLikeEClass = createEClass(CATEGORY_LIKE);
		createEAttribute(categoryLikeEClass, CATEGORY_LIKE__SLUG_PATH);
		createEAttribute(categoryLikeEClass, CATEGORY_LIKE__COLOR);
		createEAttribute(categoryLikeEClass, CATEGORY_LIKE__IMAGE_ID);
		createEAttribute(categoryLikeEClass, CATEGORY_LIKE__LEVEL);
		createEAttribute(categoryLikeEClass, CATEGORY_LIKE__CATEGORY_COUNT);

		categoryInfoEClass = createEClass(CATEGORY_INFO);
		createEReference(categoryInfoEClass, CATEGORY_INFO__PARENTS);

		progressMonitorEClass = createEClass(PROGRESS_MONITOR);
		createEAttribute(progressMonitorEClass, PROGRESS_MONITOR__CANCELED);
		createEAttribute(progressMonitorEClass, PROGRESS_MONITOR__TASK_NAME);

		shellProgressMonitorEClass = createEClass(SHELL_PROGRESS_MONITOR);

		eventBusProgressMonitorEClass = createEClass(EVENT_BUS_PROGRESS_MONITOR);
		createEAttribute(eventBusProgressMonitorEClass, EVENT_BUS_PROGRESS_MONITOR__EVENT_BUS);
		createEAttribute(eventBusProgressMonitorEClass, EVENT_BUS_PROGRESS_MONITOR__TRACKING_ID);

		progressMonitorWrapperEClass = createEClass(PROGRESS_MONITOR_WRAPPER);
		createEReference(progressMonitorWrapperEClass, PROGRESS_MONITOR_WRAPPER__DELEGATE);

		colorableEClass = createEClass(COLORABLE);
		createEAttribute(colorableEClass, COLORABLE__COLOR);

		translatableEClass = createEClass(TRANSLATABLE);
		createEAttribute(translatableEClass, TRANSLATABLE__TRANSLATION_STATE);
		createEAttribute(translatableEClass, TRANSLATABLE__ORIGINAL_LANGUAGE);
		createEAttribute(translatableEClass, TRANSLATABLE__LANGUAGE);
		createEReference(translatableEClass, TRANSLATABLE__TRANSLATIONS);

		translationEClass = createEClass(TRANSLATION);
		createEAttribute(translationEClass, TRANSLATION__LANGUAGE);
		createEReference(translationEClass, TRANSLATION__MESSAGES);

		translationMessageEntryEClass = createEClass(TRANSLATION_MESSAGE_ENTRY);
		createEAttribute(translationMessageEntryEClass, TRANSLATION_MESSAGE_ENTRY__KEY);
		createEAttribute(translationMessageEntryEClass, TRANSLATION_MESSAGE_ENTRY__VALUE);

		translationManagerEClass = createEClass(TRANSLATION_MANAGER);

		translationEntryEClass = createEClass(TRANSLATION_ENTRY);
		createEReference(translationEntryEClass, TRANSLATION_ENTRY__VALUE);
		createEAttribute(translationEntryEClass, TRANSLATION_ENTRY__KEY);

		styleConfigurationEClass = createEClass(STYLE_CONFIGURATION);

		expandableEClass = createEClass(EXPANDABLE);
		createEAttribute(expandableEClass, EXPANDABLE__EXPANSION_STATE);

		personLikeEClass = createEClass(PERSON_LIKE);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__SCHEMA_VERSION);
		createEAttribute(personEClass, PERSON__FIRST_NAME);
		createEAttribute(personEClass, PERSON__LAST_NAME);
		createEAttribute(personEClass, PERSON__PASSWORD);
		createEReference(personEClass, PERSON__PHONE_NUMBERS);
		createEReference(personEClass, PERSON__EMAILS);
		createEReference(personEClass, PERSON__MOBILE_NUMBERS);
		createEReference(personEClass, PERSON__ADDRESSES);
		createEAttribute(personEClass, PERSON__ACCOUNT_STATUS);
		createEAttribute(personEClass, PERSON__BIRTH_YEAR);
		createEAttribute(personEClass, PERSON__BIRTH_MONTH);
		createEAttribute(personEClass, PERSON__BIRTH_DAY);
		createEAttribute(personEClass, PERSON__BIRTH_DATE);
		createEAttribute(personEClass, PERSON__GENDER);
		createEAttribute(personEClass, PERSON__LANGUAGE);
		createEAttribute(personEClass, PERSON__CURRENCY_CODE);
		createEAttribute(personEClass, PERSON__CURRENCY);
		createEAttribute(personEClass, PERSON__FACEBOOK_ID);
		createEAttribute(personEClass, PERSON__FACEBOOK_USERNAME);
		createEAttribute(personEClass, PERSON__FACEBOOK_ACCESS_TOKEN);
		createEAttribute(personEClass, PERSON__TWITTER_ID);
		createEAttribute(personEClass, PERSON__TWITTER_SCREEN_NAME);
		createEAttribute(personEClass, PERSON__TWITTER_ACCESS_TOKEN);
		createEAttribute(personEClass, PERSON__TWITTER_ACCESS_TOKEN_SECRET);
		createEAttribute(personEClass, PERSON__GOOGLE_PLUS_ID);
		createEAttribute(personEClass, PERSON__GOOGLE_USERNAME);
		createEAttribute(personEClass, PERSON__VIRTUAL_MAIL);
		createEAttribute(personEClass, PERSON__NICKNAME);
		createEAttribute(personEClass, PERSON__CUSTOMER_ROLE);
		createEAttribute(personEClass, PERSON__MEMBER_ROLE);
		createEAttribute(personEClass, PERSON__MANAGER_ROLE);
		createEAttribute(personEClass, PERSON__TIME_ZONE_ID);
		createEAttribute(personEClass, PERSON__TIME_ZONE);
		createEAttribute(personEClass, PERSON__REFERRER_ID);
		createEAttribute(personEClass, PERSON__REFERRER_TYPE);
		createEAttribute(personEClass, PERSON__SIGNUP_SOURCE);
		createEAttribute(personEClass, PERSON__SIGNUP_SOURCE_TYPE);
		createEAttribute(personEClass, PERSON__IP_ADDRESS);
		createEAttribute(personEClass, PERSON__LAST_IP_ADDRESS);
		createEAttribute(personEClass, PERSON__LAST_LOGIN_TIME);
		createEAttribute(personEClass, PERSON__VALIDATION_TIME);
		createEAttribute(personEClass, PERSON__ACTIVATION_TIME);
		createEAttribute(personEClass, PERSON__VERIFICATION_TIME);
		createEAttribute(personEClass, PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED);
		createEAttribute(personEClass, PERSON__NEWSLETTER_SUBSCRIPTION_TIME);
		createEAttribute(personEClass, PERSON__SOCIAL_SHARING_ENABLED);
		createEAttribute(personEClass, PERSON__PUBLICATION_STATUS);
		createEAttribute(personEClass, PERSON__ARCHIVAL_STATUS);
		createEAttribute(personEClass, PERSON__FOLDER);
		createEAttribute(personEClass, PERSON__RELIGION);
		createEAttribute(personEClass, PERSON__PASSWORD_RESET_CODE);
		createEAttribute(personEClass, PERSON__PASSWORD_RESET_EXPIRY_TIME);

		phoneNumberEClass = createEClass(PHONE_NUMBER);
		createEAttribute(phoneNumberEClass, PHONE_NUMBER__PHONE_NUMBER);
		createEAttribute(phoneNumberEClass, PHONE_NUMBER__PRIMARY);
		createEAttribute(phoneNumberEClass, PHONE_NUMBER__VALIDATION_TIME);

		emailEClass = createEClass(EMAIL);
		createEAttribute(emailEClass, EMAIL__EMAIL);
		createEAttribute(emailEClass, EMAIL__PRIMARY);
		createEAttribute(emailEClass, EMAIL__VALIDATION_TIME);

		postalAddressEClass = createEClass(POSTAL_ADDRESS);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__SCHEMA_VERSION);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__ORGANIZATION);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__STREET);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__CITY);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__POSTAL_CODE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PROVINCE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__COUNTRY);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__COUNTRY_CODE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_MOBILE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__MOBILES);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_PHONE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PHONES);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_HOME_PHONE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__HOME_PHONES);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_WORK_PHONE);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__WORK_PHONES);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_EMAIL);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__EMAILS);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__DESCRIPTION);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_BILLING);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__PRIMARY_SHIPPING);
		createEAttribute(postalAddressEClass, POSTAL_ADDRESS__VALIDATION_TIME);

		personCatalogEClass = createEClass(PERSON_CATALOG);
		createEReference(personCatalogEClass, PERSON_CATALOG__PEOPLE);

		canonicalSluggableEClass = createEClass(CANONICAL_SLUGGABLE);
		createEAttribute(canonicalSluggableEClass, CANONICAL_SLUGGABLE__CANONICAL_SLUG);

		// Create enums
		resourceTypeEEnum = createEEnum(RESOURCE_TYPE);
		genderEEnum = createEEnum(GENDER);
		eClassStatusEEnum = createEEnum(ECLASS_STATUS);
		javaClassStatusEEnum = createEEnum(JAVA_CLASS_STATUS);
		progressStatusEEnum = createEEnum(PROGRESS_STATUS);
		accountStatusEEnum = createEEnum(ACCOUNT_STATUS);
		publicationStatusEEnum = createEEnum(PUBLICATION_STATUS);
		archivalStatusEEnum = createEEnum(ARCHIVAL_STATUS);
		translationStateEEnum = createEEnum(TRANSLATION_STATE);
		expansionStateEEnum = createEEnum(EXPANSION_STATE);
		signupSourceTypeEEnum = createEEnum(SIGNUP_SOURCE_TYPE);

		// Create data types
		dateTimeEDataType = createEDataType(DATE_TIME);
		currencyUnitEDataType = createEDataType(CURRENCY_UNIT);
		quantityEDataType = createEDataType(QUANTITY);
		unitEDataType = createEDataType(UNIT);
		listEDataType = createEDataType(LIST);
		mapEDataType = createEDataType(MAP);
		setEDataType = createEDataType(SET);
		collectionEDataType = createEDataType(COLLECTION);
		multimapEDataType = createEDataType(MULTIMAP);
		navigableMapEDataType = createEDataType(NAVIGABLE_MAP);
		queueEDataType = createEDataType(QUEUE);
		multisetEDataType = createEDataType(MULTISET);
		serializableEDataType = createEDataType(SERIALIZABLE);
		bundleEDataType = createEDataType(BUNDLE);
		bigMoneyProviderEDataType = createEDataType(BIG_MONEY_PROVIDER);
		measurableEDataType = createEDataType(MEASURABLE);
		dateTimeZoneEDataType = createEDataType(DATE_TIME_ZONE);
		localeEDataType = createEDataType(LOCALE);
		fileEDataType = createEDataType(FILE);
		listenableFutureEDataType = createEDataType(LISTENABLE_FUTURE);
		listeningExecutorServiceEDataType = createEDataType(LISTENING_EXECUTOR_SERVICE);
		classLoaderEDataType = createEDataType(CLASS_LOADER);
		urlEDataType = createEDataType(URL);
		eventBusEDataType = createEDataType(EVENT_BUS);
		localDateEDataType = createEDataType(LOCAL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		ETypeParameter informerEClass_T = addETypeParameter(informerEClass, "T");
		ETypeParameter javaClassLinkedEClass_T = addETypeParameter(javaClassLinkedEClass, "T");
		ETypeParameter addedEClass_T = addETypeParameter(addedEClass, "T");
		ETypeParameter modelNotificationEClass_T = addETypeParameter(modelNotificationEClass, "T");
		ETypeParameter attributeSetEClass_T = addETypeParameter(attributeSetEClass, "T");
		ETypeParameter attributeSetEClass_V = addETypeParameter(attributeSetEClass, "V");
		ETypeParameter attributeUnsetEClass_T = addETypeParameter(attributeUnsetEClass, "T");
		ETypeParameter attributeUnsetEClass_V = addETypeParameter(attributeUnsetEClass, "V");
		ETypeParameter removedEClass_T = addETypeParameter(removedEClass, "T");
		ETypeParameter objectNotificationEClass_T = addETypeParameter(objectNotificationEClass, "T");
		ETypeParameter attributeNotificationEClass_T = addETypeParameter(attributeNotificationEClass, "T");
		ETypeParameter attributeNotificationEClass_V = addETypeParameter(attributeNotificationEClass, "V");
		ETypeParameter addedManyEClass_T = addETypeParameter(addedManyEClass, "T");
		ETypeParameter removedManyEClass_T = addETypeParameter(removedManyEClass, "T");
		ETypeParameter objectsNotificationEClass_T = addETypeParameter(objectsNotificationEClass, "T");
		ETypeParameter eObjectLinkedEClass_T = addETypeParameter(eObjectLinkedEClass, "T");
		ETypeParameter parentableEClass_P = addETypeParameter(parentableEClass, "P");
		ETypeParameter unitEDataType_Q = addETypeParameter(unitEDataType, "Q");
		addETypeParameter(listEDataType, "T");
		addETypeParameter(mapEDataType, "K");
		addETypeParameter(mapEDataType, "V");
		addETypeParameter(setEDataType, "T");
		addETypeParameter(collectionEDataType, "T");
		addETypeParameter(multimapEDataType, "K");
		addETypeParameter(multimapEDataType, "V");
		addETypeParameter(navigableMapEDataType, "K");
		addETypeParameter(navigableMapEDataType, "V");
		addETypeParameter(queueEDataType, "T");
		addETypeParameter(multisetEDataType, "T");
		ETypeParameter measurableEDataType_Q = addETypeParameter(measurableEDataType, "Q");
		addETypeParameter(listenableFutureEDataType, "V");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getIdentifiable());
		informerEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		addedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		modelNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		attributeSetEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		attributeUnsetEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		removedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		objectNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		attributeNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		addedManyEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		removedManyEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		objectsNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		eObjectLinkedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getQuantity());
		unitEDataType_Q.getEBounds().add(g1);
		g1 = createEGenericType(this.getQuantity());
		measurableEDataType_Q.getEBounds().add(g1);

		// Add supertypes to classes
		appManifestEClass.getESuperTypes().add(this.getPositionable());
		appManifestEClass.getESuperTypes().add(this.getResourceAware());
		appManifestEClass.getESuperTypes().add(this.getBundleAware());
		personInfoEClass.getESuperTypes().add(this.getIdentifiable());
		personInfoEClass.getESuperTypes().add(this.getPhotoIdContainer());
		personInfoEClass.getESuperTypes().add(this.getSluggable());
		personInfoEClass.getESuperTypes().add(this.getNameContainer());
		personInfoEClass.getESuperTypes().add(this.getPersonLike());
		photoIdContainerEClass.getESuperTypes().add(this.getImageable());
		nameContainerEClass.getESuperTypes().add(this.getNameable());
		webAddressEClass.getESuperTypes().add(this.getPositionable());
		webAddressEClass.getESuperTypes().add(this.getBundleAware());
		webAddressEClass.getESuperTypes().add(this.getResourceAware());
		webAddressEClass.getESuperTypes().add(this.getExpandable());
		g1 = createEGenericType(this.getObjectNotification());
		EGenericType g2 = createEGenericType(addedEClass_T);
		g1.getETypeArguments().add(g2);
		addedEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getEObjectLinked());
		g2 = createEGenericType(modelNotificationEClass_T);
		g1.getETypeArguments().add(g2);
		modelNotificationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeNotification());
		g2 = createEGenericType(attributeSetEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeSetEClass_V);
		g1.getETypeArguments().add(g2);
		attributeSetEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeNotification());
		g2 = createEGenericType(attributeUnsetEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeUnsetEClass_V);
		g1.getETypeArguments().add(g2);
		attributeUnsetEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getObjectNotification());
		g2 = createEGenericType(removedEClass_T);
		g1.getETypeArguments().add(g2);
		removedEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelNotification());
		g2 = createEGenericType(objectNotificationEClass_T);
		g1.getETypeArguments().add(g2);
		objectNotificationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelNotification());
		g2 = createEGenericType(attributeNotificationEClass_T);
		g1.getETypeArguments().add(g2);
		attributeNotificationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getEObjectLinked());
		g2 = createEGenericType(attributeNotificationEClass_T);
		g1.getETypeArguments().add(g2);
		attributeNotificationEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getObjectsNotification());
		g2 = createEGenericType(addedManyEClass_T);
		g1.getETypeArguments().add(g2);
		addedManyEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getObjectsNotification());
		g2 = createEGenericType(removedManyEClass_T);
		g1.getETypeArguments().add(g2);
		removedManyEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModelNotification());
		g2 = createEGenericType(objectsNotificationEClass_T);
		g1.getETypeArguments().add(g2);
		objectsNotificationEClass.getEGenericSuperTypes().add(g1);
		categoryLikeEClass.getESuperTypes().add(this.getPositionable());
		categoryLikeEClass.getESuperTypes().add(this.getSluggable());
		categoryLikeEClass.getESuperTypes().add(this.getImageable());
		categoryLikeEClass.getESuperTypes().add(this.getIdentifiable());
		categoryLikeEClass.getESuperTypes().add(this.getNameContainer());
		g1 = createEGenericType(this.getCategoryLike());
		categoryInfoEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getParentable());
		g2 = createEGenericType(this.getCategoryInfo());
		g1.getETypeArguments().add(g2);
		categoryInfoEClass.getEGenericSuperTypes().add(g1);
		shellProgressMonitorEClass.getESuperTypes().add(this.getProgressMonitor());
		eventBusProgressMonitorEClass.getESuperTypes().add(this.getProgressMonitor());
		progressMonitorWrapperEClass.getESuperTypes().add(this.getProgressMonitor());
		g1 = createEGenericType(this.getNameContainer());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPhotoIdContainer());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIdentifiable());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPersonLike());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInformer());
		g2 = createEGenericType(this.getPersonInfo());
		g1.getETypeArguments().add(g2);
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTimestamped());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSchemaVersionable());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDescribable());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSluggable());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCanonicalSluggable());
		personEClass.getEGenericSuperTypes().add(g1);
		postalAddressEClass.getESuperTypes().add(this.getNameContainer());
		postalAddressEClass.getESuperTypes().add(this.getIdentifiable());
		postalAddressEClass.getESuperTypes().add(this.getSchemaVersionable());

		// Initialize classes and features; add operations and parameters
		initEClass(resourceAwareEClass, ResourceAware.class, "ResourceAware", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceAware_ResourceType(), this.getResourceType(), "resourceType", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAware_ResourceUri(), ecorePackage.getEString(), "resourceUri", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAware_ResourceName(), ecorePackage.getEString(), "resourceName", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionableEClass, Positionable.class, "Positionable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPositionable_Positioner(), ecorePackage.getEIntegerObject(), "positioner", "0", 0, 1, Positionable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appManifestEClass, AppManifest.class, "AppManifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppManifest_Title(), ecorePackage.getEString(), "title", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_Description(), ecorePackage.getEString(), "description", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_Domain(), theEcorePackage.getEString(), "domain", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_GeneralEmail(), theEcorePackage.getEString(), "generalEmail", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_OrganizationName(), theEcorePackage.getEString(), "organizationName", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_OrganizationAddress(), theEcorePackage.getEString(), "organizationAddress", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_LetterSalutation(), theEcorePackage.getEString(), "letterSalutation", "Hai", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_LetterClosing(), theEcorePackage.getEString(), "letterClosing", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultTimeZoneId(), theEcorePackage.getEString(), "defaultTimeZoneId", "UTC", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultTimeZone(), this.getDateTimeZone(), "defaultTimeZone", null, 0, 1, AppManifest.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultCurrencyCode(), theEcorePackage.getEString(), "defaultCurrencyCode", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultCurrency(), this.getCurrencyUnit(), "defaultCurrency", null, 0, 1, AppManifest.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(personInfoEClass, PersonInfo.class, "PersonInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersonInfo_Gender(), this.getGender(), "gender", null, 0, 1, PersonInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonInfo_Email(), theEcorePackage.getEString(), "email", null, 0, 1, PersonInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timestampedEClass, Timestamped.class, "Timestamped", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimestamped_CreationTime(), this.getDateTime(), "creationTime", null, 0, 1, Timestamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimestamped_ModificationTime(), this.getDateTime(), "modificationTime", null, 0, 1, Timestamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Id(), ecorePackage.getEString(), "id", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sluggableEClass, Sluggable.class, "Sluggable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSluggable_Slug(), ecorePackage.getEString(), "slug", null, 0, 1, Sluggable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(nameableEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(imageableEClass, Imageable.class, "Imageable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(imageableEClass, ecorePackage.getEString(), "getImageId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(photoIdContainerEClass, PhotoIdContainer.class, "PhotoIdContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhotoIdContainer_PhotoId(), ecorePackage.getEString(), "photoId", null, 0, 1, PhotoIdContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameContainerEClass, NameContainer.class, "NameContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameContainer_Name(), ecorePackage.getEString(), "name", null, 1, 1, NameContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(informerEClass, Informer.class, "Informer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(informerEClass, null, "toInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(informerEClass_T);
		initEOperation(op, g1);

		initEClass(describableEClass, Describable.class, "Describable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescribable_Description(), theEcorePackage.getEString(), "description", null, 0, 1, Describable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bundleAwareEClass, BundleAware.class, "BundleAware", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBundleAware_Bundle(), this.getBundle(), "bundle", null, 0, 1, BundleAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaClassLinkedEClass, JavaClassLinked.class, "JavaClassLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaClassLinked_JavaClassName(), theEcorePackage.getEString(), "javaClassName", null, 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEJavaClass());
		g2 = createEGenericType(javaClassLinkedEClass_T);
		g1.getETypeArguments().add(g2);
		initEAttribute(getJavaClassLinked_JavaClass(), g1, "javaClass", null, 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaClassLinked_JavaClassStatus(), this.getJavaClassStatus(), "javaClassStatus", "unresolved", 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(javaClassLinkedEClass, null, "resolveJavaClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBundle(), "bundle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eClassLinkedEClass, EClassLinked.class, "EClassLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassLinked_EClass(), theEcorePackage.getEClass(), null, "eClass", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EClassStatus(), this.getEClassStatus(), "eClassStatus", "unresolved", 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EPackageNsPrefix(), theEcorePackage.getEString(), "ePackageNsPrefix", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EClassName(), theEcorePackage.getEString(), "eClassName", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EPackageName(), theEcorePackage.getEString(), "ePackageName", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(eClassLinkedEClass, null, "resolveEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEClass());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eClassMap", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(schemaVersionableEClass, SchemaVersionable.class, "SchemaVersionable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(schemaVersionableEClass, theEcorePackage.getELong(), "getSchemaVersion", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eFactoryLinkedEClass, EFactoryLinked.class, "EFactoryLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEFactoryLinked_EFactory(), theEcorePackage.getEFactory(), null, "eFactory", null, 0, 1, EFactoryLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nsPrefixableEClass, NsPrefixable.class, "NsPrefixable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNsPrefixable_NsPrefix(), theEcorePackage.getEString(), "nsPrefix", null, 0, 1, NsPrefixable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(webAddressEClass, WebAddress.class, "WebAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWebAddress_BaseUri(), ecorePackage.getEString(), "baseUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_BasePath(), ecorePackage.getEString(), "basePath", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_ApiPath(), ecorePackage.getEString(), "apiPath", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_ImagesUri(), ecorePackage.getEString(), "imagesUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SkinUri(), ecorePackage.getEString(), "skinUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_JsUri(), ecorePackage.getEString(), "jsUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureBaseUri(), ecorePackage.getEString(), "secureBaseUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureImagesUri(), ecorePackage.getEString(), "secureImagesUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureSkinUri(), ecorePackage.getEString(), "secureSkinUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureJsUri(), ecorePackage.getEString(), "secureJsUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addedEClass, Added.class, "Added", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelNotificationEClass, ModelNotification.class, "ModelNotification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelNotification_Container(), theEcorePackage.getEObject(), null, "container", null, 0, 1, ModelNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeSetEClass, AttributeSet.class, "AttributeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeUnsetEClass, AttributeUnset.class, "AttributeUnset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removedEClass, Removed.class, "Removed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectNotificationEClass, ObjectNotification.class, "ObjectNotification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(objectNotificationEClass_T);
		initEAttribute(getObjectNotification_Object(), g1, "object", null, 1, 1, ObjectNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeNotificationEClass, AttributeNotification.class, "AttributeNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeNotification_Attribute(), theEcorePackage.getEAttribute(), null, "attribute", null, 1, 1, AttributeNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(attributeNotificationEClass_T);
		initEAttribute(getAttributeNotification_Object(), g1, "object", null, 1, 1, AttributeNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(attributeNotificationEClass_V);
		initEAttribute(getAttributeNotification_OldValue(), g1, "oldValue", null, 0, 1, AttributeNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(attributeNotificationEClass_V);
		initEAttribute(getAttributeNotification_NewValue(), g1, "newValue", null, 0, 1, AttributeNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addedManyEClass, AddedMany.class, "AddedMany", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removedManyEClass, RemovedMany.class, "RemovedMany", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectsNotificationEClass, ObjectsNotification.class, "ObjectsNotification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(objectsNotificationEClass_T);
		initEAttribute(getObjectsNotification_Objects(), g1, "objects", null, 1, -1, ObjectsNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectLinkedEClass, EObjectLinked.class, "EObjectLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eObjectLinkedEClass, null, "getObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(eObjectLinkedEClass_T);
		initEOperation(op, g1);

		initEClass(parentableEClass, Parentable.class, "Parentable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(parentableEClass_P);
		initEReference(getParentable_Parent(), g1, null, "parent", null, 0, 1, Parentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryLikeEClass, CategoryLike.class, "CategoryLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryLike_SlugPath(), theEcorePackage.getEString(), "slugPath", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_Color(), theEcorePackage.getEString(), "color", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_ImageId(), theEcorePackage.getEString(), "imageId", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_Level(), theEcorePackage.getEIntegerObject(), "level", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_CategoryCount(), theEcorePackage.getELongObject(), "categoryCount", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryInfoEClass, CategoryInfo.class, "CategoryInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategoryInfo_Parents(), this.getCategoryInfo(), null, "parents", null, 0, -1, CategoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(progressMonitorEClass, ProgressMonitor.class, "ProgressMonitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgressMonitor_Canceled(), theEcorePackage.getEBoolean(), "canceled", null, 0, 1, ProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgressMonitor_TaskName(), theEcorePackage.getEString(), "taskName", null, 0, 1, ProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "beginTask", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getELong(), "totalWork", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(progressMonitorEClass, null, "done", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "internalWorked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDouble(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "subTask", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "worked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getELong(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "done", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgressStatus(), "status", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(progressMonitorEClass, null, "worked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getELong(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgressStatus(), "status", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(shellProgressMonitorEClass, ShellProgressMonitor.class, "ShellProgressMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventBusProgressMonitorEClass, EventBusProgressMonitor.class, "EventBusProgressMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventBusProgressMonitor_EventBus(), this.getEventBus(), "eventBus", null, 0, 1, EventBusProgressMonitor.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventBusProgressMonitor_TrackingId(), theEcorePackage.getEString(), "trackingId", null, 0, 1, EventBusProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(progressMonitorWrapperEClass, ProgressMonitorWrapper.class, "ProgressMonitorWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgressMonitorWrapper_Delegate(), this.getProgressMonitor(), null, "delegate", null, 0, 1, ProgressMonitorWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorableEClass, Colorable.class, "Colorable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorable_Color(), theEcorePackage.getEString(), "color", null, 0, 1, Colorable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translatableEClass, Translatable.class, "Translatable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslatable_TranslationState(), this.getTranslationState(), "translationState", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatable_OriginalLanguage(), theEcorePackage.getEString(), "originalLanguage", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatable_Language(), theEcorePackage.getEString(), "language", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslatable_Translations(), this.getTranslationEntry(), null, "translations", null, 0, -1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationEClass, Translation.class, "Translation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslation_Language(), theEcorePackage.getEString(), "language", null, 0, 1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslation_Messages(), this.getTranslationMessageEntry(), null, "messages", null, 0, -1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationMessageEntryEClass, Map.Entry.class, "TranslationMessageEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslationMessageEntry_Key(), theEcorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslationMessageEntry_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationManagerEClass, TranslationManager.class, "TranslationManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(translationManagerEClass, null, "translate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTranslatable(), "entity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "targetLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(translationEntryEClass, Map.Entry.class, "TranslationEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTranslationEntry_Value(), this.getTranslation(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslationEntry_Key(), theEcorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styleConfigurationEClass, StyleConfiguration.class, "StyleConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(styleConfigurationEClass, theEcorePackage.getEString(), "getDefaultStyle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandableEClass, Expandable.class, "Expandable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpandable_ExpansionState(), this.getExpansionState(), "expansionState", null, 0, 1, Expandable.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(expandableEClass, null, "expand", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType(theEcorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "scope", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(personLikeEClass, PersonLike.class, "PersonLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(personLikeEClass, theEcorePackage.getEString(), "getId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(personLikeEClass, theEcorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(personLikeEClass, theEcorePackage.getEString(), "getSlug", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(personLikeEClass, theEcorePackage.getEString(), "getEmail", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(personLikeEClass, theEcorePackage.getEString(), "getPhotoId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(personLikeEClass, this.getGender(), "getGender", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_SchemaVersion(), theEcorePackage.getELong(), "schemaVersion", "2", 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FirstName(), theEcorePackage.getEString(), "firstName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastName(), theEcorePackage.getEString(), "lastName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Password(), theEcorePackage.getEString(), "password", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_PhoneNumbers(), this.getPhoneNumber(), null, "phoneNumbers", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Emails(), this.getEmail(), null, "emails", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_MobileNumbers(), this.getPhoneNumber(), null, "mobileNumbers", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Addresses(), this.getPostalAddress(), null, "addresses", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_AccountStatus(), this.getAccountStatus(), "accountStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthYear(), theEcorePackage.getEIntegerObject(), "birthYear", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthMonth(), theEcorePackage.getEIntegerObject(), "birthMonth", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthDay(), theEcorePackage.getEIntegerObject(), "birthDay", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthDate(), this.getLocalDate(), "birthDate", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Gender(), this.getGender(), "gender", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Language(), theEcorePackage.getEString(), "language", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_CurrencyCode(), theEcorePackage.getEString(), "currencyCode", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Currency(), this.getCurrencyUnit(), "currency", null, 0, 1, Person.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FacebookId(), theEcorePackage.getELongObject(), "facebookId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FacebookUsername(), theEcorePackage.getEString(), "facebookUsername", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FacebookAccessToken(), theEcorePackage.getEString(), "facebookAccessToken", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TwitterId(), theEcorePackage.getELongObject(), "twitterId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TwitterScreenName(), theEcorePackage.getEString(), "twitterScreenName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TwitterAccessToken(), theEcorePackage.getEString(), "twitterAccessToken", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TwitterAccessTokenSecret(), theEcorePackage.getEString(), "twitterAccessTokenSecret", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GooglePlusId(), theEcorePackage.getEString(), "googlePlusId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GoogleUsername(), theEcorePackage.getEString(), "googleUsername", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_VirtualMail(), theEcorePackage.getEString(), "virtualMail", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Nickname(), theEcorePackage.getEString(), "nickname", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_CustomerRole(), theEcorePackage.getEString(), "customerRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_MemberRole(), theEcorePackage.getEString(), "memberRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ManagerRole(), theEcorePackage.getEString(), "managerRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TimeZoneId(), theEcorePackage.getEString(), "timeZoneId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TimeZone(), this.getDateTimeZone(), "timeZone", null, 0, 1, Person.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ReferrerId(), theEcorePackage.getEString(), "referrerId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ReferrerType(), theEcorePackage.getEString(), "referrerType", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SignupSource(), theEcorePackage.getEString(), "signupSource", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SignupSourceType(), this.getSignupSourceType(), "signupSourceType", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_IpAddress(), theEcorePackage.getEString(), "ipAddress", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastIpAddress(), theEcorePackage.getEString(), "lastIpAddress", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastLoginTime(), this.getDateTime(), "lastLoginTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ActivationTime(), this.getDateTime(), "activationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_VerificationTime(), this.getDateTime(), "verificationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NewsletterSubscriptionEnabled(), theEcorePackage.getEBooleanObject(), "newsletterSubscriptionEnabled", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NewsletterSubscriptionTime(), this.getDateTime(), "newsletterSubscriptionTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SocialSharingEnabled(), theEcorePackage.getEBooleanObject(), "socialSharingEnabled", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PublicationStatus(), this.getPublicationStatus(), "publicationStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ArchivalStatus(), this.getArchivalStatus(), "archivalStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Folder(), theEcorePackage.getEString(), "folder", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Religion(), theEcorePackage.getEString(), "religion", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PasswordResetCode(), theEcorePackage.getEString(), "passwordResetCode", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PasswordResetExpiryTime(), this.getDateTime(), "passwordResetExpiryTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phoneNumberEClass, PhoneNumber.class, "PhoneNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhoneNumber_PhoneNumber(), theEcorePackage.getEString(), "phoneNumber", null, 1, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNumber_Primary(), theEcorePackage.getEBoolean(), "primary", "false", 0, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNumber_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emailEClass, Email.class, "Email", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmail_Email(), theEcorePackage.getEString(), "email", null, 1, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmail_Primary(), theEcorePackage.getEBoolean(), "primary", "false", 0, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmail_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postalAddressEClass, PostalAddress.class, "PostalAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPostalAddress_SchemaVersion(), theEcorePackage.getELong(), "schemaVersion", "3", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Organization(), ecorePackage.getEString(), "organization", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Street(), ecorePackage.getEString(), "street", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_City(), ecorePackage.getEString(), "city", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PostalCode(), ecorePackage.getEString(), "postalCode", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Province(), ecorePackage.getEString(), "province", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Country(), ecorePackage.getEString(), "country", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_CountryCode(), ecorePackage.getEString(), "countryCode", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryMobile(), ecorePackage.getEString(), "primaryMobile", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Mobiles(), ecorePackage.getEString(), "mobiles", null, 0, -1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryPhone(), ecorePackage.getEString(), "primaryPhone", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Phones(), ecorePackage.getEString(), "phones", null, 0, -1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryHomePhone(), ecorePackage.getEString(), "primaryHomePhone", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_HomePhones(), ecorePackage.getEString(), "homePhones", null, 0, -1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryWorkPhone(), ecorePackage.getEString(), "primaryWorkPhone", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_WorkPhones(), ecorePackage.getEString(), "workPhones", null, 0, -1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryEmail(), ecorePackage.getEString(), "primaryEmail", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Emails(), ecorePackage.getEString(), "emails", null, 0, -1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPostalAddress_Description(), ecorePackage.getEString(), "description", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_Primary(), theEcorePackage.getEBoolean(), "primary", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryBilling(), theEcorePackage.getEBoolean(), "primaryBilling", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryShipping(), theEcorePackage.getEBoolean(), "primaryShipping", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personCatalogEClass, PersonCatalog.class, "PersonCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersonCatalog_People(), this.getPerson(), null, "people", null, 0, -1, PersonCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(canonicalSluggableEClass, CanonicalSluggable.class, "CanonicalSluggable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCanonicalSluggable_CanonicalSlug(), theEcorePackage.getEString(), "canonicalSlug", null, 0, 1, CanonicalSluggable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(resourceTypeEEnum, ResourceType.class, "ResourceType");
		addEEnumLiteral(resourceTypeEEnum, ResourceType.BUNDLE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.FILE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.DATABASE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.CLASSPATH);

		initEEnum(genderEEnum, Gender.class, "Gender");
		addEEnumLiteral(genderEEnum, Gender.MALE);
		addEEnumLiteral(genderEEnum, Gender.FEMALE);

		initEEnum(eClassStatusEEnum, EClassStatus.class, "EClassStatus");
		addEEnumLiteral(eClassStatusEEnum, EClassStatus.UNRESOLVED);
		addEEnumLiteral(eClassStatusEEnum, EClassStatus.RESOLVED);

		initEEnum(javaClassStatusEEnum, JavaClassStatus.class, "JavaClassStatus");
		addEEnumLiteral(javaClassStatusEEnum, JavaClassStatus.UNRESOLVED);
		addEEnumLiteral(javaClassStatusEEnum, JavaClassStatus.RESOLVED);

		initEEnum(progressStatusEEnum, ProgressStatus.class, "ProgressStatus");
		addEEnumLiteral(progressStatusEEnum, ProgressStatus.OK);
		addEEnumLiteral(progressStatusEEnum, ProgressStatus.ERROR);
		addEEnumLiteral(progressStatusEEnum, ProgressStatus.WARNING);
		addEEnumLiteral(progressStatusEEnum, ProgressStatus.DELETED);
		addEEnumLiteral(progressStatusEEnum, ProgressStatus.SKIPPED);

		initEEnum(accountStatusEEnum, AccountStatus.class, "AccountStatus");
		addEEnumLiteral(accountStatusEEnum, AccountStatus.DRAFT);
		addEEnumLiteral(accountStatusEEnum, AccountStatus.VALIDATED);
		addEEnumLiteral(accountStatusEEnum, AccountStatus.ACTIVE);
		addEEnumLiteral(accountStatusEEnum, AccountStatus.VERIFIED);
		addEEnumLiteral(accountStatusEEnum, AccountStatus.INACTIVE);
		addEEnumLiteral(accountStatusEEnum, AccountStatus.VOID);

		initEEnum(publicationStatusEEnum, PublicationStatus.class, "PublicationStatus");
		addEEnumLiteral(publicationStatusEEnum, PublicationStatus.DRAFT);
		addEEnumLiteral(publicationStatusEEnum, PublicationStatus.PUBLISHED);
		addEEnumLiteral(publicationStatusEEnum, PublicationStatus.UNPUBLISHED);

		initEEnum(archivalStatusEEnum, ArchivalStatus.class, "ArchivalStatus");
		addEEnumLiteral(archivalStatusEEnum, ArchivalStatus.FRESH);
		addEEnumLiteral(archivalStatusEEnum, ArchivalStatus.ARCHIVED);

		initEEnum(translationStateEEnum, TranslationState.class, "TranslationState");
		addEEnumLiteral(translationStateEEnum, TranslationState.ORIGINAL);
		addEEnumLiteral(translationStateEEnum, TranslationState.TRANSLATED);

		initEEnum(expansionStateEEnum, ExpansionState.class, "ExpansionState");
		addEEnumLiteral(expansionStateEEnum, ExpansionState.UNEXPANDED);
		addEEnumLiteral(expansionStateEEnum, ExpansionState.EXPANDED);

		initEEnum(signupSourceTypeEEnum, SignupSourceType.class, "SignupSourceType");
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.OTHER);
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.GOOGLE_SEARCH);
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.GOOGLE_ADS);
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.FACEBOOK_ADS);
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.FACEBOOK_FRIEND);
		addEEnumLiteral(signupSourceTypeEEnum, SignupSourceType.ALIA_MAGAZINE);

		// Initialize data types
		initEDataType(dateTimeEDataType, DateTime.class, "DateTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(currencyUnitEDataType, CurrencyUnit.class, "CurrencyUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(quantityEDataType, Quantity.class, "Quantity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unitEDataType, Unit.class, "Unit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(setEDataType, Set.class, "Set", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(multimapEDataType, Multimap.class, "Multimap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(navigableMapEDataType, NavigableMap.class, "NavigableMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(queueEDataType, Queue.class, "Queue", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(multisetEDataType, Multiset.class, "Multiset", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(serializableEDataType, Serializable.class, "Serializable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(bundleEDataType, Bundle.class, "Bundle", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(bigMoneyProviderEDataType, BigMoneyProvider.class, "BigMoneyProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(measurableEDataType, Measurable.class, "Measurable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dateTimeZoneEDataType, DateTimeZone.class, "DateTimeZone", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localeEDataType, Locale.class, "Locale", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(fileEDataType, File.class, "File", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listenableFutureEDataType, ListenableFuture.class, "ListenableFuture", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listeningExecutorServiceEDataType, ListeningExecutorService.class, "ListeningExecutorService", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(classLoaderEDataType, ClassLoader.class, "ClassLoader", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(urlEDataType, java.net.URL.class, "URL", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eventBusEDataType, EventBus.class, "EventBus", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localDateEDataType, LocalDate.class, "LocalDate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (getResourceAware_ResourceName(), 
		   source, 
		   new String[] {
			 "documentation", "Name relative to parent resource."
		   });		
		addAnnotation
		  (resourceTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The resource is from a bundle classpath."
		   });		
		addAnnotation
		  (resourceTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The resource is from a file, usually in a watched folder."
		   });		
		addAnnotation
		  (resourceTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The resource is from a persistence storage."
		   });		
		addAnnotation
		  (resourceTypeEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "The resource is from a plain Java classpath."
		   });		
		addAnnotation
		  (appManifestEClass, 
		   source, 
		   new String[] {
			 "documentation", "Attributes are optional because can use OverlayingSupplier."
		   });		
		addAnnotation
		  (getAppManifest_Domain(), 
		   source, 
		   new String[] {
			 "documentation", "Primary domain name of the application, e.g. \"berbatik.com\". Used by Email system.\n\n<p>For development, use e.g. \"berbatik.annafi.dev\".\n\n<p>TODO: title & domain should probably be moved somewhere else, since it\'s tenant & environment specific.\n\n<p>Production: title=Berbatik, domain=berbatik.com\n\n<p>Staging: title=Berbatik stg, domain=stg.berbatik.com\n\n<p>Development: title=Berbatik Annafi, domain=berbatik.annafi.dev\n\n<p>Description usually stays the same, but can be different too."
		   });		
		addAnnotation
		  (getAppManifest_GeneralEmail(), 
		   source, 
		   new String[] {
			 "documentation", "Email address used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application."
		   });		
		addAnnotation
		  (getAppManifest_OrganizationName(), 
		   source, 
		   new String[] {
			 "documentation", "Used in email notifications, e.g. \"PT Berniaga Digital\"."
		   });		
		addAnnotation
		  (getAppManifest_OrganizationAddress(), 
		   source, 
		   new String[] {
			 "documentation", "Used in email notifications, e.g. \"Talavera Office Park, Jl. TB Simatupang KAV 20-22 Jakarta\"."
		   });		
		addAnnotation
		  (getAppManifest_LetterSalutation(), 
		   source, 
		   new String[] {
			 "documentation", "The SALUTATION (C) of the letter starts on the left margin two lines below the inside address for a business letter or five lines below the heading of a personal letter, if typed. All words in the salutation are capitalized, and the last word is followed by a comma in a personal letter or a colon in a business letter.\nSample salutations are:\n\n\nPersonal:\nGreetings Friend, Dear Bob, Hi Bob,\n\nBusiness:\nDear Mr. Jones: Dear Sir:\nLadies and Gentlemen: Dear Mr./Mrs./Ms. Jones:\n"
		   });		
		addAnnotation
		  (getAppManifest_LetterClosing(), 
		   source, 
		   new String[] {
			 "documentation", "The first word of the CLOSING (E), which is placed several lines below the body, lines up with the first word in the heading and is the only word capitalized. A comma follows the closing.\n\nPossible closings include:\n\nPersonal:\nYour friend, Missing you, Sincerely,\nConfused, Affectionately,Cordially,\n\nBusiness:\nSincerely yours, Yours truly,Respectfully yours,"
		   });		
		addAnnotation
		  (getAppManifest_DefaultTimeZoneId(), 
		   source, 
		   new String[] {
			 "documentation", "Default time zone for the application. For example this is used by perpetual inventory to store dates with a fixed reference timezone.\nIt\'s a String, not a DateTimeZone object, to make it easier to edit the *.AppManifest.xmi file using generic EMF editor."
		   });		
		addAnnotation
		  (getAppManifest_DefaultTimeZone(), 
		   source, 
		   new String[] {
			 "documentation", "Reads directly from {@link #getDefaultTimeZoneId()}."
		   });		
		addAnnotation
		  (getAppManifest_DefaultCurrencyCode(), 
		   source, 
		   new String[] {
			 "documentation", "This is a String and not a CurrencyUnit object to aid visual editing using EMF Reflective Editor."
		   });		
		addAnnotation
		  (getAppManifest_DefaultCurrency(), 
		   source, 
		   new String[] {
			 "documentation", "Reads directly from {@link #getDefaultCurrencyCode()}."
		   });		
		addAnnotation
		  (personInfoEClass, 
		   source, 
		   new String[] {
			 "documentation", "Person partial value object that is stored in Graph database (usually Neo4j) or embedded in a MongoDB document.\n\nThe ID is Directory entry uid attribute.\n"
		   });		
		addAnnotation
		  (timestampedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Can be used by any EObject that wants to preserve creationTime/modificationTime."
		   });		
		addAnnotation
		  (getTimestamped_CreationTime(), 
		   source, 
		   new String[] {
			 "documentation", "First creation time (raw)."
		   });		
		addAnnotation
		  (getTimestamped_ModificationTime(), 
		   source, 
		   new String[] {
			 "documentation", "Last modification time (raw)."
		   });		
		addAnnotation
		  (identifiableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Object that has ID as String."
		   });		
		addAnnotation
		  (getIdentifiable_Id(), 
		   source, 
		   new String[] {
			 "documentation", "ID of the object. Usually either lowercase_underscored or UUID. Optional because some implementations (e.g. CategoryCatalog) can generate IDs dynamically when loading from Catalog.\n\n<p>In LDAP, it can either be \'uid\' or \'uniqueIdentifier\'.\n\n<p>RFC1274: unique identifer.\nLDAP: uniqueIdentifier"
		   });		
		addAnnotation
		  (getSluggable_Slug(), 
		   source, 
		   new String[] {
			 "documentation", "Slug (aka Directory uniqueIdentifier) used in SEO-friendly URIs. Optional because some implementations (e.g. CategoryCatalog) can generate slugs dynamically when loading from Catalogs."
		   });		
		addAnnotation
		  (nameableEClass, 
		   source, 
		   new String[] {
			 "documentation", "An object that can provide a name."
		   });		
		addAnnotation
		  (imageableEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Return the primary image ID for square proportion."
		   });		
		addAnnotation
		  (photoIdContainerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains image ID as photoId attribute and has default implementation for {#getImageId()}."
		   });		
		addAnnotation
		  (getPhotoIdContainer_PhotoId(), 
		   source, 
		   new String[] {
			 "documentation", "Avatar Photo ID directly usable by Image Store. Used by {#getImageId()}."
		   });		
		addAnnotation
		  (nameContainerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains a name attribute named \'name\' and has default implementation for {@link #getName()}."
		   });		
		addAnnotation
		  (getNameContainer_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Display name (can be full name, nickname, slug, screen name, etc. whatever is commonly used by the particular app).\nUsed by {#getName()}."
		   });		
		addAnnotation
		  (informerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Can transform itself an \"Info\" object."
		   });		
		addAnnotation
		  (informerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Transforms to its \"Info\" model."
		   });		
		addAnnotation
		  (describableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Has description."
		   });		
		addAnnotation
		  (bundleEDataType, 
		   source, 
		   new String[] {
			 "documentation", "An installed bundle in the Framework.\n\nA Bundle object is the access point to define the lifecycle of an installed bundle. Each bundle installed in the OSGi environment must have an associated Bundle object.\n\nA bundle must have a unique identity, a long, chosen by the Framework. This identity must not change during the lifecycle of a bundle, even when the bundle is updated. Uninstalling and then reinstalling the bundle must create a new unique identity.\n\nA bundle can be in one of six states:\n\nUNINSTALLED\nINSTALLED\nRESOLVED\nSTARTING\nSTOPPING\nACTIVE\nValues assigned to these states have no specified ordering; they represent bit values that may be ORed together to determine if a bundle is in one of the valid states.\n\nA bundle should only have active threads of execution when its state is one of STARTING,ACTIVE, or STOPPING. An UNINSTALLED bundle can not be set to another state; it is a zombie and can only be reached because references are kept somewhere.\n\nThe Framework is the only entity that is allowed to create Bundle objects, and these objects are only valid within the Framework that created them.\n\nBundles have a natural ordering such that if two Bundles have the same bundle id they are equal. A Bundle is less than another Bundle if it has a lower bundle id and is greater if it has a higher bundle id."
		   });		
		addAnnotation
		  (bundleAwareEClass, 
		   source, 
		   new String[] {
			 "documentation", "BundleAware classes are usually also ResourceAware (since Bundle is a resource).\nHowever, Soluvas can load from other non-bundle resources as well, etc. JCR, Git, filesystem, database, HTTP, etc."
		   });		
		addAnnotation
		  (getBundleAware_Bundle(), 
		   source, 
		   new String[] {
			 "documentation", "Only available if resolved."
		   });		
		addAnnotation
		  (javaClassLinkedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Implementation is in {@link org.soluvas.commons.JavaClassLinked.Trait}."
		   });		
		addAnnotation
		  (javaClassLinkedEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Resolve referenced Java Class."
		   });		
		addAnnotation
		  ((javaClassLinkedEClass.getEOperations().get(0)).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Resolve referenced Java Class using the specified Bundle."
		   });		
		addAnnotation
		  (getJavaClassLinked_JavaClassName(), 
		   source, 
		   new String[] {
			 "documentation", "The Java class name linked to this type. Used to resolve the Java Class instance."
		   });		
		addAnnotation
		  (getJavaClassLinked_JavaClass(), 
		   source, 
		   new String[] {
			 "documentation", "The Java class linked to this type. Only available when resolved."
		   });		
		addAnnotation
		  (eClassLinkedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Implementation is in {@link org.soluvas.commons.util.EClassLinked.Trait}."
		   });		
		addAnnotation
		  (eClassLinkedEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Resolve referenced EClass."
		   });		
		addAnnotation
		  ((eClassLinkedEClass.getEOperations().get(0)).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Keys are {ePackageName}.{eClassName}.\nValues are EClass instances themselves."
		   });		
		addAnnotation
		  (getEClassLinked_EClass(), 
		   source, 
		   new String[] {
			 "documentation", "EClass for this instances of this type."
		   });		
		addAnnotation
		  (getEClassLinked_EPackageNsPrefix(), 
		   source, 
		   new String[] {
			 "documentation", "Used to resolve agains NS Prefix instead of EPackage name. The key format will be \"{ePackage.nsPrefix}:{eClass.name}\"."
		   });		
		addAnnotation
		  (getEClassLinked_EClassName(), 
		   source, 
		   new String[] {
			 "documentation", "Name of EClass, used for resolving the EClass instance."
		   });		
		addAnnotation
		  (getEClassLinked_EPackageName(), 
		   source, 
		   new String[] {
			 "documentation", "Name of EPackage, used for resolving the EClass instance.  The key format will be \"{ePackage.name}.{eClass.name}\"."
		   });		
		addAnnotation
		  (eFactoryLinkedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Useful for schema classes, e.g. {@code com.soluvas.story.schema.ActionType}, {@code com.soluvas.story.schema.TargetType}."
		   });		
		addAnnotation
		  (getEFactoryLinked_EFactory(), 
		   source, 
		   new String[] {
			 "documentation", "Useful for schema classes, e.g. {@code com.soluvas.story.schema.ActionType}, {@code com.soluvas.story.schema.TargetType}. Only accessible when resolved."
		   });		
		addAnnotation
		  (getNsPrefixable_NsPrefix(), 
		   source, 
		   new String[] {
			 "documentation", "Context-specific NS prefix.\n\nComes from: getActionType().getEClass().getEPackage().getNsPrefix()."
		   });		
		addAnnotation
		  (webAddressEClass, 
		   source, 
		   new String[] {
			 "documentation", "Tenant-wide website URI configuration."
		   });		
		addAnnotation
		  (getWebAddress_BaseUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI of the website. Used by email notifications, external servers, etc."
		   });		
		addAnnotation
		  (getWebAddress_BasePath(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute path to website, e.g. /"
		   });		
		addAnnotation
		  (getWebAddress_ApiPath(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute path to API, e.g. /api/\n"
		   });		
		addAnnotation
		  (getWebAddress_ImagesUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to image files, e.g. http://images.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SkinUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to CSS files and dependencies (sprite images, fonts, etc.), e.g. http://skin.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_JsUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to JavaScript files, e.g. http://js.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureBaseUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to website, e.g. https://www.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureImagesUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to secure image files, e.g. https://images.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureSkinUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute secure URI to CSS files and dependencies (sprite images, fonts, etc.), e.g. http://skin.berbatik.com/"
		   });		
		addAnnotation
		  (addedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Inspired by {@link org.eclipse.emf.common.notify.Notification}."
		   });		
		addAnnotation
		  (modelNotificationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Inspired by {@link org.eclipse.emf.common.notify.Notification}."
		   });		
		addAnnotation
		  (categoryLikeEClass, 
		   source, 
		   new String[] {
			 "documentation", "ID is prefixed with parent IDs then concatenated by \'_\', it won\'t change when categories are reordered are moved/restructured. IDs cannot be duplicate (even draft/inactive/void categories). Slugs can be duplicates only within same parent. Names can be duplicates.\n\n<p>Slug is used as name in JCR repositories. If not specified, should be generated based on Name.\n\n<p>Name is used as displayName in JCR repositories."
		   });		
		addAnnotation
		  (getCategoryLike_SlugPath(), 
		   source, 
		   new String[] {
			 "documentation", "Automatically updated based on slug and parent slugs, separated by \'/\'."
		   });		
		addAnnotation
		  (getCategoryLike_Color(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color code name or hexadecimal code (i.e. \"#3356ff\") of category color (usually used as background)."
		   });		
		addAnnotation
		  (getCategoryLike_Level(), 
		   source, 
		   new String[] {
			 "documentation", "The \"implicit root category\" has level 0. So a Category without a parent has level 1. Automatically updated on save."
		   });		
		addAnnotation
		  (getCategoryLike_CategoryCount(), 
		   source, 
		   new String[] {
			 "documentation", "Number of children categories. Automatically updated when categories are restructured."
		   });		
		addAnnotation
		  (getCategoryInfo_Parents(), 
		   source, 
		   new String[] {
			 "documentation", "Used to help query performance. And also to display breadcrumbs."
		   });		
		addAnnotation
		  (progressMonitorEClass, 
		   source, 
		   new String[] {
			 "documentation", " * The <code>IProgressMonitor</code> interface is implemented\n * by objects that monitor the progress of an activity; the methods\n * in this interface are invoked by code that performs the activity.\n * <p>\n * All activity is broken down into a linear sequence of tasks against\n * which progress is reported. When a task begins, a <code>beginTask(String, int)\n * </code> notification is reported, followed by any number and mixture of \n * progress reports (<code>worked()</code>) and subtask notifications \n * (<code>subTask(String)</code>).  When the task is eventually completed, a \n * <code>done()</code> notification is reported.  After the <code>done()</code>\n * notification, the progress monitor cannot be reused;  i.e., <code>\n * beginTask(String, int)</code> cannot be called again after the call to \n * <code>done()</code>.\n * </p>\n * <p>\n * A request to cancel an operation can be signaled using the \n * <code>setCanceled</code> method.  Operations taking a progress\n * monitor are expected to poll the monitor (using <code>isCanceled</code>)\n * periodically and abort at their earliest convenience.  Operation can however \n * choose to ignore cancelation requests.\n * </p>\n * <p>\n * Since notification is synchronous with the activity itself, the listener should \n * provide a fast and robust implementation. If the handling of notifications would \n * involve blocking operations, or operations which might throw uncaught exceptions, \n * the notifications should be queued, and the actual processing deferred (or perhaps\n * delegated to a separate thread).\n * </p><p>\n * This interface can be used without OSGi running.\n * </p><p>\n * Clients may implement this interface.\n * </p>\n\n\nInspired by: org.eclipse.core.runtime.IProgressMonitor\n"
		   });		
		addAnnotation
		  (progressMonitorEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "\t * Notifies that the main task is beginning.  This must only be called once\n\t * on a given progress monitor instance.\n\t * \n\t * @param name the name (or description) of the main task\n\t * @param totalWork the total number of work units into which\n\t *  the main task is been subdivided. If the value is <code>UNKNOWN</code> \n\t *  the implementation is free to indicate progress in a way which \n\t *  doesn\'t require the total number of work units in advance.\n\nTODO: support formatting in the task name, probably using HTML5 or RDFa, which will be converted (in shell) into ANSI codes."
		   });		
		addAnnotation
		  (progressMonitorEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "\t * Notifies that the work is done; that is, either the main task is completed \n\t * or the user canceled it. This method may be called more than once \n\t * (implementations should be prepared to handle this case).\n"
		   });		
		addAnnotation
		  (progressMonitorEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "\t * Internal method to handle scaling correctly. This method\n\t * must not be called by a client. Clients should \n\t * always use the method </code>worked(int)</code>.\n\t * \n\t * @param work the amount of work done\n"
		   });		
		addAnnotation
		  (getProgressMonitor_Canceled(), 
		   source, 
		   new String[] {
			 "documentation", "\t * Returns whether cancelation of current operation has been requested.\n\t * Long-running operations should poll to see if cancelation\n\t * has been requested.\n\t *\n\t * @return <code>true</code> if cancellation has been requested,\n\t *    and <code>false</code> otherwise\n\t * @see #setCanceled(boolean)\n"
		   });		
		addAnnotation
		  (getProgressMonitor_TaskName(), 
		   source, 
		   new String[] {
			 "documentation", "\t * Sets the task name to the given value. This method is used to \n\t * restore the task label after a nested operation was executed. \n\t * Normally there is no need for clients to call this method.\n\t *\n\t * @param name the name (or description) of the main task\n\t * @see #beginTask(java.lang.String, int)\n"
		   });		
		addAnnotation
		  (progressStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Completed successfully."
		   });		
		addAnnotation
		  (progressStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Error occurred."
		   });		
		addAnnotation
		  (progressStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Process completed with warnings."
		   });		
		addAnnotation
		  (progressStatusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "OK but destructive."
		   });		
		addAnnotation
		  (progressStatusEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Skipped for some reason."
		   });		
		addAnnotation
		  (shellProgressMonitorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Use ansi.render() to report progress."
		   });		
		addAnnotation
		  (eventBusProgressMonitorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Use Guava EventBus to report progress.\nCan be used to implement web-based progress bar."
		   });		
		addAnnotation
		  (progressMonitorWrapperEClass, 
		   source, 
		   new String[] {
			 "documentation", " * An abstract wrapper around a progress monitor which,\n * unless overridden, forwards <code>IProgressMonitor</code>\n * and <code>IProgressMonitorWithBlocking</code> methods to the wrapped progress monitor.\n * <p>\n * This class can be used without OSGi running.\n * </p><p>\n * Clients may subclass.\n * </p>\n"
		   });		
		addAnnotation
		  (accountStatusEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Status of Account, can be use for shop , person , or mall"
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Member belum aktif."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Email sudah divalidasi tapi belum aktif (bila membership dimoderasi)."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Akun aktif dan dapat digunakan."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator)."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", " Member dinonaktifkan / suspended."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Member dihapus."
		   });		
		addAnnotation
		  (publicationStatusEEnum, 
		   source, 
		   new String[] {
			 "documentation", "atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit)."
		   });		
		addAnnotation
		  (publicationStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Not Yet Published"
		   });		
		addAnnotation
		  (publicationStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Has published and can be viewed by authorized viewers."
		   });		
		addAnnotation
		  (publicationStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Was published but taken down"
		   });		
		addAnnotation
		  (archivalStatusEEnum, 
		   source, 
		   new String[] {
			 "documentation", " atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya."
		   });		
		addAnnotation
		  (archivalStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "New item"
		   });		
		addAnnotation
		  (archivalStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Old Item"
		   });		
		addAnnotation
		  (colorableEClass, 
		   source, 
		   new String[] {
			 "documentation", "An object that can display itself as color."
		   });		
		addAnnotation
		  (getColorable_Color(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color code name or hexadecimal code (i.e. \"#3356ff\") of category color (usually used as background)."
		   });		
		addAnnotation
		  (translatableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Entity Translation\nMulti-locale & multi-language support for entities/nodes/database objects\nAllow entities (like Product) to have different description / price / custom attribute values (fabric, origin, technique, etc.) for each locale/language."
		   });		
		addAnnotation
		  (getTranslatable_OriginalLanguage(), 
		   source, 
		   new String[] {
			 "documentation", "The language of original values."
		   });		
		addAnnotation
		  (getTranslatable_Language(), 
		   source, 
		   new String[] {
			 "documentation", "Current language code (if translationState == translated) or same as originalLanguage."
		   });		
		addAnnotation
		  (getTranslatable_Translations(), 
		   source, 
		   new String[] {
			 "documentation", "EMap[ language: String, Translation ]\nWhere Translation object contains language: String and the localized messages keyed by attribute QName.\nExample translations is as follows:\n1. en\n1. base_description : Very good style.\n2. base_fabric : Super funky.\n2. id\n1. base_description : Sangat bagus untuk Anda.\n2. base_fabric : Katun keren.\n3. base_origin : Jakarta area.\nCountry codes in language codes:\nen and en_US are identical and interchangeable.\nid and id_ID are identical and interchangeable."
		   });		
		addAnnotation
		  (translationStateEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "1. Values are in their original language as specified by originalLanguage (usually the mother tongue, i.e. id)."
		   });		
		addAnnotation
		  (translationStateEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "2. Values are translated and language attribute is set as the current language."
		   });		
		addAnnotation
		  (translationEClass, 
		   source, 
		   new String[] {
			 "documentation", "It\'s not an EMap so it won\'t be complex to create the underlying EMap (messages)."
		   });		
		addAnnotation
		  (translationManagerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Processes available translations and sets language to the targetLanguage.\nWill throw Exception if it\'s not already in the targetLanguage and translationState is translated."
		   });		
		addAnnotation
		  (getTranslationEntry_Key(), 
		   source, 
		   new String[] {
			 "documentation", "Language of the translation."
		   });		
		addAnnotation
		  (styleConfigurationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Used by {@link org.soluvas.web.site.SiteResource} to get the current Mall\'s default style."
		   });		
		addAnnotation
		  (styleConfigurationEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Default style name for Wicket, e.g. \"fluid\" (Cinta Lama\'s original theme, created by Ahmad Syarif Farsiado)."
		   });		
		addAnnotation
		  (expandableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Can be expanded upon loading by XmiObjectLoader.\n\nExample is WebAddress, it will replace {+fqdn} with FQDN (useful for development)."
		   });		
		addAnnotation
		  (expandableEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Expand attribute values."
		   });		
		addAnnotation
		  (getExpandable_ExpansionState(), 
		   source, 
		   new String[] {
			 "documentation", "Whether attribute values are already expanded. If so, calling expand() will do nothing."
		   });		
		addAnnotation
		  (expansionStateEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Attribute values are unexpanded, for example baseUri=\"http://www.cintalama5.{+fqdn}/\""
		   });		
		addAnnotation
		  (expansionStateEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Attribute values are expanded, for example baseUri=\"http://www.cintalama5.{+fqdn}/\" becomes \"http://www.cintalama5.rudi.dev/\""
		   });		
		addAnnotation
		  (personLikeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains basic attributes of a Person."
		   });		
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "documentation", "Database-agnostic future replacement for org.soluvas.ldap.SocialPerson & BippoPerson.\n\nA basic LDAP <tt>objectClass=person</tt> with proper mappings that can be subclassed."
		   });		
		addAnnotation
		  (getPerson_Password(), 
		   source, 
		   new String[] {
			 "documentation", "The password, may be encoded e.g. <code>{SSHA}BacKnhFVjpSunHYgivCVPAzcavAZZe9QFtd51A==<code>"
		   });		
		addAnnotation
		  (getPerson_AccountStatus(), 
		   source, 
		   new String[] {
			 "documentation", "Status of Account, can be used for shop, person, or mall.\n\naccountStatus itu delete (move to Trash)/undelete, untuk normal repository :\n\n<ol>\n\t<li>draft: Member belum aktif.</li>\n\t<li>validated: Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).</li>\n\t<li>active: Akun aktif dan dapat digunakan.</li>\n\t<li>verified: Akun aktif dan dapat digunakan, dan sudah diverifikasi bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator).</li>\n\t<li>inactive: Member dinonaktifkan / suspended.</li>\n\t<li>void: Member dihapus.@return the accountStatus</li>\n</ol>\n"
		   });		
		addAnnotation
		  (getPerson_BirthDate(), 
		   source, 
		   new String[] {
			 "documentation", "Only available if birthYear, birthMonth, and birthDay is a valid date."
		   });		
		addAnnotation
		  (getPerson_Language(), 
		   source, 
		   new String[] {
			 "documentation", "Preferred language as language identifier,\nas defined by IETF RFC 4646 (http://www.ietf.org/rfc/rfc4646.txt) or successor,\nor ISO 639-1 Language Codes. \n"
		   });		
		addAnnotation
		  (getPerson_CurrencyCode(), 
		   source, 
		   new String[] {
			 "documentation", "Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.\n\n"
		   });		
		addAnnotation
		  (getPerson_Currency(), 
		   source, 
		   new String[] {
			 "documentation", "Preferred currency as ISO 4217. The purpose of ISO 4217:2008 is to establish internationally recognised codes for the representation of currencies.\n"
		   });		
		addAnnotation
		  (getPerson_CustomerRole(), 
		   source, 
		   new String[] {
			 "documentation", "Name of Customer Role or Group, for example in Tuneeca there are 5: ag-sp, agen, biasa, drops, membr\n"
		   });		
		addAnnotation
		  (getPerson_MemberRole(), 
		   source, 
		   new String[] {
			 "documentation", "Name of Member Role or Group for example : newbie, aktivis , donatur\n\n"
		   });		
		addAnnotation
		  (getPerson_ManagerRole(), 
		   source, 
		   new String[] {
			 "documentation", "Name of Manager Role or Group for example : regular, moderator , administrator, sysadmin. (administrativeRole attribute OID 2.5.18.5 is already used by LDAP standard)\n\n"
		   });		
		addAnnotation
		  (getPerson_TimeZoneId(), 
		   source, 
		   new String[] {
			 "documentation", "The attribute is named \'timezone\' and is a plain string, e.g. \'Asia/Jakarta\' or \'UTC\'. If not set, will default to whatever the application configuration is set to (or its heuristics). References: * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html * http://tracker.moodle.org/browse/MDL-17330\n"
		   });		
		addAnnotation
		  (getPerson_TimeZone(), 
		   source, 
		   new String[] {
			 "documentation", "The attribute is named \'timezone\' and is a plain string, e.g. \'Asia/Jakarta\' or \'UTC\'. If not set, will default to whatever the application configuration is set to (or its heuristics). References: * https://wikis.oracle.com/display/CommSuite/LDAP+General+Information+and+Time+Zones#LDAPGeneralInformationandTimeZones-ANOFE * http://docs.oracle.com/cd/E19683-01/816-4856/nisplus2ldap-59/index.html * http://tracker.moodle.org/browse/MDL-17330\n"
		   });		
		addAnnotation
		  (getPerson_ReferrerId(), 
		   source, 
		   new String[] {
			 "documentation", "Person ID who refers this person"
		   });		
		addAnnotation
		  (getPerson_ReferrerType(), 
		   source, 
		   new String[] {
			 "documentation", "Type of referrer for example : person_id , email, facebook_id\n\n"
		   });		
		addAnnotation
		  (getPerson_SignupSource(), 
		   source, 
		   new String[] {
			 "documentation", "Signup source name, e.g. \"Rudi Wijaya\" for {@link SignupSourceType#FACEBOOK_FRIEND}."
		   });		
		addAnnotation
		  (getPerson_SignupSourceType(), 
		   source, 
		   new String[] {
			 "documentation", "Signup source type, e.g. {@link SignupSourceType#FACEBOOK_FRIEND}."
		   });		
		addAnnotation
		  (getPerson_IpAddress(), 
		   source, 
		   new String[] {
			 "documentation", "IP address pertama kali login"
		   });		
		addAnnotation
		  (getPerson_LastIpAddress(), 
		   source, 
		   new String[] {
			 "documentation", "IP address terakhir kali login"
		   });		
		addAnnotation
		  (getPerson_LastLoginTime(), 
		   source, 
		   new String[] {
			 "documentation", "kapan terakhir kali login"
		   });		
		addAnnotation
		  (getPerson_ValidationTime(), 
		   source, 
		   new String[] {
			 "documentation", "kapan dia validate email"
		   });		
		addAnnotation
		  (getPerson_ActivationTime(), 
		   source, 
		   new String[] {
			 "documentation", "kapan akun dia aktif (bila dimoderasi)"
		   });		
		addAnnotation
		  (getPerson_VerificationTime(), 
		   source, 
		   new String[] {
			 "documentation", "kapan dia menjadi verified member"
		   });		
		addAnnotation
		  (getPerson_NewsletterSubscriptionEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Apakah dia ingin menerima newsletter."
		   });		
		addAnnotation
		  (getPerson_NewsletterSubscriptionTime(), 
		   source, 
		   new String[] {
			 "documentation", "Kapan dia terdaftar di newsletter"
		   });		
		addAnnotation
		  (getPerson_SocialSharingEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Apakah dia ingin mensharing aktivitasnya di social network seperti Twitter, Facebook, Path, Google+, dll. (secara umum, konfigurasi spesifik di tempat lain)"
		   });		
		addAnnotation
		  (getPerson_PublicationStatus(), 
		   source, 
		   new String[] {
			 "documentation", "atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).\n\n<ol>\n\t<li>draft</li>\n\t<li>published</li>\n\t<li>unpublished</li>\n</ol>"
		   });		
		addAnnotation
		  (getPerson_ArchivalStatus(), 
		   source, 
		   new String[] {
			 "documentation", "atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya. fresh archived\n\n"
		   });		
		addAnnotation
		  (getPerson_Folder(), 
		   source, 
		   new String[] {
			 "documentation", "atribut untuk labeling. Masukkan nsPrefix_{folderName}. (folder name di sini underscore lowercase)"
		   });		
		addAnnotation
		  (getPerson_PasswordResetCode(), 
		   source, 
		   new String[] {
			 "documentation", "Code that can be used to perform password reset for a limited time."
		   });		
		addAnnotation
		  (getPerson_PasswordResetExpiryTime(), 
		   source, 
		   new String[] {
			 "documentation", "The time when the passwordResetCode becomes no longer usable."
		   });		
		addAnnotation
		  (getPhoneNumber_Primary(), 
		   source, 
		   new String[] {
			 "documentation", "Designates this PhoneNumber as the primary PhoneNumber of the containing list."
		   });		
		addAnnotation
		  (getPhoneNumber_ValidationTime(), 
		   source, 
		   new String[] {
			 "documentation", "When this phone number was validated by the user."
		   });		
		addAnnotation
		  (getEmail_Primary(), 
		   source, 
		   new String[] {
			 "documentation", "Designates this Email as the primary Email of the containing list."
		   });		
		addAnnotation
		  (getEmail_ValidationTime(), 
		   source, 
		   new String[] {
			 "documentation", "When this email was validated by the user."
		   });		
		addAnnotation
		  (postalAddressEClass, 
		   source, 
		   new String[] {
			 "documentation", "See http://www.upu.int/en/activities/addressing/standards.html - UPU S42.\n\nID is RFC1274: unique identifer.\nLDAP: uniqueIdentifier\n\n\'name\' attribute is Person name who will receive.\nRFC2256: common name(s) for which the entity is known by.\ncn, commonName.\n\nCan be used as:\n\n1. Billing Address in SalesQuote/SalesOrder\n2. Shipping Address in SalesQuote/SalesOrder\n3. Origin Address in SalesQuote/SalesOrder\n4. Person (Customer) Address\n5. Shop Address\n6. Mall Address\n"
		   });		
		addAnnotation
		  (getPostalAddress_Organization(), 
		   source, 
		   new String[] {
			 "documentation", "Organization or company name who will send or receive.\nCan be empty.\nRFC2256: organization this object belongs to\nLDAP: o, organizationName"
		   });		
		addAnnotation
		  (getPostalAddress_Country(), 
		   source, 
		   new String[] {
			 "documentation", "RFC1274: friendly country name.\n\nLDAP: co, friendlyCountryName"
		   });		
		addAnnotation
		  (getPostalAddress_CountryCode(), 
		   source, 
		   new String[] {
			 "documentation", "ISO 3166-1 alpha-2.\n\nLDAP: c, countryName"
		   });		
		addAnnotation
		  (getPostalAddress_Mobiles(), 
		   source, 
		   new String[] {
			 "documentation", "RFC1274: mobile telephone number\nLDAP: mobile, mobileTelephoneNumber"
		   });		
		addAnnotation
		  (getPostalAddress_PrimaryPhone(), 
		   source, 
		   new String[] {
			 "documentation", "RFC2256: Telephone Number\nLDAP: telephoneNumber\n\nFor offices, usually work phone. For people, usually home phone."
		   });		
		addAnnotation
		  (getPostalAddress_HomePhones(), 
		   source, 
		   new String[] {
			 "documentation", "RFC1274: home telephone number.\nLDAP: homePhone, homeTelephoneNumber."
		   });		
		addAnnotation
		  (getPostalAddress_WorkPhones(), 
		   source, 
		   new String[] {
			 "documentation", "RFC2256: Telephone Number.\nLDAP: (not yet mapped)"
		   });		
		addAnnotation
		  (getPostalAddress_Emails(), 
		   source, 
		   new String[] {
			 "documentation", "LDAP: mail."
		   });		
		addAnnotation
		  (getPostalAddress_Description(), 
		   source, 
		   new String[] {
			 "documentation", "What this address represents, usually \"Home\", \"Work\", etc."
		   });		
		addAnnotation
		  (getPostalAddress_Primary(), 
		   source, 
		   new String[] {
			 "documentation", "Designates this Address as the primary Address of the containing list."
		   });		
		addAnnotation
		  (getPostalAddress_PrimaryBilling(), 
		   source, 
		   new String[] {
			 "documentation", "Designates this Address as the primary billing Address of the containing list."
		   });		
		addAnnotation
		  (getPostalAddress_PrimaryShipping(), 
		   source, 
		   new String[] {
			 "documentation", "Designates this Address as the primary billing Address of the containing list."
		   });		
		addAnnotation
		  (getPostalAddress_ValidationTime(), 
		   source, 
		   new String[] {
			 "documentation", "When this postal address was validated by the user."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Other."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Google Search Engine."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Google AdSense / AdWords ads."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Facebook Ads."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Facebook friend."
		   });		
		addAnnotation
		  (signupSourceTypeEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Alia magazine."
		   });		
		addAnnotation
		  (canonicalSluggableEClass, 
		   source, 
		   new String[] {
			 "documentation", "TODO: Consider merging this with {@link Sluggable}?"
		   });		
		addAnnotation
		  (getCanonicalSluggable_CanonicalSlug(), 
		   source, 
		   new String[] {
			 "documentation", "Canonical slug is lowercase, and removes every character not in a-z, 0-9, and underscore.\n\n<p>It is useful for e.g. making both http://www.satukancinta.com/arum.puspita and http://www.satukancinta.com/arumpuspita or even http://www.satukancinta.com/member/arum.pus.pi.ta usable.\n\n<p>From the technical point-of-view (easy matching/lookup), the canonical slug/identifier for arum.puspita is arumpuspita, the canonicalSlug should be indexed in database for fast matching. From the user or SEO point-of-view however, the \"canonical\" one is arum.puspita, but it is not what is meant here.\n\n<p>Use {@link SlugUtils#canonicalize()} to generate canonical slug from user-provided slug."
		   });
	}
	
	public static CommonsPackage getInstance() {
		return eINSTANCE;
	}

} //CommonsPackageImpl
