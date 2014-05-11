/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mongo Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.MongoSysConfig#getMongoUri <em>Mongo Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getMongoSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MongoSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Mongo Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MongoDB URI for all MongoDB repositories except image repositories. Each repository implementation should determine its own access patterns with regard to replica set (i.e. primary only, secondary on read, etc.)
	 * 
	 * Templated using URI Templates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mongo Uri</em>' attribute.
	 * @see #setMongoUri(String)
	 * @see org.soluvas.commons.CommonsPackage#getMongoSysConfig_MongoUri()
	 * @model
	 * @generated
	 */
	String getMongoUri();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.MongoSysConfig#getMongoUri <em>Mongo Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mongo Uri</em>' attribute.
	 * @see #getMongoUri()
	 * @generated
	 */
	void setMongoUri(String value);

} // MongoSysConfig
