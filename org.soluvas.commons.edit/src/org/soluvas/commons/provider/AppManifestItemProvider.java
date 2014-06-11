/**
 */
package org.soluvas.commons.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsPackage;

/**
 * This is the item provider adapter for a {@link org.soluvas.commons.AppManifest} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AppManifestItemProvider
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
	public AppManifestItemProvider(AdapterFactory adapterFactory) {
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

			addPositionerPropertyDescriptor(object);
			addResourceTypePropertyDescriptor(object);
			addResourceUriPropertyDescriptor(object);
			addResourceNamePropertyDescriptor(object);
			addBundlePropertyDescriptor(object);
			addExpansionStatePropertyDescriptor(object);
			addTitlePropertyDescriptor(object);
			addSummaryPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addDomainPropertyDescriptor(object);
			addDomainPrdPropertyDescriptor(object);
			addDomainDevPropertyDescriptor(object);
			addDomainStgPropertyDescriptor(object);
			addGeneralEmailPropertyDescriptor(object);
			addGeneralEmailPrdPropertyDescriptor(object);
			addGeneralEmailDevPropertyDescriptor(object);
			addGeneralEmailStgPropertyDescriptor(object);
			addOrganizationNamePropertyDescriptor(object);
			addOrganizationAddressPropertyDescriptor(object);
			addOrganizationPhoneNumbersPropertyDescriptor(object);
			addDefaultTimeZoneIdPropertyDescriptor(object);
			addDefaultTimeZonePropertyDescriptor(object);
			addDefaultCurrencyCodePropertyDescriptor(object);
			addDefaultCurrencyPropertyDescriptor(object);
			addDefaultLanguageTagPropertyDescriptor(object);
			addDefaultCountryCodePropertyDescriptor(object);
			addDefaultCategoryUNamePropertyDescriptor(object);
			addEmailLogoUriTemplatePropertyDescriptor(object);
			addLetterSalutationPropertyDescriptor(object);
			addLetterClosingPropertyDescriptor(object);
			addFootnotePropertyDescriptor(object);
			addWwwUsedPropertyDescriptor(object);
			addHeadNotePropertyDescriptor(object);
			addHeadTitlePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Positioner feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPositionerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Positionable_positioner_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Positionable_positioner_feature", "_UI_Positionable_type"),
				 CommonsPackage.Literals.POSITIONABLE__POSITIONER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceAware_resourceType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceAware_resourceType_feature", "_UI_ResourceAware_type"),
				 CommonsPackage.Literals.RESOURCE_AWARE__RESOURCE_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceAware_resourceUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceAware_resourceUri_feature", "_UI_ResourceAware_type"),
				 CommonsPackage.Literals.RESOURCE_AWARE__RESOURCE_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resource Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ResourceAware_resourceName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ResourceAware_resourceName_feature", "_UI_ResourceAware_type"),
				 CommonsPackage.Literals.RESOURCE_AWARE__RESOURCE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bundle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBundlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleAware_bundle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleAware_bundle_feature", "_UI_BundleAware_type"),
				 CommonsPackage.Literals.BUNDLE_AWARE__BUNDLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expansion State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpansionStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Expandable_expansionState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Expandable_expansionState_feature", "_UI_Expandable_type"),
				 CommonsPackage.Literals.EXPANDABLE__EXPANSION_STATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_title_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_title_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Summary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSummaryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_summary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_summary_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__SUMMARY,
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
				 getString("_UI_AppManifest_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_description_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Domain feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_domain_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_domain_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DOMAIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Domain Prd feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainPrdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_domainPrd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_domainPrd_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DOMAIN_PRD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Domain Dev feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainDevPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_domainDev_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_domainDev_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DOMAIN_DEV,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Domain Stg feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDomainStgPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_domainStg_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_domainStg_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DOMAIN_STG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the General Email feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralEmailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_generalEmail_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_generalEmail_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__GENERAL_EMAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the General Email Prd feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralEmailPrdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_generalEmailPrd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_generalEmailPrd_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__GENERAL_EMAIL_PRD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the General Email Dev feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralEmailDevPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_generalEmailDev_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_generalEmailDev_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__GENERAL_EMAIL_DEV,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the General Email Stg feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralEmailStgPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_generalEmailStg_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_generalEmailStg_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__GENERAL_EMAIL_STG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organization Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_organizationName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_organizationName_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__ORGANIZATION_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organization Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_organizationAddress_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_organizationAddress_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__ORGANIZATION_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organization Phone Numbers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationPhoneNumbersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_organizationPhoneNumbers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_organizationPhoneNumbers_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Time Zone Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultTimeZoneIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultTimeZoneId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultTimeZoneId_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_TIME_ZONE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Time Zone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultTimeZonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultTimeZone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultTimeZone_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_TIME_ZONE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Currency Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultCurrencyCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultCurrencyCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultCurrencyCode_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_CURRENCY_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Currency feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultCurrencyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultCurrency_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultCurrency_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_CURRENCY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Language Tag feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultLanguageTagPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultLanguageTag_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultLanguageTag_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_LANGUAGE_TAG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Country Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultCountryCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultCountryCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultCountryCode_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_COUNTRY_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Category UName feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultCategoryUNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_defaultCategoryUName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_defaultCategoryUName_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__DEFAULT_CATEGORY_UNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Email Logo Uri Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmailLogoUriTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_emailLogoUriTemplate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_emailLogoUriTemplate_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Letter Salutation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLetterSalutationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_letterSalutation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_letterSalutation_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__LETTER_SALUTATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Letter Closing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLetterClosingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_letterClosing_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_letterClosing_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__LETTER_CLOSING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Footnote feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFootnotePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_footnote_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_footnote_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__FOOTNOTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Www Used feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWwwUsedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_wwwUsed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_wwwUsed_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__WWW_USED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Head Note feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeadNotePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_headNote_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_headNote_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__HEAD_NOTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Head Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeadTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AppManifest_headTitle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AppManifest_headTitle_feature", "_UI_AppManifest_type"),
				 CommonsPackage.Literals.APP_MANIFEST__HEAD_TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AppManifest.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AppManifest"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AppManifest)object).getResourceName();
		return label == null || label.length() == 0 ?
			getString("_UI_AppManifest_type") :
			getString("_UI_AppManifest_type") + " " + label;
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

		switch (notification.getFeatureID(AppManifest.class)) {
			case CommonsPackage.APP_MANIFEST__POSITIONER:
			case CommonsPackage.APP_MANIFEST__RESOURCE_TYPE:
			case CommonsPackage.APP_MANIFEST__RESOURCE_URI:
			case CommonsPackage.APP_MANIFEST__RESOURCE_NAME:
			case CommonsPackage.APP_MANIFEST__BUNDLE:
			case CommonsPackage.APP_MANIFEST__EXPANSION_STATE:
			case CommonsPackage.APP_MANIFEST__TITLE:
			case CommonsPackage.APP_MANIFEST__SUMMARY:
			case CommonsPackage.APP_MANIFEST__DESCRIPTION:
			case CommonsPackage.APP_MANIFEST__DOMAIN:
			case CommonsPackage.APP_MANIFEST__DOMAIN_PRD:
			case CommonsPackage.APP_MANIFEST__DOMAIN_DEV:
			case CommonsPackage.APP_MANIFEST__DOMAIN_STG:
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL:
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_PRD:
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_DEV:
			case CommonsPackage.APP_MANIFEST__GENERAL_EMAIL_STG:
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_NAME:
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_ADDRESS:
			case CommonsPackage.APP_MANIFEST__ORGANIZATION_PHONE_NUMBERS:
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE_ID:
			case CommonsPackage.APP_MANIFEST__DEFAULT_TIME_ZONE:
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY_CODE:
			case CommonsPackage.APP_MANIFEST__DEFAULT_CURRENCY:
			case CommonsPackage.APP_MANIFEST__DEFAULT_LANGUAGE_TAG:
			case CommonsPackage.APP_MANIFEST__DEFAULT_COUNTRY_CODE:
			case CommonsPackage.APP_MANIFEST__DEFAULT_CATEGORY_UNAME:
			case CommonsPackage.APP_MANIFEST__EMAIL_LOGO_URI_TEMPLATE:
			case CommonsPackage.APP_MANIFEST__LETTER_SALUTATION:
			case CommonsPackage.APP_MANIFEST__LETTER_CLOSING:
			case CommonsPackage.APP_MANIFEST__FOOTNOTE:
			case CommonsPackage.APP_MANIFEST__WWW_USED:
			case CommonsPackage.APP_MANIFEST__HEAD_NOTE:
			case CommonsPackage.APP_MANIFEST__HEAD_TITLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
