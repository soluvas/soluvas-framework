/**
 */
package org.soluvas.social.schema;

import org.eclipse.emf.common.util.EList;

import org.soluvas.commons.SerializableEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Type Removed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.social.schema.TargetTypeRemoved#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.social.schema.SchemaPackage#getTargetTypeRemoved()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface TargetTypeRemoved extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Target Types</b></em>' reference list.
	 * The list contents are of type {@link org.soluvas.social.schema.TargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Types</em>' reference list.
	 * @see org.soluvas.social.schema.SchemaPackage#getTargetTypeRemoved_TargetTypes()
	 * @model
	 * @generated
	 */
	EList<TargetType> getTargetTypes();

} // TargetTypeRemoved
