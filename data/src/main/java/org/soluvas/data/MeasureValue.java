/**
 */
package org.soluvas.data;

import java.math.BigDecimal;
import java.util.Locale;

import javax.measure.Measure;
import javax.measure.unit.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Mixin with measured unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.MeasureValue#getValueUnit <em>Value Unit</em>}</li>
 *   <li>{@link org.soluvas.data.MeasureValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.soluvas.data.DataPackage#getMeasureValue()
 * @model superTypes="org.soluvas.data.Value<org.eclipse.emf.ecore.EBigDecimal>"
 * @generated
 */
public interface MeasureValue extends Value<BigDecimal> {
	
	public void fillAsNewDefault(Locale locale, Unit<?> unit);
	
	/**
	 * Returns the value of the '<em><b>Value Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Unit</em>' attribute.
	 * @see #setValueUnit(Unit)
	 * @see org.soluvas.data.DataPackage#getMeasureValue_ValueUnit()
	 * @model dataType="org.soluvas.commons.Unit<?>"
	 * @generated
	 */
	Unit<?> getValueUnit();

	/**
	 * Sets the value of the '{@link org.soluvas.data.MeasureValue#getValueUnit <em>Value Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Unit</em>' attribute.
	 * @see #getValueUnit()
	 * @generated
	 */
	void setValueUnit(Unit<?> value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(BigDecimal)
	 * @see org.soluvas.data.DataPackage#getMeasureValue_Value()
	 * @model
	 * @generated
	 */
	@Override
	BigDecimal getValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.MeasureValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BigDecimal value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.soluvas.data.Measure"
	 * @generated
	 */
	Measure getMeasure();

} // MeasureValue
