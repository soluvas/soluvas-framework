/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Describable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.data.impl.MixinImpl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mixin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.Mixin#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.soluvas.data.Mixin#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getMixin()
 * @model
 * @generated
 */
@JsonDeserialize(as=MixinImpl.class)
public interface Mixin extends NameContainer, ResourceAware, BundleAware, NsPrefixable, Describable {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.data.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.soluvas.data.DataPackage#getMixin_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.soluvas.data.DataPackage#getMixin_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Mixin#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

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

} // Mixin
