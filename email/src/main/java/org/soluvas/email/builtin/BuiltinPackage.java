/**
 */
package org.soluvas.email.builtin;

import email.EmailPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.TestImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getTest()
	 * @generated
	 */
	int TEST = 0;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.soluvas.email.builtin.impl.FeedbackToAdminImpl <em>Feedback To Admin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.email.builtin.impl.FeedbackToAdminImpl
	 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdmin()
	 * @generated
	 */
	int FEEDBACK_TO_ADMIN = 1;

	/**
	 * The feature id for the '<em><b>Subject Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__SUBJECT_TEMPLATE = EmailPackage.PAGE__SUBJECT_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Plain Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__PLAIN_TEMPLATE = EmailPackage.PAGE__PLAIN_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Html Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__HTML_TEMPLATE = EmailPackage.PAGE__HTML_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Web Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__WEB_ADDRESS = EmailPackage.PAGE__WEB_ADDRESS;

	/**
	 * The feature id for the '<em><b>App Manifest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__APP_MANIFEST = EmailPackage.PAGE__APP_MANIFEST;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__RECIPIENTS = EmailPackage.PAGE__RECIPIENTS;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__LAYOUT = EmailPackage.PAGE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Page Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__PAGE_TYPE = EmailPackage.PAGE__PAGE_TYPE;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__SENDER = EmailPackage.PAGE__SENDER;

	/**
	 * The feature id for the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN__MAIL_SESSION = EmailPackage.PAGE__MAIL_SESSION;

	/**
	 * The number of structural features of the '<em>Feedback To Admin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEEDBACK_TO_ADMIN_FEATURE_COUNT = EmailPackage.PAGE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see org.soluvas.email.builtin.Test
	 * @generated
	 */
	EClass getTest();

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
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.TestImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();
		/**
		 * The meta object literal for the '{@link org.soluvas.email.builtin.impl.FeedbackToAdminImpl <em>Feedback To Admin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.email.builtin.impl.FeedbackToAdminImpl
		 * @see org.soluvas.email.builtin.impl.BuiltinPackageImpl#getFeedbackToAdmin()
		 * @generated
		 */
		EClass FEEDBACK_TO_ADMIN = eINSTANCE.getFeedbackToAdmin();

	}

} //BuiltinPackage
