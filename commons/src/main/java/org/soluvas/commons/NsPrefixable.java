/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ns Prefixable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.NsPrefixable#getNsPrefix <em>Ns Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getNsPrefixable()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface NsPrefixable extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Context-specific NS prefix.
	 * 
	 * Comes from: getActionType().getEClass().getEPackage().getNsPrefix().
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.soluvas.commons.CommonsPackage#getNsPrefixable_NsPrefix()
	 * @model default=""
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.NsPrefixable#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

} // NsPrefixable
