/**
 */
package org.soluvas.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Customer Role Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Permissions for Person domain.
 * <!-- end-model-doc -->
 * @see org.soluvas.security.SecurityPackage#getCustomerRoleAction()
 * @model
 * @generated
 */
public enum CustomerRoleAction implements Enumerator {
	/**
	 * The '<em><b>List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_VALUE
	 * @generated
	 * @ordered
	 */
	LIST(0, "list", "list"),

	/**
	 * The '<em><b>Modify</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFY_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFY(1, "modify", "modify"),

	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(2, "add", "add");

	/**
	 * The '<em><b>List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List all people.
	 * <!-- end-model-doc -->
	 * @see #LIST
	 * @model name="list"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_VALUE = 0;

	/**
	 * The '<em><b>Modify</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Modify a person (non-administrative attributes).
	 * <!-- end-model-doc -->
	 * @see #MODIFY
	 * @model name="modify"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFY_VALUE = 1;

	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Add a person.
	 * <!-- end-model-doc -->
	 * @see #ADD
	 * @model name="add"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Customer Role Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CustomerRoleAction[] VALUES_ARRAY =
		new CustomerRoleAction[] {
			LIST,
			MODIFY,
			ADD,
		};

	/**
	 * A public read-only list of all the '<em><b>Customer Role Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CustomerRoleAction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Customer Role Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CustomerRoleAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CustomerRoleAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Customer Role Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CustomerRoleAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CustomerRoleAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Customer Role Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CustomerRoleAction get(int value) {
		switch (value) {
			case LIST_VALUE: return LIST;
			case MODIFY_VALUE: return MODIFY;
			case ADD_VALUE: return ADD;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CustomerRoleAction(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CustomerRoleAction
