package org.soluvas.ldap;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class LdapRepositoryException extends RuntimeException {

	/**
	 * 
	 */
	public LdapRepositoryException() {
	}

	/**
	 * @param message
	 */
	public LdapRepositoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LdapRepositoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LdapRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LdapRepositoryException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
