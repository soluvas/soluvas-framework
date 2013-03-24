package org.soluvas.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutorService;

import javax.inject.Qualifier;

/**
 * Used to get CPU {@link ExecutorService}.
 * @author rudi
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpu {

}
