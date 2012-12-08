/**
 */
package org.soluvas.commons;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Linked</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.EClassLinked#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.soluvas.commons.EClassLinked#getEClassStatus <em>EClass Status</em>}</li>
 *   <li>{@link org.soluvas.commons.EClassLinked#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@link org.soluvas.commons.EClassLinked#getEPackageName <em>EPackage Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getEClassLinked()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface EClassLinked extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * EClass for this instances of this type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see org.soluvas.commons.CommonsPackage#getEClassLinked_EClass()
	 * @model
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.EClassLinked#getEClass <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' reference.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>EClass Status</b></em>' attribute.
	 * The default value is <code>"unresolved"</code>.
	 * The literals are from the enumeration {@link org.soluvas.commons.EClassStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass Status</em>' attribute.
	 * @see org.soluvas.commons.EClassStatus
	 * @see #setEClassStatus(EClassStatus)
	 * @see org.soluvas.commons.CommonsPackage#getEClassLinked_EClassStatus()
	 * @model default="unresolved" transient="true"
	 * @generated
	 */
	EClassStatus getEClassStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.EClassLinked#getEClassStatus <em>EClass Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass Status</em>' attribute.
	 * @see org.soluvas.commons.EClassStatus
	 * @see #getEClassStatus()
	 * @generated
	 */
	void setEClassStatus(EClassStatus value);

	/**
	 * Returns the value of the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of EClass, used for resolving the EClass instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EClass Name</em>' attribute.
	 * @see #setEClassName(String)
	 * @see org.soluvas.commons.CommonsPackage#getEClassLinked_EClassName()
	 * @model
	 * @generated
	 */
	String getEClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.EClassLinked#getEClassName <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass Name</em>' attribute.
	 * @see #getEClassName()
	 * @generated
	 */
	void setEClassName(String value);

	/**
	 * Returns the value of the '<em><b>EPackage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of EPackage, used for resolving the EClass instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EPackage Name</em>' attribute.
	 * @see #setEPackageName(String)
	 * @see org.soluvas.commons.CommonsPackage#getEClassLinked_EPackageName()
	 * @model
	 * @generated
	 */
	String getEPackageName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.EClassLinked#getEPackageName <em>EPackage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPackage Name</em>' attribute.
	 * @see #getEPackageName()
	 * @generated
	 */
	void setEPackageName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resolve referenced EClass.
	 * @param eClassMap
	 *   Keys are {ePackageName}.{eClassName}.
	 *   Values are EClass instances themselves.
	 * <!-- end-model-doc -->
	 * @model eClassMapDataType="org.soluvas.commons.Map<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EClass>"
	 * @generated
	 */
	void resolveEClass(Map<String, EClass> eClassMap);

} // EClassLinked
