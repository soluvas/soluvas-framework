/**
 */
package org.soluvas.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Person Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Permissions for Person domain.
 * <!-- end-model-doc -->
 * @see org.soluvas.security.SecurityPackage#getPersonAction()
 * @model
 * @generated
 */
public enum PersonAction implements Enumerator {
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
	 * The '<em><b>View</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	VIEW(1, "view", "view"),

	/**
	 * The '<em><b>View administrative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEW_ADMINISTRATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	VIEW_ADMINISTRATIVE(2, "view_administrative", "view_administrative"),

	/**
	 * The '<em><b>Modify</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFY_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFY(3, "modify", "modify"),

	/**
	 * The '<em><b>Modify administrative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFY_ADMINISTRATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFY_ADMINISTRATIVE(4, "modify_administrative", "modify_administrative"),

	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(5, "add", "add");

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
	 * The '<em><b>View</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * View a person (non-administrative attributes).
	 * <!-- end-model-doc -->
	 * @see #VIEW
	 * @model name="view"
	 * @generated
	 * @ordered
	 */
	public static final int VIEW_VALUE = 1;

	/**
	 * The '<em><b>View administrative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * View a person (administrative or sensitive attributes, e.g. hashed password).
	 * <!-- end-model-doc -->
	 * @see #VIEW_ADMINISTRATIVE
	 * @model name="view_administrative"
	 * @generated
	 * @ordered
	 */
	public static final int VIEW_ADMINISTRATIVE_VALUE = 2;

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
	public static final int MODIFY_VALUE = 3;

	/**
	 * The '<em><b>Modify administrative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Modify a person (administrative or sensitive attributes, e.g. status, hashed password).
	 * <!-- end-model-doc -->
	 * @see #MODIFY_ADMINISTRATIVE
	 * @model name="modify_administrative"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFY_ADMINISTRATIVE_VALUE = 4;

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
	public static final int ADD_VALUE = 5;

	/**
	 * An array of all the '<em><b>Person Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PersonAction[] VALUES_ARRAY =
		new PersonAction[] {
			LIST,
			VIEW,
			VIEW_ADMINISTRATIVE,
			MODIFY,
			MODIFY_ADMINISTRATIVE,
			ADD,
		};

	/**
	 * A public read-only list of all the '<em><b>Person Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PersonAction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Person Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersonAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PersonAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Person Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersonAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PersonAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Person Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersonAction get(int value) {
		switch (value) {
			case LIST_VALUE: return LIST;
			case VIEW_VALUE: return VIEW;
			case VIEW_ADMINISTRATIVE_VALUE: return VIEW_ADMINISTRATIVE;
			case MODIFY_VALUE: return MODIFY;
			case MODIFY_ADMINISTRATIVE_VALUE: return MODIFY_ADMINISTRATIVE;
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
	private PersonAction(int value, String name, String literal) {
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
	
} //PersonAction
