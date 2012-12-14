/**
 */
package org.soluvas.email.builtin;

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
	 * Returns the meta object for class '{@link org.soluvas.email.builtin.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see org.soluvas.email.builtin.Test
	 * @generated
	 */
	EClass getTest();

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

	}

} //BuiltinPackage
