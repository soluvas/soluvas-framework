package org.soluvas.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CDI annotation for specifying the namespace filter.
 * Otherwise no namespace filter is applied.
 * @author ceefour
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Namespaced {
	
	String value();

}
