/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Translation State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage#getTranslationState()
 * @model
 * @generated
 */
public enum TranslationState implements Enumerator {
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
	 * The '<em><b>Translated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSLATED_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSLATED(1, "translated", "translated");

	/**
	 * The '<em><b>Original</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1. Values are in their original language as specified by originalLanguage (usually the mother tongue, i.e. id).
	 * <!-- end-model-doc -->
	 * @see #ORIGINAL
	 * @model name="original"
	 * @generated
	 * @ordered
	 */
	public static final int ORIGINAL_VALUE = 0;

	/**
	 * The '<em><b>Translated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 2. Values are translated and language attribute is set as the current language.
	 * <!-- end-model-doc -->
	 * @see #TRANSLATED
	 * @model name="translated"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSLATED_VALUE = 1;

	/**
	 * An array of all the '<em><b>Translation State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TranslationState[] VALUES_ARRAY =
		new TranslationState[] {
			ORIGINAL,
			TRANSLATED,
		};

	/**
	 * A public read-only list of all the '<em><b>Translation State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TranslationState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Translation State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TranslationState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TranslationState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Translation State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TranslationState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TranslationState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Translation State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TranslationState get(int value) {
		switch (value) {
			case ORIGINAL_VALUE: return ORIGINAL;
			case TRANSLATED_VALUE: return TRANSLATED;
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
	private TranslationState(int value, String name, String literal) {
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
	
} //TranslationState
