/**
 */
package org.soluvas.security.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecurityFactoryImpl extends EFactoryImpl implements SecurityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SecurityFactory init() {
		try {
			SecurityFactory theSecurityFactory = (SecurityFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/security/1.0"); 
			if (theSecurityFactory != null) {
				return theSecurityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SecurityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityFactoryImpl() {
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
			case SecurityPackage.ROLE: return createRole();
			case SecurityPackage.DOMAIN_ROLE: return createDomainRole();
			case SecurityPackage.DOMAIN: return createDomain();
			case SecurityPackage.ACTION: return createAction();
			case SecurityPackage.SECURITY_CATALOG: return createSecurityCatalog();
			case SecurityPackage.PERMISSION: return createPermission();
			case SecurityPackage.DOMAIN_PERMISSION: return createDomainPermission();
			case SecurityPackage.APP_SESSION: return createAppSession();
			case SecurityPackage.APP_SESSION_ATTRIBUTE_ENTRY: return (EObject)createAppSessionAttributeEntry();
			case SecurityPackage.APP_SESSION_MANAGER: return createAppSessionManager();
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
			case SecurityPackage.ASSIGN_MODE:
				return createAssignModeFromString(eDataType, initialValue);
			case SecurityPackage.APP_SESSION_STATUS:
				return createAppSessionStatusFromString(eDataType, initialValue);
			case SecurityPackage.SESSION:
				return createSessionFromString(eDataType, initialValue);
			case SecurityPackage.HTTP_SERVLET_REQUEST:
				return createHttpServletRequestFromString(eDataType, initialValue);
			case SecurityPackage.HTTP_SERVLET_RESPONSE:
				return createHttpServletResponseFromString(eDataType, initialValue);
			case SecurityPackage.PERSON:
				return createPersonFromString(eDataType, initialValue);
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
			case SecurityPackage.ASSIGN_MODE:
				return convertAssignModeToString(eDataType, instanceValue);
			case SecurityPackage.APP_SESSION_STATUS:
				return convertAppSessionStatusToString(eDataType, instanceValue);
			case SecurityPackage.SESSION:
				return convertSessionToString(eDataType, instanceValue);
			case SecurityPackage.HTTP_SERVLET_REQUEST:
				return convertHttpServletRequestToString(eDataType, instanceValue);
			case SecurityPackage.HTTP_SERVLET_RESPONSE:
				return convertHttpServletResponseToString(eDataType, instanceValue);
			case SecurityPackage.PERSON:
				return convertPersonToString(eDataType, instanceValue);
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
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainRole createDomainRole() {
		DomainRoleImpl domainRole = new DomainRoleImpl();
		return domainRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecurityCatalog createSecurityCatalog() {
		SecurityCatalogImpl securityCatalog = new SecurityCatalogImpl();
		return securityCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Permission createPermission() {
		PermissionImpl permission = new PermissionImpl();
		return permission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainPermission createDomainPermission() {
		DomainPermissionImpl domainPermission = new DomainPermissionImpl();
		return domainPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppSession createAppSession() {
		AppSessionImpl appSession = new AppSessionImpl();
		return appSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createAppSessionAttributeEntry() {
		AppSessionAttributeEntryImpl appSessionAttributeEntry = new AppSessionAttributeEntryImpl();
		return appSessionAttributeEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppSessionManager createAppSessionManager() {
		AppSessionManagerImpl appSessionManager = new AppSessionManagerImpl();
		return appSessionManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignMode createAssignModeFromString(EDataType eDataType, String initialValue) {
		AssignMode result = AssignMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppSessionStatus createAppSessionStatusFromString(EDataType eDataType, String initialValue) {
		AppSessionStatus result = AppSessionStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAppSessionStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session createSessionFromString(EDataType eDataType, String initialValue) {
		return (Session)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSessionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServletRequest createHttpServletRequestFromString(EDataType eDataType, String initialValue) {
		return (HttpServletRequest)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHttpServletRequestToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServletResponse createHttpServletResponseFromString(EDataType eDataType, String initialValue) {
		return (HttpServletResponse)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHttpServletResponseToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPersonFromString(EDataType eDataType, String initialValue) {
		return (Person)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPersonToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SecurityPackage getSecurityPackage() {
		return (SecurityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SecurityPackage getPackage() {
		return SecurityPackage.eINSTANCE;
	}

} //SecurityFactoryImpl
