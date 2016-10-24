/**
 */
package org.soluvas.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assign Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Specify how a role should be assigned to a subject.
 * <!-- end-model-doc -->
 * @see org.soluvas.security.SecurityPackage#getAssignMode()
 * @model
 * @generated
 */
public enum AssignMode implements Enumerator {
	/**
	 * The '<em><b>Manual</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUAL_VALUE
	 * @generated
	 * @ordered
	 */
	MANUAL(0, "manual", "manual"),

	/**
	 * The '<em><b>Guest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUEST_VALUE
	 * @generated
	 * @ordered
	 */
	GUEST(1, "guest", "guest"),

	/**
	 * The '<em><b>Authenticated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHENTICATED_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHENTICATED(2, "authenticated", "authenticated");

	/**
	 * The '<em><b>Manual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Do not automatically assign this role.
	 * <!-- end-model-doc -->
	 * @see #MANUAL
	 * @model name="manual"
	 * @generated
	 * @ordered
	 */
	public static final int MANUAL_VALUE = 0;

	/**
	 * The '<em><b>Guest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This role is given to all subjects including guest (not logged in).
	 * <!-- end-model-doc -->
	 * @see #GUEST
	 * @model name="guest"
	 * @generated
	 * @ordered
	 */
	public static final int GUEST_VALUE = 1;

	/**
	 * The '<em><b>Authenticated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This role is given to all remembered or authenticated users.
	 * <!-- end-model-doc -->
	 * @see #AUTHENTICATED
	 * @model name="authenticated"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHENTICATED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Assign Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AssignMode[] VALUES_ARRAY =
		new AssignMode[] {
			MANUAL,
			GUEST,
			AUTHENTICATED,
		};

	/**
	 * A public read-only list of all the '<em><b>Assign Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AssignMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Assign Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assign Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssignMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assign Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssignMode get(int value) {
		switch (value) {
			case MANUAL_VALUE: return MANUAL;
			case GUEST_VALUE: return GUEST;
			case AUTHENTICATED_VALUE: return AUTHENTICATED;
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
	private AssignMode(int value, String name, String literal) {
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
	
} //AssignMode
