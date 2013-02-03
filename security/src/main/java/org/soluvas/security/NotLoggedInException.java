package org.soluvas.security;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class NotLoggedInException extends SecurityException {

	/**
	 * 
	 */
	public NotLoggedInException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotLoggedInException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotLoggedInException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotLoggedInException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param cause
	 * @param message
	 * @param args
	 */
	public NotLoggedInException(Throwable cause, String message, Object... args) {
		super(cause, message, args);
	}

}
