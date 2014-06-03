/**
 */
package org.soluvas.data;

import javax.annotation.Nullable;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Colorable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Positionable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.Translatable;

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
 *   <li>{@link org.soluvas.data.Term#isBordered <em>Bordered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends TermContainer, BundleAware, NameContainer, ResourceAware, NsPrefixable, Imageable, Positionable, Colorable, Translatable {
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
	 * If a term has specified an image, the image ID in the predefined image directories or {@link org.soluvas.image.store.ImageRepository}, it's highly recommended to just use the {@link #getName()} as {@code imageId}.
	 * 
	 * <p>Using image directories and URI templates is common because URI can be created without needing Wicket (e.g. inside email notification) and optionally CDN and even HTTPS. The logic is:
	 * <ol>
	 * <li>if Term {@link #getNsPrefix()} is {@code base}, the URI is <tt>{secure|imagesUri}/org.soluvas.data/{kindNsPrefix}_{kindName}/{imageId}.png</tt></li>
	 * <li>if Term {@link #getNsPrefix()} is not {@code base}, the URI is <tt>{secure|imagesUri}/term/{nsPrefix}/{kindNsPrefix}_{kindName}/{imageId}.png</tt> (since Bippo 5.4.x)</li>
	 * </ol>
	 * <p>Note that {@code imagesUri} can be CDN and/or secure. A shared hostname such as {@code bipporeg-prd-img.bipposhop.com} is recommended
	 * (to make CloudFlare, SSL, and DNS wildcard settings practical). The {@code nsPrefix == tenantId} is part of the URI to support this deployment approach.
	 * 
	 * <p>When {@link org.soluvas.image.store.ImageRepository} is used, it depends on the {@link #getKindNsPrefix()} and {@link #getKindName()}.
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
	 * Returns the value of the '<em><b>Bordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bordered</em>' attribute.
	 * @see #setBordered(boolean)
	 * @see org.soluvas.data.DataPackage#getTerm_Bordered()
	 * @model
	 * @generated
	 */
	boolean isBordered();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Term#isBordered <em>Bordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bordered</em>' attribute.
	 * @see #isBordered()
	 * @generated
	 */
	void setBordered(boolean value);

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Given a base {@code imagesUri} (can be either secure or insecure), returns the term image URI if available, or {@code null} if {@link #getImageId()} is empty.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	@Nullable
	String getImageUri(String imagesUri);

} // Term
