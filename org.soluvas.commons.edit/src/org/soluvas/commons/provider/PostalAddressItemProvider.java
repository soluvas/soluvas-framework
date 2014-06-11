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

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.PostalAddress;

/**
 * This is the item provider adapter for a {@link org.soluvas.commons.PostalAddress} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PostalAddressItemProvider
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
	public PostalAddressItemProvider(AdapterFactory adapterFactory) {
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
			addIdPropertyDescriptor(object);
			addSchemaVersionPropertyDescriptor(object);
			addOrganizationPropertyDescriptor(object);
			addStreetPropertyDescriptor(object);
			addCityPropertyDescriptor(object);
			addPostalCodePropertyDescriptor(object);
			addProvincePropertyDescriptor(object);
			addCountryPropertyDescriptor(object);
			addCountryCodePropertyDescriptor(object);
			addPrimaryMobilePropertyDescriptor(object);
			addMobilesPropertyDescriptor(object);
			addPrimaryPhonePropertyDescriptor(object);
			addPhonesPropertyDescriptor(object);
			addPrimaryHomePhonePropertyDescriptor(object);
			addHomePhonesPropertyDescriptor(object);
			addPrimaryWorkPhonePropertyDescriptor(object);
			addWorkPhonesPropertyDescriptor(object);
			addPrimaryEmailPropertyDescriptor(object);
			addEmailsPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addPrimaryPropertyDescriptor(object);
			addPrimaryBillingPropertyDescriptor(object);
			addPrimaryShippingPropertyDescriptor(object);
			addValidationTimePropertyDescriptor(object);
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
				 getString("_UI_PostalAddress_schemaVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_schemaVersion_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__SCHEMA_VERSION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Organization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOrganizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_organization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_organization_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__ORGANIZATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Street feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStreetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_street_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_street_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__STREET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the City feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_city_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_city_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__CITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postal Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPostalCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_postalCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_postalCode_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__POSTAL_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Province feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvincePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_province_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_province_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PROVINCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Country feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCountryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_country_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_country_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__COUNTRY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Country Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCountryCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_countryCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_countryCode_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__COUNTRY_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Mobile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryMobilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryMobile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryMobile_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_MOBILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mobiles feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMobilesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_mobiles_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_mobiles_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__MOBILES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryPhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryPhone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryPhone_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Phones feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhonesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_phones_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_phones_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PHONES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Home Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryHomePhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryHomePhone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryHomePhone_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_HOME_PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Home Phones feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHomePhonesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_homePhones_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_homePhones_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__HOME_PHONES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Work Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryWorkPhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryWorkPhone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryWorkPhone_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_WORK_PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Work Phones feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWorkPhonesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_workPhones_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_workPhones_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__WORK_PHONES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Email feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryEmailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryEmail_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryEmail_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_EMAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Emails feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmailsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_emails_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_emails_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__EMAILS,
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
				 getString("_UI_PostalAddress_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_description_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primary_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Billing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryBillingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryBilling_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryBilling_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_BILLING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Primary Shipping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrimaryShippingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PostalAddress_primaryShipping_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_primaryShipping_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__PRIMARY_SHIPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_PostalAddress_validationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PostalAddress_validationTime_feature", "_UI_PostalAddress_type"),
				 CommonsPackage.Literals.POSTAL_ADDRESS__VALIDATION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns PostalAddress.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PostalAddress"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PostalAddress)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_PostalAddress_type") :
			getString("_UI_PostalAddress_type") + " " + label;
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

		switch (notification.getFeatureID(PostalAddress.class)) {
			case CommonsPackage.POSTAL_ADDRESS__NAME:
			case CommonsPackage.POSTAL_ADDRESS__ID:
			case CommonsPackage.POSTAL_ADDRESS__SCHEMA_VERSION:
			case CommonsPackage.POSTAL_ADDRESS__ORGANIZATION:
			case CommonsPackage.POSTAL_ADDRESS__STREET:
			case CommonsPackage.POSTAL_ADDRESS__CITY:
			case CommonsPackage.POSTAL_ADDRESS__POSTAL_CODE:
			case CommonsPackage.POSTAL_ADDRESS__PROVINCE:
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY:
			case CommonsPackage.POSTAL_ADDRESS__COUNTRY_CODE:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_MOBILE:
			case CommonsPackage.POSTAL_ADDRESS__MOBILES:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_PHONE:
			case CommonsPackage.POSTAL_ADDRESS__PHONES:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_HOME_PHONE:
			case CommonsPackage.POSTAL_ADDRESS__HOME_PHONES:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_WORK_PHONE:
			case CommonsPackage.POSTAL_ADDRESS__WORK_PHONES:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_EMAIL:
			case CommonsPackage.POSTAL_ADDRESS__EMAILS:
			case CommonsPackage.POSTAL_ADDRESS__DESCRIPTION:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_BILLING:
			case CommonsPackage.POSTAL_ADDRESS__PRIMARY_SHIPPING:
			case CommonsPackage.POSTAL_ADDRESS__VALIDATION_TIME:
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
