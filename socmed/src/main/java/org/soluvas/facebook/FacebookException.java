package org.soluvas.facebook;

/**
 * @author ceefour
 *
 */
public class FacebookException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FacebookException() {
	}

	/**
	 * @param message
	 */
	public FacebookException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FacebookException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FacebookException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FacebookException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
