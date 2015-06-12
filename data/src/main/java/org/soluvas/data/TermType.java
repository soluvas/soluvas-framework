/**
 */
package org.soluvas.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Term Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.data.DataPackage#getTermType()
 * @model
 * @generated
 */
public enum TermType implements Enumerator {
	/**
	 * The '<em><b>Color</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR(0, "color", "color"),

	/**
	 * The '<em><b>Size</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SIZE(1, "size", "size"), /**
	 * The '<em><b>Shoe size</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOE_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SHOE_SIZE(2, "shoe_size", "shoe_size");

	/**
	 * The '<em><b>Color</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Color</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR
	 * @model name="color"
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_VALUE = 0;

	/**
	 * The '<em><b>Size</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * size for cloth
	 * <!-- end-model-doc -->
	 * @see #SIZE
	 * @model name="size"
	 * @generated
	 * @ordered
	 */
	public static final int SIZE_VALUE = 1;

	/**
	 * The '<em><b>Shoe size</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Shoe size</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOE_SIZE
	 * @model name="shoe_size"
	 * @generated
	 * @ordered
	 */
	public static final int SHOE_SIZE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Term Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TermType[] VALUES_ARRAY =
		new TermType[] {
			COLOR,
			SIZE,
			SHOE_SIZE,
		};

	/**
	 * A public read-only list of all the '<em><b>Term Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TermType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Term Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TermType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Term Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TermType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Term Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermType get(int value) {
		switch (value) {
			case COLOR_VALUE: return COLOR;
			case SIZE_VALUE: return SIZE;
			case SHOE_SIZE_VALUE: return SHOE_SIZE;
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
	private TermType(int value, String name, String literal) {
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
	
} //TermType
