/**
 */
package org.soluvas.email;

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
 * @see org.soluvas.email.EmailFactory
 * @model kind="package"
 * @generated
 */
public interface EmailPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "email";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/email/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "email";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailPackage eINSTANCE = org.soluvas.email.impl.EmailPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.EmailCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.EmailCatalogImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailCatalog()
	 * @generated
	 */
	int EMAIL_CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Page Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__PAGE_TYPES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layout Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__LAYOUT_TYPES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sender Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__SENDER_TYPES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Generated Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__GENERATED_PACKAGE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__EPACKAGE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__EFACTORY = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.TemplateTypeImpl <em>Template Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.TemplateTypeImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplateType()
	 * @generated
	 */
	int TEMPLATE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__RESOURCE_TYPE = CommonsPackage.RESOURCE_AWARE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__RESOURCE_URI = CommonsPackage.RESOURCE_AWARE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__RESOURCE_NAME = CommonsPackage.RESOURCE_AWARE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__BUNDLE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__SUBJECT_TEMPLATE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__PLAIN_TEMPLATE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__HTML_TEMPLATE = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__JAVA_CLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__JAVA_CLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__JAVA_CLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__EFACTORY = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__ECLASS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__ECLASS_STATUS = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__EPACKAGE_NS_PREFIX = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__ECLASS_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__EPACKAGE_NAME = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Template Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE_FEATURE_COUNT = CommonsPackage.RESOURCE_AWARE_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.PageTypeImpl <em>Page Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.PageTypeImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getPageType()
	 * @generated
	 */
	int PAGE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__RESOURCE_TYPE = TEMPLATE_TYPE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__RESOURCE_URI = TEMPLATE_TYPE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__RESOURCE_NAME = TEMPLATE_TYPE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__BUNDLE = TEMPLATE_TYPE__BUNDLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__NAME = TEMPLATE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__SUBJECT_TEMPLATE = TEMPLATE_TYPE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__PLAIN_TEMPLATE = TEMPLATE_TYPE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__HTML_TEMPLATE = TEMPLATE_TYPE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__NS_PREFIX = TEMPLATE_TYPE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__JAVA_CLASS_NAME = TEMPLATE_TYPE__JAVA_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__JAVA_CLASS = TEMPLATE_TYPE__JAVA_CLASS;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__JAVA_CLASS_STATUS = TEMPLATE_TYPE__JAVA_CLASS_STATUS;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__EFACTORY = TEMPLATE_TYPE__EFACTORY;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__ECLASS = TEMPLATE_TYPE__ECLASS;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__ECLASS_STATUS = TEMPLATE_TYPE__ECLASS_STATUS;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__EPACKAGE_NS_PREFIX = TEMPLATE_TYPE__EPACKAGE_NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__ECLASS_NAME = TEMPLATE_TYPE__ECLASS_NAME;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__EPACKAGE_NAME = TEMPLATE_TYPE__EPACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Sender Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE__SENDER_TYPE_NAME = TEMPLATE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Page Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE_FEATURE_COUNT = TEMPLATE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.TemplateImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 4;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.LayoutTypeImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getLayoutType()
	 * @generated
	 */
	int LAYOUT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__RESOURCE_TYPE = TEMPLATE_TYPE__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__RESOURCE_URI = TEMPLATE_TYPE__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__RESOURCE_NAME = TEMPLATE_TYPE__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__BUNDLE = TEMPLATE_TYPE__BUNDLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__NAME = TEMPLATE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__SUBJECT_TEMPLATE = TEMPLATE_TYPE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__PLAIN_TEMPLATE = TEMPLATE_TYPE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__HTML_TEMPLATE = TEMPLATE_TYPE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__NS_PREFIX = TEMPLATE_TYPE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__JAVA_CLASS_NAME = TEMPLATE_TYPE__JAVA_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__JAVA_CLASS = TEMPLATE_TYPE__JAVA_CLASS;

	/**
	 * The feature id for the '<em><b>Java Class Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__JAVA_CLASS_STATUS = TEMPLATE_TYPE__JAVA_CLASS_STATUS;

	/**
	 * The feature id for the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__EFACTORY = TEMPLATE_TYPE__EFACTORY;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__ECLASS = TEMPLATE_TYPE__ECLASS;

	/**
	 * The feature id for the '<em><b>EClass Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__ECLASS_STATUS = TEMPLATE_TYPE__ECLASS_STATUS;

	/**
	 * The feature id for the '<em><b>EPackage Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__EPACKAGE_NS_PREFIX = TEMPLATE_TYPE__EPACKAGE_NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__ECLASS_NAME = TEMPLATE_TYPE__ECLASS_NAME;

	/**
	 * The feature id for the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__EPACKAGE_NAME = TEMPLATE_TYPE__EPACKAGE_NAME;

	/**
	 * The number of structural features of the '<em>Layout Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE_FEATURE_COUNT = TEMPLATE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.RecipientImpl <em>Recipient</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.RecipientImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getRecipient()
	 * @generated
	 */
	int RECIPIENT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.LayoutImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 6;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.PageImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 7;

	/**
	 * The meta object id for the '{@link org.soluvas.email.TemplateLike <em>Template Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.TemplateLike
	 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplateLike()
	 * @generated
	 */
	int TEMPLATE_LIKE = 8;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_LIKE__SUBJECT_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_LIKE__PLAIN_TEMPLATE = 1;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_LIKE__HTML_TEMPLATE = 2;

	/**
	 * The number of structural features of the '<em>Template Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_LIKE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__SUBJECT_TEMPLATE = TEMPLATE_LIKE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__PLAIN_TEMPLATE = TEMPLATE_LIKE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__HTML_TEMPLATE = TEMPLATE_LIKE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__WEB_ADDRESS = TEMPLATE_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__APP_MANIFEST = TEMPLATE_LIKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__RECIPIENTS = TEMPLATE_LIKE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = TEMPLATE_LIKE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__EMAIL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__FIRST_NAME = 2;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__LAST_NAME = 3;

	/**
	 * The feature id for the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__ROLE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Preferred Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__PREFERRED_FORMAT = 5;

	/**
	 * The feature id for the '<em><b>Preferred Web Security</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT__PREFERRED_WEB_SECURITY = 6;

	/**
	 * The number of structural features of the '<em>Recipient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIPIENT_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__SUBJECT_TEMPLATE = TEMPLATE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__PLAIN_TEMPLATE = TEMPLATE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__HTML_TEMPLATE = TEMPLATE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__WEB_ADDRESS = TEMPLATE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__APP_MANIFEST = TEMPLATE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__RECIPIENTS = TEMPLATE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Page Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__PAGE_SUBJECT = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Page Plain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__PAGE_PLAIN = TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Page Html</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__PAGE_HTML = TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__LAYOUT_TYPE = TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__SUBJECT_TEMPLATE = TEMPLATE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PLAIN_TEMPLATE = TEMPLATE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__HTML_TEMPLATE = TEMPLATE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__WEB_ADDRESS = TEMPLATE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__APP_MANIFEST = TEMPLATE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__RECIPIENTS = TEMPLATE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__LAYOUT = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Page Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PAGE_TYPE = TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__SENDER = TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__MAIL_SESSION = TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.EmailManagerImpl <em>Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.EmailManagerImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailManager()
	 * @generated
	 */
	int EMAIL_MANAGER = 9;

	/**
	 * The feature id for the '<em><b>Smtp User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER__SMTP_USER = 0;

	/**
	 * The feature id for the '<em><b>Smtp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER__SMTP_PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Smtp Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER__SMTP_HOST = 2;

	/**
	 * The feature id for the '<em><b>Smtp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER__SMTP_PORT = 3;

	/**
	 * The feature id for the '<em><b>Smtp Security</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER__SMTP_SECURITY = 4;

	/**
	 * The number of structural features of the '<em>Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_MANAGER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.email.SenderLike <em>Sender Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.SenderLike
	 * @see org.soluvas.email.impl.EmailPackageImpl#getSenderLike()
	 * @generated
	 */
	int SENDER_LIKE = 12;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_LIKE__FROM = 0;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_LIKE__EMAIL = 1;

	/**
	 * The feature id for the '<em><b>Reply To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_LIKE__REPLY_TO = 2;

	/**
	 * The number of structural features of the '<em>Sender Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_LIKE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.SenderImpl <em>Sender</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.SenderImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getSender()
	 * @generated
	 */
	int SENDER = 10;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__FROM = SENDER_LIKE__FROM;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__EMAIL = SENDER_LIKE__EMAIL;

	/**
	 * The feature id for the '<em><b>Reply To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__REPLY_TO = SENDER_LIKE__REPLY_TO;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__WEB_ADDRESS = SENDER_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__APP_MANIFEST = SENDER_LIKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sender Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER__SENDER_TYPE = SENDER_LIKE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sender</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_FEATURE_COUNT = SENDER_LIKE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.soluvas.email.impl.SenderTypeImpl <em>Sender Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.impl.SenderTypeImpl
	 * @see org.soluvas.email.impl.EmailPackageImpl#getSenderType()
	 * @generated
	 */
	int SENDER_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__BUNDLE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__FROM = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__EMAIL = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reply To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE__REPLY_TO = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sender Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENDER_TYPE_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.email.DefaultScope <em>Default Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.DefaultScope
	 * @see org.soluvas.email.impl.EmailPackageImpl#getDefaultScope()
	 * @generated
	 */
	int DEFAULT_SCOPE = 13;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_SCOPE__WEB_ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_SCOPE__APP_MANIFEST = 1;

	/**
	 * The number of structural features of the '<em>Default Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_SCOPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.email.EmailFormat <em>Format</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.EmailFormat
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailFormat()
	 * @generated
	 */
	int EMAIL_FORMAT = 14;

	/**
	 * The meta object id for the '{@link org.soluvas.email.WebSecurity <em>Web Security</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.WebSecurity
	 * @see org.soluvas.email.impl.EmailPackageImpl#getWebSecurity()
	 * @generated
	 */
	int WEB_SECURITY = 15;

	/**
	 * The meta object id for the '{@link org.soluvas.email.EmailSecurity <em>Security</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.EmailSecurity
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailSecurity()
	 * @generated
	 */
	int EMAIL_SECURITY = 16;

	/**
	 * The meta object id for the '<em>Email</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.commons.mail.Email
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmail()
	 * @generated
	 */
	int EMAIL = 17;

	/**
	 * The meta object id for the '<em>Mail Session</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.mail.Session
	 * @see org.soluvas.email.impl.EmailPackageImpl#getMailSession()
	 * @generated
	 */
	int MAIL_SESSION = 18;

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.EmailCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.email.EmailCatalog
	 * @generated
	 */
	EClass getEmailCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.email.EmailCatalog#getPageTypes <em>Page Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Types</em>'.
	 * @see org.soluvas.email.EmailCatalog#getPageTypes()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_PageTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.email.EmailCatalog#getLayoutTypes <em>Layout Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layout Types</em>'.
	 * @see org.soluvas.email.EmailCatalog#getLayoutTypes()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_LayoutTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.email.EmailCatalog#getSenderTypes <em>Sender Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sender Types</em>'.
	 * @see org.soluvas.email.EmailCatalog#getSenderTypes()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_SenderTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailCatalog#getGeneratedPackageName <em>Generated Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated Package Name</em>'.
	 * @see org.soluvas.email.EmailCatalog#getGeneratedPackageName()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EAttribute getEmailCatalog_GeneratedPackageName();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.EmailCatalog#getEPackage <em>EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EPackage</em>'.
	 * @see org.soluvas.email.EmailCatalog#getEPackage()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_EPackage();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.EmailCatalog#getEFactory <em>EFactory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EFactory</em>'.
	 * @see org.soluvas.email.EmailCatalog#getEFactory()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_EFactory();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.TemplateType <em>Template Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Type</em>'.
	 * @see org.soluvas.email.TemplateType
	 * @generated
	 */
	EClass getTemplateType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.PageType <em>Page Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Type</em>'.
	 * @see org.soluvas.email.PageType
	 * @generated
	 */
	EClass getPageType();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.PageType#getSenderTypeName <em>Sender Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sender Type Name</em>'.
	 * @see org.soluvas.email.PageType#getSenderTypeName()
	 * @see #getPageType()
	 * @generated
	 */
	EAttribute getPageType_SenderTypeName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.soluvas.email.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.email.Template#getRecipients <em>Recipients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Recipients</em>'.
	 * @see org.soluvas.email.Template#getRecipients()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Recipients();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.LayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Type</em>'.
	 * @see org.soluvas.email.LayoutType
	 * @generated
	 */
	EClass getLayoutType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.Recipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recipient</em>'.
	 * @see org.soluvas.email.Recipient
	 * @generated
	 */
	EClass getRecipient();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.soluvas.email.Recipient#getEmail()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_Email();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.email.Recipient#getName()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.soluvas.email.Recipient#getFirstName()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.soluvas.email.Recipient#getLastName()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_LastName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getPreferredFormat <em>Preferred Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Format</em>'.
	 * @see org.soluvas.email.Recipient#getPreferredFormat()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_PreferredFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getPreferredWebSecurity <em>Preferred Web Security</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Web Security</em>'.
	 * @see org.soluvas.email.Recipient#getPreferredWebSecurity()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_PreferredWebSecurity();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Recipient#getRoleName <em>Role Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Name</em>'.
	 * @see org.soluvas.email.Recipient#getRoleName()
	 * @see #getRecipient()
	 * @generated
	 */
	EAttribute getRecipient_RoleName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see org.soluvas.email.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Layout#getPageSubject <em>Page Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Subject</em>'.
	 * @see org.soluvas.email.Layout#getPageSubject()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_PageSubject();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Layout#getPagePlain <em>Page Plain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Plain</em>'.
	 * @see org.soluvas.email.Layout#getPagePlain()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_PagePlain();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Layout#getPageHtml <em>Page Html</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Html</em>'.
	 * @see org.soluvas.email.Layout#getPageHtml()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_PageHtml();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Layout#getLayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout Type</em>'.
	 * @see org.soluvas.email.Layout#getLayoutType()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_LayoutType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see org.soluvas.email.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Page#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout</em>'.
	 * @see org.soluvas.email.Page#getLayout()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Layout();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Page#getPageType <em>Page Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Page Type</em>'.
	 * @see org.soluvas.email.Page#getPageType()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_PageType();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Page#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender</em>'.
	 * @see org.soluvas.email.Page#getSender()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Sender();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.Page#getMailSession <em>Mail Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail Session</em>'.
	 * @see org.soluvas.email.Page#getMailSession()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_MailSession();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.TemplateLike <em>Template Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Like</em>'.
	 * @see org.soluvas.email.TemplateLike
	 * @generated
	 */
	EClass getTemplateLike();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.TemplateLike#getSubjectTemplate <em>Subject Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subject Template</em>'.
	 * @see org.soluvas.email.TemplateLike#getSubjectTemplate()
	 * @see #getTemplateLike()
	 * @generated
	 */
	EAttribute getTemplateLike_SubjectTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.TemplateLike#getPlainTemplate <em>Plain Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plain Template</em>'.
	 * @see org.soluvas.email.TemplateLike#getPlainTemplate()
	 * @see #getTemplateLike()
	 * @generated
	 */
	EAttribute getTemplateLike_PlainTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.TemplateLike#getHtmlTemplate <em>Html Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Html Template</em>'.
	 * @see org.soluvas.email.TemplateLike#getHtmlTemplate()
	 * @see #getTemplateLike()
	 * @generated
	 */
	EAttribute getTemplateLike_HtmlTemplate();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.EmailManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see org.soluvas.email.EmailManager
	 * @generated
	 */
	EClass getEmailManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailManager#getSmtpUser <em>Smtp User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp User</em>'.
	 * @see org.soluvas.email.EmailManager#getSmtpUser()
	 * @see #getEmailManager()
	 * @generated
	 */
	EAttribute getEmailManager_SmtpUser();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailManager#getSmtpPassword <em>Smtp Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Password</em>'.
	 * @see org.soluvas.email.EmailManager#getSmtpPassword()
	 * @see #getEmailManager()
	 * @generated
	 */
	EAttribute getEmailManager_SmtpPassword();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailManager#getSmtpHost <em>Smtp Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Host</em>'.
	 * @see org.soluvas.email.EmailManager#getSmtpHost()
	 * @see #getEmailManager()
	 * @generated
	 */
	EAttribute getEmailManager_SmtpHost();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailManager#getSmtpPort <em>Smtp Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Port</em>'.
	 * @see org.soluvas.email.EmailManager#getSmtpPort()
	 * @see #getEmailManager()
	 * @generated
	 */
	EAttribute getEmailManager_SmtpPort();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.EmailManager#getSmtpSecurity <em>Smtp Security</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Security</em>'.
	 * @see org.soluvas.email.EmailManager#getSmtpSecurity()
	 * @see #getEmailManager()
	 * @generated
	 */
	EAttribute getEmailManager_SmtpSecurity();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.Sender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sender</em>'.
	 * @see org.soluvas.email.Sender
	 * @generated
	 */
	EClass getSender();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Sender#getSenderType <em>Sender Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sender Type</em>'.
	 * @see org.soluvas.email.Sender#getSenderType()
	 * @see #getSender()
	 * @generated
	 */
	EReference getSender_SenderType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.SenderType <em>Sender Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sender Type</em>'.
	 * @see org.soluvas.email.SenderType
	 * @generated
	 */
	EClass getSenderType();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.SenderLike <em>Sender Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sender Like</em>'.
	 * @see org.soluvas.email.SenderLike
	 * @generated
	 */
	EClass getSenderLike();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.SenderLike#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.soluvas.email.SenderLike#getFrom()
	 * @see #getSenderLike()
	 * @generated
	 */
	EAttribute getSenderLike_From();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.SenderLike#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.soluvas.email.SenderLike#getEmail()
	 * @see #getSenderLike()
	 * @generated
	 */
	EAttribute getSenderLike_Email();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.SenderLike#getReplyTo <em>Reply To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reply To</em>'.
	 * @see org.soluvas.email.SenderLike#getReplyTo()
	 * @see #getSenderLike()
	 * @generated
	 */
	EAttribute getSenderLike_ReplyTo();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.DefaultScope <em>Default Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Scope</em>'.
	 * @see org.soluvas.email.DefaultScope
	 * @generated
	 */
	EClass getDefaultScope();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.DefaultScope#getWebAddress <em>Web Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Web Address</em>'.
	 * @see org.soluvas.email.DefaultScope#getWebAddress()
	 * @see #getDefaultScope()
	 * @generated
	 */
	EReference getDefaultScope_WebAddress();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.DefaultScope#getAppManifest <em>App Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>App Manifest</em>'.
	 * @see org.soluvas.email.DefaultScope#getAppManifest()
	 * @see #getDefaultScope()
	 * @generated
	 */
	EReference getDefaultScope_AppManifest();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.email.EmailFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Format</em>'.
	 * @see org.soluvas.email.EmailFormat
	 * @generated
	 */
	EEnum getEmailFormat();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.email.WebSecurity <em>Web Security</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Web Security</em>'.
	 * @see org.soluvas.email.WebSecurity
	 * @generated
	 */
	EEnum getWebSecurity();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.email.EmailSecurity <em>Security</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Security</em>'.
	 * @see org.soluvas.email.EmailSecurity
	 * @generated
	 */
	EEnum getEmailSecurity();

	/**
	 * Returns the meta object for data type '{@link org.apache.commons.mail.Email <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Email</em>'.
	 * @see org.apache.commons.mail.Email
	 * @model instanceClass="org.apache.commons.mail.Email"
	 * @generated
	 */
	EDataType getEmail();

	/**
	 * Returns the meta object for data type '{@link javax.mail.Session <em>Mail Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mail Session</em>'.
	 * @see javax.mail.Session
	 * @model instanceClass="javax.mail.Session" serializeable="false"
	 * @generated
	 */
	EDataType getMailSession();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmailFactory getEmailFactory();

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
		 * The meta object literal for the '{@link org.soluvas.email.impl.EmailCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.EmailCatalogImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailCatalog()
		 * @generated
		 */
		EClass EMAIL_CATALOG = eINSTANCE.getEmailCatalog();

		/**
		 * The meta object literal for the '<em><b>Page Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__PAGE_TYPES = eINSTANCE.getEmailCatalog_PageTypes();

		/**
		 * The meta object literal for the '<em><b>Layout Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__LAYOUT_TYPES = eINSTANCE.getEmailCatalog_LayoutTypes();

		/**
		 * The meta object literal for the '<em><b>Sender Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__SENDER_TYPES = eINSTANCE.getEmailCatalog_SenderTypes();

		/**
		 * The meta object literal for the '<em><b>Generated Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_CATALOG__GENERATED_PACKAGE_NAME = eINSTANCE.getEmailCatalog_GeneratedPackageName();

		/**
		 * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__EPACKAGE = eINSTANCE.getEmailCatalog_EPackage();

		/**
		 * The meta object literal for the '<em><b>EFactory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__EFACTORY = eINSTANCE.getEmailCatalog_EFactory();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.TemplateTypeImpl <em>Template Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.TemplateTypeImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplateType()
		 * @generated
		 */
		EClass TEMPLATE_TYPE = eINSTANCE.getTemplateType();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.PageTypeImpl <em>Page Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.PageTypeImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getPageType()
		 * @generated
		 */
		EClass PAGE_TYPE = eINSTANCE.getPageType();

		/**
		 * The meta object literal for the '<em><b>Sender Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TYPE__SENDER_TYPE_NAME = eINSTANCE.getPageType_SenderTypeName();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.TemplateImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Recipients</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__RECIPIENTS = eINSTANCE.getTemplate_Recipients();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.LayoutTypeImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getLayoutType()
		 * @generated
		 */
		EClass LAYOUT_TYPE = eINSTANCE.getLayoutType();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.RecipientImpl <em>Recipient</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.RecipientImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getRecipient()
		 * @generated
		 */
		EClass RECIPIENT = eINSTANCE.getRecipient();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__EMAIL = eINSTANCE.getRecipient_Email();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__NAME = eINSTANCE.getRecipient_Name();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__FIRST_NAME = eINSTANCE.getRecipient_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__LAST_NAME = eINSTANCE.getRecipient_LastName();

		/**
		 * The meta object literal for the '<em><b>Preferred Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__PREFERRED_FORMAT = eINSTANCE.getRecipient_PreferredFormat();

		/**
		 * The meta object literal for the '<em><b>Preferred Web Security</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__PREFERRED_WEB_SECURITY = eINSTANCE.getRecipient_PreferredWebSecurity();

		/**
		 * The meta object literal for the '<em><b>Role Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIPIENT__ROLE_NAME = eINSTANCE.getRecipient_RoleName();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.LayoutImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '<em><b>Page Subject</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__PAGE_SUBJECT = eINSTANCE.getLayout_PageSubject();

		/**
		 * The meta object literal for the '<em><b>Page Plain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__PAGE_PLAIN = eINSTANCE.getLayout_PagePlain();

		/**
		 * The meta object literal for the '<em><b>Page Html</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__PAGE_HTML = eINSTANCE.getLayout_PageHtml();

		/**
		 * The meta object literal for the '<em><b>Layout Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__LAYOUT_TYPE = eINSTANCE.getLayout_LayoutType();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.PageImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__LAYOUT = eINSTANCE.getPage_Layout();

		/**
		 * The meta object literal for the '<em><b>Page Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__PAGE_TYPE = eINSTANCE.getPage_PageType();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__SENDER = eINSTANCE.getPage_Sender();

		/**
		 * The meta object literal for the '<em><b>Mail Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__MAIL_SESSION = eINSTANCE.getPage_MailSession();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.TemplateLike <em>Template Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.TemplateLike
		 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplateLike()
		 * @generated
		 */
		EClass TEMPLATE_LIKE = eINSTANCE.getTemplateLike();

		/**
		 * The meta object literal for the '<em><b>Subject Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_LIKE__SUBJECT_TEMPLATE = eINSTANCE.getTemplateLike_SubjectTemplate();

		/**
		 * The meta object literal for the '<em><b>Plain Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_LIKE__PLAIN_TEMPLATE = eINSTANCE.getTemplateLike_PlainTemplate();

		/**
		 * The meta object literal for the '<em><b>Html Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_LIKE__HTML_TEMPLATE = eINSTANCE.getTemplateLike_HtmlTemplate();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.EmailManagerImpl <em>Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.EmailManagerImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailManager()
		 * @generated
		 */
		EClass EMAIL_MANAGER = eINSTANCE.getEmailManager();

		/**
		 * The meta object literal for the '<em><b>Smtp User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_MANAGER__SMTP_USER = eINSTANCE.getEmailManager_SmtpUser();

		/**
		 * The meta object literal for the '<em><b>Smtp Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_MANAGER__SMTP_PASSWORD = eINSTANCE.getEmailManager_SmtpPassword();

		/**
		 * The meta object literal for the '<em><b>Smtp Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_MANAGER__SMTP_HOST = eINSTANCE.getEmailManager_SmtpHost();

		/**
		 * The meta object literal for the '<em><b>Smtp Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_MANAGER__SMTP_PORT = eINSTANCE.getEmailManager_SmtpPort();

		/**
		 * The meta object literal for the '<em><b>Smtp Security</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMAIL_MANAGER__SMTP_SECURITY = eINSTANCE.getEmailManager_SmtpSecurity();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.SenderImpl <em>Sender</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.SenderImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getSender()
		 * @generated
		 */
		EClass SENDER = eINSTANCE.getSender();

		/**
		 * The meta object literal for the '<em><b>Sender Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENDER__SENDER_TYPE = eINSTANCE.getSender_SenderType();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.impl.SenderTypeImpl <em>Sender Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.SenderTypeImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getSenderType()
		 * @generated
		 */
		EClass SENDER_TYPE = eINSTANCE.getSenderType();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.SenderLike <em>Sender Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.SenderLike
		 * @see org.soluvas.email.impl.EmailPackageImpl#getSenderLike()
		 * @generated
		 */
		EClass SENDER_LIKE = eINSTANCE.getSenderLike();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENDER_LIKE__FROM = eINSTANCE.getSenderLike_From();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENDER_LIKE__EMAIL = eINSTANCE.getSenderLike_Email();

		/**
		 * The meta object literal for the '<em><b>Reply To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENDER_LIKE__REPLY_TO = eINSTANCE.getSenderLike_ReplyTo();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.DefaultScope <em>Default Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.DefaultScope
		 * @see org.soluvas.email.impl.EmailPackageImpl#getDefaultScope()
		 * @generated
		 */
		EClass DEFAULT_SCOPE = eINSTANCE.getDefaultScope();

		/**
		 * The meta object literal for the '<em><b>Web Address</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_SCOPE__WEB_ADDRESS = eINSTANCE.getDefaultScope_WebAddress();

		/**
		 * The meta object literal for the '<em><b>App Manifest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_SCOPE__APP_MANIFEST = eINSTANCE.getDefaultScope_AppManifest();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.EmailFormat <em>Format</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.EmailFormat
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailFormat()
		 * @generated
		 */
		EEnum EMAIL_FORMAT = eINSTANCE.getEmailFormat();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.WebSecurity <em>Web Security</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.WebSecurity
		 * @see org.soluvas.email.impl.EmailPackageImpl#getWebSecurity()
		 * @generated
		 */
		EEnum WEB_SECURITY = eINSTANCE.getWebSecurity();

		/**
		 * The meta object literal for the '{@link org.soluvas.email.EmailSecurity <em>Security</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.EmailSecurity
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailSecurity()
		 * @generated
		 */
		EEnum EMAIL_SECURITY = eINSTANCE.getEmailSecurity();

		/**
		 * The meta object literal for the '<em>Email</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.commons.mail.Email
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmail()
		 * @generated
		 */
		EDataType EMAIL = eINSTANCE.getEmail();

		/**
		 * The meta object literal for the '<em>Mail Session</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.mail.Session
		 * @see org.soluvas.email.impl.EmailPackageImpl#getMailSession()
		 * @generated
		 */
		EDataType MAIL_SESSION = eINSTANCE.getMailSession();

	}

} //EmailPackage
