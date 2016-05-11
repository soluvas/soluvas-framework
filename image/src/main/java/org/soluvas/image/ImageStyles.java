/**
 */
package org.soluvas.image;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Styles</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Holds commonly used image styles.
 * <!-- end-model-doc -->
 * @see org.soluvas.image.ImagePackage#getImageStyles()
 */
public enum ImageStyles implements Enumerator, ImageStyle {
	/**
	 * The '<em><b>Original</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORIGINAL_VALUE
	 * @generated
	 * @ordered
	 */
	ORIGINAL(0, "original", "original"),

	/**
	 * The '<em><b>Thumbnail</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THUMBNAIL_VALUE
	 * @generated
	 * @ordered
	 */
	THUMBNAIL(1, "thumbnail", "thumbnail"),

	/**
	 * The '<em><b>Small</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALL_VALUE
	 * @generated
	 * @ordered
	 */
	SMALL(2, "small", "small"),

	/**
	 * The '<em><b>Normal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	NORMAL(3, "normal", "normal"),

	/**
	 * The '<em><b>Large</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LARGE_VALUE
	 * @generated
	 * @ordered
	 */
	LARGE(4, "large", "large");

	/**
	 * The '<em><b>Original</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Original</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORIGINAL
	 * @model name="original"
	 * @generated
	 * @ordered
	 */
	public static final int ORIGINAL_VALUE = 0;

	/**
	 * The '<em><b>Thumbnail</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Thumbnail</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THUMBNAIL
	 * @model name="thumbnail"
	 * @generated
	 * @ordered
	 */
	public static final int THUMBNAIL_VALUE = 1;

	/**
	 * The '<em><b>Small</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Small</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMALL
	 * @model name="small"
	 * @generated
	 * @ordered
	 */
	public static final int SMALL_VALUE = 2;

	/**
	 * The '<em><b>Normal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Normal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORMAL
	 * @model name="normal"
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL_VALUE = 3;

	/**
	 * The '<em><b>Large</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Large</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LARGE
	 * @model name="large"
	 * @generated
	 * @ordered
	 */
	public static final int LARGE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Styles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImageStyles[] VALUES_ARRAY =
		new ImageStyles[] {
			ORIGINAL,
			THUMBNAIL,
			SMALL,
			NORMAL,
			LARGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Styles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImageStyles> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Styles</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageStyles get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageStyles result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Styles</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageStyles getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImageStyles result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Styles</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImageStyles get(int value) {
		switch (value) {
			case ORIGINAL_VALUE: return ORIGINAL;
			case THUMBNAIL_VALUE: return THUMBNAIL;
			case SMALL_VALUE: return SMALL;
			case NORMAL_VALUE: return NORMAL;
			case LARGE_VALUE: return LARGE;
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
	private ImageStyles(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	
} //ImageStyles
