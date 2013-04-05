/**
 */
package email;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Web Security</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Preference between URIs will use unsecure HTTP or secured HTTPS.
 * <!-- end-model-doc -->
 * @see email.EmailPackage#getWebSecurity()
 * @model
 * @generated
 */
public enum WebSecurity implements Enumerator {
	/**
	 * The '<em><b>Prefer secure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFER_SECURE_VALUE
	 * @generated
	 * @ordered
	 */
	PREFER_SECURE(0, "prefer_secure", "prefer_secure"),

	/**
	 * The '<em><b>Always secure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALWAYS_SECURE_VALUE
	 * @generated
	 * @ordered
	 */
	ALWAYS_SECURE(1, "always_secure", "always_secure"),

	/**
	 * The '<em><b>Always unsecure</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALWAYS_UNSECURE_VALUE
	 * @generated
	 * @ordered
	 */
	ALWAYS_UNSECURE(2, "always_unsecure", "always_unsecure");

	/**
	 * The '<em><b>Prefer secure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Prefer HTTPS for sensitive content (recommended).
	 * <!-- end-model-doc -->
	 * @see #PREFER_SECURE
	 * @model name="prefer_secure"
	 * @generated
	 * @ordered
	 */
	public static final int PREFER_SECURE_VALUE = 0;

	/**
	 * The '<em><b>Always secure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Always use secure HTTPS for all content, including content with publicly available URIs. (slows down)
	 * <!-- end-model-doc -->
	 * @see #ALWAYS_SECURE
	 * @model name="always_secure"
	 * @generated
	 * @ordered
	 */
	public static final int ALWAYS_SECURE_VALUE = 1;

	/**
	 * The '<em><b>Always unsecure</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Always use plain HTTP for all content, including content with sensitive URIs. (not recommended, but sometimes required for older mobile devices, or for development purposes.)
	 * <!-- end-model-doc -->
	 * @see #ALWAYS_UNSECURE
	 * @model name="always_unsecure"
	 * @generated
	 * @ordered
	 */
	public static final int ALWAYS_UNSECURE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Web Security</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WebSecurity[] VALUES_ARRAY =
		new WebSecurity[] {
			PREFER_SECURE,
			ALWAYS_SECURE,
			ALWAYS_UNSECURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Web Security</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<WebSecurity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Web Security</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WebSecurity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WebSecurity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Security</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WebSecurity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WebSecurity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Security</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WebSecurity get(int value) {
		switch (value) {
			case PREFER_SECURE_VALUE: return PREFER_SECURE;
			case ALWAYS_SECURE_VALUE: return ALWAYS_SECURE;
			case ALWAYS_UNSECURE_VALUE: return ALWAYS_UNSECURE;
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
	private WebSecurity(int value, String name, String literal) {
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
	
} //WebSecurity
