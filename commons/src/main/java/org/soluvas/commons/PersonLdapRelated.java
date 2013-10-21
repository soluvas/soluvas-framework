package org.soluvas.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Used by {@code Ldap Matrix}
 * 
 * @author agus
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonLdapRelated {

}
