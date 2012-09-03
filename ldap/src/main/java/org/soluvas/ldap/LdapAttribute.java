package org.soluvas.ldap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the field or getter/setter as a particular LDAP attribute.
 * 
 * A hashed <tt>userPassword</tt> attribute value will be mapped like this: <tt>{SSHA}msj4ASs1BvRnC7ZQpva1NsDesBofz2uhoSZlNw==</tt>
 * 
 * A plaintext <tt>userPassword</tt> will contain only the plaintext password.
 * 
 * @author ceefour
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LdapAttribute {

	/**
	 * Name(s) of the LDAP attribute.
	 * @return
	 */
	String[] value();
	
}
