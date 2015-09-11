/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Publication Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * atribut untuk draft/published, editing. Semanticnya Drafts (Edit kayanya beda lagi, bikin ticket baru aja dech untuk Edit).
 * <!-- end-model-doc -->
 * @see org.soluvas.commons.CommonsPackage#getPublicationStatus()
 * @model
 * @generated
 */
public enum PublicationStatus implements Enumerator {
	/**
	 * The '<em><b>Draft</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAFT_VALUE
	 * @generated
	 * @ordered
	 */
	DRAFT(0, "draft", "draft"),

	/**
	 * The '<em><b>Published</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLISHED_VALUE
	 * @generated
	 * @ordered
	 */
	PUBLISHED(1, "published", "published"),

	/**
	 * The '<em><b>Unpublished</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNPUBLISHED_VALUE
	 * @generated
	 * @ordered
	 */
	UNPUBLISHED(2, "unpublished", "unpublished");

	/**
	 * The '<em><b>Draft</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Not Yet Published
	 * <!-- end-model-doc -->
	 * @see #DRAFT
	 * @model name="draft"
	 * @generated
	 * @ordered
	 */
	public static final int DRAFT_VALUE = 0;

	/**
	 * The '<em><b>Published</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Has published and can be viewed by authorized viewers.
	 * <!-- end-model-doc -->
	 * @see #PUBLISHED
	 * @model name="published"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLISHED_VALUE = 1;

	/**
	 * The '<em><b>Unpublished</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Was published but taken down
	 * <!-- end-model-doc -->
	 * @see #UNPUBLISHED
	 * @model name="unpublished"
	 * @generated
	 * @ordered
	 */
	public static final int UNPUBLISHED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Publication Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PublicationStatus[] VALUES_ARRAY =
		new PublicationStatus[] {
			DRAFT,
			PUBLISHED,
			UNPUBLISHED,
		};

	/**
	 * A public read-only list of all the '<em><b>Publication Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PublicationStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Publication Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PublicationStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublicationStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publication Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PublicationStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublicationStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publication Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PublicationStatus get(int value) {
		switch (value) {
			case DRAFT_VALUE: return DRAFT;
			case PUBLISHED_VALUE: return PUBLISHED;
			case UNPUBLISHED_VALUE: return UNPUBLISHED;
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
	private PublicationStatus(int value, String name, String literal) {
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
	
} //PublicationStatus
