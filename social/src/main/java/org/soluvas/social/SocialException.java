package org.soluvas.social;

/**
 * @author rully
 *
 */
@SuppressWarnings("serial")
public class SocialException extends RuntimeException {

	/**
	 * 
	 */
	public SocialException() {
	}

	/**
	 * @param message
	 */
	public SocialException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SocialException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SocialException(String message, Throwable cause) {
		super(message, cause);
	}

}
