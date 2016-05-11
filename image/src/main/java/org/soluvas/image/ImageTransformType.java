/**
 */
package org.soluvas.image;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Transform Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage#getImageTransformType()
 * @model
 * @generated
 */
public enum ImageTransformType implements Enumerator {
	/**
	 * The '<em><b>Resize to fit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESIZE_TO_FIT_VALUE
	 * @generated
	 * @ordered
	 */
	RESIZE_TO_FIT(0, "resize_to_fit", "resize_to_fit"),

	/**
	 * The '<em><b>Resize to fill</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESIZE_TO_FILL_VALUE
	 * @generated
	 * @ordered
	 */
	RESIZE_TO_FILL(1, "resize_to_fill", "resize_to_fill");

	/**
	 * The '<em><b>Resize to fit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create thumbnail with same aspect ratio.
	 * <!-- end-model-doc -->
	 * @see #RESIZE_TO_FIT
	 * @model name="resize_to_fit"
	 * @generated
	 * @ordered
	 */
	public static final int RESIZE_TO_FIT_VALUE = 0;

	/**
	 * The '<em><b>Resize to fill</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Fill thumbnail dimension.
	 * <!-- end-model-doc -->
	 * @see #RESIZE_TO_FILL
	 * @model name="resize_to_fill"
	 * @generated
	 * @ordered
	 */
	public static final int RESIZE_TO_FILL_VALUE = 1;

	/**
	 * An array of all the '<em><b>Transform Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImageTransformType[] VALUES_ARRAY =
		new ImageTransformType[] {
			RESIZE_TO_FIT,
			RESIZE_TO_FILL,
		};

	/**
	 * A public read-only list of all the '<em><b>Transform Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImageTransformType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transform Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageTransformType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageTransformType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transform Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageTransformType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageTransformType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transform Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageTransformType get(int value) {
		switch (value) {
			case RESIZE_TO_FIT_VALUE: return RESIZE_TO_FIT;
			case RESIZE_TO_FILL_VALUE: return RESIZE_TO_FILL;
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
	private ImageTransformType(int value, String name, String literal) {
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
	
} //ImageTransformType
