/**
 */
package org.soluvas.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Attribute Semantic</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.data.DataPackage#getAttributeSemantic()
 * @model
 * @generated
 */
public enum AttributeSemantic implements Enumerator {
	/**
	 * The '<em><b>Equal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(0, "equal", "equal"),

	/**
	 * The '<em><b>Less than</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	LESS_THAN(1, "less_than", "less_than"),

	/**
	 * The '<em><b>Less than or equal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	LESS_THAN_OR_EQUAL(2, "less_than_or_equal", "lessThanOrEqual"),

	/**
	 * The '<em><b>Greater than</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN(3, "greater_than", "greater_than"),

	/**
	 * The '<em><b>Greater than or equal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN_OR_EQUAL(4, "greater_than_or_equal", "equalOrGreaterThan");

	/**
	 * The '<em><b>Equal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model name="equal"
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 0;

	/**
	 * The '<em><b>Less than</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Less than</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN
	 * @model name="less_than"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_THAN_VALUE = 1;

	/**
	 * The '<em><b>Less than or equal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Less than or equal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS_THAN_OR_EQUAL
	 * @model name="less_than_or_equal" literal="lessThanOrEqual"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_THAN_OR_EQUAL_VALUE = 2;

	/**
	 * The '<em><b>Greater than</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Greater than</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN
	 * @model name="greater_than"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_VALUE = 3;

	/**
	 * The '<em><b>Greater than or equal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Greater than or equal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_OR_EQUAL
	 * @model name="greater_than_or_equal" literal="equalOrGreaterThan"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Attribute Semantic</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AttributeSemantic[] VALUES_ARRAY =
		new AttributeSemantic[] {
			EQUAL,
			LESS_THAN,
			LESS_THAN_OR_EQUAL,
			GREATER_THAN,
			GREATER_THAN_OR_EQUAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Attribute Semantic</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AttributeSemantic> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Attribute Semantic</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeSemantic get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttributeSemantic result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attribute Semantic</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeSemantic getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AttributeSemantic result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Attribute Semantic</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttributeSemantic get(int value) {
		switch (value) {
			case EQUAL_VALUE: return EQUAL;
			case LESS_THAN_VALUE: return LESS_THAN;
			case LESS_THAN_OR_EQUAL_VALUE: return LESS_THAN_OR_EQUAL;
			case GREATER_THAN_VALUE: return GREATER_THAN;
			case GREATER_THAN_OR_EQUAL_VALUE: return GREATER_THAN_OR_EQUAL;
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
	private AttributeSemantic(int value, String name, String literal) {
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
	
} //AttributeSemantic
