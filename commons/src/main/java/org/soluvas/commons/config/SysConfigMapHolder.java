package org.soluvas.commons.config;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.springframework.context.annotation.Configuration;

/**
 * Holds a {@code SysConfig} {@link Map}, usually implemented by the application root {@link Configuration}.
 * @author ceefour
 * @todo This needs to be rethought and made more practical, in line with Spring Boot and Hendy's Starter approach.
 * @see SoluvasApplication
 */
public interface SysConfigMapHolder<T extends EObject> {
	
	Map<String, T> sysConfigMap() throws Exception;

}
