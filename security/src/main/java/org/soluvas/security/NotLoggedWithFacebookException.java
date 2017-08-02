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

	private String error;
	private Integer errorCode;
	private String errorReason;

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

	/**
	 * Sets error details from Facebook.
	 * @param error
	 * @param errorCode Must be integer because will be passed to Google Analytics event.
	 * @param errorReason
	 * @return
	 */
	public NotLoggedWithFacebookException error(String error, Integer errorCode, String errorReason) {
		this.error = error;
		this.errorCode = errorCode;
		this.errorReason = errorReason;
		return this;
	}

	public String getError() {
		return error;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorReason() {
		return errorReason;
	}
}
