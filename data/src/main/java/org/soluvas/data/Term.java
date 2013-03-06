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
 *   <li>{@link org.soluvas.data.Term#getKindNsPrefix <em>Kind Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.data.Term#getKindName <em>Kind Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends TermContainer, BundleAware, NameContainer, ResourceAware, NsPrefixable, Imageable, Positionable, Colorable {
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
	@Override
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
	 * Returns the value of the '<em><b>Kind Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The nsPrefix of the {@link Kind} of this term. For example, for kind "base_Color", nsPrefix is "base".
	 * 
	 * Term is optionally linked to {@link Kind}, not to {@link Attribute}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind Ns Prefix</em>' attribute.
	 * @see #setKindNsPrefix(String)
	 * @see org.soluvas.data.DataPackage#getTerm_KindNsPrefix()
	 * @model
	 * @generated
	 */
	String getKindNsPrefix();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getKindNsPrefix <em>Kind Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind Ns Prefix</em>' attribute.
	 * @see #getKindNsPrefix()
	 * @generated
	 */
	void setKindNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Kind Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the {@link Kind} of this term. For example, for kind "base_Color", name is "Color".
	 * 
	 * Term is optionally linked to {@link Kind}, not to {@link Attribute}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind Name</em>' attribute.
	 * @see #setKindName(String)
	 * @see org.soluvas.data.DataPackage#getTerm_KindName()
	 * @model
	 * @generated
	 */
	String getKindName();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#getKindName <em>Kind Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind Name</em>' attribute.
	 * @see #getKindName()
	 * @generated
	 */
	void setKindName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the nsPrefix_name.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TermValue toValue();

} // Term
