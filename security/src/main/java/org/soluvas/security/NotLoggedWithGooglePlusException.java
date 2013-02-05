/**
 * 
 */
package org.soluvas.security;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class NotLoggedWithGooglePlusException extends SecurityException {

	/**
	 * 
	 */
	public NotLoggedWithGooglePlusException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotLoggedWithGooglePlusException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotLoggedWithGooglePlusException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotLoggedWithGooglePlusException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param cause
	 * @param message
	 * @param args
	 */
	public NotLoggedWithGooglePlusException(Throwable cause, String message, Object... args) {
		super(cause, message, args);
	}
	
}
