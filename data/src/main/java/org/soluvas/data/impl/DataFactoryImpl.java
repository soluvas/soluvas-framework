/**
 */
package org.soluvas.data.impl;

import javax.measure.DecimalMeasure;
import javax.measure.Measure;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.data.*;
import org.soluvas.data.AttributeSemantic;
import org.soluvas.data.CurrencyValue;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.FreeVocab;
import org.soluvas.data.ListVocab;
import org.soluvas.data.MeasureValue;
import org.soluvas.data.Mixin;
import org.soluvas.data.RangeValue;
import org.soluvas.data.StringValue;
import org.soluvas.data.Term;
import org.soluvas.data.TermValue;
import org.soluvas.data.TreeVocab;
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
			DataFactory theDataFactory = (DataFactory)EPackage.Registry.INSTANCE.getEFactory(DataPackage.eNS_URI);
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
			case DataPackage.ATTRIBUTE: return createAttribute();
			case DataPackage.STRING_VALUE: return createStringValue();
			case DataPackage.MEASURE_VALUE: return createMeasureValue();
			case DataPackage.CURRENCY_VALUE: return createCurrencyValue();
			case DataPackage.MIXIN: return createMixin();
			case DataPackage.RANGE_VALUE: return createRangeValue();
			case DataPackage.TERM_VALUE: return createTermValue();
			case DataPackage.TERM: return createTerm();
			case DataPackage.LIST_VOCAB: return createListVocab();
			case DataPackage.TREE_VOCAB: return createTreeVocab();
			case DataPackage.FREE_VOCAB: return createFreeVocab();
			case DataPackage.DATA_CATALOG: return createDataCatalog();
			case DataPackage.KIND: return createKind();
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
			case DataPackage.ATTRIBUTE_SEMANTIC:
				return createAttributeSemanticFromString(eDataType, initialValue);
			case DataPackage.INPUT_METHOD:
				return createInputMethodFromString(eDataType, initialValue);
			case DataPackage.STATUS_MASK:
				return createStatusMaskFromString(eDataType, initialValue);
			case DataPackage.LOOKUP_KEY:
				return createLookupKeyFromString(eDataType, initialValue);
			case DataPackage.CRUD_REPOSITORY:
				return createCrudRepositoryFromString(eDataType, initialValue);
			case DataPackage.PAGING_AND_SORTING_REPOSITORY:
				return createPagingAndSortingRepositoryFromString(eDataType, initialValue);
			case DataPackage.CRUD_REPOSITORY_BASE:
				return createCrudRepositoryBaseFromString(eDataType, initialValue);
			case DataPackage.MEASURE:
				return createMeasureFromString(eDataType, initialValue);
			case DataPackage.DECIMAL_MEASURE:
				return createDecimalMeasureFromString(eDataType, initialValue);
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
			case DataPackage.ATTRIBUTE_SEMANTIC:
				return convertAttributeSemanticToString(eDataType, instanceValue);
			case DataPackage.INPUT_METHOD:
				return convertInputMethodToString(eDataType, instanceValue);
			case DataPackage.STATUS_MASK:
				return convertStatusMaskToString(eDataType, instanceValue);
			case DataPackage.LOOKUP_KEY:
				return convertLookupKeyToString(eDataType, instanceValue);
			case DataPackage.CRUD_REPOSITORY:
				return convertCrudRepositoryToString(eDataType, instanceValue);
			case DataPackage.PAGING_AND_SORTING_REPOSITORY:
				return convertPagingAndSortingRepositoryToString(eDataType, instanceValue);
			case DataPackage.CRUD_REPOSITORY_BASE:
				return convertCrudRepositoryBaseToString(eDataType, instanceValue);
			case DataPackage.MEASURE:
				return convertMeasureToString(eDataType, instanceValue);
			case DataPackage.DECIMAL_MEASURE:
				return convertDecimalMeasureToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringValue createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	@Override
	public StringValue createStringValue(String value) {
		StringValueImpl StringValue = new StringValueImpl();
		StringValue.setValue(value);
		StringValue.setDisplayValue(value);
		return StringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MeasureValue createMeasureValue() {
		MeasureValueImpl measureValue = new MeasureValueImpl();
		return measureValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CurrencyValue createCurrencyValue() {
		CurrencyValueImpl currencyValue = new CurrencyValueImpl();
		return currencyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mixin createMixin() {
		MixinImpl mixin = new MixinImpl();
		return mixin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T> RangeValue<T> createRangeValue() {
		RangeValueImpl<T> rangeValue = new RangeValueImpl<T>();
		return rangeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TermValue createTermValue() {
		TermValueImpl termValue = new TermValueImpl();
		return termValue;
	}

	@Override
	public TermValue createTermValue(String value, String displayValue) {
		TermValueImpl termValue = new TermValueImpl();
		termValue.setId(value);
		termValue.setValue(value);
		termValue.setDisplayValue(displayValue);
		return termValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term createTerm() {
		TermImpl term = new TermImpl();
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListVocab createListVocab() {
		ListVocabImpl listVocab = new ListVocabImpl();
		return listVocab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TreeVocab createTreeVocab() {
		TreeVocabImpl treeVocab = new TreeVocabImpl();
		return treeVocab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FreeVocab createFreeVocab() {
		FreeVocabImpl freeVocab = new FreeVocabImpl();
		return freeVocab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataCatalog createDataCatalog() {
		DataCatalogImpl dataCatalog = new DataCatalogImpl();
		return dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kind createKind() {
		KindImpl kind = new KindImpl();
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeSemantic createAttributeSemanticFromString(EDataType eDataType, String initialValue) {
		AttributeSemantic result = AttributeSemantic.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeSemanticToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputMethod createInputMethodFromString(EDataType eDataType, String initialValue) {
		InputMethod result = InputMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInputMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusMask createStatusMaskFromString(EDataType eDataType, String initialValue) {
		StatusMask result = StatusMask.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatusMaskToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupKey createLookupKeyFromString(EDataType eDataType, String initialValue) {
		LookupKey result = LookupKey.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLookupKeyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public Measure<?, ?> createMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecimalMeasure<?> createDecimalMeasureFromString(EDataType eDataType, String initialValue) {
		return (DecimalMeasure<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDecimalMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
