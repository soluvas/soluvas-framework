/**
 */
package org.soluvas.data;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.Term#getVocab <em>Vocab</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getAttributeTypeNsPrefix <em>Attribute Type Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getAttributeTypeName <em>Attribute Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends TermContainer, BundleAware, NameContainer, ResourceAware {
	/**
	 * Returns the value of the '<em><b>Vocab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vocab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vocab</em>' reference.
	 * @see #setVocab(Vocab)
	 * @see org.soluvas.data.DataPackage#getTerm_Vocab()
	 * @model
	 * @generated
	 */
	Vocab getVocab();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getVocab <em>Vocab</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vocab</em>' reference.
	 * @see #getVocab()
	 * @generated
	 */
	void setVocab(Vocab value);

	/**
	 * Returns the value of the '<em><b>Attribute Type Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The nsPrefix of the attributeType of this term. For example, for attribute type "base_color", nsPrefix is "base".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute Type Ns Prefix</em>' attribute.
	 * @see #setAttributeTypeNsPrefix(String)
	 * @see org.soluvas.data.DataPackage#getTerm_AttributeTypeNsPrefix()
	 * @model
	 * @generated
	 */
	String getAttributeTypeNsPrefix();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getAttributeTypeNsPrefix <em>Attribute Type Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Type Ns Prefix</em>' attribute.
	 * @see #getAttributeTypeNsPrefix()
	 * @generated
	 */
	void setAttributeTypeNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Attribute Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the attributeType of this term. For example, for attribute type "base_color", attributeTypeName is "color".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute Type Name</em>' attribute.
	 * @see #setAttributeTypeName(String)
	 * @see org.soluvas.data.DataPackage#getTerm_AttributeTypeName()
	 * @model
	 * @generated
	 */
	String getAttributeTypeName();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getAttributeTypeName <em>Attribute Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Type Name</em>' attribute.
	 * @see #getAttributeTypeName()
	 * @generated
	 */
	void setAttributeTypeName(String value);

} // Term
