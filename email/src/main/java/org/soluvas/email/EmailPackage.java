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
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__PAGES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG__LAYOUTS = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_CATALOG_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

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
	 * The number of structural features of the '<em>Page Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TYPE_FEATURE_COUNT = TEMPLATE_TYPE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__TEMPLATE = TEMPLATE_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__RECIPIENTS = TEMPLATE_LIKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__APP_MANIFEST = TEMPLATE_LIKE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__WEB_ADDRESS = TEMPLATE_LIKE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = TEMPLATE_LIKE_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__TEMPLATE = TEMPLATE__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__RECIPIENTS = TEMPLATE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__APP_MANIFEST = TEMPLATE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__WEB_ADDRESS = TEMPLATE__WEB_ADDRESS;

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
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__TEMPLATE = TEMPLATE__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__RECIPIENTS = TEMPLATE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__APP_MANIFEST = TEMPLATE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__WEB_ADDRESS = TEMPLATE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__LAYOUT = TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.email.EmailFormat <em>Format</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.EmailFormat
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmailFormat()
	 * @generated
	 */
	int EMAIL_FORMAT = 9;

	/**
	 * The meta object id for the '{@link org.soluvas.email.WebSecurity <em>Web Security</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.WebSecurity
	 * @see org.soluvas.email.impl.EmailPackageImpl#getWebSecurity()
	 * @generated
	 */
	int WEB_SECURITY = 10;

	/**
	 * The meta object id for the '<em>Email</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.commons.mail.Email
	 * @see org.soluvas.email.impl.EmailPackageImpl#getEmail()
	 * @generated
	 */
	int EMAIL = 11;

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
	 * Returns the meta object for the containment reference list '{@link org.soluvas.email.EmailCatalog#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see org.soluvas.email.EmailCatalog#getPages()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_Pages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.email.EmailCatalog#getLayouts <em>Layouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layouts</em>'.
	 * @see org.soluvas.email.EmailCatalog#getLayouts()
	 * @see #getEmailCatalog()
	 * @generated
	 */
	EReference getEmailCatalog_Layouts();

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
	 * Returns the meta object for class '{@link org.soluvas.email.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.soluvas.email.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Template#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template</em>'.
	 * @see org.soluvas.email.Template#getTemplate()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Template();

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
	 * Returns the meta object for the reference '{@link org.soluvas.email.Template#getWebAddress <em>Web Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Web Address</em>'.
	 * @see org.soluvas.email.Template#getWebAddress()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_WebAddress();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.Template#getAppManifest <em>App Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>App Manifest</em>'.
	 * @see org.soluvas.email.Template#getAppManifest()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_AppManifest();

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
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__PAGES = eINSTANCE.getEmailCatalog_Pages();

		/**
		 * The meta object literal for the '<em><b>Layouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMAIL_CATALOG__LAYOUTS = eINSTANCE.getEmailCatalog_Layouts();

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
		 * The meta object literal for the '{@link org.soluvas.email.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.impl.TemplateImpl
		 * @see org.soluvas.email.impl.EmailPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__TEMPLATE = eINSTANCE.getTemplate_Template();

		/**
		 * The meta object literal for the '<em><b>Recipients</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__RECIPIENTS = eINSTANCE.getTemplate_Recipients();

		/**
		 * The meta object literal for the '<em><b>Web Address</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__WEB_ADDRESS = eINSTANCE.getTemplate_WebAddress();

		/**
		 * The meta object literal for the '<em><b>App Manifest</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__APP_MANIFEST = eINSTANCE.getTemplate_AppManifest();

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
		 * The meta object literal for the '<em>Email</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.commons.mail.Email
		 * @see org.soluvas.email.impl.EmailPackageImpl#getEmail()
		 * @generated
		 */
		EDataType EMAIL = eINSTANCE.getEmail();

	}

} //EmailPackage
