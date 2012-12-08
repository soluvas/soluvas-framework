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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CommonsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CommonsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommonsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
