/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Aware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BundleAware classes are usually also ResourceAware (since Bundle is a resource).
 * However, Soluvas can load from other non-bundle resources as well, etc. JCR, Git, filesystem, database, HTTP, etc.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.BundleAware#getBundle <em>Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getBundleAware()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface BundleAware extends EObject {
	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only available if resolved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(Bundle)
	 * @see org.soluvas.commons.CommonsPackage#getBundleAware_Bundle()
	 * @model dataType="org.soluvas.commons.Bundle" transient="true"
	 * @generated
	 */
	@JsonIgnore
	Bundle getBundle();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.BundleAware#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(Bundle value);

} // BundleAware
