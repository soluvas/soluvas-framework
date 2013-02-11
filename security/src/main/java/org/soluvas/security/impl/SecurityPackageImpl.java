/**
 */
package org.soluvas.security.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
import org.soluvas.commons.CommonsPackage;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.Person;
import org.soluvas.security.Action;
import org.soluvas.security.AppSession;
import org.soluvas.security.AppSessionManager;
import org.soluvas.security.AppSessionStatus;
import org.soluvas.security.AssignMode;
import org.soluvas.security.Domain;
import org.soluvas.security.DomainPermission;
import org.soluvas.security.DomainRole;
import org.soluvas.security.Permission;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityFactory;
import org.soluvas.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecurityPackageImpl extends EPackageImpl implements SecurityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainPermissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appSessionAttributeEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appSessionManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assignModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum appSessionStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sessionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType httpServletRequestEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType httpServletResponseEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType personEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType securityManagerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType entityLookupEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType subjectEDataType = null;

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
	 * @see org.soluvas.security.SecurityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SecurityPackageImpl() {
		super(eNS_URI, SecurityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SecurityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SecurityPackage init() {
		if (isInited) return (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage(SecurityPackage.eNS_URI);

		// Obtain or create and register package
		SecurityPackageImpl theSecurityPackage = (SecurityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SecurityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SecurityPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSecurityPackage.createPackageContents();

		// Initialize created meta-data
		theSecurityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSecurityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SecurityPackage.eNS_URI, theSecurityPackage);
		return theSecurityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_Name() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_Description() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRole_AssignMode() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainRole() {
		return domainRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainRole_Name() {
		return (EAttribute)domainRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainRole_Description() {
		return (EAttribute)domainRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainRole_Domain() {
		return (EAttribute)domainRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_Name() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_Description() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Name() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Global() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Domains() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Description() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSecurityCatalog() {
		return securityCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_Roles() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_InstanceRoles() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_Domains() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_Actions() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_Permissions() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSecurityCatalog_DomainPermissions() {
		return (EReference)securityCatalogEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPermission() {
		return permissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermission_Roles() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermission_DomainPermission() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermission_ActionPermission() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermission_InstancePermission() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainPermission() {
		return domainPermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainPermission_Domain() {
		return (EAttribute)domainPermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainPermission_DomainRoles() {
		return (EAttribute)domainPermissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainPermission_Actions() {
		return (EAttribute)domainPermissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppSession() {
		return appSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAppSession_Person() {
		return (EReference)appSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_SchemaVersion() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_Status() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_IpAddress() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_Ipv6Address() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_IpAddresses() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_Ipv6Addresses() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_UserAgent() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_UserAgents() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAppSession_Attributes() {
		return (EReference)appSessionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_Timeout() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_AccessTime() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_ExpiryTime() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_TimeZone() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSession_Locale() {
		return (EAttribute)appSessionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppSessionAttributeEntry() {
		return appSessionAttributeEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSessionAttributeEntry_Key() {
		return (EAttribute)appSessionAttributeEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSessionAttributeEntry_Value() {
		return (EAttribute)appSessionAttributeEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppSessionManager() {
		return appSessionManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSessionManager_SecurityManager() {
		return (EAttribute)appSessionManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAppSessionManager_PersonLookup() {
		return (EAttribute)appSessionManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAssignMode() {
		return assignModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAppSessionStatus() {
		return appSessionStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSession() {
		return sessionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getHttpServletRequest() {
		return httpServletRequestEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getHttpServletResponse() {
		return httpServletResponseEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPerson() {
		return personEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSecurityManager() {
		return securityManagerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEntityLookup() {
		return entityLookupEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSubject() {
		return subjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecurityFactory getSecurityFactory() {
		return (SecurityFactory)getEFactoryInstance();
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
		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__NAME);
		createEAttribute(roleEClass, ROLE__DESCRIPTION);
		createEAttribute(roleEClass, ROLE__ASSIGN_MODE);

		domainRoleEClass = createEClass(DOMAIN_ROLE);
		createEAttribute(domainRoleEClass, DOMAIN_ROLE__NAME);
		createEAttribute(domainRoleEClass, DOMAIN_ROLE__DESCRIPTION);
		createEAttribute(domainRoleEClass, DOMAIN_ROLE__DOMAIN);

		domainEClass = createEClass(DOMAIN);
		createEAttribute(domainEClass, DOMAIN__NAME);
		createEAttribute(domainEClass, DOMAIN__DESCRIPTION);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__NAME);
		createEAttribute(actionEClass, ACTION__GLOBAL);
		createEAttribute(actionEClass, ACTION__DOMAINS);
		createEAttribute(actionEClass, ACTION__DESCRIPTION);

		securityCatalogEClass = createEClass(SECURITY_CATALOG);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__ROLES);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__INSTANCE_ROLES);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__DOMAINS);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__ACTIONS);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__PERMISSIONS);
		createEReference(securityCatalogEClass, SECURITY_CATALOG__DOMAIN_PERMISSIONS);

		permissionEClass = createEClass(PERMISSION);
		createEAttribute(permissionEClass, PERMISSION__ROLES);
		createEAttribute(permissionEClass, PERMISSION__DOMAIN_PERMISSION);
		createEAttribute(permissionEClass, PERMISSION__ACTION_PERMISSION);
		createEAttribute(permissionEClass, PERMISSION__INSTANCE_PERMISSION);

		domainPermissionEClass = createEClass(DOMAIN_PERMISSION);
		createEAttribute(domainPermissionEClass, DOMAIN_PERMISSION__DOMAIN);
		createEAttribute(domainPermissionEClass, DOMAIN_PERMISSION__DOMAIN_ROLES);
		createEAttribute(domainPermissionEClass, DOMAIN_PERMISSION__ACTIONS);

		appSessionEClass = createEClass(APP_SESSION);
		createEReference(appSessionEClass, APP_SESSION__PERSON);
		createEAttribute(appSessionEClass, APP_SESSION__SCHEMA_VERSION);
		createEAttribute(appSessionEClass, APP_SESSION__STATUS);
		createEAttribute(appSessionEClass, APP_SESSION__IP_ADDRESS);
		createEAttribute(appSessionEClass, APP_SESSION__IPV6_ADDRESS);
		createEAttribute(appSessionEClass, APP_SESSION__IP_ADDRESSES);
		createEAttribute(appSessionEClass, APP_SESSION__IPV6_ADDRESSES);
		createEAttribute(appSessionEClass, APP_SESSION__USER_AGENT);
		createEAttribute(appSessionEClass, APP_SESSION__USER_AGENTS);
		createEReference(appSessionEClass, APP_SESSION__ATTRIBUTES);
		createEAttribute(appSessionEClass, APP_SESSION__TIMEOUT);
		createEAttribute(appSessionEClass, APP_SESSION__ACCESS_TIME);
		createEAttribute(appSessionEClass, APP_SESSION__EXPIRY_TIME);
		createEAttribute(appSessionEClass, APP_SESSION__TIME_ZONE);
		createEAttribute(appSessionEClass, APP_SESSION__LOCALE);

		appSessionAttributeEntryEClass = createEClass(APP_SESSION_ATTRIBUTE_ENTRY);
		createEAttribute(appSessionAttributeEntryEClass, APP_SESSION_ATTRIBUTE_ENTRY__KEY);
		createEAttribute(appSessionAttributeEntryEClass, APP_SESSION_ATTRIBUTE_ENTRY__VALUE);

		appSessionManagerEClass = createEClass(APP_SESSION_MANAGER);
		createEAttribute(appSessionManagerEClass, APP_SESSION_MANAGER__SECURITY_MANAGER);
		createEAttribute(appSessionManagerEClass, APP_SESSION_MANAGER__PERSON_LOOKUP);

		// Create enums
		assignModeEEnum = createEEnum(ASSIGN_MODE);
		appSessionStatusEEnum = createEEnum(APP_SESSION_STATUS);

		// Create data types
		sessionEDataType = createEDataType(SESSION);
		httpServletRequestEDataType = createEDataType(HTTP_SERVLET_REQUEST);
		httpServletResponseEDataType = createEDataType(HTTP_SERVLET_RESPONSE);
		personEDataType = createEDataType(PERSON);
		securityManagerEDataType = createEDataType(SECURITY_MANAGER);
		entityLookupEDataType = createEDataType(ENTITY_LOOKUP);
		subjectEDataType = createEDataType(SUBJECT);
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
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(entityLookupEDataType, "T");
		ETypeParameter entityLookupEDataType_ID = addETypeParameter(entityLookupEDataType, "ID");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theCommonsPackage.getSerializable());
		entityLookupEDataType_ID.getEBounds().add(g1);

		// Add supertypes to classes
		roleEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		domainRoleEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		domainEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		actionEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		permissionEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		appSessionEClass.getESuperTypes().add(theCommonsPackage.getIdentifiable());
		appSessionEClass.getESuperTypes().add(theCommonsPackage.getTimestamped());
		appSessionEClass.getESuperTypes().add(theCommonsPackage.getSchemaVersionable());

		// Initialize classes and features; add operations and parameters
		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_Name(), ecorePackage.getEString(), "name", null, 1, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_Description(), ecorePackage.getEString(), "description", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRole_AssignMode(), this.getAssignMode(), "assignMode", "manual", 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainRoleEClass, DomainRole.class, "DomainRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainRole_Name(), ecorePackage.getEString(), "name", null, 1, 1, DomainRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainRole_Description(), ecorePackage.getEString(), "description", null, 0, 1, DomainRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainRole_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, DomainRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_Name(), ecorePackage.getEString(), "name", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_Description(), ecorePackage.getEString(), "description", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Name(), ecorePackage.getEString(), "name", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Global(), ecorePackage.getEBooleanObject(), "global", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Domains(), ecorePackage.getEString(), "domains", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Description(), ecorePackage.getEString(), "description", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityCatalogEClass, SecurityCatalog.class, "SecurityCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecurityCatalog_Roles(), this.getRole(), null, "roles", null, 0, -1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCatalog_InstanceRoles(), this.getDomainRole(), null, "instanceRoles", null, 0, -1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCatalog_Domains(), this.getDomain(), null, "domains", null, 0, -1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCatalog_Actions(), this.getAction(), null, "actions", null, 0, -1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCatalog_Permissions(), this.getPermission(), null, "permissions", null, 0, -1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCatalog_DomainPermissions(), this.getDomainPermission(), null, "domainPermissions", null, 0, 1, SecurityCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionEClass, Permission.class, "Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermission_Roles(), ecorePackage.getEString(), "roles", null, 0, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_DomainPermission(), ecorePackage.getEString(), "domainPermission", null, 1, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_ActionPermission(), ecorePackage.getEString(), "actionPermission", "", 1, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_InstancePermission(), ecorePackage.getEString(), "instancePermission", null, 1, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(permissionEClass, ecorePackage.getEString(), "toStringPermission", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(domainPermissionEClass, DomainPermission.class, "DomainPermission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainPermission_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, DomainPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainPermission_DomainRoles(), ecorePackage.getEString(), "domainRoles", null, 1, -1, DomainPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainPermission_Actions(), ecorePackage.getEString(), "actions", null, 1, -1, DomainPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appSessionEClass, AppSession.class, "AppSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppSession_Person(), theCommonsPackage.getPersonInfo(), null, "person", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_SchemaVersion(), theEcorePackage.getELong(), "schemaVersion", "2", 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_Status(), this.getAppSessionStatus(), "status", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_IpAddress(), theEcorePackage.getEString(), "ipAddress", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_Ipv6Address(), theEcorePackage.getEString(), "ipv6Address", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_IpAddresses(), theEcorePackage.getEString(), "ipAddresses", null, 0, -1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_Ipv6Addresses(), theEcorePackage.getEString(), "ipv6Addresses", null, 0, -1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_UserAgent(), theEcorePackage.getEString(), "userAgent", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_UserAgents(), theCommonsPackage.getList(), "userAgents", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppSession_Attributes(), this.getAppSessionAttributeEntry(), null, "attributes", null, 0, -1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_Timeout(), theEcorePackage.getELongObject(), "timeout", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_AccessTime(), theCommonsPackage.getDateTime(), "accessTime", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_ExpiryTime(), theCommonsPackage.getDateTime(), "expiryTime", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_TimeZone(), theCommonsPackage.getDateTimeZone(), "timeZone", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSession_Locale(), theCommonsPackage.getLocale(), "locale", null, 0, 1, AppSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(appSessionEClass, this.getSession(), "toSession", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(appSessionAttributeEntryEClass, Map.Entry.class, "AppSessionAttributeEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppSessionAttributeEntry_Key(), theEcorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppSessionAttributeEntry_Value(), theEcorePackage.getEJavaObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appSessionManagerEClass, AppSessionManager.class, "AppSessionManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppSessionManager_SecurityManager(), this.getSecurityManager(), "securityManager", null, 0, 1, AppSessionManager.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getEntityLookup());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getPerson());
		g2.setEUpperBound(g3);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getAppSessionManager_PersonLookup(), g1, "personLookup", null, 0, 1, AppSessionManager.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(appSessionManagerEClass, null, "requirePerson", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getPerson());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getHttpServletRequest(), "httpRequest", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getHttpServletResponse(), "httpResponse", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = addEOperation(appSessionManagerEClass, null, "requirePerson", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getPerson());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getSubject(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(assignModeEEnum, AssignMode.class, "AssignMode");
		addEEnumLiteral(assignModeEEnum, AssignMode.MANUAL);
		addEEnumLiteral(assignModeEEnum, AssignMode.GUEST);
		addEEnumLiteral(assignModeEEnum, AssignMode.AUTHENTICATED);

		initEEnum(appSessionStatusEEnum, AppSessionStatus.class, "AppSessionStatus");
		addEEnumLiteral(appSessionStatusEEnum, AppSessionStatus.ACTIVE);
		addEEnumLiteral(appSessionStatusEEnum, AppSessionStatus.INACTIVE);

		// Initialize data types
		initEDataType(sessionEDataType, Session.class, "Session", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(httpServletRequestEDataType, HttpServletRequest.class, "HttpServletRequest", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(httpServletResponseEDataType, HttpServletResponse.class, "HttpServletResponse", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(personEDataType, Person.class, "Person", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(securityManagerEDataType, org.apache.shiro.mgt.SecurityManager.class, "SecurityManager", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(entityLookupEDataType, EntityLookup.class, "EntityLookup", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(subjectEDataType, Subject.class, "Subject", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (roleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Roles contain global permissions."
		   });		
		addAnnotation
		  (getRole_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Name of role, e.g. \"admin\", \"sysadmin\", \"manager\", \"sales\", in lower_underscore format.\n\nThis corresponds directly to entries in ou=groups in LDAP."
		   });		
		addAnnotation
		  (domainRoleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Can be assigned to a person (security subject) in relation to a domain instance, e.g. \"manager\" of \"zibalabel\" \"shop\".\n\nmanager : instance role.\nzibalabel : instance.\nshop : domain.\n"
		   });		
		addAnnotation
		  (getDomainRole_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Name of instance role, e.g. \"admin\", \"sysadmin\", \"manager\", \"sales\", in lower_underscore format.\n\nThis corresponds directly to entries in ou=groups in LDAP."
		   });		
		addAnnotation
		  (getDomainRole_Domain(), 
		   source, 
		   new String[] {
			 "documentation", "Domain where this role applies to."
		   });		
		addAnnotation
		  (getDomain_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Name of the security domain (object class), e.g. \"shop\", \"person\", \"product\", in lower_underscore format."
		   });		
		addAnnotation
		  (getDomain_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Provides human-readable description."
		   });		
		addAnnotation
		  (actionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Secured action."
		   });		
		addAnnotation
		  (getAction_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Name of action, e.g. \"print\", \"edit\", in lower_underscore format."
		   });		
		addAnnotation
		  (getAction_Global(), 
		   source, 
		   new String[] {
			 "documentation", "Global actions apply to the whole application, in addition to domain instances (if specified)."
		   });		
		addAnnotation
		  (getAction_Domains(), 
		   source, 
		   new String[] {
			 "documentation", "The list of domains this action applies to."
		   });		
		addAnnotation
		  (getAction_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Provides human-readable purpose of the action."
		   });		
		addAnnotation
		  (securityCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains objects used to define security: roles, instance roles, domains, actions."
		   });		
		addAnnotation
		  (permissionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Format it as string usable by Shiro."
		   });		
		addAnnotation
		  (getPermission_Roles(), 
		   source, 
		   new String[] {
			 "documentation", "The roles this permission apply to."
		   });		
		addAnnotation
		  (getPermission_DomainPermission(), 
		   source, 
		   new String[] {
			 "documentation", "Name(s) of the domain, can be \"*\"."
		   });		
		addAnnotation
		  (getPermission_ActionPermission(), 
		   source, 
		   new String[] {
			 "documentation", "Name(s) of the action, can be \"*\"."
		   });		
		addAnnotation
		  (getPermission_InstancePermission(), 
		   source, 
		   new String[] {
			 "documentation", "Name(s) of the instance(s), can be \"*\".\n\nTo specify multiple parts, separate each with \":\".\ne.g.\ndomain=wink\naction=add\ninstance=hendy:car:nana\n\nmeans permit hendy to add wink for car to nana."
		   });		
		addAnnotation
		  (assignModeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Specify how a role should be assigned to a subject."
		   });		
		addAnnotation
		  (assignModeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Do not automatically assign this role."
		   });		
		addAnnotation
		  (assignModeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "This role is given to all subjects including guest (not logged in)."
		   });		
		addAnnotation
		  (assignModeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "This role is given to all remembered or authenticated users."
		   });		
		addAnnotation
		  (domainPermissionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permission for arbitrary instance of a single domain.\n\nTo express \"manager of shop X can edit shop X\" :\ndomain: shop\ninstanceRole: manager\naction: edit,delete\n\nMore complex use cases are not possible, and need a different and much more complex DSL, such as...\n\nTo express \"moderator of shop X can edit+delete comment * to shop X\"\ndomain: shop\ninstanceRole: moderator\naction: edit,delete\ntargetDomain: comment\ntargetInstance: *\n\nTo express \"wink_moderator of zibalabel can edit+delete wink * of product * for zibalabel\"\n\nTo express \"creator of comment X can edit+delete comment X for *\":\ninstanceRole: creator\ndomain: comment\naction: edit,delete\n\n"
		   });		
		addAnnotation
		  (getDomainPermission_Domain(), 
		   source, 
		   new String[] {
			 "documentation", "A simple (non-composite) domain this permission refers to.\n\nA composite domain example is \"comment-shop\" or \"wink-product-person\".\n"
		   });		
		addAnnotation
		  (getDomainPermission_Actions(), 
		   source, 
		   new String[] {
			 "documentation", "Action permissions given to subjects having the specified domain roles of a particular domain."
		   });		
		addAnnotation
		  (appSessionEClass, 
		   source, 
		   new String[] {
			 "documentation", "An OAuth app session.\n\nid is used as the accessToken.\n\nSee: https://sites.google.com/a/bippo.co.id/dev/berbatik/oauth\n"
		   });		
		addAnnotation
		  (getAppSession_IpAddress(), 
		   source, 
		   new String[] {
			 "documentation", "IPv4 Address during initial sign in."
		   });		
		addAnnotation
		  (getAppSession_Ipv6Address(), 
		   source, 
		   new String[] {
			 "documentation", "IPv6 address during initial sign in."
		   });		
		addAnnotation
		  (getAppSession_IpAddresses(), 
		   source, 
		   new String[] {
			 "documentation", "IPv4 Addresses used during the whole session."
		   });		
		addAnnotation
		  (getAppSession_Ipv6Addresses(), 
		   source, 
		   new String[] {
			 "documentation", "IPv6 Addresses used during the whole session."
		   });		
		addAnnotation
		  (getAppSession_UserAgents(), 
		   source, 
		   new String[] {
			 "documentation", "HTTP user agents used during the whole session."
		   });		
		addAnnotation
		  (getAppSession_Timeout(), 
		   source, 
		   new String[] {
			 "documentation", "Sets the time in milliseconds that the session may remain idle before expiring.\n<ul>\n <li>A negative value means the session will never expire.</li>\n <li>A non-negative value (0 or greater) means the session expiration will occur if idle for that\n length of time.</li>\n</ul>\n<p/>\n<b>*Note:</b> if you are used to the {@code HttpSession}\'s {@code getMaxInactiveInterval()} method, the scale on\nthis method is different: Shiro Sessions use millisecond values for timeout whereas\n{@code HttpSession.getMaxInactiveInterval} uses seconds.  Always use millisecond values with Shiro sessions.\n"
		   });		
		addAnnotation
		  (getAppSession_AccessTime(), 
		   source, 
		   new String[] {
			 "documentation", "Returns the last time the application received a request or method invocation from the user associated with this session.\nApplication calls to this method do not affect this access time."
		   });		
		addAnnotation
		  (getAppSession_ExpiryTime(), 
		   source, 
		   new String[] {
			 "documentation", "Returns the time that the session will expire (if it remains idle).\n\nIf there is activity, expiryTime may be extended.\n\n@see {@link getAccessTime()}"
		   });		
		addAnnotation
		  (appSessionManagerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Allows universal access to security Subject and derivatives (i.e. Person) from Wicket, JAX-RS, or other means."
		   });		
		addAnnotation
		  (appSessionManagerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", " Ensure personId is set. If not, throw Exception.\nThe IP Address and User Agent is required for security purposes.\nConvenience method for {@link #requirePerson(RequestIdentity)}."
		   });
	}

} //SecurityPackageImpl
