/**
 */
package org.soluvas.image;

import org.soluvas.commons.SerializableEObject;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Image module configuration.
 * 
 * The URI pattern is hardcoded as folows:
 * 
 * For normal styles:
 * 
 * * {publicUri}/{namespace}/{styleCode}/{id}_{styleCode}.{extension}
 * 
 * For variant styles: (styleCode is usually 'x', but can be anything else except 'o')
 * 
 * * {publicUri}/{namespace}/{styleCode}/{id}_{styleCode}_{variantCode}.{extension}
 * 
 * In the future, URI pattern ("template") should be configurable, based on http://tools.ietf.org/html/rfc6570
 * and can be expanded both by server and client scripts.
 * 
 * The domain name can also be different for each namespace, or even for each styleCode or variantCode.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.ImageConfig#getPublicUri <em>Public Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getImageConfig()
 * @model
 * @extends SerializableEObject
 * @generated
 */
public interface ImageConfig extends SerializableEObject {
	/**
	 * Returns the value of the '<em><b>Public Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Uri</em>' attribute.
	 * @see #setPublicUri(String)
	 * @see org.soluvas.image.ImagePackage#getImageConfig_PublicUri()
	 * @model
	 * @generated
	 */
	String getPublicUri();

	/**
	 * Sets the value of the '{@link org.soluvas.image.ImageConfig#getPublicUri <em>Public Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Uri</em>' attribute.
	 * @see #getPublicUri()
	 * @generated
	 */
	void setPublicUri(String value);

} // ImageConfig
