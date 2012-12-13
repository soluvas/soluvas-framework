package org.soluvas.email;

/**
 * @author rully
 */
@SuppressWarnings("serial")
public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	public EmailException() {
	}

	/**
	 * @param message
	 */
	public EmailException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EmailException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}

}
