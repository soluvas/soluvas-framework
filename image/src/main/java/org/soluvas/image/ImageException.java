/**
 * 
 */
package org.soluvas.image;

/**
 * @author ceefour
 *
 */
public class ImageException extends RuntimeException {

	/**
	 * 
	 */
	public ImageException() {
	}

	/**
	 * @param message
	 */
	public ImageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ImageException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImageException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ImageException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
