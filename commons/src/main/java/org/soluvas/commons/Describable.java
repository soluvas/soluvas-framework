/**
 */
package org.soluvas.commons;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Describable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Has description.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.Describable#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getDescribable()
 * @model interface="true" abstract="true"
 * @generated NOT
 */
public interface Describable {

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description for this entity, in <a href="https://en.wikipedia.org/wiki/AsciiDoc">AsciiDoc</a> format.
	 * If <a href="http://dev.w3.org/html5/rdfa/">HTML+RDFa (Linked Data)</a> format is desired, you should create a separate {@code descriptionHtml} attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.soluvas.commons.CommonsPackage#getDescribable_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Describable#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Describable
