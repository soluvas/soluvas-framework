/**
 */
package org.soluvas.security;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.soluvas.commons.CommonsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.security.SecurityFactory
 * @model kind="package"
 * @generated
 */
public interface SecurityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "security";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/security/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "security";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecurityPackage eINSTANCE = org.soluvas.security.impl.SecurityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.RoleImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assign Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ASSIGN_MODE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.DomainRoleImpl <em>Domain Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.DomainRoleImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomainRole()
	 * @generated
	 */
	int DOMAIN_ROLE = 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__DESCRIPTION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE__DOMAIN = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ROLE_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.DomainImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__DESCRIPTION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.ActionImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__GLOBAL = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DOMAINS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DESCRIPTION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.SecurityCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.SecurityCatalogImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getSecurityCatalog()
	 * @generated
	 */
	int SECURITY_CATALOG = 4;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__ROLES = 0;

	/**
	 * The feature id for the '<em><b>Instance Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__INSTANCE_ROLES = 1;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__DOMAINS = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__ACTIONS = 3;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__PERMISSIONS = 4;

	/**
	 * The feature id for the '<em><b>Domain Permissions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG__DOMAIN_PERMISSIONS = 5;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CATALOG_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.PermissionImpl <em>Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.PermissionImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getPermission()
	 * @generated
	 */
	int PERMISSION = 5;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ROLES = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Permission</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__DOMAIN_PERMISSION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action Permission</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ACTION_PERMISSION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Permission</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__INSTANCE_PERMISSION = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.DomainPermissionImpl <em>Domain Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.DomainPermissionImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomainPermission()
	 * @generated
	 */
	int DOMAIN_PERMISSION = 6;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PERMISSION__DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Domain Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PERMISSION__DOMAIN_ROLES = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PERMISSION__ACTIONS = 2;

	/**
	 * The number of structural features of the '<em>Domain Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PERMISSION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.AppSessionImpl <em>App Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.AppSessionImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSession()
	 * @generated
	 */
	int APP_SESSION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__ID = CommonsPackage.IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__CREATION_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modification Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__MODIFICATION_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__PERSON = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__SCHEMA_VERSION = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__STATUS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ip Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__IP_ADDRESS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ipv6 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__IPV6_ADDRESS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Ip Addresses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__IP_ADDRESSES = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Ipv6 Addresses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__IPV6_ADDRESSES = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>User Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__USER_AGENT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>User Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__USER_AGENTS = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__ATTRIBUTES = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__TIMEOUT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Access Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__ACCESS_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Expiry Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__EXPIRY_TIME = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__TIME_ZONE = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION__LOCALE = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>App Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_FEATURE_COUNT = CommonsPackage.IDENTIFIABLE_FEATURE_COUNT + 17;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.AppSessionAttributeEntryImpl <em>App Session Attribute Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.AppSessionAttributeEntryImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionAttributeEntry()
	 * @generated
	 */
	int APP_SESSION_ATTRIBUTE_ENTRY = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_ATTRIBUTE_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_ATTRIBUTE_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>App Session Attribute Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_ATTRIBUTE_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.security.impl.AppSessionManagerImpl <em>App Session Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.impl.AppSessionManagerImpl
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionManager()
	 * @generated
	 */
	int APP_SESSION_MANAGER = 9;

	/**
	 * The feature id for the '<em><b>Security Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_MANAGER__SECURITY_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Person Lookup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_MANAGER__PERSON_LOOKUP = 1;

	/**
	 * The number of structural features of the '<em>App Session Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_SESSION_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.security.AssignMode <em>Assign Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.AssignMode
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAssignMode()
	 * @generated
	 */
	int ASSIGN_MODE = 10;


	/**
	 * The meta object id for the '{@link org.soluvas.security.AppSessionStatus <em>App Session Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.security.AppSessionStatus
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionStatus()
	 * @generated
	 */
	int APP_SESSION_STATUS = 11;


	/**
	 * The meta object id for the '<em>Session</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.shiro.session.Session
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 12;


	/**
	 * The meta object id for the '<em>Http Servlet Request</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.servlet.http.HttpServletRequest
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getHttpServletRequest()
	 * @generated
	 */
	int HTTP_SERVLET_REQUEST = 13;

	/**
	 * The meta object id for the '<em>Http Servlet Response</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.servlet.http.HttpServletResponse
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getHttpServletResponse()
	 * @generated
	 */
	int HTTP_SERVLET_RESPONSE = 14;


	/**
	 * The meta object id for the '<em>Person</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.ldap.Person
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 15;


	/**
	 * The meta object id for the '<em>Manager</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getSecurityManager()
	 * @generated
	 */
	int SECURITY_MANAGER = 16;


	/**
	 * The meta object id for the '<em>Entity Lookup</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.EntityLookup
	 * @see org.soluvas.security.impl.SecurityPackageImpl#getEntityLookup()
	 * @generated
	 */
	int ENTITY_LOOKUP = 17;


	/**
	 * Returns the meta object for class '{@link org.soluvas.security.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.soluvas.security.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.security.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Role#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.security.Role#getDescription()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Role#getAssignMode <em>Assign Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assign Mode</em>'.
	 * @see org.soluvas.security.Role#getAssignMode()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_AssignMode();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.DomainRole <em>Domain Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Role</em>'.
	 * @see org.soluvas.security.DomainRole
	 * @generated
	 */
	EClass getDomainRole();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.DomainRole#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.security.DomainRole#getName()
	 * @see #getDomainRole()
	 * @generated
	 */
	EAttribute getDomainRole_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.DomainRole#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.security.DomainRole#getDescription()
	 * @see #getDomainRole()
	 * @generated
	 */
	EAttribute getDomainRole_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.DomainRole#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see org.soluvas.security.DomainRole#getDomain()
	 * @see #getDomainRole()
	 * @generated
	 */
	EAttribute getDomainRole_Domain();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see org.soluvas.security.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Domain#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.security.Domain#getName()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Domain#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.security.Domain#getDescription()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_Description();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.soluvas.security.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.security.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Action#getGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global</em>'.
	 * @see org.soluvas.security.Action#getGlobal()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Global();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.Action#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domains</em>'.
	 * @see org.soluvas.security.Action#getDomains()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Domains();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.Action#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.security.Action#getDescription()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Description();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.SecurityCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.security.SecurityCatalog
	 * @generated
	 */
	EClass getSecurityCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.security.SecurityCatalog#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getRoles()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.security.SecurityCatalog#getInstanceRoles <em>Instance Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Roles</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getInstanceRoles()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_InstanceRoles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.security.SecurityCatalog#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getDomains()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_Domains();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.security.SecurityCatalog#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getActions()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.security.SecurityCatalog#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permissions</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getPermissions()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_Permissions();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.security.SecurityCatalog#getDomainPermissions <em>Domain Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Permissions</em>'.
	 * @see org.soluvas.security.SecurityCatalog#getDomainPermissions()
	 * @see #getSecurityCatalog()
	 * @generated
	 */
	EReference getSecurityCatalog_DomainPermissions();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.Permission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission</em>'.
	 * @see org.soluvas.security.Permission
	 * @generated
	 */
	EClass getPermission();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.Permission#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Roles</em>'.
	 * @see org.soluvas.security.Permission#getRoles()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Roles();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.Permission#getDomainPermission <em>Domain Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domain Permission</em>'.
	 * @see org.soluvas.security.Permission#getDomainPermission()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_DomainPermission();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.Permission#getActionPermission <em>Action Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Action Permission</em>'.
	 * @see org.soluvas.security.Permission#getActionPermission()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_ActionPermission();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.Permission#getInstancePermission <em>Instance Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Instance Permission</em>'.
	 * @see org.soluvas.security.Permission#getInstancePermission()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_InstancePermission();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.DomainPermission <em>Domain Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Permission</em>'.
	 * @see org.soluvas.security.DomainPermission
	 * @generated
	 */
	EClass getDomainPermission();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.DomainPermission#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see org.soluvas.security.DomainPermission#getDomain()
	 * @see #getDomainPermission()
	 * @generated
	 */
	EAttribute getDomainPermission_Domain();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.DomainPermission#getDomainRoles <em>Domain Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domain Roles</em>'.
	 * @see org.soluvas.security.DomainPermission#getDomainRoles()
	 * @see #getDomainPermission()
	 * @generated
	 */
	EAttribute getDomainPermission_DomainRoles();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.DomainPermission#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Actions</em>'.
	 * @see org.soluvas.security.DomainPermission#getActions()
	 * @see #getDomainPermission()
	 * @generated
	 */
	EAttribute getDomainPermission_Actions();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.AppSession <em>App Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Session</em>'.
	 * @see org.soluvas.security.AppSession
	 * @generated
	 */
	EClass getAppSession();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.security.AppSession#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see org.soluvas.security.AppSession#getPerson()
	 * @see #getAppSession()
	 * @generated
	 */
	EReference getAppSession_Person();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getSchemaVersion <em>Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Version</em>'.
	 * @see org.soluvas.security.AppSession#getSchemaVersion()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_SchemaVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.soluvas.security.AppSession#getStatus()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getIpAddress <em>Ip Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip Address</em>'.
	 * @see org.soluvas.security.AppSession#getIpAddress()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_IpAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getIpv6Address <em>Ipv6 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ipv6 Address</em>'.
	 * @see org.soluvas.security.AppSession#getIpv6Address()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_Ipv6Address();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.AppSession#getIpAddresses <em>Ip Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ip Addresses</em>'.
	 * @see org.soluvas.security.AppSession#getIpAddresses()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_IpAddresses();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.security.AppSession#getIpv6Addresses <em>Ipv6 Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ipv6 Addresses</em>'.
	 * @see org.soluvas.security.AppSession#getIpv6Addresses()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_Ipv6Addresses();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getUserAgent <em>User Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Agent</em>'.
	 * @see org.soluvas.security.AppSession#getUserAgent()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_UserAgent();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getUserAgents <em>User Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Agents</em>'.
	 * @see org.soluvas.security.AppSession#getUserAgents()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_UserAgents();

	/**
	 * Returns the meta object for the map '{@link org.soluvas.security.AppSession#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Attributes</em>'.
	 * @see org.soluvas.security.AppSession#getAttributes()
	 * @see #getAppSession()
	 * @generated
	 */
	EReference getAppSession_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see org.soluvas.security.AppSession#getTimeout()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getAccessTime <em>Access Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Time</em>'.
	 * @see org.soluvas.security.AppSession#getAccessTime()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_AccessTime();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getExpiryTime <em>Expiry Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiry Time</em>'.
	 * @see org.soluvas.security.AppSession#getExpiryTime()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_ExpiryTime();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getTimeZone <em>Time Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Zone</em>'.
	 * @see org.soluvas.security.AppSession#getTimeZone()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_TimeZone();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSession#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see org.soluvas.security.AppSession#getLocale()
	 * @see #getAppSession()
	 * @generated
	 */
	EAttribute getAppSession_Locale();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>App Session Attribute Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Session Attribute Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EJavaObject"
	 * @generated
	 */
	EClass getAppSessionAttributeEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getAppSessionAttributeEntry()
	 * @generated
	 */
	EAttribute getAppSessionAttributeEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getAppSessionAttributeEntry()
	 * @generated
	 */
	EAttribute getAppSessionAttributeEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.soluvas.security.AppSessionManager <em>App Session Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Session Manager</em>'.
	 * @see org.soluvas.security.AppSessionManager
	 * @generated
	 */
	EClass getAppSessionManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSessionManager#getSecurityManager <em>Security Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Security Manager</em>'.
	 * @see org.soluvas.security.AppSessionManager#getSecurityManager()
	 * @see #getAppSessionManager()
	 * @generated
	 */
	EAttribute getAppSessionManager_SecurityManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.security.AppSessionManager#getPersonLookup <em>Person Lookup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Person Lookup</em>'.
	 * @see org.soluvas.security.AppSessionManager#getPersonLookup()
	 * @see #getAppSessionManager()
	 * @generated
	 */
	EAttribute getAppSessionManager_PersonLookup();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.security.AssignMode <em>Assign Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assign Mode</em>'.
	 * @see org.soluvas.security.AssignMode
	 * @generated
	 */
	EEnum getAssignMode();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.security.AppSessionStatus <em>App Session Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>App Session Status</em>'.
	 * @see org.soluvas.security.AppSessionStatus
	 * @generated
	 */
	EEnum getAppSessionStatus();

	/**
	 * Returns the meta object for data type '{@link org.apache.shiro.session.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Session</em>'.
	 * @see org.apache.shiro.session.Session
	 * @model instanceClass="org.apache.shiro.session.Session"
	 * @generated
	 */
	EDataType getSession();

	/**
	 * Returns the meta object for data type '{@link javax.servlet.http.HttpServletRequest <em>Http Servlet Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Http Servlet Request</em>'.
	 * @see javax.servlet.http.HttpServletRequest
	 * @model instanceClass="javax.servlet.http.HttpServletRequest"
	 * @generated
	 */
	EDataType getHttpServletRequest();

	/**
	 * Returns the meta object for data type '{@link javax.servlet.http.HttpServletResponse <em>Http Servlet Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Http Servlet Response</em>'.
	 * @see javax.servlet.http.HttpServletResponse
	 * @model instanceClass="javax.servlet.http.HttpServletResponse"
	 * @generated
	 */
	EDataType getHttpServletResponse();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.ldap.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Person</em>'.
	 * @see org.soluvas.ldap.Person
	 * @model instanceClass="org.soluvas.ldap.Person"
	 * @generated
	 */
	EDataType getPerson();

	/**
	 * Returns the meta object for data type '{@link org.apache.shiro.mgt.SecurityManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Manager</em>'.
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @model instanceClass="org.apache.shiro.mgt.SecurityManager" serializeable="false"
	 * @generated
	 */
	EDataType getSecurityManager();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.EntityLookup <em>Entity Lookup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Entity Lookup</em>'.
	 * @see org.soluvas.data.EntityLookup
	 * @model instanceClass="org.soluvas.data.EntityLookup" serializeable="false" typeParameters="T ID" IDBounds="org.soluvas.commons.Serializable"
	 * @generated
	 */
	EDataType getEntityLookup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SecurityFactory getSecurityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.RoleImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__DESCRIPTION = eINSTANCE.getRole_Description();

		/**
		 * The meta object literal for the '<em><b>Assign Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__ASSIGN_MODE = eINSTANCE.getRole_AssignMode();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.DomainRoleImpl <em>Domain Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.DomainRoleImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomainRole()
		 * @generated
		 */
		EClass DOMAIN_ROLE = eINSTANCE.getDomainRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ROLE__NAME = eINSTANCE.getDomainRole_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ROLE__DESCRIPTION = eINSTANCE.getDomainRole_Description();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ROLE__DOMAIN = eINSTANCE.getDomainRole_Domain();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.DomainImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN__NAME = eINSTANCE.getDomain_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN__DESCRIPTION = eINSTANCE.getDomain_Description();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.ActionImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__GLOBAL = eINSTANCE.getAction_Global();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DOMAINS = eINSTANCE.getAction_Domains();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DESCRIPTION = eINSTANCE.getAction_Description();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.SecurityCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.SecurityCatalogImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getSecurityCatalog()
		 * @generated
		 */
		EClass SECURITY_CATALOG = eINSTANCE.getSecurityCatalog();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__ROLES = eINSTANCE.getSecurityCatalog_Roles();

		/**
		 * The meta object literal for the '<em><b>Instance Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__INSTANCE_ROLES = eINSTANCE.getSecurityCatalog_InstanceRoles();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__DOMAINS = eINSTANCE.getSecurityCatalog_Domains();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__ACTIONS = eINSTANCE.getSecurityCatalog_Actions();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__PERMISSIONS = eINSTANCE.getSecurityCatalog_Permissions();

		/**
		 * The meta object literal for the '<em><b>Domain Permissions</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CATALOG__DOMAIN_PERMISSIONS = eINSTANCE.getSecurityCatalog_DomainPermissions();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.PermissionImpl <em>Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.PermissionImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getPermission()
		 * @generated
		 */
		EClass PERMISSION = eINSTANCE.getPermission();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__ROLES = eINSTANCE.getPermission_Roles();

		/**
		 * The meta object literal for the '<em><b>Domain Permission</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__DOMAIN_PERMISSION = eINSTANCE.getPermission_DomainPermission();

		/**
		 * The meta object literal for the '<em><b>Action Permission</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__ACTION_PERMISSION = eINSTANCE.getPermission_ActionPermission();

		/**
		 * The meta object literal for the '<em><b>Instance Permission</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__INSTANCE_PERMISSION = eINSTANCE.getPermission_InstancePermission();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.DomainPermissionImpl <em>Domain Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.DomainPermissionImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getDomainPermission()
		 * @generated
		 */
		EClass DOMAIN_PERMISSION = eINSTANCE.getDomainPermission();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_PERMISSION__DOMAIN = eINSTANCE.getDomainPermission_Domain();

		/**
		 * The meta object literal for the '<em><b>Domain Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_PERMISSION__DOMAIN_ROLES = eINSTANCE.getDomainPermission_DomainRoles();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_PERMISSION__ACTIONS = eINSTANCE.getDomainPermission_Actions();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.AppSessionImpl <em>App Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.AppSessionImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSession()
		 * @generated
		 */
		EClass APP_SESSION = eINSTANCE.getAppSession();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP_SESSION__PERSON = eINSTANCE.getAppSession_Person();

		/**
		 * The meta object literal for the '<em><b>Schema Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__SCHEMA_VERSION = eINSTANCE.getAppSession_SchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__STATUS = eINSTANCE.getAppSession_Status();

		/**
		 * The meta object literal for the '<em><b>Ip Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__IP_ADDRESS = eINSTANCE.getAppSession_IpAddress();

		/**
		 * The meta object literal for the '<em><b>Ipv6 Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__IPV6_ADDRESS = eINSTANCE.getAppSession_Ipv6Address();

		/**
		 * The meta object literal for the '<em><b>Ip Addresses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__IP_ADDRESSES = eINSTANCE.getAppSession_IpAddresses();

		/**
		 * The meta object literal for the '<em><b>Ipv6 Addresses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__IPV6_ADDRESSES = eINSTANCE.getAppSession_Ipv6Addresses();

		/**
		 * The meta object literal for the '<em><b>User Agent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__USER_AGENT = eINSTANCE.getAppSession_UserAgent();

		/**
		 * The meta object literal for the '<em><b>User Agents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__USER_AGENTS = eINSTANCE.getAppSession_UserAgents();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP_SESSION__ATTRIBUTES = eINSTANCE.getAppSession_Attributes();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__TIMEOUT = eINSTANCE.getAppSession_Timeout();

		/**
		 * The meta object literal for the '<em><b>Access Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__ACCESS_TIME = eINSTANCE.getAppSession_AccessTime();

		/**
		 * The meta object literal for the '<em><b>Expiry Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__EXPIRY_TIME = eINSTANCE.getAppSession_ExpiryTime();

		/**
		 * The meta object literal for the '<em><b>Time Zone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__TIME_ZONE = eINSTANCE.getAppSession_TimeZone();

		/**
		 * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION__LOCALE = eINSTANCE.getAppSession_Locale();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.AppSessionAttributeEntryImpl <em>App Session Attribute Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.AppSessionAttributeEntryImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionAttributeEntry()
		 * @generated
		 */
		EClass APP_SESSION_ATTRIBUTE_ENTRY = eINSTANCE.getAppSessionAttributeEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION_ATTRIBUTE_ENTRY__KEY = eINSTANCE.getAppSessionAttributeEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION_ATTRIBUTE_ENTRY__VALUE = eINSTANCE.getAppSessionAttributeEntry_Value();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.impl.AppSessionManagerImpl <em>App Session Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.impl.AppSessionManagerImpl
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionManager()
		 * @generated
		 */
		EClass APP_SESSION_MANAGER = eINSTANCE.getAppSessionManager();

		/**
		 * The meta object literal for the '<em><b>Security Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION_MANAGER__SECURITY_MANAGER = eINSTANCE.getAppSessionManager_SecurityManager();

		/**
		 * The meta object literal for the '<em><b>Person Lookup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APP_SESSION_MANAGER__PERSON_LOOKUP = eINSTANCE.getAppSessionManager_PersonLookup();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.AssignMode <em>Assign Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.AssignMode
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAssignMode()
		 * @generated
		 */
		EEnum ASSIGN_MODE = eINSTANCE.getAssignMode();

		/**
		 * The meta object literal for the '{@link org.soluvas.security.AppSessionStatus <em>App Session Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.security.AppSessionStatus
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getAppSessionStatus()
		 * @generated
		 */
		EEnum APP_SESSION_STATUS = eINSTANCE.getAppSessionStatus();

		/**
		 * The meta object literal for the '<em>Session</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.shiro.session.Session
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getSession()
		 * @generated
		 */
		EDataType SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '<em>Http Servlet Request</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.servlet.http.HttpServletRequest
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getHttpServletRequest()
		 * @generated
		 */
		EDataType HTTP_SERVLET_REQUEST = eINSTANCE.getHttpServletRequest();

		/**
		 * The meta object literal for the '<em>Http Servlet Response</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.servlet.http.HttpServletResponse
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getHttpServletResponse()
		 * @generated
		 */
		EDataType HTTP_SERVLET_RESPONSE = eINSTANCE.getHttpServletResponse();

		/**
		 * The meta object literal for the '<em>Person</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.ldap.Person
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getPerson()
		 * @generated
		 */
		EDataType PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em>Manager</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.shiro.mgt.SecurityManager
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getSecurityManager()
		 * @generated
		 */
		EDataType SECURITY_MANAGER = eINSTANCE.getSecurityManager();

		/**
		 * The meta object literal for the '<em>Entity Lookup</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.EntityLookup
		 * @see org.soluvas.security.impl.SecurityPackageImpl#getEntityLookup()
		 * @generated
		 */
		EDataType ENTITY_LOOKUP = eINSTANCE.getEntityLookup();

	}

} //SecurityPackage
