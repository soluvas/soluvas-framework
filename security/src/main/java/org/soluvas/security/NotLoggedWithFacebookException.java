/**
 * 
 */
package org.soluvas.security;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class NotLoggedWithFacebookException extends SecurityException {

	/**
	 * 
	 */
	public NotLoggedWithFacebookException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotLoggedWithFacebookException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotLoggedWithFacebookException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotLoggedWithFacebookException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param cause
	 * @param message
	 * @param args
	 */
	public NotLoggedWithFacebookException(Throwable cause, String message, Object... args) {
		super(cause, message, args);
	}
	
}
