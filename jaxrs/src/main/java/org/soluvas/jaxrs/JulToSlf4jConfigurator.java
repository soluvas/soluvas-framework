package org.soluvas.jaxrs;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Removes all {@code java.util.logging} handlers
 * and replaces it with Slf4jBridgeHandler.
 * Useful for Jersey which insists on using JUL.
 * 
 * <p>Usage in {@code web.xml}:
 * 
 * <pre>{@literal
 * <listener>
 * 	<listener-class>org.soluvas.jaxrs.JulToSlf4jConfigurator</listener-class>
 * </listener>
 * }</pre>
 * 
 * @author rudi
 */
public class JulToSlf4jConfigurator implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
