/**
 */
package org.soluvas.commons;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.commons.GeneralSysConfig#getSslSupported <em>Ssl Supported</em>}</li>
 * </ul>
 *
 * @see org.soluvas.commons.CommonsPackage#getGeneralSysConfig()
 * @model abstract="true"
 * @generated
 */
public interface GeneralSysConfig extends Expandable, SysConfig {

	/**
	 * Returns the value of the '<em><b>Ssl Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether Wicket/Spring MVC controllers can require secure channel, and whether URI generators (used in Sitemaps, Atom Feeds, Canonical URIs, etc.) use HTTPS URIs. This should always be {@code true}.
	 * 
	 * <p>For development and debugging purposes (i.e. a bug is caused or made harder to diagnose due to SSL mechanism), this can be set to false. Otherwise, the development Tomcat/Undertow container should have SSL configured using self-signed (wildcard?) certificates.
	 * 
	 * <p>For production purpose, when the customer doesn't have an SSL certificate yet, this can be disabled. But such scenario should be temporary and SSL should be enabled whenever possible.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ssl Supported</em>' attribute.
	 * @see #setSslSupported(Boolean)
	 * @see org.soluvas.commons.CommonsPackage#getGeneralSysConfig_SslSupported()
	 * @model
	 * @generated
	 */
	Boolean getSslSupported();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.GeneralSysConfig#getSslSupported <em>Ssl Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssl Supported</em>' attribute.
	 * @see #getSslSupported()
	 * @generated
	 */
	void setSslSupported(Boolean value);

} // GeneralSysConfig
