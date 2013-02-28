/**
 */
package org.soluvas.data;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Colorable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Positionable;
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
 *   <li>{@link org.soluvas.data.Term#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getAttributeTypeNsPrefix <em>Attribute Type Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getAttributeTypeName <em>Attribute Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends TermContainer, BundleAware, NameContainer, ResourceAware, NsPrefixable, Colorable, Imageable, Positionable {
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
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Human friendly name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.soluvas.data.DataPackage#getTerm_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Image ID of the term in the repository (if available). The ImageRepository is usually using "term" namespace.
	 * 
	 * TODO: provide a way to specify a static image instead (using 'imagesUri').
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Image Id</em>' attribute.
	 * @see #setImageId(String)
	 * @see org.soluvas.data.DataPackage#getTerm_ImageId()
	 * @model
	 * @generated
	 */
	String getImageId();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(String value);

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
