/**
 */
package org.soluvas.data;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1. Kind (Attribute Type / Vocab) is like an EMF DataType or Enum.
 * A Kind is always type-agnostic, but a default input method & unit can be hinted by the attribute (see below).
 * A Kind is always cardinality agnostic.
 * For example, Length kind is hinted as "measure" with "cm" unit, however all the attribute values below are valid:
 * 1. 9 cm (just like the hint)
 * 2. 10 km (different unit)
 * 3. 9-12 cm (use unit like the hint, but RangeValue instead)
 * 4. 5-6 kg (different unit and use RangeValue)
 * 5. "cukup panjang untuk orang dewasa" (StringValue)
 * 6. base_very_long (TermValue from base nsPrefix)
 * 7. tuneeca_half_a_mile (TermValue from tuneeca nsPrefix)
 * In addition, all of the above can have multiple cardinality or no value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.data.Kind#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.soluvas.data.Kind#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.data.Kind#getSameAsUris <em>Same As Uris</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.data.DataPackage#getKind()
 * @model
 * @generated
 */
public interface Kind extends NsPrefixable, BundleAware, NameContainer, ResourceAware, Imageable, Describable {

	/**
	 * Returns the value of the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Id</em>' attribute.
	 * @see #setImageId(String)
	 * @see org.soluvas.data.DataPackage#getKind_ImageId()
	 * @model
	 * @generated
	 */
	@Override
	String getImageId();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Kind#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(String value);

	/**
	 * Returns the value of the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary Linked Data URI for <a href="http://www.w3.org/2002/07/owl#Class">owl:Class</a>, to be usable as property range, e.g. {@code http://purl.org/opdm/garment#Fabric}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Uri</em>' attribute.
	 * @see #setPrimaryUri(String)
	 * @see org.soluvas.data.DataPackage#getKind_PrimaryUri()
	 * @model
	 * @generated
	 */
	String getPrimaryUri();

	/**
	 * Sets the value of the '{@link org.soluvas.data.Kind#getPrimaryUri <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Uri</em>' attribute.
	 * @see #getPrimaryUri()
	 * @generated
	 */
	void setPrimaryUri(String value);

	/**
	 * Returns the value of the '<em><b>Same As Uris</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Additional <a href="http://schema.org/sameAs">sameAs</a> Linked Data URIs for <a href="http://www.w3.org/2002/07/owl#Class">owl:Class</a>, to be usable for inference or other purposes,
	 * e.g. {@code http://purl.org/opdm/garment#Fabric}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Same As Uris</em>' attribute list.
	 * @see org.soluvas.data.DataPackage#getKind_SameAsUris()
	 * @model
	 * @generated
	 */
	@JsonDeserialize(as=BasicEList.class)
	EList<String> getSameAsUris();
} // Kind
