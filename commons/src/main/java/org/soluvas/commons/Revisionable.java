/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guid Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains a globally unique identifier (GUID) and revision.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.Revisionable#getGuid <em>Guid</em>}</li>
 *   <li>{@link org.soluvas.commons.Revisionable#getRevision <em>Revision</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getRevisionable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Revisionable extends EObject {
	/**
	 * Returns the value of the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Globally unique identifier (GUID). Usually it's the same as OID (object identifier), for better space usage. However there are times where it is app-generated
	 * (i.e. by a PouchDB app).
	 * 
	 * For CouchDB this maps to "_id" field.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Guid</em>' attribute.
	 * @see #setGuid(String)
	 * @see org.soluvas.commons.CommonsPackage#getRevisionable_Guid()
	 * @model
	 * @generated
	 */
	String getGuid();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Revisionable#getGuid <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid</em>' attribute.
	 * @see #getGuid()
	 * @generated
	 */
	void setGuid(String value);

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CouchDB document revision ("_rev").
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #setRevision(String)
	 * @see org.soluvas.commons.CommonsPackage#getRevisionable_Revision()
	 * @model
	 * @generated
	 */
	String getRevision();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.Revisionable#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(String value);

} // GuidContainer
