package org.soluvas.jpa.jpa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A representation of the literals of the enumeration '<em><b>Gender</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public enum Gender {

	/**
	 * The enum: MALE <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	MALE(1, "male", "male") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isMale() {
			return true;
		}
	},
	/**
	 * The enum: FEMALE <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FEMALE(2, "female", "female") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isFemale() {
			return true;
		}
	},
	/**
	 * The enum: UNKNOWN <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UNKNOWN(0, "unknown", "unknown") {

		/**
		 * @return always true for this instance
		 * @generated
		 */
		@Override
		public boolean isUnknown() {
			return true;
		}
	};

	/**
	 * An array of all the '<em><b>Gender</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Gender[] VALUES_ARRAY = new Gender[] { MALE, FEMALE,
			UNKNOWN };

	/**
	 * A public read-only list of all the '<em><b>Gender</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<Gender> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Gender</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal to use to get the enum instance
	 * @return the Gender, the literal enum class
	 * @generated
	 */
	public static Gender get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Gender result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gender</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name to use to get the enum instance
	 * @return the Gender, the literal enum class
	 * @generated
	 */
	public static Gender getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Gender result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Gender</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the value to use to get the enum instance
	 * @return the Gender, the literal enum
	 * @generated
	 */
	public static Gender get(int value) {
		for (Gender enumInstance : VALUES_ARRAY) {
			if (enumInstance.getValue() == value) {
				return enumInstance;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private Gender(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isMale() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isFemale() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return false, is overridden by actual enum types.
	 * @generated
	 */
	public boolean isUnknown() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the name
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the literal of this enum instance
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the literal value of the enumerator, which is its string
	 *         representation.
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
