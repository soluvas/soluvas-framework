package org.soluvas.email;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.soluvas.email.impl.EmailTemplate;

/**
 * Will be mapped to {@link EmailTemplate}.
 * {@link EmailTemplate#setHtml(String)} will be loaded from the same
 * class, with extension {@code .html.mustache}.
 * @author ceefour
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface EmailModel {
	/**
	 * Subject.
	 * @return
	 */
	String subject();
	String fromName() default "{{{appManifest.title}}}";
	String fromEmail() default "{{{appManifest.generalEmail}}}";
	String replyToName() default "";
	String replyToEmail() default "";
}
