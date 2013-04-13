package org.soluvas.ldap;

/**
 * Thrown when mapping failed.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LdapMappingException extends RuntimeException {

	public LdapMappingException() {
		super();
	}

	public LdapMappingException(String message, Throwable cause) {
		super(message, cause);
	}

	public LdapMappingException(String message) {
		super(message);
	}

	public LdapMappingException(Throwable cause) {
		super(cause);
	}

	public LdapMappingException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
