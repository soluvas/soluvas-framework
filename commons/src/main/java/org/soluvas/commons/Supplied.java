package org.soluvas.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.base.Supplier;

/**
 * CDI Qualifier for not searching services, but {@link Supplier} with
 * the field type as {@code suppliedClass}, and the specified {@code layer}
 * (default is {@code application}).
 * @author ceefour
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Supplied {
	
	public static enum Layer { APPLICATION, MODULE };

	Layer value() default Layer.APPLICATION;
	
}
