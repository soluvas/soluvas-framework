/**
 */
package org.soluvas.data.impl;

import java.math.BigDecimal;

import javax.measure.DecimalMeasure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.soluvas.data.DataPackage;
import org.soluvas.data.MeasureValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.MeasureValueImpl#getValueUnit <em>Value Unit</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MeasureValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasureValueImpl<Q extends Quantity> extends ValueImpl<BigDecimal> implements MeasureValue<Q> {
	/**
	 * The cached value of the '{@link #getValueUnit() <em>Value Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueUnit()
	 * @generated
	 * @ordered
	 */
	protected Unit<Q> valueUnit;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureValueImpl() {
		super();
	}

	public MeasureValueImpl(DecimalMeasure<Q> measure) {
		super();
		setValue(measure.getValue());
		setValueUnit(measure.getUnit());
	}

	public MeasureValueImpl(Unit<Q> unit, BigDecimal value) {
		super();
		setValue(value);
		setValueUnit(unit);
	}

	public MeasureValueImpl(Unit<Q> unit, double value) {
		super();
		setValue(new BigDecimal(value));
		setValueUnit(unit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.MEASURE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Unit<Q> getValueUnit() {
		return valueUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueUnit(Unit<Q> newValueUnit) {
		Unit<Q> oldValueUnit = valueUnit;
		valueUnit = newValueUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MEASURE_VALUE__VALUE_UNIT, oldValueUnit, valueUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(BigDecimal newValue) {
		BigDecimal oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.MEASURE_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DecimalMeasure<Q> getMeasure() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.MEASURE_VALUE__VALUE_UNIT:
				return getValueUnit();
			case DataPackage.MEASURE_VALUE__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.MEASURE_VALUE__VALUE_UNIT:
				setValueUnit((Unit<Q>)newValue);
				return;
			case DataPackage.MEASURE_VALUE__VALUE:
				setValue((BigDecimal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.MEASURE_VALUE__VALUE_UNIT:
				setValueUnit((Unit<Q>)null);
				return;
			case DataPackage.MEASURE_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.MEASURE_VALUE__VALUE_UNIT:
				return valueUnit != null;
			case DataPackage.MEASURE_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (valueUnit: ");
		result.append(valueUnit);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //MeasureValueImpl
