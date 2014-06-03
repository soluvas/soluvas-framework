/**
 */
package org.soluvas.data.impl;

import javax.measure.DecimalMeasure;
import javax.measure.Measure;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.data.Attribute;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.CurrencyValue;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.FreeVocab;
import org.soluvas.data.InputMethod;
import org.soluvas.data.Kind;
import org.soluvas.data.ListVocab;
import org.soluvas.data.LookupKey;
import org.soluvas.data.MeasureValue;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinCatalog;
import org.soluvas.data.MixinManager;
import org.soluvas.data.RangeValue;
import org.soluvas.data.StatusMask;
import org.soluvas.data.StringValue;
import org.soluvas.data.Term;
import org.soluvas.data.TermContainer;
import org.soluvas.data.TermValue;
import org.soluvas.data.TreeVocab;
import org.soluvas.data.Value;
import org.soluvas.data.Vocab;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
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
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass currencyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mixinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listVocabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeVocabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeVocabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mixinCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mixinManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attributeSemanticEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum inputMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum statusMaskEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lookupKeyEEnum = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType measureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType decimalMeasureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pageableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pageEDataType = null;

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
		EcorePackage.eINSTANCE.eClass();

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
	@Override
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_DisplayName() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_Enabled() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_MinValues() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_MaxValues() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_DataTypeName() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_KindNsPrefix() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_KindName() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_InputMethod() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_InputUnitName() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_VisibleInSimple() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_SearchableInQuick() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_ImageId() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_FieldWidth() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_Principal() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValue_Semantic() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValue_DisplayValue() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringValue() {
		return stringValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringValue_Value() {
		return (EAttribute)stringValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeasureValue() {
		return measureValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMeasureValue_ValueUnit() {
		return (EAttribute)measureValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMeasureValue_Value() {
		return (EAttribute)measureValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCurrencyValue() {
		return currencyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCurrencyValue_CurrencyUnit() {
		return (EAttribute)currencyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMixin() {
		return mixinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMixin_Attributes() {
		return (EReference)mixinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMixin_DisplayName() {
		return (EAttribute)mixinEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRangeValue() {
		return rangeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRangeValue_StartValue() {
		return (EAttribute)rangeValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRangeValue_EndValue() {
		return (EAttribute)rangeValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTermValue() {
		return termValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTermValue_Term() {
		return (EReference)termValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTermValue_SlugPath() {
		return (EAttribute)termValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTermValue_Value() {
		return (EAttribute)termValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVocab() {
		return vocabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTerm_Vocab() {
		return (EReference)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTerm_DisplayName() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTerm_ImageId() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTerm_KindNsPrefix() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTerm_KindName() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTerm_Bordered() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getListVocab() {
		return listVocabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTreeVocab() {
		return treeVocabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFreeVocab() {
		return freeVocabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTermContainer() {
		return termContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTermContainer_Terms() {
		return (EReference)termContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataCatalog() {
		return dataCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataCatalog_Vocabs() {
		return (EReference)dataCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataCatalog_Terms() {
		return (EReference)dataCatalogEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataCatalog_Kinds() {
		return (EReference)dataCatalogEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKind() {
		return kindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getKind_ImageId() {
		return (EAttribute)kindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMixinCatalog() {
		return mixinCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMixinCatalog_Mixins() {
		return (EReference)mixinCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMixinManager() {
		return mixinManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMixinManager_MixinCatalog() {
		return (EReference)mixinManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMixinManager_Mixins() {
		return (EAttribute)mixinManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAttributeSemantic() {
		return attributeSemanticEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getInputMethod() {
		return inputMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getStatusMask() {
		return statusMaskEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getLookupKey() {
		return lookupKeyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCrudRepository() {
		return crudRepositoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPagingAndSortingRepository() {
		return pagingAndSortingRepositoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCrudRepositoryBase() {
		return crudRepositoryBaseEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getMeasure() {
		return measureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDecimalMeasure() {
		return decimalMeasureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPageable() {
		return pageableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPage() {
		return pageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

		// Create classes and their features
		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__DISPLAY_NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__ENABLED);
		createEAttribute(attributeEClass, ATTRIBUTE__MIN_VALUES);
		createEAttribute(attributeEClass, ATTRIBUTE__MAX_VALUES);
		createEAttribute(attributeEClass, ATTRIBUTE__DATA_TYPE_NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__KIND_NS_PREFIX);
		createEAttribute(attributeEClass, ATTRIBUTE__KIND_NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__INPUT_METHOD);
		createEAttribute(attributeEClass, ATTRIBUTE__INPUT_UNIT_NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__VISIBLE_IN_SIMPLE);
		createEAttribute(attributeEClass, ATTRIBUTE__SEARCHABLE_IN_QUICK);
		createEAttribute(attributeEClass, ATTRIBUTE__IMAGE_ID);
		createEAttribute(attributeEClass, ATTRIBUTE__FIELD_WIDTH);
		createEAttribute(attributeEClass, ATTRIBUTE__PRINCIPAL);

		valueEClass = createEClass(VALUE);
		createEAttribute(valueEClass, VALUE__SEMANTIC);
		createEAttribute(valueEClass, VALUE__DISPLAY_VALUE);

		stringValueEClass = createEClass(STRING_VALUE);
		createEAttribute(stringValueEClass, STRING_VALUE__VALUE);

		measureValueEClass = createEClass(MEASURE_VALUE);
		createEAttribute(measureValueEClass, MEASURE_VALUE__VALUE_UNIT);
		createEAttribute(measureValueEClass, MEASURE_VALUE__VALUE);

		currencyValueEClass = createEClass(CURRENCY_VALUE);
		createEAttribute(currencyValueEClass, CURRENCY_VALUE__CURRENCY_UNIT);

		mixinEClass = createEClass(MIXIN);
		createEReference(mixinEClass, MIXIN__ATTRIBUTES);
		createEAttribute(mixinEClass, MIXIN__DISPLAY_NAME);

		rangeValueEClass = createEClass(RANGE_VALUE);
		createEAttribute(rangeValueEClass, RANGE_VALUE__START_VALUE);
		createEAttribute(rangeValueEClass, RANGE_VALUE__END_VALUE);

		termValueEClass = createEClass(TERM_VALUE);
		createEReference(termValueEClass, TERM_VALUE__TERM);
		createEAttribute(termValueEClass, TERM_VALUE__SLUG_PATH);
		createEAttribute(termValueEClass, TERM_VALUE__VALUE);

		vocabEClass = createEClass(VOCAB);

		termEClass = createEClass(TERM);
		createEReference(termEClass, TERM__VOCAB);
		createEAttribute(termEClass, TERM__DISPLAY_NAME);
		createEAttribute(termEClass, TERM__IMAGE_ID);
		createEAttribute(termEClass, TERM__KIND_NS_PREFIX);
		createEAttribute(termEClass, TERM__KIND_NAME);
		createEAttribute(termEClass, TERM__BORDERED);

		listVocabEClass = createEClass(LIST_VOCAB);

		treeVocabEClass = createEClass(TREE_VOCAB);

		freeVocabEClass = createEClass(FREE_VOCAB);

		termContainerEClass = createEClass(TERM_CONTAINER);
		createEReference(termContainerEClass, TERM_CONTAINER__TERMS);

		dataCatalogEClass = createEClass(DATA_CATALOG);
		createEReference(dataCatalogEClass, DATA_CATALOG__VOCABS);
		createEReference(dataCatalogEClass, DATA_CATALOG__TERMS);
		createEReference(dataCatalogEClass, DATA_CATALOG__KINDS);

		kindEClass = createEClass(KIND);
		createEAttribute(kindEClass, KIND__IMAGE_ID);

		mixinCatalogEClass = createEClass(MIXIN_CATALOG);
		createEReference(mixinCatalogEClass, MIXIN_CATALOG__MIXINS);

		mixinManagerEClass = createEClass(MIXIN_MANAGER);
		createEReference(mixinManagerEClass, MIXIN_MANAGER__MIXIN_CATALOG);
		createEAttribute(mixinManagerEClass, MIXIN_MANAGER__MIXINS);

		// Create enums
		attributeSemanticEEnum = createEEnum(ATTRIBUTE_SEMANTIC);
		inputMethodEEnum = createEEnum(INPUT_METHOD);
		statusMaskEEnum = createEEnum(STATUS_MASK);
		lookupKeyEEnum = createEEnum(LOOKUP_KEY);

		// Create data types
		crudRepositoryEDataType = createEDataType(CRUD_REPOSITORY);
		pagingAndSortingRepositoryEDataType = createEDataType(PAGING_AND_SORTING_REPOSITORY);
		crudRepositoryBaseEDataType = createEDataType(CRUD_REPOSITORY_BASE);
		measureEDataType = createEDataType(MEASURE);
		decimalMeasureEDataType = createEDataType(DECIMAL_MEASURE);
		pageableEDataType = createEDataType(PAGEABLE);
		pageEDataType = createEDataType(PAGE);
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

		// Create type parameters
		ETypeParameter valueEClass_T = addETypeParameter(valueEClass, "T");
		ETypeParameter rangeValueEClass_T = addETypeParameter(rangeValueEClass, "T");
		addETypeParameter(crudRepositoryEDataType, "T");
		ETypeParameter crudRepositoryEDataType_ID = addETypeParameter(crudRepositoryEDataType, "ID");
		addETypeParameter(pagingAndSortingRepositoryEDataType, "T");
		ETypeParameter pagingAndSortingRepositoryEDataType_ID = addETypeParameter(pagingAndSortingRepositoryEDataType, "ID");
		addETypeParameter(crudRepositoryBaseEDataType, "T");
		ETypeParameter crudRepositoryBaseEDataType_ID = addETypeParameter(crudRepositoryBaseEDataType, "ID");
		addETypeParameter(measureEDataType, "V");
		ETypeParameter measureEDataType_Q = addETypeParameter(measureEDataType, "Q");
		ETypeParameter decimalMeasureEDataType_Q = addETypeParameter(decimalMeasureEDataType, "Q");
		addETypeParameter(pageEDataType, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theCommonsPackage.getSerializable());
		crudRepositoryEDataType_ID.getEBounds().add(g1);
		g1 = createEGenericType(theCommonsPackage.getSerializable());
		pagingAndSortingRepositoryEDataType_ID.getEBounds().add(g1);
		g1 = createEGenericType(theCommonsPackage.getSerializable());
		crudRepositoryBaseEDataType_ID.getEBounds().add(g1);
		g1 = createEGenericType(theCommonsPackage.getQuantity());
		measureEDataType_Q.getEBounds().add(g1);
		g1 = createEGenericType(theCommonsPackage.getQuantity());
		decimalMeasureEDataType_Q.getEBounds().add(g1);

		// Add supertypes to classes
		attributeEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		attributeEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		attributeEClass.getESuperTypes().add(theCommonsPackage.getImageable());
		attributeEClass.getESuperTypes().add(theCommonsPackage.getDescribable());
		attributeEClass.getESuperTypes().add(theCommonsPackage.getPositionable());
		g1 = createEGenericType(this.getValue());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		stringValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType(ecorePackage.getEBigDecimal());
		g1.getETypeArguments().add(g2);
		measureValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType(ecorePackage.getEBigDecimal());
		g1.getETypeArguments().add(g2);
		currencyValueEClass.getEGenericSuperTypes().add(g1);
		mixinEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		mixinEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		mixinEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		mixinEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		mixinEClass.getESuperTypes().add(theCommonsPackage.getDescribable());
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType(rangeValueEClass_T);
		g1.getETypeArguments().add(g2);
		rangeValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		termValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getIdentifiable());
		termValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCommonsPackage.getSluggable());
		termValueEClass.getEGenericSuperTypes().add(g1);
		vocabEClass.getESuperTypes().add(this.getTermContainer());
		vocabEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		vocabEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		vocabEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		vocabEClass.getESuperTypes().add(theCommonsPackage.getDescribable());
		termEClass.getESuperTypes().add(this.getTermContainer());
		termEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		termEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		termEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		termEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		termEClass.getESuperTypes().add(theCommonsPackage.getImageable());
		termEClass.getESuperTypes().add(theCommonsPackage.getPositionable());
		termEClass.getESuperTypes().add(theCommonsPackage.getColorable());
		termEClass.getESuperTypes().add(theCommonsPackage.getTranslatable());
		listVocabEClass.getESuperTypes().add(this.getVocab());
		treeVocabEClass.getESuperTypes().add(this.getVocab());
		freeVocabEClass.getESuperTypes().add(this.getVocab());
		dataCatalogEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		dataCatalogEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		dataCatalogEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		kindEClass.getESuperTypes().add(theCommonsPackage.getNsPrefixable());
		kindEClass.getESuperTypes().add(theCommonsPackage.getBundleAware());
		kindEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());
		kindEClass.getESuperTypes().add(theCommonsPackage.getResourceAware());
		kindEClass.getESuperTypes().add(theCommonsPackage.getImageable());
		kindEClass.getESuperTypes().add(theCommonsPackage.getDescribable());
		mixinCatalogEClass.getESuperTypes().add(theCommonsPackage.getNameContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_MinValues(), ecorePackage.getELong(), "minValues", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_MaxValues(), ecorePackage.getELong(), "maxValues", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_DataTypeName(), ecorePackage.getEString(), "dataTypeName", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_KindNsPrefix(), ecorePackage.getEString(), "kindNsPrefix", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_KindName(), ecorePackage.getEString(), "kindName", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_InputMethod(), this.getInputMethod(), "inputMethod", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_InputUnitName(), ecorePackage.getEString(), "inputUnitName", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_VisibleInSimple(), ecorePackage.getEBoolean(), "visibleInSimple", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_SearchableInQuick(), ecorePackage.getEBoolean(), "searchableInQuick", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_FieldWidth(), ecorePackage.getEInt(), "fieldWidth", "20", 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Principal(), ecorePackage.getEBoolean(), "principal", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(attributeEClass, null, "valueOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "stringValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(attributeEClass, null, "create", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getValue());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		addEOperation(attributeEClass, ecorePackage.getEBoolean(), "isRequired", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(attributeEClass, ecorePackage.getEBoolean(), "isMultiple", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(attributeEClass, null, "getInputUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theCommonsPackage.getUnit());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValue_Semantic(), this.getAttributeSemantic(), "semantic", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValue_DisplayValue(), ecorePackage.getEString(), "displayValue", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(valueEClass, ecorePackage.getEString(), "getString", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(valueEClass, null, "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(valueEClass_T);
		initEOperation(op, g1);

		initEClass(stringValueEClass, StringValue.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureValueEClass, MeasureValue.class, "MeasureValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theCommonsPackage.getUnit());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getMeasureValue_ValueUnit(), g1, "valueUnit", null, 0, 1, MeasureValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureValue_Value(), ecorePackage.getEBigDecimal(), "value", null, 0, 1, MeasureValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(measureValueEClass, null, "getMeasure", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getDecimalMeasure());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(currencyValueEClass, CurrencyValue.class, "CurrencyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCurrencyValue_CurrencyUnit(), theCommonsPackage.getCurrencyUnit(), "currencyUnit", null, 0, 1, CurrencyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mixinEClass, Mixin.class, "Mixin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMixin_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Mixin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMixin_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, Mixin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mixinEClass, ecorePackage.getEString(), "getQName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(rangeValueEClass, RangeValue.class, "RangeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(rangeValueEClass_T);
		initEAttribute(getRangeValue_StartValue(), g1, "startValue", null, 0, 1, RangeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(rangeValueEClass_T);
		initEAttribute(getRangeValue_EndValue(), g1, "endValue", null, 0, 1, RangeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termValueEClass, TermValue.class, "TermValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTermValue_Term(), this.getTerm(), null, "term", null, 0, 1, TermValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTermValue_SlugPath(), ecorePackage.getEString(), "slugPath", null, 0, 1, TermValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTermValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, TermValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vocabEClass, Vocab.class, "Vocab", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerm_Vocab(), this.getVocab(), null, "vocab", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_KindNsPrefix(), ecorePackage.getEString(), "kindNsPrefix", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_KindName(), ecorePackage.getEString(), "kindName", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerm_Bordered(), ecorePackage.getEBoolean(), "bordered", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(termEClass, ecorePackage.getEString(), "getQName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(termEClass, this.getTermValue(), "toValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(termEClass, ecorePackage.getEString(), "getImageUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "imagesUri", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(listVocabEClass, ListVocab.class, "ListVocab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(treeVocabEClass, TreeVocab.class, "TreeVocab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(freeVocabEClass, FreeVocab.class, "FreeVocab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(termContainerEClass, TermContainer.class, "TermContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTermContainer_Terms(), this.getTerm(), null, "terms", null, 0, -1, TermContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataCatalogEClass, DataCatalog.class, "DataCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataCatalog_Vocabs(), this.getVocab(), null, "vocabs", null, 0, -1, DataCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataCatalog_Terms(), this.getTerm(), null, "terms", null, 0, -1, DataCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataCatalog_Kinds(), this.getKind(), null, "kinds", null, 0, -1, DataCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kindEClass, Kind.class, "Kind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKind_ImageId(), ecorePackage.getEString(), "imageId", null, 0, 1, Kind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mixinCatalogEClass, MixinCatalog.class, "MixinCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMixinCatalog_Mixins(), this.getMixin(), null, "mixins", null, 0, -1, MixinCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mixinManagerEClass, MixinManager.class, "MixinManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMixinManager_MixinCatalog(), this.getMixinCatalog(), null, "mixinCatalog", null, 1, 1, MixinManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getMixin());
		g1.getETypeArguments().add(g2);
		initEAttribute(getMixinManager_Mixins(), g1, "mixins", null, 1, 1, MixinManager.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(mixinManagerEClass, this.getMixin(), "findMixin", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "uName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mixinManagerEClass, null, "findMixin", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "term", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPageable(), "pageable", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPage());
		g2 = createEGenericType(this.getMixin());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(attributeSemanticEEnum, AttributeSemantic.class, "AttributeSemantic");
		addEEnumLiteral(attributeSemanticEEnum, AttributeSemantic.EQUAL);
		addEEnumLiteral(attributeSemanticEEnum, AttributeSemantic.LESS_THAN);
		addEEnumLiteral(attributeSemanticEEnum, AttributeSemantic.LESS_THAN_OR_EQUAL);
		addEEnumLiteral(attributeSemanticEEnum, AttributeSemantic.GREATER_THAN);
		addEEnumLiteral(attributeSemanticEEnum, AttributeSemantic.GREATER_THAN_OR_EQUAL);

		initEEnum(inputMethodEEnum, InputMethod.class, "InputMethod");
		addEEnumLiteral(inputMethodEEnum, InputMethod.STRING);
		addEEnumLiteral(inputMethodEEnum, InputMethod.MEASURE);
		addEEnumLiteral(inputMethodEEnum, InputMethod.RANGE);
		addEEnumLiteral(inputMethodEEnum, InputMethod.CURRENCY);
		addEEnumLiteral(inputMethodEEnum, InputMethod.TERM);

		initEEnum(statusMaskEEnum, StatusMask.class, "StatusMask");
		addEEnumLiteral(statusMaskEEnum, StatusMask.RAW);
		addEEnumLiteral(statusMaskEEnum, StatusMask.ACTIVE_ONLY);
		addEEnumLiteral(statusMaskEEnum, StatusMask.INCLUDE_INACTIVE);
		addEEnumLiteral(statusMaskEEnum, StatusMask.DRAFT_ONLY);
		addEEnumLiteral(statusMaskEEnum, StatusMask.VOID_ONLY);

		initEEnum(lookupKeyEEnum, LookupKey.class, "LookupKey");
		addEEnumLiteral(lookupKeyEEnum, LookupKey.ID);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.SLUG);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.GUID);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.EMAIL);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.FACEBOOK_ID);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.FACEBOOK_USERNAME);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.TWITTER_ID);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.TWITTER_SCREENNAME);
		addEEnumLiteral(lookupKeyEEnum, LookupKey.MOBILE_NUMBER);

		// Initialize data types
		initEDataType(crudRepositoryEDataType, CrudRepository.class, "CrudRepository", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pagingAndSortingRepositoryEDataType, PagingAndSortingRepository.class, "PagingAndSortingRepository", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(crudRepositoryBaseEDataType, CrudRepositoryBase.class, "CrudRepositoryBase", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(measureEDataType, Measure.class, "Measure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(decimalMeasureEDataType, DecimalMeasure.class, "DecimalMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pageableEDataType, Pageable.class, "Pageable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pageEDataType, Page.class, "Page", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
		  (attributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "EXPERIMENTAL.\n\nTwo/three approaches:\n\n1. Mixin must be statically designed into Ecore EClass, e.g. BerbatikBags, which inherits from BerbatikMixin (inherits ClothingMixin = SizeMixin + ColorMixin), BatikMixin, and BagsMixin. The upside is all attributes/references merge into the EObject. Downside is we need to permutate all combinations into EClass.\nNot sure yet how it goes with MongoDB, JSON, and XMI import/export. Not sure yet how it goes with VariedProduct, BundleProduct, SubscribedProduct, SharedProduct, etc.\n\n2. Mixin is dynamic. Each product object maintain a list of MixinTypes (which is by default specified when the product is created), and filled mixins are put in an EList. Mixins can be added and removed during runtime, without any build-time project rebuild or EMF regeneration.\nSo store owner, even staff, can define new mixin and manipulate existing products with ease. No Mall admin or schema changes required.\nStore staff can browse available mixin types and just add any mixin they want.\nSimilar approach with Drupal taxonomy or JCR mixin. Magento is more restrictive because of its inflexible AttributeSet concept. Mixin is like AttributeSet but with cardinality 0..*.\nProbably need better name than mixin though.\nSeems to be most flexible, for Jackson we can have custom converter. My concern is MongoDB and XMI.\nNot sure yet how it goes with MongoDB, JSON, and XMI import/export. Not sure yet how it goes with VariedProduct, BundleProduct, SubscribedProduct, SharedProduct, etc.\n\n3. Hybrid #1. Mixin is by default static, which hopefully covers 80% use case.\nWhen you want dynamic, you can add more mixins.\nBut ain\'t this too complicated?\nOn the web client side, it\'s also more work. Not to mention inventory, etc. integration with other systems.\nProductInfo & principal etc. also use the fully dynamic approach.\n\n4. Hybrid #2. Mixin is by default dynamic, which covers 80% of the customization.\nAnd for things like category, tag, color, size, they\'re static, with code support. i.e. must be generated by EMF.\n"
		   });		
		addAnnotation
		  (attributeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Convert the string value to a mixin instance."
		   });		
		addAnnotation
		  (attributeEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "True if minValues > 0."
		   });		
		addAnnotation
		  (attributeEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "documentation", "true if maxValues is > 1."
		   });		
		addAnnotation
		  (attributeEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Returns the Unit object based on {@link #inputUnitName}."
		   });		
		addAnnotation
		  (getAttribute_DisplayName(), 
		   source, 
		   new String[] {
			 "documentation", "Human friendly name."
		   });		
		addAnnotation
		  (getAttribute_Enabled(), 
		   source, 
		   new String[] {
			 "documentation", "If {@code false}, this attribute will not be editable in the Product Editor backend."
		   });		
		addAnnotation
		  (getAttribute_MinValues(), 
		   source, 
		   new String[] {
			 "documentation", "0 means optional, 1 means required, and so on."
		   });		
		addAnnotation
		  (getAttribute_MaxValues(), 
		   source, 
		   new String[] {
			 "documentation", "1 means singular. -1 means no maximum number of values."
		   });		
		addAnnotation
		  (getAttribute_InputUnitName(), 
		   source, 
		   new String[] {
			 "documentation", "This is a String to make it easy to edit using Eclipse Generic XMI editor."
		   });		
		addAnnotation
		  (getAttribute_VisibleInSimple(), 
		   source, 
		   new String[] {
			 "documentation", "Whether this attribute is visible in simple entity listing (e.g. \'ls\' shell command)."
		   });		
		addAnnotation
		  (getAttribute_SearchableInQuick(), 
		   source, 
		   new String[] {
			 "documentation", "Whether this attribute is included in quick searches (e.g. \'search\' shell command.)\n\nNote: If the repository is not code-generated, the search behavior depends on Repository.search() implementation.\nHowever, it is used for generation of \'search\' shell command and soon, search UI."
		   });		
		addAnnotation
		  (getAttribute_FieldWidth(), 
		   source, 
		   new String[] {
			 "documentation", "Field width, in characters. Used by text-based UI like Shell."
		   });		
		addAnnotation
		  (getAttribute_Principal(), 
		   source, 
		   new String[] {
			 "documentation", "If true, this attribute will be used as principal in VariedProduct (has no effect in SimpleProduct).\n\nA VariedProduct may also override the principals in use for that specific product (this mechanism is not yet defined)."
		   });		
		addAnnotation
		  (valueEClass, 
		   source, 
		   new String[] {
			 "documentation", "Attribute having single or multiple values.\n\n{\nattributes:\n  color: [{value: \"red\", displayValue: \"Merah\"}],\n  berbatikMaterial: [{value: \"katun\", displayValue: \"Katun\"}],\n  berbatikShawlLength: [{value: \"90cm\", displayValue: \"90 cm\"}],\nmixins: {\n  \"color\": {\n    attributeTypes: {\n      color: {className: \"TermValue\", \"name\": \"color\", \"label\": \"Warna\"}, // nsPrefix: builtin\n    },\n  \"berbatik\": {\n    attributeTypes: {\n      berbatikMaterial: {className: \"TermValue\", nsPrefix: \"berbatik\", name: \"material\", label: \"Material\"},\n      berbatikBatikAge: {className: \"TermValue\", nsPrefix: \"berbatik\", name: \"batikAge\", label: \"Batik Age\"},\n    }\n  },\n}\n\n\n\"berbatik:material\": [{value: \"Katun\"}],\n\nnggak enak:\nproduct[\'berbatik:material\'][0].displayValue\n\nlebih enak:\n\n<p>Warna: {{product.attributes.color.0.displayValue}}</p>\n<p>Material: {{product.attributes.berbatikMaterial.0.displayValue}}</p>\n"
		   });		
		addAnnotation
		  (valueEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Convert the mixin value to a single string. Paths are separated with \'/\'. Ranges are separated with \"-\" or \"..\" (TODO: which one?).\nSemantics are prefixed: \"<\", \"<=\", \">\", \">=\". equal \"=\" is default if not specified.\n\n<p>9 cm would be \"9cm\". Bags > Hobos would be \"bags_hobos\" (using ID) or \"bags/hobos\" (using slugPath).\n\n<p>9 cm, 20 km would be \"9cm,20km\".\n\n<p>\"2012-12-30-2012-12-30\"\n\"2012-12-30..2012-12-30\"\n\"2012-12-30T15:15:70.863+0700-2012-12-30T15:15:70.863+0700\"\n\"2012-12-30T15:15:70.863+0700..2012-12-30T15:15:70.863+0700\"\n\"atang-sutisna-rudi-wijaya\"\n\"atang-sutisna..rudi-wijaya\"\n\"atang_sutisna-rudi_wijaya\"\n\"atang_sutisna..rudi_wijaya\"\n"
		   });		
		addAnnotation
		  (valueEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Primary value of the attribute in native type. There may be complementary values like unit.\nIn multiple attribute values, this returns the first value.\n\n<p>Note: setting the value will clear all values and reset to a list with 1 element."
		   });		
		addAnnotation
		  (getValue_Semantic(), 
		   source, 
		   new String[] {
			 "documentation", "Optional semantic of this value.\n\ni.e. value = 50 cm, semantic = less than, means \"< 50 cm\"."
		   });		
		addAnnotation
		  (measureValueEClass, 
		   source, 
		   new String[] {
			 "documentation", "Mixin with measured unit."
		   });		
		addAnnotation
		  (currencyValueEClass, 
		   source, 
		   new String[] {
			 "documentation", "Mixin with monetary value and currency code."
		   });		
		addAnnotation
		  (mixinEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Return the nsPrefix_name."
		   });		
		addAnnotation
		  (rangeValueEClass, 
		   source, 
		   new String[] {
			 "documentation", "Range attribute\'s primary value can be either the start or end value."
		   });		
		addAnnotation
		  (termValueEClass, 
		   source, 
		   new String[] {
			 "documentation", "Use a taxonomy term. \'value\' is the ID of the term."
		   });		
		addAnnotation
		  (getTermValue_SlugPath(), 
		   source, 
		   new String[] {
			 "documentation", "\'/\'-separated slug path."
		   });		
		addAnnotation
		  (vocabEClass, 
		   source, 
		   new String[] {
			 "documentation", "pindah jd attributetype."
		   });			
		addAnnotation
		  (termEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Return the nsPrefix_name."
		   });		
		addAnnotation
		  (termEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Given a base {@code imagesUri} (can be either secure or insecure), returns the term image URI if available, or {@code null} if {@link #getImageId()} is empty."
		   });		
		addAnnotation
		  (getTerm_DisplayName(), 
		   source, 
		   new String[] {
			 "documentation", "Human friendly name."
		   });		
		addAnnotation
		  (getTerm_ImageId(), 
		   source, 
		   new String[] {
			 "documentation", "If a term has specified an image, the image ID in the predefined image directories or {@link org.soluvas.image.store.ImageRepository}, it\'s highly recommended to just use the {@link #getName()} as {@code imageId}.\n\n<p>Using image directories and URI templates is common because URI can be created without needing Wicket (e.g. inside email notification) and optionally CDN and even HTTPS. The logic is:\n<ol>\n<li>if Term {@link #getNsPrefix()} is {@code base}, the URI is <tt>{secure|imagesUri}/org.soluvas.data/{kindNsPrefix}_{kindName}/{imageId}.png</tt></li>\n<li>if Term {@link #getNsPrefix()} is not {@code base}, the URI is <tt>{secure|imagesUri}/term/{nsPrefix}/{kindNsPrefix}_{kindName}/{imageId}.png</tt> (since Bippo 5.4.x)</li>\n</ol>\n<p>Note that {@code imagesUri} can be CDN and/or secure. A shared hostname such as {@code bipporeg-prd-img.bipposhop.com} is recommended\n(to make CloudFlare, SSL, and DNS wildcard settings practical). The {@code nsPrefix == tenantId} is part of the URI to support this deployment approach.\n\n<p>When {@link org.soluvas.image.store.ImageRepository} is used, it depends on the {@link #getKindNsPrefix()} and {@link #getKindName()}.\n\nTODO: provide a way to specify a static image instead (using \'imagesUri\')."
		   });		
		addAnnotation
		  (getTerm_KindNsPrefix(), 
		   source, 
		   new String[] {
			 "documentation", "The nsPrefix of the {@link Kind} of this term. For example, for kind \"base_Color\", nsPrefix is \"base\".\n\nTerm is optionally linked to {@link Kind}, not to {@link Attribute}."
		   });		
		addAnnotation
		  (getTerm_KindName(), 
		   source, 
		   new String[] {
			 "documentation", "The name of the {@link Kind} of this term. For example, for kind \"base_Color\", name is \"Color\".\n\nTerm is optionally linked to {@link Kind}, not to {@link Attribute}."
		   });					
		addAnnotation
		  (getTermContainer_Terms(), 
		   source, 
		   new String[] {
			 "documentation", "List of terms in a Vocabulary or if the Term is nested (tree vocabulary)."
		   });			
		addAnnotation
		  (dataCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains collections of data objects: kinds, terms."
		   });		
		addAnnotation
		  (kindEClass, 
		   source, 
		   new String[] {
			 "documentation", "1. Kind (Attribute Type / Vocab) is like an EMF DataType or Enum.\nA Kind is always type-agnostic, but a default input method & unit can be hinted by the attribute (see below).\nA Kind is always cardinality agnostic.\nFor example, Length kind is hinted as \"measure\" with \"cm\" unit, however all the attribute values below are valid:\n1. 9 cm (just like the hint)\n2. 10 km (different unit)\n3. 9-12 cm (use unit like the hint, but RangeValue instead)\n4. 5-6 kg (different unit and use RangeValue)\n5. \"cukup panjang untuk orang dewasa\" (StringValue)\n6. base_very_long (TermValue from base nsPrefix)\n7. tuneeca_half_a_mile (TermValue from tuneeca nsPrefix)\nIn addition, all of the above can have multiple cardinality or no value."
		   });		
		addAnnotation
		  (inputMethodEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Attribute can hint the inputMethod (string, measure, range, currency, term)  and inputUnit. But user can always override this.\n\nFor currency, the default currency depends on user setting, which if absent, defaults to Shop/Mall setting."
		   });		
		addAnnotation
		  (mixinCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains a collection of mixins."
		   });		
		addAnnotation
		  (statusMaskEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Status filter mask, to be used in findAll(), findOne(), count(), etc.\nSome implementations, like CouchDB (Map views), is more practically implemented using predefined mask values instead of Set[Enum].\nMask is also about semantics, loosely related to actual entity-specific status values."
		   });		
		addAnnotation
		  (statusMaskEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Return everything, including but not limited to, INACTIVE, DRAFT and VOID. Usually used for sysadmin only."
		   });		
		addAnnotation
		  (statusMaskEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Return only ACTIVE | VALIDATED | VERIFIED entities. Usually used for frontend."
		   });		
		addAnnotation
		  (statusMaskEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Return ACTIVE | VALIDATED | VERIFIED plus INACTIVE. Usually used for backend, normal listing."
		   });		
		addAnnotation
		  (statusMaskEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Return DRAFT only. Usually used for backend, Drafts folder."
		   });		
		addAnnotation
		  (statusMaskEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Return VOID only. Usually used for backend, Trash folder."
		   });		
		addAnnotation
		  (lookupKeyEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Used by EntityNotFoundException to know what attribute was used to lookup."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Lookup via entity-scoped unique ID, which is common for backend pages and shell."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Lookup via slug, which is the most common for frontend pages."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Lookup via GUID, rarely used but usable in CouchDB."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Lookup based on email. Note that an entity may contain multiple emails."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Lookup based on Facebook ID (long). Note that an entity may contain multiple Facebook IDs."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Lookup based on Facebook username. Note that an entity may contain multiple Facebook usernames."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(6), 
		   source, 
		   new String[] {
			 "documentation", "Lookup based on Twitter ID (long). Note that an entity may contain multiple Twitter IDs."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(7), 
		   source, 
		   new String[] {
			 "documentation", "Lookup based on Twitter username. Note that an entity may contain multiple Twitter usernames."
		   });		
		addAnnotation
		  (lookupKeyEEnum.getELiterals().get(8), 
		   source, 
		   new String[] {
			 "documentation", "Mobile number, in international format, without any punctuation except for \"+\" prefix, e.g. \"+6281212345678\".\nNote that for lookup purposes, depending on the default country, a lookup for \"081212345678\" will match\nthe stored account having \"+6281212345678\".\nThe stored account MUST always contain the country code prefix."
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";																											
		addAnnotation
		  (vocabEClass, 
		   source, 
		   new String[] {
			 "name", "Vocab"
		   });								
		addAnnotation
		  (listVocabEClass, 
		   source, 
		   new String[] {
			 "name", "ListVocab"
		   });		
		addAnnotation
		  (treeVocabEClass, 
		   source, 
		   new String[] {
			 "name", "TreeVocab"
		   });		
		addAnnotation
		  (freeVocabEClass, 
		   source, 
		   new String[] {
			 "name", "FreeVocab"
		   });			
		addAnnotation
		  (dataCatalogEClass, 
		   source, 
		   new String[] {
			 "name", "DataCatalog"
		   });																				
	}
	
	public static DataPackage getInstance() {
		return eINSTANCE;
	}
	
	@Override
	protected Resource createResource(String uri) {
		// assume accessed from bipporeg-model
		return super.createResource("../../../org.soluvas.data/src/main/resources/org/soluvas/data/data.ecore");
	}

} //DataPackageImpl
