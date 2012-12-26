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
 *   <li>{@link org.soluvas.data.Mixin#getAttributeTypes <em>Attribute Types</em>}</li>
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
	 * Returns the value of the '<em><b>Attribute Types</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.data.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Types</em>' reference list.
	 * @see org.soluvas.data.DataPackage#getMixin_AttributeTypes()
	 * @model
	 * @generated
	 */
	EList<AttributeType> getAttributeTypes();

} // Mixin
