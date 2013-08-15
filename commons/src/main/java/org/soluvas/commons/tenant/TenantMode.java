package org.soluvas.commons.tenant;

/**
 * Web application multitenancy mode.
 * Global configuration is searched in two files:
 * <ol>
 * 	<li>{@code /WEB-INF/soluvas-global.properties}. Recommended (shortcut) for web applications.</li>
 * 	<li>{@code classpath:META-INF/soluvas-global.properties}. Good for non-web applications,
 * 		in a webapp this will be {@code WEB-INF/classes/META-INF/soluvas-global.properties}.</li>
 * </ol>
 * @author ceefour
 */
public enum TenantMode {
	/**
	 * The application is fixed single-tenant.
	 * The {@code tenantId} and {@code tenantEnv} is specified in global configuration properties
	 * {@code tenantId} and {@code tenantEnv}.
	 */
	FIXED,
	/**
	 * The application is dynamic single-tenant per context.
	 * The {@code tenantId} and {@code tenantEnv} is specified from context name. 
	 * Example is Bippo Commerce.
	 */
	SINGLE_CONTEXT,
	/**
	 * The application is dynamic single-tenant per host.
	 * The {@code tenantId} and {@code tenantEnv} is specified from {@code Host} header
	 * (or {@literal Host} element in Tomcat's {@literal server.xml}). 
	 */
	SINGLE_HOST,
	/**
	 * Application is multi-tenant based on path.
	 * The {@code tenantId} and {@code tenantEnv} is specified from {@code /t/${tenantId}/${tenantEnv}/}
	 * path prefix after the context path.
	 * This configuration requires a reverse proxy (e.g. nginx) to operate properly.
	 * @deprecated Because cannot be used directly with wicketstuff @MountPath, requires reverse proxy.
	 */
	@Deprecated
	MULTI_PATH,
	/**
	 * Application is multi-tenant based on {@code Host} header.
	 * The {@code tenantId} is specified from the first domain component of {@code Host} header.
	 * {@code tenantEnv} is specified by global configuration property {@code tenantEnv}. 
	 * Application should be deployed as {@code ROOT} context.
	 * This configuration enables the application to be run solely using Tomcat,
	 * which is useful during development.
	 * 
	 * <p>Note: This practically requires a dedicated Tomcat per multitenant application.
	 * Although it's still possible to run different applications via different HTTP ports
	 * in a single Tomcat. 
	 */
	MULTI_HOST
}
