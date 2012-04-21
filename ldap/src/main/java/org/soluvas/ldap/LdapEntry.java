package org.soluvas.ldap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used by Soluvas LDAP Object Mapper.
 * @author ceefour
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LdapEntry {

	/**
	 * LDAP <tt>objectClass</tt>es used by this POJO class when stored in LDAP repository.
	 * 
	 * The first <tt>objectClass</tt> must be a structural class, and the rest must be auxiliary classes.
	 * 
	 * @return
	 */
	String[] objectClasses();
	
}
