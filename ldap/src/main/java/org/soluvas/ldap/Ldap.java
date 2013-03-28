package org.soluvas.ldap;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author agus
 *
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Ldap {

}
