/**
 */
package org.soluvas.email.impl;

import org.apache.commons.mail.Email;
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
import org.soluvas.email.DefaultScope;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.EmailFormat;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.TemplateType;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;
import org.soluvas.email.Recipient;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderLike;
import org.soluvas.email.SenderType;
import org.soluvas.email.Template;
import org.soluvas.email.TemplateLike;
import org.soluvas.email.WebSecurity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmailPackageImpl extends EPackageImpl implements EmailPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emailCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recipientEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emailManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senderTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass senderLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum emailFormatEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum webSecurityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType emailEDataType = null;

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
	 * @see org.soluvas.email.EmailPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmailPackageImpl() {
		super(eNS_URI, EmailFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EmailPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmailPackage init() {
		if (isInited) return (EmailPackage)EPackage.Registry.INSTANCE.getEPackage(EmailPackage.eNS_URI);

		// Obtain or create and register package
		EmailPackageImpl theEmailPackage = (EmailPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmailPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmailPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEmailPackage.createPackageContents();

		// Initialize created meta-data
		theEmailPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmailPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmailPackage.eNS_URI, theEmailPackage);
		return theEmailPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmailCatalog() {
		return emailCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmailCatalog_PageTypes() {
		return (EReference)emailCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmailCatalog_LayoutTypes() {
		return (EReference)emailCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmailCatalog_SenderTypes() {
		return (EReference)emailCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateType() {
		return templateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPageType() {
		return pageTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplate_Recipients() {
		return (EReference)templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLayoutType() {
		return layoutTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecipient() {
		return recipientEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_Email() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_Name() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_FirstName() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_LastName() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_PreferredFormat() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecipient_PreferredWebSecurity() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRecipient_RoleName() {
		return (EAttribute)recipientEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLayout() {
		return layoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLayout_PageSubject() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLayout_PagePlain() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLayout_PageHtml() {
		return (EAttribute)layoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayout_LayoutType() {
		return (EReference)layoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPage() {
		return pageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPage_Layout() {
		return (EReference)pageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPage_PageType() {
		return (EReference)pageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateLike() {
		return templateLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplateLike_SubjectTemplate() {
		return (EAttribute)templateLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplateLike_PlainTemplate() {
		return (EAttribute)templateLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemplateLike_HtmlTemplate() {
		return (EAttribute)templateLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmailManager() {
		return emailManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSender() {
		return senderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSender_SenderType() {
		return (EReference)senderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSenderType() {
		return senderTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSenderLike() {
		return senderLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSenderLike_From() {
		return (EAttribute)senderLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSenderLike_Email() {
		return (EAttribute)senderLikeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSenderLike_ReplyTo() {
		return (EAttribute)senderLikeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultScope() {
		return defaultScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultScope_WebAddress() {
		return (EReference)defaultScopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultScope_AppManifest() {
		return (EReference)defaultScopeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEmailFormat() {
		return emailFormatEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWebSecurity() {
		return webSecurityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEmail() {
		return emailEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmailFactory getEmailFactory() {
		return (EmailFactory)getEFactoryInstance();
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
		emailCatalogEClass = createEClass(EMAIL_CATALOG);
		createEReference(emailCatalogEClass, EMAIL_CATALOG__PAGE_TYPES);
		createEReference(emailCatalogEClass, EMAIL_CATALOG__LAYOUT_TYPES);
		createEReference(emailCatalogEClass, EMAIL_CATALOG__SENDER_TYPES);

		templateTypeEClass = createEClass(TEMPLATE_TYPE);

		pageTypeEClass = createEClass(PAGE_TYPE);

		layoutTypeEClass = createEClass(LAYOUT_TYPE);

		templateEClass = createEClass(TEMPLATE);
		createEReference(templateEClass, TEMPLATE__RECIPIENTS);

		recipientEClass = createEClass(RECIPIENT);
		createEAttribute(recipientEClass, RECIPIENT__EMAIL);
		createEAttribute(recipientEClass, RECIPIENT__NAME);
		createEAttribute(recipientEClass, RECIPIENT__FIRST_NAME);
		createEAttribute(recipientEClass, RECIPIENT__LAST_NAME);
		createEAttribute(recipientEClass, RECIPIENT__ROLE_NAME);
		createEAttribute(recipientEClass, RECIPIENT__PREFERRED_FORMAT);
		createEAttribute(recipientEClass, RECIPIENT__PREFERRED_WEB_SECURITY);

		layoutEClass = createEClass(LAYOUT);
		createEAttribute(layoutEClass, LAYOUT__PAGE_SUBJECT);
		createEAttribute(layoutEClass, LAYOUT__PAGE_PLAIN);
		createEAttribute(layoutEClass, LAYOUT__PAGE_HTML);
		createEReference(layoutEClass, LAYOUT__LAYOUT_TYPE);

		pageEClass = createEClass(PAGE);
		createEReference(pageEClass, PAGE__LAYOUT);
		createEReference(pageEClass, PAGE__PAGE_TYPE);

		templateLikeEClass = createEClass(TEMPLATE_LIKE);
		createEAttribute(templateLikeEClass, TEMPLATE_LIKE__SUBJECT_TEMPLATE);
		createEAttribute(templateLikeEClass, TEMPLATE_LIKE__PLAIN_TEMPLATE);
		createEAttribute(templateLikeEClass, TEMPLATE_LIKE__HTML_TEMPLATE);

		emailManagerEClass = createEClass(EMAIL_MANAGER);

		senderEClass = createEClass(SENDER);
		createEReference(senderEClass, SENDER__SENDER_TYPE);

		senderTypeEClass = createEClass(SENDER_TYPE);

		senderLikeEClass = createEClass(SENDER_LIKE);
		createEAttribute(senderLikeEClass, SENDER_LIKE__FROM);
		createEAttribute(senderLikeEClass, SENDER_LIKE__EMAIL);
		createEAttribute(senderLikeEClass, SENDER_LIKE__REPLY_TO);

		defaultScopeEClass = createEClass(DEFAULT_SCOPE);
		createEReference(defaultScopeEClass, DEFAULT_SCOPE__WEB_ADDRESS);
		createEReference(defaultScopeEClass, DEFAULT_SCOPE__APP_MANIFEST);

		// Create enums
		emailFormatEEnum = createEEnum(EMAIL_FORMAT);
		webSecurityEEnum = createEEnum(WEB_SECURITY);

		// Create data types
		emailEDataType = createEDataType(EMAIL);
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
		ETypeParameter templateTypeEClass_T = addETypeParameter(templateTypeEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getTemplate());
		templateTypeEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		emailCatalogEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		g1 = createEGenericType(theCommonsPackage.getResourceAware());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNameContainer());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTemplateLike());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNsPrefixable());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		EGenericType g2 = createEGenericType(templateTypeEClass_T);
		g1.getETypeArguments().add(g2);
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEFactoryLinked());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		templateTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTemplateType());
		g2 = createEGenericType(this.getPage());
		g1.getETypeArguments().add(g2);
		pageTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTemplateType());
		g2 = createEGenericType(this.getLayout());
		g1.getETypeArguments().add(g2);
		layoutTypeEClass.getEGenericSuperTypes().add(g1);
		templateEClass.getESuperTypes().add(this.getTemplateLike());
		templateEClass.getESuperTypes().add(this.getDefaultScope());
		layoutEClass.getESuperTypes().add(this.getTemplate());
		pageEClass.getESuperTypes().add(this.getTemplate());
		senderEClass.getESuperTypes().add(this.getSenderLike());
		senderEClass.getESuperTypes().add(this.getDefaultScope());
		g1 = createEGenericType(theCommonsPackage.getNameContainer());
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getBundleAware());
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getNsPrefixable());
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEClassLinked());
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getJavaClassLinked());
		g2 = createEGenericType(this.getSender());
		g1.getETypeArguments().add(g2);
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getEFactoryLinked());
		senderTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSenderLike());
		senderTypeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(emailCatalogEClass, EmailCatalog.class, "EmailCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmailCatalog_PageTypes(), this.getPageType(), null, "pageTypes", null, 0, -1, EmailCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmailCatalog_LayoutTypes(), this.getLayoutType(), null, "layoutTypes", null, 0, -1, EmailCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmailCatalog_SenderTypes(), this.getSenderType(), null, "senderTypes", null, 0, -1, EmailCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateTypeEClass, TemplateType.class, "TemplateType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageTypeEClass, PageType.class, "PageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(pageTypeEClass, this.getPage(), "create", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLayout(), "layout", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(layoutTypeEClass, LayoutType.class, "LayoutType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(layoutTypeEClass, this.getLayout(), "create", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(templateEClass, Template.class, "Template", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplate_Recipients(), this.getRecipient(), null, "recipients", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(templateEClass, theEcorePackage.getEString(), "renderSubject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRecipient(), "recipient", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(templateEClass, theEcorePackage.getEString(), "renderText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRecipient(), "recipient", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(templateEClass, theEcorePackage.getEString(), "renderHtml", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRecipient(), "recipient", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(recipientEClass, Recipient.class, "Recipient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecipient_Email(), theEcorePackage.getEString(), "email", null, 1, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_Name(), theEcorePackage.getEString(), "name", null, 1, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_FirstName(), theEcorePackage.getEString(), "firstName", null, 0, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_LastName(), theEcorePackage.getEString(), "lastName", null, 0, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_RoleName(), theEcorePackage.getEString(), "roleName", null, 0, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_PreferredFormat(), this.getEmailFormat(), "preferredFormat", null, 0, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecipient_PreferredWebSecurity(), this.getWebSecurity(), "preferredWebSecurity", null, 0, 1, Recipient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(layoutEClass, Layout.class, "Layout", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayout_PageSubject(), theEcorePackage.getEString(), "pageSubject", null, 1, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_PagePlain(), theEcorePackage.getEString(), "pagePlain", null, 1, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayout_PageHtml(), theEcorePackage.getEString(), "pageHtml", null, 1, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLayout_LayoutType(), this.getLayoutType(), null, "layoutType", null, 1, 1, Layout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageEClass, Page.class, "Page", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPage_Layout(), this.getLayout(), null, "layout", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPage_PageType(), this.getPageType(), null, "pageType", null, 1, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(pageEClass, this.getEmail(), "compose", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRecipient(), "recipient", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pageEClass, null, "composeAll", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getList());
		g2 = createEGenericType(this.getEmail());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(templateLikeEClass, TemplateLike.class, "TemplateLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateLike_SubjectTemplate(), theEcorePackage.getEString(), "subjectTemplate", null, 0, 1, TemplateLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateLike_PlainTemplate(), theEcorePackage.getEString(), "plainTemplate", null, 0, 1, TemplateLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateLike_HtmlTemplate(), theEcorePackage.getEString(), "htmlTemplate", null, 0, 1, TemplateLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emailManagerEClass, EmailManager.class, "EmailManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(emailManagerEClass, null, "createPage", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getPage());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaClass());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "pageClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(senderEClass, Sender.class, "Sender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSender_SenderType(), this.getSenderType(), null, "senderType", null, 1, 1, Sender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(senderTypeEClass, SenderType.class, "SenderType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(senderLikeEClass, SenderLike.class, "SenderLike", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSenderLike_From(), theEcorePackage.getEString(), "from", null, 0, 1, SenderLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSenderLike_Email(), theEcorePackage.getEString(), "email", null, 0, 1, SenderLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSenderLike_ReplyTo(), theEcorePackage.getEString(), "replyTo", null, 0, 1, SenderLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultScopeEClass, DefaultScope.class, "DefaultScope", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultScope_WebAddress(), theCommonsPackage.getWebAddress(), null, "webAddress", null, 0, 1, DefaultScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultScope_AppManifest(), theCommonsPackage.getAppManifest(), null, "appManifest", null, 0, 1, DefaultScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(emailFormatEEnum, EmailFormat.class, "EmailFormat");
		addEEnumLiteral(emailFormatEEnum, EmailFormat.MULTIPART);
		addEEnumLiteral(emailFormatEEnum, EmailFormat.PLAIN);
		addEEnumLiteral(emailFormatEEnum, EmailFormat.HTML);

		initEEnum(webSecurityEEnum, WebSecurity.class, "WebSecurity");
		addEEnumLiteral(webSecurityEEnum, WebSecurity.PREFER_SECURE);
		addEEnumLiteral(webSecurityEEnum, WebSecurity.ALWAYS_SECURE);
		addEEnumLiteral(webSecurityEEnum, WebSecurity.ALWAYS_UNSECURE);

		// Initialize data types
		initEDataType(emailEDataType, Email.class, "Email", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (pageTypeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create Page using the specified layout."
		   });		
		addAnnotation
		  (templateEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Render the subject."
		   });		
		addAnnotation
		  (templateEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Render body using text/plain format."
		   });		
		addAnnotation
		  (templateEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Render body using text/html format."
		   });		
		addAnnotation
		  (getRecipient_RoleName(), 
		   source, 
		   new String[] {
			 "documentation", "Role e.g. \"administrator\", \"sales staff for O Batiks\"."
		   });		
		addAnnotation
		  (getLayout_PageSubject(), 
		   source, 
		   new String[] {
			 "documentation", "Rendered subject by Page, to be used as input for the layout."
		   });		
		addAnnotation
		  (getLayout_PagePlain(), 
		   source, 
		   new String[] {
			 "documentation", "Rendered text/plain content by Page, to be used as input for the layout."
		   });		
		addAnnotation
		  (getLayout_PageHtml(), 
		   source, 
		   new String[] {
			 "documentation", "Rendered text/html content by Page, to be used as input for the layout."
		   });		
		addAnnotation
		  (pageEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Compose an Email to a recipient, using the provided layout."
		   });		
		addAnnotation
		  (pageEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Compose emails based on attributes, using the provided layout."
		   });		
		addAnnotation
		  (getTemplateLike_SubjectTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "Some subjects include tracking ID, e.g.\n\n<pre>[#MCV-529-28864]: Email forwarding not working</pre>\n\n<p>Such subject would use this template:\n\n<pre>[#{{{ticket.formalId}}}]: {{{ticket.subject}}}</pre>\n\n<p>It\'s not recommended to put company name in the subject. Best practice is to put the company name as Sender\'s name, optionally suffixed with \"Support\" etc. Also, most services (Facebook, NameCheap) do not put the recipient name in the subject."
		   });		
		addAnnotation
		  (getTemplateLike_PlainTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "Plain text template."
		   });		
		addAnnotation
		  (getTemplateLike_HtmlTemplate(), 
		   source, 
		   new String[] {
			 "documentation", "If this is null, the html template will be synthesized from plain template."
		   });		
		addAnnotation
		  (webSecurityEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Preference between URIs will use unsecure HTTP or secured HTTPS."
		   });		
		addAnnotation
		  (webSecurityEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Prefer HTTPS for sensitive content (recommended)."
		   });		
		addAnnotation
		  (webSecurityEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Always use secure HTTPS for all content, including content with publicly available URIs. (slows down)"
		   });		
		addAnnotation
		  (webSecurityEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Always use plain HTTP for all content, including content with sensitive URIs. (not recommended, but sometimes required for older mobile devices, or for development purposes.)"
		   });		
		addAnnotation
		  (emailManagerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Create an email Page using the tenant-wide default layout."
		   });		
		addAnnotation
		  (senderEClass, 
		   source, 
		   new String[] {
			 "documentation", "Sender information. Mustache variables are supported."
		   });		
		addAnnotation
		  (getSenderLike_From(), 
		   source, 
		   new String[] {
			 "documentation", "Best practice is to put the company name as Sender\'s name, optionally suffixed with \"Support\" etc.\n\n<p>Most notifications should consist only of company name. Actual conversations with support (i.e. tickets) would be suffixed with \"Support\"."
		   });		
		addAnnotation
		  (getSenderLike_Email(), 
		   source, 
		   new String[] {
			 "documentation", "Email address of the sender. This can be:\n\n<ol>\n<li>a fully static text, e.g. \"support@berbatik.com\", very seldom used</li>\n<li>a variable, e.g. \"{{{generalEmail}}}\", most common</li>\n<li>a partial variable, e.g. \"support@{{{appManifest.domain}}}\", sometimes used</li>\n<li>multiple variables for randomly generated drop boxes, e.g. \"{{{dropbox.code}}}@{{{postEmailDomain}}}\" or \"{{{dropbox.code}}}@post.{{{appManifest.domain}}}\", which expands to \"yummy234food@post.berbatik.com\"</li>\n<li>a tracking address, e.g. \"notification+mwkuhkji@facebookmail.com\". Template is: \"notification+{{{tracker.code}}}@notification.{{{appManifest.domain}}}\" or \"notification+{{{tracker.code}}}@{{{notificationEmailDomain}}}\"</li>\n\n<p>WARNING: A suffix like \"+something\" is not recommended for non-tracking emails, some mail servers like NameCheap email forwarding does not support it, and many email forms do not accept \"+\"."
		   });
	}

} //EmailPackageImpl
