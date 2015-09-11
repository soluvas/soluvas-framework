/**
 */
package org.soluvas.commons;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.AttributeSet#getPrincipals <em>Principals</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getAttributeSet()
 * @model
 * @generated
 */
public interface AttributeSet<T extends EObject, V> extends AttributeNotification<T, V> {

	/**
	 * Returns the value of the '<em><b>Principals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Principals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Principals</em>' attribute list.
	 * @see org.soluvas.commons.CommonsPackage#getAttributeSet_Principals()
	 * @model
	 * @generated
	 */
	EList<String> getPrincipals();
} // AttributeSet
