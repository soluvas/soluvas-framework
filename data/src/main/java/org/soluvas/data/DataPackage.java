/**
 */
package org.soluvas.data;

import org.eclipse.emf.ecore.EDataType;
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
 * @see org.soluvas.data.DataFactory
 * @model kind="package"
 * @generated
 */
public interface DataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "data";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/data/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "data";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataPackage eINSTANCE = org.soluvas.data.impl.DataPackageImpl.init();

	/**
	 * The meta object id for the '<em>Crud Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepository()
	 * @generated
	 */
	int CRUD_REPOSITORY = 0;

	/**
	 * The meta object id for the '<em>Paging And Sorting Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.PagingAndSortingRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getPagingAndSortingRepository()
	 * @generated
	 */
	int PAGING_AND_SORTING_REPOSITORY = 1;

	/**
	 * The meta object id for the '<em>Crud Repository Base</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepositoryBase
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepositoryBase()
	 * @generated
	 */
	int CRUD_REPOSITORY_BASE = 2;


	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.repository.CrudRepository <em>Crud Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Crud Repository</em>'.
	 * @see org.soluvas.data.repository.CrudRepository
	 * @model instanceClass="org.soluvas.data.repository.CrudRepository" typeParameters="T ID" IDBounds="org.soluvas.commons.Serializable"
	 * @generated
	 */
	EDataType getCrudRepository();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.repository.PagingAndSortingRepository <em>Paging And Sorting Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Paging And Sorting Repository</em>'.
	 * @see org.soluvas.data.repository.PagingAndSortingRepository
	 * @model instanceClass="org.soluvas.data.repository.PagingAndSortingRepository" typeParameters="T ID" IDBounds="org.soluvas.commons.Serializable"
	 * @generated
	 */
	EDataType getPagingAndSortingRepository();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.repository.CrudRepositoryBase <em>Crud Repository Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Crud Repository Base</em>'.
	 * @see org.soluvas.data.repository.CrudRepositoryBase
	 * @model instanceClass="org.soluvas.data.repository.CrudRepositoryBase" typeParameters="T ID" IDBounds="org.soluvas.commons.Serializable"
	 * @generated
	 */
	EDataType getCrudRepositoryBase();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataFactory getDataFactory();

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
		 * The meta object literal for the '<em>Crud Repository</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.repository.CrudRepository
		 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepository()
		 * @generated
		 */
		EDataType CRUD_REPOSITORY = eINSTANCE.getCrudRepository();

		/**
		 * The meta object literal for the '<em>Paging And Sorting Repository</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.repository.PagingAndSortingRepository
		 * @see org.soluvas.data.impl.DataPackageImpl#getPagingAndSortingRepository()
		 * @generated
		 */
		EDataType PAGING_AND_SORTING_REPOSITORY = eINSTANCE.getPagingAndSortingRepository();

		/**
		 * The meta object literal for the '<em>Crud Repository Base</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.repository.CrudRepositoryBase
		 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepositoryBase()
		 * @generated
		 */
		EDataType CRUD_REPOSITORY_BASE = eINSTANCE.getCrudRepositoryBase();

	}

} //DataPackage
