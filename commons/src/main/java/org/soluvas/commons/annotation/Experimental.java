package org.soluvas.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * General qualifier for experimental stuff, for example
 * if you want to use two Perpetual implementations inside one webapp,
 * but marking the other one as {@link Experimental}.
 * @author ceefour
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Experimental {

}
