/**
 */
package org.soluvas.data;

import java.util.Locale;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.data.StringValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.soluvas.data.DataPackage#getStringValue()
 * @model superTypes="org.soluvas.data.Value<org.eclipse.emf.ecore.EString>"
 * @generated
 */
public interface StringValue extends Value<String> {
	
	public void fillAsNewDefault(Locale locale);
	
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.soluvas.data.DataPackage#getStringValue_Value()
	 * @model
	 * @generated
	 */
	@Override
	String getValue();

	/**
	 * Sets the value of the '{@link org.soluvas.data.StringValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // StringValue

