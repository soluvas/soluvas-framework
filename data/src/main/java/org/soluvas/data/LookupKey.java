/**
 */
package org.soluvas.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Lookup Key</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Used by EntityNotFoundException to know what attribute was used to lookup.
 * <!-- end-model-doc -->
 * @see org.soluvas.data.DataPackage#getLookupKey()
 * @model
 * @generated
 */
public enum LookupKey implements Enumerator {
	/**
	 * The '<em><b>Id</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ID_VALUE
	 * @generated
	 * @ordered
	 */
	ID(0, "id", "id"),

	/**
	 * The '<em><b>Slug</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLUG_VALUE
	 * @generated
	 * @ordered
	 */
	SLUG(1, "slug", "slug"),

	/**
	 * The '<em><b>Guid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUID_VALUE
	 * @generated
	 * @ordered
	 */
	GUID(2, "guid", "guid"), /**
	 * The '<em><b>Email</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMAIL_VALUE
	 * @generated
	 * @ordered
	 */
	EMAIL(3, "email", "email"), /**
	 * The '<em><b>Facebook id</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK_ID_VALUE
	 * @generated
	 * @ordered
	 */
	FACEBOOK_ID(4, "facebook_id", "facebook_id"), /**
	 * The '<em><b>Facebook username</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACEBOOK_USERNAME_VALUE
	 * @generated
	 * @ordered
	 */
	FACEBOOK_USERNAME(5, "facebook_username", "facebook_username"), /**
	 * The '<em><b>Twitter id</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWITTER_ID_VALUE
	 * @generated
	 * @ordered
	 */
	TWITTER_ID(6, "twitter_id", "twitter_id"), /**
	 * The '<em><b>Twitter screenname</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWITTER_SCREENNAME_VALUE
	 * @generated
	 * @ordered
	 */
	TWITTER_SCREENNAME(7, "twitter_screenname", "twitter_screenname");

	/**
	 * The '<em><b>Id</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup via entity-scoped unique ID, which is common for backend pages and shell.
	 * <!-- end-model-doc -->
	 * @see #ID
	 * @model name="id"
	 * @generated
	 * @ordered
	 */
	public static final int ID_VALUE = 0;

	/**
	 * The '<em><b>Slug</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup via slug, which is the most common for frontend pages.
	 * <!-- end-model-doc -->
	 * @see #SLUG
	 * @model name="slug"
	 * @generated
	 * @ordered
	 */
	public static final int SLUG_VALUE = 1;

	/**
	 * The '<em><b>Guid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup via GUID, rarely used but usable in CouchDB.
	 * <!-- end-model-doc -->
	 * @see #GUID
	 * @model name="guid"
	 * @generated
	 * @ordered
	 */
	public static final int GUID_VALUE = 2;

	/**
	 * The '<em><b>Email</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup based on email. Note that an entity may contain multiple emails.
	 * <!-- end-model-doc -->
	 * @see #EMAIL
	 * @model name="email"
	 * @generated
	 * @ordered
	 */
	public static final int EMAIL_VALUE = 3;

	/**
	 * The '<em><b>Facebook id</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup based on Facebook ID (long). Note that an entity may contain multiple Facebook IDs.
	 * <!-- end-model-doc -->
	 * @see #FACEBOOK_ID
	 * @model name="facebook_id"
	 * @generated
	 * @ordered
	 */
	public static final int FACEBOOK_ID_VALUE = 4;

	/**
	 * The '<em><b>Facebook username</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup based on Facebook username. Note that an entity may contain multiple Facebook usernames.
	 * <!-- end-model-doc -->
	 * @see #FACEBOOK_USERNAME
	 * @model name="facebook_username"
	 * @generated
	 * @ordered
	 */
	public static final int FACEBOOK_USERNAME_VALUE = 5;

	/**
	 * The '<em><b>Twitter id</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup based on Twitter ID (long). Note that an entity may contain multiple Twitter IDs.
	 * <!-- end-model-doc -->
	 * @see #TWITTER_ID
	 * @model name="twitter_id"
	 * @generated
	 * @ordered
	 */
	public static final int TWITTER_ID_VALUE = 6;

	/**
	 * The '<em><b>Twitter screenname</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup based on Twitter username. Note that an entity may contain multiple Twitter usernames.
	 * <!-- end-model-doc -->
	 * @see #TWITTER_SCREENNAME
	 * @model name="twitter_screenname"
	 * @generated
	 * @ordered
	 */
	public static final int TWITTER_SCREENNAME_VALUE = 7;

	/**
	 * An array of all the '<em><b>Lookup Key</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LookupKey[] VALUES_ARRAY =
		new LookupKey[] {
			ID,
			SLUG,
			GUID,
			EMAIL,
			FACEBOOK_ID,
			FACEBOOK_USERNAME,
			TWITTER_ID,
			TWITTER_SCREENNAME,
		};

	/**
	 * A public read-only list of all the '<em><b>Lookup Key</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LookupKey> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Lookup Key</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LookupKey get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LookupKey result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lookup Key</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LookupKey getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LookupKey result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lookup Key</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LookupKey get(int value) {
		switch (value) {
			case ID_VALUE: return ID;
			case SLUG_VALUE: return SLUG;
			case GUID_VALUE: return GUID;
			case EMAIL_VALUE: return EMAIL;
			case FACEBOOK_ID_VALUE: return FACEBOOK_ID;
			case FACEBOOK_USERNAME_VALUE: return FACEBOOK_USERNAME;
			case TWITTER_ID_VALUE: return TWITTER_ID;
			case TWITTER_SCREENNAME_VALUE: return TWITTER_SCREENNAME;
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
	private LookupKey(int value, String name, String literal) {
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
	
} //LookupKey
