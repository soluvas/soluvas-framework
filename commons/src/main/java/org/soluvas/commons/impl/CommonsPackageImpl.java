package org.soluvas.commons.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import javax.measure.Measurable;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.Temperature;
import javax.measure.unit.Unit;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.joda.money.BigMoneyProvider;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.CustomerRoleStatus;
import org.soluvas.commons.Organization;
import org.soluvas.commons.Describable;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.EObjectLinked;
import org.soluvas.commons.Email;
import org.soluvas.commons.EventBusProgressMonitor;
import org.soluvas.commons.Expandable;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.FacebookAccessible;
import org.soluvas.commons.FacebookIdentity;
import org.soluvas.commons.Gender;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.GenericStatus;
import org.soluvas.commons.Geolocation;
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
import org.soluvas.commons.Revisionable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.Sluggable;
import org.soluvas.commons.StyleConfiguration;
import org.soluvas.commons.SysConfig;
import org.soluvas.commons.TenantSource;
import org.soluvas.commons.ThingInfo;
import org.soluvas.commons.Timestamped;
import org.soluvas.commons.Translatable;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationManager;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.TwitterAccessible;
import org.soluvas.commons.TwitterIdentity;
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
	private EClass twitterAccessibleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass twitterIdentityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facebookIdentityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facebookAccessibleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geolocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thingInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerRoleEClass = null;

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
	private EEnum tenantSourceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum genericStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum customerRoleStatusEEnum = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType noSuchElementExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dequeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType temperatureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType localTimeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eFactoryEDataType = null;

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
	public EAttribute getAppManifest_Summary() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_Description() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_Domain() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DomainPrd() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DomainDev() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DomainStg() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_GeneralEmail() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_OrganizationName() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_OrganizationAddress() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_LetterSalutation() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppManifest_LetterClosing() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultTimeZoneId() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultTimeZone() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultCurrencyCode() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultCurrency() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_EmailLogoUriTemplate() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultLanguageTag() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppManifest_DefaultCountryCode() {
		return (EAttribute)appManifestEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAppManifest__GetDefaultLocale() {
		return appManifestEClass.getEOperations().get(0);
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
	public EOperation getNameable__GetName() {
		return nameableEClass.getEOperations().get(0);
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
	public EOperation getImageable__GetImageId() {
		return imageableEClass.getEOperations().get(0);
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
	public EOperation getInformer__ToInfo() {
		return informerEClass.getEOperations().get(0);
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
	public EOperation getJavaClassLinked__ResolveJavaClass__Bundle() {
		return javaClassLinkedEClass.getEOperations().get(0);
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
	public EOperation getEClassLinked__ResolveEClass__Map() {
		return eClassLinkedEClass.getEOperations().get(0);
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
	public EOperation getSchemaVersionable__GetSchemaVersion() {
		return schemaVersionableEClass.getEOperations().get(0);
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
	public EAttribute getEFactoryLinked_EFactory() {
		return (EAttribute)eFactoryLinkedEClass.getEStructuralFeatures().get(0);
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
	public EOperation getWebAddress__GetApiUri() {
		return webAddressEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWebAddress__GetSecureApiUri() {
		return webAddressEClass.getEOperations().get(1);
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
	public EOperation getEObjectLinked__GetObject() {
		return eObjectLinkedEClass.getEOperations().get(0);
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
	public EAttribute getParentable_Parent() {
		return (EAttribute)parentableEClass.getEStructuralFeatures().get(0);
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
	public EOperation getProgressMonitor__BeginTask__String_long() {
		return progressMonitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__Done() {
		return progressMonitorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__InternalWorked__double() {
		return progressMonitorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__SubTask__String() {
		return progressMonitorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__Worked__long() {
		return progressMonitorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__Done__ProgressStatus() {
		return progressMonitorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProgressMonitor__Worked__long_ProgressStatus() {
		return progressMonitorEClass.getEOperations().get(6);
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
	public EOperation getTranslationManager__Translate__Translatable_String() {
		return translationManagerEClass.getEOperations().get(0);
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
	public EOperation getStyleConfiguration__GetDefaultStyle() {
		return styleConfigurationEClass.getEOperations().get(0);
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
	public EOperation getExpandable__Expand__Map() {
		return expandableEClass.getEOperations().get(0);
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
	public EOperation getPersonLike__GetId() {
		return personLikeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonLike__GetName() {
		return personLikeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonLike__GetSlug() {
		return personLikeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonLike__GetEmail() {
		return personLikeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonLike__GetPhotoId() {
		return personLikeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonLike__GetGender() {
		return personLikeEClass.getEOperations().get(5);
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
	public EAttribute getPerson_GooglePlusId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_GoogleUsername() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_VirtualMail() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Nickname() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_CustomerRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_MemberRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ManagerRole() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TimeZoneId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TimeZone() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ReferrerId() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ReferrerType() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SignupSource() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SignupSourceType() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_IpAddress() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastIpAddress() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastLoginTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ValidationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ActivationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_VerificationTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NewsletterSubscriptionEnabled() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_NewsletterSubscriptionTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SocialSharingEnabled() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PublicationStatus() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ArchivalStatus() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Folder() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Religion() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PasswordResetCode() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PasswordResetExpiryTime() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_ClientAccessToken() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SecurityRoleIds() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_DebitBalance() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_DebitCurrency() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Type() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_VerifyCode() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Organizations() {
		return (EReference)personEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPerson__HasEmail__String() {
		return personEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPerson__PutEmail__String() {
		return personEClass.getEOperations().get(1);
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
	public EClass getTwitterAccessible() {
		return twitterAccessibleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterAccessible_TwitterAccessToken() {
		return (EAttribute)twitterAccessibleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterAccessible_TwitterAccessTokenSecret() {
		return (EAttribute)twitterAccessibleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTwitterIdentity() {
		return twitterIdentityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterIdentity_TwitterId() {
		return (EAttribute)twitterIdentityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwitterIdentity_TwitterScreenName() {
		return (EAttribute)twitterIdentityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacebookIdentity() {
		return facebookIdentityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookIdentity_FacebookId() {
		return (EAttribute)facebookIdentityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookIdentity_FacebookUsername() {
		return (EAttribute)facebookIdentityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacebookAccessible() {
		return facebookAccessibleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacebookAccessible_FacebookAccessToken() {
		return (EAttribute)facebookAccessibleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionable() {
		return revisionableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionable_Guid() {
		return (EAttribute)revisionableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionable_Revision() {
		return (EAttribute)revisionableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSysConfig() {
		return sysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSysConfig_TenantId() {
		return (EAttribute)sysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeolocation() {
		return geolocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeolocation_Latitude() {
		return (EAttribute)geolocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeolocation_Longitude() {
		return (EAttribute)geolocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeolocation_Elevation() {
		return (EAttribute)geolocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThingInfo() {
		return thingInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThingInfo_ImageId() {
		return (EAttribute)thingInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralSysConfig() {
		return generalSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganization() {
		return organizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_SchemaVersion() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_BlackBerryPin() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_Website() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_FacebookPageUri() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_FacebookAccessToken() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_FacebookId() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_FacebookUserName() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TwitterScreenName() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TwitterAccessToken() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TwitterAccessTokenSecret() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TwitterId() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerRole() {
		return customerRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerRole_SchemaVersion() {
		return (EAttribute)customerRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomerRole_Status() {
		return (EAttribute)customerRoleEClass.getEStructuralFeatures().get(1);
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
	public EEnum getTenantSource() {
		return tenantSourceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGenericStatus() {
		return genericStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCustomerRoleStatus() {
		return customerRoleStatusEEnum;
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
	public EDataType getNoSuchElementException() {
		return noSuchElementExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDeque() {
		return dequeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTemperature() {
		return temperatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLocalTime() {
		return localTimeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getException() {
		return exceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEFactory() {
		return eFactoryEDataType;
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
		createEAttribute(appManifestEClass, APP_MANIFEST__SUMMARY);
		createEAttribute(appManifestEClass, APP_MANIFEST__DESCRIPTION);
		createEAttribute(appManifestEClass, APP_MANIFEST__DOMAIN);
		createEAttribute(appManifestEClass, APP_MANIFEST__DOMAIN_PRD);
		createEAttribute(appManifestEClass, APP_MANIFEST__DOMAIN_DEV);
		createEAttribute(appManifestEClass, APP_MANIFEST__DOMAIN_STG);
		createEAttribute(appManifestEClass, APP_MANIFEST__GENERAL_EMAIL);
		createEAttribute(appManifestEClass, APP_MANIFEST__ORGANIZATION_NAME);
		createEAttribute(appManifestEClass, APP_MANIFEST__ORGANIZATION_ADDRESS);
		createEAttribute(appManifestEClass, APP_MANIFEST__LETTER_SALUTATION);
		createEAttribute(appManifestEClass, APP_MANIFEST__LETTER_CLOSING);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_TIME_ZONE_ID);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_TIME_ZONE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_CURRENCY_CODE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_CURRENCY);
		createEAttribute(appManifestEClass, APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_LANGUAGE_TAG);
		createEAttribute(appManifestEClass, APP_MANIFEST__DEFAULT_COUNTRY_CODE);
		createEOperation(appManifestEClass, APP_MANIFEST___GET_DEFAULT_LOCALE);

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
		createEOperation(nameableEClass, NAMEABLE___GET_NAME);

		imageableEClass = createEClass(IMAGEABLE);
		createEOperation(imageableEClass, IMAGEABLE___GET_IMAGE_ID);

		photoIdContainerEClass = createEClass(PHOTO_ID_CONTAINER);
		createEAttribute(photoIdContainerEClass, PHOTO_ID_CONTAINER__PHOTO_ID);

		nameContainerEClass = createEClass(NAME_CONTAINER);
		createEAttribute(nameContainerEClass, NAME_CONTAINER__NAME);

		informerEClass = createEClass(INFORMER);
		createEOperation(informerEClass, INFORMER___TO_INFO);

		describableEClass = createEClass(DESCRIBABLE);
		createEAttribute(describableEClass, DESCRIBABLE__DESCRIPTION);

		bundleAwareEClass = createEClass(BUNDLE_AWARE);
		createEAttribute(bundleAwareEClass, BUNDLE_AWARE__BUNDLE);

		javaClassLinkedEClass = createEClass(JAVA_CLASS_LINKED);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS_NAME);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS);
		createEAttribute(javaClassLinkedEClass, JAVA_CLASS_LINKED__JAVA_CLASS_STATUS);
		createEOperation(javaClassLinkedEClass, JAVA_CLASS_LINKED___RESOLVE_JAVA_CLASS__BUNDLE);

		eClassLinkedEClass = createEClass(ECLASS_LINKED);
		createEReference(eClassLinkedEClass, ECLASS_LINKED__ECLASS);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__ECLASS_STATUS);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__EPACKAGE_NS_PREFIX);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__ECLASS_NAME);
		createEAttribute(eClassLinkedEClass, ECLASS_LINKED__EPACKAGE_NAME);
		createEOperation(eClassLinkedEClass, ECLASS_LINKED___RESOLVE_ECLASS__MAP);

		schemaVersionableEClass = createEClass(SCHEMA_VERSIONABLE);
		createEOperation(schemaVersionableEClass, SCHEMA_VERSIONABLE___GET_SCHEMA_VERSION);

		eFactoryLinkedEClass = createEClass(EFACTORY_LINKED);
		createEAttribute(eFactoryLinkedEClass, EFACTORY_LINKED__EFACTORY);

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
		createEOperation(webAddressEClass, WEB_ADDRESS___GET_API_URI);
		createEOperation(webAddressEClass, WEB_ADDRESS___GET_SECURE_API_URI);

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
		createEOperation(eObjectLinkedEClass, EOBJECT_LINKED___GET_OBJECT);

		parentableEClass = createEClass(PARENTABLE);
		createEAttribute(parentableEClass, PARENTABLE__PARENT);

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
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___BEGIN_TASK__STRING_LONG);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___DONE);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___INTERNAL_WORKED__DOUBLE);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___SUB_TASK__STRING);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___WORKED__LONG);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___DONE__PROGRESSSTATUS);
		createEOperation(progressMonitorEClass, PROGRESS_MONITOR___WORKED__LONG_PROGRESSSTATUS);

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
		createEOperation(translationManagerEClass, TRANSLATION_MANAGER___TRANSLATE__TRANSLATABLE_STRING);

		translationEntryEClass = createEClass(TRANSLATION_ENTRY);
		createEReference(translationEntryEClass, TRANSLATION_ENTRY__VALUE);
		createEAttribute(translationEntryEClass, TRANSLATION_ENTRY__KEY);

		styleConfigurationEClass = createEClass(STYLE_CONFIGURATION);
		createEOperation(styleConfigurationEClass, STYLE_CONFIGURATION___GET_DEFAULT_STYLE);

		expandableEClass = createEClass(EXPANDABLE);
		createEAttribute(expandableEClass, EXPANDABLE__EXPANSION_STATE);
		createEOperation(expandableEClass, EXPANDABLE___EXPAND__MAP);

		personLikeEClass = createEClass(PERSON_LIKE);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_ID);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_NAME);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_SLUG);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_EMAIL);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_PHOTO_ID);
		createEOperation(personLikeEClass, PERSON_LIKE___GET_GENDER);

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
		createEAttribute(personEClass, PERSON__CLIENT_ACCESS_TOKEN);
		createEAttribute(personEClass, PERSON__SECURITY_ROLE_IDS);
		createEAttribute(personEClass, PERSON__DEBIT_BALANCE);
		createEAttribute(personEClass, PERSON__DEBIT_CURRENCY);
		createEAttribute(personEClass, PERSON__TYPE);
		createEAttribute(personEClass, PERSON__VERIFY_CODE);
		createEReference(personEClass, PERSON__ORGANIZATIONS);
		createEOperation(personEClass, PERSON___HAS_EMAIL__STRING);
		createEOperation(personEClass, PERSON___PUT_EMAIL__STRING);

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

		twitterAccessibleEClass = createEClass(TWITTER_ACCESSIBLE);
		createEAttribute(twitterAccessibleEClass, TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN);
		createEAttribute(twitterAccessibleEClass, TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN_SECRET);

		twitterIdentityEClass = createEClass(TWITTER_IDENTITY);
		createEAttribute(twitterIdentityEClass, TWITTER_IDENTITY__TWITTER_ID);
		createEAttribute(twitterIdentityEClass, TWITTER_IDENTITY__TWITTER_SCREEN_NAME);

		facebookIdentityEClass = createEClass(FACEBOOK_IDENTITY);
		createEAttribute(facebookIdentityEClass, FACEBOOK_IDENTITY__FACEBOOK_ID);
		createEAttribute(facebookIdentityEClass, FACEBOOK_IDENTITY__FACEBOOK_USERNAME);

		facebookAccessibleEClass = createEClass(FACEBOOK_ACCESSIBLE);
		createEAttribute(facebookAccessibleEClass, FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN);

		revisionableEClass = createEClass(REVISIONABLE);
		createEAttribute(revisionableEClass, REVISIONABLE__GUID);
		createEAttribute(revisionableEClass, REVISIONABLE__REVISION);

		sysConfigEClass = createEClass(SYS_CONFIG);
		createEAttribute(sysConfigEClass, SYS_CONFIG__TENANT_ID);

		geolocationEClass = createEClass(GEOLOCATION);
		createEAttribute(geolocationEClass, GEOLOCATION__LATITUDE);
		createEAttribute(geolocationEClass, GEOLOCATION__LONGITUDE);
		createEAttribute(geolocationEClass, GEOLOCATION__ELEVATION);

		thingInfoEClass = createEClass(THING_INFO);
		createEAttribute(thingInfoEClass, THING_INFO__IMAGE_ID);

		generalSysConfigEClass = createEClass(GENERAL_SYS_CONFIG);

		organizationEClass = createEClass(ORGANIZATION);
		createEAttribute(organizationEClass, ORGANIZATION__SCHEMA_VERSION);
		createEAttribute(organizationEClass, ORGANIZATION__BLACK_BERRY_PIN);
		createEAttribute(organizationEClass, ORGANIZATION__WEBSITE);
		createEAttribute(organizationEClass, ORGANIZATION__FACEBOOK_PAGE_URI);
		createEAttribute(organizationEClass, ORGANIZATION__FACEBOOK_ACCESS_TOKEN);
		createEAttribute(organizationEClass, ORGANIZATION__FACEBOOK_ID);
		createEAttribute(organizationEClass, ORGANIZATION__FACEBOOK_USER_NAME);
		createEAttribute(organizationEClass, ORGANIZATION__TWITTER_SCREEN_NAME);
		createEAttribute(organizationEClass, ORGANIZATION__TWITTER_ACCESS_TOKEN);
		createEAttribute(organizationEClass, ORGANIZATION__TWITTER_ACCESS_TOKEN_SECRET);
		createEAttribute(organizationEClass, ORGANIZATION__TWITTER_ID);

		customerRoleEClass = createEClass(CUSTOMER_ROLE);
		createEAttribute(customerRoleEClass, CUSTOMER_ROLE__SCHEMA_VERSION);
		createEAttribute(customerRoleEClass, CUSTOMER_ROLE__STATUS);

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
		tenantSourceEEnum = createEEnum(TENANT_SOURCE);
		genericStatusEEnum = createEEnum(GENERIC_STATUS);
		customerRoleStatusEEnum = createEEnum(CUSTOMER_ROLE_STATUS);

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
		noSuchElementExceptionEDataType = createEDataType(NO_SUCH_ELEMENT_EXCEPTION);
		dequeEDataType = createEDataType(DEQUE);
		temperatureEDataType = createEDataType(TEMPERATURE);
		localTimeEDataType = createEDataType(LOCAL_TIME);
		exceptionEDataType = createEDataType(EXCEPTION);
		eFactoryEDataType = createEDataType(EFACTORY);
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
		addETypeParameter(dequeEDataType, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getIdentifiable());
		informerEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		addedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		modelNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		attributeSetEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		attributeUnsetEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		removedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		objectNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		attributeNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		addedManyEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		removedManyEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		objectsNotificationEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		eObjectLinkedEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getQuantity());
		unitEDataType_Q.getEBounds().add(g1);
		g1 = createEGenericType(this.getQuantity());
		measurableEDataType_Q.getEBounds().add(g1);

		// Add supertypes to classes
		appManifestEClass.getESuperTypes().add(this.getPositionable());
		appManifestEClass.getESuperTypes().add(this.getResourceAware());
		appManifestEClass.getESuperTypes().add(this.getBundleAware());
		appManifestEClass.getESuperTypes().add(this.getExpandable());
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
		categoryLikeEClass.getESuperTypes().add(this.getIdentifiable());
		categoryLikeEClass.getESuperTypes().add(this.getNsPrefixable());
		categoryLikeEClass.getESuperTypes().add(this.getNameContainer());
		categoryLikeEClass.getESuperTypes().add(this.getPositionable());
		categoryLikeEClass.getESuperTypes().add(this.getSluggable());
		categoryLikeEClass.getESuperTypes().add(this.getImageable());
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
		g1 = createEGenericType(this.getTwitterAccessible());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTwitterIdentity());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFacebookIdentity());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFacebookAccessible());
		personEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getRevisionable());
		personEClass.getEGenericSuperTypes().add(g1);
		postalAddressEClass.getESuperTypes().add(this.getNameContainer());
		postalAddressEClass.getESuperTypes().add(this.getIdentifiable());
		postalAddressEClass.getESuperTypes().add(this.getSchemaVersionable());
		canonicalSluggableEClass.getESuperTypes().add(this.getSluggable());
		sysConfigEClass.getESuperTypes().add(this.getTimestamped());
		thingInfoEClass.getESuperTypes().add(this.getNameContainer());
		thingInfoEClass.getESuperTypes().add(this.getIdentifiable());
		thingInfoEClass.getESuperTypes().add(this.getSluggable());
		thingInfoEClass.getESuperTypes().add(this.getImageable());
		generalSysConfigEClass.getESuperTypes().add(this.getExpandable());
		organizationEClass.getESuperTypes().add(this.getIdentifiable());
		organizationEClass.getESuperTypes().add(this.getSchemaVersionable());
		organizationEClass.getESuperTypes().add(this.getNameContainer());
		customerRoleEClass.getESuperTypes().add(this.getIdentifiable());
		customerRoleEClass.getESuperTypes().add(this.getSchemaVersionable());
		customerRoleEClass.getESuperTypes().add(this.getNameContainer());
		customerRoleEClass.getESuperTypes().add(this.getTimestamped());

		// Initialize classes, features, and operations; add parameters
		initEClass(resourceAwareEClass, ResourceAware.class, "ResourceAware", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceAware_ResourceType(), this.getResourceType(), "resourceType", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAware_ResourceUri(), ecorePackage.getEString(), "resourceUri", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceAware_ResourceName(), ecorePackage.getEString(), "resourceName", null, 0, 1, ResourceAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionableEClass, Positionable.class, "Positionable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPositionable_Positioner(), ecorePackage.getEIntegerObject(), "positioner", "0", 0, 1, Positionable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appManifestEClass, AppManifest.class, "AppManifest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppManifest_Title(), ecorePackage.getEString(), "title", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_Summary(), ecorePackage.getEString(), "summary", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_Description(), ecorePackage.getEString(), "description", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_Domain(), ecorePackage.getEString(), "domain", "{+tenantId}.{+appDomain}", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DomainPrd(), ecorePackage.getEString(), "domainPrd", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DomainDev(), ecorePackage.getEString(), "domainDev", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DomainStg(), ecorePackage.getEString(), "domainStg", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_GeneralEmail(), ecorePackage.getEString(), "generalEmail", "{+userName}@{+fqdn}", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_OrganizationName(), ecorePackage.getEString(), "organizationName", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_OrganizationAddress(), ecorePackage.getEString(), "organizationAddress", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_LetterSalutation(), ecorePackage.getEString(), "letterSalutation", "Hi", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_LetterClosing(), ecorePackage.getEString(), "letterClosing", null, 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultTimeZoneId(), ecorePackage.getEString(), "defaultTimeZoneId", "UTC", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultTimeZone(), this.getDateTimeZone(), "defaultTimeZone", null, 0, 1, AppManifest.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultCurrencyCode(), ecorePackage.getEString(), "defaultCurrencyCode", "USD", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultCurrency(), this.getCurrencyUnit(), "defaultCurrency", null, 0, 1, AppManifest.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_EmailLogoUriTemplate(), ecorePackage.getEString(), "emailLogoUriTemplate", "{+imagesUri}tenant_common/logo_email.png", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultLanguageTag(), ecorePackage.getEString(), "defaultLanguageTag", "en-US", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppManifest_DefaultCountryCode(), ecorePackage.getEString(), "defaultCountryCode", "US", 0, 1, AppManifest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAppManifest__GetDefaultLocale(), this.getLocale(), "getDefaultLocale", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(personInfoEClass, PersonInfo.class, "PersonInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersonInfo_Gender(), this.getGender(), "gender", null, 0, 1, PersonInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPersonInfo_Email(), ecorePackage.getEString(), "email", null, 0, 1, PersonInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timestampedEClass, Timestamped.class, "Timestamped", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimestamped_CreationTime(), this.getDateTime(), "creationTime", null, 0, 1, Timestamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimestamped_ModificationTime(), this.getDateTime(), "modificationTime", null, 0, 1, Timestamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Id(), ecorePackage.getEString(), "id", null, 0, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sluggableEClass, Sluggable.class, "Sluggable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSluggable_Slug(), ecorePackage.getEString(), "slug", null, 0, 1, Sluggable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getNameable__GetName(), ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(imageableEClass, Imageable.class, "Imageable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getImageable__GetImageId(), ecorePackage.getEString(), "getImageId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(photoIdContainerEClass, PhotoIdContainer.class, "PhotoIdContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhotoIdContainer_PhotoId(), ecorePackage.getEString(), "photoId", null, 0, 1, PhotoIdContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameContainerEClass, NameContainer.class, "NameContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameContainer_Name(), ecorePackage.getEString(), "name", null, 1, 1, NameContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(informerEClass, Informer.class, "Informer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getInformer__ToInfo(), null, "toInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(informerEClass_T);
		initEOperation(op, g1);

		initEClass(describableEClass, Describable.class, "Describable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescribable_Description(), ecorePackage.getEString(), "description", null, 0, 1, Describable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bundleAwareEClass, BundleAware.class, "BundleAware", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBundleAware_Bundle(), this.getBundle(), "bundle", null, 0, 1, BundleAware.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaClassLinkedEClass, JavaClassLinked.class, "JavaClassLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaClassLinked_JavaClassName(), ecorePackage.getEString(), "javaClassName", null, 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType(javaClassLinkedEClass_T);
		g1.getETypeArguments().add(g2);
		initEAttribute(getJavaClassLinked_JavaClass(), g1, "javaClass", null, 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaClassLinked_JavaClassStatus(), this.getJavaClassStatus(), "javaClassStatus", "unresolved", 0, 1, JavaClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getJavaClassLinked__ResolveJavaClass__Bundle(), null, "resolveJavaClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBundle(), "bundle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eClassLinkedEClass, EClassLinked.class, "EClassLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassLinked_EClass(), ecorePackage.getEClass(), null, "eClass", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EClassStatus(), this.getEClassStatus(), "eClassStatus", "unresolved", 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EPackageNsPrefix(), ecorePackage.getEString(), "ePackageNsPrefix", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EClassName(), ecorePackage.getEString(), "eClassName", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassLinked_EPackageName(), ecorePackage.getEString(), "ePackageName", null, 0, 1, EClassLinked.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getEClassLinked__ResolveEClass__Map(), null, "resolveEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEClass());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eClassMap", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(schemaVersionableEClass, SchemaVersionable.class, "SchemaVersionable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSchemaVersionable__GetSchemaVersion(), ecorePackage.getELong(), "getSchemaVersion", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eFactoryLinkedEClass, EFactoryLinked.class, "EFactoryLinked", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFactoryLinked_EFactory(), this.getEFactory(), "eFactory", null, 0, 1, EFactoryLinked.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nsPrefixableEClass, NsPrefixable.class, "NsPrefixable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNsPrefixable_NsPrefix(), ecorePackage.getEString(), "nsPrefix", null, 0, 1, NsPrefixable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEOperation(getWebAddress__GetApiUri(), ecorePackage.getEString(), "getApiUri", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getWebAddress__GetSecureApiUri(), ecorePackage.getEString(), "getSecureApiUri", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addedEClass, Added.class, "Added", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelNotificationEClass, ModelNotification.class, "ModelNotification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelNotification_Container(), ecorePackage.getEObject(), null, "container", null, 0, 1, ModelNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeSetEClass, AttributeSet.class, "AttributeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeUnsetEClass, AttributeUnset.class, "AttributeUnset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removedEClass, Removed.class, "Removed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectNotificationEClass, ObjectNotification.class, "ObjectNotification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(objectNotificationEClass_T);
		initEAttribute(getObjectNotification_Object(), g1, "object", null, 1, 1, ObjectNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeNotificationEClass, AttributeNotification.class, "AttributeNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeNotification_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, AttributeNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

		op = initEOperation(getEObjectLinked__GetObject(), null, "getObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(eObjectLinkedEClass_T);
		initEOperation(op, g1);

		initEClass(parentableEClass, Parentable.class, "Parentable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(parentableEClass_P);
		initEAttribute(getParentable_Parent(), g1, "parent", null, 0, 1, Parentable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryLikeEClass, CategoryLike.class, "CategoryLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryLike_SlugPath(), ecorePackage.getEString(), "slugPath", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_Color(), ecorePackage.getEString(), "color", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_Level(), ecorePackage.getEIntegerObject(), "level", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategoryLike_CategoryCount(), ecorePackage.getELongObject(), "categoryCount", null, 0, 1, CategoryLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryInfoEClass, CategoryInfo.class, "CategoryInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategoryInfo_Parents(), this.getCategoryInfo(), null, "parents", null, 0, -1, CategoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(progressMonitorEClass, ProgressMonitor.class, "ProgressMonitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgressMonitor_Canceled(), ecorePackage.getEBoolean(), "canceled", null, 0, 1, ProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgressMonitor_TaskName(), ecorePackage.getEString(), "taskName", null, 0, 1, ProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getProgressMonitor__BeginTask__String_long(), null, "beginTask", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "totalWork", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProgressMonitor__Done(), null, "done", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProgressMonitor__InternalWorked__double(), null, "internalWorked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDouble(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProgressMonitor__SubTask__String(), null, "subTask", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProgressMonitor__Worked__long(), null, "worked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProgressMonitor__Done__ProgressStatus(), null, "done", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgressStatus(), "status", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProgressMonitor__Worked__long_ProgressStatus(), null, "worked", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "work", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProgressStatus(), "status", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(shellProgressMonitorEClass, ShellProgressMonitor.class, "ShellProgressMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventBusProgressMonitorEClass, EventBusProgressMonitor.class, "EventBusProgressMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventBusProgressMonitor_EventBus(), this.getEventBus(), "eventBus", null, 0, 1, EventBusProgressMonitor.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventBusProgressMonitor_TrackingId(), ecorePackage.getEString(), "trackingId", null, 0, 1, EventBusProgressMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(progressMonitorWrapperEClass, ProgressMonitorWrapper.class, "ProgressMonitorWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgressMonitorWrapper_Delegate(), this.getProgressMonitor(), null, "delegate", null, 0, 1, ProgressMonitorWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorableEClass, Colorable.class, "Colorable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorable_Color(), ecorePackage.getEString(), "color", null, 0, 1, Colorable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translatableEClass, Translatable.class, "Translatable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslatable_TranslationState(), this.getTranslationState(), "translationState", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatable_OriginalLanguage(), ecorePackage.getEString(), "originalLanguage", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslatable_Language(), ecorePackage.getEString(), "language", null, 0, 1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslatable_Translations(), this.getTranslationEntry(), null, "translations", null, 0, -1, Translatable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationEClass, Translation.class, "Translation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslation_Language(), ecorePackage.getEString(), "language", null, 0, 1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTranslation_Messages(), this.getTranslationMessageEntry(), null, "messages", null, 0, -1, Translation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationMessageEntryEClass, Map.Entry.class, "TranslationMessageEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslationMessageEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslationMessageEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(translationManagerEClass, TranslationManager.class, "TranslationManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getTranslationManager__Translate__Translatable_String(), null, "translate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTranslatable(), "entity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "targetLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(translationEntryEClass, Map.Entry.class, "TranslationEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTranslationEntry_Value(), this.getTranslation(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTranslationEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(styleConfigurationEClass, StyleConfiguration.class, "StyleConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getStyleConfiguration__GetDefaultStyle(), ecorePackage.getEString(), "getDefaultStyle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandableEClass, Expandable.class, "Expandable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpandable_ExpansionState(), this.getExpansionState(), "expansionState", null, 0, 1, Expandable.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getExpandable__Expand__Map(), null, "expand", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "scope", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(personLikeEClass, PersonLike.class, "PersonLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPersonLike__GetId(), ecorePackage.getEString(), "getId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPersonLike__GetName(), ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPersonLike__GetSlug(), ecorePackage.getEString(), "getSlug", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPersonLike__GetEmail(), ecorePackage.getEString(), "getEmail", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPersonLike__GetPhotoId(), ecorePackage.getEString(), "getPhotoId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPersonLike__GetGender(), this.getGender(), "getGender", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "2", 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Password(), ecorePackage.getEString(), "password", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_PhoneNumbers(), this.getPhoneNumber(), null, "phoneNumbers", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Emails(), this.getEmail(), null, "emails", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_MobileNumbers(), this.getPhoneNumber(), null, "mobileNumbers", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Addresses(), this.getPostalAddress(), null, "addresses", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_AccountStatus(), this.getAccountStatus(), "accountStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthYear(), ecorePackage.getEIntegerObject(), "birthYear", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthMonth(), ecorePackage.getEIntegerObject(), "birthMonth", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthDay(), ecorePackage.getEIntegerObject(), "birthDay", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthDate(), this.getLocalDate(), "birthDate", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Gender(), this.getGender(), "gender", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Language(), ecorePackage.getEString(), "language", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_CurrencyCode(), ecorePackage.getEString(), "currencyCode", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Currency(), this.getCurrencyUnit(), "currency", null, 0, 1, Person.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GooglePlusId(), ecorePackage.getEString(), "googlePlusId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_GoogleUsername(), ecorePackage.getEString(), "googleUsername", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_VirtualMail(), ecorePackage.getEString(), "virtualMail", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Nickname(), ecorePackage.getEString(), "nickname", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_CustomerRole(), ecorePackage.getEString(), "customerRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_MemberRole(), ecorePackage.getEString(), "memberRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ManagerRole(), ecorePackage.getEString(), "managerRole", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TimeZoneId(), ecorePackage.getEString(), "timeZoneId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_TimeZone(), this.getDateTimeZone(), "timeZone", null, 0, 1, Person.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ReferrerId(), ecorePackage.getEString(), "referrerId", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ReferrerType(), ecorePackage.getEString(), "referrerType", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SignupSource(), ecorePackage.getEString(), "signupSource", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SignupSourceType(), this.getSignupSourceType(), "signupSourceType", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_IpAddress(), ecorePackage.getEString(), "ipAddress", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastIpAddress(), ecorePackage.getEString(), "lastIpAddress", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastLoginTime(), this.getDateTime(), "lastLoginTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ActivationTime(), this.getDateTime(), "activationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_VerificationTime(), this.getDateTime(), "verificationTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NewsletterSubscriptionEnabled(), ecorePackage.getEBooleanObject(), "newsletterSubscriptionEnabled", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_NewsletterSubscriptionTime(), this.getDateTime(), "newsletterSubscriptionTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SocialSharingEnabled(), ecorePackage.getEBooleanObject(), "socialSharingEnabled", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PublicationStatus(), this.getPublicationStatus(), "publicationStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ArchivalStatus(), this.getArchivalStatus(), "archivalStatus", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Folder(), ecorePackage.getEString(), "folder", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Religion(), ecorePackage.getEString(), "religion", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PasswordResetCode(), ecorePackage.getEString(), "passwordResetCode", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PasswordResetExpiryTime(), this.getDateTime(), "passwordResetExpiryTime", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_ClientAccessToken(), ecorePackage.getEString(), "clientAccessToken", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SecurityRoleIds(), ecorePackage.getEString(), "securityRoleIds", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_DebitBalance(), ecorePackage.getEBigDecimal(), "debitBalance", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_DebitCurrency(), this.getCurrencyUnit(), "debitCurrency", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Type(), ecorePackage.getEString(), "type", "Person", 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_VerifyCode(), ecorePackage.getEString(), "verifyCode", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Organizations(), this.getOrganization(), null, "organizations", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPerson__HasEmail__String(), ecorePackage.getEBoolean(), "hasEmail", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "email", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPerson__PutEmail__String(), this.getEmail(), "putEmail", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "email", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(phoneNumberEClass, PhoneNumber.class, "PhoneNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhoneNumber_PhoneNumber(), ecorePackage.getEString(), "phoneNumber", null, 1, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNumber_Primary(), ecorePackage.getEBoolean(), "primary", "false", 0, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhoneNumber_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, PhoneNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emailEClass, Email.class, "Email", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmail_Email(), ecorePackage.getEString(), "email", null, 1, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmail_Primary(), ecorePackage.getEBoolean(), "primary", "false", 0, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmail_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, Email.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postalAddressEClass, PostalAddress.class, "PostalAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPostalAddress_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "3", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
		initEAttribute(getPostalAddress_Primary(), ecorePackage.getEBoolean(), "primary", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryBilling(), ecorePackage.getEBoolean(), "primaryBilling", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_PrimaryShipping(), ecorePackage.getEBoolean(), "primaryShipping", "false", 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostalAddress_ValidationTime(), this.getDateTime(), "validationTime", null, 0, 1, PostalAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personCatalogEClass, PersonCatalog.class, "PersonCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersonCatalog_People(), this.getPerson(), null, "people", null, 0, -1, PersonCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(canonicalSluggableEClass, CanonicalSluggable.class, "CanonicalSluggable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCanonicalSluggable_CanonicalSlug(), ecorePackage.getEString(), "canonicalSlug", null, 0, 1, CanonicalSluggable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(twitterAccessibleEClass, TwitterAccessible.class, "TwitterAccessible", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTwitterAccessible_TwitterAccessToken(), ecorePackage.getEString(), "twitterAccessToken", null, 0, 1, TwitterAccessible.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterAccessible_TwitterAccessTokenSecret(), ecorePackage.getEString(), "twitterAccessTokenSecret", null, 0, 1, TwitterAccessible.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(twitterIdentityEClass, TwitterIdentity.class, "TwitterIdentity", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTwitterIdentity_TwitterId(), ecorePackage.getELongObject(), "twitterId", null, 0, 1, TwitterIdentity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTwitterIdentity_TwitterScreenName(), ecorePackage.getEString(), "twitterScreenName", null, 0, 1, TwitterIdentity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facebookIdentityEClass, FacebookIdentity.class, "FacebookIdentity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacebookIdentity_FacebookId(), ecorePackage.getELongObject(), "facebookId", null, 0, 1, FacebookIdentity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacebookIdentity_FacebookUsername(), ecorePackage.getEString(), "facebookUsername", null, 0, 1, FacebookIdentity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facebookAccessibleEClass, FacebookAccessible.class, "FacebookAccessible", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacebookAccessible_FacebookAccessToken(), ecorePackage.getEString(), "facebookAccessToken", null, 0, 1, FacebookAccessible.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionableEClass, Revisionable.class, "Revisionable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevisionable_Guid(), ecorePackage.getEString(), "guid", null, 0, 1, Revisionable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionable_Revision(), ecorePackage.getEString(), "revision", null, 0, 1, Revisionable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sysConfigEClass, SysConfig.class, "SysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSysConfig_TenantId(), ecorePackage.getEString(), "tenantId", null, 0, 1, SysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geolocationEClass, Geolocation.class, "Geolocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeolocation_Latitude(), ecorePackage.getEDoubleObject(), "latitude", null, 0, 1, Geolocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeolocation_Longitude(), ecorePackage.getEDoubleObject(), "longitude", null, 0, 1, Geolocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeolocation_Elevation(), ecorePackage.getEDoubleObject(), "elevation", null, 0, 1, Geolocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thingInfoEClass, ThingInfo.class, "ThingInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThingInfo_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1, ThingInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalSysConfigEClass, GeneralSysConfig.class, "GeneralSysConfig", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationEClass, Organization.class, "Organization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrganization_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "1", 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_BlackBerryPin(), ecorePackage.getEString(), "blackBerryPin", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_Website(), ecorePackage.getEString(), "website", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_FacebookPageUri(), ecorePackage.getEString(), "facebookPageUri", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_FacebookAccessToken(), ecorePackage.getEString(), "facebookAccessToken", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_FacebookId(), ecorePackage.getEString(), "facebookId", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_FacebookUserName(), ecorePackage.getEString(), "facebookUserName", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_TwitterScreenName(), ecorePackage.getEString(), "twitterScreenName", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_TwitterAccessToken(), ecorePackage.getEString(), "twitterAccessToken", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_TwitterAccessTokenSecret(), ecorePackage.getEString(), "twitterAccessTokenSecret", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrganization_TwitterId(), ecorePackage.getEString(), "twitterId", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customerRoleEClass, CustomerRole.class, "CustomerRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomerRole_SchemaVersion(), ecorePackage.getELong(), "schemaVersion", "1", 0, 1, CustomerRole.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomerRole_Status(), this.getCustomerRoleStatus(), "status", null, 0, 1, CustomerRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(resourceTypeEEnum, ResourceType.class, "ResourceType");
		addEEnumLiteral(resourceTypeEEnum, ResourceType.BUNDLE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.FILE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.DATABASE);
		addEEnumLiteral(resourceTypeEEnum, ResourceType.CLASSPATH);

		initEEnum(genderEEnum, Gender.class, "Gender");
		addEEnumLiteral(genderEEnum, Gender.UNKNOWN);
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

		initEEnum(tenantSourceEEnum, TenantSource.class, "TenantSource");
		addEEnumLiteral(tenantSourceEEnum, TenantSource.CONFIG);
		addEEnumLiteral(tenantSourceEEnum, TenantSource.REPOSITORY);

		initEEnum(genericStatusEEnum, GenericStatus.class, "GenericStatus");
		addEEnumLiteral(genericStatusEEnum, GenericStatus.BOOKED);
		addEEnumLiteral(genericStatusEEnum, GenericStatus.DRAFT);
		addEEnumLiteral(genericStatusEEnum, GenericStatus.INACTIVE);
		addEEnumLiteral(genericStatusEEnum, GenericStatus.VOID);

		initEEnum(customerRoleStatusEEnum, CustomerRoleStatus.class, "CustomerRoleStatus");
		addEEnumLiteral(customerRoleStatusEEnum, CustomerRoleStatus.ACTIVE);
		addEEnumLiteral(customerRoleStatusEEnum, CustomerRoleStatus.INACTIVE);
		addEEnumLiteral(customerRoleStatusEEnum, CustomerRoleStatus.VOID);

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
		initEDataType(noSuchElementExceptionEDataType, NoSuchElementException.class, "NoSuchElementException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dequeEDataType, Deque.class, "Deque", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(temperatureEDataType, Temperature.class, "Temperature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localTimeEDataType, LocalTime.class, "LocalTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eFactoryEDataType, EFactory.class, "EFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
			 "documentation", "AppManifest is actually a misnomer, it should\'ve been called TenantManifest instead, which is the primary (non-sysconfig) information about a tenant.\n\n<p>Attributes are optional because can use OverlayingSupplier.\n\n<p>Expandable attributes are: domain, generalEmail.\n\n<p>Expansion variables are: fqdn (host-dependent), appDomain (from properties), userName (from System property user.name), domain (can only be used by other attributes than domain itself)."
		   });		
		addAnnotation
		  (getAppManifest__GetDefaultLocale(), 
		   source, 
		   new String[] {
			 "documentation", "Returns the {@link java.util.Locale} referred by {@link @getDefaultLanguageTag()}."
		   });		
		addAnnotation
		  (getAppManifest_Summary(), 
		   source, 
		   new String[] {
			 "documentation", "Short description to be used in page title, usually 3-10 words."
		   });		
		addAnnotation
		  (getAppManifest_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Longer description to be used in meta description, recommended to be less than 160 characters."
		   });		
		addAnnotation
		  (getAppManifest_Domain(), 
		   source, 
		   new String[] {
			 "documentation", "Primary domain name of the application for current environment, e.g. \"berbatik.com\". Used by Email system. URI templatable using \"appDomain\", \"fqdn\", \"tenantId\", \"tenantEnv\".\n\n<p>TODO: make this read-only for future usage.\n\n<p>For development, use e.g. \"berbatik.annafi.dev\".\n\n<p>Production: title=Berbatik, domain=berbatik.com\n\n<p>Staging: title=Berbatik stg, domain=stg.berbatik.com\n\n<p>Development: title=Berbatik Annafi, domain=berbatik.annafi.dev\n\n<p>Description usually stays the same, but can be different too.\n\n<p>Templated using URI templates. e.g. to use {@code appDomain} variable, i.e. \"acme.{+appDomain}\",\nthat will be expanded when you call {@link #expand()}."
		   });		
		addAnnotation
		  (getAppManifest_DomainPrd(), 
		   source, 
		   new String[] {
			 "documentation", "Primary domain name of the application for \"prd\" environment, e.g. \"berbatik.com\". Used by Email system. URI templatable using \"appDomain\", \"fqdn\", \"tenantId\", \"tenantEnv\".\n\n<p>To get the real domain name, use {@link #getRealDomain(String)} instead.\n\n<p>For development, use e.g. \"berbatik.annafi.dev\".\n\n<p>Production: title=Berbatik, domain=berbatik.com\n\n<p>Staging: title=Berbatik stg, domain=stg.berbatik.com\n\n<p>Development: title=Berbatik Annafi, domain=berbatik.annafi.dev\n\n<p>Description usually stays the same, but can be different too.\n\n<p>Templated using URI templates. e.g. to use {@code appDomain} variable, i.e. \"acme.{+appDomain}\",\nthat will be expanded when you call {@link #expand()}."
		   });		
		addAnnotation
		  (getAppManifest_DomainDev(), 
		   source, 
		   new String[] {
			 "documentation", "Primary domain name of the application for \"dev\" environment.\nURI templatable using \"appDomain\", \"fqdn\", \"tenantId\", \"tenantEnv\"."
		   });		
		addAnnotation
		  (getAppManifest_DomainStg(), 
		   source, 
		   new String[] {
			 "documentation", "Primary domain name of the application for \"dev\" environment.\nURI templatable using \"appDomain\", \"fqdn\", \"tenantId\", \"tenantEnv\"."
		   });		
		addAnnotation
		  (getAppManifest_GeneralEmail(), 
		   source, 
		   new String[] {
			 "documentation", "Email address used for general inquiries, e.g. cantik@berbatik.com. This address is usually handled by a Customer Care application.\nThe default templated generalEmail is \"{+userName}@{+fqdn}\" so that in a development environment, a default postfix and dovecot installation will allow the developer to receive incoming emails and replies.\n\n<p>Templated using URI templates."
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
		  (getAppManifest_EmailLogoUriTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "URI to tenant logo usable when sending email notifications, by default the tenant logo URI template is: {+imagesUri}tenant_common/logo_email.png\n\n<p>Width of 127 pixels is recommended with landscape ratio.\n\n<p>Supported parameter is \"imagesUri\", which is from {link WebAddress#getImagesUri()}.\n\n<p>You can have app-wide logo without any tenant_common folder by using URI template such as: {+imagesUri}/com.aksimata.app/aksimata_email_192x92.png\n\n<p>To get the actual URI, call {@link AppUtils#getEmailLogoUri(AppManifest, WebAddress)}."
		   });		
		addAnnotation
		  (getAppManifest_DefaultLanguageTag(), 
		   source, 
		   new String[] {
			 "documentation", "IETF BCP 47 language tag string, e.g. {@code id-ID}. This is different than {@code defaultCountryCode}, because {@code defaultLanguageTag} is used to determine the {@link java.util.Locale}."
		   });		
		addAnnotation
		  (getAppManifest_DefaultCountryCode(), 
		   source, 
		   new String[] {
			 "documentation", "Default country code in ISO 3166-1 alpha-2. It is used for e.g. fill the country field in new PostalAddress form."
		   });		
		addAnnotation
		  (personInfoEClass, 
		   source, 
		   new String[] {
			 "documentation", "Person partial value object that is stored in Graph database (usually Neo4j) or embedded in a MongoDB document.\n\nThe ID is Directory entry uid attribute.\n"
		   });		
		addAnnotation
		  (genderEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Unknown gender (null value needs to be modeled explicitly in EMF Enum)."
		   });		
		addAnnotation
		  (genderEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Male person."
		   });		
		addAnnotation
		  (genderEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Female person."
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
		  (getImageable__GetImageId(), 
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
		  (getInformer__ToInfo(), 
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
		  (getJavaClassLinked__ResolveJavaClass__Bundle(), 
		   source, 
		   new String[] {
			 "documentation", "Resolve referenced Java Class."
		   });		
		addAnnotation
		  ((getJavaClassLinked__ResolveJavaClass__Bundle()).getEParameters().get(0), 
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
		  (getEClassLinked__ResolveEClass__Map(), 
		   source, 
		   new String[] {
			 "documentation", "Resolve referenced EClass."
		   });		
		addAnnotation
		  ((getEClassLinked__ResolveEClass__Map()).getEParameters().get(0), 
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
			 "documentation", "Tenant-wide website URI configuration. URI template variables: appId, tenantId, tenantEnv, appDomain, domain, fqdn."
		   });		
		addAnnotation
		  (getWebAddress__GetApiUri(), 
		   source, 
		   new String[] {
			 "documentation", "API URI is useful if you want to access API resources (e.g. MediaResource) from external apps, email, etc. or where you have taken care of the cross-origin request issues.\n\nAlways returns baseUri + apiPath, removing double slash."
		   });		
		addAnnotation
		  (getWebAddress__GetSecureApiUri(), 
		   source, 
		   new String[] {
			 "documentation", "API URI is useful if you want to access API resources (e.g. MediaResource) from external apps, email, etc. or where you have taken care of the cross-origin request issues.\n\nAlways returns secureBaseUri + apiPath, removing double slash."
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
		  (getProgressMonitor__BeginTask__String_long(), 
		   source, 
		   new String[] {
			 "documentation", "\t * Notifies that the main task is beginning.  This must only be called once\n\t * on a given progress monitor instance.\n\t * \n\t * @param name the name (or description) of the main task\n\t * @param totalWork the total number of work units into which\n\t *  the main task is been subdivided. If the value is <code>UNKNOWN</code> \n\t *  the implementation is free to indicate progress in a way which \n\t *  doesn\'t require the total number of work units in advance.\n\nTODO: support formatting in the task name, probably using HTML5 or RDFa, which will be converted (in shell) into ANSI codes."
		   });		
		addAnnotation
		  (getProgressMonitor__Done(), 
		   source, 
		   new String[] {
			 "documentation", "\t * Notifies that the work is done; that is, either the main task is completed \n\t * or the user canceled it. This method may be called more than once \n\t * (implementations should be prepared to handle this case).\n"
		   });		
		addAnnotation
		  (getProgressMonitor__InternalWorked__double(), 
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
			 "documentation", "Member belum aktif. Pertama kali user registrasi mandiri (belum validasi email), status adalah draft.\nSetelah user melakukan validasi email, status berubah menjadi:\n1. Bila membership dimoderasi, menjadi \'validated\' terlebih dahulu. Admin harus meng-approve member tersebut agar menjadi active.\n2. Bila membership bebas, maka status \'draft\' langsung menjadi \'active\' (tanpa approval admin)."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Email sudah divalidasi tapi belum aktif (bila membership dimoderasi).\n"
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Akun aktif dan dapat digunakan. Diasumsikan email sudah valid. Bila membership dimoderasi, maka sudah ada admin yang meng-approve membership ini."
		   });		
		addAnnotation
		  (accountStatusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Akun aktif dan dapat digunakan, dan sudah diverifikasi secara lebih pasti bahwa pemilik akun ini dikenali oleh pengelola website (membership premium/aktivis/donator)."
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
		  (getTranslationManager__Translate__Translatable_String(), 
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
		  (getStyleConfiguration__GetDefaultStyle(), 
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
		  (getExpandable__Expand__Map(), 
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
		  (getPerson__HasEmail__String(), 
		   source, 
		   new String[] {
			 "documentation", "Checks if the email is already in its list."
		   });		
		addAnnotation
		  (getPerson__PutEmail__String(), 
		   source, 
		   new String[] {
			 "documentation", "Puts the (normalized) email, and sets it as primary if the only one. Has no effect if already exists. Returns the added Email contained object."
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
		  (getPerson_ClientAccessToken(), 
		   source, 
		   new String[] {
			 "documentation", "OAuth 2.0 access token usable by official client applications (Android, iOS, etc.).\nThis is for simple usage, with no expiration (though regenerating the client access token is possible if the access token is compromised). For more complex usage like third party applications, use another mechanism.\n\nThe \'client_id\' and \'callback_url\' (or \'callback_domains\') should be specified elsewhere (probably on AppManifest?)\n\nSee: https://developer.foursquare.com/overview/auth.html"
		   });		
		addAnnotation
		  (getPerson_VerifyCode(), 
		   source, 
		   new String[] {
			 "documentation", "Verify Code is used to link to VerifyNewMemberPage"
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
		  (getEmail_Email(), 
		   source, 
		   new String[] {
			 "documentation", "Must be normalized: lowercased, trimmed, and must not be null."
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
			 "documentation", "Country code using <a href=\"http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2\">ISO 3166-1 alpha-2</a>.\n\nLDAP: c, countryName"
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
		addAnnotation
		  (twitterAccessibleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Supports Twitter Access Token and Access Token Secret, and therefore able to tweet, mention, or retweet."
		   });		
		addAnnotation
		  (twitterIdentityEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains Twitter identity, which can be Twitter ID, screen name, or both."
		   });		
		addAnnotation
		  (facebookIdentityEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains Facebook identity, which can be Facebook ID, username, or both."
		   });		
		addAnnotation
		  (facebookAccessibleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains Facebook access token (which can expire anytime)."
		   });		
		addAnnotation
		  (revisionableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains a globally unique identifier (GUID) and revision."
		   });		
		addAnnotation
		  (getRevisionable_Guid(), 
		   source, 
		   new String[] {
			 "documentation", "Globally unique identifier (GUID). Usually it\'s the same as OID (object identifier), for better space usage. However there are times where it is app-generated\n(i.e. by a PouchDB app).\n\nFor CouchDB this maps to \"_id\" field."
		   });		
		addAnnotation
		  (getRevisionable_Revision(), 
		   source, 
		   new String[] {
			 "documentation", "The CouchDB document revision (\"_rev\")."
		   });		
		addAnnotation
		  (tenantSourceEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Loads tenants from config folder, which is either META-INF or a $HOME-relative config folder.\nThis is practical for development or for production of single or few static tenants."
		   });		
		addAnnotation
		  (tenantSourceEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Loads tenants from repository, which is preferred for production environment with dynamic tenants."
		   });		
		addAnnotation
		  (sysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base EMF Interface of system configuration for a tenant."
		   });		
		addAnnotation
		  (getSysConfig_TenantId(), 
		   source, 
		   new String[] {
			 "documentation", "Tenant ID (without tenantEnv) which this sysconfig applies to."
		   });		
		addAnnotation
		  (genericStatusEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Generic status for general-purpose usage."
		   });		
		addAnnotation
		  (genericStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Entity is active and usable."
		   });		
		addAnnotation
		  (genericStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Entity has not yet been formally created."
		   });		
		addAnnotation
		  (genericStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Entity is editable but not active for operational purposes."
		   });		
		addAnnotation
		  (genericStatusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Entity is trashed or banned."
		   });		
		addAnnotation
		  (geolocationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Why Double?\n\nHibernate Search has this as best practice:\n\"add the @Latitude and @Longitude annotations on your properties representing the coordinates; these must be of type Double\"\nhttp://docs.jboss.org/hibernate/search/4.2/reference/en-US/html/spatial.html"
		   });		
		addAnnotation
		  (thingInfoEClass, 
		   source, 
		   new String[] {
			 "documentation", "A condensed version of a (probably app-specific) Thing."
		   });
	}
	
	public static CommonsPackage getInstance() {
		return eINSTANCE;
	}

} //CommonsPackageImpl
