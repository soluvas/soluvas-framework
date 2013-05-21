/**
 */
package org.soluvas.email.impl;

import org.apache.commons.mail.Email;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.email.*;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.EmailFormat;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.LayoutType;
import org.soluvas.email.PageType;
import org.soluvas.email.Recipient;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderType;
import org.soluvas.email.WebSecurity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmailFactoryImpl extends EFactoryImpl implements EmailFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmailFactory init() {
		try {
			EmailFactory theEmailFactory = (EmailFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/email/1.0"); 
			if (theEmailFactory != null) {
				return theEmailFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmailFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailFactoryImpl() {
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
			case EmailPackage.EMAIL_CATALOG: return (EObject)createEmailCatalog();
			case EmailPackage.PAGE_TYPE: return (EObject)createPageType();
			case EmailPackage.LAYOUT_TYPE: return (EObject)createLayoutType();
			case EmailPackage.RECIPIENT: return (EObject)createRecipient();
			case EmailPackage.EMAIL_MANAGER: return (EObject)createEmailManager();
			case EmailPackage.SENDER: return (EObject)createSender();
			case EmailPackage.SENDER_TYPE: return (EObject)createSenderType();
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
			case EmailPackage.EMAIL_FORMAT:
				return createEmailFormatFromString(eDataType, initialValue);
			case EmailPackage.WEB_SECURITY:
				return createWebSecurityFromString(eDataType, initialValue);
			case EmailPackage.EMAIL_SECURITY:
				return createEmailSecurityFromString(eDataType, initialValue);
			case EmailPackage.EMAIL:
				return createEmailFromString(eDataType, initialValue);
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
			case EmailPackage.EMAIL_FORMAT:
				return convertEmailFormatToString(eDataType, instanceValue);
			case EmailPackage.WEB_SECURITY:
				return convertWebSecurityToString(eDataType, instanceValue);
			case EmailPackage.EMAIL_SECURITY:
				return convertEmailSecurityToString(eDataType, instanceValue);
			case EmailPackage.EMAIL:
				return convertEmailToString(eDataType, instanceValue);
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
	public EmailCatalog createEmailCatalog() {
		EmailCatalogImpl emailCatalog = new EmailCatalogImpl();
		return emailCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageType createPageType() {
		PageTypeImpl pageType = new PageTypeImpl();
		return pageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LayoutType createLayoutType() {
		LayoutTypeImpl layoutType = new LayoutTypeImpl();
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Recipient createRecipient() {
		RecipientImpl recipient = new RecipientImpl();
		return recipient;
	}
	
	@Override
	public Recipient createRecipient(String name, String email, String roleName) {
		final Recipient recipient = createRecipient();
		recipient.setName(name);
		final PersonName splitName = NameUtils.splitName(name);
		recipient.setFirstName(splitName.getFirstName());
		recipient.setLastName(splitName.getLastName());
		recipient.setEmail(email);
		recipient.setRoleName(roleName);
		return recipient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmailManager createEmailManager() {
		EmailManagerImpl emailManager = new EmailManagerImpl();
		return emailManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sender createSender() {
		SenderImpl sender = new SenderImpl();
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenderType createSenderType() {
		SenderTypeImpl senderType = new SenderTypeImpl();
		return senderType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailFormat createEmailFormatFromString(EDataType eDataType, String initialValue) {
		EmailFormat result = EmailFormat.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmailFormatToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebSecurity createWebSecurityFromString(EDataType eDataType, String initialValue) {
		WebSecurity result = WebSecurity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWebSecurityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailSecurity createEmailSecurityFromString(EDataType eDataType, String initialValue) {
		EmailSecurity result = EmailSecurity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmailSecurityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Email createEmailFromString(EDataType eDataType, String initialValue) {
		return (Email)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmailToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmailPackage getEmailPackage() {
		return (EmailPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EmailPackage getPackage() {
		return EmailPackage.eINSTANCE;
	}
	
	public static EmailFactory getInstance() {
		return EmailFactory.eINSTANCE;
	}

} //EmailFactoryImpl
