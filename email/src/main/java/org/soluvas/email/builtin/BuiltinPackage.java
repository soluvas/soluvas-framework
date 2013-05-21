/**
 */
package org.soluvas.email.builtin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.soluvas.email.EmailPackage;

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
 * @see org.soluvas.email.builtin.BuiltinFactory
 * @model kind="package"
 * @generated
 */
public interface BuiltinPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "builtin";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/email.builtin/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "builtin-email";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuiltinPackage eINSTANCE = org.soluvas.email.builtin.impl.BuiltinPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.ContactImpl <em>Contact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.ContactImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getContact()
	 * @generated
	 */
	int CONTACT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__EMAIL = 1;

	/**
	 * The feature id for the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__MOBILE = 2;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__SUBJECT = 3;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__MESSAGE = 4;

	/**
	 * The number of structural features of the '<em>Contact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.FeedbackToAdmin <em>Feedback To Admin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.FeedbackToAdmin
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdmin()
	 * @generated
	 */
	int FEEDBACK_TO_ADMIN = 1;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__CONTACT = 0;

	/**
	 * The number of structural features of the '<em>Feedback To Admin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.FeedbackToAdminManagerImpl <em>Feedback To Admin Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.FeedbackToAdminManagerImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdminManager()
	 * @generated
	 */
	int FEEDBACK_TO_ADMIN_MANAGER = 2;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__SUBJECT_TEMPLATE = EmailPackage.PAGE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__PLAIN_TEMPLATE = EmailPackage.PAGE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__HTML_TEMPLATE = EmailPackage.PAGE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__WEB_ADDRESS = EmailPackage.PAGE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__APP_MANIFEST = EmailPackage.PAGE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__RECIPIENTS = EmailPackage.PAGE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__LAYOUT = EmailPackage.PAGE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Page Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__PAGE_TYPE = EmailPackage.PAGE__PAGE_TYPE;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__SENDER = EmailPackage.PAGE__SENDER;

	/**
	 * The feature id for the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__MAIL_SESSION = EmailPackage.PAGE__MAIL_SESSION;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER__CONTACT = EmailPackage.PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feedback To Admin Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_MANAGER_FEATURE_COUNT = EmailPackage.PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.SoluvasImpl <em>Soluvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.SoluvasImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getSoluvas()
	 * @generated
	 */
	int SOLUVAS = 3;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__SUBJECT_TEMPLATE = EmailPackage.LAYOUT__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__PLAIN_TEMPLATE = EmailPackage.LAYOUT__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__HTML_TEMPLATE = EmailPackage.LAYOUT__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__WEB_ADDRESS = EmailPackage.LAYOUT__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__APP_MANIFEST = EmailPackage.LAYOUT__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__RECIPIENTS = EmailPackage.LAYOUT__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Page Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__PAGE_SUBJECT = EmailPackage.LAYOUT__PAGE_SUBJECT;

	/**
	 * The feature id for the '<em><b>Page Plain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__PAGE_PLAIN = EmailPackage.LAYOUT__PAGE_PLAIN;

	/**
	 * The feature id for the '<em><b>Page Html</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__PAGE_HTML = EmailPackage.LAYOUT__PAGE_HTML;

	/**
	 * The feature id for the '<em><b>Layout Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS__LAYOUT_TYPE = EmailPackage.LAYOUT__LAYOUT_TYPE;

	/**
	 * The number of structural features of the '<em>Soluvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUVAS_FEATURE_COUNT = EmailPackage.LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.TesterImpl <em>Tester</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.TesterImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getTester()
	 * @generated
	 */
	int TESTER = 4;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__SUBJECT_TEMPLATE = EmailPackage.PAGE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__PLAIN_TEMPLATE = EmailPackage.PAGE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__HTML_TEMPLATE = EmailPackage.PAGE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__WEB_ADDRESS = EmailPackage.PAGE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__APP_MANIFEST = EmailPackage.PAGE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__RECIPIENTS = EmailPackage.PAGE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__LAYOUT = EmailPackage.PAGE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Page Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__PAGE_TYPE = EmailPackage.PAGE__PAGE_TYPE;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__SENDER = EmailPackage.PAGE__SENDER;

	/**
	 * The feature id for the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__MAIL_SESSION = EmailPackage.PAGE__MAIL_SESSION;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__TITLE = EmailPackage.PAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER__MESSAGE = EmailPackage.PAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tester</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTER_FEATURE_COUNT = EmailPackage.PAGE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.Contact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contact</em>'.
	 * @see org.soluvas.email.builtin.Contact
	 * @generated
	 */
	EClass getContact();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Contact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.email.builtin.Contact#getName()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Contact#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.soluvas.email.builtin.Contact#getEmail()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Email();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Contact#getMobile <em>Mobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mobile</em>'.
	 * @see org.soluvas.email.builtin.Contact#getMobile()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Mobile();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Contact#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subject</em>'.
	 * @see org.soluvas.email.builtin.Contact#getSubject()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Subject();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Contact#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.soluvas.email.builtin.Contact#getMessage()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Message();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.FeedbackToAdmin <em>Feedback To Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feedback To Admin</em>'.
	 * @see org.soluvas.email.builtin.FeedbackToAdmin
	 * @generated
	 */
	EClass getFeedbackToAdmin();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.email.builtin.FeedbackToAdmin#getContact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Contact</em>'.
	 * @see org.soluvas.email.builtin.FeedbackToAdmin#getContact()
	 * @see #getFeedbackToAdmin()
	 * @generated
	 */
	EReference getFeedbackToAdmin_Contact();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.FeedbackToAdminManager <em>Feedback To Admin Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feedback To Admin Manager</em>'.
	 * @see org.soluvas.email.builtin.FeedbackToAdminManager
	 * @generated
	 */
	EClass getFeedbackToAdminManager();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.Soluvas <em>Soluvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Soluvas</em>'.
	 * @see org.soluvas.email.builtin.Soluvas
	 * @generated
	 */
	EClass getSoluvas();

	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.Tester <em>Tester</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tester</em>'.
	 * @see org.soluvas.email.builtin.Tester
	 * @generated
	 */
	EClass getTester();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Tester#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.email.builtin.Tester#getTitle()
	 * @see #getTester()
	 * @generated
	 */
	EAttribute getTester_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.email.builtin.Tester#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.soluvas.email.builtin.Tester#getMessage()
	 * @see #getTester()
	 * @generated
	 */
	EAttribute getTester_Message();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BuiltinFactory getBuiltinFactory();

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
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.ContactImpl <em>Contact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.ContactImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getContact()
		 * @generated
		 */
		EClass CONTACT = eINSTANCE.getContact();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__NAME = eINSTANCE.getContact_Name();
		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__EMAIL = eINSTANCE.getContact_Email();
		/**
		 * The meta object literal for the '<em><b>Mobile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__MOBILE = eINSTANCE.getContact_Mobile();
		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__SUBJECT = eINSTANCE.getContact_Subject();
		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__MESSAGE = eINSTANCE.getContact_Message();
		/**
		 * The meta object literal for the '{@link org.soluvas.email.builtin.FeedbackToAdmin <em>Feedback To Admin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.FeedbackToAdmin
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdmin()
		 * @generated
		 */
		EClass FEEDBACK_TO_ADMIN = eINSTANCE.getFeedbackToAdmin();
		/**
		 * The meta object literal for the '<em><b>Contact</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEEDBACK_TO_ADMIN__CONTACT = eINSTANCE.getFeedbackToAdmin_Contact();
		/**
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.FeedbackToAdminManagerImpl <em>Feedback To Admin Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.FeedbackToAdminManagerImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdminManager()
		 * @generated
		 */
		EClass FEEDBACK_TO_ADMIN_MANAGER = eINSTANCE.getFeedbackToAdminManager();
		/**
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.SoluvasImpl <em>Soluvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.SoluvasImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getSoluvas()
		 * @generated
		 */
		EClass SOLUVAS = eINSTANCE.getSoluvas();
		/**
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.TesterImpl <em>Tester</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.TesterImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getTester()
		 * @generated
		 */
		EClass TESTER = eINSTANCE.getTester();
		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTER__TITLE = eINSTANCE.getTester_Title();
		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTER__MESSAGE = eINSTANCE.getTester_Message();

	}

} //BuiltinPackage
