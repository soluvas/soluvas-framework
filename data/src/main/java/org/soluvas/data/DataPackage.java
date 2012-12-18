/**
 */
package org.soluvas.data;

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
	 * The meta object id for the '{@link org.soluvas.data.AttributeType <em>Attribute Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.AttributeType
	 * @see org.soluvas.data.impl.DataPackageImpl#getAttributeType()
	 * @generated
	 */
	int ATTRIBUTE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__RESOURCE_TYPE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__RESOURCE_URI = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__RESOURCE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__BUNDLE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__LABEL = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Min Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__MIN_VALUES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__MAX_VALUES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Data Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__DATA_TYPE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.ValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 1;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__SEMANTIC = 0;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__DISPLAY_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.MeasureValueImpl <em>Measure Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.MeasureValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getMeasureValue()
	 * @generated
	 */
	int MEASURE_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__SEMANTIC = VALUE__SEMANTIC;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__DISPLAY_VALUE = VALUE__DISPLAY_VALUE;

	/**
	 * The feature id for the '<em><b>Value Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__VALUE_UNIT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__VALUE = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Measure Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.CurrencyValueImpl <em>Currency Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.CurrencyValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getCurrencyValue()
	 * @generated
	 */
	int CURRENCY_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__SEMANTIC = VALUE__SEMANTIC;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__DISPLAY_VALUE = VALUE__DISPLAY_VALUE;

	/**
	 * The feature id for the '<em><b>Currency Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__CURRENCY_UNIT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Currency Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.MixinImpl <em>Mixin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.MixinImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getMixin()
	 * @generated
	 */
	int MIXIN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__RESOURCE_TYPE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__RESOURCE_URI = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__RESOURCE_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__BUNDLE = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__NS_PREFIX = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__DESCRIPTION = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Attribute Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__ATTRIBUTE_TYPES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Mixin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.RangeValueImpl <em>Range Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.RangeValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getRangeValue()
	 * @generated
	 */
	int RANGE_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__SEMANTIC = VALUE__SEMANTIC;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__DISPLAY_VALUE = VALUE__DISPLAY_VALUE;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__START_VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__END_VALUE = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.TermValueImpl <em>Term Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.TermValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getTermValue()
	 * @generated
	 */
	int TERM_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__SEMANTIC = VALUE__SEMANTIC;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__DISPLAY_VALUE = VALUE__DISPLAY_VALUE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__ID = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__SLUG = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__TERM = VALUE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Slug Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__SLUG_PATH = VALUE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__VALUE = VALUE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Term Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.data.TermContainer <em>Term Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.TermContainer
	 * @see org.soluvas.data.impl.DataPackageImpl#getTermContainer()
	 * @generated
	 */
	int TERM_CONTAINER = 12;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_CONTAINER__TERMS = 0;

	/**
	 * The number of structural features of the '<em>Term Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.VocabImpl <em>Vocab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.VocabImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getVocab()
	 * @generated
	 */
	int VOCAB = 7;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__TERMS = TERM_CONTAINER__TERMS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__BUNDLE = TERM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__RESOURCE_TYPE = TERM_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__RESOURCE_URI = TERM_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__RESOURCE_NAME = TERM_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__NS_PREFIX = TERM_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB__DESCRIPTION = TERM_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Vocab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCAB_FEATURE_COUNT = TERM_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.TermImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 8;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TERMS = TERM_CONTAINER__TERMS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__BUNDLE = TERM_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NAME = TERM_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__RESOURCE_TYPE = TERM_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__RESOURCE_URI = TERM_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__RESOURCE_NAME = TERM_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vocab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__VOCAB = TERM_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = TERM_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.ListVocabImpl <em>List Vocab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.ListVocabImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getListVocab()
	 * @generated
	 */
	int LIST_VOCAB = 9;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__TERMS = VOCAB__TERMS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__BUNDLE = VOCAB__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__RESOURCE_TYPE = VOCAB__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__RESOURCE_URI = VOCAB__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__RESOURCE_NAME = VOCAB__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__NS_PREFIX = VOCAB__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB__DESCRIPTION = VOCAB__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>List Vocab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VOCAB_FEATURE_COUNT = VOCAB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.TreeVocabImpl <em>Tree Vocab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.TreeVocabImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getTreeVocab()
	 * @generated
	 */
	int TREE_VOCAB = 10;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__TERMS = VOCAB__TERMS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__BUNDLE = VOCAB__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__RESOURCE_TYPE = VOCAB__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__RESOURCE_URI = VOCAB__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__RESOURCE_NAME = VOCAB__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__NS_PREFIX = VOCAB__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB__DESCRIPTION = VOCAB__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Tree Vocab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VOCAB_FEATURE_COUNT = VOCAB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.FreeVocabImpl <em>Free Vocab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.FreeVocabImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getFreeVocab()
	 * @generated
	 */
	int FREE_VOCAB = 11;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__TERMS = VOCAB__TERMS;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__BUNDLE = VOCAB__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__RESOURCE_TYPE = VOCAB__RESOURCE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__RESOURCE_URI = VOCAB__RESOURCE_URI;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__RESOURCE_NAME = VOCAB__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__NS_PREFIX = VOCAB__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB__DESCRIPTION = VOCAB__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Free Vocab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_VOCAB_FEATURE_COUNT = VOCAB_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.DataCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.DataCatalogImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getDataCatalog()
	 * @generated
	 */
	int DATA_CATALOG = 13;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__BUNDLE = CommonsPackage.BUNDLE_AWARE__BUNDLE;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__RESOURCE_TYPE = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__RESOURCE_URI = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__RESOURCE_NAME = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__NAME = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vocabs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__VOCABS = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__MIXINS = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__TERMS = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Attribute Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__ATTRIBUTE_TYPES = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG_FEATURE_COUNT = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.soluvas.data.AttributeSemantic <em>Attribute Semantic</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.AttributeSemantic
	 * @see org.soluvas.data.impl.DataPackageImpl#getAttributeSemantic()
	 * @generated
	 */
	int ATTRIBUTE_SEMANTIC = 14;

	/**
	 * The meta object id for the '<em>Crud Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepository()
	 * @generated
	 */
	int CRUD_REPOSITORY = 15;

	/**
	 * The meta object id for the '<em>Paging And Sorting Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.PagingAndSortingRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getPagingAndSortingRepository()
	 * @generated
	 */
	int PAGING_AND_SORTING_REPOSITORY = 16;

	/**
	 * The meta object id for the '<em>Crud Repository Base</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepositoryBase
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepositoryBase()
	 * @generated
	 */
	int CRUD_REPOSITORY_BASE = 17;


	/**
	 * The meta object id for the '<em>Measure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.Measure
	 * @see org.soluvas.data.impl.DataPackageImpl#getMeasure()
	 * @generated
	 */
	int MEASURE = 18;

	/**
	 * The meta object id for the '<em>Decimal Measure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.DecimalMeasure
	 * @see org.soluvas.data.impl.DataPackageImpl#getDecimalMeasure()
	 * @generated
	 */
	int DECIMAL_MEASURE = 19;


	/**
	 * Returns the meta object for class '{@link org.soluvas.data.AttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Type</em>'.
	 * @see org.soluvas.data.AttributeType
	 * @generated
	 */
	EClass getAttributeType();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.AttributeType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.soluvas.data.AttributeType#getLabel()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.AttributeType#getMinValues <em>Min Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Values</em>'.
	 * @see org.soluvas.data.AttributeType#getMinValues()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_MinValues();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.AttributeType#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see org.soluvas.data.AttributeType#getMaxValues()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.AttributeType#getDataTypeName <em>Data Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type Name</em>'.
	 * @see org.soluvas.data.AttributeType#getDataTypeName()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_DataTypeName();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.soluvas.data.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Value#getSemantic <em>Semantic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Semantic</em>'.
	 * @see org.soluvas.data.Value#getSemantic()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Semantic();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Value#getDisplayValue <em>Display Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Value</em>'.
	 * @see org.soluvas.data.Value#getDisplayValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_DisplayValue();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.MeasureValue <em>Measure Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Value</em>'.
	 * @see org.soluvas.data.MeasureValue
	 * @generated
	 */
	EClass getMeasureValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.MeasureValue#getValueUnit <em>Value Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Unit</em>'.
	 * @see org.soluvas.data.MeasureValue#getValueUnit()
	 * @see #getMeasureValue()
	 * @generated
	 */
	EAttribute getMeasureValue_ValueUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.MeasureValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.soluvas.data.MeasureValue#getValue()
	 * @see #getMeasureValue()
	 * @generated
	 */
	EAttribute getMeasureValue_Value();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.CurrencyValue <em>Currency Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Currency Value</em>'.
	 * @see org.soluvas.data.CurrencyValue
	 * @generated
	 */
	EClass getCurrencyValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.CurrencyValue#getCurrencyUnit <em>Currency Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Currency Unit</em>'.
	 * @see org.soluvas.data.CurrencyValue#getCurrencyUnit()
	 * @see #getCurrencyValue()
	 * @generated
	 */
	EAttribute getCurrencyValue_CurrencyUnit();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Mixin <em>Mixin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixin</em>'.
	 * @see org.soluvas.data.Mixin
	 * @generated
	 */
	EClass getMixin();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.data.Mixin#getAttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute Types</em>'.
	 * @see org.soluvas.data.Mixin#getAttributeTypes()
	 * @see #getMixin()
	 * @generated
	 */
	EReference getMixin_AttributeTypes();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.RangeValue <em>Range Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Value</em>'.
	 * @see org.soluvas.data.RangeValue
	 * @generated
	 */
	EClass getRangeValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.RangeValue#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see org.soluvas.data.RangeValue#getStartValue()
	 * @see #getRangeValue()
	 * @generated
	 */
	EAttribute getRangeValue_StartValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.RangeValue#getEndValue <em>End Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Value</em>'.
	 * @see org.soluvas.data.RangeValue#getEndValue()
	 * @see #getRangeValue()
	 * @generated
	 */
	EAttribute getRangeValue_EndValue();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.TermValue <em>Term Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Value</em>'.
	 * @see org.soluvas.data.TermValue
	 * @generated
	 */
	EClass getTermValue();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.data.TermValue#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Term</em>'.
	 * @see org.soluvas.data.TermValue#getTerm()
	 * @see #getTermValue()
	 * @generated
	 */
	EReference getTermValue_Term();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.TermValue#getSlugPath <em>Slug Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slug Path</em>'.
	 * @see org.soluvas.data.TermValue#getSlugPath()
	 * @see #getTermValue()
	 * @generated
	 */
	EAttribute getTermValue_SlugPath();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.TermValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.soluvas.data.TermValue#getValue()
	 * @see #getTermValue()
	 * @generated
	 */
	EAttribute getTermValue_Value();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Vocab <em>Vocab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocab</em>'.
	 * @see org.soluvas.data.Vocab
	 * @generated
	 */
	EClass getVocab();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see org.soluvas.data.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.data.Term#getVocab <em>Vocab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vocab</em>'.
	 * @see org.soluvas.data.Term#getVocab()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Vocab();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.ListVocab <em>List Vocab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Vocab</em>'.
	 * @see org.soluvas.data.ListVocab
	 * @generated
	 */
	EClass getListVocab();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.TreeVocab <em>Tree Vocab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Vocab</em>'.
	 * @see org.soluvas.data.TreeVocab
	 * @generated
	 */
	EClass getTreeVocab();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.FreeVocab <em>Free Vocab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Vocab</em>'.
	 * @see org.soluvas.data.FreeVocab
	 * @generated
	 */
	EClass getFreeVocab();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.TermContainer <em>Term Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Container</em>'.
	 * @see org.soluvas.data.TermContainer
	 * @generated
	 */
	EClass getTermContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.soluvas.data.TermContainer#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Terms</em>'.
	 * @see org.soluvas.data.TermContainer#getTerms()
	 * @see #getTermContainer()
	 * @generated
	 */
	EReference getTermContainer_Terms();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.DataCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.data.DataCatalog
	 * @generated
	 */
	EClass getDataCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.DataCatalog#getVocabs <em>Vocabs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vocabs</em>'.
	 * @see org.soluvas.data.DataCatalog#getVocabs()
	 * @see #getDataCatalog()
	 * @generated
	 */
	EReference getDataCatalog_Vocabs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.DataCatalog#getMixins <em>Mixins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mixins</em>'.
	 * @see org.soluvas.data.DataCatalog#getMixins()
	 * @see #getDataCatalog()
	 * @generated
	 */
	EReference getDataCatalog_Mixins();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.DataCatalog#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see org.soluvas.data.DataCatalog#getTerms()
	 * @see #getDataCatalog()
	 * @generated
	 */
	EReference getDataCatalog_Terms();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.DataCatalog#getAttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Types</em>'.
	 * @see org.soluvas.data.DataCatalog#getAttributeTypes()
	 * @see #getDataCatalog()
	 * @generated
	 */
	EReference getDataCatalog_AttributeTypes();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.data.AttributeSemantic <em>Attribute Semantic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attribute Semantic</em>'.
	 * @see org.soluvas.data.AttributeSemantic
	 * @generated
	 */
	EEnum getAttributeSemantic();

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
	 * Returns the meta object for data type '{@link javax.measure.Measure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Measure</em>'.
	 * @see javax.measure.Measure
	 * @model instanceClass="javax.measure.Measure" typeParameters="V Q" QBounds="org.soluvas.commons.Quantity"
	 * @generated
	 */
	EDataType getMeasure();

	/**
	 * Returns the meta object for data type '{@link javax.measure.DecimalMeasure <em>Decimal Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Decimal Measure</em>'.
	 * @see javax.measure.DecimalMeasure
	 * @model instanceClass="javax.measure.DecimalMeasure" typeParameters="Q" QBounds="org.soluvas.commons.Quantity"
	 * @generated
	 */
	EDataType getDecimalMeasure();

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
		 * The meta object literal for the '{@link org.soluvas.data.AttributeType <em>Attribute Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.AttributeType
		 * @see org.soluvas.data.impl.DataPackageImpl#getAttributeType()
		 * @generated
		 */
		EClass ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__LABEL = eINSTANCE.getAttributeType_Label();

		/**
		 * The meta object literal for the '<em><b>Min Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__MIN_VALUES = eINSTANCE.getAttributeType_MinValues();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__MAX_VALUES = eINSTANCE.getAttributeType_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Data Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__DATA_TYPE_NAME = eINSTANCE.getAttributeType_DataTypeName();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.ValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Semantic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__SEMANTIC = eINSTANCE.getValue_Semantic();

		/**
		 * The meta object literal for the '<em><b>Display Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__DISPLAY_VALUE = eINSTANCE.getValue_DisplayValue();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.MeasureValueImpl <em>Measure Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.MeasureValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getMeasureValue()
		 * @generated
		 */
		EClass MEASURE_VALUE = eINSTANCE.getMeasureValue();

		/**
		 * The meta object literal for the '<em><b>Value Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_VALUE__VALUE_UNIT = eINSTANCE.getMeasureValue_ValueUnit();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_VALUE__VALUE = eINSTANCE.getMeasureValue_Value();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.CurrencyValueImpl <em>Currency Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.CurrencyValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getCurrencyValue()
		 * @generated
		 */
		EClass CURRENCY_VALUE = eINSTANCE.getCurrencyValue();

		/**
		 * The meta object literal for the '<em><b>Currency Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CURRENCY_VALUE__CURRENCY_UNIT = eINSTANCE.getCurrencyValue_CurrencyUnit();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.MixinImpl <em>Mixin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.MixinImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getMixin()
		 * @generated
		 */
		EClass MIXIN = eINSTANCE.getMixin();

		/**
		 * The meta object literal for the '<em><b>Attribute Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIXIN__ATTRIBUTE_TYPES = eINSTANCE.getMixin_AttributeTypes();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.RangeValueImpl <em>Range Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.RangeValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getRangeValue()
		 * @generated
		 */
		EClass RANGE_VALUE = eINSTANCE.getRangeValue();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_VALUE__START_VALUE = eINSTANCE.getRangeValue_StartValue();

		/**
		 * The meta object literal for the '<em><b>End Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_VALUE__END_VALUE = eINSTANCE.getRangeValue_EndValue();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.TermValueImpl <em>Term Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.TermValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getTermValue()
		 * @generated
		 */
		EClass TERM_VALUE = eINSTANCE.getTermValue();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_VALUE__TERM = eINSTANCE.getTermValue_Term();

		/**
		 * The meta object literal for the '<em><b>Slug Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_VALUE__SLUG_PATH = eINSTANCE.getTermValue_SlugPath();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_VALUE__VALUE = eINSTANCE.getTermValue_Value();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.VocabImpl <em>Vocab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.VocabImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getVocab()
		 * @generated
		 */
		EClass VOCAB = eINSTANCE.getVocab();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.TermImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '<em><b>Vocab</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__VOCAB = eINSTANCE.getTerm_Vocab();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.ListVocabImpl <em>List Vocab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.ListVocabImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getListVocab()
		 * @generated
		 */
		EClass LIST_VOCAB = eINSTANCE.getListVocab();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.TreeVocabImpl <em>Tree Vocab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.TreeVocabImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getTreeVocab()
		 * @generated
		 */
		EClass TREE_VOCAB = eINSTANCE.getTreeVocab();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.FreeVocabImpl <em>Free Vocab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.FreeVocabImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getFreeVocab()
		 * @generated
		 */
		EClass FREE_VOCAB = eINSTANCE.getFreeVocab();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.TermContainer <em>Term Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.TermContainer
		 * @see org.soluvas.data.impl.DataPackageImpl#getTermContainer()
		 * @generated
		 */
		EClass TERM_CONTAINER = eINSTANCE.getTermContainer();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_CONTAINER__TERMS = eINSTANCE.getTermContainer_Terms();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.DataCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.DataCatalogImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getDataCatalog()
		 * @generated
		 */
		EClass DATA_CATALOG = eINSTANCE.getDataCatalog();

		/**
		 * The meta object literal for the '<em><b>Vocabs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__VOCABS = eINSTANCE.getDataCatalog_Vocabs();

		/**
		 * The meta object literal for the '<em><b>Mixins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__MIXINS = eINSTANCE.getDataCatalog_Mixins();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__TERMS = eINSTANCE.getDataCatalog_Terms();

		/**
		 * The meta object literal for the '<em><b>Attribute Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__ATTRIBUTE_TYPES = eINSTANCE.getDataCatalog_AttributeTypes();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.AttributeSemantic <em>Attribute Semantic</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.AttributeSemantic
		 * @see org.soluvas.data.impl.DataPackageImpl#getAttributeSemantic()
		 * @generated
		 */
		EEnum ATTRIBUTE_SEMANTIC = eINSTANCE.getAttributeSemantic();

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

		/**
		 * The meta object literal for the '<em>Measure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.Measure
		 * @see org.soluvas.data.impl.DataPackageImpl#getMeasure()
		 * @generated
		 */
		EDataType MEASURE = eINSTANCE.getMeasure();

		/**
		 * The meta object literal for the '<em>Decimal Measure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.measure.DecimalMeasure
		 * @see org.soluvas.data.impl.DataPackageImpl#getDecimalMeasure()
		 * @generated
		 */
		EDataType DECIMAL_MEASURE = eINSTANCE.getDecimalMeasure();

	}

} //DataPackage
