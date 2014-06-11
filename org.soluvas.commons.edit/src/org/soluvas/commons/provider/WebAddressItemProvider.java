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
import org.soluvas.commons.WebAddress;

/**
 * This is the item provider adapter for a {@link org.soluvas.commons.WebAddress} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WebAddressItemProvider
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
	public WebAddressItemProvider(AdapterFactory adapterFactory) {
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
			addBundlePropertyDescriptor(object);
			addResourceTypePropertyDescriptor(object);
			addResourceUriPropertyDescriptor(object);
			addResourceNamePropertyDescriptor(object);
			addExpansionStatePropertyDescriptor(object);
			addBaseUriPropertyDescriptor(object);
			addBasePathPropertyDescriptor(object);
			addApiPathPropertyDescriptor(object);
			addImagesUriPropertyDescriptor(object);
			addSkinUriPropertyDescriptor(object);
			addJsUriPropertyDescriptor(object);
			addSecureBaseUriPropertyDescriptor(object);
			addSecureImagesUriPropertyDescriptor(object);
			addSecureSkinUriPropertyDescriptor(object);
			addSecureJsUriPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Base Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_baseUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_baseUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__BASE_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Base Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBasePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_basePath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_basePath_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__BASE_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Api Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addApiPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_apiPath_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_apiPath_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__API_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Images Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImagesUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_imagesUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_imagesUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__IMAGES_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Skin Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSkinUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_skinUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_skinUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__SKIN_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Js Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJsUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_jsUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_jsUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__JS_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Secure Base Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecureBaseUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_secureBaseUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_secureBaseUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__SECURE_BASE_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Secure Images Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecureImagesUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_secureImagesUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_secureImagesUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__SECURE_IMAGES_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Secure Skin Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecureSkinUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_secureSkinUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_secureSkinUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__SECURE_SKIN_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Secure Js Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSecureJsUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WebAddress_secureJsUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_WebAddress_secureJsUri_feature", "_UI_WebAddress_type"),
				 CommonsPackage.Literals.WEB_ADDRESS__SECURE_JS_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns WebAddress.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/WebAddress"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((WebAddress)object).getResourceName();
		return label == null || label.length() == 0 ?
			getString("_UI_WebAddress_type") :
			getString("_UI_WebAddress_type") + " " + label;
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

		switch (notification.getFeatureID(WebAddress.class)) {
			case CommonsPackage.WEB_ADDRESS__POSITIONER:
			case CommonsPackage.WEB_ADDRESS__BUNDLE:
			case CommonsPackage.WEB_ADDRESS__RESOURCE_TYPE:
			case CommonsPackage.WEB_ADDRESS__RESOURCE_URI:
			case CommonsPackage.WEB_ADDRESS__RESOURCE_NAME:
			case CommonsPackage.WEB_ADDRESS__EXPANSION_STATE:
			case CommonsPackage.WEB_ADDRESS__BASE_URI:
			case CommonsPackage.WEB_ADDRESS__BASE_PATH:
			case CommonsPackage.WEB_ADDRESS__API_PATH:
			case CommonsPackage.WEB_ADDRESS__IMAGES_URI:
			case CommonsPackage.WEB_ADDRESS__SKIN_URI:
			case CommonsPackage.WEB_ADDRESS__JS_URI:
			case CommonsPackage.WEB_ADDRESS__SECURE_BASE_URI:
			case CommonsPackage.WEB_ADDRESS__SECURE_IMAGES_URI:
			case CommonsPackage.WEB_ADDRESS__SECURE_SKIN_URI:
			case CommonsPackage.WEB_ADDRESS__SECURE_JS_URI:
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
