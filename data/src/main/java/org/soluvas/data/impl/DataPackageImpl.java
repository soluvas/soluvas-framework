/**
 */
package org.soluvas.data.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.commons.CommonsPackage;

import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;

import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.CrudRepositoryBase;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataPackageImpl extends EPackageImpl implements DataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType crudRepositoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pagingAndSortingRepositoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType crudRepositoryBaseEDataType = null;

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
	 * @see org.soluvas.data.DataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataPackageImpl() {
		super(eNS_URI, DataFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataPackage init() {
		if (isInited) return (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

		// Obtain or create and register package
		DataPackageImpl theDataPackage = (DataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDataPackage.createPackageContents();

		// Initialize created meta-data
		theDataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, theDataPackage);
		return theDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCrudRepository() {
		return crudRepositoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPagingAndSortingRepository() {
		return pagingAndSortingRepositoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCrudRepositoryBase() {
		return crudRepositoryBaseEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFactory getDataFactory() {
		return (DataFactory)getEFactoryInstance();
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

		// Create data types
		crudRepositoryEDataType = createEDataType(CRUD_REPOSITORY);
		pagingAndSortingRepositoryEDataType = createEDataType(PAGING_AND_SORTING_REPOSITORY);
		crudRepositoryBaseEDataType = createEDataType(CRUD_REPOSITORY_BASE);
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

		// Initialize data types
		initEDataType(crudRepositoryEDataType, CrudRepository.class, "CrudRepository", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pagingAndSortingRepositoryEDataType, PagingAndSortingRepository.class, "PagingAndSortingRepository", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(crudRepositoryBaseEDataType, CrudRepositoryBase.class, "CrudRepositoryBase", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "Object type of the data structure values."
		   });		
		addAnnotation
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "ID type of the data structure identifiers, usually String."
		   });		
		addAnnotation
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "Object type of the data structure values."
		   });		
		addAnnotation
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "ID type of the data structure identifiers, usually String."
		   });		
		addAnnotation
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "Object type of the data structure values."
		   });		
		addAnnotation
		  (null, 
		   source, 
		   new String[] {
			 "documentation", "ID type of the data structure identifiers, usually String."
		   });
	}

} //DataPackageImpl
