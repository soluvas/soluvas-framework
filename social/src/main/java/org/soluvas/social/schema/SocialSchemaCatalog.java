/**
 */
package org.soluvas.social.schema;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Social Schema Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The loader will load two files for each catalog:
 * 
 * 1. <catalogName>.StorySchemaCatalog.xmi, declaring the action/target/aggregation/story types, but not the structure.
 * 2. <catalogName>.ecore. This defines the structure of the types.
 * 
 * The loader will resolve eClass names mentioned in the StorySchemaCatalog inside the related ecore file.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getTargetTypes <em>Target Types</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix <em>Ns Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog()
 * @model
 * @generated
 */
public interface SocialSchemaCatalog extends ResourceAware, BundleAware {
	/**
	 * Returns the value of the '<em><b>Target Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.social.schema.TargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Types</em>' containment reference list.
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_TargetTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetType> getTargetTypes();

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to resolve a TargetType subject types inside ActionType.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_NsPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

} // SocialSchemaCatalog
