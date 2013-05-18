package org.soluvas.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Usually used to qualify a PersonRepository (EntityLookup for Person) bean,
 * so that it's usable directly by socmed Twitter shell commands.
 * @author ceefour
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TwitterRelated {

}
