/**
 */
package org.soluvas.image;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transform Gravity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage#getTransformGravity()
 * @model
 * @generated
 */
public enum TransformGravity implements Enumerator {
	/**
	 * The '<em><b>Center</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTER_VALUE
	 * @generated
	 * @ordered
	 */
	CENTER(0, "center", "center"),

	/**
	 * The '<em><b>Top center</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_CENTER_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_CENTER(1, "top_center", "top_center"), /**
	 * The '<em><b>Bottom center</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_CENTER_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_CENTER(6, "bottom_center", "bottom_center"), /**
	 * The '<em><b>Center left</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTER_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	CENTER_LEFT(4, "center_left", "center_left"), /**
	 * The '<em><b>Center right</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTER_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	CENTER_RIGHT(5, "center_right", "center_right"), /**
	 * The '<em><b>Top left</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_LEFT(2, "top_left", "top_left"),

	/**
	 * The '<em><b>Top right</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_RIGHT(3, "top_right", "top_right"),

	/**
	 * The '<em><b>Bottom left</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_LEFT(7, "bottom_left", "bottom_left"),

	/**
	 * The '<em><b>Bottom right</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_RIGHT(8, "bottom_right", "bottom_right");

	/**
	 * The '<em><b>Center</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Center</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTER
	 * @model name="center"
	 * @generated
	 * @ordered
	 */
	public static final int CENTER_VALUE = 0;

	/**
	 * The '<em><b>Top center</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top center</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_CENTER
	 * @model name="top_center"
	 * @generated
	 * @ordered
	 */
	public static final int TOP_CENTER_VALUE = 1;

	/**
	 * The '<em><b>Bottom center</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom center</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_CENTER
	 * @model name="bottom_center"
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_CENTER_VALUE = 6;

	/**
	 * The '<em><b>Center left</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Center left</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTER_LEFT
	 * @model name="center_left"
	 * @generated
	 * @ordered
	 */
	public static final int CENTER_LEFT_VALUE = 4;

	/**
	 * The '<em><b>Center right</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Center right</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTER_RIGHT
	 * @model name="center_right"
	 * @generated
	 * @ordered
	 */
	public static final int CENTER_RIGHT_VALUE = 5;

	/**
	 * The '<em><b>Top left</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top left</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_LEFT
	 * @model name="top_left"
	 * @generated
	 * @ordered
	 */
	public static final int TOP_LEFT_VALUE = 2;

	/**
	 * The '<em><b>Top right</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top right</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_RIGHT
	 * @model name="top_right"
	 * @generated
	 * @ordered
	 */
	public static final int TOP_RIGHT_VALUE = 3;

	/**
	 * The '<em><b>Bottom left</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom left</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_LEFT
	 * @model name="bottom_left"
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_LEFT_VALUE = 7;

	/**
	 * The '<em><b>Bottom right</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom right</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_RIGHT
	 * @model name="bottom_right"
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_RIGHT_VALUE = 8;

	/**
	 * An array of all the '<em><b>Transform Gravity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransformGravity[] VALUES_ARRAY =
		new TransformGravity[] {
			CENTER,
			TOP_CENTER,
			BOTTOM_CENTER,
			CENTER_LEFT,
			CENTER_RIGHT,
			TOP_LEFT,
			TOP_RIGHT,
			BOTTOM_LEFT,
			BOTTOM_RIGHT,
		};

	/**
	 * A public read-only list of all the '<em><b>Transform Gravity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransformGravity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transform Gravity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransformGravity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformGravity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transform Gravity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransformGravity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransformGravity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transform Gravity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TransformGravity get(int value) {
		switch (value) {
			case CENTER_VALUE: return CENTER;
			case TOP_CENTER_VALUE: return TOP_CENTER;
			case BOTTOM_CENTER_VALUE: return BOTTOM_CENTER;
			case CENTER_LEFT_VALUE: return CENTER_LEFT;
			case CENTER_RIGHT_VALUE: return CENTER_RIGHT;
			case TOP_LEFT_VALUE: return TOP_LEFT;
			case TOP_RIGHT_VALUE: return TOP_RIGHT;
			case BOTTOM_LEFT_VALUE: return BOTTOM_LEFT;
			case BOTTOM_RIGHT_VALUE: return BOTTOM_RIGHT;
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
	private TransformGravity(int value, String name, String literal) {
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
	
} //TransformGravity
