package org.soluvas.commons;

/**
 * @author rully
 *
 */
@SuppressWarnings("serial")
public class CommonsException extends RuntimeException {

	/**
	 * 
	 */
	public CommonsException() {
	}

	/**
	 * @param message
	 */
	public CommonsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CommonsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommonsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommonsException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
