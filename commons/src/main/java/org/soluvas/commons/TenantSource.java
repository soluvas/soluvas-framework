/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tenant Source</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage#getTenantSource()
 * @model
 * @generated
 */
public enum TenantSource implements Enumerator {
	/**
	 * The '<em><b>Config</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFIG_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIG(0, "config", "config"),

	/**
	 * The '<em><b>Repository</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPOSITORY_VALUE
	 * @generated
	 * @ordered
	 */
	REPOSITORY(1, "repository", "repository"), /**
	 * The '<em><b>Classpath</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASSPATH_VALUE
	 * @generated
	 * @ordered
	 */
	CLASSPATH(0, "classpath", "classpath");

	/**
	 * The '<em><b>Config</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Loads tenants from Spring Boot {@code config} directory relative to current directory.
	 * This is practical for development or for production of single or few static tenants.
	 * <!-- end-model-doc -->
	 * @see #CONFIG
	 * @model name="config"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIG_VALUE = 0;

	/**
	 * The '<em><b>Repository</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Loads tenants from repository, which is preferred for production environment with dynamic tenants.
	 * <!-- end-model-doc -->
	 * @see #REPOSITORY
	 * @model name="repository"
	 * @generated
	 * @ordered
	 */
	public static final int REPOSITORY_VALUE = 1;

	/**
	 * The '<em><b>Classpath</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (Deprecated) Loads tenants from META-INF in classpath.
	 * Deprecated because while convenient for development of single or few static tenants,
	 * it's not practical to exclude these files during packaging.
	 * So please switch to {@link TenantSource#CONFIG} (for Spring Boot) or {@link TenantSource#REPOSITORY} (for webapp).
	 * <!-- end-model-doc -->
	 * @see #CLASSPATH
	 * @model name="classpath"
	 * @generated
	 * @ordered
	 */
	public static final int CLASSPATH_VALUE = 0;

	/**
	 * An array of all the '<em><b>Tenant Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TenantSource[] VALUES_ARRAY =
		new TenantSource[] {
			CONFIG,
			REPOSITORY,
			CLASSPATH,
		};

	/**
	 * A public read-only list of all the '<em><b>Tenant Source</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TenantSource> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tenant Source</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TenantSource get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TenantSource result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tenant Source</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TenantSource getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TenantSource result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tenant Source</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TenantSource get(int value) {
		switch (value) {
			case CONFIG_VALUE: return CONFIG;
			case REPOSITORY_VALUE: return REPOSITORY;
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
	private TenantSource(int value, String name, String literal) {
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
	
} //TenantSource
