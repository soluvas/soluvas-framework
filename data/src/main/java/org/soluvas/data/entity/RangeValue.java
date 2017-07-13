/**
 */
package org.soluvas.data.entity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.impl.RangeValueImpl#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link org.soluvas.data.impl.RangeValueImpl#getEndValue <em>End Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeValue<T> extends Value<T> {
	/**
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected T startValue;

	/**
	 * The cached value of the '{@link #getEndValue() <em>End Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndValue()
	 * @generated
	 * @ordered
	 */
	protected T endValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeValue() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T getStartValue() {
		return startValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(T newStartValue) {
		this.startValue = newStartValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T getEndValue() {
		return endValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndValue(T newEndValue) {
		this.endValue = newEndValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startValue: ");
		result.append(startValue);
		result.append(", endValue: ");
		result.append(endValue);
		result.append(')');
		return result.toString();
	}
	
//	@Override
//	public void copyFrom(org.soluvas.data.Value<?> upValue) {
//		super.copyFrom(upValue);
//		if (upValue instanceof org.soluvas.data.RangeValue) {
//			final org.soluvas.data.RangeValue<T> upRangeValue = (org.soluvas.data.RangeValue) upValue;
//			setEndValue( upRangeValue.getEndValue() );
//			setStartValue( upRangeValue.getStartValue() );
//		}
//	}

} //RangeValueImpl
