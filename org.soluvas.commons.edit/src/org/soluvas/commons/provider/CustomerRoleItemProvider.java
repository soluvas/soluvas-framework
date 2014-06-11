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
import org.soluvas.commons.CustomerRole;

/**
 * This is the item provider adapter for a {@link org.soluvas.commons.CustomerRole} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomerRoleItemProvider
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
	public CustomerRoleItemProvider(AdapterFactory adapterFactory) {
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

			addIdPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addCreationTimePropertyDescriptor(object);
			addModificationTimePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addSchemaVersionPropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addQuickShopEnabledPropertyDescriptor(object);
			addSalesOrderReportEnabledPropertyDescriptor(object);
			addHistorySalesOrderEnabledPropertyDescriptor(object);
			addAgentSalesReportEnabledPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_CustomerRole_schemaVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_schemaVersion_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__SCHEMA_VERSION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_status_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_status_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_readOnly_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_readOnly_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__READ_ONLY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Quick Shop Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQuickShopEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_quickShopEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_quickShopEnabled_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__QUICK_SHOP_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sales Order Report Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSalesOrderReportEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_salesOrderReportEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_salesOrderReportEnabled_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the History Sales Order Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHistorySalesOrderEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_historySalesOrderEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_historySalesOrderEnabled_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Agent Sales Report Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgentSalesReportEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CustomerRole_agentSalesReportEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CustomerRole_agentSalesReportEnabled_feature", "_UI_CustomerRole_type"),
				 CommonsPackage.Literals.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns CustomerRole.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CustomerRole"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CustomerRole)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CustomerRole_type") :
			getString("_UI_CustomerRole_type") + " " + label;
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

		switch (notification.getFeatureID(CustomerRole.class)) {
			case CommonsPackage.CUSTOMER_ROLE__ID:
			case CommonsPackage.CUSTOMER_ROLE__NAME:
			case CommonsPackage.CUSTOMER_ROLE__CREATION_TIME:
			case CommonsPackage.CUSTOMER_ROLE__MODIFICATION_TIME:
			case CommonsPackage.CUSTOMER_ROLE__DESCRIPTION:
			case CommonsPackage.CUSTOMER_ROLE__SCHEMA_VERSION:
			case CommonsPackage.CUSTOMER_ROLE__STATUS:
			case CommonsPackage.CUSTOMER_ROLE__READ_ONLY:
			case CommonsPackage.CUSTOMER_ROLE__QUICK_SHOP_ENABLED:
			case CommonsPackage.CUSTOMER_ROLE__SALES_ORDER_REPORT_ENABLED:
			case CommonsPackage.CUSTOMER_ROLE__HISTORY_SALES_ORDER_ENABLED:
			case CommonsPackage.CUSTOMER_ROLE__AGENT_SALES_REPORT_ENABLED:
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
