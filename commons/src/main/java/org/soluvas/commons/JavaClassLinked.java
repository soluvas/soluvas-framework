/**
 */
package org.soluvas.commons;

import org.osgi.framework.Bundle;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Class Linked</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClassName <em>Java Class Name</em>}</li>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClassStatus <em>Java Class Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface JavaClassLinked<T> extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Java class name linked to this type. Used to resolve the Java Class instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Java Class Name</em>' attribute.
	 * @see #setJavaClassName(String)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClassName()
	 * @model transient="true"
	 * @generated
	 */
	String getJavaClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClassName <em>Java Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class Name</em>' attribute.
	 * @see #getJavaClassName()
	 * @generated
	 */
	void setJavaClassName(String value);

	/**
	 * Returns the value of the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Java class linked to this type. Only available when resolved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Java Class</em>' attribute.
	 * @see #setJavaClass(Class)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClass()
	 * @model
	 * @generated
	 */
	Class<T> getJavaClass();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClass <em>Java Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class</em>' attribute.
	 * @see #getJavaClass()
	 * @generated
	 */
	void setJavaClass(Class<T> value);

	/**
	 * Returns the value of the '<em><b>Java Class Status</b></em>' attribute.
	 * The default value is <code>"unresolved"</code>.
	 * The literals are from the enumeration {@link org.soluvas.commons.JavaClassStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Class Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Class Status</em>' attribute.
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see #setJavaClassStatus(JavaClassStatus)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClassStatus()
	 * @model default="unresolved" transient="true"
	 * @generated
	 */
	JavaClassStatus getJavaClassStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClassStatus <em>Java Class Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class Status</em>' attribute.
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see #getJavaClassStatus()
	 * @generated
	 */
	void setJavaClassStatus(JavaClassStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resolve referenced Java Class.
	 * @param bundle Resolve referenced Java Class using the specified Bundle.
	 * <!-- end-model-doc -->
	 * @model bundleDataType="org.soluvas.commons.Bundle"
	 * @generated
	 */
	void resolveJavaClass(Bundle bundle);

} // JavaClassLinked
