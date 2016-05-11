/**
 */
package org.soluvas.image;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Duplicate Id Handling</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage#getDuplicateIdHandling()
 * @model
 * @generated
 */
public enum DuplicateIdHandling implements Enumerator {
	/**
	 * The '<em><b>Skip</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKIP_VALUE
	 * @generated
	 * @ordered
	 */
	SKIP(0, "skip", "skip"),

	/**
	 * The '<em><b>Overwrite</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERWRITE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERWRITE(1, "overwrite", "overwrite"),

	/**
	 * The '<em><b>Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(2, "add", "add"),

	/**
	 * The '<em><b>Error</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR(3, "error", "error");

	/**
	 * The '<em><b>Skip</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If ID already exists, skip (default, safest)
	 * <!-- end-model-doc -->
	 * @see #SKIP
	 * @model name="skip"
	 * @generated
	 * @ordered
	 */
	public static final int SKIP_VALUE = 0;

	/**
	 * The '<em><b>Overwrite</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If ID already exists, overwrite (common use)
	 * <!-- end-model-doc -->
	 * @see #OVERWRITE
	 * @model name="overwrite"
	 * @generated
	 * @ordered
	 */
	public static final int OVERWRITE_VALUE = 1;

	/**
	 * The '<em><b>Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If ID already exists, upload new image (not very useful)
	 * <!-- end-model-doc -->
	 * @see #ADD
	 * @model name="add"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 2;

	/**
	 * The '<em><b>Error</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If ID already exists, throw error (strict)
	 * <!-- end-model-doc -->
	 * @see #ERROR
	 * @model name="error"
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_VALUE = 3;

	/**
	 * An array of all the '<em><b>Duplicate Id Handling</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DuplicateIdHandling[] VALUES_ARRAY =
		new DuplicateIdHandling[] {
			SKIP,
			OVERWRITE,
			ADD,
			ERROR,
		};

	/**
	 * A public read-only list of all the '<em><b>Duplicate Id Handling</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DuplicateIdHandling> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Duplicate Id Handling</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DuplicateIdHandling get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DuplicateIdHandling result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Duplicate Id Handling</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DuplicateIdHandling getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DuplicateIdHandling result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Duplicate Id Handling</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DuplicateIdHandling get(int value) {
		switch (value) {
			case SKIP_VALUE: return SKIP;
			case OVERWRITE_VALUE: return OVERWRITE;
			case ADD_VALUE: return ADD;
			case ERROR_VALUE: return ERROR;
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
	private DuplicateIdHandling(int value, String name, String literal) {
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
	
} //DuplicateIdHandling
