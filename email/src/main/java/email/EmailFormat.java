/**
 */
package email;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Format</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see email.EmailPackage#getEmailFormat()
 * @model
 * @generated
 */
public enum EmailFormat implements Enumerator {
	/**
	 * The '<em><b>Multipart</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIPART_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIPART(0, "multipart", "multipart"),

	/**
	 * The '<em><b>Plain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAIN_VALUE
	 * @generated
	 * @ordered
	 */
	PLAIN(1, "plain", "plain"),

	/**
	 * The '<em><b>Html</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HTML_VALUE
	 * @generated
	 * @ordered
	 */
	HTML(2, "html", "html");

	/**
	 * The '<em><b>Multipart</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Multipart</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTIPART
	 * @model name="multipart"
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPART_VALUE = 0;

	/**
	 * The '<em><b>Plain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Plain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAIN
	 * @model name="plain"
	 * @generated
	 * @ordered
	 */
	public static final int PLAIN_VALUE = 1;

	/**
	 * The '<em><b>Html</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Html</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HTML
	 * @model name="html"
	 * @generated
	 * @ordered
	 */
	public static final int HTML_VALUE = 2;

	/**
	 * An array of all the '<em><b>Format</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmailFormat[] VALUES_ARRAY =
		new EmailFormat[] {
			MULTIPART,
			PLAIN,
			HTML,
		};

	/**
	 * A public read-only list of all the '<em><b>Format</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EmailFormat> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmailFormat get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmailFormat result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmailFormat getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmailFormat result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EmailFormat get(int value) {
		switch (value) {
			case MULTIPART_VALUE: return MULTIPART;
			case PLAIN_VALUE: return PLAIN;
			case HTML_VALUE: return HTML;
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
	private EmailFormat(int value, String name, String literal) {
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
	
} //EmailFormat
