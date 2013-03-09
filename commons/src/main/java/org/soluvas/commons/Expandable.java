/**
 */
package org.soluvas.commons;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expandable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Can be expanded upon loading by XmiObjectLoader.
 * 
 * Example is WebAddress, it will replace {+fqdn} with FQDN (useful for development).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.Expandable#getExpansionState <em>Expansion State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getExpandable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface Expandable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Expansion State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.soluvas.commons.ExpansionState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether attribute values are already expanded. If so, calling expand() will do nothing.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expansion State</em>' attribute.
	 * @see org.soluvas.commons.ExpansionState
	 * @see org.soluvas.commons.CommonsPackage#getExpandable_ExpansionState()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	ExpansionState getExpansionState();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expand attribute values.
	 * <!-- end-model-doc -->
	 * @model scopeDataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject>"
	 * @generated
	 */
	void expand(Map<String, Object> scope);

} // Expandable
