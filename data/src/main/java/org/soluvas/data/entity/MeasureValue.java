/**
 */
package org.soluvas.data.entity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Locale;

import javax.measure.Measure;
import javax.measure.unit.Unit;

import org.soluvas.commons.TranslationState;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.impl.MeasureValueImpl#getValueUnit <em>Value Unit</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MeasureValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
public class MeasureValue extends Value<BigDecimal> {
	/**
	 * The cached value of the '{@link #getValueUnit() <em>Value Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueUnit()
	 * @generated NOT
	 * @ordered
	 */
	protected Unit<?> valueUnit;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final BigDecimal VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated NOT
	 * @ordered
	 */
	protected BigDecimal value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MeasureValue() {
		super();
	}
	
	public MeasureValue(Measure<?> measure) {
		super();
		setValue(measure.decimalValue((Unit) measure.getUnit(), MathContext.UNLIMITED));
		setValueUnit(measure.getUnit());
	}

	public MeasureValue(Unit<?> unit, BigDecimal value) {
		super();
		setValue(value);
		setValueUnit(unit);
	}

	public MeasureValue(Unit<?> unit, double value) {
		super();
		setValue(new BigDecimal(value));
		setValueUnit(unit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Unit<?> getValueUnit() {
		return valueUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValueUnit(Unit<?> newValueUnit) {
		this.valueUnit = newValueUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValue(BigDecimal newValue) {
		this.value = newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@JsonIgnore
	public Measure<?> getMeasure() {
		return Measure.valueOf(getValue(), getValueUnit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (valueUnit: ");
		result.append(valueUnit);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public String getString() {
		return (getValue() != null ? getValue().toString() : "") + " " + getValueUnit();
	}
	
//	@Override
//	public void copyFrom(org.soluvas.data.Value<?> upValue) {
//		super.copyFrom(upValue);
//		if (upValue instanceof org.soluvas.data.MeasureValue) {
//			final org.soluvas.data.MeasureValue upMeasureValue = (org.soluvas.data.MeasureValue) upValue;
//			setValue(upMeasureValue.getValue());
//			setValueUnit(upMeasureValue.getValueUnit());
//		}
//	}

	public void fillAsNewDefault(Locale locale, Unit<?> unit) {
			setLanguage(locale.toLanguageTag());
			setOriginalLanguage(locale.toLanguageTag());
			setTranslationState(TranslationState.ORIGINAL);
			setValueUnit(unit);
	}

} //MeasureValueImpl
