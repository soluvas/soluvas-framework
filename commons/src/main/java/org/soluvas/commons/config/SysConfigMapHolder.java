package org.soluvas.commons.config;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.springframework.context.annotation.Configuration;

/**
 * Holds a {@code SysConfig} {@link Map}, usually implemented by the application root {@link Configuration}.
 * @author ceefour
 */
public interface SysConfigMapHolder<T extends EObject> {
	
	Map<String, T> sysConfigMap() throws Exception;

}
