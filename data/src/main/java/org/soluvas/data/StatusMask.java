/**
 */
package org.soluvas.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Status Mask</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Status filter mask, to be used in findAll(), findOne(), count(), etc.
 * Some implementations, like CouchDB (Map views), is more practically implemented using predefined mask values instead of Set[Enum].
 * Mask is also about semantics, loosely related to actual entity-specific status values.
 * <!-- end-model-doc -->
 * @see org.soluvas.data.DataPackage#getStatusMask()
 * @model
 * @generated
 */
public enum StatusMask implements Enumerator {
	/**
	 * The '<em><b>Raw</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAW_VALUE
	 * @generated
	 * @ordered
	 */
	RAW(0, "raw", "raw"),

	/**
	 * The '<em><b>Active only</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_ONLY(1, "active_only", "active_only"),

	/**
	 * The '<em><b>Include inactive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCLUDE_INACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	INCLUDE_INACTIVE(2, "include_inactive", "include_inactive"),

	/**
	 * The '<em><b>Draft only</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAFT_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	DRAFT_ONLY(3, "draft_only", "draft_only"),

	/**
	 * The '<em><b>Void only</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOID_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	VOID_ONLY(4, "void_only", "void_only");

	/**
	 * The '<em><b>Raw</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return everything, including but not limited to, INACTIVE, DRAFT and VOID. Usually used for sysadmin only.
	 * <!-- end-model-doc -->
	 * @see #RAW
	 * @model name="raw"
	 * @generated
	 * @ordered
	 */
	public static final int RAW_VALUE = 0;

	/**
	 * The '<em><b>Active only</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return only ACTIVE | VALIDATED | VERIFIED entities. Usually used for frontend.
	 * <!-- end-model-doc -->
	 * @see #ACTIVE_ONLY
	 * @model name="active_only"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_ONLY_VALUE = 1;

	/**
	 * The '<em><b>Include inactive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return ACTIVE | VALIDATED | VERIFIED plus INACTIVE. Usually used for backend, normal listing.
	 * <!-- end-model-doc -->
	 * @see #INCLUDE_INACTIVE
	 * @model name="include_inactive"
	 * @generated
	 * @ordered
	 */
	public static final int INCLUDE_INACTIVE_VALUE = 2;

	/**
	 * The '<em><b>Draft only</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return DRAFT only. Usually used for backend, Drafts folder.
	 * <!-- end-model-doc -->
	 * @see #DRAFT_ONLY
	 * @model name="draft_only"
	 * @generated
	 * @ordered
	 */
	public static final int DRAFT_ONLY_VALUE = 3;

	/**
	 * The '<em><b>Void only</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return VOID only. Usually used for backend, Trash folder.
	 * <!-- end-model-doc -->
	 * @see #VOID_ONLY
	 * @model name="void_only"
	 * @generated
	 * @ordered
	 */
	public static final int VOID_ONLY_VALUE = 4;

	/**
	 * An array of all the '<em><b>Status Mask</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final StatusMask[] VALUES_ARRAY =
		new StatusMask[] {
			RAW,
			ACTIVE_ONLY,
			INCLUDE_INACTIVE,
			DRAFT_ONLY,
			VOID_ONLY,
		};

	/**
	 * A public read-only list of all the '<em><b>Status Mask</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<StatusMask> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Status Mask</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatusMask get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StatusMask result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Status Mask</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatusMask getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StatusMask result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Status Mask</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatusMask get(int value) {
		switch (value) {
			case RAW_VALUE: return RAW;
			case ACTIVE_ONLY_VALUE: return ACTIVE_ONLY;
			case INCLUDE_INACTIVE_VALUE: return INCLUDE_INACTIVE;
			case DRAFT_ONLY_VALUE: return DRAFT_ONLY;
			case VOID_ONLY_VALUE: return VOID_ONLY;
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
	private StatusMask(int value, String name, String literal) {
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
	
} //StatusMask
