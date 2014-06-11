/**
 */
package org.soluvas.commons.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Person;

/**
 * This is the item provider adapter for a {@link org.soluvas.commons.Person} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PersonItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addPhotoIdPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addCreationTimePropertyDescriptor(object);
			addModificationTimePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addSlugPropertyDescriptor(object);
			addCanonicalSlugPropertyDescriptor(object);
			addTwitterAccessTokenPropertyDescriptor(object);
			addTwitterAccessTokenSecretPropertyDescriptor(object);
			addTwitterIdPropertyDescriptor(object);
			addTwitterScreenNamePropertyDescriptor(object);
			addFacebookIdPropertyDescriptor(object);
			addFacebookUsernamePropertyDescriptor(object);
			addFacebookAccessTokenPropertyDescriptor(object);
			addGuidPropertyDescriptor(object);
			addRevisionPropertyDescriptor(object);
			addSchemaVersionPropertyDescriptor(object);
			addFirstNamePropertyDescriptor(object);
			addLastNamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addAccountStatusPropertyDescriptor(object);
			addBirthYearPropertyDescriptor(object);
			addBirthMonthPropertyDescriptor(object);
			addBirthDayPropertyDescriptor(object);
			addBirthDatePropertyDescriptor(object);
			addGenderPropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addCurrencyCodePropertyDescriptor(object);
			addCurrencyPropertyDescriptor(object);
			addGooglePlusIdPropertyDescriptor(object);
			addGoogleUsernamePropertyDescriptor(object);
			addVirtualMailPropertyDescriptor(object);
			addNicknamePropertyDescriptor(object);
			addCustomerRolePropertyDescriptor(object);
			addMemberRolePropertyDescriptor(object);
			addManagerRolePropertyDescriptor(object);
			addTimeZoneIdPropertyDescriptor(object);
			addTimeZonePropertyDescriptor(object);
			addReferrerIdPropertyDescriptor(object);
			addReferrerTypePropertyDescriptor(object);
			addSignupSourcePropertyDescriptor(object);
			addSignupSourceTypePropertyDescriptor(object);
			addIpAddressPropertyDescriptor(object);
			addLastIpAddressPropertyDescriptor(object);
			addLastLoginTimePropertyDescriptor(object);
			addValidationTimePropertyDescriptor(object);
			addActivationTimePropertyDescriptor(object);
			addVerificationTimePropertyDescriptor(object);
			addNewsletterSubscriptionEnabledPropertyDescriptor(object);
			addNewsletterSubscriptionTimePropertyDescriptor(object);
			addSocialSharingEnabledPropertyDescriptor(object);
			addPublicationStatusPropertyDescriptor(object);
			addArchivalStatusPropertyDescriptor(object);
			addFolderPropertyDescriptor(object);
			addReligionPropertyDescriptor(object);
			addPasswordResetCodePropertyDescriptor(object);
			addPasswordResetExpiryTimePropertyDescriptor(object);
			addClientAccessTokenPropertyDescriptor(object);
			addSecurityRoleIdsPropertyDescriptor(object);
			addDebitBalancePropertyDescriptor(object);
			addDebitCurrencyPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addVerifyCodePropertyDescriptor(object);
			addOrganizationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NameContainer_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NameContainer_name_feature", "_UI_NameContainer_type"),
				 CommonsPackage.Literals.NAME_CONTAINER__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Photo Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhotoIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PhotoIdContainer_photoId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PhotoIdContainer_photoId_feature", "_UI_PhotoIdContainer_type"),
				 CommonsPackage.Literals.PHOTO_ID_CONTAINER__PHOTO_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Identifiable_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Identifiable_id_feature", "_UI_Identifiable_type"),
				 CommonsPackage.Literals.IDENTIFIABLE__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Timestamped_creationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Timestamped_creationTime_feature", "_UI_Timestamped_type"),
				 CommonsPackage.Literals.TIMESTAMPED__CREATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modification Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModificationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Timestamped_modificationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Timestamped_modificationTime_feature", "_UI_Timestamped_type"),
				 CommonsPackage.Literals.TIMESTAMPED__MODIFICATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Describable_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Describable_description_feature", "_UI_Describable_type"),
				 CommonsPackage.Literals.DESCRIBABLE__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Slug feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSlugPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Sluggable_slug_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Sluggable_slug_feature", "_UI_Sluggable_type"),
				 CommonsPackage.Literals.SLUGGABLE__SLUG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Canonical Slug feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCanonicalSlugPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CanonicalSluggable_canonicalSlug_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CanonicalSluggable_canonicalSlug_feature", "_UI_CanonicalSluggable_type"),
				 CommonsPackage.Literals.CANONICAL_SLUGGABLE__CANONICAL_SLUG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Twitter Access Token feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTwitterAccessTokenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TwitterAccessible_twitterAccessToken_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TwitterAccessible_twitterAccessToken_feature", "_UI_TwitterAccessible_type"),
				 CommonsPackage.Literals.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Twitter Access Token Secret feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTwitterAccessTokenSecretPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TwitterAccessible_twitterAccessTokenSecret_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TwitterAccessible_twitterAccessTokenSecret_feature", "_UI_TwitterAccessible_type"),
				 CommonsPackage.Literals.TWITTER_ACCESSIBLE__TWITTER_ACCESS_TOKEN_SECRET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Twitter Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTwitterIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TwitterIdentity_twitterId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TwitterIdentity_twitterId_feature", "_UI_TwitterIdentity_type"),
				 CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Twitter Screen Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTwitterScreenNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TwitterIdentity_twitterScreenName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TwitterIdentity_twitterScreenName_feature", "_UI_TwitterIdentity_type"),
				 CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_SCREEN_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facebook Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacebookIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacebookIdentity_facebookId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacebookIdentity_facebookId_feature", "_UI_FacebookIdentity_type"),
				 CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facebook Username feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacebookUsernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacebookIdentity_facebookUsername_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacebookIdentity_facebookUsername_feature", "_UI_FacebookIdentity_type"),
				 CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_USERNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Facebook Access Token feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFacebookAccessTokenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FacebookAccessible_facebookAccessToken_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FacebookAccessible_facebookAccessToken_feature", "_UI_FacebookAccessible_type"),
				 CommonsPackage.Literals.FACEBOOK_ACCESSIBLE__FACEBOOK_ACCESS_TOKEN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Guid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGuidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Revisionable_guid_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Revisionable_guid_feature", "_UI_Revisionable_type"),
				 CommonsPackage.Literals.REVISIONABLE__GUID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Revision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRevisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Revisionable_revision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Revisionable_revision_feature", "_UI_Revisionable_type"),
				 CommonsPackage.Literals.REVISIONABLE__REVISION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Schema Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSchemaVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_schemaVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_schemaVersion_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__SCHEMA_VERSION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the First Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFirstNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_firstName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_firstName_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__FIRST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_lastName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_lastName_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__LAST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_password_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_password_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Account Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccountStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_accountStatus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_accountStatus_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__ACCOUNT_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Birth Year feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBirthYearPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_birthYear_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_birthYear_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__BIRTH_YEAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Birth Month feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBirthMonthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_birthMonth_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_birthMonth_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__BIRTH_MONTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Birth Day feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBirthDayPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_birthDay_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_birthDay_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__BIRTH_DAY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Birth Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBirthDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_birthDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_birthDate_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__BIRTH_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gender feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGenderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_gender_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_gender_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__GENDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_language_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_language_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Currency Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrencyCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_currencyCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_currencyCode_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__CURRENCY_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Currency feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrencyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_currency_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_currency_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__CURRENCY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Google Plus Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGooglePlusIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_googlePlusId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_googlePlusId_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__GOOGLE_PLUS_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Google Username feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGoogleUsernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_googleUsername_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_googleUsername_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__GOOGLE_USERNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Virtual Mail feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVirtualMailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_virtualMail_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_virtualMail_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__VIRTUAL_MAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Nickname feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNicknamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_nickname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_nickname_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__NICKNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Customer Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCustomerRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_customerRole_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_customerRole_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__CUSTOMER_ROLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Member Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemberRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_memberRole_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_memberRole_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__MEMBER_ROLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manager Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManagerRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_managerRole_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_managerRole_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__MANAGER_ROLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Zone Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeZoneIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_timeZoneId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_timeZoneId_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__TIME_ZONE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Zone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeZonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_timeZone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_timeZone_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__TIME_ZONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referrer Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferrerIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_referrerId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_referrerId_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__REFERRER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referrer Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferrerTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_referrerType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_referrerType_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__REFERRER_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Signup Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSignupSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_signupSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_signupSource_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__SIGNUP_SOURCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Signup Source Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSignupSourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_signupSourceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_signupSourceType_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__SIGNUP_SOURCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ip Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIpAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_ipAddress_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_ipAddress_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__IP_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Ip Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastIpAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_lastIpAddress_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_lastIpAddress_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__LAST_IP_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Login Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastLoginTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_lastLoginTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_lastLoginTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__LAST_LOGIN_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validation Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_validationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_validationTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__VALIDATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Activation Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_activationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_activationTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__ACTIVATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Verification Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerificationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_verificationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_verificationTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__VERIFICATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Newsletter Subscription Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNewsletterSubscriptionEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_newsletterSubscriptionEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_newsletterSubscriptionEnabled_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Newsletter Subscription Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNewsletterSubscriptionTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_newsletterSubscriptionTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_newsletterSubscriptionTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__NEWSLETTER_SUBSCRIPTION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Social Sharing Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSocialSharingEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_socialSharingEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_socialSharingEnabled_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__SOCIAL_SHARING_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publication Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublicationStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_publicationStatus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_publicationStatus_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__PUBLICATION_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Archival Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArchivalStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_archivalStatus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_archivalStatus_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__ARCHIVAL_STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Folder feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFolderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_folder_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_folder_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__FOLDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Religion feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReligionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_religion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_religion_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__RELIGION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password Reset Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordResetCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_passwordResetCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_passwordResetCode_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__PASSWORD_RESET_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password Reset Expiry Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordResetExpiryTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_passwordResetExpiryTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_passwordResetExpiryTime_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__PASSWORD_RESET_EXPIRY_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client Access Token feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientAccessTokenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_clientAccessToken_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_clientAccessToken_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__CLIENT_ACCESS_TOKEN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Security Role Ids feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecurityRoleIdsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_securityRoleIds_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_securityRoleIds_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__SECURITY_ROLE_IDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Debit Balance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDebitBalancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_debitBalance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_debitBalance_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__DEBIT_BALANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Debit Currency feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDebitCurrencyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_debitCurrency_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_debitCurrency_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__DEBIT_CURRENCY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_type_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__TYPE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Verify Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerifyCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_verifyCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_verifyCode_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__VERIFY_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organizations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Person_organizations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Person_organizations_feature", "_UI_Person_type"),
				 CommonsPackage.Literals.PERSON__ORGANIZATIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CommonsPackage.Literals.PERSON__PHONE_NUMBERS);
			childrenFeatures.add(CommonsPackage.Literals.PERSON__EMAILS);
			childrenFeatures.add(CommonsPackage.Literals.PERSON__MOBILE_NUMBERS);
			childrenFeatures.add(CommonsPackage.Literals.PERSON__ADDRESSES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Person.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Person"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Person)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Person_type") :
			getString("_UI_Person_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Person.class)) {
			case CommonsPackage.PERSON__NAME:
			case CommonsPackage.PERSON__PHOTO_ID:
			case CommonsPackage.PERSON__ID:
			case CommonsPackage.PERSON__CREATION_TIME:
			case CommonsPackage.PERSON__MODIFICATION_TIME:
			case CommonsPackage.PERSON__DESCRIPTION:
			case CommonsPackage.PERSON__SLUG:
			case CommonsPackage.PERSON__CANONICAL_SLUG:
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN:
			case CommonsPackage.PERSON__TWITTER_ACCESS_TOKEN_SECRET:
			case CommonsPackage.PERSON__TWITTER_ID:
			case CommonsPackage.PERSON__TWITTER_SCREEN_NAME:
			case CommonsPackage.PERSON__FACEBOOK_ID:
			case CommonsPackage.PERSON__FACEBOOK_USERNAME:
			case CommonsPackage.PERSON__FACEBOOK_ACCESS_TOKEN:
			case CommonsPackage.PERSON__GUID:
			case CommonsPackage.PERSON__REVISION:
			case CommonsPackage.PERSON__SCHEMA_VERSION:
			case CommonsPackage.PERSON__FIRST_NAME:
			case CommonsPackage.PERSON__LAST_NAME:
			case CommonsPackage.PERSON__PASSWORD:
			case CommonsPackage.PERSON__ACCOUNT_STATUS:
			case CommonsPackage.PERSON__BIRTH_YEAR:
			case CommonsPackage.PERSON__BIRTH_MONTH:
			case CommonsPackage.PERSON__BIRTH_DAY:
			case CommonsPackage.PERSON__BIRTH_DATE:
			case CommonsPackage.PERSON__GENDER:
			case CommonsPackage.PERSON__LANGUAGE:
			case CommonsPackage.PERSON__CURRENCY_CODE:
			case CommonsPackage.PERSON__CURRENCY:
			case CommonsPackage.PERSON__GOOGLE_PLUS_ID:
			case CommonsPackage.PERSON__GOOGLE_USERNAME:
			case CommonsPackage.PERSON__VIRTUAL_MAIL:
			case CommonsPackage.PERSON__NICKNAME:
			case CommonsPackage.PERSON__CUSTOMER_ROLE:
			case CommonsPackage.PERSON__MEMBER_ROLE:
			case CommonsPackage.PERSON__MANAGER_ROLE:
			case CommonsPackage.PERSON__TIME_ZONE_ID:
			case CommonsPackage.PERSON__TIME_ZONE:
			case CommonsPackage.PERSON__REFERRER_ID:
			case CommonsPackage.PERSON__REFERRER_TYPE:
			case CommonsPackage.PERSON__SIGNUP_SOURCE:
			case CommonsPackage.PERSON__SIGNUP_SOURCE_TYPE:
			case CommonsPackage.PERSON__IP_ADDRESS:
			case CommonsPackage.PERSON__LAST_IP_ADDRESS:
			case CommonsPackage.PERSON__LAST_LOGIN_TIME:
			case CommonsPackage.PERSON__VALIDATION_TIME:
			case CommonsPackage.PERSON__ACTIVATION_TIME:
			case CommonsPackage.PERSON__VERIFICATION_TIME:
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_ENABLED:
			case CommonsPackage.PERSON__NEWSLETTER_SUBSCRIPTION_TIME:
			case CommonsPackage.PERSON__SOCIAL_SHARING_ENABLED:
			case CommonsPackage.PERSON__PUBLICATION_STATUS:
			case CommonsPackage.PERSON__ARCHIVAL_STATUS:
			case CommonsPackage.PERSON__FOLDER:
			case CommonsPackage.PERSON__RELIGION:
			case CommonsPackage.PERSON__PASSWORD_RESET_CODE:
			case CommonsPackage.PERSON__PASSWORD_RESET_EXPIRY_TIME:
			case CommonsPackage.PERSON__CLIENT_ACCESS_TOKEN:
			case CommonsPackage.PERSON__SECURITY_ROLE_IDS:
			case CommonsPackage.PERSON__DEBIT_BALANCE:
			case CommonsPackage.PERSON__DEBIT_CURRENCY:
			case CommonsPackage.PERSON__TYPE:
			case CommonsPackage.PERSON__VERIFY_CODE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CommonsPackage.PERSON__PHONE_NUMBERS:
			case CommonsPackage.PERSON__EMAILS:
			case CommonsPackage.PERSON__MOBILE_NUMBERS:
			case CommonsPackage.PERSON__ADDRESSES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CommonsPackage.Literals.PERSON__PHONE_NUMBERS,
				 CommonsFactory.eINSTANCE.createPhoneNumber()));

		newChildDescriptors.add
			(createChildParameter
				(CommonsPackage.Literals.PERSON__EMAILS,
				 CommonsFactory.eINSTANCE.createEmail()));

		newChildDescriptors.add
			(createChildParameter
				(CommonsPackage.Literals.PERSON__MOBILE_NUMBERS,
				 CommonsFactory.eINSTANCE.createPhoneNumber()));

		newChildDescriptors.add
			(createChildParameter
				(CommonsPackage.Literals.PERSON__ADDRESSES,
				 CommonsFactory.eINSTANCE.createPostalAddress()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == CommonsPackage.Literals.PERSON__PHONE_NUMBERS ||
			childFeature == CommonsPackage.Literals.PERSON__MOBILE_NUMBERS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CommonsEditPlugin.INSTANCE;
	}

}
