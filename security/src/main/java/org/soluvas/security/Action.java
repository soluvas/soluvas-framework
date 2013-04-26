/**
 */
package org.soluvas.security;

import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Secured action.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.security.Action#getName <em>Name</em>}</li>
 *   <li>{@link org.soluvas.security.Action#getGlobal <em>Global</em>}</li>
 *   <li>{@link org.soluvas.security.Action#getDomains <em>Domains</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.security.SecurityPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends ResourceAware, Nameable, Describable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of action, e.g. "print", "edit", in lower_underscore format.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.soluvas.security.SecurityPackage#getAction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.soluvas.security.Action#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Global actions apply to the whole application, in addition to domain instances (if specified).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global</em>' attribute.
	 * @see #setGlobal(Boolean)
	 * @see org.soluvas.security.SecurityPackage#getAction_Global()
	 * @model
	 * @generated
	 */
	Boolean getGlobal();

	/**
	 * Sets the value of the '{@link org.soluvas.security.Action#getGlobal <em>Global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global</em>' attribute.
	 * @see #getGlobal()
	 * @generated
	 */
	void setGlobal(Boolean value);

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of domains this action applies to.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domains</em>' attribute list.
	 * @see org.soluvas.security.SecurityPackage#getAction_Domains()
	 * @model
	 * @generated
	 */
	EList<String> getDomains();

} // Action
