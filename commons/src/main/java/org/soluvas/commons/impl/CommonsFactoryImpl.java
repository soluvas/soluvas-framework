/**
 */
package org.soluvas.commons.impl;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

import javax.measure.Measurable;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.joda.money.BigMoneyProvider;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.*;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Added;
import org.soluvas.commons.AddedMany;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.ArchivalStatus;
import org.soluvas.commons.AttributeNotification;
import org.soluvas.commons.AttributeSet;
import org.soluvas.commons.AttributeUnset;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.EClassStatus;
import org.soluvas.commons.Email;
import org.soluvas.commons.EventBusProgressMonitor;
import org.soluvas.commons.ExpansionState;
import org.soluvas.commons.Gender;
import org.soluvas.commons.JavaClassStatus;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonCatalog;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PhoneNumber;
import org.soluvas.commons.PostalAddress;
import org.soluvas.commons.ProgressMonitorWrapper;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.PublicationStatus;
import org.soluvas.commons.Removed;
import org.soluvas.commons.RemovedMany;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.SignupSourceType;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationManager;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.WebAddress;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonsFactoryImpl extends EFactoryImpl implements CommonsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonsFactory init() {
		try {
			CommonsFactory theCommonsFactory = (CommonsFactory)EPackage.Registry.INSTANCE.getEFactory(CommonsPackage.eNS_URI);
			if (theCommonsFactory != null) {
				return theCommonsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CommonsPackage.APP_MANIFEST: return createAppManifest();
			case CommonsPackage.PERSON_INFO: return createPersonInfo();
			case CommonsPackage.WEB_ADDRESS: return createWebAddress();
			case CommonsPackage.ADDED: return createAdded();
			case CommonsPackage.ATTRIBUTE_SET: return createAttributeSet();
			case CommonsPackage.ATTRIBUTE_UNSET: return createAttributeUnset();
			case CommonsPackage.REMOVED: return createRemoved();
			case CommonsPackage.ATTRIBUTE_NOTIFICATION: return createAttributeNotification();
			case CommonsPackage.ADDED_MANY: return createAddedMany();
			case CommonsPackage.REMOVED_MANY: return createRemovedMany();
			case CommonsPackage.CATEGORY_INFO: return createCategoryInfo();
			case CommonsPackage.SHELL_PROGRESS_MONITOR: return createShellProgressMonitor();
			case CommonsPackage.EVENT_BUS_PROGRESS_MONITOR: return createEventBusProgressMonitor();
			case CommonsPackage.PROGRESS_MONITOR_WRAPPER: return createProgressMonitorWrapper();
			case CommonsPackage.TRANSLATION: return createTranslation();
			case CommonsPackage.TRANSLATION_MESSAGE_ENTRY: return (EObject)createTranslationMessageEntry();
			case CommonsPackage.TRANSLATION_MANAGER: return createTranslationManager();
			case CommonsPackage.TRANSLATION_ENTRY: return (EObject)createTranslationEntry();
			case CommonsPackage.PERSON: return createPerson();
			case CommonsPackage.PHONE_NUMBER: return createPhoneNumber();
			case CommonsPackage.EMAIL: return createEmail();
			case CommonsPackage.POSTAL_ADDRESS: return createPostalAddress();
			case CommonsPackage.PERSON_CATALOG: return createPersonCatalog();
			case CommonsPackage.FACEBOOK_IDENTITY: return createFacebookIdentity();
			case CommonsPackage.FACEBOOK_ACCESSIBLE: return createFacebookAccessible();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CommonsPackage.RESOURCE_TYPE:
				return createResourceTypeFromString(eDataType, initialValue);
			case CommonsPackage.GENDER:
				return createGenderFromString(eDataType, initialValue);
			case CommonsPackage.ECLASS_STATUS:
				return createEClassStatusFromString(eDataType, initialValue);
			case CommonsPackage.JAVA_CLASS_STATUS:
				return createJavaClassStatusFromString(eDataType, initialValue);
			case CommonsPackage.PROGRESS_STATUS:
				return createProgressStatusFromString(eDataType, initialValue);
			case CommonsPackage.ACCOUNT_STATUS:
				return createAccountStatusFromString(eDataType, initialValue);
			case CommonsPackage.PUBLICATION_STATUS:
				return createPublicationStatusFromString(eDataType, initialValue);
			case CommonsPackage.ARCHIVAL_STATUS:
				return createArchivalStatusFromString(eDataType, initialValue);
			case CommonsPackage.TRANSLATION_STATE:
				return createTranslationStateFromString(eDataType, initialValue);
			case CommonsPackage.EXPANSION_STATE:
				return createExpansionStateFromString(eDataType, initialValue);
			case CommonsPackage.SIGNUP_SOURCE_TYPE:
				return createSignupSourceTypeFromString(eDataType, initialValue);
			case CommonsPackage.DATE_TIME:
				return createDateTimeFromString(eDataType, initialValue);
			case CommonsPackage.CURRENCY_UNIT:
				return createCurrencyUnitFromString(eDataType, initialValue);
			case CommonsPackage.QUANTITY:
				return createQuantityFromString(eDataType, initialValue);
			case CommonsPackage.UNIT:
				return createUnitFromString(eDataType, initialValue);
			case CommonsPackage.LIST:
				return createListFromString(eDataType, initialValue);
			case CommonsPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			case CommonsPackage.SET:
				return createSetFromString(eDataType, initialValue);
			case CommonsPackage.COLLECTION:
				return createCollectionFromString(eDataType, initialValue);
			case CommonsPackage.MULTIMAP:
				return createMultimapFromString(eDataType, initialValue);
			case CommonsPackage.NAVIGABLE_MAP:
				return createNavigableMapFromString(eDataType, initialValue);
			case CommonsPackage.QUEUE:
				return createQueueFromString(eDataType, initialValue);
			case CommonsPackage.MULTISET:
				return createMultisetFromString(eDataType, initialValue);
			case CommonsPackage.SERIALIZABLE:
				return createSerializableFromString(eDataType, initialValue);
			case CommonsPackage.BIG_MONEY_PROVIDER:
				return createBigMoneyProviderFromString(eDataType, initialValue);
			case CommonsPackage.MEASURABLE:
				return createMeasurableFromString(eDataType, initialValue);
			case CommonsPackage.DATE_TIME_ZONE:
				return createDateTimeZoneFromString(eDataType, initialValue);
			case CommonsPackage.LOCALE:
				return createLocaleFromString(eDataType, initialValue);
			case CommonsPackage.FILE:
				return createFileFromString(eDataType, initialValue);
			case CommonsPackage.LOCAL_DATE:
				return createLocalDateFromString(eDataType, initialValue);
			case CommonsPackage.NO_SUCH_ELEMENT_EXCEPTION:
				return createNoSuchElementExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CommonsPackage.RESOURCE_TYPE:
				return convertResourceTypeToString(eDataType, instanceValue);
			case CommonsPackage.GENDER:
				return convertGenderToString(eDataType, instanceValue);
			case CommonsPackage.ECLASS_STATUS:
				return convertEClassStatusToString(eDataType, instanceValue);
			case CommonsPackage.JAVA_CLASS_STATUS:
				return convertJavaClassStatusToString(eDataType, instanceValue);
			case CommonsPackage.PROGRESS_STATUS:
				return convertProgressStatusToString(eDataType, instanceValue);
			case CommonsPackage.ACCOUNT_STATUS:
				return convertAccountStatusToString(eDataType, instanceValue);
			case CommonsPackage.PUBLICATION_STATUS:
				return convertPublicationStatusToString(eDataType, instanceValue);
			case CommonsPackage.ARCHIVAL_STATUS:
				return convertArchivalStatusToString(eDataType, instanceValue);
			case CommonsPackage.TRANSLATION_STATE:
				return convertTranslationStateToString(eDataType, instanceValue);
			case CommonsPackage.EXPANSION_STATE:
				return convertExpansionStateToString(eDataType, instanceValue);
			case CommonsPackage.SIGNUP_SOURCE_TYPE:
				return convertSignupSourceTypeToString(eDataType, instanceValue);
			case CommonsPackage.DATE_TIME:
				return convertDateTimeToString(eDataType, instanceValue);
			case CommonsPackage.CURRENCY_UNIT:
				return convertCurrencyUnitToString(eDataType, instanceValue);
			case CommonsPackage.QUANTITY:
				return convertQuantityToString(eDataType, instanceValue);
			case CommonsPackage.UNIT:
				return convertUnitToString(eDataType, instanceValue);
			case CommonsPackage.LIST:
				return convertListToString(eDataType, instanceValue);
			case CommonsPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			case CommonsPackage.SET:
				return convertSetToString(eDataType, instanceValue);
			case CommonsPackage.COLLECTION:
				return convertCollectionToString(eDataType, instanceValue);
			case CommonsPackage.MULTIMAP:
				return convertMultimapToString(eDataType, instanceValue);
			case CommonsPackage.NAVIGABLE_MAP:
				return convertNavigableMapToString(eDataType, instanceValue);
			case CommonsPackage.QUEUE:
				return convertQueueToString(eDataType, instanceValue);
			case CommonsPackage.MULTISET:
				return convertMultisetToString(eDataType, instanceValue);
			case CommonsPackage.SERIALIZABLE:
				return convertSerializableToString(eDataType, instanceValue);
			case CommonsPackage.BIG_MONEY_PROVIDER:
				return convertBigMoneyProviderToString(eDataType, instanceValue);
			case CommonsPackage.MEASURABLE:
				return convertMeasurableToString(eDataType, instanceValue);
			case CommonsPackage.DATE_TIME_ZONE:
				return convertDateTimeZoneToString(eDataType, instanceValue);
			case CommonsPackage.LOCALE:
				return convertLocaleToString(eDataType, instanceValue);
			case CommonsPackage.FILE:
				return convertFileToString(eDataType, instanceValue);
			case CommonsPackage.LOCAL_DATE:
				return convertLocalDateToString(eDataType, instanceValue);
			case CommonsPackage.NO_SUCH_ELEMENT_EXCEPTION:
				return convertNoSuchElementExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppManifest createAppManifest() {
		AppManifestImpl appManifest = new AppManifestImpl();
		return appManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonInfo createPersonInfo() {
		PersonInfoImpl personInfo = new PersonInfoImpl();
		return personInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WebAddress createWebAddress() {
		WebAddressImpl webAddress = new WebAddressImpl();
		return webAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject> Added<T> createAdded() {
		AddedImpl<T> added = new AddedImpl<T>();
		return added;
	}

	public <T extends EObject> Added<T> createAdded(T object) {
		AddedImpl<T> added = new AddedImpl<T>();
		added.setObject(object);
		return added;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject, V> AttributeSet<T, V> createAttributeSet() {
		AttributeSetImpl<T, V> attributeSet = new AttributeSetImpl<T, V>();
		return attributeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject, V> AttributeUnset<T, V> createAttributeUnset() {
		AttributeUnsetImpl<T, V> attributeUnset = new AttributeUnsetImpl<T, V>();
		return attributeUnset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject> Removed<T> createRemoved() {
		RemovedImpl<T> removed = new RemovedImpl<T>();
		return removed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject, V> AttributeNotification<T, V> createAttributeNotification() {
		AttributeNotificationImpl<T, V> attributeNotification = new AttributeNotificationImpl<T, V>();
		return attributeNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject> AddedMany<T> createAddedMany() {
		AddedManyImpl<T> addedMany = new AddedManyImpl<T>();
		return addedMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends EObject> RemovedMany<T> createRemovedMany() {
		RemovedManyImpl<T> removedMany = new RemovedManyImpl<T>();
		return removedMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CategoryInfo createCategoryInfo() {
		CategoryInfoImpl categoryInfo = new CategoryInfoImpl();
		return categoryInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShellProgressMonitor createShellProgressMonitor() {
		ShellProgressMonitorImpl shellProgressMonitor = new ShellProgressMonitorImpl();
		return shellProgressMonitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventBusProgressMonitor createEventBusProgressMonitor() {
		EventBusProgressMonitorImpl eventBusProgressMonitor = new EventBusProgressMonitorImpl();
		return eventBusProgressMonitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProgressMonitorWrapper createProgressMonitorWrapper() {
		ProgressMonitorWrapperImpl progressMonitorWrapper = new ProgressMonitorWrapperImpl();
		return progressMonitorWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Translation createTranslation() {
		TranslationImpl translation = new TranslationImpl();
		return translation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createTranslationMessageEntry() {
		TranslationMessageEntryImpl translationMessageEntry = new TranslationMessageEntryImpl();
		return translationMessageEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TranslationManager createTranslationManager() {
		TranslationManagerImpl translationManager = new TranslationManagerImpl();
		return translationManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Translation> createTranslationEntry() {
		TranslationEntryImpl translationEntry = new TranslationEntryImpl();
		return translationEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PhoneNumber createPhoneNumber() {
		PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
		return phoneNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Email createEmail() {
		EmailImpl email = new EmailImpl();
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostalAddress createPostalAddress() {
		PostalAddressImpl postalAddress = new PostalAddressImpl();
		return postalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonCatalog createPersonCatalog() {
		PersonCatalogImpl personCatalog = new PersonCatalogImpl();
		return personCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacebookIdentity createFacebookIdentity() {
		FacebookIdentityImpl facebookIdentity = new FacebookIdentityImpl();
		return facebookIdentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacebookAccessible createFacebookAccessible() {
		FacebookAccessibleImpl facebookAccessible = new FacebookAccessibleImpl();
		return facebookAccessible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceTypeFromString(EDataType eDataType, String initialValue) {
		ResourceType result = ResourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender createGenderFromString(EDataType eDataType, String initialValue) {
		Gender result = Gender.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassStatus createEClassStatusFromString(EDataType eDataType, String initialValue) {
		EClassStatus result = EClassStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEClassStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassStatus createJavaClassStatusFromString(EDataType eDataType, String initialValue) {
		JavaClassStatus result = JavaClassStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaClassStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressStatus createProgressStatusFromString(EDataType eDataType, String initialValue) {
		ProgressStatus result = ProgressStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgressStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccountStatus createAccountStatusFromString(EDataType eDataType, String initialValue) {
		AccountStatus result = AccountStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccountStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationStatus createPublicationStatusFromString(EDataType eDataType, String initialValue) {
		PublicationStatus result = PublicationStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPublicationStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchivalStatus createArchivalStatusFromString(EDataType eDataType, String initialValue) {
		ArchivalStatus result = ArchivalStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchivalStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationState createTranslationStateFromString(EDataType eDataType, String initialValue) {
		TranslationState result = TranslationState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTranslationStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionState createExpansionStateFromString(EDataType eDataType, String initialValue) {
		ExpansionState result = ExpansionState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpansionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignupSourceType createSignupSourceTypeFromString(EDataType eDataType, String initialValue) {
		SignupSourceType result = SignupSourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSignupSourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DateTime createDateTimeFromString(EDataType eDataType, String initialValue) {
		return initialValue != null ? new DateTime(initialValue) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateTimeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public CurrencyUnit createCurrencyUnitFromString(EDataType eDataType, String initialValue) {
		return CurrencyUnit.of(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCurrencyUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Unit<?> createUnitFromString(EDataType eDataType, String initialValue) {
		if (initialValue != null) {
			return "".equals(initialValue) ? Unit.ONE : (Unit<?>)Unit.valueOf(initialValue); 
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String convertUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue != null ? instanceValue.toString() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<?> createListFromString(EDataType eDataType, String initialValue) {
		return (List<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set<?> createSetFromString(EDataType eDataType, String initialValue) {
		return (Set<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> createCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multimap<?, ?> createMultimapFromString(EDataType eDataType, String initialValue) {
		return (Multimap<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultimapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigableMap<?, ?> createNavigableMapFromString(EDataType eDataType, String initialValue) {
		return (NavigableMap<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNavigableMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Queue<?> createQueueFromString(EDataType eDataType, String initialValue) {
		return (Queue<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiset<?> createMultisetFromString(EDataType eDataType, String initialValue) {
		return (Multiset<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultisetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Serializable createSerializableFromString(EDataType eDataType, String initialValue) {
		return (Serializable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSerializableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigMoneyProvider createBigMoneyProviderFromString(EDataType eDataType, String initialValue) {
		return (BigMoneyProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBigMoneyProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantity createQuantityFromString(EDataType eDataType, String initialValue) {
		return (Quantity)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQuantityToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measurable<?> createMeasurableFromString(EDataType eDataType, String initialValue) {
		return (Measurable<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasurableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public BigDecimal createBigDecimalFromString(EDataType eDataType, String initialValue) {
		return initialValue != null ? new BigDecimal(initialValue) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String convertBigDecimalToString(EDataType eDataType, Object instanceValue) {
		return instanceValue != null ? instanceValue.toString() : null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DateTimeZone createDateTimeZoneFromString(EDataType eDataType, String initialValue) {
		return DateTimeZone.forID(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateTimeZoneToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locale createLocaleFromString(EDataType eDataType, String initialValue) {
		return (Locale)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocaleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFileFromString(EDataType eDataType, String initialValue) {
		return (File)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public LocalDate createLocalDateFromString(EDataType eDataType, String initialValue) {
		return initialValue != null ? new LocalDate(initialValue) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocalDateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoSuchElementException createNoSuchElementExceptionFromString(EDataType eDataType, String initialValue) {
		return (NoSuchElementException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNoSuchElementExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommonsPackage getCommonsPackage() {
		return (CommonsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonsPackage getPackage() {
		return CommonsPackage.eINSTANCE;
	}

	@Override
	public PersonInfo createPersonInfo(String id, String slug, String name,
			String photoId, Gender gender) {
		final PersonInfo person = createPersonInfo();
		person.setId(id);
		person.setSlug(slug);
		person.setName(name);
		person.setPhotoId(photoId);
		person.setGender(gender);
		return person;
	}

} //CommonsFactoryImpl
