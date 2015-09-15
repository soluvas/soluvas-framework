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
	 * The meta object id for the '{@link org.soluvas.data.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.AttributeImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DESCRIPTION = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__POSITIONER = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DISPLAY_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ENABLED = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Min Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MIN_VALUES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MAX_VALUES = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Data Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DATA_TYPE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Kind Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KIND_NS_PREFIX = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KIND_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Input Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INPUT_METHOD = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Input Unit Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INPUT_UNIT_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Visible In Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VISIBLE_IN_SIMPLE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Searchable In Quick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SEARCHABLE_IN_QUICK = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IMAGE_ID = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Field Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__FIELD_WIDTH = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Principal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PRINCIPAL = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PRIMARY_URI = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Same As Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SAME_AS_URIS = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 19;

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
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TRANSLATION_STATE = CommonsPackage.TRANSLATABLE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__ORIGINAL_LANGUAGE = CommonsPackage.TRANSLATABLE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__LANGUAGE = CommonsPackage.TRANSLATABLE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TRANSLATIONS = CommonsPackage.TRANSLATABLE__TRANSLATIONS;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__SEMANTIC = CommonsPackage.TRANSLATABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__DISPLAY_VALUE = CommonsPackage.TRANSLATABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = CommonsPackage.TRANSLATABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.StringValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__TRANSLATION_STATE = VALUE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__ORIGINAL_LANGUAGE = VALUE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__LANGUAGE = VALUE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__TRANSLATIONS = VALUE__TRANSLATIONS;

	/**
	 * The feature id for the '<em><b>Semantic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__SEMANTIC = VALUE__SEMANTIC;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__DISPLAY_VALUE = VALUE__DISPLAY_VALUE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.MeasureValueImpl <em>Measure Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.MeasureValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getMeasureValue()
	 * @generated
	 */
	int MEASURE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__TRANSLATION_STATE = VALUE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__ORIGINAL_LANGUAGE = VALUE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__LANGUAGE = VALUE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_VALUE__TRANSLATIONS = VALUE__TRANSLATIONS;

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
	int CURRENCY_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__TRANSLATION_STATE = VALUE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__ORIGINAL_LANGUAGE = VALUE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__LANGUAGE = VALUE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENCY_VALUE__TRANSLATIONS = VALUE__TRANSLATIONS;

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
	int MIXIN = 5;

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
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__ATTRIBUTES = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN__DISPLAY_NAME = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mixin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.RangeValueImpl <em>Range Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.RangeValueImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getRangeValue()
	 * @generated
	 */
	int RANGE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__TRANSLATION_STATE = VALUE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__ORIGINAL_LANGUAGE = VALUE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__LANGUAGE = VALUE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_VALUE__TRANSLATIONS = VALUE__TRANSLATIONS;

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
	int TERM_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__TRANSLATION_STATE = VALUE__TRANSLATION_STATE;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__ORIGINAL_LANGUAGE = VALUE__ORIGINAL_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__LANGUAGE = VALUE__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__TRANSLATIONS = VALUE__TRANSLATIONS;

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
	 * The feature id for the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE__PRIMARY_URI = VALUE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Term Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.soluvas.data.TermContainer <em>Term Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.TermContainer
	 * @see org.soluvas.data.impl.DataPackageImpl#getTermContainer()
	 * @generated
	 */
	int TERM_CONTAINER = 13;

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
	int VOCAB = 8;

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
	int TERM = 9;

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
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NS_PREFIX = TERM_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__POSITIONER = TERM_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__COLOR = TERM_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Translation State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TRANSLATION_STATE = TERM_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Original Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__ORIGINAL_LANGUAGE = TERM_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__LANGUAGE = TERM_CONTAINER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Translations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TRANSLATIONS = TERM_CONTAINER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Vocab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__VOCAB = TERM_CONTAINER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__DISPLAY_NAME = TERM_CONTAINER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__IMAGE_ID = TERM_CONTAINER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Kind Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__KIND_NS_PREFIX = TERM_CONTAINER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__KIND_NAME = TERM_CONTAINER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Bordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__BORDERED = TERM_CONTAINER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Image Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__IMAGE_URI = TERM_CONTAINER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__PRIMARY_URI = TERM_CONTAINER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Same As Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__SAME_AS_URIS = TERM_CONTAINER_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = TERM_CONTAINER_FEATURE_COUNT + 21;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.ListVocabImpl <em>List Vocab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.ListVocabImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getListVocab()
	 * @generated
	 */
	int LIST_VOCAB = 10;

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
	int TREE_VOCAB = 11;

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
	int FREE_VOCAB = 12;

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
	int DATA_CATALOG = 14;

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
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__TERMS = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Kinds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG__KINDS = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CATALOG_FEATURE_COUNT = CommonsPackage.BUNDLE_AWARE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.KindImpl <em>Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.KindImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getKind()
	 * @generated
	 */
	int KIND = 15;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__NS_PREFIX = CommonsPackage.NS_PREFIXABLE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__BUNDLE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__RESOURCE_TYPE = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__RESOURCE_URI = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__RESOURCE_NAME = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__DESCRIPTION = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__IMAGE_ID = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__PRIMARY_URI = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Same As Uris</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND__SAME_AS_URIS = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KIND_FEATURE_COUNT = CommonsPackage.NS_PREFIXABLE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.MixinCatalogImpl <em>Mixin Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.MixinCatalogImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getMixinCatalog()
	 * @generated
	 */
	int MIXIN_CATALOG = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_CATALOG__NAME = CommonsPackage.NAME_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_CATALOG__MIXINS = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mixin Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_CATALOG_FEATURE_COUNT = CommonsPackage.NAME_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.MixinManagerImpl <em>Mixin Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.MixinManagerImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getMixinManager()
	 * @generated
	 */
	int MIXIN_MANAGER = 17;

	/**
	 * The feature id for the '<em><b>Mixin Catalog</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_MANAGER__MIXIN_CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Mixins</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_MANAGER__MIXINS = 1;

	/**
	 * The number of structural features of the '<em>Mixin Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIXIN_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.impl.TermEntryImpl <em>Term Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.impl.TermEntryImpl
	 * @see org.soluvas.data.impl.DataPackageImpl#getTermEntry()
	 * @generated
	 */
	int TERM_ENTRY = 18;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Term Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.data.AttributeSemantic <em>Attribute Semantic</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.AttributeSemantic
	 * @see org.soluvas.data.impl.DataPackageImpl#getAttributeSemantic()
	 * @generated
	 */
	int ATTRIBUTE_SEMANTIC = 19;

	/**
	 * The meta object id for the '{@link org.soluvas.data.InputMethod <em>Input Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.InputMethod
	 * @see org.soluvas.data.impl.DataPackageImpl#getInputMethod()
	 * @generated
	 */
	int INPUT_METHOD = 20;

	/**
	 * The meta object id for the '{@link org.soluvas.data.StatusMask <em>Status Mask</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.StatusMask
	 * @see org.soluvas.data.impl.DataPackageImpl#getStatusMask()
	 * @generated
	 */
	int STATUS_MASK = 21;

	/**
	 * The meta object id for the '{@link org.soluvas.data.LookupKey <em>Lookup Key</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.LookupKey
	 * @see org.soluvas.data.impl.DataPackageImpl#getLookupKey()
	 * @generated
	 */
	int LOOKUP_KEY = 22;

	/**
	 * The meta object id for the '<em>Crud Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepository()
	 * @generated
	 */
	int CRUD_REPOSITORY = 23;

	/**
	 * The meta object id for the '<em>Paging And Sorting Repository</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.PagingAndSortingRepository
	 * @see org.soluvas.data.impl.DataPackageImpl#getPagingAndSortingRepository()
	 * @generated
	 */
	int PAGING_AND_SORTING_REPOSITORY = 24;

	/**
	 * The meta object id for the '<em>Crud Repository Base</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.repository.CrudRepositoryBase
	 * @see org.soluvas.data.impl.DataPackageImpl#getCrudRepositoryBase()
	 * @generated
	 */
	int CRUD_REPOSITORY_BASE = 25;


	/**
	 * The meta object id for the '<em>Measure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.measure.Measure
	 * @see org.soluvas.data.impl.DataPackageImpl#getMeasure()
	 * @generated
	 */
	int MEASURE = 26;

	/**
	 * The meta object id for the '<em>Pageable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.domain.Pageable
	 * @see org.soluvas.data.impl.DataPackageImpl#getPageable()
	 * @generated
	 */
	int PAGEABLE = 27;

	/**
	 * The meta object id for the '<em>Page</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.data.domain.Page
	 * @see org.soluvas.data.impl.DataPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 28;


	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.soluvas.data.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.soluvas.data.Attribute#getDisplayName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.soluvas.data.Attribute#isEnabled()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getMinValues <em>Min Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Values</em>'.
	 * @see org.soluvas.data.Attribute#getMinValues()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_MinValues();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getMaxValues <em>Max Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Values</em>'.
	 * @see org.soluvas.data.Attribute#getMaxValues()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_MaxValues();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getDataTypeName <em>Data Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type Name</em>'.
	 * @see org.soluvas.data.Attribute#getDataTypeName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DataTypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getKindNsPrefix <em>Kind Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Ns Prefix</em>'.
	 * @see org.soluvas.data.Attribute#getKindNsPrefix()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_KindNsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getKindName <em>Kind Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Name</em>'.
	 * @see org.soluvas.data.Attribute#getKindName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_KindName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getInputMethod <em>Input Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Method</em>'.
	 * @see org.soluvas.data.Attribute#getInputMethod()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_InputMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getInputUnitName <em>Input Unit Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Unit Name</em>'.
	 * @see org.soluvas.data.Attribute#getInputUnitName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_InputUnitName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#isVisibleInSimple <em>Visible In Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible In Simple</em>'.
	 * @see org.soluvas.data.Attribute#isVisibleInSimple()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_VisibleInSimple();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#isSearchableInQuick <em>Searchable In Quick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Searchable In Quick</em>'.
	 * @see org.soluvas.data.Attribute#isSearchableInQuick()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_SearchableInQuick();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.soluvas.data.Attribute#getImageId()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getFieldWidth <em>Field Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Width</em>'.
	 * @see org.soluvas.data.Attribute#getFieldWidth()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_FieldWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#isPrincipal <em>Principal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Principal</em>'.
	 * @see org.soluvas.data.Attribute#isPrincipal()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Principal();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Attribute#getPrimaryUri <em>Primary Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Uri</em>'.
	 * @see org.soluvas.data.Attribute#getPrimaryUri()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_PrimaryUri();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.data.Attribute#getSameAsUris <em>Same As Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Same As Uris</em>'.
	 * @see org.soluvas.data.Attribute#getSameAsUris()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_SameAsUris();

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
	 * Returns the meta object for class '{@link org.soluvas.data.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.soluvas.data.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.soluvas.data.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

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
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.Mixin#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.soluvas.data.Mixin#getAttributes()
	 * @see #getMixin()
	 * @generated
	 */
	EReference getMixin_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Mixin#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.soluvas.data.Mixin#getDisplayName()
	 * @see #getMixin()
	 * @generated
	 */
	EAttribute getMixin_DisplayName();

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
	 * Returns the meta object for the attribute '{@link org.soluvas.data.TermValue#getPrimaryUri <em>Primary Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Uri</em>'.
	 * @see org.soluvas.data.TermValue#getPrimaryUri()
	 * @see #getTermValue()
	 * @generated
	 */
	EAttribute getTermValue_PrimaryUri();

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
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.soluvas.data.Term#getDisplayName()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.soluvas.data.Term#getImageId()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getKindNsPrefix <em>Kind Ns Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Ns Prefix</em>'.
	 * @see org.soluvas.data.Term#getKindNsPrefix()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_KindNsPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getKindName <em>Kind Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Name</em>'.
	 * @see org.soluvas.data.Term#getKindName()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_KindName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#isBordered <em>Bordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bordered</em>'.
	 * @see org.soluvas.data.Term#isBordered()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_Bordered();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getImageUri <em>Image Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Uri</em>'.
	 * @see org.soluvas.data.Term#getImageUri()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_ImageUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Term#getPrimaryUri <em>Primary Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Uri</em>'.
	 * @see org.soluvas.data.Term#getPrimaryUri()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_PrimaryUri();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.data.Term#getSameAsUris <em>Same As Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Same As Uris</em>'.
	 * @see org.soluvas.data.Term#getSameAsUris()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_SameAsUris();

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
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.DataCatalog#getKinds <em>Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Kinds</em>'.
	 * @see org.soluvas.data.DataCatalog#getKinds()
	 * @see #getDataCatalog()
	 * @generated
	 */
	EReference getDataCatalog_Kinds();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.Kind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kind</em>'.
	 * @see org.soluvas.data.Kind
	 * @generated
	 */
	EClass getKind();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Kind#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.soluvas.data.Kind#getImageId()
	 * @see #getKind()
	 * @generated
	 */
	EAttribute getKind_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.Kind#getPrimaryUri <em>Primary Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Uri</em>'.
	 * @see org.soluvas.data.Kind#getPrimaryUri()
	 * @see #getKind()
	 * @generated
	 */
	EAttribute getKind_PrimaryUri();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.data.Kind#getSameAsUris <em>Same As Uris</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Same As Uris</em>'.
	 * @see org.soluvas.data.Kind#getSameAsUris()
	 * @see #getKind()
	 * @generated
	 */
	EAttribute getKind_SameAsUris();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.MixinCatalog <em>Mixin Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixin Catalog</em>'.
	 * @see org.soluvas.data.MixinCatalog
	 * @generated
	 */
	EClass getMixinCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.data.MixinCatalog#getMixins <em>Mixins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mixins</em>'.
	 * @see org.soluvas.data.MixinCatalog#getMixins()
	 * @see #getMixinCatalog()
	 * @generated
	 */
	EReference getMixinCatalog_Mixins();

	/**
	 * Returns the meta object for class '{@link org.soluvas.data.MixinManager <em>Mixin Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mixin Manager</em>'.
	 * @see org.soluvas.data.MixinManager
	 * @generated
	 */
	EClass getMixinManager();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.data.MixinManager#getMixinCatalog <em>Mixin Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mixin Catalog</em>'.
	 * @see org.soluvas.data.MixinManager#getMixinCatalog()
	 * @see #getMixinManager()
	 * @generated
	 */
	EReference getMixinManager_MixinCatalog();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.data.MixinManager#getMixins <em>Mixins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mixins</em>'.
	 * @see org.soluvas.data.MixinManager#getMixins()
	 * @see #getMixinManager()
	 * @generated
	 */
	EAttribute getMixinManager_Mixins();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Term Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.soluvas.data.Term"
	 * @generated
	 */
	EClass getTermEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTermEntry()
	 * @generated
	 */
	EAttribute getTermEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTermEntry()
	 * @generated
	 */
	EReference getTermEntry_Value();

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
	 * Returns the meta object for enum '{@link org.soluvas.data.InputMethod <em>Input Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Input Method</em>'.
	 * @see org.soluvas.data.InputMethod
	 * @generated
	 */
	EEnum getInputMethod();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.data.StatusMask <em>Status Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status Mask</em>'.
	 * @see org.soluvas.data.StatusMask
	 * @generated
	 */
	EEnum getStatusMask();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.data.LookupKey <em>Lookup Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lookup Key</em>'.
	 * @see org.soluvas.data.LookupKey
	 * @generated
	 */
	EEnum getLookupKey();

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
	 * @model instanceClass="javax.measure.Measure" typeParameters="Q" QBounds="org.soluvas.commons.Quantity"
	 * @generated
	 */
	EDataType getMeasure();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.domain.Pageable <em>Pageable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pageable</em>'.
	 * @see org.soluvas.data.domain.Pageable
	 * @model instanceClass="org.soluvas.data.domain.Pageable"
	 * @generated
	 */
	EDataType getPageable();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.data.domain.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Page</em>'.
	 * @see org.soluvas.data.domain.Page
	 * @model instanceClass="org.soluvas.data.domain.Page" serializeable="false" typeParameters="T"
	 * @generated
	 */
	EDataType getPage();

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
		 * The meta object literal for the '{@link org.soluvas.data.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.AttributeImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DISPLAY_NAME = eINSTANCE.getAttribute_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__ENABLED = eINSTANCE.getAttribute_Enabled();

		/**
		 * The meta object literal for the '<em><b>Min Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MIN_VALUES = eINSTANCE.getAttribute_MinValues();

		/**
		 * The meta object literal for the '<em><b>Max Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MAX_VALUES = eINSTANCE.getAttribute_MaxValues();

		/**
		 * The meta object literal for the '<em><b>Data Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DATA_TYPE_NAME = eINSTANCE.getAttribute_DataTypeName();

		/**
		 * The meta object literal for the '<em><b>Kind Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__KIND_NS_PREFIX = eINSTANCE.getAttribute_KindNsPrefix();

		/**
		 * The meta object literal for the '<em><b>Kind Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__KIND_NAME = eINSTANCE.getAttribute_KindName();

		/**
		 * The meta object literal for the '<em><b>Input Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__INPUT_METHOD = eINSTANCE.getAttribute_InputMethod();

		/**
		 * The meta object literal for the '<em><b>Input Unit Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__INPUT_UNIT_NAME = eINSTANCE.getAttribute_InputUnitName();

		/**
		 * The meta object literal for the '<em><b>Visible In Simple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VISIBLE_IN_SIMPLE = eINSTANCE.getAttribute_VisibleInSimple();

		/**
		 * The meta object literal for the '<em><b>Searchable In Quick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__SEARCHABLE_IN_QUICK = eINSTANCE.getAttribute_SearchableInQuick();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IMAGE_ID = eINSTANCE.getAttribute_ImageId();

		/**
		 * The meta object literal for the '<em><b>Field Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__FIELD_WIDTH = eINSTANCE.getAttribute_FieldWidth();

		/**
		 * The meta object literal for the '<em><b>Principal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__PRINCIPAL = eINSTANCE.getAttribute_Principal();

		/**
		 * The meta object literal for the '<em><b>Primary Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__PRIMARY_URI = eINSTANCE.getAttribute_PrimaryUri();

		/**
		 * The meta object literal for the '<em><b>Same As Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__SAME_AS_URIS = eINSTANCE.getAttribute_SameAsUris();

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
		 * The meta object literal for the '{@link org.soluvas.data.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.StringValueImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

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
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIXIN__ATTRIBUTES = eINSTANCE.getMixin_Attributes();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIXIN__DISPLAY_NAME = eINSTANCE.getMixin_DisplayName();

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
		 * The meta object literal for the '<em><b>Primary Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_VALUE__PRIMARY_URI = eINSTANCE.getTermValue_PrimaryUri();

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
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__DISPLAY_NAME = eINSTANCE.getTerm_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__IMAGE_ID = eINSTANCE.getTerm_ImageId();

		/**
		 * The meta object literal for the '<em><b>Kind Ns Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__KIND_NS_PREFIX = eINSTANCE.getTerm_KindNsPrefix();

		/**
		 * The meta object literal for the '<em><b>Kind Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__KIND_NAME = eINSTANCE.getTerm_KindName();

		/**
		 * The meta object literal for the '<em><b>Bordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__BORDERED = eINSTANCE.getTerm_Bordered();

		/**
		 * The meta object literal for the '<em><b>Image Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__IMAGE_URI = eINSTANCE.getTerm_ImageUri();

		/**
		 * The meta object literal for the '<em><b>Primary Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__PRIMARY_URI = eINSTANCE.getTerm_PrimaryUri();

		/**
		 * The meta object literal for the '<em><b>Same As Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__SAME_AS_URIS = eINSTANCE.getTerm_SameAsUris();

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
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__TERMS = eINSTANCE.getDataCatalog_Terms();

		/**
		 * The meta object literal for the '<em><b>Kinds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CATALOG__KINDS = eINSTANCE.getDataCatalog_Kinds();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.KindImpl <em>Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.KindImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getKind()
		 * @generated
		 */
		EClass KIND = eINSTANCE.getKind();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KIND__IMAGE_ID = eINSTANCE.getKind_ImageId();

		/**
		 * The meta object literal for the '<em><b>Primary Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KIND__PRIMARY_URI = eINSTANCE.getKind_PrimaryUri();

		/**
		 * The meta object literal for the '<em><b>Same As Uris</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KIND__SAME_AS_URIS = eINSTANCE.getKind_SameAsUris();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.MixinCatalogImpl <em>Mixin Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.MixinCatalogImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getMixinCatalog()
		 * @generated
		 */
		EClass MIXIN_CATALOG = eINSTANCE.getMixinCatalog();

		/**
		 * The meta object literal for the '<em><b>Mixins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIXIN_CATALOG__MIXINS = eINSTANCE.getMixinCatalog_Mixins();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.MixinManagerImpl <em>Mixin Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.MixinManagerImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getMixinManager()
		 * @generated
		 */
		EClass MIXIN_MANAGER = eINSTANCE.getMixinManager();

		/**
		 * The meta object literal for the '<em><b>Mixin Catalog</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIXIN_MANAGER__MIXIN_CATALOG = eINSTANCE.getMixinManager_MixinCatalog();

		/**
		 * The meta object literal for the '<em><b>Mixins</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIXIN_MANAGER__MIXINS = eINSTANCE.getMixinManager_Mixins();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.impl.TermEntryImpl <em>Term Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.impl.TermEntryImpl
		 * @see org.soluvas.data.impl.DataPackageImpl#getTermEntry()
		 * @generated
		 */
		EClass TERM_ENTRY = eINSTANCE.getTermEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_ENTRY__KEY = eINSTANCE.getTermEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_ENTRY__VALUE = eINSTANCE.getTermEntry_Value();

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
		 * The meta object literal for the '{@link org.soluvas.data.InputMethod <em>Input Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.InputMethod
		 * @see org.soluvas.data.impl.DataPackageImpl#getInputMethod()
		 * @generated
		 */
		EEnum INPUT_METHOD = eINSTANCE.getInputMethod();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.StatusMask <em>Status Mask</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.StatusMask
		 * @see org.soluvas.data.impl.DataPackageImpl#getStatusMask()
		 * @generated
		 */
		EEnum STATUS_MASK = eINSTANCE.getStatusMask();

		/**
		 * The meta object literal for the '{@link org.soluvas.data.LookupKey <em>Lookup Key</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.LookupKey
		 * @see org.soluvas.data.impl.DataPackageImpl#getLookupKey()
		 * @generated
		 */
		EEnum LOOKUP_KEY = eINSTANCE.getLookupKey();

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
		 * The meta object literal for the '<em>Pageable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.domain.Pageable
		 * @see org.soluvas.data.impl.DataPackageImpl#getPageable()
		 * @generated
		 */
		EDataType PAGEABLE = eINSTANCE.getPageable();

		/**
		 * The meta object literal for the '<em>Page</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.data.domain.Page
		 * @see org.soluvas.data.impl.DataPackageImpl#getPage()
		 * @generated
		 */
		EDataType PAGE = eINSTANCE.getPage();

	}

} //DataPackage
