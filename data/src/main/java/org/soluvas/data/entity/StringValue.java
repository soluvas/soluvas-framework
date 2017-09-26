/**
 */
package org.soluvas.data.entity;

import java.util.Locale;

import org.soluvas.commons.TranslationState;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>String Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.soluvas.data.impl.StringValueImpl#getValue <em>Value</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class StringValue extends Value<String> {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringValue() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(String newValue) {
		this.value = newValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

	public StringValue createStringValue(String value) {
		StringValue StringValue = new StringValue();
		StringValue.setValue(value);
		StringValue.setDisplayValue(value);
		return StringValue;
	}

//	@Override
//	public void copyFrom(org.soluvas.data.Value<?> upValue) {
//		super.copyFrom(upValue);
//		if (upValue instanceof org.soluvas.data.StringValue) {
//			final org.soluvas.data.StringValue upStringValue = (org.soluvas.data.StringValue) upValue;
//			setValue(upStringValue.getValue());
//		}
//	}

	public void fillAsNewDefault(Locale locale) {
		setLanguage(locale.toLanguageTag());
		setOriginalLanguage(locale.toLanguageTag());
		setTranslationState(TranslationState.ORIGINAL);
	}
	
	public void fillAsNew(Locale locale, String value) {
		setLanguage(locale.toLanguageTag());
		setOriginalLanguage(locale.toLanguageTag());
		setTranslationState(TranslationState.ORIGINAL);
		setValue(value);
		setDisplayValue(value);
	}

} // StringValueImpl
