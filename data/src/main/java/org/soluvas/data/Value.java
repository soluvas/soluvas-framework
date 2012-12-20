/**
 */
package org.soluvas.data;

import org.soluvas.commons.SerializableEObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Attribute having single or multiple values.
 * 
 * {
 * attributes:
 *   color: [{value: "red", displayValue: "Merah"}],
 *   berbatikMaterial: [{value: "katun", displayValue: "Katun"}],
 *   berbatikShawlLength: [{value: "90cm", displayValue: "90 cm"}],
 * mixins: {
 *   "color": {
 *     attributeTypes: {
 *       color: {className: "TermValue", "name": "color", "label": "Warna"}, // nsPrefix: builtin
 *     },
 *   "berbatik": {
 *     attributeTypes: {
 *       berbatikMaterial: {className: "TermValue", nsPrefix: "berbatik", name: "material", label: "Material"},
 *       berbatikBatikAge: {className: "TermValue", nsPrefix: "berbatik", name: "batikAge", label: "Batik Age"},
 *     }
 *   },
 * }
 * 
 * 
 * "berbatik:material": [{value: "Katun"}],
 * 
 * nggak enak:
 * product['berbatik:material'][0].displayValue
 * 
 * lebih enak:
 * 
 * <p>Warna: {{product.attributes.color.0.displayValue}}</p>
 * <p>Material: {{product.attributes.berbatikMaterial.0.displayValue}}</p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.Value#getSemantic <em>Semantic</em>}</li>
 *   <li>{@link org.soluvas.data.Value#getDisplayValue <em>Display Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getValue()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface Value<T> extends SerializableEObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary value of the attribute in native type. There may be complementary values like unit.
	 * In multiple attribute values, this returns the first value.
	 * 
	 * <p>Note: setting the value will clear all values and reset to a list with 1 element.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	T getValue();

	/**
	 * Returns the value of the '<em><b>Semantic</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.data.AttributeSemantic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional semantic of this value.
	 * 
	 * i.e. value = 50 cm, semantic = less than, means "< 50 cm".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Semantic</em>' attribute.
	 * @see org.soluvas.data.AttributeSemantic
	 * @see #setSemantic(AttributeSemantic)
	 * @see org.soluvas.data.DataPackage#getValue_Semantic()
	 * @model
	 * @generated
	 */
	AttributeSemantic getSemantic();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Value#getSemantic <em>Semantic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic</em>' attribute.
	 * @see org.soluvas.data.AttributeSemantic
	 * @see #getSemantic()
	 * @generated
	 */
	void setSemantic(AttributeSemantic value);

	/**
	 * Returns the value of the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Value</em>' attribute.
	 * @see #setDisplayValue(String)
	 * @see org.soluvas.data.DataPackage#getValue_DisplayValue()
	 * @model
	 * @generated
	 */
	String getDisplayValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Value#getDisplayValue <em>Display Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Value</em>' attribute.
	 * @see #getDisplayValue()
	 * @generated
	 */
	void setDisplayValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Convert the mixin value to a single string. Paths are separated with '/'. Ranges are separated with "-" or ".." (TODO: which one?).
	 * Semantics are prefixed: "<", "<=", ">", ">=". equal "=" is default if not specified.
	 * 
	 * <p>9 cm would be "9cm". Bags > Hobos would be "bags_hobos" (using ID) or "bags/hobos" (using slugPath).
	 * 
	 * <p>9 cm, 20 km would be "9cm,20km".
	 * 
	 * <p>"2012-12-30-2012-12-30"
	 * "2012-12-30..2012-12-30"
	 * "2012-12-30T15:15:70.863+0700-2012-12-30T15:15:70.863+0700"
	 * "2012-12-30T15:15:70.863+0700..2012-12-30T15:15:70.863+0700"
	 * "atang-sutisna-rudi-wijaya"
	 * "atang-sutisna..rudi-wijaya"
	 * "atang_sutisna-rudi_wijaya"
	 * "atang_sutisna..rudi_wijaya"
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	@JsonIgnore
	String getString();

} // Value
