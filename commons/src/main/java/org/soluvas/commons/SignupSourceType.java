/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Signup Source Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage#getSignupSourceType()
 * @model
 * @generated
 */
public enum SignupSourceType implements Enumerator {
	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(0, "other", "other"),

	/**
	 * The '<em><b>Google search</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOOGLE_SEARCH_VALUE
	 * @generated
	 * @ordered
	 */
	GOOGLE_SEARCH(1, "google_search", "google_search"),

	/**
	 * The '<em><b>Google ads</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOOGLE_ADS_VALUE
	 * @generated
	 * @ordered
	 */
	GOOGLE_ADS(2, "google_ads", "google_ads"),

	/**
	 * The '<em><b>Facebook ads</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK_ADS_VALUE
	 * @generated
	 * @ordered
	 */
	FACEBOOK_ADS(3, "facebook_ads", "facebook_ads"),

	/**
	 * The '<em><b>Facebook friend</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK_FRIEND_VALUE
	 * @generated
	 * @ordered
	 */
	FACEBOOK_FRIEND(4, "facebook_friend", "facebook_friend"),

	/**
	 * The '<em><b>Alia magazine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALIA_MAGAZINE_VALUE
	 * @generated
	 * @ordered
	 */
	ALIA_MAGAZINE(5, "alia_magazine", "alia_magazine");

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Other.
	 * <!-- end-model-doc -->
	 * @see #OTHER
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 0;

	/**
	 * The '<em><b>Google search</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Google Search Engine.
	 * <!-- end-model-doc -->
	 * @see #GOOGLE_SEARCH
	 * @model name="google_search"
	 * @generated
	 * @ordered
	 */
	public static final int GOOGLE_SEARCH_VALUE = 1;

	/**
	 * The '<em><b>Google ads</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Google AdSense / AdWords ads.
	 * <!-- end-model-doc -->
	 * @see #GOOGLE_ADS
	 * @model name="google_ads"
	 * @generated
	 * @ordered
	 */
	public static final int GOOGLE_ADS_VALUE = 2;

	/**
	 * The '<em><b>Facebook ads</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook Ads.
	 * <!-- end-model-doc -->
	 * @see #FACEBOOK_ADS
	 * @model name="facebook_ads"
	 * @generated
	 * @ordered
	 */
	public static final int FACEBOOK_ADS_VALUE = 3;

	/**
	 * The '<em><b>Facebook friend</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook friend.
	 * <!-- end-model-doc -->
	 * @see #FACEBOOK_FRIEND
	 * @model name="facebook_friend"
	 * @generated
	 * @ordered
	 */
	public static final int FACEBOOK_FRIEND_VALUE = 4;

	/**
	 * The '<em><b>Alia magazine</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Alia magazine.
	 * <!-- end-model-doc -->
	 * @see #ALIA_MAGAZINE
	 * @model name="alia_magazine"
	 * @generated
	 * @ordered
	 */
	public static final int ALIA_MAGAZINE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Signup Source Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SignupSourceType[] VALUES_ARRAY =
		new SignupSourceType[] {
			OTHER,
			GOOGLE_SEARCH,
			GOOGLE_ADS,
			FACEBOOK_ADS,
			FACEBOOK_FRIEND,
			ALIA_MAGAZINE,
		};

	/**
	 * A public read-only list of all the '<em><b>Signup Source Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SignupSourceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Signup Source Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SignupSourceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SignupSourceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Signup Source Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SignupSourceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SignupSourceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Signup Source Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SignupSourceType get(int value) {
		switch (value) {
			case OTHER_VALUE: return OTHER;
			case GOOGLE_SEARCH_VALUE: return GOOGLE_SEARCH;
			case GOOGLE_ADS_VALUE: return GOOGLE_ADS;
			case FACEBOOK_ADS_VALUE: return FACEBOOK_ADS;
			case FACEBOOK_FRIEND_VALUE: return FACEBOOK_FRIEND;
			case ALIA_MAGAZINE_VALUE: return ALIA_MAGAZINE;
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
	private SignupSourceType(int value, String name, String literal) {
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
	
} //SignupSourceType
