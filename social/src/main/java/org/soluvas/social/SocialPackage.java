/**
 */
package org.soluvas.social;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.soluvas.social.SocialFactory
 * @model kind="package"
 * @generated
 */
public interface SocialPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "social";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/social/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "social";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SocialPackage eINSTANCE = org.soluvas.social.impl.SocialPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.social.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.impl.TargetImpl
	 * @see org.soluvas.social.impl.SocialPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__DESCRIPTION = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__TARGET_TYPE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__TITLE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__IMAGES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__URI = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__TYPE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.soluvas.social.PersonLike <em>Person Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.PersonLike
	 * @see org.soluvas.social.impl.SocialPackageImpl#getPersonLike()
	 * @generated
	 */
	int PERSON_LIKE = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_LIKE__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_LIKE__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_LIKE__USERNAME = 2;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_LIKE__GENDER = 3;

	/**
	 * The number of structural features of the '<em>Person Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_LIKE_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.soluvas.social.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see org.soluvas.social.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.social.Target#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Type</em>'.
	 * @see org.soluvas.social.Target#getTargetType()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_TargetType();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.Target#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.social.Target#getTitle()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.Target#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Images</em>'.
	 * @see org.soluvas.social.Target#getImages()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_Images();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.Target#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.soluvas.social.Target#getUri()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.Target#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.soluvas.social.Target#getTypeName()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_TypeName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.PersonLike <em>Person Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person Like</em>'.
	 * @see org.soluvas.social.PersonLike
	 * @generated
	 */
	EClass getPersonLike();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.PersonLike#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.soluvas.social.PersonLike#getFirstName()
	 * @see #getPersonLike()
	 * @generated
	 */
	EAttribute getPersonLike_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.PersonLike#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.soluvas.social.PersonLike#getLastName()
	 * @see #getPersonLike()
	 * @generated
	 */
	EAttribute getPersonLike_LastName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.PersonLike#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.soluvas.social.PersonLike#getUsername()
	 * @see #getPersonLike()
	 * @generated
	 */
	EAttribute getPersonLike_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.PersonLike#getGender <em>Gender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gender</em>'.
	 * @see org.soluvas.social.PersonLike#getGender()
	 * @see #getPersonLike()
	 * @generated
	 */
	EAttribute getPersonLike_Gender();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SocialFactory getSocialFactory();

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
		 * The meta object literal for the '{@link org.soluvas.social.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.impl.TargetImpl
		 * @see org.soluvas.social.impl.SocialPackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__TARGET_TYPE = eINSTANCE.getTarget_TargetType();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__TITLE = eINSTANCE.getTarget_Title();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__IMAGES = eINSTANCE.getTarget_Images();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__URI = eINSTANCE.getTarget_Uri();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__TYPE_NAME = eINSTANCE.getTarget_TypeName();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.PersonLike <em>Person Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.PersonLike
		 * @see org.soluvas.social.impl.SocialPackageImpl#getPersonLike()
		 * @generated
		 */
		EClass PERSON_LIKE = eINSTANCE.getPersonLike();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_LIKE__FIRST_NAME = eINSTANCE.getPersonLike_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_LIKE__LAST_NAME = eINSTANCE.getPersonLike_LastName();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_LIKE__USERNAME = eINSTANCE.getPersonLike_Username();

		/**
		 * The meta object literal for the '<em><b>Gender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON_LIKE__GENDER = eINSTANCE.getPersonLike_Gender();

	}

} //SocialPackage
