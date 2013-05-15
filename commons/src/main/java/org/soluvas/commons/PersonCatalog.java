/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.PersonCatalog#getPeople <em>People</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getPersonCatalog()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface PersonCatalog extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>People</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.commons.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People</em>' containment reference list.
	 * @see org.soluvas.commons.CommonsPackage#getPersonCatalog_People()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPeople();

} // PersonCatalog
