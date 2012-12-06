/**
 */
package org.soluvas.data.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.data.*;

import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataFactoryImpl extends EFactoryImpl implements DataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataFactory init() {
		try {
			DataFactory theDataFactory = (DataFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/data/1.0"); 
			if (theDataFactory != null) {
				return theDataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFactoryImpl() {
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
			case DataPackage.CRUD_REPOSITORY:
				return createCrudRepositoryFromString(eDataType, initialValue);
			case DataPackage.PAGING_AND_SORTING_REPOSITORY:
				return createPagingAndSortingRepositoryFromString(eDataType, initialValue);
			case DataPackage.CRUD_REPOSITORY_BASE:
				return createCrudRepositoryBaseFromString(eDataType, initialValue);
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
			case DataPackage.CRUD_REPOSITORY:
				return convertCrudRepositoryToString(eDataType, instanceValue);
			case DataPackage.PAGING_AND_SORTING_REPOSITORY:
				return convertPagingAndSortingRepositoryToString(eDataType, instanceValue);
			case DataPackage.CRUD_REPOSITORY_BASE:
				return convertCrudRepositoryBaseToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrudRepository<?, ?> createCrudRepositoryFromString(EDataType eDataType, String initialValue) {
		return (CrudRepository<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCrudRepositoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PagingAndSortingRepository<?, ?> createPagingAndSortingRepositoryFromString(EDataType eDataType, String initialValue) {
		return (PagingAndSortingRepository<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPagingAndSortingRepositoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrudRepositoryBase<?, ?> createCrudRepositoryBaseFromString(EDataType eDataType, String initialValue) {
		return (CrudRepositoryBase<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCrudRepositoryBaseToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPackage getDataPackage() {
		return (DataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataPackage getPackage() {
		return DataPackage.eINSTANCE;
	}

} //DataFactoryImpl
