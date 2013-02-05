/**
 * 
 */
package org.soluvas.security;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class NotLoggedWithTwitterException extends SecurityException {

	/**
	 * 
	 */
	public NotLoggedWithTwitterException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotLoggedWithTwitterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotLoggedWithTwitterException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotLoggedWithTwitterException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param cause
	 * @param message
	 * @param args
	 */
	public NotLoggedWithTwitterException(Throwable cause, String message, Object... args) {
		super(cause, message, args);
	}
	
}
